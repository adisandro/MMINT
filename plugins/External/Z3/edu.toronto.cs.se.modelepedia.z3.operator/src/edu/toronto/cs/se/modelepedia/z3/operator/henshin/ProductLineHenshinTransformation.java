/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.henshin.trace.Trace;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.productline.PLElement;
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
	protected void transformModelObjAWhenLifted(PLElement modelObjA) {

		modelObjA.setPresenceCondition(LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN_APPLY + (this.ruleApplicationsLifting+1) + Z3Utils.SMTLIB_PREDICATE_END);
	}

	@Override
	protected void createZ3ApplyFormula() {

		createZ3ApplyFormulaMatchSetNIteration();
		createZ3ApplyFormulaMatchSetIteration(this.modelObjsC, LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN_C, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_TRUE);
		createZ3ApplyFormulaMatchSetIteration(this.modelObjsD, LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN_D, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_TRUE);
	}

	@Override
    protected void updateLiterals() {

		var countLiterals = 0;
		for (var modelObjCDN : this.modelObjsCDN) {
			var modelObjCDNLiterals = this.modelObjsLiterals.get(modelObjCDN);
			if (modelObjCDNLiterals == null) {
				modelObjCDNLiterals = (modelObjCDN.getPresenceCondition().equals(Z3Utils.SMTLIB_TRUE)) ? new Integer(0) : new Integer(1);
				this.modelObjsLiterals.put(modelObjCDN, modelObjCDNLiterals);
			}
			countLiterals += modelObjCDNLiterals;
		}
		for (var modelObjA : this.modelObjsA) {
			this.modelObjsLiterals.put(modelObjA, new Integer(countLiterals));
		}
	}

	@Override
    protected void getMatchedModelObjs(Match match, Set<Node> nodes, Set<PLElement> modelObjs, Set<PLElement> allModelObjs) {

		for (Node node : nodes) {
			var nodeTarget = match.getNodeTarget(node);
			if (nodeTarget instanceof PLElement) {
				allModelObjs.add((PLElement) nodeTarget);
				if (((PLElement) nodeTarget).getPresenceCondition() != null) {
					modelObjs.add((PLElement) nodeTarget);
				}
			}
		}
	}

	private TransformationApplicabilityCondition checkApplicabilityConditions(Rule rule, Engine engine, EGraph graph, Z3IncrementalSolver z3IncSolver) {

		for (var i = 0; i < rule.getLhs().getNACs().size(); i++) { // one Nac at a time
			var ruleCopyN = EcoreUtil.copy(rule);
			Set<Node> nodesN = new LinkedHashSet<>(), nodesC = new LinkedHashSet<>(), nodesD = new LinkedHashSet<>();
			var matchesN = findNMatches(ruleCopyN, engine, graph, i, nodesC, nodesD, nodesN);
			for (var j = 0; j < matchesN.size(); j++) {
				this.modelObjsNBar.clear();
				this.modelObjsC.clear();
				this.modelObjsD.clear();
				this.modelObjsCDN.clear();
				var matchNj = matchesN.get(j);
				addNBarModelObjs(matchNj, nodesN);
				getMatchedModelObjs(matchNj, nodesC, this.modelObjsC, this.modelObjsCDN);
				getMatchedModelObjs(matchNj, nodesD, this.modelObjsD, this.modelObjsCDN);
				for (var k = 0; k < matchesN.size(); k++) { // same Nac for NBar
					if (j == k) {
						continue;
					}
					var matchNk = matchesN.get(k);
					if (!areMatchesOverlapping(matchNj, matchNk, nodesC, nodesC, nodesD, nodesD)) {
						continue;
					}
					addNBarModelObjs(matchNk, nodesN);
				}
				for (var l = 0; l < rule.getLhs().getNACs().size(); l++) { // other Nacs for NBar
					if (l == i) {
						continue;
					}
					Set<Node> nodesNl = new LinkedHashSet<>(), nodesCl = new LinkedHashSet<>(), nodesDl = new LinkedHashSet<>();
					var matchesNl = findNMatches(EcoreUtil.copy(rule), engine, graph, l, nodesCl, nodesDl, nodesNl);
					for (var m = 0; m < matchesNl.size(); m++) {
						var matchNm = matchesNl.get(m);
						if (!areMatchesOverlapping(matchNj, matchNm, nodesC, nodesCl, nodesD, nodesDl)) {
							continue;
						}
						addNBarModelObjs(matchNm, nodesNl);
					}
				}
				// check apply formula
				if (checkZ3ApplicabilityFormula(z3IncSolver, this.smtEncoding.length())) {
					return new TransformationApplicabilityCondition(ruleCopyN, matchNj, true); // <NBar,C,D> lifted match
				}
			}
		}

		// no Nac matched
		var ruleCopy = EcoreUtil.copy(rule);
		Set<Node> nodesC = new HashSet<>(), nodesD = new HashSet<>();
		getCDNodes(ruleCopy, nodesC, nodesD);
		var matches = InterpreterUtil.findAllMatches(engine, ruleCopy, graph, null);
		for (var i = 0; i < matches.size(); i++) {
			this.modelObjsNBar.clear();
			this.modelObjsC.clear();
			this.modelObjsD.clear();
			this.modelObjsCDN.clear();
			var match = matches.get(i);
			getMatchedModelObjs(match, nodesC, this.modelObjsC, this.modelObjsCDN);
			getMatchedModelObjs(match, nodesD, this.modelObjsD, this.modelObjsCDN);
			// check apply formula
			if (checkZ3ApplicabilityFormula(z3IncSolver, this.smtEncoding.length())) {
				return new TransformationApplicabilityCondition(ruleCopy, match, true); // <C,D> lifted match
			}
		}

		return null; // no matches
	}

	@Override
	protected int matchAndTransformLifting(Rule rule, Engine engine, EGraph graph, Z3IncrementalSolver z3IncSolver, int checkpointA) {

		RuleApplication application = new RuleApplicationImpl(engine);
		TransformationApplicabilityCondition condition;
		// check applicability condition involves defining fN,fC,fD at step ruleApplicationsLifting +
		// invoking the solver (algorithm line 3)
		while ((condition = checkApplicabilityConditions(rule, engine, graph, z3IncSolver)) != null) {
			application.setRule(condition.getMatchedRule());
			application.setEGraph(graph);
			// transform and detect (A)dded model objects
			this.modelObjsA.clear();
			transformLifting(application, condition.getMatch(), condition.isLiftedMatch());
			if (condition.isLiftedMatch()) {
				this.ruleApplicationsLifting++;
				updateChains();
				updateLiterals();
			}
			else {
				this.ruleApplicationsNotLifting++;
			}
		}

		return this.smtEncoding.length();
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// Using PL elements in this operator works
		// as long as all elements in the Henshin rules are PL elements, the only
		// exception being the root which is always present.

		// input
	    Input input = new Input(inputsByName);
		super.init();
		// function declarations at step 0 for fN-fC-fD (phis) +
		// function definition at every step for fY (phi apply, algorithm line 2) +
		// function definition at every step for fX (phi P, external constraint)
		super.initSMTEncoding(ProductLineHenshinTransformation.SMTLIB_APPLICABILITY_PREAMBLE, ProductLineHenshinTransformation.SMTLIB_APPLICABILITY_POSTAMBLE);

		// do transformations
		String fullUri = FileUtils.prependWorkspacePath(FileUtils.replaceLastSegmentInPath(input.original.getUri(), ""));
		HenshinResourceSet hResourceSet = new HenshinResourceSet(fullUri);
		var hModule = hResourceSet.getModule(this.transformationModule, false);
		Engine hEngine = new EngineImpl();
		hEngine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
		EGraph hGraph = new EGraphImpl(hResourceSet.getResource(FileUtils.getLastSegmentFromPath(input.original.getUri())));
		if (this.timeClassicalEnabled) {
			doTransformationClassical(hModule, hEngine, hGraph);
			hResourceSet = new HenshinResourceSet(fullUri);
			hModule = hResourceSet.getModule(this.transformationModule, false);
			hEngine = new EngineImpl();
			hEngine.getOptions().put(Engine.OPTION_SORT_VARIABLES, false);
			hGraph = new EGraphImpl(hResourceSet.getResource(FileUtils.getLastSegmentFromPath(input.original.getUri())));
		}
		doTransformationLifting(hModule, hEngine, hGraph);
		if (this.transformedConstraintEnabled) {
			this.transformedConstraint = this.smtEncoding.toString();
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
				FileUtils.addFileNameSuffixInPath(input.original.getUri(), LiftingHenshinTransformation.TRANSFORMED_MODEL_SUFFIX),
				transformedModelType.getFileExtension()),
			true,
			false);
		var transformedModel = transformedModelType.createInstanceAndEditor(
			transformedRootModelObj,
			transformedMIDModelPath,
			outputMIDsByName.get(LiftingHenshinTransformation.OUT_MODEL));
		var traceRel = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			LiftingHenshinTransformation.OUT_MODELREL,
			input.original,
			transformedModel,
			outputMIDsByName.get(LiftingHenshinTransformation.OUT_MODELREL));
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(LiftingHenshinTransformation.OUT_MODEL, transformedModel);
		outputsByName.put(LiftingHenshinTransformation.OUT_MODELREL, traceRel);
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MIDOperatorIOUtils.writeOutputProperties(this, outputProperties);

		return outputsByName;
	}

}
