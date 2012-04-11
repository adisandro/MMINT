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
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getModel <em>Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getReferencedModel <em>Referenced Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getContainedModel <em>Contained Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelContainerImpl extends EObjectImpl implements ModelContainer {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementReference> elements;

	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)MappingPackage.Literals.MODEL_CONTAINER__NAME).getSettingDelegate();
	/**
	 * The cached setting delegate for the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate MODEL__ESETTING_DELEGATE = ((EStructuralFeature.Internal)MappingPackage.Literals.MODEL_CONTAINER__MODEL).getSettingDelegate();

	/**
	 * The cached value of the '{@link #getReferencedModel() <em>Referenced Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedModel()
	 * @generated
	 * @ordered
	 */
	protected ModelReference referencedModel;

	/**
	 * The cached value of the '{@link #getContainedModel() <em>Contained Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedModel()
	 * @generated
	 * @ordered
	 */
	protected ModelReference containedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MODEL_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementReference> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<ModelElementReference>(ModelElementReference.class, this, MappingPackage.MODEL_CONTAINER__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)NAME__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference getModel() {
		return (ModelReference)MODEL__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference basicGetModel() {
		return (ModelReference)MODEL__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference getReferencedModel() {
		if (referencedModel != null && referencedModel.eIsProxy()) {
			InternalEObject oldReferencedModel = (InternalEObject)referencedModel;
			referencedModel = (ModelReference)eResolveProxy(oldReferencedModel);
			if (referencedModel != oldReferencedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL, oldReferencedModel, referencedModel));
			}
		}
		return referencedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference basicGetReferencedModel() {
		return referencedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedModel(ModelReference newReferencedModel) {
		ModelReference oldReferencedModel = referencedModel;
		referencedModel = newReferencedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL, oldReferencedModel, referencedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelReference getContainedModel() {
		return containedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainedModel(ModelReference newContainedModel, NotificationChain msgs) {
		ModelReference oldContainedModel = containedModel;
		containedModel = newContainedModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL, oldContainedModel, newContainedModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedModel(ModelReference newContainedModel) {
		if (newContainedModel != containedModel) {
			NotificationChain msgs = null;
			if (containedModel != null)
				msgs = ((InternalEObject)containedModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL, null, msgs);
			if (newContainedModel != null)
				msgs = ((InternalEObject)newContainedModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL, null, msgs);
			msgs = basicSetContainedModel(newContainedModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL, newContainedModel, newContainedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				return basicSetContainedModel(null, msgs);
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
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				return getElements();
			case MappingPackage.MODEL_CONTAINER__NAME:
				return getName();
			case MappingPackage.MODEL_CONTAINER__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL:
				if (resolve) return getReferencedModel();
				return basicGetReferencedModel();
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				return getContainedModel();
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
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ModelElementReference>)newValue);
				return;
			case MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL:
				setReferencedModel((ModelReference)newValue);
				return;
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				setContainedModel((ModelReference)newValue);
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
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				getElements().clear();
				return;
			case MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL:
				setReferencedModel((ModelReference)null);
				return;
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				setContainedModel((ModelReference)null);
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
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case MappingPackage.MODEL_CONTAINER__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case MappingPackage.MODEL_CONTAINER__MODEL:
				return MODEL__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL:
				return referencedModel != null;
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				return containedModel != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelContainerImpl
