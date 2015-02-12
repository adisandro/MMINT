/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.henshin.trace.Trace;

import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

/**
 * Implementation of the algorithm in Fig. 6 of the paper:
 * 
 * Rick Salay, Michalis Famelis, Julia Rubin, Alessio Di Sandro, Marsha Chechik:
 * Lifting model transformations to product lines. ICSE 2014: 117-128
 * 
 * @author Alessio Di Sandro
 */
public class ProductLineHenshinTransformation extends LiftingHenshinTransformation {

	protected static final String SMTLIB_APPLICABILITY_PREAMBLE = "(declare-fun fN (Int) Bool) (declare-fun fC (Int) Bool) (declare-fun fD (Int) Bool) (declare-fun fY (Int) Bool) (assert (forall ((i Int)) (= (fY i) (and (not (fN i)) (fC i) (fD i))))) (declare-fun fX (Int) Bool) (assert (forall ((i Int)) (= (fX i)";
	protected static final String SMTLIB_APPLICABILITY_POSTAMBLE = ")))";

	/**
	 * Updates the presence condition of the (A)dded model object to be phi
	 * apply at step ruleApplicationsLifting+1 (algorithm line 6).
	 * 
	 * @param modelObjA
	 *            The (A)dded model object.
	 */
	@Override
	protected void transformModelObjAWhenLifted(MAVOElement modelObjA) {

		modelObjA.setFormulaVariable(SMTLIB_APPLICABILITY_FUN_APPLY + (ruleApplicationsLifting+1) + Z3Utils.SMTLIB_PREDICATE_END);
	}

	@Override
	protected void createZ3ApplyFormula() {

		createZ3ApplyFormulaMatchSetNIteration();
		createZ3ApplyFormulaMatchSetIteration(modelObjsC, SMTLIB_APPLICABILITY_FUN_C, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_TRUE);
		createZ3ApplyFormulaMatchSetIteration(modelObjsD, SMTLIB_APPLICABILITY_FUN_D, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_TRUE);
	}

	protected void updateLiterals() {

		int countLiterals = 0;
		for (MAVOElement modelObjCDN : modelObjsCDN) {
			Integer modelObjCDNLiterals = modelObjsLiterals.get(modelObjCDN);
			if (modelObjCDNLiterals == null) {
				modelObjCDNLiterals = (modelObjCDN.getFormulaVariable().equals(Z3Utils.SMTLIB_TRUE)) ? new Integer(0) : new Integer(1);
				modelObjsLiterals.put(modelObjCDN, modelObjCDNLiterals);
			}
			countLiterals += modelObjCDNLiterals;
		}
		for (MAVOElement modelObjA : modelObjsA) {
			modelObjsLiterals.put(modelObjA, new Integer(countLiterals));
		}
	}

	protected void getMatchedModelObjs(Match match, Set<Node> nodes, Set<MAVOElement> modelObjs, Set<MAVOElement> allModelObjs) {

		for (Node node : nodes) {
			EObject nodeTarget = match.getNodeTarget(node);
			if (nodeTarget instanceof MAVOElement) {
				allModelObjs.add((MAVOElement) nodeTarget);
				if (((MAVOElement) nodeTarget).getFormulaVariable() != null) {
					modelObjs.add((MAVOElement) nodeTarget);
				}
			}
		}
	}

	private TransformationApplicabilityCondition checkApplicabilityConditions(Rule rule, Engine engine, EGraph graph, Z3IncrementalSolver z3IncSolver) {

		for (int i = 0; i < rule.getLhs().getNACs().size(); i++) { // one Nac at a time
			Rule ruleCopyN = EcoreUtil.copy(rule);
			Set<Node> nodesN = new LinkedHashSet<Node>(), nodesC = new LinkedHashSet<Node>(), nodesD = new LinkedHashSet<Node>();
			List<Match> matchesN = findNMatches(ruleCopyN, engine, graph, i, nodesC, nodesD, nodesN);
			for (int j = 0; j < matchesN.size(); j++) {
				modelObjsNBar.clear();
				modelObjsC.clear();
				modelObjsD.clear();
				modelObjsCDN.clear();
				Match matchNj = matchesN.get(j);
				addNBarModelObjs(matchNj, nodesN);
				getMatchedModelObjs(matchNj, nodesC, modelObjsC, modelObjsCDN);
				getMatchedModelObjs(matchNj, nodesD, modelObjsD, modelObjsCDN);
				for (int k = 0; k < matchesN.size(); k++) { // same Nac for NBar
					if (j == k) {
						continue;
					}
					Match matchNk = matchesN.get(k);
					if (!areMatchesOverlapping(matchNj, matchNk, nodesC, nodesC, nodesD, nodesD)) {
						continue;
					}
					addNBarModelObjs(matchNk, nodesN);
				}
				for (int l = 0; l < rule.getLhs().getNACs().size(); l++) { // other Nacs for NBar
					if (l == i) {
						continue;
					}
					Set<Node> nodesNl = new LinkedHashSet<Node>(), nodesCl = new LinkedHashSet<Node>(), nodesDl = new LinkedHashSet<Node>();
					List<Match> matchesNl = findNMatches(EcoreUtil.copy(rule), engine, graph, l, nodesCl, nodesDl, nodesNl);
					for (int m = 0; m < matchesNl.size(); m++) {
						Match matchNm = matchesNl.get(m);
						if (!areMatchesOverlapping(matchNj, matchNm, nodesC, nodesCl, nodesD, nodesDl)) {
							continue;
						}
						addNBarModelObjs(matchNm, nodesNl);
					}
				}
				// check apply formula
				if (checkZ3ApplicabilityFormula(z3IncSolver, smtEncoding.length())) {
					return new TransformationApplicabilityCondition(ruleCopyN, matchNj, true); // <NBar,C,D> lifted match
				}
			}
		}

		// no Nac matched
		Rule ruleCopy = EcoreUtil.copy(rule);
		Set<Node> nodesC = new HashSet<Node>(), nodesD = new HashSet<Node>();
		getCDNodes(ruleCopy, nodesC, nodesD);
		List<Match> matches = InterpreterUtil.findAllMatches(engine, ruleCopy, graph, null);
		for (int i = 0; i < matches.size(); i++) {
			modelObjsNBar.clear();
			modelObjsC.clear();
			modelObjsD.clear();
			modelObjsCDN.clear();
			Match match = matches.get(i);
			getMatchedModelObjs(match, nodesC, modelObjsC, modelObjsCDN);
			getMatchedModelObjs(match, nodesD, modelObjsD, modelObjsCDN);
			// check apply formula
			if (checkZ3ApplicabilityFormula(z3IncSolver, smtEncoding.length())) {
				return new TransformationApplicabilityCondition(ruleCopy, match, true); // <C,D> lifted match
			}
		}

		return null; // no matches
	}

	@Override
	protected void matchAndTransformLifting(Rule rule, Engine engine, EGraph graph, Z3IncrementalSolver z3IncSolver) {

		RuleApplication application = new RuleApplicationImpl(engine);
		TransformationApplicabilityCondition condition;
		// check applicability condition involves defining fN,fC,fD at step ruleApplicationsLifting +
		// invoking the solver (algorithm line 3)
		while ((condition = checkApplicabilityConditions(rule, engine, graph, z3IncSolver)) != null) {
			application.setRule(condition.getMatchedRule());
			application.setEGraph(graph);
			// transform and detect (A)dded model objects
			modelObjsA.clear();
			transformLifting(application, condition.getMatch(), condition.isLiftedMatch());
			if (condition.isLiftedMatch()) {
				ruleApplicationsLifting++;
				updateChains();
				updateLiterals();
			}
			else {
				ruleApplicationsNotLifting++;
			}
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// Using MAVO elements in this operator is a "trick" to reuse the
		// formulaVariable field as the container of presence conditions. It works
		// as long as all elements in the Henshin rules are MAVO elements, the only
		// exception being the root which is always present.

		Model model = actualParameters.get(0);
		// function declarations at step 0 for fN-fC-fD (phis) +
		// function definition at every step for fY (phi apply, algorithm line 2) +
		// function definition at every step for fX (phi P, external constraint)
		initSMTEncoding(SMTLIB_APPLICABILITY_PREAMBLE, SMTLIB_APPLICABILITY_POSTAMBLE);

		// henshin initialization
		String fullUri = MultiModelUtils.prependWorkspaceToUri(MultiModelUtils.replaceLastSegmentInUri(model.getUri(), ""));
		HenshinResourceSet resourceSet = new HenshinResourceSet(fullUri);
		Module module = resourceSet.getModule(transformationModule, false);
		Engine engine = new EngineImpl();
		engine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
		EGraph graph = new EGraphImpl(resourceSet.getResource(MultiModelUtils.getLastSegmentFromUri(model.getUri())));
		// if enabled, run the classical transformation and reinitialize henshin
		if (timeClassicalEnabled) {
			doTransformationClassical(module, engine, graph);
			resourceSet = new HenshinResourceSet(fullUri);
			module = resourceSet.getModule(transformationModule, false);
			engine = new EngineImpl();
			engine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
			graph = new EGraphImpl(resourceSet.getResource(MultiModelUtils.getLastSegmentFromUri(model.getUri())));
		}
		// run the lifted transformation
		doTransformationLifting(module, engine, graph);

		// save transformed model(s) and update mid
		EList<Model> result = new BasicEList<Model>();
		MultiModel multiModel = (isUpdateMID()) ?
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
		Model modelInputType = MultiModelTypeRegistry.getType(rootInput.eClass().getEPackage().getNsURI());
		String transformedModelInputUri = MultiModelUtils.getUniqueUri(
			MultiModelUtils.addFileNameSuffixInUri(model.getUri(), TRANSFORMED_MODEL_SUFFIX),
			true,
			false
		);
		String transformedModelInputName = MultiModelUtils.getLastSegmentFromUri(transformedModelInputUri);
		resourceSet.saveEObject(rootInput, transformedModelInputName);
		Model transformedModelInput = (isUpdateMID()) ?
			modelInputType.createInstanceAndEditor(transformedModelInputUri, ModelOrigin.CREATED, multiModel) :
			modelInputType.createInstance(transformedModelInputUri, ModelOrigin.CREATED, null);
		result.add(transformedModelInput);
		if (rootOutput != null) {
			Model modelOutputType = MultiModelTypeRegistry.getType(rootOutput.eClass().getEPackage().getNsURI());
			String transformedModelOutputUri = MultiModelUtils.getUniqueUri(
				MultiModelUtils.replaceFileExtensionInUri(
					MultiModelUtils.addFileNameSuffixInUri(model.getUri(), TRANSFORMED_MODEL_SUFFIX),
					modelOutputType.getFileExtension()
				),
				true,
				false
			);
			String transformedModelOutputName = MultiModelUtils.getLastSegmentFromUri(transformedModelOutputUri);
			resourceSet.saveEObject(rootOutput, transformedModelOutputName);
			Model transformedModelOutput = (isUpdateMID()) ?
				modelOutputType.createInstanceAndEditor(transformedModelOutputUri, ModelOrigin.CREATED, multiModel) :
				modelOutputType.createInstance(transformedModelOutputUri, ModelOrigin.CREATED, null);
			result.add(transformedModelOutput);
		}

		// save output properties
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			model,
			getInputSubdir(),
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return result;
	}

}
