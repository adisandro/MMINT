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
package edu.toronto.cs.se.modelepedia.istar_mavo.impl;

import edu.toronto.cs.se.modelepedia.istar_mavo.ComponentsReference;
import edu.toronto.cs.se.modelepedia.istar_mavo.Contribution;
import edu.toronto.cs.se.modelepedia.istar_mavo.Dependency;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intentional Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl#getComposite <em>Composite</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl#getContributionsAsContributor <em>Contributions As Contributor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntentionalElementImpl extends DependencyEndpointImpl implements IntentionalElement {
	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependencies;

	/**
	 * The cached value of the '{@link #getComposite() <em>Composite</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposite()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentsReference> composite;

	/**
	 * The cached value of the '{@link #getContributionsAsContributor() <em>Contributions As Contributor</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributionsAsContributor()
	 * @generated
	 * @ordered
	 */
	protected EList<Contribution> contributionsAsContributor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntentionalElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IStar_MAVOPackage.Literals.INTENTIONAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCIES, IStar_MAVOPackage.DEPENDENCY__DEPENDUM);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentsReference> getComposite() {
		if (composite == null) {
			composite = new EObjectWithInverseResolvingEList<ComponentsReference>(ComponentsReference.class, this, IStar_MAVOPackage.INTENTIONAL_ELEMENT__COMPOSITE, IStar_MAVOPackage.COMPONENTS_REFERENCE__TGT);
		}
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contribution> getContributionsAsContributor() {
		if (contributionsAsContributor == null) {
			contributionsAsContributor = new EObjectWithInverseResolvingEList<Contribution>(Contribution.class, this, IStar_MAVOPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR, IStar_MAVOPackage.CONTRIBUTION__CONTRIBUTOR);
		}
		return contributionsAsContributor;
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependencies()).basicAdd(otherEnd, msgs);
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComposite()).basicAdd(otherEnd, msgs);
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContributionsAsContributor()).basicAdd(otherEnd, msgs);
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return ((InternalEList<?>)getComposite()).basicRemove(otherEnd, msgs);
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return ((InternalEList<?>)getContributionsAsContributor()).basicRemove(otherEnd, msgs);
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				return getDependencies();
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return getComposite();
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return getContributionsAsContributor();
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Dependency>)newValue);
				return;
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				getComposite().clear();
				getComposite().addAll((Collection<? extends ComponentsReference>)newValue);
				return;
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				getContributionsAsContributor().clear();
				getContributionsAsContributor().addAll((Collection<? extends Contribution>)newValue);
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				getDependencies().clear();
				return;
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				getComposite().clear();
				return;
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				getContributionsAsContributor().clear();
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return composite != null && !composite.isEmpty();
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return contributionsAsContributor != null && !contributionsAsContributor.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IntentionalElementImpl
