/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contextualizable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextualizableImpl#getInContextOf <em>In Context Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ContextualizableImpl extends DecoratableImpl implements Contextualizable {
  /**
   * The cached value of the '{@link #getInContextOf() <em>In Context Of</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInContextOf()
   * @generated
   * @ordered
   */
  protected EList<InContextOf> inContextOf;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContextualizableImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.CONTEXTUALIZABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InContextOf> getInContextOf() {
    if (this.inContextOf == null) {
      this.inContextOf = new EObjectContainmentWithInverseEList<>(InContextOf.class, this, GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF);
    }
    return this.inContextOf;
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
      case GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getInContextOf()).basicAdd(otherEnd, msgs);
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
      case GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF:
        return ((InternalEList<?>)getInContextOf()).basicRemove(otherEnd, msgs);
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
      case GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF:
        return getInContextOf();
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
      case GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF:
        getInContextOf().clear();
        getInContextOf().addAll((Collection<? extends InContextOf>)newValue);
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
      case GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF:
        getInContextOf().clear();
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
      case GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF:
        return this.inContextOf != null && !this.inContextOf.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ContextualizableImpl
