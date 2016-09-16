/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.tutorial.operator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.modelepedia.operator.patch.ATLConversionOperator;
import edu.toronto.cs.se.modelepedia.tutorial.army.ArmyPackage;

public class EconomyToArmy extends ATLConversionOperator {

	// input-output
	private final static @NonNull String IN_MODEL = "economy";
	private final static @NonNull String OUT_MODEL = "army";

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		inputModel = inputsByName.get(IN_MODEL);
		MID instanceMID = outputMIDsByName.get(OUT_MODEL);

		// transform
		init(ArmyPackage.eNAME);
		EconomyToArmy_M2M atl = new EconomyToArmy_M2M();
		atl.loadModels(inputModel.getUri());
		atl.doEconomyToArmy_M2M(new NullProgressMonitor());
		atl.saveModels(convertedModelUri);

		// output
		super.createConvertedModel(ArmyPackage.eNS_URI, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, convertedModel);

		return outputsByName;
	}

}
