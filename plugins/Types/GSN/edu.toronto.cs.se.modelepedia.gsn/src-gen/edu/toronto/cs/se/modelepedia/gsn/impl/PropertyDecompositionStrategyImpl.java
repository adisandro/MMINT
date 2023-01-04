/*******************************************************************************
 * Copyright (c) 2020, 2023 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Property;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNDecompositionTrait;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Property Decomposition Strategy</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionStrategyImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionStrategyImpl#getReasonerName <em>Reasoner Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDecompositionStrategyImpl extends DecompositionStrategyImpl implements
  PropertyDecompositionStrategy {
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected Property property;

  /**
   * The default value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected static final String REASONER_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected String reasonerName = PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PropertyDecompositionStrategyImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.PROPERTY_DECOMPOSITION_STRATEGY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getReasonerName() {
    return this.reasonerName;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReasonerName(String newReasonerName) {
    var oldReasonerName = this.reasonerName;
    this.reasonerName = newReasonerName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME, oldReasonerName, this.reasonerName));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Property getProperty() {
    return this.property;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProperty(Property newProperty, NotificationChain msgs) {
    var oldProperty = this.property;
    this.property = newProperty;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, oldProperty, newProperty);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(Property newProperty) {
    if (newProperty != this.property) {
      NotificationChain msgs = null;
      if (this.property != null)
        msgs = ((InternalEObject)this.property).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, null, msgs);
      if (newProperty != null)
        msgs = ((InternalEObject)newProperty).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, null, msgs);
      msgs = basicSetProperty(newProperty, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, newProperty, newProperty));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        return basicSetProperty(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    var reasonerName = Objects.requireNonNull(getReasonerName(), "Reasoner not specified");
    var reasoner = Objects.requireNonNull(MMINT.getReasoner(reasonerName),
                                          "The reasoner '" + reasonerName + "' is not installed");
    if (!(reasoner instanceof IGSNDecompositionTrait gsnReasoner)) {
      throw new MMINTException("The reasoner '" + reasonerName + "' does not support GSN property decompositions");
    }
    Objects.requireNonNull(getProperty(), "Property not specified");
    gsnReasoner.validatePropertyDecomposition(this);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        return getProperty();
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        return getReasonerName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        setProperty((Property)newValue);
        return;
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        setReasonerName((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        setProperty((Property)null);
        return;
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        setReasonerName(PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        return this.property != null;
      case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        return PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT == null ? this.reasonerName != null : !PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT.equals(this.reasonerName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == PropertyDecompositionElement.class) {
      switch (derivedFeatureID) {
        case GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY: return GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == PropertyDecompositionElement.class) {
      switch (baseFeatureID) {
        case GSNPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY: return GSNPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (reasonerName: ");
    result.append(this.reasonerName);
    result.append(')');
    return result.toString();
  }

} // PropertyDecompositionStrategyImpl
