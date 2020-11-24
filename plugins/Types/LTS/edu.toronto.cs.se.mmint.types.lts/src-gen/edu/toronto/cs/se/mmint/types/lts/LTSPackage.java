/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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
 * @see edu.toronto.cs.se.mmint.types.lts.LTSFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface LTSPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "lts";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "edu.toronto.cs.se.mmint.types.lts";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "lts";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LTSPackage eINSTANCE = edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.LTSImpl <em>LTS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSImpl
   * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getLTS()
   * @generated
   */
  int LTS = 0;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTS__STATES = 0;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTS__TRANSITIONS = 1;

  /**
   * The number of structural features of the '<em>LTS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTS_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>LTS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LTS_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.LabeledElementImpl <em>Labeled Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.lts.impl.LabeledElementImpl
   * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getLabeledElement()
   * @generated
   */
  int LABELED_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_ELEMENT__LABEL = 0;

  /**
   * The number of structural features of the '<em>Labeled Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Labeled Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABELED_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.lts.impl.StateImpl
   * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getState()
   * @generated
   */
  int STATE = 2;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__LABEL = LTSPackage.LABELED_ELEMENT__LABEL;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__INCOMING = LTSPackage.LABELED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__OUTGOING = LTSPackage.LABELED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = LTSPackage.LABELED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_OPERATION_COUNT = LTSPackage.LABELED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.InitialStateImpl <em>Initial State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.lts.impl.InitialStateImpl
   * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getInitialState()
   * @generated
   */
  int INITIAL_STATE = 3;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_STATE__LABEL = LTSPackage.STATE__LABEL;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_STATE__INCOMING = LTSPackage.STATE__INCOMING;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_STATE__OUTGOING = LTSPackage.STATE__OUTGOING;

  /**
   * The number of structural features of the '<em>Initial State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_STATE_FEATURE_COUNT = LTSPackage.STATE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Initial State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_STATE_OPERATION_COUNT = LTSPackage.STATE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.types.lts.impl.TransitionImpl
   * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 4;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__LABEL = LTSPackage.LABELED_ELEMENT__LABEL;

  /**
   * The feature id for the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__FROM = LTSPackage.LABELED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>To</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TO = LTSPackage.LABELED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = LTSPackage.LABELED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_OPERATION_COUNT = LTSPackage.LABELED_ELEMENT_OPERATION_COUNT + 0;


  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.lts.LTS <em>LTS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LTS</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.LTS
   * @generated
   */
  EClass getLTS();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.types.lts.LTS#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.LTS#getStates()
   * @see #getLTS()
   * @generated
   */
  EReference getLTS_States();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.types.lts.LTS#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.LTS#getTransitions()
   * @see #getLTS()
   * @generated
   */
  EReference getLTS_Transitions();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.lts.LabeledElement <em>Labeled Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Labeled Element</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.LabeledElement
   * @generated
   */
  EClass getLabeledElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.types.lts.LabeledElement#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.LabeledElement#getLabel()
   * @see #getLabeledElement()
   * @generated
   */
  EAttribute getLabeledElement_Label();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.lts.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.types.lts.State#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Incoming</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.State#getIncoming()
   * @see #getState()
   * @generated
   */
  EReference getState_Incoming();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.types.lts.State#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outgoing</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.State#getOutgoing()
   * @see #getState()
   * @generated
   */
  EReference getState_Outgoing();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.lts.InitialState <em>Initial State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initial State</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.InitialState
   * @generated
   */
  EClass getInitialState();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.types.lts.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.types.lts.Transition#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>From</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.Transition#getFrom()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_From();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.types.lts.Transition#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>To</em>'.
   * @see edu.toronto.cs.se.mmint.types.lts.Transition#getTo()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_To();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LTSFactory getLTSFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.LTSImpl <em>LTS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSImpl
     * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getLTS()
     * @generated
     */
    EClass LTS = LTSPackage.eINSTANCE.getLTS();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LTS__STATES = LTSPackage.eINSTANCE.getLTS_States();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LTS__TRANSITIONS = LTSPackage.eINSTANCE.getLTS_Transitions();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.LabeledElementImpl <em>Labeled Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.lts.impl.LabeledElementImpl
     * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getLabeledElement()
     * @generated
     */
    EClass LABELED_ELEMENT = LTSPackage.eINSTANCE.getLabeledElement();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABELED_ELEMENT__LABEL = LTSPackage.eINSTANCE.getLabeledElement_Label();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.lts.impl.StateImpl
     * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getState()
     * @generated
     */
    EClass STATE = LTSPackage.eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__INCOMING = LTSPackage.eINSTANCE.getState_Incoming();

    /**
     * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__OUTGOING = LTSPackage.eINSTANCE.getState_Outgoing();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.InitialStateImpl <em>Initial State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.lts.impl.InitialStateImpl
     * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getInitialState()
     * @generated
     */
    EClass INITIAL_STATE = LTSPackage.eINSTANCE.getInitialState();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.types.lts.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.types.lts.impl.TransitionImpl
     * @see edu.toronto.cs.se.mmint.types.lts.impl.LTSPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = LTSPackage.eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>From</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__FROM = LTSPackage.eINSTANCE.getTransition_From();

    /**
     * The meta object literal for the '<em><b>To</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TO = LTSPackage.eINSTANCE.getTransition_To();

  }

} //LTSPackage
