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
package edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl;

import edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl;

import edu.toronto.cs.se.modelepedia.mavo.classdiagram.ClassdiagramPackage;
import edu.toronto.cs.se.modelepedia.mavo.classdiagram.Dependency;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.DependencyImpl#getDependee <em>Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.DependencyImpl#getDepender <em>Depender</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependencyImpl extends MAVOElementImpl implements Dependency {
	/**
	 * The cached value of the '{@link #getDependee() <em>Dependee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependee()
	 * @generated
	 * @ordered
	 */
	protected edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class dependee;

	/**
	 * The cached value of the '{@link #getDepender() <em>Depender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepender()
	 * @generated
	 * @ordered
	 */
	protected edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class depender;

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
		return ClassdiagramPackage.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class getDependee() {
		if (dependee != null && dependee.eIsProxy()) {
			InternalEObject oldDependee = (InternalEObject)dependee;
			dependee = (edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class)eResolveProxy(oldDependee);
			if (dependee != oldDependee) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramPackage.DEPENDENCY__DEPENDEE, oldDependee, dependee));
			}
		}
		return dependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class basicGetDependee() {
		return dependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependee(edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class newDependee, NotificationChain msgs) {
		edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class oldDependee = dependee;
		dependee = newDependee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.DEPENDENCY__DEPENDEE, oldDependee, newDependee);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependee(edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class newDependee) {
		if (newDependee != dependee) {
			NotificationChain msgs = null;
			if (dependee != null)
				msgs = ((InternalEObject)dependee).eInverseRemove(this, ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class.class, msgs);
			if (newDependee != null)
				msgs = ((InternalEObject)newDependee).eInverseAdd(this, ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class.class, msgs);
			msgs = basicSetDependee(newDependee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.DEPENDENCY__DEPENDEE, newDependee, newDependee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class getDepender() {
		if (depender != null && depender.eIsProxy()) {
			InternalEObject oldDepender = (InternalEObject)depender;
			depender = (edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class)eResolveProxy(oldDepender);
			if (depender != oldDepender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramPackage.DEPENDENCY__DEPENDER, oldDepender, depender));
			}
		}
		return depender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class basicGetDepender() {
		return depender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepender(edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class newDepender, NotificationChain msgs) {
		edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class oldDepender = depender;
		depender = newDepender;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.DEPENDENCY__DEPENDER, oldDepender, newDepender);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepender(edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class newDepender) {
		if (newDepender != depender) {
			NotificationChain msgs = null;
			if (depender != null)
				msgs = ((InternalEObject)depender).eInverseRemove(this, ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER, edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class.class, msgs);
			if (newDepender != null)
				msgs = ((InternalEObject)newDepender).eInverseAdd(this, ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER, edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class.class, msgs);
			msgs = basicSetDepender(newDepender, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.DEPENDENCY__DEPENDER, newDepender, newDepender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramPackage.DEPENDENCY__DEPENDEE:
				if (dependee != null)
					msgs = ((InternalEObject)dependee).eInverseRemove(this, ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class.class, msgs);
				return basicSetDependee((edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class)otherEnd, msgs);
			case ClassdiagramPackage.DEPENDENCY__DEPENDER:
				if (depender != null)
					msgs = ((InternalEObject)depender).eInverseRemove(this, ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER, edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class.class, msgs);
				return basicSetDepender((edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class)otherEnd, msgs);
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
			case ClassdiagramPackage.DEPENDENCY__DEPENDEE:
				return basicSetDependee(null, msgs);
			case ClassdiagramPackage.DEPENDENCY__DEPENDER:
				return basicSetDepender(null, msgs);
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
			case ClassdiagramPackage.DEPENDENCY__DEPENDEE:
				if (resolve) return getDependee();
				return basicGetDependee();
			case ClassdiagramPackage.DEPENDENCY__DEPENDER:
				if (resolve) return getDepender();
				return basicGetDepender();
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
			case ClassdiagramPackage.DEPENDENCY__DEPENDEE:
				setDependee((edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class)newValue);
				return;
			case ClassdiagramPackage.DEPENDENCY__DEPENDER:
				setDepender((edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class)newValue);
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
			case ClassdiagramPackage.DEPENDENCY__DEPENDEE:
				setDependee((edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class)null);
				return;
			case ClassdiagramPackage.DEPENDENCY__DEPENDER:
				setDepender((edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class)null);
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
			case ClassdiagramPackage.DEPENDENCY__DEPENDEE:
				return dependee != null;
			case ClassdiagramPackage.DEPENDENCY__DEPENDER:
				return depender != null;
		}
		return super.eIsSet(featureID);
	}

} //DependencyImpl
