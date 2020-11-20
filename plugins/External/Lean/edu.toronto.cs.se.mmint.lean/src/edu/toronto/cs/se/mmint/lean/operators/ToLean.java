/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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
import java.util.Map;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.AcceleoUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class ToLean extends OperatorImpl {

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
    public final static String MODEL = "encoding";
    public String leanPath;
    public File leanFolder;
    public Model leanModel;
    public MID mid;

    public Output(Input input, Map<String, MID> outputMIDsByName) {
      this.leanPath = FileUtils.replaceLastSegmentInPath(input.model.getUri(), input.model.getName() + ".lean");
      this.leanFolder = (new File(FileUtils.prependWorkspacePath(input.model.getUri()))).getParentFile();
      this.mid = outputMIDsByName.get(Output.MODEL);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      if (!FileUtils.isFile(this.leanPath, true)) {
        throw new MMINTException("Acceleo generation failed");
      }
      var fileModelType = MIDTypeRegistry.<Model>getType(Output.MODEL_TYPE_ID);
      this.leanModel = fileModelType.createInstance(null, this.leanPath, this.mid);

      return Map.of(Output.MODEL, this.leanModel);
    }
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws IOException {
    this.input = new Input(inputsByName);
    this.output = new Output(this.input, outputMIDsByName);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    //TODO MMINT[LEAN] Add an acceleo interface to extend too (i.e. EObject root + String modelName)
    AcceleoUtils.runAcceleo(this.leanGenerator);

    return this.output.packed();
  }

}
