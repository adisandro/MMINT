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

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.Event#getProbability <em>Probability</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.Event#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.Event#getGate <em>Gate</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.Event#getSuperGate <em>Super Gate</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends EObject {
  /**
   * Returns the value of the '<em><b>Probability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Probability</em>' attribute.
   * @see #setProbability(BigDecimal)
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getEvent_Probability()
   * @model
   * @generated
   */
  BigDecimal getProbability();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.fta.Event#getProbability <em>Probability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Probability</em>' attribute.
   * @see #getProbability()
   * @generated
   */
  void setProbability(BigDecimal value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getEvent_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.fta.Event#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Gate</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.types.fta.Gate#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gate</em>' containment reference.
   * @see #setGate(Gate)
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getEvent_Gate()
   * @see edu.toronto.cs.se.mmint.types.fta.Gate#getEvent
   * @model opposite="event" containment="true"
   * @generated
   */
  Gate getGate();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.fta.Event#getGate <em>Gate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gate</em>' containment reference.
   * @see #getGate()
   * @generated
   */
  void setGate(Gate value);

  /**
   * Returns the value of the '<em><b>Super Gate</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.types.fta.Gate#getSubEvents <em>Sub Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Gate</em>' reference.
   * @see #setSuperGate(Gate)
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getEvent_SuperGate()
   * @see edu.toronto.cs.se.mmint.types.fta.Gate#getSubEvents
   * @model opposite="subEvents"
   * @generated
   */
  Gate getSuperGate();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.fta.Event#getSuperGate <em>Super Gate</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Gate</em>' reference.
   * @see #getSuperGate()
   * @generated
   */
  void setSuperGate(Gate value);

} // Event
