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
package edu.toronto.cs.se.modelepedia.kleisli;

import edu.toronto.cs.se.mmtf.mid.MidPackage;

import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface KleisliPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kleisli";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/KleisliModelRel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kleisli";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KleisliPackage eINSTANCE = edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelImpl
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliModel()
	 * @generated
	 */
	int KLEISLI_MODEL = 0;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__MAY = MidPackage.MODEL__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__SET = MidPackage.MODEL__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__VAR = MidPackage.MODEL__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__FORMULA_ID = MidPackage.MODEL__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__SUPERTYPE = MidPackage.MODEL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__METATYPE = MidPackage.MODEL__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__URI = MidPackage.MODEL__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__NAME = MidPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__LEVEL = MidPackage.MODEL__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__METATYPE_URI = MidPackage.MODEL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__DYNAMIC = MidPackage.MODEL__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__CONSTRAINT = MidPackage.MODEL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__INC = MidPackage.MODEL__INC;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__ORIGIN = MidPackage.MODEL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__FILE_EXTENSION = MidPackage.MODEL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__EDITORS = MidPackage.MODEL__EDITORS;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__MODEL_ELEMS = MidPackage.MODEL__MODEL_ELEMS;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__CONVERSION_OPERATORS = MidPackage.MODEL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL__ABSTRACT = MidPackage.MODEL__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_FEATURE_COUNT = MidPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___CREATE_SUBTYPE_URI__STRING_STRING = MidPackage.MODEL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___GET_METATYPE = MidPackage.MODEL___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___GET_SUPERTYPE = MidPackage.MODEL___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN = MidPackage.MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = MidPackage.MODEL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = MidPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create MAVO Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___CREATE_MAVO_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = MidPackage.MODEL___CREATE_MAVO_INSTANCE__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create MAVO Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___CREATE_MAVO_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = MidPackage.MODEL___CREATE_MAVO_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Copy MAVO Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___COPY_MAVO_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MULTIMODEL = MidPackage.MODEL___COPY_MAVO_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Kleisli Create Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___KLEISLI_CREATE_TYPE__KLEISLIMODELENDPOINT = MidPackage.MODEL_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___DELETE_TYPE = MidPackage.MODEL_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EMF Type Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___GET_EMF_TYPE_ROOT = MidPackage.MODEL_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Kleisli Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___KLEISLI_CREATE_INSTANCE__KLEISLIMODELENDPOINT = MidPackage.MODEL_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___DELETE_INSTANCE = MidPackage.MODEL_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get EMF Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL___GET_EMF_ROOT = MidPackage.MODEL_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_OPERATION_COUNT = MidPackage.MODEL_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelRelImpl <em>Model Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelRelImpl
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliModelRel()
	 * @generated
	 */
	int KLEISLI_MODEL_REL = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl <em>Model Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliModelEndpoint()
	 * @generated
	 */
	int KLEISLI_MODEL_ENDPOINT = 1;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__MAY = MidPackage.MODEL_ENDPOINT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__SET = MidPackage.MODEL_ENDPOINT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__VAR = MidPackage.MODEL_ENDPOINT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__FORMULA_ID = MidPackage.MODEL_ENDPOINT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__SUPERTYPE = MidPackage.MODEL_ENDPOINT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__METATYPE = MidPackage.MODEL_ENDPOINT__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__URI = MidPackage.MODEL_ENDPOINT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__NAME = MidPackage.MODEL_ENDPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__LEVEL = MidPackage.MODEL_ENDPOINT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__METATYPE_URI = MidPackage.MODEL_ENDPOINT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__DYNAMIC = MidPackage.MODEL_ENDPOINT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__CONSTRAINT = MidPackage.MODEL_ENDPOINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__LOWER_BOUND = MidPackage.MODEL_ENDPOINT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__UPPER_BOUND = MidPackage.MODEL_ENDPOINT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__TARGET = MidPackage.MODEL_ENDPOINT__TARGET;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__TARGET_URI = MidPackage.MODEL_ENDPOINT__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Extended Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET = MidPackage.MODEL_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET_URI = MidPackage.MODEL_ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_FEATURE_COUNT = MidPackage.MODEL_ENDPOINT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = MidPackage.MODEL_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___GET_SUPERTYPE = MidPackage.MODEL_ENDPOINT___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___GET_TARGET = MidPackage.MODEL_ENDPOINT___GET_TARGET;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___GET_METATYPE = MidPackage.MODEL_ENDPOINT___GET_METATYPE;

	/**
	 * The operation id for the '<em>Create Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__MODELENDPOINTREFERENCE_BOOLEAN_BOOLEAN_MODELREL = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__MODELENDPOINTREFERENCE_STRING_MODEL_BOOLEAN_MODELREL = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Replace Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_MODELENDPOINTREFERENCE_STRING_MODEL_MODELREL = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Type And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__BOOLEAN_MODELREL = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_BOOLEAN_MODELREL = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Replace Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Delete Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 7;

	/**
	 * The number of operations of the '<em>Model Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_OPERATION_COUNT = MidPackage.MODEL_ENDPOINT_OPERATION_COUNT + 8;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__MAY = RelationshipPackage.MODEL_REL__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__SET = RelationshipPackage.MODEL_REL__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__VAR = RelationshipPackage.MODEL_REL__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__FORMULA_ID = RelationshipPackage.MODEL_REL__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__SUPERTYPE = RelationshipPackage.MODEL_REL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__METATYPE = RelationshipPackage.MODEL_REL__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__URI = RelationshipPackage.MODEL_REL__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__NAME = RelationshipPackage.MODEL_REL__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__LEVEL = RelationshipPackage.MODEL_REL__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__METATYPE_URI = RelationshipPackage.MODEL_REL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__DYNAMIC = RelationshipPackage.MODEL_REL__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__CONSTRAINT = RelationshipPackage.MODEL_REL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__INC = RelationshipPackage.MODEL_REL__INC;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__ORIGIN = RelationshipPackage.MODEL_REL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__FILE_EXTENSION = RelationshipPackage.MODEL_REL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__EDITORS = RelationshipPackage.MODEL_REL__EDITORS;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__MODEL_ELEMS = RelationshipPackage.MODEL_REL__MODEL_ELEMS;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__CONVERSION_OPERATORS = RelationshipPackage.MODEL_REL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__ABSTRACT = RelationshipPackage.MODEL_REL__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__MODEL_ENDPOINTS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__LINKS = RelationshipPackage.MODEL_REL__LINKS;

	/**
	 * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__MODEL_ENDPOINT_REFS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS;

	/**
	 * The feature id for the '<em><b>Link Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__LINK_REFS = RelationshipPackage.MODEL_REL__LINK_REFS;

	/**
	 * The feature id for the '<em><b>Extended Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL__EXTENDED_URI = RelationshipPackage.MODEL_REL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL_FEATURE_COUNT = RelationshipPackage.MODEL_REL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Get EMF Type Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___GET_EMF_TYPE_ROOT = RelationshipPackage.MODEL_REL___GET_EMF_TYPE_ROOT;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = RelationshipPackage.MODEL_REL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create MAVO Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_MAVO_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = RelationshipPackage.MODEL_REL___CREATE_MAVO_INSTANCE__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create MAVO Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_MAVO_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = RelationshipPackage.MODEL_REL___CREATE_MAVO_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Copy MAVO Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___COPY_MAVO_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MULTIMODEL = RelationshipPackage.MODEL_REL___COPY_MAVO_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Get EMF Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___GET_EMF_ROOT = RelationshipPackage.MODEL_REL___GET_EMF_ROOT;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___GET_METATYPE = RelationshipPackage.MODEL_REL___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___GET_SUPERTYPE = RelationshipPackage.MODEL_REL___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Create Instance And Endpoints And References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS_AND_REFERENCES__STRING_BOOLEAN_MODELORIGIN_ELIST = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS_AND_REFERENCES__STRING_BOOLEAN_MODELORIGIN_ELIST;

	/**
	 * The operation id for the '<em>Copy MAVO Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___COPY_MAVO_INSTANCE__MODELREL_MULTIMODEL = RelationshipPackage.MODEL_REL___COPY_MAVO_INSTANCE__MODELREL_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Copy Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___COPY_SUBTYPE__MODELREL = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___DELETE_TYPE = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Outline Resource Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Type Transformation Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___GET_TYPE_TRANSFORMATION_OPERATOR__MODEL = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___DELETE_INSTANCE = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Open Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___OPEN_TYPE = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Open Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL___OPEN_INSTANCE = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_REL_OPERATION_COUNT = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 10;


	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliBinaryModelRelImpl <em>Binary Model Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliBinaryModelRelImpl
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliBinaryModelRel()
	 * @generated
	 */
	int KLEISLI_BINARY_MODEL_REL = 3;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__MAY = KLEISLI_MODEL_REL__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__SET = KLEISLI_MODEL_REL__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__VAR = KLEISLI_MODEL_REL__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__FORMULA_ID = KLEISLI_MODEL_REL__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__SUPERTYPE = KLEISLI_MODEL_REL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__METATYPE = KLEISLI_MODEL_REL__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__URI = KLEISLI_MODEL_REL__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__NAME = KLEISLI_MODEL_REL__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__LEVEL = KLEISLI_MODEL_REL__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__METATYPE_URI = KLEISLI_MODEL_REL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__DYNAMIC = KLEISLI_MODEL_REL__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__CONSTRAINT = KLEISLI_MODEL_REL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__INC = KLEISLI_MODEL_REL__INC;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__ORIGIN = KLEISLI_MODEL_REL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__FILE_EXTENSION = KLEISLI_MODEL_REL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__EDITORS = KLEISLI_MODEL_REL__EDITORS;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__MODEL_ELEMS = KLEISLI_MODEL_REL__MODEL_ELEMS;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__CONVERSION_OPERATORS = KLEISLI_MODEL_REL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__ABSTRACT = KLEISLI_MODEL_REL__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__MODEL_ENDPOINTS = KLEISLI_MODEL_REL__MODEL_ENDPOINTS;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__LINKS = KLEISLI_MODEL_REL__LINKS;

	/**
	 * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__MODEL_ENDPOINT_REFS = KLEISLI_MODEL_REL__MODEL_ENDPOINT_REFS;

	/**
	 * The feature id for the '<em><b>Link Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__LINK_REFS = KLEISLI_MODEL_REL__LINK_REFS;

	/**
	 * The feature id for the '<em><b>Extended Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__EXTENDED_URI = KLEISLI_MODEL_REL__EXTENDED_URI;

	/**
	 * The feature id for the '<em><b>Source Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__SOURCE_MODEL = KLEISLI_MODEL_REL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL__TARGET_MODEL = KLEISLI_MODEL_REL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL_FEATURE_COUNT = KLEISLI_MODEL_REL_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = KLEISLI_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN = KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Get EMF Type Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___GET_EMF_TYPE_ROOT = KLEISLI_MODEL_REL___GET_EMF_TYPE_ROOT;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = KLEISLI_MODEL_REL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create MAVO Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_MAVO_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = KLEISLI_MODEL_REL___CREATE_MAVO_INSTANCE__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create MAVO Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_MAVO_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = KLEISLI_MODEL_REL___CREATE_MAVO_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Copy MAVO Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___COPY_MAVO_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MULTIMODEL = KLEISLI_MODEL_REL___COPY_MAVO_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Get EMF Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___GET_EMF_ROOT = KLEISLI_MODEL_REL___GET_EMF_ROOT;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___GET_METATYPE = KLEISLI_MODEL_REL___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___GET_SUPERTYPE = KLEISLI_MODEL_REL___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Create Instance And Endpoints And References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS_AND_REFERENCES__STRING_BOOLEAN_MODELORIGIN_ELIST = KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS_AND_REFERENCES__STRING_BOOLEAN_MODELORIGIN_ELIST;

	/**
	 * The operation id for the '<em>Copy MAVO Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___COPY_MAVO_INSTANCE__MODELREL_MULTIMODEL = KLEISLI_MODEL_REL___COPY_MAVO_INSTANCE__MODELREL_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING = KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING;

	/**
	 * The operation id for the '<em>Copy Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___COPY_SUBTYPE__MODELREL = KLEISLI_MODEL_REL___COPY_SUBTYPE__MODELREL;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___DELETE_TYPE = KLEISLI_MODEL_REL___DELETE_TYPE;

	/**
	 * The operation id for the '<em>Get Outline Resource Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL = KLEISLI_MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___DELETE_INSTANCE = KLEISLI_MODEL_REL___DELETE_INSTANCE;

	/**
	 * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES;

	/**
	 * The operation id for the '<em>Open Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___OPEN_TYPE = KLEISLI_MODEL_REL___OPEN_TYPE;

	/**
	 * The operation id for the '<em>Open Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___OPEN_INSTANCE = KLEISLI_MODEL_REL___OPEN_INSTANCE;

	/**
	 * The operation id for the '<em>Get Type Transformation Operator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL___GET_TYPE_TRANSFORMATION_OPERATOR__MODEL = KLEISLI_MODEL_REL_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Binary Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_BINARY_MODEL_REL_OPERATION_COUNT = KLEISLI_MODEL_REL_OPERATION_COUNT + 2;


	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointReferenceImpl <em>Model Endpoint Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliModelEndpointReference()
	 * @generated
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__OBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__SUPERTYPE_REF = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__MODIFIABLE = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__URI = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__TARGET_URI = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Model Elem Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS;

	/**
	 * The feature id for the '<em><b>Extended Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE__EXTENDED_TARGET_URI = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE_FEATURE_COUNT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___GET_OBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_OBJECT;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN;

	/**
	 * The operation id for the '<em>Accept Model Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept Model Element Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel
	 * @generated
	 */
	EClass getKleisliModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#kleisliCreateType(edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint) <em>Kleisli Create Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Kleisli Create Type</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#kleisliCreateType(edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint)
	 * @generated
	 */
	EOperation getKleisliModel__KleisliCreateType__KleisliModelEndpoint();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#deleteType()
	 * @generated
	 */
	EOperation getKleisliModel__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#getEMFTypeRoot() <em>Get EMF Type Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Type Root</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#getEMFTypeRoot()
	 * @generated
	 */
	EOperation getKleisliModel__GetEMFTypeRoot();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#kleisliCreateInstance(edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint) <em>Kleisli Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Kleisli Create Instance</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#kleisliCreateInstance(edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint)
	 * @generated
	 */
	EOperation getKleisliModel__KleisliCreateInstance__KleisliModelEndpoint();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#deleteInstance()
	 * @generated
	 */
	EOperation getKleisliModel__DeleteInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#getEMFInstanceRoot() <em>Get EMF Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Root</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#getEMFInstanceRoot()
	 * @generated
	 */
	EOperation getKleisliModel__GetEMFRoot();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel <em>Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Rel</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel
	 * @generated
	 */
	EClass getKleisliModelRel();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getExtendedUri <em>Extended Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extended Uri</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getExtendedUri()
	 * @see #getKleisliModelRel()
	 * @generated
	 */
	EAttribute getKleisliModelRel_ExtendedUri();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#createSubtype(java.lang.String, boolean, java.lang.String, java.lang.String) <em>Create Subtype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#createSubtype(java.lang.String, boolean, java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getKleisliModelRel__CreateSubtype__String_boolean_String_String();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#copySubtype(edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Copy Subtype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy Subtype</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#copySubtype(edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getKleisliModelRel__CopySubtype__ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#deleteType()
	 * @generated
	 */
	EOperation getKleisliModelRel__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#createInstance(java.lang.String, boolean, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel) <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#createInstance(java.lang.String, boolean, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel)
	 * @generated
	 */
	EOperation getKleisliModelRel__CreateInstance__String_boolean_ModelOrigin_MultiModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#deleteInstance()
	 * @generated
	 */
	EOperation getKleisliModelRel__DeleteInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#openType() <em>Open Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Open Type</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#openType()
	 * @generated
	 */
	EOperation getKleisliModelRel__OpenType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#openInstance() <em>Open Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Open Instance</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#openInstance()
	 * @generated
	 */
	EOperation getKleisliModelRel__OpenInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getOutlineResourceTypes() <em>Get Outline Resource Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outline Resource Types</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getOutlineResourceTypes()
	 * @generated
	 */
	EOperation getKleisliModelRel__GetOutlineResourceTypes();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getTypeTransformationOperator(edu.toronto.cs.se.mmtf.mid.Model) <em>Get Type Transformation Operator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Transformation Operator</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getTypeTransformationOperator(edu.toronto.cs.se.mmtf.mid.Model)
	 * @generated
	 */
	EOperation getKleisliModelRel__GetTypeTransformationOperator__Model();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getOutlineResourceInstances() <em>Get Outline Resource Instances</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outline Resource Instances</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#getOutlineResourceInstances()
	 * @generated
	 */
	EOperation getKleisliModelRel__GetOutlineResourceInstances();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint <em>Model Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Endpoint</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint
	 * @generated
	 */
	EClass getKleisliModelEndpoint();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#getExtendedTarget <em>Extended Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extended Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#getExtendedTarget()
	 * @see #getKleisliModelEndpoint()
	 * @generated
	 */
	EReference getKleisliModelEndpoint_ExtendedTarget();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#getExtendedTargetUri <em>Extended Target Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extended Target Uri</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#getExtendedTargetUri()
	 * @see #getKleisliModelEndpoint()
	 * @generated
	 */
	EAttribute getKleisliModelEndpoint_ExtendedTargetUri();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, java.lang.String, edu.toronto.cs.se.mmtf.mid.Model, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, java.lang.String, edu.toronto.cs.se.mmtf.mid.Model, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getKleisliModelEndpoint__CreateSubtypeAndReference__ModelEndpointReference_String_Model_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#replaceSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.ModelEndpoint, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, java.lang.String, edu.toronto.cs.se.mmtf.mid.Model, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Replace Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Replace Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#replaceSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.ModelEndpoint, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, java.lang.String, edu.toronto.cs.se.mmtf.mid.Model, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getKleisliModelEndpoint__ReplaceSubtypeAndReference__ModelEndpoint_ModelEndpointReference_String_Model_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#deleteTypeAndReference(boolean) <em>Delete Type And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type And Reference</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#deleteTypeAndReference(boolean)
	 * @generated
	 */
	EOperation getKleisliModelEndpoint__DeleteTypeAndReference__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createInstanceAndReference(edu.toronto.cs.se.mmtf.mid.Model, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createInstanceAndReference(edu.toronto.cs.se.mmtf.mid.Model, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getKleisliModelEndpoint__CreateInstanceAndReference__Model_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#deleteInstanceAndReference(boolean) <em>Delete Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#deleteInstanceAndReference(boolean)
	 * @generated
	 */
	EOperation getKleisliModelEndpoint__DeleteInstanceAndReference__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#replaceInstanceAndReference(edu.toronto.cs.se.mmtf.mid.ModelEndpoint, edu.toronto.cs.se.mmtf.mid.Model) <em>Replace Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Replace Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#replaceInstanceAndReference(edu.toronto.cs.se.mmtf.mid.ModelEndpoint, edu.toronto.cs.se.mmtf.mid.Model)
	 * @generated
	 */
	EOperation getKleisliModelEndpoint__ReplaceInstanceAndReference__ModelEndpoint_Model();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, boolean, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, boolean, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getKleisliModelEndpoint__CreateTypeReference__ModelEndpointReference_boolean_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createInstanceReference(boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createInstanceReference(boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getKleisliModelEndpoint__CreateInstanceReference__boolean_ModelRel();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel <em>Binary Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Model Rel</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel
	 * @generated
	 */
	EClass getKleisliBinaryModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel#getTypeTransformationOperator(edu.toronto.cs.se.mmtf.mid.Model) <em>Get Type Transformation Operator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Type Transformation Operator</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel#getTypeTransformationOperator(edu.toronto.cs.se.mmtf.mid.Model)
	 * @generated
	 */
	EOperation getKleisliBinaryModelRel__GetTypeTransformationOperator__Model();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference <em>Model Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Endpoint Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference
	 * @generated
	 */
	EClass getKleisliModelEndpointReference();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference#getExtendedTargetUri <em>Extended Target Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extended Target Uri</em>'.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference#getExtendedTargetUri()
	 * @see #getKleisliModelEndpointReference()
	 * @generated
	 */
	EAttribute getKleisliModelEndpointReference_ExtendedTargetUri();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference#acceptModelElementType(org.eclipse.emf.ecore.EObject) <em>Accept Model Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept Model Element Type</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference#acceptModelElementType(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getKleisliModelEndpointReference__AcceptModelElementType__EObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference#acceptModelElementInstance(org.eclipse.emf.ecore.EObject) <em>Accept Model Element Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept Model Element Instance</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference#acceptModelElementInstance(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getKleisliModelEndpointReference__AcceptModelElementInstance__EObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KleisliFactory getKleisliFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelImpl
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliModel()
		 * @generated
		 */
		EClass KLEISLI_MODEL = eINSTANCE.getKleisliModel();

		/**
		 * The meta object literal for the '<em><b>Kleisli Create Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL___KLEISLI_CREATE_TYPE__KLEISLIMODELENDPOINT = eINSTANCE.getKleisliModel__KleisliCreateType__KleisliModelEndpoint();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL___DELETE_TYPE = eINSTANCE.getKleisliModel__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Get EMF Type Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL___GET_EMF_TYPE_ROOT = eINSTANCE.getKleisliModel__GetEMFTypeRoot();

		/**
		 * The meta object literal for the '<em><b>Kleisli Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL___KLEISLI_CREATE_INSTANCE__KLEISLIMODELENDPOINT = eINSTANCE.getKleisliModel__KleisliCreateInstance__KleisliModelEndpoint();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL___DELETE_INSTANCE = eINSTANCE.getKleisliModel__DeleteInstance();

		/**
		 * The meta object literal for the '<em><b>Get EMF Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL___GET_EMF_ROOT = eINSTANCE.getKleisliModel__GetEMFRoot();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelRelImpl <em>Model Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelRelImpl
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliModelRel()
		 * @generated
		 */
		EClass KLEISLI_MODEL_REL = eINSTANCE.getKleisliModelRel();

		/**
		 * The meta object literal for the '<em><b>Extended Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLEISLI_MODEL_REL__EXTENDED_URI = eINSTANCE.getKleisliModelRel_ExtendedUri();

		/**
		 * The meta object literal for the '<em><b>Create Subtype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING = eINSTANCE.getKleisliModelRel__CreateSubtype__String_boolean_String_String();

		/**
		 * The meta object literal for the '<em><b>Copy Subtype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___COPY_SUBTYPE__MODELREL = eINSTANCE.getKleisliModelRel__CopySubtype__ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___DELETE_TYPE = eINSTANCE.getKleisliModelRel__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL = eINSTANCE.getKleisliModelRel__CreateInstance__String_boolean_ModelOrigin_MultiModel();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___DELETE_INSTANCE = eINSTANCE.getKleisliModelRel__DeleteInstance();

		/**
		 * The meta object literal for the '<em><b>Open Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___OPEN_TYPE = eINSTANCE.getKleisliModelRel__OpenType();

		/**
		 * The meta object literal for the '<em><b>Open Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___OPEN_INSTANCE = eINSTANCE.getKleisliModelRel__OpenInstance();

		/**
		 * The meta object literal for the '<em><b>Get Outline Resource Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = eINSTANCE.getKleisliModelRel__GetOutlineResourceTypes();

		/**
		 * The meta object literal for the '<em><b>Get Type Transformation Operator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___GET_TYPE_TRANSFORMATION_OPERATOR__MODEL = eINSTANCE.getKleisliModelRel__GetTypeTransformationOperator__Model();

		/**
		 * The meta object literal for the '<em><b>Get Outline Resource Instances</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = eINSTANCE.getKleisliModelRel__GetOutlineResourceInstances();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl <em>Model Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointImpl
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliModelEndpoint()
		 * @generated
		 */
		EClass KLEISLI_MODEL_ENDPOINT = eINSTANCE.getKleisliModelEndpoint();

		/**
		 * The meta object literal for the '<em><b>Extended Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET = eINSTANCE.getKleisliModelEndpoint_ExtendedTarget();

		/**
		 * The meta object literal for the '<em><b>Extended Target Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET_URI = eINSTANCE.getKleisliModelEndpoint_ExtendedTargetUri();

		/**
		 * The meta object literal for the '<em><b>Create Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__MODELENDPOINTREFERENCE_STRING_MODEL_BOOLEAN_MODELREL = eINSTANCE.getKleisliModelEndpoint__CreateSubtypeAndReference__ModelEndpointReference_String_Model_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Replace Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_MODELENDPOINTREFERENCE_STRING_MODEL_MODELREL = eINSTANCE.getKleisliModelEndpoint__ReplaceSubtypeAndReference__ModelEndpoint_ModelEndpointReference_String_Model_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Type And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN = eINSTANCE.getKleisliModelEndpoint__DeleteTypeAndReference__boolean();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_BOOLEAN_MODELREL = eINSTANCE.getKleisliModelEndpoint__CreateInstanceAndReference__Model_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN = eINSTANCE.getKleisliModelEndpoint__DeleteInstanceAndReference__boolean();

		/**
		 * The meta object literal for the '<em><b>Replace Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL = eINSTANCE.getKleisliModelEndpoint__ReplaceInstanceAndReference__ModelEndpoint_Model();

		/**
		 * The meta object literal for the '<em><b>Create Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__MODELENDPOINTREFERENCE_BOOLEAN_BOOLEAN_MODELREL = eINSTANCE.getKleisliModelEndpoint__CreateTypeReference__ModelEndpointReference_boolean_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__BOOLEAN_MODELREL = eINSTANCE.getKleisliModelEndpoint__CreateInstanceReference__boolean_ModelRel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliBinaryModelRelImpl <em>Binary Model Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliBinaryModelRelImpl
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliBinaryModelRel()
		 * @generated
		 */
		EClass KLEISLI_BINARY_MODEL_REL = eINSTANCE.getKleisliBinaryModelRel();

		/**
		 * The meta object literal for the '<em><b>Get Type Transformation Operator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_BINARY_MODEL_REL___GET_TYPE_TRANSFORMATION_OPERATOR__MODEL = eINSTANCE.getKleisliBinaryModelRel__GetTypeTransformationOperator__Model();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointReferenceImpl <em>Model Endpoint Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliModelEndpointReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getKleisliModelEndpointReference()
		 * @generated
		 */
		EClass KLEISLI_MODEL_ENDPOINT_REFERENCE = eINSTANCE.getKleisliModelEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Extended Target Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KLEISLI_MODEL_ENDPOINT_REFERENCE__EXTENDED_TARGET_URI = eINSTANCE.getKleisliModelEndpointReference_ExtendedTargetUri();

		/**
		 * The meta object literal for the '<em><b>Accept Model Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT = eINSTANCE.getKleisliModelEndpointReference__AcceptModelElementType__EObject();

		/**
		 * The meta object literal for the '<em><b>Accept Model Element Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KLEISLI_MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT = eINSTANCE.getKleisliModelEndpointReference__AcceptModelElementInstance__EObject();

	}

} //KleisliPackage
