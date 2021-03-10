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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Supported By</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl#getSource <em>Source</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupportedByImpl extends MinimalEObjectImpl.Container implements SupportedBy {
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Supporter target;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected SupportedByImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.SUPPORTED_BY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Supportable getSource() {
    if (eContainerFeatureID() != GSNPackage.SUPPORTED_BY__SOURCE)
      return null;
    return (Supportable) eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetSource(Supportable newSource, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newSource, GSNPackage.SUPPORTED_BY__SOURCE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void setSource(Supportable newSource) {
    if (newSource != eInternalContainer() || (eContainerFeatureID() != GSNPackage.SUPPORTED_BY__SOURCE
      && newSource != null)) {
      if (EcoreUtil.isAncestor(this, newSource))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSource != null)
        msgs = ((InternalEObject) newSource).eInverseAdd(this, GSNPackage.SUPPORTABLE__SUPPORTED_BY, Supportable.class,
                                                         msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SUPPORTED_BY__SOURCE, newSource, newSource));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Supporter getTarget() {
    if (target != null && target.eIsProxy()) {
      InternalEObject oldTarget = (InternalEObject) target;
      target = (Supporter) eResolveProxy(oldTarget);
      if (target != oldTarget) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.SUPPORTED_BY__TARGET, oldTarget,
                                        target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Supporter basicGetTarget() {
    return target;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetTarget(Supporter newTarget, NotificationChain msgs) {
    Supporter oldTarget = target;
    target = newTarget;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.SUPPORTED_BY__TARGET,
                                                             oldTarget, newTarget);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void setTarget(Supporter newTarget) {
    if (newTarget != target) {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject) target).eInverseRemove(this, GSNPackage.SUPPORTER__SUPPORTS, Supporter.class, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject) newTarget).eInverseAdd(this, GSNPackage.SUPPORTER__SUPPORTS, Supporter.class, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.SUPPORTED_BY__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case GSNPackage.SUPPORTED_BY__SOURCE:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetSource((Supportable) otherEnd, msgs);
    case GSNPackage.SUPPORTED_BY__TARGET:
      if (target != null)
        msgs = ((InternalEObject) target).eInverseRemove(this, GSNPackage.SUPPORTER__SUPPORTS, Supporter.class, msgs);
      return basicSetTarget((Supporter) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case GSNPackage.SUPPORTED_BY__SOURCE:
      return basicSetSource(null, msgs);
    case GSNPackage.SUPPORTED_BY__TARGET:
      return basicSetTarget(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case GSNPackage.SUPPORTED_BY__SOURCE:
      return eInternalContainer().eInverseRemove(this, GSNPackage.SUPPORTABLE__SUPPORTED_BY, Supportable.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case GSNPackage.SUPPORTED_BY__SOURCE:
      return getSource();
    case GSNPackage.SUPPORTED_BY__TARGET:
      if (resolve)
        return getTarget();
      return basicGetTarget();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case GSNPackage.SUPPORTED_BY__SOURCE:
      setSource((Supportable) newValue);
      return;
    case GSNPackage.SUPPORTED_BY__TARGET:
      setTarget((Supporter) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case GSNPackage.SUPPORTED_BY__SOURCE:
      setSource((Supportable) null);
      return;
    case GSNPackage.SUPPORTED_BY__TARGET:
      setTarget((Supporter) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case GSNPackage.SUPPORTED_BY__SOURCE:
      return getSource() != null;
    case GSNPackage.SUPPORTED_BY__TARGET:
      return target != null;
    }
    return super.eIsSet(featureID);
  }

} // SupportedByImpl
