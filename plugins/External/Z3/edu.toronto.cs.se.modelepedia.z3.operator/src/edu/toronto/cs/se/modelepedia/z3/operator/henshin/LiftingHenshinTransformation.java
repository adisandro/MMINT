/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Formula;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

public abstract class LiftingHenshinTransformation extends RandomOperatorImpl {

    public static class Constraint implements IJavaOperatorConstraint {

        @Override
        public @NonNull Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName, @NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName) {

            Input input = new Input(inputsByName);
            var transformedModel = outputsByName.get(LiftingHenshinTransformation.OUT_MODEL);
            var traceRel = (ModelRel) outputsByName.get(LiftingHenshinTransformation.OUT_MODELREL);
            Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
            List<Model> endpointModels = new ArrayList<>();
            endpointModels.add(input.original);
            endpointModels.add(transformedModel);
            validOutputs.put(traceRel, endpointModels);

            return validOutputs;
        }

    }

    protected static class Input {

        protected Model original;

        public Input(Map<String, Model> inputsByName) {

            this.original = inputsByName.get(LiftingHenshinTransformation.IN_MODEL);
        }
    }

	protected class TransformationApplicabilityCondition {

		private Rule matchedRule;
		private Match match;
		private boolean isLiftedMatch;

		public TransformationApplicabilityCondition(Rule matchedRule, Match match, boolean isLiftedMatch) {
			this.matchedRule = matchedRule;
			this.match = match;
			this.isLiftedMatch = isLiftedMatch;
		}

		public Rule getMatchedRule() {
			return this.matchedRule;
		}

		public Match getMatch() {
			return this.match;
		}

		public boolean isLiftedMatch() {
			return this.isLiftedMatch;
		}
	}


	// input-output
	protected final static @NonNull String IN_MODEL = "original";
	protected final static @NonNull String OUT_MODEL = "transformed";
	protected final static @NonNull String OUT_MODELREL = "trace";
	public static final String PROPERTY_IN_CONSTRAINT = "constraint";
	private static final String PROPERTY_IN_CONSTRAINT_DEFAULT = Z3Utils.SMTLIB_TRUE;
	public static final String PROPERTY_IN_CONSTRAINTVARIABLES = "constraintVariables";
	private static final List<String> PROPERTY_IN_CONSTRAINTVARIABLES_DEFAULT = List.of();
	private static final String PROPERTY_IN_TRANSFORMATIONMODULE = "transformationModule";
	private static final String PROPERTY_IN_TRANSFORMATIONRULES = "transformationRules";
	private static final List<String> PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT = List.of();
	private static final String PROPERTY_IN_TRANSFORMATIONRULESLIFTING = "transformationRulesLifting";
	private static final String PROPERTY_OUT_TIMECLASSICAL = "timeClassical";
	protected static final String PROPERTY_OUT_TIMELIFTING = "timeLifting";
	private static final String PROPERTY_OUT_RULEAPPLICATIONSCLASSICAL = "ruleApplicationsClassical";
	protected static final String PROPERTY_OUT_RULEAPPLICATIONSLIFTING = "ruleApplicationsLifting";
	private static final String PROPERTY_OUT_RULEAPPLICATIONSNOTLIFTING = "ruleApplicationsNotLifting";
	protected static final String PROPERTY_OUT_SATCOUNTLIFTING = "satCountLifting";
	protected static final String PROPERTY_OUT_UNSATCOUNTLIFTING = "unsatCountLifting";
	protected static final String PROPERTY_OUT_SMTENCODINGLENGTH = "smtEncodingLength";
	protected static final String PROPERTY_OUT_SMTENCODINGVARIABLES = "smtEncodingVariables";
	protected static final String PROPERTY_OUT_TRANSFORMEDCONSTRAINT = "transformedConstraint";
	private static final String PROPERTY_OUT_CHAINS = "chains";
	private static final int PROPERTY_OUT_CHAINS_MAX = 10;
	private static final String PROPERTY_OUT_LITERALS = "literals";
	private static final int PROPERTY_OUT_LITERALS_MAX = 10;
	// constants
	protected static final String ANAC_NAME = "A_NAC";
	protected static final String TRANSFORMED_MODEL_SUFFIX = "_transformed";
	protected static final String SMTLIB_APPLICABILITY_FUN = "(f";
	protected static final String SMTLIB_APPLICABILITY_FUN_CONSTRAINTS = LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN + "X ";
	protected static final String SMTLIB_APPLICABILITY_FUN_APPLY = LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN + "Y ";
	protected static final String SMTLIB_APPLICABILITY_FUN_N = LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN + "N ";
	protected static final String SMTLIB_APPLICABILITY_FUN_C = LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN + "C ";
	protected static final String SMTLIB_APPLICABILITY_FUN_D = LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN + "D ";
	protected static final String SMTLIB_APPLICABILITY_FUN_A = LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN + "A ";

	protected String constraint;
	protected List<String> constraintVariables;
	protected String transformationModule;
	protected List<String> transformationRules;
	protected List<String> transformationRulesLifting;

	protected List<Set<PLElement>> modelObjsNBar;
	protected Set<PLElement> modelObjsC;
	protected Set<PLElement> modelObjsD;
	protected Set<PLElement> modelObjsA;
	protected Set<PLElement> modelObjsCDN;
	protected int modelObjACounter;
	protected StringBuilder smtEncoding;
	protected Set<String> smtEncodingVariables;

	protected boolean timeClassicalEnabled;
	protected boolean transformedConstraintEnabled;
	protected long timeClassical;
	protected long timeLifting;
	protected int ruleApplicationsClassical;
	protected int ruleApplicationsLifting;
	protected int ruleApplicationsNotLifting;
	protected int satCountLifting;
	protected int unsatCountLifting;
	protected String transformedConstraint;
	protected Map<PLElement, Integer> modelObjsChains;
	protected Map<PLElement, Integer> modelObjsLiterals;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		this.constraint = MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, LiftingHenshinTransformation.PROPERTY_IN_CONSTRAINT, LiftingHenshinTransformation.PROPERTY_IN_CONSTRAINT_DEFAULT);
		this.constraintVariables = MIDOperatorIOUtils.getOptionalStringPropertyList(inputProperties, LiftingHenshinTransformation.PROPERTY_IN_CONSTRAINTVARIABLES, LiftingHenshinTransformation.PROPERTY_IN_CONSTRAINTVARIABLES_DEFAULT);
		this.transformationModule = MIDOperatorIOUtils.getStringProperty(inputProperties, LiftingHenshinTransformation.PROPERTY_IN_TRANSFORMATIONMODULE);
		this.transformationRules = MIDOperatorIOUtils.getOptionalStringPropertyList(inputProperties, LiftingHenshinTransformation.PROPERTY_IN_TRANSFORMATIONRULES, LiftingHenshinTransformation.PROPERTY_IN_TRANSFORMATIONRULES_DEFAULT);
		this.transformationRulesLifting = MIDOperatorIOUtils.getStringPropertyList(inputProperties, LiftingHenshinTransformation.PROPERTY_IN_TRANSFORMATIONRULESLIFTING);
		this.timeClassicalEnabled = MIDOperatorIOUtils.getBoolProperty(inputProperties, LiftingHenshinTransformation.PROPERTY_OUT_TIMECLASSICAL+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX);
		this.transformedConstraintEnabled = MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, LiftingHenshinTransformation.PROPERTY_OUT_TRANSFORMEDCONSTRAINT+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX, false);
	}

	protected void writeProperties(Properties properties) {

		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_TIMECLASSICAL, String.valueOf(this.timeClassical));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_TIMELIFTING, String.valueOf(this.timeLifting));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_RULEAPPLICATIONSCLASSICAL, String.valueOf(this.ruleApplicationsClassical));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_RULEAPPLICATIONSLIFTING, String.valueOf(this.ruleApplicationsLifting));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_RULEAPPLICATIONSNOTLIFTING, String.valueOf(this.ruleApplicationsNotLifting));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_SATCOUNTLIFTING, String.valueOf(this.satCountLifting));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_UNSATCOUNTLIFTING, String.valueOf(this.unsatCountLifting));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_SMTENCODINGLENGTH, String.valueOf(this.smtEncoding.length()));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_SMTENCODINGVARIABLES, String.valueOf(this.smtEncodingVariables.size()));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_TRANSFORMEDCONSTRAINT, this.transformedConstraint);
		var chains = new int[LiftingHenshinTransformation.PROPERTY_OUT_CHAINS_MAX];
		for (int chain : this.modelObjsChains.values()) {
			if (chain >= LiftingHenshinTransformation.PROPERTY_OUT_CHAINS_MAX) {
				chains[LiftingHenshinTransformation.PROPERTY_OUT_CHAINS_MAX-1]++;
			}
			else {
				chains[chain]++;
			}
		}
		for (var i = 0; i < chains.length; i++) {
			if (chains[i] > 0) {
				properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_CHAINS+i, String.valueOf(chains[i]));
			}
		}
		var literals = new int[LiftingHenshinTransformation.PROPERTY_OUT_LITERALS_MAX];
		for (int literal : this.modelObjsLiterals.values()) {
			if (literal >= LiftingHenshinTransformation.PROPERTY_OUT_LITERALS_MAX) {
				literals[LiftingHenshinTransformation.PROPERTY_OUT_LITERALS_MAX-1]++;
			}
			else {
				literals[literal]++;
			}
		}
		for (var i = 0; i < literals.length; i++) {
			if (literals[i] > 0) {
				properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_LITERALS+i, String.valueOf(literals[i]));
			}
		}
	}

	protected void init() {

		//state
		this.modelObjsNBar = new ArrayList<>();
		this.modelObjsC = new HashSet<>();
		this.modelObjsD = new HashSet<>();
		this.modelObjsA = new HashSet<>();
		this.modelObjsCDN = new HashSet<>();
		this.modelObjACounter = 0;
		this.smtEncoding = new StringBuilder();
		this.smtEncodingVariables = new HashSet<>();

		// output
		this.timeClassical = -1;
		this.timeLifting = -1;
		this.ruleApplicationsClassical = 0;
		this.ruleApplicationsLifting = 0;
		this.ruleApplicationsNotLifting = 0;
		this.satCountLifting = 0;
		this.unsatCountLifting = 0;
		this.transformedConstraint = "";
		this.modelObjsChains = new HashMap<>();
		this.modelObjsLiterals = new HashMap<>();
	}

	protected void initSMTEncoding(String preamble, String postamble) {

		for (String constraintVariable : this.constraintVariables) {
			this.smtEncodingVariables.add(constraintVariable);
		}
		for (String smtConstant: this.smtEncodingVariables) {
			this.smtEncoding.append(Z3Utils.constant(smtConstant, Z3Utils.SMTLIB_TYPE_BOOL));
		}
		this.smtEncoding.append(preamble);
		this.smtEncoding.append(this.constraint);
		this.smtEncoding.append(postamble);
	}

	protected String createZ3ApplyFormulaMatchSet(Set<PLElement> modelObjs, String innerPredicate, String functionEmpty) {

		var smtEncoding = "";
		if (modelObjs.isEmpty()) {
			smtEncoding += functionEmpty;
		}
		else {
			var simplify = (modelObjs.size() == 1) ? true : false;
			if (!simplify) {
				smtEncoding += innerPredicate;
			}
			for (var modelObj : modelObjs) {
				smtEncoding += modelObj.getPresenceCondition() + " ";
			}
			smtEncoding = smtEncoding.substring(0, smtEncoding.length()-1);
			if (!simplify) {
				smtEncoding += Z3Utils.SMTLIB_PREDICATE_END;
			}
		}

		return smtEncoding;
	}

	protected void createZ3ApplyFormulaMatchSetIteration(Set<PLElement> modelObjs, String functionName, String innerPredicate, String functionEmpty) {

		this.smtEncoding.append(
			Z3Utils.assertion(
				Z3Utils.equality(
					Z3Utils.predicate(functionName, Integer.toString(this.ruleApplicationsLifting + 1)) +
					createZ3ApplyFormulaMatchSet(modelObjs, innerPredicate, functionEmpty)
				)
			)
		);
	}

	protected void createZ3ApplyFormulaMatchSetNIteration() {

		this.smtEncoding.append(Z3Utils.SMTLIB_ASSERT);
		this.smtEncoding.append(Z3Utils.SMTLIB_EQUALITY);
		this.smtEncoding.append(
			Z3Utils.predicate(LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN_N, Integer.toString(this.ruleApplicationsLifting + 1))
		);

		if (this.modelObjsNBar.isEmpty()) {
			this.smtEncoding.append(Z3Utils.SMTLIB_FALSE);
		}
		else {
			var simplify = (this.modelObjsNBar.size() == 1) ? true : false;
			if (!simplify) {
				this.smtEncoding.append(Z3Utils.SMTLIB_OR);
			}
			var previousNSimplified = false;
			for (var modelObjsN : this.modelObjsNBar) {
				if (previousNSimplified && modelObjsN.size() == 1) {
					this.smtEncoding.append(" ");
				}
				//TODO MMINT[LIFTING] review if true or false here when simplifying
				this.smtEncoding.append(
					createZ3ApplyFormulaMatchSet(modelObjsN, Z3Utils.SMTLIB_AND, Z3Utils.SMTLIB_FALSE)
				);
				previousNSimplified = (modelObjsN.size() == 1) ? true : false;
			}
			if (!simplify) {
				this.smtEncoding.append(Z3Utils.SMTLIB_PREDICATE_END);
			}
		}
		this.smtEncoding.append(Z3Utils.SMTLIB_PREDICATE_END);
		this.smtEncoding.append(Z3Utils.SMTLIB_PREDICATE_END);
	}

	protected abstract void createZ3ApplyFormula();

	protected boolean checkZ3ApplicabilityFormula(Z3IncrementalSolver z3IncSolver, int checkpointA) {

		var checkpointUnsat = this.smtEncoding.length();
		createZ3ApplyFormula();
		String applicabilityCondition = Z3Utils.assertion(
			Z3Utils.equality(
				Z3Utils.and(
					Z3Utils.predicate(LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN_CONSTRAINTS, Integer.toString(this.ruleApplicationsLifting)) +
					Z3Utils.predicate(LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN_APPLY, Integer.toString(this.ruleApplicationsLifting + 1))
				) +
				Z3Utils.SMTLIB_TRUE
			)
		);
		Z3Model z3ModelResult = z3IncSolver.checkSatAndGetModel(this.smtEncoding.substring(checkpointA) + applicabilityCondition, Z3IncrementalBehavior.POP_IF_UNSAT);
		if (z3ModelResult.getZ3Result().isSAT()) {
			this.satCountLifting++;
			return true;
		}
		this.smtEncoding.delete(checkpointUnsat, this.smtEncoding.length());
		this.unsatCountLifting++;
		return false;
	}

	protected void updateChains() {

		var maxChain = 0;
		for (var modelObjCDN : this.modelObjsCDN) {
			var modelObjCDNChain = this.modelObjsChains.get(modelObjCDN);
			if (modelObjCDNChain == null) {
				this.modelObjsChains.put(modelObjCDN, new Integer(0));
			}
			else if (modelObjCDNChain > maxChain) {
				maxChain = modelObjCDNChain;
			}
		}
		maxChain++;
		for (var modelObjA : this.modelObjsA) {
			this.modelObjsChains.put(modelObjA, new Integer(maxChain));
		}
	}

	protected abstract void updateLiterals();

	protected void getNNodesAndChangeToC(NestedCondition conditionN, Rule ruleN, Set<Node> nodesN) {

		// (N)ac nodes
		Map<Node, Node> forbid2preserve = new HashMap<>();
		for (Node nodeN : conditionN.getConclusion().getNodes()) {
			if (nodeN.getAction() != null && nodeN.getAction().getType() == Action.Type.FORBID) {
				var newNodeN = HenshinFactory.eINSTANCE.createNode();
				ruleN.getLhs().getNodes().add(newNodeN);
				nodesN.add(newNodeN);
				forbid2preserve.put(nodeN, newNodeN);
				newNodeN.setType(nodeN.getType());
				// Action.Type.PRESERVE has to be set at last
				newNodeN.setAction(new Action(Action.Type.PRESERVE));
				// copy attributes
				for (Attribute attributeN : nodeN.getAttributes()) {
					var newAttributeN = HenshinFactory.eINSTANCE.createAttribute();
					newNodeN.getAttributes().add(newAttributeN);
					newAttributeN.setType(attributeN.getType());
					newAttributeN.setValue(attributeN.getValue());
					newAttributeN.setAction(new Action(Action.Type.PRESERVE));
				}
			}
		}
		for (Edge edgeN : conditionN.getConclusion().getEdges()) {
			if (edgeN.getAction() != null && edgeN.getAction().getType() == Action.Type.FORBID) {
				var newEdgeN = HenshinFactory.eINSTANCE.createEdge();
				ruleN.getLhs().getEdges().add(newEdgeN);
				newEdgeN.setType(edgeN.getType());
				var newSrcNodeN = forbid2preserve.get(edgeN.getSource());
				if (newSrcNodeN == null) {
					newSrcNodeN = conditionN.getMappings().getOrigin(edgeN.getSource());
				}
				newEdgeN.setSource(newSrcNodeN);
				var newTgtNodeN = forbid2preserve.get(edgeN.getTarget());
				if (newTgtNodeN == null) {
					newTgtNodeN = conditionN.getMappings().getOrigin(edgeN.getTarget());
				}
				newEdgeN.setTarget(newTgtNodeN);
				// Action.Type.PRESERVE has to be set at last
				newEdgeN.setAction(new Action(Action.Type.PRESERVE));
			}
		}
		ruleN.getLhs().setFormula(null);
	}

	protected void getCDNodes(Rule rule, Set<Node> nodesC, Set<Node> nodesD) {

		for (Node node : rule.getLhs().getNodes()) {
			if (node.getAction() != null) {
				if (node.getAction().getType() == Action.Type.PRESERVE) {
					nodesC.add(node);
				}
				else if (node.getAction().getType() == Action.Type.DELETE) {
					nodesD.add(node);
				}
			}
		}
	}

	protected boolean areMatchesOverlapping(Match match1, Match match2, Set<Node> nodesC1, Set<Node> nodesC2, Set<Node> nodesD1, Set<Node> nodesD2) {

		// nodesC1 and nodesC2 are the same set of nodes by construction, but they could be from different copies of the same rule (same for nodesD1 and nodesD2)
		// the underlying model element instead is the same
		var same = (nodesC1 == nodesC2);
		Iterator<Node> iter1 = nodesC1.iterator(), iter2 = null;
		if (!same) {
			iter2 = nodesC2.iterator();
		}
		while (iter1.hasNext()) {
			var nodeC1 = iter1.next();
			var nodeC2 = (same) ? nodeC1 : iter2.next();
			var nodeTargetC1 = match1.getNodeTarget(nodeC1);
			var nodeTargetC2 = match2.getNodeTarget(nodeC2);
			if (nodeTargetC1 != nodeTargetC2) {
				return false;
			}
		}
		iter1 = nodesD1.iterator();
		if (!same) {
			iter2 = nodesD2.iterator();
		}
		while (iter1.hasNext()) {
			var nodeD1 = iter1.next();
			var nodeD2 = (same) ? nodeD1 : iter2.next();
			var nodeTargetD1 = match1.getNodeTarget(nodeD1);
			var nodeTargetD2 = match2.getNodeTarget(nodeD2);
			if (nodeTargetD1 != nodeTargetD2) {
				return false;
			}
		}

		return true;
	}

	protected List<Match> findNMatches(Rule rule, Engine engine, EGraph graph, int indexN, Set<Node> nodesC, Set<Node> nodesD, Set<Node> nodesN) {

		var conditionN = rule.getLhs().getNACs().get(indexN);
		rule.getLhs().setFormula((Formula) conditionN.eContainer()); // remove other Nacs
		getCDNodes(rule, nodesC, nodesD);
		getNNodesAndChangeToC(conditionN, rule, nodesN);

		return InterpreterUtil.findAllMatches(engine, rule, graph, null);
	}

	protected boolean addNBarModelObjs(Match matchN, Set<Node> nodesN) {

		var modelObjsN = new HashSet<PLElement>();
		getMatchedModelObjs(matchN, nodesN, modelObjsN, this.modelObjsCDN);
		var isLiftedMatchNBar = (modelObjsN.size() > 0);
		if (isLiftedMatchNBar) {
			this.modelObjsNBar.add(modelObjsN);
		}

		return isLiftedMatchNBar;
	}

	protected abstract void getMatchedModelObjs(Match match, Set<Node> nodes, Set<PLElement> modelObjs, Set<PLElement> allModelObjs);

	protected void matchAndTransformClassical(Rule rule, Engine engine, EGraph graph, boolean isLifting) {

		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(rule);
		application.setEGraph(graph);
		for (Match match : engine.findMatches(rule, graph, null)) {
			application.setCompleteMatch(match);
			application.execute(null);
			if (isLifting) {
				this.ruleApplicationsNotLifting++;
			}
			else {
				this.ruleApplicationsClassical++;
			}
		}
	}

	protected void doTransformationClassical(Module module, Engine engine, EGraph graph) {

		var startTime = System.nanoTime();

		for (String transformationRule : this.transformationRules) {
			var rule = (Rule) module.getUnit(transformationRule);
			matchAndTransformClassical(rule, engine, graph, false);
		}
		for (String transformationRuleLifted : this.transformationRulesLifting) {
			var rule = (Rule) module.getUnit(transformationRuleLifted);
			matchAndTransformClassical(rule, engine, graph, false);
		}

		this.timeClassical = System.nanoTime() - startTime;
	}

	protected void transformModelObjAWhenLifted(PLElement modelObjA) {
		// do nothing
	}

	protected void transformModelObjA(PLElement modelObjA) {
		// do nothing
	}

	protected void transformLifting(RuleApplication application, Match match, boolean isLiftedMatch) {

		// apply transformation
		application.setCompleteMatch(match);
		application.execute(null);

		// possibly propagate may to (A)dded elements
		var resultMatch = application.getResultMatch();
		for (EObject resultNodeTarget : resultMatch.getNodeTargets()) {
			if (!(resultNodeTarget instanceof PLElement)) {
				continue;
			}
			// (C)ontext/(D)eleted/(N)ac elements
			if (this.modelObjsCDN.contains(resultNodeTarget)) {
				continue;
			}
			// (A)dded elements
			if (isLiftedMatch) {
				this.modelObjsA.add((PLElement) resultNodeTarget);
				transformModelObjAWhenLifted((PLElement) resultNodeTarget);
			}
			transformModelObjA((PLElement) resultNodeTarget);
			this.modelObjACounter++;
		}
	}

	protected abstract int matchAndTransformLifting(Rule rule, Engine engine, EGraph graph, Z3IncrementalSolver z3IncSolver, int checkpointA);

	protected void doTransformationLifting(Module module, Engine engine, EGraph graph) {

		var startTime = System.nanoTime();

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(this.smtEncoding.toString());
		// run transformation rules marked as classical (e.g. root creation)
		for (String transformationRule : this.transformationRules) {
			var rule = (Rule) module.getUnit(transformationRule);
			matchAndTransformClassical(rule, engine, graph, true);
		}
		// run transformation rules marked as lifted
		var checkpointA = this.smtEncoding.length();
		for (String transformationRuleLifted : this.transformationRulesLifting) {
			var rule = (Rule) module.getUnit(transformationRuleLifted);
			checkpointA = matchAndTransformLifting(rule, engine, graph, z3IncSolver, checkpointA);
		}

		this.timeLifting = System.nanoTime() - startTime;
	}

}
