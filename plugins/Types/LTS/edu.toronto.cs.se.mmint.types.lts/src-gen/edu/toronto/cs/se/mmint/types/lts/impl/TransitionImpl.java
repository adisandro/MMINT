/*******************************************************************************
 * Copyright (c) 2020, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.lts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.types.lts.LTSPackage;
import edu.toronto.cs.se.mmint.types.lts.State;
import edu.toronto.cs.se.mmint.types.lts.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.impl.TransitionImpl#getFrom <em>From</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.impl.TransitionImpl#getTo <em>To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends LabeledElementImpl implements Transition {
  /**
   * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrom()
   * @generated
   * @ordered
   */
  protected State from;

  /**
   * The cached value of the '{@link #getTo() <em>To</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected State to;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LTSPackage.Literals.TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public State getFrom() {
    if (this.from != null && this.from.eIsProxy()) {
      var oldFrom = (InternalEObject)this.from;
      this.from = (State)eResolveProxy(oldFrom);
      if (this.from != oldFrom) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LTSPackage.TRANSITION__FROM, oldFrom, this.from));
      }
    }
    return this.from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetFrom() {
    return this.from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFrom(State newFrom, NotificationChain msgs) {
    var oldFrom = this.from;
    this.from = newFrom;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, LTSPackage.TRANSITION__FROM, oldFrom, newFrom);
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
  public void setFrom(State newFrom) {
    if (newFrom != this.from) {
      NotificationChain msgs = null;
      if (this.from != null)
        msgs = ((InternalEObject)this.from).eInverseRemove(this, LTSPackage.STATE__OUTGOING, State.class, msgs);
      if (newFrom != null)
        msgs = ((InternalEObject)newFrom).eInverseAdd(this, LTSPackage.STATE__OUTGOING, State.class, msgs);
      msgs = basicSetFrom(newFrom, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LTSPackage.TRANSITION__FROM, newFrom, newFrom));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public State getTo() {
    if (this.to != null && this.to.eIsProxy()) {
      var oldTo = (InternalEObject)this.to;
      this.to = (State)eResolveProxy(oldTo);
      if (this.to != oldTo) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LTSPackage.TRANSITION__TO, oldTo, this.to));
      }
    }
    return this.to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetTo() {
    return this.to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTo(State newTo, NotificationChain msgs) {
    var oldTo = this.to;
    this.to = newTo;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, LTSPackage.TRANSITION__TO, oldTo, newTo);
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
  public void setTo(State newTo) {
    if (newTo != this.to) {
      NotificationChain msgs = null;
      if (this.to != null)
        msgs = ((InternalEObject)this.to).eInverseRemove(this, LTSPackage.STATE__INCOMING, State.class, msgs);
      if (newTo != null)
        msgs = ((InternalEObject)newTo).eInverseAdd(this, LTSPackage.STATE__INCOMING, State.class, msgs);
      msgs = basicSetTo(newTo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LTSPackage.TRANSITION__TO, newTo, newTo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case LTSPackage.TRANSITION__FROM:
        if (this.from != null)
          msgs = ((InternalEObject)this.from).eInverseRemove(this, LTSPackage.STATE__OUTGOING, State.class, msgs);
        return basicSetFrom((State)otherEnd, msgs);
      case LTSPackage.TRANSITION__TO:
        if (this.to != null)
          msgs = ((InternalEObject)this.to).eInverseRemove(this, LTSPackage.STATE__INCOMING, State.class, msgs);
        return basicSetTo((State)otherEnd, msgs);
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
      case LTSPackage.TRANSITION__FROM:
        return basicSetFrom(null, msgs);
      case LTSPackage.TRANSITION__TO:
        return basicSetTo(null, msgs);
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
      case LTSPackage.TRANSITION__FROM:
        if (resolve) return getFrom();
        return basicGetFrom();
      case LTSPackage.TRANSITION__TO:
        if (resolve) return getTo();
        return basicGetTo();
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
      case LTSPackage.TRANSITION__FROM:
        setFrom((State)newValue);
        return;
      case LTSPackage.TRANSITION__TO:
        setTo((State)newValue);
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
      case LTSPackage.TRANSITION__FROM:
        setFrom((State)null);
        return;
      case LTSPackage.TRANSITION__TO:
        setTo((State)null);
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
      case LTSPackage.TRANSITION__FROM:
        return this.from != null;
      case LTSPackage.TRANSITION__TO:
        return this.to != null;
    }
    return super.eIsSet(featureID);
  }

} //TransitionImpl
