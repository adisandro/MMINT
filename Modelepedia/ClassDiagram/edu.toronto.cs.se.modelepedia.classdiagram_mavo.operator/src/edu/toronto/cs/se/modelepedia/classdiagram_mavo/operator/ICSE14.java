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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.operator;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOFactory;
import edu.toronto.cs.se.modelepedia.operator.patch.ProductLineHenshinTransformation;

public class ICSE14 extends ProductLineHenshinTransformation {

	private static final String FEATURE_MODELS_SUBDIR = "featuremodels";

	private static final String PROPERTY_IN_FEATUREMODELNAME = "featureModelName";
	private static final String PROPERTY_IN_NUMRULEELEMENTS = "numRuleElements";
	private static final String PROPERTY_IN_NUMRULEELEMENTS_SEPARATOR = "-";
	private static final String PROPERTY_IN_MODELSIZE = "modelSize";
	private static final String PROPERTY_IN_MAXCHAINS = "maxChains";
	private static final String PROPERTY_IN_NUMITERATIONS = "numIterations";
	private static final String PROPERTY_IN_NACMATCHPERC = "nacMatchPerc";
	private static final double PROPERTY_IN_NACMATCHPERC_DEFAULT = 0.5;
	private static final String PROPERTY_IN_ALWAYSPRESENTPERC = "alwaysPresentPerc";
	private static final double PROPERTY_IN_ALWAYSPRESENTPERC_DEFAULT = 0.5;

	private String featureModelName;
	private int numRuleElementsN;
	private int numRuleElementsC;
	private int numRuleElementsA;
	private int modelSize;
	private int maxChains;
	private int numIterations;
	private double nacMatchPerc;
	private double alwaysPresentPerc;

	private Model inputModel;
	private List<MAVOElement> modelObjsBucketA;
	private List<Integer> modelObjsChainsA;

	protected void readProperties(Properties properties) throws Exception {

		featureModelName = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_FEATUREMODELNAME);
		Properties constraintProperties = new Properties();
		String constraintPropertiesFile = MultiModelUtils.prependWorkspaceToUri(
			MultiModelUtils.replaceLastSegmentInUri(
				inputModel.getUri(),
				FEATURE_MODELS_SUBDIR + MMTF.URI_SEPARATOR + featureModelName + MultiModelOperatorUtils.PROPERTIES_SUFFIX
			)
		);
		constraintProperties.load(new FileInputStream(constraintPropertiesFile));
		constraint = MultiModelOperatorUtils.getStringProperty(constraintProperties, PROPERTY_IN_CONSTRAINT);
		constraintVariables = MultiModelOperatorUtils.getStringProperties(constraintProperties, PROPERTY_IN_CONSTRAINTVARIABLES);
		String[] numRuleElements = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_NUMRULEELEMENTS).split(PROPERTY_IN_NUMRULEELEMENTS_SEPARATOR);
		numRuleElementsN = Integer.parseInt(numRuleElements[0]);
		numRuleElementsC = Integer.parseInt(numRuleElements[1]);
		numRuleElementsA = Integer.parseInt(numRuleElements[2]);
		modelSize = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MODELSIZE);
		maxChains = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MAXCHAINS);
		numIterations = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_NUMITERATIONS);
		nacMatchPerc = MultiModelOperatorUtils.getOptionalDoubleProperty(properties, PROPERTY_IN_NACMATCHPERC, PROPERTY_IN_NACMATCHPERC_DEFAULT);
		alwaysPresentPerc = MultiModelOperatorUtils.getOptionalDoubleProperty(properties, PROPERTY_IN_ALWAYSPRESENTPERC, PROPERTY_IN_ALWAYSPRESENTPERC_DEFAULT);
	}

	protected void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMELIFTING, String.valueOf(timeLifting));
		properties.setProperty(PROPERTY_OUT_SATCOUNT, String.valueOf(satCount));
		properties.setProperty(PROPERTY_OUT_UNSATCOUNT, String.valueOf(unsatCount));
		properties.setProperty(PROPERTY_OUT_SMTENCODINGLENGTH, String.valueOf(smtEncoding.length()));
		properties.setProperty(PROPERTY_OUT_SMTENCODINGVARIABLES, String.valueOf(smtEncodingVariables.size()));
	}

	protected void init() {

		super.init();
		modelObjsBucketA = new ArrayList<MAVOElement>();
		modelObjsChainsA = new ArrayList<Integer>();
	}

	private void transformMatch() {

		modelSize += numRuleElementsA;
		for (int i = 0; i < numRuleElementsA; i++) {
			MAVOElement modelObjA = ClassDiagram_MAVOFactory.eINSTANCE.createClass();
			modelObjA.setFormulaId(SMTLIB_APPLICABILITY_FUN_APPLY + (ruleApplicationsLifting+1) + SMTLIB_PREDICATE_END);
			modelObjsBucketA.add(modelObjA);
			modelObjsChainsA.add(new Integer(maxChains));
		}
	}

	private boolean checkApplicabilityConditions() {

		modelObjsNBar.clear();
		modelObjsC.clear();
		modelObjsD.clear();
		Set<MAVOElement> modelObjsN = new HashSet<MAVOElement>();
		modelObjsNBar.add(modelObjsN);
		double modelObjAMatchPerc = modelObjsChainsA.size() / modelSize;
		boolean nacMatched = (state.nextDouble() < nacMatchPerc);
		for (int i = 0; i < (numRuleElementsN+numRuleElementsC); i++) {
			MAVOElement modelObj = null;
			boolean modelObjAMatched = (state.nextDouble() < modelObjAMatchPerc);
			if (modelObjAMatched) { // previously (A)dded element matched
				int indexA = state.nextInt(modelObjsChainsA.size());
				int chains = modelObjsChainsA.get(indexA);
				if (chains > 0) { // still able to chain
					chains--;
					if (chains == 0) {
						modelObj = modelObjsBucketA.remove(indexA);
						modelObjsChainsA.remove(indexA);
					}
					else {
						modelObj = modelObjsBucketA.get(indexA);
						modelObjsChainsA.add(indexA, new Integer(chains));
					}
				}
			}
			else {
				modelObj = ClassDiagram_MAVOFactory.eINSTANCE.createClass();
				String formulaId = (state.nextDouble() < alwaysPresentPerc) ?
					SMTLIB_TRUE :
					constraintVariables[state.nextInt(constraintVariables.length)];
				modelObj.setFormulaId(formulaId);
			}
			if (i < numRuleElementsC) { // (C)ontext element matched
				modelObjsC.add(modelObj);
			}
			else {
				if (nacMatched) { // (N)ac element matched
					modelObjsN.add(modelObj);
				}
				else {
					break;
				}
			}
		}

		return checkZ3ApplicabilityFormula();
	}

	private void doSimulatedLifting() throws MMTFException {

		long startTime = System.nanoTime();
		while (ruleApplicationsLifting < numIterations) {
			checkApplicabilityConditions();
			modelObjsA.clear();
			transformMatch();
			ruleApplicationsLifting++;
		}
		
		long endTime = System.nanoTime();

		timeLifting = endTime - startTime;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		inputModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			inputModel,
			inputSubdir,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);
		init();
		initSMTEncoding(SMTLIB_APPLICABILITY_PREAMBLE, SMTLIB_APPLICABILITY_POSTAMBLE);

		z3IncResult = CLibrary.OPERATOR_INSTANCE.firstCheckSatAndGetModelIncremental(smtEncoding.toString());
		doSimulatedLifting();
		CLibrary.OPERATOR_INSTANCE.freeResultIncremental(z3IncResult);

		// save output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			inputModel,
			MultiModelOperatorUtils.getSubdir(inputProperties),
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return null;
	}

}
