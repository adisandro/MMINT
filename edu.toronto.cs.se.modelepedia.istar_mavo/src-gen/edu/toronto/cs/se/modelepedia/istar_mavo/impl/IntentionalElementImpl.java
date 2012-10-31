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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intentional Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl#getDependency <em>Dependency</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl#getComposite <em>Composite</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl#getContributionsAsContributor <em>Contributions As Contributor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntentionalElementImpl extends DependencyEndpointImpl implements IntentionalElement {
	/**
	 * The cached value of the '{@link #getDependency() <em>Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency dependency;

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
	public Dependency getDependency() {
		if (dependency != null && dependency.eIsProxy()) {
			InternalEObject oldDependency = (InternalEObject)dependency;
			dependency = (Dependency)eResolveProxy(oldDependency);
			if (dependency != oldDependency) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY, oldDependency, dependency));
			}
		}
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetDependency() {
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependency(Dependency newDependency, NotificationChain msgs) {
		Dependency oldDependency = dependency;
		dependency = newDependency;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY, oldDependency, newDependency);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependency(Dependency newDependency) {
		if (newDependency != dependency) {
			NotificationChain msgs = null;
			if (dependency != null)
				msgs = ((InternalEObject)dependency).eInverseRemove(this, IStar_MAVOPackage.DEPENDENCY__DEPENDUM, Dependency.class, msgs);
			if (newDependency != null)
				msgs = ((InternalEObject)newDependency).eInverseAdd(this, IStar_MAVOPackage.DEPENDENCY__DEPENDUM, Dependency.class, msgs);
			msgs = basicSetDependency(newDependency, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY, newDependency, newDependency));
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				if (dependency != null)
					msgs = ((InternalEObject)dependency).eInverseRemove(this, IStar_MAVOPackage.DEPENDENCY__DEPENDUM, Dependency.class, msgs);
				return basicSetDependency((Dependency)otherEnd, msgs);
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				return basicSetDependency(null, msgs);
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				if (resolve) return getDependency();
				return basicGetDependency();
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				setDependency((Dependency)newValue);
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				setDependency((Dependency)null);
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
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				return dependency != null;
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return composite != null && !composite.isEmpty();
			case IStar_MAVOPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return contributionsAsContributor != null && !contributionsAsContributor.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IntentionalElementImpl
