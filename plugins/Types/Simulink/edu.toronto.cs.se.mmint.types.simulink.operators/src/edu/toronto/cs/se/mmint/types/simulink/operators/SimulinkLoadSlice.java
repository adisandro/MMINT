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

import java.nio.file.Paths;
import java.util.Map;

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

public class SimulinkLoadSlice extends OperatorImpl {
  private Input input;
  private Output output;

  private static class Input {
    private final static String IN_MODEL = "simulink";
    private final static String SLICE_FILE_EXT = "slice";
    public Model simulinkModel;
    public String sliceFileName;

    public Input(Map<String, Model> inputsByName) {
      this.simulinkModel = inputsByName.get(Input.IN_MODEL);
      this.sliceFileName = FileUtils.replaceFileExtensionInPath(this.simulinkModel.getUri(), Input.SLICE_FILE_EXT);
      if (!FileUtils.isFile(this.sliceFileName, true)) {
        // a .slice file from Matlab's reach/coreach is required
        throw new IllegalArgumentException();
      }
    }
  }

  private static class Output {
    public final static String OUT_MODELREL = "slice";
    public static final String MODELREL_TYPE_ID = "rel://edu.toronto.cs.se.mmint.types.simulink.SimulinkSliceRel";
    public ModelRel sliceRel;

    public Output(Input input, Map<String, MID> outputMIDsByName) throws MMINTException {
      var mid = outputMIDsByName.get(Output.OUT_MODELREL);
      var relType = MIDTypeRegistry.<ModelRel>getType(Output.MODELREL_TYPE_ID);
      relType.createInstanceAndEndpoints(null, Output.OUT_MODELREL, ECollections.newBasicEList(input.simulinkModel),
                                         mid);
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

  private void load() {
    var slicePath = Paths.get(FileUtils.prependWorkspacePath(this.input.sliceFileName));
  }

  //TODO constraint checks if there is a file with the appropriate name, then searches the model for the corresponding refs and creates a slice rel out of it
  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    load();

    return this.output.packed();
  }
}
