/*******************************************************************************
 * Copyright (c) 2017, 2025 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Template;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Safety Case</b></em>'. <!-- end-user-doc -->
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
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl#getTemplates <em>Templates</em>}</li>
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
   * The cached value of the '{@link #getStrategies() <em>Strategies</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getStrategies()
   * @generated
   * @ordered
   */
  protected EList<Strategy> strategies;

  /**
   * The cached value of the '{@link #getSolutions() <em>Solutions</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getSolutions()
   * @generated
   * @ordered
   */
  protected EList<Solution> solutions;

  /**
   * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getContexts()
   * @generated
   * @ordered
   */
  protected EList<Context> contexts;

  /**
   * The cached value of the '{@link #getJustifications() <em>Justifications</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getJustifications()
   * @generated
   * @ordered
   */
  protected EList<Justification> justifications;

  /**
   * The cached value of the '{@link #getAssumptions() <em>Assumptions</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getAssumptions()
   * @generated
   * @ordered
   */
  protected EList<Assumption> assumptions;

  /**
   * The cached value of the '{@link #getTemplates() <em>Templates</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplates()
   * @generated
   * @ordered
   */
  protected EList<Template> templates;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SafetyCaseImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.SAFETY_CASE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Goal> getGoals() {
    if (this.goals == null) {
      this.goals = new EObjectContainmentEList<>(Goal.class, this, GSNPackage.SAFETY_CASE__GOALS);
    }
    return this.goals;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Strategy> getStrategies() {
    if (this.strategies == null) {
      this.strategies = new EObjectContainmentEList<>(Strategy.class, this, GSNPackage.SAFETY_CASE__STRATEGIES);
    }
    return this.strategies;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Solution> getSolutions() {
    if (this.solutions == null) {
      this.solutions = new EObjectContainmentEList<>(Solution.class, this, GSNPackage.SAFETY_CASE__SOLUTIONS);
    }
    return this.solutions;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Context> getContexts() {
    if (this.contexts == null) {
      this.contexts = new EObjectContainmentEList<>(Context.class, this, GSNPackage.SAFETY_CASE__CONTEXTS);
    }
    return this.contexts;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Justification> getJustifications() {
    if (this.justifications == null) {
      this.justifications = new EObjectContainmentEList<>(Justification.class, this, GSNPackage.SAFETY_CASE__JUSTIFICATIONS);
    }
    return this.justifications;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Assumption> getAssumptions() {
    if (this.assumptions == null) {
      this.assumptions = new EObjectContainmentEList<>(Assumption.class, this, GSNPackage.SAFETY_CASE__ASSUMPTIONS);
    }
    return this.assumptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Template> getTemplates() {
    if (this.templates == null) {
      this.templates = new EObjectContainmentEList<>(Template.class, this, GSNPackage.SAFETY_CASE__TEMPLATES);
    }
    return this.templates;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
      case GSNPackage.SAFETY_CASE__TEMPLATES:
        return ((InternalEList<?>)getTemplates()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
      case GSNPackage.SAFETY_CASE__TEMPLATES:
        return getTemplates();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
      case GSNPackage.SAFETY_CASE__TEMPLATES:
        getTemplates().clear();
        getTemplates().addAll((Collection<? extends Template>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
      case GSNPackage.SAFETY_CASE__TEMPLATES:
        getTemplates().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case GSNPackage.SAFETY_CASE__GOALS:
        return this.goals != null && !this.goals.isEmpty();
      case GSNPackage.SAFETY_CASE__STRATEGIES:
        return this.strategies != null && !this.strategies.isEmpty();
      case GSNPackage.SAFETY_CASE__SOLUTIONS:
        return this.solutions != null && !this.solutions.isEmpty();
      case GSNPackage.SAFETY_CASE__CONTEXTS:
        return this.contexts != null && !this.contexts.isEmpty();
      case GSNPackage.SAFETY_CASE__JUSTIFICATIONS:
        return this.justifications != null && !this.justifications.isEmpty();
      case GSNPackage.SAFETY_CASE__ASSUMPTIONS:
        return this.assumptions != null && !this.assumptions.isEmpty();
      case GSNPackage.SAFETY_CASE__TEMPLATES:
        return this.templates != null && !this.templates.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // SafetyCaseImpl
