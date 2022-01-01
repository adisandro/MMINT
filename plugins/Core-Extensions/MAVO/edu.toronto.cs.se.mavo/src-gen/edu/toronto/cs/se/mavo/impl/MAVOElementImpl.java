/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVOElementImpl#isMay <em>May</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVOElementImpl#isSet <em>Set</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVOElementImpl#isVar <em>Var</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVOElementImpl#getCollections <em>Collections</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MAVOElementImpl extends LogicElementImpl implements MAVOElement {
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
	 * The cached value of the '{@link #getCollections() <em>Collections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollections()
	 * @generated
	 * @ordered
	 */
	protected EList<MAVOCollection> collections;

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
		return MAVOPackage.Literals.MAVO_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOPackage.MAVO_ELEMENT__MAY, oldMay, may));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOPackage.MAVO_ELEMENT__SET, oldSet, set));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOPackage.MAVO_ELEMENT__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MAVOCollection> getCollections() {
		if (collections == null) {
			collections = new EObjectWithInverseResolvingEList.ManyInverse<MAVOCollection>(MAVOCollection.class, this, MAVOPackage.MAVO_ELEMENT__COLLECTIONS, MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS);
		}
		return collections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MAVOPackage.MAVO_ELEMENT__COLLECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCollections()).basicAdd(otherEnd, msgs);
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
			case MAVOPackage.MAVO_ELEMENT__COLLECTIONS:
				return ((InternalEList<?>)getCollections()).basicRemove(otherEnd, msgs);
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
			case MAVOPackage.MAVO_ELEMENT__MAY:
				return isMay();
			case MAVOPackage.MAVO_ELEMENT__SET:
				return isSet();
			case MAVOPackage.MAVO_ELEMENT__VAR:
				return isVar();
			case MAVOPackage.MAVO_ELEMENT__COLLECTIONS:
				return getCollections();
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
			case MAVOPackage.MAVO_ELEMENT__MAY:
				setMay((Boolean)newValue);
				return;
			case MAVOPackage.MAVO_ELEMENT__SET:
				setSet((Boolean)newValue);
				return;
			case MAVOPackage.MAVO_ELEMENT__VAR:
				setVar((Boolean)newValue);
				return;
			case MAVOPackage.MAVO_ELEMENT__COLLECTIONS:
				getCollections().clear();
				getCollections().addAll((Collection<? extends MAVOCollection>)newValue);
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
			case MAVOPackage.MAVO_ELEMENT__MAY:
				setMay(MAY_EDEFAULT);
				return;
			case MAVOPackage.MAVO_ELEMENT__SET:
				setSet(SET_EDEFAULT);
				return;
			case MAVOPackage.MAVO_ELEMENT__VAR:
				setVar(VAR_EDEFAULT);
				return;
			case MAVOPackage.MAVO_ELEMENT__COLLECTIONS:
				getCollections().clear();
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
			case MAVOPackage.MAVO_ELEMENT__MAY:
				return may != MAY_EDEFAULT;
			case MAVOPackage.MAVO_ELEMENT__SET:
				return set != SET_EDEFAULT;
			case MAVOPackage.MAVO_ELEMENT__VAR:
				return var != VAR_EDEFAULT;
			case MAVOPackage.MAVO_ELEMENT__COLLECTIONS:
				return collections != null && !collections.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //MAVOElementImpl
