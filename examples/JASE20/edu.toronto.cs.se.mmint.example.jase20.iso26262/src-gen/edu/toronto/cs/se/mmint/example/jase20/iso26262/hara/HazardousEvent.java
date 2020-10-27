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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hazardous Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getHazard <em>Hazard</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getSituation <em>Situation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getSeverity <em>Severity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getExposure <em>Exposure</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getControllability <em>Controllability</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getASIL <em>ASIL</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazardousEvent()
 * @model
 * @generated
 */
public interface HazardousEvent extends EObject {
  /**
   * Returns the value of the '<em><b>Hazard</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hazard</em>' reference.
   * @see #setHazard(Hazard)
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazardousEvent_Hazard()
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getEvents
   * @model opposite="events" required="true"
   * @generated
   */
  Hazard getHazard();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getHazard <em>Hazard</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hazard</em>' reference.
   * @see #getHazard()
   * @generated
   */
  void setHazard(Hazard value);

  /**
   * Returns the value of the '<em><b>Situation</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Situation</em>' reference.
   * @see #setSituation(OperationalSituation)
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazardousEvent_Situation()
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation#getEvents
   * @model opposite="events" required="true"
   * @generated
   */
  OperationalSituation getSituation();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getSituation <em>Situation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Situation</em>' reference.
   * @see #getSituation()
   * @generated
   */
  void setSituation(OperationalSituation value);

  /**
   * Returns the value of the '<em><b>Severity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Severity</em>' attribute.
   * @see #setSeverity(String)
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazardousEvent_Severity()
   * @model required="true"
   * @generated
   */
  String getSeverity();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getSeverity <em>Severity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Severity</em>' attribute.
   * @see #getSeverity()
   * @generated
   */
  void setSeverity(String value);

  /**
   * Returns the value of the '<em><b>Exposure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exposure</em>' attribute.
   * @see #setExposure(String)
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazardousEvent_Exposure()
   * @model required="true"
   * @generated
   */
  String getExposure();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getExposure <em>Exposure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exposure</em>' attribute.
   * @see #getExposure()
   * @generated
   */
  void setExposure(String value);

  /**
   * Returns the value of the '<em><b>Controllability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Controllability</em>' attribute.
   * @see #setControllability(String)
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazardousEvent_Controllability()
   * @model required="true"
   * @generated
   */
  String getControllability();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getControllability <em>Controllability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Controllability</em>' attribute.
   * @see #getControllability()
   * @generated
   */
  void setControllability(String value);

  /**
   * Returns the value of the '<em><b>ASIL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>ASIL</em>' attribute.
   * @see #setASIL(String)
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#getHazardousEvent_ASIL()
   * @model required="true"
   * @generated
   */
  String getASIL();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getASIL <em>ASIL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>ASIL</em>' attribute.
   * @see #getASIL()
   * @generated
   */
  void setASIL(String value);

} // HazardousEvent
