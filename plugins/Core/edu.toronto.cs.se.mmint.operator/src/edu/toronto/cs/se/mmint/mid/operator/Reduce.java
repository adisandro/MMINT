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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
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
	private final static @NonNull String REDUCED_MID_SUFFIX = "_reduced";
	private final static @NonNull String MODELRELCOMPOSITION_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelComposition";

	private @NonNull MultiModel reduce(@NonNull Model inputMIDModel, @NonNull Operator accumulatorOperatorType)
			throws Exception {

		MultiModel reducedMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
		Map<String, MultiModel> operatorOutputMIDsByName = accumulatorOperatorType.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
				outputModelTypeEndpoint -> reducedMID));
		EList<MultiModel> inputMIDs = new BasicEList<>();
		inputMIDs.add(reducedMID);
		Set<EList<OperatorInput>> operatorInputSet;
		Set<Model> tempModelsToDelete = new HashSet<>();
		Map<String, Model> operatorOutputsByName = null;
		while (!(operatorInputSet = accumulatorOperatorType.findAllowedInputs(inputMIDs)).isEmpty()) {
			for (EList<OperatorInput> operatorInputs : operatorInputSet) {
				try {
					// get all model inputs, including the ones attached to model rel inputs
					Set<Model> inputModels = new HashSet<>();
					Set<ModelRel> inputModelRels = new HashSet<>();
					for (OperatorInput operatorInput : operatorInputs) {
						Model inputModel = operatorInput.getModel();
						if (inputModel instanceof ModelRel) {
							inputModels.addAll(((ModelRel) inputModel).getModelEndpoints().stream()
								.map(ModelEndpoint::getTarget)
								.collect(Collectors.toSet()));
							inputModelRels.add((ModelRel) inputModel);
						}
						else {
							inputModels.add(inputModel);
						}
					}
					// get all model rels attached to input models that are not inputs themselves
					Set<ModelRel> connectedModelRels = MultiModelRegistry.getModelRels(reducedMID).stream()
						.filter(modelRel -> !inputModelRels.contains(modelRel))
						.filter(modelRel -> !Collections.disjoint(
							inputModels,
							modelRel.getModelEndpoints().stream()
								.map(ModelEndpoint::getTarget)
								.collect(Collectors.toSet())))
						.collect(Collectors.toSet());
					// run the ACCUMULATOR operator
					operatorOutputsByName = accumulatorOperatorType.start(operatorInputs,
						operatorOutputMIDsByName, null);
					tempModelsToDelete.addAll(
						operatorOutputsByName.values().stream()
							.filter(outputModel -> !(outputModel instanceof ModelRel))
							.collect(Collectors.toSet()));
					// for each model rel in the output that is connected with the input models, do the composition
					Operator compOperatorType = MultiModelTypeRegistry.getType(MODELRELCOMPOSITION_OPERATORTYPE_URI);
					Map<String, MultiModel> compOperatorOutputMIDsByName = compOperatorType.getOutputs().stream()
						.collect(Collectors.toMap(
							outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
							outputModelTypeEndpoint -> reducedMID));
					for (ModelRel connectedModelRel : connectedModelRels) {
						for (Model outputModelRel : operatorOutputsByName.values()) {
							if (!(outputModelRel instanceof ModelRel)) {
								continue;
							}
							try {
								EList<OperatorInput> compOperatorInputs = new BasicEList<>();
								OperatorInput compOperatorInput1 = OperatorFactory.eINSTANCE.createOperatorInput();
								compOperatorInput1.setModel(connectedModelRel);
								compOperatorInput1.setModelTypeEndpoint(compOperatorType.getInputs().get(0));
								compOperatorInputs.add(compOperatorInput1);
								OperatorInput compOperatorInput2 = OperatorFactory.eINSTANCE.createOperatorInput();
								compOperatorInput2.setModel(outputModelRel);
								compOperatorInput2.setModelTypeEndpoint(compOperatorType.getInputs().get(1));
								compOperatorInputs.add(compOperatorInput2);
								compOperatorType.start(compOperatorInputs, compOperatorOutputMIDsByName, null);
							}
							catch (Exception e) {
								// use the composition operator itself to verify the two model rels have to be composed
							}
						}
					}
					// delete operator inputs (model rels are deleted as a side effect of deleting the models)
					inputModels.forEach(modelInput -> {
						try {
							modelInput.deleteInstance();
							//TODO MMINT[REDUCE] Remove intermediate model files
						}
						catch (MMINTException e) {}
					});
					// after a successful execution, go back to the outer loop
					break;
				}
				catch (Exception e) {
					// other than errors, the operator can fail because of input constraints due to the cartesian
					// product
					MMINTException.print(IStatus.WARNING, "Operator " + accumulatorOperatorType + " execution error, skipping it",
						e);
				}
			}
		}
		// delete intermediate model files but the ones from last execution
		for (Model tempModelToDelete : tempModelsToDelete) {
			if (operatorOutputsByName != null && operatorOutputsByName.values().contains(tempModelToDelete)) {
				continue;
			}
			for (Editor tempEditorToDelete : tempModelToDelete.getEditors()) {
				MultiModelUtils.deleteFile(tempEditorToDelete.getUri(), true);
			}
			MultiModelUtils.deleteFile(tempModelToDelete.getUri(), true);
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
