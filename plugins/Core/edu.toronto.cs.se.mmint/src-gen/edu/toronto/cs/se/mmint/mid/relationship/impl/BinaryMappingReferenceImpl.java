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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

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
    if (this.sourceModelElemRef != null && this.sourceModelElemRef.eIsProxy()) {
      var oldSourceModelElemRef = (InternalEObject)this.sourceModelElemRef;
      this.sourceModelElemRef = (ModelElementReference)eResolveProxy(oldSourceModelElemRef);
      if (this.sourceModelElemRef != oldSourceModelElemRef) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF, oldSourceModelElemRef, this.sourceModelElemRef));
        }
      }
    }
    return this.sourceModelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ModelElementReference basicGetSourceModelElemRef() {
    return this.sourceModelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setSourceModelElemRef(ModelElementReference newSourceModelElemRef) {
    var oldSourceModelElemRef = this.sourceModelElemRef;
    this.sourceModelElemRef = newSourceModelElemRef;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF, oldSourceModelElemRef, this.sourceModelElemRef));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementReference getTargetModelElemRef() {
    if (this.targetModelElemRef != null && this.targetModelElemRef.eIsProxy()) {
      var oldTargetModelElemRef = (InternalEObject)this.targetModelElemRef;
      this.targetModelElemRef = (ModelElementReference)eResolveProxy(oldTargetModelElemRef);
      if (this.targetModelElemRef != oldTargetModelElemRef) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF, oldTargetModelElemRef, this.targetModelElemRef));
        }
      }
    }
    return this.targetModelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ModelElementReference basicGetTargetModelElemRef() {
    return this.targetModelElemRef;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setTargetModelElemRef(ModelElementReference newTargetModelElemRef) {
    var oldTargetModelElemRef = this.targetModelElemRef;
    this.targetModelElemRef = newTargetModelElemRef;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF, oldTargetModelElemRef, this.targetModelElemRef));
    }
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
        if (resolve) {
          return getSourceModelElemRef();
        }
        return basicGetSourceModelElemRef();
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF:
        if (resolve) {
          return getTargetModelElemRef();
        }
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
        return this.sourceModelElemRef != null;
      case RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF:
        return this.targetModelElemRef != null;
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
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT -> RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_OBJECT;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    if (baseClass == MappingReference.class) {
      return switch (baseOperationID) {
      case RelationshipPackage.MAPPING_REFERENCE___GET_OBJECT -> RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_OBJECT;
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
    @Override
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
