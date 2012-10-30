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

import edu.toronto.cs.se.modelepedia.istar.Dependency;
import edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.IntentionalElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.DependencyImpl#getDepender <em>Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.DependencyImpl#getDependee <em>Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.DependencyImpl#getDependum <em>Dependum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependencyImpl extends EObjectImpl implements Dependency {
	/**
	 * The cached value of the '{@link #getDepender() <em>Depender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepender()
	 * @generated
	 * @ordered
	 */
	protected DependencyEndpoint depender;

	/**
	 * The cached value of the '{@link #getDependee() <em>Dependee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependee()
	 * @generated
	 * @ordered
	 */
	protected DependencyEndpoint dependee;

	/**
	 * The cached value of the '{@link #getDependum() <em>Dependum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependum()
	 * @generated
	 * @ordered
	 */
	protected IntentionalElement dependum;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IStarPackage.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyEndpoint getDepender() {
		if (depender != null && depender.eIsProxy()) {
			InternalEObject oldDepender = (InternalEObject)depender;
			depender = (DependencyEndpoint)eResolveProxy(oldDepender);
			if (depender != oldDepender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IStarPackage.DEPENDENCY__DEPENDER, oldDepender, depender));
			}
		}
		return depender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyEndpoint basicGetDepender() {
		return depender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepender(DependencyEndpoint newDepender, NotificationChain msgs) {
		DependencyEndpoint oldDepender = depender;
		depender = newDepender;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStarPackage.DEPENDENCY__DEPENDER, oldDepender, newDepender);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepender(DependencyEndpoint newDepender) {
		if (newDepender != depender) {
			NotificationChain msgs = null;
			if (depender != null)
				msgs = ((InternalEObject)depender).eInverseRemove(this, IStarPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER, DependencyEndpoint.class, msgs);
			if (newDepender != null)
				msgs = ((InternalEObject)newDepender).eInverseAdd(this, IStarPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER, DependencyEndpoint.class, msgs);
			msgs = basicSetDepender(newDepender, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.DEPENDENCY__DEPENDER, newDepender, newDepender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyEndpoint getDependee() {
		if (dependee != null && dependee.eIsProxy()) {
			InternalEObject oldDependee = (InternalEObject)dependee;
			dependee = (DependencyEndpoint)eResolveProxy(oldDependee);
			if (dependee != oldDependee) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IStarPackage.DEPENDENCY__DEPENDEE, oldDependee, dependee));
			}
		}
		return dependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyEndpoint basicGetDependee() {
		return dependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependee(DependencyEndpoint newDependee, NotificationChain msgs) {
		DependencyEndpoint oldDependee = dependee;
		dependee = newDependee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStarPackage.DEPENDENCY__DEPENDEE, oldDependee, newDependee);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependee(DependencyEndpoint newDependee) {
		if (newDependee != dependee) {
			NotificationChain msgs = null;
			if (dependee != null)
				msgs = ((InternalEObject)dependee).eInverseRemove(this, IStarPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE, DependencyEndpoint.class, msgs);
			if (newDependee != null)
				msgs = ((InternalEObject)newDependee).eInverseAdd(this, IStarPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE, DependencyEndpoint.class, msgs);
			msgs = basicSetDependee(newDependee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.DEPENDENCY__DEPENDEE, newDependee, newDependee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentionalElement getDependum() {
		return dependum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependum(IntentionalElement newDependum, NotificationChain msgs) {
		IntentionalElement oldDependum = dependum;
		dependum = newDependum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStarPackage.DEPENDENCY__DEPENDUM, oldDependum, newDependum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependum(IntentionalElement newDependum) {
		if (newDependum != dependum) {
			NotificationChain msgs = null;
			if (dependum != null)
				msgs = ((InternalEObject)dependum).eInverseRemove(this, IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCY, IntentionalElement.class, msgs);
			if (newDependum != null)
				msgs = ((InternalEObject)newDependum).eInverseAdd(this, IStarPackage.INTENTIONAL_ELEMENT__DEPENDENCY, IntentionalElement.class, msgs);
			msgs = basicSetDependum(newDependum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStarPackage.DEPENDENCY__DEPENDUM, newDependum, newDependum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IStarPackage.DEPENDENCY__DEPENDER:
				if (depender != null)
					msgs = ((InternalEObject)depender).eInverseRemove(this, IStarPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER, DependencyEndpoint.class, msgs);
				return basicSetDepender((DependencyEndpoint)otherEnd, msgs);
			case IStarPackage.DEPENDENCY__DEPENDEE:
				if (dependee != null)
					msgs = ((InternalEObject)dependee).eInverseRemove(this, IStarPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE, DependencyEndpoint.class, msgs);
				return basicSetDependee((DependencyEndpoint)otherEnd, msgs);
			case IStarPackage.DEPENDENCY__DEPENDUM:
				if (dependum != null)
					msgs = ((InternalEObject)dependum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IStarPackage.DEPENDENCY__DEPENDUM, null, msgs);
				return basicSetDependum((IntentionalElement)otherEnd, msgs);
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
			case IStarPackage.DEPENDENCY__DEPENDER:
				return basicSetDepender(null, msgs);
			case IStarPackage.DEPENDENCY__DEPENDEE:
				return basicSetDependee(null, msgs);
			case IStarPackage.DEPENDENCY__DEPENDUM:
				return basicSetDependum(null, msgs);
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
			case IStarPackage.DEPENDENCY__DEPENDER:
				if (resolve) return getDepender();
				return basicGetDepender();
			case IStarPackage.DEPENDENCY__DEPENDEE:
				if (resolve) return getDependee();
				return basicGetDependee();
			case IStarPackage.DEPENDENCY__DEPENDUM:
				return getDependum();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IStarPackage.DEPENDENCY__DEPENDER:
				setDepender((DependencyEndpoint)newValue);
				return;
			case IStarPackage.DEPENDENCY__DEPENDEE:
				setDependee((DependencyEndpoint)newValue);
				return;
			case IStarPackage.DEPENDENCY__DEPENDUM:
				setDependum((IntentionalElement)newValue);
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
			case IStarPackage.DEPENDENCY__DEPENDER:
				setDepender((DependencyEndpoint)null);
				return;
			case IStarPackage.DEPENDENCY__DEPENDEE:
				setDependee((DependencyEndpoint)null);
				return;
			case IStarPackage.DEPENDENCY__DEPENDUM:
				setDependum((IntentionalElement)null);
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
			case IStarPackage.DEPENDENCY__DEPENDER:
				return depender != null;
			case IStarPackage.DEPENDENCY__DEPENDEE:
				return dependee != null;
			case IStarPackage.DEPENDENCY__DEPENDUM:
				return dependum != null;
		}
		return super.eIsSet(featureID);
	}

} //DependencyImpl
