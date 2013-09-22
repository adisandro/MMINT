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
package edu.toronto.cs.se.modelepedia.operator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTSolver;

public class ModelepediaOperatorActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {

		System.setProperty(Z3SMTSolver.PROPERTY_LIBRARY_PATH, Z3SMTSolver.LIBRARY_PATH);
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		// do nothing
	}

}
