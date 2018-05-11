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
	 * The feature id for the '<em><b>Justifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__JUSTIFICATIONS = 4;

	/**
	 * The number of structural features of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContentfulElementImpl <em>Contentful Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContentfulElementImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContentfulElement()
	 * @generated
	 */
	int CONTENTFUL_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTFUL_ELEMENT__CONTENT_VALIDITY = 0;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTFUL_ELEMENT__CONTENT_STATUS = 1;

	/**
	 * The number of structural features of the '<em>Contentful Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTFUL_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Contentful Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTFUL_ELEMENT_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT__CONTENT_VALIDITY = CONTENTFUL_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT__CONTENT_STATUS = CONTENTFUL_ELEMENT__CONTENT_STATUS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT__ID = CONTENTFUL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT__DESCRIPTION = CONTENTFUL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Argument Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT_FEATURE_COUNT = CONTENTFUL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Argument Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT_OPERATION_COUNT = CONTENTFUL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl <em>Stateful Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStatefulElement()
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
	 * The feature id for the '<em><b>State Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_ELEMENT__STATE_STATUS = 1;

	/**
	 * The number of structural features of the '<em>Stateful Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_ELEMENT_FEATURE_COUNT = 2;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILfulElement()
	 * @generated
	 */
	int ASI_LFUL_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Asil</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASI_LFUL_ELEMENT__ASIL = 0;

	/**
	 * The feature id for the '<em><b>Asil Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASI_LFUL_ELEMENT__ASIL_STATUS = 1;

	/**
	 * The number of structural features of the '<em>ASI Lful Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASI_LFUL_ELEMENT_FEATURE_COUNT = 2;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getCoreElement()
	 * @generated
	 */
	int CORE_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT__CONTENT_VALIDITY = ARGUMENT_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT__CONTENT_STATUS = ARGUMENT_ELEMENT__CONTENT_STATUS;

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
	int DECOMPOSABLE_CORE_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY = CORE_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__CONTENT_STATUS = CORE_ELEMENT__CONTENT_STATUS;

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
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__SUPPORTS = CORE_ELEMENT__SUPPORTS;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY = CORE_ELEMENT_FEATURE_COUNT + 1;

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
	int CONTEXTUAL_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__CONTENT_VALIDITY = ARGUMENT_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__CONTENT_STATUS = ARGUMENT_ELEMENT__CONTENT_STATUS;

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
	int SUPPORTED_BY = 8;

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
	int IN_CONTEXT_OF = 9;

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
	int GOAL = 10;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__CONTENT_VALIDITY = DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__CONTENT_STATUS = DECOMPOSABLE_CORE_ELEMENT__CONTENT_STATUS;

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
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SUPPORTS = DECOMPOSABLE_CORE_ELEMENT__SUPPORTS;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__IN_CONTEXT_OF = DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SUPPORTED_BY = DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY;

	/**
	 * The feature id for the '<em><b>State Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATE_VALIDITY = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATE_STATUS = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Asil</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ASIL = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Asil Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ASIL_STATUS = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 4;

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
	int STRATEGY = 11;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__CONTENT_VALIDITY = DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__CONTENT_STATUS = DECOMPOSABLE_CORE_ELEMENT__CONTENT_STATUS;

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
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__SUPPORTS = DECOMPOSABLE_CORE_ELEMENT__SUPPORTS;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__IN_CONTEXT_OF = DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__SUPPORTED_BY = DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getBasicStrategy()
	 * @generated
	 */
	int BASIC_STRATEGY = 12;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STRATEGY__CONTENT_VALIDITY = STRATEGY__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STRATEGY__CONTENT_STATUS = STRATEGY__CONTENT_STATUS;

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
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STRATEGY__SUPPORTS = STRATEGY__SUPPORTS;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STRATEGY__IN_CONTEXT_OF = STRATEGY__IN_CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STRATEGY__SUPPORTED_BY = STRATEGY__SUPPORTED_BY;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILDecompositionStrategy()
	 * @generated
	 */
	int ASIL_DECOMPOSITION_STRATEGY = 13;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_DECOMPOSITION_STRATEGY__CONTENT_VALIDITY = STRATEGY__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_DECOMPOSITION_STRATEGY__CONTENT_STATUS = STRATEGY__CONTENT_STATUS;

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
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_DECOMPOSITION_STRATEGY__SUPPORTS = STRATEGY__SUPPORTS;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_DECOMPOSITION_STRATEGY__IN_CONTEXT_OF = STRATEGY__IN_CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_DECOMPOSITION_STRATEGY__SUPPORTED_BY = STRATEGY__SUPPORTED_BY;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 14;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__CONTENT_VALIDITY = CORE_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__CONTENT_STATUS = CORE_ELEMENT__CONTENT_STATUS;

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
	 * The feature id for the '<em><b>State Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__STATE_STATUS = CORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = CORE_ELEMENT_FEATURE_COUNT + 2;

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
	int CONTEXT = 15;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__CONTENT_VALIDITY = CONTEXTUAL_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__CONTENT_STATUS = CONTEXTUAL_ELEMENT__CONTENT_STATUS;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getJustification()
	 * @generated
	 */
	int JUSTIFICATION = 16;

	/**
	 * The feature id for the '<em><b>Content Validity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUSTIFICATION__CONTENT_VALIDITY = CONTEXTUAL_ELEMENT__CONTENT_VALIDITY;

	/**
	 * The feature id for the '<em><b>Content Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JUSTIFICATION__CONTENT_STATUS = CONTEXTUAL_ELEMENT__CONTENT_STATUS;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl <em>ASIL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASIL()
	 * @generated
	 */
	int ASIL = 17;

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
	 * The number of structural features of the '<em>ASIL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>ASIL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContentImpactAnnotationImpl <em>Content Impact Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContentImpactAnnotationImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContentImpactAnnotation()
	 * @generated
	 */
	int CONTENT_IMPACT_ANNOTATION = 18;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_IMPACT_ANNOTATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_IMPACT_ANNOTATION__SOURCE = 1;

	/**
	 * The number of structural features of the '<em>Content Impact Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_IMPACT_ANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Content Impact Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_IMPACT_ANNOTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StateImpactAnnotationImpl <em>State Impact Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StateImpactAnnotationImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStateImpactAnnotation()
	 * @generated
	 */
	int STATE_IMPACT_ANNOTATION = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_IMPACT_ANNOTATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_IMPACT_ANNOTATION__SOURCE = 1;

	/**
	 * The number of structural features of the '<em>State Impact Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_IMPACT_ANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>State Impact Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_IMPACT_ANNOTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpactAnnotationImpl <em>ASIL Impact Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpactAnnotationImpl
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILImpactAnnotation()
	 * @generated
	 */
	int ASIL_IMPACT_ANNOTATION = 20;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_IMPACT_ANNOTATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_IMPACT_ANNOTATION__SOURCE = 1;

	/**
	 * The number of structural features of the '<em>ASIL Impact Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_IMPACT_ANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>ASIL Impact Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_IMPACT_ANNOTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILLevel <em>ASIL Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILLevel
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILLevel()
	 * @generated
	 */
	int ASIL_LEVEL = 21;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ValidityValue <em>Validity Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getValidityValue()
	 * @generated
	 */
	int VALIDITY_VALUE = 22;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType <em>Content Impact Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContentImpactType()
	 * @generated
	 */
	int CONTENT_IMPACT_TYPE = 23;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.StateImpactType <em>State Impact Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.StateImpactType
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStateImpactType()
	 * @generated
	 */
	int STATE_IMPACT_TYPE = 24;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILImpactType <em>ASIL Impact Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILImpactType
	 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILImpactType()
	 * @generated
	 */
	int ASIL_IMPACT_TYPE = 25;


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
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.safetycase.StatefulElement#getStateStatus <em>State Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Status</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.StatefulElement#getStateStatus()
	 * @see #getStatefulElement()
	 * @generated
	 */
	EReference getStatefulElement_StateStatus();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentfulElement <em>Contentful Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contentful Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentfulElement
	 * @generated
	 */
	EClass getContentfulElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentfulElement#getContentValidity <em>Content Validity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Validity</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentfulElement#getContentValidity()
	 * @see #getContentfulElement()
	 * @generated
	 */
	EAttribute getContentfulElement_ContentValidity();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentfulElement#getContentStatus <em>Content Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content Status</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentfulElement#getContentStatus()
	 * @see #getContentfulElement()
	 * @generated
	 */
	EReference getContentfulElement_ContentStatus();

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
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement#getAsilStatus <em>Asil Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Asil Status</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement#getAsilStatus()
	 * @see #getASILfulElement()
	 * @generated
	 */
	EReference getASILfulElement_AsilStatus();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation <em>Content Impact Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Impact Annotation</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation
	 * @generated
	 */
	EClass getContentImpactAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation#getType()
	 * @see #getContentImpactAnnotation()
	 * @generated
	 */
	EAttribute getContentImpactAnnotation_Type();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation#getSource()
	 * @see #getContentImpactAnnotation()
	 * @generated
	 */
	EAttribute getContentImpactAnnotation_Source();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.StateImpactAnnotation <em>State Impact Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Impact Annotation</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.StateImpactAnnotation
	 * @generated
	 */
	EClass getStateImpactAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.StateImpactAnnotation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.StateImpactAnnotation#getType()
	 * @see #getStateImpactAnnotation()
	 * @generated
	 */
	EAttribute getStateImpactAnnotation_Type();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.StateImpactAnnotation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.StateImpactAnnotation#getSource()
	 * @see #getStateImpactAnnotation()
	 * @generated
	 */
	EAttribute getStateImpactAnnotation_Source();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILImpactAnnotation <em>ASIL Impact Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ASIL Impact Annotation</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILImpactAnnotation
	 * @generated
	 */
	EClass getASILImpactAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILImpactAnnotation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILImpactAnnotation#getType()
	 * @see #getASILImpactAnnotation()
	 * @generated
	 */
	EAttribute getASILImpactAnnotation_Type();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILImpactAnnotation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILImpactAnnotation#getSource()
	 * @see #getASILImpactAnnotation()
	 * @generated
	 */
	EAttribute getASILImpactAnnotation_Source();

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
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType <em>Content Impact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Content Impact Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType
	 * @generated
	 */
	EEnum getContentImpactType();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.safetycase.StateImpactType <em>State Impact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Impact Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.StateImpactType
	 * @generated
	 */
	EEnum getStateImpactType();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILImpactType <em>ASIL Impact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ASIL Impact Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILImpactType
	 * @generated
	 */
	EEnum getASILImpactType();

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
		 * The meta object literal for the '<em><b>Justifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__JUSTIFICATIONS = eINSTANCE.getSafetyCase_Justifications();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl <em>Stateful Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StatefulElementImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStatefulElement()
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
		 * The meta object literal for the '<em><b>State Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEFUL_ELEMENT__STATE_STATUS = eINSTANCE.getStatefulElement_StateStatus();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContentfulElementImpl <em>Contentful Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContentfulElementImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContentfulElement()
		 * @generated
		 */
		EClass CONTENTFUL_ELEMENT = eINSTANCE.getContentfulElement();

		/**
		 * The meta object literal for the '<em><b>Content Validity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENTFUL_ELEMENT__CONTENT_VALIDITY = eINSTANCE.getContentfulElement_ContentValidity();

		/**
		 * The meta object literal for the '<em><b>Content Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENTFUL_ELEMENT__CONTENT_STATUS = eINSTANCE.getContentfulElement_ContentStatus();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILfulElementImpl <em>ASI Lful Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILfulElementImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILfulElement()
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
		 * The meta object literal for the '<em><b>Asil Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASI_LFUL_ELEMENT__ASIL_STATUS = eINSTANCE.getASILfulElement_AsilStatus();

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
		 * The meta object literal for the '<em><b>In Context Of</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = eINSTANCE.getDecomposableCoreElement_InContextOf();

		/**
		 * The meta object literal for the '<em><b>Supported By</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY = eINSTANCE.getDecomposableCoreElement_SupportedBy();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl <em>Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StrategyImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStrategy()
		 * @generated
		 */
		EClass STRATEGY = eINSTANCE.getStrategy();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.BasicStrategyImpl <em>Basic Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.BasicStrategyImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getBasicStrategy()
		 * @generated
		 */
		EClass BASIC_STRATEGY = eINSTANCE.getBasicStrategy();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILDecompositionStrategyImpl <em>ASIL Decomposition Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILDecompositionStrategyImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILDecompositionStrategy()
		 * @generated
		 */
		EClass ASIL_DECOMPOSITION_STRATEGY = eINSTANCE.getASILDecompositionStrategy();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContextImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.JustificationImpl <em>Justification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.JustificationImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getJustification()
		 * @generated
		 */
		EClass JUSTIFICATION = eINSTANCE.getJustification();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ContentImpactAnnotationImpl <em>Content Impact Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ContentImpactAnnotationImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContentImpactAnnotation()
		 * @generated
		 */
		EClass CONTENT_IMPACT_ANNOTATION = eINSTANCE.getContentImpactAnnotation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_IMPACT_ANNOTATION__TYPE = eINSTANCE.getContentImpactAnnotation_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT_IMPACT_ANNOTATION__SOURCE = eINSTANCE.getContentImpactAnnotation_Source();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.StateImpactAnnotationImpl <em>State Impact Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.StateImpactAnnotationImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStateImpactAnnotation()
		 * @generated
		 */
		EClass STATE_IMPACT_ANNOTATION = eINSTANCE.getStateImpactAnnotation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_IMPACT_ANNOTATION__TYPE = eINSTANCE.getStateImpactAnnotation_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_IMPACT_ANNOTATION__SOURCE = eINSTANCE.getStateImpactAnnotation_Source();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpactAnnotationImpl <em>ASIL Impact Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.ASILImpactAnnotationImpl
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILImpactAnnotation()
		 * @generated
		 */
		EClass ASIL_IMPACT_ANNOTATION = eINSTANCE.getASILImpactAnnotation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASIL_IMPACT_ANNOTATION__TYPE = eINSTANCE.getASILImpactAnnotation_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASIL_IMPACT_ANNOTATION__SOURCE = eINSTANCE.getASILImpactAnnotation_Source();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ValidityValue <em>Validity Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getValidityValue()
		 * @generated
		 */
		EEnum VALIDITY_VALUE = eINSTANCE.getValidityValue();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType <em>Content Impact Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getContentImpactType()
		 * @generated
		 */
		EEnum CONTENT_IMPACT_TYPE = eINSTANCE.getContentImpactType();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.StateImpactType <em>State Impact Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.StateImpactType
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getStateImpactType()
		 * @generated
		 */
		EEnum STATE_IMPACT_TYPE = eINSTANCE.getStateImpactType();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILImpactType <em>ASIL Impact Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILImpactType
		 * @see edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCasePackageImpl#getASILImpactType()
		 * @generated
		 */
		EEnum ASIL_IMPACT_TYPE = eINSTANCE.getASILImpactType();

	}

} //SafetyCasePackage
