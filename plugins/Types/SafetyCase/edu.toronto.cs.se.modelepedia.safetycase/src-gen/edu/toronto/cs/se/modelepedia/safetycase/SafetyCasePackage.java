/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
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
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory
 * @model kind="package"
 * @generated
 */
public interface SafetyCasePackage extends EPackage {
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
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/SafetyCase";

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
	SafetyCasePackage eINSTANCE = edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getSafetyCase()
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
	 * The number of structural features of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_FEATURE_COUNT = 4;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getArgumentElement()
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
	 * The feature id for the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT__STATUS = 2;

	/**
	 * The number of structural features of the '<em>Argument Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Argument Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.CoreElementImpl <em>Core Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.CoreElementImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getCoreElement()
	 * @generated
	 */
	int CORE_ELEMENT = 2;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl <em>Decomposable Core Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getDecomposableCoreElement()
	 * @generated
	 */
	int DECOMPOSABLE_CORE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__ID = CORE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION = CORE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__STATUS = CORE_ELEMENT__STATUS;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__SUPPORTS = CORE_ELEMENT__SUPPORTS;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY = CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = CORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Decomposable Core Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT = CORE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Decomposable Core Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT = CORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContextualElementImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContextualElement()
	 * @generated
	 */
	int CONTEXTUAL_ELEMENT = 4;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getSupportedBy()
	 * @generated
	 */
	int SUPPORTED_BY = 5;

	/**
	 * The feature id for the '<em><b>Conclusion</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY__CONCLUSION = 0;

	/**
	 * The feature id for the '<em><b>Premise</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY__PREMISE = 1;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getInContextOf()
	 * @generated
	 */
	int IN_CONTEXT_OF = 6;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 7;

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
	 * The feature id for the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATUS = DECOMPOSABLE_CORE_ELEMENT__STATUS;

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
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__IN_CONTEXT_OF = DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATE = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl <em>Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStrategy()
	 * @generated
	 */
	int STRATEGY = 8;

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
	 * The feature id for the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__STATUS = DECOMPOSABLE_CORE_ELEMENT__STATUS;

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
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__IN_CONTEXT_OF = DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__STATE = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_FEATURE_COUNT = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_OPERATION_COUNT = DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 9;

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
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__STATE = CORE_ELEMENT_FEATURE_COUNT + 0;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 10;

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
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__STATE = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ImpactAnnotationImpl <em>Impact Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ImpactAnnotationImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getImpactAnnotation()
	 * @generated
	 */
	int IMPACT_ANNOTATION = 11;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl <em>ASIL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASIL()
	 * @generated
	 */
	int ASIL = 12;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__LEVEL = 1;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.TruthState <em>Truth State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.TruthState
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getTruthState()
	 * @generated
	 */
	int TRUTH_STATE = 13;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILLevel <em>ASIL Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILLevel
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILLevel()
	 * @generated
	 */
	int ASIL_LEVEL = 14;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ValidityState <em>Validity State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityState
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getValidityState()
	 * @generated
	 */
	int VALIDITY_STATE = 15;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ImpactType <em>Impact Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ImpactType
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getImpactType()
	 * @generated
	 */
	int IMPACT_TYPE = 16;


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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.CoreElement <em>Core Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.CoreElement
	 * @generated
	 */
	EClass getCoreElement();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.CoreElement#getSupports <em>Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supports</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.CoreElement#getSupports()
	 * @see #getCoreElement()
	 * @generated
	 */
	EReference getCoreElement_Supports();

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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement#getSupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supported By</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement#getSupportedBy()
	 * @see #getDecomposableCoreElement()
	 * @generated
	 */
	EReference getDecomposableCoreElement_SupportedBy();

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
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getConclusion <em>Conclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Conclusion</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getConclusion()
	 * @see #getSupportedBy()
	 * @generated
	 */
	EReference getSupportedBy_Conclusion();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getPremise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Premise</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getPremise()
	 * @see #getSupportedBy()
	 * @generated
	 */
	EReference getSupportedBy_Premise();

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
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.Goal#getState()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_State();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getAsil <em>Asil</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Asil</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.Goal#getAsil()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_Asil();

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
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.Strategy#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.Strategy#getState()
	 * @see #getStrategy()
	 * @generated
	 */
	EAttribute getStrategy_State();

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
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.Solution#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.Solution#getState()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_State();

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
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.Context#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.Context#getState()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_State();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL <em>ASIL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ASIL</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL
	 * @generated
	 */
	EClass getASIL();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL#getOwner()
	 * @see #getASIL()
	 * @generated
	 */
	EReference getASIL_Owner();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL#getLevel()
	 * @see #getASIL()
	 * @generated
	 */
	EAttribute getASIL_Level();

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
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.safetycase.TruthState <em>Truth State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Truth State</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.TruthState
	 * @generated
	 */
	EEnum getTruthState();

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
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.safetycase.ValidityState <em>Validity State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Validity State</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityState
	 * @generated
	 */
	EEnum getValidityState();

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
	SafetyCaseFactory getSafetyCaseFactory();

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
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getSafetyCase()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ArgumentElementImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getArgumentElement()
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
		 * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT_ELEMENT__STATUS = eINSTANCE.getArgumentElement_Status();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.CoreElementImpl <em>Core Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.CoreElementImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getCoreElement()
		 * @generated
		 */
		EClass CORE_ELEMENT = eINSTANCE.getCoreElement();

		/**
		 * The meta object literal for the '<em><b>Supports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_ELEMENT__SUPPORTS = eINSTANCE.getCoreElement_Supports();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl <em>Decomposable Core Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getDecomposableCoreElement()
		 * @generated
		 */
		EClass DECOMPOSABLE_CORE_ELEMENT = eINSTANCE.getDecomposableCoreElement();

		/**
		 * The meta object literal for the '<em><b>Supported By</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY = eINSTANCE.getDecomposableCoreElement_SupportedBy();

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
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContextualElement()
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
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getSupportedBy()
		 * @generated
		 */
		EClass SUPPORTED_BY = eINSTANCE.getSupportedBy();

		/**
		 * The meta object literal for the '<em><b>Conclusion</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPPORTED_BY__CONCLUSION = eINSTANCE.getSupportedBy_Conclusion();

		/**
		 * The meta object literal for the '<em><b>Premise</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPPORTED_BY__PREMISE = eINSTANCE.getSupportedBy_Premise();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.InContextOfImpl <em>In Context Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.InContextOfImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getInContextOf()
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
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL__STATE = eINSTANCE.getGoal_State();

		/**
		 * The meta object literal for the '<em><b>Asil</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__ASIL = eINSTANCE.getGoal_Asil();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl <em>Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStrategy()
		 * @generated
		 */
		EClass STRATEGY = eINSTANCE.getStrategy();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRATEGY__STATE = eINSTANCE.getStrategy_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl <em>Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SolutionImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getSolution()
		 * @generated
		 */
		EClass SOLUTION = eINSTANCE.getSolution();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__STATE = eINSTANCE.getSolution_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT__STATE = eINSTANCE.getContext_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ImpactAnnotationImpl <em>Impact Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ImpactAnnotationImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getImpactAnnotation()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl <em>ASIL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASIL()
		 * @generated
		 */
		EClass ASIL = eINSTANCE.getASIL();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASIL__OWNER = eINSTANCE.getASIL_Owner();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASIL__LEVEL = eINSTANCE.getASIL_Level();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASIL__STATUS = eINSTANCE.getASIL_Status();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.TruthState <em>Truth State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.TruthState
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getTruthState()
		 * @generated
		 */
		EEnum TRUTH_STATE = eINSTANCE.getTruthState();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILLevel <em>ASIL Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILLevel
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILLevel()
		 * @generated
		 */
		EEnum ASIL_LEVEL = eINSTANCE.getASILLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ValidityState <em>Validity State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityState
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getValidityState()
		 * @generated
		 */
		EEnum VALIDITY_STATE = eINSTANCE.getValidityState();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ImpactType <em>Impact Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.ImpactType
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getImpactType()
		 * @generated
		 */
		EEnum IMPACT_TYPE = eINSTANCE.getImpactType();

	}

} //SafetyCasePackage
