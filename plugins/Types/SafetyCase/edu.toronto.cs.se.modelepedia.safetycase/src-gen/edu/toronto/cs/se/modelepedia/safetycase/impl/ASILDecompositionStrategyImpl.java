/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedByDecomposable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ASIL Decomposition Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILDecompositionStrategyImpl#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILDecompositionStrategyImpl#getSupportedByIndependent <em>Supported By Independent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ASILDecompositionStrategyImpl extends StrategyImpl implements ASILDecompositionStrategy {
	/**
	 * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<SupportedByDecomposable> supportedBy;

	/**
	 * The cached value of the '{@link #getSupportedByIndependent() <em>Supported By Independent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedByIndependent()
	 * @generated
	 * @ordered
	 */
	protected SupportedByDecomposable supportedByIndependent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ASILDecompositionStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.ASIL_DECOMPOSITION_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupportedByDecomposable> getSupportedBy() {
		if (supportedBy == null) {
			supportedBy = new EObjectContainmentEList<SupportedByDecomposable>(SupportedByDecomposable.class, this, SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY);
		}
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportedByDecomposable getSupportedByIndependent() {
		if (supportedByIndependent != null && supportedByIndependent.eIsProxy()) {
			InternalEObject oldSupportedByIndependent = (InternalEObject)supportedByIndependent;
			supportedByIndependent = (SupportedByDecomposable)eResolveProxy(oldSupportedByIndependent);
			if (supportedByIndependent != oldSupportedByIndependent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY_INDEPENDENT, oldSupportedByIndependent, supportedByIndependent));
			}
		}
		return supportedByIndependent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportedByDecomposable basicGetSupportedByIndependent() {
		return supportedByIndependent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedByIndependent(SupportedByDecomposable newSupportedByIndependent) {
		SupportedByDecomposable oldSupportedByIndependent = supportedByIndependent;
		supportedByIndependent = newSupportedByIndependent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY_INDEPENDENT, oldSupportedByIndependent, supportedByIndependent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY:
				return ((InternalEList<?>)getSupportedBy()).basicRemove(otherEnd, msgs);
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
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY:
				return getSupportedBy();
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY_INDEPENDENT:
				if (resolve) return getSupportedByIndependent();
				return basicGetSupportedByIndependent();
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
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY:
				getSupportedBy().clear();
				getSupportedBy().addAll((Collection<? extends SupportedByDecomposable>)newValue);
				return;
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY_INDEPENDENT:
				setSupportedByIndependent((SupportedByDecomposable)newValue);
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
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY:
				getSupportedBy().clear();
				return;
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY_INDEPENDENT:
				setSupportedByIndependent((SupportedByDecomposable)null);
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
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY:
				return supportedBy != null && !supportedBy.isEmpty();
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY_INDEPENDENT:
				return supportedByIndependent != null;
		}
		return super.eIsSet(featureID);
	}

} //ASILDecompositionStrategyImpl
