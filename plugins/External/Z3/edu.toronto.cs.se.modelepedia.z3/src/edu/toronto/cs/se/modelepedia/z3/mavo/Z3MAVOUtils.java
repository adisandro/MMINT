/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.z3.mavo;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

public class Z3MAVOUtils {

	private static @NonNull String getSMTLIBMAVOModelObjectFunction(@NonNull MAVOElement mavoModelObj) throws MMINTException {

		boolean isNode;
		if (mavoModelObj.eClass().getEAnnotation("gmf.node") != null) {
			isNode = true;
		}
		else if (mavoModelObj.eClass().getEAnnotation("gmf.link") != null) {
			isNode = false;
		}
		else {
			throw new MMINTException("The model object " + mavoModelObj.getFormulaVariable() + " doesn't have a Eugenia node/link annotation");
		}

		return (isNode) ? Z3Utils.SMTLIB_NODE_FUNCTION : Z3Utils.SMTLIB_EDGE_FUNCTION;
	}

	public static @NonNull String getSMTLIBMayModelObjectConstraint(@NonNull MAVOElement mayModelObj, boolean isMayOnly, boolean isNegation) throws MMINTException {

		String smtFunction = getSMTLIBMAVOModelObjectFunction(mayModelObj);
		String smtEncoding = (isMayOnly) ?
			Z3Utils.predicate(smtFunction, mayModelObj.getFormulaVariable()) :
			Z3Utils.exists(
				Z3Utils.predicate(Z3Utils.SMTLIB_CONCRETIZATION_QUANTIFIER, mayModelObj.eClass().getName()),
				Z3Utils.predicate(smtFunction, mayModelObj.getFormulaVariable() + " " + Z3Utils.SMTLIB_CONCRETIZATION)
			);

		return (isNegation) ? Z3Utils.not(smtEncoding) : smtEncoding;
	}

	public static @NonNull String getSMTLIBSetModelObjectConstraint(@NonNull MAVOElement setModelObj, boolean isNegation) throws MMINTException {

		final String SMTLIB_CONCRETIZATION1 = Z3Utils.SMTLIB_CONCRETIZATION + "1";
		final String SMTLIB_CONCRETIZATION2 = Z3Utils.SMTLIB_CONCRETIZATION + "2";
		final String SMTLIB_CONCRETIZATION1_QUANTIFIER = Z3Utils.SMTLIB_PREDICATE_START + SMTLIB_CONCRETIZATION1 + " ";
		final String SMTLIB_CONCRETIZATION2_QUANTIFIER = Z3Utils.SMTLIB_PREDICATE_START + SMTLIB_CONCRETIZATION2 + " ";

		String smtFunction = getSMTLIBMAVOModelObjectFunction(setModelObj);
		String smtThenTerms = Z3Utils.equality(SMTLIB_CONCRETIZATION1 + " " + SMTLIB_CONCRETIZATION2);
		if (isNegation) {
			smtThenTerms = Z3Utils.not(smtThenTerms);
		}
		String smtTerms = Z3Utils.implication(
			Z3Utils.and(
				Z3Utils.predicate(smtFunction, setModelObj.getFormulaVariable() + " " + SMTLIB_CONCRETIZATION1) +
				Z3Utils.predicate(smtFunction, setModelObj.getFormulaVariable() + " " + SMTLIB_CONCRETIZATION2)
			),
			smtThenTerms
		);
		String smtQuantification = 
			Z3Utils.predicate(SMTLIB_CONCRETIZATION1_QUANTIFIER, setModelObj.eClass().getName()) +
			Z3Utils.predicate(SMTLIB_CONCRETIZATION2_QUANTIFIER, setModelObj.eClass().getName());
		String smtEncoding = (isNegation) ?
			Z3Utils.exists(smtQuantification, smtTerms) :
			Z3Utils.forall(smtQuantification, smtTerms);

		return smtEncoding;
	}

	public static @NonNull String getSMTLIBVarModelObjectConstraint(@NonNull MAVOElement varModelObj, @NonNull Set<String> unmergeableFormulaVars, boolean isNegation) throws MMINTException {

		String smtFunction = getSMTLIBMAVOModelObjectFunction(varModelObj);
		String smtThenTerms = "";
		for (String unmergeableFormulaVar : unmergeableFormulaVars) {
			smtThenTerms += Z3Utils.predicate(smtFunction, unmergeableFormulaVar + " " + Z3Utils.SMTLIB_CONCRETIZATION);
		}
		smtThenTerms = (isNegation) ? Z3Utils.and(smtThenTerms) : Z3Utils.not(Z3Utils.or(smtThenTerms));
		String smtEncoding = Z3Utils.forall(
			Z3Utils.predicate(Z3Utils.SMTLIB_CONCRETIZATION_QUANTIFIER, varModelObj.eClass().getName()),
			Z3Utils.implication(
				Z3Utils.predicate(smtFunction, varModelObj.getFormulaVariable() + " " + Z3Utils.SMTLIB_CONCRETIZATION),
				smtThenTerms
			)
		);

		return smtEncoding;
	}

}
