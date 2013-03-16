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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
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
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
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
	private static final String A_NAC_NAME = "A_NAC";
	private static final String TRANSFORMED_MODELINPUT_SUFFIX = "_transformedInput";
	private static final String TRANSFORMED_MODELOUTPUT_SUFFIX = "_transformedOutput";

	private String mayFormula;
	private String[] mayFormulaIds;
	private Set<MAVOElement> mayFormulaConstants;
	private String transformationModule;
	private String[] transformationRules;
	private String[] transformationRulesMAVO;
	private List<Set<MAVOElement>> mavoModelObjsNBar;
	private Set<MAVOElement> mavoModelObjsC;
	private Set<MAVOElement> mavoModelObjsA;
	private Set<MAVOElement> mavoModelObjsD;
	private long timeClassical;
	private long timeMAVO;

	private void readProperties(Properties properties) throws Exception {

		mayFormula = MultiModelOperatorUtils.getOptionalStringProperty(properties, PROPERTY_IN_MAYFORMULA, PROPERTY_IN_MAYFORMULA_DEFAULT);
		mayFormulaIds = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_MAYFORMULAIDS, PROPERTY_IN_MAYFORMULAIDS_DEFAULT);
		transformationModule = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONMODULE);
		transformationRules = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULES, PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT);
		transformationRulesMAVO = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULESMAVO);
	}

	private void initOutput() {

		timeClassical = -1;
		timeMAVO = -1;
	}

	private void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMECLASSICAL, String.valueOf(timeClassical));
		properties.setProperty(PROPERTY_OUT_TIMEMAVO, String.valueOf(timeMAVO));
	}

	private void transformMatch(RuleApplication application, Match match, boolean isMayMatch) {

		// apply transformation
		application.setCompleteMatch(match);
		application.execute(null);

		if (!isMayMatch) {
			return;
		}

		// propagate may to (A)dded elements
		Match resultMatch = application.getResultMatch();
resultNodeTargets:
		for (EObject resultNodeTarget : resultMatch.getNodeTargets()) {
			if (!(resultNodeTarget instanceof MAVOElement)) {
				continue;
			}
			// (C)ontext elements
			if (mavoModelObjsC.contains(resultNodeTarget)) {
				continue;
			}
			// (N)ac elements
			for (Set<MAVOElement> mavoModelObjsN : mavoModelObjsNBar) {
				if (mavoModelObjsN.contains(resultNodeTarget)) {
					continue resultNodeTargets;
				}
			}
			// (A)dded elements
			mavoModelObjsA.add((MAVOElement) resultNodeTarget);
			((MAVOElement) resultNodeTarget).setMay(true);
		}
	}

	private void transformMayFormula() {

		// update set of may formula elements
		StringBuilder formula = new StringBuilder();
		formula.append(SMTLIB_OR);
			formula.append(SMTLIB_AND);
				formula.append(SMTLIB_AND);
					formula.append(mayFormula);
					formula.append(" ");
					formula.append(SMTLIB_NOT);
						createZ3ApplyFormula(formula);
					formula.append(SMTLIB_PREDICATE_END);
				formula.append(SMTLIB_PREDICATE_END);
				formula.append(SMTLIB_NOT);
					createZ3ApplyFormulaMatchParts(formula, mavoModelObjsA, SMTLIB_OR);
				formula.append(SMTLIB_PREDICATE_END);
			formula.append(SMTLIB_PREDICATE_END);
			formula.append(SMTLIB_AND);
				formula.append(SMTLIB_AND);
					formula.append(mayFormula);
					formula.append(" ");
					createZ3ApplyFormula(formula);
				formula.append(SMTLIB_PREDICATE_END);
				formula.append(SMTLIB_NOT);
					createZ3ApplyFormulaMatchParts(formula, mavoModelObjsD, SMTLIB_AND);
				formula.append(SMTLIB_PREDICATE_END);
				createZ3ApplyFormulaMatchParts(formula, mavoModelObjsA, SMTLIB_AND);
			formula.append(SMTLIB_PREDICATE_END);
		formula.append(SMTLIB_PREDICATE_END);
		mayFormula = formula.toString();
		for (Set<MAVOElement> mavoModelObjSN : mavoModelObjsNBar) {
			mayFormulaConstants.addAll(mavoModelObjSN);
		}
		mayFormulaConstants.addAll(mavoModelObjsC);
		mayFormulaConstants.addAll(mavoModelObjsD);
		mayFormulaConstants.addAll(mavoModelObjsA);
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

	private void createZ3ApplyFormulaConstant(StringBuilder formula, Set<MAVOElement> mavoModelObjs, boolean isMayFormula) {

		for (MAVOElement mavoModelObj : mavoModelObjs) {
			if (!isMayFormula && mayFormulaConstants.contains(mavoModelObj)) {
				continue;
			}
			formula.append(SMTLIB_CONST);
			formula.append(mavoModelObj.getFormulaId());
			formula.append(" ");
			formula.append(SMTLIB_TYPE_BOOL);
			formula.append(SMTLIB_PREDICATE_END);
		}
	}

	private void createZ3ApplyFormulaConstants(StringBuilder formula) {

		// add may formula constants first
		createZ3ApplyFormulaConstant(formula, mayFormulaConstants, true);

		// add current constants
		Set<MAVOElement> uniqueMavoModelObjsN = new HashSet<MAVOElement>();
		for (Set<MAVOElement> mavoModelObjsN : mavoModelObjsNBar) {
			uniqueMavoModelObjsN.addAll(mavoModelObjsN);
		}
		createZ3ApplyFormulaConstant(formula, uniqueMavoModelObjsN, false);
		createZ3ApplyFormulaConstant(formula, mavoModelObjsC, false);
		createZ3ApplyFormulaConstant(formula, mavoModelObjsD, false);
	}

	private void createZ3ApplyFormulaMatchParts(StringBuilder formula, Set<MAVOElement> mavoModelObjs, String smtlibPredicate) {

		if (mavoModelObjs.isEmpty()) {
			return;
		}

		formula.append(smtlibPredicate);
		for (MAVOElement mavoModelObj : mavoModelObjs) {
			formula.append(mavoModelObj.getFormulaId());
			formula.append(" ");
		}
		formula.append(SMTLIB_PREDICATE_END);
	}

	private void createZ3ApplyFormulaMatchPartN(StringBuilder formula) {

		if (mavoModelObjsNBar.isEmpty()) {
			return;
		}

		formula.append(SMTLIB_NOT);
		formula.append(SMTLIB_OR);
		for (Set<MAVOElement> mavoModelObjsN : mavoModelObjsNBar) {
			createZ3ApplyFormulaMatchParts(formula, mavoModelObjsN, SMTLIB_AND);
		}
		formula.append(SMTLIB_PREDICATE_END);
		formula.append(SMTLIB_PREDICATE_END);
	}

	private void createZ3ApplyFormula(StringBuilder formula) {

		formula.append(SMTLIB_AND);
		formula.append(mayFormula);
		formula.append(SMTLIB_AND);
		createZ3ApplyFormulaMatchPartN(formula);
		createZ3ApplyFormulaMatchParts(formula, mavoModelObjsC, SMTLIB_AND);
		createZ3ApplyFormulaMatchParts(formula, mavoModelObjsD, SMTLIB_AND);
		formula.append(SMTLIB_PREDICATE_END);
		formula.append(SMTLIB_PREDICATE_END);
	}

	private String createZ3CheckableApplyFormula() {

		StringBuilder formula = new StringBuilder();
		createZ3ApplyFormulaConstants(formula);
		formula.append(SMTLIB_ASSERT);
		createZ3ApplyFormula(formula);
		formula.append(SMTLIB_PREDICATE_END);

		return formula.toString();
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

	private boolean isMayMatch(Match match, Set<Node> nodes, Set<MAVOElement> mavoModelObjs) {

		boolean isMayMatch = false;
		for (Node node : nodes) {
			EObject nodeTarget = match.getNodeTarget(node);
			if (nodeTarget instanceof MAVOElement) {
				mavoModelObjs.add((MAVOElement) nodeTarget);
				if (((MAVOElement) nodeTarget).isMay()) {
					isMayMatch = true;
				}
			}
		}

		return isMayMatch;
	}

	private TransformationApplicabilityCondition checkApplicabilityCondition(Rule rule, Engine engine, EGraph graph) {

		Set<Node> nodesN = new HashSet<Node>();
		Set<Node> nodesC = new HashSet<Node>();
		Set<Node> nodesD = new HashSet<Node>();
		//TODO MMTF: loop through all nacs
		Rule ruleCopyN = EcoreUtil.copy(rule);
		NestedCondition conditionN = ruleCopyN.getLhs().getNestedConditions().get(0);
		// (N)ac
		getNNodesAndChangeToC(conditionN, ruleCopyN, nodesN);
		getCDNodes(ruleCopyN, nodesC, nodesD);
		boolean isMayMatchNBar = true;
		List<Match> matchesN = InterpreterUtil.findAllMatches(engine, ruleCopyN, graph, null);
matchesN:
		for (int i = 0; i < matchesN.size(); i++) {
			mavoModelObjsNBar = new ArrayList<Set<MAVOElement>>();
			Set<MAVOElement> mavoModelObjsNi = new HashSet<MAVOElement>();
			mavoModelObjsC = new HashSet<MAVOElement>();
			mavoModelObjsD = new HashSet<MAVOElement>();
			Match matchNi = matchesN.get(i);
			isMayMatchNBar &= isMayMatch(matchNi, nodesN, mavoModelObjsNi);
			mavoModelObjsNBar.add(mavoModelObjsNi);
			// check forall NBar condition
			if (!isMayMatchNBar) {
				continue;
			}
			isMayMatch(matchNi, nodesC, mavoModelObjsC);
			isMayMatch(matchNi, nodesD, mavoModelObjsD);
			for (int j = 0; j < matchesN.size(); j++) {
				if (i == j) {
					continue;
				}
				Match matchNj = matchesN.get(j);
				if (!overlapCD(matchNi, matchNj, nodesC, nodesD)) {
					continue;
				}
				Set<MAVOElement> mavoModelObjsNj = new HashSet<MAVOElement>();
				isMayMatchNBar &= isMayMatch(matchNj, nodesN, mavoModelObjsNj);
				mavoModelObjsNBar.add(mavoModelObjsNj);
				// check forall NBar condition
				if (!isMayMatchNBar) {
					continue matchesN;
				}
				isMayMatch(matchNj, nodesC, mavoModelObjsC);
				isMayMatch(matchNj, nodesD, mavoModelObjsD);
			}
			// check apply formula
			int z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(createZ3CheckableApplyFormula());
			if (z3Result == Z3_SAT) {
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
			mavoModelObjsNBar = new ArrayList<Set<MAVOElement>>();
			mavoModelObjsC = new HashSet<MAVOElement>();
			mavoModelObjsD = new HashSet<MAVOElement>();
			Match match = matches.get(i);
			isMayMatch |= isMayMatch(match, nodesC, mavoModelObjsC);
			isMayMatch |= isMayMatch(match, nodesD, mavoModelObjsD);
			if (isMayMatch) {
				// check apply formula
				int z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(createZ3CheckableApplyFormula());
				if (z3Result == Z3_SAT) {
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
		while ((condition = checkApplicabilityCondition(rule, engine, graph)) != null) {
			application.setRule(condition.getMatchedRule());
			application.setEGraph(graph);
			// transform
			mavoModelObjsA = new HashSet<MAVOElement>();
			transformMatch(application, condition.getMatch(), condition.isMayMatch());
			if (condition.isMayMatch()) {
				transformMayFormula();
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

		// get MAVO elements in formula
		mayFormulaConstants = new HashSet<MAVOElement>();
		TreeIterator<EObject> iter = MultiModelTypeIntrospection.getRoot(model).eAllContents();
		while (iter.hasNext()) {
			EObject modelObj = iter.next();
			if (!(modelObj instanceof MAVOElement)) {
				continue;
			}
			for (String mayFormulaId : mayFormulaIds) {
				if (mayFormulaId.equals(((MAVOElement) modelObj).getFormulaId())) {
					mayFormulaConstants.add((MAVOElement) modelObj);
				}
			}
		}

		// do transformations
		//TODO MMTF: implement D support and OR-ed N support
		System.setProperty(PROPERTY_LIBRARY_PATH, LIBRARY_PATH);
		String fullUri = MultiModelRegistry.prependWorkspaceToUri(MultiModelRegistry.replaceLastSegmentInUri(model.getUri(), ""));
		HenshinResourceSet resourceSet = new HenshinResourceSet(fullUri);
		Module module = resourceSet.getModule(transformationModule, false);
		Engine engine = new EngineImpl();
		EGraph graph = new EGraphImpl(resourceSet.getResource(MultiModelRegistry.getLastSegmentFromUri(model.getUri())));
		doClassicalTransformation(module, engine, graph);
		resourceSet = new HenshinResourceSet(fullUri);
		module = resourceSet.getModule(transformationModule, false);
		engine = new EngineImpl();
		graph = new EGraphImpl(resourceSet.getResource(MultiModelRegistry.getLastSegmentFromUri(model.getUri())));
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
