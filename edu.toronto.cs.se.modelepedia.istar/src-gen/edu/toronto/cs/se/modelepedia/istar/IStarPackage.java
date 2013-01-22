/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar;

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
 * @see edu.toronto.cs.se.modelepedia.istar.IStarFactory
 * @model kind="package"
 * @generated
 */
public interface IStarPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "istar";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/IStar";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "istar";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IStarPackage eINSTANCE = edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.IStarImpl <em>IStar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getIStar()
	 * @generated
	 */
	int ISTAR = 0;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__DEPENDENCIES = 1;

	/**
	 * The feature id for the '<em><b>Dependums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__DEPENDUMS = 2;

	/**
	 * The number of structural features of the '<em>IStar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>IStar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.DependencyEndpointImpl <em>Dependency Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.DependencyEndpointImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getDependencyEndpoint()
	 * @generated
	 */
	int DEPENDENCY_ENDPOINT = 9;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER = 0;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__NAME = 2;

	/**
	 * The number of structural features of the '<em>Dependency Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Dependency Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.ActorImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 1;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__DEPENDENCIES_AS_DEPENDER = DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__DEPENDENCIES_AS_DEPENDEE = DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = DEPENDENCY_ENDPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Intentional Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INTENTIONAL_ELEMENTS = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contributions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__CONTRIBUTIONS = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_OPERATION_COUNT = DEPENDENCY_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.DependencyImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 2;

	/**
	 * The feature id for the '<em><b>Depender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDER = 0;

	/**
	 * The feature id for the '<em><b>Dependee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDEE = 1;

	/**
	 * The feature id for the '<em><b>Dependum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDUM = 2;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl <em>Intentional Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getIntentionalElement()
	 * @generated
	 */
	int INTENTIONAL_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__DEPENDENCIES_AS_DEPENDER = DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__DEPENDENCIES_AS_DEPENDEE = DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__NAME = DEPENDENCY_ENDPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__DEPENDENCIES = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__COMPOSITE = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contributions As Contributor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__FULLY_SATISFIED = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__UNKNOWN = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__CONFLICT = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__PARTIALLY_DENIED = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__FULLY_DENIED = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Nothing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__NOTHING = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Intentional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT_FEATURE_COUNT = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Intentional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT_OPERATION_COUNT = DEPENDENCY_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.TaskImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 4;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEPENDENCIES_AS_DEPENDER = INTENTIONAL_ELEMENT__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEPENDENCIES_AS_DEPENDEE = INTENTIONAL_ELEMENT__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = INTENTIONAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEPENDENCIES = INTENTIONAL_ELEMENT__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__COMPOSITE = INTENTIONAL_ELEMENT__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Contributions As Contributor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__CONTRIBUTIONS_AS_CONTRIBUTOR = INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__FULLY_SATISFIED = INTENTIONAL_ELEMENT__FULLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PARTIALLY_SATISFIED = INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__UNKNOWN = INTENTIONAL_ELEMENT__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__CONFLICT = INTENTIONAL_ELEMENT__CONFLICT;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PARTIALLY_DENIED = INTENTIONAL_ELEMENT__PARTIALLY_DENIED;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__FULLY_DENIED = INTENTIONAL_ELEMENT__FULLY_DENIED;

	/**
	 * The feature id for the '<em><b>Nothing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NOTHING = INTENTIONAL_ELEMENT__NOTHING;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__END = INTENTIONAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__COMPONENTS = INTENTIONAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = INTENTIONAL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OPERATION_COUNT = INTENTIONAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.ResourceImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEPENDENCIES_AS_DEPENDER = INTENTIONAL_ELEMENT__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEPENDENCIES_AS_DEPENDEE = INTENTIONAL_ELEMENT__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = INTENTIONAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEPENDENCIES = INTENTIONAL_ELEMENT__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__COMPOSITE = INTENTIONAL_ELEMENT__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Contributions As Contributor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CONTRIBUTIONS_AS_CONTRIBUTOR = INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__FULLY_SATISFIED = INTENTIONAL_ELEMENT__FULLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PARTIALLY_SATISFIED = INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__UNKNOWN = INTENTIONAL_ELEMENT__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CONFLICT = INTENTIONAL_ELEMENT__CONFLICT;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PARTIALLY_DENIED = INTENTIONAL_ELEMENT__PARTIALLY_DENIED;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__FULLY_DENIED = INTENTIONAL_ELEMENT__FULLY_DENIED;

	/**
	 * The feature id for the '<em><b>Nothing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NOTHING = INTENTIONAL_ELEMENT__NOTHING;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = INTENTIONAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = INTENTIONAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.GoalImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 6;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DEPENDENCIES_AS_DEPENDER = INTENTIONAL_ELEMENT__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DEPENDENCIES_AS_DEPENDEE = INTENTIONAL_ELEMENT__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = INTENTIONAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DEPENDENCIES = INTENTIONAL_ELEMENT__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__COMPOSITE = INTENTIONAL_ELEMENT__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Contributions As Contributor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__CONTRIBUTIONS_AS_CONTRIBUTOR = INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__FULLY_SATISFIED = INTENTIONAL_ELEMENT__FULLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__PARTIALLY_SATISFIED = INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__UNKNOWN = INTENTIONAL_ELEMENT__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__CONFLICT = INTENTIONAL_ELEMENT__CONFLICT;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__PARTIALLY_DENIED = INTENTIONAL_ELEMENT__PARTIALLY_DENIED;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__FULLY_DENIED = INTENTIONAL_ELEMENT__FULLY_DENIED;

	/**
	 * The feature id for the '<em><b>Nothing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NOTHING = INTENTIONAL_ELEMENT__NOTHING;

	/**
	 * The feature id for the '<em><b>Means</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__MEANS = INTENTIONAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = INTENTIONAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = INTENTIONAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.SoftGoalImpl <em>Soft Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.SoftGoalImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getSoftGoal()
	 * @generated
	 */
	int SOFT_GOAL = 7;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__DEPENDENCIES_AS_DEPENDER = GOAL__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__DEPENDENCIES_AS_DEPENDEE = GOAL__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__NAME = GOAL__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__DEPENDENCIES = GOAL__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__COMPOSITE = GOAL__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Contributions As Contributor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTOR = GOAL__CONTRIBUTIONS_AS_CONTRIBUTOR;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__FULLY_SATISFIED = GOAL__FULLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__PARTIALLY_SATISFIED = GOAL__PARTIALLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__UNKNOWN = GOAL__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__CONFLICT = GOAL__CONFLICT;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__PARTIALLY_DENIED = GOAL__PARTIALLY_DENIED;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__FULLY_DENIED = GOAL__FULLY_DENIED;

	/**
	 * The feature id for the '<em><b>Nothing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__NOTHING = GOAL__NOTHING;

	/**
	 * The feature id for the '<em><b>Means</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__MEANS = GOAL__MEANS;

	/**
	 * The feature id for the '<em><b>Contributions As Contributee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE = GOAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Soft Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL_FEATURE_COUNT = GOAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Soft Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL_OPERATION_COUNT = GOAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.ContributionImpl
	 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Contributor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__CONTRIBUTOR = 1;

	/**
	 * The feature id for the '<em><b>Contributee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__CONTRIBUTEE = 2;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.IStar <em>IStar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IStar</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStar
	 * @generated
	 */
	EClass getIStar();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar.IStar#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStar#getActors()
	 * @see #getIStar()
	 * @generated
	 */
	EReference getIStar_Actors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar.IStar#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStar#getDependencies()
	 * @see #getIStar()
	 * @generated
	 */
	EReference getIStar_Dependencies();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar.IStar#getDependums <em>Dependums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependums</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStar#getDependums()
	 * @see #getIStar()
	 * @generated
	 */
	EReference getIStar_Dependums();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar.Actor#getIntentionalElements <em>Intentional Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intentional Elements</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Actor#getIntentionalElements()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_IntentionalElements();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar.Actor#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributions</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Actor#getContributions()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Contributions();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDepender <em>Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Dependency#getDepender()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Depender();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDependee <em>Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Dependency#getDependee()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Dependee();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDependum <em>Dependum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependum</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Dependency#getDependum()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Dependum();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement <em>Intentional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intentional Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement
	 * @generated
	 */
	EClass getIntentionalElement();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getDependencies()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_Dependencies();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getComposite()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_Composite();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getContributionsAsContributor <em>Contributions As Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contributions As Contributor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getContributionsAsContributor()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_ContributionsAsContributor();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isFullySatisfied <em>Fully Satisfied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fully Satisfied</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isFullySatisfied()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EAttribute getIntentionalElement_FullySatisfied();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isPartiallySatisfied <em>Partially Satisfied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partially Satisfied</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isPartiallySatisfied()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EAttribute getIntentionalElement_PartiallySatisfied();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unknown</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isUnknown()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EAttribute getIntentionalElement_Unknown();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isConflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conflict</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isConflict()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EAttribute getIntentionalElement_Conflict();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isPartiallyDenied <em>Partially Denied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partially Denied</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isPartiallyDenied()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EAttribute getIntentionalElement_PartiallyDenied();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isFullyDenied <em>Fully Denied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fully Denied</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isFullyDenied()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EAttribute getIntentionalElement_FullyDenied();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isNothing <em>Nothing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nothing</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#isNothing()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EAttribute getIntentionalElement_Nothing();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar.Task#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Task#getEnd()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_End();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar.Task#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Task#getComponents()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Components();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar.Goal#getMeans <em>Means</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Means</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Goal#getMeans()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_Means();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.SoftGoal <em>Soft Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Soft Goal</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.SoftGoal
	 * @generated
	 */
	EClass getSoftGoal();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar.SoftGoal#getContributionsAsContributee <em>Contributions As Contributee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contributions As Contributee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.SoftGoal#getContributionsAsContributee()
	 * @see #getSoftGoal()
	 * @generated
	 */
	EReference getSoftGoal_ContributionsAsContributee();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contribution</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Contribution
	 * @generated
	 */
	EClass getContribution();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Contribution#getType()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_Type();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getContributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contributor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Contribution#getContributor()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Contributor();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getContributee <em>Contributee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contributee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.Contribution#getContributee()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Contributee();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint <em>Dependency Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Endpoint</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint
	 * @generated
	 */
	EClass getDependencyEndpoint();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDepender <em>Dependencies As Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies As Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDepender()
	 * @see #getDependencyEndpoint()
	 * @generated
	 */
	EReference getDependencyEndpoint_DependenciesAsDepender();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDependee <em>Dependencies As Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies As Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDependee()
	 * @see #getDependencyEndpoint()
	 * @generated
	 */
	EReference getDependencyEndpoint_DependenciesAsDependee();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getName()
	 * @see #getDependencyEndpoint()
	 * @generated
	 */
	EAttribute getDependencyEndpoint_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IStarFactory getIStarFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.IStarImpl <em>IStar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getIStar()
		 * @generated
		 */
		EClass ISTAR = eINSTANCE.getIStar();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISTAR__ACTORS = eINSTANCE.getIStar_Actors();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISTAR__DEPENDENCIES = eINSTANCE.getIStar_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Dependums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISTAR__DEPENDUMS = eINSTANCE.getIStar_Dependums();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.ActorImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Intentional Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INTENTIONAL_ELEMENTS = eINSTANCE.getActor_IntentionalElements();

		/**
		 * The meta object literal for the '<em><b>Contributions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__CONTRIBUTIONS = eINSTANCE.getActor_Contributions();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.DependencyImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Depender</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDER = eINSTANCE.getDependency_Depender();

		/**
		 * The meta object literal for the '<em><b>Dependee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDEE = eINSTANCE.getDependency_Dependee();

		/**
		 * The meta object literal for the '<em><b>Dependum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDUM = eINSTANCE.getDependency_Dependum();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl <em>Intentional Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IntentionalElementImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getIntentionalElement()
		 * @generated
		 */
		EClass INTENTIONAL_ELEMENT = eINSTANCE.getIntentionalElement();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTIONAL_ELEMENT__DEPENDENCIES = eINSTANCE.getIntentionalElement_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTIONAL_ELEMENT__COMPOSITE = eINSTANCE.getIntentionalElement_Composite();

		/**
		 * The meta object literal for the '<em><b>Contributions As Contributor</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR = eINSTANCE.getIntentionalElement_ContributionsAsContributor();

		/**
		 * The meta object literal for the '<em><b>Fully Satisfied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTIONAL_ELEMENT__FULLY_SATISFIED = eINSTANCE.getIntentionalElement_FullySatisfied();

		/**
		 * The meta object literal for the '<em><b>Partially Satisfied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED = eINSTANCE.getIntentionalElement_PartiallySatisfied();

		/**
		 * The meta object literal for the '<em><b>Unknown</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTIONAL_ELEMENT__UNKNOWN = eINSTANCE.getIntentionalElement_Unknown();

		/**
		 * The meta object literal for the '<em><b>Conflict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTIONAL_ELEMENT__CONFLICT = eINSTANCE.getIntentionalElement_Conflict();

		/**
		 * The meta object literal for the '<em><b>Partially Denied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTIONAL_ELEMENT__PARTIALLY_DENIED = eINSTANCE.getIntentionalElement_PartiallyDenied();

		/**
		 * The meta object literal for the '<em><b>Fully Denied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTIONAL_ELEMENT__FULLY_DENIED = eINSTANCE.getIntentionalElement_FullyDenied();

		/**
		 * The meta object literal for the '<em><b>Nothing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTIONAL_ELEMENT__NOTHING = eINSTANCE.getIntentionalElement_Nothing();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.TaskImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__END = eINSTANCE.getTask_End();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__COMPONENTS = eINSTANCE.getTask_Components();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.ResourceImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.GoalImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '<em><b>Means</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__MEANS = eINSTANCE.getGoal_Means();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.SoftGoalImpl <em>Soft Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.SoftGoalImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getSoftGoal()
		 * @generated
		 */
		EClass SOFT_GOAL = eINSTANCE.getSoftGoal();

		/**
		 * The meta object literal for the '<em><b>Contributions As Contributee</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE = eINSTANCE.getSoftGoal_ContributionsAsContributee();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.ContributionImpl <em>Contribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.ContributionImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getContribution()
		 * @generated
		 */
		EClass CONTRIBUTION = eINSTANCE.getContribution();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTION__TYPE = eINSTANCE.getContribution_Type();

		/**
		 * The meta object literal for the '<em><b>Contributor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__CONTRIBUTOR = eINSTANCE.getContribution_Contributor();

		/**
		 * The meta object literal for the '<em><b>Contributee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__CONTRIBUTEE = eINSTANCE.getContribution_Contributee();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar.impl.DependencyEndpointImpl <em>Dependency Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.DependencyEndpointImpl
		 * @see edu.toronto.cs.se.modelepedia.istar.impl.IStarPackageImpl#getDependencyEndpoint()
		 * @generated
		 */
		EClass DEPENDENCY_ENDPOINT = eINSTANCE.getDependencyEndpoint();

		/**
		 * The meta object literal for the '<em><b>Dependencies As Depender</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER = eINSTANCE.getDependencyEndpoint_DependenciesAsDepender();

		/**
		 * The meta object literal for the '<em><b>Dependencies As Dependee</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE = eINSTANCE.getDependencyEndpoint_DependenciesAsDependee();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_ENDPOINT__NAME = eINSTANCE.getDependencyEndpoint_Name();

	}

} //IStarPackage
