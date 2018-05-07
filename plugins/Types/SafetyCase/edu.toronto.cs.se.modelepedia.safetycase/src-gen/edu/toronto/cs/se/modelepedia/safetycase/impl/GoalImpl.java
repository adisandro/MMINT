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
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.GoalSupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.StateValidity;
import edu.toronto.cs.se.modelepedia.safetycase.StatefulElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getStateValidity <em>State Validity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getAsil <em>Asil</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalImpl extends DecomposableCoreElementImpl implements Goal {
	/**
	 * The cached value of the '{@link #getStateValidity() <em>State Validity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateValidity()
	 * @generated
	 * @ordered
	 */
	protected StateValidity stateValidity;

	/**
	 * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<GoalSupportedBy> supportedBy;

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
	public StateValidity getStateValidity() {
		return stateValidity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateValidity(StateValidity newStateValidity, NotificationChain msgs) {
		StateValidity oldStateValidity = stateValidity;
		stateValidity = newStateValidity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__STATE_VALIDITY, oldStateValidity, newStateValidity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateValidity(StateValidity newStateValidity) {
		if (newStateValidity != stateValidity) {
			NotificationChain msgs = null;
			if (stateValidity != null)
				msgs = ((InternalEObject)stateValidity).eInverseRemove(this, SafetyCasePackage.STATE_VALIDITY__TARGET, StateValidity.class, msgs);
			if (newStateValidity != null)
				msgs = ((InternalEObject)newStateValidity).eInverseAdd(this, SafetyCasePackage.STATE_VALIDITY__TARGET, StateValidity.class, msgs);
			msgs = basicSetStateValidity(newStateValidity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__STATE_VALIDITY, newStateValidity, newStateValidity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GoalSupportedBy> getSupportedBy() {
		if (supportedBy == null) {
			supportedBy = new EObjectContainmentWithInverseEList<GoalSupportedBy>(GoalSupportedBy.class, this, SafetyCasePackage.GOAL__SUPPORTED_BY, SafetyCasePackage.GOAL_SUPPORTED_BY__CONCLUSION);
		}
		return supportedBy;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.GOAL__STATE_VALIDITY:
				if (stateValidity != null)
					msgs = ((InternalEObject)stateValidity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.GOAL__STATE_VALIDITY, null, msgs);
				return basicSetStateValidity((StateValidity)otherEnd, msgs);
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupportedBy()).basicAdd(otherEnd, msgs);
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
			case SafetyCasePackage.GOAL__STATE_VALIDITY:
				return basicSetStateValidity(null, msgs);
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				return ((InternalEList<?>)getSupportedBy()).basicRemove(otherEnd, msgs);
			case SafetyCasePackage.GOAL__ASIL:
				return basicSetAsil(null, msgs);
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
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				return getSupportedBy();
			case SafetyCasePackage.GOAL__ASIL:
				return getAsil();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SafetyCasePackage.GOAL__STATE_VALIDITY:
				setStateValidity((StateValidity)newValue);
				return;
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				getSupportedBy().clear();
				getSupportedBy().addAll((Collection<? extends GoalSupportedBy>)newValue);
				return;
			case SafetyCasePackage.GOAL__ASIL:
				setAsil((ASIL)newValue);
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
				setStateValidity((StateValidity)null);
				return;
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				getSupportedBy().clear();
				return;
			case SafetyCasePackage.GOAL__ASIL:
				setAsil((ASIL)null);
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
				return stateValidity != null;
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				return supportedBy != null && !supportedBy.isEmpty();
			case SafetyCasePackage.GOAL__ASIL:
				return asil != null;
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
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //GoalImpl
