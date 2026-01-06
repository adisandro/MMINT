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
 * A representation of the model object '<em><b>Fault Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.FaultTree#getEvents <em>Events</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.fta.FaultTree#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getFaultTree()
 * @model
 * @generated
 */
public interface FaultTree extends EObject {
  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.types.fta.Event}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getFaultTree_Events()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Event> getEvents();

  /**
   * Returns the value of the '<em><b>Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' reference.
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#getFaultTree_Root()
   * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  Event getRoot();

} // FaultTree
