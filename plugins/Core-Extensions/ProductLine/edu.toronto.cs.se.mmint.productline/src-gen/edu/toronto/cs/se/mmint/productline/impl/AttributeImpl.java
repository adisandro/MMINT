/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.AttributeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.AttributeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends PLElementImpl implements Attribute {
  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = AttributeImpl.VALUE_EDEFAULT;
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EAttribute type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ProductLinePackage.Literals.ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getValue() {
    return this.value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setValue(String newValue) {
    var oldValue = this.value;
    this.value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.ATTRIBUTE__VALUE, oldValue, this.value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getType() {
    if (this.type != null && this.type.eIsProxy()) {
      var oldType = (InternalEObject) this.type;
      this.type = (EAttribute) eResolveProxy(oldType);
      if (this.type != oldType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductLinePackage.ATTRIBUTE__TYPE, oldType, this.type));
      }
    }
    return this.type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute basicGetType() {
    return this.type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(EAttribute newType) {
    var oldType = this.type;
    this.type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.ATTRIBUTE__TYPE, oldType, this.type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ProductLinePackage.ATTRIBUTE__VALUE:
      return getValue();
    case ProductLinePackage.ATTRIBUTE__TYPE:
      if (resolve)
        return getType();
      return basicGetType();
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
    case ProductLinePackage.ATTRIBUTE__VALUE:
      setValue((String) newValue);
      return;
    case ProductLinePackage.ATTRIBUTE__TYPE:
      setType((EAttribute) newValue);
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
    case ProductLinePackage.ATTRIBUTE__VALUE:
      setValue(AttributeImpl.VALUE_EDEFAULT);
      return;
    case ProductLinePackage.ATTRIBUTE__TYPE:
      setType((EAttribute) null);
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
    case ProductLinePackage.ATTRIBUTE__VALUE:
      return AttributeImpl.VALUE_EDEFAULT == null ? this.value != null : !AttributeImpl.VALUE_EDEFAULT.equals(this.value);
    case ProductLinePackage.ATTRIBUTE__TYPE:
      return this.type != null;
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
    if (eIsProxy())
      return super.toString();

    var result = new StringBuilder(super.toString());
    result.append(" (value: ");
    result.append(this.value);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public ProductLine getProductLine() {
    return (ProductLine) eContainer().eContainer();
  }

} //AttributeImpl
