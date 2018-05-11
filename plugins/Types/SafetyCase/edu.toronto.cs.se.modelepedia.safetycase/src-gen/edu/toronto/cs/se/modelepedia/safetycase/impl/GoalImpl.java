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

import edu.toronto.cs.se.modelepedia.safetycase.ASIL;
import edu.toronto.cs.se.modelepedia.safetycase.ASILImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
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
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getStateValidity <em>State Validity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getStateStatus <em>State Status</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getAsil <em>Asil</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getAsilStatus <em>Asil Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalImpl extends DecomposableCoreElementImpl implements Goal {
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
	 * The cached value of the '{@link #getAsil() <em>Asil</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsil()
	 * @generated
	 * @ordered
	 */
	protected ASIL asil;

	/**
	 * The cached value of the '{@link #getAsilStatus() <em>Asil Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsilStatus()
	 * @generated
	 * @ordered
	 */
	protected ASILImpactAnnotation asilStatus;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.GOAL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__STATE_VALIDITY, oldStateValidity, stateValidity));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__STATE_STATUS, oldStateStatus, newStateStatus);
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
				msgs = ((InternalEObject)stateStatus).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.GOAL__STATE_STATUS, null, msgs);
			if (newStateStatus != null)
				msgs = ((InternalEObject)newStateStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.GOAL__STATE_STATUS, null, msgs);
			msgs = basicSetStateStatus(newStateStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__STATE_STATUS, newStateStatus, newStateStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASIL getAsil() {
		return asil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAsil(ASIL newAsil, NotificationChain msgs) {
		ASIL oldAsil = asil;
		asil = newAsil;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__ASIL, oldAsil, newAsil);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsil(ASIL newAsil) {
		if (newAsil != asil) {
			NotificationChain msgs = null;
			if (asil != null)
				msgs = ((InternalEObject)asil).eInverseRemove(this, SafetyCasePackage.ASIL__TARGET, ASIL.class, msgs);
			if (newAsil != null)
				msgs = ((InternalEObject)newAsil).eInverseAdd(this, SafetyCasePackage.ASIL__TARGET, ASIL.class, msgs);
			msgs = basicSetAsil(newAsil, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__ASIL, newAsil, newAsil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILImpactAnnotation getAsilStatus() {
		return asilStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAsilStatus(ASILImpactAnnotation newAsilStatus, NotificationChain msgs) {
		ASILImpactAnnotation oldAsilStatus = asilStatus;
		asilStatus = newAsilStatus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__ASIL_STATUS, oldAsilStatus, newAsilStatus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsilStatus(ASILImpactAnnotation newAsilStatus) {
		if (newAsilStatus != asilStatus) {
			NotificationChain msgs = null;
			if (asilStatus != null)
				msgs = ((InternalEObject)asilStatus).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.GOAL__ASIL_STATUS, null, msgs);
			if (newAsilStatus != null)
				msgs = ((InternalEObject)newAsilStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.GOAL__ASIL_STATUS, null, msgs);
			msgs = basicSetAsilStatus(newAsilStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__ASIL_STATUS, newAsilStatus, newAsilStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.GOAL__ASIL:
				if (asil != null)
					msgs = ((InternalEObject)asil).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.GOAL__ASIL, null, msgs);
				return basicSetAsil((ASIL)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.GOAL__STATE_STATUS:
				return basicSetStateStatus(null, msgs);
			case SafetyCasePackage.GOAL__ASIL:
				return basicSetAsil(null, msgs);
			case SafetyCasePackage.GOAL__ASIL_STATUS:
				return basicSetAsilStatus(null, msgs);
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
			case SafetyCasePackage.GOAL__STATE_VALIDITY:
				return getStateValidity();
			case SafetyCasePackage.GOAL__STATE_STATUS:
				return getStateStatus();
			case SafetyCasePackage.GOAL__ASIL:
				return getAsil();
			case SafetyCasePackage.GOAL__ASIL_STATUS:
				return getAsilStatus();
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
			case SafetyCasePackage.GOAL__STATE_VALIDITY:
				setStateValidity((ValidityValue)newValue);
				return;
			case SafetyCasePackage.GOAL__STATE_STATUS:
				setStateStatus((StateImpactAnnotation)newValue);
				return;
			case SafetyCasePackage.GOAL__ASIL:
				setAsil((ASIL)newValue);
				return;
			case SafetyCasePackage.GOAL__ASIL_STATUS:
				setAsilStatus((ASILImpactAnnotation)newValue);
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
			case SafetyCasePackage.GOAL__STATE_VALIDITY:
				setStateValidity(STATE_VALIDITY_EDEFAULT);
				return;
			case SafetyCasePackage.GOAL__STATE_STATUS:
				setStateStatus((StateImpactAnnotation)null);
				return;
			case SafetyCasePackage.GOAL__ASIL:
				setAsil((ASIL)null);
				return;
			case SafetyCasePackage.GOAL__ASIL_STATUS:
				setAsilStatus((ASILImpactAnnotation)null);
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
			case SafetyCasePackage.GOAL__STATE_VALIDITY:
				return stateValidity != STATE_VALIDITY_EDEFAULT;
			case SafetyCasePackage.GOAL__STATE_STATUS:
				return stateStatus != null;
			case SafetyCasePackage.GOAL__ASIL:
				return asil != null;
			case SafetyCasePackage.GOAL__ASIL_STATUS:
				return asilStatus != null;
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
				case SafetyCasePackage.GOAL__STATE_VALIDITY: return SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY;
				case SafetyCasePackage.GOAL__STATE_STATUS: return SafetyCasePackage.STATEFUL_ELEMENT__STATE_STATUS;
				default: return -1;
			}
		}
		if (baseClass == ASILfulElement.class) {
			switch (derivedFeatureID) {
				case SafetyCasePackage.GOAL__ASIL: return SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL;
				case SafetyCasePackage.GOAL__ASIL_STATUS: return SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL_STATUS;
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
				case SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY: return SafetyCasePackage.GOAL__STATE_VALIDITY;
				case SafetyCasePackage.STATEFUL_ELEMENT__STATE_STATUS: return SafetyCasePackage.GOAL__STATE_STATUS;
				default: return -1;
			}
		}
		if (baseClass == ASILfulElement.class) {
			switch (baseFeatureID) {
				case SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL: return SafetyCasePackage.GOAL__ASIL;
				case SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL_STATUS: return SafetyCasePackage.GOAL__ASIL_STATUS;
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

} //GoalImpl
