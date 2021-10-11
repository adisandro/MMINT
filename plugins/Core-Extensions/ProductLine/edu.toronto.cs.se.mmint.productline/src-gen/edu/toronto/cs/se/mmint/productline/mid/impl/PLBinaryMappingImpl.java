/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.mid.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingImpl;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMapping;
import edu.toronto.cs.se.mmint.productline.mid.PLMapping;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PL Binary Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingImpl#getPresenceCondition <em>Presence Condition</em>}</li>
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
    return ProductLineMIDPackage.Literals.PL_BINARY_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getPresenceCondition() {
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
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLineMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION,
                                    oldPresenceCondition, this.presenceCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ProductLineMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
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
    case ProductLineMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
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
    case ProductLineMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
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
    case ProductLineMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
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
      switch (derivedFeatureID) {
      case ProductLineMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION:
        return ProductLinePackage.PL_ELEMENT__PRESENCE_CONDITION;
      default:
        return -1;
      }
    }
    if (baseClass == PLMapping.class) {
      switch (derivedFeatureID) {
      default:
        return -1;
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
    if (baseClass == PLElement.class) {
      switch (baseFeatureID) {
      case ProductLinePackage.PL_ELEMENT__PRESENCE_CONDITION:
        return ProductLineMIDPackage.PL_BINARY_MAPPING__PRESENCE_CONDITION;
      default:
        return -1;
      }
    }
    if (baseClass == PLMapping.class) {
      switch (baseFeatureID) {
      default:
        return -1;
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
    if (eIsProxy())
      return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (presenceCondition: ");
    result.append(this.presenceCondition);
    result.append(')');
    return result.toString();
  }

} //PLBinaryMappingImpl
