/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends PLElementImpl implements Reference {
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected edu.toronto.cs.se.mmint.productline.Class target;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EReference type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ProductLinePackage.Literals.REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public edu.toronto.cs.se.mmint.productline.Class getTarget() {
    if (this.target != null && this.target.eIsProxy()) {
      var oldTarget = (InternalEObject) this.target;
      this.target = (edu.toronto.cs.se.mmint.productline.Class) eResolveProxy(oldTarget);
      if (this.target != oldTarget) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductLinePackage.REFERENCE__TARGET, oldTarget,
                                        this.target));
      }
    }
    return this.target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public edu.toronto.cs.se.mmint.productline.Class basicGetTarget() {
    return this.target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(edu.toronto.cs.se.mmint.productline.Class newTarget, NotificationChain msgs) {
    var oldTarget = this.target;
    this.target = newTarget;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                                                             ProductLinePackage.REFERENCE__TARGET, oldTarget,
                                                             newTarget);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTarget(edu.toronto.cs.se.mmint.productline.Class newTarget) {
    if (newTarget != this.target) {
      NotificationChain msgs = null;
      if (this.target != null)
        msgs = ((InternalEObject) this.target).eInverseRemove(this, ProductLinePackage.CLASS__REFERENCES_AS_TARGET,
                                                         edu.toronto.cs.se.mmint.productline.Class.class, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject) newTarget).eInverseAdd(this, ProductLinePackage.CLASS__REFERENCES_AS_TARGET,
                                                         edu.toronto.cs.se.mmint.productline.Class.class, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.REFERENCE__TARGET, newTarget,
                                    newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getType() {
    if (this.type != null && this.type.eIsProxy()) {
      var oldType = (InternalEObject) this.type;
      this.type = (EReference) eResolveProxy(oldType);
      if (this.type != oldType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductLinePackage.REFERENCE__TYPE, oldType, this.type));
      }
    }
    return this.type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference basicGetType() {
    return this.type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(EReference newType) {
    var oldType = this.type;
    this.type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.REFERENCE__TYPE, oldType, this.type));
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
    case ProductLinePackage.REFERENCE__TARGET:
      if (this.target != null)
        msgs = ((InternalEObject) this.target).eInverseRemove(this, ProductLinePackage.CLASS__REFERENCES_AS_TARGET,
                                                         edu.toronto.cs.se.mmint.productline.Class.class, msgs);
      return basicSetTarget((edu.toronto.cs.se.mmint.productline.Class) otherEnd, msgs);
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
    case ProductLinePackage.REFERENCE__TARGET:
      return basicSetTarget(null, msgs);
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
    case ProductLinePackage.REFERENCE__TARGET:
      if (resolve)
        return getTarget();
      return basicGetTarget();
    case ProductLinePackage.REFERENCE__TYPE:
      if (resolve)
        return getType();
      return basicGetType();
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
    case ProductLinePackage.REFERENCE__TARGET:
      setTarget((edu.toronto.cs.se.mmint.productline.Class) newValue);
      return;
    case ProductLinePackage.REFERENCE__TYPE:
      setType((EReference) newValue);
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
    case ProductLinePackage.REFERENCE__TARGET:
      setTarget((edu.toronto.cs.se.mmint.productline.Class) null);
      return;
    case ProductLinePackage.REFERENCE__TYPE:
      setType((EReference) null);
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
    case ProductLinePackage.REFERENCE__TARGET:
      return this.target != null;
    case ProductLinePackage.REFERENCE__TYPE:
      return this.type != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * @generated NOT
   */
  @Override
  public ProductLine getProductLine() {
    return (ProductLine) eContainer().eContainer();
  }
} //ReferenceImpl
