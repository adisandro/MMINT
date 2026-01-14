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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see edu.toronto.cs.se.mmint.types.fta.FTAFactory
 * @model kind="package"
 * @generated
 */
public interface FTAPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fta";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "model://edu.toronto.cs.se.mmint.types.fta";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fta";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FTAPackage eINSTANCE = edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.fta.impl.FaultTreeImpl <em>Fault Tree</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.fta.impl.FaultTreeImpl
   * @see edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl#getFaultTree()
   * @generated
   */
  int FAULT_TREE = 0;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAULT_TREE__EVENTS = 0;

  /**
   * The feature id for the '<em><b>Top Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAULT_TREE__TOP_EVENT = 1;

  /**
   * The number of structural features of the '<em>Fault Tree</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAULT_TREE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Fault Tree</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAULT_TREE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.fta.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.fta.impl.EventImpl
   * @see edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl#getEvent()
   * @generated
   */
  int EVENT = 1;

  /**
   * The feature id for the '<em><b>Probability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__PROBABILITY = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__NAME = 1;

  /**
   * The feature id for the '<em><b>Gate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__GATE = 2;

  /**
   * The feature id for the '<em><b>Super Gate</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__SUPER_GATE = 3;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.fta.impl.GateImpl <em>Gate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.fta.impl.GateImpl
   * @see edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl#getGate()
   * @generated
   */
  int GATE = 2;

  /**
   * The feature id for the '<em><b>Sub Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GATE__SUB_EVENTS = 0;

  /**
   * The feature id for the '<em><b>Logic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GATE__LOGIC = 1;

  /**
   * The number of structural features of the '<em>Gate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GATE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Gate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GATE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.fta.GateLogic <em>Gate Logic</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.fta.GateLogic
   * @see edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl#getGateLogic()
   * @generated
   */
  int GATE_LOGIC = 3;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.fta.FaultTree <em>Fault Tree</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fault Tree</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.FaultTree
   * @generated
   */
  EClass getFaultTree();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.types.fta.FaultTree#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.FaultTree#getEvents()
   * @see #getFaultTree()
   * @generated
   */
  EReference getFaultTree_Events();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.types.fta.FaultTree#getTopEvent <em>Top Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Top Event</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.FaultTree#getTopEvent()
   * @see #getFaultTree()
   * @generated
   */
  EReference getFaultTree_TopEvent();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.fta.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.fta.Event#getProbability <em>Probability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Probability</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.Event#getProbability()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Probability();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.fta.Event#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.Event#getName()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Name();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint.types.fta.Event#getGate <em>Gate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Gate</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.Event#getGate()
   * @see #getEvent()
   * @generated
   */
  EReference getEvent_Gate();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.types.fta.Event#getSuperGate <em>Super Gate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super Gate</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.Event#getSuperGate()
   * @see #getEvent()
   * @generated
   */
  EReference getEvent_SuperGate();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.fta.Gate <em>Gate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gate</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.Gate
   * @generated
   */
  EClass getGate();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.types.fta.Gate#getSubEvents <em>Sub Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sub Events</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.Gate#getSubEvents()
   * @see #getGate()
   * @generated
   */
  EReference getGate_SubEvents();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.fta.Gate#getLogic <em>Logic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Logic</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.Gate#getLogic()
   * @see #getGate()
   * @generated
   */
  EAttribute getGate_Logic();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.mmint.types.fta.GateLogic <em>Gate Logic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Gate Logic</em>'.
   * @see edu.toronto.cs.se.mmint.types.fta.GateLogic
   * @generated
   */
  EEnum getGateLogic();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FTAFactory getFTAFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.fta.impl.FaultTreeImpl <em>Fault Tree</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.fta.impl.FaultTreeImpl
     * @see edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl#getFaultTree()
     * @generated
     */
    EClass FAULT_TREE = FTAPackage.eINSTANCE.getFaultTree();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAULT_TREE__EVENTS = FTAPackage.eINSTANCE.getFaultTree_Events();

    /**
     * The meta object literal for the '<em><b>Top Event</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAULT_TREE__TOP_EVENT = FTAPackage.eINSTANCE.getFaultTree_TopEvent();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.fta.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.fta.impl.EventImpl
     * @see edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = FTAPackage.eINSTANCE.getEvent();

    /**
     * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__PROBABILITY = FTAPackage.eINSTANCE.getEvent_Probability();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__NAME = FTAPackage.eINSTANCE.getEvent_Name();

    /**
     * The meta object literal for the '<em><b>Gate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT__GATE = FTAPackage.eINSTANCE.getEvent_Gate();

    /**
     * The meta object literal for the '<em><b>Super Gate</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT__SUPER_GATE = FTAPackage.eINSTANCE.getEvent_SuperGate();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.fta.impl.GateImpl <em>Gate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.fta.impl.GateImpl
     * @see edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl#getGate()
     * @generated
     */
    EClass GATE = FTAPackage.eINSTANCE.getGate();

    /**
     * The meta object literal for the '<em><b>Sub Events</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GATE__SUB_EVENTS = FTAPackage.eINSTANCE.getGate_SubEvents();

    /**
     * The meta object literal for the '<em><b>Logic</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GATE__LOGIC = FTAPackage.eINSTANCE.getGate_Logic();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.fta.GateLogic <em>Gate Logic</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.fta.GateLogic
     * @see edu.toronto.cs.se.mmint.types.fta.impl.FTAPackageImpl#getGateLogic()
     * @generated
     */
    EEnum GATE_LOGIC = FTAPackage.eINSTANCE.getGateLogic();

  }

} //FTAPackage
