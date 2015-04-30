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
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class Map extends OperatorImpl {

	@NonNull private final static String INPUT_MIDS = "inputMIDs";
	@NonNull private final static String OUTPUT_MIDS = "outputMIDs";
	@NonNull private final static String GENERIC_OPERATORTYPE = "OP";

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
				OperatorInput operatorInput = OperatorFactory.eINSTANCE.createOperatorInput();
				operatorInput.setModel(inputModel);
				operatorInput.getConversions().addAll(conversions);
				operatorInput.setModelTypeEndpoint(inputModelTypeEndpoint);
				modelTypeEndpointInputSet.add(operatorInput);
			}
		}

		return modelTypeEndpointInputs;
	}

	private void getOperatorTypeInputs(List<Set<OperatorInput>> modelTypeEndpointInputs,
			Set<EList<OperatorInput>> operatorTypeInputs, EList<OperatorInput> inputModelsAccumulator, int currentIndex) {

		if (modelTypeEndpointInputs.size() == currentIndex) {
			operatorTypeInputs.add(inputModelsAccumulator);
		}
		else {
			for (OperatorInput inputModel : modelTypeEndpointInputs.get(currentIndex)) {
				EList<OperatorInput> newInputModelsAccumulator = new BasicEList<>(inputModelsAccumulator);
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

	private void runOperatorType(Operator operatorType, List<Set<OperatorInput>> modelTypeEndpointInputs,
			MultiModel mapMID) {

		Set<EList<OperatorInput>> operatorInputSet = new HashSet<>();
		getOperatorTypeInputs(modelTypeEndpointInputs, operatorInputSet, new BasicEList<>(), 0);
		java.util.Map<String, MultiModel> outputMIDsByName = operatorType.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
				outputModelTypeEndpoint -> null)
			);
		for (EList<OperatorInput> operatorInputs : operatorInputSet) {
			try {
				operatorType.start(operatorInputs, outputMIDsByName, mapMID);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Operator " + operatorType + " execution error, skipping it", e);
			}
		}
	}

	@Override
	public java.util.Map<String, Model> run(java.util.Map<String, Model> inputsByName,
			java.util.Map<String, GenericElement> genericsByName, java.util.Map<String, MultiModel> outputMIDsByName)
			throws Exception {

		Model inputMIDModel = inputsByName.get(INPUT_MIDS);
		Operator operatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_MIDS);
		MultiModel mapMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();

		// find all possible combinations of inputs for operatorType and execute them
		List<Set<OperatorInput>> modelTypeEndpointInputs = getModelTypeEndpointInputs(operatorType, mapMID);
		runOperatorType(operatorType, modelTypeEndpointInputs, mapMID);
		/* TODO
		 * - Make it recursive and add option for shallow/deep
		 * - Think about the alternative invocation, with a mid for every parameter of operatorType
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
		java.util.Map<String, Model> outputs = new HashMap<>();
		outputs.put(OUTPUT_MIDS, mapMIDModel);

		return outputs;
	}

}
