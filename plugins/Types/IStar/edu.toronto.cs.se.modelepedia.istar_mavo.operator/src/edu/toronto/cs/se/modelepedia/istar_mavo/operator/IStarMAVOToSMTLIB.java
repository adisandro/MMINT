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
package edu.toronto.cs.se.modelepedia.istar_mavo.operator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIBListener;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;

public class IStarMAVOToSMTLIB extends OperatorImpl {

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

	public enum AnalysisDirection {FORWARD, BACKWARD};

	private static final String PROPERTY_IN_ANALYSISDIRECTION = "analysisDirection";
	private static final AnalysisDirection PROPERTY_IN_ANALYSISDIRECTION_DEFAULT = AnalysisDirection.FORWARD;

	private EcoreMAVOToSMTLIBListener smtListener;
	private AnalysisDirection analysisDirection;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		analysisDirection = MultiModelOperatorUtils.getOptionalEnumProperty(inputProperties, PROPERTY_IN_ANALYSISDIRECTION, PROPERTY_IN_ANALYSISDIRECTION_DEFAULT, AnalysisDirection.class);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model istarModel = actualParameters.get(0);
		MAVOUtils.createFormulaVars(istarModel);

		List<Object> m2tArgs = new ArrayList<Object>();
		m2tArgs.add(istarModel.getName());
		switch (analysisDirection) {
		case BACKWARD:
			m2tArgs.add(false);
			break;
		case FORWARD:
		default:
			m2tArgs.add(true);
			break;
		}
		File folder = (new File(MultiModelUtils.prependWorkspaceToUri(istarModel.getUri()))).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		IStarMAVOToSMTLIB_M2T m2t = new IStarMAVOToSMTLIBWithListeners_M2T(istarModel.getEMFInstanceRoot(), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return actualParameters;
	}

	public Z3MAVOModelParser getZ3MAVOModelParser() {

		return smtListener.getZ3MAVOModelParser();
	}

}
