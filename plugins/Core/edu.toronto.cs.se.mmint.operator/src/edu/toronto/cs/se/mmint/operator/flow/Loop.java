/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Loop extends ConditionalOperator {

	// input-output
	private final static @NonNull String GENERIC_WORKFLOWOPERATORTYPE = "DO";

	@Override
	public Operator startWorkflowInstance(EList<OperatorInput> inputs, EList<OperatorGeneric> generics, MID workflowMID) throws MMINTException {

		Operator newOperator = super.startWorkflowInstance(inputs, generics, workflowMID);
		// create the vararg output models
		for (int i = 0; i < inputs.size(); i++) {
			//TODO MMINT[SCRIPTING] Handle model rels
			Model outputModelType = inputs.get(i).getModel().getMetatype();
			String outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
			Model outputModel = outputModelType.createWorkflowInstance(outputModelId, workflowMID);
			ModelEndpoint outputModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
				outputModel,
				newOperator,
				OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
			outputModelEndpoint.setName(outputModelEndpoint.getName() + i);
		}

		return newOperator;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model conditionModel = inputsByName.get(IN_MODEL);
		List<Model> inputModels = MIDOperatorIOUtils.getVarargs(inputsByName, IN_MODELS);
		BooleanExpression condition = (BooleanExpression) genericsByName.get(GENERIC_OPERATORTYPE);
		WorkflowOperator doBlock = (WorkflowOperator) genericsByName.get(GENERIC_WORKFLOWOPERATORTYPE);
		Map<String, MID> outputMIDsByInput = MIDOperatorIOUtils.getVarargOutputMIDsByOtherName(outputMIDsByName, OUT_MODELS, inputModels);

		// loop and run block
		List<Model> outputModels = new ArrayList<>(inputModels);
		while (super.evaluateCondition(conditionModel, condition)) {
			outputModels = super.runBlock(outputModels, doBlock);
			//TODO MMINT[SCRIPTING] Figure out a way to keep track of every time the cycle has been executed (create a new mid each time?)
		}

		// output
		Map<String, Model> outputsByName = MIDOperatorIOUtils.setVarargs(outputModels, OUT_MODELS);

		return outputsByName;
	}

}
