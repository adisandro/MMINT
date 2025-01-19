/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactStep;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ImpactStepImpl#getImpacted <em>Impacted</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ImpactStepImpl#getTrace <em>Trace</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImpactStepImpl extends MinimalEObjectImpl.Container implements ImpactStep {
  /**
   * The cached value of the '{@link #getImpacted() <em>Impacted</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpacted()
   * @generated
   * @ordered
   */
  protected ArgumentElement impacted;

  /**
   * The cached value of the '{@link #getTrace() <em>Trace</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrace()
   * @generated
   * @ordered
   */
  protected EList<EObject> trace;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImpactStepImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.IMPACT_STEP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentElement getImpacted() {
    if (this.impacted != null && this.impacted.eIsProxy()) {
      var oldImpacted = (InternalEObject)this.impacted;
      this.impacted = (ArgumentElement)eResolveProxy(oldImpacted);
      if (this.impacted != oldImpacted) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.IMPACT_STEP__IMPACTED, oldImpacted, this.impacted));
        }
      }
    }
    return this.impacted;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArgumentElement basicGetImpacted() {
    return this.impacted;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setImpacted(ArgumentElement newImpacted) {
    var oldImpacted = this.impacted;
    this.impacted = newImpacted;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.IMPACT_STEP__IMPACTED, oldImpacted, this.impacted));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EObject> getTrace() {
    if (this.trace == null) {
      this.trace = new EObjectResolvingEList<>(EObject.class, this, GSNPackage.IMPACT_STEP__TRACE);
    }
    return this.trace;
  }

  /**
   * @generated NOT
   */
  private List<ImpactStep> nextSupporters(Supportable supportable, List<EObject> trace, Object change) {
    var nextSteps = new ArrayList<ImpactStep>();
    for (var supportedBy : supportable.getSupportedBy()) {
      var nextStep = GSNFactory.eINSTANCE.createImpactStep();
      nextStep.setImpacted(supportedBy.getTarget());
      nextStep.getTrace().add(supportedBy);
      nextStep.getTrace().add(supportable);
      nextStep.getTrace().addAll(trace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  /**
   * @generated NOT
   */
  private List<ImpactStep> nextContexts(Contextualizable contextualizable, List<EObject> trace, Object change) {
    var nextSteps = new ArrayList<ImpactStep>();
    for (var inContextOf : contextualizable.getInContextOf()) {
      var nextStep = GSNFactory.eINSTANCE.createImpactStep();
      nextStep.setImpacted(inContextOf.getContext());
      nextStep.getTrace().add(inContextOf);
      nextStep.getTrace().add(contextualizable);
      nextStep.getTrace().addAll(trace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  /**
   * @generated NOT
   */
  private ImpactType getPreviousImpact(Object change) {
    return getTrace().stream()
      .filter(o -> o instanceof ArgumentElement)
      .map(o -> ((ArgumentElement) o).getStatus().getType())
      .findFirst()
      .orElse(ImpactType.RECHECK); //TODO: derive from change
  }

  /**
   * @generated NOT
   */
  @Override
  public EList<ImpactStep> nextSteps(Object change, ImpactType previousImpact) {
    var element = getImpacted();
    var trace = getTrace();
    var status = element.getStatus();
    if (previousImpact == null) {
      previousImpact = getPreviousImpact(change);
    }
    // impact rules
    var nextSteps = new BasicEList<ImpactStep>();
    switch (element) {
      case Goal goal -> {
        status.setType(previousImpact);
        nextSteps.addAll(nextSupporters(goal, trace, change));
        nextSteps.addAll(nextContexts(goal, trace, change));
      }
      case Strategy strategy -> {
        status.setType(previousImpact);
        nextSteps.addAll(nextSupporters(strategy, trace, change));
        nextSteps.addAll(nextContexts(strategy, trace, change));
      }
      case Contextual context -> {
        status.setType(ImpactType.REUSE);
      }
      default -> {
        status.setType(previousImpact);
      }
    };

    return nextSteps;
  }

  /**
   * @generated NOT
   */
  @Override
  public void impact(Object change) throws Exception {
    var impacted = getImpacted();
    var status = impacted.getStatus();
    var previousImpact = getPreviousImpact(change);
    // stop condition: already impacted with equal or more priority
    if (status != null && status.getType().compareTo(previousImpact) >= 0) {
      return;
    }
    if (status == null) {
      status = GSNFactory.eINSTANCE.createImpactAnnotation();
      impacted.setStatus(status);
    }
    // separate syntactic vs semantic (template) behavior
    List<ImpactStep> nextSteps = null;
    if (impacted.getTemplates().isEmpty()) {
      nextSteps = nextSteps(change, previousImpact);
    }
    else {
      for (var template : impacted.getTemplates()) {
        nextSteps = template.impact(this, change);
        break;
      }
    }
    for (var nextStep : nextSteps) {
      nextStep.impact(change);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.IMPACT_STEP__IMPACTED:
        if (resolve) {
          return getImpacted();
        }
        return basicGetImpacted();
      case GSNPackage.IMPACT_STEP__TRACE:
        return getTrace();
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
      case GSNPackage.IMPACT_STEP__IMPACTED:
        setImpacted((ArgumentElement)newValue);
        return;
      case GSNPackage.IMPACT_STEP__TRACE:
        getTrace().clear();
        getTrace().addAll((Collection<? extends EObject>)newValue);
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
      case GSNPackage.IMPACT_STEP__IMPACTED:
        setImpacted((ArgumentElement)null);
        return;
      case GSNPackage.IMPACT_STEP__TRACE:
        getTrace().clear();
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
      case GSNPackage.IMPACT_STEP__IMPACTED:
        return this.impacted != null;
      case GSNPackage.IMPACT_STEP__TRACE:
        return this.trace != null && !this.trace.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case GSNPackage.IMPACT_STEP___IMPACT__OBJECT:
        try {
          impact(arguments.get(0));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

} //ImpactStepImpl
