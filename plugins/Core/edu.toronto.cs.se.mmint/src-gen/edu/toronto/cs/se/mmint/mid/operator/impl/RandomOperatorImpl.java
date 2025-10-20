/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.operator.impl;

import java.util.Random;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl#getState <em>State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RandomOperatorImpl extends OperatorImpl implements RandomOperator {
    /**
   * The default value of the '{@link #getState() <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
    protected static final Random STATE_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getState() <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
    protected Random state = RandomOperatorImpl.STATE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public RandomOperatorImpl() {
        super();
    }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return OperatorPackage.Literals.RANDOM_OPERATOR;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Random getState() {
    return this.state;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setState(Random newState) {
    var oldState = this.state;
    this.state = newState;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.RANDOM_OPERATOR__STATE, oldState, this.state));
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
      case OperatorPackage.RANDOM_OPERATOR__STATE:
        return getState();
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
      case OperatorPackage.RANDOM_OPERATOR__STATE:
        setState((Random)newValue);
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
      case OperatorPackage.RANDOM_OPERATOR__STATE:
        setState(RandomOperatorImpl.STATE_EDEFAULT);
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
      case OperatorPackage.RANDOM_OPERATOR__STATE:
        return RandomOperatorImpl.STATE_EDEFAULT == null ? this.state != null : !RandomOperatorImpl.STATE_EDEFAULT.equals(this.state);
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String toStringGen() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (state: ");
    result.append(this.state);
    result.append(')');
    return result.toString();
  }

    /**
     * @generated NOT
     */
    @Override
    public Operator createInstance(MID instanceMID) throws MMINTException {

        var newOperator = (RandomOperator) super.createInstance(instanceMID);
        //TODO MMINT[OPERATOR] This is an ugly way to run a callback
        if (this.getState() == null) {
            newOperator.setState(new Random());
        }
        else {
            newOperator.setState(this.getState());
            this.setState(null);
        }

        return newOperator;
    }

} //RandomOperatorImpl
