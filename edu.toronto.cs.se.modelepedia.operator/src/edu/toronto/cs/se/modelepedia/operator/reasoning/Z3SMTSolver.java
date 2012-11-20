/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.reasoning;

import org.eclipse.emf.common.util.EList;

import com.sun.jna.Library;
import com.sun.jna.Native;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;

public class Z3SMTSolver extends OperatorExecutableImpl {

	private static final String Z3_LIBRARY_NAME = "z3";
	private static final String OPERATOR_LIBRARY_NAME = "Z3SMTSolver";
	private static final String Z3_LIBRARY_PATH = "/usr/lib";

	public interface CLibrary extends Library {

		CLibrary Z3_INSTANCE = (CLibrary) Native.loadLibrary(Z3_LIBRARY_NAME, CLibrary.class);
		CLibrary OPERATOR_INSTANCE = (CLibrary) Native.loadLibrary(OPERATOR_LIBRARY_NAME, CLibrary.class);

		int checkSat(String smtString);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		System.setProperty("jna.library.path", Z3_LIBRARY_PATH);

		String test = "";
		int x = CLibrary.OPERATOR_INSTANCE.checkSat(test);
		System.err.println(x);

		return actualParameters;
	}

}
