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
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.safetycase.Domain;
import edu.toronto.cs.se.modelepedia.safetycase.EnumDomain;
import edu.toronto.cs.se.modelepedia.safetycase.GSNPackage;
import edu.toronto.cs.se.modelepedia.safetycase.IntDomain;
import edu.toronto.cs.se.modelepedia.safetycase.RealDomain;
import edu.toronto.cs.se.modelepedia.safetycase.ValueDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.EnumDomainImpl#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumDomainImpl extends DomainImpl implements EnumDomain {
  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<String> values;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumDomainImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.ENUM_DOMAIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getValues() {
    if (this.values == null) {
      this.values = new EDataTypeUniqueEList<>(String.class, this, GSNPackage.ENUM_DOMAIN__VALUES);
    }
    return this.values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.ENUM_DOMAIN__VALUES:
        return getValues();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case GSNPackage.ENUM_DOMAIN__VALUES:
        getValues().clear();
        getValues().addAll((Collection<? extends String>)newValue);
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
      case GSNPackage.ENUM_DOMAIN__VALUES:
        getValues().clear();
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
      case GSNPackage.ENUM_DOMAIN__VALUES:
        return this.values != null && !this.values.isEmpty();
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
    result.append(" (values: ");
    result.append(this.values);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public void validateDecomposition(EList<Domain> subDomains) throws MMINTException {
    var enumValues = new HashSet<>(getValues());
    for (var subDomain : subDomains) {
      if (subDomain instanceof IntDomain || subDomain instanceof RealDomain) {
        throw new MMINTException("An enum domain can't be decomposed into integer or real sub-domains");
      }
      else if (subDomain instanceof EnumDomain) {
        var subValues = ((EnumDomain) subDomain).getValues();
        if (!enumValues.containsAll(subValues)) {
          throw new MMINTException("One or more sub-domain values within '" + subValues +
                                   "' are not in the domain");
        }
        enumValues.removeAll(subValues);
      }
      else { // ValueDomain
        var subValue = ((ValueDomain) subDomain).getValue();
        if (!enumValues.contains(subValue)) {
          throw new MMINTException("The sub-domain value '" + subValue + "' is not in the domain");
        }
        enumValues.remove(subValue);
      }
    }
    if (!enumValues.isEmpty()) {
      throw new MMINTException("Sub-domains '" + enumValues + "' are missing");
    }
  }

} //EnumDomainImpl
