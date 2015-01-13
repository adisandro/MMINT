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
package edu.toronto.cs.se.modelepedia.tutorial.operator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.ATLConversion;
import edu.toronto.cs.se.modelepedia.tutorial.army.ArmyPackage;

public class StateToArmy extends ATLConversion {

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		init(actualParameters, ArmyPackage.eNAME);
		StateToArmy_M2M atl = new StateToArmy_M2M();
		atl.loadModels(inputModel.getUri());
		atl.doStateToArmy_M2M(new NullProgressMonitor());
		atl.saveModels(convertedModelUri);

		return super.createConvertedModel(ArmyPackage.eNS_URI);
	}

}
