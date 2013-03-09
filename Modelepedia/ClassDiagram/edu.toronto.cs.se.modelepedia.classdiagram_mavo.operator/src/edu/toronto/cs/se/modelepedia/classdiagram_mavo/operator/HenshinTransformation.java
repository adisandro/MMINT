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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;

public class HenshinTransformation extends OperatorExecutableImpl {

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model cdModel = actualParameters.get(0);

		String fullUri = MultiModelRegistry.prependWorkspaceToUri(MultiModelRegistry.replaceLastSegmentInUri(cdModel.getUri(), ""));
		HenshinResourceSet resourceSet = new HenshinResourceSet(fullUri);
		Module module = resourceSet.getModule("default.henshin", false);
		Engine engine = new EngineImpl();
		EGraph graph = new EGraphImpl(resourceSet.getResource("cd.classdiagram_mavo"));

//		UnitApplication app = new UnitApplicationImpl(engine);
//		app.setUnit(module.getUnit("addGetters"));
//		app.setEGraph(graph);
//		app.execute(null);

		Rule rule = (Rule) module.getUnit("addGetter");
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(rule, graph, null)) {
			application.setCompleteMatch(match);
			application.execute(null);
		}

		resourceSet.saveEObject(graph.getRoots().get(0), "transformed.classdiagram_mavo");
		EList<Model> result = new BasicEList<Model>();

		return result;
	}

}
