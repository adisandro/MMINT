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

import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;

public class HenshinTransformation extends OperatorExecutableImpl {

	private static final String PROPERTY_IN_TRANSFORMATIONMODULE = "transformationModule";
	private static final String PROPERTY_IN_TRANSFORMATIONUNIT = "transformationUnit";
	private static final String A_NAC_NAME = "A_NAC";
	private static final String TRANSFORMED_MODEL_SUFFIX = "_transformed";

	private String transformationModule;
	private String transformationUnit;

	private void readProperties(Properties properties) throws Exception {

		transformationModule = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONMODULE);
		transformationUnit = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONUNIT);
	}

	private void applyMatch(RuleApplication application, Match match) {

		// inspect if (C)ontext has may elements
		Set<MAVOElement> mayContext = new HashSet<MAVOElement>();
		boolean propagateMay = false;
		for (EObject node : match.getNodeTargets()) {
			if (!(node instanceof MAVOElement)) {
				continue;
			}
			mayContext.add((MAVOElement) node);
			propagateMay |= ((MAVOElement) node).isMay();
		}
		application.setCompleteMatch(match);
		application.execute(null);
		if (!propagateMay) {
			return;
		}
		// propagate may to (A)dded elements
		Match resultMatch = application.getResultMatch();
		for (EObject resultNode : resultMatch.getNodeTargets()) {
			if (!(resultNode instanceof MAVOElement)) {
				continue;
			}
			// (A)dded elements
			if (!mayContext.contains((MAVOElement) resultNode)) {
				((MAVOElement) resultNode).setMay(true);
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

	private void matchNAC(Rule rule, Engine engine, EGraph graph) {

		// firstly, store (AN)ac matches
		Rule ruleCopyANac = EcoreUtil.copy(rule);
		NestedCondition conditionANac = ruleCopyANac.getLhs().getNAC(A_NAC_NAME);
		List<Match> matchesANac = new ArrayList<Match>();
		List<Match> mayMatchesANac = new ArrayList<Match>();//TODO MMTF: needed?
		if (conditionANac != null) {
			// (AN)ac
			Set<Node> nodesANac = transformNacToContext(conditionANac, ruleCopyANac);
			// try to match (AN)ac as (C)ontext
			for (Node nodeANac : nodesANac) {
				nodeANac.setAction(new Action(Action.Type.PRESERVE));
			}
			ruleCopyANac.getLhs().setFormula(null);
			for (Match matchANac : engine.findMatches(ruleCopyANac, graph, null)) {
				matchesANac.add(matchANac);
				for (Node nodeANac : nodesANac) {
					EObject nodeTargetANac = matchANac.getNodeTarget(nodeANac);
					if (nodeTargetANac instanceof MAVOElement && ((MAVOElement) nodeTargetANac).isMay()) {
						mayMatchesANac.add(matchANac);
					}
				}
			}
		}
		//TODO MMTF: propagate may to A-D

		// secondly, do OR-ed (N)acs
		Map<Match, Rule> mayMatchesNac = new HashMap<Match, Rule>();
		// foreach OR-ed (N)ac
		for (int i = 0; i < rule.getLhs().getNestedConditions().size(); i++) {
			Rule ruleCopyNac = EcoreUtil.copy(rule);
			NestedCondition conditionNac = ruleCopyNac.getLhs().getNestedConditions().get(i);
			if (!(conditionNac.eContainer() instanceof Not) || conditionNac.getConclusion().getName().equals(A_NAC_NAME)) {
				continue;
			}
			// (N)ac
			Set<Node> nodesNac = transformNacToContext(conditionNac, ruleCopyNac);
			// try to match (N)ac as (C)ontext
matchesNac:
			for (Match matchNac : engine.findMatches(ruleCopyNac, graph, null)) {
				boolean isMayMatchNac = false;
				for (Node nodeNac : nodesNac) {
					EObject nodeTargetNac = matchNac.getNodeTarget(nodeNac);
					if (nodeTargetNac instanceof MAVOElement && ((MAVOElement) nodeTargetNac).isMay()) {
						isMayMatchNac = true;
						// OR-ed with (AN)ac
						for (Match matchANac : matchesANac) {
							if (matchNac.overlapsWith(matchANac)) {
								continue matchesNac;
							}
						}
						// OR-ed with an already matched (N)ac
						for (Match mayMatchNac : mayMatchesNac.keySet()) {
							if (matchNac.overlapsWith(mayMatchNac)) {
								continue matchesNac;
							}
						}
						mayMatchesNac.put(matchNac, ruleCopyNac);
					}
				}
				if (!isMayMatchNac) {
					List<Match> mayMatchesNacToRemove = new ArrayList<Match>();
					// here OR-ed with an already matched (N)ac removes it
					for (Match mayMatchNac : mayMatchesNac.keySet()) {
						if (matchNac.overlapsWith(mayMatchNac)) {
							mayMatchesNacToRemove.add(mayMatchNac);
						}
					}
					for (Match mayMatchNacToRemove : mayMatchesNacToRemove) {
						mayMatchesNac.remove(mayMatchNacToRemove);
					}
				}
			}
		}

		// execute transformation
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setEGraph(graph);
		for (Map.Entry<Match, Rule> mayMatchNac: mayMatchesNac.entrySet()) {
			application.setRule(mayMatchNac.getValue());
			applyMatch(application, mayMatchNac.getKey());
		}
	}

	private void match(Rule rule, Engine engine, EGraph graph) {

		// apply rule
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(rule, graph, null)) {
			applyMatch(application, match);
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model cdModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			cdModel,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);

		// do transformation
		String fullUri = MultiModelRegistry.prependWorkspaceToUri(MultiModelRegistry.replaceLastSegmentInUri(cdModel.getUri(), ""));
		HenshinResourceSet resourceSet = new HenshinResourceSet(fullUri);
		Module module = resourceSet.getModule(transformationModule, false);
		Engine engine = new EngineImpl();
		EGraph graph = new EGraphImpl(resourceSet.getResource(MultiModelRegistry.getLastSegmentFromUri(cdModel.getUri())));
		Rule rule = (Rule) module.getUnit(transformationUnit);
		matchNAC(rule, engine, graph);
		match(rule, engine, graph);

		// save transformed model
		String newCdModelUri = MultiModelRegistry.addFileNameSuffixInUri(cdModel.getUri(), TRANSFORMED_MODEL_SUFFIX);
		String newCdModelName = MultiModelRegistry.getLastSegmentFromUri(newCdModelUri);
		resourceSet.saveEObject(
			graph.getRoots().get(0),
			newCdModelName
		);
		EList<Model> result = new BasicEList<Model>();
		boolean updateMid = MultiModelOperatorUtils.isUpdatingMid(inputProperties);
		MultiModel multiModel = (updateMid) ?
			MultiModelRegistry.getMultiModel(cdModel) :
			null;
		Model modelType = MultiModelTypeRegistry.getExtendibleElementType(ClassDiagram_MAVOPackage.eINSTANCE.getNsURI());
		Model newCdModel = (updateMid) ?
			MultiModelInstanceFactory.createModelAndEditor(modelType, newCdModelUri, ModelOrigin.CREATED, multiModel) :
			MultiModelInstanceFactory.createModel(modelType, newCdModelUri, ModelOrigin.CREATED, null);
		result.add(newCdModel);

		return result;
	}

}
