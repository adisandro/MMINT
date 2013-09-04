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
package edu.toronto.cs.se.modelepedia.operator.patch;

import java.util.Properties;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;

import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTSolver;

public abstract class LiftingHenshinTransformation extends OperatorExecutableImpl implements Z3SMTSolver {

	protected class TransformationApplicabilityCondition {

		private Rule matchedRule;
		private Match match;
		private boolean isLiftedMatch;

		public TransformationApplicabilityCondition(Rule matchedRule, Match match, boolean isLiftedMatch) {
			this.matchedRule = matchedRule;
			this.match = match;
			this.isLiftedMatch = isLiftedMatch;
		}

		public Rule getMatchedRule() {
			return matchedRule;
		}

		public Match getMatch() {
			return match;
		}

		public boolean isLiftedMatch() {
			return isLiftedMatch;
		}
	}

	private static final String PROPERTY_IN_TRANSFORMATIONMODULE = "transformationModule";
	private static final String PROPERTY_IN_TRANSFORMATIONRULES = "transformationRules";
	private static final String[] PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT = {};
	private static final String PROPERTY_IN_TRANSFORMATIONRULESLIFTING = "transformationRulesLifting";

	protected static final String SMTLIB_APPLICABILITY_FUN = "(f";
	protected static final String SMTLIB_APPLICABILITY_FUN_CONSTRAINTS = SMTLIB_APPLICABILITY_FUN + "X ";
	protected static final String SMTLIB_APPLICABILITY_FUN_APPLY = SMTLIB_APPLICABILITY_FUN + "Y ";
	protected static final String SMTLIB_APPLICABILITY_FUN_N = SMTLIB_APPLICABILITY_FUN + "N ";
	protected static final String SMTLIB_APPLICABILITY_FUN_C = SMTLIB_APPLICABILITY_FUN + "C ";
	protected static final String SMTLIB_APPLICABILITY_FUN_D = SMTLIB_APPLICABILITY_FUN + "D ";
	protected static final String SMTLIB_APPLICABILITY_FUN_A = SMTLIB_APPLICABILITY_FUN + "A ";

	protected String transformationModule;
	protected String[] transformationRules;
	protected String[] transformationRulesLifting;
	protected int liftingIterations;

	protected void readProperties(Properties properties) throws Exception {

		transformationModule = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONMODULE);
		transformationRules = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULES, PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT);
		transformationRulesLifting = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULESLIFTING);
	}

	protected abstract void doLiftingTransformation(Module module, Engine engine, EGraph graph);

}
