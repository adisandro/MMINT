/*******************************************************************************
 * Copyright (c) 2024, 2026 Alessio Di Sandro.
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

import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osgi.framework.wiring.BundleWiring;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNAnalyticTemplateImpl#getAnalysis <em>Analysis</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PLGSNAnalyticTemplateImpl extends PLGSNTemplateImpl implements PLGSNAnalyticTemplate {
  /**
   * The default value of the '{@link #getAnalysis() <em>Analysis</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnalysis()
   * @generated
   * @ordered
   */
  protected static final IPLGSNAnalysis ANALYSIS_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getAnalysis() <em>Analysis</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnalysis()
   * @generated
   * @ordered
   */
  protected IPLGSNAnalysis analysis = PLGSNAnalyticTemplateImpl.ANALYSIS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLGSNAnalyticTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLGSNPackage.Literals.PLGSN_ANALYTIC_TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IPLGSNAnalysis getAnalysisGen() {
    return this.analysis;
  }

  /**
   * @generated NOT
   */
  @Override
  public IPLGSNAnalysis getAnalysis() {
    var loadedAnalysis = getAnalysisGen();
    if (loadedAnalysis == null) {
      var javaPath = getAttribute(GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate_AnalysisPath());
      if (javaPath == null) {
        throw new NoSuchElementException("Missing analysis Java path");
      }
      var bundleName = getAttribute(GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate_LoaderBundleName());
      var classLoader = getClass().getClassLoader();
      if (bundleName != null) {
        var bundle = Platform.getBundle(bundleName);
        if (bundle != null) {
          classLoader = bundle.adapt(BundleWiring.class).getClassLoader();
        }
      }
      try {
        loadedAnalysis = (IPLGSNAnalysis) FileUtils.loadClassFromWorkspace(javaPath, classLoader);
      }
      catch (Exception e) {
        throw new NoSuchElementException("Unable to load analysis Java class", e);
      }
      // bypass EMF notifications and the need for a write transaction
      this.analysis = loadedAnalysis;
    }

    return loadedAnalysis;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAnalysis(IPLGSNAnalysis newAnalysis) {
    var oldAnalysis = this.analysis;
    this.analysis = newAnalysis;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE__ANALYSIS, oldAnalysis, this.analysis));
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
      case PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE__ANALYSIS:
        return getAnalysis();
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
      case PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE__ANALYSIS:
        setAnalysis((IPLGSNAnalysis)newValue);
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
      case PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE__ANALYSIS:
        setAnalysis(PLGSNAnalyticTemplateImpl.ANALYSIS_EDEFAULT);
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
      case PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE__ANALYSIS:
        return PLGSNAnalyticTemplateImpl.ANALYSIS_EDEFAULT == null ? this.analysis != null : !PLGSNAnalyticTemplateImpl.ANALYSIS_EDEFAULT.equals(this.analysis);
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
    result.append(" (analysis: ");
    result.append(this.analysis);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public void import_(ProductLine productLine) throws Exception {
    var javaPath = MIDDialogs.selectFile("Import analysis template", "Select a Java class that implements the analysis",
                                         "There are no Java files in the workspace", Set.of("java"));
    setAttribute(GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate_AnalysisPath(), javaPath);
    super.import_(productLine);
    getAnalysis().import_(this, productLine);
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

  /**
   * @generated NOT
   */
  @Override
  public EList<PLGSNChangeStep> nextImpactSteps(PLGSNChangeStep step) throws Exception {
    return ECollections.asEList(getAnalysis().nextImpactSteps(this, step));
  }

  /**
   * @generated NOT
   */
  @Override
  public void impact(PLGSNChangeStep step) throws Exception {
    getAnalysis().impact(this, step);
  }

  /**
   * @generated NOT
   */
  @Override
  public EList<PLGSNChangeStep> nextRepairSteps(PLGSNChangeStep step) throws Exception {
    return ECollections.asEList(getAnalysis().nextRepairSteps(this, step));
  }

  /**
   * @generated NOT
   */
  @Override
  public void repair(PLGSNChangeStep step) throws Exception {
    getAnalysis().repair(this, step);
  }

} //GSNPLAnalysisTemplateImpl
