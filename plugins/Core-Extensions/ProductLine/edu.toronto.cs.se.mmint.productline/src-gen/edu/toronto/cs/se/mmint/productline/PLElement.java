/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PL Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.PLElement#getPresenceCondition <em>Presence Condition</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.productline.PLPackage#getPLElement()
 * @model abstract="true"
 * @generated
 */
public interface PLElement extends EObject {
  /**
   * Returns the value of the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Presence Condition</em>' attribute.
   * @see #setPresenceCondition(String)
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getPLElement_PresenceCondition()
   * @model
   * @generated
   */
  String getPresenceCondition();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.PLElement#getPresenceCondition <em>Presence Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Presence Condition</em>' attribute.
   * @see #getPresenceCondition()
   * @generated
   */
  void setPresenceCondition(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  ProductLine getProductLine();

  /**
   * <!-- begin-user-doc --> Checks whether this Product Line element is always present in each product, i.e. if the
   * presence condition corresponds to the TRUE literal.
   *
   * @return True if always present, false otherwise. <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  boolean isAlwaysPresent();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true" withParenthesisRequired="true"
   * @generated
   */
  String getPresenceConditionLabel(boolean withParenthesis);

} // PLElement
