/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVOCollectionImpl#getMavoElements <em>Mavo Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MAVOCollectionImpl extends DecisionElementImpl implements MAVOCollection {
	/**
	 * The cached value of the '{@link #getMavoElements() <em>Mavo Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMavoElements()
	 * @generated
	 * @ordered
	 */
	protected EList<MAVOElement> mavoElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVOCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOPackage.Literals.MAVO_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MAVOElement> getMavoElements() {
		if (mavoElements == null) {
			mavoElements = new EObjectWithInverseResolvingEList.ManyInverse<MAVOElement>(MAVOElement.class, this, MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS, MAVOPackage.MAVO_ELEMENT__COLLECTIONS);
		}
		return mavoElements;
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
			case MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMavoElements()).basicAdd(otherEnd, msgs);
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
			case MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS:
				return ((InternalEList<?>)getMavoElements()).basicRemove(otherEnd, msgs);
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
			case MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS:
				return getMavoElements();
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
			case MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS:
				getMavoElements().clear();
				getMavoElements().addAll((Collection<? extends MAVOElement>)newValue);
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
			case MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS:
				getMavoElements().clear();
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
			case MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS:
				return mavoElements != null && !mavoElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MAVOCollectionImpl
