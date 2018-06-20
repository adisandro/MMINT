/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.jdt.annotation.NonNull;

public class Z3Utils {

	public static final @NonNull String SMTLIB_FILE_EXTENSION = "smt2";
	public static final @NonNull String SMTLIB_PREDICATE_START = "(";
	public static final @NonNull String SMTLIB_PREDICATE_END = ")";
	public static final @NonNull String SMTLIB_TRUE = " true ";
	public static final @NonNull String SMTLIB_FALSE = " false ";
	public static final @NonNull String SMTLIB_ASSERT = SMTLIB_PREDICATE_START + "assert ";
	public static final @NonNull String SMTLIB_EXISTS = SMTLIB_PREDICATE_START + "exists ";
	public static final @NonNull String SMTLIB_FORALL = SMTLIB_PREDICATE_START + "forall ";
	public static final @NonNull String SMTLIB_AND = SMTLIB_PREDICATE_START + "and ";
	public static final @NonNull String SMTLIB_OR = SMTLIB_PREDICATE_START + "or ";
	public static final @NonNull String SMTLIB_NOT = SMTLIB_PREDICATE_START + "not ";
	public static final @NonNull String SMTLIB_EQUALITY = SMTLIB_PREDICATE_START + "= ";
	public static final @NonNull String SMTLIB_IMPLICATION = SMTLIB_PREDICATE_START + "=> ";
	public static final @NonNull String SMTLIB_CONST = SMTLIB_PREDICATE_START + "declare-const ";
	public static final @NonNull String SMTLIB_TYPE_BOOL = "Bool";
	public static final @NonNull String SMTLIB_TYPE_INT = "Int";

	public static final @NonNull String SMTLIB_NODE = "node";
	public static final @NonNull String SMTLIB_EDGE = "edge";
	public static final @NonNull String SMTLIB_NODE_FUNCTION = SMTLIB_PREDICATE_START + SMTLIB_NODE + " ";
	public static final @NonNull String SMTLIB_EDGE_FUNCTION = SMTLIB_PREDICATE_START + SMTLIB_EDGE + " ";
	public static final @NonNull String SMTLIB_CONCRETIZATION = "c";
	public static final @NonNull String SMTLIB_CONCRETIZATION_QUANTIFIER = SMTLIB_PREDICATE_START + SMTLIB_CONCRETIZATION + " ";

	public static final @NonNull String Z3_MODEL_SEPARATOR = "!";

	public static @NonNull String predicate(@NonNull String predicateStart, @NonNull String smtTerms) {

		return predicateStart + smtTerms + SMTLIB_PREDICATE_END;
	}

	public static @NonNull String emptyPredicate(@NonNull String smtTerms) {

		return predicate(SMTLIB_PREDICATE_START, smtTerms);
	}

	public static @NonNull String assertion(@NonNull String smtTerms) {

		return predicate(SMTLIB_ASSERT, smtTerms);
	}

	public static @NonNull String not(@NonNull String smtTerms) {

		return predicate(SMTLIB_NOT, smtTerms);
	}

	public static @NonNull String and(@NonNull String smtTerms) {

		return predicate(SMTLIB_AND, smtTerms);
	}

	public static @NonNull String or(@NonNull String smtTerms) {

		return predicate(SMTLIB_OR, smtTerms);
	}

	public static @NonNull String constant(@NonNull String smtConstantName, @NonNull String smtConstantType) {

		return predicate(SMTLIB_CONST, smtConstantName + " " + smtConstantType);
	}

	public static @NonNull String equality(@NonNull String smtTerms) {

		return predicate(SMTLIB_EQUALITY, smtTerms);
	}

	public static @NonNull String implication(@NonNull String smtIfTerms, @NonNull String smtThenTerms) {

		return predicate(SMTLIB_IMPLICATION, smtIfTerms + smtThenTerms);
	}

	public static @NonNull String exists(@NonNull String smtQuantification, @NonNull String smtTerms) {

		return predicate(
			SMTLIB_EXISTS,
			SMTLIB_PREDICATE_START + smtQuantification + SMTLIB_PREDICATE_END + smtTerms
		);
	}

	public static @NonNull String forall(@NonNull String smtQuantification, @NonNull String smtTerms) {

		return predicate(
			SMTLIB_FORALL,
			SMTLIB_PREDICATE_START + smtQuantification + SMTLIB_PREDICATE_END + smtTerms
		);
	}

}
