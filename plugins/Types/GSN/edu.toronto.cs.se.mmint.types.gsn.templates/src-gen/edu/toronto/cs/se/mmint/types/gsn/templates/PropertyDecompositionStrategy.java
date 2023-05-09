/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Decomposition Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy#getReasonerName <em>Reasoner Name</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getPropertyDecompositionStrategy()
 * @model
 * @generated
 */
public interface PropertyDecompositionStrategy extends DecompositionStrategy, PropertyDecompositionElement {
  /**
   * Returns the value of the '<em><b>Reasoner Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reasoner Name</em>' attribute.
   * @see #setReasonerName(String)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getPropertyDecompositionStrategy_ReasonerName()
   * @model required="true"
   * @generated
   */
  String getReasonerName();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy#getReasonerName <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reasoner Name</em>' attribute.
   * @see #getReasonerName()
   * @generated
   */
  void setReasonerName(String value);

} // PropertyDecompositionStrategy
