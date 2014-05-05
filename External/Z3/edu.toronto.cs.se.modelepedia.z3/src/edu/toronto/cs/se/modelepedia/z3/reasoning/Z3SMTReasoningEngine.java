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
package edu.toronto.cs.se.modelepedia.z3.reasoning;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.reasoning.ReasoningEngine;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils.Z3BoolResult;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils.Z3ModelResult;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;

public class Z3SMTReasoningEngine implements ReasoningEngine {

	private final static String ECOREMAVOTOSMTLIB_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";

	@Override
	public MAVOTruthValue checkConstraint(Model model, ExtendibleElementConstraint constraint, MidLevel constraintLevel) {

		String smtlibConstraint = constraint.getImplementation();
		EcoreMAVOToSMTLIB ecore2smt = (EcoreMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getType(ECOREMAVOTOSMTLIB_OPERATOR_URI);
		EList<Model> actualParameters = new BasicEList<Model>();
		actualParameters.add(model);
		try {
			ecore2smt.execute(actualParameters);
		}
		catch (Exception e) {
			MMINTException.print(MMINTException.Type.ERROR, "Can't generate SMTLIB encoding, evaluating to false", e);
			return MAVOTruthValue.FALSE;
		}
		ecore2smt.cleanup();

		// tri-state logic
		Z3SMTIncrementalSolver z3IncSolver = new Z3SMTIncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(ecore2smt.getListener().getSMTEncoding());
		Z3ModelResult z3ModelResult = z3IncSolver.checkSatAndGetModel(Z3SMTUtils.assertion(smtlibConstraint), Z3IncrementalBehavior.POP);
		boolean propertyTruthValue = z3ModelResult.getZ3BoolResult() == Z3BoolResult.SAT;
		z3ModelResult = z3IncSolver.checkSatAndGetModel(Z3SMTUtils.assertion(Z3SMTUtils.not(smtlibConstraint)), Z3IncrementalBehavior.POP);
		boolean notPropertyTruthValue = z3ModelResult.getZ3BoolResult() == Z3BoolResult.SAT;

		return MAVOTruthValue.toMAVOTruthValue(propertyTruthValue, notPropertyTruthValue);
	}

	@Override
	public boolean checkConstraintConsistency(Model modelType, String constraint) {

		return true;
	}

}
