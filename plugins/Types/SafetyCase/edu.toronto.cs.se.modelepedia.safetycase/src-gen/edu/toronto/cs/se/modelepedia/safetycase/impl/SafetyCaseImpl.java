/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.modelepedia.safetycase.Assumption;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.Justification;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl#getStrategies <em>Strategies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl#getJustifications <em>Justifications</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl#getAssumptions <em>Assumptions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SafetyCaseImpl extends MinimalEObjectImpl.Container implements SafetyCase {
	/**
	 * The cached value of the '{@link #getGoals() <em>Goals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> goals;

	/**
	 * The cached value of the '{@link #getStrategies() <em>Strategies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategies()
	 * @generated
	 * @ordered
	 */
	protected EList<Strategy> strategies;

	/**
	 * The cached value of the '{@link #getSolutions() <em>Solutions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutions()
	 * @generated
	 * @ordered
	 */
	protected EList<Solution> solutions;

	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> contexts;

	/**
	 * The cached value of the '{@link #getJustifications() <em>Justifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJustifications()
	 * @generated
	 * @ordered
	 */
	protected EList<Justification> justifications;

	/**
	 * The cached value of the '{@link #getAssumptions() <em>Assumptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssumptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Assumption> assumptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafetyCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.SAFETY_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Goal> getGoals() {
		if (goals == null) {
			goals = new EObjectContainmentEList<Goal>(Goal.class, this, SafetyCasePackage.SAFETY_CASE__GOALS);
		}
		return goals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Strategy> getStrategies() {
		if (strategies == null) {
			strategies = new EObjectContainmentEList<Strategy>(Strategy.class, this, SafetyCasePackage.SAFETY_CASE__STRATEGIES);
		}
		return strategies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Solution> getSolutions() {
		if (solutions == null) {
			solutions = new EObjectContainmentEList<Solution>(Solution.class, this, SafetyCasePackage.SAFETY_CASE__SOLUTIONS);
		}
		return solutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Context> getContexts() {
		if (contexts == null) {
			contexts = new EObjectContainmentEList<Context>(Context.class, this, SafetyCasePackage.SAFETY_CASE__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Justification> getJustifications() {
		if (justifications == null) {
			justifications = new EObjectContainmentEList<Justification>(Justification.class, this, SafetyCasePackage.SAFETY_CASE__JUSTIFICATIONS);
		}
		return justifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assumption> getAssumptions() {
		if (assumptions == null) {
			assumptions = new EObjectContainmentEList<Assumption>(Assumption.class, this, SafetyCasePackage.SAFETY_CASE__ASSUMPTIONS);
		}
		return assumptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SafetyCasePackage.SAFETY_CASE__GOALS:
				return ((InternalEList<?>)getGoals()).basicRemove(otherEnd, msgs);
			case SafetyCasePackage.SAFETY_CASE__STRATEGIES:
				return ((InternalEList<?>)getStrategies()).basicRemove(otherEnd, msgs);
			case SafetyCasePackage.SAFETY_CASE__SOLUTIONS:
				return ((InternalEList<?>)getSolutions()).basicRemove(otherEnd, msgs);
			case SafetyCasePackage.SAFETY_CASE__CONTEXTS:
				return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
			case SafetyCasePackage.SAFETY_CASE__JUSTIFICATIONS:
				return ((InternalEList<?>)getJustifications()).basicRemove(otherEnd, msgs);
			case SafetyCasePackage.SAFETY_CASE__ASSUMPTIONS:
				return ((InternalEList<?>)getAssumptions()).basicRemove(otherEnd, msgs);
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
			case SafetyCasePackage.SAFETY_CASE__GOALS:
				return getGoals();
			case SafetyCasePackage.SAFETY_CASE__STRATEGIES:
				return getStrategies();
			case SafetyCasePackage.SAFETY_CASE__SOLUTIONS:
				return getSolutions();
			case SafetyCasePackage.SAFETY_CASE__CONTEXTS:
				return getContexts();
			case SafetyCasePackage.SAFETY_CASE__JUSTIFICATIONS:
				return getJustifications();
			case SafetyCasePackage.SAFETY_CASE__ASSUMPTIONS:
				return getAssumptions();
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
			case SafetyCasePackage.SAFETY_CASE__GOALS:
				getGoals().clear();
				getGoals().addAll((Collection<? extends Goal>)newValue);
				return;
			case SafetyCasePackage.SAFETY_CASE__STRATEGIES:
				getStrategies().clear();
				getStrategies().addAll((Collection<? extends Strategy>)newValue);
				return;
			case SafetyCasePackage.SAFETY_CASE__SOLUTIONS:
				getSolutions().clear();
				getSolutions().addAll((Collection<? extends Solution>)newValue);
				return;
			case SafetyCasePackage.SAFETY_CASE__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends Context>)newValue);
				return;
			case SafetyCasePackage.SAFETY_CASE__JUSTIFICATIONS:
				getJustifications().clear();
				getJustifications().addAll((Collection<? extends Justification>)newValue);
				return;
			case SafetyCasePackage.SAFETY_CASE__ASSUMPTIONS:
				getAssumptions().clear();
				getAssumptions().addAll((Collection<? extends Assumption>)newValue);
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
			case SafetyCasePackage.SAFETY_CASE__GOALS:
				getGoals().clear();
				return;
			case SafetyCasePackage.SAFETY_CASE__STRATEGIES:
				getStrategies().clear();
				return;
			case SafetyCasePackage.SAFETY_CASE__SOLUTIONS:
				getSolutions().clear();
				return;
			case SafetyCasePackage.SAFETY_CASE__CONTEXTS:
				getContexts().clear();
				return;
			case SafetyCasePackage.SAFETY_CASE__JUSTIFICATIONS:
				getJustifications().clear();
				return;
			case SafetyCasePackage.SAFETY_CASE__ASSUMPTIONS:
				getAssumptions().clear();
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
			case SafetyCasePackage.SAFETY_CASE__GOALS:
				return goals != null && !goals.isEmpty();
			case SafetyCasePackage.SAFETY_CASE__STRATEGIES:
				return strategies != null && !strategies.isEmpty();
			case SafetyCasePackage.SAFETY_CASE__SOLUTIONS:
				return solutions != null && !solutions.isEmpty();
			case SafetyCasePackage.SAFETY_CASE__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
			case SafetyCasePackage.SAFETY_CASE__JUSTIFICATIONS:
				return justifications != null && !justifications.isEmpty();
			case SafetyCasePackage.SAFETY_CASE__ASSUMPTIONS:
				return assumptions != null && !assumptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SafetyCaseImpl
