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
package edu.toronto.cs.se.mmint.operator.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jdt.annotation.NonNull;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDDiagramViewProvider;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Map extends NestingOperatorImpl {

	// input-output
	private final static @NonNull String IN_MIDS = "mids";
	private final static @NonNull String OUT_MIDS = "mappedMids";
	private final static @NonNull String GENERIC_OPERATORTYPE = "MAPPER";
	// constants
	private final static @NonNull String MAPPED_MID_SUFFIX = "_map";
	private final static @NonNull String MIDREL_MODELTYPE_URI_SUFFIX = "Rel";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, List<OperatorInput> inputs) {
	
			if (genericType.getName().equals("Filter") || genericType.getName().equals("Map") || genericType.getName().equals("Reduce")) {
				return false;
			}
	
			return true;
		}
	}

	@Override
	public void createWorkflowInstanceOutputs(Operator newOperator, java.util.Map<String, Model> inputsByName, MID workflowMID) throws MMINTException {

		// create the vararg mapped mids
		Operator mapperOperatorType = (Operator) newOperator.getGenerics().get(0);
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

	private Model createOutputMIDRelModel(String outputName, MID outputMID, Model midModelType, Model midrelModelType, String midDiagramPluginId, MID instanceMID, Set<Model> midrelEndpointModels, MIDDiagramViewProvider gmfViewProvider) throws Exception {

		Model outputMIDModel = createOutputMIDModel(outputName, outputMID, midrelModelType, instanceMID);
		// create gmf shortcuts
		edu.toronto.cs.se.mmint.mid.editor.Diagram outputMIDModelDiagram = MIDRegistry.getModelDiagram(outputMIDModel);
		Diagram gmfDiagram = (Diagram) FileUtils.readModelFile(outputMIDModelDiagram.getUri(), true);
		for (Model midrelEndpointModel : midrelEndpointModels) {
			GMFUtils.createGMFNodeShortcut(midrelEndpointModel, gmfDiagram, midDiagramPluginId, midModelType.getName(), gmfViewProvider);
		}
		FileUtils.writeModelFile(gmfDiagram, outputMIDModelDiagram.getUri(), true);

		return outputMIDModel;
	}

	private java.util.@NonNull Map<String, Model> map(
			@NonNull List<Model> inputMIDModels,
			@NonNull EList<MID> inputMIDs,
			Operator mapperOperatorType,
			java.util.@NonNull Map<Operator, Set<EList<OperatorInput>>> mapperSpecs,
			java.util.@NonNull Map<String, MID> instanceMIDsByMapperOutput) throws Exception {

		// create output MIDs
		java.util.Map<String, MID> mapperOutputMIDsByName = mapperOperatorType.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
				outputModelTypeEndpoint -> MIDFactory.eINSTANCE.createMID()));
		String mapperMIDPath = this.getNestedMIDPath();
		MID mapperMID = super.getNestedInstanceMID();
		// start operator types
		java.util.Map<String, Set<Model>> midrelEndpointModelsByOutputName = new HashMap<>();
		EList<Model> mapperShortcutModels = new BasicEList<>();
		for (Entry<Operator, Set<EList<OperatorInput>>> mapperSpec : mapperSpecs.entrySet()) {
			Operator mapper = mapperSpec.getKey();
			for (EList<OperatorInput> mapperInputs : mapperSpec.getValue()) {
				try {
					EList<OperatorGeneric> mapperGenerics = mapper.selectAllowedGenerics(mapperInputs);
					java.util.Map<String, Model> mapperOutputsByName = mapper.startInstance(
						mapperInputs,
						null,
						mapperGenerics,
						mapperOutputMIDsByName,
						mapperMID)
							.getOutputsByName();
					if (mapperMIDPath != null) {
						mapperShortcutModels.addAll(mapperInputs.stream()
							.map(OperatorInput::getModel)
							.collect(Collectors.toList()));
						mapperShortcutModels.addAll(mapperOutputsByName.values());
					}
					// get model shortcuts to create for output MIDRels (to model endpoints)
					for (Entry<String, Model> mapperOutput : mapperOutputsByName.entrySet()) {
						Model mapperOutputModel = mapperOutput.getValue();
						if (!(mapperOutputModel instanceof ModelRel)) {
							continue;
						}
						String mapperOutputName = mapperOutput.getKey();
						Set<Model> newMidrelEndpointModels = ((ModelRel) mapperOutputModel).getModelEndpoints().stream()
							.map(ModelEndpoint::getTarget)
							.collect(Collectors.toSet());
						Set<Model> midrelEndpointModels = midrelEndpointModelsByOutputName.putIfAbsent(
							mapperOutputName,
							newMidrelEndpointModels);
						if (midrelEndpointModels != null) {
							midrelEndpointModels.addAll(newMidrelEndpointModels);
						}
						//TODO MMINT[MAP] Not needed unless we reactivate the fake endpoints
//						Set<MID> newMidrelEndpointMIDs = ((ModelRel) mapperOutputModel).getModelEndpoints().stream()
//							.map(modelEndpoint -> modelEndpoint.getTarget().getMIDContainer())
//							.collect(Collectors.toSet());
//						Set<MID> midrelEndpointMIDs = midrelEndpointMIDsByOutputName.putIfAbsent(
//							mapperOutputName,
//							newMidrelEndpointMIDs);
//						if (midrelEndpointMIDs != null) {
//							midrelEndpointMIDs.addAll(newMidrelEndpointMIDs);
//						}
					}
				}
				catch (Exception e) {
					// other than errors, the operator can fail because of input constraints due to the cartesian product
					MMINTException.print(
						IStatus.WARNING, "Operator " + mapper + " execution error, skipping it", e);
				}
			}
		}
		// store all involved MIDs
		Model midModelType = MIDTypeRegistry.getMIDModelType();
		List<Model> outputMIDModels = new ArrayList<>();
		// pass 1: output MIDs only
		for (Entry<String, MID> outputMIDByName : mapperOutputMIDsByName.entrySet()) {
			String outputName = outputMIDByName.getKey();
			if (midrelEndpointModelsByOutputName.containsKey(outputName)) { // is a MIDRel
				continue;
			}
			MID outputMID = outputMIDByName.getValue();
			Model outputMIDModel = this.createOutputMIDModel(
				outputName,
				outputMID,
				midModelType,
				instanceMIDsByMapperOutput.get(outputName));
			outputMIDModels.add(outputMIDModel);
		}
		// pass 2: output MIDRels only
		Model midrelModelType = MIDTypeRegistry.getType(MIDPackage.eNS_URI + MIDREL_MODELTYPE_URI_SUFFIX);
		String midDiagramPluginId = MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName();
		MIDDiagramViewProvider gmfViewProvider = new MIDDiagramViewProvider();
		for (Entry<String, MID> outputMIDByName : mapperOutputMIDsByName.entrySet()) {
			String outputName = outputMIDByName.getKey();
			if (!midrelEndpointModelsByOutputName.containsKey(outputName)) { // is not a MIDRel
				continue;
			}
			MID outputMID = outputMIDByName.getValue();
			MID instanceMID = instanceMIDsByMapperOutput.get(outputName);
			Model outputMIDModel = this.createOutputMIDRelModel(
				outputName,
				outputMID,
				midModelType,
				midrelModelType,
				midDiagramPluginId,
				instanceMID,
				midrelEndpointModelsByOutputName.get(outputName),
				gmfViewProvider);
			outputMIDModels.add(outputMIDModel);
			//TODO MMINT[MAP] A MIDRel is just a Model, so this was to fake it to have endpoints (a proper metamodel object and gmf figure would be needed)
//			for (MID midrelEndpointMID : midrelEndpointMIDsByOutputName.get(outputName)) {
//				if (midrelEndpointMID != instanceMID) { // can't create the rel
//					continue;
//				}
//				Model midrelEndpointMIDModel = instanceMID.getExtendibleElement(MIDRegistry.getModelUri(midrelEndpointMID));
//				MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
//					null,
//					midrelEndpointMIDModel.getName(),
//					outputMIDModel,
//					midrelEndpointMIDModel,
//					instanceMID);
//			}
		}
		// pass 3: mapper MID, after output MIDs and MIDRels are serialized
		this.createNestedInstanceMIDModelShortcuts(mapperShortcutModels, gmfViewProvider);
		super.writeNestedInstanceMID();

		// pass 4: input MIDs and endpoint MIDs of input MIDRels, since model elements can be created there
		java.util.Map<String, MID> inputMIDsToSerialize = new HashMap<>();
		Set<MID> inputMIDRels = new HashSet<>();
		for (int i = 0; i < inputMIDModels.size(); i++) {
			MID inputMID = inputMIDs.get(i);
			if (MIDTypeHierarchy.instanceOf(inputMIDModels.get(i), midrelModelType.getUri(), false)) {
				inputMIDRels.add(inputMID);
				continue;
			}
			inputMIDsToSerialize.put(inputMIDModels.get(i).getUri(), inputMID);
		}
		for (MID inputMIDRel : inputMIDRels) {
			java.util.Map<String, MID> endpointMIDs = inputMIDRel.getModelRels().stream()
				.flatMap(modelRel -> modelRel.getModelEndpoints().stream()
				.map(modelEndpoint -> modelEndpoint.getTarget()))
				.map(model -> model.getMIDContainer())
				.collect(Collectors.toMap(mid -> MIDRegistry.getModelUri(mid), mid -> mid, (mid1, mid2) -> mid1)); // duplicates should simply be used once
			inputMIDsToSerialize.putAll(endpointMIDs);
		}
		for (Entry<String, MID> inputMIDToSerialize : inputMIDsToSerialize.entrySet()) {
			FileUtils.writeModelFile(inputMIDToSerialize.getValue(), inputMIDToSerialize.getKey(), true);
		}

		return MIDOperatorIOUtils.setVarargs(outputMIDModels, OUT_MIDS);
	}

	private java.util.@NonNull Map<String, EList<OperatorInput>> diffMultipleDispatchInputs(java.util.@NonNull Map<String, EList<OperatorInput>> assignedInputs, @NonNull Set<EList<OperatorInput>> mapperInputs) {

		java.util.Map<String, EList<OperatorInput>> newInputs = new HashMap<>();
		for (EList<OperatorInput> mapperInput : mapperInputs) {
			String key = mapperInput.stream()
				.map(input -> MIDRegistry.getModelElementUri(input.getModel()))
				.collect(Collectors.joining(";"));
			if (!assignedInputs.containsKey(key)) {
				newInputs.put(key, mapperInput);
			}
		}

		return newInputs;
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

		// find all possible combinations of inputs and execute them
		java.util.Map<Operator, Set<EList<OperatorInput>>> mapperSpecs = new HashMap<>();
		EList<Operator> multipleDispatch = (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_MULTIPLEDISPATCH_ENABLED))) ?
			ECollections.asEList(MIDTypeHierarchy.getSubtypes(mapperOperatorType)) :
			ECollections.emptyEList();
		if (multipleDispatch.isEmpty()) { // multiple dispatch disabled, or the mapper operator is not a multimethod
			mapperSpecs.put(mapperOperatorType, mapperOperatorType.findAllowedInputs(inputMIDs));
		}
		else {
			multipleDispatch.add(mapperOperatorType);
			java.util.Map<String, EList<OperatorInput>> assignedInputs = new HashMap<>();
			Iterator<Operator> multiIter = MIDTypeHierarchy.getInverseTypeHierarchyIterator(multipleDispatch);
			while (multiIter.hasNext()) { // start from the most specialized operator backwards
				Operator multiMapper = multiIter.next();
				// assign at each step the allowed inputs that have not been already assigned
				Set<EList<OperatorInput>> mapperInputs = multiMapper.findAllowedInputs(inputMIDs);
				java.util.Map<String, EList<OperatorInput>> newInputs = this.diffMultipleDispatchInputs(assignedInputs, mapperInputs);
				mapperSpecs.put(multiMapper, new HashSet<>(newInputs.values()));
				assignedInputs.putAll(newInputs);
			}
		}
		java.util.Map<String, Model> outputsByName = this.map(inputMIDModels, inputMIDs, mapperOperatorType, mapperSpecs, instanceMIDsByMapperOutput);

		return outputsByName;
	}

}
