/*******************************************************************************
 * Copyright (c) 2020, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.lts;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.Transition#getFrom <em>From</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.Transition#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends LabeledElement {
  /**
   * Returns the value of the '<em><b>From</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.types.lts.State#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' reference.
   * @see #setFrom(State)
   * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getTransition_From()
   * @see edu.toronto.cs.se.mmint.types.lts.State#getOutgoing
   * @model opposite="outgoing" required="true"
   * @generated
   */
  State getFrom();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.lts.Transition#getFrom <em>From</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' reference.
   * @see #getFrom()
   * @generated
   */
  void setFrom(State value);

  /**
   * Returns the value of the '<em><b>To</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.types.lts.State#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' reference.
   * @see #setTo(State)
   * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getTransition_To()
   * @see edu.toronto.cs.se.mmint.types.lts.State#getIncoming
   * @model opposite="incoming" required="true"
   * @generated
   */
  State getTo();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.lts.Transition#getTo <em>To</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' reference.
   * @see #getTo()
   * @generated
   */
  void setTo(State value);

} // Transition
