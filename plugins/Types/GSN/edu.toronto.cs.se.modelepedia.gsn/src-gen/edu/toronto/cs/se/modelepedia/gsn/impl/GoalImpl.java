/**
 * Copyright (c) 2012-2021 Alessio Di Sandro, Marsha Chechik, Nick Fung.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.modelepedia.gsn.ASIL;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.StatefulElement;
import edu.toronto.cs.se.modelepedia.gsn.ValidityValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl#getStateValidity <em>State Validity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl#getAsil <em>Asil</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GoalImpl extends DecomposableCoreElementImpl implements Goal {
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
  protected ValidityValue stateValidity = GoalImpl.STATE_VALIDITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getAsil() <em>Asil</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsil()
   * @generated
   * @ordered
   */
  protected ASIL asil;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GoalImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.GOAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValidityValue getStateValidity() {
    return this.stateValidity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStateValidity(ValidityValue newStateValidity) {
    var oldStateValidity = this.stateValidity;
    this.stateValidity = newStateValidity == null ? GoalImpl.STATE_VALIDITY_EDEFAULT : newStateValidity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.GOAL__STATE_VALIDITY, oldStateValidity, this.stateValidity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ASIL getAsil() {
    return this.asil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAsil(ASIL newAsil, NotificationChain msgs) {
    var oldAsil = this.asil;
    this.asil = newAsil;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.GOAL__ASIL, oldAsil, newAsil);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAsil(ASIL newAsil) {
    if (newAsil != this.asil) {
      NotificationChain msgs = null;
      if (this.asil != null)
        msgs = ((InternalEObject)this.asil).eInverseRemove(this, GSNPackage.ASIL__TARGET, ASIL.class, msgs);
      if (newAsil != null)
        msgs = ((InternalEObject)newAsil).eInverseAdd(this, GSNPackage.ASIL__TARGET, ASIL.class, msgs);
      msgs = basicSetAsil(newAsil, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.GOAL__ASIL, newAsil, newAsil));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.GOAL__ASIL:
        if (this.asil != null)
          msgs = ((InternalEObject)this.asil).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.GOAL__ASIL, null, msgs);
        return basicSetAsil((ASIL)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.GOAL__ASIL:
        return basicSetAsil(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.GOAL__STATE_VALIDITY:
        return getStateValidity();
      case GSNPackage.GOAL__ASIL:
        return getAsil();
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
      case GSNPackage.GOAL__STATE_VALIDITY:
        setStateValidity((ValidityValue)newValue);
        return;
      case GSNPackage.GOAL__ASIL:
        setAsil((ASIL)newValue);
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
      case GSNPackage.GOAL__STATE_VALIDITY:
        setStateValidity(GoalImpl.STATE_VALIDITY_EDEFAULT);
        return;
      case GSNPackage.GOAL__ASIL:
        setAsil((ASIL)null);
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
      case GSNPackage.GOAL__STATE_VALIDITY:
        return this.stateValidity != GoalImpl.STATE_VALIDITY_EDEFAULT;
      case GSNPackage.GOAL__ASIL:
        return this.asil != null;
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
    if (baseClass == StatefulElement.class) {
      switch (derivedFeatureID) {
        case GSNPackage.GOAL__STATE_VALIDITY: return GSNPackage.STATEFUL_ELEMENT__STATE_VALIDITY;
        default: return -1;
      }
    }
    if (baseClass == ASILfulElement.class) {
      switch (derivedFeatureID) {
        case GSNPackage.GOAL__ASIL: return GSNPackage.ASI_LFUL_ELEMENT__ASIL;
        default: return -1;
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
    if (baseClass == StatefulElement.class) {
      switch (baseFeatureID) {
        case GSNPackage.STATEFUL_ELEMENT__STATE_VALIDITY: return GSNPackage.GOAL__STATE_VALIDITY;
        default: return -1;
      }
    }
    if (baseClass == ASILfulElement.class) {
      switch (baseFeatureID) {
        case GSNPackage.ASI_LFUL_ELEMENT__ASIL: return GSNPackage.GOAL__ASIL;
        default: return -1;
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
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (stateValidity: ");
    result.append(this.stateValidity);
    result.append(')');
    return result.toString();
  }

} //GoalImpl
