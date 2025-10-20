/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointReferenceImpl#getModelElemRef <em>Model Elem Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelElementEndpointReferenceImpl extends ExtendibleElementEndpointReferenceImpl implements ModelElementEndpointReference {
    /**
   * The cached value of the '{@link #getModelElemRef() <em>Model Elem Ref</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getModelElemRef()
   * @generated
   * @ordered
   */
    protected ModelElementReference modelElemRef;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected ModelElementEndpointReferenceImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return RelationshipPackage.Literals.MODEL_ELEMENT_ENDPOINT_REFERENCE;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementReference getModelElemRef() {
    if (this.modelElemRef != null && this.modelElemRef.eIsProxy()) {
      var oldModelElemRef = (InternalEObject)this.modelElemRef;
      this.modelElemRef = (ModelElementReference)eResolveProxy(oldModelElemRef);
      if (this.modelElemRef != oldModelElemRef) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF, oldModelElemRef, this.modelElemRef));
        }
      }
    }
    return this.modelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ModelElementReference basicGetModelElemRef() {
    return this.modelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public NotificationChain basicSetModelElemRef(ModelElementReference newModelElemRef, NotificationChain msgs) {
    var oldModelElemRef = this.modelElemRef;
    this.modelElemRef = newModelElemRef;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF, oldModelElemRef, newModelElemRef);
      if (msgs == null) {
        msgs = notification;
      }
      else {
        msgs.add(notification);
      }
    }
    return msgs;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setModelElemRef(ModelElementReference newModelElemRef) {
    if (newModelElemRef != this.modelElemRef) {
      NotificationChain msgs = null;
      if (this.modelElemRef != null) {
        msgs = ((InternalEObject)this.modelElemRef).eInverseRemove(this, RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS, ModelElementReference.class, msgs);
      }
      if (newModelElemRef != null) {
        msgs = ((InternalEObject)newModelElemRef).eInverseAdd(this, RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS, ModelElementReference.class, msgs);
      }
      msgs = basicSetModelElemRef(newModelElemRef, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF, newModelElemRef, newModelElemRef));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementEndpoint getObject() {
    var object = super.getObject();
    return (object == null) ? null : (ModelElementEndpoint) object;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementEndpointReference getSupertypeRef() {
    var supertypeRef = super.getSupertypeRef();
    return (supertypeRef == null) ? null : (ModelElementEndpointReference) supertypeRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
        if (this.modelElemRef != null) {
          msgs = ((InternalEObject)this.modelElemRef).eInverseRemove(this, RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS, ModelElementReference.class, msgs);
        }
        return basicSetModelElemRef((ModelElementReference)otherEnd, msgs);
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
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
        return basicSetModelElemRef(null, msgs);
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
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
        if (resolve) {
          return getModelElemRef();
        }
        return basicGetModelElemRef();
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
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
        setModelElemRef((ModelElementReference)newValue);
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
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
        setModelElemRef((ModelElementReference)null);
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
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
        return this.modelElemRef != null;
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == ExtendibleElementReference.class) {
      return switch (baseOperationID) {
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT -> RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    if (baseClass == ExtendibleElementEndpointReference.class) {
      return switch (baseOperationID) {
      case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT -> RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT;
      case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF -> RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT:
        return getObject();
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF:
        return getSupertypeRef();
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN:
        try {
          deleteTypeReference((Boolean)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_AND_REFERENCE__BOOLEAN:
        try {
          deleteTypeAndReference((Boolean)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN:
        try {
          deleteInstanceAndReference((Boolean)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

    /**
     * @generated NOT
     */
    @Override
    public void deleteTypeReference(boolean isFullDelete) throws MMINTException {

        MMINTException.mustBeType(this);

        if (isFullDelete) {
            setModelElemRef(null);
            ((MappingReference) this.eContainer()).getModelElemEndpointRefs().remove(this);
        }
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteTypeAndReference(boolean isFullDelete) throws MMINTException {

        MMINTException.mustBeType(this);

        var typeMID = this.getMIDContainer();
        var mappingTypeRef = (MappingReference) this.eContainer();
        var modelRelType = (ModelRel) mappingTypeRef.eContainer();
        // delete the "thing" and the corresponding reference
        getObject().deleteType(isFullDelete);
        if (isFullDelete) {
            mappingTypeRef.getObject().getModelElemEndpointRefs().remove(this);
        }
        deleteTypeReference(isFullDelete);
        // delete references of the "thing" in subtypes of the container's container
        for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(modelRelType, typeMID)) {
            MappingReference mappingSubtypeRef = MIDRegistry.getReference(mappingTypeRef, modelRelSubtype.getMappingRefs());
            ModelElementEndpointReference modelElemSubtypeEndpointRef = MIDRegistry.getReference(this, mappingSubtypeRef.getModelElemEndpointRefs());
            modelElemSubtypeEndpointRef.deleteTypeReference(isFullDelete);
        }
        // delete references of the "thing" in subtypes of the container
        for (Mapping mappingSubtype : MIDTypeHierarchy.getSubtypes(mappingTypeRef.getObject(), typeMID)) {
            if (isFullDelete) {
                mappingSubtype.getModelElemEndpointRefs().remove(this);
            }
        }
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteInstanceAndReference(boolean isFullDelete) throws MMINTException {

        MMINTException.mustBeInstance(this);

        var mappingRef = (MappingReference) this.eContainer();
        var mapping = mappingRef.getObject();
        if (isFullDelete) {
            mapping.getModelElemEndpoints().remove(getObject());
            mappingRef.getModelElemEndpointRefs().remove(this);
            mapping.getModelElemEndpointRefs().remove(this);
            setModelElemRef(null);
        }
    }

} //ModelElementEndpointReferenceImpl
