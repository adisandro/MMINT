/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.ATLConversion;
import edu.toronto.cs.se.modelepedia.tutorial.army.ArmyPackage;
import edu.toronto.cs.se.modelepedia.tutorial.economy.EconomyPackage;

public class StateToEconomy extends ATLConversion {

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		init(actualParameters, EconomyPackage.eNAME);
		StateToEconomy_M2M atl = new StateToEconomy_M2M();
		atl.loadModels(inputModel.getUri());
		atl.doStateToEconomy_M2M(new NullProgressMonitor());
		atl.saveModels(convertedModelUri);

		return super.createConvertedModel(ArmyPackage.eNS_URI);
	}

}
