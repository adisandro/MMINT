/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.impl;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;

import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElement;

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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getReferencedModel <em>Referenced Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getContainedModel <em>Contained Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getModel <em>Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelContainerImpl extends EObjectImpl implements ModelContainer {
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
	 * The cached setting delegate for the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate TYPE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)MappingPackage.Literals.MODEL_CONTAINER__TYPE).getSettingDelegate();

	/**
	 * The cached value of the '{@link #getReferencedModel() <em>Referenced Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedModel()
	 * @generated
	 * @ordered
	 */
	protected Model referencedModel;

	/**
	 * The cached value of the '{@link #getContainedModel() <em>Contained Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedModel()
	 * @generated
	 * @ordered
	 */
	protected Model containedModel;

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
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> elements;

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
	public String getName() {
		return (String)NAME__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement getType() {
		return (ExtendibleElement)TYPE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement basicGetType() {
		return (ExtendibleElement)TYPE__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getReferencedModel() {
		if (referencedModel != null && referencedModel.eIsProxy()) {
			InternalEObject oldReferencedModel = (InternalEObject)referencedModel;
			referencedModel = (Model)eResolveProxy(oldReferencedModel);
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
	public Model basicGetReferencedModel() {
		return referencedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedModel(Model newReferencedModel) {
		Model oldReferencedModel = referencedModel;
		referencedModel = newReferencedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL, oldReferencedModel, referencedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getContainedModel() {
		return containedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainedModel(Model newContainedModel, NotificationChain msgs) {
		Model oldContainedModel = containedModel;
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
	public void setContainedModel(Model newContainedModel) {
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
	public Model getModel() {
		return (Model)MODEL__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetModel() {
		return (Model)MODEL__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<ModelElement>(ModelElement.class, this, MappingPackage.MODEL_CONTAINER__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				return basicSetContainedModel(null, msgs);
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MODEL_CONTAINER__NAME:
				return getName();
			case MappingPackage.MODEL_CONTAINER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL:
				if (resolve) return getReferencedModel();
				return basicGetReferencedModel();
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				return getContainedModel();
			case MappingPackage.MODEL_CONTAINER__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				return getElements();
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
			case MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL:
				setReferencedModel((Model)newValue);
				return;
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				setContainedModel((Model)newValue);
				return;
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ModelElement>)newValue);
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
			case MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL:
				setReferencedModel((Model)null);
				return;
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				setContainedModel((Model)null);
				return;
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				getElements().clear();
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
			case MappingPackage.MODEL_CONTAINER__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case MappingPackage.MODEL_CONTAINER__TYPE:
				return TYPE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case MappingPackage.MODEL_CONTAINER__REFERENCED_MODEL:
				return referencedModel != null;
			case MappingPackage.MODEL_CONTAINER__CONTAINED_MODEL:
				return containedModel != null;
			case MappingPackage.MODEL_CONTAINER__MODEL:
				return MODEL__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case MappingPackage.MODEL_CONTAINER__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelContainerImpl
