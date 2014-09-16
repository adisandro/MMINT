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
package edu.toronto.cs.se.mavo.util;

import edu.toronto.cs.se.mavo.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mavo.MAVOPackage
 * @generated
 */
public class MAVOSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MAVOPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOSwitch() {
		if (modelPackage == null) {
			modelPackage = MAVOPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MAVOPackage.LOGIC_ELEMENT: {
				LogicElement logicElement = (LogicElement)theEObject;
				T result = caseLogicElement(logicElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MAVOPackage.DECISION_ELEMENT: {
				DecisionElement decisionElement = (DecisionElement)theEObject;
				T result = caseDecisionElement(decisionElement);
				if (result == null) result = caseLogicElement(decisionElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MAVOPackage.MAVO_MODEL: {
				MAVOModel mavoModel = (MAVOModel)theEObject;
				T result = caseMAVOModel(mavoModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MAVOPackage.MAVO_ELEMENT: {
				MAVOElement mavoElement = (MAVOElement)theEObject;
				T result = caseMAVOElement(mavoElement);
				if (result == null) result = caseLogicElement(mavoElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MAVOPackage.MAVO_REFERENCE: {
				MAVOReference mavoReference = (MAVOReference)theEObject;
				T result = caseMAVOReference(mavoReference);
				if (result == null) result = caseMAVOElement(mavoReference);
				if (result == null) result = caseLogicElement(mavoReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MAVOPackage.MAVO_DECISION: {
				MAVODecision mavoDecision = (MAVODecision)theEObject;
				T result = caseMAVODecision(mavoDecision);
				if (result == null) result = caseDecisionElement(mavoDecision);
				if (result == null) result = caseLogicElement(mavoDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MAVOPackage.MAVO_ALTERNATIVE: {
				MAVOAlternative mavoAlternative = (MAVOAlternative)theEObject;
				T result = caseMAVOAlternative(mavoAlternative);
				if (result == null) result = caseDecisionElement(mavoAlternative);
				if (result == null) result = caseLogicElement(mavoAlternative);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MAVOPackage.MAY_DECISION: {
				MayDecision mayDecision = (MayDecision)theEObject;
				T result = caseMayDecision(mayDecision);
				if (result == null) result = caseMAVODecision(mayDecision);
				if (result == null) result = caseDecisionElement(mayDecision);
				if (result == null) result = caseLogicElement(mayDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MAVOPackage.VAR_DECISION: {
				VarDecision varDecision = (VarDecision)theEObject;
				T result = caseVarDecision(varDecision);
				if (result == null) result = caseMAVODecision(varDecision);
				if (result == null) result = caseDecisionElement(varDecision);
				if (result == null) result = caseLogicElement(varDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicElement(LogicElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decision Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decision Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecisionElement(DecisionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAVOModel(MAVOModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAVOElement(MAVOElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAVOReference(MAVOReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAVODecision(MAVODecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alternative</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternative</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMAVOAlternative(MAVOAlternative object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>May Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>May Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMayDecision(MayDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarDecision(VarDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MAVOSwitch
