/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

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
			smtEncoding.append(Z3Utils.constant(mavoModelObj.getFormulaVariable(), Z3Utils.SMTLIB_TYPE_BOOL));
		}
	}

	private void createZ3ApplyFormulaConstants() {

		Set<MAVOElement> uniqueMayModelObjsN = new HashSet<>();
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
		createZ3ApplyFormulaMatchSetIteration(modelObjsC, SMTLIB_APPLICABILITY_FUN_C, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_TRUE);
		createZ3ApplyFormulaMatchSetIteration(modelObjsD, SMTLIB_APPLICABILITY_FUN_D, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_TRUE);
		createZ3ApplyFormulaMatchSetIteration(modelObjsD, SMTLIB_APPLICABILITY_FUN_D_OR, Z3Utils.SMTLIB_OR, Z3Utils.SMTLIB_FALSE);
	}

	@Override
	protected void updateLiterals() {
		// do nothing
	}

	@Override
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

	private TransformationApplicabilityCondition checkApplicabilityConditions(Rule rule, Engine engine, EGraph graph, Z3IncrementalSolver z3IncSolver, int checkpointA) {

		for (int i = 0; i < rule.getLhs().getNACs().size(); i++) { // one Nac at a time
			Rule ruleCopyN = EcoreUtil.copy(rule);
			Set<Node> nodesN = new LinkedHashSet<>(), nodesC = new LinkedHashSet<>(), nodesD = new LinkedHashSet<>();
			List<Match> matchesN = findNMatches(ruleCopyN, engine, graph, i, nodesC, nodesD, nodesN);
matchesN:
			for (int j = 0; j < matchesN.size(); j++) {
				modelObjsNBar.clear();
				modelObjsC.clear();
				modelObjsD.clear();
				modelObjsCDN.clear();
				Match matchNj = matchesN.get(j);
				boolean isLiftedMatchNBar = addNBarModelObjs(matchNj, nodesN);
				if (!isLiftedMatchNBar) {
					continue;
				}
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
					isLiftedMatchNBar = addNBarModelObjs(matchNk, nodesN);
					if (!isLiftedMatchNBar) {
						continue matchesN;
					}
				}
				for (int l = 0; l < rule.getLhs().getNACs().size(); l++) { // other Nacs for NBar
					if (l == i) {
						continue;
					}
					Set<Node> nodesNl = new LinkedHashSet<>(), nodesCl = new LinkedHashSet<>(), nodesDl = new LinkedHashSet<>();
					List<Match> matchesNl = findNMatches(EcoreUtil.copy(rule), engine, graph, l, nodesCl, nodesDl, nodesNl);
					for (int m = 0; m < matchesNl.size(); m++) {
						Match matchNm = matchesNl.get(m);
						if (!areMatchesOverlapping(matchNj, matchNm, nodesC, nodesCl, nodesD, nodesDl)) {
							continue;
						}
						isLiftedMatchNBar = addNBarModelObjs(matchNm, nodesNl);
						if (!isLiftedMatchNBar) {
							continue matchesN;
						}
					}
				}
				// check apply formula
				if (checkZ3ApplicabilityFormula(z3IncSolver, checkpointA)) {
					return new TransformationApplicabilityCondition(ruleCopyN, matchNj, true); // <NBar,C,D> may match
				}
			}
		}

		// no Nac matched
		Rule ruleCopy = EcoreUtil.copy(rule);
		Set<Node> nodesC = new HashSet<>(), nodesD = new HashSet<>();
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
				if (checkZ3ApplicabilityFormula(z3IncSolver, checkpointA)) {
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
	protected int matchAndTransformLifting(Rule rule, Engine engine, EGraph graph, Z3IncrementalSolver z3IncSolver, int checkpointA) {

		RuleApplication application = new RuleApplicationImpl(engine);
		TransformationApplicabilityCondition condition;
		while ((condition = checkApplicabilityConditions(rule, engine, graph, z3IncSolver, checkpointA)) != null) {
			application.setRule(condition.getMatchedRule());
			application.setEGraph(graph);
			// transform
			modelObjsA.clear();
			transformLifting(application, condition.getMatch(), condition.isLiftedMatch());
			if (condition.isLiftedMatch()) {
				// update encoding
				checkpointA = smtEncoding.length();
				createZ3ApplyFormulaConstant(modelObjsA);
				createZ3ApplyFormulaMatchSetIteration(modelObjsA, SMTLIB_APPLICABILITY_FUN_A, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_TRUE);
				createZ3ApplyFormulaMatchSetIteration(modelObjsA, SMTLIB_APPLICABILITY_FUN_A_OR, Z3Utils.SMTLIB_OR, Z3Utils.SMTLIB_FALSE);
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

		return checkpointA;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
	    Input input = new Input(inputsByName);
		super.init();
		super.initSMTEncoding(SMTLIB_APPLICABILITY_PREAMBLE, SMTLIB_APPLICABILITY_POSTAMBLE);

		// do transformations
		String fullUri = FileUtils.prependWorkspacePath(FileUtils.replaceLastSegmentInPath(input.original.getUri(), ""));
		HenshinResourceSet hResourceSet = new HenshinResourceSet(fullUri);
		Module hModule = hResourceSet.getModule(transformationModule, false);
		Engine hEngine = new EngineImpl();
		hEngine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
		EGraph hGraph = new EGraphImpl(hResourceSet.getResource(FileUtils.getLastSegmentFromPath(input.original.getUri())));
		if (timeClassicalEnabled) {
			doTransformationClassical(hModule, hEngine, hGraph);
			hResourceSet = new HenshinResourceSet(fullUri);
			hModule = hResourceSet.getModule(transformationModule, false);
			hEngine = new EngineImpl();
			hEngine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
			hGraph = new EGraphImpl(hResourceSet.getResource(FileUtils.getLastSegmentFromPath(input.original.getUri())));
		}
		doTransformationLifting(hModule, hEngine, hGraph);
		if (transformedConstraintEnabled) {
			transformedConstraint = smtEncoding.toString();
		}

		// output
		EObject transformedRootModelObj = null;
		for (EObject hRoot : hGraph.getRoots()) {
			if (hRoot instanceof Trace) {
				continue;
			}
			transformedRootModelObj = hRoot;
		}
		if (transformedRootModelObj == null) {
			throw new MMINTException("Can't retrieve transformed root model object");
		}
		Model transformedModelType = MIDTypeRegistry.getType(
			transformedRootModelObj.eClass().getEPackage().getNsURI());
		String transformedMIDModelPath = FileUtils.getUniquePath(
			FileUtils.replaceFileExtensionInPath(
				FileUtils.addFileNameSuffixInPath(input.original.getUri(), TRANSFORMED_MODEL_SUFFIX),
				transformedModelType.getFileExtension()),
			true,
			false);
		Model transformedModel = transformedModelType.createInstanceAndEditor(
			transformedRootModelObj,
			transformedMIDModelPath,
			outputMIDsByName.get(OUT_MODEL));
		BinaryModelRel traceRel = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			OUT_MODELREL,
			input.original,
			transformedModel,
			outputMIDsByName.get(OUT_MODELREL));
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, transformedModel);
		outputsByName.put(OUT_MODELREL, traceRel);
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MIDOperatorIOUtils.writePropertiesFile(
			outputProperties,
			this,
			input.original,
			getInputSubdir(),
			MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return outputsByName;
	}

}
