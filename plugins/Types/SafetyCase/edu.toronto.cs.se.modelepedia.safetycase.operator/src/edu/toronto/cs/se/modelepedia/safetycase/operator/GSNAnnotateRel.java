/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class GSNAnnotateRel extends GSNAnnotate {

  private static class Input {
    private final static @NonNull String IN_REVISE = "revise";
    private final static @NonNull String IN_RECHECK_CONTENT = "recheck_content";
    private final static @NonNull String IN_RECHECK_STATE = "recheck_state";
    private ModelRel reviseRel;
    private ModelRel recheckContentRel;
    private ModelRel recheckStateRel;
    private Model scModel;

    public Input(Map<String, Model> inputsByName) {
      this.reviseRel = (ModelRel) inputsByName.get(Input.IN_REVISE);
      this.recheckContentRel = (ModelRel) inputsByName.get(Input.IN_RECHECK_CONTENT);
      this.recheckStateRel = (ModelRel) inputsByName.get(Input.IN_RECHECK_STATE);
      this.scModel = this.reviseRel.getModelEndpoints().get(0).getTarget();
      Model sameSCModelContent = this.recheckContentRel.getModelEndpoints().get(0).getTarget();
      Model sameSCModelState = this.recheckStateRel.getModelEndpoints().get(0).getTarget();
      if (!this.scModel.getUri().equals(sameSCModelContent.getUri()) ||
          !this.scModel.getUri().equals(sameSCModelState.getUri())) {
        throw new IllegalArgumentException();
      }
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
}
