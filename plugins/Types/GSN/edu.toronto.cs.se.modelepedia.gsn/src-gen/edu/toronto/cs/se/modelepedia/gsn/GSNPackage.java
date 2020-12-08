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
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNFactory
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
  String eNAME = "gsn";

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
  String eNS_PREFIX = "gsn";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GSNPackage eINSTANCE = edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSafetyCase()
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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getArgumentElement()
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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.StatefulElementImpl <em>Stateful Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.StatefulElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getStatefulElement()
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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILfulElementImpl <em>ASI Lful Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILfulElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILfulElement()
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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.CoreElementImpl <em>Core Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.CoreElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getCoreElement()
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
  int CORE_ELEMENT__ID = GSNPackage.ARGUMENT_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__DESCRIPTION = GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__CONTENT_VALIDITY = GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__STATUS = GSNPackage.ARGUMENT_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT__SUPPORTS = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Core Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT_FEATURE_COUNT = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Core Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORE_ELEMENT_OPERATION_COUNT = GSNPackage.ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupporterImpl <em>Supporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupporterImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupporter()
   * @generated
   */
  int SUPPORTER = 22;

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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl <em>Supportable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportable()
   * @generated
   */
  int SUPPORTABLE = 21;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__SUPPORTS = GSNPackage.SUPPORTER__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__SUPPORTED_BY = GSNPackage.SUPPORTER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Supportable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE_FEATURE_COUNT = GSNPackage.SUPPORTER_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Supportable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE_OPERATION_COUNT = GSNPackage.SUPPORTER_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DecomposableCoreElementImpl <em>Decomposable Core Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.DecomposableCoreElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDecomposableCoreElement()
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
  int DECOMPOSABLE_CORE_ELEMENT__SUPPORTS = GSNPackage.SUPPORTABLE__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY = GSNPackage.SUPPORTABLE__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__ID = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__STATUS = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Decomposable Core Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 5;

  /**
   * The number of operations of the '<em>Decomposable Core Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT = GSNPackage.SUPPORTABLE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextualElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContextualElement()
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
  int CONTEXTUAL_ELEMENT__ID = GSNPackage.ARGUMENT_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__DESCRIPTION = GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__CONTENT_VALIDITY = GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__STATUS = GSNPackage.ARGUMENT_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT__CONTEXT_OF = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Contextual Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT_FEATURE_COUNT = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Contextual Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_ELEMENT_OPERATION_COUNT = GSNPackage.ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl <em>Supported By</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportedBy()
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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getInContextOf()
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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl <em>Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getGoal()
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
  int GOAL__SUPPORTS = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__SUPPORTED_BY = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ID = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DESCRIPTION = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CONTENT_VALIDITY = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__STATUS = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__IN_CONTEXT_OF = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__STATE_VALIDITY = GSNPackage.DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ASIL = GSNPackage.DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FEATURE_COUNT = GSNPackage.DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_OPERATION_COUNT = GSNPackage.DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.BasicGoalImpl <em>Basic Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.BasicGoalImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getBasicGoal()
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
  int BASIC_GOAL__SUPPORTS = GSNPackage.GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__SUPPORTED_BY = GSNPackage.GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__ID = GSNPackage.GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__DESCRIPTION = GSNPackage.GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__CONTENT_VALIDITY = GSNPackage.GOAL__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__STATUS = GSNPackage.GOAL__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__IN_CONTEXT_OF = GSNPackage.GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__STATE_VALIDITY = GSNPackage.GOAL__STATE_VALIDITY;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL__ASIL = GSNPackage.GOAL__ASIL;

  /**
   * The number of structural features of the '<em>Basic Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL_FEATURE_COUNT = GSNPackage.GOAL_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Basic Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_GOAL_OPERATION_COUNT = GSNPackage.GOAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.IndependenceGoalImpl <em>Independence Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.IndependenceGoalImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getIndependenceGoal()
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
  int INDEPENDENCE_GOAL__SUPPORTS = GSNPackage.GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__SUPPORTED_BY = GSNPackage.GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__ID = GSNPackage.GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__DESCRIPTION = GSNPackage.GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__CONTENT_VALIDITY = GSNPackage.GOAL__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__STATUS = GSNPackage.GOAL__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__IN_CONTEXT_OF = GSNPackage.GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__STATE_VALIDITY = GSNPackage.GOAL__STATE_VALIDITY;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL__ASIL = GSNPackage.GOAL__ASIL;

  /**
   * The number of structural features of the '<em>Independence Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL_FEATURE_COUNT = GSNPackage.GOAL_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Independence Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEPENDENCE_GOAL_OPERATION_COUNT = GSNPackage.GOAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DomainGoalImpl <em>Domain Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.DomainGoalImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDomainGoal()
   * @generated
   */
  int DOMAIN_GOAL = 36;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getStrategy()
   * @generated
   */
  int STRATEGY = 12;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__SUPPORTS = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__SUPPORTED_BY = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__ID = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__DESCRIPTION = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__CONTENT_VALIDITY = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__STATUS = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__IN_CONTEXT_OF = GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_FEATURE_COUNT = GSNPackage.DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_OPERATION_COUNT = GSNPackage.DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.BasicStrategyImpl <em>Basic Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.BasicStrategyImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getBasicStrategy()
   * @generated
   */
  int BASIC_STRATEGY = 13;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__SUPPORTS = GSNPackage.STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__SUPPORTED_BY = GSNPackage.STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__ID = GSNPackage.STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__DESCRIPTION = GSNPackage.STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__CONTENT_VALIDITY = GSNPackage.STRATEGY__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__STATUS = GSNPackage.STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY__IN_CONTEXT_OF = GSNPackage.STRATEGY__IN_CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Basic Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY_FEATURE_COUNT = GSNPackage.STRATEGY_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Basic Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_STRATEGY_OPERATION_COUNT = GSNPackage.STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILDecompositionStrategyImpl <em>ASIL Decomposition Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILDecompositionStrategyImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILDecompositionStrategy()
   * @generated
   */
  int ASIL_DECOMPOSITION_STRATEGY = 14;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__SUPPORTS = GSNPackage.STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY = GSNPackage.STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__ID = GSNPackage.STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__DESCRIPTION = GSNPackage.STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__CONTENT_VALIDITY = GSNPackage.STRATEGY__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__STATUS = GSNPackage.STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY__IN_CONTEXT_OF = GSNPackage.STRATEGY__IN_CONTEXT_OF;

  /**
   * The number of structural features of the '<em>ASIL Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY_FEATURE_COUNT = GSNPackage.STRATEGY_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>ASIL Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_DECOMPOSITION_STRATEGY_OPERATION_COUNT = GSNPackage.STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl <em>Solution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSolution()
   * @generated
   */
  int SOLUTION = 15;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__ID = GSNPackage.CORE_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__DESCRIPTION = GSNPackage.CORE_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__CONTENT_VALIDITY = GSNPackage.CORE_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__STATUS = GSNPackage.CORE_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__SUPPORTS = GSNPackage.CORE_ELEMENT__SUPPORTS;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__STATE_VALIDITY = GSNPackage.CORE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Solution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_FEATURE_COUNT = GSNPackage.CORE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Solution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_OPERATION_COUNT = GSNPackage.CORE_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl <em>Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 16;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__ID = GSNPackage.CONTEXTUAL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__DESCRIPTION = GSNPackage.CONTEXTUAL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONTENT_VALIDITY = GSNPackage.CONTEXTUAL_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__STATUS = GSNPackage.CONTEXTUAL_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONTEXT_OF = GSNPackage.CONTEXTUAL_ELEMENT__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_FEATURE_COUNT = GSNPackage.CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_OPERATION_COUNT = GSNPackage.CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.JustificationImpl <em>Justification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.JustificationImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getJustification()
   * @generated
   */
  int JUSTIFICATION = 17;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__ID = GSNPackage.CONTEXTUAL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__DESCRIPTION = GSNPackage.CONTEXTUAL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__CONTENT_VALIDITY = GSNPackage.CONTEXTUAL_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__STATUS = GSNPackage.CONTEXTUAL_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__CONTEXT_OF = GSNPackage.CONTEXTUAL_ELEMENT__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Justification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION_FEATURE_COUNT = GSNPackage.CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Justification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION_OPERATION_COUNT = GSNPackage.CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.AssumptionImpl <em>Assumption</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.AssumptionImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getAssumption()
   * @generated
   */
  int ASSUMPTION = 18;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__ID = GSNPackage.CONTEXTUAL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__DESCRIPTION = GSNPackage.CONTEXTUAL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__CONTENT_VALIDITY = GSNPackage.CONTEXTUAL_ELEMENT__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__STATUS = GSNPackage.CONTEXTUAL_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__CONTEXT_OF = GSNPackage.CONTEXTUAL_ELEMENT__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Assumption</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_FEATURE_COUNT = GSNPackage.CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Assumption</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_OPERATION_COUNT = GSNPackage.CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILImpl <em>ASIL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASIL()
   * @generated
   */
  int ASIL = 19;

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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl <em>Impact Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getImpactAnnotation()
   * @generated
   */
  int IMPACT_ANNOTATION = 20;

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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportConnectorImpl <em>Support Connector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportConnectorImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportConnector()
   * @generated
   */
  int SUPPORT_CONNECTOR = 23;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORT_CONNECTOR__SUPPORTS = GSNPackage.SUPPORTABLE__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORT_CONNECTOR__SUPPORTED_BY = GSNPackage.SUPPORTABLE__SUPPORTED_BY;

  /**
   * The number of structural features of the '<em>Support Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORT_CONNECTOR_FEATURE_COUNT = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Support Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORT_CONNECTOR_OPERATION_COUNT = GSNPackage.SUPPORTABLE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.AndSupporterImpl <em>And Supporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.AndSupporterImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getAndSupporter()
   * @generated
   */
  int AND_SUPPORTER = 24;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SUPPORTER__SUPPORTS = GSNPackage.SUPPORT_CONNECTOR__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SUPPORTER__SUPPORTED_BY = GSNPackage.SUPPORT_CONNECTOR__SUPPORTED_BY;

  /**
   * The number of structural features of the '<em>And Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SUPPORTER_FEATURE_COUNT = GSNPackage.SUPPORT_CONNECTOR_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>And Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SUPPORTER_OPERATION_COUNT = GSNPackage.SUPPORT_CONNECTOR_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.OrSupporterImpl <em>Or Supporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.OrSupporterImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getOrSupporter()
   * @generated
   */
  int OR_SUPPORTER = 25;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_SUPPORTER__SUPPORTS = GSNPackage.SUPPORT_CONNECTOR__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_SUPPORTER__SUPPORTED_BY = GSNPackage.SUPPORT_CONNECTOR__SUPPORTED_BY;

  /**
   * The number of structural features of the '<em>Or Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_SUPPORTER_FEATURE_COUNT = GSNPackage.SUPPORT_CONNECTOR_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Or Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_SUPPORTER_OPERATION_COUNT = GSNPackage.SUPPORT_CONNECTOR_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.XorSupporterImpl <em>Xor Supporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.XorSupporterImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getXorSupporter()
   * @generated
   */
  int XOR_SUPPORTER = 26;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_SUPPORTER__SUPPORTS = GSNPackage.SUPPORT_CONNECTOR__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_SUPPORTER__SUPPORTED_BY = GSNPackage.SUPPORT_CONNECTOR__SUPPORTED_BY;

  /**
   * The number of structural features of the '<em>Xor Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_SUPPORTER_FEATURE_COUNT = GSNPackage.SUPPORT_CONNECTOR_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Xor Supporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_SUPPORTER_OPERATION_COUNT = GSNPackage.SUPPORT_CONNECTOR_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.MofNSupporterImpl <em>Mof NSupporter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.MofNSupporterImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getMofNSupporter()
   * @generated
   */
  int MOF_NSUPPORTER = 27;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER__SUPPORTS = GSNPackage.SUPPORT_CONNECTOR__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER__SUPPORTED_BY = GSNPackage.SUPPORT_CONNECTOR__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER__TARGET = GSNPackage.SUPPORT_CONNECTOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Mof NSupporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER_FEATURE_COUNT = GSNPackage.SUPPORT_CONNECTOR_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Mof NSupporter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOF_NSUPPORTER_OPERATION_COUNT = GSNPackage.SUPPORT_CONNECTOR_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DecompositionStrategyImpl <em>Decomposition Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.DecompositionStrategyImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDecompositionStrategy()
   * @generated
   */
  int DECOMPOSITION_STRATEGY = 28;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY__SUPPORTS = GSNPackage.STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY__SUPPORTED_BY = GSNPackage.STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY__ID = GSNPackage.STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY__DESCRIPTION = GSNPackage.STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY__CONTENT_VALIDITY = GSNPackage.STRATEGY__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY__STATUS = GSNPackage.STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY__IN_CONTEXT_OF = GSNPackage.STRATEGY__IN_CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY_FEATURE_COUNT = GSNPackage.STRATEGY_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY___VALIDATE = GSNPackage.STRATEGY_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECOMPOSITION_STRATEGY_OPERATION_COUNT = GSNPackage.STRATEGY_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.DomainImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 29;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = 0;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN___VALIDATE_DECOMPOSITION__ELIST = 0;

  /**
   * The number of operations of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.IntDomainImpl <em>Int Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.IntDomainImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getIntDomain()
   * @generated
   */
  int INT_DOMAIN = 30;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN__LOWER_BOUND = GSNPackage.DOMAIN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN__UPPER_BOUND = GSNPackage.DOMAIN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Int Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN_FEATURE_COUNT = GSNPackage.DOMAIN_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST;

  /**
   * The number of operations of the '<em>Int Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DOMAIN_OPERATION_COUNT = GSNPackage.DOMAIN_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.RealDomainImpl <em>Real Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.RealDomainImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getRealDomain()
   * @generated
   */
  int REAL_DOMAIN = 31;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN__LOWER_BOUND = GSNPackage.DOMAIN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN__UPPER_BOUND = GSNPackage.DOMAIN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Real Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN_FEATURE_COUNT = GSNPackage.DOMAIN_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST;

  /**
   * The number of operations of the '<em>Real Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_DOMAIN_OPERATION_COUNT = GSNPackage.DOMAIN_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.EnumDomainImpl <em>Enum Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.EnumDomainImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getEnumDomain()
   * @generated
   */
  int ENUM_DOMAIN = 32;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_DOMAIN__VALUES = GSNPackage.DOMAIN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_DOMAIN_FEATURE_COUNT = GSNPackage.DOMAIN_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST;

  /**
   * The number of operations of the '<em>Enum Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_DOMAIN_OPERATION_COUNT = GSNPackage.DOMAIN_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ValueDomainImpl <em>Value Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ValueDomainImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getValueDomain()
   * @generated
   */
  int VALUE_DOMAIN = 33;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DOMAIN__VALUE = GSNPackage.DOMAIN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Value Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DOMAIN_FEATURE_COUNT = GSNPackage.DOMAIN_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate Decomposition</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST;

  /**
   * The number of operations of the '<em>Value Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_DOMAIN_OPERATION_COUNT = GSNPackage.DOMAIN_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DomainDecompositionElementImpl <em>Domain Decomposition Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.DomainDecompositionElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDomainDecompositionElement()
   * @generated
   */
  int DOMAIN_DECOMPOSITION_ELEMENT = 34;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN = 0;

  /**
   * The number of structural features of the '<em>Domain Decomposition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Domain Decomposition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DomainDecompositionStrategyImpl <em>Domain Decomposition Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.DomainDecompositionStrategyImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDomainDecompositionStrategy()
   * @generated
   */
  int DOMAIN_DECOMPOSITION_STRATEGY = 35;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__SUPPORTS = GSNPackage.DECOMPOSITION_STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__SUPPORTED_BY = GSNPackage.DECOMPOSITION_STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__ID = GSNPackage.DECOMPOSITION_STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__DESCRIPTION = GSNPackage.DECOMPOSITION_STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__CONTENT_VALIDITY = GSNPackage.DECOMPOSITION_STRATEGY__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__STATUS = GSNPackage.DECOMPOSITION_STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__IN_CONTEXT_OF = GSNPackage.DECOMPOSITION_STRATEGY__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN = GSNPackage.DECOMPOSITION_STRATEGY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Domain Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY_FEATURE_COUNT = GSNPackage.DECOMPOSITION_STRATEGY_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY___VALIDATE = GSNPackage.DECOMPOSITION_STRATEGY___VALIDATE;

  /**
   * The number of operations of the '<em>Domain Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_DECOMPOSITION_STRATEGY_OPERATION_COUNT = GSNPackage.DECOMPOSITION_STRATEGY_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__SUPPORTS = GSNPackage.GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__SUPPORTED_BY = GSNPackage.GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__ID = GSNPackage.GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__DESCRIPTION = GSNPackage.GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__CONTENT_VALIDITY = GSNPackage.GOAL__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__STATUS = GSNPackage.GOAL__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__IN_CONTEXT_OF = GSNPackage.GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__STATE_VALIDITY = GSNPackage.GOAL__STATE_VALIDITY;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__ASIL = GSNPackage.GOAL__ASIL;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL__DOMAIN = GSNPackage.GOAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Domain Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL_FEATURE_COUNT = GSNPackage.GOAL_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Domain Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_GOAL_OPERATION_COUNT = GSNPackage.GOAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionElementImpl <em>Property Decomposition Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getPropertyDecompositionElement()
   * @generated
   */
  int PROPERTY_DECOMPOSITION_ELEMENT = 37;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY = 0;

  /**
   * The number of structural features of the '<em>Property Decomposition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Property Decomposition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionStrategyImpl <em>Property Decomposition Strategy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionStrategyImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getPropertyDecompositionStrategy()
   * @generated
   */
  int PROPERTY_DECOMPOSITION_STRATEGY = 38;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__SUPPORTS = GSNPackage.DECOMPOSITION_STRATEGY__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__SUPPORTED_BY = GSNPackage.DECOMPOSITION_STRATEGY__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__ID = GSNPackage.DECOMPOSITION_STRATEGY__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__DESCRIPTION = GSNPackage.DECOMPOSITION_STRATEGY__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__CONTENT_VALIDITY = GSNPackage.DECOMPOSITION_STRATEGY__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__STATUS = GSNPackage.DECOMPOSITION_STRATEGY__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__IN_CONTEXT_OF = GSNPackage.DECOMPOSITION_STRATEGY__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY = GSNPackage.DECOMPOSITION_STRATEGY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY_FEATURE_COUNT = GSNPackage.DECOMPOSITION_STRATEGY_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY___VALIDATE = GSNPackage.DECOMPOSITION_STRATEGY___VALIDATE;

  /**
   * The number of operations of the '<em>Property Decomposition Strategy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_DECOMPOSITION_STRATEGY_OPERATION_COUNT = GSNPackage.DECOMPOSITION_STRATEGY_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyGoalImpl <em>Property Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.PropertyGoalImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getPropertyGoal()
   * @generated
   */
  int PROPERTY_GOAL = 39;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__SUPPORTS = GSNPackage.GOAL__SUPPORTS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__SUPPORTED_BY = GSNPackage.GOAL__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__ID = GSNPackage.GOAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__DESCRIPTION = GSNPackage.GOAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Content Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__CONTENT_VALIDITY = GSNPackage.GOAL__CONTENT_VALIDITY;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__STATUS = GSNPackage.GOAL__STATUS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__IN_CONTEXT_OF = GSNPackage.GOAL__IN_CONTEXT_OF;

  /**
   * The feature id for the '<em><b>State Validity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__STATE_VALIDITY = GSNPackage.GOAL__STATE_VALIDITY;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__ASIL = GSNPackage.GOAL__ASIL;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL__PROPERTY = GSNPackage.GOAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL_FEATURE_COUNT = GSNPackage.GOAL_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Property Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_GOAL_OPERATION_COUNT = GSNPackage.GOAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.ASILLevel <em>ASIL Level</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILLevel
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILLevel()
   * @generated
   */
  int ASIL_LEVEL = 40;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.ValidityValue <em>Validity Value</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.ValidityValue
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getValidityValue()
   * @generated
   */
  int VALIDITY_VALUE = 41;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactType <em>Impact Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactType
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getImpactType()
   * @generated
   */
  int IMPACT_TYPE = 42;


  /**
   * The meta object id for the '<em>MMINT Exception</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.MMINTException
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getMMINTException()
   * @generated
   */
  int MMINT_EXCEPTION = 43;


  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase <em>Safety Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Safety Case</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase
   * @generated
   */
  EClass getSafetyCase();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getGoals <em>Goals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Goals</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getGoals()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Goals();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getStrategies <em>Strategies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Strategies</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getStrategies()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Strategies();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getSolutions <em>Solutions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Solutions</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getSolutions()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Solutions();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getContexts <em>Contexts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contexts</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getContexts()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Contexts();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getJustifications <em>Justifications</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Justifications</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getJustifications()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Justifications();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getAssumptions <em>Assumptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assumptions</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getAssumptions()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Assumptions();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getConnectors <em>Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connectors</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getConnectors()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Connectors();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement <em>Argument Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement
   * @generated
   */
  EClass getArgumentElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getId()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_Id();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getDescription()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_Description();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getContentValidity <em>Content Validity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content Validity</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getContentValidity()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_ContentValidity();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getStatus <em>Status</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Status</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getStatus()
   * @see #getArgumentElement()
   * @generated
   */
  EReference getArgumentElement_Status();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.StatefulElement <em>Stateful Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stateful Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.StatefulElement
   * @generated
   */
  EClass getStatefulElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.StatefulElement#getStateValidity <em>State Validity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Validity</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.StatefulElement#getStateValidity()
   * @see #getStatefulElement()
   * @generated
   */
  EAttribute getStatefulElement_StateValidity();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement <em>ASI Lful Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASI Lful Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILfulElement
   * @generated
   */
  EClass getASILfulElement();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement#getAsil <em>Asil</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Asil</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILfulElement#getAsil()
   * @see #getASILfulElement()
   * @generated
   */
  EReference getASILfulElement_Asil();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.CoreElement <em>Core Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Core Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.CoreElement
   * @generated
   */
  EClass getCoreElement();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement <em>Decomposable Core Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decomposable Core Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement
   * @generated
   */
  EClass getDecomposableCoreElement();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement#getInContextOf <em>In Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>In Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement#getInContextOf()
   * @see #getDecomposableCoreElement()
   * @generated
   */
  EReference getDecomposableCoreElement_InContextOf();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ContextualElement <em>Contextual Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contextual Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ContextualElement
   * @generated
   */
  EClass getContextualElement();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.gsn.ContextualElement#getContextOf <em>Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ContextualElement#getContextOf()
   * @see #getContextualElement()
   * @generated
   */
  EReference getContextualElement_ContextOf();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy <em>Supported By</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Supported By</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy
   * @generated
   */
  EClass getSupportedBy();

  /**
   * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Source</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getSource()
   * @see #getSupportedBy()
   * @generated
   */
  EReference getSupportedBy_Source();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getTarget()
   * @see #getSupportedBy()
   * @generated
   */
  EReference getSupportedBy_Target();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf <em>In Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>In Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.InContextOf
   * @generated
   */
  EClass getInContextOf();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Context</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContext()
   * @see #getInContextOf()
   * @generated
   */
  EReference getInContextOf_Context();

  /**
   * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContextOf <em>Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContextOf()
   * @see #getInContextOf()
   * @generated
   */
  EReference getInContextOf_ContextOf();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Goal <em>Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Goal
   * @generated
   */
  EClass getGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.BasicGoal <em>Basic Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.BasicGoal
   * @generated
   */
  EClass getBasicGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.IndependenceGoal <em>Independence Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Independence Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.IndependenceGoal
   * @generated
   */
  EClass getIndependenceGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.DomainGoal <em>Domain Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.DomainGoal
   * @generated
   */
  EClass getDomainGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement <em>Property Decomposition Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Decomposition Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement
   * @generated
   */
  EClass getPropertyDecompositionElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement#getProperty()
   * @see #getPropertyDecompositionElement()
   * @generated
   */
  EAttribute getPropertyDecompositionElement_Property();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy <em>Property Decomposition Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Decomposition Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy
   * @generated
   */
  EClass getPropertyDecompositionStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyGoal <em>Property Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.PropertyGoal
   * @generated
   */
  EClass getPropertyGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Strategy <em>Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Strategy
   * @generated
   */
  EClass getStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.BasicStrategy <em>Basic Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.BasicStrategy
   * @generated
   */
  EClass getBasicStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ASILDecompositionStrategy <em>ASIL Decomposition Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASIL Decomposition Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILDecompositionStrategy
   * @generated
   */
  EClass getASILDecompositionStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Solution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Solution</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Solution
   * @generated
   */
  EClass getSolution();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Context <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Context
   * @generated
   */
  EClass getContext();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Justification <em>Justification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Justification</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Justification
   * @generated
   */
  EClass getJustification();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Assumption <em>Assumption</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assumption</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Assumption
   * @generated
   */
  EClass getAssumption();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL <em>ASIL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASIL</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL
   * @generated
   */
  EClass getASIL();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL#getValue()
   * @see #getASIL()
   * @generated
   */
  EAttribute getASIL_Value();

  /**
   * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL#getTarget()
   * @see #getASIL()
   * @generated
   */
  EReference getASIL_Target();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getStatus <em>Status</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Status</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL#getStatus()
   * @see #getASIL()
   * @generated
   */
  EReference getASIL_Status();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation <em>Impact Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Impact Annotation</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation
   * @generated
   */
  EClass getImpactAnnotation();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getType()
   * @see #getImpactAnnotation()
   * @generated
   */
  EAttribute getImpactAnnotation_Type();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getSource()
   * @see #getImpactAnnotation()
   * @generated
   */
  EAttribute getImpactAnnotation_Source();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Supportable <em>Supportable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Supportable</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supportable
   * @generated
   */
  EClass getSupportable();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.Supportable#getSupportedBy <em>Supported By</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supported By</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supportable#getSupportedBy()
   * @see #getSupportable()
   * @generated
   */
  EReference getSupportable_SupportedBy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Supporter <em>Supporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supporter
   * @generated
   */
  EClass getSupporter();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.gsn.Supporter#getSupports <em>Supports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supports</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supporter#getSupports()
   * @see #getSupporter()
   * @generated
   */
  EReference getSupporter_Supports();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.SupportConnector <em>Support Connector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Support Connector</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportConnector
   * @generated
   */
  EClass getSupportConnector();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.AndSupporter <em>And Supporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.AndSupporter
   * @generated
   */
  EClass getAndSupporter();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.OrSupporter <em>Or Supporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.OrSupporter
   * @generated
   */
  EClass getOrSupporter();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.XorSupporter <em>Xor Supporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xor Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.XorSupporter
   * @generated
   */
  EClass getXorSupporter();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.MofNSupporter <em>Mof NSupporter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mof NSupporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.MofNSupporter
   * @generated
   */
  EClass getMofNSupporter();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.MofNSupporter#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.MofNSupporter#getTarget()
   * @see #getMofNSupporter()
   * @generated
   */
  EAttribute getMofNSupporter_Target();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy <em>Decomposition Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decomposition Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy
   * @generated
   */
  EClass getDecompositionStrategy();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy#validate() <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy#validate()
   * @generated
   */
  EOperation getDecompositionStrategy__Validate();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.Domain#validateDecomposition(org.eclipse.emf.common.util.EList) <em>Validate Decomposition</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate Decomposition</em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.Domain#validateDecomposition(org.eclipse.emf.common.util.EList)
   * @generated
   */
  EOperation getDomain__ValidateDecomposition__EList();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.IntDomain <em>Int Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Domain</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.IntDomain
   * @generated
   */
  EClass getIntDomain();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.IntDomain#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.IntDomain#getLowerBound()
   * @see #getIntDomain()
   * @generated
   */
  EAttribute getIntDomain_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.IntDomain#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.IntDomain#getUpperBound()
   * @see #getIntDomain()
   * @generated
   */
  EAttribute getIntDomain_UpperBound();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.RealDomain <em>Real Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Domain</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.RealDomain
   * @generated
   */
  EClass getRealDomain();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.RealDomain#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.RealDomain#getLowerBound()
   * @see #getRealDomain()
   * @generated
   */
  EAttribute getRealDomain_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.RealDomain#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.RealDomain#getUpperBound()
   * @see #getRealDomain()
   * @generated
   */
  EAttribute getRealDomain_UpperBound();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.EnumDomain <em>Enum Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Domain</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.EnumDomain
   * @generated
   */
  EClass getEnumDomain();

  /**
   * Returns the meta object for the attribute list '{@link edu.toronto.cs.se.modelepedia.gsn.EnumDomain#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.EnumDomain#getValues()
   * @see #getEnumDomain()
   * @generated
   */
  EAttribute getEnumDomain_Values();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ValueDomain <em>Value Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Domain</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ValueDomain
   * @generated
   */
  EClass getValueDomain();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ValueDomain#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ValueDomain#getValue()
   * @see #getValueDomain()
   * @generated
   */
  EAttribute getValueDomain_Value();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement <em>Domain Decomposition Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Decomposition Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement
   * @generated
   */
  EClass getDomainDecompositionElement();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement#getDomain()
   * @see #getDomainDecompositionElement()
   * @generated
   */
  EReference getDomainDecompositionElement_Domain();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionStrategy <em>Domain Decomposition Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Decomposition Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionStrategy
   * @generated
   */
  EClass getDomainDecompositionStrategy();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.gsn.ASILLevel <em>ASIL Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>ASIL Level</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILLevel
   * @generated
   */
  EEnum getASILLevel();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.gsn.ValidityValue <em>Validity Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Validity Value</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ValidityValue
   * @generated
   */
  EEnum getValidityValue();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactType <em>Impact Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Impact Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactType
   * @generated
   */
  EEnum getImpactType();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.MMINTException <em>MMINT Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>MMINT Exception</em>'.
   * @see edu.toronto.cs.se.mmint.MMINTException
   * @model instanceClass="edu.toronto.cs.se.mmint.MMINTException"
   * @generated
   */
  EDataType getMMINTException();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSafetyCase()
     * @generated
     */
    EClass SAFETY_CASE = GSNPackage.eINSTANCE.getSafetyCase();

    /**
     * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__GOALS = GSNPackage.eINSTANCE.getSafetyCase_Goals();

    /**
     * The meta object literal for the '<em><b>Strategies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__STRATEGIES = GSNPackage.eINSTANCE.getSafetyCase_Strategies();

    /**
     * The meta object literal for the '<em><b>Solutions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__SOLUTIONS = GSNPackage.eINSTANCE.getSafetyCase_Solutions();

    /**
     * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__CONTEXTS = GSNPackage.eINSTANCE.getSafetyCase_Contexts();

    /**
     * The meta object literal for the '<em><b>Justifications</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__JUSTIFICATIONS = GSNPackage.eINSTANCE.getSafetyCase_Justifications();

    /**
     * The meta object literal for the '<em><b>Assumptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__ASSUMPTIONS = GSNPackage.eINSTANCE.getSafetyCase_Assumptions();

    /**
     * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__CONNECTORS = GSNPackage.eINSTANCE.getSafetyCase_Connectors();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getArgumentElement()
     * @generated
     */
    EClass ARGUMENT_ELEMENT = GSNPackage.eINSTANCE.getArgumentElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__ID = GSNPackage.eINSTANCE.getArgumentElement_Id();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__DESCRIPTION = GSNPackage.eINSTANCE.getArgumentElement_Description();

    /**
     * The meta object literal for the '<em><b>Content Validity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__CONTENT_VALIDITY = GSNPackage.eINSTANCE.getArgumentElement_ContentValidity();

    /**
     * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_ELEMENT__STATUS = GSNPackage.eINSTANCE.getArgumentElement_Status();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.StatefulElementImpl <em>Stateful Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.StatefulElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getStatefulElement()
     * @generated
     */
    EClass STATEFUL_ELEMENT = GSNPackage.eINSTANCE.getStatefulElement();

    /**
     * The meta object literal for the '<em><b>State Validity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEFUL_ELEMENT__STATE_VALIDITY = GSNPackage.eINSTANCE.getStatefulElement_StateValidity();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILfulElementImpl <em>ASI Lful Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILfulElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILfulElement()
     * @generated
     */
    EClass ASI_LFUL_ELEMENT = GSNPackage.eINSTANCE.getASILfulElement();

    /**
     * The meta object literal for the '<em><b>Asil</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASI_LFUL_ELEMENT__ASIL = GSNPackage.eINSTANCE.getASILfulElement_Asil();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.CoreElementImpl <em>Core Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.CoreElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getCoreElement()
     * @generated
     */
    EClass CORE_ELEMENT = GSNPackage.eINSTANCE.getCoreElement();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DecomposableCoreElementImpl <em>Decomposable Core Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.DecomposableCoreElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDecomposableCoreElement()
     * @generated
     */
    EClass DECOMPOSABLE_CORE_ELEMENT = GSNPackage.eINSTANCE.getDecomposableCoreElement();

    /**
     * The meta object literal for the '<em><b>In Context Of</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = GSNPackage.eINSTANCE.getDecomposableCoreElement_InContextOf();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextualElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContextualElement()
     * @generated
     */
    EClass CONTEXTUAL_ELEMENT = GSNPackage.eINSTANCE.getContextualElement();

    /**
     * The meta object literal for the '<em><b>Context Of</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXTUAL_ELEMENT__CONTEXT_OF = GSNPackage.eINSTANCE.getContextualElement_ContextOf();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl <em>Supported By</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportedBy()
     * @generated
     */
    EClass SUPPORTED_BY = GSNPackage.eINSTANCE.getSupportedBy();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTED_BY__SOURCE = GSNPackage.eINSTANCE.getSupportedBy_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTED_BY__TARGET = GSNPackage.eINSTANCE.getSupportedBy_Target();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getInContextOf()
     * @generated
     */
    EClass IN_CONTEXT_OF = GSNPackage.eINSTANCE.getInContextOf();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IN_CONTEXT_OF__CONTEXT = GSNPackage.eINSTANCE.getInContextOf_Context();

    /**
     * The meta object literal for the '<em><b>Context Of</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IN_CONTEXT_OF__CONTEXT_OF = GSNPackage.eINSTANCE.getInContextOf_ContextOf();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl <em>Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getGoal()
     * @generated
     */
    EClass GOAL = GSNPackage.eINSTANCE.getGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.BasicGoalImpl <em>Basic Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.BasicGoalImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getBasicGoal()
     * @generated
     */
    EClass BASIC_GOAL = GSNPackage.eINSTANCE.getBasicGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.IndependenceGoalImpl <em>Independence Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.IndependenceGoalImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getIndependenceGoal()
     * @generated
     */
    EClass INDEPENDENCE_GOAL = GSNPackage.eINSTANCE.getIndependenceGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DomainGoalImpl <em>Domain Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.DomainGoalImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDomainGoal()
     * @generated
     */
    EClass DOMAIN_GOAL = GSNPackage.eINSTANCE.getDomainGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionElementImpl <em>Property Decomposition Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getPropertyDecompositionElement()
     * @generated
     */
    EClass PROPERTY_DECOMPOSITION_ELEMENT = GSNPackage.eINSTANCE.getPropertyDecompositionElement();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY = GSNPackage.eINSTANCE.getPropertyDecompositionElement_Property();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionStrategyImpl <em>Property Decomposition Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.PropertyDecompositionStrategyImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getPropertyDecompositionStrategy()
     * @generated
     */
    EClass PROPERTY_DECOMPOSITION_STRATEGY = GSNPackage.eINSTANCE.getPropertyDecompositionStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.PropertyGoalImpl <em>Property Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.PropertyGoalImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getPropertyGoal()
     * @generated
     */
    EClass PROPERTY_GOAL = GSNPackage.eINSTANCE.getPropertyGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getStrategy()
     * @generated
     */
    EClass STRATEGY = GSNPackage.eINSTANCE.getStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.BasicStrategyImpl <em>Basic Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.BasicStrategyImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getBasicStrategy()
     * @generated
     */
    EClass BASIC_STRATEGY = GSNPackage.eINSTANCE.getBasicStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILDecompositionStrategyImpl <em>ASIL Decomposition Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILDecompositionStrategyImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILDecompositionStrategy()
     * @generated
     */
    EClass ASIL_DECOMPOSITION_STRATEGY = GSNPackage.eINSTANCE.getASILDecompositionStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl <em>Solution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSolution()
     * @generated
     */
    EClass SOLUTION = GSNPackage.eINSTANCE.getSolution();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContext()
     * @generated
     */
    EClass CONTEXT = GSNPackage.eINSTANCE.getContext();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.JustificationImpl <em>Justification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.JustificationImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getJustification()
     * @generated
     */
    EClass JUSTIFICATION = GSNPackage.eINSTANCE.getJustification();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.AssumptionImpl <em>Assumption</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.AssumptionImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getAssumption()
     * @generated
     */
    EClass ASSUMPTION = GSNPackage.eINSTANCE.getAssumption();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILImpl <em>ASIL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASIL()
     * @generated
     */
    EClass ASIL = GSNPackage.eINSTANCE.getASIL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASIL__VALUE = GSNPackage.eINSTANCE.getASIL_Value();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASIL__TARGET = GSNPackage.eINSTANCE.getASIL_Target();

    /**
     * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASIL__STATUS = GSNPackage.eINSTANCE.getASIL_Status();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl <em>Impact Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getImpactAnnotation()
     * @generated
     */
    EClass IMPACT_ANNOTATION = GSNPackage.eINSTANCE.getImpactAnnotation();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPACT_ANNOTATION__TYPE = GSNPackage.eINSTANCE.getImpactAnnotation_Type();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPACT_ANNOTATION__SOURCE = GSNPackage.eINSTANCE.getImpactAnnotation_Source();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl <em>Supportable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportable()
     * @generated
     */
    EClass SUPPORTABLE = GSNPackage.eINSTANCE.getSupportable();

    /**
     * The meta object literal for the '<em><b>Supported By</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTABLE__SUPPORTED_BY = GSNPackage.eINSTANCE.getSupportable_SupportedBy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupporterImpl <em>Supporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupporterImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupporter()
     * @generated
     */
    EClass SUPPORTER = GSNPackage.eINSTANCE.getSupporter();

    /**
     * The meta object literal for the '<em><b>Supports</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTER__SUPPORTS = GSNPackage.eINSTANCE.getSupporter_Supports();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportConnectorImpl <em>Support Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportConnectorImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportConnector()
     * @generated
     */
    EClass SUPPORT_CONNECTOR = GSNPackage.eINSTANCE.getSupportConnector();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.AndSupporterImpl <em>And Supporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.AndSupporterImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getAndSupporter()
     * @generated
     */
    EClass AND_SUPPORTER = GSNPackage.eINSTANCE.getAndSupporter();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.OrSupporterImpl <em>Or Supporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.OrSupporterImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getOrSupporter()
     * @generated
     */
    EClass OR_SUPPORTER = GSNPackage.eINSTANCE.getOrSupporter();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.XorSupporterImpl <em>Xor Supporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.XorSupporterImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getXorSupporter()
     * @generated
     */
    EClass XOR_SUPPORTER = GSNPackage.eINSTANCE.getXorSupporter();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.MofNSupporterImpl <em>Mof NSupporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.MofNSupporterImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getMofNSupporter()
     * @generated
     */
    EClass MOF_NSUPPORTER = GSNPackage.eINSTANCE.getMofNSupporter();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOF_NSUPPORTER__TARGET = GSNPackage.eINSTANCE.getMofNSupporter_Target();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DecompositionStrategyImpl <em>Decomposition Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.DecompositionStrategyImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDecompositionStrategy()
     * @generated
     */
    EClass DECOMPOSITION_STRATEGY = GSNPackage.eINSTANCE.getDecompositionStrategy();

    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation DECOMPOSITION_STRATEGY___VALIDATE = GSNPackage.eINSTANCE.getDecompositionStrategy__Validate();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.DomainImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = GSNPackage.eINSTANCE.getDomain();

    /**
     * The meta object literal for the '<em><b>Validate Decomposition</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation DOMAIN___VALIDATE_DECOMPOSITION__ELIST = GSNPackage.eINSTANCE.getDomain__ValidateDecomposition__EList();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.IntDomainImpl <em>Int Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.IntDomainImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getIntDomain()
     * @generated
     */
    EClass INT_DOMAIN = GSNPackage.eINSTANCE.getIntDomain();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_DOMAIN__LOWER_BOUND = GSNPackage.eINSTANCE.getIntDomain_LowerBound();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_DOMAIN__UPPER_BOUND = GSNPackage.eINSTANCE.getIntDomain_UpperBound();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.RealDomainImpl <em>Real Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.RealDomainImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getRealDomain()
     * @generated
     */
    EClass REAL_DOMAIN = GSNPackage.eINSTANCE.getRealDomain();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_DOMAIN__LOWER_BOUND = GSNPackage.eINSTANCE.getRealDomain_LowerBound();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_DOMAIN__UPPER_BOUND = GSNPackage.eINSTANCE.getRealDomain_UpperBound();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.EnumDomainImpl <em>Enum Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.EnumDomainImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getEnumDomain()
     * @generated
     */
    EClass ENUM_DOMAIN = GSNPackage.eINSTANCE.getEnumDomain();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_DOMAIN__VALUES = GSNPackage.eINSTANCE.getEnumDomain_Values();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ValueDomainImpl <em>Value Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ValueDomainImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getValueDomain()
     * @generated
     */
    EClass VALUE_DOMAIN = GSNPackage.eINSTANCE.getValueDomain();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_DOMAIN__VALUE = GSNPackage.eINSTANCE.getValueDomain_Value();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DomainDecompositionElementImpl <em>Domain Decomposition Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.DomainDecompositionElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDomainDecompositionElement()
     * @generated
     */
    EClass DOMAIN_DECOMPOSITION_ELEMENT = GSNPackage.eINSTANCE.getDomainDecompositionElement();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN = GSNPackage.eINSTANCE.getDomainDecompositionElement_Domain();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DomainDecompositionStrategyImpl <em>Domain Decomposition Strategy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.DomainDecompositionStrategyImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDomainDecompositionStrategy()
     * @generated
     */
    EClass DOMAIN_DECOMPOSITION_STRATEGY = GSNPackage.eINSTANCE.getDomainDecompositionStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.ASILLevel <em>ASIL Level</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.ASILLevel
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILLevel()
     * @generated
     */
    EEnum ASIL_LEVEL = GSNPackage.eINSTANCE.getASILLevel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.ValidityValue <em>Validity Value</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.ValidityValue
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getValidityValue()
     * @generated
     */
    EEnum VALIDITY_VALUE = GSNPackage.eINSTANCE.getValidityValue();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactType <em>Impact Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.ImpactType
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getImpactType()
     * @generated
     */
    EEnum IMPACT_TYPE = GSNPackage.eINSTANCE.getImpactType();

    /**
     * The meta object literal for the '<em>MMINT Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.MMINTException
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getMMINTException()
     * @generated
     */
    EDataType MMINT_EXCEPTION = GSNPackage.eINSTANCE.getMMINTException();

  }

} //GSNPackage
