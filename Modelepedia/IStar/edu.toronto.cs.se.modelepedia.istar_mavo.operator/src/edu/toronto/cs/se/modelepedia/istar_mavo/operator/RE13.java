/**
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
package edu.toronto.cs.se.modelepedia.istar_mavo.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTSolver;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTSolver.CLibrary.Z3IncResult;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils;
import edu.toronto.cs.se.modelepedia.istar_mavo.Actor;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;

public class RE13 extends OperatorExecutableImpl implements Z3SMTSolver {

	private enum SMTLIBLabel {

		fs(IStar_MAVOPackage.eINSTANCE.getIntention_FullySatisfied()),
		ps(IStar_MAVOPackage.eINSTANCE.getIntention_PartiallySatisfied()),
		un(IStar_MAVOPackage.eINSTANCE.getIntention_Unknown()),
		co(IStar_MAVOPackage.eINSTANCE.getIntention_Conflict()),
		pd(IStar_MAVOPackage.eINSTANCE.getIntention_PartiallyDenied()),
		fd(IStar_MAVOPackage.eINSTANCE.getIntention_FullyDenied()),
		n(IStar_MAVOPackage.eINSTANCE.getIntention_NoLabel());

		private final EStructuralFeature modelFeature;

		SMTLIBLabel(EStructuralFeature modelFeature) {
			this.modelFeature = modelFeature;
		}

		EStructuralFeature getModelFeature() {
			return modelFeature;
		}
	}

	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_IStarMAVOToSMTLIB";
	private static final String PROPERTY_IN_TARGETSPROPERTY = "targetsProperty";
	private static final String PROPERTY_IN_TARGETSPROPERTY_DEFAULT = "";
	private static final String PROPERTY_OUT_TIMEMODEL = "timeModel";
	private static final String PROPERTY_OUT_TIMEANALYSIS = "timeAnalysis";
	private static final String PROPERTY_OUT_TIMETARGETS = "timeTargets";
	private static final String PROPERTY_OUT_LABELS_SUFFIX = ".labels";
	private static final String PROPERTY_OUT_TARGETS = "targets";

	protected static final String SMTLIB_CONCRETIZATION = " c ";
	protected static final String SMTLIB_NODEFUNCTION = SMTLIB_PREDICATE_START + "node ";
	private static final Set<String> Z3_MODEL_NODETYPES = new HashSet<String>();
	static {
		Z3_MODEL_NODETYPES.add("Task");
		Z3_MODEL_NODETYPES.add("Goal");
		Z3_MODEL_NODETYPES.add("SoftGoal");
		Z3_MODEL_NODETYPES.add("Resource");
	}

	private boolean timeModelEnabled;
	protected boolean timeTargetsEnabled;
	private String targetsProperty;

	protected IStar istar;
	protected Map<String, Intention> intentions;
	protected Set<String> intentionLeafs;
	private String smtEncoding;
	private Map<Integer, String> smtNodes;
	protected Z3IncResult z3IncResult;

	private long timeModel;
	private long timeAnalysis;
	private long timeTargets;
	protected String targets;

	protected void readProperties(Properties properties) throws Exception {

		timeModelEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMEMODEL+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		timeTargetsEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMETARGETS+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		targetsProperty = MultiModelOperatorUtils.getOptionalStringProperty(properties, PROPERTY_IN_TARGETSPROPERTY, PROPERTY_IN_TARGETSPROPERTY_DEFAULT);
	}

	protected void initOutput() {

		timeModel = -1;
		timeAnalysis = -1;
		timeTargets = -1;
		targets = "0";
	}

	protected void init() {

		intentions = new HashMap<String, Intention>();
		intentionLeafs = new HashSet<String>();
		IStarMAVOToSMTLIB previousOperator = (previousExecutable == null) ?
			(IStarMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI).getExecutable() :
			(IStarMAVOToSMTLIB) previousExecutable;
		smtEncoding = previousOperator.getListener().getSMTEncoding();
		smtNodes = previousOperator.getListener().getSMTNodes();
		initOutput();
	}

	protected void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMEMODEL, String.valueOf(timeModel));
		properties.setProperty(PROPERTY_OUT_TIMEANALYSIS, String.valueOf(timeAnalysis));
		properties.setProperty(PROPERTY_OUT_TIMETARGETS, String.valueOf(timeTargets));
		properties.setProperty(PROPERTY_OUT_TARGETS, targets);
		String labels;
		for (Map.Entry<String, Intention> entry : intentions.entrySet()) {
			Intention intention = entry.getValue();
			labels = "";
			for (SMTLIBLabel label : SMTLIBLabel.values()) {
				if ((boolean) intention.eGet(label.getModelFeature())) {
					labels += label.name() + ",";
				}
			}
			if (!labels.equals("")) {
				labels = labels.substring(0, labels.length()-1);
			}
			properties.setProperty(entry.getKey()+PROPERTY_OUT_LABELS_SUFFIX, labels);
		}
	}

	private void optimizeLabelNodes(Map<String, Integer> z3ModelNodes, Set<String> z3LabelNodes, SMTLIBLabel label, String nodeType, boolean elseValue) {

		EStructuralFeature labelFeature = label.getModelFeature();
		if (elseValue) {
			for (Map.Entry<String, Integer> z3ModelNode : z3ModelNodes.entrySet()) {
				String z3ModelNodeName = z3ModelNode.getKey();
				if (!z3ModelNodeName.startsWith(nodeType)) {
					continue;
				}
				if (z3LabelNodes.contains(z3ModelNodeName)) {
					continue;
				}
				Integer z3ModelNodeNumber = z3ModelNode.getValue();
				intentions.get(smtNodes.get(z3ModelNodeNumber)).eSet(labelFeature, true);
			}
		}
		else {
			for (String z3LabelNodeName : z3LabelNodes) {
				Integer z3LabelNodeNumber = z3ModelNodes.get(z3LabelNodeName);
				intentions.get(smtNodes.get(z3LabelNodeNumber)).eSet(labelFeature, true);
			}
		}
	}

	private void optimizeLabelFunction(String z3Model, Map<String, Integer> z3ModelNodes, SMTLIBLabel label, int startIndex) {

		String line;
		int lineLength;
		String[] tokens;
		Set<String> z3LabelNodes = new HashSet<String>();
		boolean firstCheck = true;
		String nodeType = "";
		do {
			line = z3Model.substring(startIndex, z3Model.indexOf(Z3_MODEL_NEWLINE, startIndex)+1);
			lineLength = line.length();
			line = line.trim();
			if (firstCheck) { // just check it once
				if (line.equals("false")) { // all false
					return;
				}
				if (line.equals("true")) { // all true
					//TODO MMTF: do something about it?
					return;
				}
				if (line.startsWith(SMTLIB_PREDICATE_START + label.name())) { // jump to subfunction
					String subfunction = line.substring(1, line.indexOf(' ')) + Z3_MODEL_DEFINITION + Z3_MODEL_FUNCTION_START + Z3_MODEL_NEWLINE;
					optimizeLabelFunction(z3Model, z3ModelNodes, label, z3Model.indexOf(subfunction)+subfunction.length());
					return;
				}
				nodeType = line.substring(0, line.indexOf(Z3_MODEL_SEPARATOR));
				if (!Z3_MODEL_NODETYPES.contains(nodeType)) { // edge function
					return;
				}
			}
			// node function
			firstCheck = false;
			tokens = line.split(Z3_MODEL_DEFINITION);
			if (tokens[0].equals(Z3_MODEL_ELSE)) {
				optimizeLabelNodes(z3ModelNodes, z3LabelNodes, label, nodeType, Boolean.parseBoolean(tokens[1]));
				return;
			}
			z3LabelNodes.add(tokens[0]);
			startIndex += lineLength;
		}
		while (!line.equals(Z3_MODEL_FUNCTION_END));
	}

	private Map<String, Integer> parseZ3ModelNodes(String z3Model) {

		Map<String, Integer> z3ModelNodes = new HashMap<String, Integer>();
		String nodeFunction = "node" + Z3_MODEL_SEPARATOR;
		String nodeFunctionDefinition = Z3_MODEL_DEFINITION + Z3_MODEL_FUNCTION_START + Z3_MODEL_NEWLINE;
		String line;
		int lineLength;

nextNodeFunction:
		for (int i = z3Model.indexOf(nodeFunction); i != -1; i = z3Model.indexOf(nodeFunction, i)) {
			if (z3Model.substring(i-1, i).equals(SMTLIB_PREDICATE_START)) { // function invocation
				i += nodeFunction.length();
				continue;
			}
			i = z3Model.indexOf(nodeFunctionDefinition, i);
			i += nodeFunctionDefinition.length();
			do {
				line = z3Model.substring(i, z3Model.indexOf(Z3_MODEL_NEWLINE, i)+1);
				lineLength = line.length();
				line = line.trim();
				int spaceIndex = line.indexOf(' ');
				String z3ModelNodeNumber = line.substring(0, spaceIndex);
				if (z3ModelNodeNumber.equals(Z3_MODEL_ELSE)) {
					continue nextNodeFunction;
				}
				String z3ModelNodeName = line.substring(spaceIndex+1, line.indexOf(' ', spaceIndex+1));
				z3ModelNodes.put(z3ModelNodeName, new Integer(z3ModelNodeNumber));
				i += lineLength;
			}
			while (!line.equals(Z3_MODEL_FUNCTION_END));
		}

		return z3ModelNodes;
	}

	private void optimizeAnalysis() {

		String z3Model = z3IncResult.model.getString(0);
		Map<String, Integer> z3ModelNodes = parseZ3ModelNodes(z3Model);
		for (SMTLIBLabel label : SMTLIBLabel.values()) {
			String labelFunctionDefinition = label.name() + Z3_MODEL_DEFINITION + Z3_MODEL_FUNCTION_START + Z3_MODEL_NEWLINE;
			for (int i = z3Model.indexOf(labelFunctionDefinition); i != -1; i = z3Model.indexOf(labelFunctionDefinition, i)) {
				i += labelFunctionDefinition.length();
				optimizeLabelFunction(z3Model, z3ModelNodes, label, i);
			}
		}
	}

	protected void doAnalysis() {

		long startTime = System.nanoTime();

		z3IncResult = CLibrary.OPERATOR_INSTANCE.firstCheckSatAndGetModelIncremental(smtEncoding);
		if (timeModelEnabled) {
			timeModel = System.nanoTime() - startTime;
		}
		String intentionProperty, labelProperty;
		for (Map.Entry<String, Intention> entry : intentions.entrySet()) {
			String intentionName = entry.getKey();
			Intention intention = entry.getValue();
			if (intentionLeafs.contains(intentionName)) { // skip leafs
				continue;
			}
			intentionProperty = SMTLIB_ASSERT;
			if (intention.isMay()) {
				intentionProperty +=
					SMTLIB_AND +
					Z3SMTUtils.exists(
						Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION + intention.eClass().getName()),
						Z3SMTUtils.predicate(SMTLIB_NODEFUNCTION, intentionName + SMTLIB_CONCRETIZATION)
					)
				;
			}
			intentionProperty +=
				SMTLIB_FORALL +
				SMTLIB_PREDICATE_START +
				Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION + intention.eClass().getName()) +
				SMTLIB_PREDICATE_END +
				SMTLIB_IMPLICATION +
				Z3SMTUtils.predicate(SMTLIB_NODEFUNCTION, intentionName + SMTLIB_CONCRETIZATION)
			;
			for (SMTLIBLabel label : SMTLIBLabel.values()) {
				if ((boolean) intention.eGet(label.getModelFeature())) { // skip already checked
					continue;
				}
				labelProperty = intentionProperty + Z3SMTUtils.predicate(SMTLIB_PREDICATE_START + label.name(), SMTLIB_CONCRETIZATION) + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END;
				if (intention.isMay()) {
					labelProperty += SMTLIB_PREDICATE_END;
				}
				labelProperty += SMTLIB_PREDICATE_END;
				CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, labelProperty, 1, 0);
				if (z3IncResult.flag == Z3_SAT) {
					intention.eSet(label.getModelFeature(), true);
					optimizeAnalysis();
				}
			}
		}

		timeAnalysis = System.nanoTime() - startTime;
	}

	protected void doTargets() {

		long startTime = System.nanoTime();

		String property = SMTLIB_ASSERT + targetsProperty + SMTLIB_PREDICATE_END;
		CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, property, 0, 0);
		targets = Integer.toString(z3IncResult.flag);

		timeTargets = System.nanoTime() - startTime;
	}

	protected void collectAnalysisModelObjs(Model istarModel) {

		istar = (IStar) MultiModelTypeIntrospection.getRoot(istarModel);
		for (Actor actor : istar.getActors()) {
			for (Intention intention : actor.getIntentions()) {
				intentions.put(intention.getName().replace(" ", ""), intention);
			}
		}
		for (Intention intention : istar.getDependums()) {
			intentions.put(intention.getName().replace(" ", ""), intention);
		}
		for (Map.Entry<String, Intention> entry : intentions.entrySet()) {
			Intention intention = entry.getValue();
			if (
				intention.isFullySatisfied() ||
				intention.isPartiallySatisfied() ||
				intention.isUnknown() ||
				intention.isConflict() ||
				intention.isPartiallyDenied() ||
				intention.isFullyDenied() ||
				intention.isNoLabel()
			) {
				intentionLeafs.add(entry.getKey());
			}
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model istarModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			istarModel,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);
		init();

		// run solver
		collectAnalysisModelObjs(istarModel);
		doAnalysis();
		if (timeTargetsEnabled) {
			doTargets();
		}
		CLibrary.OPERATOR_INSTANCE.freeResultIncremental(z3IncResult);

		// save output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			istarModel,
			null,
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return actualParameters;
	}

}
