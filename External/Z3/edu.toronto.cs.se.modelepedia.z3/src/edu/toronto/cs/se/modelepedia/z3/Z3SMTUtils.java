/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import com.microsoft.z3.Model;
import com.microsoft.z3.Status;

public class Z3SMTUtils {

	public static final String SMTLIB_FILE_EXTENSION = "smt2";
	public static final String SMTLIB_PREDICATE_START = "(";
	public static final String SMTLIB_PREDICATE_END = ")";
	public static final String SMTLIB_TRUE = " true ";
	public static final String SMTLIB_FALSE = " false ";
	public static final String SMTLIB_ASSERT = SMTLIB_PREDICATE_START + "assert ";
	public static final String SMTLIB_EXISTS = SMTLIB_PREDICATE_START + "exists ";
	public static final String SMTLIB_FORALL = SMTLIB_PREDICATE_START + "forall ";
	public static final String SMTLIB_AND = SMTLIB_PREDICATE_START + "and ";
	public static final String SMTLIB_OR = SMTLIB_PREDICATE_START + "or ";
	public static final String SMTLIB_NOT = SMTLIB_PREDICATE_START + "not ";
	public static final String SMTLIB_EQUALITY = SMTLIB_PREDICATE_START + "= ";
	public static final String SMTLIB_IMPLICATION = SMTLIB_PREDICATE_START + "=> ";
	public static final String SMTLIB_CONST = SMTLIB_PREDICATE_START + "declare-const ";
	public static final String SMTLIB_TYPE_BOOL = "Bool";

	public static final String Z3_MODEL_SEPARATOR = "!";
	public static final String Z3_MODEL_DEFINITION = " -> ";
	public static final String Z3_MODEL_ELSE = "else";
	public static final String Z3_MODEL_FUNCTION_START = "{";
	public static final String Z3_MODEL_FUNCTION_END = "}";
	public static final String Z3_MODEL_NEWLINE = "\n";

	public enum Z3BoolResult {

		SAT, UNSAT, UNKNOWN;

		public static Z3BoolResult toZ3BoolResult(Status z3Status) {

			switch (z3Status) {
				case UNSATISFIABLE:
					return UNSAT;
				case SATISFIABLE:
					return SAT;
				default:
					return UNKNOWN;
			}
		}

	}

	public static class Z3ModelResult {

		private Z3BoolResult z3BoolResult;
		private Model z3Model;

		public Z3ModelResult(Z3BoolResult z3BoolResult, Model z3Model) {
			this.z3BoolResult = z3BoolResult;
			this.z3Model = z3Model;
		}

		public Z3ModelResult(Status z3Status, Model z3Model) {
			this.z3BoolResult = Z3BoolResult.toZ3BoolResult(z3Status);
			this.z3Model = z3Model;
		}

		public Z3BoolResult getZ3BoolResult() {
			return z3BoolResult;
		}

		public Model getZ3Model() {
			return z3Model;
		}
	}

	public static String predicate(String predicateStart, String smtTerms) {

		return predicateStart + smtTerms + SMTLIB_PREDICATE_END;
	}

	public static String emptyPredicate(String smtTerms) {

		return predicate(SMTLIB_PREDICATE_START, smtTerms);
	}

	public static String assertion(String smtTerms) {

		return predicate(SMTLIB_ASSERT, smtTerms);
	}

	public static String not(String smtTerms) {

		return predicate(SMTLIB_NOT, smtTerms);
	}

	public static String and(String smtTerms) {

		return predicate(SMTLIB_AND, smtTerms);
	}

	public static String or(String smtTerms) {

		return predicate(SMTLIB_OR, smtTerms);
	}

	public static String equality(String smtTerms) {

		return predicate(SMTLIB_EQUALITY, smtTerms);
	}

	public static String implication(String smtIfTerms, String smtThenTerms) {

		return predicate(SMTLIB_IMPLICATION, smtIfTerms + smtThenTerms);
	}

	public static String exists(String smtQuantification, String smtTerms) {

		return predicate(
			SMTLIB_EXISTS,
			SMTLIB_PREDICATE_START + smtQuantification + SMTLIB_PREDICATE_END + smtTerms
		);
	}

	public static String forall(String smtQuantification, String smtTerms) {

		return predicate(
			SMTLIB_FORALL,
			SMTLIB_PREDICATE_START + smtQuantification + SMTLIB_PREDICATE_END + smtTerms
		);
	}

}
