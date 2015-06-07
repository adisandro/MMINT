/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class EcoreMAVOToSMTLIB extends OperatorImpl {

	private class EcoreMAVOToSMTLIBWithListeners_M2T extends EcoreMAVOToSMTLIB_M2T {

		public EcoreMAVOToSMTLIBWithListeners_M2T(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {

			super(model, targetFolder, arguments);
	    }

		@Override
	    public List<IAcceleoTextGenerationListener> getGenerationListeners() {

			List<IAcceleoTextGenerationListener> listeners = new ArrayList<IAcceleoTextGenerationListener>();
			smtListener = new EcoreMAVOToSMTLIBListener(mavoModelObjs, isMayOnly);
			listeners.add(smtListener);

			return listeners;
		}
	}

	// input-output
	private final static @NonNull String IN_MODEL = "mavo";
	private static final @NonNull String PROPERTY_IN_MAYONLY = "mayOnly";
	private static final @Nullable Boolean PROPERTY_IN_MAYONLY_DEFAULT = null;

	protected EcoreMAVOToSMTLIBListener smtListener;
	protected Map<String, MAVOElement> mavoModelObjs;
	protected Boolean isMayOnly;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		isMayOnly = MultiModelOperatorUtils.getOptionalBoolProperty(inputProperties, PROPERTY_IN_MAYONLY, PROPERTY_IN_MAYONLY_DEFAULT);
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		//TODO MMINT[REASONING] generalize for non-mavo too
		//TODO MMINT[REASONING] refactor common code/encoding for mayOnly and not
		//TODO MMINT[REASONING] improve create formula vars 1) use other strings if name not present 2) check uniqueness 3) use names of src/tgt for edges

		// input
		Model mavoModel = inputsByName.get(IN_MODEL);

		mavoModelObjs = MAVOUtils.createFormulaVars(mavoModel);
		if (this.isMayOnly == null) {
			this.isMayOnly = MAVOUtils.isMayOnly(mavoModelObjs);
		}
		List<Object> m2tArgs = new ArrayList<Object>();
		m2tArgs.add(mavoModel.getName());
		m2tArgs.add(this.isMayOnly);
		File folder = (new File(MultiModelUtils.prependWorkspaceToUri(mavoModel.getUri()))).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		EcoreMAVOToSMTLIB_M2T m2t = new EcoreMAVOToSMTLIBWithListeners_M2T(mavoModel.getEMFInstanceRoot(), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return new HashMap<>();
	}

	//TODO MMINT[OPERATOR] Make cleanup() part of the api
	public void cleanup() {

		MultiModelUtils.deleteFile(smtListener.getZ3MAVOModelParser().getSMTLIBEncodingUri(), false);
	}

	public @NonNull Z3MAVOModelParser getZ3MAVOModelParser() {

		return smtListener.getZ3MAVOModelParser();
	}

}
