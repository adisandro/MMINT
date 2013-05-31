/*
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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.henshin.trace.Trace;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTSolver;

public class MAVOHenshinTransformation extends OperatorExecutableImpl implements Z3SMTSolver {

	private class TransformationApplicabilityCondition {

		private Rule matchedRule;
		private Match match;
		private boolean isMayMatch;

		public TransformationApplicabilityCondition(Rule matchedRule, Match match, boolean isMayMatch) {
			this.matchedRule = matchedRule;
			this.match = match;
			this.isMayMatch = isMayMatch;
		}

		public Rule getMatchedRule() {
			return matchedRule;
		}

		public Match getMatch() {
			return match;
		}

		public boolean isMayMatch() {
			return isMayMatch;
		}
	}

	private static final String PROPERTY_IN_MAYFORMULA = "mayFormula";
	private static final String PROPERTY_IN_MAYFORMULA_DEFAULT = SMTLIB_TRUE;
	private static final String PROPERTY_IN_MAYFORMULAIDS = "mayFormulaIds";
	private static final String[] PROPERTY_IN_MAYFORMULAIDS_DEFAULT = {};
	private static final String PROPERTY_IN_TRANSFORMATIONMODULE = "transformationModule";
	private static final String PROPERTY_IN_TRANSFORMATIONRULES = "transformationRules";
	private static final String[] PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT = {};
	private static final String PROPERTY_IN_TRANSFORMATIONRULESMAVO = "transformationRulesMAVO";
	private static final String PROPERTY_OUT_TIMECLASSICAL = "timeClassical";
	private static final String PROPERTY_OUT_TIMEMAVO = "timeMAVO";
	private static final String PROPERTY_OUT_MAYFORMULALENGTH = "mayFormulaLength";
	private static final String ANAC_NAME = "A_NAC";
	private static final String A_MAVOELEMENT_FORMULAID_PREFIX = "a";
	private static final String TRANSFORMED_MODELINPUT_SUFFIX = "_transformedInput";
	private static final String TRANSFORMED_MODELOUTPUT_SUFFIX = "_transformedOutput";

	private static final String SMTLIB_APPLICABILITY_PREAMBLE = "(declare-fun fN (Int) Bool) (declare-fun fC (Int) Bool) (declare-fun fD (Int) Bool) (declare-fun fA (Int) Bool) (declare-fun fDo (Int) Bool) (declare-fun fAo (Int) Bool) (declare-fun fP (Int) Bool) (assert (forall ((i Int)) (= (fP i) (and (not (fN i)) (fC i) (fD i))))) (declare-fun fM (Int) Bool) (assert (forall ((i Int)) (= (fM i) (ite (= i 0)";
	private static final String SMTLIB_APPLICABILITY_POSTAMBLE = "(or (and (fM (- i 1)) (not (fP i)) (not (fAo i))) (and (and (fM (- i 1)) (fP i)) (not (fDo i)) (fA i)))))))";
	private static final String SMTLIB_APPLICABILITY_FUN = "(f";
	private static final String SMTLIB_APPLICABILITY_FUN_MAY = SMTLIB_APPLICABILITY_FUN + "M ";
	private static final String SMTLIB_APPLICABILITY_FUN_APPLY = SMTLIB_APPLICABILITY_FUN + "P ";
	private static final String SMTLIB_APPLICABILITY_FUN_N = SMTLIB_APPLICABILITY_FUN + "N ";
	private static final String SMTLIB_APPLICABILITY_FUN_C = SMTLIB_APPLICABILITY_FUN + "C ";
	private static final String SMTLIB_APPLICABILITY_FUN_D = SMTLIB_APPLICABILITY_FUN + "D ";
	private static final String SMTLIB_APPLICABILITY_FUN_A = SMTLIB_APPLICABILITY_FUN + "A ";
	private static final String SMTLIB_APPLICABILITY_FUN_D_OR = SMTLIB_APPLICABILITY_FUN + "Do ";
	private static final String SMTLIB_APPLICABILITY_FUN_A_OR = SMTLIB_APPLICABILITY_FUN + "Ao ";

	private String mayFormula;
	private String[] mayFormulaIds;
	private Set<String> mayFormulaConstants;
	private String transformationModule;
	private String[] transformationRules;
	private String[] transformationRulesMAVO;
	private List<Set<MAVOElement>> mayModelObjsNBar;
	private Set<MAVOElement> mayModelObjsC;
	private Set<MAVOElement> mayModelObjsD;
	private Set<MAVOElement> mayModelObjsA;
	private Set<MAVOElement> mavoModelObjsCDN;
	private int mavoModelObjACounter;
	private StringBuilder smtEncoding;
	private int mayFormulaIterations;
	private boolean timeClassicalEnabled;
	private long timeClassical;
	private long timeMAVO;

	private void readProperties(Properties properties) throws Exception {

		mayFormula = MultiModelOperatorUtils.getOptionalStringProperty(properties, PROPERTY_IN_MAYFORMULA, PROPERTY_IN_MAYFORMULA_DEFAULT);
		mayFormulaIds = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_MAYFORMULAIDS, PROPERTY_IN_MAYFORMULAIDS_DEFAULT);
		transformationModule = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONMODULE);
		transformationRules = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULES, PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT);
		transformationRulesMAVO = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULESMAVO);
		timeClassicalEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMECLASSICAL+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
	}

	private void initOutput() {

		timeClassical = -1;
		timeMAVO = -1;
	}

	private void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMECLASSICAL, String.valueOf(timeClassical));
		properties.setProperty(PROPERTY_OUT_TIMEMAVO, String.valueOf(timeMAVO));
		properties.setProperty(PROPERTY_OUT_MAYFORMULALENGTH, String.valueOf(smtEncoding.length()));
	}

	private void transformMatch(RuleApplication application, Match match, boolean isMayMatch) {

		// apply transformation
		application.setCompleteMatch(match);
		application.execute(null);

		// possibly propagate may to (A)dded elements
		Match resultMatch = application.getResultMatch();
		for (EObject resultNodeTarget : resultMatch.getNodeTargets()) {
			if (!(resultNodeTarget instanceof MAVOElement)) {
				continue;
			}
			// (C)ontext/(D)eleted/(A)dded elements
			if (mavoModelObjsCDN.contains(resultNodeTarget)) {
				continue;
			}
			// (A)dded elements
			if (isMayMatch) {
				mayModelObjsA.add((MAVOElement) resultNodeTarget);
				((MAVOElement) resultNodeTarget).setMay(true);
			}
			((MAVOElement) resultNodeTarget).setFormulaId(A_MAVOELEMENT_FORMULAID_PREFIX + mavoModelObjACounter);
			mavoModelObjACounter++;
		}
	}

	private void getCDNodes(Rule rule, Set<Node> nodesC, Set<Node> nodesD) {

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

	private void getNNodesAndChangeToC(NestedCondition conditionNac, Rule ruleNac, Set<Node> nodesN) {

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

	private void matchAndTransform(Rule rule, Engine engine, EGraph graph) {

		// apply rule
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(rule, graph, null)) {
			application.setCompleteMatch(match);
			application.execute(null);
		}
	}

	private void createZ3ApplyFormulaConstant() {

		for (String mayFormulaConstant : mayFormulaConstants) {
			smtEncoding.append(SMTLIB_CONST);
			smtEncoding.append(mayFormulaConstant);
			smtEncoding.append(" ");
			smtEncoding.append(SMTLIB_TYPE_BOOL);
			smtEncoding.append(SMTLIB_PREDICATE_END);
		}
	}

	private void createZ3ApplyFormulaConstant(Set<MAVOElement> mavoModelObjs) {

		for (MAVOElement mavoModelObj : mavoModelObjs) {
			if (mayFormulaConstants.contains(mavoModelObj.getFormulaId())) {
				continue;
			}
			smtEncoding.append(SMTLIB_CONST);
			smtEncoding.append(mavoModelObj.getFormulaId());
			smtEncoding.append(" ");
			smtEncoding.append(SMTLIB_TYPE_BOOL);
			smtEncoding.append(SMTLIB_PREDICATE_END);
		}
	}

	private void createZ3ApplyFormulaConstants() {

		Set<MAVOElement> uniqueMayModelObjsN = new HashSet<MAVOElement>();
		for (Set<MAVOElement> mayModelObjsN : mayModelObjsNBar) {
			uniqueMayModelObjsN.addAll(mayModelObjsN);
		}
		createZ3ApplyFormulaConstant(uniqueMayModelObjsN);
		createZ3ApplyFormulaConstant(mayModelObjsC);
		createZ3ApplyFormulaConstant(mayModelObjsD);
	}

	private void createZ3ApplyFormulaMatchSet(Set<MAVOElement> mayModelObjs, String innerPredicate, String functionEmpty) {

		if (mayModelObjs.isEmpty()) {
			smtEncoding.append(functionEmpty);
		}
		else {
			boolean simplify = (mayModelObjs.size() == 1) ? true : false;
			if (!simplify) {
				smtEncoding.append(innerPredicate);
			}
			for (MAVOElement mayModelObj : mayModelObjs) {
				smtEncoding.append(mayModelObj.getFormulaId());
				smtEncoding.append(" ");
			}
			smtEncoding.deleteCharAt(smtEncoding.length()-1);
			if (!simplify) {
				smtEncoding.append(SMTLIB_PREDICATE_END);
			}
		}
	}

	private void createZ3ApplyFormulaMatchSetIteration(Set<MAVOElement> mayModelObjs, String functionName, String innerPredicate, String functionEmpty) {

		smtEncoding.append(SMTLIB_ASSERT);
		smtEncoding.append(SMTLIB_EQUALITY);
		smtEncoding.append(functionName);
		smtEncoding.append(mayFormulaIterations + 1);
		smtEncoding.append(SMTLIB_PREDICATE_END);
		createZ3ApplyFormulaMatchSet(mayModelObjs, innerPredicate, functionEmpty);
		smtEncoding.append(SMTLIB_PREDICATE_END);
		smtEncoding.append(SMTLIB_PREDICATE_END);
	}

	private void createZ3ApplyFormulaMatchSetNIteration() {

		smtEncoding.append(SMTLIB_ASSERT);
		smtEncoding.append(SMTLIB_EQUALITY);
		smtEncoding.append(SMTLIB_APPLICABILITY_FUN_N);
		smtEncoding.append(mayFormulaIterations + 1);
		smtEncoding.append(SMTLIB_PREDICATE_END);

		if (mayModelObjsNBar.isEmpty()) {
			smtEncoding.append(SMTLIB_FALSE);
		}
		else {
			boolean simplify = (mayModelObjsNBar.size() == 1) ? true : false;
			if (!simplify) {
				smtEncoding.append(SMTLIB_OR);
			}
			boolean previousNSimplified = false;
			for (Set<MAVOElement> mayModelObjsN : mayModelObjsNBar) {
				if (previousNSimplified & mayModelObjsN.size() == 1) {
					smtEncoding.append(" ");
				}
				//TODO MMTF: review if true or false here when simplifying
				createZ3ApplyFormulaMatchSet(mayModelObjsN, SMTLIB_AND, SMTLIB_FALSE);
				previousNSimplified = (mayModelObjsN.size() == 1) ? true : false;
			}
			if (!simplify) {
				smtEncoding.append(SMTLIB_PREDICATE_END);
			}
		}
		smtEncoding.append(SMTLIB_PREDICATE_END);
		smtEncoding.append(SMTLIB_PREDICATE_END);
	}

	private void createZ3ApplyFormula() {

		createZ3ApplyFormulaConstants();
		createZ3ApplyFormulaMatchSetNIteration();
		createZ3ApplyFormulaMatchSetIteration(mayModelObjsC, SMTLIB_APPLICABILITY_FUN_C, SMTLIB_AND, SMTLIB_TRUE);
		createZ3ApplyFormulaMatchSetIteration(mayModelObjsD, SMTLIB_APPLICABILITY_FUN_D, SMTLIB_AND, SMTLIB_TRUE);
		createZ3ApplyFormulaMatchSetIteration(mayModelObjsD, SMTLIB_APPLICABILITY_FUN_D_OR, SMTLIB_OR, SMTLIB_FALSE);
	}

	private boolean checkZ3ApplicabilityFormula() {

		int checkpointUnsat = smtEncoding.length();
		createZ3ApplyFormula();
		int checkpointSat = smtEncoding.length();
		smtEncoding.append(SMTLIB_ASSERT);
		smtEncoding.append(SMTLIB_EQUALITY);
		smtEncoding.append(SMTLIB_AND);
		smtEncoding.append(SMTLIB_APPLICABILITY_FUN_MAY);
		smtEncoding.append(mayFormulaIterations);
		smtEncoding.append(SMTLIB_PREDICATE_END);
		smtEncoding.append(SMTLIB_APPLICABILITY_FUN_APPLY);
		smtEncoding.append(mayFormulaIterations + 1);
		smtEncoding.append(SMTLIB_PREDICATE_END);
		smtEncoding.append(SMTLIB_PREDICATE_END);
		smtEncoding.append(SMTLIB_TRUE);
		smtEncoding.append(SMTLIB_PREDICATE_END);
		smtEncoding.append(SMTLIB_PREDICATE_END);

		int z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(smtEncoding.toString());
		if (z3Result == Z3_SAT) {
			smtEncoding.delete(checkpointSat, smtEncoding.length());
			return true;
		}
		smtEncoding.delete(checkpointUnsat, smtEncoding.length());
		return false;
	}

	private boolean overlapCD(Match match1, Match match2, Set<Node> nodesC, Set<Node> nodesD) {

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

	private boolean isMayMatch(Match match, Set<Node> nodes, Set<MAVOElement> mayModelObjs, Set<MAVOElement> mavoModelObjs) {

		boolean isMayMatch = false;
		for (Node node : nodes) {
			EObject nodeTarget = match.getNodeTarget(node);
			if (nodeTarget instanceof MAVOElement) {
				mavoModelObjs.add((MAVOElement) nodeTarget);
				if (((MAVOElement) nodeTarget).isMay()) {
					mayModelObjs.add((MAVOElement) nodeTarget);
					isMayMatch = true;
				}
			}
		}

		return isMayMatch;
	}

	private TransformationApplicabilityCondition checkApplicabilityConditions(Rule rule, Engine engine, EGraph graph) {

		Set<Node> nodesN = new HashSet<Node>();
		Set<Node> nodesC = new HashSet<Node>();
		Set<Node> nodesD = new HashSet<Node>();
		//TODO MMTF: loop through all nacs
		Rule ruleCopyN = EcoreUtil.copy(rule);
//		NestedCondition conditionN = ruleCopyN.getLhs().getNestedConditions().get(0);
		NestedCondition conditionN = ruleCopyN.getLhs().getNAC(ANAC_NAME);
		// (N)ac
		getCDNodes(ruleCopyN, nodesC, nodesD);
		getNNodesAndChangeToC(conditionN, ruleCopyN, nodesN);
		boolean isMayMatchNBar = true;
		List<Match> matchesN = InterpreterUtil.findAllMatches(engine, ruleCopyN, graph, null);
matchesN:
		for (int i = 0; i < matchesN.size(); i++) {
			mayModelObjsNBar.clear();
			Set<MAVOElement> mayModelObjsNi = new HashSet<MAVOElement>();
			mayModelObjsC.clear();
			mayModelObjsD.clear();
			mavoModelObjsCDN.clear();
			Match matchNi = matchesN.get(i);
			isMayMatchNBar &= isMayMatch(matchNi, nodesN, mayModelObjsNi, mavoModelObjsCDN);
			// check forall NBar condition
			if (!isMayMatchNBar) {
				continue;
			}
			mayModelObjsNBar.add(mayModelObjsNi);
			isMayMatch(matchNi, nodesC, mayModelObjsC, mavoModelObjsCDN);
			isMayMatch(matchNi, nodesD, mayModelObjsD, mavoModelObjsCDN);
			for (int j = 0; j < matchesN.size(); j++) {
				if (i == j) {
					continue;
				}
				Match matchNj = matchesN.get(j);
				if (!overlapCD(matchNi, matchNj, nodesC, nodesD)) {
					continue;
				}
				Set<MAVOElement> mayModelObjsNj = new HashSet<MAVOElement>();
				isMayMatchNBar &= isMayMatch(matchNj, nodesN, mayModelObjsNj, mavoModelObjsCDN);
				// check forall NBar condition
				if (!isMayMatchNBar) {
					continue matchesN;
				}
				mayModelObjsNBar.add(mayModelObjsNj);
				isMayMatch(matchNj, nodesC, mayModelObjsC, mavoModelObjsCDN);
				isMayMatch(matchNj, nodesD, mayModelObjsD, mavoModelObjsCDN);
			}
			// check apply formula
			if (checkZ3ApplicabilityFormula()) {
				return new TransformationApplicabilityCondition(ruleCopyN, matchNi, true); // <NBar,C,D> may match
			}
		}

		// no (N)ac matched
		Rule ruleCopy = EcoreUtil.copy(rule);
		nodesN = new HashSet<Node>();
		nodesC = new HashSet<Node>();
		nodesD = new HashSet<Node>();
		getCDNodes(ruleCopy, nodesC, nodesD);
		boolean isMayMatch = false;
		List<Match> matches = InterpreterUtil.findAllMatches(engine, ruleCopy, graph, null);
		for (int i = 0; i < matches.size(); i++) {
			mayModelObjsNBar.clear();
			mayModelObjsC.clear();
			mayModelObjsD.clear();
			mavoModelObjsCDN.clear();
			Match match = matches.get(i);
			isMayMatch |= isMayMatch(match, nodesC, mayModelObjsC, mavoModelObjsCDN);
			isMayMatch |= isMayMatch(match, nodesD, mayModelObjsD, mavoModelObjsCDN);
			if (isMayMatch) {
				// check apply formula
				if (checkZ3ApplicabilityFormula()) {
					return new TransformationApplicabilityCondition(ruleCopy, match, true); // <C,D> may match
				}
			}
			else {
				return new TransformationApplicabilityCondition(ruleCopy, match, false); // <C,D> classical match
			}
		}

		return null; // no matches
	}

	private void matchMAVOAndTransform(Rule rule, Engine engine, EGraph graph) {

		RuleApplication application = new RuleApplicationImpl(engine);
		TransformationApplicabilityCondition condition;
		while ((condition = checkApplicabilityConditions(rule, engine, graph)) != null) {
			application.setRule(condition.getMatchedRule());
			application.setEGraph(graph);
			// transform
			mayModelObjsA.clear();
			transformMatch(application, condition.getMatch(), condition.isMayMatch());
			if (condition.isMayMatch()) {
				// update encoding
				createZ3ApplyFormulaConstant(mayModelObjsA);
				createZ3ApplyFormulaMatchSetIteration(mayModelObjsA, SMTLIB_APPLICABILITY_FUN_A, SMTLIB_AND, SMTLIB_TRUE);
				createZ3ApplyFormulaMatchSetIteration(mayModelObjsA, SMTLIB_APPLICABILITY_FUN_A_OR, SMTLIB_OR, SMTLIB_FALSE);
				mayFormulaIterations++;
				// update set of may formula elements
				for (Set<MAVOElement> mayModelObjSN : mayModelObjsNBar) {
					for (MAVOElement mayModelObjN : mayModelObjSN) {
						mayFormulaConstants.add(mayModelObjN.getFormulaId());
					}
				}
				for (MAVOElement mayModelObjC : mayModelObjsC) {
					mayFormulaConstants.add(mayModelObjC.getFormulaId());
				}
				for (MAVOElement mayModelObjD : mayModelObjsD) {
					mayFormulaConstants.add(mayModelObjD.getFormulaId());
				}
				for (MAVOElement mayModelObjA : mayModelObjsA) {
					mayFormulaConstants.add(mayModelObjA.getFormulaId());
				}
			}
		}
	}

	private void doClassicalTransformation(Module module, Engine engine, EGraph graph) {

		long startTime = System.nanoTime();
		for (String transformationRule : transformationRules) {
			Rule rule = (Rule) module.getUnit(transformationRule);
			matchAndTransform(rule, engine, graph);
		}
		for (String transformationRuleMAVO : transformationRulesMAVO) {
			Rule rule = (Rule) module.getUnit(transformationRuleMAVO);
			matchAndTransform(rule, engine, graph);
		}
		long endTime = System.nanoTime();

		timeClassical = endTime - startTime;
	}

	private void doMAVOTransformation(Module module, Engine engine, EGraph graph) {

		long startTime = System.nanoTime();
		for (String transformationRule : transformationRules) {
			Rule rule = (Rule) module.getUnit(transformationRule);
			matchAndTransform(rule, engine, graph);
		}
		for (String transformationRuleMAVO : transformationRulesMAVO) {
			Rule rule = (Rule) module.getUnit(transformationRuleMAVO);
			matchMAVOAndTransform(rule, engine, graph);
		}
		long endTime = System.nanoTime();

		timeMAVO = endTime - startTime;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			model,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);
		initOutput();
		mayModelObjsNBar = new ArrayList<Set<MAVOElement>>();
		mayModelObjsC = new HashSet<MAVOElement>();
		mayModelObjsD = new HashSet<MAVOElement>();
		mayModelObjsA = new HashSet<MAVOElement>();
		mavoModelObjsCDN = new HashSet<MAVOElement>();
		mavoModelObjACounter = 0;
		mayFormulaConstants = new HashSet<String>();
		smtEncoding = new StringBuilder();
		mayFormulaIterations = 0;

		// init SMT encoding
		for (String mayFormulaId : mayFormulaIds) {
			mayFormulaConstants.add(mayFormulaId);
		}
		createZ3ApplyFormulaConstant();
		smtEncoding.append(SMTLIB_APPLICABILITY_PREAMBLE);
		smtEncoding.append(mayFormula);
		smtEncoding.append(SMTLIB_APPLICABILITY_POSTAMBLE);

		// do transformations
		//TODO MMTF: implement D support and OR-ed N support
		System.setProperty(PROPERTY_LIBRARY_PATH, LIBRARY_PATH);
		String fullUri = MultiModelRegistry.prependWorkspaceToUri(MultiModelRegistry.replaceLastSegmentInUri(model.getUri(), ""));
		HenshinResourceSet resourceSet = new HenshinResourceSet(fullUri);
		Module module = resourceSet.getModule(transformationModule, false);
		Engine engine = new EngineImpl();
		EGraph graph = new EGraphImpl(resourceSet.getResource(MultiModelRegistry.getLastSegmentFromUri(model.getUri())));
		if (timeClassicalEnabled) {
			doClassicalTransformation(module, engine, graph);
			resourceSet = new HenshinResourceSet(fullUri);
			module = resourceSet.getModule(transformationModule, false);
			engine = new EngineImpl();
			graph = new EGraphImpl(resourceSet.getResource(MultiModelRegistry.getLastSegmentFromUri(model.getUri())));
		}
		doMAVOTransformation(module, engine, graph);

		// save transformed model(s) and update mid
		EList<Model> result = new BasicEList<Model>();
		boolean updateMid = MultiModelOperatorUtils.isUpdatingMid(inputProperties);
		MultiModel multiModel = (updateMid) ?
			MultiModelRegistry.getMultiModel(model) :
			null;
		EObject rootInput = null, rootOutput = null;
		for (EObject root : graph.getRoots()) {
			if (root instanceof Trace) {
				continue;
			}
			if (rootInput == null) {
				rootInput = root;
				continue;
			}
			if (rootOutput == null) {
				rootOutput = root;
			}
		}
		Model modelInputType = MultiModelTypeRegistry.getExtendibleElementType(rootInput.eClass().getEPackage().getNsURI());
		String transformedModelInputUri = MultiModelRegistry.addFileNameSuffixInUri(model.getUri(), TRANSFORMED_MODELINPUT_SUFFIX);
		String transformedModelInputName = MultiModelRegistry.getLastSegmentFromUri(transformedModelInputUri);
		resourceSet.saveEObject(rootInput, transformedModelInputName);
		Model transformedModelInput = (updateMid) ?
			MultiModelInstanceFactory.createModelAndEditor(modelInputType, transformedModelInputUri, ModelOrigin.CREATED, multiModel) :
			MultiModelInstanceFactory.createModel(modelInputType, transformedModelInputUri, ModelOrigin.CREATED, null);
		result.add(transformedModelInput);
		if (rootOutput != null) {
			Model modelOutputType = MultiModelTypeRegistry.getExtendibleElementType(rootOutput.eClass().getEPackage().getNsURI());
			String transformedModelOutputUri = MultiModelRegistry.replaceFileExtensionInUri(
				MultiModelRegistry.addFileNameSuffixInUri(model.getUri(), TRANSFORMED_MODELOUTPUT_SUFFIX),
				modelOutputType.getFileExtension()
			);
			String transformedModelOutputName = MultiModelRegistry.getLastSegmentFromUri(transformedModelOutputUri);
			resourceSet.saveEObject(rootOutput, transformedModelOutputName);
			Model transformedModelOutput = (updateMid) ?
				MultiModelInstanceFactory.createModelAndEditor(modelOutputType, transformedModelOutputUri, ModelOrigin.CREATED, multiModel) :
				MultiModelInstanceFactory.createModel(modelOutputType, transformedModelOutputUri, ModelOrigin.CREATED, null);
			result.add(transformedModelOutput);
		}

		// save output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			model,
			MultiModelOperatorUtils.getSubdir(inputProperties),
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return result;
	}

}
