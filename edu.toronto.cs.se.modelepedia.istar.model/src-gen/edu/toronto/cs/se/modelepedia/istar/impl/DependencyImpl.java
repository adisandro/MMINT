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
import edu.toronto.cs.se.modelepedia.istar.Dependency;
import edu.toronto.cs.se.modelepedia.istar.IntentionalElement;
import edu.toronto.cs.se.modelepedia.istar.IstarPackage;

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
	protected Actor depender;

	/**
	 * The cached value of the '{@link #getDependee() <em>Dependee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependee()
	 * @generated
	 * @ordered
	 */
	protected Actor dependee;

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
		return IstarPackage.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getDepender() {
		if (depender != null && depender.eIsProxy()) {
			InternalEObject oldDepender = (InternalEObject)depender;
			depender = (Actor)eResolveProxy(oldDepender);
			if (depender != oldDepender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IstarPackage.DEPENDENCY__DEPENDER, oldDepender, depender));
			}
		}
		return depender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetDepender() {
		return depender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepender(Actor newDepender, NotificationChain msgs) {
		Actor oldDepender = depender;
		depender = newDepender;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IstarPackage.DEPENDENCY__DEPENDER, oldDepender, newDepender);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepender(Actor newDepender) {
		if (newDepender != depender) {
			NotificationChain msgs = null;
			if (depender != null)
				msgs = ((InternalEObject)depender).eInverseRemove(this, IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER, Actor.class, msgs);
			if (newDepender != null)
				msgs = ((InternalEObject)newDepender).eInverseAdd(this, IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER, Actor.class, msgs);
			msgs = basicSetDepender(newDepender, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.DEPENDENCY__DEPENDER, newDepender, newDepender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getDependee() {
		if (dependee != null && dependee.eIsProxy()) {
			InternalEObject oldDependee = (InternalEObject)dependee;
			dependee = (Actor)eResolveProxy(oldDependee);
			if (dependee != oldDependee) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IstarPackage.DEPENDENCY__DEPENDEE, oldDependee, dependee));
			}
		}
		return dependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetDependee() {
		return dependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependee(Actor newDependee, NotificationChain msgs) {
		Actor oldDependee = dependee;
		dependee = newDependee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IstarPackage.DEPENDENCY__DEPENDEE, oldDependee, newDependee);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependee(Actor newDependee) {
		if (newDependee != dependee) {
			NotificationChain msgs = null;
			if (dependee != null)
				msgs = ((InternalEObject)dependee).eInverseRemove(this, IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE, Actor.class, msgs);
			if (newDependee != null)
				msgs = ((InternalEObject)newDependee).eInverseAdd(this, IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE, Actor.class, msgs);
			msgs = basicSetDependee(newDependee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.DEPENDENCY__DEPENDEE, newDependee, newDependee));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IstarPackage.DEPENDENCY__DEPENDUM, oldDependum, newDependum);
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
				msgs = ((InternalEObject)dependum).eInverseRemove(this, IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY, IntentionalElement.class, msgs);
			if (newDependum != null)
				msgs = ((InternalEObject)newDependum).eInverseAdd(this, IstarPackage.INTENTIONAL_ELEMENT__DEPENDENCY, IntentionalElement.class, msgs);
			msgs = basicSetDependum(newDependum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IstarPackage.DEPENDENCY__DEPENDUM, newDependum, newDependum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IstarPackage.DEPENDENCY__DEPENDER:
				if (depender != null)
					msgs = ((InternalEObject)depender).eInverseRemove(this, IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDER, Actor.class, msgs);
				return basicSetDepender((Actor)otherEnd, msgs);
			case IstarPackage.DEPENDENCY__DEPENDEE:
				if (dependee != null)
					msgs = ((InternalEObject)dependee).eInverseRemove(this, IstarPackage.ACTOR__DEPENDENCIES_AS_DEPENDEE, Actor.class, msgs);
				return basicSetDependee((Actor)otherEnd, msgs);
			case IstarPackage.DEPENDENCY__DEPENDUM:
				if (dependum != null)
					msgs = ((InternalEObject)dependum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IstarPackage.DEPENDENCY__DEPENDUM, null, msgs);
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
			case IstarPackage.DEPENDENCY__DEPENDER:
				return basicSetDepender(null, msgs);
			case IstarPackage.DEPENDENCY__DEPENDEE:
				return basicSetDependee(null, msgs);
			case IstarPackage.DEPENDENCY__DEPENDUM:
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
			case IstarPackage.DEPENDENCY__DEPENDER:
				if (resolve) return getDepender();
				return basicGetDepender();
			case IstarPackage.DEPENDENCY__DEPENDEE:
				if (resolve) return getDependee();
				return basicGetDependee();
			case IstarPackage.DEPENDENCY__DEPENDUM:
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
			case IstarPackage.DEPENDENCY__DEPENDER:
				setDepender((Actor)newValue);
				return;
			case IstarPackage.DEPENDENCY__DEPENDEE:
				setDependee((Actor)newValue);
				return;
			case IstarPackage.DEPENDENCY__DEPENDUM:
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
			case IstarPackage.DEPENDENCY__DEPENDER:
				setDepender((Actor)null);
				return;
			case IstarPackage.DEPENDENCY__DEPENDEE:
				setDependee((Actor)null);
				return;
			case IstarPackage.DEPENDENCY__DEPENDUM:
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
			case IstarPackage.DEPENDENCY__DEPENDER:
				return depender != null;
			case IstarPackage.DEPENDENCY__DEPENDEE:
				return dependee != null;
			case IstarPackage.DEPENDENCY__DEPENDUM:
				return dependum != null;
		}
		return super.eIsSet(featureID);
	}

} //DependencyImpl
