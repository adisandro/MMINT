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

import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisRunner;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
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
  protected AnalysisRunner runner;

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
  public AnalysisRunner getRunnerGen() {
    if (this.runner != null && this.runner.eIsProxy()) {
      var oldRunner = (InternalEObject)this.runner;
      this.runner = (AnalysisRunner)eResolveProxy(oldRunner);
      if (this.runner != oldRunner) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNTemplatesPackage.ANALYSIS_TEMPLATE__RUNNER, oldRunner, this.runner));
        }
      }
    }
    return this.runner;
  }

  /**
   * @generated NOT
   */
  @Override
  public AnalysisRunner getRunner() {
    var runner = getRunnerGen();
    if (runner != null) {
      return runner;
    }
    try {
      var javaPath = getRunnerPath();
      if (javaPath == null) {
        return null;
      }
      var className = FileUtils.getFileNameFromPath(javaPath);
      var projectName = FileUtils.getFirstSegmentFromPath(javaPath);
      var binaryName = FileUtils.getAllButLastSegmentFromPath(javaPath)
        .replace(IPath.SEPARATOR + projectName + IPath.SEPARATOR + "src" + IPath.SEPARATOR, "")
        .replace(IPath.SEPARATOR, '.') +
        className;
      var emfUri = FileUtils.createEMFUri(projectName + IPath.SEPARATOR + "bin" + IPath.SEPARATOR, true);
      var url = URI.create(emfUri.toString()).toURL();
      try (var loader = new URLClassLoader(new URL[] {url}, this.getClass().getClassLoader())) {
        var runnerClass = loader.loadClass(binaryName);
        runner = (AnalysisRunner) runnerClass.getConstructor().newInstance();
      }
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
  public AnalysisRunner basicGetRunner() {
    return this.runner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRunner(AnalysisRunner newRunner) {
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
        setRunner((AnalysisRunner)newValue);
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
        setRunner((AnalysisRunner)null);
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
    var javaPath = MIDDialogs.selectFile("Import analysis template", "Select a Java class that implements the analysis",
                                         "There are no Java files in the workspace", Set.of("java"));
    setRunnerPath(javaPath);
    super.import_(safetyCase);
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

} //AnalysisTemplateImpl
