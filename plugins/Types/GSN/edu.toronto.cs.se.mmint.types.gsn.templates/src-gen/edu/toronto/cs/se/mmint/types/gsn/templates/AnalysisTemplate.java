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

import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysisRunner;
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
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate#getRunnerPath <em>Runner Path</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalysisTemplate()
 * @model
 * @generated
 */
public interface AnalysisTemplate extends Template {
  /**
   * Returns the value of the '<em><b>Runner Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Runner Path</em>' attribute.
   * @see #setRunnerPath(String)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalysisTemplate_RunnerPath()
   * @model
   * @generated
   */
  String getRunnerPath();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate#getRunnerPath <em>Runner Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Runner Path</em>' attribute.
   * @see #getRunnerPath()
   * @generated
   */
  void setRunnerPath(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" dataType="edu.toronto.cs.se.mmint.types.gsn.templates.IAnalysisRunner" exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  IAnalysisRunner getRunner() throws Exception;

} // AnalysisTemplate
