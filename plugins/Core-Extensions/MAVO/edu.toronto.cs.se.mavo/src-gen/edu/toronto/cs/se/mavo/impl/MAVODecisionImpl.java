/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mavo.impl;

import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOPackage;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVODecisionImpl#getRequiredDecisions <em>Required Decisions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MAVODecisionImpl extends DecisionElementImpl implements MAVODecision {
	/**
	 * The cached value of the '{@link #getRequiredDecisions() <em>Required Decisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredDecisions()
	 * @generated
	 * @ordered
	 */
	protected EList<MAVODecision> requiredDecisions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVODecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOPackage.Literals.MAVO_DECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MAVODecision> getRequiredDecisions() {
		if (requiredDecisions == null) {
			requiredDecisions = new EObjectResolvingEList<MAVODecision>(MAVODecision.class, this, MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS);
		}
		return requiredDecisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS:
				return getRequiredDecisions();
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
			case MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS:
				getRequiredDecisions().clear();
				getRequiredDecisions().addAll((Collection<? extends MAVODecision>)newValue);
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
			case MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS:
				getRequiredDecisions().clear();
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
			case MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS:
				return requiredDecisions != null && !requiredDecisions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MAVODecisionImpl
