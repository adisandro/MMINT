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
package edu.toronto.cs.se.modelepedia.istar.impl;

import edu.toronto.cs.se.modelepedia.istar.Contribution;
import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.SoftGoal;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Soft Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.impl.SoftGoalImpl#getContributionsAsContributee <em>Contributions As Contributee</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftGoalImpl extends GoalImpl implements SoftGoal {
	/**
	 * The cached value of the '{@link #getContributionsAsContributee() <em>Contributions As Contributee</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributionsAsContributee()
	 * @generated
	 * @ordered
	 */
	protected EList<Contribution> contributionsAsContributee;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftGoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IStarPackage.Literals.SOFT_GOAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contribution> getContributionsAsContributee() {
		if (contributionsAsContributee == null) {
			contributionsAsContributee = new EObjectWithInverseResolvingEList<Contribution>(Contribution.class, this, IStarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE, IStarPackage.CONTRIBUTION__CONTRIBUTEE);
		}
		return contributionsAsContributee;
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
			case IStarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContributionsAsContributee()).basicAdd(otherEnd, msgs);
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
			case IStarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE:
				return ((InternalEList<?>)getContributionsAsContributee()).basicRemove(otherEnd, msgs);
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
			case IStarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE:
				return getContributionsAsContributee();
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
			case IStarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE:
				getContributionsAsContributee().clear();
				getContributionsAsContributee().addAll((Collection<? extends Contribution>)newValue);
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
			case IStarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE:
				getContributionsAsContributee().clear();
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
			case IStarPackage.SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE:
				return contributionsAsContributee != null && !contributionsAsContributee.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SoftGoalImpl
