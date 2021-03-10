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

import edu.toronto.cs.se.modelepedia.gsn.ContextualElement;
import edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>In Context Of</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl#getContext <em>Context</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl#getContextOf <em>Context Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InContextOfImpl extends MinimalEObjectImpl.Container implements InContextOf {
  /**
   * The cached value of the '{@link #getContext() <em>Context</em>}' reference. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected ContextualElement context;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected InContextOfImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.IN_CONTEXT_OF;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public ContextualElement getContext() {
    if (context != null && context.eIsProxy()) {
      InternalEObject oldContext = (InternalEObject) context;
      context = (ContextualElement) eResolveProxy(oldContext);
      if (context != oldContext) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.IN_CONTEXT_OF__CONTEXT, oldContext,
                                        context));
      }
    }
    return context;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ContextualElement basicGetContext() {
    return context;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetContext(ContextualElement newContext, NotificationChain msgs) {
    ContextualElement oldContext = context;
    context = newContext;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.IN_CONTEXT_OF__CONTEXT,
                                                             oldContext, newContext);
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
  public void setContext(ContextualElement newContext) {
    if (newContext != context) {
      NotificationChain msgs = null;
      if (context != null)
        msgs = ((InternalEObject) context).eInverseRemove(this, GSNPackage.CONTEXTUAL_ELEMENT__CONTEXT_OF,
                                                          ContextualElement.class, msgs);
      if (newContext != null)
        msgs = ((InternalEObject) newContext).eInverseAdd(this, GSNPackage.CONTEXTUAL_ELEMENT__CONTEXT_OF,
                                                          ContextualElement.class, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.IN_CONTEXT_OF__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public DecomposableCoreElement getContextOf() {
    if (eContainerFeatureID() != GSNPackage.IN_CONTEXT_OF__CONTEXT_OF)
      return null;
    return (DecomposableCoreElement) eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetContextOf(DecomposableCoreElement newContextOf, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newContextOf, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void setContextOf(DecomposableCoreElement newContextOf) {
    if (newContextOf != eInternalContainer() || (eContainerFeatureID() != GSNPackage.IN_CONTEXT_OF__CONTEXT_OF
      && newContextOf != null)) {
      if (EcoreUtil.isAncestor(this, newContextOf))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newContextOf != null)
        msgs = ((InternalEObject) newContextOf).eInverseAdd(this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF,
                                                            DecomposableCoreElement.class, msgs);
      msgs = basicSetContextOf(newContextOf, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF, newContextOf,
                                    newContextOf));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case GSNPackage.IN_CONTEXT_OF__CONTEXT:
      if (context != null)
        msgs = ((InternalEObject) context).eInverseRemove(this, GSNPackage.CONTEXTUAL_ELEMENT__CONTEXT_OF,
                                                          ContextualElement.class, msgs);
      return basicSetContext((ContextualElement) otherEnd, msgs);
    case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetContextOf((DecomposableCoreElement) otherEnd, msgs);
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
    case GSNPackage.IN_CONTEXT_OF__CONTEXT:
      return basicSetContext(null, msgs);
    case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
      return basicSetContextOf(null, msgs);
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
    case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
      return eInternalContainer().eInverseRemove(this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF,
                                                 DecomposableCoreElement.class, msgs);
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
    case GSNPackage.IN_CONTEXT_OF__CONTEXT:
      if (resolve)
        return getContext();
      return basicGetContext();
    case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
      return getContextOf();
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
    case GSNPackage.IN_CONTEXT_OF__CONTEXT:
      setContext((ContextualElement) newValue);
      return;
    case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
      setContextOf((DecomposableCoreElement) newValue);
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
    case GSNPackage.IN_CONTEXT_OF__CONTEXT:
      setContext((ContextualElement) null);
      return;
    case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
      setContextOf((DecomposableCoreElement) null);
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
    case GSNPackage.IN_CONTEXT_OF__CONTEXT:
      return context != null;
    case GSNPackage.IN_CONTEXT_OF__CONTEXT_OF:
      return getContextOf() != null;
    }
    return super.eIsSet(featureID);
  }

} // InContextOfImpl
