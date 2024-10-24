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
package edu.toronto.cs.se.mmint.mid.productline.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLMIDHeavyTypeFactory;
import edu.toronto.cs.se.mmint.mid.productline.PLMIDPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLMapping;
import edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingImpl;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.impl.PLElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PL Binary Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingImpl#getPresenceCondition <em>Presence Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PLBinaryMappingImpl extends BinaryMappingImpl implements PLBinaryMapping {
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
  protected String presenceCondition = PLBinaryMappingImpl.PRESENCE_CONDITION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLBinaryMappingImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLMIDPackage.Literals.PL_BINARY_MAPPING;
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
      eNotify(new ENotificationImpl(this, Notification.SET, PLMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION,
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
    case PLMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
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
    case PLMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
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
    case PLMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
      setPresenceCondition(PLBinaryMappingImpl.PRESENCE_CONDITION_EDEFAULT);
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
    case PLMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
      return PLBinaryMappingImpl.PRESENCE_CONDITION_EDEFAULT == null ? this.presenceCondition != null
        : !PLBinaryMappingImpl.PRESENCE_CONDITION_EDEFAULT.equals(this.presenceCondition);
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
    if (baseClass == PLElement.class) {
      return switch (derivedFeatureID) {
      case PLMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION -> PLPackage.PL_ELEMENT__PRESENCE_CONDITION;
      default -> -1;
      };
    }
    if (baseClass == PLMapping.class) {
      return switch (derivedFeatureID) {
      default -> -1;
      };
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
    if (baseClass == PLElement.class) {
      return switch (baseFeatureID) {
      case PLPackage.PL_ELEMENT__PRESENCE_CONDITION -> PLMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION;
      default -> -1;
      };
    }
    if (baseClass == PLMapping.class) {
      return switch (baseFeatureID) {
      default -> -1;
      };
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == PLElement.class) {
      return switch (baseOperationID) {
      case PLPackage.PL_ELEMENT___GET_PRODUCT_LINE -> PLMIDPackage.PL_BINARY_MAPPING___GET_PRODUCT_LINE;
      case PLPackage.PL_ELEMENT___IS_ALWAYS_PRESENT -> PLMIDPackage.PL_BINARY_MAPPING___IS_ALWAYS_PRESENT;
      case PLPackage.PL_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN -> PLMIDPackage.PL_BINARY_MAPPING___GET_PRESENCE_CONDITION_LABEL__BOOLEAN;
      default -> -1;
      };
    }
    if (baseClass == PLMapping.class) {
      return switch (baseOperationID) {
      case PLMIDPackage.PL_MAPPING___TO_MID_CUSTOM_PRINT_LABEL -> PLMIDPackage.PL_BINARY_MAPPING___TO_MID_CUSTOM_PRINT_LABEL;
      case PLMIDPackage.PL_MAPPING___TO_MID_CUSTOM_EDIT_LABEL -> PLMIDPackage.PL_BINARY_MAPPING___TO_MID_CUSTOM_EDIT_LABEL;
      case PLMIDPackage.PL_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING -> PLMIDPackage.PL_BINARY_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING;
      default -> -1;
      };
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
    case PLMIDPackage.PL_BINARY_MAPPING___GET_PRODUCT_LINE:
      return getProductLine();
    case PLMIDPackage.PL_BINARY_MAPPING___IS_ALWAYS_PRESENT:
      return isAlwaysPresent();
    case PLMIDPackage.PL_BINARY_MAPPING___GET_PRESENCE_CONDITION_LABEL__BOOLEAN:
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
    return PLMIDHeavyTypeFactory.getProductLine(this);
  }

  /**
   * @generated NOT
   */
  @Override
  public String getPresenceCondition() {
    return PLElementImpl.getPresenceCondition(getProductLine(), getPresenceConditionGen());
  }

  /**
   * @generated NOT
   */
  @Override
  public boolean isAlwaysPresent() {
    return PLElementImpl.isAlwaysPresent(getProductLine(), getPresenceConditionGen());
  }

  /**
   * @generated NOT
   */
  @Override
  public String getPresenceConditionLabel(boolean withParenthesis) {
    return PLElementImpl.getPresenceConditionLabel(this, withParenthesis);
  }

  /**
   * @generated NOT
   */
  @Override
  public String toMIDCustomPrintLabel() {
    return PLElementImpl.getPresenceConditionLabel(this, true);
  }

  /**
   * @generated NOT
   */
  @Override
  public String toMIDCustomEditLabel() {
    return PLElementImpl.getPresenceConditionLabel(this, false);
  }

  /**
   * @generated NOT
   */
  @Override
  public void updateMIDCustomLabel(String newLabel) {
    setPresenceCondition(newLabel);
  }

} //PLBinaryMappingImpl
