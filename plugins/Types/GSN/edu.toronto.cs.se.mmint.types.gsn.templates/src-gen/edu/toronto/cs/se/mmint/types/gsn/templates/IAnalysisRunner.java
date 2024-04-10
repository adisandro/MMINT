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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IAnalysis Runner</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getIAnalysisRunner()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IAnalysisRunner extends EObject {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void instantiate() throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void validate() throws Exception;

} // IAnalysisRunner
