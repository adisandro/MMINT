/*******************************************************************************
 * Copyright (c) 2017, 2023 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.StatefulElement;
import edu.toronto.cs.se.modelepedia.gsn.ValidityValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Solution</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl#getStateValidity <em>State Validity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends CoreElementImpl implements Solution {
  /**
   * The default value of the '{@link #getStateValidity() <em>State Validity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateValidity()
   * @generated
   * @ordered
   */
  protected static final ValidityValue STATE_VALIDITY_EDEFAULT = ValidityValue.INVALID;

  /**
   * The cached value of the '{@link #getStateValidity() <em>State Validity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateValidity()
   * @generated
   * @ordered
   */
  protected ValidityValue stateValidity = SolutionImpl.STATE_VALIDITY_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SolutionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.SOLUTION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValidityValue getStateValidity() {
    return this.stateValidity;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStateValidity(ValidityValue newStateValidity) {
    var oldStateValidity = this.stateValidity;
    this.stateValidity = newStateValidity == null ? SolutionImpl.STATE_VALIDITY_EDEFAULT : newStateValidity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SOLUTION__STATE_VALIDITY, oldStateValidity, this.stateValidity));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.SOLUTION__STATE_VALIDITY:
        return getStateValidity();
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
      case GSNPackage.SOLUTION__STATE_VALIDITY:
        setStateValidity((ValidityValue)newValue);
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
      case GSNPackage.SOLUTION__STATE_VALIDITY:
        setStateValidity(SolutionImpl.STATE_VALIDITY_EDEFAULT);
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
      case GSNPackage.SOLUTION__STATE_VALIDITY:
        return this.stateValidity != SolutionImpl.STATE_VALIDITY_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == StatefulElement.class) {
      switch (derivedFeatureID) {
        case GSNPackage.SOLUTION__STATE_VALIDITY: return GSNPackage.STATEFUL_ELEMENT__STATE_VALIDITY;
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
    if (baseClass == StatefulElement.class) {
      switch (baseFeatureID) {
        case GSNPackage.STATEFUL_ELEMENT__STATE_VALIDITY: return GSNPackage.SOLUTION__STATE_VALIDITY;
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
    result.append(" (stateValidity: ");
    result.append(this.stateValidity);
    result.append(')');
    return result.toString();
  }

} // SolutionImpl
