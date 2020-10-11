/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.slice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class AnnotateSlice extends OperatorImpl {

  public static final String MODEL_TYPE_ID = "http://se.cs.toronto.edu/modelepedia/File";
  protected Input input;
  protected Output output;

  protected static class Input {
    private final static String IN_MODELREL = "slice";
    public ModelRel sliceRel;
    public Model model;

    public Input(Map<String, Model> inputsByName) {
      this.sliceRel = (ModelRel) inputsByName.get(Input.IN_MODELREL);
      if (this.sliceRel.getModelEndpoints().size() != 1) {
        // rel must be unary
        throw new IllegalArgumentException();
      }
      this.model = this.sliceRel.getModelEndpoints().get(0).getTarget();
    }
  }

  protected static class Output {
    public final static String OUT_MODEL = "annotated";
    public Model annotatedModel;
    public MID mid;

    public Output(Map<String, MID> outputMIDsByName) {
      this.mid = outputMIDsByName.get(Output.OUT_MODEL);
    }

    public Map<String, Model> packed() {
      var outputsByName = new HashMap<String, Model>();
      outputsByName.put(Output.OUT_MODEL, this.annotatedModel);
      return outputsByName;
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean isAllowedInput(Map<String, Model> inputsByName) {
      try {
        new Input(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
  }

  private void annotateModelElem(ModelElement modelElem, @Nullable String cause, BufferedWriter buffer)
                                   throws IOException {
    buffer.write(modelElem.getName());
    if (cause != null) {
      buffer.write(" <-- " + cause);
    }
    buffer.newLine();
  }

  private void annotateSliceType(List<MappingReference> mappingRefs, String header, BufferedWriter buffer)
                                throws IOException {
    buffer.write(header);
    buffer.newLine();
    buffer.newLine();
    for (var mappingRef : mappingRefs) {
      var sliceTypeId = mappingRef.getObject().getMetatypeUri();
      for (var modelElemEndpointRef : mappingRef.getModelElemEndpointRefs()) {
        var modelElemRef = modelElemEndpointRef.getModelElemRef();
        // extract all mappings attached as causes
        var cause = modelElemRef.getModelElemEndpointRefs().stream()
          .map(meer -> ((MappingReference) meer.eContainer()).getObject())
          .filter(m -> m.getMetatypeUri().equals(sliceTypeId)) // use only causes from same slice type
          .map(Mapping::getName)
          .collect(Collectors.joining(", "));
        annotateModelElem(modelElemRef.getObject(), cause, buffer);
      }
    }
  }

  protected void annotate() throws Exception {
    var filePath = FileUtils.replaceLastSegmentInPath(this.input.model.getUri(),
                                                      this.input.model.getName() + "_" + Output.OUT_MODEL + ".txt");
    var systemFilePath = FileUtils.prependWorkspacePath(filePath);
    try (var buffer = Files.newBufferedWriter(Paths.get(systemFilePath), Charset.forName("UTF-8"))) {
      // group mappings by slice types
      var mappingTypes = this.input.sliceRel.getMappingRefs().stream()
        .collect(Collectors.groupingBy(mr -> mr.getObject().getMetatype().getName()));
      for (var mappingEntry : mappingTypes.entrySet()) {
        annotateSliceType(mappingEntry.getValue(), mappingEntry.getKey(), buffer);
        buffer.newLine();
      }
    }
    var fileModelType = MIDTypeRegistry.<Model>getType(AnnotateSlice.MODEL_TYPE_ID);
    this.output.annotatedModel = fileModelType.createInstance(null, filePath, this.output.mid);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    annotate();
    return this.output.packed();
  }

}
