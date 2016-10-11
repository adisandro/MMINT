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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Loop extends ConditionalOperator {

	// input-output
	private final static @NonNull String IN_MODELS = "models";
	private final static @NonNull String OUT_MODELS = "loopedModels";
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

	private @NonNull List<Model> loop(@NonNull List<Model> inputModels, @NonNull Model conditionModelType, @NonNull WorkflowOperator doOperatorType, @NonNull Map<String, MID> outputMIDsByInput) throws MMINTException, Exception {

		List<Model> outputModels = null;
		MID loopMID = MIDFactory.eINSTANCE.createMID();
		List<Model> loopModels = new ArrayList<>(inputModels);
		while (super.evaluateCondition(loopModels, conditionModelType)) {
			EList<OperatorInput> doInputs = new BasicEList<>();
			for (int i = 0; i < doOperatorType.getInputs().size(); i++) {
				ModelEndpoint inputModelEndpoint = doOperatorType.getInputs().get(i);
				Model inputModel = inputModels.get(i);
				OperatorInput doInput = OperatorFactory.eINSTANCE.createOperatorInput();
				doInput.setModel(inputModel);
				doInput.setModelTypeEndpoint(inputModelEndpoint.getMetatype());
				doInputs.add(doInput);
			}
			EList<OperatorGeneric> doGenerics = doOperatorType.selectAllowedGenerics(doInputs);
			Map<String, MID> doOutputMIDsByName = MIDOperatorIOUtils.createSimpleOutputMIDsByName(doOperatorType, loopMID);
			Map<String, Model> doOutputsByName = doOperatorType.startInstance(
				doInputs,
				null,
				doGenerics,
				doOutputMIDsByName,
				loopMID)
					.getOutputsByName();
			loopModels = new ArrayList<>(doOutputsByName.values());
			/*TODO:
			 * 1) Check that DO workflow operator is compatible with the inputModels (here or at creation time?)
			 * 2) Reassign inputModels at every step by running and getting the output of doWorkflowOperator
			 * 3) Create a traceability MID to unroll every time the cycle has been executed
			 * 4) Do the outputs need to be the same as inputs?
			 */
		}

		return outputModels;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		//TODO MMINT[SCRIPTING] Make this an abstract operator and provide concrete variants like While, Until, For?
		// input
		List<Model> inputModels = MIDOperatorIOUtils.getVarargs(inputsByName, IN_MODELS);
		Model conditionModelType = (Model) genericsByName.get(GENERIC_MODELTYPE);
		WorkflowOperator doOperatorType = (WorkflowOperator) genericsByName.get(GENERIC_WORKFLOWOPERATORTYPE);
		Map<String, MID> outputMIDsByInput = MIDOperatorIOUtils.getVarargOutputMIDsByOtherName(outputMIDsByName, OUT_MODELS, inputModels);

		List<Model> outputModels = this.loop(inputModels, conditionModelType, doOperatorType, outputMIDsByInput);
		Map<String, Model> outputsByName = MIDOperatorIOUtils.setVarargs(outputModels, OUT_MODELS);

		return outputsByName;
	}

}
