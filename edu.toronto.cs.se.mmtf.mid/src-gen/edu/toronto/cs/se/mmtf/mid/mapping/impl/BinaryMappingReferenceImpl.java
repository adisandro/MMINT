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

import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingReferenceImpl#getModel0 <em>Model0</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingReferenceImpl#getModel1 <em>Model1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryMappingReferenceImpl extends MappingReferenceImpl implements BinaryMappingReference {
	/**
	 * The cached value of the '{@link #getModel0() <em>Model0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel0()
	 * @generated
	 * @ordered
	 */
	protected ModelReference model0;
	/**
	 * The cached value of the '{@link #getModel1() <em>Model1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel1()
	 * @generated
	 * @ordered
	 */
	protected ModelReference model1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryMappingReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.BINARY_MAPPING_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference getModel0() {
		if (model0 != null && model0.eIsProxy()) {
			InternalEObject oldModel0 = (InternalEObject)model0;
			model0 = (ModelReference)eResolveProxy(oldModel0);
			if (model0 != oldModel0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.BINARY_MAPPING_REFERENCE__MODEL0, oldModel0, model0));
			}
		}
		return model0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference basicGetModel0() {
		return model0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel0(ModelReference newModel0) {
		ModelReference oldModel0 = model0;
		model0 = newModel0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.BINARY_MAPPING_REFERENCE__MODEL0, oldModel0, model0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference getModel1() {
		if (model1 != null && model1.eIsProxy()) {
			InternalEObject oldModel1 = (InternalEObject)model1;
			model1 = (ModelReference)eResolveProxy(oldModel1);
			if (model1 != oldModel1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.BINARY_MAPPING_REFERENCE__MODEL1, oldModel1, model1));
			}
		}
		return model1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference basicGetModel1() {
		return model1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel1(ModelReference newModel1) {
		ModelReference oldModel1 = model1;
		model1 = newModel1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.BINARY_MAPPING_REFERENCE__MODEL1, oldModel1, model1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.BINARY_MAPPING_REFERENCE__MODEL0:
				if (resolve) return getModel0();
				return basicGetModel0();
			case MappingPackage.BINARY_MAPPING_REFERENCE__MODEL1:
				if (resolve) return getModel1();
				return basicGetModel1();
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
			case MappingPackage.BINARY_MAPPING_REFERENCE__MODEL0:
				setModel0((ModelReference)newValue);
				return;
			case MappingPackage.BINARY_MAPPING_REFERENCE__MODEL1:
				setModel1((ModelReference)newValue);
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
			case MappingPackage.BINARY_MAPPING_REFERENCE__MODEL0:
				setModel0((ModelReference)null);
				return;
			case MappingPackage.BINARY_MAPPING_REFERENCE__MODEL1:
				setModel1((ModelReference)null);
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
			case MappingPackage.BINARY_MAPPING_REFERENCE__MODEL0:
				return model0 != null;
			case MappingPackage.BINARY_MAPPING_REFERENCE__MODEL1:
				return model1 != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryMappingReferenceImpl
