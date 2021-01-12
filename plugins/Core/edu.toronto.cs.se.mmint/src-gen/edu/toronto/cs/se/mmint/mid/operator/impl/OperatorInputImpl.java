/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.operator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorInputImpl#getModel <em>Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorInputImpl#getConversions <em>Conversions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorInputImpl#getModelTypeEndpoint <em>Model Type Endpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperatorInputImpl extends MinimalEObjectImpl.Container implements OperatorInput {
    /**
   * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getModel()
   * @generated
   * @ordered
   */
    protected Model model;

    /**
   * The cached value of the '{@link #getConversions() <em>Conversions</em>}' reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getConversions()
   * @generated
   * @ordered
   */
    protected EList<ConversionOperator> conversions;

    /**
   * The cached value of the '{@link #getModelTypeEndpoint() <em>Model Type Endpoint</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getModelTypeEndpoint()
   * @generated
   * @ordered
   */
    protected ModelEndpoint modelTypeEndpoint;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected OperatorInputImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return OperatorPackage.Literals.OPERATOR_INPUT;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Model getModel() {
    if (model != null && model.eIsProxy()) {
      InternalEObject oldModel = (InternalEObject)model;
      model = (Model)eResolveProxy(oldModel);
      if (model != oldModel) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.OPERATOR_INPUT__MODEL, oldModel, model));
      }
    }
    return model;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public Model basicGetModel() {
    return model;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setModel(Model newModel) {
    Model oldModel = model;
    model = newModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_INPUT__MODEL, oldModel, model));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EList<ConversionOperator> getConversions() {
    if (conversions == null) {
      conversions = new EObjectResolvingEList<ConversionOperator>(ConversionOperator.class, this, OperatorPackage.OPERATOR_INPUT__CONVERSIONS);
    }
    return conversions;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelEndpoint getModelTypeEndpoint() {
    if (modelTypeEndpoint != null && modelTypeEndpoint.eIsProxy()) {
      InternalEObject oldModelTypeEndpoint = (InternalEObject)modelTypeEndpoint;
      modelTypeEndpoint = (ModelEndpoint)eResolveProxy(oldModelTypeEndpoint);
      if (modelTypeEndpoint != oldModelTypeEndpoint) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.OPERATOR_INPUT__MODEL_TYPE_ENDPOINT, oldModelTypeEndpoint, modelTypeEndpoint));
      }
    }
    return modelTypeEndpoint;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ModelEndpoint basicGetModelTypeEndpoint() {
    return modelTypeEndpoint;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setModelTypeEndpoint(ModelEndpoint newModelTypeEndpoint) {
    ModelEndpoint oldModelTypeEndpoint = modelTypeEndpoint;
    modelTypeEndpoint = newModelTypeEndpoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_INPUT__MODEL_TYPE_ENDPOINT, oldModelTypeEndpoint, modelTypeEndpoint));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OperatorPackage.OPERATOR_INPUT__MODEL:
        if (resolve) return getModel();
        return basicGetModel();
      case OperatorPackage.OPERATOR_INPUT__CONVERSIONS:
        return getConversions();
      case OperatorPackage.OPERATOR_INPUT__MODEL_TYPE_ENDPOINT:
        if (resolve) return getModelTypeEndpoint();
        return basicGetModelTypeEndpoint();
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
      case OperatorPackage.OPERATOR_INPUT__MODEL:
        setModel((Model)newValue);
        return;
      case OperatorPackage.OPERATOR_INPUT__CONVERSIONS:
        getConversions().clear();
        getConversions().addAll((Collection<? extends ConversionOperator>)newValue);
        return;
      case OperatorPackage.OPERATOR_INPUT__MODEL_TYPE_ENDPOINT:
        setModelTypeEndpoint((ModelEndpoint)newValue);
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
      case OperatorPackage.OPERATOR_INPUT__MODEL:
        setModel((Model)null);
        return;
      case OperatorPackage.OPERATOR_INPUT__CONVERSIONS:
        getConversions().clear();
        return;
      case OperatorPackage.OPERATOR_INPUT__MODEL_TYPE_ENDPOINT:
        setModelTypeEndpoint((ModelEndpoint)null);
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
      case OperatorPackage.OPERATOR_INPUT__MODEL:
        return model != null;
      case OperatorPackage.OPERATOR_INPUT__CONVERSIONS:
        return conversions != null && !conversions.isEmpty();
      case OperatorPackage.OPERATOR_INPUT__MODEL_TYPE_ENDPOINT:
        return modelTypeEndpoint != null;
    }
    return super.eIsSet(featureID);
  }

} //OperatorInputImpl
