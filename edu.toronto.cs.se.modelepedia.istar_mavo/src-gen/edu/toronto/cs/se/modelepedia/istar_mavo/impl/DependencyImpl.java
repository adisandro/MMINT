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

import edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl;

import edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference;
import edu.toronto.cs.se.modelepedia.istar_mavo.Dependency;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyImpl#getDepender <em>Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyImpl#getDependee <em>Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyImpl#getDependum <em>Dependum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependencyImpl extends MAVOElementImpl implements Dependency {
	/**
	 * The cached value of the '{@link #getDepender() <em>Depender</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepender()
	 * @generated
	 * @ordered
	 */
	protected EList<DependerReference> depender;

	/**
	 * The cached value of the '{@link #getDependee() <em>Dependee</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependee()
	 * @generated
	 * @ordered
	 */
	protected EList<DependeeReference> dependee;

	/**
	 * The cached value of the '{@link #getDependum() <em>Dependum</em>}' reference.
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
		return IStar_MAVOPackage.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependerReference> getDepender() {
		if (depender == null) {
			depender = new EObjectContainmentWithInverseEList<DependerReference>(DependerReference.class, this, IStar_MAVOPackage.DEPENDENCY__DEPENDER, IStar_MAVOPackage.DEPENDER_REFERENCE__SRC);
		}
		return depender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependeeReference> getDependee() {
		if (dependee == null) {
			dependee = new EObjectContainmentWithInverseEList<DependeeReference>(DependeeReference.class, this, IStar_MAVOPackage.DEPENDENCY__DEPENDEE, IStar_MAVOPackage.DEPENDEE_REFERENCE__SRC);
		}
		return dependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentionalElement getDependum() {
		if (dependum != null && dependum.eIsProxy()) {
			InternalEObject oldDependum = (InternalEObject)dependum;
			dependum = (IntentionalElement)eResolveProxy(oldDependum);
			if (dependum != oldDependum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IStar_MAVOPackage.DEPENDENCY__DEPENDUM, oldDependum, dependum));
			}
		}
		return dependum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentionalElement basicGetDependum() {
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.DEPENDENCY__DEPENDUM, oldDependum, newDependum);
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
				msgs = ((InternalEObject)dependum).eInverseRemove(this, IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY, IntentionalElement.class, msgs);
			if (newDependum != null)
				msgs = ((InternalEObject)newDependum).eInverseAdd(this, IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY, IntentionalElement.class, msgs);
			msgs = basicSetDependum(newDependum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.DEPENDENCY__DEPENDUM, newDependum, newDependum));
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
			case IStar_MAVOPackage.DEPENDENCY__DEPENDER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDepender()).basicAdd(otherEnd, msgs);
			case IStar_MAVOPackage.DEPENDENCY__DEPENDEE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependee()).basicAdd(otherEnd, msgs);
			case IStar_MAVOPackage.DEPENDENCY__DEPENDUM:
				if (dependum != null)
					msgs = ((InternalEObject)dependum).eInverseRemove(this, IStar_MAVOPackage.INTENTIONAL_ELEMENT__DEPENDENCY, IntentionalElement.class, msgs);
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
			case IStar_MAVOPackage.DEPENDENCY__DEPENDER:
				return ((InternalEList<?>)getDepender()).basicRemove(otherEnd, msgs);
			case IStar_MAVOPackage.DEPENDENCY__DEPENDEE:
				return ((InternalEList<?>)getDependee()).basicRemove(otherEnd, msgs);
			case IStar_MAVOPackage.DEPENDENCY__DEPENDUM:
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
			case IStar_MAVOPackage.DEPENDENCY__DEPENDER:
				return getDepender();
			case IStar_MAVOPackage.DEPENDENCY__DEPENDEE:
				return getDependee();
			case IStar_MAVOPackage.DEPENDENCY__DEPENDUM:
				if (resolve) return getDependum();
				return basicGetDependum();
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
			case IStar_MAVOPackage.DEPENDENCY__DEPENDER:
				getDepender().clear();
				getDepender().addAll((Collection<? extends DependerReference>)newValue);
				return;
			case IStar_MAVOPackage.DEPENDENCY__DEPENDEE:
				getDependee().clear();
				getDependee().addAll((Collection<? extends DependeeReference>)newValue);
				return;
			case IStar_MAVOPackage.DEPENDENCY__DEPENDUM:
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
			case IStar_MAVOPackage.DEPENDENCY__DEPENDER:
				getDepender().clear();
				return;
			case IStar_MAVOPackage.DEPENDENCY__DEPENDEE:
				getDependee().clear();
				return;
			case IStar_MAVOPackage.DEPENDENCY__DEPENDUM:
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
			case IStar_MAVOPackage.DEPENDENCY__DEPENDER:
				return depender != null && !depender.isEmpty();
			case IStar_MAVOPackage.DEPENDENCY__DEPENDEE:
				return dependee != null && !dependee.isEmpty();
			case IStar_MAVOPackage.DEPENDENCY__DEPENDUM:
				return dependum != null;
		}
		return super.eIsSet(featureID);
	}

} //DependencyImpl
