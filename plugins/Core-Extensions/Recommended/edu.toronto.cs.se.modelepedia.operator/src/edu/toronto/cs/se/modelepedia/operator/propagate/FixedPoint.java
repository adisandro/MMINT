/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.propagate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class FixedPoint extends NestingOperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELS = "models";
	private final static @NonNull String OUT_MODELS = "fixedModels";
	private final static @NonNull String GENERIC_OPERATORTYPE = "FIXER";
	// constants
	private final static @NonNull String FIXED_MODEL_SUFFIX = "_fixed";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedGeneric(@NonNull GenericEndpoint genericTypeEndpoint, @NonNull GenericElement genericType, @NonNull List<OperatorInput> inputs) {

			Operator fixerOperatorType = (Operator) genericType;
			if (fixerOperatorType.getInputs().size() != fixerOperatorType.getOutputs().size()) {
				return false;
			}
			if (fixerOperatorType.getInputs().size() != inputs.size()) {
				return false;
			}
			for (int i = 0; i < fixerOperatorType.getInputs().size(); i++) {
				String inputModelTypeUri = fixerOperatorType.getInputs().get(i).getTargetUri();
				String outputModelTypeUri = fixerOperatorType.getOutputs().get(i).getTargetUri();
				if (
					!inputModelTypeUri.equals(outputModelTypeUri) ||
					!MIDTypeHierarchy.isSubtypeOf(outputModelTypeUri, inputModelTypeUri)
				) {
					return false;
				}
			}

			return true;
		}
	}

	@Override
	public void createWorkflowInstanceOutputs(Operator newOperator, Map<String, Model> inputsByName, MID workflowMID) throws MMINTException {

		// create the vararg fixed models
		Map<String, Model> outputsByName = new HashMap<>();
		Operator fixerOperatorType = (Operator) newOperator.getGenerics().get(0);
		for (int i = 0; i < fixerOperatorType.getOutputs().size(); i++) {
			ModelEndpoint outputModelTypeEndpoint = fixerOperatorType.getOutputs().get(i);
			String outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
			Model outputModel = outputModelTypeEndpoint.getTarget().createWorkflowInstance(outputModelId, workflowMID);
			ModelEndpoint outputModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
				outputModel,
				newOperator,
				OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
			outputModelEndpoint.setName(outputModelEndpoint.getName() + i);
			outputsByName.put(outputModelTypeEndpoint.getName(), outputModel);
		}
		// use the fixer operator constraints in case of output model rels
		List<Model> inputModels = MIDOperatorIOUtils.getVarargs(inputsByName, this.getInputs().get(0).getName());
		inputsByName.clear();
		for (int i = 0; i < fixerOperatorType.getInputs().size(); i++) {
			inputsByName.put(fixerOperatorType.getInputs().get(i).getName(), inputModels.get(i));
		}
		Map<ModelRel, List<Model>> validOutputs = MIDConstraintChecker.getOperatorOutputConstraints(fixerOperatorType.getClosestTypeConstraint(), inputsByName, outputsByName);
		for (Entry<ModelRel, List<Model>> validOutput : validOutputs.entrySet()) {
			ModelRel outputModelRel = validOutput.getKey();
			for (Model endpointModel : validOutput.getValue()) {
				String modelTypeEndpointUri = MIDConstraintChecker.getAllowedModelEndpoints(outputModelRel, null, endpointModel).get(0);
				ModelEndpoint modelTypeEndpoint = MIDTypeRegistry.getType(modelTypeEndpointUri);
				modelTypeEndpoint.createWorkflowInstance(endpointModel, outputModelRel);
			}
		}
	}

	private @NonNull Model fix(@NonNull List<Model> model, @NonNull Operator fixerOperatorType, @NonNull MID instanceMID) {

		Model fixedModel = null;

		return fixedModel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		List<Model> models = MIDOperatorIOUtils.getVarargs(inputsByName, IN_MODELS);
		Operator fixerOperatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		//TODO MMINT[MODELS17] get the output MIDs as varargs
		MID instanceMID = outputMIDsByName.get(OUT_MODELS);

		// loop until the output is equal to the input
		Model fixedModel = this.fix(models, fixerOperatorType, instanceMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELS, fixedModel);

		return outputsByName;
	}

}
