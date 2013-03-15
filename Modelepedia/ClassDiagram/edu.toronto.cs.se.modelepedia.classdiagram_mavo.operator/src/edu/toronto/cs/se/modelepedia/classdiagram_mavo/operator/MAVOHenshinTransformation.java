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
import org.eclipse.emf.henshin.model.Not;
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

	private void applyMatch(RuleApplication application, Match match) {

		// inspect if (C)ontext has may elements
		Set<MAVOElement> localMavoModelObjsC = new HashSet<MAVOElement>();
		boolean propagateMay = false;
		for (EObject nodeTarget : match.getNodeTargets()) {
			if (!(nodeTarget instanceof MAVOElement)) {
				continue;
			}
			localMavoModelObjsC.add((MAVOElement) nodeTarget);
			propagateMay |= ((MAVOElement) nodeTarget).isMay();
		}

		// apply transformation
		application.setCompleteMatch(match);
		application.execute(null);

		// propagate may to (A)dded elements
		Match resultMatch = application.getResultMatch();
		for (EObject resultNodeTarget : resultMatch.getNodeTargets()) {
			if (!(resultNodeTarget instanceof MAVOElement)) {
				continue;
			}
			// (C)ontext elements
			if (localMavoModelObjsC.contains((MAVOElement) resultNodeTarget)) {
				for (Set<MAVOElement> mavoModelObjsN : mavoModelObjsNBar) {
					if (!mavoModelObjsN.contains(resultNodeTarget)) {
						mavoModelObjsC.add((MAVOElement) resultNodeTarget);
					}
				}
			}
			// (A)dded elements
			else {
				mavoModelObjsA.add((MAVOElement) resultNodeTarget);
				((MAVOElement) resultNodeTarget).setMay(propagateMay);
			}
		}
	}

	private void transformNacToContext(NestedCondition conditionNac, Rule ruleNac, Set<Node> nodesN, Set<Node> nodesC, Set<Node> nodesD) {

		// original rule nodes
		for (Node node : ruleNac.getLhs().getNodes()) {
			if (node.getAction() != null) {
				if (node.getAction().getType() == Action.Type.PRESERVE) {
					nodesC.add(node);
				}
				else if (node.getAction().getType() == Action.Type.DELETE) {
					nodesD.add(node);
				}
			}
		}

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

	private boolean overlapsWithNodes(Match match1, Set<Node> nodes1, Match match2, Set<Node> nodes2) {

		// basic check
		if (!match1.overlapsWith(match2)) {
			return false;
		}

		Set<EObject> modelObjs1 = new HashSet<EObject>();
		for (Node node1 : nodes1) {
			modelObjs1.add(match1.getNodeTarget(node1));
		}
		for (Node node2 : nodes2) {
			if (modelObjs1.contains(match2.getNodeTarget(node2))) {
				return true;
			}
		}

		return false;
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

	private void createZ3ApplyFormulaMatchParts(StringBuilder formula, Set<MAVOElement> mavoModelObjs) {

		if (mavoModelObjs.isEmpty()) {
			return;
		}

		formula.append(SMTLIB_AND);
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
			createZ3ApplyFormulaMatchParts(formula, mavoModelObjsN);
		}
		formula.append(SMTLIB_PREDICATE_END);
		formula.append(SMTLIB_PREDICATE_END);
	}

	private void createZ3ApplyFormula(StringBuilder formula) {

		formula.append(SMTLIB_AND);
		formula.append(mayFormula);
		formula.append(SMTLIB_AND);
		createZ3ApplyFormulaMatchPartN(formula);
		createZ3ApplyFormulaMatchParts(formula, mavoModelObjsC);
		createZ3ApplyFormulaMatchParts(formula, mavoModelObjsD);
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

	private void matchNAC(Rule rule, Engine engine, EGraph graph) {

		//TODO MMTF: loop through all nacs
		Rule ruleCopyN = EcoreUtil.copy(rule);
		NestedCondition conditionN = ruleCopyN.getLhs().getNestedConditions().get(0);
		if (!(conditionN.eContainer() instanceof Not)) {
			return;
		}
		// (N)ac
		Set<Node> nodesN = new HashSet<Node>();
		Set<Node> nodesC = new HashSet<Node>();
		Set<Node> nodesD = new HashSet<Node>();
		transformNacToContext(conditionN, ruleCopyN, nodesN, nodesC, nodesD);
		boolean isMayMatchNBar = true;
		List<Match> matchesN = InterpreterUtil.findAllMatches(engine, ruleCopyN, graph, null);
matchesN:
		for (int i = 0; i < matchesN.size(); i++) {
			mavoModelObjsNBar = new ArrayList<Set<MAVOElement>>();
			Set<MAVOElement> mavoModelObjsNi = new HashSet<MAVOElement>();
			mavoModelObjsC = new HashSet<MAVOElement>();
			mavoModelObjsA = new HashSet<MAVOElement>();//TODO MMTF: move
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
				return; //TODO MMTF:return something
			}
		}
		//TODO MMTF:return something else


//		Map<Match, Set<Node>> mayMatchesN = new HashMap<Match, Set<Node>>();
//		Map<Match, Set<Node>> nonMayMatchesN = new HashMap<Match, Set<Node>>();
//		// foreach OR-ed (N)ac
//		boolean allMayMatchN = true;
//		for (int i = 0; i < rule.getLhs().getNestedConditions().size(); i++) {
//			Rule ruleCopyN = EcoreUtil.copy(rule);
//			NestedCondition conditionN = ruleCopyN.getLhs().getNestedConditions().get(i);
//			if (!(conditionN.eContainer() instanceof Not)) {
//				continue;
//			}
//			// (N)ac
//			Set<Node> nodesN = transformNacToContext(conditionN, ruleCopyN);
//			Set<MAVOElement> mavoModelObjsN = new HashSet<MAVOElement>();
//			mavoModelObjsNBar.add(mavoModelObjsN);
//			// try to match (N)ac as (C)ontext
//matchesN:
//			for (Match matchN : engine.findMatches(ruleCopyN, graph, null)) {
//				boolean isMayMatchN = false;
//				for (Node nodeN : nodesN) {
//					EObject nodeTargetN = matchN.getNodeTarget(nodeN);
//					if (nodeTargetN instanceof MAVOElement) {
//						mavoModelObjsN.add((MAVOElement) nodeTargetN);
//						if (((MAVOElement) nodeTargetN).isMay()) {
//							isMayMatchN = true;
//						}
//					}
//				}
////				if (isMayMatchN) {
////					// OR-ed with an already matched (N)ac, execute just once
////					for (Map.Entry<Match, Set<Node>> mayMatchN : mayMatchesN.entrySet()) {
////						if (overlapsWithNodes(matchN, nodesN, mayMatchN.getKey(), mayMatchN.getValue())) {
////							continue matchesN;
////						}
////					}
////					mayMatchesN.put(matchN, nodesN);
////				}
////				else {
////					nonMayMatchesN.put(matchN, nodesN);
////				}
//				allMayMatchN &= isMayMatchN;
//			}
//		}
////		// OR-ed with a non-may matched (N)ac, non-may (N)ac rule applies
////		List<Match> mayMatchesNToRemove = new ArrayList<Match>();
////		for (Map.Entry<Match, Set<Node>> nonMayMatchN : nonMayMatchesN.entrySet()) {
////			for (Map.Entry<Match, Set<Node>> mayMatchN : mayMatchesN.entrySet()) {
////				if (overlapsWithNodes(nonMayMatchN.getKey(), nonMayMatchN.getValue(), mayMatchN.getKey(), mayMatchN.getValue())) {
////					mayMatchesNToRemove.add(mayMatchN.getKey());
////				}
////			}
////		}
////		for (Match mayMatchNToRemove : mayMatchesNToRemove) {
////			mayMatchesN.remove(mayMatchNToRemove);
////		}
//
//		return allMayMatchN;
	}

	private void matchMAVOAndTransform(Rule rule, Engine engine, EGraph graph) {

		// evaluate apply formula as first thing
		int z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(createZ3ApplyFormula());
		if (z3Result != Z3_SAT) {
			return;
		}
		// remove all (N)acs
		Rule ruleCopy = EcoreUtil.copy(rule);
		ruleCopy.getLhs().setFormula(null);
		// match
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(ruleCopy);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(ruleCopy, graph, null)) {
			applyMatch(application, match);
			z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(createZ3ApplyFormula());
			if (z3Result != Z3_SAT) {
				break;
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
			matchNAC(rule, engine, graph);
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
//		doClassicalTransformation(module, engine, graph);
//		resourceSet = new HenshinResourceSet(fullUri);
//		module = resourceSet.getModule(transformationModule, false);
//		engine = new EngineImpl();
//		graph = new EGraphImpl(resourceSet.getResource(MultiModelRegistry.getLastSegmentFromUri(model.getUri())));
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
