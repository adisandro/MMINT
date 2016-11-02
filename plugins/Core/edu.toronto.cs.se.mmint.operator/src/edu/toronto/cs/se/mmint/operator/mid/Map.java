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
package edu.toronto.cs.se.mmint.operator.mid;

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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

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

	@Override
	public Operator startWorkflowInstance(EList<OperatorInput> inputs, EList<OperatorGeneric> generics, MID workflowMID) throws MMINTException {

		Operator newOperator = super.startWorkflowInstance(inputs, generics, workflowMID);
		// create the vararg mapped mids
		Operator mapperOperatorType = (Operator) generics.get(0).getGeneric();
		Model midModelType = MIDTypeRegistry.getMIDModelType();
		Model midrelModelType = MIDTypeRegistry.getType(MIDPackage.eNS_URI + MIDREL_MODELTYPE_URI_SUFFIX);
		for (int i = 0; i < mapperOperatorType.getOutputs().size(); i++) {
			Model outputModelType = (mapperOperatorType.getOutputs().get(i).getTarget() instanceof ModelRel) ?
				midrelModelType : midModelType;
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

	private Model createOutputMIDModel(String outputName, MID outputMID, Model midModelType, MID instanceMID) throws Exception {

		String baseOutputPath = (instanceMID == null) ?
			MMINT.getActiveInstanceMIDFile().getFullPath().toOSString() :
			MIDRegistry.getModelUri(instanceMID);
		String outputMIDPath = FileUtils.getUniquePath(
			FileUtils.replaceFileNameInPath(baseOutputPath, outputName + MAPPED_MID_SUFFIX),
			true,
			false);
		Model outputMIDModel = midModelType.createInstanceAndEditor(
			outputMID,
			outputMIDPath,
			instanceMID);

		return outputMIDModel;
	}

	private Model createOutputMIDRelModel(String outputName, MID outputMID, Model midrelModelType, MID instanceMID, Set<Model> midrelShortcuts) throws Exception {

		Model outputMIDModel = createOutputMIDModel(outputName, outputMID, midrelModelType, instanceMID);
		// create gmf shortcuts
		Diagram outputMIDModelDiagram = MIDRegistry.getModelDiagram(outputMIDModel);
		View gmfDiagramRoot = (View) FileUtils.readModelFile(outputMIDModelDiagram.getUri(), true);
		for (Model midrelShortcut : midrelShortcuts) {
			MIDDiagramUtils.createModelShortcut(midrelShortcut, gmfDiagramRoot);
		}
		FileUtils.writeModelFile(gmfDiagramRoot, outputMIDModelDiagram.getUri(), true);

		return outputMIDModel;
	}

	private java.util.@NonNull Map<String, Model> map(
			@NonNull List<Model> inputMIDModels, @NonNull Operator mapperOperatorType,
			@NonNull Set<EList<OperatorInput>> mapperInputSet, java.util.@NonNull Map<String, MID> instanceMIDsByMapperOutput) throws Exception {

		// create output MIDs
		java.util.Map<String, MID> mapperOutputMIDsByName = mapperOperatorType.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
				outputModelTypeEndpoint -> MIDFactory.eINSTANCE.createMID()));
		MID mapperMID = Boolean.parseBoolean(
			MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPERATORS_ENABLED)) ?
				MIDFactory.eINSTANCE.createMID() :
				null;
		// start operator types
		java.util.Map<String, Set<Model>> midrelShortcutsByOutputName = new HashMap<>();
		java.util.Map<String, Set<MID>> midrelMIDsByOutputName = new HashMap<>();
		Set<Model> midoperModelShortcuts = new HashSet<>(), midoperModelRelShortcuts = new HashSet<>();
		for (EList<OperatorInput> mapperInputs : mapperInputSet) {
			try {
				EList<OperatorGeneric> mapperGenerics = mapperOperatorType.selectAllowedGenerics(mapperInputs);
				java.util.Map<String, Model> mapperOutputsByName = mapperOperatorType.startInstance(
						mapperInputs,
						null,
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
						Set<MID> midrelMIDsToAdd = ((ModelRel) mapperOutput.getValue()).getModelEndpoints()
							.stream()
							.map(modelEndpoint -> modelEndpoint.getTarget().getMIDContainer())
							.collect(Collectors.toSet());
						Set<MID> midrelMIDs = midrelMIDsByOutputName.putIfAbsent(
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
		Model midModelType = MIDTypeRegistry.getMIDModelType();
		Model midrelModelType = MIDTypeRegistry.getType(MIDPackage.eNS_URI + MIDREL_MODELTYPE_URI_SUFFIX);
		List<Model> outputMIDModels = new ArrayList<>();
		// pass 1: no midrels
		for (Entry<String, MID> outputMIDByName : mapperOutputMIDsByName.entrySet()) {
			String outputName = outputMIDByName.getKey();
			MID outputMID = outputMIDByName.getValue();
			boolean isMIDRel = midrelShortcutsByOutputName.get(outputName) != null;
			if (isMIDRel) {
				continue;
			}
			Model outputMIDModel = createOutputMIDModel(outputName, outputMID, midModelType, instanceMIDsByMapperOutput.get(outputName));
			outputMIDModels.add(outputMIDModel);
		}
		// pass 2: midrels only
		for (Entry<String, MID> outputMIDByName : mapperOutputMIDsByName.entrySet()) {
			String outputName = outputMIDByName.getKey();
			MID outputMID = outputMIDByName.getValue();
			boolean isMIDRel = midrelShortcutsByOutputName.get(outputName) != null;
			if (!isMIDRel) {
				continue;
			}
			MID instanceMID = instanceMIDsByMapperOutput.get(outputName);
			Model outputMIDModel = createOutputMIDRelModel(outputName, outputMID, midrelModelType, instanceMID, midrelShortcutsByOutputName.get(outputName));
			outputMIDModels.add(outputMIDModel);
			for (MID midrelMID : midrelMIDsByOutputName.get(outputName)) {
				String midrelMIDUri = MIDRegistry.getModelUri(midrelMID);
				if (midrelMID != instanceMID) { // can't create the rel
					continue;
				}
				Model midrelMIDModel = instanceMID.getExtendibleElement(midrelMIDUri);
				ModelRel midrelRel = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
					null,
					midrelMIDModel.getName(),
					outputMIDModel,
					midrelMIDModel,
					instanceMID);
			}
		}
		//TODO MMINT[OPERATOR] MIDOper's destiny? 
		// create midoper
//		String baseOutputUri = MIDRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0];
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

		return MIDOperatorIOUtils.setVarargs(outputMIDModels, OUT_MIDS);
	}

	@Override
	public java.util.Map<String, Model> run(
			java.util.Map<String, Model> inputsByName, java.util.Map<String, GenericElement> genericsByName,
			java.util.Map<String, MID> outputMIDsByName) throws Exception {

		// input
		List<Model> inputMIDModels = MIDOperatorIOUtils.getVarargs(inputsByName, IN_MIDS);
		EList<MID> inputMIDs = new BasicEList<>();
		for (Model inputMIDModel : inputMIDModels) {
			inputMIDs.add((MID) inputMIDModel.getEMFInstanceRoot());
		}
		Operator mapperOperatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		java.util.Map<String, MID> instanceMIDsByMapperOutput = MIDOperatorIOUtils.getVarargOutputMIDsByOtherName(outputMIDsByName, OUT_MIDS, mapperOperatorType.getOutputs());

		// find all possible combinations of inputs for operatorType and execute them
		Set<EList<OperatorInput>> operatorInputSet = mapperOperatorType.findAllowedInputs(inputMIDs);
		java.util.Map<String, Model> outputsByName = this.map(inputMIDModels, mapperOperatorType, operatorInputSet, instanceMIDsByMapperOutput);

		// store model elements created in the input mids
		for (int i = 0; i < inputMIDModels.size(); i++) {
			FileUtils.writeModelFile(inputMIDs.get(i), inputMIDModels.get(i).getUri(), true);
		}

		return outputsByName;
	}

}
