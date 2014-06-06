/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Naama Ben-David - Highlighting functionality
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
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTModel;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTModel.Z3SMTBool;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;

public class Z3SMTReasoningEngine implements IReasoningEngine {

	private final static String ECOREMAVOTOSMTLIB_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";
	private final static String GRAPH_MAVO_URI = "http://se.cs.toronto.edu/modelepedia/Graph_MAVO";

	public static MAVOTruthValue checkMAVOProperty(String smtEncoding, String smtProperty) {

		// tri-state MAVO logic
		Z3SMTIncrementalSolver z3IncSolver = new Z3SMTIncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		Z3SMTModel z3Model = z3IncSolver.checkSatAndGetModel(Z3SMTUtils.assertion(smtProperty), Z3IncrementalBehavior.POP);
		boolean propertyTruthValue = z3Model.getZ3Bool() == Z3SMTBool.SAT;
		z3Model = z3IncSolver.checkSatAndGetModel(Z3SMTUtils.assertion(Z3SMTUtils.not(smtProperty)), Z3IncrementalBehavior.POP);
		boolean notPropertyTruthValue = z3Model.getZ3Bool() == Z3SMTBool.SAT;

		return MAVOTruthValue.toMAVOTruthValue(propertyTruthValue, notPropertyTruthValue);
	}

	@Override
	public MAVOTruthValue checkConstraint(Model model, ExtendibleElementConstraint constraint, MidLevel constraintLevel) {

		String smtConstraint = constraint.getImplementation();
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

		MAVOTruthValue propertyTruthValue = checkMAVOProperty(ecore2smt.getListener().getSMTLIBEncoding(), smtConstraint);

		if (propertyTruthValue == MAVOTruthValue.MAYBE){
			//TODO MMINT[MU-MMINT] Generalize to any MAVO model.
			if(model.getMetatypeUri().equals(GRAPH_MAVO_URI)){
				if (MultiModelDiagramUtils.getBooleanInput("Example Highlighter", "Do you want to see a highlighter example?")){
					MAVOConcretizationHighlighter highlighter;
					try {
						highlighter = new MAVOConcretizationHighlighter(ecore2smt.getListener());
						highlighter.highlightExample(model);
					} catch (Exception e) {
						e.printStackTrace();
						MMINTException.print(MMINTException.Type.ERROR, "Can't highlight example", e);
					}					
				}
			}
		}
		return propertyTruthValue;
	}

	@Override
	public boolean checkConstraintConsistency(Model modelType, String constraint) {

		return true;
	}

}
