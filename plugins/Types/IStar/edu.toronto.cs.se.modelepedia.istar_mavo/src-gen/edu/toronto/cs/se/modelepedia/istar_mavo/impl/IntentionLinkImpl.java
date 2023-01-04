/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;
import edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intention Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionLinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionLinkImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionLinkImpl#getTgt <em>Tgt</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntentionLinkImpl extends MAVOElementImpl implements IntentionLink {
	/**
	 * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)IStar_MAVOPackage.Literals.INTENTION_LINK__NAME).getSettingDelegate();

	/**
	 * The cached value of the '{@link #getTgt() <em>Tgt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTgt()
	 * @generated
	 * @ordered
	 */
	protected Intention tgt;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntentionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IStar_MAVOPackage.Literals.INTENTION_LINK;
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
	public Intention getSrc() {
		if (eContainerFeatureID() != IStar_MAVOPackage.INTENTION_LINK__SRC) return null;
		return (Intention)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSrc(Intention newSrc, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSrc, IStar_MAVOPackage.INTENTION_LINK__SRC, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc(Intention newSrc) {
		if (newSrc != eInternalContainer() || (eContainerFeatureID() != IStar_MAVOPackage.INTENTION_LINK__SRC && newSrc != null)) {
			if (EcoreUtil.isAncestor(this, newSrc))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSrc != null)
				msgs = ((InternalEObject)newSrc).eInverseAdd(this, IStar_MAVOPackage.INTENTION__LINKS_AS_SRC, Intention.class, msgs);
			msgs = basicSetSrc(newSrc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.INTENTION_LINK__SRC, newSrc, newSrc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intention getTgt() {
		if (tgt != null && tgt.eIsProxy()) {
			InternalEObject oldTgt = (InternalEObject)tgt;
			tgt = (Intention)eResolveProxy(oldTgt);
			if (tgt != oldTgt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IStar_MAVOPackage.INTENTION_LINK__TGT, oldTgt, tgt));
			}
		}
		return tgt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intention basicGetTgt() {
		return tgt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTgt(Intention newTgt, NotificationChain msgs) {
		Intention oldTgt = tgt;
		tgt = newTgt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.INTENTION_LINK__TGT, oldTgt, newTgt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTgt(Intention newTgt) {
		if (newTgt != tgt) {
			NotificationChain msgs = null;
			if (tgt != null)
				msgs = ((InternalEObject)tgt).eInverseRemove(this, IStar_MAVOPackage.INTENTION__LINKS_AS_TGT, Intention.class, msgs);
			if (newTgt != null)
				msgs = ((InternalEObject)newTgt).eInverseAdd(this, IStar_MAVOPackage.INTENTION__LINKS_AS_TGT, Intention.class, msgs);
			msgs = basicSetTgt(newTgt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IStar_MAVOPackage.INTENTION_LINK__TGT, newTgt, newTgt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IStar_MAVOPackage.INTENTION_LINK__SRC:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSrc((Intention)otherEnd, msgs);
			case IStar_MAVOPackage.INTENTION_LINK__TGT:
				if (tgt != null)
					msgs = ((InternalEObject)tgt).eInverseRemove(this, IStar_MAVOPackage.INTENTION__LINKS_AS_TGT, Intention.class, msgs);
				return basicSetTgt((Intention)otherEnd, msgs);
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
			case IStar_MAVOPackage.INTENTION_LINK__SRC:
				return basicSetSrc(null, msgs);
			case IStar_MAVOPackage.INTENTION_LINK__TGT:
				return basicSetTgt(null, msgs);
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
			case IStar_MAVOPackage.INTENTION_LINK__SRC:
				return eInternalContainer().eInverseRemove(this, IStar_MAVOPackage.INTENTION__LINKS_AS_SRC, Intention.class, msgs);
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
			case IStar_MAVOPackage.INTENTION_LINK__NAME:
				return getName();
			case IStar_MAVOPackage.INTENTION_LINK__SRC:
				return getSrc();
			case IStar_MAVOPackage.INTENTION_LINK__TGT:
				if (resolve) return getTgt();
				return basicGetTgt();
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
			case IStar_MAVOPackage.INTENTION_LINK__SRC:
				setSrc((Intention)newValue);
				return;
			case IStar_MAVOPackage.INTENTION_LINK__TGT:
				setTgt((Intention)newValue);
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
			case IStar_MAVOPackage.INTENTION_LINK__SRC:
				setSrc((Intention)null);
				return;
			case IStar_MAVOPackage.INTENTION_LINK__TGT:
				setTgt((Intention)null);
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
			case IStar_MAVOPackage.INTENTION_LINK__NAME:
				return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case IStar_MAVOPackage.INTENTION_LINK__SRC:
				return getSrc() != null;
			case IStar_MAVOPackage.INTENTION_LINK__TGT:
				return tgt != null;
		}
		return super.eIsSet(featureID);
	}

} //IntentionLinkImpl
