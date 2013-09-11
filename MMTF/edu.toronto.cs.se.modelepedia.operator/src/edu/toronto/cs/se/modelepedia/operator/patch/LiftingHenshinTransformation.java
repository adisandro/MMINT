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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
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

	public static final String PROPERTY_IN_CONSTRAINT = "constraint";
	private static final String PROPERTY_IN_CONSTRAINT_DEFAULT = SMTLIB_TRUE;
	public static final String PROPERTY_IN_CONSTRAINTVARIABLES = "constraintVariables";
	private static final String[] PROPERTY_IN_CONSTRAINTVARIABLES_DEFAULT = {};
	private static final String PROPERTY_IN_TRANSFORMATIONMODULE = "transformationModule";
	private static final String PROPERTY_IN_TRANSFORMATIONRULES = "transformationRules";
	private static final String[] PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT = {};
	private static final String PROPERTY_IN_TRANSFORMATIONRULESLIFTING = "transformationRulesLifting";

	private static final String PROPERTY_OUT_TIMECLASSICAL = "timeClassical";
	private static final String PROPERTY_OUT_TIMELIFTING = "timeLifting";
	private static final String PROPERTY_OUT_ITERATIONSCLASSICAL = "iterationsClassical";
	private static final String PROPERTY_OUT_ITERATIONSLIFTING = "iterationsLifting";
	private static final String PROPERTY_OUT_ITERATIONSNOTLIFTING = "iterationsNotLifting";
	private static final String PROPERTY_OUT_SMTENCODINGLENGTH = "smtEncodingLength";
	private static final String PROPERTY_OUT_CHAINS = "chains";
	private static final int PROPERTY_OUT_CHAINS_MAX = 10;
	private static final String PROPERTY_OUT_LITERALS = "literals";
	private static final int PROPERTY_OUT_LITERALS_MAX = 10;

	protected static final String ANAC_NAME = "A_NAC";
	protected static final String A_MODELOBJECT_SMTENCODING_PREFIX = "a";
	protected static final String TRANSFORMED_MODELINPUT_SUFFIX = "_transformedInput";
	protected static final String TRANSFORMED_MODELOUTPUT_SUFFIX = "_transformedOutput";
	protected static final String SMTLIB_APPLICABILITY_FUN = "(f";
	protected static final String SMTLIB_APPLICABILITY_FUN_CONSTRAINTS = SMTLIB_APPLICABILITY_FUN + "X ";
	protected static final String SMTLIB_APPLICABILITY_FUN_APPLY = SMTLIB_APPLICABILITY_FUN + "Y ";
	protected static final String SMTLIB_APPLICABILITY_FUN_N = SMTLIB_APPLICABILITY_FUN + "N ";
	protected static final String SMTLIB_APPLICABILITY_FUN_C = SMTLIB_APPLICABILITY_FUN + "C ";
	protected static final String SMTLIB_APPLICABILITY_FUN_D = SMTLIB_APPLICABILITY_FUN + "D ";
	protected static final String SMTLIB_APPLICABILITY_FUN_A = SMTLIB_APPLICABILITY_FUN + "A ";

	protected String constraint;
	protected String[] constraintVariables;
	protected String transformationModule;
	protected String[] transformationRules;
	protected String[] transformationRulesLifting;

	protected List<Set<MAVOElement>> modelObjsNBar;
	protected Set<MAVOElement> modelObjsC;
	protected Set<MAVOElement> modelObjsD;
	protected Set<MAVOElement> modelObjsA;
	protected Set<MAVOElement> modelObjsCDN;
	protected int modelObjACounter;
	protected StringBuilder smtEncoding;
	protected Set<String> smtEncodingConstants;

	protected boolean timeClassicalEnabled;
	protected long timeClassical;
	protected long timeLifting;
	protected int iterationsClassical;
	protected int iterationsLifting;
	protected int iterationsNotLifting;
	protected Map<MAVOElement, Integer> modelObjsChains;
	protected Map<MAVOElement, Integer> modelObjsLiterals;

	protected void readProperties(Properties properties) throws Exception {

		constraint = MultiModelOperatorUtils.getOptionalStringProperty(properties, PROPERTY_IN_CONSTRAINT, PROPERTY_IN_CONSTRAINT_DEFAULT);
		constraintVariables = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_CONSTRAINTVARIABLES, PROPERTY_IN_CONSTRAINTVARIABLES_DEFAULT);
		transformationModule = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONMODULE);
		transformationRules = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULES, PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT);
		transformationRulesLifting = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULESLIFTING);
		timeClassicalEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMECLASSICAL+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
	}

	protected void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMECLASSICAL, String.valueOf(timeClassical));
		properties.setProperty(PROPERTY_OUT_TIMELIFTING, String.valueOf(timeLifting));
		properties.setProperty(PROPERTY_OUT_ITERATIONSCLASSICAL, String.valueOf(iterationsClassical));
		properties.setProperty(PROPERTY_OUT_ITERATIONSLIFTING, String.valueOf(iterationsLifting));
		properties.setProperty(PROPERTY_OUT_ITERATIONSNOTLIFTING, String.valueOf(iterationsNotLifting));
		properties.setProperty(PROPERTY_OUT_SMTENCODINGLENGTH, String.valueOf(smtEncoding.length()));
		int[] chains = new int[PROPERTY_OUT_CHAINS_MAX];
		for (int chain : modelObjsChains.values()) {
			if (chain >= PROPERTY_OUT_CHAINS_MAX) {
				chains[PROPERTY_OUT_CHAINS_MAX-1]++;
			}
			else {
				chains[chain]++;
			}
		}
		for (int i = 0; i < chains.length; i++) {
			if (chains[i] > 0) {
				properties.setProperty(PROPERTY_OUT_CHAINS+i, String.valueOf(chains[i]));
			}
		}
		int[] literals = new int[PROPERTY_OUT_LITERALS_MAX];
		for (int literal : modelObjsLiterals.values()) {
			if (literal >= PROPERTY_OUT_LITERALS_MAX) {
				literals[PROPERTY_OUT_LITERALS_MAX-1]++;
			}
			else {
				literals[literal]++;
			}
		}
		for (int i = 0; i < literals.length; i++) {
			if (literals[i] > 0) {
				properties.setProperty(PROPERTY_OUT_LITERALS+i, String.valueOf(literals[i]));
			}
		}
	}

	private void initOutput() {

		timeClassical = -1;
		timeLifting = -1;
		iterationsClassical = 0;
		iterationsLifting = 0;
		iterationsNotLifting = 0;
		modelObjsChains = new HashMap<MAVOElement, Integer>();
		modelObjsLiterals = new HashMap<MAVOElement, Integer>();
	}

	protected void init() {

		modelObjsNBar = new ArrayList<Set<MAVOElement>>();
		modelObjsC = new HashSet<MAVOElement>();
		modelObjsD = new HashSet<MAVOElement>();
		modelObjsA = new HashSet<MAVOElement>();
		modelObjsCDN = new HashSet<MAVOElement>();
		modelObjACounter = 0;
		smtEncodingConstants = new HashSet<String>();
		smtEncoding = new StringBuilder();
		initOutput();
	}

	protected void initSMTEncoding(String preamble, String postamble) {

		for (String constraintVariable : constraintVariables) {
			smtEncodingConstants.add(constraintVariable);
		}
		createZ3ApplyFormulaConstant();
		smtEncoding.append(preamble);
		smtEncoding.append(constraint);
		smtEncoding.append(postamble);
	}

	protected void createZ3ApplyFormulaConstant() {

		for (String smtEncodingConstant : smtEncodingConstants) {
			smtEncoding.append(SMTLIB_CONST);
			smtEncoding.append(smtEncodingConstant);
			smtEncoding.append(" ");
			smtEncoding.append(SMTLIB_TYPE_BOOL);
			smtEncoding.append(SMTLIB_PREDICATE_END);
		}
	}

	protected void createZ3ApplyFormulaMatchSet(Set<MAVOElement> modelObjs, String innerPredicate, String functionEmpty) {

		if (modelObjs.isEmpty()) {
			smtEncoding.append(functionEmpty);
		}
		else {
			boolean simplify = (modelObjs.size() == 1) ? true : false;
			if (!simplify) {
				smtEncoding.append(innerPredicate);
			}
			for (MAVOElement modelObj : modelObjs) {
				smtEncoding.append(modelObj.getFormulaId());
				smtEncoding.append(" ");
			}
			smtEncoding.deleteCharAt(smtEncoding.length()-1);
			if (!simplify) {
				smtEncoding.append(SMTLIB_PREDICATE_END);
			}
		}
	}

	protected void createZ3ApplyFormulaMatchSetIteration(Set<MAVOElement> modelObjs, String functionName, String innerPredicate, String functionEmpty) {

		smtEncoding.append(SMTLIB_ASSERT);
		smtEncoding.append(SMTLIB_EQUALITY);
		smtEncoding.append(functionName);
		smtEncoding.append(iterationsLifting + 1);
		smtEncoding.append(SMTLIB_PREDICATE_END);
		createZ3ApplyFormulaMatchSet(modelObjs, innerPredicate, functionEmpty);
		smtEncoding.append(SMTLIB_PREDICATE_END);
		smtEncoding.append(SMTLIB_PREDICATE_END);
	}

	protected void createZ3ApplyFormulaMatchSetNIteration() {

		smtEncoding.append(SMTLIB_ASSERT);
		smtEncoding.append(SMTLIB_EQUALITY);
		smtEncoding.append(SMTLIB_APPLICABILITY_FUN_N);
		smtEncoding.append(iterationsLifting + 1);
		smtEncoding.append(SMTLIB_PREDICATE_END);

		if (modelObjsNBar.isEmpty()) {
			smtEncoding.append(SMTLIB_FALSE);
		}
		else {
			boolean simplify = (modelObjsNBar.size() == 1) ? true : false;
			if (!simplify) {
				smtEncoding.append(SMTLIB_OR);
			}
			boolean previousNSimplified = false;
			for (Set<MAVOElement> modelObjsN : modelObjsNBar) {
				if (previousNSimplified && modelObjsN.size() == 1) {
					smtEncoding.append(" ");
				}
				//TODO MMTF: review if true or false here when simplifying
				createZ3ApplyFormulaMatchSet(modelObjsN, SMTLIB_AND, SMTLIB_FALSE);
				previousNSimplified = (modelObjsN.size() == 1) ? true : false;
			}
			if (!simplify) {
				smtEncoding.append(SMTLIB_PREDICATE_END);
			}
		}
		smtEncoding.append(SMTLIB_PREDICATE_END);
		smtEncoding.append(SMTLIB_PREDICATE_END);
	}

	protected void updateChains() {

		int maxChain = 0;
		for (MAVOElement modelObjCDN : modelObjsCDN) {
			Integer modelObjCDNChain = modelObjsChains.get(modelObjCDN);
			if (modelObjCDNChain == null) {
				modelObjsChains.put(modelObjCDN, new Integer(0));
			}
			else if (modelObjCDNChain > maxChain) {
				maxChain = modelObjCDNChain;
			}
		}
		maxChain++;
		for (MAVOElement modelObjA : modelObjsA) {
			modelObjsChains.put(modelObjA, new Integer(maxChain));
		}
	}

	protected abstract void updateLiterals();

	protected void matchAndTransform(Rule rule, Engine engine, EGraph graph, boolean isLifting) {

		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);int i=0;
		for (Match match : engine.findMatches(rule, graph, null)) {System.err.println(i);i++;
			application.setCompleteMatch(match);
			application.execute(null);
			if (isLifting) {
				iterationsNotLifting++;
			}
			else {
				iterationsClassical++;
			}
		}
	}

	protected abstract void matchAndTransformLifting(Rule rule, Engine engine, EGraph graph);

	protected void doClassicalTransformation(Module module, Engine engine, EGraph graph) {

		long startTime = System.nanoTime();
		for (String transformationRule : transformationRules) {System.err.println(transformationRule);
			Rule rule = (Rule) module.getUnit(transformationRule);
			matchAndTransform(rule, engine, graph, false);
		}
		for (String transformationRuleLifted : transformationRulesLifting) {System.err.println(transformationRuleLifted);
			Rule rule = (Rule) module.getUnit(transformationRuleLifted);
			matchAndTransform(rule, engine, graph, false);
		}
		long endTime = System.nanoTime();

		timeClassical = endTime - startTime;
	}

	protected void doLiftingTransformation(Module module, Engine engine, EGraph graph) {

		long startTime = System.nanoTime();
		for (String transformationRule : transformationRules) {System.err.println(transformationRule);
			Rule rule = (Rule) module.getUnit(transformationRule);
			matchAndTransform(rule, engine, graph, true);
		}
		for (String transformationRuleLifted : transformationRulesLifting) {System.err.println(transformationRuleLifted);
			Rule rule = (Rule) module.getUnit(transformationRuleLifted);
			matchAndTransformLifting(rule, engine, graph);
		}
		long endTime = System.nanoTime();

		timeLifting = endTime - startTime;
	}

}
