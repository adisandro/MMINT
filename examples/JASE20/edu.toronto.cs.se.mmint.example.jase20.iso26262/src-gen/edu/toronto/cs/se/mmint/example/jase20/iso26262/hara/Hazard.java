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
 * A representation of the model object '<em><b>Hazard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getEvents <em>Events</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazard()
 * @model
 * @generated
 */
public interface Hazard extends EObject {
  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazard_Description()
   * @model required="true"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Events</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getHazard <em>Hazard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' reference list.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazard_Events()
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getHazard
   * @model opposite="hazard"
   * @generated
   */
  EList<HazardousEvent> getEvents();

} // Hazard
