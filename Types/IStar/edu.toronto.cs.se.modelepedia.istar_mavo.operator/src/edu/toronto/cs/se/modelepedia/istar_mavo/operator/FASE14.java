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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MavoPackage;
import edu.toronto.cs.se.mmtf.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils;
import edu.toronto.cs.se.modelepedia.istar_mavo.Actor;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;

public class FASE14 extends RE13 {

	private static final String SMTLIB_CONCRETIZATION1 = " c1 ";
	private static final String SMTLIB_CONCRETIZATION2 = " c2 ";
	private static final String SMTLIB_EDGEFUNCTION = "(edge ";

	private static final String PROPERTY_OUT_TIMERNF = "timeRNF";
	private static final String RNF_OUTPUT_SUFFIX = "_rnf";

	private Map<String, MAVOElement> mavoModelObjs;
	private String smtEncodingRNF;

	private long timeRNF;

	@Override
	protected void initOutput() {

		super.initOutput();
		timeRNF = -1;
	}

	@Override
	protected void init() {

		super.init();
		mavoModelObjs = new HashMap<String, MAVOElement>();
		smtEncodingRNF = "";
	}

	@Override
	protected void writeProperties(Properties properties) {

		super.writeProperties(properties);
		properties.setProperty(PROPERTY_OUT_TIMERNF, String.valueOf(timeRNF));
	}

	//TODO MMTF: unify/refactor these functions when simplifying the i* metamodel
	private String encodeMAVConstraintFunction(MAVOElement mavoModelObj) {

		return (mavoModelObj instanceof DependencyEndpoint) ?
			SMTLIB_NODEFUNCTION :
			SMTLIB_EDGEFUNCTION;
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

	private void checkMAVOAnnotation(MAVOElement mavoModelObj, EStructuralFeature mavoAnnotation, String smtMavoConstraint) {

		CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, Z3SMTUtils.assertion(Z3SMTUtils.not(smtMavoConstraint)), 1, 0);
		if (z3IncResult.flag == Z3_SAT) {
			//TODO MMTF: optimize search for other annotations in output model using the map mavoModelObjs
		}
		else {
			if (mavoAnnotation == MavoPackage.eINSTANCE.getMAVOElement_May() && smtMavoConstraint.startsWith(SMTLIB_NOT)) { // M model object deletion
				EcoreUtil.delete(mavoModelObj, true);
			}
			else { // M-S-V removal
				mavoModelObj.eSet(mavoAnnotation, false);
			}
			String smtMavoAssertion = Z3SMTUtils.assertion(smtMavoConstraint);
			smtEncodingRNF += smtMavoAssertion + "\n";
			CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, smtMavoAssertion, 0, 0);
		}
	}

	private void doRNF() {

		long startTime = System.nanoTime();

		for (Map.Entry<String, MAVOElement> mavoModelObjEntry : mavoModelObjs.entrySet()) {
			MAVOElement mavoModelObj = mavoModelObjEntry.getValue();
			String id = mavoModelObjEntry.getKey();
			String sort = mavoModelObj.eClass().getName();
			String function = encodeMAVConstraintFunction(mavoModelObj);
			if (mavoModelObj.isMay()) {
				String smtMConstraint = encodeMConstraint(sort, function, id);
				checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_May(), smtMConstraint);
				checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_May(), Z3SMTUtils.not(smtMConstraint));
			}
			if (mavoModelObj.isSet()) {
				String smtSConstraint = encodeSConstraint(sort, function, id);
				checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_Set(), smtSConstraint);
			}
			if (mavoModelObj.isVar()) {
				List<String> mergeableIds = MAVOUtils.getMergeableIds(istar, mavoModelObj);
				if (!mergeableIds.isEmpty()) {
					String smtVConstraint = encodeVConstraint(sort, function, id, mergeableIds);
					checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_Var(), smtVConstraint);
				}
			}
		}

		timeRNF = System.nanoTime() - startTime;
	}

	@Override
	protected void collectAnalysisModelObjs(Model istarModel) throws MMTFException {

		istar = (IStar) istarModel.getEMFInstanceRoot();
		MAVOUtils.createIdsFromNames(istar);
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(istar, true);
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			if (modelObj instanceof Intention) {
				Intention intention = (Intention) modelObj;
				intentions.put(intention.getFormulaId(), intention);
				if (
					intention.isFullySatisfied() ||
					intention.isPartiallySatisfied() ||
					intention.isUnknown() ||
					intention.isConflict() ||
					intention.isPartiallyDenied() ||
					intention.isFullyDenied() ||
					intention.isNoLabel()
				) {
					initialIntentions.add(intention.getFormulaId());
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
				String id = ((MAVOElement) modelObj).getFormulaId();
				mavoModelObjs.put(id, (MAVOElement) modelObj);
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
			if (targets.equals(Integer.toString(Z3_SAT))) {
				doRNF();
			}
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
		if (timeRNF != -1) {
			try {
				MultiModelUtils.createTextFile(
					MultiModelUtils.prependWorkspaceToUri(
						MultiModelUtils.replaceFileExtensionInUri(
							MultiModelUtils.addFileNameSuffixInUri(istarModel.getUri(), RNF_OUTPUT_SUFFIX),
							SMTLIB_FILE_EXTENSION
						)
					),
					smtEncodingRNF
				);
			}
			catch (Exception e) {
				MMTFException.print(Type.WARNING, "RNF file writing failed", e);
			}
		}

		return actualParameters;
	}

}
