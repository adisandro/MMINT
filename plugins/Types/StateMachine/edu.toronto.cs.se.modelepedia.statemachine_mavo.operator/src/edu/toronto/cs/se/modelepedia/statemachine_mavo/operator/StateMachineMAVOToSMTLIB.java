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
package edu.toronto.cs.se.modelepedia.statemachine_mavo.operator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIBListener;

public class StateMachineMAVOToSMTLIB extends EcoreMAVOToSMTLIB {

	public class StateMachineMAVOToSMTLIBWithListeners_M2T extends StateMachineMAVOToSMTLIB_M2T {

		public StateMachineMAVOToSMTLIBWithListeners_M2T(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {

			super(model, targetFolder, arguments);
	    }

		@Override
	    public List<IAcceleoTextGenerationListener> getGenerationListeners() {

			List<IAcceleoTextGenerationListener> listeners = new ArrayList<>();
			smtListener = new EcoreMAVOToSMTLIBListener(mavoModelObjs, isMayOnly);
			listeners.add(smtListener);

			return listeners;
		}
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		Model smModel = inputsByName.get(IN_MODEL);

		mavoModelObjs = MAVOUtils.createFormulaVars(smModel);
		if (this.isMayOnly == null) {
			this.isMayOnly = MAVOUtils.isMayOnly(mavoModelObjs);
		}
		List<Object> m2tArgs = new ArrayList<Object>();
		m2tArgs.add(smModel.getName());
		File folder = (new File(MultiModelUtils.prependWorkspaceToUri(smModel.getUri()))).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		StateMachineMAVOToSMTLIB_M2T m2t = new StateMachineMAVOToSMTLIBWithListeners_M2T(smModel.getEMFInstanceRoot(), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return new HashMap<>();
	}

}
