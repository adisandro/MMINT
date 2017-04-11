/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import edu.toronto.cs.se.mmint.mid.MIDPackage;

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
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory
 * @model kind="package"
 * @generated
 */
public interface RelationshipPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "relationship";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/mmint/MID/Relationship";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "relationship";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationshipPackage eINSTANCE = edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl <em>Model Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelRel()
	 * @generated
	 */
	int MODEL_REL = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryModelRelImpl <em>Binary Model Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryModelRelImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getBinaryModelRel()
	 * @generated
	 */
	int BINARY_MODEL_REL = 1;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelEndpointReferenceImpl <em>Model Endpoint Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelEndpointReferenceImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelEndpointReference()
	 * @generated
	 */
	int MODEL_ENDPOINT_REFERENCE = 4;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementReferenceImpl <em>Extendible Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementReferenceImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getExtendibleElementReference()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementEndpointReferenceImpl <em>Extendible Element Endpoint Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementEndpointReferenceImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getExtendibleElementEndpointReference()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__SUPERTYPE = MIDPackage.MODEL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__URI = MIDPackage.MODEL__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__NAME = MIDPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__LEVEL = MIDPackage.MODEL__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__METATYPE_URI = MIDPackage.MODEL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__DYNAMIC = MIDPackage.MODEL__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__CONSTRAINT = MIDPackage.MODEL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__ABSTRACT = MIDPackage.MODEL__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__ORIGIN = MIDPackage.MODEL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__FILE_EXTENSION = MIDPackage.MODEL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__EDITORS = MIDPackage.MODEL__EDITORS;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MODEL_ELEMS = MIDPackage.MODEL__MODEL_ELEMS;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__CONVERSION_OPERATORS = MIDPackage.MODEL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MODEL_ENDPOINTS = MIDPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MAPPINGS = MIDPackage.MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MODEL_ENDPOINT_REFS = MIDPackage.MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MAPPING_REFS = MIDPackage.MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL_FEATURE_COUNT = MIDPackage.MODEL_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___IS_LEVEL__MIDLEVEL = MIDPackage.MODEL___IS_LEVEL__MIDLEVEL;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___IS_TYPES_LEVEL = MIDPackage.MODEL___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.MODEL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Add Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.MODEL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___IS_INSTANCES_LEVEL = MIDPackage.MODEL___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_RUNTIME_TYPES = MIDPackage.MODEL___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT = MIDPackage.MODEL___GET_CLOSEST_TYPE_CONSTRAINT;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.MODEL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___VALIDATE_INSTANCE = MIDPackage.MODEL___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___IS_WORKFLOWS_LEVEL = MIDPackage.MODEL___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.MODEL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.MODEL___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.MODEL___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.MODEL___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN = MIDPackage.MODEL___CREATE_SUBTYPE__STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___DELETE_TYPE = MIDPackage.MODEL___DELETE_TYPE;

	/**
	 * The operation id for the '<em>Get EMF Type Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_EMF_TYPE_ROOT = MIDPackage.MODEL___GET_EMF_TYPE_ROOT;

	/**
	 * The operation id for the '<em>Open Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___OPEN_TYPE = MIDPackage.MODEL___OPEN_TYPE;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID = MIDPackage.MODEL___CREATE_INSTANCE__EOBJECT_STRING_MID;

	/**
	 * The operation id for the '<em>Create Instance Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_INSTANCE_EDITOR = MIDPackage.MODEL___CREATE_INSTANCE_EDITOR;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = MIDPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

	/**
	 * The operation id for the '<em>Import Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___IMPORT_INSTANCE__STRING_MID = MIDPackage.MODEL___IMPORT_INSTANCE__STRING_MID;

	/**
	 * The operation id for the '<em>Import Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = MIDPackage.MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
	 * The operation id for the '<em>Copy Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = MIDPackage.MODEL___COPY_INSTANCE__MODEL_STRING_MID;

	/**
	 * The operation id for the '<em>Copy Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = MIDPackage.MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___DELETE_INSTANCE = MIDPackage.MODEL___DELETE_INSTANCE;

	/**
	 * The operation id for the '<em>Delete Instance And File</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___DELETE_INSTANCE_AND_FILE = MIDPackage.MODEL___DELETE_INSTANCE_AND_FILE;

	/**
	 * The operation id for the '<em>Get EMF Instance Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_EMF_INSTANCE_ROOT = MIDPackage.MODEL___GET_EMF_INSTANCE_ROOT;

	/**
	 * The operation id for the '<em>Open Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___OPEN_INSTANCE = MIDPackage.MODEL___OPEN_INSTANCE;

	/**
	 * The operation id for the '<em>Create Workflow Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID = MIDPackage.MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
	 * The operation id for the '<em>Delete Workflow Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___DELETE_WORKFLOW_INSTANCE = MIDPackage.MODEL___DELETE_WORKFLOW_INSTANCE;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_METATYPE = MIDPackage.MODEL_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_SUPERTYPE = MIDPackage.MODEL_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_MID_CONTAINER = MIDPackage.MODEL_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Binary Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = MIDPackage.MODEL_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Copy Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___COPY_SUBTYPE__MODELREL = MIDPackage.MODEL_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Outline Resource Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = MIDPackage.MODEL_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Instance And Endpoints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = MIDPackage.MODEL_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Create Binary Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = MIDPackage.MODEL_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Create Binary Instance And Endpoints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = MIDPackage.MODEL_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = MIDPackage.MODEL_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Create Workflow Instance And Endpoints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = MIDPackage.MODEL_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Create Workflow Binary Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = MIDPackage.MODEL_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = MIDPackage.MODEL_OPERATION_COUNT + 12;

	/**
	 * The number of operations of the '<em>Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL_OPERATION_COUNT = MIDPackage.MODEL_OPERATION_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__SUPERTYPE = MODEL_REL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__URI = MODEL_REL__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__NAME = MODEL_REL__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__LEVEL = MODEL_REL__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__METATYPE_URI = MODEL_REL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__DYNAMIC = MODEL_REL__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__CONSTRAINT = MODEL_REL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__ABSTRACT = MODEL_REL__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__ORIGIN = MODEL_REL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__FILE_EXTENSION = MODEL_REL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__EDITORS = MODEL_REL__EDITORS;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MODEL_ELEMS = MODEL_REL__MODEL_ELEMS;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__CONVERSION_OPERATORS = MODEL_REL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MODEL_ENDPOINTS = MODEL_REL__MODEL_ENDPOINTS;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MAPPINGS = MODEL_REL__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MODEL_ENDPOINT_REFS = MODEL_REL__MODEL_ENDPOINT_REFS;

	/**
	 * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MAPPING_REFS = MODEL_REL__MAPPING_REFS;

	/**
	 * The feature id for the '<em><b>Source Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__SOURCE_MODEL = MODEL_REL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__TARGET_MODEL = MODEL_REL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL_FEATURE_COUNT = MODEL_REL_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___IS_LEVEL__MIDLEVEL = MODEL_REL___IS_LEVEL__MIDLEVEL;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___IS_TYPES_LEVEL = MODEL_REL___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Add Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING = MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___IS_INSTANCES_LEVEL = MODEL_REL___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_RUNTIME_TYPES = MODEL_REL___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT = MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___VALIDATE_INSTANCE = MODEL_REL___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___IS_WORKFLOWS_LEVEL = MODEL_REL___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL = MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL = MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING = MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN = MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___DELETE_TYPE = MODEL_REL___DELETE_TYPE;

	/**
	 * The operation id for the '<em>Get EMF Type Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_EMF_TYPE_ROOT = MODEL_REL___GET_EMF_TYPE_ROOT;

	/**
	 * The operation id for the '<em>Open Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___OPEN_TYPE = MODEL_REL___OPEN_TYPE;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID = MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID;

	/**
	 * The operation id for the '<em>Create Instance Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_INSTANCE_EDITOR = MODEL_REL___CREATE_INSTANCE_EDITOR;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

	/**
	 * The operation id for the '<em>Import Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___IMPORT_INSTANCE__STRING_MID = MODEL_REL___IMPORT_INSTANCE__STRING_MID;

	/**
	 * The operation id for the '<em>Import Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
	 * The operation id for the '<em>Copy Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID;

	/**
	 * The operation id for the '<em>Copy Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___DELETE_INSTANCE = MODEL_REL___DELETE_INSTANCE;

	/**
	 * The operation id for the '<em>Delete Instance And File</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___DELETE_INSTANCE_AND_FILE = MODEL_REL___DELETE_INSTANCE_AND_FILE;

	/**
	 * The operation id for the '<em>Get EMF Instance Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_EMF_INSTANCE_ROOT = MODEL_REL___GET_EMF_INSTANCE_ROOT;

	/**
	 * The operation id for the '<em>Open Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___OPEN_INSTANCE = MODEL_REL___OPEN_INSTANCE;

	/**
	 * The operation id for the '<em>Create Workflow Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID = MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
	 * The operation id for the '<em>Delete Workflow Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___DELETE_WORKFLOW_INSTANCE = MODEL_REL___DELETE_WORKFLOW_INSTANCE;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_METATYPE = MODEL_REL___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_SUPERTYPE = MODEL_REL___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_MID_CONTAINER = MODEL_REL___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Create Binary Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Copy Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___COPY_SUBTYPE__MODELREL = MODEL_REL___COPY_SUBTYPE__MODELREL;

	/**
	 * The operation id for the '<em>Get Outline Resource Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = MODEL_REL___GET_OUTLINE_RESOURCE_TYPES;

	/**
	 * The operation id for the '<em>Create Instance And Endpoints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID;

	/**
	 * The operation id for the '<em>Create Binary Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID;

	/**
	 * The operation id for the '<em>Create Binary Instance And Endpoints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID;

	/**
	 * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES;

	/**
	 * The operation id for the '<em>Create Workflow Instance And Endpoints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID;

	/**
	 * The operation id for the '<em>Create Workflow Binary Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID;

	/**
	 * The operation id for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID;

	/**
	 * The operation id for the '<em>Add Model Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN = MODEL_REL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL_OPERATION_COUNT = MODEL_REL_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF = 2;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE = 3;

	/**
	 * The number of structural features of the '<em>Extendible Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE___GET_URI = 0;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT = 1;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE___GET_MID_CONTAINER = 2;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE___IS_TYPES_LEVEL = 3;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL = 4;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL = 5;

	/**
	 * The number of operations of the '<em>Extendible Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE;

	/**
	 * The number of structural features of the '<em>Extendible Element Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_URI = EXTENDIBLE_ELEMENT_REFERENCE___GET_URI;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT_REFERENCE___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Target Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_TARGET_URI = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Extendible Element Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Model Elem Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___GET_URI = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_URI;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Get Target Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___GET_TARGET_URI = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_TARGET_URI;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept Model Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Accept Model Element Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Model Element Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Model Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementReferenceImpl <em>Model Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementReferenceImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelElementReference()
	 * @generated
	 */
	int MODEL_ELEMENT_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___GET_URI = EXTENDIBLE_ELEMENT_REFERENCE___GET_URI;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT_REFERENCE___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.MappingImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 6;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SUPERTYPE = MIDPackage.EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__URI = MIDPackage.EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = MIDPackage.EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__LEVEL = MIDPackage.EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__METATYPE_URI = MIDPackage.EXTENDIBLE_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DYNAMIC = MIDPackage.EXTENDIBLE_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CONSTRAINT = MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__MODEL_ELEM_ENDPOINTS = MIDPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__MODEL_ELEM_ENDPOINT_REFS = MIDPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = MIDPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___IS_LEVEL__MIDLEVEL = MIDPackage.EXTENDIBLE_ELEMENT___IS_LEVEL__MIDLEVEL;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___IS_TYPES_LEVEL = MIDPackage.EXTENDIBLE_ELEMENT___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Add Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.EXTENDIBLE_ELEMENT___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___IS_INSTANCES_LEVEL = MIDPackage.EXTENDIBLE_ELEMENT___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___GET_RUNTIME_TYPES = MIDPackage.EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___GET_CLOSEST_TYPE_CONSTRAINT = MIDPackage.EXTENDIBLE_ELEMENT___GET_CLOSEST_TYPE_CONSTRAINT;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_INSTANCE = MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___IS_WORKFLOWS_LEVEL = MIDPackage.EXTENDIBLE_ELEMENT___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.EXTENDIBLE_ELEMENT___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.EXTENDIBLE_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___GET_METATYPE = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___GET_SUPERTYPE = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___GET_MID_CONTAINER = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___DELETE_TYPE = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Create Instance And Reference And Endpoints And References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___DELETE_INSTANCE = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = MIDPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingImpl <em>Binary Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getBinaryMapping()
	 * @generated
	 */
	int BINARY_MAPPING = 7;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__SUPERTYPE = MAPPING__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__URI = MAPPING__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__NAME = MAPPING__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__LEVEL = MAPPING__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__METATYPE_URI = MAPPING__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__DYNAMIC = MAPPING__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__CONSTRAINT = MAPPING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__MODEL_ELEM_ENDPOINTS = MAPPING__MODEL_ELEM_ENDPOINTS;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING__MODEL_ELEM_ENDPOINT_REFS = MAPPING__MODEL_ELEM_ENDPOINT_REFS;

	/**
	 * The number of structural features of the '<em>Binary Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___IS_LEVEL__MIDLEVEL = MAPPING___IS_LEVEL__MIDLEVEL;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___IS_TYPES_LEVEL = MAPPING___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___CREATE_SUBTYPE_URI__STRING_STRING = MAPPING___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Add Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING = MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___IS_INSTANCES_LEVEL = MAPPING___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___GET_RUNTIME_TYPES = MAPPING___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___GET_CLOSEST_TYPE_CONSTRAINT = MAPPING___GET_CLOSEST_TYPE_CONSTRAINT;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___VALIDATE_INSTANCE = MAPPING___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___IS_WORKFLOWS_LEVEL = MAPPING___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___TO_MID_CUSTOM_PRINT_LABEL = MAPPING___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___TO_MID_CUSTOM_EDIT_LABEL = MAPPING___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING = MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___GET_METATYPE = MAPPING___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___GET_SUPERTYPE = MAPPING___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___GET_MID_CONTAINER = MAPPING___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Create Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL = MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL = MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___DELETE_TYPE = MAPPING___DELETE_TYPE;

	/**
	 * The operation id for the '<em>Create Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL = MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL;

	/**
	 * The operation id for the '<em>Create Instance And Reference And Endpoints And References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST = MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING___DELETE_INSTANCE = MAPPING___DELETE_INSTANCE;

	/**
	 * The number of operations of the '<em>Binary Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_OPERATION_COUNT = MAPPING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointImpl <em>Model Element Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelElementEndpoint()
	 * @generated
	 */
	int MODEL_ELEMENT_ENDPOINT = 8;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__SUPERTYPE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__URI = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__NAME = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__LEVEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__METATYPE_URI = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__DYNAMIC = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__CONSTRAINT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__LOWER_BOUND = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__UPPER_BOUND = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__TARGET = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET;

	/**
	 * The number of structural features of the '<em>Model Element Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_FEATURE_COUNT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___IS_LEVEL__MIDLEVEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___IS_LEVEL__MIDLEVEL;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___IS_TYPES_LEVEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Add Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___IS_INSTANCES_LEVEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_RUNTIME_TYPES = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_CLOSEST_TYPE_CONSTRAINT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_CLOSEST_TYPE_CONSTRAINT;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___VALIDATE_INSTANCE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___IS_WORKFLOWS_LEVEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Target Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_TARGET_URI = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_TARGET_URI;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_METATYPE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_MID_CONTAINER = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_TARGET = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___CREATE_TYPE_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE_BOOLEAN_BOOLEAN_MAPPINGREFERENCE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODELELEMENTREFERENCE_BOOLEAN_MAPPINGREFERENCE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Replace Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_STRING_MODELELEMENTREFERENCE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___DELETE_TYPE__BOOLEAN = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Create Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Replace Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>Model Element Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_OPERATION_COUNT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 11;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.MappingReferenceImpl <em>Mapping Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.MappingReferenceImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getMappingReference()
	 * @generated
	 */
	int MAPPING_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___GET_URI = EXTENDIBLE_ELEMENT_REFERENCE___GET_URI;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT_REFERENCE___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___DELETE_TYPE_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Type And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Delete Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Delete Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl <em>Binary Mapping Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getBinaryMappingReference()
	 * @generated
	 */
	int BINARY_MAPPING_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__REFERENCED_OBJECT = MAPPING_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__CONTAINED_OBJECT = MAPPING_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__SUPERTYPE_REF = MAPPING_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__MODIFIABLE = MAPPING_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

	/**
	 * The feature id for the '<em><b>Source Model Elem Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF = MAPPING_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Model Elem Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF = MAPPING_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE_FEATURE_COUNT = MAPPING_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___GET_URI = MAPPING_REFERENCE___GET_URI;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___GET_MID_CONTAINER = MAPPING_REFERENCE___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___IS_TYPES_LEVEL = MAPPING_REFERENCE___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___IS_INSTANCES_LEVEL = MAPPING_REFERENCE___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL = MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___GET_SUPERTYPE_REF = MAPPING_REFERENCE___GET_SUPERTYPE_REF;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___DELETE_TYPE_REFERENCE = MAPPING_REFERENCE___DELETE_TYPE_REFERENCE;

	/**
	 * The operation id for the '<em>Delete Type And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE = MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE;

	/**
	 * The operation id for the '<em>Delete Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE = MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE;

	/**
	 * The operation id for the '<em>Delete Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___GET_OBJECT = MAPPING_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Model Element Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN = MAPPING_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Binary Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE_OPERATION_COUNT = MAPPING_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointReferenceImpl <em>Model Element Endpoint Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointReferenceImpl
	 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelElementEndpointReference()
	 * @generated
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Model Elem Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_URI = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_URI;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Get Target Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_TARGET_URI = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_TARGET_URI;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Type And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_AND_REFERENCE__BOOLEAN = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Delete Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Model Element Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 5;

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel <em>Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Rel</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel
	 * @generated
	 */
	EClass getModelRel();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getModelEndpoints <em>Model Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Endpoints</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getModelEndpoints()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_ModelEndpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMappings()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_Mappings();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getModelEndpointRefs <em>Model Endpoint Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Endpoint Refs</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getModelEndpointRefs()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_ModelEndpointRefs();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMappingRefs <em>Mapping Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Refs</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMappingRefs()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_MappingRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMetatype()
	 * @generated
	 */
	EOperation getModelRel__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getSupertype()
	 * @generated
	 */
	EOperation getModelRel__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMIDContainer() <em>Get MID Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get MID Container</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMIDContainer()
	 * @generated
	 */
	EOperation getModelRel__GetMIDContainer();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createBinarySubtype(java.lang.String, boolean) <em>Create Binary Subtype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Binary Subtype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createBinarySubtype(java.lang.String, boolean)
	 * @generated
	 */
	EOperation getModelRel__CreateBinarySubtype__String_boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#copySubtype(edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Copy Subtype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy Subtype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#copySubtype(edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelRel__CopySubtype__ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getOutlineResourceTypes() <em>Get Outline Resource Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outline Resource Types</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getOutlineResourceTypes()
	 * @generated
	 */
	EOperation getModelRel__GetOutlineResourceTypes();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createInstanceAndEndpoints(org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.emf.common.util.EList, edu.toronto.cs.se.mmint.mid.MID) <em>Create Instance And Endpoints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Endpoints</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createInstanceAndEndpoints(org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.emf.common.util.EList, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModelRel__CreateInstanceAndEndpoints__EObject_String_EList_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createBinaryInstance(org.eclipse.emf.ecore.EObject, java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Create Binary Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Binary Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createBinaryInstance(org.eclipse.emf.ecore.EObject, java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModelRel__CreateBinaryInstance__EObject_String_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createBinaryInstanceAndEndpoints(org.eclipse.emf.ecore.EObject, java.lang.String, edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.MID) <em>Create Binary Instance And Endpoints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Binary Instance And Endpoints</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createBinaryInstanceAndEndpoints(org.eclipse.emf.ecore.EObject, java.lang.String, edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModelRel__CreateBinaryInstanceAndEndpoints__EObject_String_Model_Model_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getOutlineResourceInstances() <em>Get Outline Resource Instances</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outline Resource Instances</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getOutlineResourceInstances()
	 * @generated
	 */
	EOperation getModelRel__GetOutlineResourceInstances();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createWorkflowInstanceAndEndpoints(java.lang.String, org.eclipse.emf.common.util.EList, edu.toronto.cs.se.mmint.mid.MID) <em>Create Workflow Instance And Endpoints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Workflow Instance And Endpoints</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createWorkflowInstanceAndEndpoints(java.lang.String, org.eclipse.emf.common.util.EList, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModelRel__CreateWorkflowInstanceAndEndpoints__String_EList_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createWorkflowBinaryInstance(java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Create Workflow Binary Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Workflow Binary Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createWorkflowBinaryInstance(java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModelRel__CreateWorkflowBinaryInstance__String_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createWorkflowBinaryInstanceAndEndpoints(java.lang.String, edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.MID) <em>Create Workflow Binary Instance And Endpoints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel#createWorkflowBinaryInstanceAndEndpoints(java.lang.String, edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModelRel__CreateWorkflowBinaryInstanceAndEndpoints__String_Model_Model_MID();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel <em>Binary Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Model Rel</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel
	 * @generated
	 */
	EClass getBinaryModelRel();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#getSourceModel <em>Source Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Model</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#getSourceModel()
	 * @see #getBinaryModelRel()
	 * @generated
	 */
	EReference getBinaryModelRel_SourceModel();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#getTargetModel <em>Target Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Model</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#getTargetModel()
	 * @see #getBinaryModelRel()
	 * @generated
	 */
	EReference getBinaryModelRel_TargetModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#addModelType(edu.toronto.cs.se.mmint.mid.Model, boolean) <em>Add Model Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Model Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel#addModelType(edu.toronto.cs.se.mmint.mid.Model, boolean)
	 * @generated
	 */
	EOperation getBinaryModelRel__AddModelType__Model_boolean();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference <em>Model Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Endpoint Reference</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference
	 * @generated
	 */
	EClass getModelEndpointReference();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#getModelElemRefs <em>Model Elem Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elem Refs</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#getModelElemRefs()
	 * @see #getModelEndpointReference()
	 * @generated
	 */
	EReference getModelEndpointReference_ModelElemRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#getObject()
	 * @generated
	 */
	EOperation getModelEndpointReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getModelEndpointReference__GetSupertypeRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#acceptModelElementType(org.eclipse.emf.ecore.EObject) <em>Accept Model Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept Model Element Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#acceptModelElementType(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getModelEndpointReference__AcceptModelElementType__EObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#deleteTypeReference(boolean) <em>Delete Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#deleteTypeReference(boolean)
	 * @generated
	 */
	EOperation getModelEndpointReference__DeleteTypeReference__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#acceptModelElementInstance(org.eclipse.emf.ecore.EObject) <em>Accept Model Element Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept Model Element Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#acceptModelElementInstance(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getModelEndpointReference__AcceptModelElementInstance__EObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#createModelElementInstanceAndReference(org.eclipse.emf.ecore.EObject, java.lang.String) <em>Create Model Element Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Model Element Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#createModelElementInstanceAndReference(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * @generated
	 */
	EOperation getModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference <em>Model Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Reference</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference
	 * @generated
	 */
	EClass getModelElementReference();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Elem Endpoint Refs</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getModelElemEndpointRefs()
	 * @see #getModelElementReference()
	 * @generated
	 */
	EReference getModelElementReference_ModelElemEndpointRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getObject()
	 * @generated
	 */
	EOperation getModelElementReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getModelElementReference__GetSupertypeRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#deleteTypeReference() <em>Delete Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#deleteTypeReference()
	 * @generated
	 */
	EOperation getModelElementReference__DeleteTypeReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#deleteInstanceReference() <em>Delete Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#deleteInstanceReference()
	 * @generated
	 */
	EOperation getModelElementReference__DeleteInstanceReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#getModelElemEndpoints <em>Model Elem Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elem Endpoints</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#getModelElemEndpoints()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_ModelElemEndpoints();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Elem Endpoint Refs</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#getModelElemEndpointRefs()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_ModelElemEndpointRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#getMetatype()
	 * @generated
	 */
	EOperation getMapping__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#getSupertype()
	 * @generated
	 */
	EOperation getMapping__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#getMIDContainer() <em>Get MID Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get MID Container</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#getMIDContainer()
	 * @generated
	 */
	EOperation getMapping__GetMIDContainer();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#createTypeReference(edu.toronto.cs.se.mmint.mid.relationship.MappingReference, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#createTypeReference(edu.toronto.cs.se.mmint.mid.relationship.MappingReference, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getMapping__CreateTypeReference__MappingReference_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#createSubtypeAndReference(edu.toronto.cs.se.mmint.mid.relationship.MappingReference, java.lang.String, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#createSubtypeAndReference(edu.toronto.cs.se.mmint.mid.relationship.MappingReference, java.lang.String, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getMapping__CreateSubtypeAndReference__MappingReference_String_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#deleteType()
	 * @generated
	 */
	EOperation getMapping__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#createInstanceReference(edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#createInstanceReference(edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getMapping__CreateInstanceReference__ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#createInstanceAndReference(boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#createInstanceAndReference(boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getMapping__CreateInstanceAndReference__boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#createInstanceAndReferenceAndEndpointsAndReferences(boolean, org.eclipse.emf.common.util.EList) <em>Create Instance And Reference And Endpoints And References</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference And Endpoints And References</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#createInstanceAndReferenceAndEndpointsAndReferences(boolean, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getMapping__CreateInstanceAndReferenceAndEndpointsAndReferences__boolean_EList();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping#deleteInstance()
	 * @generated
	 */
	EOperation getMapping__DeleteInstance();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping <em>Binary Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Mapping</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping
	 * @generated
	 */
	EClass getBinaryMapping();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint <em>Model Element Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint
	 * @generated
	 */
	EClass getModelElementEndpoint();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#getSupertype()
	 * @generated
	 */
	EOperation getModelElementEndpoint__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#getMIDContainer() <em>Get MID Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get MID Container</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#getMIDContainer()
	 * @generated
	 */
	EOperation getModelElementEndpoint__GetMIDContainer();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#getTarget()
	 * @generated
	 */
	EOperation getModelElementEndpoint__GetTarget();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#getMetatype()
	 * @generated
	 */
	EOperation getModelElementEndpoint__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#createTypeReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference, edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, boolean, boolean, edu.toronto.cs.se.mmint.mid.relationship.MappingReference) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#createTypeReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference, edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, boolean, boolean, edu.toronto.cs.se.mmint.mid.relationship.MappingReference)
	 * @generated
	 */
	EOperation getModelElementEndpoint__CreateTypeReference__ModelElementEndpointReference_ModelElementReference_boolean_boolean_MappingReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#createSubtypeAndReference(java.lang.String, edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, boolean, edu.toronto.cs.se.mmint.mid.relationship.MappingReference) <em>Create Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#createSubtypeAndReference(java.lang.String, edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, boolean, edu.toronto.cs.se.mmint.mid.relationship.MappingReference)
	 * @generated
	 */
	EOperation getModelElementEndpoint__CreateSubtypeAndReference__String_ModelElementReference_boolean_MappingReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#replaceSubtypeAndReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference, java.lang.String, edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference) <em>Replace Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Replace Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#replaceSubtypeAndReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference, java.lang.String, edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference)
	 * @generated
	 */
	EOperation getModelElementEndpoint__ReplaceSubtypeAndReference__ModelElementEndpointReference_String_ModelElementReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#deleteType(boolean) <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#deleteType(boolean)
	 * @generated
	 */
	EOperation getModelElementEndpoint__DeleteType__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#createInstanceReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, edu.toronto.cs.se.mmint.mid.relationship.MappingReference) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#createInstanceReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, edu.toronto.cs.se.mmint.mid.relationship.MappingReference)
	 * @generated
	 */
	EOperation getModelElementEndpoint__CreateInstanceReference__ModelElementReference_MappingReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#createInstanceAndReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, edu.toronto.cs.se.mmint.mid.relationship.MappingReference) <em>Create Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#createInstanceAndReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, edu.toronto.cs.se.mmint.mid.relationship.MappingReference)
	 * @generated
	 */
	EOperation getModelElementEndpoint__CreateInstanceAndReference__ModelElementReference_MappingReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#replaceInstanceAndReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference, edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference) <em>Replace Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Replace Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint#replaceInstanceAndReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference, edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference)
	 * @generated
	 */
	EOperation getModelElementEndpoint__ReplaceInstanceAndReference__ModelElementEndpointReference_ModelElementReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference <em>Mapping Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Reference</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference
	 * @generated
	 */
	EClass getMappingReference();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elem Endpoint Refs</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference#getModelElemEndpointRefs()
	 * @see #getMappingReference()
	 * @generated
	 */
	EReference getMappingReference_ModelElemEndpointRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference#getObject()
	 * @generated
	 */
	EOperation getMappingReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getMappingReference__GetSupertypeRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference#deleteTypeReference() <em>Delete Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference#deleteTypeReference()
	 * @generated
	 */
	EOperation getMappingReference__DeleteTypeReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference#deleteTypeAndReference() <em>Delete Type And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference#deleteTypeAndReference()
	 * @generated
	 */
	EOperation getMappingReference__DeleteTypeAndReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference#deleteInstanceReference() <em>Delete Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference#deleteInstanceReference()
	 * @generated
	 */
	EOperation getMappingReference__DeleteInstanceReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference#deleteInstanceAndReference() <em>Delete Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference#deleteInstanceAndReference()
	 * @generated
	 */
	EOperation getMappingReference__DeleteInstanceAndReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference <em>Binary Mapping Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Mapping Reference</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference
	 * @generated
	 */
	EClass getBinaryMappingReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getSourceModelElemRef <em>Source Model Elem Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Model Elem Ref</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getSourceModelElemRef()
	 * @see #getBinaryMappingReference()
	 * @generated
	 */
	EReference getBinaryMappingReference_SourceModelElemRef();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getTargetModelElemRef <em>Target Model Elem Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Model Elem Ref</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getTargetModelElemRef()
	 * @see #getBinaryMappingReference()
	 * @generated
	 */
	EReference getBinaryMappingReference_TargetModelElemRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#getObject()
	 * @generated
	 */
	EOperation getBinaryMappingReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#addModelElementTypeReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, boolean) <em>Add Model Element Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Model Element Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference#addModelElementTypeReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, boolean)
	 * @generated
	 */
	EOperation getBinaryMappingReference__AddModelElementTypeReference__ModelElementReference_boolean();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference <em>Extendible Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element Reference</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference
	 * @generated
	 */
	EClass getExtendibleElementReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getReferencedObject <em>Referenced Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Object</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getReferencedObject()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EReference getExtendibleElementReference_ReferencedObject();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getContainedObject <em>Contained Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Object</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getContainedObject()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EReference getExtendibleElementReference_ContainedObject();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getSupertypeRef <em>Supertype Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supertype Ref</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getSupertypeRef()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EReference getExtendibleElementReference_SupertypeRef();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isModifiable <em>Modifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifiable</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isModifiable()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EAttribute getExtendibleElementReference_Modifiable();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getUri() <em>Get Uri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Uri</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getUri()
	 * @generated
	 */
	EOperation getExtendibleElementReference__GetUri();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getObject()
	 * @generated
	 */
	EOperation getExtendibleElementReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getMIDContainer() <em>Get MID Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get MID Container</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#getMIDContainer()
	 * @generated
	 */
	EOperation getExtendibleElementReference__GetMIDContainer();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isTypesLevel() <em>Is Types Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Types Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isTypesLevel()
	 * @generated
	 */
	EOperation getExtendibleElementReference__IsTypesLevel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isInstancesLevel() <em>Is Instances Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Instances Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isInstancesLevel()
	 * @generated
	 */
	EOperation getExtendibleElementReference__IsInstancesLevel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isWorkflowsLevel() <em>Is Workflows Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Workflows Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference#isWorkflowsLevel()
	 * @generated
	 */
	EOperation getExtendibleElementReference__IsWorkflowsLevel();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference <em>Extendible Element Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element Endpoint Reference</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference
	 * @generated
	 */
	EClass getExtendibleElementEndpointReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference#getObject()
	 * @generated
	 */
	EOperation getExtendibleElementEndpointReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getExtendibleElementEndpointReference__GetSupertypeRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference#getTargetUri() <em>Get Target Uri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target Uri</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference#getTargetUri()
	 * @generated
	 */
	EOperation getExtendibleElementEndpointReference__GetTargetUri();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference <em>Model Element Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Endpoint Reference</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference
	 * @generated
	 */
	EClass getModelElementEndpointReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getModelElemRef <em>Model Elem Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Elem Ref</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getModelElemRef()
	 * @see #getModelElementEndpointReference()
	 * @generated
	 */
	EReference getModelElementEndpointReference_ModelElemRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getObject()
	 * @generated
	 */
	EOperation getModelElementEndpointReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getModelElementEndpointReference__GetSupertypeRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#deleteTypeReference(boolean) <em>Delete Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#deleteTypeReference(boolean)
	 * @generated
	 */
	EOperation getModelElementEndpointReference__DeleteTypeReference__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#deleteTypeAndReference(boolean) <em>Delete Type And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#deleteTypeAndReference(boolean)
	 * @generated
	 */
	EOperation getModelElementEndpointReference__DeleteTypeAndReference__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#deleteInstanceAndReference(boolean) <em>Delete Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#deleteInstanceAndReference(boolean)
	 * @generated
	 */
	EOperation getModelElementEndpointReference__DeleteInstanceAndReference__boolean();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RelationshipFactory getRelationshipFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl <em>Model Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelRelImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelRel()
		 * @generated
		 */
		EClass MODEL_REL = eINSTANCE.getModelRel();

		/**
		 * The meta object literal for the '<em><b>Model Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__MODEL_ENDPOINTS = eINSTANCE.getModelRel_ModelEndpoints();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__MAPPINGS = eINSTANCE.getModelRel_Mappings();

		/**
		 * The meta object literal for the '<em><b>Model Endpoint Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__MODEL_ENDPOINT_REFS = eINSTANCE.getModelRel_ModelEndpointRefs();

		/**
		 * The meta object literal for the '<em><b>Mapping Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__MAPPING_REFS = eINSTANCE.getModelRel_MappingRefs();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_METATYPE = eINSTANCE.getModelRel__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_SUPERTYPE = eINSTANCE.getModelRel__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Get MID Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_MID_CONTAINER = eINSTANCE.getModelRel__GetMIDContainer();

		/**
		 * The meta object literal for the '<em><b>Create Binary Subtype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = eINSTANCE.getModelRel__CreateBinarySubtype__String_boolean();

		/**
		 * The meta object literal for the '<em><b>Copy Subtype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___COPY_SUBTYPE__MODELREL = eINSTANCE.getModelRel__CopySubtype__ModelRel();

		/**
		 * The meta object literal for the '<em><b>Get Outline Resource Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = eINSTANCE.getModelRel__GetOutlineResourceTypes();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Endpoints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = eINSTANCE.getModelRel__CreateInstanceAndEndpoints__EObject_String_EList_MID();

		/**
		 * The meta object literal for the '<em><b>Create Binary Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = eINSTANCE.getModelRel__CreateBinaryInstance__EObject_String_MID();

		/**
		 * The meta object literal for the '<em><b>Create Binary Instance And Endpoints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = eINSTANCE.getModelRel__CreateBinaryInstanceAndEndpoints__EObject_String_Model_Model_MID();

		/**
		 * The meta object literal for the '<em><b>Get Outline Resource Instances</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = eINSTANCE.getModelRel__GetOutlineResourceInstances();

		/**
		 * The meta object literal for the '<em><b>Create Workflow Instance And Endpoints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = eINSTANCE.getModelRel__CreateWorkflowInstanceAndEndpoints__String_EList_MID();

		/**
		 * The meta object literal for the '<em><b>Create Workflow Binary Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = eINSTANCE.getModelRel__CreateWorkflowBinaryInstance__String_MID();

		/**
		 * The meta object literal for the '<em><b>Create Workflow Binary Instance And Endpoints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = eINSTANCE.getModelRel__CreateWorkflowBinaryInstanceAndEndpoints__String_Model_Model_MID();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryModelRelImpl <em>Binary Model Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryModelRelImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getBinaryModelRel()
		 * @generated
		 */
		EClass BINARY_MODEL_REL = eINSTANCE.getBinaryModelRel();

		/**
		 * The meta object literal for the '<em><b>Source Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MODEL_REL__SOURCE_MODEL = eINSTANCE.getBinaryModelRel_SourceModel();

		/**
		 * The meta object literal for the '<em><b>Target Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MODEL_REL__TARGET_MODEL = eINSTANCE.getBinaryModelRel_TargetModel();

		/**
		 * The meta object literal for the '<em><b>Add Model Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN = eINSTANCE.getBinaryModelRel__AddModelType__Model_boolean();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelEndpointReferenceImpl <em>Model Endpoint Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelEndpointReferenceImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelEndpointReference()
		 * @generated
		 */
		EClass MODEL_ENDPOINT_REFERENCE = eINSTANCE.getModelEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Model Elem Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS = eINSTANCE.getModelEndpointReference_ModelElemRefs();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___GET_OBJECT = eINSTANCE.getModelEndpointReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getModelEndpointReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Accept Model Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT = eINSTANCE.getModelEndpointReference__AcceptModelElementType__EObject();

		/**
		 * The meta object literal for the '<em><b>Delete Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN = eINSTANCE.getModelEndpointReference__DeleteTypeReference__boolean();

		/**
		 * The meta object literal for the '<em><b>Accept Model Element Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT = eINSTANCE.getModelEndpointReference__AcceptModelElementInstance__EObject();

		/**
		 * The meta object literal for the '<em><b>Create Model Element Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING = eINSTANCE.getModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementReferenceImpl <em>Model Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementReferenceImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelElementReference()
		 * @generated
		 */
		EClass MODEL_ELEMENT_REFERENCE = eINSTANCE.getModelElementReference();

		/**
		 * The meta object literal for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = eINSTANCE.getModelElementReference_ModelElemEndpointRefs();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_REFERENCE___GET_OBJECT = eINSTANCE.getModelElementReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getModelElementReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Delete Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE = eINSTANCE.getModelElementReference__DeleteTypeReference();

		/**
		 * The meta object literal for the '<em><b>Delete Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE = eINSTANCE.getModelElementReference__DeleteInstanceReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.MappingImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Model Elem Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__MODEL_ELEM_ENDPOINTS = eINSTANCE.getMapping_ModelElemEndpoints();

		/**
		 * The meta object literal for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__MODEL_ELEM_ENDPOINT_REFS = eINSTANCE.getMapping_ModelElemEndpointRefs();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___GET_METATYPE = eINSTANCE.getMapping__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___GET_SUPERTYPE = eINSTANCE.getMapping__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Get MID Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___GET_MID_CONTAINER = eINSTANCE.getMapping__GetMIDContainer();

		/**
		 * The meta object literal for the '<em><b>Create Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL = eINSTANCE.getMapping__CreateTypeReference__MappingReference_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL = eINSTANCE.getMapping__CreateSubtypeAndReference__MappingReference_String_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___DELETE_TYPE = eINSTANCE.getMapping__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Create Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL = eINSTANCE.getMapping__CreateInstanceReference__ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = eINSTANCE.getMapping__CreateInstanceAndReference__boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Reference And Endpoints And References</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST = eINSTANCE.getMapping__CreateInstanceAndReferenceAndEndpointsAndReferences__boolean_EList();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___DELETE_INSTANCE = eINSTANCE.getMapping__DeleteInstance();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingImpl <em>Binary Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getBinaryMapping()
		 * @generated
		 */
		EClass BINARY_MAPPING = eINSTANCE.getBinaryMapping();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointImpl <em>Model Element Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelElementEndpoint()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ENDPOINT = eINSTANCE.getModelElementEndpoint();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE = eINSTANCE.getModelElementEndpoint__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Get MID Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___GET_MID_CONTAINER = eINSTANCE.getModelElementEndpoint__GetMIDContainer();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___GET_TARGET = eINSTANCE.getModelElementEndpoint__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___GET_METATYPE = eINSTANCE.getModelElementEndpoint__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Create Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___CREATE_TYPE_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE_BOOLEAN_BOOLEAN_MAPPINGREFERENCE = eINSTANCE.getModelElementEndpoint__CreateTypeReference__ModelElementEndpointReference_ModelElementReference_boolean_boolean_MappingReference();

		/**
		 * The meta object literal for the '<em><b>Create Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODELELEMENTREFERENCE_BOOLEAN_MAPPINGREFERENCE = eINSTANCE.getModelElementEndpoint__CreateSubtypeAndReference__String_ModelElementReference_boolean_MappingReference();

		/**
		 * The meta object literal for the '<em><b>Replace Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_STRING_MODELELEMENTREFERENCE = eINSTANCE.getModelElementEndpoint__ReplaceSubtypeAndReference__ModelElementEndpointReference_String_ModelElementReference();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___DELETE_TYPE__BOOLEAN = eINSTANCE.getModelElementEndpoint__DeleteType__boolean();

		/**
		 * The meta object literal for the '<em><b>Create Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE = eINSTANCE.getModelElementEndpoint__CreateInstanceReference__ModelElementReference_MappingReference();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE = eINSTANCE.getModelElementEndpoint__CreateInstanceAndReference__ModelElementReference_MappingReference();

		/**
		 * The meta object literal for the '<em><b>Replace Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE = eINSTANCE.getModelElementEndpoint__ReplaceInstanceAndReference__ModelElementEndpointReference_ModelElementReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.MappingReferenceImpl <em>Mapping Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.MappingReferenceImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getMappingReference()
		 * @generated
		 */
		EClass MAPPING_REFERENCE = eINSTANCE.getMappingReference();

		/**
		 * The meta object literal for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = eINSTANCE.getMappingReference_ModelElemEndpointRefs();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_REFERENCE___GET_OBJECT = eINSTANCE.getMappingReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getMappingReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Delete Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_REFERENCE___DELETE_TYPE_REFERENCE = eINSTANCE.getMappingReference__DeleteTypeReference();

		/**
		 * The meta object literal for the '<em><b>Delete Type And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE = eINSTANCE.getMappingReference__DeleteTypeAndReference();

		/**
		 * The meta object literal for the '<em><b>Delete Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE = eINSTANCE.getMappingReference__DeleteInstanceReference();

		/**
		 * The meta object literal for the '<em><b>Delete Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = eINSTANCE.getMappingReference__DeleteInstanceAndReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl <em>Binary Mapping Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingReferenceImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getBinaryMappingReference()
		 * @generated
		 */
		EClass BINARY_MAPPING_REFERENCE = eINSTANCE.getBinaryMappingReference();

		/**
		 * The meta object literal for the '<em><b>Source Model Elem Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF = eINSTANCE.getBinaryMappingReference_SourceModelElemRef();

		/**
		 * The meta object literal for the '<em><b>Target Model Elem Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF = eINSTANCE.getBinaryMappingReference_TargetModelElemRef();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_MAPPING_REFERENCE___GET_OBJECT = eINSTANCE.getBinaryMappingReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Add Model Element Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN = eINSTANCE.getBinaryMappingReference__AddModelElementTypeReference__ModelElementReference_boolean();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementReferenceImpl <em>Extendible Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementReferenceImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getExtendibleElementReference()
		 * @generated
		 */
		EClass EXTENDIBLE_ELEMENT_REFERENCE = eINSTANCE.getExtendibleElementReference();

		/**
		 * The meta object literal for the '<em><b>Referenced Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT = eINSTANCE.getExtendibleElementReference_ReferencedObject();

		/**
		 * The meta object literal for the '<em><b>Contained Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT = eINSTANCE.getExtendibleElementReference_ContainedObject();

		/**
		 * The meta object literal for the '<em><b>Supertype Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF = eINSTANCE.getExtendibleElementReference_SupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Modifiable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE = eINSTANCE.getExtendibleElementReference_Modifiable();

		/**
		 * The meta object literal for the '<em><b>Get Uri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_REFERENCE___GET_URI = eINSTANCE.getExtendibleElementReference__GetUri();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT = eINSTANCE.getExtendibleElementReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get MID Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_REFERENCE___GET_MID_CONTAINER = eINSTANCE.getExtendibleElementReference__GetMIDContainer();

		/**
		 * The meta object literal for the '<em><b>Is Types Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_REFERENCE___IS_TYPES_LEVEL = eINSTANCE.getExtendibleElementReference__IsTypesLevel();

		/**
		 * The meta object literal for the '<em><b>Is Instances Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL = eINSTANCE.getExtendibleElementReference__IsInstancesLevel();

		/**
		 * The meta object literal for the '<em><b>Is Workflows Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL = eINSTANCE.getExtendibleElementReference__IsWorkflowsLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementEndpointReferenceImpl <em>Extendible Element Endpoint Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ExtendibleElementEndpointReferenceImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getExtendibleElementEndpointReference()
		 * @generated
		 */
		EClass EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE = eINSTANCE.getExtendibleElementEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT = eINSTANCE.getExtendibleElementEndpointReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getExtendibleElementEndpointReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Get Target Uri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_TARGET_URI = eINSTANCE.getExtendibleElementEndpointReference__GetTargetUri();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointReferenceImpl <em>Model Element Endpoint Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementEndpointReferenceImpl
		 * @see edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl#getModelElementEndpointReference()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ENDPOINT_REFERENCE = eINSTANCE.getModelElementEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Model Elem Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF = eINSTANCE.getModelElementEndpointReference_ModelElemRef();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT = eINSTANCE.getModelElementEndpointReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getModelElementEndpointReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Delete Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN = eINSTANCE.getModelElementEndpointReference__DeleteTypeReference__boolean();

		/**
		 * The meta object literal for the '<em><b>Delete Type And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_AND_REFERENCE__BOOLEAN = eINSTANCE.getModelElementEndpointReference__DeleteTypeAndReference__boolean();

		/**
		 * The meta object literal for the '<em><b>Delete Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN = eINSTANCE.getModelElementEndpointReference__DeleteInstanceAndReference__boolean();

	}

} //RelationshipPackage
