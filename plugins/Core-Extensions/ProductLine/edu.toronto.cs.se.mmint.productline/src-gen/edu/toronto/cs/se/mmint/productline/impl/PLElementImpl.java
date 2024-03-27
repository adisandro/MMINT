/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PL Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.PLElementImpl#getPresenceCondition <em>Presence Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PLElementImpl extends MinimalEObjectImpl.Container implements PLElement {
  /**
   * The default value of the '{@link #getPresenceCondition() <em>Presence Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPresenceCondition()
   * @generated
   * @ordered
   */
  protected static final String PRESENCE_CONDITION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPresenceCondition() <em>Presence Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPresenceCondition()
   * @generated
   * @ordered
   */
  protected String presenceCondition = PLElementImpl.PRESENCE_CONDITION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLPackage.Literals.PL_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPresenceConditionGen() {
    return this.presenceCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPresenceCondition(String newPresenceCondition) {
    var oldPresenceCondition = this.presenceCondition;
    this.presenceCondition = newPresenceCondition;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, PLPackage.PL_ELEMENT__PRESENCE_CONDITION,
                                    oldPresenceCondition, this.presenceCondition));
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
    case PLPackage.PL_ELEMENT__PRESENCE_CONDITION:
      return getPresenceCondition();
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
    case PLPackage.PL_ELEMENT__PRESENCE_CONDITION:
      setPresenceCondition((String) newValue);
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
    case PLPackage.PL_ELEMENT__PRESENCE_CONDITION:
      setPresenceCondition(PLElementImpl.PRESENCE_CONDITION_EDEFAULT);
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
    case PLPackage.PL_ELEMENT__PRESENCE_CONDITION:
      return PLElementImpl.PRESENCE_CONDITION_EDEFAULT == null ? this.presenceCondition != null
        : !PLElementImpl.PRESENCE_CONDITION_EDEFAULT.equals(this.presenceCondition);
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
    case PLPackage.PL_ELEMENT___GET_PRODUCT_LINE:
      return getProductLine();
    case PLPackage.PL_ELEMENT___IS_ALWAYS_PRESENT:
      return isAlwaysPresent();
    case PLPackage.PL_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN:
      return getPresenceConditionLabel((Boolean) arguments.get(0));
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (presenceCondition: ");
    result.append(this.presenceCondition);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public ProductLine getProductLine() {
    return (ProductLine) eContainer();
  }

  /**
   * @generated NOT
   */
  public static @Nullable String getPresenceCondition(ProductLine productLine, @Nullable String presenceCondition) {
    if (presenceCondition == null) {
      try {
        presenceCondition = productLine.getReasoner().getTrueLiteral();
      }
      catch (MMINTException e) {
        // fallback to null presence condition
      }
    }
    return presenceCondition;
  }

  /**
   * @generated NOT
   */
  @Override
  public String getPresenceCondition() {
    return getPresenceCondition(getProductLine(), getPresenceConditionGen());
  }

  /**
   * @generated NOT
   */
  public static boolean isAlwaysPresent(ProductLine productLine, @Nullable String presenceCondition) {
    try {
      if (presenceCondition == null || presenceCondition.strip().equals(productLine.getReasoner().getTrueLiteral())) {
        return true;
      }
      return false;
    }
    catch (MMINTException e) {
      return false;
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public boolean isAlwaysPresent() {
    return isAlwaysPresent(getProductLine(), getPresenceConditionGen());
  }

  /**
   * @generated NOT
   */
  public static String getPresenceConditionLabel(PLElement plElem, boolean withParenthesis) {
    if (plElem.isAlwaysPresent()) {
      return "";
    }
    var pc = plElem.getPresenceCondition();
    if (withParenthesis) {
      return "(" + pc + ")";
    }
    return pc;
  }

  /**
   * @generated NOT
   */
  @Override
  public String getPresenceConditionLabel(boolean withParenthesis) {
    return getPresenceConditionLabel(this, withParenthesis);
  }

} //PLElementImpl
