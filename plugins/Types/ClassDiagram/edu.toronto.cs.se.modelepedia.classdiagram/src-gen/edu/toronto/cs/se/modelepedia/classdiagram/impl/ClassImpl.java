/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram.Composition;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getDependenciesAsDependee <em>Dependencies As Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getDependenciesAsDepender <em>Dependencies As Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getNestedIn <em>Nested In</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getNested <em>Nested</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getSuperclass <em>Superclass</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getSubclasses <em>Subclasses</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getAssociationsAsSource <em>Associations As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getAssociationsAsTarget <em>Associations As Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getCompositionsAsConstituent <em>Compositions As Constituent</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl#getCompositionsAsComposite <em>Compositions As Composite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends TypeableImpl implements edu.toronto.cs.se.modelepedia.classdiagram.Class {
	/**
   * The cached value of the '{@link #getOwnedAttributes() <em>Owned Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOwnedAttributes()
   * @generated
   * @ordered
   */
	protected EList<Attribute> ownedAttributes;

	/**
   * The cached value of the '{@link #getOwnedOperations() <em>Owned Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOwnedOperations()
   * @generated
   * @ordered
   */
	protected EList<Operation> ownedOperations;

	/**
   * The cached value of the '{@link #getDependenciesAsDependee() <em>Dependencies As Dependee</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDependenciesAsDependee()
   * @generated
   * @ordered
   */
	protected EList<Dependency> dependenciesAsDependee;

	/**
   * The cached value of the '{@link #getDependenciesAsDepender() <em>Dependencies As Depender</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDependenciesAsDepender()
   * @generated
   * @ordered
   */
	protected EList<Dependency> dependenciesAsDepender;

	/**
   * The cached value of the '{@link #getNestedIn() <em>Nested In</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getNestedIn()
   * @generated
   * @ordered
   */
	protected edu.toronto.cs.se.modelepedia.classdiagram.Class nestedIn;

	/**
   * The cached value of the '{@link #getNested() <em>Nested</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getNested()
   * @generated
   * @ordered
   */
	protected EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> nested;

	/**
   * The cached value of the '{@link #getSuperclass() <em>Superclass</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSuperclass()
   * @generated
   * @ordered
   */
	protected edu.toronto.cs.se.modelepedia.classdiagram.Class superclass;

	/**
   * The cached value of the '{@link #getSubclasses() <em>Subclasses</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getSubclasses()
   * @generated
   * @ordered
   */
	protected EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> subclasses;

	/**
   * The cached value of the '{@link #getAssociationsAsSource() <em>Associations As Source</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAssociationsAsSource()
   * @generated
   * @ordered
   */
	protected EList<Association> associationsAsSource;

	/**
   * The cached value of the '{@link #getAssociationsAsTarget() <em>Associations As Target</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAssociationsAsTarget()
   * @generated
   * @ordered
   */
	protected EList<Association> associationsAsTarget;

	/**
   * The cached value of the '{@link #getCompositionsAsConstituent() <em>Compositions As Constituent</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCompositionsAsConstituent()
   * @generated
   * @ordered
   */
	protected EList<Composition> compositionsAsConstituent;

	/**
   * The cached value of the '{@link #getCompositionsAsComposite() <em>Compositions As Composite</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCompositionsAsComposite()
   * @generated
   * @ordered
   */
	protected EList<Composition> compositionsAsComposite;

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
    return ClassDiagramPackage.Literals.CLASS;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Attribute> getOwnedAttributes() {
    if (this.ownedAttributes == null) {
      this.ownedAttributes = new EObjectContainmentEList<>(Attribute.class, this, ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES);
    }
    return this.ownedAttributes;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Operation> getOwnedOperations() {
    if (this.ownedOperations == null) {
      this.ownedOperations = new EObjectContainmentEList<>(Operation.class, this, ClassDiagramPackage.CLASS__OWNED_OPERATIONS);
    }
    return this.ownedOperations;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Dependency> getDependenciesAsDependee() {
    if (this.dependenciesAsDependee == null) {
      this.dependenciesAsDependee = new EObjectWithInverseResolvingEList<>(Dependency.class, this, ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, ClassDiagramPackage.DEPENDENCY__DEPENDEE);
    }
    return this.dependenciesAsDependee;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Dependency> getDependenciesAsDepender() {
    if (this.dependenciesAsDepender == null) {
      this.dependenciesAsDepender = new EObjectWithInverseResolvingEList<>(Dependency.class, this, ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER, ClassDiagramPackage.DEPENDENCY__DEPENDER);
    }
    return this.dependenciesAsDepender;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram.Class getNestedIn() {
    if (this.nestedIn != null && this.nestedIn.eIsProxy()) {
      var oldNestedIn = (InternalEObject)this.nestedIn;
      this.nestedIn = (edu.toronto.cs.se.modelepedia.classdiagram.Class)eResolveProxy(oldNestedIn);
      if (this.nestedIn != oldNestedIn) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagramPackage.CLASS__NESTED_IN, oldNestedIn, this.nestedIn));
      }
    }
    return this.nestedIn;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class basicGetNestedIn() {
    return this.nestedIn;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetNestedIn(edu.toronto.cs.se.modelepedia.classdiagram.Class newNestedIn, NotificationChain msgs) {
    var oldNestedIn = this.nestedIn;
    this.nestedIn = newNestedIn;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.CLASS__NESTED_IN, oldNestedIn, newNestedIn);
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
  public void setNestedIn(edu.toronto.cs.se.modelepedia.classdiagram.Class newNestedIn) {
    if (newNestedIn != this.nestedIn) {
      NotificationChain msgs = null;
      if (this.nestedIn != null)
        msgs = ((InternalEObject)this.nestedIn).eInverseRemove(this, ClassDiagramPackage.CLASS__NESTED, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
      if (newNestedIn != null)
        msgs = ((InternalEObject)newNestedIn).eInverseAdd(this, ClassDiagramPackage.CLASS__NESTED, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
      msgs = basicSetNestedIn(newNestedIn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.CLASS__NESTED_IN, newNestedIn, newNestedIn));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> getNested() {
    if (this.nested == null) {
      this.nested = new EObjectWithInverseResolvingEList<>(edu.toronto.cs.se.modelepedia.classdiagram.Class.class, this, ClassDiagramPackage.CLASS__NESTED, ClassDiagramPackage.CLASS__NESTED_IN);
    }
    return this.nested;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram.Class getSuperclass() {
    if (this.superclass != null && this.superclass.eIsProxy()) {
      var oldSuperclass = (InternalEObject)this.superclass;
      this.superclass = (edu.toronto.cs.se.modelepedia.classdiagram.Class)eResolveProxy(oldSuperclass);
      if (this.superclass != oldSuperclass) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagramPackage.CLASS__SUPERCLASS, oldSuperclass, this.superclass));
      }
    }
    return this.superclass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class basicGetSuperclass() {
    return this.superclass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetSuperclass(edu.toronto.cs.se.modelepedia.classdiagram.Class newSuperclass, NotificationChain msgs) {
    var oldSuperclass = this.superclass;
    this.superclass = newSuperclass;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.CLASS__SUPERCLASS, oldSuperclass, newSuperclass);
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
  public void setSuperclass(edu.toronto.cs.se.modelepedia.classdiagram.Class newSuperclass) {
    if (newSuperclass != this.superclass) {
      NotificationChain msgs = null;
      if (this.superclass != null)
        msgs = ((InternalEObject)this.superclass).eInverseRemove(this, ClassDiagramPackage.CLASS__SUBCLASSES, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
      if (newSuperclass != null)
        msgs = ((InternalEObject)newSuperclass).eInverseAdd(this, ClassDiagramPackage.CLASS__SUBCLASSES, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
      msgs = basicSetSuperclass(newSuperclass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.CLASS__SUPERCLASS, newSuperclass, newSuperclass));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> getSubclasses() {
    if (this.subclasses == null) {
      this.subclasses = new EObjectWithInverseResolvingEList<>(edu.toronto.cs.se.modelepedia.classdiagram.Class.class, this, ClassDiagramPackage.CLASS__SUBCLASSES, ClassDiagramPackage.CLASS__SUPERCLASS);
    }
    return this.subclasses;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Association> getAssociationsAsSource() {
    if (this.associationsAsSource == null) {
      this.associationsAsSource = new EObjectWithInverseResolvingEList<>(Association.class, this, ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE, ClassDiagramPackage.ASSOCIATION__SOURCE);
    }
    return this.associationsAsSource;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Association> getAssociationsAsTarget() {
    if (this.associationsAsTarget == null) {
      this.associationsAsTarget = new EObjectWithInverseResolvingEList<>(Association.class, this, ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET, ClassDiagramPackage.ASSOCIATION__TARGET);
    }
    return this.associationsAsTarget;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Composition> getCompositionsAsConstituent() {
    if (this.compositionsAsConstituent == null) {
      this.compositionsAsConstituent = new EObjectWithInverseResolvingEList<>(Composition.class, this, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT, ClassDiagramPackage.COMPOSITION__CONSTITUENT);
    }
    return this.compositionsAsConstituent;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Composition> getCompositionsAsComposite() {
    if (this.compositionsAsComposite == null) {
      this.compositionsAsComposite = new EObjectWithInverseResolvingEList<>(Composition.class, this, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE, ClassDiagramPackage.COMPOSITION__COMPOSITE);
    }
    return this.compositionsAsComposite;
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
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDependee()).basicAdd(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDepender()).basicAdd(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__NESTED_IN:
        if (this.nestedIn != null)
          msgs = ((InternalEObject)this.nestedIn).eInverseRemove(this, ClassDiagramPackage.CLASS__NESTED, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
        return basicSetNestedIn((edu.toronto.cs.se.modelepedia.classdiagram.Class)otherEnd, msgs);
      case ClassDiagramPackage.CLASS__NESTED:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getNested()).basicAdd(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__SUPERCLASS:
        if (this.superclass != null)
          msgs = ((InternalEObject)this.superclass).eInverseRemove(this, ClassDiagramPackage.CLASS__SUBCLASSES, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
        return basicSetSuperclass((edu.toronto.cs.se.modelepedia.classdiagram.Class)otherEnd, msgs);
      case ClassDiagramPackage.CLASS__SUBCLASSES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubclasses()).basicAdd(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationsAsSource()).basicAdd(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationsAsTarget()).basicAdd(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getCompositionsAsConstituent()).basicAdd(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getCompositionsAsComposite()).basicAdd(otherEnd, msgs);
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
      case ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES:
        return ((InternalEList<?>)getOwnedAttributes()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__OWNED_OPERATIONS:
        return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
        return ((InternalEList<?>)getDependenciesAsDependee()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
        return ((InternalEList<?>)getDependenciesAsDepender()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__NESTED_IN:
        return basicSetNestedIn(null, msgs);
      case ClassDiagramPackage.CLASS__NESTED:
        return ((InternalEList<?>)getNested()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__SUPERCLASS:
        return basicSetSuperclass(null, msgs);
      case ClassDiagramPackage.CLASS__SUBCLASSES:
        return ((InternalEList<?>)getSubclasses()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
        return ((InternalEList<?>)getAssociationsAsSource()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET:
        return ((InternalEList<?>)getAssociationsAsTarget()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT:
        return ((InternalEList<?>)getCompositionsAsConstituent()).basicRemove(otherEnd, msgs);
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE:
        return ((InternalEList<?>)getCompositionsAsComposite()).basicRemove(otherEnd, msgs);
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
      case ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES:
        return getOwnedAttributes();
      case ClassDiagramPackage.CLASS__OWNED_OPERATIONS:
        return getOwnedOperations();
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
        return getDependenciesAsDependee();
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
        return getDependenciesAsDepender();
      case ClassDiagramPackage.CLASS__NESTED_IN:
        if (resolve) return getNestedIn();
        return basicGetNestedIn();
      case ClassDiagramPackage.CLASS__NESTED:
        return getNested();
      case ClassDiagramPackage.CLASS__SUPERCLASS:
        if (resolve) return getSuperclass();
        return basicGetSuperclass();
      case ClassDiagramPackage.CLASS__SUBCLASSES:
        return getSubclasses();
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
        return getAssociationsAsSource();
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET:
        return getAssociationsAsTarget();
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT:
        return getCompositionsAsConstituent();
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE:
        return getCompositionsAsComposite();
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
      case ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES:
        getOwnedAttributes().clear();
        getOwnedAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case ClassDiagramPackage.CLASS__OWNED_OPERATIONS:
        getOwnedOperations().clear();
        getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
        return;
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
        getDependenciesAsDependee().clear();
        getDependenciesAsDependee().addAll((Collection<? extends Dependency>)newValue);
        return;
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
        getDependenciesAsDepender().clear();
        getDependenciesAsDepender().addAll((Collection<? extends Dependency>)newValue);
        return;
      case ClassDiagramPackage.CLASS__NESTED_IN:
        setNestedIn((edu.toronto.cs.se.modelepedia.classdiagram.Class)newValue);
        return;
      case ClassDiagramPackage.CLASS__NESTED:
        getNested().clear();
        getNested().addAll((Collection<? extends edu.toronto.cs.se.modelepedia.classdiagram.Class>)newValue);
        return;
      case ClassDiagramPackage.CLASS__SUPERCLASS:
        setSuperclass((edu.toronto.cs.se.modelepedia.classdiagram.Class)newValue);
        return;
      case ClassDiagramPackage.CLASS__SUBCLASSES:
        getSubclasses().clear();
        getSubclasses().addAll((Collection<? extends edu.toronto.cs.se.modelepedia.classdiagram.Class>)newValue);
        return;
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
        getAssociationsAsSource().clear();
        getAssociationsAsSource().addAll((Collection<? extends Association>)newValue);
        return;
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET:
        getAssociationsAsTarget().clear();
        getAssociationsAsTarget().addAll((Collection<? extends Association>)newValue);
        return;
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT:
        getCompositionsAsConstituent().clear();
        getCompositionsAsConstituent().addAll((Collection<? extends Composition>)newValue);
        return;
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE:
        getCompositionsAsComposite().clear();
        getCompositionsAsComposite().addAll((Collection<? extends Composition>)newValue);
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
      case ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES:
        getOwnedAttributes().clear();
        return;
      case ClassDiagramPackage.CLASS__OWNED_OPERATIONS:
        getOwnedOperations().clear();
        return;
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
        getDependenciesAsDependee().clear();
        return;
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
        getDependenciesAsDepender().clear();
        return;
      case ClassDiagramPackage.CLASS__NESTED_IN:
        setNestedIn((edu.toronto.cs.se.modelepedia.classdiagram.Class)null);
        return;
      case ClassDiagramPackage.CLASS__NESTED:
        getNested().clear();
        return;
      case ClassDiagramPackage.CLASS__SUPERCLASS:
        setSuperclass((edu.toronto.cs.se.modelepedia.classdiagram.Class)null);
        return;
      case ClassDiagramPackage.CLASS__SUBCLASSES:
        getSubclasses().clear();
        return;
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
        getAssociationsAsSource().clear();
        return;
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET:
        getAssociationsAsTarget().clear();
        return;
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT:
        getCompositionsAsConstituent().clear();
        return;
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE:
        getCompositionsAsComposite().clear();
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
      case ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES:
        return this.ownedAttributes != null && !this.ownedAttributes.isEmpty();
      case ClassDiagramPackage.CLASS__OWNED_OPERATIONS:
        return this.ownedOperations != null && !this.ownedOperations.isEmpty();
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
        return this.dependenciesAsDependee != null && !this.dependenciesAsDependee.isEmpty();
      case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
        return this.dependenciesAsDepender != null && !this.dependenciesAsDepender.isEmpty();
      case ClassDiagramPackage.CLASS__NESTED_IN:
        return this.nestedIn != null;
      case ClassDiagramPackage.CLASS__NESTED:
        return this.nested != null && !this.nested.isEmpty();
      case ClassDiagramPackage.CLASS__SUPERCLASS:
        return this.superclass != null;
      case ClassDiagramPackage.CLASS__SUBCLASSES:
        return this.subclasses != null && !this.subclasses.isEmpty();
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
        return this.associationsAsSource != null && !this.associationsAsSource.isEmpty();
      case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET:
        return this.associationsAsTarget != null && !this.associationsAsTarget.isEmpty();
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT:
        return this.compositionsAsConstituent != null && !this.compositionsAsConstituent.isEmpty();
      case ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE:
        return this.compositionsAsComposite != null && !this.compositionsAsComposite.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClassImpl
