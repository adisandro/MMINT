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
package edu.toronto.cs.se.modelepedia.operator.merge;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class ModelRelComposition extends OperatorImpl {

	@NonNull
	private final static String INPUT_MODELREL1 = "rel1";
	@NonNull
	private final static String INPUT_MODELREL2 = "rel2";
	@NonNull
	private final static String OUTPUT_COMPOSEDMODELREL = "composedRel";

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MultiModel> outputMIDsByName)
		throws Exception {

		ModelRel modelRel1 = (ModelRel) inputsByName.get(INPUT_MODELREL1);
		ModelRel modelRel2 = (ModelRel) inputsByName.get(INPUT_MODELREL2);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_COMPOSEDMODELREL);

		Map<String, Model> outputsByName = new HashMap<>();

		return outputsByName;
	}

}
