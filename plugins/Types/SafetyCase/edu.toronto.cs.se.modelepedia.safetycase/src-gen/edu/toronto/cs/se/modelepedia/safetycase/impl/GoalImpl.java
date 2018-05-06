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
import edu.toronto.cs.se.modelepedia.safetycase.ValidityValue;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
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
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getAsil <em>Asil</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getContentValidity <em>Content Validity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl#getSupportedBy <em>Supported By</em>}</li>
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
	 * The cached value of the '{@link #getAsil() <em>Asil</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsil()
	 * @generated
	 * @ordered
	 */
	protected ASIL asil;

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
	 * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<GoalSupportedBy> supportedBy;

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
				msgs = ((InternalEObject)asil).eInverseRemove(this, SafetyCasePackage.ASIL__OWNER, ASIL.class, msgs);
			if (newAsil != null)
				msgs = ((InternalEObject)newAsil).eInverseAdd(this, SafetyCasePackage.ASIL__OWNER, ASIL.class, msgs);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL__CONTENT_VALIDITY, oldContentValidity, contentValidity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GoalSupportedBy> getSupportedBy() {
		if (supportedBy == null) {
			supportedBy = new EObjectContainmentEList<GoalSupportedBy>(GoalSupportedBy.class, this, SafetyCasePackage.GOAL__SUPPORTED_BY);
		}
		return supportedBy;
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
			case SafetyCasePackage.GOAL__ASIL:
				return basicSetAsil(null, msgs);
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				return ((InternalEList<?>)getSupportedBy()).basicRemove(otherEnd, msgs);
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
			case SafetyCasePackage.GOAL__ASIL:
				return getAsil();
			case SafetyCasePackage.GOAL__CONTENT_VALIDITY:
				return getContentValidity();
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				return getSupportedBy();
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
				setStateValidity((ValidityValue)newValue);
				return;
			case SafetyCasePackage.GOAL__ASIL:
				setAsil((ASIL)newValue);
				return;
			case SafetyCasePackage.GOAL__CONTENT_VALIDITY:
				setContentValidity((ValidityValue)newValue);
				return;
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				getSupportedBy().clear();
				getSupportedBy().addAll((Collection<? extends GoalSupportedBy>)newValue);
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
			case SafetyCasePackage.GOAL__ASIL:
				setAsil((ASIL)null);
				return;
			case SafetyCasePackage.GOAL__CONTENT_VALIDITY:
				setContentValidity(CONTENT_VALIDITY_EDEFAULT);
				return;
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				getSupportedBy().clear();
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
			case SafetyCasePackage.GOAL__ASIL:
				return asil != null;
			case SafetyCasePackage.GOAL__CONTENT_VALIDITY:
				return contentValidity != CONTENT_VALIDITY_EDEFAULT;
			case SafetyCasePackage.GOAL__SUPPORTED_BY:
				return supportedBy != null && !supportedBy.isEmpty();
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
		result.append(" (stateValidity: ");
		result.append(stateValidity);
		result.append(", contentValidity: ");
		result.append(contentValidity);
		result.append(')');
		return result.toString();
	}

} //GoalImpl
