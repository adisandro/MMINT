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

import edu.toronto.cs.se.mmint.productline.ProductLine;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage#getGSNPLTemplate()
 * @model
 * @generated
 */
public interface GSNPLTemplate extends edu.toronto.cs.se.mmint.productline.Class {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.types.gsn.productline.Exception"
   * @generated
   */
  void validate() throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.types.gsn.productline.Exception" productLineRequired="true"
   * @generated
   */
  void import_(ProductLine productLine) throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.types.gsn.productline.Exception"
   * @generated
   */
  void instantiate() throws Exception;
} // GSNPLTemplate
