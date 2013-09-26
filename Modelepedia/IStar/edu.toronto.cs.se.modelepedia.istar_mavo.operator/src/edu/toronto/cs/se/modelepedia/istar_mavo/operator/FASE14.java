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

import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MavoPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink;
import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTUtils;

public class FASE14 extends RE13 {

	private static final String SMTLIB_EDGEFUN = "edge ";

	private static final String PROPERTY_OUT_TIMERNF = "timeRNF";

	private Map<String, MAVOElement> mavoModelObjs;
	private String smtEncodingRNF;

	private long timeRNF;

	protected void initOutput() {

		super.initOutput();
		timeRNF = -1;
	}

	protected void init() {

		super.init();
		smtEncodingRNF = "";
	}

	protected void writeProperties(Properties properties) {

		super.writeProperties(properties);
		properties.setProperty(PROPERTY_OUT_TIMERNF, String.valueOf(timeRNF));
	}

	private String encodeMConstraint(MAVOElement mavoModelObj) {

		String sort = mavoModelObj.eClass().getName(), fun = "", name = "";
		if (mavoModelObj instanceof DependencyEndpoint) {
			fun = SMTLIB_NODEFUN;
			name = ((DependencyEndpoint) mavoModelObj).getName();
		}
		else if (mavoModelObj instanceof IntentionLink) {
			fun = SMTLIB_EDGEFUN;
			name = ((IntentionLink) mavoModelObj).getName();
		}
		else if (mavoModelObj instanceof DependeeLink) {
			fun = SMTLIB_EDGEFUN;
			name = ((DependeeLink) mavoModelObj).getName();
		}
		else if (mavoModelObj instanceof DependerLink) {
			fun = SMTLIB_EDGEFUN;
			name = ((DependerLink) mavoModelObj).getName();
		}
		name = name.replaceAll(" ", "");

		return Z3SMTUtils.exists(
			SMTLIB_CONCRETIZATIONVAR + sort,
			Z3SMTUtils.predicate(fun, name + " " + SMTLIB_CONCRETIZATIONVAR)
		);
	}

	private String encodeSConstraint(MAVOElement mavoModelObj) {

		String sort = mavoModelObj.eClass().getName(), fun = "", name = "";
		if (mavoModelObj instanceof DependencyEndpoint) {
			fun = SMTLIB_NODEFUN;
			name = ((DependencyEndpoint) mavoModelObj).getName();
		}
		else if (mavoModelObj instanceof IntentionLink) {
			fun = SMTLIB_EDGEFUN;
			name = ((IntentionLink) mavoModelObj).getName();
		}
		else if (mavoModelObj instanceof DependeeLink) {
			fun = SMTLIB_EDGEFUN;
			name = ((DependeeLink) mavoModelObj).getName();
		}
		else if (mavoModelObj instanceof DependerLink) {
			fun = SMTLIB_EDGEFUN;
			name = ((DependerLink) mavoModelObj).getName();
		}
		name = name.replaceAll(" ", "");

		return Z3SMTUtils.exists(
			SMTLIB_CONCRETIZATIONVAR + sort,
			Z3SMTUtils.predicate(fun, name + " " + SMTLIB_CONCRETIZATIONVAR)
		);
	}

	private String encodeVConstraint(MAVOElement mavoModelObj) {

		return "";
	}

	private void checkMAVOAnnotation(MAVOElement mavoModelObj, EStructuralFeature mavoAnnotation, String smtMavoConstraint) {

		String smtMavoConstraintNegation = Z3SMTUtils.not(smtMavoConstraint);
		CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, Z3SMTUtils.assertion(smtMavoConstraintNegation), 1, 0);
		if (z3IncResult.flag == Z3_SAT) {
			//TODO MMTF: optimize search for other annotations in output model
		}
		else {
			mavoModelObj.eSet(mavoAnnotation, false);
			smtEncodingRNF += Z3SMTUtils.assertion(smtMavoConstraint);
			CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, Z3SMTUtils.assertion(smtMavoConstraintNegation), 0, 0);
		}
	}

	private void doRNF() {

		long startTime = System.nanoTime();

		for (MAVOElement mavoModelObj : mavoModelObjs.values()) {
			if (mavoModelObj.isMay()) {
				String smtMConstraint = encodeMConstraint(mavoModelObj);
				checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_May(), smtMConstraint);
			}
			if (mavoModelObj.isSet()) {
				String smtSConstraint = encodeSConstraint(mavoModelObj);
				checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_Set(), smtSConstraint);
			}
			if (mavoModelObj.isVar()) {
				String smtVConstraint = encodeVConstraint(mavoModelObj);
				checkMAVOAnnotation(mavoModelObj, MavoPackage.eINSTANCE.getMAVOElement_Var(), smtVConstraint);
			}
		}
		//TODO MMTF: augment RNF with real removal of M nodes

		timeRNF = System.nanoTime() - startTime;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		//TODO: MMTF how to integrate with the rest of RE13 without copying everything?
		Model istarModel = actualParameters.get(0);

		// create list of mavo elements
		IStar istar = (IStar) MultiModelTypeIntrospection.getRoot(istarModel);
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
				String name = "";
				if (modelObj instanceof DependencyEndpoint) {
					name = ((DependencyEndpoint) modelObj).getName();
				}
				else if (modelObj instanceof IntentionLink) {
					name = ((IntentionLink) modelObj).getName();
				}
				else if (modelObj instanceof DependerLink) {
					name = ((DependerLink) modelObj).getName();
				}
				else if (modelObj instanceof DependeeLink) {
					name = ((DependeeLink) modelObj).getName();
				}
				mavoModelObjs.put(name, (MAVOElement) modelObj);
			}
		}

		doRNF();
		// output new reduced model or just the smt encoding?

		return super.execute(actualParameters);
	}

}
