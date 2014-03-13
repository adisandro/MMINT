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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorImpl;
import edu.toronto.cs.se.modelepedia.tutorial.army.ArmyPackage;

public class StateToArmy extends ConversionOperatorImpl {

	private Model newArmyModel;

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model stateModel = actualParameters.get(0);
		String newArmyModelUri = MultiModelUtils.replaceFileExtensionInUri(stateModel.getUri(), ArmyPackage.eNAME);
		StateToArmy_M2M atl = new StateToArmy_M2M();
		atl.loadModels(stateModel.getUri());
		atl.doStateToArmy_M2M(new NullProgressMonitor());
		atl.saveModels(newArmyModelUri);

		MultiModel multiModel = MultiModelRegistry.getMultiModel(stateModel);
		Model armyModelType = MultiModelTypeRegistry.getType(ArmyPackage.eNS_URI);
		newArmyModel = armyModelType.createMAVOInstanceAndEditor(newArmyModelUri, ModelOrigin.CREATED, multiModel);
		EList<Model> result = new BasicEList<Model>();
		result.add(newArmyModel);

		return result;
	}

	@Override
	public void cleanup() throws Exception {

		if (newArmyModel != null) {
			MultiModelUtils.deleteModelFile(newArmyModel);
			newArmyModel = null;
		}
	}

}
