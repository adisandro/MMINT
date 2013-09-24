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
import org.eclipse.acceleo.engine.event.AcceleoTextGenerationEvent;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;

public class IStarMAVOToSMTLIB extends OperatorExecutableImpl {

	public class IStarMAVOToSMTLIB_M2TWithListeners extends IStarMAVOToSMTLIB_M2T {

		public class IStarMAVOToSMTLIBListener implements IAcceleoTextGenerationListener {

			private StringBuilder textGeneration;

			public IStarMAVOToSMTLIBListener() {

				textGeneration = new StringBuilder();
			}

			@Override
			public void textGenerated(AcceleoTextGenerationEvent event) {

				textGeneration.append(event.getText());
			}

			@Override
			public void filePathComputed(AcceleoTextGenerationEvent event) {
			}

			@Override
			public void fileGenerated(AcceleoTextGenerationEvent event) {

				smtEncoding = textGeneration.toString();
			}

			@Override
			public void generationEnd(AcceleoTextGenerationEvent event) {
			}

			@Override
			public boolean listensToGenerationEnd() {
				return false;
			}
			
		}

		public IStarMAVOToSMTLIB_M2TWithListeners(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {

			super(model, targetFolder, arguments);
	    }

		@Override
	    public List<IAcceleoTextGenerationListener> getGenerationListeners() {

			List<IAcceleoTextGenerationListener> listeners = new ArrayList<IAcceleoTextGenerationListener>();
			listeners.add(new IStarMAVOToSMTLIBListener());

			return listeners;
		}
	}

	private String smtEncoding;

	public String getSMTEncoding() {

		return smtEncoding;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model istarModel = actualParameters.get(0);

		// generate smt-lib representation of the random model
		List<Object> m2tArgs = new ArrayList<Object>();
		m2tArgs.add(istarModel.getName());
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		File folder = (new File(workspaceUri + istarModel.getUri())).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		IStarMAVOToSMTLIB_M2T m2t = new IStarMAVOToSMTLIB_M2TWithListeners(MultiModelTypeIntrospection.getRoot(istarModel), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return actualParameters;
	}

}
