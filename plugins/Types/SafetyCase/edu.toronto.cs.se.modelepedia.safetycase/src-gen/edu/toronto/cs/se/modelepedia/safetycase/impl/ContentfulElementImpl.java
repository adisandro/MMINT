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

import edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.ContentfulElement;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.ValidityValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contentful Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContentfulElementImpl#getContentValidity <em>Content Validity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContentfulElementImpl#getContentStatus <em>Content Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ContentfulElementImpl extends MinimalEObjectImpl.Container implements ContentfulElement {
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
	 * The cached value of the '{@link #getContentStatus() <em>Content Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentStatus()
	 * @generated
	 * @ordered
	 */
	protected ContentImpactAnnotation contentStatus;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentfulElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.CONTENTFUL_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_VALIDITY, oldContentValidity, contentValidity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentImpactAnnotation getContentStatus() {
		return contentStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContentStatus(ContentImpactAnnotation newContentStatus, NotificationChain msgs) {
		ContentImpactAnnotation oldContentStatus = contentStatus;
		contentStatus = newContentStatus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS, oldContentStatus, newContentStatus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentStatus(ContentImpactAnnotation newContentStatus) {
		if (newContentStatus != contentStatus) {
			NotificationChain msgs = null;
			if (contentStatus != null)
				msgs = ((InternalEObject)contentStatus).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS, null, msgs);
			if (newContentStatus != null)
				msgs = ((InternalEObject)newContentStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS, null, msgs);
			msgs = basicSetContentStatus(newContentStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS, newContentStatus, newContentStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS:
				return basicSetContentStatus(null, msgs);
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
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_VALIDITY:
				return getContentValidity();
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS:
				return getContentStatus();
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
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_VALIDITY:
				setContentValidity((ValidityValue)newValue);
				return;
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS:
				setContentStatus((ContentImpactAnnotation)newValue);
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
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_VALIDITY:
				setContentValidity(CONTENT_VALIDITY_EDEFAULT);
				return;
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS:
				setContentStatus((ContentImpactAnnotation)null);
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
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_VALIDITY:
				return contentValidity != CONTENT_VALIDITY_EDEFAULT;
			case SafetyCasePackage.CONTENTFUL_ELEMENT__CONTENT_STATUS:
				return contentStatus != null;
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

} //ContentfulElementImpl
