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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IAnalysisRunner;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalysisTemplateImpl#getRunnerPath <em>Runner Path</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalysisTemplateImpl#getRunner <em>Runner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalysisTemplateImpl extends TemplateImpl implements AnalysisTemplate {
  /**
   * The default value of the '{@link #getRunnerPath() <em>Runner Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRunnerPath()
   * @generated
   * @ordered
   */
  protected static final String RUNNER_PATH_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getRunnerPath() <em>Runner Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRunnerPath()
   * @generated
   * @ordered
   */
  protected String runnerPath = AnalysisTemplateImpl.RUNNER_PATH_EDEFAULT;
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
  public String getRunnerPath() {
    return this.runnerPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRunnerPath(String newRunnerPath) {
    var oldRunnerPath = this.runnerPath;
    this.runnerPath = newRunnerPath;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER_PATH, oldRunnerPath, this.runnerPath));
    }
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
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER_PATH:
        return getRunnerPath();
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
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER_PATH:
        setRunnerPath((String)newValue);
        return;
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
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER_PATH:
        setRunnerPath(AnalysisTemplateImpl.RUNNER_PATH_EDEFAULT);
        return;
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
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER_PATH:
        return AnalysisTemplateImpl.RUNNER_PATH_EDEFAULT == null ? this.runnerPath != null : !AnalysisTemplateImpl.RUNNER_PATH_EDEFAULT.equals(this.runnerPath);
      case GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER:
        return this.runner != null;
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
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (runnerPath: ");
    result.append(this.runnerPath);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public void import_(SafetyCase safetyCase) throws Exception {
    super.import_(safetyCase);
    try {
      var u = URI.create(FileUtils.createEMFUri("/edu.toronto.cs.se.mmint.productline.tests/bin/", true).toString()).toURL();
      var x = new URLClassLoader(new URL[] {u});
      var c = x.loadClass("edu.toronto.cs.se.mmint.test.Something");
      var i = (IAnalysisRunner) c.getConstructor().newInstance();
      setRunner(i);
      x.close();
    }
    catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | IOException e) {
      e.printStackTrace();
    }
    //TODO will need a string field to hold the runner location and a volatile runner to be reloaded if null, just like the rootModelObj thing
    //TODO document the two main ways of extending template behavior: runner vs inheritance
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    super.instantiate();
    getRunner().instantiate();
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    super.validate();
    getRunner().validate();
  }

} //AnalysisTemplateImpl
