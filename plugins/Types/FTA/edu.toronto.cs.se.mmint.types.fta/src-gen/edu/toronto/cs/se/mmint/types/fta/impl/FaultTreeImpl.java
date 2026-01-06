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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.types.fta.Event;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;
import edu.toronto.cs.se.mmint.types.fta.FaultTree;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fault Tree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.impl.FaultTreeImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.impl.FaultTreeImpl#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FaultTreeImpl extends MinimalEObjectImpl.Container implements FaultTree {
  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<Event> events;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FaultTreeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FTAPackage.Literals.FAULT_TREE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Event> getEvents() {
    if (this.events == null) {
      this.events = new EObjectContainmentEList<>(Event.class, this, FTAPackage.FAULT_TREE__EVENTS);
    }
    return this.events;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Event getRoot() {
    var root = basicGetRoot();
    return root != null && root.eIsProxy() ? (Event) eResolveProxy((InternalEObject) root) : root;
  }

  /**
   * @generated NOT
   */
  public Event basicGetRoot() {
    return getEvents().stream().filter(e -> e.getSuperGate() == null).findFirst().get();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FTAPackage.FAULT_TREE__EVENTS:
      return ((InternalEList<?>) getEvents()).basicRemove(otherEnd, msgs);
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
    case FTAPackage.FAULT_TREE__EVENTS:
      return getEvents();
    case FTAPackage.FAULT_TREE__ROOT:
      if (resolve) {
        return getRoot();
      }
      return basicGetRoot();
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
    case FTAPackage.FAULT_TREE__EVENTS:
      getEvents().clear();
      getEvents().addAll((Collection<? extends Event>) newValue);
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
    case FTAPackage.FAULT_TREE__EVENTS:
      getEvents().clear();
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
    case FTAPackage.FAULT_TREE__EVENTS:
      return this.events != null && !this.events.isEmpty();
    case FTAPackage.FAULT_TREE__ROOT:
      return basicGetRoot() != null;
    }
    return super.eIsSet(featureID);
  }

} //FaultTreeImpl
