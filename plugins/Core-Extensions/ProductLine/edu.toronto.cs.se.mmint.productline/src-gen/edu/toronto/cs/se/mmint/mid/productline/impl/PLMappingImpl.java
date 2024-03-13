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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.mid.productline.MIDPLHeavyTypeFactory;
import edu.toronto.cs.se.mmint.mid.productline.MIDPLPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLMapping;
import edu.toronto.cs.se.mmint.mid.relationship.impl.MappingImpl;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.PLUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PL Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingImpl#getPresenceCondition <em>Presence Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PLMappingImpl extends MappingImpl implements PLMapping {
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
  protected String presenceCondition = PLMappingImpl.PRESENCE_CONDITION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLMappingImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MIDPLPackage.Literals.PL_MAPPING;
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
   * @generated NOT
   */
  @Override
  public String getPresenceCondition() {
    return PLUtils.getPresenceCondition(this, getPresenceConditionGen());
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
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPLPackage.PL_MAPPING__PRESENCE_CONDITION,
                                    oldPresenceCondition, this.presenceCondition));
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public ProductLine getProductLine() {
    return MIDPLHeavyTypeFactory.getProductLine(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MIDPLPackage.PL_MAPPING__PRESENCE_CONDITION:
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
    case MIDPLPackage.PL_MAPPING__PRESENCE_CONDITION:
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
    case MIDPLPackage.PL_MAPPING__PRESENCE_CONDITION:
      setPresenceCondition(PLMappingImpl.PRESENCE_CONDITION_EDEFAULT);
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
    case MIDPLPackage.PL_MAPPING__PRESENCE_CONDITION:
      return PLMappingImpl.PRESENCE_CONDITION_EDEFAULT == null ? this.presenceCondition != null
        : !PLMappingImpl.PRESENCE_CONDITION_EDEFAULT.equals(this.presenceCondition);
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
      case MIDPLPackage.PL_MAPPING__PRESENCE_CONDITION -> PLPackage.PL_ELEMENT__PRESENCE_CONDITION;
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
      case PLPackage.PL_ELEMENT__PRESENCE_CONDITION -> MIDPLPackage.PL_MAPPING__PRESENCE_CONDITION;
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
  public String toMIDCustomPrintLabel() {
    return PLUtils.getPresenceConditionLabel(this, true);
  }

  /**
   * @generated NOT
   */
  @Override
  public String toMIDCustomEditLabel() {
    return PLUtils.getPresenceConditionLabel(this, false);
  }

  /**
   * @generated NOT
   */
  @Override
  public void updateMIDCustomLabel(String newLabel) {
    setPresenceCondition(newLabel);
  }

  /**
   * @generated NOT
   */
  @Override
  public boolean isAlwaysPresent() {
    return PLUtils.isAlwaysPresent(this, getPresenceConditionGen());
  }

} //PLMappingImpl
