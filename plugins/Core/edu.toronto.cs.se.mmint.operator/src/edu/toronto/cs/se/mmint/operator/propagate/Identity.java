/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.propagate;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Identity extends OperatorImpl {

  // input-output
  private final static @NonNull String IN_MODEL = "model";
  private final static @NonNull String OUT_MODEL = "sameModel";

  @Override
  public void createWorkflowInstanceOutputs(Operator newOperator, Map<String, GenericElement> genericsByName, Map<String, Model> inputsByName, MID workflowMID)
                                            throws MMINTException {
    MMINTException.mustBeType(this);

    // use the input model type to create the same output type
    var inputModel = inputsByName.get(Identity.IN_MODEL);
    var outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
    var outputModel = inputModel.getMetatype().createWorkflowInstance(outputModelId, workflowMID);
    getOutputs().get(0).createWorkflowInstance(outputModel, newOperator,
                                               OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
    if (inputModel instanceof ModelRel) {
      for (var modelEndpoint : ((ModelRel) inputModel).getModelEndpoints()) {
        modelEndpoint.getMetatype().createWorkflowInstance(modelEndpoint.getTarget(), (ModelRel) outputModel);
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    return Map.of(Identity.OUT_MODEL, inputsByName.get(Identity.IN_MODEL));
  }
}
