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

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisRunner;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;

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
  public GSNPLAnalysisRunner getRunnerGen() {
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
   * @generated NOT
   */
  @Override
  public GSNPLAnalysisRunner getRunner() {
    var runner = getRunnerGen();
    if (runner != null) {
      return runner;
    }
    try {
      var javaPath = getAttribute(GSNTemplatesPackage.eINSTANCE.getAnalysisTemplate_RunnerPath()).get(0);
      if (javaPath == null) {
        return null;
      }
      runner = (GSNPLAnalysisRunner) FileUtils.loadClassFromWorkspace(javaPath, this.getClass().getClassLoader());
      // bypass EMF notifications and the need for a write transaction
      this.runner = runner;
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, "Failed to load analysis runner class, returning null", e);
      return null;
    }

    return runner;
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

  /**
   * @generated NOT
   */
  @Override
  public void import_(ProductLine productLine) throws Exception {
    var javaPath = MIDDialogs.selectFile("Import analysis template", "Select a Java class that implements the analysis",
                                         "There are no Java files in the workspace", Set.of("java"));
    addAttribute(GSNTemplatesPackage.eINSTANCE.getAnalysisTemplate_RunnerPath(), javaPath);
    super.import_(productLine);
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var runner = getRunner();
    if (runner != null) {
      runner.instantiate(this);
    }
    super.instantiate();
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    var runner = getRunner();
    if (runner != null) {
      runner.validate(this);
    }
    super.validate();
  }

} //GSNPLAnalysisTemplateImpl
