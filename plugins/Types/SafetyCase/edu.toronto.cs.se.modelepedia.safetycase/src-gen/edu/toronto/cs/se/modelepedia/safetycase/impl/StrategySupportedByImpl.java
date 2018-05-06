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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
	 * The cached value of the '{@link #getConclusion() <em>Conclusion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConclusion()
	 * @generated
	 * @ordered
	 */
	protected Strategy conclusion;

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
		if (conclusion != null && conclusion.eIsProxy()) {
			InternalEObject oldConclusion = (InternalEObject)conclusion;
			conclusion = (Strategy)eResolveProxy(oldConclusion);
			if (conclusion != oldConclusion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION, oldConclusion, conclusion));
			}
		}
		return conclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy basicGetConclusion() {
		return conclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConclusion(Strategy newConclusion) {
		Strategy oldConclusion = conclusion;
		conclusion = newConclusion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION, oldConclusion, conclusion));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__CONCLUSION:
				if (resolve) return getConclusion();
				return basicGetConclusion();
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
				return conclusion != null;
			case SafetyCasePackage.STRATEGY_SUPPORTED_BY__PREMISE:
				return premise != null;
		}
		return super.eIsSet(featureID);
	}

} //StrategySupportedByImpl
