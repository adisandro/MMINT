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
package edu.toronto.cs.se.modelepedia.istar_mavo;

import edu.toronto.cs.se.mmtf.mavo.MavoPackage;

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
 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOFactory
 * @model kind="package"
 * @generated
 */
public interface IStar_MAVOPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "istar_mavo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/IStar_MAVO";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "istar_mavo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IStar_MAVOPackage eINSTANCE = edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStarImpl <em>IStar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStarImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getIStar()
	 * @generated
	 */
	int ISTAR = 0;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__INC = MavoPackage.MAVO_MODEL__INC;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__ACTORS = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__DEPENDENCIES = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IStar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR_FEATURE_COUNT = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>IStar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR_OPERATION_COUNT = MavoPackage.MAVO_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyEndpointImpl <em>Dependency Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyEndpointImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependencyEndpoint()
	 * @generated
	 */
	int DEPENDENCY_ENDPOINT = 11;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__MAY = MavoPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__SET = MavoPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__VAR = MavoPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__NAME = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dependency Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT_FEATURE_COUNT = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Dependency Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT_OPERATION_COUNT = MavoPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ActorImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 1;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__MAY = DEPENDENCY_ENDPOINT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__SET = DEPENDENCY_ENDPOINT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__VAR = DEPENDENCY_ENDPOINT__VAR;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 2;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__MAY = MavoPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SET = MavoPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__VAR = MavoPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Depender</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDER = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependee</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDEE = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDUM = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = MavoPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl <em>Intentional Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getIntentionalElement()
	 * @generated
	 */
	int INTENTIONAL_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__MAY = DEPENDENCY_ENDPOINT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__SET = DEPENDENCY_ENDPOINT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__VAR = DEPENDENCY_ENDPOINT__VAR;

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
	 * The feature id for the '<em><b>Dependency</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT__DEPENDENCY = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference list.
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
	 * The number of structural features of the '<em>Intentional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT_FEATURE_COUNT = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Intentional Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTIONAL_ELEMENT_OPERATION_COUNT = DEPENDENCY_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.TaskImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 4;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__MAY = INTENTIONAL_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__SET = INTENTIONAL_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__VAR = INTENTIONAL_ELEMENT__VAR;

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
	 * The feature id for the '<em><b>Dependency</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEPENDENCY = INTENTIONAL_ELEMENT__DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference list.
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
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__COMPONENTS = INTENTIONAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__END = INTENTIONAL_ELEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ResourceImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__MAY = INTENTIONAL_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__SET = INTENTIONAL_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__VAR = INTENTIONAL_ELEMENT__VAR;

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
	 * The feature id for the '<em><b>Dependency</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEPENDENCY = INTENTIONAL_ELEMENT__DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference list.
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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.GoalImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 6;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__MAY = INTENTIONAL_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SET = INTENTIONAL_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__VAR = INTENTIONAL_ELEMENT__VAR;

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
	 * The feature id for the '<em><b>Dependency</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DEPENDENCY = INTENTIONAL_ELEMENT__DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference list.
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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.SoftGoalImpl <em>Soft Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.SoftGoalImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getSoftGoal()
	 * @generated
	 */
	int SOFT_GOAL = 7;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__MAY = GOAL__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__SET = GOAL__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__VAR = GOAL__VAR;

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
	 * The feature id for the '<em><b>Dependency</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__DEPENDENCY = GOAL__DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' reference list.
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
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ContributionImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 8;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__MAY = MavoPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__SET = MavoPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__VAR = MavoPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__TYPE = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contributor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__CONTRIBUTOR = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contributee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__CONTRIBUTEE = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_OPERATION_COUNT = MavoPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.EndReferenceImpl <em>End Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.EndReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getEndReference()
	 * @generated
	 */
	int END_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REFERENCE__MAY = MavoPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REFERENCE__SET = MavoPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REFERENCE__VAR = MavoPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REFERENCE__SRC = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REFERENCE__TGT = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>End Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REFERENCE_FEATURE_COUNT = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>End Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_REFERENCE_OPERATION_COUNT = MavoPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ComponentsReferenceImpl <em>Components Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ComponentsReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getComponentsReference()
	 * @generated
	 */
	int COMPONENTS_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_REFERENCE__MAY = MavoPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_REFERENCE__SET = MavoPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_REFERENCE__VAR = MavoPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_REFERENCE__SRC = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_REFERENCE__TGT = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Components Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_REFERENCE_FEATURE_COUNT = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Components Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENTS_REFERENCE_OPERATION_COUNT = MavoPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerReferenceImpl <em>Depender Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependerReference()
	 * @generated
	 */
	int DEPENDER_REFERENCE = 12;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_REFERENCE__MAY = MavoPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_REFERENCE__SET = MavoPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_REFERENCE__VAR = MavoPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_REFERENCE__TGT = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_REFERENCE__SRC = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Depender Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_REFERENCE_FEATURE_COUNT = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Depender Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_REFERENCE_OPERATION_COUNT = MavoPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeReferenceImpl <em>Dependee Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependeeReference()
	 * @generated
	 */
	int DEPENDEE_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_REFERENCE__MAY = MavoPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_REFERENCE__SET = MavoPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_REFERENCE__VAR = MavoPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_REFERENCE__TGT = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_REFERENCE__SRC = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dependee Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_REFERENCE_FEATURE_COUNT = MavoPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dependee Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_REFERENCE_OPERATION_COUNT = MavoPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IStar <em>IStar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IStar</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar
	 * @generated
	 */
	EClass getIStar();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IStar#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar#getActors()
	 * @see #getIStar()
	 * @generated
	 */
	EReference getIStar_Actors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IStar#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar#getDependencies()
	 * @see #getIStar()
	 * @generated
	 */
	EReference getIStar_Dependencies();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Actor#getIntentionalElements <em>Intentional Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intentional Elements</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Actor#getIntentionalElements()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_IntentionalElements();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Actor#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributions</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Actor#getContributions()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Contributions();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDepender <em>Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDepender()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Depender();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDependee <em>Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDependee()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Dependee();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDependum <em>Dependum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependum</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDependum()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Dependum();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement <em>Intentional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intentional Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement
	 * @generated
	 */
	EClass getIntentionalElement();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dependency</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement#getDependency()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_Dependency();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Composite</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement#getComposite()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_Composite();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement#getContributionsAsContributor <em>Contributions As Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contributions As Contributor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement#getContributionsAsContributor()
	 * @see #getIntentionalElement()
	 * @generated
	 */
	EReference getIntentionalElement_ContributionsAsContributor();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Task#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Task#getComponents()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Task#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>End</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Task#getEnd()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_End();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Goal#getMeans <em>Means</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Means</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Goal#getMeans()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_Means();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal <em>Soft Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Soft Goal</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal
	 * @generated
	 */
	EClass getSoftGoal();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal#getContributionsAsContributee <em>Contributions As Contributee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contributions As Contributee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal#getContributionsAsContributee()
	 * @see #getSoftGoal()
	 * @generated
	 */
	EReference getSoftGoal_ContributionsAsContributee();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contribution</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Contribution
	 * @generated
	 */
	EClass getContribution();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Contribution#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Contribution#getType()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_Type();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Contribution#getContributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contributor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Contribution#getContributor()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Contributor();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Contribution#getContributee <em>Contributee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contributee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Contribution#getContributee()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Contributee();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.EndReference <em>End Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.EndReference
	 * @generated
	 */
	EClass getEndReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.EndReference#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Src</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.EndReference#getSrc()
	 * @see #getEndReference()
	 * @generated
	 */
	EReference getEndReference_Src();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.EndReference#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.EndReference#getTgt()
	 * @see #getEndReference()
	 * @generated
	 */
	EReference getEndReference_Tgt();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.ComponentsReference <em>Components Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Components Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.ComponentsReference
	 * @generated
	 */
	EClass getComponentsReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.ComponentsReference#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Src</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.ComponentsReference#getSrc()
	 * @see #getComponentsReference()
	 * @generated
	 */
	EReference getComponentsReference_Src();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.ComponentsReference#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.ComponentsReference#getTgt()
	 * @see #getComponentsReference()
	 * @generated
	 */
	EReference getComponentsReference_Tgt();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint <em>Dependency Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Endpoint</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint
	 * @generated
	 */
	EClass getDependencyEndpoint();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getDependenciesAsDepender <em>Dependencies As Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies As Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getDependenciesAsDepender()
	 * @see #getDependencyEndpoint()
	 * @generated
	 */
	EReference getDependencyEndpoint_DependenciesAsDepender();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getDependenciesAsDependee <em>Dependencies As Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies As Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getDependenciesAsDependee()
	 * @see #getDependencyEndpoint()
	 * @generated
	 */
	EReference getDependencyEndpoint_DependenciesAsDependee();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getName()
	 * @see #getDependencyEndpoint()
	 * @generated
	 */
	EAttribute getDependencyEndpoint_Name();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference <em>Depender Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depender Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference
	 * @generated
	 */
	EClass getDependerReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference#getTgt()
	 * @see #getDependerReference()
	 * @generated
	 */
	EReference getDependerReference_Tgt();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Src</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference#getSrc()
	 * @see #getDependerReference()
	 * @generated
	 */
	EReference getDependerReference_Src();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference <em>Dependee Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependee Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference
	 * @generated
	 */
	EClass getDependeeReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference#getTgt()
	 * @see #getDependeeReference()
	 * @generated
	 */
	EReference getDependeeReference_Tgt();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Src</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference#getSrc()
	 * @see #getDependeeReference()
	 * @generated
	 */
	EReference getDependeeReference_Src();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IStar_MAVOFactory getIStar_MAVOFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStarImpl <em>IStar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStarImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getIStar()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ActorImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getActor()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Depender</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDER = eINSTANCE.getDependency_Depender();

		/**
		 * The meta object literal for the '<em><b>Dependee</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDEE = eINSTANCE.getDependency_Dependee();

		/**
		 * The meta object literal for the '<em><b>Dependum</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDUM = eINSTANCE.getDependency_Dependum();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl <em>Intentional Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionalElementImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getIntentionalElement()
		 * @generated
		 */
		EClass INTENTIONAL_ELEMENT = eINSTANCE.getIntentionalElement();

		/**
		 * The meta object literal for the '<em><b>Dependency</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTIONAL_ELEMENT__DEPENDENCY = eINSTANCE.getIntentionalElement_Dependency();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' reference list feature.
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.TaskImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__COMPONENTS = eINSTANCE.getTask_Components();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__END = eINSTANCE.getTask_End();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ResourceImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.GoalImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getGoal()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.SoftGoalImpl <em>Soft Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.SoftGoalImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getSoftGoal()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ContributionImpl <em>Contribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ContributionImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getContribution()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.EndReferenceImpl <em>End Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.EndReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getEndReference()
		 * @generated
		 */
		EClass END_REFERENCE = eINSTANCE.getEndReference();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_REFERENCE__SRC = eINSTANCE.getEndReference_Src();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_REFERENCE__TGT = eINSTANCE.getEndReference_Tgt();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ComponentsReferenceImpl <em>Components Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ComponentsReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getComponentsReference()
		 * @generated
		 */
		EClass COMPONENTS_REFERENCE = eINSTANCE.getComponentsReference();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENTS_REFERENCE__SRC = eINSTANCE.getComponentsReference_Src();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENTS_REFERENCE__TGT = eINSTANCE.getComponentsReference_Tgt();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyEndpointImpl <em>Dependency Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyEndpointImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependencyEndpoint()
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

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerReferenceImpl <em>Depender Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependerReference()
		 * @generated
		 */
		EClass DEPENDER_REFERENCE = eINSTANCE.getDependerReference();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDER_REFERENCE__TGT = eINSTANCE.getDependerReference_Tgt();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDER_REFERENCE__SRC = eINSTANCE.getDependerReference_Src();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeReferenceImpl <em>Dependee Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependeeReference()
		 * @generated
		 */
		EClass DEPENDEE_REFERENCE = eINSTANCE.getDependeeReference();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDEE_REFERENCE__TGT = eINSTANCE.getDependeeReference_Tgt();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDEE_REFERENCE__SRC = eINSTANCE.getDependeeReference_Src();

	}

} //IStar_MAVOPackage
