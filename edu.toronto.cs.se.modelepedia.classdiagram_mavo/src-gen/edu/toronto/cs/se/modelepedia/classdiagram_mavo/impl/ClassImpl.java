/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl;

import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
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
			ownedAttributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES);
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
			ownedOperations = new EObjectContainmentEList<Operation>(Operation.class, this, ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS);
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDependee()).basicAdd(otherEnd, msgs);
			case ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDepender()).basicAdd(otherEnd, msgs);
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
		}
		return super.eIsSet(featureID);
	}

} //ClassImpl
