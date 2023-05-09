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
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.TemplateElement#isValid <em>Valid</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getTemplateElement()
 * @model abstract="true"
 * @generated
 */
public interface TemplateElement extends EObject {
  /**
   * Returns the value of the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Valid</em>' attribute.
   * @see #setValid(boolean)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getTemplateElement_Valid()
   * @model required="true"
   * @generated
   */
  boolean isValid();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.TemplateElement#isValid <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Valid</em>' attribute.
   * @see #isValid()
   * @generated
   */
  void setValid(boolean value);

  /**
   * <!-- begin-user-doc -->Validates the correctness of this instantiated template element.
   *
   * @throws Exception
   *           If this template element has not been instantiated correctly. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void validate() throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void repair() throws Exception;

} // TemplateElement
