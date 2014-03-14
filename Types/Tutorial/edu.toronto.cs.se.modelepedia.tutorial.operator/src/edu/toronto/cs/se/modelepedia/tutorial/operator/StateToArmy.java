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
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.tutorial.army.ArmyPackage;

public class StateToArmy extends ATLConversion {

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model stateModel = actualParameters.get(0);
		String newArmyModelUri = MultiModelUtils.replaceFileExtensionInUri(stateModel.getUri(), ArmyPackage.eNAME);
		StateToArmy_M2M atl = new StateToArmy_M2M();
		atl.loadModels(stateModel.getUri());
		atl.doStateToArmy_M2M(new NullProgressMonitor());
		atl.saveModels(newArmyModelUri);

		return super.x(stateModel, ArmyPackage.eNS_URI, newArmyModelUri);
	}

}
