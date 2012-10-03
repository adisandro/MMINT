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
package edu.toronto.cs.se.modelepedia.istar.impl;

import edu.toronto.cs.se.modelepedia.istar.Actor;
import edu.toronto.cs.se.modelepedia.istar.Contribution;
import edu.toronto.cs.se.modelepedia.istar.Dependency;
import edu.toronto.cs.se.modelepedia.istar.IntentionalElement;
import edu.toronto.cs.se.modelepedia.istar.IstarPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.ActorImpl#getIntentionalElements <em>Intentional Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.ActorImpl#getDependenciesAsDepender <em>Dependencies As Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.ActorImpl#getDependenciesAsDependee <em>Dependencies As Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.ActorImpl#getContributions <em>Contributions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorImpl extends EObjectImpl implements Actor {
	/**
	 * The cached value of the '{@link #getIntentionalElements() <em>Intentional Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentionalElements()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentionalElement> intentionalElements;

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
	 * The cached value of the '{@link #getDependenciesAsDependee() <em>Dependencies As Dependee</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesAsDependee()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependenciesAsDependee;

	/**
	 * The cached value of the '{@link #getContributions() <em>Contributions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributions()
	 * @generated
	 * @ordered
	 */
	protected EList<Contribution> contributions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IstarPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntentionalElement> getIntentionalElements() {
		if (intentionalElements == null) {
			intentionalElements = new EObjectContainmentEList<IntentionalElement>(IntentionalElement.class, this, IstarPackage.ACTOR__INTENTIONAL_ELEMENTS);
		}
		return intentionalElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependenciesAsDepender() {
		if (dependenciesAsDepender == null) {
			dependenciesAsDepender = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER, IstarPackage.DEPENDENCY__DEPENDER);
		}
		return dependenciesAsDepender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependenciesAsDependee() {
		if (dependenciesAsDependee == null) {
			dependenciesAsDependee = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE, IstarPackage.DEPENDENCY__DEPENDEE);
		}
		return dependenciesAsDependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contribution> getContributions() {
		if (contributions == null) {
			contributions = new EObjectContainmentEList<Contribution>(Contribution.class, this, IstarPackage.ACTOR__CONTRIBUTIONS);
		}
		return contributions;
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
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDepender()).basicAdd(otherEnd, msgs);
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDependee()).basicAdd(otherEnd, msgs);
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
			case IstarPackage.ACTOR__INTENTIONAL_ELEMENTS:
				return ((InternalEList<?>)getIntentionalElements()).basicRemove(otherEnd, msgs);
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER:
				return ((InternalEList<?>)getDependenciesAsDepender()).basicRemove(otherEnd, msgs);
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE:
				return ((InternalEList<?>)getDependenciesAsDependee()).basicRemove(otherEnd, msgs);
			case IstarPackage.ACTOR__CONTRIBUTIONS:
				return ((InternalEList<?>)getContributions()).basicRemove(otherEnd, msgs);
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
			case IstarPackage.ACTOR__INTENTIONAL_ELEMENTS:
				return getIntentionalElements();
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER:
				return getDependenciesAsDepender();
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE:
				return getDependenciesAsDependee();
			case IstarPackage.ACTOR__CONTRIBUTIONS:
				return getContributions();
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
			case IstarPackage.ACTOR__INTENTIONAL_ELEMENTS:
				getIntentionalElements().clear();
				getIntentionalElements().addAll((Collection<? extends IntentionalElement>)newValue);
				return;
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER:
				getDependenciesAsDepender().clear();
				getDependenciesAsDepender().addAll((Collection<? extends Dependency>)newValue);
				return;
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE:
				getDependenciesAsDependee().clear();
				getDependenciesAsDependee().addAll((Collection<? extends Dependency>)newValue);
				return;
			case IstarPackage.ACTOR__CONTRIBUTIONS:
				getContributions().clear();
				getContributions().addAll((Collection<? extends Contribution>)newValue);
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
			case IstarPackage.ACTOR__INTENTIONAL_ELEMENTS:
				getIntentionalElements().clear();
				return;
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER:
				getDependenciesAsDepender().clear();
				return;
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE:
				getDependenciesAsDependee().clear();
				return;
			case IstarPackage.ACTOR__CONTRIBUTIONS:
				getContributions().clear();
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
			case IstarPackage.ACTOR__INTENTIONAL_ELEMENTS:
				return intentionalElements != null && !intentionalElements.isEmpty();
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER:
				return dependenciesAsDepender != null && !dependenciesAsDepender.isEmpty();
			case IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE:
				return dependenciesAsDependee != null && !dependenciesAsDependee.isEmpty();
			case IstarPackage.ACTOR__CONTRIBUTIONS:
				return contributions != null && !contributions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActorImpl
