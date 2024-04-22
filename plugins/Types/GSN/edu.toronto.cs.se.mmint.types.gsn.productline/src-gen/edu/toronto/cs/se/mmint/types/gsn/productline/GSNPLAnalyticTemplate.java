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

import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IGSNPLAnalysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Template</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage#getGSNPLAnalyticTemplate()
 * @model
 * @generated
 */
public interface GSNPLAnalyticTemplate extends GSNPLTemplate {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" dataType="edu.toronto.cs.se.mmint.types.gsn.productline.IGSNPLAnalysis" exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  IGSNPLAnalysis getAnalysis() throws Exception;

} // GSNPLAnalysisTemplate
