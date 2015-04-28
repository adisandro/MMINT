/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class Map extends OperatorImpl {

	//TODO MMINT[OPERATOR] Make this into mid.model and apis?
	private class OperatorInput {
		private Model model;
		private List<ConversionOperator> conversions;
		public OperatorInput(@NonNull Model model, @NonNull List<ConversionOperator> conversions) {
			this.model = model;
			this.conversions = conversions;
		}
		public @NonNull Model getModel() {
			return model;
		}
		public @NonNull List<ConversionOperator> getConversions() {
			return conversions;
		}
	}

	@NonNull private final static String MAP_MID_SUFFIX = "_map";

	private List<Set<OperatorInput>> getModelTypeEndpointInputs(Operator operatorType, MultiModel mapMID) {

		//TODO MMINT[MAP] Add support for upper bound = -1
		//TODO MMINT[MAP] Need something more in the operators themselves to validate proper input in case of model rels
		List<Set<OperatorInput>> modelTypeEndpointInputs = new ArrayList<>();
		for (ModelEndpoint inputModelTypeEndpoint : operatorType.getInputs()) {
			Set<OperatorInput> modelTypeEndpointInputSet = new HashSet<>();
			modelTypeEndpointInputs.add(modelTypeEndpointInputSet);
			for (Model inputModel : mapMID.getModels()) {
				List<ConversionOperator> conversions = MultiModelTypeHierarchy.instanceOf(
					inputModel,
					inputModelTypeEndpoint.getTargetUri()
				);
				if (conversions == null) {
					continue;
				}
				modelTypeEndpointInputSet.add(new OperatorInput(inputModel, conversions));
			}
		}

		return modelTypeEndpointInputs;
	}

	private void getOperatorTypeInputs(List<Set<OperatorInput>> modelTypeEndpointInputs, Set<List<OperatorInput>> operatorTypeInputs, List<OperatorInput> inputModelsAccumulator, int currentIndex) {

		if (modelTypeEndpointInputs.size() == currentIndex) {
			operatorTypeInputs.add(inputModelsAccumulator);
		}
		else {
			for (OperatorInput inputModel : modelTypeEndpointInputs.get(currentIndex)) {
				List<OperatorInput> newInputModelsAccumulator = new ArrayList<>(inputModelsAccumulator);
				newInputModelsAccumulator.add(inputModel);
				getOperatorTypeInputs(
					modelTypeEndpointInputs,
					operatorTypeInputs,
					newInputModelsAccumulator,
					currentIndex + 1
				);
			}
		}
	}

	private void runOperatorType(Operator operatorType, List<Set<OperatorInput>> modelTypeEndpointInputs, MultiModel mapMID) {

		Set<List<OperatorInput>> operatorTypeInputs = new HashSet<>();
		getOperatorTypeInputs(modelTypeEndpointInputs, operatorTypeInputs, new ArrayList<>(), 0);
		for (List<OperatorInput> operatorTypeInput : operatorTypeInputs) {
			EList<Model> inputModels = new BasicEList<>();
			java.util.Map<Integer, EList<ConversionOperator>> conversions = new HashMap<>();
			for (int i = 0; i < operatorTypeInput.size(); i++) {
				inputModels.add(operatorTypeInput.get(i).getModel());
				List<ConversionOperator> conversion = operatorTypeInput.get(i).getConversions();
				if (!conversion.isEmpty()) {
					conversions.put(new Integer(i), new BasicEList<>(conversion));
				}
			}
			try {
				Operator newOperator = operatorType.createInstance(mapMID);
				for (Model inputModel : inputModels) {
					//TODO MMINT[OPERATOR] Create operator inputs
					//inputModelTypeEndpoint.createInstance(inputModel, newOperator, OperatorPackage.eINSTANCE.getOperator_Inputs().getName());
				}
				newOperator.run(inputModels, conversions, mapMID);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Operator " + operatorType + " execution error, skipping it", e);
			}
		}
	}

	public EList<Model> execute(EList<Model> inputModels) throws Exception {

		Model inputMIDModel = inputModels.get(0);
		MultiModel instanceMID = MultiModelRegistry.getMultiModel(inputMIDModel);
		Operator operatorType = (Operator) ((GenericEndpoint) getGenerics().get(0)).getTarget();
		MultiModel mapMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();

		// find all possible combinations of inputs for operatorType and execute them
		List<Set<OperatorInput>> modelTypeEndpointInputs = getModelTypeEndpointInputs(operatorType, mapMID);
		runOperatorType(operatorType, modelTypeEndpointInputs, mapMID);
		/* TODO
		 * - Make it recursive and add option for shallow/deep
		 * - Think about the alternative invocation, with a mid for every parameter of operatorType (no need to find matches?)
		 */

		String mapMIDUri = MultiModelUtils.getUniqueUri(
			MultiModelUtils.addFileNameSuffixInUri(inputMIDModel.getUri(), MAP_MID_SUFFIX),
			true,
			false
		);
		MultiModelUtils.createModelFile(mapMID, mapMIDUri, true);
		Model mapMIDModel = inputMIDModel.getMetatype().createInstanceAndEditor(
			mapMIDUri,
			ModelOrigin.CREATED,
			instanceMID
		);
		EList<Model> operatorOutputs = new BasicEList<>();
		operatorOutputs.add(mapMIDModel);

		return operatorOutputs;
	}

}
