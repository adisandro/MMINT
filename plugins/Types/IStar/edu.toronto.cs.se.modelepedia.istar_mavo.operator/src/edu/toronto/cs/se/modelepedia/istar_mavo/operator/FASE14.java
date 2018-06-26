/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Result;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

public class FASE14 extends RE13 {

	// input-output properties
	protected static final String PROPERTY_OUT_TIMERNF = "timeRNF";
	// constants
	private static final String RNF_OUTPUT_SUFFIX = "_rnf";

	// state
	protected Map<String, MAVOElement> mavoModelObjs;
	private String smtEncodingRNF;
	// output
	protected long timeRNF;

	@Override
	protected void init() {

		super.init();

		// state
		mavoModelObjs = new HashMap<>();
		smtEncodingRNF = "";
		// output
		timeRNF = -1;
	}

	@Override
	protected void writeProperties(Properties properties) {

		super.writeProperties(properties);
		properties.setProperty(PROPERTY_OUT_TIMERNF, String.valueOf(timeRNF));
	}

	private Z3Model checkMAVOAnnotation(MAVOElement mavoModelObj, EStructuralFeature mavoAnnotation, String smtMavoConstraint, Z3IncrementalSolver z3IncSolver, List<MAVOElement> mavoModelObjsToRemove) {

		Z3Model z3ModelResult = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(Z3Utils.not(smtMavoConstraint)), Z3IncrementalBehavior.POP);
		if (z3ModelResult.getZ3Result() == Z3Result.SAT) {
			//TODO MMINT[RNF] optimize search for other annotations in output model using the map mavoModelObjs

			return null;
		}
		else {
			if (mavoAnnotation == MAVOPackage.eINSTANCE.getMAVOElement_May() && smtMavoConstraint.startsWith(Z3Utils.SMTLIB_NOT)) { // M model object deletion
				EcoreUtil.delete(mavoModelObj, true);
			}
			else { // M-S-V removal
				mavoModelObj.eSet(mavoAnnotation, false);
			}
			mavoModelObjsToRemove.add(mavoModelObj);
			String smtMavoAssertion = Z3Utils.assertion(smtMavoConstraint);
			smtEncodingRNF += smtMavoAssertion + "\n";

			return z3IncSolver.checkSatAndGetModel(smtMavoAssertion, Z3IncrementalBehavior.NORMAL);
		}
	}

	protected void doRNF(Z3IncrementalSolver z3IncSolver, Z3Model z3Model) {

		long startTime = System.nanoTime();

		Z3Model z3TempModel;
		List<MAVOElement> mavoModelObjsToRemove = new ArrayList<MAVOElement>();
		for (MAVOElement mavoModelObj : mavoModelObjs.values()) {
			try {
				if (mavoModelObj.isMay()) {
					String smtMConstraint = Z3MAVOUtils.getSMTLIBMayModelObjectConstraint(mavoModelObj, false, false);
					z3TempModel = checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_May(), smtMConstraint, z3IncSolver, mavoModelObjsToRemove);
					if (z3TempModel != null) {
						z3Model = z3TempModel;
					}
					z3TempModel = checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_May(), Z3Utils.not(smtMConstraint), z3IncSolver, mavoModelObjsToRemove);
					if (z3TempModel != null) {
						z3Model = z3TempModel;
					}
				}
				if (mavoModelObj.isSet()) {
					String smtSConstraint = Z3MAVOUtils.getSMTLIBSetModelObjectConstraint(mavoModelObj, false);
					z3TempModel = checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_Set(), smtSConstraint, z3IncSolver, mavoModelObjsToRemove);
					if (z3TempModel != null) {
						z3Model = z3TempModel;
					}
				}
				if (mavoModelObj.isVar()) {
					Set<String> mergeableFormulaVars = MAVOUtils.getMergeableFormulaVars(istar, mavoModelObj);
					if (!mergeableFormulaVars.isEmpty()) {
						String smtVConstraint = Z3MAVOUtils.getSMTLIBVarModelObjectConstraint(mavoModelObj, mergeableFormulaVars, false);
						z3TempModel = checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_Var(), smtVConstraint, z3IncSolver, mavoModelObjsToRemove);
						if (z3TempModel != null) {
							z3Model = z3TempModel;
						}
					}
				}
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "Error creating RNF constraint for model object " + mavoModelObj.getFormulaVariable() + ", skipping it", e);
				continue;
			}
		}
		mavoModelObjs.values().removeAll(mavoModelObjsToRemove);

		timeRNF = System.nanoTime() - startTime;
	}

	protected void writeRNF(Model istarModel) {

		try {
			FileUtils.createTextFile(
				FileUtils.replaceFileExtensionInPath(
					FileUtils.addFileNameSuffixInPath(istarModel.getUri(), RNF_OUTPUT_SUFFIX),
					Z3Utils.SMTLIB_FILE_EXTENSION
				),
				smtEncodingRNF,
				true
			);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "RNF file writing failed", e);
		}
	}

	@Override
	protected void collectAnalysisModelObjects(Model istarModel) throws MMINTException {

		super.collectAnalysisModelObjects(istarModel);
		mavoModelObjs = MAVOUtils.getAnnotatedMAVOModelObjects(istar);
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model istarModel = inputsByName.get(IN_MODEL);
		this.init();

		// run
		collectAnalysisModelObjects(istarModel);
		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		doAnalysis(z3IncSolver);
		if (timeTargetsEnabled) {
			Z3Model z3Model = doTargets(z3IncSolver);
			if (targets == Z3Result.SAT) {
				doRNF(z3IncSolver, z3Model);
			}
		}

		// output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MIDOperatorIOUtils.writePropertiesFile(
			outputProperties,
			this,
			istarModel,
			null,
			MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX
		);
		if (timeRNF != -1) {
			writeRNF(istarModel);
		}

		return new HashMap<>();
	}

}
