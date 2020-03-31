/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.slice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class SafetySlice extends OperatorImpl {

  protected Input input;
  protected Output output;

  private static class Input {
    private final static String IN_MODELREL1 = "criterionMD";
    private final static String IN_MODELREL2 = "criterionD";
    private ModelRel critMDRel;
    private ModelRel critDRel;
    private Model model;

    public Input(Map<String, Model> inputsByName) {
      this.critMDRel = (ModelRel) inputsByName.get(Input.IN_MODELREL1);
      this.critDRel = (ModelRel) inputsByName.get(Input.IN_MODELREL2);
      if (this.critMDRel.getModelEndpoints().size() != 1 ||
          this.critDRel.getModelEndpoints().size() != 1) {
        // rels must be unary
        throw new IllegalArgumentException();
      }
      this.model = this.critMDRel.getModelEndpoints().get(0).getTarget();
      var model2Path = this.critDRel.getModelEndpoints().get(0).getTargetUri();
      if (!this.model.getUri().equals(model2Path)) {
        // rels point to different models
        throw new IllegalArgumentException();
      }
    }
  }

  private static class Output {
    private final static String OUT_MODELREL1 = "revise";
    private final static String OUT_MODELREL2 = "recheckContent";
    private final static String OUT_MODELREL3 = "recheckState";
    private ModelRel reviseRel;
    private ModelRel recheckContentRel;
    private ModelRel recheckStateRel;
    private MID reviseMID;
    private MID recheckContentMID;
    private MID recheckStateMID;

    public Output(Map<String, MID> outputMIDsByName) {
      this.reviseMID = outputMIDsByName.get(Output.OUT_MODELREL1);
      this.recheckContentMID = outputMIDsByName.get(Output.OUT_MODELREL2);
      this.recheckStateMID = outputMIDsByName.get(Output.OUT_MODELREL3);
    }

    public Map<String, Model> packed() {
      var outputsByName = new HashMap<String, Model>();
      outputsByName.put(Output.OUT_MODELREL1, this.reviseRel);
      outputsByName.put(Output.OUT_MODELREL2, this.recheckContentRel);
      outputsByName.put(Output.OUT_MODELREL3, this.recheckStateRel);
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

    @Override
    public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, Model> inputsByName,
                                                                        Map<String, Model> outputsByName) {
      var input = new Input(inputsByName);
      var reviseRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL1);
      var recheckContentRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL2);
      var recheckStateRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL3);
      var endpoint = List.of(input.model);
      return Map.of(reviseRel, endpoint,
                    recheckContentRel, endpoint,
                    recheckStateRel, endpoint);
    }
  }
}
