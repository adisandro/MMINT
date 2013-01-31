/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.modelepedia.istar_mavo.Actor;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;
import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTSolver;

public class RE13 extends OperatorExecutableImpl implements Z3SMTSolver {

	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_IStarMAVOToSMTLIB";
	private static final String PROPERTY_IN_TARGETSPROPERTY = "targetsProperty";
	private static final String PROPERTY_OUT_TIMEANALYSIS = "timeAnalysis";
	private static final String PROPERTY_OUT_TIMETARGETS = "timeTargets";
	private static final String PROPERTY_OUT_LABELS_SUFFIX = ".labels";
	private static final String PROPERTY_OUT_TARGETS = "targets";

	private static final String[] SMTLIB_LABELS = {"fs", "ps", "un", "co", "pd", "fd", "n"};
	private static final String SMTLIB_CONCRETIZATIONVAR = " c ";
	private static final String SMTLIB_CONCRETIZATIONSUFFIX = "Concretization";
	private static final String SMTLIB_NODE = "node ";

	private boolean timeTargetsEnabled;
	private String targetsProperty;
	private Map<String, Intention> intentions;
	private long timeAnalysis;
	private long timeTargets;
	private String targets;

	private void readProperties(Properties properties) throws Exception {

		timeTargetsEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMETARGETS+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		targetsProperty = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_TARGETSPROPERTY);
	}

	private void initOutput() {

		intentions = new HashMap<String, Intention>();
		timeAnalysis = -1;
		timeTargets = -1;
		targets = "0";
	}

	private void writeProperties(Properties properties) {

		String labels;

		properties.setProperty(PROPERTY_OUT_TIMEANALYSIS, String.valueOf(timeAnalysis));
		properties.setProperty(PROPERTY_OUT_TIMETARGETS, String.valueOf(timeTargets));
		properties.setProperty(PROPERTY_OUT_TARGETS, targets);
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

	private void doAnalysis(String smtlibEncoding) {

		int z3Result;
		String encoding, elementProperty, property;

		long startTime = System.nanoTime();
		for (Map.Entry<String, Intention> entry : intentions.entrySet()) {
			Intention intention = entry.getValue();
			elementProperty = "";
			if (intention.isMay()) {
				elementProperty +=
					SMTLIB_AND +
					SMTLIB_EXISTS +
					SMTLIB_PREDICATE_START + SMTLIB_PREDICATE_START +
					SMTLIB_CONCRETIZATIONVAR + intention.eClass().getName() + SMTLIB_CONCRETIZATIONSUFFIX +
					SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END +
					SMTLIB_PREDICATE_START + SMTLIB_NODE + entry.getKey() + SMTLIB_CONCRETIZATIONVAR + SMTLIB_PREDICATE_END +
					SMTLIB_PREDICATE_END
				;
			}
			elementProperty +=
				SMTLIB_FORALL +
				SMTLIB_PREDICATE_START + SMTLIB_PREDICATE_START +
				SMTLIB_CONCRETIZATIONVAR + intention.eClass().getName() + SMTLIB_CONCRETIZATIONSUFFIX +
				SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END +
				SMTLIB_IMPLICATION +
				SMTLIB_PREDICATE_START + SMTLIB_NODE + entry.getKey() + SMTLIB_CONCRETIZATIONVAR + SMTLIB_PREDICATE_END
			;
			for (int i = 0; i < SMTLIB_LABELS.length; i++) {
				property = elementProperty + SMTLIB_PREDICATE_START + SMTLIB_LABELS[i] + SMTLIB_CONCRETIZATIONVAR + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END;
				if (intention.isMay()) {
					property += SMTLIB_PREDICATE_END;
				}
				encoding = smtlibEncoding + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END;
				z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(encoding);
				if (z3Result == 1) {
					intention.eSet(labelSwitch(i), true);
				}
			}
		}
		long endTime = System.nanoTime();

		timeAnalysis = endTime - startTime;
	}

	private void doTargets(String smtlibEncoding) {

		long startTime = System.nanoTime();
		String encoding = (targetsProperty.equals("")) ?
			smtlibEncoding :
			smtlibEncoding + SMTLIB_ASSERT + targetsProperty + SMTLIB_PREDICATE_END;
		targets = Integer.toString(CLibrary.OPERATOR_INSTANCE.checkSat(encoding));
		long endTime = System.nanoTime();

		timeTargets = endTime - startTime;
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
		initOutput();

		// get output from previous operator
		IStarMAVOToSMTLIB previousOperator = (previousExecutable == null) ?
			(IStarMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getExtendibleElementType(PREVIOUS_OPERATOR_URI).getExecutable() :
			(IStarMAVOToSMTLIB) previousExecutable;
		final String smtlibEncoding = previousOperator.getSMTLIBEncoding();

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
		System.setProperty(PROPERTY_LIBRARY_PATH, LIBRARY_PATH);
		doAnalysis(smtlibEncoding);
		if (timeTargetsEnabled) {
			doTargets(smtlibEncoding);
		}

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
