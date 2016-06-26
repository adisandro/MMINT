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
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorConstraintParameterImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorConstraintParameterImpl#getEndpointIndex <em>Endpoint Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperatorConstraintParameterImpl extends MinimalEObjectImpl.Container implements OperatorConstraintParameter {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected ModelEndpointReference parameter;

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
	public ModelEndpointReference getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (ModelEndpointReference)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelEndpointReference basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(ModelEndpointReference newParameter) {
		ModelEndpointReference oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER, oldParameter, parameter));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
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
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER:
				setParameter((ModelEndpointReference)newValue);
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
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER:
				setParameter((ModelEndpointReference)null);
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
			case OperatorPackage.OPERATOR_CONSTRAINT_PARAMETER__PARAMETER:
				return parameter != null;
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
