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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Reduce extends OperatorImpl {

	@NonNull
	private final static String INPUT_MID = "inputMID";
	@NonNull
	private final static String OUTPUT_MID = "outputMID";
	@NonNull
	private final static String GENERIC_OPERATORTYPE = "OP";

	@NonNull
	private final static String REDUCE_MID_SUFFIX = "_reduce";
	@NonNull
	private final static String OPERATORTYPE_MODELRELCOMPOSITION_URI = "http://se.cs.toronto.edu/modelepedia/Operator_ModelRelComposition";

	private void reduceOperatorType(@NonNull Operator operatorType, @NonNull MultiModel outputMID) throws Exception {

		EList<MultiModel> inputMIDs = new BasicEList<>();
		inputMIDs.add(outputMID);
		Map<String, MultiModel> operatorOutputMIDsByName = operatorType.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
				outputModelTypeEndpoint -> outputMID));
		Set<EList<OperatorInput>> operatorInputSet;
		while (!(operatorInputSet = operatorType.findAllowedInputs(inputMIDs)).isEmpty()) {
			for (EList<OperatorInput> operatorInputs : operatorInputSet) {
				try {
					Map<String, Model> operatorOutputsByName = operatorType.start(operatorInputs,
						operatorOutputMIDsByName, null);
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
					// get all model rels attached to input models that are not inputs themselves..
					Set<ModelRel> connectedModelRels = MultiModelRegistry.getModelRels(outputMID).stream()
						.filter(modelRel -> !inputModelRels.contains(modelRel))
						.filter(modelRel -> !Collections.disjoint(
							inputModels,
							modelRel.getModelEndpoints().stream()
								.map(ModelEndpoint::getTarget)
								.collect(Collectors.toSet())))
						.collect(Collectors.toSet());
					// ..then for each model rel in the output that is connected with the input model, compute the
					// composition
					Operator compOperatorType = MultiModelTypeRegistry.getType(OPERATORTYPE_MODELRELCOMPOSITION_URI);
					Map<String, MultiModel> compOperatorOutputMIDsByName = compOperatorType.getOutputs().stream()
						.collect(Collectors.toMap(
							outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
							outputModelTypeEndpoint -> outputMID));
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
								compOperatorInput2.setModelTypeEndpoint(compOperatorType.getInputs().get(0));
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
						}
						catch (MMINTException e) {}
					});
					// after a successful execution, go back to the outer loop
					break;
				}
				catch (Exception e) {
					// other than errors, the operator can fail because of input constraints due to the cartesian
					// product
					MMINTException.print(IStatus.WARNING, "Operator " + operatorType + " execution error, skipping it",
						e);
				}
			}
		}
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MultiModel> outputMIDsByName)
		throws Exception {

		Model inputMIDModel = inputsByName.get(INPUT_MID);
		Operator operatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_MID);

		// loop until reduction is no longer possible, reducing one input at a time
		MultiModel outputMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
		reduceOperatorType(operatorType, outputMID);

		String outputMIDUri = MultiModelUtils.addFileNameSuffixInUri(inputMIDModel.getUri(), REDUCE_MID_SUFFIX);
		MultiModelUtils.createModelFile(outputMID, outputMIDUri, true);
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		Model outputMIDModel = midModelType.createInstanceAndEditor(outputMIDUri, ModelOrigin.CREATED, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUTPUT_MID, outputMIDModel);

		return outputsByName;
	}

}
