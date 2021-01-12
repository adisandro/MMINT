/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mavo.impl;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logic Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.LogicElementImpl#getFormulaVariable <em>Formula Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LogicElementImpl extends MinimalEObjectImpl.Container implements LogicElement {
	/**
	 * The default value of the '{@link #getFormulaVariable() <em>Formula Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMULA_VARIABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormulaVariable() <em>Formula Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaVariable()
	 * @generated
	 * @ordered
	 */
	protected String formulaVariable = FORMULA_VARIABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOPackage.Literals.LOGIC_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormulaVariable() {
		return formulaVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormulaVariable(String newFormulaVariable) {
		String oldFormulaVariable = formulaVariable;
		formulaVariable = newFormulaVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE, oldFormulaVariable, formulaVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE:
				return getFormulaVariable();
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
			case MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE:
				setFormulaVariable((String)newValue);
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
			case MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE:
				setFormulaVariable(FORMULA_VARIABLE_EDEFAULT);
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
			case MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE:
				return FORMULA_VARIABLE_EDEFAULT == null ? formulaVariable != null : !FORMULA_VARIABLE_EDEFAULT.equals(formulaVariable);
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
		result.append(" (formulaVariable: ");
		result.append(formulaVariable);
		result.append(')');
		return result.toString();
	}

} //LogicElementImpl
