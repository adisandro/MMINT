/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.types.simulink.operators;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.slice.Slice.SliceType;
import hu.bme.mit.massif.simulink.SimulinkElement;

public class SimulinkLoadSlice extends OperatorImpl {
  private Input input;
  private Output output;

  private static class Input {
    private final static String IN_MODEL = "simulink";
    private final static String REACHED_FILE_EXT = "reached";
    private final static String CHANGED_FILE_EXT = "changed";
    public Model simulinkModel;
    public String sliceFileName;

    public Input(Map<String, Model> inputsByName) {
      this.simulinkModel = inputsByName.get(Input.IN_MODEL);
      this.sliceFileName = FileUtils.replaceFileExtensionInPath(this.simulinkModel.getUri(), Input.REACHED_FILE_EXT);
      if (!FileUtils.isFile(this.sliceFileName, true)) {
        this.sliceFileName = FileUtils.replaceFileExtensionInPath(this.simulinkModel.getUri(), Input.CHANGED_FILE_EXT);
        if (!FileUtils.isFile(this.sliceFileName, true)) {
          // a file from Matlab's reach/coreach or model-comparison is required
          throw new IllegalArgumentException();
        }
      }
    }
  }

  private static class Output {
    public final static String OUT_MODELREL = "loaded";
    public static final String MODELREL_TYPE_ID = "rel://edu.toronto.cs.se.mmint.types.simulink.SimulinkSliceRel";
    public ModelRel sliceRel;

    public Output(Input input, Map<String, MID> outputMIDsByName) throws MMINTException {
      var mid = outputMIDsByName.get(Output.OUT_MODELREL);
      var relType = MIDTypeRegistry.<ModelRel>getType(Output.MODELREL_TYPE_ID);
      this.sliceRel = relType.createInstanceAndEndpoints(null, Output.OUT_MODELREL,
                                                         ECollections.newBasicEList(input.simulinkModel), mid);
    }

    public Map<String, Model> packed() {
      return Map.of(Output.OUT_MODELREL, this.sliceRel);
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new Input(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.input = new Input(inputsByName);
    this.output = new Output(this.input, outputMIDsByName);
  }

  private void load() throws Exception {
    var sliceEndpointRef = this.output.sliceRel.getModelEndpointRefs().get(0);
    var addSliceType = new SliceType(SliceType.ADD, 10);
    var delSliceType = new SliceType(SliceType.DEL, 20);
    var modSliceType = new SliceType(SliceType.MOD, 30);
    var slicePath = Paths.get(FileUtils.prependWorkspacePath(this.input.sliceFileName));
    Map<String, SliceType> simulinkIds;
    if (this.input.sliceFileName.endsWith(Input.REACHED_FILE_EXT)) {
      simulinkIds = Files.lines(slicePath).map(String::strip).collect(Collectors.toMap(l -> l, l -> modSliceType));
    }
    else {
      simulinkIds = new HashMap<>();
      var header = "Comparison Root/Simulink/";
      var lines = Files.readAllLines(slicePath);
      var line = lines.get(0).strip();
      var numLines = Integer.parseInt(line.substring(line.lastIndexOf(" ")+1));
      var start = 1;
      var end = 1 + numLines;
      for (var i = start; i < end; i++) {
        var simulinkId = lines.get(i).strip().substring(header.length());
        simulinkIds.put(simulinkId, addSliceType);
      }
      line = lines.get(end).strip();
      numLines = Integer.parseInt(line.substring(line.lastIndexOf(" ")+1));
      start = end + 1;
      end += 1 + numLines;
      for (var i = start; i < end; i++) {
        var simulinkId = lines.get(i).strip().substring(header.length());
        simulinkIds.put(simulinkId, delSliceType);
      }
      line = lines.get(end).strip();
      numLines = Integer.parseInt(line.substring(line.lastIndexOf(" ")+1));
      start = end + 1;
      end += 1 + numLines;
      line = lines.get(end).strip();
      numLines = Integer.parseInt(line.substring(line.lastIndexOf(" ")+1));
      start = end + 1;
      end += 1 + numLines;
      for (var i = start; i < end; i++) {
        var simulinkId = lines.get(i).strip().substring(header.length());
        simulinkIds.put(simulinkId, modSliceType);
      }
    }
    for (var simulinkIter = this.input.simulinkModel.getEMFInstanceRoot().eAllContents(); simulinkIter.hasNext();) {
      var simulinkModelObj = simulinkIter.next();
      if (!(simulinkModelObj instanceof SimulinkElement simulinkElem)) {
        continue;
      }
      var simulinkId = simulinkElem.getSimulinkRef().getQualifier() + "/" + simulinkElem.getSimulinkRef().getName();
      var sliceType = simulinkIds.get(simulinkId);
      if (sliceType != null) {
        var sliceModelElemRef = sliceEndpointRef.createModelElementInstanceAndReference(simulinkModelObj, null);
        sliceType.mappingType
          .createInstanceAndReferenceAndEndpointsAndReferences(false, ECollections.asEList(sliceModelElemRef));
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    load();

    return this.output.packed();
  }
}
