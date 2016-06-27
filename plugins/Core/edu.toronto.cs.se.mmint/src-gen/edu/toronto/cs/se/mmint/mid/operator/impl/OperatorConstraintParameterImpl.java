/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.operator.impl;

import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintParameter;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;

import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorConstraintParameterImpl#getParameterRef <em>Parameter Ref</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorConstraintParameterImpl#getEndpointIndex <em>Endpoint Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperatorConstraintParameterImpl extends MinimalEObjectImpl.Container implements OperatorConstraintParameter {
	/**
	 * The cached value of the '{@link #getParameterRef() <em>Parameter Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterRef()
	 * @generated
	 * @ordered
	 */
	protected ModelEndpointReference parameterRef;

	/**
	 * The default value of the '{@link #getEndpointIndex() <em>Endpoint Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int ENDPOINT_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndpointIndex() <em>Endpoint Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointIndex()
	 * @generated
	 * @ordered
	 */
	protected int endpointIndex = ENDPOINT_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorConstraintParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorPackage.Literals.OPERATOR_CONSTRAINT_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelEndpointReference getParameterRef() {
		return parameterRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterRef(ModelEndpointReference newParameterRef, NotificationChain msgs) {
		ModelEndpointReference oldParameterRef = parameterRef;
		parameterRef = newParameterRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF, oldParameterRef, newParameterRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterRef(ModelEndpointReference newParameterRef) {
		if (newParameterRef != parameterRef) {
			NotificationChain msgs = null;
			if (parameterRef != null)
				msgs = ((InternalEObject)parameterRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF, null, msgs);
			if (newParameterRef != null)
				msgs = ((InternalEObject)newParameterRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF, null, msgs);
			msgs = basicSetParameterRef(newParameterRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF, newParameterRef, newParameterRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndpointIndex() {
		return endpointIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointIndex(int newEndpointIndex) {
		int oldEndpointIndex = endpointIndex;
		endpointIndex = newEndpointIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__ENDPOINT_INDEX, oldEndpointIndex, endpointIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF:
				return basicSetParameterRef(null, msgs);
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
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF:
				return getParameterRef();
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__ENDPOINT_INDEX:
				return getEndpointIndex();
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
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF:
				setParameterRef((ModelEndpointReference)newValue);
				return;
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__ENDPOINT_INDEX:
				setEndpointIndex((Integer)newValue);
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
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF:
				setParameterRef((ModelEndpointReference)null);
				return;
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__ENDPOINT_INDEX:
				setEndpointIndex(ENDPOINT_INDEX_EDEFAULT);
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
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER_REF:
				return parameterRef != null;
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__ENDPOINT_INDEX:
				return endpointIndex != ENDPOINT_INDEX_EDEFAULT;
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
		result.append(" (endpointIndex: ");
		result.append(endpointIndex);
		result.append(')');
		return result.toString();
	}

} //OperatorConstraintParameterImpl
