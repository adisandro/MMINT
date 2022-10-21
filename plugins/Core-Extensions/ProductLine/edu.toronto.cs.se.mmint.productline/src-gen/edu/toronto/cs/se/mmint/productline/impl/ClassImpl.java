/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.Reference;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDHeavyTypeFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getReferencesAsSource <em>References As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getReferencesAsTarget <em>References As Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends PLElementImpl implements edu.toronto.cs.se.mmint.productline.Class {
  /**
   * The cached value of the '{@link #getReferencesAsSource() <em>References As Source</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencesAsSource()
   * @generated
   * @ordered
   */
  protected EList<Reference> referencesAsSource;

  /**
   * The cached value of the '{@link #getReferencesAsTarget() <em>References As Target</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencesAsTarget()
   * @generated
   * @ordered
   */
  protected EList<Reference> referencesAsTarget;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EClass type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ProductLinePackage.Literals.CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Reference> getReferencesAsSource() {
    if (this.referencesAsSource == null) {
      this.referencesAsSource = new EObjectWithInverseResolvingEList<>(Reference.class, this,
                                                                           ProductLinePackage.CLASS__REFERENCES_AS_SOURCE,
                                                                           ProductLinePackage.REFERENCE__SOURCE);
    }
    return this.referencesAsSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Reference> getReferencesAsTarget() {
    if (this.referencesAsTarget == null) {
      this.referencesAsTarget = new EObjectWithInverseResolvingEList<>(Reference.class, this,
                                                                           ProductLinePackage.CLASS__REFERENCES_AS_TARGET,
                                                                           ProductLinePackage.REFERENCE__TARGET);
    }
    return this.referencesAsTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Attribute> getAttributes() {
    if (this.attributes == null) {
      this.attributes = new EObjectContainmentEList<>(Attribute.class, this, ProductLinePackage.CLASS__ATTRIBUTES);
    }
    return this.attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getType() {
    if (this.type != null && this.type.eIsProxy()) {
      var oldType = (InternalEObject) this.type;
      this.type = (EClass) eResolveProxy(oldType);
      if (this.type != oldType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductLinePackage.CLASS__TYPE, oldType, this.type));
      }
    }
    return this.type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass basicGetType() {
    return this.type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(EClass newType) {
    var oldType = this.type;
    this.type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.CLASS__TYPE, oldType, this.type));
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getReferencesAsSource()).basicAdd(otherEnd, msgs);
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGET:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getReferencesAsTarget()).basicAdd(otherEnd, msgs);
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      return ((InternalEList<?>) getReferencesAsSource()).basicRemove(otherEnd, msgs);
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGET:
      return ((InternalEList<?>) getReferencesAsTarget()).basicRemove(otherEnd, msgs);
    case ProductLinePackage.CLASS__ATTRIBUTES:
      return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      return getReferencesAsSource();
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGET:
      return getReferencesAsTarget();
    case ProductLinePackage.CLASS__ATTRIBUTES:
      return getAttributes();
    case ProductLinePackage.CLASS__TYPE:
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      getReferencesAsSource().clear();
      getReferencesAsSource().addAll((Collection<? extends Reference>) newValue);
      return;
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGET:
      getReferencesAsTarget().clear();
      getReferencesAsTarget().addAll((Collection<? extends Reference>) newValue);
      return;
    case ProductLinePackage.CLASS__ATTRIBUTES:
      getAttributes().clear();
      getAttributes().addAll((Collection<? extends Attribute>) newValue);
      return;
    case ProductLinePackage.CLASS__TYPE:
      setType((EClass) newValue);
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      getReferencesAsSource().clear();
      return;
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGET:
      getReferencesAsTarget().clear();
      return;
    case ProductLinePackage.CLASS__ATTRIBUTES:
      getAttributes().clear();
      return;
    case ProductLinePackage.CLASS__TYPE:
      setType((EClass) null);
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
    case ProductLinePackage.CLASS__REFERENCES_AS_SOURCE:
      return this.referencesAsSource != null && !this.referencesAsSource.isEmpty();
    case ProductLinePackage.CLASS__REFERENCES_AS_TARGET:
      return this.referencesAsTarget != null && !this.referencesAsTarget.isEmpty();
    case ProductLinePackage.CLASS__ATTRIBUTES:
      return this.attributes != null && !this.attributes.isEmpty();
    case ProductLinePackage.CLASS__TYPE:
      return this.type != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * @generated NOT
   */
  @Override
  public String toString() {
    return getType().getName() + " " + ProductLineMIDHeavyTypeFactory.getPLElementLabel(this, true) + " {"
      + getAttributes().stream().map(a -> a.getType().getName() + ": " + a.getValue()).collect(Collectors.joining(", "))
      + "}";
  }

} //ClassImpl
