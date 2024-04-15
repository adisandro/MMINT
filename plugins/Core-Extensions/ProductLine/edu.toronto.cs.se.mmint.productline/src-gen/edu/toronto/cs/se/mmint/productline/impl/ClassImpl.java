/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getReferences <em>References</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getReferencesAsTarget <em>References As Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ClassImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends PLElementImpl implements edu.toronto.cs.se.mmint.productline.Class {
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
   * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferences()
   * @generated
   * @ordered
   */
  protected EList<Reference> references;

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
    return PLPackage.Literals.CLASS;
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
                                                                           PLPackage.CLASS__REFERENCES_AS_TARGET,
                                                                           PLPackage.REFERENCE__TARGET);
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
      this.attributes = new EObjectContainmentEList<>(Attribute.class, this, PLPackage.CLASS__ATTRIBUTES);
    }
    return this.attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Reference> getReferences() {
    if (this.references == null) {
      this.references = new EObjectContainmentEList<>(Reference.class, this, PLPackage.CLASS__REFERENCES);
    }
    return this.references;
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
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PLPackage.CLASS__TYPE, oldType, this.type));
        }
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
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, PLPackage.CLASS__TYPE, oldType, this.type));
    }
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
    case PLPackage.CLASS__REFERENCES_AS_TARGET:
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
    case PLPackage.CLASS__ATTRIBUTES:
      return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
    case PLPackage.CLASS__REFERENCES:
      return ((InternalEList<?>) getReferences()).basicRemove(otherEnd, msgs);
    case PLPackage.CLASS__REFERENCES_AS_TARGET:
      return ((InternalEList<?>) getReferencesAsTarget()).basicRemove(otherEnd, msgs);
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
    case PLPackage.CLASS__ATTRIBUTES:
      return getAttributes();
    case PLPackage.CLASS__REFERENCES:
      return getReferences();
    case PLPackage.CLASS__REFERENCES_AS_TARGET:
      return getReferencesAsTarget();
    case PLPackage.CLASS__TYPE:
      if (resolve) {
        return getType();
      }
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
    case PLPackage.CLASS__ATTRIBUTES:
      getAttributes().clear();
      getAttributes().addAll((Collection<? extends Attribute>) newValue);
      return;
    case PLPackage.CLASS__REFERENCES:
      getReferences().clear();
      getReferences().addAll((Collection<? extends Reference>) newValue);
      return;
    case PLPackage.CLASS__REFERENCES_AS_TARGET:
      getReferencesAsTarget().clear();
      getReferencesAsTarget().addAll((Collection<? extends Reference>) newValue);
      return;
    case PLPackage.CLASS__TYPE:
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
    case PLPackage.CLASS__ATTRIBUTES:
      getAttributes().clear();
      return;
    case PLPackage.CLASS__REFERENCES:
      getReferences().clear();
      return;
    case PLPackage.CLASS__REFERENCES_AS_TARGET:
      getReferencesAsTarget().clear();
      return;
    case PLPackage.CLASS__TYPE:
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
    case PLPackage.CLASS__ATTRIBUTES:
      return this.attributes != null && !this.attributes.isEmpty();
    case PLPackage.CLASS__REFERENCES:
      return this.references != null && !this.references.isEmpty();
    case PLPackage.CLASS__REFERENCES_AS_TARGET:
      return this.referencesAsTarget != null && !this.referencesAsTarget.isEmpty();
    case PLPackage.CLASS__TYPE:
      return this.type != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
    case PLPackage.CLASS___GET_STREAM_OF_REFERENCE__EREFERENCE:
      return getStreamOfReference((EReference) arguments.get(0));
    case PLPackage.CLASS___GET_REFERENCE__EREFERENCE:
      return getReference((EReference) arguments.get(0));
    case PLPackage.CLASS___SET_REFERENCE__EREFERENCE_CLASS:
      setReference((EReference) arguments.get(0), (edu.toronto.cs.se.mmint.productline.Class) arguments.get(1));
      return null;
    case PLPackage.CLASS___GET_STREAM_OF_REFERENCE_AS_TARGET__EREFERENCE:
      return getStreamOfReferenceAsTarget((EReference) arguments.get(0));
    case PLPackage.CLASS___GET_REFERENCE_AS_TARGET__EREFERENCE:
      return getReferenceAsTarget((EReference) arguments.get(0));
    case PLPackage.CLASS___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE:
      return getStreamOfAttribute((EAttribute) arguments.get(0));
    case PLPackage.CLASS___GET_ATTRIBUTE__EATTRIBUTE:
      return getAttribute((EAttribute) arguments.get(0));
    case PLPackage.CLASS___SET_ATTRIBUTE__EATTRIBUTE_STRING:
      setAttribute((EAttribute) arguments.get(0), (String) arguments.get(1));
      return null;
    case PLPackage.CLASS___INSTANCE_OF__ECLASS:
      return instanceOf((EClass) arguments.get(0));
    case PLPackage.CLASS___GET_ECONTAINER:
      return getEContainer();
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * @generated NOT
   */
  @Override
  public String toString() {
    var attributes = getAttributes().stream().map(a -> a.getType().getName() + ": " + a.getValue()).collect(Collectors
                                                                                                                      .joining(", "));
    var pc = getPresenceConditionLabel(true);
    return getType().getName() + (attributes.isEmpty() ? "" : "{" + attributes + "}") + (pc.isEmpty() ? "" : " " + pc);
  }

  /**
   * @generated NOT
   */
  private Stream<Reference> getStreamOfReference_(EList<Reference> references, EReference referenceType) {
    return references.stream().filter(r -> r.getType() == referenceType);
  }

  /**
   * @generated NOT
   */
  @Override
  public Stream<edu.toronto.cs.se.mmint.productline.Class> getStreamOfReference(EReference referenceType) {
    return getStreamOfReference_(getReferences(), referenceType).map(r -> r.getTarget());
  }

  /**
   * @generated NOT
   */
  @Override
  public EList<edu.toronto.cs.se.mmint.productline.Class> getReference(EReference referenceType) {
    return ECollections.asEList(getStreamOfReference(referenceType).collect(Collectors.toList()));
  }

  /**
   * @generated NOT
   */
  @Override
  public void setReference(EReference referenceType, edu.toronto.cs.se.mmint.productline.Class tgtClass) {
    getStreamOfReference_(getReferences(), referenceType).forEach(r -> r.setTarget(tgtClass));
  }

  /**
   * @generated NOT
   */
  @Override
  public Stream<edu.toronto.cs.se.mmint.productline.Class> getStreamOfReferenceAsTarget(EReference referenceType) {
    return getStreamOfReference_(getReferencesAsTarget(), referenceType).map(
                                                                             r -> (edu.toronto.cs.se.mmint.productline.Class) r.eContainer());
  }

  /**
   * @generated NOT
   */
  @Override
  public EList<edu.toronto.cs.se.mmint.productline.Class> getReferenceAsTarget(EReference referenceType) {
    return ECollections.asEList(getStreamOfReferenceAsTarget(referenceType).collect(Collectors.toList()));
  }

  /**
   * @generated NOT
   */
  private Stream<Attribute> getStreamOfAttribute_(EAttribute attributeType) {
    return getAttributes().stream().filter(a -> a.getType() == attributeType);
  }

  /**
   * @generated NOT
   */
  @Override
  public Stream<String> getStreamOfAttribute(EAttribute attributeType) {
    return getStreamOfAttribute_(attributeType).map(a -> a.getValue());
  }

  /**
   * @generated NOT
   */
  @Override
  public EList<String> getAttribute(EAttribute attributeType) {
    return ECollections.asEList(getStreamOfAttribute(attributeType).collect(Collectors.toList()));
  }

  /**
   * @generated NOT
   */
  @Override
  public void setAttribute(EAttribute attributeType, String value) {
    getStreamOfAttribute_(attributeType).forEach(a -> a.setValue(value));
  }

  /**
   * @generated NOT
   */
  @Override
  public boolean instanceOf(EClass type) {
    return type.isSuperTypeOf(getType());
  }

  /**
   * @generated NOT
   */
  @Override
  public Class getEContainer() {
    return getReferencesAsTarget().stream().filter(r -> r.getType().isContainment()).map(r -> (Class) r.eContainer())
                                  .findFirst().orElse(null);
  }

} //ClassImpl
