/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ReferenceImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends PLElementImpl implements Reference {
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected edu.toronto.cs.se.mmint.productline.Class source;

  /**
   * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargets()
   * @generated
   * @ordered
   */
  protected EList<edu.toronto.cs.se.mmint.productline.Class> targets;

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
  public edu.toronto.cs.se.mmint.productline.Class getSource() {
    if (this.source != null && this.source.eIsProxy()) {
      var oldSource = (InternalEObject) this.source;
      this.source = (edu.toronto.cs.se.mmint.productline.Class) eResolveProxy(oldSource);
      if (this.source != oldSource) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductLinePackage.REFERENCE__SOURCE, oldSource,
                                        this.source));
      }
    }
    return this.source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public edu.toronto.cs.se.mmint.productline.Class basicGetSource() {
    return this.source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSource(edu.toronto.cs.se.mmint.productline.Class newSource, NotificationChain msgs) {
    var oldSource = this.source;
    this.source = newSource;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET,
                                                             ProductLinePackage.REFERENCE__SOURCE, oldSource,
                                                             newSource);
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
  public void setSource(edu.toronto.cs.se.mmint.productline.Class newSource) {
    if (newSource != this.source) {
      NotificationChain msgs = null;
      if (this.source != null)
        msgs = ((InternalEObject) this.source).eInverseRemove(this, ProductLinePackage.CLASS__REFERENCES_AS_SOURCE,
                                                         edu.toronto.cs.se.mmint.productline.Class.class, msgs);
      if (newSource != null)
        msgs = ((InternalEObject) newSource).eInverseAdd(this, ProductLinePackage.CLASS__REFERENCES_AS_SOURCE,
                                                         edu.toronto.cs.se.mmint.productline.Class.class, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.REFERENCE__SOURCE, newSource,
                                    newSource));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<edu.toronto.cs.se.mmint.productline.Class> getTargets() {
    if (this.targets == null) {
      this.targets = new EObjectWithInverseResolvingEList.ManyInverse<>(edu.toronto.cs.se.mmint.productline.Class.class,
                                                                                                            this,
                                                                                                            ProductLinePackage.REFERENCE__TARGETS,
                                                                                                            ProductLinePackage.CLASS__REFERENCES_AS_TARGETS);
    }
    return this.targets;
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
    case ProductLinePackage.REFERENCE__SOURCE:
      if (this.source != null)
        msgs = ((InternalEObject) this.source).eInverseRemove(this, ProductLinePackage.CLASS__REFERENCES_AS_SOURCE,
                                                         edu.toronto.cs.se.mmint.productline.Class.class, msgs);
      return basicSetSource((edu.toronto.cs.se.mmint.productline.Class) otherEnd, msgs);
    case ProductLinePackage.REFERENCE__TARGETS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getTargets()).basicAdd(otherEnd, msgs);
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
    case ProductLinePackage.REFERENCE__SOURCE:
      return basicSetSource(null, msgs);
    case ProductLinePackage.REFERENCE__TARGETS:
      return ((InternalEList<?>) getTargets()).basicRemove(otherEnd, msgs);
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
    case ProductLinePackage.REFERENCE__SOURCE:
      if (resolve)
        return getSource();
      return basicGetSource();
    case ProductLinePackage.REFERENCE__TARGETS:
      return getTargets();
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
    case ProductLinePackage.REFERENCE__SOURCE:
      setSource((edu.toronto.cs.se.mmint.productline.Class) newValue);
      return;
    case ProductLinePackage.REFERENCE__TARGETS:
      getTargets().clear();
      getTargets().addAll((Collection<? extends edu.toronto.cs.se.mmint.productline.Class>) newValue);
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
    case ProductLinePackage.REFERENCE__SOURCE:
      setSource((edu.toronto.cs.se.mmint.productline.Class) null);
      return;
    case ProductLinePackage.REFERENCE__TARGETS:
      getTargets().clear();
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
    case ProductLinePackage.REFERENCE__SOURCE:
      return this.source != null;
    case ProductLinePackage.REFERENCE__TARGETS:
      return this.targets != null && !this.targets.isEmpty();
    case ProductLinePackage.REFERENCE__TYPE:
      return this.type != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceImpl
