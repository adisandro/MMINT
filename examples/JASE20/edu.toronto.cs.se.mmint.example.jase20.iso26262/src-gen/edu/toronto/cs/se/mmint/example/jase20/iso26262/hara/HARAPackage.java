/*******************************************************************************
 * Copyright (c) 2012, 2023 Alessio Di Sandro.
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAFactory
 * @model kind="package"
 * @generated
 */
public interface HARAPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "hara";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "edu.toronto.cs.se.mmint.example.jase20.iso26262.hara";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "hara";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HARAPackage eINSTANCE = edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARARootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARARootImpl
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl#getHARARoot()
   * @generated
   */
  int HARA_ROOT = 0;

  /**
   * The feature id for the '<em><b>Hazards</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARA_ROOT__HAZARDS = 0;

  /**
   * The feature id for the '<em><b>Situations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARA_ROOT__SITUATIONS = 1;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARA_ROOT__EVENTS = 2;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARA_ROOT_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HARA_ROOT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardImpl <em>Hazard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardImpl
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl#getHazard()
   * @generated
   */
  int HAZARD = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__DESCRIPTION = 0;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__EVENTS = 1;

  /**
   * The number of structural features of the '<em>Hazard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Hazard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.OperationalSituationImpl <em>Operational Situation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.OperationalSituationImpl
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl#getOperationalSituation()
   * @generated
   */
  int OPERATIONAL_SITUATION = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATIONAL_SITUATION__DESCRIPTION = 0;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATIONAL_SITUATION__EVENTS = 1;

  /**
   * The number of structural features of the '<em>Operational Situation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATIONAL_SITUATION_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Operational Situation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATIONAL_SITUATION_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl <em>Hazardous Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl#getHazardousEvent()
   * @generated
   */
  int HAZARDOUS_EVENT = 3;

  /**
   * The feature id for the '<em><b>Hazard</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARDOUS_EVENT__HAZARD = 0;

  /**
   * The feature id for the '<em><b>Situation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARDOUS_EVENT__SITUATION = 1;

  /**
   * The feature id for the '<em><b>Severity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARDOUS_EVENT__SEVERITY = 2;

  /**
   * The feature id for the '<em><b>Exposure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARDOUS_EVENT__EXPOSURE = 3;

  /**
   * The feature id for the '<em><b>Controllability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARDOUS_EVENT__CONTROLLABILITY = 4;

  /**
   * The feature id for the '<em><b>ASIL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARDOUS_EVENT__ASIL = 5;

  /**
   * The number of structural features of the '<em>Hazardous Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARDOUS_EVENT_FEATURE_COUNT = 6;

  /**
   * The number of operations of the '<em>Hazardous Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARDOUS_EVENT_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot
   * @generated
   */
  EClass getHARARoot();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getHazards <em>Hazards</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Hazards</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getHazards()
   * @see #getHARARoot()
   * @generated
   */
  EReference getHARARoot_Hazards();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getSituations <em>Situations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Situations</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getSituations()
   * @see #getHARARoot()
   * @generated
   */
  EReference getHARARoot_Situations();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot#getEvents()
   * @see #getHARARoot()
   * @generated
   */
  EReference getHARARoot_Events();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard <em>Hazard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hazard</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard
   * @generated
   */
  EClass getHazard();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getDescription()
   * @see #getHazard()
   * @generated
   */
  EAttribute getHazard_Description();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Events</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard#getEvents()
   * @see #getHazard()
   * @generated
   */
  EReference getHazard_Events();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation <em>Operational Situation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operational Situation</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation
   * @generated
   */
  EClass getOperationalSituation();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation#getDescription()
   * @see #getOperationalSituation()
   * @generated
   */
  EAttribute getOperationalSituation_Description();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Events</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation#getEvents()
   * @see #getOperationalSituation()
   * @generated
   */
  EReference getOperationalSituation_Events();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent <em>Hazardous Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hazardous Event</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent
   * @generated
   */
  EClass getHazardousEvent();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getHazard <em>Hazard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Hazard</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getHazard()
   * @see #getHazardousEvent()
   * @generated
   */
  EReference getHazardousEvent_Hazard();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getSituation <em>Situation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Situation</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getSituation()
   * @see #getHazardousEvent()
   * @generated
   */
  EReference getHazardousEvent_Situation();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getSeverity <em>Severity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Severity</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getSeverity()
   * @see #getHazardousEvent()
   * @generated
   */
  EAttribute getHazardousEvent_Severity();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getExposure <em>Exposure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exposure</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getExposure()
   * @see #getHazardousEvent()
   * @generated
   */
  EAttribute getHazardousEvent_Exposure();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getControllability <em>Controllability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Controllability</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getControllability()
   * @see #getHazardousEvent()
   * @generated
   */
  EAttribute getHazardousEvent_Controllability();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getASIL <em>ASIL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ASIL</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent#getASIL()
   * @see #getHazardousEvent()
   * @generated
   */
  EAttribute getHazardousEvent_ASIL();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  HARAFactory getHARAFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARARootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARARootImpl
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl#getHARARoot()
     * @generated
     */
    EClass HARA_ROOT = eINSTANCE.getHARARoot();

    /**
     * The meta object literal for the '<em><b>Hazards</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HARA_ROOT__HAZARDS = eINSTANCE.getHARARoot_Hazards();

    /**
     * The meta object literal for the '<em><b>Situations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HARA_ROOT__SITUATIONS = eINSTANCE.getHARARoot_Situations();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HARA_ROOT__EVENTS = eINSTANCE.getHARARoot_Events();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardImpl <em>Hazard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardImpl
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl#getHazard()
     * @generated
     */
    EClass HAZARD = eINSTANCE.getHazard();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HAZARD__DESCRIPTION = eINSTANCE.getHazard_Description();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAZARD__EVENTS = eINSTANCE.getHazard_Events();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.OperationalSituationImpl <em>Operational Situation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.OperationalSituationImpl
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl#getOperationalSituation()
     * @generated
     */
    EClass OPERATIONAL_SITUATION = eINSTANCE.getOperationalSituation();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATIONAL_SITUATION__DESCRIPTION = eINSTANCE.getOperationalSituation_Description();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATIONAL_SITUATION__EVENTS = eINSTANCE.getOperationalSituation_Events();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl <em>Hazardous Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HazardousEventImpl
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl#getHazardousEvent()
     * @generated
     */
    EClass HAZARDOUS_EVENT = eINSTANCE.getHazardousEvent();

    /**
     * The meta object literal for the '<em><b>Hazard</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAZARDOUS_EVENT__HAZARD = eINSTANCE.getHazardousEvent_Hazard();

    /**
     * The meta object literal for the '<em><b>Situation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAZARDOUS_EVENT__SITUATION = eINSTANCE.getHazardousEvent_Situation();

    /**
     * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HAZARDOUS_EVENT__SEVERITY = eINSTANCE.getHazardousEvent_Severity();

    /**
     * The meta object literal for the '<em><b>Exposure</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HAZARDOUS_EVENT__EXPOSURE = eINSTANCE.getHazardousEvent_Exposure();

    /**
     * The meta object literal for the '<em><b>Controllability</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HAZARDOUS_EVENT__CONTROLLABILITY = eINSTANCE.getHazardousEvent_Controllability();

    /**
     * The meta object literal for the '<em><b>ASIL</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HAZARDOUS_EVENT__ASIL = eINSTANCE.getHazardousEvent_ASIL();

  }

} //HARAPackage
