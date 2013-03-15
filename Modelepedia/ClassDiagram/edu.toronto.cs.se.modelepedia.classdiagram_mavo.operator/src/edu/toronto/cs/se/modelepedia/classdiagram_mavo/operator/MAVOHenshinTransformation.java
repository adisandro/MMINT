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

public class MAVOHenshinTransformation extends OperatorExecutableImpl {

	private static final String PROPERTY_IN_TRANSFORMATIONMODULE = "transformationModule";
	private static final String PROPERTY_IN_TRANSFORMATIONRULES = "transformationRules";
	private static final String[] PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT = {};
	private static final String PROPERTY_IN_TRANSFORMATIONRULESMAVO = "transformationRulesMAVO";
	private static final String A_NAC_NAME = "A_NAC";
	private static final String TRANSFORMED_MODELINPUT_SUFFIX = "_transformedInput";
	private static final String TRANSFORMED_MODELOUTPUT_SUFFIX = "_transformedOutput";

	private String transformationModule;
	private String[] transformationRules;
	private String[] transformationRulesMAVO;
	private Set<MAVOElement> mavoModelObjsNNac;
	private Set<MAVOElement> mavoModelObjsANac;
	private Set<MAVOElement> mavoModelObjsC;
	private Set<MAVOElement> mavoModelObjsA;
	private Set<MAVOElement> mavoModelObjsD;

	private void readProperties(Properties properties) throws Exception {

		transformationModule = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONMODULE);
		transformationRules = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULES, PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT);
		transformationRulesMAVO = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_IN_TRANSFORMATIONRULESMAVO);
	}

	private void initOutput() {

		mavoModelObjsNNac = new HashSet<MAVOElement>();
		mavoModelObjsANac = new HashSet<MAVOElement>();
		mavoModelObjsC = new HashSet<MAVOElement>();
		mavoModelObjsA = new HashSet<MAVOElement>();
		mavoModelObjsD = new HashSet<MAVOElement>();
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
				if (!mavoModelObjsNNac.contains(resultNodeTarget)) {
					mavoModelObjsC.add((MAVOElement) resultNodeTarget);
				}
			}
			// (A)dded elements
			else {
				mavoModelObjsA.add((MAVOElement) resultNodeTarget);
				((MAVOElement) resultNodeTarget).setMay(propagateMay);
			}
		}
	}

	private Set<Node> transformNacToContext(NestedCondition conditionNac, Rule ruleNac) {

		Set<Node> nodesNac = new HashSet<Node>();
		Map<Node, Node> forbid2preserve = new HashMap<Node, Node>();
		for (Node nodeNac : conditionNac.getConclusion().getNodes()) {
			if (nodeNac.getAction() != null && nodeNac.getAction().getType() == Action.Type.FORBID) {
				Node newNodeNac = HenshinFactory.eINSTANCE.createNode();
				ruleNac.getLhs().getNodes().add(newNodeNac);
				nodesNac.add(newNodeNac);
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

		return nodesNac;
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

	private void matchNAC(Rule rule, Engine engine, EGraph graph, Set<MAVOElement> mayModelObjs) {

		// 1: do OR-ed (NN)acs
		Map<Match, Set<Node>> mayMatchesNNac = new HashMap<Match, Set<Node>>();
		Map<Match, Set<Node>> nonMayMatchesNNac = new HashMap<Match, Set<Node>>();
		Map<Match, Rule> mayMatchesNNacRules = new HashMap<Match, Rule>();
		// foreach OR-ed (NN)ac
		for (int i = 0; i < rule.getLhs().getNestedConditions().size(); i++) {
			Rule ruleCopyNNac = EcoreUtil.copy(rule);
			NestedCondition conditionNNac = ruleCopyNNac.getLhs().getNestedConditions().get(i);
			if (!(conditionNNac.eContainer() instanceof Not) || conditionNNac.getConclusion().getName().equals(A_NAC_NAME)) {
				continue;
			}
			// (NN)ac
			Set<Node> nodesNNac = transformNacToContext(conditionNNac, ruleCopyNNac);
			// try to match (NN)ac as (C)ontext
matchesNNac:
			for (Match matchNNac : engine.findMatches(ruleCopyNNac, graph, null)) {
				boolean isMayMatchNNac = false;
				for (Node nodeNNac : nodesNNac) {
					EObject nodeTargetNNac = matchNNac.getNodeTarget(nodeNNac);
					if (nodeTargetNNac instanceof MAVOElement) {
						mavoModelObjsNNac.add((MAVOElement) nodeTargetNNac);
						if (((MAVOElement) nodeTargetNNac).isMay()) {
							isMayMatchNNac = true;
						}
					}
				}
				if (isMayMatchNNac) {
					// OR-ed with an already matched (NN)ac, execute just once
					for (Map.Entry<Match, Set<Node>> mayMatchNNac : mayMatchesNNac.entrySet()) {
						if (overlapsWithNodes(matchNNac, nodesNNac, mayMatchNNac.getKey(), mayMatchNNac.getValue())) {
							continue matchesNNac;
						}
					}
					mayMatchesNNac.put(matchNNac, nodesNNac);
					mayMatchesNNacRules.put(matchNNac, ruleCopyNNac);
				}
				else {
					nonMayMatchesNNac.put(matchNNac, nodesNNac);
				}
			}
		}
		// OR-ed with a non-may matched (NN)ac, non-may (NN)ac rule applies
		List<Match> mayMatchesNNacToRemove = new ArrayList<Match>();
		for (Map.Entry<Match, Set<Node>> nonMayMatchNNac : nonMayMatchesNNac.entrySet()) {
			for (Map.Entry<Match, Set<Node>> mayMatchNNac : mayMatchesNNac.entrySet()) {
				if (overlapsWithNodes(nonMayMatchNNac.getKey(), nonMayMatchNNac.getValue(), mayMatchNNac.getKey(), mayMatchNNac.getValue())) {
					mayMatchesNNacToRemove.add(mayMatchNNac.getKey());
				}
			}
		}
		for (Match mayMatchNNacToRemove : mayMatchesNNacToRemove) {
			mayMatchesNNac.remove(mayMatchNNacToRemove);
			mayMatchesNNacRules.remove(mayMatchNNacToRemove);
		}

		// 2: do (AN)ac
		Rule ruleCopyANac = EcoreUtil.copy(rule);
		NestedCondition conditionANac = ruleCopyANac.getLhs().getNAC(A_NAC_NAME);
		List<Match> mayMatchesANac = new ArrayList<Match>();
		List<Match> nonMayMatchesANac = new ArrayList<Match>();
		Set<Node> nodesANac = new HashSet<Node>();
		if (conditionANac != null) {
			// (AN)ac
			nodesANac = transformNacToContext(conditionANac, ruleCopyANac);
			// try to match (AN)ac as (C)ontext
			for (Match matchANac : engine.findMatches(ruleCopyANac, graph, null)) {
				boolean isMayMatchANac = false;
				for (Node nodeANac : nodesANac) {
					EObject nodeTargetANac = matchANac.getNodeTarget(nodeANac);
					if (nodeTargetANac instanceof MAVOElement) {
						mavoModelObjsANac.add((MAVOElement) nodeTargetANac);
						if (((MAVOElement) nodeTargetANac).isMay()) {
							isMayMatchANac = true;
						}
					}
				}
				if (isMayMatchANac) {
					mayMatchesANac.add(matchANac);
				}
				else {
					nonMayMatchesANac.add(matchANac);
				}
			}
			// (AN)ac is just one (no OR among (AN)acs), so no need to check for overlapping
		}
		// check overlapping among (NN)acs and non-may (AN)acs
		mayMatchesNNacToRemove = new ArrayList<Match>();
		for (Match nonMayMatchANac : nonMayMatchesANac) {
			for (Map.Entry<Match, Set<Node>> mayMatchNNac : mayMatchesNNac.entrySet()) {
				if (overlapsWithNodes(nonMayMatchANac, nodesANac, mayMatchNNac.getKey(), mayMatchNNac.getValue())) {
					mayMatchesNNacToRemove.add(mayMatchNNac.getKey());
				}
			}
		}
		for (Match mayMatchNNacToRemove : mayMatchesNNacToRemove) {
			mayMatchesNNac.remove(mayMatchNNacToRemove);
			mayMatchesNNacRules.remove(mayMatchNNacToRemove);
		}

		// 3: this case is independent

		// 4: check overlapping among (NN)acs and may (AN)acs
		mayMatchesNNacToRemove = new ArrayList<Match>();
		for (Match mayMatchANac : mayMatchesANac) {
			for (Map.Entry<Match, Set<Node>> mayMatchNNac : mayMatchesNNac.entrySet()) {
				if (overlapsWithNodes(mayMatchANac, nodesANac, mayMatchNNac.getKey(), mayMatchNNac.getValue())) {
					mayMatchesNNacToRemove.add(mayMatchNNac.getKey());
				}
			}
		}
		for (Match mayMatchNNacToRemove : mayMatchesNNacToRemove) {
			mayMatchesNNac.remove(mayMatchNNacToRemove);
			mayMatchesNNacRules.remove(mayMatchNNacToRemove);
		}
		// propagate may to (A)dded'
		//TODO MMTF: need to transform A->C to match (just like N->C)
		for (Match mayMatchANac : mayMatchesANac) {
		}
		//TODO MMTF: mavoModelObjsANac and mavoModelObjsNNac can overlap??

		// 5: execute may (NN)ac transformations
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setEGraph(graph);
		for (Map.Entry<Match, Rule> mayMatchNNac: mayMatchesNNacRules.entrySet()) {
			application.setRule(mayMatchNNac.getValue());
			applyMatch(application, mayMatchNNac.getKey());
		}
	}

	private void match(Rule rule, Engine engine, EGraph graph, Set<MAVOElement> mayModelObjs) {

		// apply rule
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(rule, graph, null)) {
			applyMatch(application, match);
		}
	}

	private void simpleMatch(Rule rule, Engine engine, EGraph graph) {

		// apply rule once
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(rule, graph, null)) {
			application.setCompleteMatch(match);
			application.execute(null);
			break;
		}
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

		// get MAVO elements
		Set<MAVOElement> mayModelObjs = new HashSet<MAVOElement>();
		TreeIterator<EObject> iter = MultiModelTypeIntrospection.getRoot(model).eAllContents();
		while (iter.hasNext()) {
			EObject modelObj = iter.next();
			if (modelObj instanceof MAVOElement) {
				mayModelObjs.add((MAVOElement) modelObj);
			}
		}

		// do transformation
		String fullUri = MultiModelRegistry.prependWorkspaceToUri(MultiModelRegistry.replaceLastSegmentInUri(model.getUri(), ""));
		HenshinResourceSet resourceSet = new HenshinResourceSet(fullUri);
		Module module = resourceSet.getModule(transformationModule, false);
		Engine engine = new EngineImpl();
		EGraph graph = new EGraphImpl(resourceSet.getResource(MultiModelRegistry.getLastSegmentFromUri(model.getUri())));
		for (String transformationRule : transformationRules) {
			Rule rule = (Rule) module.getUnit(transformationRule);
			simpleMatch(rule, engine, graph);
		}
		for (String transformationRuleMAVO : transformationRulesMAVO) {
			Rule rule = (Rule) module.getUnit(transformationRuleMAVO);
			matchNAC(rule, engine, graph, mayModelObjs);
			match(rule, engine, graph, mayModelObjs);
		}

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
		}System.err.println(mavoModelObjsANac);System.err.println(mavoModelObjsNNac);System.err.println(mavoModelObjsC);System.err.println(mavoModelObjsA);

		return result;
	}

}
