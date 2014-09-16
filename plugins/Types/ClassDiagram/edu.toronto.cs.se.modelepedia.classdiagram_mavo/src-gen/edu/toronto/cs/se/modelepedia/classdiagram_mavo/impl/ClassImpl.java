/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl;

import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation;

import edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getDependenciesAsDependee <em>Dependencies As Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getDependenciesAsDepender <em>Dependencies As Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getNestedIn <em>Nested In</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getNested <em>Nested</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getSuperclass <em>Superclass</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getSubclasses <em>Subclasses</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getAssociationsAsSource <em>Associations As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl#getAssociationsAsTarget <em>Associations As Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl implements edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class {
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
	 * The cached value of the '{@link #getNestedIn() <em>Nested In</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedIn()
	 * @generated
	 * @ordered
	 */
	protected EList<NestedInReference> nestedIn;

	/**
	 * The cached value of the '{@link #getNested() <em>Nested</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNested()
	 * @generated
	 * @ordered
	 */
	protected EList<NestedInReference> nested;

	/**
	 * The cached value of the '{@link #getSuperclass() <em>Superclass</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperclass()
	 * @generated
	 * @ordered
	 */
	protected EList<SuperclassReference> superclass;

	/**
	 * The cached value of the '{@link #getSubclasses() <em>Subclasses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubclasses()
	 * @generated
	 * @ordered
	 */
	protected EList<SuperclassReference> subclasses;

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
		return ClassDiagram_MAVOPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getOwnedAttributes() {
		if (ownedAttributes == null) {
			ownedAttributes = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES, ClassDiagram_MAVOPackage.ATTRIBUTE__OWNER);
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
			ownedOperations = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS, ClassDiagram_MAVOPackage.OPERATION__OWNER);
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
			dependenciesAsDependee = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE);
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
			dependenciesAsDepender = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER);
		}
		return dependenciesAsDepender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NestedInReference> getNestedIn() {
		if (nestedIn == null) {
			nestedIn = new EObjectContainmentWithInverseEList<NestedInReference>(NestedInReference.class, this, ClassDiagram_MAVOPackage.CLASS__NESTED_IN, ClassDiagram_MAVOPackage.NESTED_IN_REFERENCE__SOURCE);
		}
		return nestedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NestedInReference> getNested() {
		if (nested == null) {
			nested = new EObjectWithInverseResolvingEList<NestedInReference>(NestedInReference.class, this, ClassDiagram_MAVOPackage.CLASS__NESTED, ClassDiagram_MAVOPackage.NESTED_IN_REFERENCE__TARGET);
		}
		return nested;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SuperclassReference> getSuperclass() {
		if (superclass == null) {
			superclass = new EObjectContainmentWithInverseEList<SuperclassReference>(SuperclassReference.class, this, ClassDiagram_MAVOPackage.CLASS__SUPERCLASS, ClassDiagram_MAVOPackage.SUPERCLASS_REFERENCE__SOURCE);
		}
		return superclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SuperclassReference> getSubclasses() {
		if (subclasses == null) {
			subclasses = new EObjectWithInverseResolvingEList<SuperclassReference>(SuperclassReference.class, this, ClassDiagram_MAVOPackage.CLASS__SUBCLASSES, ClassDiagram_MAVOPackage.SUPERCLASS_REFERENCE__TARGET);
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
			associationsAsSource = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE, ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE);
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
			associationsAsTarget = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET, ClassDiagram_MAVOPackage.ASSOCIATION__TARGET);
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
			case ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttributes()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperations()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDependee()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDepender()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__NESTED_IN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedIn()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__NESTED:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNested()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__SUPERCLASS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSuperclass()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__SUBCLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubclasses()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationsAsSource()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET:
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
			case ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES:
				return ((InternalEList<?>)getOwnedAttributes()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return ((InternalEList<?>)getDependenciesAsDependee()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return ((InternalEList<?>)getDependenciesAsDepender()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__NESTED_IN:
				return ((InternalEList<?>)getNestedIn()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__NESTED:
				return ((InternalEList<?>)getNested()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__SUPERCLASS:
				return ((InternalEList<?>)getSuperclass()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__SUBCLASSES:
				return ((InternalEList<?>)getSubclasses()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
				return ((InternalEList<?>)getAssociationsAsSource()).basicRemove(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET:
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
			case ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES:
				return getOwnedAttributes();
			case ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS:
				return getOwnedOperations();
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return getDependenciesAsDependee();
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return getDependenciesAsDepender();
			case ClassDiagram_MAVOPackage.CLASS__NESTED_IN:
				return getNestedIn();
			case ClassDiagram_MAVOPackage.CLASS__NESTED:
				return getNested();
			case ClassDiagram_MAVOPackage.CLASS__SUPERCLASS:
				return getSuperclass();
			case ClassDiagram_MAVOPackage.CLASS__SUBCLASSES:
				return getSubclasses();
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
				return getAssociationsAsSource();
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET:
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
			case ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES:
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				getDependenciesAsDependee().clear();
				getDependenciesAsDependee().addAll((Collection<? extends Dependency>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				getDependenciesAsDepender().clear();
				getDependenciesAsDepender().addAll((Collection<? extends Dependency>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__NESTED_IN:
				getNestedIn().clear();
				getNestedIn().addAll((Collection<? extends NestedInReference>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__NESTED:
				getNested().clear();
				getNested().addAll((Collection<? extends NestedInReference>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__SUPERCLASS:
				getSuperclass().clear();
				getSuperclass().addAll((Collection<? extends SuperclassReference>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__SUBCLASSES:
				getSubclasses().clear();
				getSubclasses().addAll((Collection<? extends SuperclassReference>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
				getAssociationsAsSource().clear();
				getAssociationsAsSource().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET:
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
			case ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES:
				getOwnedAttributes().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				getDependenciesAsDependee().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				getDependenciesAsDepender().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__NESTED_IN:
				getNestedIn().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__NESTED:
				getNested().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__SUPERCLASS:
				getSuperclass().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__SUBCLASSES:
				getSubclasses().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
				getAssociationsAsSource().clear();
				return;
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET:
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
			case ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES:
				return ownedAttributes != null && !ownedAttributes.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return dependenciesAsDependee != null && !dependenciesAsDependee.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return dependenciesAsDepender != null && !dependenciesAsDepender.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__NESTED_IN:
				return nestedIn != null && !nestedIn.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__NESTED:
				return nested != null && !nested.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__SUPERCLASS:
				return superclass != null && !superclass.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__SUBCLASSES:
				return subclasses != null && !subclasses.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE:
				return associationsAsSource != null && !associationsAsSource.isEmpty();
			case ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET:
				return associationsAsTarget != null && !associationsAsTarget.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassImpl
