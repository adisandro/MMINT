/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.lean.operators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.core.runtime.IPath;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.AcceleoUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ToLean extends OperatorImpl {

  protected final static String LEAN_EXT = ".lean";
  protected final static String LEAN_SANITIZE_REGEXP = "[\\s\\.\\-=<>?!]";
  protected final static String LEAN_BUNDLE_DIR = "lean/";
  protected Input input;
  protected Output output;
  protected AbstractAcceleoGenerator leanGenerator;

  protected static class Input {
    public final static String MODEL = "model";
    public Model model;

    public Input(Map<String, Model> inputsByName) {
      this.model = inputsByName.get(Input.MODEL);
    }
  }

  protected static class Output {
    public static final String MODEL_TYPE_ID = "http://se.cs.toronto.edu/mmint/File";
    public final static String MODELS = "encoding";
    public final static String EVIDENCE_FILE = "evidence" + ToLean.LEAN_EXT;
    public final static String MAIN_FILE = "main" + ToLean.LEAN_EXT;
    public File leanFolder;
    public List<String> leanPaths;
    public List<Model> leanModels;
    public MID mid;

    public Output(Input input, Map<String, MID> outputMIDsByName, String workingPath) {
      this.leanFolder = new File(FileUtils.prependWorkspacePath(workingPath));
      this.leanPaths = new ArrayList<>();
      this.leanPaths.add(workingPath + IPath.SEPARATOR + Output.MAIN_FILE);
      this.leanPaths.add(workingPath + IPath.SEPARATOR + input.model.getName() + ToLean.LEAN_EXT);
      this.leanModels = new ArrayList<>();
      this.mid = outputMIDsByName.get(Output.MODELS);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      if (this.leanPaths.stream().anyMatch(path -> !FileUtils.isFile(path, true))) {
        throw new MMINTException("Lean code generation failed");
      }
      var fileModelType = MIDTypeRegistry.<Model>getType(Output.MODEL_TYPE_ID);
      for (var i = 0; i < this.leanPaths.size(); i++) {
        this.leanModels.add(fileModelType.createInstance(null, this.leanPaths.get(i), this.mid));
      }

      return MIDOperatorIOUtils.setVarargs(this.leanModels, Output.MODELS);
    }
  }

  @Override
  public void createWorkflowInstanceOutputs(Operator newOperator, Map<String, GenericElement> genericsByName,
                                            Map<String, Model> inputsByName, MID workflowMID) throws MMINTException {
    var fileModelType = MIDTypeRegistry.<Model>getType(Output.MODEL_TYPE_ID);
    // dynamic lean files as varargs
    for (var i = 0; i < 2; i++) {
      var outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
      var outputModel = fileModelType.createWorkflowInstance(outputModelId, workflowMID);
      var outputModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
        outputModel, newOperator, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
      var fileName = (i == 0) ? Output.MAIN_FILE : inputsByName.get(Input.MODEL).getName();
      var outputName = outputModelEndpoint.getName() + fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
      outputModelEndpoint.setName(outputName);
    }
  }

  public List<String> getImportPaths() {
    return List.of();
  }

  public Optional<String> getOutputFileName() {
    return Optional.of(Output.EVIDENCE_FILE);
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    var workingPath = getWorkingPath();
    this.input = new Input(inputsByName);
    this.output = new Output(this.input, outputMIDsByName, workingPath);
    // static lean files
    var bundlePath = MIDTypeRegistry.getBundlePath(this.getMetatype(), ToLean.LEAN_BUNDLE_DIR);
    FileUtils.copyDirectory(bundlePath, false, workingPath + IPath.SEPARATOR, true);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    if (this.leanGenerator != null) {
      AcceleoUtils.runAcceleo(this.leanGenerator);
    }

    return this.output.packed();
  }

}
