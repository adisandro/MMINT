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
import edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASI Lful Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILfulElementImpl#getAsil <em>Asil</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ASILfulElementImpl extends MinimalEObjectImpl.Container implements ASILfulElement {
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
	protected ASILfulElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.ASI_LFUL_ELEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL, oldAsil, newAsil);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL, newAsil, newAsil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL:
				if (asil != null)
					msgs = ((InternalEObject)asil).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL, null, msgs);
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
			case SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL:
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
			case SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL:
				return getAsil();
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
			case SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL:
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
			case SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL:
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
			case SafetyCasePackage.ASI_LFUL_ELEMENT__ASIL:
				return asil != null;
		}
		return super.eIsSet(featureID);
	}

} //ASILfulElementImpl
