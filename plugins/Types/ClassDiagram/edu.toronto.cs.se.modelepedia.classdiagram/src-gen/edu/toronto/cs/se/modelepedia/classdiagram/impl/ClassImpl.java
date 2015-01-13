/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
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
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl implements edu.toronto.cs.se.modelepedia.classdiagram.Class {
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
	public EList<Attribute> getOwnedAttributes() {
		if (ownedAttributes == null) {
			ownedAttributes = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES, ClassDiagramPackage.ATTRIBUTE__OWNER);
		}
		return ownedAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOwnedOperations() {
		if (ownedOperations == null) {
			ownedOperations = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, ClassDiagramPackage.CLASS__OWNED_OPERATIONS, ClassDiagramPackage.OPERATION__OWNER);
		}
		return ownedOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependenciesAsDependee() {
		if (dependenciesAsDependee == null) {
			dependenciesAsDependee = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, ClassDiagramPackage.DEPENDENCY__DEPENDEE);
		}
		return dependenciesAsDependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependenciesAsDepender() {
		if (dependenciesAsDepender == null) {
			dependenciesAsDepender = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER, ClassDiagramPackage.DEPENDENCY__DEPENDER);
		}
		return dependenciesAsDepender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class getNestedIn() {
		if (nestedIn != null && nestedIn.eIsProxy()) {
			InternalEObject oldNestedIn = (InternalEObject)nestedIn;
			nestedIn = (edu.toronto.cs.se.modelepedia.classdiagram.Class)eResolveProxy(oldNestedIn);
			if (nestedIn != oldNestedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagramPackage.CLASS__NESTED_IN, oldNestedIn, nestedIn));
			}
		}
		return nestedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class basicGetNestedIn() {
		return nestedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestedIn(edu.toronto.cs.se.modelepedia.classdiagram.Class newNestedIn, NotificationChain msgs) {
		edu.toronto.cs.se.modelepedia.classdiagram.Class oldNestedIn = nestedIn;
		nestedIn = newNestedIn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.CLASS__NESTED_IN, oldNestedIn, newNestedIn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedIn(edu.toronto.cs.se.modelepedia.classdiagram.Class newNestedIn) {
		if (newNestedIn != nestedIn) {
			NotificationChain msgs = null;
			if (nestedIn != null)
				msgs = ((InternalEObject)nestedIn).eInverseRemove(this, ClassDiagramPackage.CLASS__NESTED, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
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
	public EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> getNested() {
		if (nested == null) {
			nested = new EObjectWithInverseResolvingEList<edu.toronto.cs.se.modelepedia.classdiagram.Class>(edu.toronto.cs.se.modelepedia.classdiagram.Class.class, this, ClassDiagramPackage.CLASS__NESTED, ClassDiagramPackage.CLASS__NESTED_IN);
		}
		return nested;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class getSuperclass() {
		if (superclass != null && superclass.eIsProxy()) {
			InternalEObject oldSuperclass = (InternalEObject)superclass;
			superclass = (edu.toronto.cs.se.modelepedia.classdiagram.Class)eResolveProxy(oldSuperclass);
			if (superclass != oldSuperclass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagramPackage.CLASS__SUPERCLASS, oldSuperclass, superclass));
			}
		}
		return superclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class basicGetSuperclass() {
		return superclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperclass(edu.toronto.cs.se.modelepedia.classdiagram.Class newSuperclass, NotificationChain msgs) {
		edu.toronto.cs.se.modelepedia.classdiagram.Class oldSuperclass = superclass;
		superclass = newSuperclass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.CLASS__SUPERCLASS, oldSuperclass, newSuperclass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperclass(edu.toronto.cs.se.modelepedia.classdiagram.Class newSuperclass) {
		if (newSuperclass != superclass) {
			NotificationChain msgs = null;
			if (superclass != null)
				msgs = ((InternalEObject)superclass).eInverseRemove(this, ClassDiagramPackage.CLASS__SUBCLASSES, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
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
	public EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> getSubclasses() {
		if (subclasses == null) {
			subclasses = new EObjectWithInverseResolvingEList<edu.toronto.cs.se.modelepedia.classdiagram.Class>(edu.toronto.cs.se.modelepedia.classdiagram.Class.class, this, ClassDiagramPackage.CLASS__SUBCLASSES, ClassDiagramPackage.CLASS__SUPERCLASS);
		}
		return subclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAssociationsAsSource() {
		if (associationsAsSource == null) {
			associationsAsSource = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE, ClassDiagramPackage.ASSOCIATION__SOURCE);
		}
		return associationsAsSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAssociationsAsTarget() {
		if (associationsAsTarget == null) {
			associationsAsTarget = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET, ClassDiagramPackage.ASSOCIATION__TARGET);
		}
		return associationsAsTarget;
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
			case ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttributes()).basicAdd(otherEnd, msgs);
			case ClassDiagramPackage.CLASS__OWNED_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperations()).basicAdd(otherEnd, msgs);
			case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDependee()).basicAdd(otherEnd, msgs);
			case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDepender()).basicAdd(otherEnd, msgs);
			case ClassDiagramPackage.CLASS__NESTED_IN:
				if (nestedIn != null)
					msgs = ((InternalEObject)nestedIn).eInverseRemove(this, ClassDiagramPackage.CLASS__NESTED, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
				return basicSetNestedIn((edu.toronto.cs.se.modelepedia.classdiagram.Class)otherEnd, msgs);
			case ClassDiagramPackage.CLASS__NESTED:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNested()).basicAdd(otherEnd, msgs);
			case ClassDiagramPackage.CLASS__SUPERCLASS:
				if (superclass != null)
					msgs = ((InternalEObject)superclass).eInverseRemove(this, ClassDiagramPackage.CLASS__SUBCLASSES, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
				return basicSetSuperclass((edu.toronto.cs.se.modelepedia.classdiagram.Class)otherEnd, msgs);
			case ClassDiagramPackage.CLASS__SUBCLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubclasses()).basicAdd(otherEnd, msgs);
			case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationsAsSource()).basicAdd(otherEnd, msgs);
			case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationsAsTarget()).basicAdd(otherEnd, msgs);
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
				return ownedAttributes != null && !ownedAttributes.isEmpty();
			case ClassDiagramPackage.CLASS__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return dependenciesAsDependee != null && !dependenciesAsDependee.isEmpty();
			case ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return dependenciesAsDepender != null && !dependenciesAsDepender.isEmpty();
			case ClassDiagramPackage.CLASS__NESTED_IN:
				return nestedIn != null;
			case ClassDiagramPackage.CLASS__NESTED:
				return nested != null && !nested.isEmpty();
			case ClassDiagramPackage.CLASS__SUPERCLASS:
				return superclass != null;
			case ClassDiagramPackage.CLASS__SUBCLASSES:
				return subclasses != null && !subclasses.isEmpty();
			case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
				return associationsAsSource != null && !associationsAsSource.isEmpty();
			case ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET:
				return associationsAsTarget != null && !associationsAsTarget.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassImpl
