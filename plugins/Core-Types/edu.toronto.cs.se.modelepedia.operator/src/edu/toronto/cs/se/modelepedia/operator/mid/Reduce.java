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

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class Reduce extends OperatorImpl {

	@NonNull
	private final static String INPUT_MID = "inputMID";
	@NonNull
	private final static String OUTPUT_MID = "outputMID";
	@NonNull
	private final static String GENERIC_OPERATORTYPE = "OP";

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MultiModel> outputMIDsByName)
		throws Exception {

		Model inputMIDModel = inputsByName.get(INPUT_MID);
		Operator operatorType = (Operator) genericsByName.get(GENERIC_OPERATORTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_MID);

		/*
		 * TODO
		 * Let's skip the in-place debate for now and just work on a copy of the input model as output:
		 * 1) Look for inputs to OP in a while loop
		 * 2) Execute OP
		 * 3) Compute composition of model rels for inputs and outputs of OP -> need ModelRelComposition operator
		 * 4) Delete inputs of OP
		 */

		Map<String, Model> outputsByName = new HashMap<>();

		return outputsByName;
	}

}
