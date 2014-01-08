/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.operator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.mavo.library.EcoreMAVOToSMTLIBListener;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;

public class IStarMAVOToSMTLIB extends OperatorExecutableImpl {

	public class IStarMAVOToSMTLIBWithListeners_M2T extends IStarMAVOToSMTLIB_M2T {

		public IStarMAVOToSMTLIBWithListeners_M2T(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {

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

		Model istarModel = actualParameters.get(0);

		List<Object> m2tArgs = new ArrayList<Object>();
		m2tArgs.add(istarModel.getName());
		File folder = (new File(MultiModelUtils.prependWorkspaceToUri(istarModel.getUri()))).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		IStarMAVOToSMTLIB_M2T m2t = new IStarMAVOToSMTLIBWithListeners_M2T(MultiModelTypeIntrospection.getRoot(istarModel), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return actualParameters;
	}

}
