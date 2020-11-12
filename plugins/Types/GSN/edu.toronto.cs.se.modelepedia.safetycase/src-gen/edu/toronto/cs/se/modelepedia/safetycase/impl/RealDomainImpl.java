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

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.safetycase.Domain;
import edu.toronto.cs.se.modelepedia.safetycase.EnumDomain;
import edu.toronto.cs.se.modelepedia.safetycase.GSNPackage;
import edu.toronto.cs.se.modelepedia.safetycase.IntDomain;
import edu.toronto.cs.se.modelepedia.safetycase.RealDomain;
import edu.toronto.cs.se.modelepedia.safetycase.ValueDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.RealDomainImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.RealDomainImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RealDomainImpl extends DomainImpl implements RealDomain {
  /**
   * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
  protected static final double LOWER_BOUND_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
  protected double lowerBound = LOWER_BOUND_EDEFAULT;

  /**
   * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
  protected static final double UPPER_BOUND_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
  protected double upperBound = UPPER_BOUND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RealDomainImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.REAL_DOMAIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public double getLowerBound() {
    return lowerBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLowerBound(double newLowerBound) {
    double oldLowerBound = lowerBound;
    lowerBound = newLowerBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.REAL_DOMAIN__LOWER_BOUND, oldLowerBound, lowerBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public double getUpperBound() {
    return upperBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUpperBound(double newUpperBound) {
    double oldUpperBound = upperBound;
    upperBound = newUpperBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.REAL_DOMAIN__UPPER_BOUND, oldUpperBound, upperBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.REAL_DOMAIN__LOWER_BOUND:
        return getLowerBound();
      case GSNPackage.REAL_DOMAIN__UPPER_BOUND:
        return getUpperBound();
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
      case GSNPackage.REAL_DOMAIN__LOWER_BOUND:
        setLowerBound((Double)newValue);
        return;
      case GSNPackage.REAL_DOMAIN__UPPER_BOUND:
        setUpperBound((Double)newValue);
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
      case GSNPackage.REAL_DOMAIN__LOWER_BOUND:
        setLowerBound(LOWER_BOUND_EDEFAULT);
        return;
      case GSNPackage.REAL_DOMAIN__UPPER_BOUND:
        setUpperBound(UPPER_BOUND_EDEFAULT);
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
      case GSNPackage.REAL_DOMAIN__LOWER_BOUND:
        return lowerBound != LOWER_BOUND_EDEFAULT;
      case GSNPackage.REAL_DOMAIN__UPPER_BOUND:
        return upperBound != UPPER_BOUND_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toStringGen() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (lowerBound: ");
    result.append(lowerBound);
    result.append(", upperBound: ");
    result.append(upperBound);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public String toString() {
    return getLowerBound() + "_" + getUpperBound();
  }

  /**
   * @generated NOT
   */
  @Override
  public void validateDecomposition(EList<Domain> subDomains) throws MMINTException {
    var subBounds = new ArrayList<RealDomain>();
    for (var subDomain : subDomains) {
      if (subDomain instanceof IntDomain || subDomain instanceof EnumDomain || subDomain instanceof ValueDomain) {
        throw new MMINTException("A real domain can't be decomposed into integer, enum or value sub-domains");
      }
      else { // RealDomain
        var lower = ((RealDomain) subDomain).getLowerBound();
        var upper = ((RealDomain) subDomain).getUpperBound();
        if (upper <= lower) {
          throw new MMINTException("Upper bound '" + upper + "' must be > lower bound '" + lower + "'");
        }
        subBounds.add((RealDomain) subDomain);
      }
    }
    Collections.sort(subBounds, (r1, r2) -> Double.compare(r1.getLowerBound(), r2.getLowerBound()));
    if (subBounds.get(0).getLowerBound() != getLowerBound()) {
      throw new MMINTException("The lowest sub-domain bound does not match the domain lower bound");
    }
    if (subBounds.get(subBounds.size()-1).getUpperBound() != getUpperBound()) {
      throw new MMINTException("The uppermost sub-domain bound does not match the domain upper bound");
    }
    for (var i = 0; i < subBounds.size()-1; i++) {
      var a = subBounds.get(i).getUpperBound();
      var b = subBounds.get(i+1).getLowerBound();
      if (a > b) {
        throw new MMINTException("There is overlap between sub-domain bounds '_" + a + ")' and '(" + b + "_'");
      }
      else if (a < b) {
        throw new MMINTException("There is a hole between sub-domain bounds '_" + a + ")' and '(" + b + "_'");
      }
    }
  }

} //RealDomainImpl
