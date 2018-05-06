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

import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.ValidityValue;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl#getContentValidity <em>Content Validity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContextImpl extends ContextualElementImpl implements Context {
	/**
	 * The default value of the '{@link #getContentValidity() <em>Content Validity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentValidity()
	 * @generated
	 * @ordered
	 */
	protected static final ValidityValue CONTENT_VALIDITY_EDEFAULT = ValidityValue.INVALID;

	/**
	 * The cached value of the '{@link #getContentValidity() <em>Content Validity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentValidity()
	 * @generated
	 * @ordered
	 */
	protected ValidityValue contentValidity = CONTENT_VALIDITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidityValue getContentValidity() {
		return contentValidity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentValidity(ValidityValue newContentValidity) {
		ValidityValue oldContentValidity = contentValidity;
		contentValidity = newContentValidity == null ? CONTENT_VALIDITY_EDEFAULT : newContentValidity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.CONTEXT__CONTENT_VALIDITY, oldContentValidity, contentValidity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetyCasePackage.CONTEXT__CONTENT_VALIDITY:
				return getContentValidity();
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
			case SafetyCasePackage.CONTEXT__CONTENT_VALIDITY:
				setContentValidity((ValidityValue)newValue);
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
			case SafetyCasePackage.CONTEXT__CONTENT_VALIDITY:
				setContentValidity(CONTENT_VALIDITY_EDEFAULT);
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
			case SafetyCasePackage.CONTEXT__CONTENT_VALIDITY:
				return contentValidity != CONTENT_VALIDITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (contentValidity: ");
		result.append(contentValidity);
		result.append(')');
		return result.toString();
	}

} //ContextImpl
