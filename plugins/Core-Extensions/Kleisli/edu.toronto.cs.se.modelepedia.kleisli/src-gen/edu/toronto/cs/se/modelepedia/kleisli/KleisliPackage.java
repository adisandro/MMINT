/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

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
     * The feature id for the '<em><b>Supertype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__SUPERTYPE = MIDPackage.MODEL__SUPERTYPE;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__URI = MIDPackage.MODEL__URI;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__NAME = MIDPackage.MODEL__NAME;

	/**
     * The feature id for the '<em><b>Level</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__LEVEL = MIDPackage.MODEL__LEVEL;

	/**
     * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__METATYPE_URI = MIDPackage.MODEL__METATYPE_URI;

	/**
     * The feature id for the '<em><b>Dynamic</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__DYNAMIC = MIDPackage.MODEL__DYNAMIC;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__CONSTRAINT = MIDPackage.MODEL__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__ABSTRACT = MIDPackage.MODEL__ABSTRACT;

	/**
     * The feature id for the '<em><b>Origin</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__ORIGIN = MIDPackage.MODEL__ORIGIN;

	/**
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__FILE_EXTENSION = MIDPackage.MODEL__FILE_EXTENSION;

	/**
     * The feature id for the '<em><b>Editors</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__EDITORS = MIDPackage.MODEL__EDITORS;

	/**
     * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__MODEL_ELEMS = MIDPackage.MODEL__MODEL_ELEMS;

	/**
     * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL__CONVERSION_OPERATORS = MIDPackage.MODEL__CONVERSION_OPERATORS;

	/**
     * The number of structural features of the '<em>Model</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_FEATURE_COUNT = MIDPackage.MODEL_FEATURE_COUNT + 0;

	/**
     * The operation id for the '<em>Is Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___IS_LEVEL__MIDLEVEL = MIDPackage.MODEL___IS_LEVEL__MIDLEVEL;

	/**
     * The operation id for the '<em>Is Types Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___IS_TYPES_LEVEL = MIDPackage.MODEL___IS_TYPES_LEVEL;

	/**
     * The operation id for the '<em>Create Subtype Uri</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.MODEL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
     * The operation id for the '<em>Add Type Constraint</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.MODEL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
     * The operation id for the '<em>Is Instances Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___IS_INSTANCES_LEVEL = MIDPackage.MODEL___IS_INSTANCES_LEVEL;

	/**
     * The operation id for the '<em>Get Runtime Types</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___GET_RUNTIME_TYPES = MIDPackage.MODEL___GET_RUNTIME_TYPES;

	/**
     * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KLEISLI_MODEL___GET_CLOSEST_TYPE_CONSTRAINT = MIDPackage.MODEL___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
     * The operation id for the '<em>Validate Instance Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.MODEL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
     * The operation id for the '<em>Validate Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___VALIDATE_INSTANCE = MIDPackage.MODEL___VALIDATE_INSTANCE;

	/**
     * The operation id for the '<em>Validate Instance In Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
     * The operation id for the '<em>Is Workflows Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___IS_WORKFLOWS_LEVEL = MIDPackage.MODEL___IS_WORKFLOWS_LEVEL;

	/**
     * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.MODEL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
     * The operation id for the '<em>To MID Custom Print Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.MODEL___TO_MID_CUSTOM_PRINT_LABEL;

	/**
     * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.MODEL___TO_MID_CUSTOM_EDIT_LABEL;

	/**
     * The operation id for the '<em>Update MID Custom Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.MODEL___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
     * The operation id for the '<em>Get Metatype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___GET_METATYPE = MIDPackage.MODEL___GET_METATYPE;

	/**
     * The operation id for the '<em>Get Supertype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___GET_SUPERTYPE = MIDPackage.MODEL___GET_SUPERTYPE;

	/**
     * The operation id for the '<em>Get MID Container</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___GET_MID_CONTAINER = MIDPackage.MODEL___GET_MID_CONTAINER;

	/**
     * The operation id for the '<em>Create Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___CREATE_SUBTYPE__STRING_BOOLEAN = MIDPackage.MODEL___CREATE_SUBTYPE__STRING_BOOLEAN;

	/**
     * The operation id for the '<em>Open Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___OPEN_TYPE = MIDPackage.MODEL___OPEN_TYPE;

	/**
     * The operation id for the '<em>Create Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___CREATE_INSTANCE__EOBJECT_STRING_MID = MIDPackage.MODEL___CREATE_INSTANCE__EOBJECT_STRING_MID;

	/**
     * The operation id for the '<em>Create Instance Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KLEISLI_MODEL___CREATE_INSTANCE_EDITOR__BOOLEAN = MIDPackage.MODEL___CREATE_INSTANCE_EDITOR__BOOLEAN;

    /**
     * The operation id for the '<em>Create Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = MIDPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

	/**
     * The operation id for the '<em>Import Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___IMPORT_INSTANCE__STRING_MID = MIDPackage.MODEL___IMPORT_INSTANCE__STRING_MID;

	/**
     * The operation id for the '<em>Import Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = MIDPackage.MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
     * The operation id for the '<em>Copy Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___COPY_INSTANCE__MODEL_STRING_MID = MIDPackage.MODEL___COPY_INSTANCE__MODEL_STRING_MID;

	/**
     * The operation id for the '<em>Copy Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = MIDPackage.MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
     * The operation id for the '<em>Delete Instance And File</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___DELETE_INSTANCE_AND_FILE = MIDPackage.MODEL___DELETE_INSTANCE_AND_FILE;

	/**
     * The operation id for the '<em>Open Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___OPEN_INSTANCE = MIDPackage.MODEL___OPEN_INSTANCE;

	/**
     * The operation id for the '<em>Create Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID = MIDPackage.MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
     * The operation id for the '<em>Delete Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___DELETE_WORKFLOW_INSTANCE = MIDPackage.MODEL___DELETE_WORKFLOW_INSTANCE;

	/**
     * The operation id for the '<em>Kleisli Create Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___KLEISLI_CREATE_TYPE__KLEISLIMODELENDPOINT = MIDPackage.MODEL_OPERATION_COUNT + 0;

	/**
     * The operation id for the '<em>Delete Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___DELETE_TYPE = MIDPackage.MODEL_OPERATION_COUNT + 1;

	/**
     * The operation id for the '<em>Get EMF Type Root</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___GET_EMF_TYPE_ROOT = MIDPackage.MODEL_OPERATION_COUNT + 2;

	/**
     * The operation id for the '<em>Kleisli Create Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___KLEISLI_CREATE_INSTANCE__KLEISLIMODELENDPOINT = MIDPackage.MODEL_OPERATION_COUNT + 3;

	/**
     * The operation id for the '<em>Delete Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___DELETE_INSTANCE = MIDPackage.MODEL_OPERATION_COUNT + 4;

	/**
     * The operation id for the '<em>Get EMF Instance Root</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL___GET_EMF_INSTANCE_ROOT = MIDPackage.MODEL_OPERATION_COUNT + 5;

	/**
     * The number of operations of the '<em>Model</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_OPERATION_COUNT = MIDPackage.MODEL_OPERATION_COUNT + 6;

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
     * The feature id for the '<em><b>Supertype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__SUPERTYPE = MIDPackage.MODEL_ENDPOINT__SUPERTYPE;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__URI = MIDPackage.MODEL_ENDPOINT__URI;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__NAME = MIDPackage.MODEL_ENDPOINT__NAME;

	/**
     * The feature id for the '<em><b>Level</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__LEVEL = MIDPackage.MODEL_ENDPOINT__LEVEL;

	/**
     * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__METATYPE_URI = MIDPackage.MODEL_ENDPOINT__METATYPE_URI;

	/**
     * The feature id for the '<em><b>Dynamic</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__DYNAMIC = MIDPackage.MODEL_ENDPOINT__DYNAMIC;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__CONSTRAINT = MIDPackage.MODEL_ENDPOINT__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__LOWER_BOUND = MIDPackage.MODEL_ENDPOINT__LOWER_BOUND;

	/**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__UPPER_BOUND = MIDPackage.MODEL_ENDPOINT__UPPER_BOUND;

	/**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__TARGET = MIDPackage.MODEL_ENDPOINT__TARGET;

	/**
     * The feature id for the '<em><b>Extended Target</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET = MIDPackage.MODEL_ENDPOINT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Extended Target Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET_URI = MIDPackage.MODEL_ENDPOINT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Model Endpoint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_FEATURE_COUNT = MIDPackage.MODEL_ENDPOINT_FEATURE_COUNT + 2;

	/**
     * The operation id for the '<em>Is Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___IS_LEVEL__MIDLEVEL = MIDPackage.MODEL_ENDPOINT___IS_LEVEL__MIDLEVEL;

	/**
     * The operation id for the '<em>Is Types Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___IS_TYPES_LEVEL = MIDPackage.MODEL_ENDPOINT___IS_TYPES_LEVEL;

	/**
     * The operation id for the '<em>Create Subtype Uri</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.MODEL_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
     * The operation id for the '<em>Add Type Constraint</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.MODEL_ENDPOINT___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
     * The operation id for the '<em>Is Instances Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___IS_INSTANCES_LEVEL = MIDPackage.MODEL_ENDPOINT___IS_INSTANCES_LEVEL;

	/**
     * The operation id for the '<em>Get Runtime Types</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___GET_RUNTIME_TYPES = MIDPackage.MODEL_ENDPOINT___GET_RUNTIME_TYPES;

	/**
     * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KLEISLI_MODEL_ENDPOINT___GET_CLOSEST_TYPE_CONSTRAINT = MIDPackage.MODEL_ENDPOINT___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
     * The operation id for the '<em>Validate Instance Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.MODEL_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
     * The operation id for the '<em>Validate Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___VALIDATE_INSTANCE = MIDPackage.MODEL_ENDPOINT___VALIDATE_INSTANCE;

	/**
     * The operation id for the '<em>Validate Instance In Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.MODEL_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
     * The operation id for the '<em>Is Workflows Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___IS_WORKFLOWS_LEVEL = MIDPackage.MODEL_ENDPOINT___IS_WORKFLOWS_LEVEL;

	/**
     * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.MODEL_ENDPOINT___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
     * The operation id for the '<em>To MID Custom Print Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.MODEL_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
     * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.MODEL_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
     * The operation id for the '<em>Update MID Custom Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.MODEL_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
     * The operation id for the '<em>Get Target Uri</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___GET_TARGET_URI = MIDPackage.MODEL_ENDPOINT___GET_TARGET_URI;

	/**
     * The operation id for the '<em>Get Metatype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___GET_METATYPE = MIDPackage.MODEL_ENDPOINT___GET_METATYPE;

	/**
     * The operation id for the '<em>Get Supertype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___GET_SUPERTYPE = MIDPackage.MODEL_ENDPOINT___GET_SUPERTYPE;

	/**
     * The operation id for the '<em>Get MID Container</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___GET_MID_CONTAINER = MIDPackage.MODEL_ENDPOINT___GET_MID_CONTAINER;

	/**
     * The operation id for the '<em>Get Target</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___GET_TARGET = MIDPackage.MODEL_ENDPOINT___GET_TARGET;

	/**
     * The operation id for the '<em>Create Type Reference</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL = MIDPackage.MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL;

	/**
     * The operation id for the '<em>Create Instance Reference</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL = MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL;

	/**
     * The operation id for the '<em>Create Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING = MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING;

	/**
     * The operation id for the '<em>Create Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_MODELREL = MIDPackage.MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_MODELREL;

	/**
     * The operation id for the '<em>Create Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_OPERATOR_STRING = MIDPackage.MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_OPERATOR_STRING;

	/**
     * The operation id for the '<em>Replace Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___REPLACE_WORKFLOW_INSTANCE__MODELENDPOINT_MODEL = MIDPackage.MODEL_ENDPOINT___REPLACE_WORKFLOW_INSTANCE__MODELENDPOINT_MODEL;

	/**
     * The operation id for the '<em>Delete Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___DELETE_WORKFLOW_INSTANCE = MIDPackage.MODEL_ENDPOINT___DELETE_WORKFLOW_INSTANCE;

	/**
     * The operation id for the '<em>Create Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___CREATE_SUBTYPE__STRING_MODEL_BOOLEAN_MODELREL = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 0;

	/**
     * The operation id for the '<em>Replace Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___REPLACE_SUBTYPE__MODELENDPOINT_STRING_MODEL = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 1;

	/**
     * The operation id for the '<em>Delete Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___DELETE_TYPE__BOOLEAN = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 2;

	/**
     * The operation id for the '<em>Create Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_MODELREL = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 3;

	/**
     * The operation id for the '<em>Replace Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___REPLACE_INSTANCE__MODELENDPOINT_MODEL = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 4;

	/**
     * The operation id for the '<em>Delete Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT___DELETE_INSTANCE__BOOLEAN = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 5;

	/**
     * The number of operations of the '<em>Model Endpoint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_OPERATION_COUNT = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 6;

	/**
     * The feature id for the '<em><b>Supertype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL__SUPERTYPE = RelationshipPackage.MODEL_REL__SUPERTYPE;

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
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL__ABSTRACT = RelationshipPackage.MODEL_REL__ABSTRACT;

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
     * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL__MODEL_ENDPOINTS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS;

	/**
     * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL__MAPPINGS = RelationshipPackage.MODEL_REL__MAPPINGS;

	/**
     * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL__MODEL_ENDPOINT_REFS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS;

	/**
     * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL__MAPPING_REFS = RelationshipPackage.MODEL_REL__MAPPING_REFS;

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
     * The operation id for the '<em>Is Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___IS_LEVEL__MIDLEVEL = RelationshipPackage.MODEL_REL___IS_LEVEL__MIDLEVEL;

	/**
     * The operation id for the '<em>Is Types Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___IS_TYPES_LEVEL = RelationshipPackage.MODEL_REL___IS_TYPES_LEVEL;

	/**
     * The operation id for the '<em>Create Subtype Uri</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
     * The operation id for the '<em>Add Type Constraint</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
     * The operation id for the '<em>Is Instances Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___IS_INSTANCES_LEVEL = RelationshipPackage.MODEL_REL___IS_INSTANCES_LEVEL;

	/**
     * The operation id for the '<em>Get Runtime Types</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___GET_RUNTIME_TYPES = RelationshipPackage.MODEL_REL___GET_RUNTIME_TYPES;

	/**
     * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KLEISLI_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
     * The operation id for the '<em>Validate Instance Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
     * The operation id for the '<em>Validate Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___VALIDATE_INSTANCE = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE;

	/**
     * The operation id for the '<em>Validate Instance In Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
     * The operation id for the '<em>Is Workflows Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___IS_WORKFLOWS_LEVEL = RelationshipPackage.MODEL_REL___IS_WORKFLOWS_LEVEL;

	/**
     * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
     * The operation id for the '<em>To MID Custom Print Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL;

	/**
     * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL;

	/**
     * The operation id for the '<em>Update MID Custom Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
     * The operation id for the '<em>Create Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN;

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
	int KLEISLI_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID;

	/**
     * The operation id for the '<em>Create Instance Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KLEISLI_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN;

    /**
     * The operation id for the '<em>Create Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

	/**
     * The operation id for the '<em>Import Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___IMPORT_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___IMPORT_INSTANCE__STRING_MID;

	/**
     * The operation id for the '<em>Import Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = RelationshipPackage.MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
     * The operation id for the '<em>Copy Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = RelationshipPackage.MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID;

	/**
     * The operation id for the '<em>Copy Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = RelationshipPackage.MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
     * The operation id for the '<em>Delete Instance And File</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___DELETE_INSTANCE_AND_FILE = RelationshipPackage.MODEL_REL___DELETE_INSTANCE_AND_FILE;

	/**
     * The operation id for the '<em>Get EMF Instance Root</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___GET_EMF_INSTANCE_ROOT = RelationshipPackage.MODEL_REL___GET_EMF_INSTANCE_ROOT;

	/**
     * The operation id for the '<em>Create Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
     * The operation id for the '<em>Delete Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___DELETE_WORKFLOW_INSTANCE = RelationshipPackage.MODEL_REL___DELETE_WORKFLOW_INSTANCE;

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
     * The operation id for the '<em>Get MID Container</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___GET_MID_CONTAINER = RelationshipPackage.MODEL_REL___GET_MID_CONTAINER;

	/**
     * The operation id for the '<em>Create Binary Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN;

	/**
     * The operation id for the '<em>Create Instance And Endpoints</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID;

	/**
     * The operation id for the '<em>Create Binary Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID;

	/**
     * The operation id for the '<em>Create Binary Instance And Endpoints</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID;

	/**
     * The operation id for the '<em>Create Workflow Instance And Endpoints</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID;

	/**
     * The operation id for the '<em>Create Workflow Binary Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID;

	/**
     * The operation id for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID;

	/**
     * The operation id for the '<em>Copy Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___COPY_SUBTYPE__MODELREL = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 0;

	/**
     * The operation id for the '<em>Open Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___OPEN_TYPE = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 1;

	/**
     * The operation id for the '<em>Get Outline Resource Types</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 2;

	/**
     * The operation id for the '<em>Delete Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___DELETE_TYPE = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 3;

	/**
     * The operation id for the '<em>Open Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___OPEN_INSTANCE = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 4;

	/**
     * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 5;

	/**
     * The operation id for the '<em>Delete Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL___DELETE_INSTANCE = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 6;

	/**
     * The number of operations of the '<em>Model Rel</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_REL_OPERATION_COUNT = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 7;


	/**
     * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.BinaryKleisliModelRelImpl <em>Binary Kleisli Model Rel</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.kleisli.impl.BinaryKleisliModelRelImpl
     * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getBinaryKleisliModelRel()
     * @generated
     */
	int BINARY_KLEISLI_MODEL_REL = 3;

	/**
     * The feature id for the '<em><b>Supertype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__SUPERTYPE = KLEISLI_MODEL_REL__SUPERTYPE;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__URI = KLEISLI_MODEL_REL__URI;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__NAME = KLEISLI_MODEL_REL__NAME;

	/**
     * The feature id for the '<em><b>Level</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__LEVEL = KLEISLI_MODEL_REL__LEVEL;

	/**
     * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__METATYPE_URI = KLEISLI_MODEL_REL__METATYPE_URI;

	/**
     * The feature id for the '<em><b>Dynamic</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__DYNAMIC = KLEISLI_MODEL_REL__DYNAMIC;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__CONSTRAINT = KLEISLI_MODEL_REL__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__ABSTRACT = KLEISLI_MODEL_REL__ABSTRACT;

	/**
     * The feature id for the '<em><b>Origin</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__ORIGIN = KLEISLI_MODEL_REL__ORIGIN;

	/**
     * The feature id for the '<em><b>File Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__FILE_EXTENSION = KLEISLI_MODEL_REL__FILE_EXTENSION;

	/**
     * The feature id for the '<em><b>Editors</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__EDITORS = KLEISLI_MODEL_REL__EDITORS;

	/**
     * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__MODEL_ELEMS = KLEISLI_MODEL_REL__MODEL_ELEMS;

	/**
     * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__CONVERSION_OPERATORS = KLEISLI_MODEL_REL__CONVERSION_OPERATORS;

	/**
     * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__MODEL_ENDPOINTS = KLEISLI_MODEL_REL__MODEL_ENDPOINTS;

	/**
     * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__MAPPINGS = KLEISLI_MODEL_REL__MAPPINGS;

	/**
     * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__MODEL_ENDPOINT_REFS = KLEISLI_MODEL_REL__MODEL_ENDPOINT_REFS;

	/**
     * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__MAPPING_REFS = KLEISLI_MODEL_REL__MAPPING_REFS;

	/**
     * The feature id for the '<em><b>Extended Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__EXTENDED_URI = KLEISLI_MODEL_REL__EXTENDED_URI;

	/**
     * The feature id for the '<em><b>Source Model</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__SOURCE_MODEL = KLEISLI_MODEL_REL_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Target Model</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL__TARGET_MODEL = KLEISLI_MODEL_REL_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Binary Kleisli Model Rel</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL_FEATURE_COUNT = KLEISLI_MODEL_REL_FEATURE_COUNT + 2;

	/**
     * The operation id for the '<em>Is Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___IS_LEVEL__MIDLEVEL = KLEISLI_MODEL_REL___IS_LEVEL__MIDLEVEL;

	/**
     * The operation id for the '<em>Is Types Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___IS_TYPES_LEVEL = KLEISLI_MODEL_REL___IS_TYPES_LEVEL;

	/**
     * The operation id for the '<em>Create Subtype Uri</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = KLEISLI_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
     * The operation id for the '<em>Add Type Constraint</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING = KLEISLI_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
     * The operation id for the '<em>Is Instances Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___IS_INSTANCES_LEVEL = KLEISLI_MODEL_REL___IS_INSTANCES_LEVEL;

	/**
     * The operation id for the '<em>Get Runtime Types</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___GET_RUNTIME_TYPES = KLEISLI_MODEL_REL___GET_RUNTIME_TYPES;

	/**
     * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BINARY_KLEISLI_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT = KLEISLI_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
     * The operation id for the '<em>Validate Instance Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = KLEISLI_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
     * The operation id for the '<em>Validate Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___VALIDATE_INSTANCE = KLEISLI_MODEL_REL___VALIDATE_INSTANCE;

	/**
     * The operation id for the '<em>Validate Instance In Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = KLEISLI_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
     * The operation id for the '<em>Is Workflows Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___IS_WORKFLOWS_LEVEL = KLEISLI_MODEL_REL___IS_WORKFLOWS_LEVEL;

	/**
     * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = KLEISLI_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
     * The operation id for the '<em>To MID Custom Print Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL = KLEISLI_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL;

	/**
     * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL = KLEISLI_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL;

	/**
     * The operation id for the '<em>Update MID Custom Label</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING = KLEISLI_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
     * The operation id for the '<em>Create Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN = KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN;

	/**
     * The operation id for the '<em>Get EMF Type Root</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___GET_EMF_TYPE_ROOT = KLEISLI_MODEL_REL___GET_EMF_TYPE_ROOT;

	/**
     * The operation id for the '<em>Create Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID = KLEISLI_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID;

	/**
     * The operation id for the '<em>Create Instance Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BINARY_KLEISLI_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN = KLEISLI_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN;

    /**
     * The operation id for the '<em>Create Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

	/**
     * The operation id for the '<em>Import Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___IMPORT_INSTANCE__STRING_MID = KLEISLI_MODEL_REL___IMPORT_INSTANCE__STRING_MID;

	/**
     * The operation id for the '<em>Import Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = KLEISLI_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
     * The operation id for the '<em>Copy Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = KLEISLI_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID;

	/**
     * The operation id for the '<em>Copy Instance And Editor</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = KLEISLI_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
     * The operation id for the '<em>Delete Instance And File</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___DELETE_INSTANCE_AND_FILE = KLEISLI_MODEL_REL___DELETE_INSTANCE_AND_FILE;

	/**
     * The operation id for the '<em>Get EMF Instance Root</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___GET_EMF_INSTANCE_ROOT = KLEISLI_MODEL_REL___GET_EMF_INSTANCE_ROOT;

	/**
     * The operation id for the '<em>Create Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID = KLEISLI_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
     * The operation id for the '<em>Delete Workflow Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___DELETE_WORKFLOW_INSTANCE = KLEISLI_MODEL_REL___DELETE_WORKFLOW_INSTANCE;

	/**
     * The operation id for the '<em>Get Metatype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___GET_METATYPE = KLEISLI_MODEL_REL___GET_METATYPE;

	/**
     * The operation id for the '<em>Get Supertype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___GET_SUPERTYPE = KLEISLI_MODEL_REL___GET_SUPERTYPE;

	/**
     * The operation id for the '<em>Get MID Container</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___GET_MID_CONTAINER = KLEISLI_MODEL_REL___GET_MID_CONTAINER;

	/**
     * The operation id for the '<em>Create Binary Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = KLEISLI_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN;

	/**
     * The operation id for the '<em>Create Instance And Endpoints</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = KLEISLI_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID;

	/**
     * The operation id for the '<em>Create Binary Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = KLEISLI_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID;

	/**
     * The operation id for the '<em>Create Binary Instance And Endpoints</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = KLEISLI_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID;

	/**
     * The operation id for the '<em>Create Workflow Instance And Endpoints</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = KLEISLI_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID;

	/**
     * The operation id for the '<em>Create Workflow Binary Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = KLEISLI_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID;

	/**
     * The operation id for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = KLEISLI_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID;

	/**
     * The operation id for the '<em>Copy Subtype</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___COPY_SUBTYPE__MODELREL = KLEISLI_MODEL_REL___COPY_SUBTYPE__MODELREL;

	/**
     * The operation id for the '<em>Open Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___OPEN_TYPE = KLEISLI_MODEL_REL___OPEN_TYPE;

	/**
     * The operation id for the '<em>Get Outline Resource Types</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES;

	/**
     * The operation id for the '<em>Delete Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___DELETE_TYPE = KLEISLI_MODEL_REL___DELETE_TYPE;

	/**
     * The operation id for the '<em>Open Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___OPEN_INSTANCE = KLEISLI_MODEL_REL___OPEN_INSTANCE;

	/**
     * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES;

	/**
     * The operation id for the '<em>Delete Instance</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___DELETE_INSTANCE = KLEISLI_MODEL_REL___DELETE_INSTANCE;

	/**
     * The operation id for the '<em>Add Model Type</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN = KLEISLI_MODEL_REL_OPERATION_COUNT + 0;

	/**
     * The number of operations of the '<em>Binary Kleisli Model Rel</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_KLEISLI_MODEL_REL_OPERATION_COUNT = KLEISLI_MODEL_REL_OPERATION_COUNT + 1;

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
     * The operation id for the '<em>Get Uri</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___GET_URI = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_URI;

	/**
     * The operation id for the '<em>Get MID Container</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___GET_MID_CONTAINER = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_MID_CONTAINER;

	/**
     * The operation id for the '<em>Is Types Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___IS_TYPES_LEVEL = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___IS_TYPES_LEVEL;

	/**
     * The operation id for the '<em>Is Instances Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL;

	/**
     * The operation id for the '<em>Is Workflows Level</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
     * The operation id for the '<em>Get Target Uri</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___GET_TARGET_URI = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_TARGET_URI;

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
     * The operation id for the '<em>Create Model Element Instance And Reference</em>' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int KLEISLI_MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING;

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
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#getEMFInstanceRoot() <em>Get EMF Instance Root</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get EMF Instance Root</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel#getEMFInstanceRoot()
     * @generated
     */
	EOperation getKleisliModel__GetEMFInstanceRoot();

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
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#copySubtype(edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Copy Subtype</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Copy Subtype</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#copySubtype(edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
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
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#deleteInstance() <em>Delete Instance</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Delete Instance</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel#deleteInstance()
     * @generated
     */
	EOperation getKleisliModelRel__DeleteInstance();

	/**
     * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.kleisli.BinaryKleisliModelRel <em>Binary Kleisli Model Rel</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Binary Kleisli Model Rel</em>'.
     * @see edu.toronto.cs.se.modelepedia.kleisli.BinaryKleisliModelRel
     * @generated
     */
	EClass getBinaryKleisliModelRel();

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
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createSubtype(java.lang.String, edu.toronto.cs.se.mmint.mid.Model, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Subtype</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Create Subtype</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createSubtype(java.lang.String, edu.toronto.cs.se.mmint.mid.Model, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
     * @generated
     */
	EOperation getKleisliModelEndpoint__CreateSubtype__String_Model_boolean_ModelRel();

	/**
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#replaceSubtype(edu.toronto.cs.se.mmint.mid.ModelEndpoint, java.lang.String, edu.toronto.cs.se.mmint.mid.Model) <em>Replace Subtype</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Replace Subtype</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#replaceSubtype(edu.toronto.cs.se.mmint.mid.ModelEndpoint, java.lang.String, edu.toronto.cs.se.mmint.mid.Model)
     * @generated
     */
	EOperation getKleisliModelEndpoint__ReplaceSubtype__ModelEndpoint_String_Model();

	/**
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#deleteType(boolean) <em>Delete Type</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Delete Type</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#deleteType(boolean)
     * @generated
     */
	EOperation getKleisliModelEndpoint__DeleteType__boolean();

	/**
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createInstance(edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Instance</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Create Instance</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#createInstance(edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
     * @generated
     */
	EOperation getKleisliModelEndpoint__CreateInstance__Model_ModelRel();

	/**
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#replaceInstance(edu.toronto.cs.se.mmint.mid.ModelEndpoint, edu.toronto.cs.se.mmint.mid.Model) <em>Replace Instance</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Replace Instance</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#replaceInstance(edu.toronto.cs.se.mmint.mid.ModelEndpoint, edu.toronto.cs.se.mmint.mid.Model)
     * @generated
     */
	EOperation getKleisliModelEndpoint__ReplaceInstance__ModelEndpoint_Model();

	/**
     * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#deleteInstance(boolean) <em>Delete Instance</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the '<em>Delete Instance</em>' operation.
     * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint#deleteInstance(boolean)
     * @generated
     */
	EOperation getKleisliModelEndpoint__DeleteInstance__boolean();

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
         * The meta object literal for the '<em><b>Get EMF Instance Root</b></em>' operation.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EOperation KLEISLI_MODEL___GET_EMF_INSTANCE_ROOT = eINSTANCE.getKleisliModel__GetEMFInstanceRoot();

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
         * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EOperation KLEISLI_MODEL_REL___DELETE_INSTANCE = eINSTANCE.getKleisliModelRel__DeleteInstance();

		/**
         * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.kleisli.impl.BinaryKleisliModelRelImpl <em>Binary Kleisli Model Rel</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see edu.toronto.cs.se.modelepedia.kleisli.impl.BinaryKleisliModelRelImpl
         * @see edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliPackageImpl#getBinaryKleisliModelRel()
         * @generated
         */
		EClass BINARY_KLEISLI_MODEL_REL = eINSTANCE.getBinaryKleisliModelRel();

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
         * The meta object literal for the '<em><b>Create Subtype</b></em>' operation.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EOperation KLEISLI_MODEL_ENDPOINT___CREATE_SUBTYPE__STRING_MODEL_BOOLEAN_MODELREL = eINSTANCE.getKleisliModelEndpoint__CreateSubtype__String_Model_boolean_ModelRel();

		/**
         * The meta object literal for the '<em><b>Replace Subtype</b></em>' operation.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EOperation KLEISLI_MODEL_ENDPOINT___REPLACE_SUBTYPE__MODELENDPOINT_STRING_MODEL = eINSTANCE.getKleisliModelEndpoint__ReplaceSubtype__ModelEndpoint_String_Model();

		/**
         * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EOperation KLEISLI_MODEL_ENDPOINT___DELETE_TYPE__BOOLEAN = eINSTANCE.getKleisliModelEndpoint__DeleteType__boolean();

		/**
         * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EOperation KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_MODELREL = eINSTANCE.getKleisliModelEndpoint__CreateInstance__Model_ModelRel();

		/**
         * The meta object literal for the '<em><b>Replace Instance</b></em>' operation.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EOperation KLEISLI_MODEL_ENDPOINT___REPLACE_INSTANCE__MODELENDPOINT_MODEL = eINSTANCE.getKleisliModelEndpoint__ReplaceInstance__ModelEndpoint_Model();

		/**
         * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EOperation KLEISLI_MODEL_ENDPOINT___DELETE_INSTANCE__BOOLEAN = eINSTANCE.getKleisliModelEndpoint__DeleteInstance__boolean();

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
