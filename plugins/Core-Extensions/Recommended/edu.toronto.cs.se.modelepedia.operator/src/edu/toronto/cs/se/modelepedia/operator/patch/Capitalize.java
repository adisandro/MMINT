/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.patch;

import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class Capitalize extends OperatorImpl {

  private Input input;
  private Output output;

  private static class Input {
    private final static @NonNull String IN_MODEL = "lower";
    private Model lower;
    public Input(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, GenericElement> genericsByName) {
      this.lower = inputsByName.get(IN_MODEL);
    }
  }

  private static class Output {
    private final static @NonNull String OUT_MODEL = "upper";
    private final static @NonNull String UPPER_NAME = "upper";
    private MID upperContainer;
    private Model upper;
    public Output(@NonNull Map<String, MID> outputMIDsByName) {
      this.upperContainer = outputMIDsByName.get(OUT_MODEL);
    }

    public @NonNull Map<String, Model> packed() {
      return Map.of(OUT_MODEL, this.upper);
    }
  }

  private void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, GenericElement> genericsByName,
                    @NonNull Map<String, MID> outputMIDsByName) {
    this.input = new Input(inputsByName, genericsByName);
    this.output = new Output(outputMIDsByName);
  }

  private void capitalize() throws Exception {
    var upperRootObj = this.input.lower.getEMFInstanceRoot();
    var iter = upperRootObj.eAllContents();
    while (iter.hasNext()) {
      var upperObj = iter.next();
      try {
        var name = FileUtils.getModelObjectFeature(upperObj, "name");
        if (name instanceof String) {
          FileUtils.setModelObjectFeature(upperObj, "name", ((String) name).toUpperCase());
        }
      }
      catch (MMINTException e) {
        // just skip
      }
    }
    var upperPath = Path.of(getWorkingPath(),
                            MessageFormat.format("{0}.{1}", this.input.lower.getName().toUpperCase(),
                                                 this.input.lower.getFileExtension()));
    this.output.upper = this.input.lower.getMetatype()
      .createInstanceAndEditor(upperRootObj, upperPath.toString(), this.output.upperContainer);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, genericsByName, outputMIDsByName);
    capitalize();

    return this.output.packed();
  }

}
