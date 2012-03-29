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

import edu.toronto.cs.se.mmtf.mid.impl.NamedElementImpl;

import edu.toronto.cs.se.mmtf.mid.mapping.Mapping;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelElementReferenceImpl#getPointer <em>Pointer</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelElementReferenceImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementReferenceImpl extends NamedElementImpl implements ModelElementReference {
	/**
	 * The cached value of the '{@link #getPointer() <em>Pointer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointer()
	 * @generated
	 * @ordered
	 */
	protected EObject pointer;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> mappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MODEL_ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getPointer() {
		if (pointer != null && pointer.eIsProxy()) {
			InternalEObject oldPointer = (InternalEObject)pointer;
			pointer = eResolveProxy(oldPointer);
			if (pointer != oldPointer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MODEL_ELEMENT_REFERENCE__POINTER, oldPointer, pointer));
			}
		}
		return pointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetPointer() {
		return pointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointer(EObject newPointer) {
		EObject oldPointer = pointer;
		pointer = newPointer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MODEL_ELEMENT_REFERENCE__POINTER, oldPointer, pointer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectWithInverseResolvingEList.ManyInverse<Mapping>(Mapping.class, this, MappingPackage.MODEL_ELEMENT_REFERENCE__MAPPINGS, MappingPackage.MAPPING__ELEMENTS);
		}
		return mappings;
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
			case MappingPackage.MODEL_ELEMENT_REFERENCE__MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappings()).basicAdd(otherEnd, msgs);
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
			case MappingPackage.MODEL_ELEMENT_REFERENCE__MAPPINGS:
				return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MODEL_ELEMENT_REFERENCE__POINTER:
				if (resolve) return getPointer();
				return basicGetPointer();
			case MappingPackage.MODEL_ELEMENT_REFERENCE__MAPPINGS:
				return getMappings();
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
			case MappingPackage.MODEL_ELEMENT_REFERENCE__POINTER:
				setPointer((EObject)newValue);
				return;
			case MappingPackage.MODEL_ELEMENT_REFERENCE__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends Mapping>)newValue);
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
			case MappingPackage.MODEL_ELEMENT_REFERENCE__POINTER:
				setPointer((EObject)null);
				return;
			case MappingPackage.MODEL_ELEMENT_REFERENCE__MAPPINGS:
				getMappings().clear();
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
			case MappingPackage.MODEL_ELEMENT_REFERENCE__POINTER:
				return pointer != null;
			case MappingPackage.MODEL_ELEMENT_REFERENCE__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelElementReferenceImpl
