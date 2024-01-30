/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Undeveloped;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Supportable</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl#getUndeveloped <em>Undeveloped</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SupportableImpl extends DecoratableImpl implements Supportable {
  /**
   * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getSupportedBy()
   * @generated
   * @ordered
   */
  protected EList<SupportedBy> supportedBy;

  /**
   * The cached value of the '{@link #getUndeveloped() <em>Undeveloped</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUndeveloped()
   * @generated
   * @ordered
   */
  protected Undeveloped undeveloped;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SupportableImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.SUPPORTABLE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SupportedBy> getSupportedBy() {
    if (this.supportedBy == null) {
      this.supportedBy = new EObjectContainmentWithInverseEList<>(SupportedBy.class, this, GSNPackage.SUPPORTABLE__SUPPORTED_BY, GSNPackage.SUPPORTED_BY__SOURCE);
    }
    return this.supportedBy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Undeveloped getUndeveloped() {
    return this.undeveloped;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUndeveloped(Undeveloped newUndeveloped, NotificationChain msgs) {
    var oldUndeveloped = this.undeveloped;
    this.undeveloped = newUndeveloped;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.SUPPORTABLE__UNDEVELOPED, oldUndeveloped, newUndeveloped);
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
  public void setUndeveloped(Undeveloped newUndeveloped) {
    if (newUndeveloped != this.undeveloped) {
      NotificationChain msgs = null;
      if (this.undeveloped != null) {
        msgs = ((InternalEObject)this.undeveloped).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.SUPPORTABLE__UNDEVELOPED, null, msgs);
      }
      if (newUndeveloped != null) {
        msgs = ((InternalEObject)newUndeveloped).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.SUPPORTABLE__UNDEVELOPED, null, msgs);
      }
      msgs = basicSetUndeveloped(newUndeveloped, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SUPPORTABLE__UNDEVELOPED, newUndeveloped, newUndeveloped));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.SUPPORTABLE__SUPPORTED_BY:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupportedBy()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.SUPPORTABLE__SUPPORTED_BY:
        return ((InternalEList<?>)getSupportedBy()).basicRemove(otherEnd, msgs);
      case GSNPackage.SUPPORTABLE__UNDEVELOPED:
        return basicSetUndeveloped(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.SUPPORTABLE__SUPPORTED_BY:
        return getSupportedBy();
      case GSNPackage.SUPPORTABLE__UNDEVELOPED:
        return getUndeveloped();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case GSNPackage.SUPPORTABLE__SUPPORTED_BY:
        getSupportedBy().clear();
        getSupportedBy().addAll((Collection<? extends SupportedBy>)newValue);
        return;
      case GSNPackage.SUPPORTABLE__UNDEVELOPED:
        setUndeveloped((Undeveloped)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case GSNPackage.SUPPORTABLE__SUPPORTED_BY:
        getSupportedBy().clear();
        return;
      case GSNPackage.SUPPORTABLE__UNDEVELOPED:
        setUndeveloped((Undeveloped)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case GSNPackage.SUPPORTABLE__SUPPORTED_BY:
        return this.supportedBy != null && !this.supportedBy.isEmpty();
      case GSNPackage.SUPPORTABLE__UNDEVELOPED:
        return this.undeveloped != null;
    }
    return super.eIsSet(featureID);
  }

} // SupportableImpl
