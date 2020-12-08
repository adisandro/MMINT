/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 * 
 */
package edu.toronto.cs.se.modelepedia.gsn.impl;

import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.SupportConnector;

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
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl#getStrategies <em>Strategies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl#getJustifications <em>Justifications</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl#getAssumptions <em>Assumptions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl#getConnectors <em>Connectors</em>}</li>
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
   * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectors()
   * @generated
   * @ordered
   */
  protected EList<SupportConnector> connectors;

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
    return GSNPackage.Literals.SAFETY_CASE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Goal> getGoals() {
    if (goals == null) {
      goals = new EObjectContainmentEList<Goal>(Goal.class, this, GSNPackage.SAFETY_CASE__GOALS);
    }
    return goals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Strategy> getStrategies() {
    if (strategies == null) {
      strategies = new EObjectContainmentEList<Strategy>(Strategy.class, this, GSNPackage.SAFETY_CASE__STRATEGIES);
    }
    return strategies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Solution> getSolutions() {
    if (solutions == null) {
      solutions = new EObjectContainmentEList<Solution>(Solution.class, this, GSNPackage.SAFETY_CASE__SOLUTIONS);
    }
    return solutions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Context> getContexts() {
    if (contexts == null) {
      contexts = new EObjectContainmentEList<Context>(Context.class, this, GSNPackage.SAFETY_CASE__CONTEXTS);
    }
    return contexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Justification> getJustifications() {
    if (justifications == null) {
      justifications = new EObjectContainmentEList<Justification>(Justification.class, this, GSNPackage.SAFETY_CASE__JUSTIFICATIONS);
    }
    return justifications;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Assumption> getAssumptions() {
    if (assumptions == null) {
      assumptions = new EObjectContainmentEList<Assumption>(Assumption.class, this, GSNPackage.SAFETY_CASE__ASSUMPTIONS);
    }
    return assumptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SupportConnector> getConnectors() {
    if (connectors == null) {
      connectors = new EObjectContainmentEList<SupportConnector>(SupportConnector.class, this, GSNPackage.SAFETY_CASE__CONNECTORS);
    }
    return connectors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.SAFETY_CASE__GOALS:
        return ((InternalEList<?>)getGoals()).basicRemove(otherEnd, msgs);
      case GSNPackage.SAFETY_CASE__STRATEGIES:
        return ((InternalEList<?>)getStrategies()).basicRemove(otherEnd, msgs);
      case GSNPackage.SAFETY_CASE__SOLUTIONS:
        return ((InternalEList<?>)getSolutions()).basicRemove(otherEnd, msgs);
      case GSNPackage.SAFETY_CASE__CONTEXTS:
        return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
      case GSNPackage.SAFETY_CASE__JUSTIFICATIONS:
        return ((InternalEList<?>)getJustifications()).basicRemove(otherEnd, msgs);
      case GSNPackage.SAFETY_CASE__ASSUMPTIONS:
        return ((InternalEList<?>)getAssumptions()).basicRemove(otherEnd, msgs);
      case GSNPackage.SAFETY_CASE__CONNECTORS:
        return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
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
      case GSNPackage.SAFETY_CASE__GOALS:
        return getGoals();
      case GSNPackage.SAFETY_CASE__STRATEGIES:
        return getStrategies();
      case GSNPackage.SAFETY_CASE__SOLUTIONS:
        return getSolutions();
      case GSNPackage.SAFETY_CASE__CONTEXTS:
        return getContexts();
      case GSNPackage.SAFETY_CASE__JUSTIFICATIONS:
        return getJustifications();
      case GSNPackage.SAFETY_CASE__ASSUMPTIONS:
        return getAssumptions();
      case GSNPackage.SAFETY_CASE__CONNECTORS:
        return getConnectors();
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
      case GSNPackage.SAFETY_CASE__GOALS:
        getGoals().clear();
        getGoals().addAll((Collection<? extends Goal>)newValue);
        return;
      case GSNPackage.SAFETY_CASE__STRATEGIES:
        getStrategies().clear();
        getStrategies().addAll((Collection<? extends Strategy>)newValue);
        return;
      case GSNPackage.SAFETY_CASE__SOLUTIONS:
        getSolutions().clear();
        getSolutions().addAll((Collection<? extends Solution>)newValue);
        return;
      case GSNPackage.SAFETY_CASE__CONTEXTS:
        getContexts().clear();
        getContexts().addAll((Collection<? extends Context>)newValue);
        return;
      case GSNPackage.SAFETY_CASE__JUSTIFICATIONS:
        getJustifications().clear();
        getJustifications().addAll((Collection<? extends Justification>)newValue);
        return;
      case GSNPackage.SAFETY_CASE__ASSUMPTIONS:
        getAssumptions().clear();
        getAssumptions().addAll((Collection<? extends Assumption>)newValue);
        return;
      case GSNPackage.SAFETY_CASE__CONNECTORS:
        getConnectors().clear();
        getConnectors().addAll((Collection<? extends SupportConnector>)newValue);
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
      case GSNPackage.SAFETY_CASE__GOALS:
        getGoals().clear();
        return;
      case GSNPackage.SAFETY_CASE__STRATEGIES:
        getStrategies().clear();
        return;
      case GSNPackage.SAFETY_CASE__SOLUTIONS:
        getSolutions().clear();
        return;
      case GSNPackage.SAFETY_CASE__CONTEXTS:
        getContexts().clear();
        return;
      case GSNPackage.SAFETY_CASE__JUSTIFICATIONS:
        getJustifications().clear();
        return;
      case GSNPackage.SAFETY_CASE__ASSUMPTIONS:
        getAssumptions().clear();
        return;
      case GSNPackage.SAFETY_CASE__CONNECTORS:
        getConnectors().clear();
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
      case GSNPackage.SAFETY_CASE__GOALS:
        return goals != null && !goals.isEmpty();
      case GSNPackage.SAFETY_CASE__STRATEGIES:
        return strategies != null && !strategies.isEmpty();
      case GSNPackage.SAFETY_CASE__SOLUTIONS:
        return solutions != null && !solutions.isEmpty();
      case GSNPackage.SAFETY_CASE__CONTEXTS:
        return contexts != null && !contexts.isEmpty();
      case GSNPackage.SAFETY_CASE__JUSTIFICATIONS:
        return justifications != null && !justifications.isEmpty();
      case GSNPackage.SAFETY_CASE__ASSUMPTIONS:
        return assumptions != null && !assumptions.isEmpty();
      case GSNPackage.SAFETY_CASE__CONNECTORS:
        return connectors != null && !connectors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SafetyCaseImpl
