/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 * 
 */
package edu.toronto.cs.se.modelepedia.safetycase;

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
 * @see edu.toronto.cs.se.modelepedia.safetycase.GSNFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface GSNPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "safetycase";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://se.cs.toronto.edu/modelepedia/GSN";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "safetycase";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GSNPackage eINSTANCE = edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSafetyCase()
   * @generated
   */
  int SAFETY_CASE = 0;

  /**
   * The feature id for the '<em><b>Goals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__GOALS = 0;

  /**
   * The feature id for the '<em><b>Strategies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__STRATEGIES = 1;

  /**
   * The feature id for the '<em><b>Solutions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__SOLUTIONS = 2;

  /**
   * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__CONTEXTS = 3;

  /**
   * The feature id for the '<em><b>Justifications</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__JUSTIFICATIONS = 4;

  /**
   * The feature id for the '<em><b>Assumptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__ASSUMPTIONS = 5;

  /**
   * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__CONNECTORS = 6;

  /**
   * The number of structural features of the '<em>Safety Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE_FEATURE_COUNT = 7;

  /**
   * The number of operations of the '<em>Safety Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ArgumentElementImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getArgumentElement()
   * @generated
   */
  int ARGUMENT_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__ID = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__DESCRIPTION = 1;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__CONTENT_VALIDITY = 2;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__STATUS = 3;

  /**
   * The number of structural features of the '<em>Argument Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Argument Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl <em>Stateful Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getStatefulElement()
   * @generated
   */
  int STATEFUL_ELEMENT = 2;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEFUL_ELEMENT__STATE_VALIDITY = 0;

  /**
   * The number of structural features of the '<em>Stateful Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEFUL_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Stateful Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEFUL_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILfulElementImpl <em>ASI Lful Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILfulElementImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getASILfulElement()
   * @generated
   */
  int ASI_LFUL_ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASI_LFUL_ELEMENT__ASIL = 0;

  /**
   * The number of structural features of the '<em>ASI Lful Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASI_LFUL_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>ASI Lful Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASI_LFUL_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.CoreElementImpl <em>Core Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.CoreElementImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getCoreElement()
   * @generated
   */
  int CORE_ELEMENT = 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__ID = ARGUMENT_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__DESCRIPTION = ARGUMENT_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__CONTENT_VALIDITY = ARGUMENT_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__STATUS = ARGUMENT_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__SUPPORTS = ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Core Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT_FEATURE_COUNT = ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Core Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT_OPERATION_COUNT = ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SupporterImpl <em>Supporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SupporterImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSupporter()
   * @generated
   */
  int SUPPORTER = 23;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER__SUPPORTS = 0;

  /**
   * The number of structural features of the '<em>Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SupportableImpl <em>Supportable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SupportableImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSupportable()
   * @generated
   */
  int SUPPORTABLE = 22;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__SUPPORTS = SUPPORTER__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__SUPPORTED_BY = SUPPORTER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Supportable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE_FEATURE_COUNT = SUPPORTER_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Supportable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE_OPERATION_COUNT = SUPPORTER_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl <em>Decomposable Core Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getDecomposableCoreElement()
   * @generated
   */
  int DECOMPOSABLE_CORE_ELEMENT = 5;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__SUPPORTS = SUPPORTABLE__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY = SUPPORTABLE__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__ID = SUPPORTABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION = SUPPORTABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY = SUPPORTABLE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__STATUS = SUPPORTABLE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = SUPPORTABLE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Decomposable Core Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT = SUPPORTABLE_FEATURE_COUNT + 5;

  /**
   * The number of operations of the '<em>Decomposable Core Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT = SUPPORTABLE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContextualElementImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getContextualElement()
   * @generated
   */
  int CONTEXTUAL_ELEMENT = 6;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__ID = ARGUMENT_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__DESCRIPTION = ARGUMENT_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__CONTENT_VALIDITY = ARGUMENT_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__STATUS = ARGUMENT_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__CONTEXT_OF = ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Contextual Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT_FEATURE_COUNT = ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Contextual Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT_OPERATION_COUNT = ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SupportedByImpl <em>Supported By</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SupportedByImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSupportedBy()
   * @generated
   */
  int SUPPORTED_BY = 7;

  /**
   * The feature id for the '<em><b>Source</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTED_BY__SOURCE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTED_BY__TARGET = 1;

  /**
   * The number of structural features of the '<em>Supported By</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTED_BY_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Supported By</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTED_BY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.InContextOfImpl <em>In Context Of</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.InContextOfImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getInContextOf()
   * @generated
   */
  int IN_CONTEXT_OF = 8;

  /**
   * The feature id for the '<em><b>Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_CONTEXT_OF__CONTEXT = 0;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_CONTEXT_OF__CONTEXT_OF = 1;

  /**
   * The number of structural features of the '<em>In Context Of</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_CONTEXT_OF_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>In Context Of</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_CONTEXT_OF_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl <em>Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getGoal()
   * @generated
   */
  int GOAL = 9;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__SUPPORTS = DECOMPOSABLE_CORE_ELEMENT__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__SUPPORTED_BY = DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ID = DECOMPOSABLE_CORE_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DESCRIPTION = DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CONTENT_VALIDITY = DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__STATUS = DECOMPOSABLE_CORE_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__IN_CONTEXT_OF = DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__STATE_VALIDITY = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ASIL = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FEATURE_COUNT = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_OPERATION_COUNT = DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.BasicGoalImpl <em>Basic Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.BasicGoalImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getBasicGoal()
   * @generated
   */
  int BASIC_GOAL = 10;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__SUPPORTS = GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__SUPPORTED_BY = GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__ID = GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__DESCRIPTION = GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__CONTENT_VALIDITY = GOAL__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__STATUS = GOAL__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__IN_CONTEXT_OF = GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__STATE_VALIDITY = GOAL__STATE_VALIDITY;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__ASIL = GOAL__ASIL;

  /**
   * The number of structural features of the '<em>Basic Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL_FEATURE_COUNT = GOAL_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Basic Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL_OPERATION_COUNT = GOAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.IndependenceGoalImpl <em>Independence Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.IndependenceGoalImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getIndependenceGoal()
   * @generated
   */
  int INDEPENDENCE_GOAL = 11;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__SUPPORTS = GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__SUPPORTED_BY = GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__ID = GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__DESCRIPTION = GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__CONTENT_VALIDITY = GOAL__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__STATUS = GOAL__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__IN_CONTEXT_OF = GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__STATE_VALIDITY = GOAL__STATE_VALIDITY;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__ASIL = GOAL__ASIL;

  /**
   * The number of structural features of the '<em>Independence Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL_FEATURE_COUNT = GOAL_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Independence Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL_OPERATION_COUNT = GOAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DomainGoalImpl <em>Domain Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.DomainGoalImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getDomainGoal()
   * @generated
   */
  int DOMAIN_GOAL = 12;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__SUPPORTS = GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__SUPPORTED_BY = GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__ID = GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__DESCRIPTION = GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__CONTENT_VALIDITY = GOAL__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__STATUS = GOAL__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__IN_CONTEXT_OF = GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__STATE_VALIDITY = GOAL__STATE_VALIDITY;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__ASIL = GOAL__ASIL;

  /**
   * The feature id for the '<em><b>Domain</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__DOMAIN = GOAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Domain Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL_FEATURE_COUNT = GOAL_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Domain Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL_OPERATION_COUNT = GOAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl <em>Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getStrategy()
   * @generated
   */
  int STRATEGY = 13;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__SUPPORTS = DECOMPOSABLE_CORE_ELEMENT__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__SUPPORTED_BY = DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__ID = DECOMPOSABLE_CORE_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__DESCRIPTION = DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__CONTENT_VALIDITY = DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__STATUS = DECOMPOSABLE_CORE_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__IN_CONTEXT_OF = DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_FEATURE_COUNT = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_OPERATION_COUNT = DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.BasicStrategyImpl <em>Basic Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.BasicStrategyImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getBasicStrategy()
   * @generated
   */
  int BASIC_STRATEGY = 14;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__SUPPORTS = STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__SUPPORTED_BY = STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__ID = STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__DESCRIPTION = STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__CONTENT_VALIDITY = STRATEGY__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__STATUS = STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__IN_CONTEXT_OF = STRATEGY__IN_CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Basic Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Basic Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY_OPERATION_COUNT = STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILDecompositionStrategyImpl <em>ASIL Decomposition Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILDecompositionStrategyImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getASILDecompositionStrategy()
   * @generated
   */
  int ASIL_DECOMPOSITION_STRATEGY = 15;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__SUPPORTS = STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY = STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__ID = STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__DESCRIPTION = STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__CONTENT_VALIDITY = STRATEGY__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__STATUS = STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__IN_CONTEXT_OF = STRATEGY__IN_CONTEXT_OF;

  /**
   * The number of structural features of the '<em>ASIL Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>ASIL Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY_OPERATION_COUNT = STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl <em>Solution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSolution()
   * @generated
   */
  int SOLUTION = 16;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__ID = CORE_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__DESCRIPTION = CORE_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__CONTENT_VALIDITY = CORE_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__STATUS = CORE_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__SUPPORTS = CORE_ELEMENT__SUPPORTS;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__STATE_VALIDITY = CORE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Solution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_FEATURE_COUNT = CORE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Solution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_OPERATION_COUNT = CORE_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl <em>Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 17;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__ID = CONTEXTUAL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__DESCRIPTION = CONTEXTUAL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONTENT_VALIDITY = CONTEXTUAL_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__STATUS = CONTEXTUAL_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONTEXT_OF = CONTEXTUAL_ELEMENT__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_FEATURE_COUNT = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_OPERATION_COUNT = CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.JustificationImpl <em>Justification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.JustificationImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getJustification()
   * @generated
   */
  int JUSTIFICATION = 18;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__ID = CONTEXTUAL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__DESCRIPTION = CONTEXTUAL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__CONTENT_VALIDITY = CONTEXTUAL_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__STATUS = CONTEXTUAL_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__CONTEXT_OF = CONTEXTUAL_ELEMENT__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Justification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION_FEATURE_COUNT = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Justification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION_OPERATION_COUNT = CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.AssumptionImpl <em>Assumption</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.AssumptionImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getAssumption()
   * @generated
   */
  int ASSUMPTION = 19;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__ID = CONTEXTUAL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__DESCRIPTION = CONTEXTUAL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__CONTENT_VALIDITY = CONTEXTUAL_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__STATUS = CONTEXTUAL_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__CONTEXT_OF = CONTEXTUAL_ELEMENT__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Assumption</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_FEATURE_COUNT = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Assumption</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_OPERATION_COUNT = CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl <em>ASIL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getASIL()
   * @generated
   */
  int ASIL = 20;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL__VALUE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL__TARGET = 1;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL__STATUS = 2;

  /**
   * The number of structural features of the '<em>ASIL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>ASIL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ImpactAnnotationImpl <em>Impact Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ImpactAnnotationImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getImpactAnnotation()
   * @generated
   */
  int IMPACT_ANNOTATION = 21;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPACT_ANNOTATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPACT_ANNOTATION__SOURCE = 1;

  /**
   * The number of structural features of the '<em>Impact Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPACT_ANNOTATION_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Impact Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPACT_ANNOTATION_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SupportConnectorImpl <em>Support Connector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SupportConnectorImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSupportConnector()
   * @generated
   */
  int SUPPORT_CONNECTOR = 24;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORT_CONNECTOR__SUPPORTS = SUPPORTABLE__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORT_CONNECTOR__SUPPORTED_BY = SUPPORTABLE__SUPPORTED_BY;

  /**
   * The number of structural features of the '<em>Support Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORT_CONNECTOR_FEATURE_COUNT = SUPPORTABLE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Support Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORT_CONNECTOR_OPERATION_COUNT = SUPPORTABLE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.AndSupporterImpl <em>And Supporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.AndSupporterImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getAndSupporter()
   * @generated
   */
  int AND_SUPPORTER = 25;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SUPPORTER__SUPPORTS = SUPPORT_CONNECTOR__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SUPPORTER__SUPPORTED_BY = SUPPORT_CONNECTOR__SUPPORTED_BY;

  /**
   * The number of structural features of the '<em>And Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SUPPORTER_FEATURE_COUNT = SUPPORT_CONNECTOR_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>And Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SUPPORTER_OPERATION_COUNT = SUPPORT_CONNECTOR_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.OrSupporterImpl <em>Or Supporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.OrSupporterImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getOrSupporter()
   * @generated
   */
  int OR_SUPPORTER = 26;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_SUPPORTER__SUPPORTS = SUPPORT_CONNECTOR__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_SUPPORTER__SUPPORTED_BY = SUPPORT_CONNECTOR__SUPPORTED_BY;

  /**
   * The number of structural features of the '<em>Or Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_SUPPORTER_FEATURE_COUNT = SUPPORT_CONNECTOR_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Or Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_SUPPORTER_OPERATION_COUNT = SUPPORT_CONNECTOR_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.XorSupporterImpl <em>Xor Supporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.XorSupporterImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getXorSupporter()
   * @generated
   */
  int XOR_SUPPORTER = 27;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_SUPPORTER__SUPPORTS = SUPPORT_CONNECTOR__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_SUPPORTER__SUPPORTED_BY = SUPPORT_CONNECTOR__SUPPORTED_BY;

  /**
   * The number of structural features of the '<em>Xor Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_SUPPORTER_FEATURE_COUNT = SUPPORT_CONNECTOR_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Xor Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_SUPPORTER_OPERATION_COUNT = SUPPORT_CONNECTOR_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.MofNSupporterImpl <em>Mof NSupporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.MofNSupporterImpl
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getMofNSupporter()
   * @generated
   */
  int MOF_NSUPPORTER = 28;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER__SUPPORTS = SUPPORT_CONNECTOR__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER__SUPPORTED_BY = SUPPORT_CONNECTOR__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER__TARGET = SUPPORT_CONNECTOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Mof NSupporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER_FEATURE_COUNT = SUPPORT_CONNECTOR_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Mof NSupporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER_OPERATION_COUNT = SUPPORT_CONNECTOR_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILLevel <em>ASIL Level</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASILLevel
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getASILLevel()
   * @generated
   */
  int ASIL_LEVEL = 29;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ValidityValue <em>Validity Value</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getValidityValue()
   * @generated
   */
  int VALIDITY_VALUE = 30;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ImpactType <em>Impact Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.safetycase.ImpactType
   * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getImpactType()
   * @generated
   */
  int IMPACT_TYPE = 31;


  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase <em>Safety Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Safety Case</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCase
   * @generated
   */
  EClass getSafetyCase();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getGoals <em>Goals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Goals</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getGoals()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Goals();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getStrategies <em>Strategies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Strategies</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getStrategies()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Strategies();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getSolutions <em>Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Solutions</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getSolutions()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Solutions();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getContexts <em>Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contexts</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getContexts()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Contexts();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getJustifications <em>Justifications</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Justifications</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getJustifications()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Justifications();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getAssumptions <em>Assumptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assumptions</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getAssumptions()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Assumptions();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getConnectors <em>Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connectors</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getConnectors()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Connectors();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement <em>Argument Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement
   * @generated
   */
  EClass getArgumentElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getId()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_Id();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getDescription()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_Description();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getContentValidity <em>Content Validity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content Validity</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getContentValidity()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_ContentValidity();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getStatus <em>Status</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Status</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getStatus()
   * @see #getArgumentElement()
   * @generated
   */
  EReference getArgumentElement_Status();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.StatefulElement <em>Stateful Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stateful Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.StatefulElement
   * @generated
   */
  EClass getStatefulElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.StatefulElement#getStateValidity <em>State Validity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Validity</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.StatefulElement#getStateValidity()
   * @see #getStatefulElement()
   * @generated
   */
  EAttribute getStatefulElement_StateValidity();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement <em>ASI Lful Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASI Lful Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement
   * @generated
   */
  EClass getASILfulElement();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement#getAsil <em>Asil</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Asil</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement#getAsil()
   * @see #getASILfulElement()
   * @generated
   */
  EReference getASILfulElement_Asil();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.CoreElement <em>Core Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Core Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.CoreElement
   * @generated
   */
  EClass getCoreElement();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement <em>Decomposable Core Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decomposable Core Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement
   * @generated
   */
  EClass getDecomposableCoreElement();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement#getInContextOf <em>In Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>In Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement#getInContextOf()
   * @see #getDecomposableCoreElement()
   * @generated
   */
  EReference getDecomposableCoreElement_InContextOf();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ContextualElement <em>Contextual Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contextual Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ContextualElement
   * @generated
   */
  EClass getContextualElement();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.ContextualElement#getContextOf <em>Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ContextualElement#getContextOf()
   * @see #getContextualElement()
   * @generated
   */
  EReference getContextualElement_ContextOf();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy <em>Supported By</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Supported By</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SupportedBy
   * @generated
   */
  EClass getSupportedBy();

  /**
   * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Source</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getSource()
   * @see #getSupportedBy()
   * @generated
   */
  EReference getSupportedBy_Source();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getTarget()
   * @see #getSupportedBy()
   * @generated
   */
  EReference getSupportedBy_Target();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.InContextOf <em>In Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>In Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.InContextOf
   * @generated
   */
  EClass getInContextOf();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.safetycase.InContextOf#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Context</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.InContextOf#getContext()
   * @see #getInContextOf()
   * @generated
   */
  EReference getInContextOf_Context();

  /**
   * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.safetycase.InContextOf#getContextOf <em>Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.InContextOf#getContextOf()
   * @see #getInContextOf()
   * @generated
   */
  EReference getInContextOf_ContextOf();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.Goal <em>Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Goal
   * @generated
   */
  EClass getGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.BasicGoal <em>Basic Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.BasicGoal
   * @generated
   */
  EClass getBasicGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.IndependenceGoal <em>Independence Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Independence Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.IndependenceGoal
   * @generated
   */
  EClass getIndependenceGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.DomainGoal <em>Domain Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.DomainGoal
   * @generated
   */
  EClass getDomainGoal();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.DomainGoal#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Domain</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.DomainGoal#getDomain()
   * @see #getDomainGoal()
   * @generated
   */
  EAttribute getDomainGoal_Domain();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.Strategy <em>Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Strategy
   * @generated
   */
  EClass getStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.BasicStrategy <em>Basic Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.BasicStrategy
   * @generated
   */
  EClass getBasicStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy <em>ASIL Decomposition Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASIL Decomposition Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy
   * @generated
   */
  EClass getASILDecompositionStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.Solution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Solution</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Solution
   * @generated
   */
  EClass getSolution();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.Context <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Context
   * @generated
   */
  EClass getContext();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.Justification <em>Justification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Justification</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Justification
   * @generated
   */
  EClass getJustification();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.Assumption <em>Assumption</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assumption</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Assumption
   * @generated
   */
  EClass getAssumption();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL <em>ASIL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASIL</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL
   * @generated
   */
  EClass getASIL();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL#getValue()
   * @see #getASIL()
   * @generated
   */
  EAttribute getASIL_Value();

  /**
   * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL#getTarget()
   * @see #getASIL()
   * @generated
   */
  EReference getASIL_Target();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getStatus <em>Status</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Status</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL#getStatus()
   * @see #getASIL()
   * @generated
   */
  EReference getASIL_Status();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation <em>Impact Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Impact Annotation</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation
   * @generated
   */
  EClass getImpactAnnotation();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation#getType()
   * @see #getImpactAnnotation()
   * @generated
   */
  EAttribute getImpactAnnotation_Type();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation#getSource()
   * @see #getImpactAnnotation()
   * @generated
   */
  EAttribute getImpactAnnotation_Source();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.Supportable <em>Supportable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Supportable</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Supportable
   * @generated
   */
  EClass getSupportable();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.Supportable#getSupportedBy <em>Supported By</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supported By</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Supportable#getSupportedBy()
   * @see #getSupportable()
   * @generated
   */
  EReference getSupportable_SupportedBy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.Supporter <em>Supporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Supporter
   * @generated
   */
  EClass getSupporter();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.Supporter#getSupports <em>Supports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supports</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.Supporter#getSupports()
   * @see #getSupporter()
   * @generated
   */
  EReference getSupporter_Supports();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportConnector <em>Support Connector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Support Connector</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.SupportConnector
   * @generated
   */
  EClass getSupportConnector();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.AndSupporter <em>And Supporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.AndSupporter
   * @generated
   */
  EClass getAndSupporter();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.OrSupporter <em>Or Supporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.OrSupporter
   * @generated
   */
  EClass getOrSupporter();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.XorSupporter <em>Xor Supporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xor Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.XorSupporter
   * @generated
   */
  EClass getXorSupporter();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter <em>Mof NSupporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mof NSupporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter
   * @generated
   */
  EClass getMofNSupporter();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter#getTarget()
   * @see #getMofNSupporter()
   * @generated
   */
  EAttribute getMofNSupporter_Target();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILLevel <em>ASIL Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>ASIL Level</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ASILLevel
   * @generated
   */
  EEnum getASILLevel();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.safetycase.ValidityValue <em>Validity Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Validity Value</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
   * @generated
   */
  EEnum getValidityValue();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.safetycase.ImpactType <em>Impact Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Impact Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.safetycase.ImpactType
   * @generated
   */
  EEnum getImpactType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GSNFactory getGSNFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSafetyCase()
     * @generated
     */
    EClass SAFETY_CASE = eINSTANCE.getSafetyCase();

    /**
     * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__GOALS = eINSTANCE.getSafetyCase_Goals();

    /**
     * The meta object literal for the '<em><b>Strategies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__STRATEGIES = eINSTANCE.getSafetyCase_Strategies();

    /**
     * The meta object literal for the '<em><b>Solutions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__SOLUTIONS = eINSTANCE.getSafetyCase_Solutions();

    /**
     * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__CONTEXTS = eINSTANCE.getSafetyCase_Contexts();

    /**
     * The meta object literal for the '<em><b>Justifications</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__JUSTIFICATIONS = eINSTANCE.getSafetyCase_Justifications();

    /**
     * The meta object literal for the '<em><b>Assumptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__ASSUMPTIONS = eINSTANCE.getSafetyCase_Assumptions();

    /**
     * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__CONNECTORS = eINSTANCE.getSafetyCase_Connectors();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ArgumentElementImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getArgumentElement()
     * @generated
     */
    EClass ARGUMENT_ELEMENT = eINSTANCE.getArgumentElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__ID = eINSTANCE.getArgumentElement_Id();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__DESCRIPTION = eINSTANCE.getArgumentElement_Description();

    /**
     * The meta object literal for the '<em><b>Content Validity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__CONTENT_VALIDITY = eINSTANCE.getArgumentElement_ContentValidity();

    /**
     * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_ELEMENT__STATUS = eINSTANCE.getArgumentElement_Status();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl <em>Stateful Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getStatefulElement()
     * @generated
     */
    EClass STATEFUL_ELEMENT = eINSTANCE.getStatefulElement();

    /**
     * The meta object literal for the '<em><b>State Validity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEFUL_ELEMENT__STATE_VALIDITY = eINSTANCE.getStatefulElement_StateValidity();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILfulElementImpl <em>ASI Lful Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILfulElementImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getASILfulElement()
     * @generated
     */
    EClass ASI_LFUL_ELEMENT = eINSTANCE.getASILfulElement();

    /**
     * The meta object literal for the '<em><b>Asil</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASI_LFUL_ELEMENT__ASIL = eINSTANCE.getASILfulElement_Asil();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.CoreElementImpl <em>Core Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.CoreElementImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getCoreElement()
     * @generated
     */
    EClass CORE_ELEMENT = eINSTANCE.getCoreElement();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl <em>Decomposable Core Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getDecomposableCoreElement()
     * @generated
     */
    EClass DECOMPOSABLE_CORE_ELEMENT = eINSTANCE.getDecomposableCoreElement();

    /**
     * The meta object literal for the '<em><b>In Context Of</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = eINSTANCE.getDecomposableCoreElement_InContextOf();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContextualElementImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getContextualElement()
     * @generated
     */
    EClass CONTEXTUAL_ELEMENT = eINSTANCE.getContextualElement();

    /**
     * The meta object literal for the '<em><b>Context Of</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXTUAL_ELEMENT__CONTEXT_OF = eINSTANCE.getContextualElement_ContextOf();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SupportedByImpl <em>Supported By</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SupportedByImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSupportedBy()
     * @generated
     */
    EClass SUPPORTED_BY = eINSTANCE.getSupportedBy();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTED_BY__SOURCE = eINSTANCE.getSupportedBy_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTED_BY__TARGET = eINSTANCE.getSupportedBy_Target();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.InContextOfImpl <em>In Context Of</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.InContextOfImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getInContextOf()
     * @generated
     */
    EClass IN_CONTEXT_OF = eINSTANCE.getInContextOf();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IN_CONTEXT_OF__CONTEXT = eINSTANCE.getInContextOf_Context();

    /**
     * The meta object literal for the '<em><b>Context Of</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IN_CONTEXT_OF__CONTEXT_OF = eINSTANCE.getInContextOf_ContextOf();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl <em>Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GoalImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getGoal()
     * @generated
     */
    EClass GOAL = eINSTANCE.getGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.BasicGoalImpl <em>Basic Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.BasicGoalImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getBasicGoal()
     * @generated
     */
    EClass BASIC_GOAL = eINSTANCE.getBasicGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.IndependenceGoalImpl <em>Independence Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.IndependenceGoalImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getIndependenceGoal()
     * @generated
     */
    EClass INDEPENDENCE_GOAL = eINSTANCE.getIndependenceGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DomainGoalImpl <em>Domain Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.DomainGoalImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getDomainGoal()
     * @generated
     */
    EClass DOMAIN_GOAL = eINSTANCE.getDomainGoal();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN_GOAL__DOMAIN = eINSTANCE.getDomainGoal_Domain();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl <em>Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getStrategy()
     * @generated
     */
    EClass STRATEGY = eINSTANCE.getStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.BasicStrategyImpl <em>Basic Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.BasicStrategyImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getBasicStrategy()
     * @generated
     */
    EClass BASIC_STRATEGY = eINSTANCE.getBasicStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILDecompositionStrategyImpl <em>ASIL Decomposition Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILDecompositionStrategyImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getASILDecompositionStrategy()
     * @generated
     */
    EClass ASIL_DECOMPOSITION_STRATEGY = eINSTANCE.getASILDecompositionStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl <em>Solution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSolution()
     * @generated
     */
    EClass SOLUTION = eINSTANCE.getSolution();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getContext()
     * @generated
     */
    EClass CONTEXT = eINSTANCE.getContext();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.JustificationImpl <em>Justification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.JustificationImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getJustification()
     * @generated
     */
    EClass JUSTIFICATION = eINSTANCE.getJustification();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.AssumptionImpl <em>Assumption</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.AssumptionImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getAssumption()
     * @generated
     */
    EClass ASSUMPTION = eINSTANCE.getAssumption();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl <em>ASIL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getASIL()
     * @generated
     */
    EClass ASIL = eINSTANCE.getASIL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASIL__VALUE = eINSTANCE.getASIL_Value();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASIL__TARGET = eINSTANCE.getASIL_Target();

    /**
     * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASIL__STATUS = eINSTANCE.getASIL_Status();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ImpactAnnotationImpl <em>Impact Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ImpactAnnotationImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getImpactAnnotation()
     * @generated
     */
    EClass IMPACT_ANNOTATION = eINSTANCE.getImpactAnnotation();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPACT_ANNOTATION__TYPE = eINSTANCE.getImpactAnnotation_Type();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPACT_ANNOTATION__SOURCE = eINSTANCE.getImpactAnnotation_Source();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SupportableImpl <em>Supportable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SupportableImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSupportable()
     * @generated
     */
    EClass SUPPORTABLE = eINSTANCE.getSupportable();

    /**
     * The meta object literal for the '<em><b>Supported By</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTABLE__SUPPORTED_BY = eINSTANCE.getSupportable_SupportedBy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SupporterImpl <em>Supporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SupporterImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSupporter()
     * @generated
     */
    EClass SUPPORTER = eINSTANCE.getSupporter();

    /**
     * The meta object literal for the '<em><b>Supports</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTER__SUPPORTS = eINSTANCE.getSupporter_Supports();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SupportConnectorImpl <em>Support Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SupportConnectorImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getSupportConnector()
     * @generated
     */
    EClass SUPPORT_CONNECTOR = eINSTANCE.getSupportConnector();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.AndSupporterImpl <em>And Supporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.AndSupporterImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getAndSupporter()
     * @generated
     */
    EClass AND_SUPPORTER = eINSTANCE.getAndSupporter();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.OrSupporterImpl <em>Or Supporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.OrSupporterImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getOrSupporter()
     * @generated
     */
    EClass OR_SUPPORTER = eINSTANCE.getOrSupporter();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.XorSupporterImpl <em>Xor Supporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.XorSupporterImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getXorSupporter()
     * @generated
     */
    EClass XOR_SUPPORTER = eINSTANCE.getXorSupporter();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.MofNSupporterImpl <em>Mof NSupporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.MofNSupporterImpl
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getMofNSupporter()
     * @generated
     */
    EClass MOF_NSUPPORTER = eINSTANCE.getMofNSupporter();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOF_NSUPPORTER__TARGET = eINSTANCE.getMofNSupporter_Target();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILLevel <em>ASIL Level</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.ASILLevel
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getASILLevel()
     * @generated
     */
    EEnum ASIL_LEVEL = eINSTANCE.getASILLevel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ValidityValue <em>Validity Value</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getValidityValue()
     * @generated
     */
    EEnum VALIDITY_VALUE = eINSTANCE.getValidityValue();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ImpactType <em>Impact Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.safetycase.ImpactType
     * @see edu.toronto.cs.se.modelepedia.safetycase.impl.GSNPackageImpl#getImpactType()
     * @generated
     */
    EEnum IMPACT_TYPE = eINSTANCE.getImpactType();

  }

} //GSNPackage
