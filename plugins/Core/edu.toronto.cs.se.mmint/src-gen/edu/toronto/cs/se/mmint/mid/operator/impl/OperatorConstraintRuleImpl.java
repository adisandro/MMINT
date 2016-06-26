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
import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintRule;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorConstraintRuleImpl#getOutputModelRel <em>Output Model Rel</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorConstraintRuleImpl#isIsBinary <em>Is Binary</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorConstraintRuleImpl#getEnpointModels <em>Enpoint Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperatorConstraintRuleImpl extends MinimalEObjectImpl.Container implements OperatorConstraintRule {
	/**
	 * The cached value of the '{@link #getOutputModelRel() <em>Output Model Rel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputModelRel()
	 * @generated
	 * @ordered
	 */
	protected OperatorConstraintParameter outputModelRel;

	/**
	 * The default value of the '{@link #isIsBinary() <em>Is Binary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBinary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BINARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBinary() <em>Is Binary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBinary()
	 * @generated
	 * @ordered
	 */
	protected boolean isBinary = IS_BINARY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnpointModels() <em>Enpoint Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnpointModels()
	 * @generated
	 * @ordered
	 */
	protected EList<OperatorConstraintParameter> enpointModels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorConstraintRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorPackage.Literals.OPERATOR_CONSTRAINT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorConstraintParameter getOutputModelRel() {
		return outputModelRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputModelRel(OperatorConstraintParameter newOutputModelRel, NotificationChain msgs) {
		OperatorConstraintParameter oldOutputModelRel = outputModelRel;
		outputModelRel = newOutputModelRel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL, oldOutputModelRel, newOutputModelRel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputModelRel(OperatorConstraintParameter newOutputModelRel) {
		if (newOutputModelRel != outputModelRel) {
			NotificationChain msgs = null;
			if (outputModelRel != null)
				msgs = ((InternalEObject)outputModelRel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL, null, msgs);
			if (newOutputModelRel != null)
				msgs = ((InternalEObject)newOutputModelRel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL, null, msgs);
			msgs = basicSetOutputModelRel(newOutputModelRel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL, newOutputModelRel, newOutputModelRel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBinary() {
		return isBinary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBinary(boolean newIsBinary) {
		boolean oldIsBinary = isBinary;
		isBinary = newIsBinary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_CONSTRAINT_RULE__IS_BINARY, oldIsBinary, isBinary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperatorConstraintParameter> getEnpointModels() {
		if (enpointModels == null) {
			enpointModels = new EObjectContainmentEList<OperatorConstraintParameter>(OperatorConstraintParameter.class, this, OperatorPackage.OPERATOR_CONSTRAINT_RULE__ENPOINT_MODELS);
		}
		return enpointModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL:
				return basicSetOutputModelRel(null, msgs);
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__ENPOINT_MODELS:
				return ((InternalEList<?>)getEnpointModels()).basicRemove(otherEnd, msgs);
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
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL:
				return getOutputModelRel();
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__IS_BINARY:
				return isIsBinary();
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__ENPOINT_MODELS:
				return getEnpointModels();
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
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL:
				setOutputModelRel((OperatorConstraintParameter)newValue);
				return;
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__IS_BINARY:
				setIsBinary((Boolean)newValue);
				return;
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__ENPOINT_MODELS:
				getEnpointModels().clear();
				getEnpointModels().addAll((Collection<? extends OperatorConstraintParameter>)newValue);
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
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL:
				setOutputModelRel((OperatorConstraintParameter)null);
				return;
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__IS_BINARY:
				setIsBinary(IS_BINARY_EDEFAULT);
				return;
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__ENPOINT_MODELS:
				getEnpointModels().clear();
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
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__OUTPUT_MODEL_REL:
				return outputModelRel != null;
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__IS_BINARY:
				return isBinary != IS_BINARY_EDEFAULT;
			case OperatorPackage.OPERATOR_CONSTRAINT_RULE__ENPOINT_MODELS:
				return enpointModels != null && !enpointModels.isEmpty();
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
		result.append(" (isBinary: ");
		result.append(isBinary);
		result.append(')');
		return result.toString();
	}

} //OperatorConstraintRuleImpl
