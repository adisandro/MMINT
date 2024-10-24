/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.mid.productline;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
 * @see edu.toronto.cs.se.mmint.mid.productline.PLMIDFactory
 * @model kind="package"
 * @generated
 */
public interface PLMIDPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "productline";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "rel://edu.toronto.cs.se.mmint.mid.productline.PLModelRel";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mid.productline";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PLMIDPackage eINSTANCE = edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLModelRelImpl <em>PL Model Rel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLModelRelImpl
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLModelRel()
   * @generated
   */
  int PL_MODEL_REL = 0;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__SUPERTYPE = RelationshipPackage.MODEL_REL__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__URI = RelationshipPackage.MODEL_REL__URI;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__NAME = RelationshipPackage.MODEL_REL__NAME;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__LEVEL = RelationshipPackage.MODEL_REL__LEVEL;

  /**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__METATYPE_URI = RelationshipPackage.MODEL_REL__METATYPE_URI;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__DYNAMIC = RelationshipPackage.MODEL_REL__DYNAMIC;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__CONSTRAINT = RelationshipPackage.MODEL_REL__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__ABSTRACT = RelationshipPackage.MODEL_REL__ABSTRACT;

  /**
   * The feature id for the '<em><b>Origin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__ORIGIN = RelationshipPackage.MODEL_REL__ORIGIN;

  /**
   * The feature id for the '<em><b>File Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__FILE_EXTENSION = RelationshipPackage.MODEL_REL__FILE_EXTENSION;

  /**
   * The feature id for the '<em><b>Editors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__EDITORS = RelationshipPackage.MODEL_REL__EDITORS;

  /**
   * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MODEL_ELEMS = RelationshipPackage.MODEL_REL__MODEL_ELEMS;

  /**
   * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__CONVERSION_OPERATORS = RelationshipPackage.MODEL_REL__CONVERSION_OPERATORS;

  /**
   * The feature id for the '<em><b>EMF Instance Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__EMF_INSTANCE_RESOURCE = RelationshipPackage.MODEL_REL__EMF_INSTANCE_RESOURCE;

  /**
   * The feature id for the '<em><b>EMF Instance Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__EMF_INSTANCE_ROOT = RelationshipPackage.MODEL_REL__EMF_INSTANCE_ROOT;

  /**
   * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MODEL_ENDPOINTS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MAPPINGS = RelationshipPackage.MODEL_REL__MAPPINGS;

  /**
   * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MODEL_ENDPOINT_REFS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MAPPING_REFS = RelationshipPackage.MODEL_REL__MAPPING_REFS;

  /**
   * The number of structural features of the '<em>PL Model Rel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL_FEATURE_COUNT = RelationshipPackage.MODEL_REL_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___IS_LEVEL__MIDLEVEL = RelationshipPackage.MODEL_REL___IS_LEVEL__MIDLEVEL;

  /**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___IS_TYPES_LEVEL = RelationshipPackage.MODEL_REL___IS_TYPES_LEVEL;

  /**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

  /**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING;

  /**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___IS_INSTANCES_LEVEL = RelationshipPackage.MODEL_REL___IS_INSTANCES_LEVEL;

  /**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___GET_RUNTIME_TYPES = RelationshipPackage.MODEL_REL___GET_RUNTIME_TYPES;

  /**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT;

  /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

  /**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___VALIDATE_INSTANCE = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE;

  /**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

  /**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___IS_WORKFLOWS_LEVEL = RelationshipPackage.MODEL_REL___IS_WORKFLOWS_LEVEL;

  /**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

  /**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL;

  /**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL;

  /**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING;

  /**
   * The operation id for the '<em>Create Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN;

  /**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___DELETE_TYPE = RelationshipPackage.MODEL_REL___DELETE_TYPE;

  /**
   * The operation id for the '<em>Get EMF Type Root</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___GET_EMF_TYPE_ROOT = RelationshipPackage.MODEL_REL___GET_EMF_TYPE_ROOT;

  /**
   * The operation id for the '<em>Open Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___OPEN_TYPE = RelationshipPackage.MODEL_REL___OPEN_TYPE;

  /**
   * The operation id for the '<em>Create Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID;

  /**
   * The operation id for the '<em>Create Instance Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN;

  /**
   * The operation id for the '<em>Create Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

  /**
   * The operation id for the '<em>Import Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___IMPORT_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___IMPORT_INSTANCE__STRING_MID;

  /**
   * The operation id for the '<em>Import Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = RelationshipPackage.MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

  /**
   * The operation id for the '<em>Copy Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = RelationshipPackage.MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID;

  /**
   * The operation id for the '<em>Copy Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = RelationshipPackage.MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

  /**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___DELETE_INSTANCE = RelationshipPackage.MODEL_REL___DELETE_INSTANCE;

  /**
   * The operation id for the '<em>Delete Instance And File</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___DELETE_INSTANCE_AND_FILE = RelationshipPackage.MODEL_REL___DELETE_INSTANCE_AND_FILE;

  /**
   * The operation id for the '<em>Open Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___OPEN_INSTANCE = RelationshipPackage.MODEL_REL___OPEN_INSTANCE;

  /**
   * The operation id for the '<em>Create Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

  /**
   * The operation id for the '<em>Delete Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___DELETE_WORKFLOW_INSTANCE = RelationshipPackage.MODEL_REL___DELETE_WORKFLOW_INSTANCE;

  /**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___GET_METATYPE = RelationshipPackage.MODEL_REL___GET_METATYPE;

  /**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___GET_SUPERTYPE = RelationshipPackage.MODEL_REL___GET_SUPERTYPE;

  /**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___GET_MID_CONTAINER = RelationshipPackage.MODEL_REL___GET_MID_CONTAINER;

  /**
   * The operation id for the '<em>Create Binary Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN;

  /**
   * The operation id for the '<em>Copy Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___COPY_SUBTYPE__MODELREL = RelationshipPackage.MODEL_REL___COPY_SUBTYPE__MODELREL;

  /**
   * The operation id for the '<em>Get Outline Resource Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = RelationshipPackage.MODEL_REL___GET_OUTLINE_RESOURCE_TYPES;

  /**
   * The operation id for the '<em>Create Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID;

  /**
   * The operation id for the '<em>Create Binary Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID;

  /**
   * The operation id for the '<em>Create Binary Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID;

  /**
   * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = RelationshipPackage.MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES;

  /**
   * The operation id for the '<em>Create Workflow Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID;

  /**
   * The operation id for the '<em>Create Workflow Binary Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID;

  /**
   * The operation id for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID;

  /**
   * The number of operations of the '<em>PL Model Rel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL_OPERATION_COUNT = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryModelRelImpl <em>PL Binary Model Rel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryModelRelImpl
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLBinaryModelRel()
   * @generated
   */
  int PL_BINARY_MODEL_REL = 1;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__SUPERTYPE = RelationshipPackage.BINARY_MODEL_REL__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__URI = RelationshipPackage.BINARY_MODEL_REL__URI;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__NAME = RelationshipPackage.BINARY_MODEL_REL__NAME;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__LEVEL = RelationshipPackage.BINARY_MODEL_REL__LEVEL;

  /**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__METATYPE_URI = RelationshipPackage.BINARY_MODEL_REL__METATYPE_URI;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__DYNAMIC = RelationshipPackage.BINARY_MODEL_REL__DYNAMIC;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__CONSTRAINT = RelationshipPackage.BINARY_MODEL_REL__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__ABSTRACT = RelationshipPackage.BINARY_MODEL_REL__ABSTRACT;

  /**
   * The feature id for the '<em><b>Origin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__ORIGIN = RelationshipPackage.BINARY_MODEL_REL__ORIGIN;

  /**
   * The feature id for the '<em><b>File Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__FILE_EXTENSION = RelationshipPackage.BINARY_MODEL_REL__FILE_EXTENSION;

  /**
   * The feature id for the '<em><b>Editors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__EDITORS = RelationshipPackage.BINARY_MODEL_REL__EDITORS;

  /**
   * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MODEL_ELEMS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ELEMS;

  /**
   * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__CONVERSION_OPERATORS = RelationshipPackage.BINARY_MODEL_REL__CONVERSION_OPERATORS;

  /**
   * The feature id for the '<em><b>EMF Instance Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__EMF_INSTANCE_RESOURCE = RelationshipPackage.BINARY_MODEL_REL__EMF_INSTANCE_RESOURCE;

  /**
   * The feature id for the '<em><b>EMF Instance Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__EMF_INSTANCE_ROOT = RelationshipPackage.BINARY_MODEL_REL__EMF_INSTANCE_ROOT;

  /**
   * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MODEL_ENDPOINTS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ENDPOINTS;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MAPPINGS = RelationshipPackage.BINARY_MODEL_REL__MAPPINGS;

  /**
   * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MODEL_ENDPOINT_REFS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MAPPING_REFS = RelationshipPackage.BINARY_MODEL_REL__MAPPING_REFS;

  /**
   * The feature id for the '<em><b>Source Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__SOURCE_MODEL = RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL;

  /**
   * The feature id for the '<em><b>Target Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__TARGET_MODEL = RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL;

  /**
   * The number of structural features of the '<em>PL Binary Model Rel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL_FEATURE_COUNT = RelationshipPackage.BINARY_MODEL_REL_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___IS_LEVEL__MIDLEVEL = RelationshipPackage.BINARY_MODEL_REL___IS_LEVEL__MIDLEVEL;

  /**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___IS_TYPES_LEVEL = RelationshipPackage.BINARY_MODEL_REL___IS_TYPES_LEVEL;

  /**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.BINARY_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

  /**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.BINARY_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING;

  /**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___IS_INSTANCES_LEVEL = RelationshipPackage.BINARY_MODEL_REL___IS_INSTANCES_LEVEL;

  /**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___GET_RUNTIME_TYPES = RelationshipPackage.BINARY_MODEL_REL___GET_RUNTIME_TYPES;

  /**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.BINARY_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT;

  /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.BINARY_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

  /**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___VALIDATE_INSTANCE = RelationshipPackage.BINARY_MODEL_REL___VALIDATE_INSTANCE;

  /**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.BINARY_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

  /**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___IS_WORKFLOWS_LEVEL = RelationshipPackage.BINARY_MODEL_REL___IS_WORKFLOWS_LEVEL;

  /**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.BINARY_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

  /**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.BINARY_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL;

  /**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.BINARY_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL;

  /**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.BINARY_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING;

  /**
   * The operation id for the '<em>Create Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.BINARY_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN;

  /**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___DELETE_TYPE = RelationshipPackage.BINARY_MODEL_REL___DELETE_TYPE;

  /**
   * The operation id for the '<em>Get EMF Type Root</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___GET_EMF_TYPE_ROOT = RelationshipPackage.BINARY_MODEL_REL___GET_EMF_TYPE_ROOT;

  /**
   * The operation id for the '<em>Open Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___OPEN_TYPE = RelationshipPackage.BINARY_MODEL_REL___OPEN_TYPE;

  /**
   * The operation id for the '<em>Create Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID;

  /**
   * The operation id for the '<em>Create Instance Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN = RelationshipPackage.BINARY_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN;

  /**
   * The operation id for the '<em>Create Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

  /**
   * The operation id for the '<em>Import Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___IMPORT_INSTANCE__STRING_MID = RelationshipPackage.BINARY_MODEL_REL___IMPORT_INSTANCE__STRING_MID;

  /**
   * The operation id for the '<em>Import Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = RelationshipPackage.BINARY_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

  /**
   * The operation id for the '<em>Copy Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = RelationshipPackage.BINARY_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID;

  /**
   * The operation id for the '<em>Copy Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = RelationshipPackage.BINARY_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

  /**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___DELETE_INSTANCE = RelationshipPackage.BINARY_MODEL_REL___DELETE_INSTANCE;

  /**
   * The operation id for the '<em>Delete Instance And File</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___DELETE_INSTANCE_AND_FILE = RelationshipPackage.BINARY_MODEL_REL___DELETE_INSTANCE_AND_FILE;

  /**
   * The operation id for the '<em>Open Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___OPEN_INSTANCE = RelationshipPackage.BINARY_MODEL_REL___OPEN_INSTANCE;

  /**
   * The operation id for the '<em>Create Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

  /**
   * The operation id for the '<em>Delete Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___DELETE_WORKFLOW_INSTANCE = RelationshipPackage.BINARY_MODEL_REL___DELETE_WORKFLOW_INSTANCE;

  /**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___GET_METATYPE = RelationshipPackage.BINARY_MODEL_REL___GET_METATYPE;

  /**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___GET_SUPERTYPE = RelationshipPackage.BINARY_MODEL_REL___GET_SUPERTYPE;

  /**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___GET_MID_CONTAINER = RelationshipPackage.BINARY_MODEL_REL___GET_MID_CONTAINER;

  /**
   * The operation id for the '<em>Create Binary Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.BINARY_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN;

  /**
   * The operation id for the '<em>Copy Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___COPY_SUBTYPE__MODELREL = RelationshipPackage.BINARY_MODEL_REL___COPY_SUBTYPE__MODELREL;

  /**
   * The operation id for the '<em>Get Outline Resource Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = RelationshipPackage.BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES;

  /**
   * The operation id for the '<em>Create Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID;

  /**
   * The operation id for the '<em>Create Binary Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID;

  /**
   * The operation id for the '<em>Create Binary Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID;

  /**
   * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = RelationshipPackage.BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES;

  /**
   * The operation id for the '<em>Create Workflow Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID;

  /**
   * The operation id for the '<em>Create Workflow Binary Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID;

  /**
   * The operation id for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID;

  /**
   * The operation id for the '<em>Add Model Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN = RelationshipPackage.BINARY_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN;

  /**
   * The number of operations of the '<em>PL Binary Model Rel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL_OPERATION_COUNT = RelationshipPackage.BINARY_MODEL_REL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingImpl <em>PL Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingImpl
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLMapping()
   * @generated
   */
  int PL_MAPPING = 2;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__SUPERTYPE = RelationshipPackage.MAPPING__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__URI = RelationshipPackage.MAPPING__URI;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__NAME = RelationshipPackage.MAPPING__NAME;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__LEVEL = RelationshipPackage.MAPPING__LEVEL;

  /**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__METATYPE_URI = RelationshipPackage.MAPPING__METATYPE_URI;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__DYNAMIC = RelationshipPackage.MAPPING__DYNAMIC;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__CONSTRAINT = RelationshipPackage.MAPPING__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__MODEL_ELEM_ENDPOINTS = RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS;

  /**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__PRESENCE_CONDITION = RelationshipPackage.MAPPING_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PL Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_FEATURE_COUNT = RelationshipPackage.MAPPING_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___IS_LEVEL__MIDLEVEL = RelationshipPackage.MAPPING___IS_LEVEL__MIDLEVEL;

  /**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___IS_TYPES_LEVEL = RelationshipPackage.MAPPING___IS_TYPES_LEVEL;

  /**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.MAPPING___CREATE_SUBTYPE_URI__STRING_STRING;

  /**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING;

  /**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___IS_INSTANCES_LEVEL = RelationshipPackage.MAPPING___IS_INSTANCES_LEVEL;

  /**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___GET_RUNTIME_TYPES = RelationshipPackage.MAPPING___GET_RUNTIME_TYPES;

  /**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.MAPPING___GET_CLOSEST_TYPE_CONSTRAINT;

  /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

  /**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___VALIDATE_INSTANCE = RelationshipPackage.MAPPING___VALIDATE_INSTANCE;

  /**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

  /**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___IS_WORKFLOWS_LEVEL = RelationshipPackage.MAPPING___IS_WORKFLOWS_LEVEL;

  /**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

  /**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___GET_METATYPE = RelationshipPackage.MAPPING___GET_METATYPE;

  /**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___GET_SUPERTYPE = RelationshipPackage.MAPPING___GET_SUPERTYPE;

  /**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___GET_MID_CONTAINER = RelationshipPackage.MAPPING___GET_MID_CONTAINER;

  /**
   * The operation id for the '<em>Create Type Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL = RelationshipPackage.MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL;

  /**
   * The operation id for the '<em>Create Subtype And Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL = RelationshipPackage.MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL;

  /**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___DELETE_TYPE = RelationshipPackage.MAPPING___DELETE_TYPE;

  /**
   * The operation id for the '<em>Create Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL = RelationshipPackage.MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL;

  /**
   * The operation id for the '<em>Create Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = RelationshipPackage.MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL;

  /**
   * The operation id for the '<em>Create Instance And Reference And Endpoints And References</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST = RelationshipPackage.MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST;

  /**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___DELETE_INSTANCE = RelationshipPackage.MAPPING___DELETE_INSTANCE;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___GET_PRODUCT_LINE = RelationshipPackage.MAPPING_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___IS_ALWAYS_PRESENT = RelationshipPackage.MAPPING_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = RelationshipPackage.MAPPING_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.MAPPING_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.MAPPING_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.MAPPING_OPERATION_COUNT + 5;

  /**
   * The number of operations of the '<em>PL Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_OPERATION_COUNT = RelationshipPackage.MAPPING_OPERATION_COUNT + 6;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingImpl <em>PL Binary Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingImpl
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLBinaryMapping()
   * @generated
   */
  int PL_BINARY_MAPPING = 3;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__SUPERTYPE = RelationshipPackage.BINARY_MAPPING__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__URI = RelationshipPackage.BINARY_MAPPING__URI;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__NAME = RelationshipPackage.BINARY_MAPPING__NAME;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__LEVEL = RelationshipPackage.BINARY_MAPPING__LEVEL;

  /**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__METATYPE_URI = RelationshipPackage.BINARY_MAPPING__METATYPE_URI;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__DYNAMIC = RelationshipPackage.BINARY_MAPPING__DYNAMIC;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__CONSTRAINT = RelationshipPackage.BINARY_MAPPING__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__MODEL_ELEM_ENDPOINTS = RelationshipPackage.BINARY_MAPPING__MODEL_ELEM_ENDPOINTS;

  /**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.BINARY_MAPPING__MODEL_ELEM_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__PRESENCE_CONDITION = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PL Binary Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_FEATURE_COUNT = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___IS_LEVEL__MIDLEVEL = RelationshipPackage.BINARY_MAPPING___IS_LEVEL__MIDLEVEL;

  /**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___IS_TYPES_LEVEL = RelationshipPackage.BINARY_MAPPING___IS_TYPES_LEVEL;

  /**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.BINARY_MAPPING___CREATE_SUBTYPE_URI__STRING_STRING;

  /**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.BINARY_MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING;

  /**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___IS_INSTANCES_LEVEL = RelationshipPackage.BINARY_MAPPING___IS_INSTANCES_LEVEL;

  /**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___GET_RUNTIME_TYPES = RelationshipPackage.BINARY_MAPPING___GET_RUNTIME_TYPES;

  /**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.BINARY_MAPPING___GET_CLOSEST_TYPE_CONSTRAINT;

  /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.BINARY_MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

  /**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___VALIDATE_INSTANCE = RelationshipPackage.BINARY_MAPPING___VALIDATE_INSTANCE;

  /**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.BINARY_MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

  /**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___IS_WORKFLOWS_LEVEL = RelationshipPackage.BINARY_MAPPING___IS_WORKFLOWS_LEVEL;

  /**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.BINARY_MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

  /**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___GET_METATYPE = RelationshipPackage.BINARY_MAPPING___GET_METATYPE;

  /**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___GET_SUPERTYPE = RelationshipPackage.BINARY_MAPPING___GET_SUPERTYPE;

  /**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___GET_MID_CONTAINER = RelationshipPackage.BINARY_MAPPING___GET_MID_CONTAINER;

  /**
   * The operation id for the '<em>Create Type Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL = RelationshipPackage.BINARY_MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL;

  /**
   * The operation id for the '<em>Create Subtype And Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL = RelationshipPackage.BINARY_MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL;

  /**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___DELETE_TYPE = RelationshipPackage.BINARY_MAPPING___DELETE_TYPE;

  /**
   * The operation id for the '<em>Create Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL = RelationshipPackage.BINARY_MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL;

  /**
   * The operation id for the '<em>Create Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = RelationshipPackage.BINARY_MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL;

  /**
   * The operation id for the '<em>Create Instance And Reference And Endpoints And References</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST = RelationshipPackage.BINARY_MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST;

  /**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___DELETE_INSTANCE = RelationshipPackage.BINARY_MAPPING___DELETE_INSTANCE;

  /**
   * The operation id for the '<em>Get Product Line</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___GET_PRODUCT_LINE = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Is Always Present</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___IS_ALWAYS_PRESENT = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Presence Condition Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___GET_PRESENCE_CONDITION_LABEL__BOOLEAN = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT
    + 2;

  /**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 5;

  /**
   * The number of operations of the '<em>PL Binary Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_OPERATION_COUNT = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 6;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingReferenceImpl <em>PL Mapping Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingReferenceImpl
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLMappingReference()
   * @generated
   */
  int PL_MAPPING_REFERENCE = 4;

  /**
   * The feature id for the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.MAPPING_REFERENCE__REFERENCED_OBJECT;

  /**
   * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.MAPPING_REFERENCE__CONTAINED_OBJECT;

  /**
   * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__SUPERTYPE_REF = RelationshipPackage.MAPPING_REFERENCE__SUPERTYPE_REF;

  /**
   * The feature id for the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__MODIFIABLE = RelationshipPackage.MAPPING_REFERENCE__MODIFIABLE;

  /**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

  /**
   * The number of structural features of the '<em>PL Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE_FEATURE_COUNT = RelationshipPackage.MAPPING_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Uri</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___GET_URI = RelationshipPackage.MAPPING_REFERENCE___GET_URI;

  /**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___GET_MID_CONTAINER = RelationshipPackage.MAPPING_REFERENCE___GET_MID_CONTAINER;

  /**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___IS_TYPES_LEVEL = RelationshipPackage.MAPPING_REFERENCE___IS_TYPES_LEVEL;

  /**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___IS_INSTANCES_LEVEL = RelationshipPackage.MAPPING_REFERENCE___IS_INSTANCES_LEVEL;

  /**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL = RelationshipPackage.MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL;

  /**
   * The operation id for the '<em>Get Supertype Ref</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___GET_SUPERTYPE_REF = RelationshipPackage.MAPPING_REFERENCE___GET_SUPERTYPE_REF;

  /**
   * The operation id for the '<em>Delete Type Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___DELETE_TYPE_REFERENCE = RelationshipPackage.MAPPING_REFERENCE___DELETE_TYPE_REFERENCE;

  /**
   * The operation id for the '<em>Delete Type And Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE = RelationshipPackage.MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE;

  /**
   * The operation id for the '<em>Delete Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE = RelationshipPackage.MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE;

  /**
   * The operation id for the '<em>Delete Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = RelationshipPackage.MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE;

  /**
   * The operation id for the '<em>Get Object</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE___GET_OBJECT = RelationshipPackage.MAPPING_REFERENCE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>PL Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE_OPERATION_COUNT = RelationshipPackage.MAPPING_REFERENCE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingReferenceImpl <em>PL Binary Mapping Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingReferenceImpl
   * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLBinaryMappingReference()
   * @generated
   */
  int PL_BINARY_MAPPING_REFERENCE = 5;

  /**
   * The feature id for the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.BINARY_MAPPING_REFERENCE__REFERENCED_OBJECT;

  /**
   * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.BINARY_MAPPING_REFERENCE__CONTAINED_OBJECT;

  /**
   * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__SUPERTYPE_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__SUPERTYPE_REF;

  /**
   * The feature id for the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__MODIFIABLE = RelationshipPackage.BINARY_MAPPING_REFERENCE__MODIFIABLE;

  /**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.BINARY_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Source Model Elem Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF;

  /**
   * The feature id for the '<em><b>Target Model Elem Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF;

  /**
   * The number of structural features of the '<em>PL Binary Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE_FEATURE_COUNT = RelationshipPackage.BINARY_MAPPING_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Uri</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___GET_URI = RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_URI;

  /**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___GET_MID_CONTAINER = RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_MID_CONTAINER;

  /**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___IS_TYPES_LEVEL = RelationshipPackage.BINARY_MAPPING_REFERENCE___IS_TYPES_LEVEL;

  /**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___IS_INSTANCES_LEVEL = RelationshipPackage.BINARY_MAPPING_REFERENCE___IS_INSTANCES_LEVEL;

  /**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL = RelationshipPackage.BINARY_MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL;

  /**
   * The operation id for the '<em>Get Supertype Ref</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___GET_SUPERTYPE_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_SUPERTYPE_REF;

  /**
   * The operation id for the '<em>Delete Type Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___DELETE_TYPE_REFERENCE = RelationshipPackage.BINARY_MAPPING_REFERENCE___DELETE_TYPE_REFERENCE;

  /**
   * The operation id for the '<em>Delete Type And Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE = RelationshipPackage.BINARY_MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE;

  /**
   * The operation id for the '<em>Delete Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE = RelationshipPackage.BINARY_MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE;

  /**
   * The operation id for the '<em>Delete Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = RelationshipPackage.BINARY_MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE;

  /**
   * The operation id for the '<em>Add Model Element Type Reference</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN = RelationshipPackage.BINARY_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN;

  /**
   * The operation id for the '<em>Get Object</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE___GET_OBJECT = RelationshipPackage.BINARY_MAPPING_REFERENCE_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>PL Binary Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE_OPERATION_COUNT = RelationshipPackage.BINARY_MAPPING_REFERENCE_OPERATION_COUNT + 2;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.productline.PLModelRel <em>PL Model Rel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Model Rel</em>'.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLModelRel
   * @generated
   */
  EClass getPLModelRel();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.productline.PLBinaryModelRel <em>PL Binary Model Rel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Binary Model Rel</em>'.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLBinaryModelRel
   * @generated
   */
  EClass getPLBinaryModelRel();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.productline.PLMapping <em>PL Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Mapping</em>'.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMapping
   * @generated
   */
  EClass getPLMapping();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.productline.PLMapping#toMIDCustomPrintLabel() <em>To MID Custom Print Label</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>To MID Custom Print Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMapping#toMIDCustomPrintLabel()
   * @generated
   */
  EOperation getPLMapping__ToMIDCustomPrintLabel();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.productline.PLMapping#toMIDCustomEditLabel() <em>To MID Custom Edit Label</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>To MID Custom Edit Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMapping#toMIDCustomEditLabel()
   * @generated
   */
  EOperation getPLMapping__ToMIDCustomEditLabel();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.productline.PLMapping#updateMIDCustomLabel(java.lang.String) <em>Update MID Custom Label</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Update MID Custom Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMapping#updateMIDCustomLabel(java.lang.String)
   * @generated
   */
  EOperation getPLMapping__UpdateMIDCustomLabel__String();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping <em>PL Binary Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Binary Mapping</em>'.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping
   * @generated
   */
  EClass getPLBinaryMapping();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.productline.PLMappingReference <em>PL Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Mapping Reference</em>'.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMappingReference
   * @generated
   */
  EClass getPLMappingReference();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.productline.PLMappingReference#getObject() <em>Get Object</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Object</em>' operation.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMappingReference#getObject()
   * @generated
   */
  EOperation getPLMappingReference__GetObject();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference <em>PL Binary Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Binary Mapping Reference</em>'.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference
   * @generated
   */
  EClass getPLBinaryMappingReference();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference#getObject() <em>Get Object</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Object</em>' operation.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference#getObject()
   * @generated
   */
  EOperation getPLBinaryMappingReference__GetObject();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PLMIDFactory getPLMIDFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLModelRelImpl <em>PL Model Rel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLModelRelImpl
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLModelRel()
     * @generated
     */
    EClass PL_MODEL_REL = PLMIDPackage.eINSTANCE.getPLModelRel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryModelRelImpl <em>PL Binary Model Rel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryModelRelImpl
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLBinaryModelRel()
     * @generated
     */
    EClass PL_BINARY_MODEL_REL = PLMIDPackage.eINSTANCE.getPLBinaryModelRel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingImpl <em>PL Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingImpl
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLMapping()
     * @generated
     */
    EClass PL_MAPPING = PLMIDPackage.eINSTANCE.getPLMapping();

    /**
     * The meta object literal for the '<em><b>To MID Custom Print Label</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PL_MAPPING___TO_MID_CUSTOM_PRINT_LABEL = PLMIDPackage.eINSTANCE.getPLMapping__ToMIDCustomPrintLabel();

    /**
     * The meta object literal for the '<em><b>To MID Custom Edit Label</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PL_MAPPING___TO_MID_CUSTOM_EDIT_LABEL = PLMIDPackage.eINSTANCE.getPLMapping__ToMIDCustomEditLabel();

    /**
     * The meta object literal for the '<em><b>Update MID Custom Label</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PL_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING = PLMIDPackage.eINSTANCE.getPLMapping__UpdateMIDCustomLabel__String();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingImpl <em>PL Binary Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingImpl
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLBinaryMapping()
     * @generated
     */
    EClass PL_BINARY_MAPPING = PLMIDPackage.eINSTANCE.getPLBinaryMapping();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingReferenceImpl <em>PL Mapping Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMappingReferenceImpl
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLMappingReference()
     * @generated
     */
    EClass PL_MAPPING_REFERENCE = PLMIDPackage.eINSTANCE.getPLMappingReference();

    /**
     * The meta object literal for the '<em><b>Get Object</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PL_MAPPING_REFERENCE___GET_OBJECT = PLMIDPackage.eINSTANCE.getPLMappingReference__GetObject();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingReferenceImpl <em>PL Binary Mapping Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLBinaryMappingReferenceImpl
     * @see edu.toronto.cs.se.mmint.mid.productline.impl.PLMIDPackageImpl#getPLBinaryMappingReference()
     * @generated
     */
    EClass PL_BINARY_MAPPING_REFERENCE = PLMIDPackage.eINSTANCE.getPLBinaryMappingReference();

    /**
     * The meta object literal for the '<em><b>Get Object</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PL_BINARY_MAPPING_REFERENCE___GET_OBJECT = PLMIDPackage.eINSTANCE.getPLBinaryMappingReference__GetObject();

  }

} //PLMIDPackage
