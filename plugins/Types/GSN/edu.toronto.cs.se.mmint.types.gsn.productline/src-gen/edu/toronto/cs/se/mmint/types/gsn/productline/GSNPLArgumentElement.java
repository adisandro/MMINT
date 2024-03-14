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
 * A representation of the model object '<em><b>Argument Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage#getGSNPLArgumentElement()
 * @model
 * @generated
 */
public interface GSNPLArgumentElement extends edu.toronto.cs.se.mmint.productline.Class {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.types.gsn.productline.Exception"
   * @generated
   */
  void validate(GSNPLTemplate template) throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.types.gsn.productline.Exception"
   * @generated
   */
  void instantiate(GSNPLTemplate template) throws Exception;

} // GSNPLArgumentElement
