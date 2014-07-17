/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTModel;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTModel.Z3SMTBool;

public class FASE14 extends RE13 {

	private static final String SMTLIB_CONCRETIZATION1 = " c1 ";
	private static final String SMTLIB_CONCRETIZATION2 = " c2 ";

	protected static final String PROPERTY_OUT_TIMERNF = "timeRNF";
	private static final String RNF_OUTPUT_SUFFIX = "_rnf";

	// state
	protected Map<String, MAVOElement> mavoModelObjs;
	private String smtEncodingRNF;
	// output
	protected long timeRNF;

	@Override
	public void init() throws MMINTException {

		super.init();

		// state
		mavoModelObjs = new HashMap<String, MAVOElement>();
		smtEncodingRNF = "";
		// output
		timeRNF = -1;
	}

	@Override
	protected void writeProperties(Properties properties) {

		super.writeProperties(properties);
		properties.setProperty(PROPERTY_OUT_TIMERNF, String.valueOf(timeRNF));
	}

	//TODO MMINT: unify/refactor these functions when simplifying the i* metamodel
	protected String encodeMAVConstraintFunction(MAVOElement mavoModelObj) {

		return (mavoModelObj instanceof DependencyEndpoint) ?
			Z3SMTUtils.SMTLIB_NODE_FUNCTION :
			Z3SMTUtils.SMTLIB_EDGE_FUNCTION;
	}

	protected String encodeMConstraint(String sort, String function, String formulaVar, boolean isNegation) {

		String constraint = Z3SMTUtils.exists(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION + sort),
			Z3SMTUtils.predicate(function, formulaVar + " " + SMTLIB_CONCRETIZATION)
		);

		return (isNegation) ? Z3SMTUtils.not(constraint) : constraint;
	}

	protected String encodeSConstraint(String sort, String function, String formulaVar, boolean isNegation) {

		String smtThenTerms = Z3SMTUtils.equality(SMTLIB_CONCRETIZATION1 + SMTLIB_CONCRETIZATION2);
		if (isNegation) {
			smtThenTerms = Z3SMTUtils.not(smtThenTerms);
		}

		return Z3SMTUtils.forall(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION1 + sort) + Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION2 + sort),
			Z3SMTUtils.implication(
				Z3SMTUtils.and(
					Z3SMTUtils.predicate(function, formulaVar + SMTLIB_CONCRETIZATION1) + Z3SMTUtils.predicate(function, formulaVar + SMTLIB_CONCRETIZATION2)
				),
				smtThenTerms
			)
		);
	}

	protected String encodeVConstraint(String sort, String function, String formulaVar, List<String> unmergeableFormulaVars, boolean isNegation) {

		String smtThenTerms = "";
		for (String unmergeableFormulaVar : unmergeableFormulaVars) {
			smtThenTerms += Z3SMTUtils.predicate(function, unmergeableFormulaVar + SMTLIB_CONCRETIZATION);
		}
		smtThenTerms = (isNegation) ? Z3SMTUtils.and(smtThenTerms) : Z3SMTUtils.not(Z3SMTUtils.or(smtThenTerms));

		return Z3SMTUtils.forall(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION + sort),
			Z3SMTUtils.implication(
				Z3SMTUtils.predicate(function, formulaVar + SMTLIB_CONCRETIZATION),
				smtThenTerms
			)
		);
	}

	private Z3SMTModel checkMAVOAnnotation(MAVOElement mavoModelObj, EStructuralFeature mavoAnnotation, String smtMavoConstraint, Z3SMTIncrementalSolver z3IncSolver, List<MAVOElement> mavoModelObjsToRemove) {

		Z3SMTModel z3ModelResult = z3IncSolver.checkSatAndGetModel(Z3SMTUtils.assertion(Z3SMTUtils.not(smtMavoConstraint)), Z3IncrementalBehavior.POP);
		if (z3ModelResult.getZ3Bool() == Z3SMTBool.SAT) {
			//TODO MMINT[RNF] optimize search for other annotations in output model using the map mavoModelObjs

			return null;
		}
		else {
			if (mavoAnnotation == MAVOPackage.eINSTANCE.getMAVOElement_May() && smtMavoConstraint.startsWith(Z3SMTUtils.SMTLIB_NOT)) { // M model object deletion
				EcoreUtil.delete(mavoModelObj, true);
			}
			else { // M-S-V removal
				mavoModelObj.eSet(mavoAnnotation, false);
			}
			mavoModelObjsToRemove.add(mavoModelObj);
			String smtMavoAssertion = Z3SMTUtils.assertion(smtMavoConstraint);
			smtEncodingRNF += smtMavoAssertion + "\n";

			return z3IncSolver.checkSatAndGetModel(smtMavoAssertion, Z3IncrementalBehavior.NORMAL);
		}
	}

	protected void doRNF(Z3SMTIncrementalSolver z3IncSolver, Z3SMTModel z3Model) {

		long startTime = System.nanoTime();

		Z3SMTModel z3TempModel;
		List<MAVOElement> mavoModelObjsToRemove = new ArrayList<MAVOElement>();
		for (Entry<String, MAVOElement> mavoModelObjEntry : mavoModelObjs.entrySet()) {
			MAVOElement mavoModelObj = mavoModelObjEntry.getValue();
			String formulaVar = mavoModelObjEntry.getKey();
			String sort = mavoModelObj.eClass().getName();
			String function = encodeMAVConstraintFunction(mavoModelObj);
			if (mavoModelObj.isMay()) {
				String smtMConstraint = encodeMConstraint(sort, function, formulaVar, false);
				z3TempModel = checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_May(), smtMConstraint, z3IncSolver, mavoModelObjsToRemove);
				if (z3TempModel != null) {
					z3Model = z3TempModel;
				}
				z3TempModel = checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_May(), Z3SMTUtils.not(smtMConstraint), z3IncSolver, mavoModelObjsToRemove);
				if (z3TempModel != null) {
					z3Model = z3TempModel;
				}
			}
			if (mavoModelObj.isSet()) {
				String smtSConstraint = encodeSConstraint(sort, function, formulaVar, false);
				z3TempModel = checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_Set(), smtSConstraint, z3IncSolver, mavoModelObjsToRemove);
				if (z3TempModel != null) {
					z3Model = z3TempModel;
				}
			}
			if (mavoModelObj.isVar()) {
				List<String> mergeableFormulaVars = MAVOUtils.getMergeableFormulaVars(istar, mavoModelObj);
				if (!mergeableFormulaVars.isEmpty()) {
					String smtVConstraint = encodeVConstraint(sort, function, formulaVar, mergeableFormulaVars, false);
					z3TempModel = checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_Var(), smtVConstraint, z3IncSolver, mavoModelObjsToRemove);
					if (z3TempModel != null) {
						z3Model = z3TempModel;
					}
				}
			}
		}
		mavoModelObjs.values().removeAll(mavoModelObjsToRemove);

		timeRNF = System.nanoTime() - startTime;
	}

	protected void writeRNF(Model istarModel) {

		try {
			MultiModelUtils.createTextFile(
				MultiModelUtils.replaceFileExtensionInUri(
					MultiModelUtils.addFileNameSuffixInUri(istarModel.getUri(), RNF_OUTPUT_SUFFIX),
					Z3SMTUtils.SMTLIB_FILE_EXTENSION
				),
				smtEncodingRNF,
				true
			);
		}
		catch (Exception e) {
			MMINTException.print(Type.WARNING, "RNF file writing failed", e);
		}
	}

	@Override
	protected void collectAnalysisModelObjs(Model istarModel) throws MMINTException {

		super.collectAnalysisModelObjs(istarModel);
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(istar, true);
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			if (
				modelObj instanceof MAVOElement && (
					((MAVOElement) modelObj).isMay() ||
					((MAVOElement) modelObj).isSet() ||
					((MAVOElement) modelObj).isVar()
				)
			) {
				mavoModelObjs.put(((MAVOElement) modelObj).getFormulaVariable(), (MAVOElement) modelObj);
			}
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model istarModel = actualParameters.get(0);

		// run
		collectAnalysisModelObjs(istarModel);
		Z3SMTIncrementalSolver z3IncSolver = new Z3SMTIncrementalSolver();
		doAnalysis(z3IncSolver);
		if (timeTargetsEnabled) {
			Z3SMTModel z3Model = doTargets(z3IncSolver);
			if (targets == Z3SMTBool.SAT) {
				doRNF(z3IncSolver, z3Model);
			}
		}

		// output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			istarModel,
			null,
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);
		if (timeRNF != -1) {
			writeRNF(istarModel);
		}

		return actualParameters;
	}

}
