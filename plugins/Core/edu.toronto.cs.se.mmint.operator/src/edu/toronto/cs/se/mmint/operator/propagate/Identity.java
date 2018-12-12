/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.propagate;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class Identity extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "model";
	private final static @NonNull String OUT_MODEL = "sameModel";

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model model = inputsByName.get(IN_MODEL);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, model);

		return outputsByName;
	}

}
