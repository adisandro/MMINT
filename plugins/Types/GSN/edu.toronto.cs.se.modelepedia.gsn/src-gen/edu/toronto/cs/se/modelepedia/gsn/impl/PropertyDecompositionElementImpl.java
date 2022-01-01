/**
 * Copyright (c) 2012-2022 Alessio Di Sandro, Marsha Chechik, Nick Fung.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Property;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Property Decomposition Element</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionElementImpl#getReasonerName <em>Reasoner
 * Name</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionElementImpl#getProperty
 * <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyDecompositionElementImpl extends MinimalEObjectImpl.Container implements
  PropertyDecompositionElement {
  /**
   * The default value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected static final String REASONER_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected String reasonerName = REASONER_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected Property property;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected PropertyDecompositionElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.PROPERTY_DECOMPOSITION_ELEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getReasonerName() {
    return reasonerName;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void setReasonerName(String newReasonerName) {
    String oldReasonerName = reasonerName;
    reasonerName = newReasonerName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__REASONER_NAME,
                                    oldReasonerName, reasonerName));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Property getProperty() {
    return property;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetProperty(Property newProperty, NotificationChain msgs) {
    Property oldProperty = property;
    property = newProperty;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                                                             GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY,
                                                             oldProperty, newProperty);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void setProperty(Property newProperty) {
    if (newProperty != property) {
      NotificationChain msgs = null;
      if (property != null)
        msgs = ((InternalEObject) property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
          - GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY, null, msgs);
      if (newProperty != null)
        msgs = ((InternalEObject) newProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
          - GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY, null, msgs);
      msgs = basicSetProperty(newProperty, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY,
                                    newProperty, newProperty));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
      return basicSetProperty(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__REASONER_NAME:
      return getReasonerName();
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
      return getProperty();
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
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__REASONER_NAME:
      setReasonerName((String) newValue);
      return;
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
      setProperty((Property) newValue);
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
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__REASONER_NAME:
      setReasonerName(REASONER_NAME_EDEFAULT);
      return;
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
      setProperty((Property) null);
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
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__REASONER_NAME:
      return REASONER_NAME_EDEFAULT == null ? reasonerName != null : !REASONER_NAME_EDEFAULT.equals(reasonerName);
    case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
      return property != null;
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
    result.append(" (reasonerName: ");
    result.append(reasonerName);
    result.append(')');
    return result.toString();
  }

} // PropertyDecompositionElementImpl
