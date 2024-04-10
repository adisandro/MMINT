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
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate#getRunner <em>Runner</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalysisTemplate()
 * @model
 * @generated
 */
public interface AnalysisTemplate extends Template {
  /**
   * Returns the value of the '<em><b>Runner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Runner</em>' reference.
   * @see #setRunner(IAnalysisRunner)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalysisTemplate_Runner()
   * @model required="true"
   * @generated
   */
  IAnalysisRunner getRunner();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate#getRunner <em>Runner</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Runner</em>' reference.
   * @see #getRunner()
   * @generated
   */
  void setRunner(IAnalysisRunner value);

} // AnalysisTemplate
