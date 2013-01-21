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

import java.util.ArrayList;
import java.util.List;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public interface Z3SMTSolver {

	public static final String Z3_LIBRARY_NAME = "z3";
	public static final String OPERATOR_LIBRARY_NAME = "Z3SMTSolver";
	public static final String LIBRARY_PATH = "/usr/lib";
	public static final String PROPERTY_LIBRARY_PATH = "jna.library.path";

	public static final String SMTLIB_PREDICATE_START = "(";
	public static final String SMTLIB_PREDICATE_END = ")";
	public static final String SMTLIB_TRUE = " true ";
	public static final String SMTLIB_FALSE = " false ";
	public static final String SMTLIB_ASSERT = SMTLIB_PREDICATE_START + "assert";
	public static final String SMTLIB_FORALL = SMTLIB_PREDICATE_START + "forall";
	public static final String SMTLIB_AND = SMTLIB_PREDICATE_START + "and";
	public static final String SMTLIB_OR = SMTLIB_PREDICATE_START + "or";
	public static final String SMTLIB_NOT = SMTLIB_PREDICATE_START + "not";
	public static final String SMTLIB_IMPLICATION = SMTLIB_PREDICATE_START + "=>";

	public interface CLibrary extends Library {

		public static final CLibrary Z3_INSTANCE = (CLibrary) Native.loadLibrary(Z3_LIBRARY_NAME, CLibrary.class);
		public static final CLibrary OPERATOR_INSTANCE = (CLibrary) Native.loadLibrary(OPERATOR_LIBRARY_NAME, CLibrary.class);

		public class Z3Result extends Structure {

			public int flag;
			public Pointer model;

			@Override
			@SuppressWarnings("rawtypes")
			protected List getFieldOrder() {
				List<String> fields = new ArrayList<String>();
				fields.add("flag");
				fields.add("model");
				return fields;
			}
		}

		public class Z3IncResult extends Structure {

			public int flag;
			public Pointer model;
			public Pointer contextPointer;
			public Pointer solverPointer;
			public Pointer modelPointer;

			@Override
			@SuppressWarnings("rawtypes")
			protected List getFieldOrder() {
				List<String> fields = new ArrayList<String>();
				fields.add("flag");
				fields.add("model");
				fields.add("contextPointer");
				fields.add("solverPointer");
				fields.add("modelPointer");
				return fields;
			}
		}

		public int checkSat(String smtEncoding);
		public Z3Result checkSatAndGetModel(String smtEncoding);
		public void freeResult(Z3Result result);
		public Z3IncResult firstCheckSatAndGetModelIncremental(String smtEncoding);
		public void checkSatAndGetModelIncremental(Z3IncResult incResult, String smtEncoding, int removeLastAssertion);
		public void freeResultIncremental(Z3IncResult incResult);
	}

}
