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
package edu.toronto.cs.se.mmint.types.gsn.templates;

import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis;
import edu.toronto.cs.se.modelepedia.gsn.Template;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getAnalysisPath <em>Analysis Path</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalyticTemplate()
 * @model
 * @generated
 */
public interface AnalyticTemplate extends Template {
  /**
   * Returns the value of the '<em><b>Analysis Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Analysis Path</em>' attribute.
   * @see #setAnalysisPath(String)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalyticTemplate_AnalysisPath()
   * @model
   * @generated
   */
  String getAnalysisPath();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getAnalysisPath <em>Analysis Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Analysis Path</em>' attribute.
   * @see #getAnalysisPath()
   * @generated
   */
  void setAnalysisPath(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" dataType="edu.toronto.cs.se.mmint.types.gsn.templates.IAnalysis" exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  IAnalysis getAnalysis() throws Exception;

} // AnalysisTemplate
