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
package edu.toronto.cs.se.modelepedia.tutorial.state.impl;

import edu.toronto.cs.se.modelepedia.tutorial.state.City;
import edu.toronto.cs.se.modelepedia.tutorial.state.Region;
import edu.toronto.cs.se.modelepedia.tutorial.state.StatePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.tutorial.state.impl.RegionImpl#getCapital <em>Capital</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RegionImpl extends NamedElementImpl implements Region {
	/**
	 * The cached value of the '{@link #getCapital() <em>Capital</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapital()
	 * @generated
	 * @ordered
	 */
	protected City capital;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatePackage.Literals.REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public City getCapital() {
		if (capital != null && capital.eIsProxy()) {
			InternalEObject oldCapital = (InternalEObject)capital;
			capital = (City)eResolveProxy(oldCapital);
			if (capital != oldCapital) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatePackage.REGION__CAPITAL, oldCapital, capital));
			}
		}
		return capital;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public City basicGetCapital() {
		return capital;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapital(City newCapital) {
		City oldCapital = capital;
		capital = newCapital;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatePackage.REGION__CAPITAL, oldCapital, capital));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatePackage.REGION__CAPITAL:
				if (resolve) return getCapital();
				return basicGetCapital();
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
			case StatePackage.REGION__CAPITAL:
				setCapital((City)newValue);
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
			case StatePackage.REGION__CAPITAL:
				setCapital((City)null);
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
			case StatePackage.REGION__CAPITAL:
				return capital != null;
		}
		return super.eIsSet(featureID);
	}

} //RegionImpl
