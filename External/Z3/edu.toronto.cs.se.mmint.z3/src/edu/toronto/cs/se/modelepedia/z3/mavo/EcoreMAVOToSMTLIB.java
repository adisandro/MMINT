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
package edu.toronto.cs.se.modelepedia.z3.mavo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class EcoreMAVOToSMTLIB extends OperatorImpl {

	public class EcoreMAVOToSMTLIBWithListeners_M2T extends EcoreMAVOToSMTLIB_M2T {

		public EcoreMAVOToSMTLIBWithListeners_M2T(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {

			super(model, targetFolder, arguments);
	    }

		@Override
	    public List<IAcceleoTextGenerationListener> getGenerationListeners() {

			List<IAcceleoTextGenerationListener> listeners = new ArrayList<IAcceleoTextGenerationListener>();
			smtListener = new EcoreMAVOToSMTLIBListener();
			listeners.add(smtListener);

			return listeners;
		}
	}

	private EcoreMAVOToSMTLIBListener smtListener;

	public EcoreMAVOToSMTLIBListener getListener() {

		return smtListener;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model mavoModel = actualParameters.get(0);

		List<Object> m2tArgs = new ArrayList<Object>();
		m2tArgs.add(mavoModel.getName());
		File folder = (new File(MultiModelUtils.prependWorkspaceToUri(mavoModel.getUri()))).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		EcoreMAVOToSMTLIB_M2T m2t = new EcoreMAVOToSMTLIBWithListeners_M2T(mavoModel.getEMFInstanceRoot(), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return actualParameters;
	}

	public void cleanup() {

		MultiModelUtils.deleteFile(smtListener.getSMTEncodingUri(), false);
	}

}
