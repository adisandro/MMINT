/*******************************************************************************
 * Copyright (c) 2026, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.fta.impl;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.mmint.types.fta.Event;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;
import edu.toronto.cs.se.mmint.types.fta.Gate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.impl.EventImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.impl.EventImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.impl.EventImpl#getGate <em>Gate</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.impl.EventImpl#getSuperGate <em>Super Gate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventImpl extends MinimalEObjectImpl.Container implements Event {
  /**
   * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProbability()
   * @generated
   * @ordered
   */
  protected static final BigDecimal PROBABILITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProbability()
   * @generated
   * @ordered
   */
  protected BigDecimal probability = EventImpl.PROBABILITY_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = EventImpl.NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getGate() <em>Gate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGate()
   * @generated
   * @ordered
   */
  protected Gate gate;

  /**
   * The cached value of the '{@link #getSuperGate() <em>Super Gate</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperGate()
   * @generated
   * @ordered
   */
  protected Gate superGate;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FTAPackage.Literals.EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BigDecimal getProbability() {
    return this.probability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProbability(BigDecimal newProbability) {
    var oldProbability = this.probability;
    this.probability = newProbability;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, FTAPackage.EVENT__PROBABILITY, oldProbability,
                                    this.probability));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName) {
    var oldName = this.name;
    this.name = newName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, FTAPackage.EVENT__NAME, oldName, this.name));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Gate getGate() {
    return this.gate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGate(Gate newGate, NotificationChain msgs) {
    var oldGate = this.gate;
    this.gate = newGate;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, FTAPackage.EVENT__GATE, oldGate,
                                                             newGate);
      if (msgs == null) {
        msgs = notification;
      }
      else {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setGate(Gate newGate) {
    if (newGate != this.gate) {
      NotificationChain msgs = null;
      if (this.gate != null) {
        msgs = ((InternalEObject) this.gate).eInverseRemove(this, FTAPackage.GATE__EVENT, Gate.class, msgs);
      }
      if (newGate != null) {
        msgs = ((InternalEObject) newGate).eInverseAdd(this, FTAPackage.GATE__EVENT, Gate.class, msgs);
      }
      msgs = basicSetGate(newGate, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, FTAPackage.EVENT__GATE, newGate, newGate));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Gate getSuperGate() {
    if (this.superGate != null && this.superGate.eIsProxy()) {
      var oldSuperGate = (InternalEObject) this.superGate;
      this.superGate = (Gate) eResolveProxy(oldSuperGate);
      if (this.superGate != oldSuperGate) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FTAPackage.EVENT__SUPER_GATE, oldSuperGate,
                                        this.superGate));
        }
      }
    }
    return this.superGate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Gate basicGetSuperGate() {
    return this.superGate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuperGate(Gate newSuperGate, NotificationChain msgs) {
    var oldSuperGate = this.superGate;
    this.superGate = newSuperGate;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, FTAPackage.EVENT__SUPER_GATE,
                                                             oldSuperGate, newSuperGate);
      if (msgs == null) {
        msgs = notification;
      }
      else {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSuperGate(Gate newSuperGate) {
    if (newSuperGate != this.superGate) {
      NotificationChain msgs = null;
      if (this.superGate != null) {
        msgs = ((InternalEObject) this.superGate).eInverseRemove(this, FTAPackage.GATE__SUB_EVENTS, Gate.class, msgs);
      }
      if (newSuperGate != null) {
        msgs = ((InternalEObject) newSuperGate).eInverseAdd(this, FTAPackage.GATE__SUB_EVENTS, Gate.class, msgs);
      }
      msgs = basicSetSuperGate(newSuperGate, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, FTAPackage.EVENT__SUPER_GATE, newSuperGate, newSuperGate));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FTAPackage.EVENT__GATE:
      if (this.gate != null) {
        msgs = ((InternalEObject) this.gate).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - FTAPackage.EVENT__GATE, null,
                                                       msgs);
      }
      return basicSetGate((Gate) otherEnd, msgs);
    case FTAPackage.EVENT__SUPER_GATE:
      if (this.superGate != null) {
        msgs = ((InternalEObject) this.superGate).eInverseRemove(this, FTAPackage.GATE__SUB_EVENTS, Gate.class, msgs);
      }
      return basicSetSuperGate((Gate) otherEnd, msgs);
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
    case FTAPackage.EVENT__GATE:
      return basicSetGate(null, msgs);
    case FTAPackage.EVENT__SUPER_GATE:
      return basicSetSuperGate(null, msgs);
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
    case FTAPackage.EVENT__PROBABILITY:
      return getProbability();
    case FTAPackage.EVENT__NAME:
      return getName();
    case FTAPackage.EVENT__GATE:
      return getGate();
    case FTAPackage.EVENT__SUPER_GATE:
      if (resolve) {
        return getSuperGate();
      }
      return basicGetSuperGate();
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
    case FTAPackage.EVENT__PROBABILITY:
      setProbability((BigDecimal) newValue);
      return;
    case FTAPackage.EVENT__NAME:
      setName((String) newValue);
      return;
    case FTAPackage.EVENT__GATE:
      setGate((Gate) newValue);
      return;
    case FTAPackage.EVENT__SUPER_GATE:
      setSuperGate((Gate) newValue);
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
    case FTAPackage.EVENT__PROBABILITY:
      setProbability(EventImpl.PROBABILITY_EDEFAULT);
      return;
    case FTAPackage.EVENT__NAME:
      setName(EventImpl.NAME_EDEFAULT);
      return;
    case FTAPackage.EVENT__GATE:
      setGate((Gate) null);
      return;
    case FTAPackage.EVENT__SUPER_GATE:
      setSuperGate((Gate) null);
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
    case FTAPackage.EVENT__PROBABILITY:
      return EventImpl.PROBABILITY_EDEFAULT == null ? this.probability != null : !EventImpl.PROBABILITY_EDEFAULT.equals(this.probability);
    case FTAPackage.EVENT__NAME:
      return EventImpl.NAME_EDEFAULT == null ? this.name != null : !EventImpl.NAME_EDEFAULT.equals(this.name);
    case FTAPackage.EVENT__GATE:
      return this.gate != null;
    case FTAPackage.EVENT__SUPER_GATE:
      return this.superGate != null;
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
    if (eIsProxy()) {
      return super.toString();
    }

    var result = new StringBuilder(super.toString());
    result.append(" (probability: ");
    result.append(this.probability);
    result.append(", name: ");
    result.append(this.name);
    result.append(')');
    return result.toString();
  }

} //EventImpl
