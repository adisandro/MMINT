/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mavo.impl.MAVOElementImpl;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink;
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
 * An implementation of the model object '<em><b>Depender Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerLinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerLinkImpl#getDepender <em>Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerLinkImpl#getDependum <em>Dependum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependerLinkImpl extends MAVOElementImpl implements DependerLink {
	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)IStar_MAVOPackage.Literals.DEPENDER_LINK__NAME).getSettingDelegate();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependerLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IStar_MAVOPackage.Literals.DEPENDER_LINK;
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
	public DependencyEndpoint getDepender() {
		if (depender != null && depender.eIsProxy()) {
			InternalEObject oldDepender = (InternalEObject)depender;
			depender = (DependencyEndpoint)eResolveProxy(oldDepender);
			if (depender != oldDepender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IStar_MAVOPackage.DEPENDER_LINK__DEPENDER, oldDepender, depender));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.DEPENDER_LINK__DEPENDER, oldDepender, newDepender);
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
				msgs = ((InternalEObject)depender).eInverseRemove(this, IStar_MAVOPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER, DependencyEndpoint.class, msgs);
			if (newDepender != null)
				msgs = ((InternalEObject)newDepender).eInverseAdd(this, IStar_MAVOPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER, DependencyEndpoint.class, msgs);
			msgs = basicSetDepender(newDepender, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.DEPENDER_LINK__DEPENDER, newDepender, newDepender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intention getDependum() {
		if (eContainerFeatureID() != IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM) return null;
		return (Intention)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependum(Intention newDependum, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDependum, IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependum(Intention newDependum) {
		if (newDependum != eInternalContainer() || (eContainerFeatureID() != IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM && newDependum != null)) {
			if (EcoreUtil.isAncestor(this, newDependum))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDependum != null)
				msgs = ((InternalEObject)newDependum).eInverseAdd(this, IStar_MAVOPackage.INTENTION__DEPENDER_LINKS, Intention.class, msgs);
			msgs = basicSetDependum(newDependum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM, newDependum, newDependum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDER:
				if (depender != null)
					msgs = ((InternalEObject)depender).eInverseRemove(this, IStar_MAVOPackage.DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER, DependencyEndpoint.class, msgs);
				return basicSetDepender((DependencyEndpoint)otherEnd, msgs);
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDependum((Intention)otherEnd, msgs);
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
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDER:
				return basicSetDepender(null, msgs);
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM:
				return eInternalContainer().eInverseRemove(this, IStar_MAVOPackage.INTENTION__DEPENDER_LINKS, Intention.class, msgs);
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
			case IStar_MAVOPackage.DEPENDER_LINK__NAME:
				return getName();
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDER:
				if (resolve) return getDepender();
				return basicGetDepender();
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM:
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
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDER:
				setDepender((DependencyEndpoint)newValue);
				return;
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM:
				setDependum((Intention)newValue);
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
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDER:
				setDepender((DependencyEndpoint)null);
				return;
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM:
				setDependum((Intention)null);
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
			case IStar_MAVOPackage.DEPENDER_LINK__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDER:
				return depender != null;
			case IStar_MAVOPackage.DEPENDER_LINK__DEPENDUM:
				return getDependum() != null;
		}
		return super.eIsSet(featureID);
	}

} //DependerLinkImpl
