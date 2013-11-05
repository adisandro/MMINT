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
	protected static final String SMTLIB_NODEFUNCTION = "(node ";

	private boolean timeModelEnabled;
	protected boolean timeTargetsEnabled;
	private String targetsProperty;

	protected IStar istar;
	protected Map<String, Intention> intentions;
	protected Set<Intention> intentionLeafs;
	private String smtEncoding;
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
		intentionLeafs = new HashSet<Intention>();
		IStarMAVOToSMTLIB previousOperator = (previousExecutable == null) ?
			(IStarMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI).getExecutable() :
			(IStarMAVOToSMTLIB) previousExecutable;
		smtEncoding = previousOperator.getSMTEncoding();
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

	protected void optimizeAnalysisElements() {

		final Set<String> nodeTypes = new HashSet<String>();
		nodeTypes.add("Task");
		nodeTypes.add("Goal");
		nodeTypes.add("SoftGoal");
		nodeTypes.add("Resource");

		String z3Model = z3IncResult.model.getString(0);
		String searchString;
		int a = 0;
		for (SMTLIBLabel label : SMTLIBLabel.values()) {
			searchString = label.name() + " -> {\n";
			while (true) {
				a = z3Model.indexOf(searchString, a);
				if (a == -1) {
					break;
				}
				a += searchString.length();
				int b = z3Model.indexOf(")) Bool");
				String nodeType = z3Model.substring(a, b);
				if (!nodeTypes.contains(nodeType)) {
					continue;
				}
				// see if type is among universes
				// foreach line until function end
				// if truth value, activate proper flag (allTrue, allFalse, elseTrue, elseFalse)
				// else if function name, look for it and loop
				// else get element name and truth value for it
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
			Intention intention = entry.getValue();
			if (intentionLeafs.contains(intention)) { // skip leafs
				continue;
			}
			intentionProperty = SMTLIB_ASSERT;
			if (intention.isMay()) {
				intentionProperty +=
					SMTLIB_AND +
					Z3SMTUtils.exists(
						Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION + intention.eClass().getName()),
						Z3SMTUtils.predicate(SMTLIB_NODEFUNCTION, entry.getKey() + SMTLIB_CONCRETIZATION)
					)
				;
			}
			intentionProperty +=
				SMTLIB_FORALL +
				SMTLIB_PREDICATE_START +
				Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION + intention.eClass().getName()) +
				SMTLIB_PREDICATE_END +
				SMTLIB_IMPLICATION +
				Z3SMTUtils.predicate(SMTLIB_NODEFUNCTION, entry.getKey() + SMTLIB_CONCRETIZATION)
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
					optimizeAnalysisElements();
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
		for (Intention intention : intentions.values()) {
			if (
				intention.isFullySatisfied() ||
				intention.isPartiallySatisfied() ||
				intention.isUnknown() ||
				intention.isConflict() ||
				intention.isPartiallyDenied() ||
				intention.isFullyDenied() ||
				intention.isNoLabel()
			) {
				intentionLeafs.add(intention);
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
