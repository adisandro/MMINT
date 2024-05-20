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

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osgi.framework.wiring.BundleWiring;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analytic Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalyticTemplateImpl#getAnalysisPath <em>Analysis Path</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalyticTemplateImpl#getLoaderBundleName <em>Loader Bundle Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalyticTemplateImpl extends TemplateImpl implements AnalyticTemplate {
  /**
   * The default value of the '{@link #getAnalysisPath() <em>Analysis Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnalysisPath()
   * @generated
   * @ordered
   */
  protected static final String ANALYSIS_PATH_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getAnalysisPath() <em>Analysis Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnalysisPath()
   * @generated
   * @ordered
   */
  protected String analysisPath = AnalyticTemplateImpl.ANALYSIS_PATH_EDEFAULT;
  /**
   * The default value of the '{@link #getLoaderBundleName() <em>Loader Bundle Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoaderBundleName()
   * @generated
   * @ordered
   */
  protected static final String LOADER_BUNDLE_NAME_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getLoaderBundleName() <em>Loader Bundle Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoaderBundleName()
   * @generated
   * @ordered
   */
  protected String loaderBundleName = AnalyticTemplateImpl.LOADER_BUNDLE_NAME_EDEFAULT;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnalyticTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.ANALYTIC_TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getAnalysisPath() {
    return this.analysisPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAnalysisPath(String newAnalysisPath) {
    var oldAnalysisPath = this.analysisPath;
    this.analysisPath = newAnalysisPath;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.ANALYTIC_TEMPLATE__ANALYSIS_PATH, oldAnalysisPath, this.analysisPath));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLoaderBundleName() {
    return this.loaderBundleName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLoaderBundleName(String newLoaderBundleName) {
    var oldLoaderBundleName = this.loaderBundleName;
    this.loaderBundleName = newLoaderBundleName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.ANALYTIC_TEMPLATE__LOADER_BUNDLE_NAME, oldLoaderBundleName, this.loaderBundleName));
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
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE__ANALYSIS_PATH:
        return getAnalysisPath();
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE__LOADER_BUNDLE_NAME:
        return getLoaderBundleName();
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
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE__ANALYSIS_PATH:
        setAnalysisPath((String)newValue);
        return;
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE__LOADER_BUNDLE_NAME:
        setLoaderBundleName((String)newValue);
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
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE__ANALYSIS_PATH:
        setAnalysisPath(AnalyticTemplateImpl.ANALYSIS_PATH_EDEFAULT);
        return;
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE__LOADER_BUNDLE_NAME:
        setLoaderBundleName(AnalyticTemplateImpl.LOADER_BUNDLE_NAME_EDEFAULT);
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
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE__ANALYSIS_PATH:
        return AnalyticTemplateImpl.ANALYSIS_PATH_EDEFAULT == null ? this.analysisPath != null : !AnalyticTemplateImpl.ANALYSIS_PATH_EDEFAULT.equals(this.analysisPath);
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE__LOADER_BUNDLE_NAME:
        return AnalyticTemplateImpl.LOADER_BUNDLE_NAME_EDEFAULT == null ? this.loaderBundleName != null : !AnalyticTemplateImpl.LOADER_BUNDLE_NAME_EDEFAULT.equals(this.loaderBundleName);
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
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE___GET_ANALYSIS:
        try {
          return getAnalysis();
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
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
    result.append(" (analysisPath: ");
    result.append(this.analysisPath);
    result.append(", loaderBundleName: ");
    result.append(this.loaderBundleName);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public IAnalysis getAnalysis() throws Exception {
    var javaPath = getAnalysisPath();
    if (javaPath == null) {
      throw new MMINTException("Missing analysis runner Java path");
    }
    var bundleName = getLoaderBundleName();
    var classLoader = getClass().getClassLoader();
    if (bundleName != null) {
      var bundle = Platform.getBundle(bundleName);
      if (bundle != null) {
        classLoader = bundle.adapt(BundleWiring.class).getClassLoader();
      }
    }
    return (IAnalysis) FileUtils.loadClassFromWorkspace(javaPath, classLoader);
  }

  /**
   * @generated NOT
   */
  @Override
  public void import_(SafetyCase safetyCase) throws Exception {
    var javaPath = MIDDialogs.selectFile("Import analytic template", "Select a Java class that implements the analysis",
                                         "There are no Java files in the workspace", Set.of("java"));
    setAnalysisPath(javaPath);
    super.import_(safetyCase);
    getAnalysis().import_(this, safetyCase);
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var analysis = getAnalysis();
    if (analysis.runsFirst()) {
      analysis.instantiate(this);
      super.instantiate();
    }
    else {
      super.instantiate();
      analysis.instantiate(this);
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    var analysis = getAnalysis();
    if (analysis.runsFirst()) {
      analysis.validate(this);
      super.validate();
    }
    else {
      super.validate();
      analysis.validate(this);
    }
  }

} //AnalysisTemplateImpl
