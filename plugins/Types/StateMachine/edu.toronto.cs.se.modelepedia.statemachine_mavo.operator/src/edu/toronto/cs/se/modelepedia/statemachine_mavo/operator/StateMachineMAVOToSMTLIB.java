/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.List;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreToSMTLIB;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreToSMTLIBListener;

public class StateMachineMAVOToSMTLIB extends EcoreToSMTLIB {

	public class StateMachineMAVOToSMTLIBWithListeners_M2T extends StateMachineMAVOToSMTLIB_M2T {

		public StateMachineMAVOToSMTLIBWithListeners_M2T(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {

			super(model, targetFolder, arguments);
	    }

		@Override
	    public List<IAcceleoTextGenerationListener> getGenerationListeners() {

			List<IAcceleoTextGenerationListener> listeners = new ArrayList<>();
			smtListener = new EcoreToSMTLIBListener(mavoModelObjs, isMayOnly);
			listeners.add(smtListener);

			return listeners;
		}
	}

	@Override
	protected AbstractAcceleoGenerator createAcceleoGenerator(MAVORoot rootMavoModelObj, File folder, List<Object> m2tArgs) throws IOException {

		return new StateMachineMAVOToSMTLIBWithListeners_M2T(rootMavoModelObj, folder, m2tArgs);
	}

}
