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

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IGSNPLAnalysisRunner;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class GSNPLAnalysisTemplateImpl extends GSNPLTemplateImpl implements GSNPLAnalysisTemplate {
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
   * @generated NOT
   */
  @Override
  public IGSNPLAnalysisRunner getRunner() throws Exception {
    var javaPath = getAttribute(GSNTemplatesPackage.eINSTANCE.getAnalysisTemplate_RunnerPath());
    if (javaPath.isEmpty()) {
      throw new MMINTException("Missing analysis runner Java path");
    }
    return (IGSNPLAnalysisRunner) FileUtils.loadClassFromWorkspace(javaPath.get(0), this.getClass().getClassLoader());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case GSNPLPackage.GSNPL_ANALYSIS_TEMPLATE___GET_RUNNER:
        try {
          return getRunner();
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
    try {
      getRunner().instantiate(this);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, "Failed to load runner class, skipping analysis instantiation", e);
    }
    super.instantiate();
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    try {
      getRunner().validate(this);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, "Failed to load runner class, skipping analysis validation", e);
    }
    super.validate();
  }

} //GSNPLAnalysisTemplateImpl
