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
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
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
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDDiagramViewProvider;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
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

	@NonNull
	private final static String INPUT_MIDS = "inputMIDs";
	@NonNull
	private final static String OUTPUT_MIDS = "outputMIDs";
	@NonNull
	private final static String GENERIC_OPERATORTYPE = "OP";

	@NonNull
	private final static String MAP_MID_SUFFIX = "_map";

	private @NonNull List<Set<OperatorInput>> getModelTypeEndpointInputs(
			@NonNull Operator operatorType, @NonNull List<MultiModel> inputMIDs) {

		// TODO MMINT[MAP] Add support for upper bound = -1
		List<Set<OperatorInput>> modelTypeEndpointInputs = new ArrayList<>();
		for (int i = 0; i < operatorType.getInputs().size(); i++) {
			ModelEndpoint inputModelTypeEndpoint = operatorType.getInputs().get(i);
			// TODO MMINT[MAP] Add support for intermediate combinations of input MIDs to input arguments
			MultiModel mapMID = (inputMIDs.size() == 1) ? inputMIDs.get(0) : inputMIDs.get(i);
			Set<OperatorInput> modelTypeEndpointInputSet = new HashSet<>();
			modelTypeEndpointInputs.add(modelTypeEndpointInputSet);
			for (Model inputModel : MultiModelRegistry.getModels(mapMID)) {
				List<ConversionOperator> conversions = MultiModelTypeHierarchy.instanceOf(
					inputModel,
					inputModelTypeEndpoint.getTargetUri());
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

	private void getOperatorTypeInputs(
			@NonNull List<Set<OperatorInput>> modelTypeEndpointInputs,
			@NonNull Set<EList<OperatorInput>> operatorTypeInputs,
			@NonNull EList<OperatorInput> inputModelsAccumulator, int currentIndex) {

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
					currentIndex + 1);
			}
		}
	}

	private java.util.Map<String, Model> mapOperatorType(
			@NonNull Operator operatorType, @NonNull Set<EList<OperatorInput>> operatorInputSet,
			@NonNull MultiModel instanceMID) throws Exception {

		// create output MIDs
		java.util.Map<String, MultiModel> outputMIDsByName = operatorType.getOutputs().stream()
			.collect(
				Collectors.toMap(
					outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
					outputModelTypeEndpoint -> MIDFactory.eINSTANCE.createMultiModel()));
		// start operator types
		java.util.Map<String, Set<Model>> gmfShortcutsByOutputName = new HashMap<>();
		for (EList<OperatorInput> operatorInputs : operatorInputSet) {
			try {
				// TODO MMINT[MAP] Create mid of operator applications and pass it instead of null
				java.util.Map<String, Model> operatorOutputsByName = operatorType.start(
					operatorInputs,
					outputMIDsByName,
					null);
				// get gmf shortcuts to create (output MIDs containing model rels need gmf shortcuts to model endpoints)
				for (Entry<String, Model> operatorOutput : operatorOutputsByName.entrySet()) {
					if (!(operatorOutput.getValue() instanceof ModelRel)) {
						continue;
					}
					Set<Model> gmfShortcutsToAdd = ((ModelRel) operatorOutput.getValue()).getModelEndpoints().stream()
						.map(ModelEndpoint::getTarget)
						.collect(Collectors.toSet());
					Set<Model> gmfShortcuts = gmfShortcutsByOutputName.get(operatorOutput.getKey());
					if (gmfShortcuts == null) {
						gmfShortcutsByOutputName.put(operatorOutput.getKey(), gmfShortcutsToAdd);
					}
					else {
						gmfShortcuts.addAll(gmfShortcutsToAdd);
					}
				}
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Operator " + operatorType + " execution error, skipping it", e);
			}
		}
		// store output MIDs
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		String baseOutputUri = MultiModelRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0];
		java.util.Map<String, Model> outputsByName = new HashMap<>();
		int i = 0;
		for (Entry<String, MultiModel> outputMID : outputMIDsByName.entrySet()) {
			String outputMIDUri = MultiModelUtils.getUniqueUri(
				MultiModelUtils.replaceFileNameInUri(baseOutputUri, outputMID.getKey() + MAP_MID_SUFFIX),
				true,
				false);
			MultiModelUtils.createModelFile(outputMID.getValue(), outputMIDUri, true);
			Model outputMIDModel = midModelType.createInstanceAndEditor(outputMIDUri, ModelOrigin.CREATED, instanceMID);
			outputsByName.put(OUTPUT_MIDS + i, outputMIDModel);
			i++;
			// create gmf shortcuts
			if (gmfShortcutsByOutputName.get(outputMID.getKey()) == null) {
				continue;
			}
			Diagram outputMIDModelDiagram = (Diagram) outputMIDModel.getEditors().get(0);
			View gmfDiagramRoot = (View) MultiModelUtils.getModelFile(outputMIDModelDiagram.getUri(), true);
			String gmfDiagramPluginId = MultiModelTypeRegistry
				.getTypeBundle(outputMIDModelDiagram.getMetatypeUri())
				.getSymbolicName();
			MIDDiagramViewProvider gmfViewProvider = new MIDDiagramViewProvider();
			for (Model gmfShortcut : gmfShortcutsByOutputName.get(outputMID.getKey())) {
				Node gmfNode = gmfViewProvider.createModel_2012(
					gmfShortcut,
					gmfDiagramRoot,
					-1,
					true,
					new PreferencesHint(gmfDiagramPluginId));
				EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				shortcutAnnotation.setSource("Shortcut");
				shortcutAnnotation.getDetails().put("modelID", MultiModelEditPart.MODEL_ID);
				gmfNode.getEAnnotations().add(shortcutAnnotation);
			}
			MultiModelUtils.createModelFile(gmfDiagramRoot, outputMIDModelDiagram.getUri(), true);
			// TODO MMINT[MAP] Create empty relationships with all input MIDs?
		}

		return outputsByName;
	}

	@Override
	public java.util.Map<String, Model> run(
			java.util.Map<String, Model> inputsByName, java.util.Map<String, GenericElement> genericsByName,
			java.util.Map<String, MultiModel> outputMIDsByName) throws Exception {

		// TODO MMINT[MAP] Add option for shallow/deep and support for deep
		List<Model> inputMIDModels = MultiModelOperatorUtils.getVarargs(inputsByName, INPUT_MIDS);
		Operator operatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_MIDS);
		List<MultiModel> inputMIDs = new ArrayList<>();
		for (Model inputMIDModel : inputMIDModels) {
			inputMIDs.add((MultiModel) inputMIDModel.getEMFInstanceRoot());
		}

		// find all possible combinations of inputs for operatorType and execute them
		List<Set<OperatorInput>> modelTypeEndpointInputs = getModelTypeEndpointInputs(operatorType, inputMIDs);
		Set<EList<OperatorInput>> operatorInputSet = new HashSet<>();
		getOperatorTypeInputs(modelTypeEndpointInputs, operatorInputSet, new BasicEList<>(), 0);
		java.util.Map<String, Model> outputsByName = mapOperatorType(operatorType, operatorInputSet, instanceMID);

		// store model elements created in the input mids
		for (int i = 0; i < inputMIDModels.size(); i++) {
			MultiModelUtils.createModelFile(inputMIDs.get(i), inputMIDModels.get(i).getUri(), true);
		}

		return outputsByName;
	}

}
