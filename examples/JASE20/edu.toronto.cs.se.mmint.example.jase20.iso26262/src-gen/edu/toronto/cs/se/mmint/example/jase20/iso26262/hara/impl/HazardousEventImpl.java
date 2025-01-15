/*******************************************************************************
 * Copyright (c) 2012, 2025 Alessio Di Sandro.
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
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hazardous Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl#getHazard <em>Hazard</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl#getSituation <em>Situation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl#getExposure <em>Exposure</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl#getControllability <em>Controllability</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl#getASIL <em>ASIL</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HazardousEventImpl extends MinimalEObjectImpl.Container implements HazardousEvent {
  /**
   * The cached value of the '{@link #getHazard() <em>Hazard</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHazard()
   * @generated
   * @ordered
   */
  protected Hazard hazard;

  /**
   * The cached value of the '{@link #getSituation() <em>Situation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSituation()
   * @generated
   * @ordered
   */
  protected OperationalSituation situation;

  /**
   * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeverity()
   * @generated
   * @ordered
   */
  protected static final String SEVERITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeverity()
   * @generated
   * @ordered
   */
  protected String severity = SEVERITY_EDEFAULT;

  /**
   * The default value of the '{@link #getExposure() <em>Exposure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExposure()
   * @generated
   * @ordered
   */
  protected static final String EXPOSURE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExposure() <em>Exposure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExposure()
   * @generated
   * @ordered
   */
  protected String exposure = EXPOSURE_EDEFAULT;

  /**
   * The default value of the '{@link #getControllability() <em>Controllability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControllability()
   * @generated
   * @ordered
   */
  protected static final String CONTROLLABILITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getControllability() <em>Controllability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControllability()
   * @generated
   * @ordered
   */
  protected String controllability = CONTROLLABILITY_EDEFAULT;

  /**
   * The default value of the '{@link #getASIL() <em>ASIL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getASIL()
   * @generated
   * @ordered
   */
  protected static final String ASIL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getASIL() <em>ASIL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getASIL()
   * @generated
   * @ordered
   */
  protected String asil = ASIL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HazardousEventImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return HARAPackage.Literals.HAZARDOUS_EVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Hazard getHazard() {
    if (hazard != null && hazard.eIsProxy()) {
      InternalEObject oldHazard = (InternalEObject)hazard;
      hazard = (Hazard)eResolveProxy(oldHazard);
      if (hazard != oldHazard) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HARAPackage.HAZARDOUS_EVENT__HAZARD, oldHazard, hazard));
      }
    }
    return hazard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Hazard basicGetHazard() {
    return hazard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHazard(Hazard newHazard, NotificationChain msgs) {
    Hazard oldHazard = hazard;
    hazard = newHazard;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HARAPackage.HAZARDOUS_EVENT__HAZARD, oldHazard, newHazard);
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
  public void setHazard(Hazard newHazard) {
    if (newHazard != hazard) {
      NotificationChain msgs = null;
      if (hazard != null)
        msgs = ((InternalEObject)hazard).eInverseRemove(this, HARAPackage.HAZARD__EVENTS, Hazard.class, msgs);
      if (newHazard != null)
        msgs = ((InternalEObject)newHazard).eInverseAdd(this, HARAPackage.HAZARD__EVENTS, Hazard.class, msgs);
      msgs = basicSetHazard(newHazard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HARAPackage.HAZARDOUS_EVENT__HAZARD, newHazard, newHazard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OperationalSituation getSituation() {
    if (situation != null && situation.eIsProxy()) {
      InternalEObject oldSituation = (InternalEObject)situation;
      situation = (OperationalSituation)eResolveProxy(oldSituation);
      if (situation != oldSituation) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HARAPackage.HAZARDOUS_EVENT__SITUATION, oldSituation, situation));
      }
    }
    return situation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationalSituation basicGetSituation() {
    return situation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSituation(OperationalSituation newSituation, NotificationChain msgs) {
    OperationalSituation oldSituation = situation;
    situation = newSituation;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HARAPackage.HAZARDOUS_EVENT__SITUATION, oldSituation, newSituation);
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
  public void setSituation(OperationalSituation newSituation) {
    if (newSituation != situation) {
      NotificationChain msgs = null;
      if (situation != null)
        msgs = ((InternalEObject)situation).eInverseRemove(this, HARAPackage.OPERATIONAL_SITUATION__EVENTS, OperationalSituation.class, msgs);
      if (newSituation != null)
        msgs = ((InternalEObject)newSituation).eInverseAdd(this, HARAPackage.OPERATIONAL_SITUATION__EVENTS, OperationalSituation.class, msgs);
      msgs = basicSetSituation(newSituation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HARAPackage.HAZARDOUS_EVENT__SITUATION, newSituation, newSituation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSeverity() {
    return severity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSeverity(String newSeverity) {
    String oldSeverity = severity;
    severity = newSeverity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HARAPackage.HAZARDOUS_EVENT__SEVERITY, oldSeverity, severity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getExposure() {
    return exposure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExposure(String newExposure) {
    String oldExposure = exposure;
    exposure = newExposure;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HARAPackage.HAZARDOUS_EVENT__EXPOSURE, oldExposure, exposure));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getControllability() {
    return controllability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setControllability(String newControllability) {
    String oldControllability = controllability;
    controllability = newControllability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HARAPackage.HAZARDOUS_EVENT__CONTROLLABILITY, oldControllability, controllability));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getASIL() {
    return asil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setASIL(String newASIL) {
    String oldASIL = asil;
    asil = newASIL;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HARAPackage.HAZARDOUS_EVENT__ASIL, oldASIL, asil));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case HARAPackage.HAZARDOUS_EVENT__HAZARD:
        if (hazard != null)
          msgs = ((InternalEObject)hazard).eInverseRemove(this, HARAPackage.HAZARD__EVENTS, Hazard.class, msgs);
        return basicSetHazard((Hazard)otherEnd, msgs);
      case HARAPackage.HAZARDOUS_EVENT__SITUATION:
        if (situation != null)
          msgs = ((InternalEObject)situation).eInverseRemove(this, HARAPackage.OPERATIONAL_SITUATION__EVENTS, OperationalSituation.class, msgs);
        return basicSetSituation((OperationalSituation)otherEnd, msgs);
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
      case HARAPackage.HAZARDOUS_EVENT__HAZARD:
        return basicSetHazard(null, msgs);
      case HARAPackage.HAZARDOUS_EVENT__SITUATION:
        return basicSetSituation(null, msgs);
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
      case HARAPackage.HAZARDOUS_EVENT__HAZARD:
        if (resolve) return getHazard();
        return basicGetHazard();
      case HARAPackage.HAZARDOUS_EVENT__SITUATION:
        if (resolve) return getSituation();
        return basicGetSituation();
      case HARAPackage.HAZARDOUS_EVENT__SEVERITY:
        return getSeverity();
      case HARAPackage.HAZARDOUS_EVENT__EXPOSURE:
        return getExposure();
      case HARAPackage.HAZARDOUS_EVENT__CONTROLLABILITY:
        return getControllability();
      case HARAPackage.HAZARDOUS_EVENT__ASIL:
        return getASIL();
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
      case HARAPackage.HAZARDOUS_EVENT__HAZARD:
        setHazard((Hazard)newValue);
        return;
      case HARAPackage.HAZARDOUS_EVENT__SITUATION:
        setSituation((OperationalSituation)newValue);
        return;
      case HARAPackage.HAZARDOUS_EVENT__SEVERITY:
        setSeverity((String)newValue);
        return;
      case HARAPackage.HAZARDOUS_EVENT__EXPOSURE:
        setExposure((String)newValue);
        return;
      case HARAPackage.HAZARDOUS_EVENT__CONTROLLABILITY:
        setControllability((String)newValue);
        return;
      case HARAPackage.HAZARDOUS_EVENT__ASIL:
        setASIL((String)newValue);
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
      case HARAPackage.HAZARDOUS_EVENT__HAZARD:
        setHazard((Hazard)null);
        return;
      case HARAPackage.HAZARDOUS_EVENT__SITUATION:
        setSituation((OperationalSituation)null);
        return;
      case HARAPackage.HAZARDOUS_EVENT__SEVERITY:
        setSeverity(SEVERITY_EDEFAULT);
        return;
      case HARAPackage.HAZARDOUS_EVENT__EXPOSURE:
        setExposure(EXPOSURE_EDEFAULT);
        return;
      case HARAPackage.HAZARDOUS_EVENT__CONTROLLABILITY:
        setControllability(CONTROLLABILITY_EDEFAULT);
        return;
      case HARAPackage.HAZARDOUS_EVENT__ASIL:
        setASIL(ASIL_EDEFAULT);
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
      case HARAPackage.HAZARDOUS_EVENT__HAZARD:
        return hazard != null;
      case HARAPackage.HAZARDOUS_EVENT__SITUATION:
        return situation != null;
      case HARAPackage.HAZARDOUS_EVENT__SEVERITY:
        return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals(severity);
      case HARAPackage.HAZARDOUS_EVENT__EXPOSURE:
        return EXPOSURE_EDEFAULT == null ? exposure != null : !EXPOSURE_EDEFAULT.equals(exposure);
      case HARAPackage.HAZARDOUS_EVENT__CONTROLLABILITY:
        return CONTROLLABILITY_EDEFAULT == null ? controllability != null : !CONTROLLABILITY_EDEFAULT.equals(controllability);
      case HARAPackage.HAZARDOUS_EVENT__ASIL:
        return ASIL_EDEFAULT == null ? asil != null : !ASIL_EDEFAULT.equals(asil);
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (severity: ");
    result.append(severity);
    result.append(", exposure: ");
    result.append(exposure);
    result.append(", controllability: ");
    result.append(controllability);
    result.append(", ASIL: ");
    result.append(asil);
    result.append(')');
    return result.toString();
  }

} //HazardousEventImpl
