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
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;
import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTUtils;

public class FASE14 extends RE13 {

	private static final String SMTLIB_CONCRETIZATIONVAR1 = " c1 ";
	private static final String SMTLIB_CONCRETIZATIONVAR2 = " c2 ";
	private static final String SMTLIB_EDGEFUN = "(edge ";

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

	//TODO MMTF: unify/refactor these functions when 1) simplifying the i* metamodel 2) preparing a generic smtlib encoder
	private String encodeMAVConstraintFun(MAVOElement mavoModelObj) {

		return (mavoModelObj instanceof DependencyEndpoint) ?
			SMTLIB_NODEFUN :
			SMTLIB_EDGEFUN;
	}

	private String encodeMConstraint(String sort, String fun, String name) {

		return Z3SMTUtils.exists(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATIONVAR + sort),
			Z3SMTUtils.predicate(fun, name + " " + SMTLIB_CONCRETIZATIONVAR)
		);
	}

	private String encodeSConstraint(String sort, String fun, String name) {

		return Z3SMTUtils.forall(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATIONVAR1 + sort) + Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATIONVAR2 + sort),
			Z3SMTUtils.implication(
				Z3SMTUtils.and(
					Z3SMTUtils.predicate(fun, name + SMTLIB_CONCRETIZATIONVAR1) + Z3SMTUtils.predicate(fun, name + SMTLIB_CONCRETIZATIONVAR2)
				),
				Z3SMTUtils.equality(SMTLIB_CONCRETIZATIONVAR1 + SMTLIB_CONCRETIZATIONVAR2)
			)
		);
	}

	private String encodeVConstraint(String sort, String fun, String name1, List<String> names2) {

		String smtOrTerms = "";
		for (String name2 : names2) {
			smtOrTerms += Z3SMTUtils.predicate(fun, name2 + SMTLIB_CONCRETIZATIONVAR);
		}
		return Z3SMTUtils.forall(
			Z3SMTUtils.emptyPredicate(SMTLIB_CONCRETIZATIONVAR + sort),
			Z3SMTUtils.implication(
				Z3SMTUtils.predicate(fun, name1 + SMTLIB_CONCRETIZATIONVAR),
				Z3SMTUtils.not(
					Z3SMTUtils.or(smtOrTerms)
				)
			)
		);
	}

	private void checkMAVOAnnotation(MAVOElement mavoModelObj, EStructuralFeature mavoAnnotation, String smtMavoConstraint) {

		CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, Z3SMTUtils.assertion(Z3SMTUtils.not(smtMavoConstraint)), 1, 0);
		if (z3IncResult.flag == Z3_SAT) {
			//TODO MMTF: optimize search for other annotations in output model
		}
		else {
			mavoModelObj.eSet(mavoAnnotation, false);
			String smtMavoAssertion = Z3SMTUtils.assertion(smtMavoConstraint);
			smtEncodingRNF += smtMavoAssertion + "\n";
			CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, smtMavoAssertion, 0, 0);
		}
	}

	private void doRNF() {

		long startTime = System.nanoTime();

		for (Map.Entry<String, MAVOElement> mavoModelObjEntry : mavoModelObjs.entrySet()) {
			MAVOElement mavoModelObj = mavoModelObjEntry.getValue();
			String name = mavoModelObjEntry.getKey();
			String sort = mavoModelObj.eClass().getName();
			String fun = encodeMAVConstraintFun(mavoModelObj);
			if (mavoModelObj.isMay()) {
				String smtMConstraint = encodeMConstraint(sort, fun, name);
				checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_May(), smtMConstraint);
			}
			if (mavoModelObj.isSet()) {
				String smtSConstraint = encodeSConstraint(sort, fun, name);
				checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_Set(), smtSConstraint);
			}
			if (mavoModelObj.isVar()) {
				List<String> names2 = MAVOSMTUtils.getUnmergeableModelObjects(istar, mavoModelObj);
				if (!names2.isEmpty()) {
					String smtVConstraint = encodeVConstraint(sort, fun, name, names2);
					checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_Var(), smtVConstraint);
				}
			}
		}
		//TODO MMTF: augment RNF with real removal of M nodes?

		timeRNF = System.nanoTime() - startTime;
	}

	@Override
	protected void collectAnalysisModelObjs(Model istarModel) {

		istar = (IStar) MultiModelTypeIntrospection.getRoot(istarModel);
		MAVOSMTUtils.createFormulaIdsFromNames(istar);
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(istar, true);
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			if (modelObj instanceof Intention) {
				intentions.put(((Intention) modelObj).getFormulaId(), (Intention) modelObj);
			}
			if (
				modelObj instanceof MAVOElement && (
					((MAVOElement) modelObj).isMay() ||
					((MAVOElement) modelObj).isSet() ||
					((MAVOElement) modelObj).isVar()
				)
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
			doRNF();
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
		try {
			MultiModelUtils.writeTextFile(
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

		return actualParameters;
	}

}
