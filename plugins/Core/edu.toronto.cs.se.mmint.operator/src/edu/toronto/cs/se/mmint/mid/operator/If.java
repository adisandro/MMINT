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
package edu.toronto.cs.se.mmint.mid.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class If extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELS = "models";
	private final static @NonNull String OUT_MODELS1 = "then";
	private final static @NonNull String OUT_MODELS2 = "else";
	private final static @NonNull String GENERIC_MODELTYPE = "CONDITION";

	@Override
	public Operator startWorkflowInstance(EList<OperatorInput> inputs, EList<OperatorGeneric> generics, MID workflowMID) throws MMINTException {

		Operator newOperator = super.startWorkflowInstance(inputs, generics, workflowMID);
		// create the vararg output models
		for (int i = 0; i < inputs.size(); i++) {
			//TODO MMINT[SCRIPTING] Handle model rels
			Model outputModelType = inputs.get(i).getModel().getMetatype();
			// output when cond == true
			String outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
			Model outputModel = outputModelType.createWorkflowInstance(outputModelId, workflowMID);
			ModelEndpoint outputModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
				outputModel,
				newOperator,
				OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
			outputModelEndpoint.setName(outputModelEndpoint.getName() + i);
			// output when cond == false
			outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
			outputModel = outputModelType.createWorkflowInstance(outputModelId, workflowMID);
			outputModelEndpoint = this.getOutputs().get(1).createWorkflowInstance(
				outputModel,
				newOperator,
				OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
			outputModelEndpoint.setName(outputModelEndpoint.getName() + i);
		}

		return newOperator;
	}

	private boolean evaluateCondition(@NonNull List<Model> inputModels, @NonNull Model conditionModelType) {

		for (Model inputModel : inputModels) {
			// check constraint only if types match (Model and Model, or ModelRel and ModelRel)
			if ((inputModel instanceof ModelRel) != (conditionModelType instanceof ModelRel)) {
				continue;
			}
			// check constraint
			if (MIDTypeHierarchy.instanceOf(inputModel, conditionModelType.getUri(), false) &&
				MIDConstraintChecker.checkModelConstraint(inputModel, conditionModelType.getConstraint())) {
				return true; // any match semantics
			}
		}

		return false;
	}

	private @NonNull List<Model> createOutputModels(List<Model> inputModels, Map<String, MID> outputMIDsByInput, String outputSuffix) throws Exception {

		List<Model> outputModels = new ArrayList<>();
		for (Model inputModel : inputModels) {
			MID outputMID = outputMIDsByInput.get(inputModel.getName());
			Model outputModel = inputModel.getMetatype().copyInstanceAndEditor(
				inputModel,
				inputModel.getName() + "_" + outputSuffix,
				true,
				outputMID);
			outputModels.add(outputModel);
		}

		return outputModels;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		List<Model> inputModels = MIDOperatorIOUtils.getVarargs(inputsByName, IN_MODELS);
		Model conditionModelType = (Model) genericsByName.get(GENERIC_MODELTYPE);
		Map<String, MID> thenMIDsByInput = MIDOperatorIOUtils.getVarargOutputMIDsByOtherName(outputMIDsByName, OUT_MODELS1, inputModels);
		Map<String, MID> elseMIDsByInput = MIDOperatorIOUtils.getVarargOutputMIDsByOtherName(outputMIDsByName, OUT_MODELS2, inputModels);

		// evaluate condition
		boolean condition = this.evaluateCondition(inputModels, conditionModelType);

		// output
		List<Model> outputModels = this.createOutputModels(
			inputModels,
			condition ? thenMIDsByInput : elseMIDsByInput,
			condition ? OUT_MODELS1 : OUT_MODELS2);
		Map<String, Model> outputsByName = MIDOperatorIOUtils.setVarargs(outputModels, (condition ? OUT_MODELS1 : OUT_MODELS2));

		return outputsByName;
	}

}
