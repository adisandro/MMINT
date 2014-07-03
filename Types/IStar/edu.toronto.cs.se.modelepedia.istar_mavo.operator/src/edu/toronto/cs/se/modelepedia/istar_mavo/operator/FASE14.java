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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import edu.toronto.cs.se.modelepedia.istar_mavo.Actor;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTModel;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTModel.Z3SMTBool;

public class FASE14 extends RE13 {

	private static final String SMTLIB_CONCRETIZATION1 = " c1 ";
	private static final String SMTLIB_CONCRETIZATION2 = " c2 ";

	private static final String PROPERTY_OUT_TIMERNF = "timeRNF";
	private static final String RNF_OUTPUT_SUFFIX = "_rnf";

	private Map<String, MAVOElement> mavoModelObjs;
	private String smtEncodingRNF;

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
	private String encodeMAVConstraintFunction(MAVOElement mavoModelObj) {

		return (mavoModelObj instanceof DependencyEndpoint) ?
			Z3SMTUtils.SMTLIB_NODE_FUNCTION :
			Z3SMTUtils.SMTLIB_EDGE_FUNCTION;
	}

	private String encodeMConstraint(String sort, String function, String id) {

		return Z3SMTUtils.exists(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION + sort),
			Z3SMTUtils.predicate(function, id + " " + SMTLIB_CONCRETIZATION)
		);
	}

	private String encodeSConstraint(String sort, String function, String id) {

		return Z3SMTUtils.forall(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION1 + sort) + Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION2 + sort),
			Z3SMTUtils.implication(
				Z3SMTUtils.and(
					Z3SMTUtils.predicate(function, id + SMTLIB_CONCRETIZATION1) + Z3SMTUtils.predicate(function, id + SMTLIB_CONCRETIZATION2)
				),
				Z3SMTUtils.equality(SMTLIB_CONCRETIZATION1 + SMTLIB_CONCRETIZATION2)
			)
		);
	}

	private String encodeVConstraint(String sort, String function, String id, List<String> mergeableIds) {

		String smtOrTerms = "";
		for (String unmergeableId : mergeableIds) {
			smtOrTerms += Z3SMTUtils.predicate(function, unmergeableId + SMTLIB_CONCRETIZATION);
		}
		return Z3SMTUtils.forall(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATION + sort),
			Z3SMTUtils.implication(
				Z3SMTUtils.predicate(function, id + SMTLIB_CONCRETIZATION),
				Z3SMTUtils.not(
					Z3SMTUtils.or(smtOrTerms)
				)
			)
		);
	}

	private void checkMAVOAnnotation(MAVOElement mavoModelObj, EStructuralFeature mavoAnnotation, String smtMavoConstraint, Z3SMTIncrementalSolver z3IncSolver) {

		Z3SMTModel z3ModelResult = z3IncSolver.checkSatAndGetModel(Z3SMTUtils.assertion(Z3SMTUtils.not(smtMavoConstraint)), Z3IncrementalBehavior.POP);
		if (z3ModelResult.getZ3Bool() == Z3SMTBool.SAT) {
			//TODO MMINT: optimize search for other annotations in output model using the map mavoModelObjs
		}
		else {
			if (mavoAnnotation == MAVOPackage.eINSTANCE.getMAVOElement_May() && smtMavoConstraint.startsWith(Z3SMTUtils.SMTLIB_NOT)) { // M model object deletion
				EcoreUtil.delete(mavoModelObj, true);
			}
			else { // M-S-V removal
				mavoModelObj.eSet(mavoAnnotation, false);
			}
			String smtMavoAssertion = Z3SMTUtils.assertion(smtMavoConstraint);
			smtEncodingRNF += smtMavoAssertion + "\n";
			z3IncSolver.checkSatAndGetModel(smtMavoAssertion, Z3IncrementalBehavior.NORMAL);
		}
	}

	protected void doRNF(Z3SMTIncrementalSolver z3IncSolver) {

		long startTime = System.nanoTime();

		for (Map.Entry<String, MAVOElement> mavoModelObjEntry : mavoModelObjs.entrySet()) {
			MAVOElement mavoModelObj = mavoModelObjEntry.getValue();
			String id = mavoModelObjEntry.getKey();
			String sort = mavoModelObj.eClass().getName();
			String function = encodeMAVConstraintFunction(mavoModelObj);
			if (mavoModelObj.isMay()) {
				String smtMConstraint = encodeMConstraint(sort, function, id);
				checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_May(), smtMConstraint, z3IncSolver);
				checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_May(), Z3SMTUtils.not(smtMConstraint), z3IncSolver);
			}
			if (mavoModelObj.isSet()) {
				String smtSConstraint = encodeSConstraint(sort, function, id);
				checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_Set(), smtSConstraint, z3IncSolver);
			}
			if (mavoModelObj.isVar()) {
				List<String> mergeableIds = MAVOUtils.getMergeableIds(istar, mavoModelObj);
				if (!mergeableIds.isEmpty()) {
					String smtVConstraint = encodeVConstraint(sort, function, id, mergeableIds);
					checkMAVOAnnotation(mavoModelObj, MAVOPackage.eINSTANCE.getMAVOElement_Var(), smtVConstraint, z3IncSolver);
				}
			}
		}

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

		istar = (IStar) istarModel.getEMFInstanceRoot();
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(istar, true);
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			if (modelObj instanceof Intention) {
				Intention intention = (Intention) modelObj;
				intentions.put(intention.getFormulaVariable(), intention);
				if (
					intention.isFullySatisfied() ||
					intention.isPartiallySatisfied() ||
					intention.isUnknown() ||
					intention.isConflict() ||
					intention.isPartiallyDenied() ||
					intention.isFullyDenied() ||
					intention.isNoLabel()
				) {
					initialIntentions.add(intention.getFormulaVariable());
				}
			}
			if (
				modelObj instanceof MAVOElement && (
					((MAVOElement) modelObj).isMay() ||
					((MAVOElement) modelObj).isSet() ||
					((MAVOElement) modelObj).isVar()
				) &&
				!(modelObj instanceof DependerLink && ((DependerLink) modelObj).getDepender() instanceof Actor) &&
				!(modelObj instanceof DependeeLink && ((DependeeLink) modelObj).getDependee() instanceof Actor)
			) {
				String id = ((MAVOElement) modelObj).getFormulaVariable();
				mavoModelObjs.put(id, (MAVOElement) modelObj);
			}
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model istarModel = actualParameters.get(0);

		// run solver
		collectAnalysisModelObjs(istarModel);
		Z3SMTIncrementalSolver z3IncSolver = new Z3SMTIncrementalSolver();
		doAnalysis(z3IncSolver);
		if (timeTargetsEnabled) {
			doTargets(z3IncSolver);
			if (targets == Z3SMTBool.SAT) {
				doRNF(z3IncSolver);
			}
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
		if (timeRNF != -1) {
			writeRNF(istarModel);
		}

		return actualParameters;
	}

}
