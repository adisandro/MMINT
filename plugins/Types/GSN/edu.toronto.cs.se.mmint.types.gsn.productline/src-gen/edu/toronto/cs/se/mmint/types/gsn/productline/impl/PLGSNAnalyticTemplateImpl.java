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
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.wiring.BundleWiring;

import edu.toronto.cs.se.mmint.MMINTException;
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
 *
 * @generated
 */
public class PLGSNAnalyticTemplateImpl extends PLGSNTemplateImpl implements PLGSNAnalyticTemplate {
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
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE___GET_ANALYSIS:
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
   * @generated NOT
   */
  @Override
  public IPLGSNAnalysis getAnalysis() throws Exception {
    var javaPath = getListOfAttribute(GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate_AnalysisPath());
    if (javaPath.isEmpty()) {
      throw new MMINTException("Missing analysis runner Java path");
    }
    var bundleName = getListOfAttribute(GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate_LoaderBundleName());
    var classLoader = getClass().getClassLoader();
    if (!bundleName.isEmpty()) {
      var bundle = Platform.getBundle(bundleName.get(0));
      if (bundle != null) {
        classLoader = bundle.adapt(BundleWiring.class).getClassLoader();
      }
    }
    return (IPLGSNAnalysis) FileUtils.loadClassFromWorkspace(javaPath.get(0), classLoader);
  }

  /**
   * @generated NOT
   */
  @Override
  public void import_(ProductLine productLine) throws Exception {
    var javaPath = MIDDialogs.selectFile("Import analysis template", "Select a Java class that implements the analysis",
                                         "There are no Java files in the workspace", Set.of("java"));
    addAttribute(GSNTemplatesPackage.eINSTANCE.getAnalyticTemplate_AnalysisPath(), javaPath);
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
    var analysis = getAnalysis();
    return ECollections.asEList(analysis.nextImpactSteps(this, step));
  }

  /**
   * @generated NOT
   */
  @Override
  public void impact(PLGSNChangeStep step) throws Exception {
    var analysis = getAnalysis();
    analysis.impact(this, step);
  }

  /**
   * @generated NOT
   */
  @Override
  public EList<PLGSNChangeStep> nextRepairSteps(PLGSNChangeStep step) throws Exception {
    var analysis = getAnalysis();
    return ECollections.asEList(analysis.nextRepairSteps(this, step));
  }

  /**
   * @generated NOT
   */
  @Override
  public void repair(PLGSNChangeStep step) throws Exception {
    var analysis = getAnalysis();
    analysis.repair(this, step);
  }

} //GSNPLAnalysisTemplateImpl
