/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.z3;

public class Z3Utils {

	public static final String SMTLIB_FILE_EXTENSION = "smt2";
	public static final String SMTLIB_PREDICATE_START = "(";
	public static final String SMTLIB_PREDICATE_END = ")";
	public static final String SMTLIB_TRUE = " true ";
	public static final String SMTLIB_FALSE = " false ";
	public static final String SMTLIB_ASSERT = Z3Utils.SMTLIB_PREDICATE_START + "assert ";
	public static final String SMTLIB_EXISTS = Z3Utils.SMTLIB_PREDICATE_START + "exists ";
	public static final String SMTLIB_FORALL = Z3Utils.SMTLIB_PREDICATE_START + "forall ";
	public static final String SMTLIB_AND = Z3Utils.SMTLIB_PREDICATE_START + "and ";
	public static final String SMTLIB_OR = Z3Utils.SMTLIB_PREDICATE_START + "or ";
	public static final String SMTLIB_NOT = Z3Utils.SMTLIB_PREDICATE_START + "not ";
	public static final String SMTLIB_EQUALITY = Z3Utils.SMTLIB_PREDICATE_START + "= ";
	public static final String SMTLIB_IMPLICATION = Z3Utils.SMTLIB_PREDICATE_START + "=> ";
	public static final String SMTLIB_CONST = Z3Utils.SMTLIB_PREDICATE_START + "declare-const ";
	public static final String SMTLIB_TYPE_BOOL = "Bool";
	public static final String SMTLIB_TYPE_INT = "Int";

	public static final String Z3_MODEL_SEPARATOR = "!";

	public static String predicate(String predicateStart, String smtTerms) {

		return predicateStart + smtTerms + Z3Utils.SMTLIB_PREDICATE_END;
	}

	public static String emptyPredicate(String smtTerms) {

		return predicate(Z3Utils.SMTLIB_PREDICATE_START, smtTerms);
	}

	public static String assertion(String smtTerms) {

		return predicate(Z3Utils.SMTLIB_ASSERT, smtTerms);
	}

	public static String not(String smtTerms) {

		return predicate(Z3Utils.SMTLIB_NOT, smtTerms);
	}

	public static String and(String smtTerms) {

		return predicate(Z3Utils.SMTLIB_AND, smtTerms);
	}

	public static String or(String smtTerms) {

		return predicate(Z3Utils.SMTLIB_OR, smtTerms);
	}

	public static String constant(String smtConstantName, String smtConstantType) {

		return predicate(Z3Utils.SMTLIB_CONST, smtConstantName + " " + smtConstantType);
	}

	public static String equality(String smtTerms) {

		return predicate(Z3Utils.SMTLIB_EQUALITY, smtTerms);
	}

	public static String implication(String smtIfTerms, String smtThenTerms) {

		return predicate(Z3Utils.SMTLIB_IMPLICATION, smtIfTerms + smtThenTerms);
	}

	public static String exists(String smtQuantification, String smtTerms) {

		return predicate(
			Z3Utils.SMTLIB_EXISTS,
			Z3Utils.SMTLIB_PREDICATE_START + smtQuantification + Z3Utils.SMTLIB_PREDICATE_END + smtTerms
		);
	}

	public static String forall(String smtQuantification, String smtTerms) {

		return predicate(
			Z3Utils.SMTLIB_FORALL,
			Z3Utils.SMTLIB_PREDICATE_START + smtQuantification + Z3Utils.SMTLIB_PREDICATE_END + smtTerms
		);
	}

}
