/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl#getSourceModelElemRef <em>Source Model Elem Ref</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl#getTargetModelElemRef <em>Target Model Elem Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryMappingReferenceImpl extends MappingReferenceImpl implements BinaryMappingReference {
    /**
   * The cached value of the '{@link #getSourceModelElemRef() <em>Source Model Elem Ref</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getSourceModelElemRef()
   * @generated
   * @ordered
   */
    protected ModelElementReference sourceModelElemRef;

    /**
   * The cached value of the '{@link #getTargetModelElemRef() <em>Target Model Elem Ref</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getTargetModelElemRef()
   * @generated
   * @ordered
   */
    protected ModelElementReference targetModelElemRef;

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
    return RelationshipPackage.Literals.BINARY_MAPPING_REFERENCE;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementReference getSourceModelElemRef() {
    if (sourceModelElemRef != null && sourceModelElemRef.eIsProxy()) {
      InternalEObject oldSourceModelElemRef = (InternalEObject)sourceModelElemRef;
      sourceModelElemRef = (ModelElementReference)eResolveProxy(oldSourceModelElemRef);
      if (sourceModelElemRef != oldSourceModelElemRef) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF, oldSourceModelElemRef, sourceModelElemRef));
      }
    }
    return sourceModelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ModelElementReference basicGetSourceModelElemRef() {
    return sourceModelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setSourceModelElemRef(ModelElementReference newSourceModelElemRef) {
    ModelElementReference oldSourceModelElemRef = sourceModelElemRef;
    sourceModelElemRef = newSourceModelElemRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF, oldSourceModelElemRef, sourceModelElemRef));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementReference getTargetModelElemRef() {
    if (targetModelElemRef != null && targetModelElemRef.eIsProxy()) {
      InternalEObject oldTargetModelElemRef = (InternalEObject)targetModelElemRef;
      targetModelElemRef = (ModelElementReference)eResolveProxy(oldTargetModelElemRef);
      if (targetModelElemRef != oldTargetModelElemRef) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF, oldTargetModelElemRef, targetModelElemRef));
      }
    }
    return targetModelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ModelElementReference basicGetTargetModelElemRef() {
    return targetModelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setTargetModelElemRef(ModelElementReference newTargetModelElemRef) {
    ModelElementReference oldTargetModelElemRef = targetModelElemRef;
    targetModelElemRef = newTargetModelElemRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF, oldTargetModelElemRef, targetModelElemRef));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public BinaryMapping getObject() {
    ExtendibleElement object = super.getObject();
    return (object == null) ? null : (BinaryMapping) object;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF:
        if (resolve) return getSourceModelElemRef();
        return basicGetSourceModelElemRef();
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF:
        if (resolve) return getTargetModelElemRef();
        return basicGetTargetModelElemRef();
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
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF:
        setSourceModelElemRef((ModelElementReference)newValue);
        return;
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF:
        setTargetModelElemRef((ModelElementReference)newValue);
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
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF:
        setSourceModelElemRef((ModelElementReference)null);
        return;
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF:
        setTargetModelElemRef((ModelElementReference)null);
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
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF:
        return sourceModelElemRef != null;
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF:
        return targetModelElemRef != null;
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
      switch (baseOperationID) {
        case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT: return RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_OBJECT;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    if (baseClass == MappingReference.class) {
      switch (baseOperationID) {
        case RelationshipPackage.MAPPING_REFERENCE___GET_OBJECT: return RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_OBJECT;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
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
      case RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_OBJECT:
        return getObject();
      case RelationshipPackage.BINARY_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN:
        try {
          addModelElementTypeReference((ModelElementReference)arguments.get(0), (Boolean)arguments.get(1));
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
    public void addModelElementTypeReference(ModelElementReference modelElemTypeRef, boolean isBinarySrc) throws MMINTException {

        MMINTException.mustBeType(this);

        if (isBinarySrc) {
            setSourceModelElemRef(modelElemTypeRef);
        }
        else {
            setTargetModelElemRef(modelElemTypeRef);
        }
    }

} //BinaryMappingReferenceImpl
