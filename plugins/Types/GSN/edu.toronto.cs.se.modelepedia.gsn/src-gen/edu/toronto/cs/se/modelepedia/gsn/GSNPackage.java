/*******************************************************************************
 * Copyright (c) 2017, 2025 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gsn";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://se.cs.toronto.edu/modelepedia/GSN";

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gsn";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  GSNPackage eINSTANCE = edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSafetyCase()
   * @generated
   */
  int SAFETY_CASE = 0;

  /**
   * The feature id for the '<em><b>Goals</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__GOALS = 0;

  /**
   * The feature id for the '<em><b>Strategies</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__STRATEGIES = 1;

  /**
   * The feature id for the '<em><b>Solutions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__SOLUTIONS = 2;

  /**
   * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__CONTEXTS = 3;

  /**
   * The feature id for the '<em><b>Justifications</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__JUSTIFICATIONS = 4;

  /**
   * The feature id for the '<em><b>Assumptions</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__ASSUMPTIONS = 5;

  /**
   * The feature id for the '<em><b>Templates</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE__TEMPLATES = 6;

  /**
   * The number of structural features of the '<em>Safety Case</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int SAFETY_CASE_FEATURE_COUNT = 7;

  /**
   * The number of operations of the '<em>Safety Case</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_CASE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getArgumentElement()
   * @generated
   */
  int ARGUMENT_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__ID = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__DESCRIPTION = 1;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__STATUS = 2;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__TEMPLATES = 3;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT__VALID = 4;

  /**
   * The number of structural features of the '<em>Argument Element</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT_FEATURE_COUNT = 5;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT___VALIDATE__TEMPLATE = 0;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT___INSTANTIATE__TEMPLATE = 1;

  /**
   * The number of operations of the '<em>Argument Element</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ELEMENT_OPERATION_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DecoratableImpl <em>Decoratable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.DecoratableImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDecoratable()
   * @generated
   */
  int DECORATABLE = 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE__ID = GSNPackage.ARGUMENT_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE__DESCRIPTION = GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE__STATUS = GSNPackage.ARGUMENT_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE__TEMPLATES = GSNPackage.ARGUMENT_ELEMENT__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE__VALID = GSNPackage.ARGUMENT_ELEMENT__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE__DECORATORS = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Decoratable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE_FEATURE_COUNT = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE___VALIDATE__TEMPLATE = GSNPackage.ARGUMENT_ELEMENT___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE___INSTANTIATE__TEMPLATE = GSNPackage.ARGUMENT_ELEMENT___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Decoratable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECORATABLE_OPERATION_COUNT = GSNPackage.ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILfulElementImpl <em>ASI Lful Element</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILfulElementImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILfulElement()
   * @generated
   */
  int ASI_LFUL_ELEMENT = 9;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupporterImpl <em>Supporter</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupporterImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupporter()
   * @generated
   */
  int SUPPORTER = 4;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl <em>Supportable</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportable()
   * @generated
   */
  int SUPPORTABLE = 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__ID = GSNPackage.DECORATABLE__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__DESCRIPTION = GSNPackage.DECORATABLE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__STATUS = GSNPackage.DECORATABLE__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__TEMPLATES = GSNPackage.DECORATABLE__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__VALID = GSNPackage.DECORATABLE__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__DECORATORS = GSNPackage.DECORATABLE__DECORATORS;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl <em>Supported By</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportedBy()
   * @generated
   */
  int SUPPORTED_BY = 5;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getInContextOf()
   * @generated
   */
  int IN_CONTEXT_OF = 8;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl <em>Goal</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getGoal()
   * @generated
   */
  int GOAL = 10;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getStrategy()
   * @generated
   */
  int STRATEGY = 11;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl <em>Solution</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSolution()
   * @generated
   */
  int SOLUTION = 12;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl <em>Context</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 13;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.JustificationImpl <em>Justification</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.JustificationImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getJustification()
   * @generated
   */
  int JUSTIFICATION = 14;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.AssumptionImpl <em>Assumption</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.AssumptionImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getAssumption()
   * @generated
   */
  int ASSUMPTION = 15;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILImpl <em>ASIL</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASIL()
   * @generated
   */
  int ASIL = 17;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl <em>Impact Annotation</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getImpactAnnotation()
   * @generated
   */
  int IMPACT_ANNOTATION = 18;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__SUPPORTED_BY = GSNPackage.DECORATABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE__UNDEVELOPED = GSNPackage.DECORATABLE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Supportable</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int SUPPORTABLE_FEATURE_COUNT = GSNPackage.DECORATABLE_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE___VALIDATE__TEMPLATE = GSNPackage.DECORATABLE___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE___INSTANTIATE__TEMPLATE = GSNPackage.DECORATABLE___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Supportable</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTABLE_OPERATION_COUNT = GSNPackage.DECORATABLE_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER__ID = GSNPackage.ARGUMENT_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER__DESCRIPTION = GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER__STATUS = GSNPackage.ARGUMENT_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER__TEMPLATES = GSNPackage.ARGUMENT_ELEMENT__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER__VALID = GSNPackage.ARGUMENT_ELEMENT__VALID;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER__SUPPORTS = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Supporter</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER_FEATURE_COUNT = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER___VALIDATE__TEMPLATE = GSNPackage.ARGUMENT_ELEMENT___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER___INSTANTIATE__TEMPLATE = GSNPackage.ARGUMENT_ELEMENT___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Supporter</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTER_OPERATION_COUNT = GSNPackage.ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTED_BY__SOURCE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTED_BY__TARGET = 1;

  /**
   * The number of structural features of the '<em>Supported By</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int SUPPORTED_BY_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Supported By</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPPORTED_BY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextualizableImpl <em>Contextualizable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextualizableImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContextualizable()
   * @generated
   */
  int CONTEXTUALIZABLE = 6;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE__ID = GSNPackage.DECORATABLE__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE__DESCRIPTION = GSNPackage.DECORATABLE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE__STATUS = GSNPackage.DECORATABLE__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE__TEMPLATES = GSNPackage.DECORATABLE__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE__VALID = GSNPackage.DECORATABLE__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE__DECORATORS = GSNPackage.DECORATABLE__DECORATORS;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE__IN_CONTEXT_OF = GSNPackage.DECORATABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Contextualizable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE_FEATURE_COUNT = GSNPackage.DECORATABLE_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE___VALIDATE__TEMPLATE = GSNPackage.DECORATABLE___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE___INSTANTIATE__TEMPLATE = GSNPackage.DECORATABLE___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Contextualizable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUALIZABLE_OPERATION_COUNT = GSNPackage.DECORATABLE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextualImpl <em>Contextual</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextualImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContextual()
   * @generated
   */
  int CONTEXTUAL = 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL__ID = GSNPackage.ARGUMENT_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL__DESCRIPTION = GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL__STATUS = GSNPackage.ARGUMENT_ELEMENT__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL__TEMPLATES = GSNPackage.ARGUMENT_ELEMENT__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL__VALID = GSNPackage.ARGUMENT_ELEMENT__VALID;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL__CONTEXT_OF = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Contextual</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_FEATURE_COUNT = GSNPackage.ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL___VALIDATE__TEMPLATE = GSNPackage.ARGUMENT_ELEMENT___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL___INSTANTIATE__TEMPLATE = GSNPackage.ARGUMENT_ELEMENT___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Contextual</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXTUAL_OPERATION_COUNT = GSNPackage.ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Context</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_CONTEXT_OF__CONTEXT = 0;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int IN_CONTEXT_OF__CONTEXT_OF = 1;

  /**
   * The number of structural features of the '<em>In Context Of</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int IN_CONTEXT_OF_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>In Context Of</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_CONTEXT_OF_OPERATION_COUNT = 0;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASI_LFUL_ELEMENT__ASIL = 0;

  /**
   * The number of structural features of the '<em>ASI Lful Element</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int ASI_LFUL_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>ASI Lful Element</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASI_LFUL_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ID = GSNPackage.SUPPORTABLE__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DESCRIPTION = GSNPackage.SUPPORTABLE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int GOAL__STATUS = GSNPackage.SUPPORTABLE__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TEMPLATES = GSNPackage.SUPPORTABLE__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__VALID = GSNPackage.SUPPORTABLE__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DECORATORS = GSNPackage.SUPPORTABLE__DECORATORS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__SUPPORTED_BY = GSNPackage.SUPPORTABLE__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__UNDEVELOPED = GSNPackage.SUPPORTABLE__UNDEVELOPED;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__SUPPORTS = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__IN_CONTEXT_OF = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Asil</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ASIL = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Goal</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FEATURE_COUNT = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 3;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL___VALIDATE__TEMPLATE = GSNPackage.SUPPORTABLE___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL___INSTANTIATE__TEMPLATE = GSNPackage.SUPPORTABLE___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Goal</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_OPERATION_COUNT = GSNPackage.SUPPORTABLE_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__ID = GSNPackage.SUPPORTABLE__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__DESCRIPTION = GSNPackage.SUPPORTABLE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int STRATEGY__STATUS = GSNPackage.SUPPORTABLE__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__TEMPLATES = GSNPackage.SUPPORTABLE__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__VALID = GSNPackage.SUPPORTABLE__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__DECORATORS = GSNPackage.SUPPORTABLE__DECORATORS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__SUPPORTED_BY = GSNPackage.SUPPORTABLE__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__UNDEVELOPED = GSNPackage.SUPPORTABLE__UNDEVELOPED;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__SUPPORTS = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__IN_CONTEXT_OF = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Strategy</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_FEATURE_COUNT = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY___VALIDATE__TEMPLATE = GSNPackage.SUPPORTABLE___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY___INSTANTIATE__TEMPLATE = GSNPackage.SUPPORTABLE___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Strategy</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_OPERATION_COUNT = GSNPackage.SUPPORTABLE_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__ID = GSNPackage.SUPPORTER__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__DESCRIPTION = GSNPackage.SUPPORTER__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int SOLUTION__STATUS = GSNPackage.SUPPORTER__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__TEMPLATES = GSNPackage.SUPPORTER__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__VALID = GSNPackage.SUPPORTER__VALID;

  /**
   * The feature id for the '<em><b>Supports</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__SUPPORTS = GSNPackage.SUPPORTER__SUPPORTS;

  /**
   * The number of structural features of the '<em>Solution</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_FEATURE_COUNT = GSNPackage.SUPPORTER_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION___VALIDATE__TEMPLATE = GSNPackage.SUPPORTER___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION___INSTANTIATE__TEMPLATE = GSNPackage.SUPPORTER___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Solution</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_OPERATION_COUNT = GSNPackage.SUPPORTER_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__ID = GSNPackage.CONTEXTUAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__DESCRIPTION = GSNPackage.CONTEXTUAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int CONTEXT__STATUS = GSNPackage.CONTEXTUAL__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__TEMPLATES = GSNPackage.CONTEXTUAL__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__VALID = GSNPackage.CONTEXTUAL__VALID;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__CONTEXT_OF = GSNPackage.CONTEXTUAL__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Context</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_FEATURE_COUNT = GSNPackage.CONTEXTUAL_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT___VALIDATE__TEMPLATE = GSNPackage.CONTEXTUAL___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT___INSTANTIATE__TEMPLATE = GSNPackage.CONTEXTUAL___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Context</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_OPERATION_COUNT = GSNPackage.CONTEXTUAL_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__ID = GSNPackage.CONTEXTUAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__DESCRIPTION = GSNPackage.CONTEXTUAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int JUSTIFICATION__STATUS = GSNPackage.CONTEXTUAL__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__TEMPLATES = GSNPackage.CONTEXTUAL__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__VALID = GSNPackage.CONTEXTUAL__VALID;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION__CONTEXT_OF = GSNPackage.CONTEXTUAL__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Justification</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int JUSTIFICATION_FEATURE_COUNT = GSNPackage.CONTEXTUAL_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION___VALIDATE__TEMPLATE = GSNPackage.CONTEXTUAL___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION___INSTANTIATE__TEMPLATE = GSNPackage.CONTEXTUAL___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Justification</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUSTIFICATION_OPERATION_COUNT = GSNPackage.CONTEXTUAL_OPERATION_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__ID = GSNPackage.CONTEXTUAL__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__DESCRIPTION = GSNPackage.CONTEXTUAL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int ASSUMPTION__STATUS = GSNPackage.CONTEXTUAL__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__TEMPLATES = GSNPackage.CONTEXTUAL__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__VALID = GSNPackage.CONTEXTUAL__VALID;

  /**
   * The feature id for the '<em><b>Context Of</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION__CONTEXT_OF = GSNPackage.CONTEXTUAL__CONTEXT_OF;

  /**
   * The number of structural features of the '<em>Assumption</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_FEATURE_COUNT = GSNPackage.CONTEXTUAL_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION___VALIDATE__TEMPLATE = GSNPackage.CONTEXTUAL___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION___INSTANTIATE__TEMPLATE = GSNPackage.CONTEXTUAL___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Assumption</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_OPERATION_COUNT = GSNPackage.CONTEXTUAL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl <em>Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getTemplate()
   * @generated
   */
  int TEMPLATE = 19;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.UndevelopedImpl <em>Undeveloped</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.UndevelopedImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getUndeveloped()
   * @generated
   */
  int UNDEVELOPED = 16;

  /**
   * The number of structural features of the '<em>Undeveloped</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNDEVELOPED_FEATURE_COUNT = 0;

  /**
   * The number of operations of the '<em>Undeveloped</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNDEVELOPED_OPERATION_COUNT = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL__VALUE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL__TARGET = 1;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int ASIL__STATUS = 2;

  /**
   * The number of structural features of the '<em>ASIL</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>ASIL</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASIL_OPERATION_COUNT = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPACT_ANNOTATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPACT_ANNOTATION__SOURCE = 1;

  /**
   * The number of structural features of the '<em>Impact Annotation</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPACT_ANNOTATION_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Impact Annotation</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPACT_ANNOTATION_OPERATION_COUNT = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE__ELEMENTS = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE__ID = 1;

  /**
   * The number of structural features of the '<em>Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_FEATURE_COUNT = 2;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE___VALIDATE = 0;

  /**
   * The operation id for the '<em>Import </em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE___IMPORT____SAFETYCASE = 1;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE___INSTANTIATE = 2;

  /**
   * The operation id for the '<em>Impact</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE___IMPACT__GSNIMPACTSTEP_OBJECT = 3;

  /**
   * The operation id for the '<em>Repair</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE___REPAIR__OBJECT = 4;

  /**
   * The number of operations of the '<em>Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_OPERATION_COUNT = 5;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.RelationshipDecoratorImpl <em>Relationship Decorator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.RelationshipDecoratorImpl
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getRelationshipDecorator()
   * @generated
   */
  int RELATIONSHIP_DECORATOR = 20;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__ID = GSNPackage.SUPPORTABLE__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__DESCRIPTION = GSNPackage.SUPPORTABLE__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__STATUS = GSNPackage.SUPPORTABLE__STATUS;

  /**
   * The feature id for the '<em><b>Templates</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__TEMPLATES = GSNPackage.SUPPORTABLE__TEMPLATES;

  /**
   * The feature id for the '<em><b>Valid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__VALID = GSNPackage.SUPPORTABLE__VALID;

  /**
   * The feature id for the '<em><b>Decorators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__DECORATORS = GSNPackage.SUPPORTABLE__DECORATORS;

  /**
   * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__SUPPORTED_BY = GSNPackage.SUPPORTABLE__SUPPORTED_BY;

  /**
   * The feature id for the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__UNDEVELOPED = GSNPackage.SUPPORTABLE__UNDEVELOPED;

  /**
   * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__IN_CONTEXT_OF = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__TYPE = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR__CARDINALITY = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Relationship Decorator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR_FEATURE_COUNT = GSNPackage.SUPPORTABLE_FEATURE_COUNT + 3;

  /**
   * The operation id for the '<em>Validate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR___VALIDATE__TEMPLATE = GSNPackage.SUPPORTABLE___VALIDATE__TEMPLATE;

  /**
   * The operation id for the '<em>Instantiate</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR___INSTANTIATE__TEMPLATE = GSNPackage.SUPPORTABLE___INSTANTIATE__TEMPLATE;

  /**
   * The number of operations of the '<em>Relationship Decorator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_DECORATOR_OPERATION_COUNT = GSNPackage.SUPPORTABLE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.ASILLevel <em>ASIL Level</em>}' enum. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILLevel
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILLevel()
   * @generated
   */
  int ASIL_LEVEL = 21;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactType <em>Impact Type</em>}' enum. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactType
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getImpactType()
   * @generated
   */
  int IMPACT_TYPE = 22;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.gsn.DecoratorType <em>Decorator Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.DecoratorType
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDecoratorType()
   * @generated
   */
  int DECORATOR_TYPE = 23;

  /**
   * The meta object id for the '<em>Exception</em>' data type.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see java.lang.Exception
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getException()
   * @generated
   */
  int EXCEPTION = 24;

  /**
   * The meta object id for the '<em>Builder</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getGSNBuilder()
   * @generated
   */
  int GSN_BUILDER = 25;

  /**
   * The meta object id for the '<em>Impact Step</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.gsn.util.GSNImpactStep
   * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getGSNImpactStep()
   * @generated
   */
  int GSN_IMPACT_STEP = 26;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase <em>Safety Case</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Safety Case</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase
   * @generated
   */
  EClass getSafetyCase();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getGoals <em>Goals</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
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
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contexts</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getContexts()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Contexts();

  /**
   * Returns the meta object for the containment reference list
   * '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getJustifications <em>Justifications</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
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
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getTemplates <em>Templates</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Templates</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getTemplates()
   * @see #getSafetyCase()
   * @generated
   */
  EReference getSafetyCase_Templates();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement <em>Argument Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement
   * @generated
   */
  EClass getArgumentElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getId <em>Id</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getId()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_Id();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getDescription()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_Description();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getStatus <em>Status</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the containment reference '<em>Status</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getStatus()
   * @see #getArgumentElement()
   * @generated
   */
  EReference getArgumentElement_Status();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getTemplates <em>Templates</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Templates</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getTemplates()
   * @see #getArgumentElement()
   * @generated
   */
  EReference getArgumentElement_Templates();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#isValid <em>Valid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Valid</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#isValid()
   * @see #getArgumentElement()
   * @generated
   */
  EAttribute getArgumentElement_Valid();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#validate(edu.toronto.cs.se.modelepedia.gsn.Template) <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#validate(edu.toronto.cs.se.modelepedia.gsn.Template)
   * @generated
   */
  EOperation getArgumentElement__Validate__Template();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#instantiate(edu.toronto.cs.se.modelepedia.gsn.Template) <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#instantiate(edu.toronto.cs.se.modelepedia.gsn.Template)
   * @generated
   */
  EOperation getArgumentElement__Instantiate__Template();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Decoratable <em>Decoratable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decoratable</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Decoratable
   * @generated
   */
  EClass getDecoratable();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.Decoratable#getDecorators <em>Decorators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decorators</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Decoratable#getDecorators()
   * @see #getDecoratable()
   * @generated
   */
  EReference getDecoratable_Decorators();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement <em>ASI Lful Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>ASI Lful Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILfulElement
   * @generated
   */
  EClass getASILfulElement();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement#getAsil <em>Asil</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the containment reference '<em>Asil</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILfulElement#getAsil()
   * @see #getASILfulElement()
   * @generated
   */
  EReference getASILfulElement_Asil();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy <em>Supported By</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Supported By</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy
   * @generated
   */
  EClass getSupportedBy();

  /**
   * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getSource <em>Source</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Source</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getSource()
   * @see #getSupportedBy()
   * @generated
   */
  EReference getSupportedBy_Source();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getTarget()
   * @see #getSupportedBy()
   * @generated
   */
  EReference getSupportedBy_Target();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Contextualizable <em>Contextualizable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contextualizable</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Contextualizable
   * @generated
   */
  EClass getContextualizable();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.Contextualizable#getInContextOf <em>In Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>In Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Contextualizable#getInContextOf()
   * @see #getContextualizable()
   * @generated
   */
  EReference getContextualizable_InContextOf();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Contextual <em>Contextual</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contextual</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Contextual
   * @generated
   */
  EClass getContextual();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.gsn.Contextual#getContextOf <em>Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Contextual#getContextOf()
   * @see #getContextual()
   * @generated
   */
  EReference getContextual_ContextOf();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf <em>In Context Of</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>In Context Of</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.InContextOf
   * @generated
   */
  EClass getInContextOf();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContext <em>Context</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Goal <em>Goal</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Goal</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Goal
   * @generated
   */
  EClass getGoal();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Strategy <em>Strategy</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Strategy</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Strategy
   * @generated
   */
  EClass getStrategy();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Solution <em>Solution</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Solution</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Solution
   * @generated
   */
  EClass getSolution();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Context <em>Context</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Context</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Context
   * @generated
   */
  EClass getContext();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Justification <em>Justification</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Justification</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Justification
   * @generated
   */
  EClass getJustification();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Assumption <em>Assumption</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Assumption</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Assumption
   * @generated
   */
  EClass getAssumption();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL <em>ASIL</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>ASIL</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL
   * @generated
   */
  EClass getASIL();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL#getValue()
   * @see #getASIL()
   * @generated
   */
  EAttribute getASIL_Value();

  /**
   * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL#getTarget()
   * @see #getASIL()
   * @generated
   */
  EReference getASIL_Target();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getStatus <em>Status</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Status</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL#getStatus()
   * @see #getASIL()
   * @generated
   */
  EReference getASIL_Status();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation <em>Impact Annotation</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Impact Annotation</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation
   * @generated
   */
  EClass getImpactAnnotation();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getType <em>Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getType()
   * @see #getImpactAnnotation()
   * @generated
   */
  EAttribute getImpactAnnotation_Type();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getSource <em>Source</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getSource()
   * @see #getImpactAnnotation()
   * @generated
   */
  EAttribute getImpactAnnotation_Source();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Supportable <em>Supportable</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Supportable</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supportable
   * @generated
   */
  EClass getSupportable();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.gsn.Supportable#getSupportedBy <em>Supported By</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supported By</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supportable#getSupportedBy()
   * @see #getSupportable()
   * @generated
   */
  EReference getSupportable_SupportedBy();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.gsn.Supportable#getUndeveloped <em>Undeveloped</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Undeveloped</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supportable#getUndeveloped()
   * @see #getSupportable()
   * @generated
   */
  EReference getSupportable_Undeveloped();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Supporter <em>Supporter</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Supporter</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supporter
   * @generated
   */
  EClass getSupporter();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.gsn.Supporter#getSupports <em>Supports</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supports</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supporter#getSupports()
   * @see #getSupporter()
   * @generated
   */
  EReference getSupporter_Supports();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Template <em>Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template
   * @generated
   */
  EClass getTemplate();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.gsn.Template#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Elements</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#getElements()
   * @see #getTemplate()
   * @generated
   */
  EReference getTemplate_Elements();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.Template#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#getId()
   * @see #getTemplate()
   * @generated
   */
  EAttribute getTemplate_Id();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.Template#validate() <em>Validate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate</em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#validate()
   * @generated
   */
  EOperation getTemplate__Validate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.Template#import_(edu.toronto.cs.se.modelepedia.gsn.SafetyCase) <em>Import </em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Import </em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#import_(edu.toronto.cs.se.modelepedia.gsn.SafetyCase)
   * @generated
   */
  EOperation getTemplate__Import___SafetyCase();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.Template#instantiate() <em>Instantiate</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Instantiate</em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#instantiate()
   * @generated
   */
  EOperation getTemplate__Instantiate();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.Template#impact(edu.toronto.cs.se.modelepedia.gsn.util.GSNImpactStep, java.lang.Object) <em>Impact</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Impact</em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#impact(edu.toronto.cs.se.modelepedia.gsn.util.GSNImpactStep, java.lang.Object)
   * @generated
   */
  EOperation getTemplate__Impact__GSNImpactStep_Object();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.gsn.Template#repair(java.lang.Object) <em>Repair</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Repair</em>' operation.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#repair(java.lang.Object)
   * @generated
   */
  EOperation getTemplate__Repair__Object();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator <em>Relationship Decorator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relationship Decorator</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator
   * @generated
   */
  EClass getRelationshipDecorator();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator#getType()
   * @see #getRelationshipDecorator()
   * @generated
   */
  EAttribute getRelationshipDecorator_Type();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator#getCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cardinality</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator#getCardinality()
   * @see #getRelationshipDecorator()
   * @generated
   */
  EAttribute getRelationshipDecorator_Cardinality();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.gsn.Undeveloped <em>Undeveloped</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Undeveloped</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.Undeveloped
   * @generated
   */
  EClass getUndeveloped();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.gsn.ASILLevel <em>ASIL Level</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>ASIL Level</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILLevel
   * @generated
   */
  EEnum getASILLevel();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactType <em>Impact Type</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Impact Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactType
   * @generated
   */
  EEnum getImpactType();

  /**
   * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.gsn.DecoratorType <em>Decorator Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Decorator Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecoratorType
   * @generated
   */
  EEnum getDecoratorType();

  /**
   * Returns the meta object for data type '{@link java.lang.Exception <em>Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Exception</em>'.
   * @see java.lang.Exception
   * @model instanceClass="java.lang.Exception"
   * @generated
   */
  EDataType getException();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder <em>Builder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Builder</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder
   * @model instanceClass="edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder"
   * @generated
   */
  EDataType getGSNBuilder();

  /**
   * Returns the meta object for data type '{@link edu.toronto.cs.se.modelepedia.gsn.util.GSNImpactStep <em>Impact Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Impact Step</em>'.
   * @see edu.toronto.cs.se.modelepedia.gsn.util.GSNImpactStep
   * @model instanceClass="edu.toronto.cs.se.modelepedia.gsn.util.GSNImpactStep"
   * @generated
   */
  EDataType getGSNImpactStep();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GSNFactory getGSNFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each operation of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SafetyCaseImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSafetyCase()
     * @generated
     */
    EClass SAFETY_CASE = GSNPackage.eINSTANCE.getSafetyCase();

    /**
     * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__GOALS = GSNPackage.eINSTANCE.getSafetyCase_Goals();

    /**
     * The meta object literal for the '<em><b>Strategies</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SAFETY_CASE__STRATEGIES = GSNPackage.eINSTANCE.getSafetyCase_Strategies();

    /**
     * The meta object literal for the '<em><b>Solutions</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SAFETY_CASE__SOLUTIONS = GSNPackage.eINSTANCE.getSafetyCase_Solutions();

    /**
     * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SAFETY_CASE__CONTEXTS = GSNPackage.eINSTANCE.getSafetyCase_Contexts();

    /**
     * The meta object literal for the '<em><b>Justifications</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SAFETY_CASE__JUSTIFICATIONS = GSNPackage.eINSTANCE.getSafetyCase_Justifications();

    /**
     * The meta object literal for the '<em><b>Assumptions</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SAFETY_CASE__ASSUMPTIONS = GSNPackage.eINSTANCE.getSafetyCase_Assumptions();

    /**
     * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFETY_CASE__TEMPLATES = GSNPackage.eINSTANCE.getSafetyCase_Templates();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getArgumentElement()
     * @generated
     */
    EClass ARGUMENT_ELEMENT = GSNPackage.eINSTANCE.getArgumentElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__ID = GSNPackage.eINSTANCE.getArgumentElement_Id();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__DESCRIPTION = GSNPackage.eINSTANCE.getArgumentElement_Description();

    /**
     * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_ELEMENT__STATUS = GSNPackage.eINSTANCE.getArgumentElement_Status();

    /**
     * The meta object literal for the '<em><b>Templates</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_ELEMENT__TEMPLATES = GSNPackage.eINSTANCE.getArgumentElement_Templates();

    /**
     * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_ELEMENT__VALID = GSNPackage.eINSTANCE.getArgumentElement_Valid();

    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ARGUMENT_ELEMENT___VALIDATE__TEMPLATE = GSNPackage.eINSTANCE.getArgumentElement__Validate__Template();

    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ARGUMENT_ELEMENT___INSTANTIATE__TEMPLATE = GSNPackage.eINSTANCE.getArgumentElement__Instantiate__Template();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.DecoratableImpl <em>Decoratable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.DecoratableImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDecoratable()
     * @generated
     */
    EClass DECORATABLE = GSNPackage.eINSTANCE.getDecoratable();

    /**
     * The meta object literal for the '<em><b>Decorators</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECORATABLE__DECORATORS = GSNPackage.eINSTANCE.getDecoratable_Decorators();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILfulElementImpl <em>ASI Lful Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportedByImpl <em>Supported By</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference SUPPORTED_BY__TARGET = GSNPackage.eINSTANCE.getSupportedBy_Target();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextualizableImpl <em>Contextualizable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextualizableImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContextualizable()
     * @generated
     */
    EClass CONTEXTUALIZABLE = GSNPackage.eINSTANCE.getContextualizable();

    /**
     * The meta object literal for the '<em><b>In Context Of</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXTUALIZABLE__IN_CONTEXT_OF = GSNPackage.eINSTANCE.getContextualizable_InContextOf();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextualImpl <em>Contextual</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextualImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContextual()
     * @generated
     */
    EClass CONTEXTUAL = GSNPackage.eINSTANCE.getContextual();

    /**
     * The meta object literal for the '<em><b>Context Of</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXTUAL__CONTEXT_OF = GSNPackage.eINSTANCE.getContextual_ContextOf();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.InContextOfImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getInContextOf()
     * @generated
     */
    EClass IN_CONTEXT_OF = GSNPackage.eINSTANCE.getInContextOf();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getGoal()
     * @generated
     */
    EClass GOAL = GSNPackage.eINSTANCE.getGoal();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getStrategy()
     * @generated
     */
    EClass STRATEGY = GSNPackage.eINSTANCE.getStrategy();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl <em>Solution</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SolutionImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSolution()
     * @generated
     */
    EClass SOLUTION = GSNPackage.eINSTANCE.getSolution();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getContext()
     * @generated
     */
    EClass CONTEXT = GSNPackage.eINSTANCE.getContext();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.JustificationImpl <em>Justification</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.JustificationImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getJustification()
     * @generated
     */
    EClass JUSTIFICATION = GSNPackage.eINSTANCE.getJustification();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.AssumptionImpl <em>Assumption</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.AssumptionImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getAssumption()
     * @generated
     */
    EClass ASSUMPTION = GSNPackage.eINSTANCE.getAssumption();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.ASILImpl <em>ASIL</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ASILImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASIL()
     * @generated
     */
    EClass ASIL = GSNPackage.eINSTANCE.getASIL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getImpactAnnotation()
     * @generated
     */
    EClass IMPACT_ANNOTATION = GSNPackage.eINSTANCE.getImpactAnnotation();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute IMPACT_ANNOTATION__TYPE = GSNPackage.eINSTANCE.getImpactAnnotation_Type();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute IMPACT_ANNOTATION__SOURCE = GSNPackage.eINSTANCE.getImpactAnnotation_Source();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl <em>Supportable</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupportableImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupportable()
     * @generated
     */
    EClass SUPPORTABLE = GSNPackage.eINSTANCE.getSupportable();

    /**
     * The meta object literal for the '<em><b>Supported By</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SUPPORTABLE__SUPPORTED_BY = GSNPackage.eINSTANCE.getSupportable_SupportedBy();

    /**
     * The meta object literal for the '<em><b>Undeveloped</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPPORTABLE__UNDEVELOPED = GSNPackage.eINSTANCE.getSupportable_Undeveloped();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.SupporterImpl <em>Supporter</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.SupporterImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getSupporter()
     * @generated
     */
    EClass SUPPORTER = GSNPackage.eINSTANCE.getSupporter();

    /**
     * The meta object literal for the '<em><b>Supports</b></em>' reference list feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference SUPPORTER__SUPPORTS = GSNPackage.eINSTANCE.getSupporter_Supports();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl <em>Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getTemplate()
     * @generated
     */
    EClass TEMPLATE = GSNPackage.eINSTANCE.getTemplate();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEMPLATE__ELEMENTS = GSNPackage.eINSTANCE.getTemplate_Elements();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEMPLATE__ID = GSNPackage.eINSTANCE.getTemplate_Id();

    /**
     * The meta object literal for the '<em><b>Validate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation TEMPLATE___VALIDATE = GSNPackage.eINSTANCE.getTemplate__Validate();

    /**
     * The meta object literal for the '<em><b>Import </b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation TEMPLATE___IMPORT____SAFETYCASE = GSNPackage.eINSTANCE.getTemplate__Import___SafetyCase();

    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation TEMPLATE___INSTANTIATE = GSNPackage.eINSTANCE.getTemplate__Instantiate();

    /**
     * The meta object literal for the '<em><b>Impact</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation TEMPLATE___IMPACT__GSNIMPACTSTEP_OBJECT = GSNPackage.eINSTANCE.getTemplate__Impact__GSNImpactStep_Object();

    /**
     * The meta object literal for the '<em><b>Repair</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation TEMPLATE___REPAIR__OBJECT = GSNPackage.eINSTANCE.getTemplate__Repair__Object();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.RelationshipDecoratorImpl <em>Relationship Decorator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.RelationshipDecoratorImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getRelationshipDecorator()
     * @generated
     */
    EClass RELATIONSHIP_DECORATOR = GSNPackage.eINSTANCE.getRelationshipDecorator();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONSHIP_DECORATOR__TYPE = GSNPackage.eINSTANCE.getRelationshipDecorator_Type();

    /**
     * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONSHIP_DECORATOR__CARDINALITY = GSNPackage.eINSTANCE.getRelationshipDecorator_Cardinality();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.impl.UndevelopedImpl <em>Undeveloped</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.UndevelopedImpl
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getUndeveloped()
     * @generated
     */
    EClass UNDEVELOPED = GSNPackage.eINSTANCE.getUndeveloped();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.ASILLevel <em>ASIL Level</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.ASILLevel
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getASILLevel()
     * @generated
     */
    EEnum ASIL_LEVEL = GSNPackage.eINSTANCE.getASILLevel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactType <em>Impact Type</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.ImpactType
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getImpactType()
     * @generated
     */
    EEnum IMPACT_TYPE = GSNPackage.eINSTANCE.getImpactType();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.gsn.DecoratorType <em>Decorator Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.DecoratorType
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getDecoratorType()
     * @generated
     */
    EEnum DECORATOR_TYPE = GSNPackage.eINSTANCE.getDecoratorType();

    /**
     * The meta object literal for the '<em>Exception</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see java.lang.Exception
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getException()
     * @generated
     */
    EDataType EXCEPTION = GSNPackage.eINSTANCE.getException();

    /**
     * The meta object literal for the '<em>Builder</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getGSNBuilder()
     * @generated
     */
    EDataType GSN_BUILDER = GSNPackage.eINSTANCE.getGSNBuilder();

    /**
     * The meta object literal for the '<em>Impact Step</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.gsn.util.GSNImpactStep
     * @see edu.toronto.cs.se.modelepedia.gsn.impl.GSNPackageImpl#getGSNImpactStep()
     * @generated
     */
    EDataType GSN_IMPACT_STEP = GSNPackage.eINSTANCE.getGSNImpactStep();

  }

} // GSNPackage
