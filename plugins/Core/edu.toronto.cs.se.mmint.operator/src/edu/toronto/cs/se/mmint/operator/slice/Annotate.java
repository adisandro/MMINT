/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.slice;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Annotate extends OperatorImpl {

  private Input input;
  private Output output;

  private static class Input {
    private final static @NonNull String IN_MODELREL1 = "revise";
    private final static @NonNull String IN_MODELREL2 = "recheckState";
    private final static @NonNull String IN_MODELREL3 = "recheckContent";
    private ModelRel reviseRel;
    private ModelRel recheckStateRel;
    private ModelRel recheckContentRel;
    private Model model;

    public Input(Map<String, Model> inputsByName) {
      this.reviseRel = (ModelRel) inputsByName.get(Input.IN_MODELREL1);
      this.recheckStateRel = (ModelRel) inputsByName.get(Input.IN_MODELREL2);
      this.recheckContentRel = (ModelRel) inputsByName.get(Input.IN_MODELREL3);
      if (this.reviseRel.getModelEndpoints().size() != 1 ||
          this.recheckStateRel.getModelEndpoints().size() != 1 ||
          this.recheckContentRel.getModelEndpoints().size() != 1) {
        // rels must be unary
        throw new IllegalArgumentException();
      }
      this.model = this.reviseRel.getModelEndpoints().get(0).getTarget();
      var model2Path = this.recheckStateRel.getModelEndpoints().get(0).getTargetUri();
      var model3Path = this.recheckContentRel.getModelEndpoints().get(0).getTargetUri();
      if (!this.model.getUri().equals(model2Path) || !this.model.getUri().equals(model3Path)) {
        // rels point to different models
        throw new IllegalArgumentException();
      }
    }
  }

  private static class Output {
    private final static @NonNull String OUT_MODEL = "annotated";
    private Model annotatedModel;
    private MID mid;

    public Output(@NonNull Map<String, MID> outputMIDsByName) {
      this.mid = outputMIDsByName.get(Output.OUT_MODEL);
    }

    public @NonNull Map<String, Model> packed() {
      var outputsByName = new HashMap<String, Model>();
      outputsByName.put(Output.OUT_MODEL, this.annotatedModel);
      return outputsByName;
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean isAllowedInput(@NonNull Map<String, Model> inputsByName) {
      try {
        new Input(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  private void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, MID> outputMIDsByName) {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
  }

  protected void annotate() throws MMINTException {

  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    annotate();
    return this.output.packed();
  }

}
