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
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.modelepedia.istar_mavo.Actor;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;
import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTSolver;
import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTSolver.CLibrary.Z3IncResult;

public class RE13 extends OperatorExecutableImpl implements Z3SMTSolver {

	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_IStarMAVOToSMTLIB";
	private static final String PROPERTY_IN_TARGETSPROPERTY = "targetsProperty";
	private static final String PROPERTY_IN_TARGETSPROPERTY_DEFAULT = "";
	private static final String PROPERTY_OUT_TIMEPREANALYSIS = "timePreAnalysis";
	private static final String PROPERTY_OUT_TIMEANALYSIS = "timeAnalysis";
	private static final String PROPERTY_OUT_TIMETARGETS = "timeTargets";
	private static final String PROPERTY_OUT_LABELS_SUFFIX = ".labels";
	private static final String PROPERTY_OUT_TARGETS = "targets";

	private static final String[] SMTLIB_LABELS = {"fs", "ps", "un", "co", "pd", "fd", "n"};
	private static final String SMTLIB_CONCRETIZATIONVAR = " c ";
	private static final String SMTLIB_NODE = "node ";

	private boolean timePreAnalysisEnabled;
	private boolean timeTargetsEnabled;
	private String targetsProperty;

	private Map<String, Intention> intentions;
	private Z3IncResult z3IncResult;

	private long timePreAnalysis;
	private long timeAnalysis;
	private long timeTargets;
	private String targets;

	private void readProperties(Properties properties) throws Exception {

		timePreAnalysisEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMEPREANALYSIS+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		timeTargetsEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMETARGETS+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		targetsProperty = MultiModelOperatorUtils.getOptionalStringProperty(properties, PROPERTY_IN_TARGETSPROPERTY, PROPERTY_IN_TARGETSPROPERTY_DEFAULT);
	}

	private void initOutput() {

		timePreAnalysis = -1;
		timeAnalysis = -1;
		timeTargets = -1;
		targets = "0";
	}

	private void init() {

		intentions = new HashMap<String, Intention>();
		initOutput();
	}

	private void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMEPREANALYSIS, String.valueOf(timePreAnalysis));
		properties.setProperty(PROPERTY_OUT_TIMEANALYSIS, String.valueOf(timeAnalysis));
		properties.setProperty(PROPERTY_OUT_TIMETARGETS, String.valueOf(timeTargets));
		properties.setProperty(PROPERTY_OUT_TARGETS, targets);
		String labels;
		for (Map.Entry<String, Intention> entry : intentions.entrySet()) {
			Intention intention = entry.getValue();
			labels = "";
			for (int i = 0; i < SMTLIB_LABELS.length; i++) {
				if ((boolean) intention.eGet(labelSwitch(i))) {
					labels += SMTLIB_LABELS[i] + ",";
				}
			}
			if (!labels.equals("")) {
				labels = labels.substring(0, labels.length()-1);
			}
			properties.setProperty(entry.getKey()+PROPERTY_OUT_LABELS_SUFFIX, labels);
		}
	}

	private EStructuralFeature labelSwitch(int i) {

		EStructuralFeature feature = null;
		switch (i) {
			case 0:
				feature = IStar_MAVOPackage.eINSTANCE.getIntention_FullySatisfied();
				break;
			case 1:
				feature = IStar_MAVOPackage.eINSTANCE.getIntention_PartiallySatisfied();
				break;
			case 2:
				feature = IStar_MAVOPackage.eINSTANCE.getIntention_Unknown();
				break;
			case 3:
				feature = IStar_MAVOPackage.eINSTANCE.getIntention_Conflict();
				break;
			case 4:
				feature = IStar_MAVOPackage.eINSTANCE.getIntention_PartiallyDenied();
				break;
			case 5:
				feature = IStar_MAVOPackage.eINSTANCE.getIntention_FullyDenied();
				break;
			case 6:
				feature = IStar_MAVOPackage.eINSTANCE.getIntention_NoLabel();
				break;
		}

		return feature;
	}

	private void doAnalysis() {

		long startTime = System.nanoTime();

		String intentionProperty, labelProperty;
		for (Map.Entry<String, Intention> entry : intentions.entrySet()) {
			Intention intention = entry.getValue();
			intentionProperty = SMTLIB_ASSERT;
			if (intention.isMay()) {
				intentionProperty +=
					SMTLIB_AND +
					SMTLIB_EXISTS +
					SMTLIB_PREDICATE_START + SMTLIB_PREDICATE_START +
					SMTLIB_CONCRETIZATIONVAR + intention.eClass().getName() +
					SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END +
					SMTLIB_PREDICATE_START + SMTLIB_NODE + entry.getKey() + SMTLIB_CONCRETIZATIONVAR + SMTLIB_PREDICATE_END +
					SMTLIB_PREDICATE_END
				;
			}
			intentionProperty +=
				SMTLIB_FORALL +
				SMTLIB_PREDICATE_START + SMTLIB_PREDICATE_START +
				SMTLIB_CONCRETIZATIONVAR + intention.eClass().getName() +
				SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END +
				SMTLIB_IMPLICATION +
				SMTLIB_PREDICATE_START + SMTLIB_NODE + entry.getKey() + SMTLIB_CONCRETIZATIONVAR + SMTLIB_PREDICATE_END
			;
			for (int i = 0; i < SMTLIB_LABELS.length; i++) {
				labelProperty = intentionProperty + SMTLIB_PREDICATE_START + SMTLIB_LABELS[i] + SMTLIB_CONCRETIZATIONVAR + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END;
				if (intention.isMay()) {
					labelProperty += SMTLIB_PREDICATE_END;
				}
				labelProperty += SMTLIB_PREDICATE_END;
				CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, labelProperty, 1, 0);
				if (z3IncResult.flag == Z3_SAT) {
					intention.eSet(labelSwitch(i), true);
				}
			}
		}

		timeAnalysis = System.nanoTime() - startTime;
	}

	private void doTargets() {

		long startTime = System.nanoTime();

		String property = SMTLIB_ASSERT + targetsProperty + SMTLIB_PREDICATE_END;
		CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, property, 0, 0);
		targets = Integer.toString(z3IncResult.flag);

		timeTargets = System.nanoTime() - startTime;
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

		// get output from previous operator
		IStarMAVOToSMTLIB previousOperator = (previousExecutable == null) ?
			(IStarMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI).getExecutable() :
			(IStarMAVOToSMTLIB) previousExecutable;
		final String smtEncoding = previousOperator.getSMTLIBEncoding();

		// create list of nodes
		IStar istar = (IStar) MultiModelTypeIntrospection.getRoot(istarModel);
		for (Actor actor : istar.getActors()) {
			for (Intention intention : actor.getIntentions()) {
				intentions.put(intention.getName().replace(" ", ""), intention);
			}
		}
		for (Intention intention : istar.getDependums()) {
			intentions.put(intention.getName().replace(" ", ""), intention);
		}

		// run solver
		long startTime = System.nanoTime();
		z3IncResult = CLibrary.OPERATOR_INSTANCE.firstCheckSatAndGetModelIncremental(smtEncoding);
		if (timePreAnalysisEnabled) {
			timePreAnalysis = System.nanoTime() - startTime;
		}
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
