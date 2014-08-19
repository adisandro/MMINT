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
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Bool;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;

public class Z3ReasoningEngine implements IReasoningEngine {

	private final static String ECOREMAVOTOSMTLIB_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";
	private final static String GRAPH_MAVO_URI = "http://se.cs.toronto.edu/modelepedia/Graph_MAVO";

	public static MAVOTruthValue checkMAVOProperty(String smtEncoding, String smtProperty) {

		// tri-state MAVO logic
		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		Z3Model z3Model = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(smtProperty), Z3IncrementalBehavior.POP);
		boolean propertyTruthValue = z3Model.getZ3Bool() == Z3Bool.SAT;
		z3Model = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(Z3Utils.not(smtProperty)), Z3IncrementalBehavior.POP);
		boolean notPropertyTruthValue = z3Model.getZ3Bool() == Z3Bool.SAT;

		return MAVOTruthValue.toMAVOTruthValue(propertyTruthValue, notPropertyTruthValue);
	}

	@Override
	public MAVOTruthValue checkConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel) {

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

		Z3MAVOModelParser z3ModelParser = ecore2smt.getZ3MAVOModelParser();
		MAVOTruthValue propertyTruthValue = checkMAVOProperty(z3ModelParser.getSMTLIBEncoding(), smtConstraint);
		if (propertyTruthValue == MAVOTruthValue.MAYBE){
			//TODO MMINT[MU-MMINT] Generalize to any MAVO model.
			if(model.getMetatypeUri().equals(GRAPH_MAVO_URI)){
				if (MultiModelDiagramUtils.getBooleanInput("Example Highlighter", "Do you want to see a highlighted example?")) {
					MAVOConcretizationHighlighter highlighter;
					try {
						highlighter = new MAVOConcretizationHighlighter(z3ModelParser);
						highlighter.highlightExample(model);
					}
					catch (Exception e) {
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
