/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

public class IStarMAVOToSMTLIB extends OperatorExecutableImpl {

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model istarModel = actualParameters.get(0);

		// generate smt-lib representation of the random model
		List<Object> m2tArgs = new ArrayList<Object>();
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		File folder = (new File(workspaceUri + istarModel.getUri())).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		IStarMAVOToSMTLIB_M2T m2t = new IStarMAVOToSMTLIB_M2T(MultiModelTypeIntrospection.getRoot(istarModel), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return actualParameters;
	}

}
