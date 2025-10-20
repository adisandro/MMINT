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
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryModelRelImpl#getSourceModel <em>Source Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryModelRelImpl#getTargetModel <em>Target Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryModelRelImpl extends ModelRelImpl implements BinaryModelRel {
    /**
   * The cached value of the '{@link #getSourceModel() <em>Source Model</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getSourceModel()
   * @generated
   * @ordered
   */
    protected Model sourceModel;
    /**
   * The cached value of the '{@link #getTargetModel() <em>Target Model</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getTargetModel()
   * @generated
   * @ordered
   */
    protected Model targetModel;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected BinaryModelRelImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return RelationshipPackage.Literals.BINARY_MODEL_REL;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Model getSourceModel() {
    if (this.sourceModel != null && this.sourceModel.eIsProxy()) {
      var oldSourceModel = (InternalEObject)this.sourceModel;
      this.sourceModel = (Model)eResolveProxy(oldSourceModel);
      if (this.sourceModel != oldSourceModel) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL, oldSourceModel, this.sourceModel));
        }
      }
    }
    return this.sourceModel;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public Model basicGetSourceModel() {
    return this.sourceModel;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setSourceModel(Model newSourceModel) {
    var oldSourceModel = this.sourceModel;
    this.sourceModel = newSourceModel;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL, oldSourceModel, this.sourceModel));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Model getTargetModel() {
    if (this.targetModel != null && this.targetModel.eIsProxy()) {
      var oldTargetModel = (InternalEObject)this.targetModel;
      this.targetModel = (Model)eResolveProxy(oldTargetModel);
      if (this.targetModel != oldTargetModel) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL, oldTargetModel, this.targetModel));
        }
      }
    }
    return this.targetModel;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public Model basicGetTargetModel() {
    return this.targetModel;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setTargetModel(Model newTargetModel) {
    var oldTargetModel = this.targetModel;
    this.targetModel = newTargetModel;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL, oldTargetModel, this.targetModel));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL:
        if (resolve) {
          return getSourceModel();
        }
        return basicGetSourceModel();
      case RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL:
        if (resolve) {
          return getTargetModel();
        }
        return basicGetTargetModel();
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
      case RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL:
        setSourceModel((Model)newValue);
        return;
      case RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL:
        setTargetModel((Model)newValue);
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
      case RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL:
        setSourceModel((Model)null);
        return;
      case RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL:
        setTargetModel((Model)null);
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
      case RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL:
        return this.sourceModel != null;
      case RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL:
        return this.targetModel != null;
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
      case RelationshipPackage.BINARY_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN:
        try {
          addModelType((Model)arguments.get(0), (Boolean)arguments.get(1));
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
    public String toString() {

        var ret = this.getName() + "(";
        if (this.getSourceModel() != null) {
            ret += this.getSourceModel().getName();
        }
        ret += "->";
        if (this.getTargetModel() != null) {
            ret += this.getTargetModel().getName();
        }
        ret += ")";

        return ret;
    }

    /**
     * @generated NOT
     */
    @Override
    public void addModelType(Model modelType, boolean isBinarySrc) throws MMINTException {

        MMINTException.mustBeType(this);

        if (isBinarySrc) {
            setSourceModel(modelType);
        }
        else {
            setTargetModel(modelType);
        }
    }

} //BinaryModelRelImpl
