/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import java.lang.reflect.InvocationTargetException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extendible Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementReferenceImpl#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementReferenceImpl#getContainedObject <em>Contained Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementReferenceImpl#getSupertypeRef <em>Supertype Ref</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementReferenceImpl#isModifiable <em>Modifiable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ExtendibleElementReferenceImpl extends MinimalEObjectImpl.Container implements ExtendibleElementReference {
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
   * The cached value of the '{@link #getSupertypeRef() <em>Supertype Ref</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getSupertypeRef()
   * @generated
   * @ordered
   */
    protected ExtendibleElementReference supertypeRef;

    /**
   * The default value of the '{@link #isModifiable() <em>Modifiable</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #isModifiable()
   * @generated
   * @ordered
   */
    protected static final boolean MODIFIABLE_EDEFAULT = false;

    /**
   * The cached value of the '{@link #isModifiable() <em>Modifiable</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #isModifiable()
   * @generated
   * @ordered
   */
    protected boolean modifiable = MODIFIABLE_EDEFAULT;

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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public ExtendibleElement getObject() {
    return (this.getContainedObject() == null) ?
      this.getReferencedObject() :
      this.getContainedObject();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ExtendibleElementReference getSupertypeRef() {
    if (supertypeRef != null && supertypeRef.eIsProxy()) {
      InternalEObject oldSupertypeRef = (InternalEObject)supertypeRef;
      supertypeRef = (ExtendibleElementReference)eResolveProxy(oldSupertypeRef);
      if (supertypeRef != oldSupertypeRef) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF, oldSupertypeRef, supertypeRef));
      }
    }
    return supertypeRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ExtendibleElementReference basicGetSupertypeRef() {
    return supertypeRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setSupertypeRef(ExtendibleElementReference newSupertypeRef) {
    ExtendibleElementReference oldSupertypeRef = supertypeRef;
    supertypeRef = newSupertypeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF, oldSupertypeRef, supertypeRef));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isModifiable() {
    return modifiable;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setModifiable(boolean newModifiable) {
    boolean oldModifiable = modifiable;
    modifiable = newModifiable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE, oldModifiable, modifiable));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getUri() {
    ExtendibleElement object = this.getObject();
    return (object == null) ? null : object.getUri();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public MID getMIDContainer() {
    return this.getObject().getMIDContainer();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isTypesLevel() {
    return this.getObject().isTypesLevel();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isInstancesLevel() {
    return this.getObject().isInstancesLevel();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isWorkflowsLevel() {
    return this.getObject().isWorkflowsLevel();
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
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF:
        if (resolve) return getSupertypeRef();
        return basicGetSupertypeRef();
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE:
        return isModifiable();
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
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF:
        setSupertypeRef((ExtendibleElementReference)newValue);
        return;
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE:
        setModifiable((Boolean)newValue);
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
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF:
        setSupertypeRef((ExtendibleElementReference)null);
        return;
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE:
        setModifiable(MODIFIABLE_EDEFAULT);
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
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF:
        return supertypeRef != null;
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE:
        return modifiable != MODIFIABLE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_URI:
        return getUri();
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT:
        return getObject();
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_MID_CONTAINER:
        return getMIDContainer();
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___IS_TYPES_LEVEL:
        return isTypesLevel();
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL:
        return isInstancesLevel();
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL:
        return isWorkflowsLevel();
    }
    return super.eInvoke(operationID, arguments);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (modifiable: ");
    result.append(modifiable);
    result.append(')');
    return result.toString();
  }

} //ExtendibleElementReferenceImpl
