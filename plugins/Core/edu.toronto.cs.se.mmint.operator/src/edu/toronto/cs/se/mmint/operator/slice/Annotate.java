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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class Annotate extends OperatorImpl {

  protected Input input;
  protected Output output;

  protected static class Input {
    private final static String IN_MODELREL1 = "revise";
    private final static String IN_MODELREL2 = "recheckContent";
    private final static String IN_MODELREL3 = "recheckState";
    public ModelRel reviseRel;
    public ModelRel recheckContentRel;
    public ModelRel recheckStateRel;
    public Model model;

    public Input(Map<String, Model> inputsByName) {
      this.reviseRel = (ModelRel) inputsByName.get(Input.IN_MODELREL1);
      this.recheckContentRel = (ModelRel) inputsByName.get(Input.IN_MODELREL2);
      this.recheckStateRel = (ModelRel) inputsByName.get(Input.IN_MODELREL3);
      if (this.reviseRel.getModelEndpoints().size() != 1 ||
          this.recheckContentRel.getModelEndpoints().size() != 1 ||
          this.recheckStateRel.getModelEndpoints().size() != 1) {
        // rels must be unary
        throw new IllegalArgumentException();
      }
      this.model = this.reviseRel.getModelEndpoints().get(0).getTarget();
      var model2Path = this.recheckContentRel.getModelEndpoints().get(0).getTargetUri();
      var model3Path = this.recheckStateRel.getModelEndpoints().get(0).getTargetUri();
      if (!this.model.getUri().equals(model2Path) || !this.model.getUri().equals(model3Path)) {
        // rels point to different models
        throw new IllegalArgumentException();
      }
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

  protected void annotateModelElem(ModelElement modelElem, @Nullable String cause, BufferedWriter buffer)
                                   throws IOException {
    buffer.write(modelElem.getName());
    if (cause != null) {
      buffer.write(" <-- " + cause);
    }
    buffer.newLine();
  }

  protected void annotateRel(ModelRel rel, String header, BufferedWriter buffer, Set<String> alreadyAnnotated)
                             throws IOException {
    buffer.write(header);
    buffer.newLine();
    buffer.newLine();
    for (var modelElemRef : rel.getModelEndpointRefs().get(0).getModelElemRefs()) {
      var modelElem = modelElemRef.getObject();
      if (alreadyAnnotated.contains(modelElem.getUri())) {
        continue;
      }
      var cause = modelElemRef.getModelElemEndpointRefs().stream()
        .map(meer -> ((MappingReference) meer.eContainer()).getObject().getName())
        .collect(Collectors.joining(", "));
      annotateModelElem(modelElem, cause, buffer);
      alreadyAnnotated.add(modelElem.getUri());
    }
  }

  protected void annotate() throws Exception {
    var filePath = FileUtils.replaceLastSegmentInPath(this.input.model.getUri(),
                                                      this.input.model.getName() + "_" + Output.OUT_MODEL + ".txt");
    var systemFilePath = FileUtils.prependWorkspacePath(filePath);
    try (var buffer = Files.newBufferedWriter(Paths.get(systemFilePath), Charset.forName("UTF-8"))) {
      // annotate by priority: revise > recheck content > recheck state
      var alreadyAnnotated = new HashSet<String>();
      annotateRel(this.input.reviseRel, "REVISE:", buffer, alreadyAnnotated);
      buffer.newLine();
      annotateRel(this.input.recheckContentRel, "RECHECK CONTENT:", buffer, alreadyAnnotated);
      buffer.newLine();
      annotateRel(this.input.recheckStateRel, "RECHECK STATE:", buffer, alreadyAnnotated);
    }
    var fileModelType = MIDTypeRegistry.<Model>getType("http://se.cs.toronto.edu/modelepedia/File");
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
