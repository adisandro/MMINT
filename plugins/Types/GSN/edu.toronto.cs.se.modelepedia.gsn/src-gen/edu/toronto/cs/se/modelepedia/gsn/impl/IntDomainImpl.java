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

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.Domain;
import edu.toronto.cs.se.modelepedia.gsn.EnumDomain;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.IntDomain;
import edu.toronto.cs.se.modelepedia.gsn.ValueDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Int Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.IntDomainImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.IntDomainImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntDomainImpl extends DomainImpl implements IntDomain {
  /**
   * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
  protected static final int LOWER_BOUND_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
  protected int lowerBound = IntDomainImpl.LOWER_BOUND_EDEFAULT;

  /**
   * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
  protected static final int UPPER_BOUND_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
  protected int upperBound = IntDomainImpl.UPPER_BOUND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntDomainImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.INT_DOMAIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getLowerBound() {
    return this.lowerBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLowerBound(int newLowerBound) {
    var oldLowerBound = this.lowerBound;
    this.lowerBound = newLowerBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.INT_DOMAIN__LOWER_BOUND, oldLowerBound, this.lowerBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getUpperBound() {
    return this.upperBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUpperBound(int newUpperBound) {
    var oldUpperBound = this.upperBound;
    this.upperBound = newUpperBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.INT_DOMAIN__UPPER_BOUND, oldUpperBound, this.upperBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.INT_DOMAIN__LOWER_BOUND:
        return getLowerBound();
      case GSNPackage.INT_DOMAIN__UPPER_BOUND:
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
      case GSNPackage.INT_DOMAIN__LOWER_BOUND:
        setLowerBound((Integer)newValue);
        return;
      case GSNPackage.INT_DOMAIN__UPPER_BOUND:
        setUpperBound((Integer)newValue);
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
      case GSNPackage.INT_DOMAIN__LOWER_BOUND:
        setLowerBound(IntDomainImpl.LOWER_BOUND_EDEFAULT);
        return;
      case GSNPackage.INT_DOMAIN__UPPER_BOUND:
        setUpperBound(IntDomainImpl.UPPER_BOUND_EDEFAULT);
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
      case GSNPackage.INT_DOMAIN__LOWER_BOUND:
        return this.lowerBound != IntDomainImpl.LOWER_BOUND_EDEFAULT;
      case GSNPackage.INT_DOMAIN__UPPER_BOUND:
        return this.upperBound != IntDomainImpl.UPPER_BOUND_EDEFAULT;
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
    result.append(this.lowerBound);
    result.append(", upperBound: ");
    result.append(this.upperBound);
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
  public void validateDecomposition(EList<Domain> subDomains) throws Exception {
    var subBounds = new ArrayList<IntDomain>();
    var subValues = new ArrayList<Integer>();

    for (var subDomain : subDomains) {
      if (subDomain instanceof IntDomain) {
        var lower = ((IntDomain) subDomain).getLowerBound();
        var upper = ((IntDomain) subDomain).getUpperBound();
        if (upper <= lower) {
          throw new MMINTException("Upper bound '" + upper + "' must be > lower bound '" + lower + "'");
        }
        subBounds.add((IntDomain) subDomain);
      }
      else if (subDomain instanceof EnumDomain) {
        for (var value : ((EnumDomain) subDomain).getValues()) {
          try {
            subValues.add(Integer.valueOf(value));
          }
          catch (NumberFormatException e) {
            throw new MMINTException("The sub-domain value '" + value + "' is not an integer value");
          }
        }
      }
      else { // ValueDomain
        var value = ((ValueDomain) subDomain).getValue();
        try {
          subValues.add(Integer.valueOf(value));
        }
        catch (NumberFormatException e) {
          throw new MMINTException("The sub-domain value '" + value + "' is not an integer value");
        }
      }
    }
    Collections.sort(subBounds, (i1, i2) -> Integer.compare(i1.getLowerBound(), i2.getLowerBound()));
    Collections.sort(subValues);
    var i = 0;
    var j = 0;
    Integer prevSubValue = null;
    while (true) {
      var moreBounds = (i < subBounds.size());
      var moreValues = (j < subValues.size());
      var isBound = false;
      Integer subValue = null;
      if (!moreBounds && !moreValues) {
        break;
      }
      if (moreBounds) {
        subValue = subBounds.get(i).getLowerBound();
        isBound = true;
      }
      if (moreValues) {
        var subValue2 = subValues.get(j);
        if (subValue == null || subValue > subValue2) {
          subValue = subValue2;
          isBound = false;
        }
      }
      if (prevSubValue == null) {
        if (subValue != getLowerBound()) {
          throw new MMINTException("The sub-domain lower bound does not match the domain lower bound");
        }
      }
      else {
        if ((prevSubValue + 1) > subValue) {
          throw new MMINTException("There is an overlap between sub-domain values '" + prevSubValue + "' and '" +
                                   subValue + "'");
        }
        else if ((prevSubValue + 1) < subValue) {
          throw new MMINTException("There is a gap between sub-domain values '" + prevSubValue + "' and '" + subValue +
                                   "'");
        }
      }
      if (isBound) {
        prevSubValue = subBounds.get(i).getUpperBound();
        i++;
      }
      else {
        prevSubValue = subValue;
        j++;
      }
    }
    if (prevSubValue != getUpperBound()) {
      throw new MMINTException("The sub-domain upper bound does not match the domain upper bound");
    }
  }

} //IntDomainImpl
