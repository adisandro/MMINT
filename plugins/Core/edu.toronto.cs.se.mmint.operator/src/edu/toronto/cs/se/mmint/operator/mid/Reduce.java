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
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
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
	private final static @NonNull String REDUCED_MID_SUFFIX = "_reduced";
	private final static @NonNull String MODELRELCOMPOSITION_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelComposition";
	private final static @NonNull String MODELRELMERGE_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelMerge";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedGeneric(@NonNull GenericEndpoint genericTypeEndpoint, @NonNull GenericElement genericType, @NonNull List<OperatorInput> inputs) {

			final String FILTER_URI = "http://se.cs.toronto.edu/mmint/Operator_Filter";
			final String MAP_URI = "http://se.cs.toronto.edu/mmint/Operator_Map";
			final String REDUCE_URI = "http://se.cs.toronto.edu/mmint/Operator_Reduce";
			if (genericType.getUri().equals(FILTER_URI) || genericType.getUri().equals(MAP_URI) || genericType.getUri().equals(REDUCE_URI)) {
				return false;
			}

			return true;
		}
	}

	private @NonNull Set<ModelRel> getConnectedModelRels(@NonNull MID instanceMID, @NonNull Set<Model> models, @NonNull Set<ModelRel> modelRelBlacklist) {

		//TODO MMINT[OO] This is expensive, need a direct way to reach model rels from models
		Set<ModelRel> connectedModelRels = instanceMID.getModelRels().stream()
			.filter(modelRel -> !modelRelBlacklist.contains(modelRel))
			.filter(modelRel -> modelRel.getModelEndpoints().stream()
				.anyMatch(modelEndpoint -> models.contains(modelEndpoint.getTarget())))
			.collect(Collectors.toSet());

		return connectedModelRels;
	}

	private @NonNull MID reduce(@NonNull Model inputMIDModel, @NonNull Operator accumulatorOperatorType)
			throws Exception {

		MID reducedMID = (MID) inputMIDModel.getEMFInstanceRoot();
		String nestedMIDPath = super.getNestedMIDPath();
		Operator compositionOperatorType = MIDTypeRegistry.getType(MODELRELCOMPOSITION_OPERATORTYPE_URI);
		Operator mergeOperatorType = MIDTypeRegistry.getType(MODELRELMERGE_OPERATORTYPE_URI);
		// reduce loop
		EList<OperatorInput> accumulatorInputs;
		Map<String, Model> accumulatorOutputsByName = null;
		Set<Model> accumulatorOutputModels = new HashSet<>();
		Set<Model> intermediateModelsAndRels = new HashSet<>();
		int i = 0;
        //TODO MMINT[POLY] Reduce should support multiple dispatch, trying the first allowed input from the most specific operator
		while ((accumulatorInputs = accumulatorOperatorType.findFirstAllowedInput(
				ECollections.newBasicEList(reducedMID),
				ECollections.<Set<Model>>newBasicEList(intermediateModelsAndRels))
		) != null) {
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
				// get all model rels attached to input models that are not inputs themselves or intermediate artifacts
				Set<ModelRel> modelRelBlacklist = Stream.concat(
					accumulatorInputModelRels.stream(),
					intermediateModelsAndRels.stream()
						.filter(modelRel -> modelRel instanceof ModelRel)
						.map(modelRel -> (ModelRel) modelRel))
					.collect(Collectors.toSet());
				Set<ModelRel> connectedModelRels = this.getConnectedModelRels(reducedMID, accumulatorInputModels, modelRelBlacklist);
				// run the ACCUMULATOR operator
				Map<String, MID> accumulatorOutputMIDsByName = MIDOperatorIOUtils
						.createSameOutputMIDsByName(accumulatorOperatorType, reducedMID);
				EList<OperatorGeneric> accumulatorGenerics = accumulatorOperatorType.selectAllowedGenerics(
					accumulatorInputs);
				Operator accumulatorOperator = accumulatorOperatorType.startInstance(
					accumulatorInputs,
					null,
					accumulatorGenerics,
					accumulatorOutputMIDsByName,
					(nestedMIDPath != null) ? reducedMID : null);
				accumulatorOperator.setName(accumulatorOperator.getName() + i);
				accumulatorOutputsByName = accumulatorOperator.getOutputsByName();
				accumulatorOutputModels.addAll(
					accumulatorOutputsByName.values().stream()
						.filter(model -> !(model instanceof ModelRel))
						.collect(Collectors.toSet()));
				// for each model rel in the output that is connected with the input models, do the composition
				Map<String, MID> compositionOutputMIDsByName = MIDOperatorIOUtils
						.createSameOutputMIDsByName(compositionOperatorType, reducedMID);
				List<ModelRel> compositeModelRels = new ArrayList<>();
				for (ModelRel connectedModelRel : connectedModelRels) {
					for (Model accumulatorOutputModelRel : accumulatorOutputsByName.values()) {
						if (!(accumulatorOutputModelRel instanceof ModelRel)) {
							continue;
						}
						try {
							EList<OperatorInput> compositionInputs = compositionOperatorType.checkAllowedInputs(
								ECollections.newBasicEList(connectedModelRel, accumulatorOutputModelRel));
							if (compositionInputs == null) {
								continue;
							}
							Operator compositionOperator = compositionOperatorType.startInstance(
								compositionInputs,
								null,
								ECollections.emptyEList(),
								compositionOutputMIDsByName,
								(nestedMIDPath != null) ? reducedMID : null);
							if (nestedMIDPath != null) {
								compositionOperator.setName(compositionOperator.getName() + i);
							}
							Map<String, Model> compositionOutputsByName = compositionOperator.getOutputsByName();
							compositeModelRels.add((ModelRel) compositionOutputsByName.get(
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
						.createSameOutputMIDsByName(mergeOperatorType, reducedMID);
				Set<ModelRel> mergedModelRels = new HashSet<>();
				for (int j = 0; j < compositeModelRels.size(); j++) {
					ModelRel compositeModelRel1 = compositeModelRels.get(j);
					for (int k = j+1; k < compositeModelRels.size(); k++) {
						ModelRel compositeModelRel2 = compositeModelRels.get(k);
						try {
							EList<OperatorInput> mergeInputs = mergeOperatorType.checkAllowedInputs(
								ECollections.newBasicEList(compositeModelRel1, compositeModelRel2));
							if (mergeInputs == null) {
								continue;
							}
							Operator mergeOperator = mergeOperatorType.startInstance(
								mergeInputs,
								null,
								ECollections.emptyEList(),
								mergeOutputMIDsByName,
								(nestedMIDPath != null) ? reducedMID : null);
							if (nestedMIDPath != null) {
								mergeOperator.setName(mergeOperator.getName() + i);
							}
							mergedModelRels.add(compositeModelRel1);
							mergedModelRels.add(compositeModelRel2);
						}
						catch (Exception e) {
							MMINTException.print(
								IStatus.WARNING,
								"Operator " + mergeOperatorType + " execution error, skipping it",
								e);
						}
					}
				}
				if (nestedMIDPath != null) {
					// exclude composed model rels that were merged
					intermediateModelsAndRels.addAll(mergedModelRels);
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
			finally { // even in case of failure, some actions must be taken to prevent endless loops
				if (nestedMIDPath != null) {
					// exclude accumulator inputs
					intermediateModelsAndRels.addAll(accumulatorInputModels);
					intermediateModelsAndRels.addAll(accumulatorInputModelRels);
					// exclude connected model rels, composed included (don't bother creating a blacklist, it's a set)
					intermediateModelsAndRels.addAll(
						this.getConnectedModelRels(reducedMID, accumulatorInputModels, new HashSet<>()));
				}
				else {
					// delete accumulator inputs (connected model rels are deleted as a side effect of deleting the models, composed included)
					for (Model accumulatorInputModel : accumulatorInputModels) {
						try {
							if (accumulatorOutputModels.contains(accumulatorInputModel)) { // intermediate artifact
								accumulatorInputModel.deleteInstanceAndFile();
								accumulatorOutputModels.remove(accumulatorInputModel);
							}
							else { // initial input
								accumulatorInputModel.deleteInstance();
							}
						}
						catch (MMINTException e) {}
					}
				}
				i++;
			}
		}
		if (nestedMIDPath != null) {
			super.inMemoryNestedMID = reducedMID;
			super.writeNestedInstanceMID();
			Set<Model> reducedModels = accumulatorOutputModels.stream()
			    .filter(outputModel -> !intermediateModelsAndRels.contains(outputModel))
			    .collect(Collectors.toSet());
			Set<ModelRel> intermediateModelRels = intermediateModelsAndRels.stream()
                .filter(modelRel -> modelRel instanceof ModelRel)
                .map(modelRel -> (ModelRel) modelRel)
                .collect(Collectors.toSet());
			reducedModels.addAll(this.getConnectedModelRels(reducedMID, reducedModels, intermediateModelRels));
			//TODO MMINT[NESTED] Transform input/output into shortcuts
			reducedMID = MIDFactory.eINSTANCE.createMID();
			reducedMID.setLevel(MIDLevel.INSTANCES);
			for (Model reducedModel : reducedModels) {
				if (reducedModel instanceof ModelRel) {
					continue;
				}
				reducedModel.getMetatype().importInstanceAndEditor(reducedModel.getUri(), reducedMID);
			}
			for (Model reducedModelRel : reducedModels) {
				if (!(reducedModelRel instanceof ModelRel)) {
					continue;
				}
				((ModelRel) reducedModelRel).getMetatype().copyInstance(reducedModelRel, reducedModelRel.getName(), reducedMID);
			}
		}

		return reducedMID;
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
