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
package edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MavoPackage;

import edu.toronto.cs.se.modelepedia.mavo.classdiagram.ClassdiagramPackage;
import edu.toronto.cs.se.modelepedia.mavo.classdiagram.Operation;
import edu.toronto.cs.se.modelepedia.mavo.classdiagram.Visibility;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.OperationImpl#isMay <em>May</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.OperationImpl#isSet <em>Set</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.OperationImpl#isVar <em>Var</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.OperationImpl#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends NamedElementImpl implements Operation {
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
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.PRIVATE;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Visibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramPackage.Literals.OPERATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.OPERATION__MAY, oldMay, may));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.OPERATION__SET, oldSet, set));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.OPERATION__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.OPERATION__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramPackage.OPERATION__MAY:
				return isMay();
			case ClassdiagramPackage.OPERATION__SET:
				return isSet();
			case ClassdiagramPackage.OPERATION__VAR:
				return isVar();
			case ClassdiagramPackage.OPERATION__VISIBILITY:
				return getVisibility();
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
			case ClassdiagramPackage.OPERATION__MAY:
				setMay((Boolean)newValue);
				return;
			case ClassdiagramPackage.OPERATION__SET:
				setSet((Boolean)newValue);
				return;
			case ClassdiagramPackage.OPERATION__VAR:
				setVar((Boolean)newValue);
				return;
			case ClassdiagramPackage.OPERATION__VISIBILITY:
				setVisibility((Visibility)newValue);
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
			case ClassdiagramPackage.OPERATION__MAY:
				setMay(MAY_EDEFAULT);
				return;
			case ClassdiagramPackage.OPERATION__SET:
				setSet(SET_EDEFAULT);
				return;
			case ClassdiagramPackage.OPERATION__VAR:
				setVar(VAR_EDEFAULT);
				return;
			case ClassdiagramPackage.OPERATION__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
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
			case ClassdiagramPackage.OPERATION__MAY:
				return may != MAY_EDEFAULT;
			case ClassdiagramPackage.OPERATION__SET:
				return set != SET_EDEFAULT;
			case ClassdiagramPackage.OPERATION__VAR:
				return var != VAR_EDEFAULT;
			case ClassdiagramPackage.OPERATION__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MAVOElement.class) {
			switch (derivedFeatureID) {
				case ClassdiagramPackage.OPERATION__MAY: return MavoPackage.MAVO_ELEMENT__MAY;
				case ClassdiagramPackage.OPERATION__SET: return MavoPackage.MAVO_ELEMENT__SET;
				case ClassdiagramPackage.OPERATION__VAR: return MavoPackage.MAVO_ELEMENT__VAR;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MAVOElement.class) {
			switch (baseFeatureID) {
				case MavoPackage.MAVO_ELEMENT__MAY: return ClassdiagramPackage.OPERATION__MAY;
				case MavoPackage.MAVO_ELEMENT__SET: return ClassdiagramPackage.OPERATION__SET;
				case MavoPackage.MAVO_ELEMENT__VAR: return ClassdiagramPackage.OPERATION__VAR;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //OperationImpl
