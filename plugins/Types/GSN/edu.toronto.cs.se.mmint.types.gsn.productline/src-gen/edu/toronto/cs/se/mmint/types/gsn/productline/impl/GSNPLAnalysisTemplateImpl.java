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
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisRunner;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.GSNPLAnalysisTemplateImpl#getRunner <em>Runner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GSNPLAnalysisTemplateImpl extends GSNPLTemplateImpl implements GSNPLAnalysisTemplate {
  /**
   * The cached value of the '{@link #getRunner() <em>Runner</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRunner()
   * @generated
   * @ordered
   */
  protected GSNPLAnalysisRunner runner;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GSNPLAnalysisTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPLPackage.Literals.GSNPL_ANALYSIS_TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNPLAnalysisRunner getRunner() {
    if (this.runner != null && this.runner.eIsProxy()) {
      var oldRunner = (InternalEObject)this.runner;
      this.runner = (GSNPLAnalysisRunner)eResolveProxy(oldRunner);
      if (this.runner != oldRunner) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPLPackage.GSNPL_ANALYSIS_TEMPLATE__RUNNER, oldRunner, this.runner));
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
  public GSNPLAnalysisRunner basicGetRunner() {
    return this.runner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRunner(GSNPLAnalysisRunner newRunner) {
    var oldRunner = this.runner;
    this.runner = newRunner;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPLPackage.GSNPL_ANALYSIS_TEMPLATE__RUNNER, oldRunner, this.runner));
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
      case GSNPLPackage.GSNPL_ANALYSIS_TEMPLATE__RUNNER:
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
      case GSNPLPackage.GSNPL_ANALYSIS_TEMPLATE__RUNNER:
        setRunner((GSNPLAnalysisRunner)newValue);
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
      case GSNPLPackage.GSNPL_ANALYSIS_TEMPLATE__RUNNER:
        setRunner((GSNPLAnalysisRunner)null);
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
      case GSNPLPackage.GSNPL_ANALYSIS_TEMPLATE__RUNNER:
        return this.runner != null;
    }
    return super.eIsSet(featureID);
  }

} //GSNPLAnalysisTemplateImpl
