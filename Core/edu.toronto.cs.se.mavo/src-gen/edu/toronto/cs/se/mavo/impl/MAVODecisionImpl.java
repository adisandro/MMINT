/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVODecisionLogic;
import edu.toronto.cs.se.mavo.MAVOPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVODecisionImpl#getLogic <em>Logic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVODecisionImpl#getRequiredDecisions <em>Required Decisions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.impl.MAVODecisionImpl#getAlternatives <em>Alternatives</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAVODecisionImpl extends DecisionElementImpl implements MAVODecision {
	/**
	 * The default value of the '{@link #getLogic() <em>Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogic()
	 * @generated
	 * @ordered
	 */
	protected static final MAVODecisionLogic LOGIC_EDEFAULT = MAVODecisionLogic.XOR;

	/**
	 * The cached value of the '{@link #getLogic() <em>Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogic()
	 * @generated
	 * @ordered
	 */
	protected MAVODecisionLogic logic = LOGIC_EDEFAULT;

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
	 * The cached value of the '{@link #getAlternatives() <em>Alternatives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternatives()
	 * @generated
	 * @ordered
	 */
	protected EList<MAVOAlternative> alternatives;

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
	public MAVODecisionLogic getLogic() {
		return logic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogic(MAVODecisionLogic newLogic) {
		MAVODecisionLogic oldLogic = logic;
		logic = newLogic == null ? LOGIC_EDEFAULT : newLogic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOPackage.MAVO_DECISION__LOGIC, oldLogic, logic));
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
	public EList<MAVOAlternative> getAlternatives() {
		if (alternatives == null) {
			alternatives = new EObjectContainmentEList<MAVOAlternative>(MAVOAlternative.class, this, MAVOPackage.MAVO_DECISION__ALTERNATIVES);
		}
		return alternatives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MAVOPackage.MAVO_DECISION__ALTERNATIVES:
				return ((InternalEList<?>)getAlternatives()).basicRemove(otherEnd, msgs);
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
			case MAVOPackage.MAVO_DECISION__LOGIC:
				return getLogic();
			case MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS:
				return getRequiredDecisions();
			case MAVOPackage.MAVO_DECISION__ALTERNATIVES:
				return getAlternatives();
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
			case MAVOPackage.MAVO_DECISION__LOGIC:
				setLogic((MAVODecisionLogic)newValue);
				return;
			case MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS:
				getRequiredDecisions().clear();
				getRequiredDecisions().addAll((Collection<? extends MAVODecision>)newValue);
				return;
			case MAVOPackage.MAVO_DECISION__ALTERNATIVES:
				getAlternatives().clear();
				getAlternatives().addAll((Collection<? extends MAVOAlternative>)newValue);
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
			case MAVOPackage.MAVO_DECISION__LOGIC:
				setLogic(LOGIC_EDEFAULT);
				return;
			case MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS:
				getRequiredDecisions().clear();
				return;
			case MAVOPackage.MAVO_DECISION__ALTERNATIVES:
				getAlternatives().clear();
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
			case MAVOPackage.MAVO_DECISION__LOGIC:
				return logic != LOGIC_EDEFAULT;
			case MAVOPackage.MAVO_DECISION__REQUIRED_DECISIONS:
				return requiredDecisions != null && !requiredDecisions.isEmpty();
			case MAVOPackage.MAVO_DECISION__ALTERNATIVES:
				return alternatives != null && !alternatives.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (logic: ");
		result.append(logic);
		result.append(')');
		return result.toString();
	}

} //MAVODecisionImpl
