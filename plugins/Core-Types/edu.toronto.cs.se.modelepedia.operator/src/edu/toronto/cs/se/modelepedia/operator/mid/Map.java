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
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Map extends OperatorImpl {

	@NonNull private final static String INPUT_MIDS = "inputMIDs";
	@NonNull private final static String OUTPUT_MIDS = "outputMIDs";
	@NonNull private final static String GENERIC_OPERATORTYPE = "OP";

	@NonNull private final static String MAP_MID_SUFFIX = "_map";

	private List<Set<OperatorInput>> getModelTypeEndpointInputs(Operator operatorType, MultiModel mapMID) {

		//TODO MMINT[MAP] Add support for upper bound = -1
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

	private java.util.Map<String, Model> mapOperatorType(Operator operatorType, Set<EList<OperatorInput>> operatorInputSet, MultiModel instanceMID) throws Exception {

		// create output MIDs
		java.util.Map<String, MultiModel> outputMIDsByName = operatorType.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
				outputModelTypeEndpoint -> MIDFactory.eINSTANCE.createMultiModel())
			);
		// start operator types
		java.util.Map<String, List<Model>> gmfShortcutsByOutputName = new HashMap<>();
		for (EList<OperatorInput> operatorInputs : operatorInputSet) {
			try {
				//TODO MMINT[MAP] Create mid of operator applications and pass it instead of null
				java.util.Map<String, Model> operatorOutputsByName = operatorType.start(operatorInputs, outputMIDsByName, null);
				// get gmf shortcuts to be created (output MIDs containing model rels need gmf shortcuts to model endpoints)
				for (Entry<String, Model> operatorOutput : operatorOutputsByName.entrySet()) {
					if (!(operatorOutput.getValue() instanceof ModelRel)) {
						continue;
					}
					List<Model> gmfShortcuts = ((ModelRel) operatorOutput.getValue()).getModelEndpoints().stream()
						.map(ModelEndpoint::getTarget)
						.distinct()
						.collect(Collectors.toList());
					gmfShortcutsByOutputName.put(operatorOutput.getKey(), gmfShortcuts);
				}
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Operator " + operatorType + " execution error, skipping it", e);
			}
		}
		//TODO MMINT[MAP] create gmf shortcuts
		// store output MIDs
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		String baseOutputUri = MultiModelRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0];
		java.util.Map<String, Model> outputsByName = new HashMap<>();
		int i = 0;
		for (Entry<String, MultiModel> outputMID : outputMIDsByName.entrySet()) {
			String outputMIDUri = MultiModelUtils.getUniqueUri(
				MultiModelUtils.replaceFileNameInUri(baseOutputUri, outputMID.getKey() + MAP_MID_SUFFIX),
				true,
				false
			);
			//TODO MMINT[MAP] Fix issues with gmf shortcuts: NOTYPE + creating shortcuts in advance
			MultiModelUtils.createModelFile(outputMID.getValue(), outputMIDUri, true);
			Model outputMIDModel = midModelType.createInstanceAndEditor(
				outputMIDUri,
				ModelOrigin.CREATED,
				instanceMID
			);
			outputsByName.put(OUTPUT_MIDS + i, outputMIDModel);
			i++;
			//TODO MMINT[MAP] Create empty relationships with all input MIDs
		}

		return outputsByName;
	}

	@Override
	public java.util.Map<String, Model> run(java.util.Map<String, Model> inputsByName,
			java.util.Map<String, GenericElement> genericsByName, java.util.Map<String, MultiModel> outputMIDsByName)
			throws Exception {

		//TODO MMINT[MAP] Add option for shallow/deep and support for deep
		List<Model> inputMIDModels = MultiModelOperatorUtils.getVarargs(inputsByName, INPUT_MIDS);
		//TODO MMINT[MAP] Add case for inputMIDModels.size() == 0 and inputMIDModels.size() == operatorType.getInputs().size()
		//TODO MMINT[MAP] Add support for intermediate combinations of input MIDs to input arguments
		Model inputMIDModel = inputMIDModels.get(0);
		Operator operatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_MIDS);

		// find all possible combinations of inputs for operatorType and execute them
		MultiModel inputMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
		List<Set<OperatorInput>> modelTypeEndpointInputs = getModelTypeEndpointInputs(operatorType, inputMID);
		Set<EList<OperatorInput>> operatorInputSet = new HashSet<>();
		getOperatorTypeInputs(modelTypeEndpointInputs, operatorInputSet, new BasicEList<>(), 0);
		java.util.Map<String, Model> outputsByName = mapOperatorType(operatorType, operatorInputSet, instanceMID);

		// store model elements created in the input mids
		MultiModelUtils.createModelFile(inputMID, inputMIDModel.getUri(), true);

		return outputsByName;
	}

}
