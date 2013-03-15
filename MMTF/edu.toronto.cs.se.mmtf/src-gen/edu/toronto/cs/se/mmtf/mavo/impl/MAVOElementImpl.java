/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.mmtf.mavo.impl;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MavoPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl#isMay <em>May</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl#isSet <em>Set</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl#isVar <em>Var</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl#getFormulaId <em>Formula Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MAVOElementImpl extends EObjectImpl implements MAVOElement {
	/**
	 * The default value of the '{@link #isMay() <em>May</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMay()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMay() <em>May</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMay()
	 * @generated
	 * @ordered
	 */
	protected boolean may = MAY_EDEFAULT;

	/**
	 * The default value of the '{@link #isSet() <em>Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSet()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSet() <em>Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSet()
	 * @generated
	 * @ordered
	 */
	protected boolean set = SET_EDEFAULT;

	/**
	 * The default value of the '{@link #isVar() <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVar()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VAR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVar() <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVar()
	 * @generated
	 * @ordered
	 */
	protected boolean var = VAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormulaId() <em>Formula Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaId()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMULA_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormulaId() <em>Formula Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaId()
	 * @generated
	 * @ordered
	 */
	protected String formulaId = FORMULA_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVOElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MavoPackage.Literals.MAVO_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMay() {
		return may;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMay(boolean newMay) {
		boolean oldMay = may;
		may = newMay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MavoPackage.MAVO_ELEMENT__MAY, oldMay, may));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSet() {
		return set;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSet(boolean newSet) {
		boolean oldSet = set;
		set = newSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MavoPackage.MAVO_ELEMENT__SET, oldSet, set));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVar() {
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVar(boolean newVar) {
		boolean oldVar = var;
		var = newVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MavoPackage.MAVO_ELEMENT__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormulaId() {
		return formulaId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormulaId(String newFormulaId) {
		String oldFormulaId = formulaId;
		formulaId = newFormulaId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MavoPackage.MAVO_ELEMENT__FORMULA_ID, oldFormulaId, formulaId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MavoPackage.MAVO_ELEMENT__MAY:
				return isMay();
			case MavoPackage.MAVO_ELEMENT__SET:
				return isSet();
			case MavoPackage.MAVO_ELEMENT__VAR:
				return isVar();
			case MavoPackage.MAVO_ELEMENT__FORMULA_ID:
				return getFormulaId();
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
			case MavoPackage.MAVO_ELEMENT__MAY:
				setMay((Boolean)newValue);
				return;
			case MavoPackage.MAVO_ELEMENT__SET:
				setSet((Boolean)newValue);
				return;
			case MavoPackage.MAVO_ELEMENT__VAR:
				setVar((Boolean)newValue);
				return;
			case MavoPackage.MAVO_ELEMENT__FORMULA_ID:
				setFormulaId((String)newValue);
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
			case MavoPackage.MAVO_ELEMENT__MAY:
				setMay(MAY_EDEFAULT);
				return;
			case MavoPackage.MAVO_ELEMENT__SET:
				setSet(SET_EDEFAULT);
				return;
			case MavoPackage.MAVO_ELEMENT__VAR:
				setVar(VAR_EDEFAULT);
				return;
			case MavoPackage.MAVO_ELEMENT__FORMULA_ID:
				setFormulaId(FORMULA_ID_EDEFAULT);
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
			case MavoPackage.MAVO_ELEMENT__MAY:
				return may != MAY_EDEFAULT;
			case MavoPackage.MAVO_ELEMENT__SET:
				return set != SET_EDEFAULT;
			case MavoPackage.MAVO_ELEMENT__VAR:
				return var != VAR_EDEFAULT;
			case MavoPackage.MAVO_ELEMENT__FORMULA_ID:
				return FORMULA_ID_EDEFAULT == null ? formulaId != null : !FORMULA_ID_EDEFAULT.equals(formulaId);
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
		result.append(" (may: ");
		result.append(may);
		result.append(", set: ");
		result.append(set);
		result.append(", var: ");
		result.append(var);
		result.append(", formulaId: ");
		result.append(formulaId);
		result.append(')');
		return result.toString();
	}

} //MAVOElementImpl
