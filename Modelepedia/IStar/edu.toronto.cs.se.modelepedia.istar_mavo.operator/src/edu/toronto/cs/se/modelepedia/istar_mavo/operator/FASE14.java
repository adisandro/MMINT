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

import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;

public class FASE14 extends RE13 {

	private static final String PROPERTY_OUT_TIMERNF = "timeRNF";

	protected Map<String, MAVOElement> mavoModelObjs;

	private long timeRNF;

	protected void initOutput() {

		super.initOutput();
		timeRNF = -1;
	}

	protected void writeProperties(Properties properties) {

		super.writeProperties(properties);
		properties.setProperty(PROPERTY_OUT_TIMERNF, String.valueOf(timeRNF));
	}

	private void doRNF() {

		long startTime = System.nanoTime();

		// foreach e : mavo element
		//  foreach a : annotation on e
		//   create equivalent smt constraint
		//   checkSatAndGetModelIncremental(model and previous constraint and not constraint, 1, 0)
		//   if (SAT)
		//    foreach e' : mavo element <> e
		//     foreach a' : annotation on e'
		//      if (concretization violates a')
		//       remove a' from e'
		//   else
		//    remove a from e

		timeRNF = System.nanoTime() - startTime;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// create list of mavo elements
		doRNF();
		return super.execute(actualParameters);
	}

}
