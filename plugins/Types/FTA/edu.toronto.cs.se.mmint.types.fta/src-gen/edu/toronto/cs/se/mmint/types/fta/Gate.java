/*******************************************************************************
 * Copyright (c) 2026, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.fta;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.Gate#getSubEvents <em>Sub Events</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.Gate#getLogic <em>Logic</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getGate()
 * @model
 * @generated
 */
public interface Gate extends EObject {
  /**
   * Returns the value of the '<em><b>Sub Events</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.types.fta.Event}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.types.fta.Event#getSuperGate <em>Super Gate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Events</em>' reference list.
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getGate_SubEvents()
   * @see edu.toronto.cs.se.mmint.types.fta.Event#getSuperGate
   * @model opposite="superGate" required="true"
   * @generated
   */
  EList<Event> getSubEvents();

  /**
   * Returns the value of the '<em><b>Logic</b></em>' attribute.
   * The literals are from the enumeration {@link edu.toronto.cs.se.mmint.types.fta.GateLogic}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logic</em>' attribute.
   * @see edu.toronto.cs.se.mmint.types.fta.GateLogic
   * @see #setLogic(GateLogic)
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getGate_Logic()
   * @model required="true"
   * @generated
   */
  GateLogic getLogic();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.fta.Gate#getLogic <em>Logic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logic</em>' attribute.
   * @see edu.toronto.cs.se.mmint.types.fta.GateLogic
   * @see #getLogic()
   * @generated
   */
  void setLogic(GateLogic value);

} // Gate
