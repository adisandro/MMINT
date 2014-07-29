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
package edu.toronto.cs.se.modelepedia.operator.patch;

import java.util.HashSet;
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
import org.eclipse.emf.henshin.model.NestedCondition;
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
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils;

public class MAVOHenshinTransformation extends LiftingHenshinTransformation {

	private static final String A_MODELOBJECT_SMTENCODING_PREFIX = "a";
	private static final String SMTLIB_APPLICABILITY_PREAMBLE = "(declare-fun fN (Int) Bool) (declare-fun fC (Int) Bool) (declare-fun fD (Int) Bool) (declare-fun fA (Int) Bool) (declare-fun fDo (Int) Bool) (declare-fun fAo (Int) Bool) (declare-fun fY (Int) Bool) (assert (forall ((i Int)) (= (fY i) (and (not (fN i)) (fC i) (fD i))))) (declare-fun fX (Int) Bool) (assert (forall ((i Int)) (= (fX i) (ite (= i 0)";
	private static final String SMTLIB_APPLICABILITY_POSTAMBLE = "(or (and (fX (- i 1)) (not (fY i)) (not (fAo i))) (and (and (fX (- i 1)) (fY i)) (not (fDo i)) (fA i)))))))";
	private static final String SMTLIB_APPLICABILITY_FUN_D_OR = SMTLIB_APPLICABILITY_FUN + "Do ";
	private static final String SMTLIB_APPLICABILITY_FUN_A_OR = SMTLIB_APPLICABILITY_FUN + "Ao ";

	@Override
	protected void transformModelObjAWhenLifted(MAVOElement modelObjA) {

		modelObjA.setMay(true);
	}

	@Override
	protected void transformModelObjA(MAVOElement modelObjA) {

		modelObjA.setFormulaVariable(A_MODELOBJECT_SMTENCODING_PREFIX + modelObjACounter);
	}

	private void createZ3ApplyFormulaConstant(Set<MAVOElement> mavoModelObjs) {

		for (MAVOElement mavoModelObj : mavoModelObjs) {
			if (smtEncodingVariables.contains(mavoModelObj.getFormulaVariable())) {
				continue;
			}
			smtEncoding.append(Z3SMTUtils.SMTLIB_CONST);
			smtEncoding.append(mavoModelObj.getFormulaVariable());
			smtEncoding.append(" ");
			smtEncoding.append(Z3SMTUtils.SMTLIB_TYPE_BOOL);
			smtEncoding.append(Z3SMTUtils.SMTLIB_PREDICATE_END);
		}
	}

	private void createZ3ApplyFormulaConstants() {

		Set<MAVOElement> uniqueMayModelObjsN = new HashSet<MAVOElement>();
		for (Set<MAVOElement> mayModelObjsN : modelObjsNBar) {
			uniqueMayModelObjsN.addAll(mayModelObjsN);
		}
		createZ3ApplyFormulaConstant(uniqueMayModelObjsN);
		createZ3ApplyFormulaConstant(modelObjsC);
		createZ3ApplyFormulaConstant(modelObjsD);
	}

	@Override
	protected void createZ3ApplyFormula() {

		createZ3ApplyFormulaConstants();
		createZ3ApplyFormulaMatchSetNIteration();
		createZ3ApplyFormulaMatchSetIteration(modelObjsC, SMTLIB_APPLICABILITY_FUN_C, Z3SMTUtils.SMTLIB_AND, Z3SMTUtils.SMTLIB_TRUE);
		createZ3ApplyFormulaMatchSetIteration(modelObjsD, SMTLIB_APPLICABILITY_FUN_D, Z3SMTUtils.SMTLIB_AND, Z3SMTUtils.SMTLIB_TRUE);
		createZ3ApplyFormulaMatchSetIteration(modelObjsD, SMTLIB_APPLICABILITY_FUN_D_OR, Z3SMTUtils.SMTLIB_OR, Z3SMTUtils.SMTLIB_FALSE);
	}

	@Override
	protected void updateLiterals() {
		// TODO Auto-generated method stub
	}

	protected void getMatchedModelObjs(Match match, Set<Node> nodes, Set<MAVOElement> modelObjs, Set<MAVOElement> allModelObjs) {

		for (Node node : nodes) {
			EObject nodeTarget = match.getNodeTarget(node);
			if (nodeTarget instanceof MAVOElement) {
				allModelObjs.add((MAVOElement) nodeTarget);
				if (((MAVOElement) nodeTarget).isMay()) {
					modelObjs.add((MAVOElement) nodeTarget);
				}
			}
		}
	}

	private TransformationApplicabilityCondition checkApplicabilityConditions(Rule rule, Engine engine, EGraph graph, Z3SMTIncrementalSolver z3IncSolver) {

		Set<Node> nodesN = new HashSet<Node>();
		Set<Node> nodesC = new HashSet<Node>();
		Set<Node> nodesD = new HashSet<Node>();
		//TODO MMINT: loop through all nacs
		Rule ruleCopyN = EcoreUtil.copy(rule);
//		NestedCondition conditionN = ruleCopyN.getLhs().getNestedConditions().get(0);
		NestedCondition conditionN = ruleCopyN.getLhs().getNAC(ANAC_NAME);
		// (N)ac
		getCDNodes(ruleCopyN, nodesC, nodesD);
		getNNodesAndChangeToC(conditionN, ruleCopyN, nodesN);
		boolean isLiftedMatchNBar = true;
		List<Match> matchesN = InterpreterUtil.findAllMatches(engine, ruleCopyN, graph, null);
matchesN:
		for (int i = 0; i < matchesN.size(); i++) {
			modelObjsNBar.clear();
			Set<MAVOElement> modelObjsNi = new HashSet<MAVOElement>();
			modelObjsC.clear();
			modelObjsD.clear();
			modelObjsCDN.clear();
			Match matchNi = matchesN.get(i);
			getMatchedModelObjs(matchNi, nodesN, modelObjsNi, modelObjsCDN);
			isLiftedMatchNBar &= (modelObjsNi.size() > 0);
			// check forall NBar condition
			if (!isLiftedMatchNBar) {
				continue;
			}
			modelObjsNBar.add(modelObjsNi);
			getMatchedModelObjs(matchNi, nodesC, modelObjsC, modelObjsCDN);
			getMatchedModelObjs(matchNi, nodesD, modelObjsD, modelObjsCDN);
			for (int j = 0; j < matchesN.size(); j++) {
				if (i == j) {
					continue;
				}
				Match matchNj = matchesN.get(j);
				if (!areMatchesOverlapping(matchNi, matchNj, nodesC, nodesD)) {
					continue;
				}
				Set<MAVOElement> modelObjsNj = new HashSet<MAVOElement>();
				getMatchedModelObjs(matchNj, nodesN, modelObjsNj, modelObjsCDN);
				isLiftedMatchNBar &= (modelObjsNj.size() > 0);
				// check forall NBar condition
				if (!isLiftedMatchNBar) {
					continue matchesN;
				}
				modelObjsNBar.add(modelObjsNj);
				getMatchedModelObjs(matchNj, nodesC, modelObjsC, modelObjsCDN);
				getMatchedModelObjs(matchNj, nodesD, modelObjsD, modelObjsCDN);
			}
			// check apply formula
			if (checkZ3ApplicabilityFormula(z3IncSolver)) {
				return new TransformationApplicabilityCondition(ruleCopyN, matchNi, true); // <NBar,C,D> may match
			}
		}

		// no (N)ac matched
		Rule ruleCopy = EcoreUtil.copy(rule);
		nodesN = new HashSet<Node>();
		nodesC = new HashSet<Node>();
		nodesD = new HashSet<Node>();
		getCDNodes(ruleCopy, nodesC, nodesD);
		boolean isLiftedMatch = false;
		List<Match> matches = InterpreterUtil.findAllMatches(engine, ruleCopy, graph, null);
		for (int i = 0; i < matches.size(); i++) {
			modelObjsNBar.clear();
			modelObjsC.clear();
			modelObjsD.clear();
			modelObjsCDN.clear();
			Match match = matches.get(i);
			getMatchedModelObjs(match, nodesC, modelObjsC, modelObjsCDN);
			getMatchedModelObjs(match, nodesD, modelObjsD, modelObjsCDN);
			isLiftedMatch |= (modelObjsC.size() > 0);
			isLiftedMatch |= (modelObjsD.size() > 0);
			if (isLiftedMatch) {
				// check apply formula
				if (checkZ3ApplicabilityFormula(z3IncSolver)) {
					return new TransformationApplicabilityCondition(ruleCopy, match, true); // <C,D> may match
				}
			}
			else {
				return new TransformationApplicabilityCondition(ruleCopy, match, false); // <C,D> classical match
			}
		}

		return null; // no matches
	}

	@Override
	protected void matchAndTransformLifting(Rule rule, Engine engine, EGraph graph, Z3SMTIncrementalSolver z3IncSolver) {

		RuleApplication application = new RuleApplicationImpl(engine);
		TransformationApplicabilityCondition condition;
		while ((condition = checkApplicabilityConditions(rule, engine, graph, z3IncSolver)) != null) {
			application.setRule(condition.getMatchedRule());
			application.setEGraph(graph);
			// transform
			modelObjsA.clear();
			transformLifting(application, condition.getMatch(), condition.isLiftedMatch());
			if (condition.isLiftedMatch()) {
				// update encoding
				createZ3ApplyFormulaConstant(modelObjsA);
				createZ3ApplyFormulaMatchSetIteration(modelObjsA, SMTLIB_APPLICABILITY_FUN_A, Z3SMTUtils.SMTLIB_AND, Z3SMTUtils.SMTLIB_TRUE);
				createZ3ApplyFormulaMatchSetIteration(modelObjsA, SMTLIB_APPLICABILITY_FUN_A_OR, Z3SMTUtils.SMTLIB_OR, Z3SMTUtils.SMTLIB_FALSE);
				ruleApplicationsLifting++;
				updateChains();
				// update set of constants
				for (Set<MAVOElement> mayModelObjsN : modelObjsNBar) {
					for (MAVOElement mayModelObjN : mayModelObjsN) {
						smtEncodingVariables.add(mayModelObjN.getFormulaVariable());
					}
				}
				for (MAVOElement mayModelObjC : modelObjsC) {
					smtEncodingVariables.add(mayModelObjC.getFormulaVariable());
				}
				for (MAVOElement mayModelObjD : modelObjsD) {
					smtEncodingVariables.add(mayModelObjD.getFormulaVariable());
				}
				for (MAVOElement mayModelObjA : modelObjsA) {
					smtEncodingVariables.add(mayModelObjA.getFormulaVariable());
				}
			}
			else {
				ruleApplicationsNotLifting++;
			}
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);
		initSMTEncoding(SMTLIB_APPLICABILITY_PREAMBLE, SMTLIB_APPLICABILITY_POSTAMBLE);

		// do transformations
		//TODO MMINT: implement D support and OR-ed N support
		String fullUri = MultiModelUtils.prependWorkspaceToUri(MultiModelUtils.replaceLastSegmentInUri(model.getUri(), ""));
		HenshinResourceSet resourceSet = new HenshinResourceSet(fullUri);
		Module module = resourceSet.getModule(transformationModule, false);
		Engine engine = new EngineImpl();
		engine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
		EGraph graph = new EGraphImpl(resourceSet.getResource(MultiModelUtils.getLastSegmentFromUri(model.getUri())));
		if (timeClassicalEnabled) {
			doTransformationClassical(module, engine, graph);
			resourceSet = new HenshinResourceSet(fullUri);
			module = resourceSet.getModule(transformationModule, false);
			engine = new EngineImpl();
			engine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
			graph = new EGraphImpl(resourceSet.getResource(MultiModelUtils.getLastSegmentFromUri(model.getUri())));
		}
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
		String transformedModelInputUri = MultiModelUtils.addFileNameSuffixInUri(model.getUri(), TRANSFORMED_MODELINPUT_SUFFIX);
		String transformedModelInputName = MultiModelUtils.getLastSegmentFromUri(transformedModelInputUri);
		resourceSet.saveEObject(rootInput, transformedModelInputName);
		Model transformedModelInput = (isUpdateMID()) ?
			modelInputType.createInstanceAndEditor(transformedModelInputUri, ModelOrigin.CREATED, multiModel) :
			modelInputType.createInstance(transformedModelInputUri, ModelOrigin.CREATED, null);
		result.add(transformedModelInput);
		if (rootOutput != null) {
			Model modelOutputType = MultiModelTypeRegistry.getType(rootOutput.eClass().getEPackage().getNsURI());
			String transformedModelOutputUri = MultiModelUtils.replaceFileExtensionInUri(
				MultiModelUtils.addFileNameSuffixInUri(model.getUri(), TRANSFORMED_MODELOUTPUT_SUFFIX),
				modelOutputType.getFileExtension()
			);
			String transformedModelOutputName = MultiModelUtils.getLastSegmentFromUri(transformedModelOutputUri);
			resourceSet.saveEObject(rootOutput, transformedModelOutputName);
			Model transformedModelOutput = (isUpdateMID()) ?
				modelOutputType.createInstanceAndEditor(transformedModelOutputUri, ModelOrigin.CREATED, multiModel) :
				modelOutputType.createInstance(transformedModelOutputUri, ModelOrigin.CREATED, null);
			result.add(transformedModelOutput);
		}

		// save output
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
