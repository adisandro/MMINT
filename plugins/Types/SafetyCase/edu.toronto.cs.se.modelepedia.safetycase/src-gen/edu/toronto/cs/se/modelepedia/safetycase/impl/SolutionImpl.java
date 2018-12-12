/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.StatefulElement;
import edu.toronto.cs.se.modelepedia.safetycase.ValidityValue;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl#getStateValidity <em>State Validity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends CoreElementImpl implements Solution {
	/**
	 * The default value of the '{@link #getStateValidity() <em>State Validity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateValidity()
	 * @generated
	 * @ordered
	 */
	protected static final ValidityValue STATE_VALIDITY_EDEFAULT = ValidityValue.INVALID;

	/**
	 * The cached value of the '{@link #getStateValidity() <em>State Validity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateValidity()
	 * @generated
	 * @ordered
	 */
	protected ValidityValue stateValidity = STATE_VALIDITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidityValue getStateValidity() {
		return stateValidity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateValidity(ValidityValue newStateValidity) {
		ValidityValue oldStateValidity = stateValidity;
		stateValidity = newStateValidity == null ? STATE_VALIDITY_EDEFAULT : newStateValidity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.SOLUTION__STATE_VALIDITY, oldStateValidity, stateValidity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetyCasePackage.SOLUTION__STATE_VALIDITY:
				return getStateValidity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SafetyCasePackage.SOLUTION__STATE_VALIDITY:
				setStateValidity((ValidityValue)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SafetyCasePackage.SOLUTION__STATE_VALIDITY:
				setStateValidity(STATE_VALIDITY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SafetyCasePackage.SOLUTION__STATE_VALIDITY:
				return stateValidity != STATE_VALIDITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == StatefulElement.class) {
			switch (derivedFeatureID) {
				case SafetyCasePackage.SOLUTION__STATE_VALIDITY: return SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == StatefulElement.class) {
			switch (baseFeatureID) {
				case SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY: return SafetyCasePackage.SOLUTION__STATE_VALIDITY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (stateValidity: ");
		result.append(stateValidity);
		result.append(')');
		return result.toString();
	}

} //SolutionImpl
