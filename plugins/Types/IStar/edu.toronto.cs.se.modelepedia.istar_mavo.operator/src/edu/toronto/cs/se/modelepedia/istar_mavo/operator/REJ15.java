/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.IStatus;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MIDOperatorUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Result;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.reasoning.Z3ReasoningEngine;

public class REJ15 extends FASE14 {

	// input-output properties
	private final static String PROPERTY_IN_MODELCONSTRAINT = "modelConstraint";
	private final static String PROPERTY_IN_MODELCONSTRAINT_DEFAULT = null;
	private final static String PROPERTY_IN_GENERATETARGETSCONCRETIZATION = "generateTargetsConcretization";
	private final static Boolean PROPERTY_IN_GENERATETARGETSCONCRETIZATION_DEFAULT = false;
	private final static String PROPERTY_OUT_TIMEALLSAT = "timeAllSAT";
	private final static String PROPERTY_OUT_NUMSOLUTIONS = "numSolutions";

	// input
	private boolean timeAnalysisEnabled;
	private boolean timeRNFEnabled;
	private String modelConstraint;
	private boolean generateTargetsConcretization;
	private boolean timeAllSATEnabled;
	// output
	private long timeAllSAT;
	private int numSolutions;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		timeAnalysisEnabled = MIDOperatorUtils.getBoolProperty(inputProperties, PROPERTY_OUT_TIMEANALYSIS+MIDOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		timeRNFEnabled = MIDOperatorUtils.getBoolProperty(inputProperties, PROPERTY_OUT_TIMERNF+MIDOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		modelConstraint = MIDOperatorUtils.getOptionalStringProperty(inputProperties, PROPERTY_IN_MODELCONSTRAINT, PROPERTY_IN_MODELCONSTRAINT_DEFAULT);
		generateTargetsConcretization = MIDOperatorUtils.getOptionalBoolProperty(inputProperties, PROPERTY_IN_GENERATETARGETSCONCRETIZATION, PROPERTY_IN_GENERATETARGETSCONCRETIZATION_DEFAULT);
		timeAllSATEnabled = MIDOperatorUtils.getBoolProperty(inputProperties, PROPERTY_OUT_TIMEALLSAT+MIDOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
	}

	@Override
	public void init() throws MMINTException {

		super.init();

		// state
		if (modelConstraint != null) {
			smtEncoding += Z3Utils.assertion(modelConstraint);
		}
		// output
		timeAllSAT = -1;
		numSolutions = 0;
	}

	@Override
	protected void writeProperties(Properties properties) {

		super.writeProperties(properties);
		properties.setProperty(PROPERTY_OUT_TIMEALLSAT, String.valueOf(timeAllSAT));
		properties.setProperty(PROPERTY_OUT_NUMSOLUTIONS, String.valueOf(numSolutions));
	}

	@Override
	protected Z3Model doTargets(Z3IncrementalSolver z3IncSolver) {

		long extraTime = 0;
		if (!timeAnalysisEnabled) {
			long startTime = System.nanoTime();
			z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
			extraTime = System.nanoTime() - startTime;
		}
		Z3Model z3Model = super.doTargets(z3IncSolver);
		timeTargets += extraTime;

		return z3Model;
	}

	private void doAllSAT(Z3IncrementalSolver z3IncSolver, Z3Model z3Model) {

		long startTime = System.nanoTime();

		Z3ReasoningEngine z3Reasoner;
		try {
			z3Reasoner = (Z3ReasoningEngine) MAVOMultiModelConstraintChecker.getMAVOReasoner("SMTLIB");
			numSolutions = z3Reasoner.allSATWithSolver(z3IncSolver, z3ModelParser, z3Model, new HashSet<>(mavoModelObjs.values()), istar).size();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping allSAT", e);
			return;
		}

		timeAllSAT = System.nanoTime() - startTime;
	}

//		private String[] getConcretization(IStar istar, Z3Model z3Model) {
//
//		String concretization = "", smtConcretizationConstraint = "";
//		Map<String, List<String>> z3ModelElems = new HashMap<>();
//		for (Entry<String, String> z3ModelElem : z3ModelParser.getZ3MAVOModelElements(z3Model).entrySet()) {
//			// S: x universe ids to same formula var
//			// V: 1 universe id to x formula vars
//			String universeId = z3ModelElem.getKey();
//			String formulaVar = z3ModelElem.getValue();
//			List<String> formulaVars = z3ModelElems.get(universeId);
//			if (formulaVars == null) {
//				formulaVars = new ArrayList<>();
//				z3ModelElems.put(universeId, formulaVars);
//			}
//			formulaVars.add(formulaVar);
//		}
//		for (Entry<String, MAVOElement> mavoModelObjEntry : mavoModelObjs.entrySet()) {
//			MAVOElement mavoModelObj = mavoModelObjEntry.getValue();
//			String formulaVar = mavoModelObjEntry.getKey();
//			String sort = mavoModelObj.eClass().getName();
//			String function = encodeMAVConstraintFunction(mavoModelObj);
//			int counterMS = 0;
//			List<String> mergedV = null;
//			for (List<String> z3ModelElemFormulaVars : z3ModelElems.values()) {
//				if (z3ModelElemFormulaVars.contains(formulaVar)) {
//					counterMS++;
//					mergedV = z3ModelElemFormulaVars;
//				}
//			}
//			boolean isNegation;
//			String smtConstraint = "";
//			if (mavoModelObj.isMay()) {
//				isNegation = (counterMS == 0);
//				if (isNegation) {
//					concretization += formulaVar + " deleted (M)" + System.lineSeparator();
//				}
//				smtConstraint = encodeMConstraint(sort, function, formulaVar, isNegation);
//			}
//			if (mavoModelObj.isSet() && counterMS > 0) {
//				isNegation = (counterMS > 1);
//				if (isNegation) {
//					concretization += formulaVar + " split into " + counterMS + " (S)" + System.lineSeparator();
//				}
//				smtConstraint = encodeSConstraint(sort, function, formulaVar, isNegation);
//			}
//			if (mavoModelObj.isVar() && counterMS > 0) {
//				isNegation = (mergedV.size() > 1);
//				if (isNegation) {
//					concretization += formulaVar + " merged with " + mergedV + " (V)" + System.lineSeparator();
//				}
//				else {
//					mergedV = MAVOUtils.getMergeableFormulaVars(istar, mavoModelObj);
//					if (mergedV.size() == 0) {
//						continue;
//					}
//				}
//				smtConstraint = encodeVConstraint(sort, function, formulaVar, mergedV, isNegation);
//			}
//			smtConcretizationConstraint += smtConstraint;
//		}
//		concretization += System.lineSeparator();
//		Map<String, Intention> intentions = super.collectIntentions(istar);
//		getConcretizationAnalysisLabels(intentions, z3Model);
//		for (Map.Entry<String, Intention> entry : intentions.entrySet()) {
//			concretization += entry.getKey() + "(" + writeIntentionLabels(entry.getValue()) + ") ";
//		}
//		smtConcretizationConstraint = Z3Utils.assertion(Z3Utils.not(Z3Utils.and(smtConcretizationConstraint)));
//
//		return new String[] {concretization, smtConcretizationConstraint};
//	}
//
//	private IStar copyIStarRootModelObj() {
//
//		IStar istarCopy = EcoreUtil.copy(istar);
//		Map<String, Intention> intentions = super.collectIntentions(istarCopy);
//		for (Intention intention : intentions.values()) {
//			for (SMTLIBLabel label : SMTLIBLabel.values()) {
//				intention.eSet(label.getModelFeature(), false);
//			}
//		}
//
//		return istarCopy;
//	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model istarModel = inputsByName.get(IN_MODEL);

		// run
		collectAnalysisModelObjects(istarModel);
		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		if (timeAnalysisEnabled) {
			doAnalysis(z3IncSolver);
		}
		if (timeTargetsEnabled) {
			Z3Model z3Model = doTargets(z3IncSolver);
			if (targets == Z3Result.SAT) {
				if (timeRNFEnabled) {
					doRNF(z3IncSolver, z3Model);
				}
				if (timeAllSATEnabled) {
					doAllSAT(z3IncSolver, z3Model);
				}
				if (generateTargetsConcretization) {
//					while (true) {
//						String[] concretization = getConcretization(copyIStarRootModelObj(), z3Model);
//						//TODO MMINT[MAVO] Integrate with mu-mmint code to show concretization model
//						if (!MultiModelDiagramUtils.getBooleanInput("Concretization", concretization[0] + System.lineSeparator() + System.lineSeparator() + "Do you want another concretization?")) {
//							break;
//						}
//						//TODO MMINT[TOSEM] Integrate with tosem allsat to negate current concretization
//						z3Model = z3IncSolver.checkSatAndGetModel(concretization[1], Z3IncrementalBehavior.NORMAL);
//						if (z3Model.getZ3Bool() != Z3Bool.SAT) {
//							break;
//						}
//					}
				}
			}
		}

		// output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MIDOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			istarModel,
			null,
			MIDOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);
		if (timeRNF != -1) {
			writeRNF(istarModel);
		}

		return new HashMap<>();
	}

}
