/*******************************************************************************
 * Copyright (c) 2012, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARARootImpl#getHazards <em>Hazards</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARARootImpl#getSituations <em>Situations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARARootImpl#getEvents <em>Events</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HARARootImpl extends MinimalEObjectImpl.Container implements HARARoot {
  /**
   * The cached value of the '{@link #getHazards() <em>Hazards</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHazards()
   * @generated
   * @ordered
   */
  protected EList<Hazard> hazards;

  /**
   * The cached value of the '{@link #getSituations() <em>Situations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSituations()
   * @generated
   * @ordered
   */
  protected EList<OperationalSituation> situations;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<HazardousEvent> events;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HARARootImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return HARAPackage.Literals.HARA_ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Hazard> getHazards() {
    if (hazards == null) {
      hazards = new EObjectContainmentEList<Hazard>(Hazard.class, this, HARAPackage.HARA_ROOT__HAZARDS);
    }
    return hazards;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<OperationalSituation> getSituations() {
    if (situations == null) {
      situations = new EObjectContainmentEList<OperationalSituation>(OperationalSituation.class, this, HARAPackage.HARA_ROOT__SITUATIONS);
    }
    return situations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HazardousEvent> getEvents() {
    if (events == null) {
      events = new EObjectContainmentEList<HazardousEvent>(HazardousEvent.class, this, HARAPackage.HARA_ROOT__EVENTS);
    }
    return events;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case HARAPackage.HARA_ROOT__HAZARDS:
        return ((InternalEList<?>)getHazards()).basicRemove(otherEnd, msgs);
      case HARAPackage.HARA_ROOT__SITUATIONS:
        return ((InternalEList<?>)getSituations()).basicRemove(otherEnd, msgs);
      case HARAPackage.HARA_ROOT__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
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
      case HARAPackage.HARA_ROOT__HAZARDS:
        return getHazards();
      case HARAPackage.HARA_ROOT__SITUATIONS:
        return getSituations();
      case HARAPackage.HARA_ROOT__EVENTS:
        return getEvents();
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
      case HARAPackage.HARA_ROOT__HAZARDS:
        getHazards().clear();
        getHazards().addAll((Collection<? extends Hazard>)newValue);
        return;
      case HARAPackage.HARA_ROOT__SITUATIONS:
        getSituations().clear();
        getSituations().addAll((Collection<? extends OperationalSituation>)newValue);
        return;
      case HARAPackage.HARA_ROOT__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends HazardousEvent>)newValue);
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
      case HARAPackage.HARA_ROOT__HAZARDS:
        getHazards().clear();
        return;
      case HARAPackage.HARA_ROOT__SITUATIONS:
        getSituations().clear();
        return;
      case HARAPackage.HARA_ROOT__EVENTS:
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
      case HARAPackage.HARA_ROOT__HAZARDS:
        return hazards != null && !hazards.isEmpty();
      case HARAPackage.HARA_ROOT__SITUATIONS:
        return situations != null && !situations.isEmpty();
      case HARAPackage.HARA_ROOT__EVENTS:
        return events != null && !events.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //HARARootImpl
