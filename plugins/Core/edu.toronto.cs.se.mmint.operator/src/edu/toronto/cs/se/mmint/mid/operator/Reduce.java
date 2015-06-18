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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;

public class Reduce extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MID = "mid";
	private final static @NonNull String OUT_MID = "reducedMid";
	private final static @NonNull String GENERIC_OPERATORTYPE = "ACCUMULATOR";
	// constants
	private final static @NonNull String REDUCED_MID_SUFFIX = "_reduce";
	private final static @NonNull String MODELRELCOMPOSITION_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelComposition";
	private final static @NonNull String MODELRELMERGE_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelMerge";

	@Override
	public boolean isAllowedTargetGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, EList<OperatorInput> inputs) throws MMINTException {

		boolean allowed = super.isAllowedTargetGeneric(genericTypeEndpoint, genericType, inputs);
		if (!allowed) {
			return false;
		}
		if (genericType.getName().equals("Filter") || genericType.getName().equals("Map") || genericType.getName().equals("Reduce")) {
			return false;
		}

		return true;
	}

	private @NonNull MultiModel reduce(@NonNull Model inputMIDModel, @NonNull Operator accumulatorOperatorType)
			throws Exception {

		// preparation for accumulator operator
		MultiModel reducedMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
		Map<String, MultiModel> accumulatorOutputMIDsByName = MultiModelOperatorUtils
			.createSimpleOutputMIDsByName(accumulatorOperatorType, reducedMID);
		EList<MultiModel> inputMIDs = new BasicEList<>();
		inputMIDs.add(reducedMID);
		Set<Model> accumulatorOutputModelsToDelete = new HashSet<>();
		Map<String, Model> accumulatorOutputsByName = null;
		EList<OperatorInput> accumulatorInputs;
		// preparation for composition operator
		Operator compositionOperatorType = MultiModelTypeRegistry.getType(MODELRELCOMPOSITION_OPERATORTYPE_URI);
		Map<String, MultiModel> compositionOutputMIDsByName = MultiModelOperatorUtils
			.createSimpleOutputMIDsByName(compositionOperatorType, reducedMID);
		// preparation for merge operator
		Operator mergeOperatorType = MultiModelTypeRegistry.getType(MODELRELMERGE_OPERATORTYPE_URI);
		Map<String, MultiModel> mergeOutputMIDsByName = MultiModelOperatorUtils
			.createSimpleOutputMIDsByName(mergeOperatorType, reducedMID);
		// reduce loop
		while ((accumulatorInputs = accumulatorOperatorType.findFirstAllowedInput(inputMIDs)) != null) {
			Set<Model> accumulatorInputModels = new HashSet<>();
			Set<ModelRel> accumulatorInputModelRels = new HashSet<>();
			try {
				// get all model inputs, including the ones attached to model rel inputs
				for (OperatorInput accumulatorInput : accumulatorInputs) {
					Model accumulatorInputModel = accumulatorInput.getModel();
					if (accumulatorInputModel instanceof ModelRel) {
						accumulatorInputModels.addAll(((ModelRel) accumulatorInputModel).getModelEndpoints().stream()
							.map(ModelEndpoint::getTarget)
							.collect(Collectors.toSet()));
						accumulatorInputModelRels.add((ModelRel) accumulatorInputModel);
					}
					else {
						accumulatorInputModels.add(accumulatorInputModel);
					}
				}
				// get all model rels attached to input models that are not inputs themselves
				//TODO MMINT[OO] This is expensive, need a direct way to reach model rels from models
				Set<ModelRel> connectedModelRels = MultiModelRegistry.getModelRels(reducedMID).stream()
					.filter(modelRel -> !accumulatorInputModelRels.contains(modelRel))
					.filter(modelRel -> !Collections.disjoint(
						accumulatorInputModels,
						modelRel.getModelEndpoints().stream()
							.map(ModelEndpoint::getTarget)
							.collect(Collectors.toSet())))
					.collect(Collectors.toSet());
				// run the ACCUMULATOR operator
				accumulatorOutputsByName = accumulatorOperatorType.start(
						accumulatorInputs,
						accumulatorOutputMIDsByName,
						null)
					.getOutputsByName();
				accumulatorOutputModelsToDelete.addAll(
					accumulatorOutputsByName.values().stream()
						.filter(accumulatorOutputModel -> !(accumulatorOutputModel instanceof ModelRel))
						.collect(Collectors.toSet()));
				// for each model rel in the output that is connected with the input models, do the composition
				List<ModelRel> composedModelRels = new ArrayList<>();
				for (ModelRel connectedModelRel : connectedModelRels) {
					for (Model accumulatorModelRel : accumulatorOutputsByName.values()) {
						if (!(accumulatorModelRel instanceof ModelRel)) {
							continue;
						}
						try {
							EList<Model> compositionInputModels = new BasicEList<>();
							compositionInputModels.add(connectedModelRel);
							compositionInputModels.add(accumulatorModelRel);
							EList<OperatorInput> compositionInputs = compositionOperatorType.checkAllowedInputs(
								compositionInputModels);
							if (compositionInputs == null) {
								continue;
							}
							Map<String, Model> compositionOutputsByName = compositionOperatorType.start(
									compositionInputs,
									compositionOutputMIDsByName,
									null)
								.getOutputsByName();
							composedModelRels.add(
								(ModelRel) compositionOutputsByName.get(
									compositionOperatorType.getOutputs().get(0).getName()));
						}
						catch (Exception e) {
							MMINTException.print(
								IStatus.WARNING,
								"Operator " + compositionOperatorType + " execution error, skipping it",
								e);
						}
					}
				}
				// merge model rels that have been composed and share the same model endpoints
				Set<ModelRel> composedModelRelsToDelete = new HashSet<>();
				for (int i = 0; i < composedModelRels.size(); i++) {
					ModelRel composedModelRel1 = composedModelRels.get(i);
					for (int j = i+1; j < composedModelRels.size(); j++) {
						ModelRel composedModelRel2 = composedModelRels.get(j);
						try {
							EList<Model> mergeInputModels = new BasicEList<>();
							mergeInputModels.add(composedModelRel1);
							mergeInputModels.add(composedModelRel2);
							EList<OperatorInput> mergeInputs = mergeOperatorType.checkAllowedInputs(
								mergeInputModels);
							if (mergeInputs == null) {
								continue;
							}
							mergeOperatorType.start(mergeInputs, mergeOutputMIDsByName, null);
							composedModelRelsToDelete.add(composedModelRel1);
							composedModelRelsToDelete.add(composedModelRel2);
						}
						catch (Exception e) {
							MMINTException.print(
								IStatus.WARNING,
								"Operator " + mergeOperatorType + " execution error, skipping it",
								e);
						}
					}
				}
				composedModelRelsToDelete.forEach(compModelRelToDelete -> {
					try {
						compModelRelToDelete.deleteInstance();
					}
					catch (MMINTException e) {}
				});
			}
			catch (Exception e) {
				MMINTException.print(
					IStatus.WARNING,
					"Operator " + accumulatorOperatorType + " execution error, skipping it",
					e);
			}
			finally {
				// delete accumulator inputs (model rels are deleted as a side effect of deleting the models)
				// do it in case of failure too, because it will trigger an endless loop otherwise
				accumulatorInputModels.forEach(accumulatorInputModel -> {
					try {
						accumulatorInputModel.deleteInstance();
					}
					catch (MMINTException e) {}
				});
			}
		}
		// delete intermediate output model files but the ones from last execution
		for (Model accumulatorOutputModelToDelete : accumulatorOutputModelsToDelete) {
			if (accumulatorOutputsByName != null &&
					accumulatorOutputsByName.values().contains(accumulatorOutputModelToDelete)) {
				continue;
			}
			for (Editor accumulatorOutputEditorToDelete : accumulatorOutputModelToDelete.getEditors()) {
				MultiModelUtils.deleteFile(accumulatorOutputEditorToDelete.getUri(), true);
			}
			MultiModelUtils.deleteFile(accumulatorOutputModelToDelete.getUri(), true);
		}

		return reducedMID;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		Model inputMIDModel = inputsByName.get(IN_MID);
		Operator accumulatorOperatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUT_MID);

		// loop until reduction is no longer possible, reducing one input at a time
		boolean openEditors = Boolean.parseBoolean(
			MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED));
		if (openEditors) {
			MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED, "false");
		}
		MultiModel reducedMID = reduce(inputMIDModel, accumulatorOperatorType);
		if (openEditors) {
			MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED, "true");
		}

		// output
		String reducedMIDModelUri = MultiModelUtils.getUniqueUri(
			MultiModelUtils.addFileNameSuffixInUri(inputMIDModel.getUri(), REDUCED_MID_SUFFIX),
			true,
			false);
		MultiModelUtils.createModelFile(reducedMID, reducedMIDModelUri, true);
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		Model reducedMIDModel = midModelType.createInstanceAndEditor(reducedMIDModelUri, ModelOrigin.CREATED, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, reducedMIDModel);

		return outputsByName;
	}

}
