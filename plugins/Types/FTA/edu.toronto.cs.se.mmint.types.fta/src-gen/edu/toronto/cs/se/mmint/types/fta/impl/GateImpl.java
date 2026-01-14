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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.types.fta.Event;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;
import edu.toronto.cs.se.mmint.types.fta.Gate;
import edu.toronto.cs.se.mmint.types.fta.GateLogic;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.impl.GateImpl#getSubEvents <em>Sub Events</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.impl.GateImpl#getLogic <em>Logic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GateImpl extends MinimalEObjectImpl.Container implements Gate {
  /**
   * The cached value of the '{@link #getSubEvents() <em>Sub Events</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubEvents()
   * @generated
   * @ordered
   */
  protected EList<Event> subEvents;

  /**
   * The default value of the '{@link #getLogic() <em>Logic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogic()
   * @generated
   * @ordered
   */
  protected static final GateLogic LOGIC_EDEFAULT = GateLogic.AND;

  /**
   * The cached value of the '{@link #getLogic() <em>Logic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogic()
   * @generated
   * @ordered
   */
  protected GateLogic logic = GateImpl.LOGIC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FTAPackage.Literals.GATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Event> getSubEvents() {
    if (this.subEvents == null) {
      this.subEvents = new EObjectWithInverseResolvingEList<>(Event.class, this, FTAPackage.GATE__SUB_EVENTS,
                                                              FTAPackage.EVENT__SUPER_GATE);
    }
    return this.subEvents;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GateLogic getLogic() {
    return this.logic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLogic(GateLogic newLogic) {
    var oldLogic = this.logic;
    this.logic = newLogic == null ? GateImpl.LOGIC_EDEFAULT : newLogic;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, FTAPackage.GATE__LOGIC, oldLogic, this.logic));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FTAPackage.GATE__SUB_EVENTS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubEvents()).basicAdd(otherEnd, msgs);
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
    case FTAPackage.GATE__SUB_EVENTS:
      return ((InternalEList<?>) getSubEvents()).basicRemove(otherEnd, msgs);
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
    case FTAPackage.GATE__SUB_EVENTS:
      return getSubEvents();
    case FTAPackage.GATE__LOGIC:
      return getLogic();
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
    case FTAPackage.GATE__SUB_EVENTS:
      getSubEvents().clear();
      getSubEvents().addAll((Collection<? extends Event>) newValue);
      return;
    case FTAPackage.GATE__LOGIC:
      setLogic((GateLogic) newValue);
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
    case FTAPackage.GATE__SUB_EVENTS:
      getSubEvents().clear();
      return;
    case FTAPackage.GATE__LOGIC:
      setLogic(GateImpl.LOGIC_EDEFAULT);
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
    case FTAPackage.GATE__SUB_EVENTS:
      return this.subEvents != null && !this.subEvents.isEmpty();
    case FTAPackage.GATE__LOGIC:
      return this.logic != GateImpl.LOGIC_EDEFAULT;
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
    result.append(" (logic: ");
    result.append(this.logic);
    result.append(')');
    return result.toString();
  }

} //GateImpl
