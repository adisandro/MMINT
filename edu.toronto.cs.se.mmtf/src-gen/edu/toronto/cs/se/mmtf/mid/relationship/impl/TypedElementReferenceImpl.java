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
package edu.toronto.cs.se.mmtf.mid.relationship.impl;

import edu.toronto.cs.se.mmtf.mid.TypedElement;

import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl#getContainedObject <em>Contained Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl#getObject <em>Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypedElementReferenceImpl extends EObjectImpl implements TypedElementReference {
	/**
	 * The cached value of the '{@link #getReferencedObject() <em>Referenced Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedObject()
	 * @generated
	 * @ordered
	 */
	protected TypedElement referencedObject;

	/**
	 * The cached value of the '{@link #getContainedObject() <em>Contained Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedObject()
	 * @generated
	 * @ordered
	 */
	protected TypedElement containedObject;

	/**
	 * The cached setting delegate for the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate OBJECT__ESETTING_DELEGATE = ((EStructuralFeature.Internal)RelationshipPackage.Literals.TYPED_ELEMENT_REFERENCE__OBJECT).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)RelationshipPackage.Literals.TYPED_ELEMENT_REFERENCE__NAME).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate TYPE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)RelationshipPackage.Literals.TYPED_ELEMENT_REFERENCE__TYPE).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.TYPED_ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement getReferencedObject() {
		if (referencedObject != null && referencedObject.eIsProxy()) {
			InternalEObject oldReferencedObject = (InternalEObject)referencedObject;
			referencedObject = (TypedElement)eResolveProxy(oldReferencedObject);
			if (referencedObject != oldReferencedObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT, oldReferencedObject, referencedObject));
			}
		}
		return referencedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement basicGetReferencedObject() {
		return referencedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedObject(TypedElement newReferencedObject) {
		TypedElement oldReferencedObject = referencedObject;
		referencedObject = newReferencedObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT, oldReferencedObject, referencedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement getContainedObject() {
		return containedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainedObject(TypedElement newContainedObject, NotificationChain msgs) {
		TypedElement oldContainedObject = containedObject;
		containedObject = newContainedObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT, oldContainedObject, newContainedObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedObject(TypedElement newContainedObject) {
		if (newContainedObject != containedObject) {
			NotificationChain msgs = null;
			if (containedObject != null)
				msgs = ((InternalEObject)containedObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT, null, msgs);
			if (newContainedObject != null)
				msgs = ((InternalEObject)newContainedObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT, null, msgs);
			msgs = basicSetContainedObject(newContainedObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT, newContainedObject, newContainedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement getObject() {
		return (TypedElement)OBJECT__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement basicGetObject() {
		return (TypedElement)OBJECT__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
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
	public String getType() {
		return (String)TYPE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				return basicSetContainedObject(null, msgs);
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
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT:
				if (resolve) return getReferencedObject();
				return basicGetReferencedObject();
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				return getContainedObject();
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__NAME:
				return getName();
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__TYPE:
				return getType();
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
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT:
				setReferencedObject((TypedElement)newValue);
				return;
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				setContainedObject((TypedElement)newValue);
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
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT:
				setReferencedObject((TypedElement)null);
				return;
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				setContainedObject((TypedElement)null);
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
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT:
				return referencedObject != null;
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				return containedObject != null;
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__OBJECT:
				return OBJECT__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE__TYPE:
				return TYPE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

} //TypedElementReferenceImpl
