/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo;

import edu.toronto.cs.se.mavo.MAVOPackage;
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
 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
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
	int ISTAR__INC = MAVOPackage.MAVO_MODEL__INC;

	/**
	 * The feature id for the '<em><b>Decisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__DECISIONS = MAVOPackage.MAVO_MODEL__DECISIONS;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__ACTORS = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR__DEPENDUMS = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IStar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR_FEATURE_COUNT = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>IStar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISTAR_OPERATION_COUNT = MAVOPackage.MAVO_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyEndpointImpl <em>Dependency Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependencyEndpointImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependencyEndpoint()
	 * @generated
	 */
	int DEPENDENCY_ENDPOINT = 7;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__FORMULA_VARIABLE = MAVOPackage.MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__MAY = MAVOPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__SET = MAVOPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__VAR = MAVOPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__NAME = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dependency Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT_FEATURE_COUNT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Dependency Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ENDPOINT_OPERATION_COUNT = MAVOPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__FORMULA_VARIABLE = DEPENDENCY_ENDPOINT__FORMULA_VARIABLE;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = DEPENDENCY_ENDPOINT__NAME;

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
	 * The feature id for the '<em><b>Intentions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INTENTIONS = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_OPERATION_COUNT = DEPENDENCY_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionImpl <em>Intention</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getIntention()
	 * @generated
	 */
	int INTENTION = 2;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__FORMULA_VARIABLE = DEPENDENCY_ENDPOINT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__MAY = DEPENDENCY_ENDPOINT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__SET = DEPENDENCY_ENDPOINT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__VAR = DEPENDENCY_ENDPOINT__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__NAME = DEPENDENCY_ENDPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__DEPENDENCIES_AS_DEPENDER = DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__DEPENDENCIES_AS_DEPENDEE = DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__FULLY_SATISFIED = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__PARTIALLY_SATISFIED = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__UNKNOWN = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__CONFLICT = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__PARTIALLY_DENIED = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__FULLY_DENIED = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>No Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__NO_LABEL = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Links As Src</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__LINKS_AS_SRC = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Links As Tgt</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__LINKS_AS_TGT = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Depender Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__DEPENDER_LINKS = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Dependee Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION__DEPENDEE_LINKS = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Intention</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_FEATURE_COUNT = DEPENDENCY_ENDPOINT_FEATURE_COUNT + 11;

	/**
	 * The number of operations of the '<em>Intention</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_OPERATION_COUNT = DEPENDENCY_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.TaskImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 3;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__FORMULA_VARIABLE = INTENTION__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__MAY = INTENTION__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__SET = INTENTION__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__VAR = INTENTION__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = INTENTION__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEPENDENCIES_AS_DEPENDER = INTENTION__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEPENDENCIES_AS_DEPENDEE = INTENTION__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__FULLY_SATISFIED = INTENTION__FULLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PARTIALLY_SATISFIED = INTENTION__PARTIALLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__UNKNOWN = INTENTION__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__CONFLICT = INTENTION__CONFLICT;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PARTIALLY_DENIED = INTENTION__PARTIALLY_DENIED;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__FULLY_DENIED = INTENTION__FULLY_DENIED;

	/**
	 * The feature id for the '<em><b>No Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NO_LABEL = INTENTION__NO_LABEL;

	/**
	 * The feature id for the '<em><b>Links As Src</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__LINKS_AS_SRC = INTENTION__LINKS_AS_SRC;

	/**
	 * The feature id for the '<em><b>Links As Tgt</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__LINKS_AS_TGT = INTENTION__LINKS_AS_TGT;

	/**
	 * The feature id for the '<em><b>Depender Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEPENDER_LINKS = INTENTION__DEPENDER_LINKS;

	/**
	 * The feature id for the '<em><b>Dependee Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEPENDEE_LINKS = INTENTION__DEPENDEE_LINKS;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = INTENTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OPERATION_COUNT = INTENTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ResourceImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__FORMULA_VARIABLE = INTENTION__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__MAY = INTENTION__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__SET = INTENTION__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__VAR = INTENTION__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = INTENTION__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEPENDENCIES_AS_DEPENDER = INTENTION__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEPENDENCIES_AS_DEPENDEE = INTENTION__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__FULLY_SATISFIED = INTENTION__FULLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PARTIALLY_SATISFIED = INTENTION__PARTIALLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__UNKNOWN = INTENTION__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CONFLICT = INTENTION__CONFLICT;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PARTIALLY_DENIED = INTENTION__PARTIALLY_DENIED;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__FULLY_DENIED = INTENTION__FULLY_DENIED;

	/**
	 * The feature id for the '<em><b>No Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NO_LABEL = INTENTION__NO_LABEL;

	/**
	 * The feature id for the '<em><b>Links As Src</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__LINKS_AS_SRC = INTENTION__LINKS_AS_SRC;

	/**
	 * The feature id for the '<em><b>Links As Tgt</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__LINKS_AS_TGT = INTENTION__LINKS_AS_TGT;

	/**
	 * The feature id for the '<em><b>Depender Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEPENDER_LINKS = INTENTION__DEPENDER_LINKS;

	/**
	 * The feature id for the '<em><b>Dependee Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEPENDEE_LINKS = INTENTION__DEPENDEE_LINKS;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = INTENTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = INTENTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.GoalImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 5;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__FORMULA_VARIABLE = INTENTION__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__MAY = INTENTION__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SET = INTENTION__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__VAR = INTENTION__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = INTENTION__NAME;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DEPENDENCIES_AS_DEPENDER = INTENTION__DEPENDENCIES_AS_DEPENDER;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DEPENDENCIES_AS_DEPENDEE = INTENTION__DEPENDENCIES_AS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__FULLY_SATISFIED = INTENTION__FULLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__PARTIALLY_SATISFIED = INTENTION__PARTIALLY_SATISFIED;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__UNKNOWN = INTENTION__UNKNOWN;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__CONFLICT = INTENTION__CONFLICT;

	/**
	 * The feature id for the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__PARTIALLY_DENIED = INTENTION__PARTIALLY_DENIED;

	/**
	 * The feature id for the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__FULLY_DENIED = INTENTION__FULLY_DENIED;

	/**
	 * The feature id for the '<em><b>No Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NO_LABEL = INTENTION__NO_LABEL;

	/**
	 * The feature id for the '<em><b>Links As Src</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__LINKS_AS_SRC = INTENTION__LINKS_AS_SRC;

	/**
	 * The feature id for the '<em><b>Links As Tgt</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__LINKS_AS_TGT = INTENTION__LINKS_AS_TGT;

	/**
	 * The feature id for the '<em><b>Depender Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DEPENDER_LINKS = INTENTION__DEPENDER_LINKS;

	/**
	 * The feature id for the '<em><b>Dependee Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DEPENDEE_LINKS = INTENTION__DEPENDEE_LINKS;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = INTENTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = INTENTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.SoftGoalImpl <em>Soft Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.SoftGoalImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getSoftGoal()
	 * @generated
	 */
	int SOFT_GOAL = 6;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__FORMULA_VARIABLE = GOAL__FORMULA_VARIABLE;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__NAME = GOAL__NAME;

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
	 * The feature id for the '<em><b>No Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__NO_LABEL = GOAL__NO_LABEL;

	/**
	 * The feature id for the '<em><b>Links As Src</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__LINKS_AS_SRC = GOAL__LINKS_AS_SRC;

	/**
	 * The feature id for the '<em><b>Links As Tgt</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__LINKS_AS_TGT = GOAL__LINKS_AS_TGT;

	/**
	 * The feature id for the '<em><b>Depender Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__DEPENDER_LINKS = GOAL__DEPENDER_LINKS;

	/**
	 * The feature id for the '<em><b>Dependee Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL__DEPENDEE_LINKS = GOAL__DEPENDEE_LINKS;

	/**
	 * The number of structural features of the '<em>Soft Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL_FEATURE_COUNT = GOAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Soft Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFT_GOAL_OPERATION_COUNT = GOAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionLinkImpl <em>Intention Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionLinkImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getIntentionLink()
	 * @generated
	 */
	int INTENTION_LINK = 8;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK__FORMULA_VARIABLE = MAVOPackage.MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK__MAY = MAVOPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK__SET = MAVOPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK__VAR = MAVOPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK__NAME = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK__SRC = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK__TGT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Intention Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK_FEATURE_COUNT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Intention Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENTION_LINK_OPERATION_COUNT = MAVOPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.MeansEndImpl <em>Means End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.MeansEndImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getMeansEnd()
	 * @generated
	 */
	int MEANS_END = 9;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END__FORMULA_VARIABLE = INTENTION_LINK__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END__MAY = INTENTION_LINK__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END__SET = INTENTION_LINK__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END__VAR = INTENTION_LINK__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END__NAME = INTENTION_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END__SRC = INTENTION_LINK__SRC;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END__TGT = INTENTION_LINK__TGT;

	/**
	 * The number of structural features of the '<em>Means End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END_FEATURE_COUNT = INTENTION_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Means End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_END_OPERATION_COUNT = INTENTION_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DecompositionImpl <em>Decomposition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DecompositionImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDecomposition()
	 * @generated
	 */
	int DECOMPOSITION = 10;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__FORMULA_VARIABLE = INTENTION_LINK__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__MAY = INTENTION_LINK__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__SET = INTENTION_LINK__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__VAR = INTENTION_LINK__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__NAME = INTENTION_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__SRC = INTENTION_LINK__SRC;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__TGT = INTENTION_LINK__TGT;

	/**
	 * The number of structural features of the '<em>Decomposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION_FEATURE_COUNT = INTENTION_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Decomposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION_OPERATION_COUNT = INTENTION_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.ContributionImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 11;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__FORMULA_VARIABLE = INTENTION_LINK__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__MAY = INTENTION_LINK__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__SET = INTENTION_LINK__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__VAR = INTENTION_LINK__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__NAME = INTENTION_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__SRC = INTENTION_LINK__SRC;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__TGT = INTENTION_LINK__TGT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__TYPE = INTENTION_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = INTENTION_LINK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_OPERATION_COUNT = INTENTION_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerLinkImpl <em>Depender Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerLinkImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependerLink()
	 * @generated
	 */
	int DEPENDER_LINK = 12;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK__FORMULA_VARIABLE = MAVOPackage.MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK__MAY = MAVOPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK__SET = MAVOPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK__VAR = MAVOPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK__NAME = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Depender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK__DEPENDER = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependum</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK__DEPENDUM = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Depender Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK_FEATURE_COUNT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Depender Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDER_LINK_OPERATION_COUNT = MAVOPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeLinkImpl <em>Dependee Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeLinkImpl
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependeeLink()
	 * @generated
	 */
	int DEPENDEE_LINK = 13;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK__FORMULA_VARIABLE = MAVOPackage.MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK__MAY = MAVOPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK__SET = MAVOPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK__VAR = MAVOPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK__NAME = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependum</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK__DEPENDUM = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK__DEPENDEE = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dependee Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK_FEATURE_COUNT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Dependee Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDEE_LINK_OPERATION_COUNT = MAVOPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType <em>Contribution Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getContributionType()
	 * @generated
	 */
	int CONTRIBUTION_TYPE = 14;


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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IStar#getDependums <em>Dependums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependums</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar#getDependums()
	 * @see #getIStar()
	 * @generated
	 */
	EReference getIStar_Dependums();

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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Actor#getIntentions <em>Intentions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intentions</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Actor#getIntentions()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Intentions();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention <em>Intention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intention</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention
	 * @generated
	 */
	EClass getIntention();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isFullySatisfied <em>Fully Satisfied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fully Satisfied</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isFullySatisfied()
	 * @see #getIntention()
	 * @generated
	 */
	EAttribute getIntention_FullySatisfied();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isPartiallySatisfied <em>Partially Satisfied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partially Satisfied</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isPartiallySatisfied()
	 * @see #getIntention()
	 * @generated
	 */
	EAttribute getIntention_PartiallySatisfied();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unknown</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isUnknown()
	 * @see #getIntention()
	 * @generated
	 */
	EAttribute getIntention_Unknown();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isConflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conflict</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isConflict()
	 * @see #getIntention()
	 * @generated
	 */
	EAttribute getIntention_Conflict();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isPartiallyDenied <em>Partially Denied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partially Denied</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isPartiallyDenied()
	 * @see #getIntention()
	 * @generated
	 */
	EAttribute getIntention_PartiallyDenied();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isFullyDenied <em>Fully Denied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fully Denied</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isFullyDenied()
	 * @see #getIntention()
	 * @generated
	 */
	EAttribute getIntention_FullyDenied();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isNoLabel <em>No Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Label</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isNoLabel()
	 * @see #getIntention()
	 * @generated
	 */
	EAttribute getIntention_NoLabel();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getLinksAsSrc <em>Links As Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links As Src</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getLinksAsSrc()
	 * @see #getIntention()
	 * @generated
	 */
	EReference getIntention_LinksAsSrc();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getLinksAsTgt <em>Links As Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links As Tgt</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getLinksAsTgt()
	 * @see #getIntention()
	 * @generated
	 */
	EReference getIntention_LinksAsTgt();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getDependerLinks <em>Depender Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Depender Links</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getDependerLinks()
	 * @see #getIntention()
	 * @generated
	 */
	EReference getIntention_DependerLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getDependeeLinks <em>Dependee Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependee Links</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getDependeeLinks()
	 * @see #getIntention()
	 * @generated
	 */
	EReference getIntention_DependeeLinks();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal <em>Soft Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Soft Goal</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal
	 * @generated
	 */
	EClass getSoftGoal();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink <em>Intention Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intention Link</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink
	 * @generated
	 */
	EClass getIntentionLink();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getName()
	 * @see #getIntentionLink()
	 * @generated
	 */
	EAttribute getIntentionLink_Name();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Src</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getSrc()
	 * @see #getIntentionLink()
	 * @generated
	 */
	EReference getIntentionLink_Src();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getTgt()
	 * @see #getIntentionLink()
	 * @generated
	 */
	EReference getIntentionLink_Tgt();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd <em>Means End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Means End</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd
	 * @generated
	 */
	EClass getMeansEnd();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition <em>Decomposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decomposition</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition
	 * @generated
	 */
	EClass getDecomposition();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink <em>Depender Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depender Link</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink
	 * @generated
	 */
	EClass getDependerLink();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink#getName()
	 * @see #getDependerLink()
	 * @generated
	 */
	EAttribute getDependerLink_Name();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink#getDepender <em>Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink#getDepender()
	 * @see #getDependerLink()
	 * @generated
	 */
	EReference getDependerLink_Depender();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink#getDependum <em>Dependum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dependum</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink#getDependum()
	 * @see #getDependerLink()
	 * @generated
	 */
	EReference getDependerLink_Dependum();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink <em>Dependee Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependee Link</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink
	 * @generated
	 */
	EClass getDependeeLink();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink#getName()
	 * @see #getDependeeLink()
	 * @generated
	 */
	EAttribute getDependeeLink_Name();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink#getDependum <em>Dependum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dependum</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink#getDependum()
	 * @see #getDependeeLink()
	 * @generated
	 */
	EReference getDependeeLink_Dependum();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink#getDependee <em>Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink#getDependee()
	 * @see #getDependeeLink()
	 * @generated
	 */
	EReference getDependeeLink_Dependee();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType <em>Contribution Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Contribution Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType
	 * @generated
	 */
	EEnum getContributionType();

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
		 * The meta object literal for the '<em><b>Dependums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISTAR__DEPENDUMS = eINSTANCE.getIStar_Dependums();

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
		 * The meta object literal for the '<em><b>Intentions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INTENTIONS = eINSTANCE.getActor_Intentions();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionImpl <em>Intention</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getIntention()
		 * @generated
		 */
		EClass INTENTION = eINSTANCE.getIntention();

		/**
		 * The meta object literal for the '<em><b>Fully Satisfied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTION__FULLY_SATISFIED = eINSTANCE.getIntention_FullySatisfied();

		/**
		 * The meta object literal for the '<em><b>Partially Satisfied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTION__PARTIALLY_SATISFIED = eINSTANCE.getIntention_PartiallySatisfied();

		/**
		 * The meta object literal for the '<em><b>Unknown</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTION__UNKNOWN = eINSTANCE.getIntention_Unknown();

		/**
		 * The meta object literal for the '<em><b>Conflict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTION__CONFLICT = eINSTANCE.getIntention_Conflict();

		/**
		 * The meta object literal for the '<em><b>Partially Denied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTION__PARTIALLY_DENIED = eINSTANCE.getIntention_PartiallyDenied();

		/**
		 * The meta object literal for the '<em><b>Fully Denied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTION__FULLY_DENIED = eINSTANCE.getIntention_FullyDenied();

		/**
		 * The meta object literal for the '<em><b>No Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTION__NO_LABEL = eINSTANCE.getIntention_NoLabel();

		/**
		 * The meta object literal for the '<em><b>Links As Src</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTION__LINKS_AS_SRC = eINSTANCE.getIntention_LinksAsSrc();

		/**
		 * The meta object literal for the '<em><b>Links As Tgt</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTION__LINKS_AS_TGT = eINSTANCE.getIntention_LinksAsTgt();

		/**
		 * The meta object literal for the '<em><b>Depender Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTION__DEPENDER_LINKS = eINSTANCE.getIntention_DependerLinks();

		/**
		 * The meta object literal for the '<em><b>Dependee Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTION__DEPENDEE_LINKS = eINSTANCE.getIntention_DependeeLinks();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.SoftGoalImpl <em>Soft Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.SoftGoalImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getSoftGoal()
		 * @generated
		 */
		EClass SOFT_GOAL = eINSTANCE.getSoftGoal();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionLinkImpl <em>Intention Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IntentionLinkImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getIntentionLink()
		 * @generated
		 */
		EClass INTENTION_LINK = eINSTANCE.getIntentionLink();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENTION_LINK__NAME = eINSTANCE.getIntentionLink_Name();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTION_LINK__SRC = eINSTANCE.getIntentionLink_Src();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENTION_LINK__TGT = eINSTANCE.getIntentionLink_Tgt();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.MeansEndImpl <em>Means End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.MeansEndImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getMeansEnd()
		 * @generated
		 */
		EClass MEANS_END = eINSTANCE.getMeansEnd();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DecompositionImpl <em>Decomposition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DecompositionImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDecomposition()
		 * @generated
		 */
		EClass DECOMPOSITION = eINSTANCE.getDecomposition();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerLinkImpl <em>Depender Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependerLinkImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependerLink()
		 * @generated
		 */
		EClass DEPENDER_LINK = eINSTANCE.getDependerLink();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDER_LINK__NAME = eINSTANCE.getDependerLink_Name();

		/**
		 * The meta object literal for the '<em><b>Depender</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDER_LINK__DEPENDER = eINSTANCE.getDependerLink_Depender();

		/**
		 * The meta object literal for the '<em><b>Dependum</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDER_LINK__DEPENDUM = eINSTANCE.getDependerLink_Dependum();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeLinkImpl <em>Dependee Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.DependeeLinkImpl
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getDependeeLink()
		 * @generated
		 */
		EClass DEPENDEE_LINK = eINSTANCE.getDependeeLink();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDEE_LINK__NAME = eINSTANCE.getDependeeLink_Name();

		/**
		 * The meta object literal for the '<em><b>Dependum</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDEE_LINK__DEPENDUM = eINSTANCE.getDependeeLink_Dependum();

		/**
		 * The meta object literal for the '<em><b>Dependee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDEE_LINK__DEPENDEE = eINSTANCE.getDependeeLink_Dependee();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType <em>Contribution Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType
		 * @see edu.toronto.cs.se.modelepedia.istar_mavo.impl.IStar_MAVOPackageImpl#getContributionType()
		 * @generated
		 */
		EEnum CONTRIBUTION_TYPE = eINSTANCE.getContributionType();

	}

} //IStar_MAVOPackage
