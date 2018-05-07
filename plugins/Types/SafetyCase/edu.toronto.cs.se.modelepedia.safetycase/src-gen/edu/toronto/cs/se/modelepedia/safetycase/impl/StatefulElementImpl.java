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
import edu.toronto.cs.se.modelepedia.safetycase.StateValidity;
import edu.toronto.cs.se.modelepedia.safetycase.StatefulElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stateful Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl#getStateValidity <em>State Validity</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StatefulElementImpl extends ArgumentElementImpl implements StatefulElement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatefulElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.STATEFUL_ELEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY, oldStateValidity, newStateValidity);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY, newStateValidity, newStateValidity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY:
				if (stateValidity != null)
					msgs = ((InternalEObject)stateValidity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY, null, msgs);
				return basicSetStateValidity((StateValidity)otherEnd, msgs);
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
			case SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY:
				return basicSetStateValidity(null, msgs);
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
			case SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY:
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
			case SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY:
				setStateValidity((StateValidity)newValue);
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
			case SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY:
				setStateValidity((StateValidity)null);
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
			case SafetyCasePackage.STATEFUL_ELEMENT__STATE_VALIDITY:
				return stateValidity != null;
		}
		return super.eIsSet(featureID);
	}

} //StatefulElementImpl
