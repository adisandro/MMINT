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

import edu.toronto.cs.se.modelepedia.istar.Contribution;
import edu.toronto.cs.se.modelepedia.istar.Dependency;
import edu.toronto.cs.se.modelepedia.istar.IntentionalElement;
import edu.toronto.cs.se.modelepedia.istar.IstarPackage;
import edu.toronto.cs.se.modelepedia.istar.Task;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intentional Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#getDependency <em>Dependency</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#getComposite <em>Composite</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl#getContributionsAsContributor <em>Contributions As Contributor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IntentionalElementImpl extends EObjectImpl implements IntentionalElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComposite() <em>Composite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposite()
	 * @generated
	 * @ordered
	 */
	protected Task composite;

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
		return IstarPackage.Literals.INTENTIONAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency getDependency() {
		if (eContainerFeatureID() != IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY) return null;
		return (Dependency)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependency(Dependency newDependency, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDependency, IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependency(Dependency newDependency) {
		if (newDependency != eInternalContainer() || (eContainerFeatureID() != IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY && newDependency != null)) {
			if (EcoreUtil.isAncestor(this, newDependency))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDependency != null)
				msgs = ((InternalEObject)newDependency).eInverseAdd(this, IstarPackage.DEPENDENCY__DEPENDUM, Dependency.class, msgs);
			msgs = basicSetDependency(newDependency, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY, newDependency, newDependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.INTENTIONAL_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getComposite() {
		if (composite != null && composite.eIsProxy()) {
			InternalEObject oldComposite = (InternalEObject)composite;
			composite = (Task)eResolveProxy(oldComposite);
			if (composite != oldComposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE, oldComposite, composite));
			}
		}
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task basicGetComposite() {
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComposite(Task newComposite, NotificationChain msgs) {
		Task oldComposite = composite;
		composite = newComposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE, oldComposite, newComposite);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposite(Task newComposite) {
		if (newComposite != composite) {
			NotificationChain msgs = null;
			if (composite != null)
				msgs = ((InternalEObject)composite).eInverseRemove(this, IstarPackage.TASK__COMPONENTS, Task.class, msgs);
			if (newComposite != null)
				msgs = ((InternalEObject)newComposite).eInverseAdd(this, IstarPackage.TASK__COMPONENTS, Task.class, msgs);
			msgs = basicSetComposite(newComposite, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE, newComposite, newComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contribution> getContributionsAsContributor() {
		if (contributionsAsContributor == null) {
			contributionsAsContributor = new EObjectWithInverseResolvingEList<Contribution>(Contribution.class, this, IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR, IstarPackage.CONTRIBUTION__CONTRIBUTOR);
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
			case IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDependency((Dependency)otherEnd, msgs);
			case IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				if (composite != null)
					msgs = ((InternalEObject)composite).eInverseRemove(this, IstarPackage.TASK__COMPONENTS, Task.class, msgs);
				return basicSetComposite((Task)otherEnd, msgs);
			case IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
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
			case IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				return basicSetDependency(null, msgs);
			case IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return basicSetComposite(null, msgs);
			case IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				return eInternalContainer().eInverseRemove(this, IstarPackage.DEPENDENCY__DEPENDUM, Dependency.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				return getDependency();
			case IstarPackage.INTENTIONAL_ELEMENT__NAME:
				return getName();
			case IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				if (resolve) return getComposite();
				return basicGetComposite();
			case IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
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
			case IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				setDependency((Dependency)newValue);
				return;
			case IstarPackage.INTENTIONAL_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				setComposite((Task)newValue);
				return;
			case IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
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
			case IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				setDependency((Dependency)null);
				return;
			case IstarPackage.INTENTIONAL_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				setComposite((Task)null);
				return;
			case IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
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
			case IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY:
				return getDependency() != null;
			case IstarPackage.INTENTIONAL_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IstarPackage.INTENTIONAL_ELEMENT__COMPOSITE:
				return composite != null;
			case IstarPackage.INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR:
				return contributionsAsContributor != null && !contributionsAsContributor.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //IntentionalElementImpl
