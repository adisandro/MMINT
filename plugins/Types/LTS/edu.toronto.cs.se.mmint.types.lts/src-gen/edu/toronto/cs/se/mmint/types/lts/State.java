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
package edu.toronto.cs.se.mmint.types.lts;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.State#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.State#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getState()
 * @model
 * @generated
 */
public interface State extends LabeledElement {
  /**
   * Returns the value of the '<em><b>Incoming</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.types.lts.Transition}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.types.lts.Transition#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' reference list.
   * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getState_Incoming()
   * @see edu.toronto.cs.se.mmint.types.lts.Transition#getTo
   * @model opposite="to"
   * @generated
   */
  EList<Transition> getIncoming();

  /**
   * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.types.lts.Transition}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.types.lts.Transition#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' reference list.
   * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getState_Outgoing()
   * @see edu.toronto.cs.se.mmint.types.lts.Transition#getFrom
   * @model opposite="from"
   * @generated
   */
  EList<Transition> getOutgoing();

} // State
