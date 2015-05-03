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

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class Reduce extends OperatorImpl {

	@NonNull
	private final static String INPUT_MID = "inputMID";
	@NonNull
	private final static String OUTPUT_MID = "outputMID";
	@NonNull
	private final static String GENERIC_OPERATORTYPE = "OP";

	@NonNull
	private final static String REDUCE_MID_SUFFIX = "_reduce";

	private EList<OperatorInput> getX() {

		//TODO MMINT[REDUCE] Look for the first available input (how do I navigate the mid?)
		EList<OperatorInput> inputs = new BasicEList<>();

		return inputs;
	}

	private void doY(Operator operatorType, EList<OperatorInput> operatorInputs, Map<String, MultiModel> operatorOutputMIDsByName) throws Exception {

		Map<String, Model> operatorOutputsByName = operatorType.start(
			operatorInputs,
			operatorOutputMIDsByName,
			null);
		//TODO MMINT[REDUCE] Compute composition of connected model rels + delete operatorInputs
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MultiModel> outputMIDsByName)
		throws Exception {

		Model inputMIDModel = inputsByName.get(INPUT_MID);
		Operator operatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_MID);

		// loop until reduction is no longer possible, reduce one input at a time
		MultiModel outputMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
		Map<String, MultiModel> operatorOutputMIDsByName = operatorType.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelTypeEndpoint -> outputModelTypeEndpoint.getName(),
				outputModelTypeEndpoint -> outputMID));
		EList<OperatorInput> operatorInputs;
		while ((operatorInputs = getX()) != null) {
			doY(operatorType, operatorInputs, operatorOutputMIDsByName);
		}
		String outputMIDUri = MultiModelUtils.addFileNameSuffixInUri(inputMIDModel.getUri(), REDUCE_MID_SUFFIX);
		MultiModelUtils.createModelFile(outputMID, outputMIDUri, true);
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		Model outputMIDModel = midModelType.createInstanceAndEditor(outputMIDUri, ModelOrigin.CREATED, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUTPUT_MID, outputMIDModel);

		return outputsByName;
	}

}
