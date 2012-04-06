/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.impl;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMapping;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingImpl#getElement0 <em>Element0</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingImpl#getElement1 <em>Element1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryMappingImpl extends MappingImpl implements BinaryMapping {
	/**
	 * The cached value of the '{@link #getElement0() <em>Element0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement0()
	 * @generated
	 * @ordered
	 */
	protected ModelElementReference element0;

	/**
	 * The cached value of the '{@link #getElement1() <em>Element1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement1()
	 * @generated
	 * @ordered
	 */
	protected ModelElementReference element1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.BINARY_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference getElement0() {
		if (element0 != null && element0.eIsProxy()) {
			InternalEObject oldElement0 = (InternalEObject)element0;
			element0 = (ModelElementReference)eResolveProxy(oldElement0);
			if (element0 != oldElement0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.BINARY_MAPPING__ELEMENT0, oldElement0, element0));
			}
		}
		return element0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference basicGetElement0() {
		return element0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement0(ModelElementReference newElement0) {
		ModelElementReference oldElement0 = element0;
		element0 = newElement0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.BINARY_MAPPING__ELEMENT0, oldElement0, element0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference getElement1() {
		if (element1 != null && element1.eIsProxy()) {
			InternalEObject oldElement1 = (InternalEObject)element1;
			element1 = (ModelElementReference)eResolveProxy(oldElement1);
			if (element1 != oldElement1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.BINARY_MAPPING__ELEMENT1, oldElement1, element1));
			}
		}
		return element1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference basicGetElement1() {
		return element1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement1(ModelElementReference newElement1) {
		ModelElementReference oldElement1 = element1;
		element1 = newElement1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.BINARY_MAPPING__ELEMENT1, oldElement1, element1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.BINARY_MAPPING__ELEMENT0:
				if (resolve) return getElement0();
				return basicGetElement0();
			case MappingPackage.BINARY_MAPPING__ELEMENT1:
				if (resolve) return getElement1();
				return basicGetElement1();
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
			case MappingPackage.BINARY_MAPPING__ELEMENT0:
				setElement0((ModelElementReference)newValue);
				return;
			case MappingPackage.BINARY_MAPPING__ELEMENT1:
				setElement1((ModelElementReference)newValue);
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
			case MappingPackage.BINARY_MAPPING__ELEMENT0:
				setElement0((ModelElementReference)null);
				return;
			case MappingPackage.BINARY_MAPPING__ELEMENT1:
				setElement1((ModelElementReference)null);
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
			case MappingPackage.BINARY_MAPPING__ELEMENT0:
				return element0 != null;
			case MappingPackage.BINARY_MAPPING__ELEMENT1:
				return element1 != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryMappingImpl
