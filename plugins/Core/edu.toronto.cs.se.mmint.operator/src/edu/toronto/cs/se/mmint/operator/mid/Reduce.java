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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDDiagramViewProvider;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class Reduce extends NestingOperatorImpl {

	// input-output
	private final static @NonNull String IN_MID = "mid";
	private final static @NonNull String OUT_MID = "reducedMid";
	private final static @NonNull String GENERIC_OPERATORTYPE = "ACCUMULATOR";
	// constants
	private final static @NonNull String REDUCED_MID_SUFFIX = "_reduce";
	private final static @NonNull String MODELRELCOMPOSITION_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelComposition";
	private final static @NonNull String MODELRELMERGE_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelMerge";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, List<OperatorInput> inputs) {

			if (genericType.getName().equals("Filter") || genericType.getName().equals("Map") || genericType.getName().equals("Reduce")) {
				return false;
			}

			return true;
		}
	}

	private @NonNull MID reduce(@NonNull Model inputMIDModel, @NonNull Operator accumulatorOperatorType)
			throws Exception {

		/*TODO Fixed Point as Reduce:
		 * Like normal operators, a MIDRel should be able to "grab" its MID endpoints.
		 * Reduce should not really delete anything, just create intermediate results into nested mids in order to "lose" inputs
		 * Should add support for optional outputs (0 endpoint lower bound)
		 * Create a diff-like operator that returns either the last input or nothing
		 */
		/*TODO Fixed Point custom
		 * Like normal operators, a MIDRel should be able to "grab" its MID endpoints.
		 * Create an operator that loops until the input is equal to the output
		 */
		MID inputMID = (MID) inputMIDModel.getEMFInstanceRoot();
		MID prevReducingMID = inputMID;
		MID reducingMID = super.getNestedInstanceMID();
		boolean nestingEnabled = true;
		if (reducingMID == null) { // operator traceability + nesting disabled
			reducingMID = inputMID;
			nestingEnabled = false;
		}
		MIDDiagramViewProvider gmfViewProvider = new MIDDiagramViewProvider();
		Operator compositionOperatorType = MIDTypeRegistry.getType(MODELRELCOMPOSITION_OPERATORTYPE_URI);
		Operator mergeOperatorType = MIDTypeRegistry.getType(MODELRELMERGE_OPERATORTYPE_URI);
		// reduce loop
		EList<OperatorInput> accumulatorInputs;
		Set<Model> accumulatorOutputModelsToDelete = new HashSet<>();
		Map<String, Model> accumulatorOutputsByName = null;
		Set<Model> intermediateModels = new HashSet<>();
		while ((accumulatorInputs = accumulatorOperatorType.findFirstAllowedInput(
				ECollections.newBasicEList(prevReducingMID),
				ECollections.<Set<Model>>newBasicEList(intermediateModels))
		) != null) {
			intermediateModels.clear();
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
				// get all model rels and models attached to input models that are not inputs themselves
				//TODO MMINT[OO] This is expensive, need a direct way to reach model rels from models
				Set<ModelRel> connectedModelRels = prevReducingMID.getModelRels().stream()
					.filter(modelRel -> !accumulatorInputModelRels.contains(modelRel))
					.filter(modelRel -> modelRel.getModelEndpoints().stream()
						.anyMatch(modelEndpoint -> accumulatorInputModels.contains(modelEndpoint.getTarget())))
					.collect(Collectors.toSet());
				Set<Model> connectedModels = connectedModelRels.stream()
					.flatMap(modelRel -> modelRel.getModelEndpoints().stream())
					.map(ModelEndpoint::getTarget)
					.filter(model -> !accumulatorInputModels.contains(model))
					.collect(Collectors.toSet());
				// create model shortcuts in nested MID
				//TODO make sure shortcuts work with intermediate steps too
				if (nestingEnabled) {
					List<Model> shortcuts = new ArrayList<>();
					shortcuts.addAll(accumulatorInputModels);
					shortcuts.addAll(connectedModels);
					shortcuts.addAll(accumulatorInputModelRels);
					shortcuts.addAll(connectedModelRels);
					super.createNestedInstanceMIDModelShortcuts(shortcuts, gmfViewProvider);
				}
				// run the ACCUMULATOR operator
				Map<String, MID> accumulatorOutputMIDsByName = MIDOperatorIOUtils
						.createSameOutputMIDsByName(accumulatorOperatorType, reducingMID);
				EList<OperatorGeneric> accumulatorGenerics = accumulatorOperatorType.selectAllowedGenerics(
					accumulatorInputs);
				MID accumulatorMID = (nestingEnabled) ? reducingMID : null;
				accumulatorOutputsByName = accumulatorOperatorType.startInstance(
					accumulatorInputs,
					null,
					accumulatorGenerics,
					accumulatorOutputMIDsByName,
					accumulatorMID)
						.getOutputsByName();
				accumulatorOutputModelsToDelete.addAll(
					accumulatorOutputsByName.values().stream()
						.filter(model -> !(model instanceof ModelRel))
						.collect(Collectors.toSet()));
				// for each model rel in the output that is connected with the input models, do the composition
				Map<String, MID> compositionOutputMIDsByName = MIDOperatorIOUtils
						.createSameOutputMIDsByName(compositionOperatorType, reducingMID);
				List<ModelRel> composedModelRels = new ArrayList<>();
				for (ModelRel connectedModelRel : connectedModelRels) {
					for (Model accumulatorOutputModelRel : accumulatorOutputsByName.values()) {
						if (!(accumulatorOutputModelRel instanceof ModelRel)) {
							continue;
						}
						try {
							EList<Model> compositionInputModels = ECollections.newBasicEList(
								connectedModelRel, accumulatorOutputModelRel);
							EList<OperatorInput> compositionInputs = compositionOperatorType.checkAllowedInputs(
								compositionInputModels);
							if (compositionInputs == null) {
								continue;
							}
							MID compositionMID = (nestingEnabled) ? reducingMID : null;
							Map<String, Model> compositionOutputsByName = compositionOperatorType.startInstance(
								compositionInputs,
								null,
								ECollections.emptyEList(),
								compositionOutputMIDsByName,
								compositionMID)
									.getOutputsByName();
							composedModelRels.add((ModelRel) compositionOutputsByName.get(
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
				Map<String, MID> mergeOutputMIDsByName = MIDOperatorIOUtils
						.createSameOutputMIDsByName(mergeOperatorType, reducingMID);
				Set<ModelRel> mergedModelRels = new HashSet<>();
				for (int j = 0; j < composedModelRels.size(); j++) {
					ModelRel composedModelRel1 = composedModelRels.get(j);
					for (int k = j+1; k < composedModelRels.size(); k++) {
						ModelRel composedModelRel2 = composedModelRels.get(k);
						try {
							EList<Model> mergeInputModels = ECollections.newBasicEList(
								composedModelRel1, composedModelRel2);
							EList<OperatorInput> mergeInputs = mergeOperatorType.checkAllowedInputs(mergeInputModels);
							if (mergeInputs == null) {
								continue;
							}
							MID mergeMID = (nestingEnabled) ? reducingMID : null;
							mergeOperatorType.startInstance(
								mergeInputs,
								null,
								ECollections.emptyEList(),
								mergeOutputMIDsByName,
								mergeMID);
							mergedModelRels.add(composedModelRel1);
							mergedModelRels.add(composedModelRel2);
						}
						catch (Exception e) {
							MMINTException.print(
								IStatus.WARNING,
								"Operator " + mergeOperatorType + " execution error, skipping it",
								e);
						}
					}
				}
				if (nestingEnabled) {
					// exclude composed model rels that were merged
					intermediateModels.addAll(mergedModelRels);
				}
				else {
					// delete composed model rels that were merged
					for (ModelRel mergedModelRel : mergedModelRels) {
						try { mergedModelRel.deleteInstance(); } catch (MMINTException e) {}
					}
				}
			}
			catch (Exception e) {
				MMINTException.print(
					IStatus.WARNING,
					"Operator " + accumulatorOperatorType + " execution error, skipping it",
					e);
			}
			finally {
				if (nestingEnabled) {
					// exclude accumulator inputs
					intermediateModels.addAll(accumulatorInputModels);
					// prepare a new nested MID for the next iteration
					prevReducingMID = reducingMID;
					super.writeNestedInstanceMID();
					super.addNestedInstanceMID(this, this.getMIDContainer());
					reducingMID = super.getNestedInstanceMID();
				}
				else {
					// delete accumulator inputs (model rels are deleted as a side effect of deleting the models)
					// do it in case of failure too, because it will trigger an endless loop otherwise
					for (Model accumulatorInputModel : accumulatorInputModels) {
						try { accumulatorInputModel.deleteInstance(); } catch (MMINTException e) {}
					}
				}
			}
		}
		// delete intermediate output model files but the ones from last execution
		//TODO is this needed again?
		for (Model accumulatorOutputModelToDelete : accumulatorOutputModelsToDelete) {
			if (accumulatorOutputsByName != null &&
					accumulatorOutputsByName.values().contains(accumulatorOutputModelToDelete)) {
				continue;
			}
			for (Editor accumulatorOutputEditorToDelete : accumulatorOutputModelToDelete.getEditors()) {
				FileUtils.deleteFile(accumulatorOutputEditorToDelete.getUri(), true);
			}
			FileUtils.deleteFile(accumulatorOutputModelToDelete.getUri(), true);
		}

		return inputMID;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model inputMIDModel = inputsByName.get(IN_MID);
		Operator accumulatorOperatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MID instanceMID = outputMIDsByName.get(OUT_MID);

		// loop until reduction is no longer possible, reducing one input at a time
		boolean openEditors = Boolean.parseBoolean(
			MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED));
		if (openEditors) {
			MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED, "false");
		}
		MID reducedMID = this.reduce(inputMIDModel, accumulatorOperatorType);
		if (openEditors) {
			MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED, "true");
		}

		// output
		String reducedMIDModelPath = FileUtils.getUniquePath(
			FileUtils.addFileNameSuffixInPath(inputMIDModel.getUri(), REDUCED_MID_SUFFIX),
			true,
			false);
		Model reducedMIDModel = MIDTypeRegistry.getMIDModelType().createInstanceAndEditor(
			reducedMID, reducedMIDModelPath, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, reducedMIDModel);

		return outputsByName;
	}

}
