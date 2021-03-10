/**
 * Copyright (c) 2012-2021 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 * 
 */
package edu.toronto.cs.se.modelepedia.gsn.impl;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Property;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Property</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyImpl#getFormal <em>Formal</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyImpl#getInformal <em>Informal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyImpl extends MinimalEObjectImpl.Container implements Property {
  /**
   * The default value of the '{@link #getFormal() <em>Formal</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getFormal()
   * @generated
   * @ordered
   */
  protected static final String FORMAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFormal() <em>Formal</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getFormal()
   * @generated
   * @ordered
   */
  protected String formal = FORMAL_EDEFAULT;

  /**
   * The default value of the '{@link #getInformal() <em>Informal</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getInformal()
   * @generated
   * @ordered
   */
  protected static final String INFORMAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInformal() <em>Informal</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getInformal()
   * @generated
   * @ordered
   */
  protected String informal = INFORMAL_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected PropertyImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.PROPERTY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getInformal() {
    return informal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void setInformal(String newInformal) {
    String oldInformal = informal;
    informal = newInformal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY__INFORMAL, oldInformal, informal));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getFormal() {
    return formal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void setFormal(String newFormal) {
    String oldFormal = formal;
    formal = newFormal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY__FORMAL, oldFormal, formal));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case GSNPackage.PROPERTY__FORMAL:
      return getFormal();
    case GSNPackage.PROPERTY__INFORMAL:
      return getInformal();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case GSNPackage.PROPERTY__FORMAL:
      setFormal((String) newValue);
      return;
    case GSNPackage.PROPERTY__INFORMAL:
      setInformal((String) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case GSNPackage.PROPERTY__FORMAL:
      setFormal(FORMAL_EDEFAULT);
      return;
    case GSNPackage.PROPERTY__INFORMAL:
      setInformal(INFORMAL_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case GSNPackage.PROPERTY__FORMAL:
      return FORMAL_EDEFAULT == null ? formal != null : !FORMAL_EDEFAULT.equals(formal);
    case GSNPackage.PROPERTY__INFORMAL:
      return INFORMAL_EDEFAULT == null ? informal != null : !INFORMAL_EDEFAULT.equals(informal);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (formal: ");
    result.append(formal);
    result.append(", informal: ");
    result.append(informal);
    result.append(')');
    return result.toString();
  }

} // PropertyImpl
