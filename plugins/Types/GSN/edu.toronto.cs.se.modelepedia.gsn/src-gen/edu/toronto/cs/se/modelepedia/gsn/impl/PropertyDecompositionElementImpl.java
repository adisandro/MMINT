/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Decomposition Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionElementImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionElementImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDecompositionElementImpl extends MinimalEObjectImpl.Container implements PropertyDecompositionElement {
  /**
   * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguage()
   * @generated
   * @ordered
   */
  protected static final String LANGUAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguage()
   * @generated
   * @ordered
   */
  protected String language = PropertyDecompositionElementImpl.LANGUAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected static final String PROPERTY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected String property = PropertyDecompositionElementImpl.PROPERTY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyDecompositionElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.PROPERTY_DECOMPOSITION_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLanguage() {
    return this.language;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLanguage(String newLanguage) {
    var oldLanguage = this.language;
    this.language = newLanguage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__LANGUAGE, oldLanguage, this.language));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getProperty() {
    return this.property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(String newProperty) {
    var oldProperty = this.property;
    this.property = newProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY, oldProperty, this.property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__LANGUAGE:
        return getLanguage();
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
        return getProperty();
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
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__LANGUAGE:
        setLanguage((String)newValue);
        return;
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
        setProperty((String)newValue);
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
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__LANGUAGE:
        setLanguage(PropertyDecompositionElementImpl.LANGUAGE_EDEFAULT);
        return;
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
        setProperty(PropertyDecompositionElementImpl.PROPERTY_EDEFAULT);
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
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__LANGUAGE:
        return PropertyDecompositionElementImpl.LANGUAGE_EDEFAULT == null ? this.language != null : !PropertyDecompositionElementImpl.LANGUAGE_EDEFAULT.equals(this.language);
      case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY:
        return PropertyDecompositionElementImpl.PROPERTY_EDEFAULT == null ? this.property != null : !PropertyDecompositionElementImpl.PROPERTY_EDEFAULT.equals(this.property);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    var result = new StringBuilder(super.toString());
    result.append(" (language: ");
    result.append(this.language);
    result.append(", property: ");
    result.append(this.property);
    result.append(')');
    return result.toString();
  }

} //PropertyDecompositionElementImpl
