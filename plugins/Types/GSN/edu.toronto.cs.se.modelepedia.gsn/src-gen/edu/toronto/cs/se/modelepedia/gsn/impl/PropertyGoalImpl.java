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

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyGoalImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyGoalImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyGoalImpl extends GoalImpl implements PropertyGoal {
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
  protected String language = PropertyGoalImpl.LANGUAGE_EDEFAULT;

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
  protected String property = PropertyGoalImpl.PROPERTY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyGoalImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.PROPERTY_GOAL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_GOAL__LANGUAGE, oldLanguage, this.language));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_GOAL__PROPERTY, oldProperty, this.property));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.PROPERTY_GOAL__LANGUAGE:
        return getLanguage();
      case GSNPackage.PROPERTY_GOAL__PROPERTY:
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
      case GSNPackage.PROPERTY_GOAL__LANGUAGE:
        setLanguage((String)newValue);
        return;
      case GSNPackage.PROPERTY_GOAL__PROPERTY:
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
      case GSNPackage.PROPERTY_GOAL__LANGUAGE:
        setLanguage(PropertyGoalImpl.LANGUAGE_EDEFAULT);
        return;
      case GSNPackage.PROPERTY_GOAL__PROPERTY:
        setProperty(PropertyGoalImpl.PROPERTY_EDEFAULT);
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
      case GSNPackage.PROPERTY_GOAL__LANGUAGE:
        return PropertyGoalImpl.LANGUAGE_EDEFAULT == null ? this.language != null : !PropertyGoalImpl.LANGUAGE_EDEFAULT.equals(this.language);
      case GSNPackage.PROPERTY_GOAL__PROPERTY:
        return PropertyGoalImpl.PROPERTY_EDEFAULT == null ? this.property != null : !PropertyGoalImpl.PROPERTY_EDEFAULT.equals(this.property);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == PropertyDecompositionElement.class) {
      switch (derivedFeatureID) {
        case GSNPackage.PROPERTY_GOAL__LANGUAGE: return GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__LANGUAGE;
        case GSNPackage.PROPERTY_GOAL__PROPERTY: return GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == PropertyDecompositionElement.class) {
      switch (baseFeatureID) {
        case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__LANGUAGE: return GSNPackage.PROPERTY_GOAL__LANGUAGE;
        case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY: return GSNPackage.PROPERTY_GOAL__PROPERTY;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //PropertyGoalImpl