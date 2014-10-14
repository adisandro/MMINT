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
package edu.toronto.cs.se.modelepedia.z3.operator.henshin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Bool;

public abstract class LiftingHenshinTransformation extends RandomOperatorImpl {

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
	private static final String PROPERTY_IN_CONSTRAINT_DEFAULT = Z3Utils.SMTLIB_TRUE;
	public static final String PROPERTY_IN_CONSTRAINTVARIABLES = "constraintVariables";
	private static final String[] PROPERTY_IN_CONSTRAINTVARIABLES_DEFAULT = {};
	private static final String PROPERTY_IN_TRANSFORMATIONMODULE = "transformationModule";
	private static final String PROPERTY_IN_TRANSFORMATIONRULES = "transformationRules";
	private static final String[] PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT = {};
	private static final String PROPERTY_IN_TRANSFORMATIONRULESLIFTING = "transformationRulesLifting";

	protected static final String ANAC_NAME = "A_NAC";
	protected static final String TRANSFORMED_MODELINPUT_SUFFIX = "_transformedInput";
	protected static final String TRANSFORMED_MODELOUTPUT_SUFFIX = "_transformedOutput";
	protected static final String SMTLIB_APPLICABILITY_FUN = "(f";
	protected static final String SMTLIB_APPLICABILITY_FUN_CONSTRAINTS = SMTLIB_APPLICABILITY_FUN + "X ";
	protected static final String SMTLIB_APPLICABILITY_FUN_APPLY = SMTLIB_APPLICABILITY_FUN + "Y ";
	protected static final String SMTLIB_APPLICABILITY_FUN_N = SMTLIB_APPLICABILITY_FUN + "N ";
	protected static final String SMTLIB_APPLICABILITY_FUN_C = SMTLIB_APPLICABILITY_FUN + "C ";
	protected static final String SMTLIB_APPLICABILITY_FUN_D = SMTLIB_APPLICABILITY_FUN + "D ";
	protected static final String SMTLIB_APPLICABILITY_FUN_A = SMTLIB_APPLICABILITY_FUN + "A ";

	private static final String PROPERTY_OUT_TIMECLASSICAL = "timeClassical";
	protected static final String PROPERTY_OUT_TIMELIFTING = "timeLifting";
	private static final String PROPERTY_OUT_RULEAPPLICATIONSCLASSICAL = "ruleApplicationsClassical";
	protected static final String PROPERTY_OUT_RULEAPPLICATIONSLIFTING = "ruleApplicationsLifting";
	private static final String PROPERTY_OUT_RULEAPPLICATIONSNOTLIFTING = "ruleApplicationsNotLifting";
	protected static final String PROPERTY_OUT_SATCOUNTLIFTING = "satCountLifting";
	protected static final String PROPERTY_OUT_UNSATCOUNTLIFTING = "unsatCountLifting";
	protected static final String PROPERTY_OUT_SMTENCODINGLENGTH = "smtEncodingLength";
	protected static final String PROPERTY_OUT_SMTENCODINGVARIABLES = "smtEncodingVariables";
	private static final String PROPERTY_OUT_CHAINS = "chains";
	private static final int PROPERTY_OUT_CHAINS_MAX = 10;
	private static final String PROPERTY_OUT_LITERALS = "literals";
	private static final int PROPERTY_OUT_LITERALS_MAX = 10;

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
	protected Set<String> smtEncodingVariables;

	protected boolean timeClassicalEnabled;
	protected long timeClassical;
	protected long timeLifting;
	protected int ruleApplicationsClassical;
	protected int ruleApplicationsLifting;
	protected int ruleApplicationsNotLifting;
	protected int satCountLifting;
	protected int unsatCountLifting;
	protected Map<MAVOElement, Integer> modelObjsChains;
	protected Map<MAVOElement, Integer> modelObjsLiterals;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		constraint = MultiModelOperatorUtils.getOptionalStringProperty(inputProperties, PROPERTY_IN_CONSTRAINT, PROPERTY_IN_CONSTRAINT_DEFAULT);
		constraintVariables = MultiModelOperatorUtils.getOptionalStringProperties(inputProperties, PROPERTY_IN_CONSTRAINTVARIABLES, PROPERTY_IN_CONSTRAINTVARIABLES_DEFAULT);
		transformationModule = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_TRANSFORMATIONMODULE);
		transformationRules = MultiModelOperatorUtils.getOptionalStringProperties(inputProperties, PROPERTY_IN_TRANSFORMATIONRULES, PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT);
		transformationRulesLifting = MultiModelOperatorUtils.getStringProperties(inputProperties, PROPERTY_IN_TRANSFORMATIONRULESLIFTING);
		timeClassicalEnabled = MultiModelOperatorUtils.getBoolProperty(inputProperties, PROPERTY_OUT_TIMECLASSICAL+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
	}

	protected void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMECLASSICAL, String.valueOf(timeClassical));
		properties.setProperty(PROPERTY_OUT_TIMELIFTING, String.valueOf(timeLifting));
		properties.setProperty(PROPERTY_OUT_RULEAPPLICATIONSCLASSICAL, String.valueOf(ruleApplicationsClassical));
		properties.setProperty(PROPERTY_OUT_RULEAPPLICATIONSLIFTING, String.valueOf(ruleApplicationsLifting));
		properties.setProperty(PROPERTY_OUT_RULEAPPLICATIONSNOTLIFTING, String.valueOf(ruleApplicationsNotLifting));
		properties.setProperty(PROPERTY_OUT_SATCOUNTLIFTING, String.valueOf(satCountLifting));
		properties.setProperty(PROPERTY_OUT_UNSATCOUNTLIFTING, String.valueOf(unsatCountLifting));
		properties.setProperty(PROPERTY_OUT_SMTENCODINGLENGTH, String.valueOf(smtEncoding.length()));
		properties.setProperty(PROPERTY_OUT_SMTENCODINGVARIABLES, String.valueOf(smtEncodingVariables.size()));
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

	@Override
	public void init() throws MMINTException {

		//state
		modelObjsNBar = new ArrayList<Set<MAVOElement>>();
		modelObjsC = new HashSet<MAVOElement>();
		modelObjsD = new HashSet<MAVOElement>();
		modelObjsA = new HashSet<MAVOElement>();
		modelObjsCDN = new HashSet<MAVOElement>();
		modelObjACounter = 0;
		smtEncoding = new StringBuilder();
		smtEncodingVariables = new HashSet<String>();

		// output
		timeClassical = -1;
		timeLifting = -1;
		ruleApplicationsClassical = 0;
		ruleApplicationsLifting = 0;
		ruleApplicationsNotLifting = 0;
		satCountLifting = 0;
		unsatCountLifting = 0;
		modelObjsChains = new HashMap<MAVOElement, Integer>();
		modelObjsLiterals = new HashMap<MAVOElement, Integer>();
	}

	protected void initSMTEncoding(String preamble, String postamble) {

		for (String constraintVariable : constraintVariables) {
			smtEncodingVariables.add(constraintVariable);
		}
		for (String smtConstant: smtEncodingVariables) {
			smtEncoding.append(Z3Utils.constant(smtConstant, Z3Utils.SMTLIB_TYPE_BOOL));
		}
		smtEncoding.append(preamble);
		smtEncoding.append(constraint);
		smtEncoding.append(postamble);
	}

	protected String createZ3ApplyFormulaMatchSet(Set<MAVOElement> modelObjs, String innerPredicate, String functionEmpty) {

		String smtEncoding = "";
		if (modelObjs.isEmpty()) {
			smtEncoding += functionEmpty;
		}
		else {
			boolean simplify = (modelObjs.size() == 1) ? true : false;
			if (!simplify) {
				smtEncoding += innerPredicate;
			}
			for (MAVOElement modelObj : modelObjs) {
				smtEncoding += modelObj.getFormulaVariable() + " ";
			}
			smtEncoding = smtEncoding.substring(0, smtEncoding.length()-1);
			if (!simplify) {
				smtEncoding += Z3Utils.SMTLIB_PREDICATE_END;
			}
		}

		return smtEncoding;
	}

	protected void createZ3ApplyFormulaMatchSetIteration(Set<MAVOElement> modelObjs, String functionName, String innerPredicate, String functionEmpty) {

		smtEncoding.append(
			Z3Utils.assertion(
				Z3Utils.equality(
					Z3Utils.predicate(functionName, Integer.toString(ruleApplicationsLifting + 1)) +
					createZ3ApplyFormulaMatchSet(modelObjs, innerPredicate, functionEmpty)
				)
			)
		);
	}

	protected void createZ3ApplyFormulaMatchSetNIteration() {

		smtEncoding.append(Z3Utils.SMTLIB_ASSERT);
		smtEncoding.append(Z3Utils.SMTLIB_EQUALITY);
		smtEncoding.append(
			Z3Utils.predicate(SMTLIB_APPLICABILITY_FUN_N, Integer.toString(ruleApplicationsLifting + 1))
		);

		if (modelObjsNBar.isEmpty()) {
			smtEncoding.append(Z3Utils.SMTLIB_FALSE);
		}
		else {
			boolean simplify = (modelObjsNBar.size() == 1) ? true : false;
			if (!simplify) {
				smtEncoding.append(Z3Utils.SMTLIB_OR);
			}
			boolean previousNSimplified = false;
			for (Set<MAVOElement> modelObjsN : modelObjsNBar) {
				if (previousNSimplified && modelObjsN.size() == 1) {
					smtEncoding.append(" ");
				}
				//TODO MMINT[LIFTING] review if true or false here when simplifying
				smtEncoding.append(
					createZ3ApplyFormulaMatchSet(modelObjsN, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_FALSE)
				);
				previousNSimplified = (modelObjsN.size() == 1) ? true : false;
			}
			if (!simplify) {
				smtEncoding.append(Z3Utils.SMTLIB_PREDICATE_END);
			}
		}
		smtEncoding.append(Z3Utils.SMTLIB_PREDICATE_END);
		smtEncoding.append(Z3Utils.SMTLIB_PREDICATE_END);
	}

	protected abstract void createZ3ApplyFormula();

	protected boolean checkZ3ApplicabilityFormula(Z3IncrementalSolver z3IncSolver) {

		int checkpointUnsat = smtEncoding.length();
		createZ3ApplyFormula();
		smtEncoding.append(
			Z3Utils.assertion(
				Z3Utils.equality(
					Z3Utils.and(
						Z3Utils.predicate(SMTLIB_APPLICABILITY_FUN_CONSTRAINTS, Integer.toString(ruleApplicationsLifting)) +
						Z3Utils.predicate(SMTLIB_APPLICABILITY_FUN_APPLY, Integer.toString(ruleApplicationsLifting + 1))
					) +
					Z3Utils.SMTLIB_TRUE
				)
			)
		);

		Z3Model z3ModelResult = z3IncSolver.checkSatAndGetModel(smtEncoding.substring(checkpointUnsat), Z3IncrementalBehavior.POP_IF_UNSAT);
		if (z3ModelResult.getZ3Bool() == Z3Bool.SAT) {
			satCountLifting++;
			return true;
		}
		smtEncoding.delete(checkpointUnsat, smtEncoding.length());
		unsatCountLifting++;
		return false;
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

	protected void getNNodesAndChangeToC(NestedCondition conditionNac, Rule ruleNac, Set<Node> nodesN) {

		// (N)ac nodes
		Map<Node, Node> forbid2preserve = new HashMap<Node, Node>();
		for (Node nodeNac : conditionNac.getConclusion().getNodes()) {
			if (nodeNac.getAction() != null && nodeNac.getAction().getType() == Action.Type.FORBID) {
				Node newNodeNac = HenshinFactory.eINSTANCE.createNode();
				ruleNac.getLhs().getNodes().add(newNodeNac);
				nodesN.add(newNodeNac);
				forbid2preserve.put(nodeNac, newNodeNac);
				newNodeNac.setType(nodeNac.getType());
				// Action.Type.PRESERVE has to be set at last
				newNodeNac.setAction(new Action(Action.Type.PRESERVE));
				// copy attributes
				for (Attribute attributeNac : nodeNac.getAttributes()) {
					Attribute newAttributeNac = HenshinFactory.eINSTANCE.createAttribute();
					newNodeNac.getAttributes().add(newAttributeNac);
					newAttributeNac.setType(attributeNac.getType());
					newAttributeNac.setValue(attributeNac.getValue());
					newAttributeNac.setAction(new Action(Action.Type.PRESERVE));
				}
			}
		}
		for (Edge edgeNac : conditionNac.getConclusion().getEdges()) {
			if (edgeNac.getAction() != null && edgeNac.getAction().getType() == Action.Type.FORBID) {
				Edge newEdgeNac = HenshinFactory.eINSTANCE.createEdge();
				ruleNac.getLhs().getEdges().add(newEdgeNac);
				newEdgeNac.setType(edgeNac.getType());
				Node newSrcNodeNac = forbid2preserve.get(edgeNac.getSource());
				if (newSrcNodeNac == null) {
					newSrcNodeNac = conditionNac.getMappings().getOrigin(edgeNac.getSource());
				}
				newEdgeNac.setSource(newSrcNodeNac);
				Node newTgtNodeNac = forbid2preserve.get(edgeNac.getTarget());
				if (newTgtNodeNac == null) {
					newTgtNodeNac = conditionNac.getMappings().getOrigin(edgeNac.getTarget());
				}
				newEdgeNac.setTarget(newTgtNodeNac);
				// Action.Type.PRESERVE has to be set at last
				newEdgeNac.setAction(new Action(Action.Type.PRESERVE));
			}
		}
		ruleNac.getLhs().setFormula(null);
	}

	protected void getCDNodes(Rule rule, Set<Node> nodesC, Set<Node> nodesD) {

		for (Node node : rule.getLhs().getNodes()) {
			if (node.getAction() != null) {
				if (node.getAction().getType() == Action.Type.PRESERVE) {
					nodesC.add(node);
				}
				else if (node.getAction().getType() == Action.Type.DELETE) {
					nodesD.add(node);
				}
			}
		}
	}

	protected boolean areMatchesOverlapping(Match match1, Match match2, Set<Node> nodesC, Set<Node> nodesD) {

		for (Node nodeC : nodesC) {
			EObject nodeTargetC1 = match1.getNodeTarget(nodeC);
			EObject nodeTargetC2 = match2.getNodeTarget(nodeC);
			if (nodeTargetC1 != nodeTargetC2) {
				return false;
			}
		}
		for (Node nodeD : nodesD) {
			EObject nodeTargetD1 = match1.getNodeTarget(nodeD);
			EObject nodeTargetD2 = match2.getNodeTarget(nodeD);
			if (nodeTargetD1 != nodeTargetD2) {
				return false;
			}
		}

		return true;
	}

	protected abstract void getMatchedModelObjs(Match match, Set<Node> nodes, Set<MAVOElement> modelObjs, Set<MAVOElement> allModelObjs);

	protected void matchAndTransformClassical(Rule rule, Engine engine, EGraph graph, boolean isLifting) {

		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(rule, graph, null)) {
			application.setCompleteMatch(match);
			application.execute(null);
			if (isLifting) {
				ruleApplicationsNotLifting++;
			}
			else {
				ruleApplicationsClassical++;
			}
		}
	}

	protected void doTransformationClassical(Module module, Engine engine, EGraph graph) {

		long startTime = System.nanoTime();

		for (String transformationRule : transformationRules) {
			Rule rule = (Rule) module.getUnit(transformationRule);
			matchAndTransformClassical(rule, engine, graph, false);
		}
		for (String transformationRuleLifted : transformationRulesLifting) {
			Rule rule = (Rule) module.getUnit(transformationRuleLifted);
			matchAndTransformClassical(rule, engine, graph, false);
		}

		timeClassical = System.nanoTime() - startTime;
	}

	protected void transformModelObjAWhenLifted(MAVOElement modelObjA) {
		// do nothing
	}

	protected void transformModelObjA(MAVOElement modelObjA) {
		// do nothing
	}

	protected void transformLifting(RuleApplication application, Match match, boolean isLiftedMatch) {

		// apply transformation
		application.setCompleteMatch(match);
		application.execute(null);

		// possibly propagate may to (A)dded elements
		Match resultMatch = application.getResultMatch();
		for (EObject resultNodeTarget : resultMatch.getNodeTargets()) {
			if (!(resultNodeTarget instanceof MAVOElement)) {
				continue;
			}
			// (C)ontext/(D)eleted/(N)ac elements
			if (modelObjsCDN.contains(resultNodeTarget)) {
				continue;
			}
			// (A)dded elements
			if (isLiftedMatch) {
				modelObjsA.add((MAVOElement) resultNodeTarget);
				transformModelObjAWhenLifted((MAVOElement) resultNodeTarget);
			}
			transformModelObjA((MAVOElement) resultNodeTarget);
			modelObjACounter++;
		}
	}

	protected abstract void matchAndTransformLifting(Rule rule, Engine engine, EGraph graph, Z3IncrementalSolver z3IncSolver);

	protected void doTransformationLifting(Module module, Engine engine, EGraph graph) {

		long startTime = System.nanoTime();

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(smtEncoding.toString());
		// run transformation rules marked as classical (e.g. root creation)
		for (String transformationRule : transformationRules) {
			Rule rule = (Rule) module.getUnit(transformationRule);
			matchAndTransformClassical(rule, engine, graph, true);
		}
		// run transformation rules marked as lifted
		for (String transformationRuleLifted : transformationRulesLifting) {
			Rule rule = (Rule) module.getUnit(transformationRuleLifted);
			matchAndTransformLifting(rule, engine, graph, z3IncSolver);
		}

		timeLifting = System.nanoTime() - startTime;
	}

}
