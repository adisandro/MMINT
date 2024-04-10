/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IAnalysisRunner;
import edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalysisTemplateImpl#getRunner <em>Runner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalysisTemplateImpl extends TemplateImpl implements AnalysisTemplate {
  /**
   * The cached value of the '{@link #getRunner() <em>Runner</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRunner()
   * @generated
   * @ordered
   */
  protected IAnalysisRunner runner;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnalysisTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.ANALYSIS_TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IAnalysisRunner getRunner() {
    if (this.runner != null && this.runner.eIsProxy()) {
      var oldRunner = (InternalEObject)this.runner;
      this.runner = (IAnalysisRunner)eResolveProxy(oldRunner);
      if (this.runner != oldRunner) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER, oldRunner, this.runner));
        }
      }
    }
    return this.runner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IAnalysisRunner basicGetRunner() {
    return this.runner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRunner(IAnalysisRunner newRunner) {
    var oldRunner = this.runner;
    this.runner = newRunner;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER, oldRunner, this.runner));
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
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER:
        if (resolve) {
          return getRunner();
        }
        return basicGetRunner();
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
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER:
        setRunner((IAnalysisRunner)newValue);
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
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER:
        setRunner((IAnalysisRunner)null);
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
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER:
        return this.runner != null;
    }
    return super.eIsSet(featureID);
  }

} //AnalysisTemplateImpl
