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
package edu.toronto.cs.se.mmint.mid.operator;

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

import edu.toronto.cs.se.mmint.MMINT;
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
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;

public class Map extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MIDS = "mids";
	private final static @NonNull String OUT_MIDS = "mappedMids";
	private final static @NonNull String GENERIC_OPERATORTYPE = "MAPPER";
	// constants
	private final static @NonNull String MAPPED_MID_SUFFIX = "_map";
	private final static @NonNull String MIDREL_MODELTYPE_URI_SUFFIX = "Rel";
	private final static @NonNull String MIDOPER_MODELTYPE_URI_SUFFIX = "Oper";

	@Override
	public boolean isAllowedGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, EList<OperatorInput> inputs) throws MMINTException {

		boolean allowed = super.isAllowedGeneric(genericTypeEndpoint, genericType, inputs);
		if (!allowed) {
			return false;
		}
		if (genericType.getName().equals("Filter") || genericType.getName().equals("Map") || genericType.getName().equals("Reduce")) {
			return false;
		}

		return true;
	}

	private Model createOutputMIDModel(String outputName, MultiModel outputMID, Model midModelType, MultiModel instanceMID) throws Exception {

		String baseOutputUri = MultiModelRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0];
		String outputMIDUri = MultiModelUtils.getUniqueUri(
			MultiModelUtils.replaceFileNameInUri(baseOutputUri, outputName + MAPPED_MID_SUFFIX),
			true,
			false);
		MultiModelUtils.createModelFile(outputMID, outputMIDUri, true);
		Model outputMIDModel = midModelType.createInstanceAndEditor(
			outputMIDUri,
			ModelOrigin.CREATED,
			instanceMID);

		return outputMIDModel;
	}

	private Model createOutputMIDRelModel(String outputName, MultiModel outputMID, Model midrelModelType, MultiModel instanceMID, java.util.Map<String, Set<Model>> midrelShortcutsByOutputName) throws Exception {

		Model outputMIDModel = createOutputMIDModel(outputName, outputMID, midrelModelType, instanceMID);
		// create gmf shortcuts
		Diagram outputMIDModelDiagram = (Diagram) outputMIDModel.getEditors().get(0);
		View gmfDiagramRoot = (View) MultiModelUtils.getModelFile(outputMIDModelDiagram.getUri(), true);
		//TODO MMINT[DIAGRAM] This is wrong, I'd need the supertype
		String gmfDiagramPluginId = MultiModelTypeRegistry.getTypeBundle(
			outputMIDModelDiagram.getMetatypeUri()).getSymbolicName();
		MIDDiagramViewProvider gmfViewProvider = new MIDDiagramViewProvider();
		for (Model midrelShortcut : midrelShortcutsByOutputName.get(outputName)) {
			Node gmfNode = gmfViewProvider.createModel_2012(
				midrelShortcut,
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

		return outputMIDModel;
	}

	private java.util.Map<String, Model> map(
			@NonNull List<Model> inputMIDModels, @NonNull Operator mapperOperatorType,
			@NonNull Set<EList<OperatorInput>> mapperInputSet, @NonNull MultiModel instanceMID) throws Exception {

		// create output MIDs
		java.util.Map<String, MultiModel> mapperOutputMIDsByName = mapperOperatorType.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
				outputModelTypeEndpoint -> MIDFactory.eINSTANCE.createMultiModel()));
		MultiModel mapperMID = Boolean.parseBoolean(
			MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPERATORS_ENABLED)) ?
				MIDFactory.eINSTANCE.createMultiModel() :
				null;
		// start operator types
		java.util.Map<String, Set<Model>> midrelShortcutsByOutputName = new HashMap<>();
		java.util.Map<String, Set<MultiModel>> midrelMIDsByOutputName = new HashMap<>();
		Set<Model> midoperModelShortcuts = new HashSet<>(), midoperModelRelShortcuts = new HashSet<>();
		for (EList<OperatorInput> mapperInputs : mapperInputSet) {
			try {
				EList<OperatorGeneric> mapperGenerics = mapperOperatorType.selectAllowedGenerics(mapperInputs);
				java.util.Map<String, Model> mapperOutputsByName = mapperOperatorType.start(
						mapperInputs,
						mapperGenerics,
						mapperOutputMIDsByName,
						mapperMID)
					.getOutputsByName();
				// get gmf shortcuts to create (output MIDRels/MIDOpers need gmf shortcuts to model endpoints)
				if (mapperMID != null) {
					for (OperatorInput operatorInput : mapperInputs) {
						if (operatorInput.getModel() instanceof ModelRel) {
							midoperModelRelShortcuts.add(operatorInput.getModel());
						}
						else {
							midoperModelShortcuts.add(operatorInput.getModel());
						}
					}
				}
				for (Entry<String, Model> mapperOutput : mapperOutputsByName.entrySet()) {
					if (mapperMID != null) {
						if (mapperOutput.getValue() instanceof ModelRel) {
							midoperModelRelShortcuts.add(mapperOutput.getValue());
						}
						else {
							midoperModelShortcuts.add(mapperOutput.getValue());
						}
					}
					if (mapperOutput.getValue() instanceof ModelRel) {
						Set<Model> midrelShortcutsToAdd = ((ModelRel) mapperOutput.getValue()).getModelEndpoints()
							.stream()
							.map(ModelEndpoint::getTarget)
							.collect(Collectors.toSet());
						Set<Model> midrelShortcuts = midrelShortcutsByOutputName.putIfAbsent(
							mapperOutput.getKey(),
							midrelShortcutsToAdd);
						if (midrelShortcuts != null) {
							midrelShortcuts.addAll(midrelShortcutsToAdd);
						}
						Set<MultiModel> midrelMIDsToAdd = ((ModelRel) mapperOutput.getValue()).getModelEndpoints()
							.stream()
							.map(modelEndpoint -> MultiModelRegistry.getMultiModel(modelEndpoint.getTarget()))
							.collect(Collectors.toSet());
						Set<MultiModel> midrelMIDs = midrelMIDsByOutputName.putIfAbsent(
							mapperOutput.getKey(),
							midrelMIDsToAdd);
						if (midrelMIDs != null) {
							midrelMIDs.addAll(midrelMIDsToAdd);
						}
					}
				}
			}
			catch (Exception e) {
				// other than errors, the operator can fail because of input constraints due to the cartesian product
				MMINTException.print(
					IStatus.WARNING, "Operator " + mapperOperatorType + " execution error, skipping it", e);
			}
		}
		// store output MIDs
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		Model midrelModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI + MIDREL_MODELTYPE_URI_SUFFIX);
		String baseOutputUri = MultiModelRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0];
		java.util.Map<String, Model> outputsByName = new HashMap<>();
		int i = 0;
		// pass 1: no midrels
		for (Entry<String, MultiModel> outputMIDByName : mapperOutputMIDsByName.entrySet()) {
			boolean isMIDRel = midrelShortcutsByOutputName.get(outputMIDByName.getKey()) != null;
			if (isMIDRel) {
				continue;
			}
			Model outputMIDModel = createOutputMIDModel(outputMIDByName.getKey(), outputMIDByName.getValue(), midModelType, instanceMID);
			outputsByName.put(OUT_MIDS + i, outputMIDModel);
			i++;
		}
		// pass 2: midrels only
		for (Entry<String, MultiModel> outputMIDByName : mapperOutputMIDsByName.entrySet()) {
			boolean isMIDRel = midrelShortcutsByOutputName.get(outputMIDByName.getKey()) != null;
			if (!isMIDRel) {
				continue;
			}
			String outputName = outputMIDByName.getKey();
			Model outputMIDModel = createOutputMIDRelModel(outputName, outputMIDByName.getValue(), midrelModelType, instanceMID, midrelShortcutsByOutputName);
			outputsByName.put(OUT_MIDS + i, outputMIDModel);
			i++;
			for (MultiModel midrelMID : midrelMIDsByOutputName.get(outputName)) {
				String midrelMIDUri = MultiModelRegistry.getModelAndModelElementUris(midrelMID, MIDLevel.INSTANCES)[0];
				Model midrelMIDModel = MultiModelRegistry.getExtendibleElement(midrelMIDUri, instanceMID);
				EList<Model> midrelTargetModels = new BasicEList<>();
				midrelTargetModels.add(outputMIDModel);
				midrelTargetModels.add(midrelMIDModel);
				ModelRel midrelRel = MultiModelTypeHierarchy.getRootModelRelType().createInstanceAndEndpointsAndReferences(
					null,
					true,
					ModelOrigin.CREATED,
					midrelTargetModels,
					instanceMID);
				midrelRel.setName(midrelMIDModel.getName());
			}
		}
		// create midoper
//		if (operatorMID != null) {
//			Model midoperModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI + MIDOPER_MODELTYPE_URI_SUFFIX);
//			String operatorMIDUri = MultiModelUtils.getUniqueUri(
//				MultiModelUtils.replaceFileNameInUri(baseOutputUri, mapperOperatorType.getName() + MAPPED_MID_SUFFIX),
//				true,
//				false);
//			MultiModelUtils.createModelFile(operatorMID, operatorMIDUri, true);
//			Model operatorMIDModel = midoperModelType.createInstanceAndEditor(
//				operatorMIDUri,
//				ModelOrigin.CREATED,
//				instanceMID);
//			outputsByName.put(OUT_MIDS + i, operatorMIDModel);
//			// create gmf shortcuts
//			Diagram operatorMIDModelDiagram = (Diagram) operatorMIDModel.getEditors().get(0);
//			View gmfDiagramRoot = (View) MultiModelUtils.getModelFile(operatorMIDModelDiagram.getUri(), true);
//			//TODO MMINT[DIAGRAM] This is wrong, I'd need the supertype
//			String gmfDiagramPluginId = MultiModelTypeRegistry.getTypeBundle(
//				operatorMIDModelDiagram.getMetatypeUri()).getSymbolicName();
//			MIDDiagramViewProvider gmfViewProvider = new MIDDiagramViewProvider();
//			for (Model midoperModelShortcut : midoperModelShortcuts) {
//				Node gmfNode = gmfViewProvider.createModel_2012(
//					midoperModelShortcut,
//					gmfDiagramRoot,
//					-1,
//					true,
//					new PreferencesHint(gmfDiagramPluginId));
//				EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
//				shortcutAnnotation.setSource("Shortcut");
//				shortcutAnnotation.getDetails().put("modelID", MultiModelEditPart.MODEL_ID);
//				gmfNode.getEAnnotations().add(shortcutAnnotation);
//			}
//			//TODO MMINT[MAP] Fix refresh problems, don't know if there can be shortcuts for gmf links (binary model rels)
////			for (Model midoperModelRelShortcut : midoperModelRelShortcuts) {
////				View gmfView;
////				//TODO MMINT[MAP] Create function to do this
////				if (midoperModelRelShortcut instanceof BinaryModelRel) {
////					gmfView = gmfViewProvider.createBinaryModelRel_4015(
////						midoperModelRelShortcut,
////						gmfDiagramRoot,
////						-1,
////						true,
////						new PreferencesHint(gmfDiagramPluginId));
////				}
////				else {
////					gmfView = gmfViewProvider.createModelRel_2014(
////						midoperModelRelShortcut,
////						gmfDiagramRoot,
////						-1,
////						true,
////						new PreferencesHint(gmfDiagramPluginId));
////				}
////				EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
////				shortcutAnnotation.setSource("Shortcut");
////				shortcutAnnotation.getDetails().put("modelID", MultiModelEditPart.MODEL_ID);
////				gmfView.getEAnnotations().add(shortcutAnnotation);
////			}
//			MultiModelUtils.createModelFile(gmfDiagramRoot, operatorMIDModelDiagram.getUri(), true);
//		}

		return outputsByName;
	}

	@Override
	public java.util.Map<String, Model> run(
			java.util.Map<String, Model> inputsByName, java.util.Map<String, GenericElement> genericsByName,
			java.util.Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		List<Model> inputMIDModels = MultiModelOperatorUtils.getVarargs(inputsByName, IN_MIDS);
		Operator mapperOperatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUT_MIDS);
		EList<MultiModel> inputMIDs = new BasicEList<>();
		for (Model inputMIDModel : inputMIDModels) {
			inputMIDs.add((MultiModel) inputMIDModel.getEMFInstanceRoot());
		}

		// find all possible combinations of inputs for operatorType and execute them
		Set<EList<OperatorInput>> operatorInputSet = mapperOperatorType.findAllowedInputs(inputMIDs);
		java.util.Map<String, Model> outputsByName = map(inputMIDModels, mapperOperatorType, operatorInputSet, instanceMID);

		// store model elements created in the input mids
		for (int i = 0; i < inputMIDModels.size(); i++) {
			MultiModelUtils.createModelFile(inputMIDs.get(i), inputMIDModels.get(i).getUri(), true);
		}

		return outputsByName;
	}

}
