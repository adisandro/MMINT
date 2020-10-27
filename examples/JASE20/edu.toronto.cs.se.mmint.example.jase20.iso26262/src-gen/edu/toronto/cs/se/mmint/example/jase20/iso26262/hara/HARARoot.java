/*******************************************************************************
 * Copyright (c) 2012, 2020 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.example.jase20.iso26262.hara;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getHazards <em>Hazards</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getSituations <em>Situations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getEvents <em>Events</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHARARoot()
 * @model
 * @generated
 */
public interface HARARoot extends EObject {
  /**
   * Returns the value of the '<em><b>Hazards</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hazards</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHARARoot_Hazards()
   * @model containment="true"
   * @generated
   */
  EList<Hazard> getHazards();

  /**
   * Returns the value of the '<em><b>Situations</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Situations</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHARARoot_Situations()
   * @model containment="true"
   * @generated
   */
  EList<OperationalSituation> getSituations();

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHARARoot_Events()
   * @model containment="true"
   * @generated
   */
  EList<HazardousEvent> getEvents();

} // HARARoot
