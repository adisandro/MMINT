/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.modelepedia.safetycase.StateImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.StatefulElement;
import edu.toronto.cs.se.modelepedia.safetycase.ValidityValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl#getStateStatus <em>State Status</em>}</li>
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
	 * The cached value of the '{@link #getStateStatus() <em>State Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateStatus()
	 * @generated
	 * @ordered
	 */
	protected StateImpactAnnotation stateStatus;

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
	public StateImpactAnnotation getStateStatus() {
		return stateStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateStatus(StateImpactAnnotation newStateStatus, NotificationChain msgs) {
		StateImpactAnnotation oldStateStatus = stateStatus;
		stateStatus = newStateStatus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafetyCasePackage.SOLUTION__STATE_STATUS, oldStateStatus, newStateStatus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateStatus(StateImpactAnnotation newStateStatus) {
		if (newStateStatus != stateStatus) {
			NotificationChain msgs = null;
			if (stateStatus != null)
				msgs = ((InternalEObject)stateStatus).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.SOLUTION__STATE_STATUS, null, msgs);
			if (newStateStatus != null)
				msgs = ((InternalEObject)newStateStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.SOLUTION__STATE_STATUS, null, msgs);
			msgs = basicSetStateStatus(newStateStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.SOLUTION__STATE_STATUS, newStateStatus, newStateStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.SOLUTION__STATE_STATUS:
				return basicSetStateStatus(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case SafetyCasePackage.SOLUTION__STATE_STATUS:
				return getStateStatus();
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
			case SafetyCasePackage.SOLUTION__STATE_STATUS:
				setStateStatus((StateImpactAnnotation)newValue);
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
			case SafetyCasePackage.SOLUTION__STATE_STATUS:
				setStateStatus((StateImpactAnnotation)null);
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
			case SafetyCasePackage.SOLUTION__STATE_STATUS:
				return stateStatus != null;
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
				case SafetyCasePackage.SOLUTION__STATE_STATUS: return SafetyCasePackage.STATEFUL_ELEMENT__STATE_STATUS;
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
				case SafetyCasePackage.STATEFUL_ELEMENT__STATE_STATUS: return SafetyCasePackage.SOLUTION__STATE_STATUS;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stateValidity: ");
		result.append(stateValidity);
		result.append(')');
		return result.toString();
	}

} //SolutionImpl
