/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.impl;

import edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl;

import edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependee Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeLinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeLinkImpl#getDependum <em>Dependum</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeLinkImpl#getDependee <em>Dependee</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependeeLinkImpl extends MAVOElementImpl implements DependeeLink {
	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)IStar_MAVOPackage.Literals.DEPENDEE_LINK__NAME).getSettingDelegate();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependeeLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IStar_MAVOPackage.Literals.DEPENDEE_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)NAME__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intention getDependum() {
		if (eContainerFeatureID() != IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM) return null;
		return (Intention)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependum(Intention newDependum, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDependum, IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependum(Intention newDependum) {
		if (newDependum != eInternalContainer() || (eContainerFeatureID() != IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM && newDependum != null)) {
			if (EcoreUtil.isAncestor(this, newDependum))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDependum != null)
				msgs = ((InternalEObject)newDependum).eInverseAdd(this, IStar_MAVOPackage.INTENTION__DEPENDEE_LINKS, Intention.class, msgs);
			msgs = basicSetDependum(newDependum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM, newDependum, newDependum));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE, oldDependee, dependee));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE, oldDependee, newDependee);
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
				msgs = ((InternalEObject)dependee).eInverseRemove(this, IStar_MAVOPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE, DependencyEndpoint.class, msgs);
			if (newDependee != null)
				msgs = ((InternalEObject)newDependee).eInverseAdd(this, IStar_MAVOPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE, DependencyEndpoint.class, msgs);
			msgs = basicSetDependee(newDependee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE, newDependee, newDependee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDependum((Intention)otherEnd, msgs);
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE:
				if (dependee != null)
					msgs = ((InternalEObject)dependee).eInverseRemove(this, IStar_MAVOPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE, DependencyEndpoint.class, msgs);
				return basicSetDependee((DependencyEndpoint)otherEnd, msgs);
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
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM:
				return basicSetDependum(null, msgs);
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE:
				return basicSetDependee(null, msgs);
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
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM:
				return eInternalContainer().eInverseRemove(this, IStar_MAVOPackage.INTENTION__DEPENDEE_LINKS, Intention.class, msgs);
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
			case IStar_MAVOPackage.DEPENDEE_LINK__NAME:
				return getName();
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM:
				return getDependum();
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE:
				if (resolve) return getDependee();
				return basicGetDependee();
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
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM:
				setDependum((Intention)newValue);
				return;
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE:
				setDependee((DependencyEndpoint)newValue);
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
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM:
				setDependum((Intention)null);
				return;
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE:
				setDependee((DependencyEndpoint)null);
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
			case IStar_MAVOPackage.DEPENDEE_LINK__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDUM:
				return getDependum() != null;
			case IStar_MAVOPackage.DEPENDEE_LINK__DEPENDEE:
				return dependee != null;
		}
		return super.eIsSet(featureID);
	}

} //DependeeLinkImpl
