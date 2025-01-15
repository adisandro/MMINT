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
package edu.toronto.cs.se.mmint.mid.operator.impl;

import edu.toronto.cs.se.mmint.mid.GenericElement;

import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorGenericImpl#getGeneric <em>Generic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorGenericImpl#getGenericSuperTypeEndpoint <em>Generic Super Type Endpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperatorGenericImpl extends MinimalEObjectImpl.Container implements OperatorGeneric {
    /**
   * The cached value of the '{@link #getGeneric() <em>Generic</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getGeneric()
   * @generated
   * @ordered
   */
    protected GenericElement generic;

    /**
   * The cached value of the '{@link #getGenericSuperTypeEndpoint() <em>Generic Super Type Endpoint</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getGenericSuperTypeEndpoint()
   * @generated
   * @ordered
   */
    protected GenericEndpoint genericSuperTypeEndpoint;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected OperatorGenericImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return OperatorPackage.Literals.OPERATOR_GENERIC;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public GenericElement getGeneric() {
    if (generic != null && generic.eIsProxy()) {
      InternalEObject oldGeneric = (InternalEObject)generic;
      generic = (GenericElement)eResolveProxy(oldGeneric);
      if (generic != oldGeneric) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.OPERATOR_GENERIC__GENERIC, oldGeneric, generic));
      }
    }
    return generic;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public GenericElement basicGetGeneric() {
    return generic;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setGeneric(GenericElement newGeneric) {
    GenericElement oldGeneric = generic;
    generic = newGeneric;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_GENERIC__GENERIC, oldGeneric, generic));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public GenericEndpoint getGenericSuperTypeEndpoint() {
    if (genericSuperTypeEndpoint != null && genericSuperTypeEndpoint.eIsProxy()) {
      InternalEObject oldGenericSuperTypeEndpoint = (InternalEObject)genericSuperTypeEndpoint;
      genericSuperTypeEndpoint = (GenericEndpoint)eResolveProxy(oldGenericSuperTypeEndpoint);
      if (genericSuperTypeEndpoint != oldGenericSuperTypeEndpoint) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT, oldGenericSuperTypeEndpoint, genericSuperTypeEndpoint));
      }
    }
    return genericSuperTypeEndpoint;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public GenericEndpoint basicGetGenericSuperTypeEndpoint() {
    return genericSuperTypeEndpoint;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setGenericSuperTypeEndpoint(GenericEndpoint newGenericSuperTypeEndpoint) {
    GenericEndpoint oldGenericSuperTypeEndpoint = genericSuperTypeEndpoint;
    genericSuperTypeEndpoint = newGenericSuperTypeEndpoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT, oldGenericSuperTypeEndpoint, genericSuperTypeEndpoint));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OperatorPackage.OPERATOR_GENERIC__GENERIC:
        if (resolve) return getGeneric();
        return basicGetGeneric();
      case OperatorPackage.OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT:
        if (resolve) return getGenericSuperTypeEndpoint();
        return basicGetGenericSuperTypeEndpoint();
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
      case OperatorPackage.OPERATOR_GENERIC__GENERIC:
        setGeneric((GenericElement)newValue);
        return;
      case OperatorPackage.OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT:
        setGenericSuperTypeEndpoint((GenericEndpoint)newValue);
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
      case OperatorPackage.OPERATOR_GENERIC__GENERIC:
        setGeneric((GenericElement)null);
        return;
      case OperatorPackage.OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT:
        setGenericSuperTypeEndpoint((GenericEndpoint)null);
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
      case OperatorPackage.OPERATOR_GENERIC__GENERIC:
        return generic != null;
      case OperatorPackage.OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT:
        return genericSuperTypeEndpoint != null;
    }
    return super.eIsSet(featureID);
  }

} //OperatorGenericImpl
