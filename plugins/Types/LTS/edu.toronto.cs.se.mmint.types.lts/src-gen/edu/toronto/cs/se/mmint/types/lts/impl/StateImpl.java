/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.types.lts.LTSPackage;
import edu.toronto.cs.se.mmint.types.lts.State;
import edu.toronto.cs.se.mmint.types.lts.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.impl.StateImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.impl.StateImpl#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateImpl extends LabeledElementImpl implements State {
  /**
   * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncoming()
   * @generated
   * @ordered
   */
  protected EList<Transition> incoming;

  /**
   * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoing()
   * @generated
   * @ordered
   */
  protected EList<Transition> outgoing;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LTSPackage.Literals.STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Transition> getIncoming() {
    if (this.incoming == null) {
      this.incoming = new EObjectWithInverseResolvingEList<>(Transition.class, this, LTSPackage.STATE__INCOMING, LTSPackage.TRANSITION__TO);
    }
    return this.incoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Transition> getOutgoing() {
    if (this.outgoing == null) {
      this.outgoing = new EObjectWithInverseResolvingEList<>(Transition.class, this, LTSPackage.STATE__OUTGOING, LTSPackage.TRANSITION__FROM);
    }
    return this.outgoing;
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
      case LTSPackage.STATE__INCOMING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
      case LTSPackage.STATE__OUTGOING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
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
      case LTSPackage.STATE__INCOMING:
        return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
      case LTSPackage.STATE__OUTGOING:
        return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
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
      case LTSPackage.STATE__INCOMING:
        return getIncoming();
      case LTSPackage.STATE__OUTGOING:
        return getOutgoing();
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
      case LTSPackage.STATE__INCOMING:
        getIncoming().clear();
        getIncoming().addAll((Collection<? extends Transition>)newValue);
        return;
      case LTSPackage.STATE__OUTGOING:
        getOutgoing().clear();
        getOutgoing().addAll((Collection<? extends Transition>)newValue);
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
      case LTSPackage.STATE__INCOMING:
        getIncoming().clear();
        return;
      case LTSPackage.STATE__OUTGOING:
        getOutgoing().clear();
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
      case LTSPackage.STATE__INCOMING:
        return this.incoming != null && !this.incoming.isEmpty();
      case LTSPackage.STATE__OUTGOING:
        return this.outgoing != null && !this.outgoing.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StateImpl
