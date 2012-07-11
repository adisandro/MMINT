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

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;

import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extendible Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl#getContainedObject <em>Contained Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl#getObject <em>Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExtendibleElementReferenceImpl extends EObjectImpl implements ExtendibleElementReference {
	/**
	 * The cached value of the '{@link #getReferencedObject() <em>Referenced Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedObject()
	 * @generated
	 * @ordered
	 */
	protected ExtendibleElement referencedObject;

	/**
	 * The cached value of the '{@link #getContainedObject() <em>Contained Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedObject()
	 * @generated
	 * @ordered
	 */
	protected ExtendibleElement containedObject;

	/**
	 * The cached setting delegate for the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate OBJECT__ESETTING_DELEGATE = ((EStructuralFeature.Internal)RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__OBJECT).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__NAME).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate TYPE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE__TYPE).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendibleElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement getReferencedObject() {
		if (referencedObject != null && referencedObject.eIsProxy()) {
			InternalEObject oldReferencedObject = (InternalEObject)referencedObject;
			referencedObject = (ExtendibleElement)eResolveProxy(oldReferencedObject);
			if (referencedObject != oldReferencedObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT, oldReferencedObject, referencedObject));
			}
		}
		return referencedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement basicGetReferencedObject() {
		return referencedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedObject(ExtendibleElement newReferencedObject) {
		ExtendibleElement oldReferencedObject = referencedObject;
		referencedObject = newReferencedObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT, oldReferencedObject, referencedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement getContainedObject() {
		return containedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainedObject(ExtendibleElement newContainedObject, NotificationChain msgs) {
		ExtendibleElement oldContainedObject = containedObject;
		containedObject = newContainedObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT, oldContainedObject, newContainedObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedObject(ExtendibleElement newContainedObject) {
		if (newContainedObject != containedObject) {
			NotificationChain msgs = null;
			if (containedObject != null)
				msgs = ((InternalEObject)containedObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT, null, msgs);
			if (newContainedObject != null)
				msgs = ((InternalEObject)newContainedObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT, null, msgs);
			msgs = basicSetContainedObject(newContainedObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT, newContainedObject, newContainedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement getObject() {
		return (ExtendibleElement)OBJECT__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElement basicGetObject() {
		return (ExtendibleElement)OBJECT__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
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
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT:
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
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT:
				if (resolve) return getReferencedObject();
				return basicGetReferencedObject();
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				return getContainedObject();
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__NAME:
				return getName();
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__TYPE:
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
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT:
				setReferencedObject((ExtendibleElement)newValue);
				return;
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				setContainedObject((ExtendibleElement)newValue);
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
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT:
				setReferencedObject((ExtendibleElement)null);
				return;
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				setContainedObject((ExtendibleElement)null);
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
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT:
				return referencedObject != null;
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT:
				return containedObject != null;
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__OBJECT:
				return OBJECT__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__TYPE:
				return TYPE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

} //ExtendibleElementReferenceImpl
