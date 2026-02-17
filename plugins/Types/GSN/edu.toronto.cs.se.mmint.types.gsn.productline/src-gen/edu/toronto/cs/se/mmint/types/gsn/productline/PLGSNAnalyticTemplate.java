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
package edu.toronto.cs.se.mmint.types.gsn.productline;

import java.util.Optional;

import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate#getAnalysis <em>Analysis</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage#getPLGSNAnalyticTemplate()
 * @model
 * @generated
 */
public interface PLGSNAnalyticTemplate extends PLGSNTemplate {
  /**
   * Returns the value of the '<em><b>Analysis</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Analysis</em>' attribute.
   * @see #setAnalysis(Optional)
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage#getPLGSNAnalyticTemplate_Analysis()
   * @model dataType="edu.toronto.cs.se.mmint.types.gsn.productline.Optional&lt;edu.toronto.cs.se.mmint.types.gsn.productline.IPLGSNAnalysis&gt;" transient="true"
   * @generated
   */
  Optional<IPLGSNAnalysis> getAnalysis() throws Exception;

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate#getAnalysis <em>Analysis</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Analysis</em>' attribute.
   * @see #getAnalysis()
   * @generated
   */
  void setAnalysis(Optional<IPLGSNAnalysis> value);

} // GSNPLAnalysisTemplate
