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
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;

public class HenshinTransformation extends OperatorExecutableImpl {

	private static final String PROPERTY_IN_TRANSFORMATIONMODULE = "transformationModule";
	private static final String PROPERTY_IN_TRANSFORMATIONUNIT = "transformationUnit";
	private static final String TRANSFORMED_MODEL_SUFFIX = "_transformed";

	private String transformationModule;
	private String transformationUnit;

	private void readProperties(Properties properties) throws Exception {

		transformationModule = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONMODULE);
		transformationUnit = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TRANSFORMATIONUNIT);
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
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(rule, graph, null)) {
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
			Match resultMatch = application.getResultMatch();
			for (EObject resultNode : resultMatch.getNodeTargets()) {
				if (!(resultNode instanceof MAVOElement)) {
					continue;
				}
				// created elements
				if (!mayContext.contains((MAVOElement) resultNode)) {
					((MAVOElement) resultNode).setMay(propagateMay);
				}
			}
		}

		resourceSet.saveEObject(
			graph.getRoots().get(0),
			MultiModelRegistry.getLastSegmentFromUri(MultiModelRegistry.addFileNameSuffixInUri(cdModel.getUri(), TRANSFORMED_MODEL_SUFFIX))
		);
		//TODO MMTF: create model for result, add to mid?
		EList<Model> result = new BasicEList<Model>();

		return result;
	}

}
