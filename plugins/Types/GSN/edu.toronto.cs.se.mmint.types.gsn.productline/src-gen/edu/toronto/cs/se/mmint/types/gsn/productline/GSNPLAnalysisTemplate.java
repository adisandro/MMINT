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
package edu.toronto.cs.se.mmint.types.gsn.productline;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate#getRunner <em>Runner</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage#getGSNPLAnalysisTemplate()
 * @model
 * @generated
 */
public interface GSNPLAnalysisTemplate extends GSNPLTemplate {
  /**
   * Returns the value of the '<em><b>Runner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Runner</em>' reference.
   * @see #setRunner(GSNPLAnalysisRunner)
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage#getGSNPLAnalysisTemplate_Runner()
   * @model transient="true"
   * @generated
   */
  GSNPLAnalysisRunner getRunner();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate#getRunner <em>Runner</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Runner</em>' reference.
   * @see #getRunner()
   * @generated
   */
  void setRunner(GSNPLAnalysisRunner value);

} // GSNPLAnalysisTemplate
