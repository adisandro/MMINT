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

import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIBListener;

public class IStarMAVOToSMTLIB extends EcoreMAVOToSMTLIB {

	public class IStarMAVOToSMTLIBWithListeners_M2T extends IStarMAVOToSMTLIB_M2T {

		public IStarMAVOToSMTLIBWithListeners_M2T(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {

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

	public enum AnalysisDirection {FORWARD, BACKWARD};

	private static final @NonNull String PROPERTY_IN_ANALYSISDIRECTION = "analysisDirection";
	private static final @NonNull AnalysisDirection PROPERTY_IN_ANALYSISDIRECTION_DEFAULT = AnalysisDirection.FORWARD;

	private AnalysisDirection analysisDirection;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		analysisDirection = MultiModelOperatorUtils.getOptionalEnumProperty(inputProperties, PROPERTY_IN_ANALYSISDIRECTION, PROPERTY_IN_ANALYSISDIRECTION_DEFAULT, AnalysisDirection.class);
	}

	@Override
	protected List<Object> createAcceleoArguments(Model mavoModel) {

		List<Object> m2tArgs = super.createAcceleoArguments(mavoModel);
		switch (analysisDirection) {
		case BACKWARD:
			m2tArgs.add(false);
			break;
		case FORWARD:
		default:
			m2tArgs.add(true);
			break;
		}

		return m2tArgs;
	}

	@Override
	protected AbstractAcceleoGenerator createAcceleoGenerator(MAVOModel rootMavoModelObj, File folder, List<Object> m2tArgs) throws IOException {

		return new IStarMAVOToSMTLIBWithListeners_M2T(rootMavoModelObj, folder, m2tArgs);
	}

}
