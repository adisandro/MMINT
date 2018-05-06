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

import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.StrategySupportedBy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Strategy Supported By</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StrategySupportedByImpl#getConclusion <em>Conclusion</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StrategySupportedByImpl#getPremise <em>Premise</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StrategySupportedByImpl extends SupportedByImpl implements StrategySupportedBy {
	/**
	 * The cached value of the '{@link #getPremise() <em>Premise</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremise()
	 * @generated
	 * @ordered
	 */
	protected CoreElement premise;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StrategySupportedByImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.STRATEGY_SUPPORTED_BY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy getConclusion() {
		if (eContainerFeatureID() != SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION) return null;
		return (Strategy)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConclusion(Strategy newConclusion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConclusion, SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConclusion(Strategy newConclusion) {
		if (newConclusion != eInternalContainer() || (eContainerFeatureID() != SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION && newConclusion != null)) {
			if (EcoreUtil.isAncestor(this, newConclusion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConclusion != null)
				msgs = ((InternalEObject)newConclusion).eInverseAdd(this, SafetyCasePackage.STRATEGY__SUPPORTED_BY, Strategy.class, msgs);
			msgs = basicSetConclusion(newConclusion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION, newConclusion, newConclusion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreElement getPremise() {
		if (premise != null && premise.eIsProxy()) {
			InternalEObject oldPremise = (InternalEObject)premise;
			premise = (CoreElement)eResolveProxy(oldPremise);
			if (premise != oldPremise) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyCasePackage.STRATEGY_SUPPORTED_BY__PREMISE, oldPremise, premise));
			}
		}
		return premise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreElement basicGetPremise() {
		return premise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremise(CoreElement newPremise) {
		CoreElement oldPremise = premise;
		premise = newPremise;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.STRATEGY_SUPPORTED_BY__PREMISE, oldPremise, premise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConclusion((Strategy)otherEnd, msgs);
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
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION:
				return basicSetConclusion(null, msgs);
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
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION:
				return eInternalContainer().eInverseRemove(this, SafetyCasePackage.STRATEGY__SUPPORTED_BY, Strategy.class, msgs);
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
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION:
				return getConclusion();
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__PREMISE:
				if (resolve) return getPremise();
				return basicGetPremise();
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
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION:
				setConclusion((Strategy)newValue);
				return;
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__PREMISE:
				setPremise((CoreElement)newValue);
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
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION:
				setConclusion((Strategy)null);
				return;
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__PREMISE:
				setPremise((CoreElement)null);
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
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION:
				return getConclusion() != null;
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__PREMISE:
				return premise != null;
		}
		return super.eIsSet(featureID);
	}

} //StrategySupportedByImpl
