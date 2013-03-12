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

import java.util.HashSet;
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
import org.eclipse.emf.henshin.model.And;
import org.eclipse.emf.henshin.model.Graph;
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

		// inspect if context has may elements
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
		// propagate may to created elements
		Match resultMatch = application.getResultMatch();
		for (EObject resultNode : resultMatch.getNodeTargets()) {
			if (!(resultNode instanceof MAVOElement)) {
				continue;
			}
			// created elements (A)
			if (!mayContext.contains((MAVOElement) resultNode)) {
				((MAVOElement) resultNode).setMay(true);
			}
		}
	}

	private void matchNAC(Rule rule, Engine engine, EGraph graph) {

		for (int i = 0; i < rule.getLhs().getNestedConditions().size(); i++) {
			Rule ruleCopy = EcoreUtil.copy(rule);
			NestedCondition nac = ruleCopy.getLhs().getNestedConditions().get(i);
			if (!(nac.eContainer() instanceof Not)) {
				continue;
			}
			// NAC
			ruleCopy.getLhs().getNestedConditions().clear();
			ruleCopy.getLhs().setFormula(nac);
			Set<Node> nacNodes = new HashSet<Node>();
			boolean isANAC = false;
			nacNodes.addAll(nac.getConclusion().getNodes());
			if (nac.getConclusion().getName().equals(A_NAC_NAME)) {
				isANAC = true;
			}
		}

		// find NACs
		Rule ruleCopy = EcoreUtil.copy(rule);
		Set<Node> nacNodes = new HashSet<Node>();
		boolean isANAC = false;
		for (NestedCondition nac : ruleCopy.getLhs().getNestedConditions()) {
			//TODO the problem with ORed NACs is that they become ANDed context
			//TODO should really do one at a time and delete all the others :(
			//TODO if they are in binary formula, delete the father
			//TODO but then should not apply all the matches, just one (if at least one match of course)
			if (nac.eContainer() instanceof Not) { // NAC
				EObject x = nac.eContainer().eContainer();
				if (x instanceof Graph) {
					((Graph) x).setFormula(nac);
				}
				else if (x instanceof And) {
					if (((And) x).getLeft() == nac.eContainer()) {
						((And) x).setLeft(nac);
					}
					else { // right
						((And) x).setRight(nac);
					}
				}
				nacNodes.addAll(nac.getConclusion().getNodes());
				if (nac.getConclusion().getName().equals(A_NAC_NAME)) {
					isANAC = true;
				}
			}
		}

		// apply rule without NAC if NAC contains may elements
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(ruleCopy);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(ruleCopy, graph, null)) {
			for (Node nacNode : nacNodes) {
				EObject nacNodeTarget = match.getNodeTarget(nacNode);
				if (nacNodeTarget instanceof MAVOElement && ((MAVOElement) nacNodeTarget).isMay()) {
					if (!isANAC) {
						applyMatch(application, match);
					}
					break;
				}
			}
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
