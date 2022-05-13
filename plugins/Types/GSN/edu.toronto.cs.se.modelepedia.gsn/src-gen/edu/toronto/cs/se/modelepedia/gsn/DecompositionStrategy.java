/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Decomposition Strategy</b></em>'. <!--
 * end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getDecompositionStrategy()
 * @model abstract="true"
 * @generated
 */
public interface DecompositionStrategy extends Strategy {
  /**
   * <!-- begin-user-doc -->Validates the correctness of this decomposition strategy.
   *
   * @throws Exception
   *           If the decomposition is not correct. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void validate() throws Exception;

} // DecompositionStrategy
