/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDFactory
 * @model kind="package"
 * @generated
 */
public interface MAVOMIDPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "mavomid";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://se.cs.toronto.edu/mmint/MAVOMID";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "mavomid";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	MAVOMIDPackage eINSTANCE = edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl.init();

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelImpl <em>MAVO Model</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModel()
   * @generated
   */
	int MAVO_MODEL = 0;

	/**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__SUPERTYPE = MIDPackage.MODEL__SUPERTYPE;

	/**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__URI = MIDPackage.MODEL__URI;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__NAME = MIDPackage.MODEL__NAME;

	/**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__LEVEL = MIDPackage.MODEL__LEVEL;

	/**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__METATYPE_URI = MIDPackage.MODEL__METATYPE_URI;

	/**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__DYNAMIC = MIDPackage.MODEL__DYNAMIC;

	/**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__CONSTRAINT = MIDPackage.MODEL__CONSTRAINT;

	/**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__ABSTRACT = MIDPackage.MODEL__ABSTRACT;

	/**
   * The feature id for the '<em><b>Origin</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__ORIGIN = MIDPackage.MODEL__ORIGIN;

	/**
   * The feature id for the '<em><b>File Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__FILE_EXTENSION = MIDPackage.MODEL__FILE_EXTENSION;

	/**
   * The feature id for the '<em><b>Editors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__EDITORS = MIDPackage.MODEL__EDITORS;

	/**
   * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__MODEL_ELEMS = MIDPackage.MODEL__MODEL_ELEMS;

	/**
   * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__CONVERSION_OPERATORS = MIDPackage.MODEL__CONVERSION_OPERATORS;

	/**
   * The feature id for the '<em><b>EMF Instance Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAVO_MODEL__EMF_INSTANCE_RESOURCE = MIDPackage.MODEL__EMF_INSTANCE_RESOURCE;

  /**
   * The feature id for the '<em><b>EMF Instance Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAVO_MODEL__EMF_INSTANCE_ROOT = MIDPackage.MODEL__EMF_INSTANCE_ROOT;

  /**
   * The feature id for the '<em><b>Inc</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__INC = MIDPackage.MODEL_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Decisions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL__DECISIONS = MIDPackage.MODEL_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>MAVO Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_FEATURE_COUNT = MIDPackage.MODEL_FEATURE_COUNT + 2;

	/**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___IS_LEVEL__MIDLEVEL = MIDPackage.MODEL___IS_LEVEL__MIDLEVEL;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___IS_TYPES_LEVEL = MIDPackage.MODEL___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.MODEL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.MODEL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___IS_INSTANCES_LEVEL = MIDPackage.MODEL___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___GET_RUNTIME_TYPES = MIDPackage.MODEL___GET_RUNTIME_TYPES;

	/**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int MAVO_MODEL___GET_CLOSEST_TYPE_CONSTRAINT = MIDPackage.MODEL___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.MODEL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___VALIDATE_INSTANCE = MIDPackage.MODEL___VALIDATE_INSTANCE;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___IS_WORKFLOWS_LEVEL = MIDPackage.MODEL___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.MODEL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___GET_METATYPE = MIDPackage.MODEL___GET_METATYPE;

	/**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___GET_SUPERTYPE = MIDPackage.MODEL___GET_SUPERTYPE;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___GET_MID_CONTAINER = MIDPackage.MODEL___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Create Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___CREATE_SUBTYPE__STRING_BOOLEAN = MIDPackage.MODEL___CREATE_SUBTYPE__STRING_BOOLEAN;

	/**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___DELETE_TYPE = MIDPackage.MODEL___DELETE_TYPE;

	/**
   * The operation id for the '<em>Get EMF Type Root</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___GET_EMF_TYPE_ROOT = MIDPackage.MODEL___GET_EMF_TYPE_ROOT;

	/**
   * The operation id for the '<em>Open Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___OPEN_TYPE = MIDPackage.MODEL___OPEN_TYPE;

	/**
   * The operation id for the '<em>Create Instance Editor</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int MAVO_MODEL___CREATE_INSTANCE_EDITOR__BOOLEAN = MIDPackage.MODEL___CREATE_INSTANCE_EDITOR__BOOLEAN;

    /**
   * The operation id for the '<em>Create Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = MIDPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

	/**
   * The operation id for the '<em>Import Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = MIDPackage.MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
   * The operation id for the '<em>Copy Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___COPY_INSTANCE__MODEL_STRING_MID = MIDPackage.MODEL___COPY_INSTANCE__MODEL_STRING_MID;

	/**
   * The operation id for the '<em>Copy Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = MIDPackage.MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___DELETE_INSTANCE = MIDPackage.MODEL___DELETE_INSTANCE;

	/**
   * The operation id for the '<em>Delete Instance And File</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___DELETE_INSTANCE_AND_FILE = MIDPackage.MODEL___DELETE_INSTANCE_AND_FILE;

	/**
   * The operation id for the '<em>Open Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___OPEN_INSTANCE = MIDPackage.MODEL___OPEN_INSTANCE;

	/**
   * The operation id for the '<em>Create Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID = MIDPackage.MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
   * The operation id for the '<em>Delete Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___DELETE_WORKFLOW_INSTANCE = MIDPackage.MODEL___DELETE_WORKFLOW_INSTANCE;

	/**
   * The operation id for the '<em>Create Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___CREATE_INSTANCE__EOBJECT_STRING_MID = MIDPackage.MODEL_OPERATION_COUNT + 0;

	/**
   * The operation id for the '<em>Import Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___IMPORT_INSTANCE__STRING_MID = MIDPackage.MODEL_OPERATION_COUNT + 1;

	/**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.MODEL_OPERATION_COUNT + 2;

	/**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.MODEL_OPERATION_COUNT + 3;

	/**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.MODEL_OPERATION_COUNT + 4;

	/**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.MODEL_OPERATION_COUNT + 5;

	/**
   * The number of operations of the '<em>MAVO Model</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_OPERATION_COUNT = MIDPackage.MODEL_OPERATION_COUNT + 6;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl <em>MAVO Model Element</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelElement()
   * @generated
   */
	int MAVO_MODEL_ELEMENT = 1;

	/**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__SUPERTYPE = MIDPackage.MODEL_ELEMENT__SUPERTYPE;

	/**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__URI = MIDPackage.MODEL_ELEMENT__URI;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__NAME = MIDPackage.MODEL_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__LEVEL = MIDPackage.MODEL_ELEMENT__LEVEL;

	/**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__METATYPE_URI = MIDPackage.MODEL_ELEMENT__METATYPE_URI;

	/**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__DYNAMIC = MIDPackage.MODEL_ELEMENT__DYNAMIC;

	/**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__CONSTRAINT = MIDPackage.MODEL_ELEMENT__CONSTRAINT;

	/**
   * The feature id for the '<em><b>EInfo</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__EINFO = MIDPackage.MODEL_ELEMENT__EINFO;

	/**
   * The feature id for the '<em><b>EMF Instance Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAVO_MODEL_ELEMENT__EMF_INSTANCE_OBJECT = MIDPackage.MODEL_ELEMENT__EMF_INSTANCE_OBJECT;

  /**
   * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__FORMULA_VARIABLE = MIDPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>May</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__MAY = MIDPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Set</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__SET = MIDPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__VAR = MIDPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
   * The feature id for the '<em><b>Collections</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT__COLLECTIONS = MIDPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
   * The number of structural features of the '<em>MAVO Model Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_FEATURE_COUNT = MIDPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___IS_LEVEL__MIDLEVEL = MIDPackage.MODEL_ELEMENT___IS_LEVEL__MIDLEVEL;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___IS_TYPES_LEVEL = MIDPackage.MODEL_ELEMENT___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.MODEL_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.MODEL_ELEMENT___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___IS_INSTANCES_LEVEL = MIDPackage.MODEL_ELEMENT___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___GET_RUNTIME_TYPES = MIDPackage.MODEL_ELEMENT___GET_RUNTIME_TYPES;

	/**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int MAVO_MODEL_ELEMENT___GET_CLOSEST_TYPE_CONSTRAINT = MIDPackage.MODEL_ELEMENT___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.MODEL_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___VALIDATE_INSTANCE = MIDPackage.MODEL_ELEMENT___VALIDATE_INSTANCE;

	/**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.MODEL_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___IS_WORKFLOWS_LEVEL = MIDPackage.MODEL_ELEMENT___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.MODEL_ELEMENT___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___GET_METATYPE = MIDPackage.MODEL_ELEMENT___GET_METATYPE;

	/**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___GET_SUPERTYPE = MIDPackage.MODEL_ELEMENT___GET_SUPERTYPE;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___GET_MID_CONTAINER = MIDPackage.MODEL_ELEMENT___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Create Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE = MIDPackage.MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE;

	/**
   * The operation id for the '<em>Create Subtype And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE = MIDPackage.MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE;

	/**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___DELETE_TYPE = MIDPackage.MODEL_ELEMENT___DELETE_TYPE;

	/**
   * The operation id for the '<em>Get EMF Type Object</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___GET_EMF_TYPE_OBJECT = MIDPackage.MODEL_ELEMENT___GET_EMF_TYPE_OBJECT;

	/**
   * The operation id for the '<em>Create Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE = MIDPackage.MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE;

	/**
   * The operation id for the '<em>Create Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE = MIDPackage.MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE;

	/**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___DELETE_INSTANCE = MIDPackage.MODEL_ELEMENT___DELETE_INSTANCE;

	/**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.MODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.MODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.MODEL_ELEMENT_OPERATION_COUNT + 2;

	/**
   * The number of operations of the '<em>MAVO Model Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_OPERATION_COUNT = MIDPackage.MODEL_ELEMENT_OPERATION_COUNT + 3;


	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelRelImpl <em>MAVO Model Rel</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelRelImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelRel()
   * @generated
   */
	int MAVO_MODEL_REL = 2;

	/**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__SUPERTYPE = RelationshipPackage.MODEL_REL__SUPERTYPE;

	/**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__URI = RelationshipPackage.MODEL_REL__URI;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__NAME = RelationshipPackage.MODEL_REL__NAME;

	/**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__LEVEL = RelationshipPackage.MODEL_REL__LEVEL;

	/**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__METATYPE_URI = RelationshipPackage.MODEL_REL__METATYPE_URI;

	/**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__DYNAMIC = RelationshipPackage.MODEL_REL__DYNAMIC;

	/**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__CONSTRAINT = RelationshipPackage.MODEL_REL__CONSTRAINT;

	/**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__ABSTRACT = RelationshipPackage.MODEL_REL__ABSTRACT;

	/**
   * The feature id for the '<em><b>Origin</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__ORIGIN = RelationshipPackage.MODEL_REL__ORIGIN;

	/**
   * The feature id for the '<em><b>File Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__FILE_EXTENSION = RelationshipPackage.MODEL_REL__FILE_EXTENSION;

	/**
   * The feature id for the '<em><b>Editors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__EDITORS = RelationshipPackage.MODEL_REL__EDITORS;

	/**
   * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__MODEL_ELEMS = RelationshipPackage.MODEL_REL__MODEL_ELEMS;

	/**
   * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__CONVERSION_OPERATORS = RelationshipPackage.MODEL_REL__CONVERSION_OPERATORS;

	/**
   * The feature id for the '<em><b>EMF Instance Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAVO_MODEL_REL__EMF_INSTANCE_RESOURCE = RelationshipPackage.MODEL_REL__EMF_INSTANCE_RESOURCE;

  /**
   * The feature id for the '<em><b>EMF Instance Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAVO_MODEL_REL__EMF_INSTANCE_ROOT = RelationshipPackage.MODEL_REL__EMF_INSTANCE_ROOT;

  /**
   * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__MODEL_ENDPOINTS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS;

	/**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__MAPPINGS = RelationshipPackage.MODEL_REL__MAPPINGS;

	/**
   * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__MODEL_ENDPOINT_REFS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS;

	/**
   * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL__MAPPING_REFS = RelationshipPackage.MODEL_REL__MAPPING_REFS;

	/**
   * The number of structural features of the '<em>MAVO Model Rel</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL_FEATURE_COUNT = RelationshipPackage.MODEL_REL_FEATURE_COUNT + 0;

	/**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___IS_LEVEL__MIDLEVEL = RelationshipPackage.MODEL_REL___IS_LEVEL__MIDLEVEL;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___IS_TYPES_LEVEL = RelationshipPackage.MODEL_REL___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___IS_INSTANCES_LEVEL = RelationshipPackage.MODEL_REL___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___GET_RUNTIME_TYPES = RelationshipPackage.MODEL_REL___GET_RUNTIME_TYPES;

	/**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int MAVO_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___VALIDATE_INSTANCE = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE;

	/**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___IS_WORKFLOWS_LEVEL = RelationshipPackage.MODEL_REL___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL;

	/**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL;

	/**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
   * The operation id for the '<em>Create Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN;

	/**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___DELETE_TYPE = RelationshipPackage.MODEL_REL___DELETE_TYPE;

	/**
   * The operation id for the '<em>Get EMF Type Root</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___GET_EMF_TYPE_ROOT = RelationshipPackage.MODEL_REL___GET_EMF_TYPE_ROOT;

	/**
   * The operation id for the '<em>Open Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___OPEN_TYPE = RelationshipPackage.MODEL_REL___OPEN_TYPE;

	/**
   * The operation id for the '<em>Create Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID;

	/**
   * The operation id for the '<em>Create Instance Editor</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int MAVO_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN;

    /**
   * The operation id for the '<em>Create Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

	/**
   * The operation id for the '<em>Import Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___IMPORT_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___IMPORT_INSTANCE__STRING_MID;

	/**
   * The operation id for the '<em>Import Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = RelationshipPackage.MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
   * The operation id for the '<em>Copy Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = RelationshipPackage.MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___DELETE_INSTANCE = RelationshipPackage.MODEL_REL___DELETE_INSTANCE;

	/**
   * The operation id for the '<em>Delete Instance And File</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___DELETE_INSTANCE_AND_FILE = RelationshipPackage.MODEL_REL___DELETE_INSTANCE_AND_FILE;

	/**
   * The operation id for the '<em>Open Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___OPEN_INSTANCE = RelationshipPackage.MODEL_REL___OPEN_INSTANCE;

	/**
   * The operation id for the '<em>Create Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
   * The operation id for the '<em>Delete Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___DELETE_WORKFLOW_INSTANCE = RelationshipPackage.MODEL_REL___DELETE_WORKFLOW_INSTANCE;

	/**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___GET_METATYPE = RelationshipPackage.MODEL_REL___GET_METATYPE;

	/**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___GET_SUPERTYPE = RelationshipPackage.MODEL_REL___GET_SUPERTYPE;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___GET_MID_CONTAINER = RelationshipPackage.MODEL_REL___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Create Binary Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN;

	/**
   * The operation id for the '<em>Copy Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___COPY_SUBTYPE__MODELREL = RelationshipPackage.MODEL_REL___COPY_SUBTYPE__MODELREL;

	/**
   * The operation id for the '<em>Get Outline Resource Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = RelationshipPackage.MODEL_REL___GET_OUTLINE_RESOURCE_TYPES;

	/**
   * The operation id for the '<em>Create Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID;

	/**
   * The operation id for the '<em>Create Binary Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID;

	/**
   * The operation id for the '<em>Create Binary Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID;

	/**
   * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = RelationshipPackage.MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES;

	/**
   * The operation id for the '<em>Create Workflow Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID;

	/**
   * The operation id for the '<em>Create Workflow Binary Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID;

	/**
   * The operation id for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID;

	/**
   * The operation id for the '<em>Copy Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 0;

	/**
   * The number of operations of the '<em>MAVO Model Rel</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_REL_OPERATION_COUNT = RelationshipPackage.MODEL_REL_OPERATION_COUNT + 1;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOModelRelImpl <em>Binary MAVO Model Rel</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOModelRelImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getBinaryMAVOModelRel()
   * @generated
   */
	int BINARY_MAVO_MODEL_REL = 3;

	/**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__SUPERTYPE = RelationshipPackage.BINARY_MODEL_REL__SUPERTYPE;

	/**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__URI = RelationshipPackage.BINARY_MODEL_REL__URI;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__NAME = RelationshipPackage.BINARY_MODEL_REL__NAME;

	/**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__LEVEL = RelationshipPackage.BINARY_MODEL_REL__LEVEL;

	/**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__METATYPE_URI = RelationshipPackage.BINARY_MODEL_REL__METATYPE_URI;

	/**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__DYNAMIC = RelationshipPackage.BINARY_MODEL_REL__DYNAMIC;

	/**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__CONSTRAINT = RelationshipPackage.BINARY_MODEL_REL__CONSTRAINT;

	/**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__ABSTRACT = RelationshipPackage.BINARY_MODEL_REL__ABSTRACT;

	/**
   * The feature id for the '<em><b>Origin</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__ORIGIN = RelationshipPackage.BINARY_MODEL_REL__ORIGIN;

	/**
   * The feature id for the '<em><b>File Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__FILE_EXTENSION = RelationshipPackage.BINARY_MODEL_REL__FILE_EXTENSION;

	/**
   * The feature id for the '<em><b>Editors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__EDITORS = RelationshipPackage.BINARY_MODEL_REL__EDITORS;

	/**
   * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__MODEL_ELEMS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ELEMS;

	/**
   * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__CONVERSION_OPERATORS = RelationshipPackage.BINARY_MODEL_REL__CONVERSION_OPERATORS;

	/**
   * The feature id for the '<em><b>EMF Instance Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_MAVO_MODEL_REL__EMF_INSTANCE_RESOURCE = RelationshipPackage.BINARY_MODEL_REL__EMF_INSTANCE_RESOURCE;

  /**
   * The feature id for the '<em><b>EMF Instance Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_MAVO_MODEL_REL__EMF_INSTANCE_ROOT = RelationshipPackage.BINARY_MODEL_REL__EMF_INSTANCE_ROOT;

  /**
   * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__MODEL_ENDPOINTS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ENDPOINTS;

	/**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__MAPPINGS = RelationshipPackage.BINARY_MODEL_REL__MAPPINGS;

	/**
   * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__MODEL_ENDPOINT_REFS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ENDPOINT_REFS;

	/**
   * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__MAPPING_REFS = RelationshipPackage.BINARY_MODEL_REL__MAPPING_REFS;

	/**
   * The feature id for the '<em><b>Source Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__SOURCE_MODEL = RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL;

	/**
   * The feature id for the '<em><b>Target Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL__TARGET_MODEL = RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL;

	/**
   * The number of structural features of the '<em>Binary MAVO Model Rel</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL_FEATURE_COUNT = RelationshipPackage.BINARY_MODEL_REL_FEATURE_COUNT + 0;

	/**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___IS_LEVEL__MIDLEVEL = RelationshipPackage.BINARY_MODEL_REL___IS_LEVEL__MIDLEVEL;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___IS_TYPES_LEVEL = RelationshipPackage.BINARY_MODEL_REL___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.BINARY_MODEL_REL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.BINARY_MODEL_REL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___IS_INSTANCES_LEVEL = RelationshipPackage.BINARY_MODEL_REL___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___GET_RUNTIME_TYPES = RelationshipPackage.BINARY_MODEL_REL___GET_RUNTIME_TYPES;

	/**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int BINARY_MAVO_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.BINARY_MODEL_REL___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.BINARY_MODEL_REL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___VALIDATE_INSTANCE = RelationshipPackage.BINARY_MODEL_REL___VALIDATE_INSTANCE;

	/**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.BINARY_MODEL_REL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___IS_WORKFLOWS_LEVEL = RelationshipPackage.BINARY_MODEL_REL___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.BINARY_MODEL_REL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.BINARY_MODEL_REL___TO_MID_CUSTOM_PRINT_LABEL;

	/**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.BINARY_MODEL_REL___TO_MID_CUSTOM_EDIT_LABEL;

	/**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.BINARY_MODEL_REL___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
   * The operation id for the '<em>Create Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.BINARY_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN;

	/**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___DELETE_TYPE = RelationshipPackage.BINARY_MODEL_REL___DELETE_TYPE;

	/**
   * The operation id for the '<em>Get EMF Type Root</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___GET_EMF_TYPE_ROOT = RelationshipPackage.BINARY_MODEL_REL___GET_EMF_TYPE_ROOT;

	/**
   * The operation id for the '<em>Open Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___OPEN_TYPE = RelationshipPackage.BINARY_MODEL_REL___OPEN_TYPE;

	/**
   * The operation id for the '<em>Create Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_INSTANCE__EOBJECT_STRING_MID;

	/**
   * The operation id for the '<em>Create Instance Editor</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int BINARY_MAVO_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN = RelationshipPackage.BINARY_MODEL_REL___CREATE_INSTANCE_EDITOR__BOOLEAN;

    /**
   * The operation id for the '<em>Create Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID;

	/**
   * The operation id for the '<em>Import Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___IMPORT_INSTANCE__STRING_MID = RelationshipPackage.BINARY_MODEL_REL___IMPORT_INSTANCE__STRING_MID;

	/**
   * The operation id for the '<em>Import Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = RelationshipPackage.BINARY_MODEL_REL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
   * The operation id for the '<em>Copy Instance And Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = RelationshipPackage.BINARY_MODEL_REL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___DELETE_INSTANCE = RelationshipPackage.BINARY_MODEL_REL___DELETE_INSTANCE;

	/**
   * The operation id for the '<em>Delete Instance And File</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___DELETE_INSTANCE_AND_FILE = RelationshipPackage.BINARY_MODEL_REL___DELETE_INSTANCE_AND_FILE;

	/**
   * The operation id for the '<em>Open Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___OPEN_INSTANCE = RelationshipPackage.BINARY_MODEL_REL___OPEN_INSTANCE;

	/**
   * The operation id for the '<em>Create Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
   * The operation id for the '<em>Delete Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___DELETE_WORKFLOW_INSTANCE = RelationshipPackage.BINARY_MODEL_REL___DELETE_WORKFLOW_INSTANCE;

	/**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___GET_METATYPE = RelationshipPackage.BINARY_MODEL_REL___GET_METATYPE;

	/**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___GET_SUPERTYPE = RelationshipPackage.BINARY_MODEL_REL___GET_SUPERTYPE;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___GET_MID_CONTAINER = RelationshipPackage.BINARY_MODEL_REL___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Create Binary Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN = RelationshipPackage.BINARY_MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN;

	/**
   * The operation id for the '<em>Copy Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___COPY_SUBTYPE__MODELREL = RelationshipPackage.BINARY_MODEL_REL___COPY_SUBTYPE__MODELREL;

	/**
   * The operation id for the '<em>Get Outline Resource Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = RelationshipPackage.BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES;

	/**
   * The operation id for the '<em>Create Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID;

	/**
   * The operation id for the '<em>Create Binary Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID;

	/**
   * The operation id for the '<em>Create Binary Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID;

	/**
   * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = RelationshipPackage.BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES;

	/**
   * The operation id for the '<em>Create Workflow Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID;

	/**
   * The operation id for the '<em>Create Workflow Binary Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID;

	/**
   * The operation id for the '<em>Create Workflow Binary Instance And Endpoints</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID = RelationshipPackage.BINARY_MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID;

	/**
   * The operation id for the '<em>Add Model Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN = RelationshipPackage.BINARY_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN;

	/**
   * The operation id for the '<em>Copy Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = RelationshipPackage.BINARY_MODEL_REL_OPERATION_COUNT + 0;

	/**
   * The number of operations of the '<em>Binary MAVO Model Rel</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MODEL_REL_OPERATION_COUNT = RelationshipPackage.BINARY_MODEL_REL_OPERATION_COUNT + 1;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelEndpointImpl <em>MAVO Model Endpoint</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelEndpointImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelEndpoint()
   * @generated
   */
	int MAVO_MODEL_ENDPOINT = 4;

	/**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__SUPERTYPE = MIDPackage.MODEL_ENDPOINT__SUPERTYPE;

	/**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__URI = MIDPackage.MODEL_ENDPOINT__URI;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__NAME = MIDPackage.MODEL_ENDPOINT__NAME;

	/**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__LEVEL = MIDPackage.MODEL_ENDPOINT__LEVEL;

	/**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__METATYPE_URI = MIDPackage.MODEL_ENDPOINT__METATYPE_URI;

	/**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__DYNAMIC = MIDPackage.MODEL_ENDPOINT__DYNAMIC;

	/**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__CONSTRAINT = MIDPackage.MODEL_ENDPOINT__CONSTRAINT;

	/**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__LOWER_BOUND = MIDPackage.MODEL_ENDPOINT__LOWER_BOUND;

	/**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__UPPER_BOUND = MIDPackage.MODEL_ENDPOINT__UPPER_BOUND;

	/**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT__TARGET = MIDPackage.MODEL_ENDPOINT__TARGET;

	/**
   * The number of structural features of the '<em>MAVO Model Endpoint</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_FEATURE_COUNT = MIDPackage.MODEL_ENDPOINT_FEATURE_COUNT + 0;

	/**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___IS_LEVEL__MIDLEVEL = MIDPackage.MODEL_ENDPOINT___IS_LEVEL__MIDLEVEL;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___IS_TYPES_LEVEL = MIDPackage.MODEL_ENDPOINT___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.MODEL_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.MODEL_ENDPOINT___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___IS_INSTANCES_LEVEL = MIDPackage.MODEL_ENDPOINT___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___GET_RUNTIME_TYPES = MIDPackage.MODEL_ENDPOINT___GET_RUNTIME_TYPES;

	/**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int MAVO_MODEL_ENDPOINT___GET_CLOSEST_TYPE_CONSTRAINT = MIDPackage.MODEL_ENDPOINT___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.MODEL_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___VALIDATE_INSTANCE = MIDPackage.MODEL_ENDPOINT___VALIDATE_INSTANCE;

	/**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.MODEL_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___IS_WORKFLOWS_LEVEL = MIDPackage.MODEL_ENDPOINT___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.MODEL_ENDPOINT___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.MODEL_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.MODEL_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.MODEL_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
   * The operation id for the '<em>Get Target Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___GET_TARGET_URI = MIDPackage.MODEL_ENDPOINT___GET_TARGET_URI;

	/**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___GET_METATYPE = MIDPackage.MODEL_ENDPOINT___GET_METATYPE;

	/**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___GET_SUPERTYPE = MIDPackage.MODEL_ENDPOINT___GET_SUPERTYPE;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___GET_MID_CONTAINER = MIDPackage.MODEL_ENDPOINT___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Create Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL = MIDPackage.MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL;

	/**
   * The operation id for the '<em>Create Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___CREATE_SUBTYPE__STRING_MODEL_BOOLEAN_MODELREL = MIDPackage.MODEL_ENDPOINT___CREATE_SUBTYPE__STRING_MODEL_BOOLEAN_MODELREL;

	/**
   * The operation id for the '<em>Replace Subtype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___REPLACE_SUBTYPE__MODELENDPOINT_STRING_MODEL = MIDPackage.MODEL_ENDPOINT___REPLACE_SUBTYPE__MODELENDPOINT_STRING_MODEL;

	/**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___DELETE_TYPE__BOOLEAN = MIDPackage.MODEL_ENDPOINT___DELETE_TYPE__BOOLEAN;

	/**
   * The operation id for the '<em>Create Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL = MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL;

	/**
   * The operation id for the '<em>Create Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_MODELREL = MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_MODELREL;

	/**
   * The operation id for the '<em>Create Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING = MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING;

	/**
   * The operation id for the '<em>Replace Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___REPLACE_INSTANCE__MODELENDPOINT_MODEL = MIDPackage.MODEL_ENDPOINT___REPLACE_INSTANCE__MODELENDPOINT_MODEL;

	/**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___DELETE_INSTANCE__BOOLEAN = MIDPackage.MODEL_ENDPOINT___DELETE_INSTANCE__BOOLEAN;

	/**
   * The operation id for the '<em>Create Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_MODELREL = MIDPackage.MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_MODELREL;

	/**
   * The operation id for the '<em>Create Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_OPERATOR_STRING = MIDPackage.MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_OPERATOR_STRING;

	/**
   * The operation id for the '<em>Replace Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___REPLACE_WORKFLOW_INSTANCE__MODELENDPOINT_MODEL = MIDPackage.MODEL_ENDPOINT___REPLACE_WORKFLOW_INSTANCE__MODELENDPOINT_MODEL;

	/**
   * The operation id for the '<em>Delete Workflow Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___DELETE_WORKFLOW_INSTANCE = MIDPackage.MODEL_ENDPOINT___DELETE_WORKFLOW_INSTANCE;

	/**
   * The operation id for the '<em>Get Target</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT___GET_TARGET = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 0;

	/**
   * The number of operations of the '<em>MAVO Model Endpoint</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_OPERATION_COUNT = MIDPackage.MODEL_ENDPOINT_OPERATION_COUNT + 1;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelEndpointReferenceImpl <em>MAVO Model Endpoint Reference</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelEndpointReferenceImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelEndpointReference()
   * @generated
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE = 8;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMappingReferenceImpl <em>MAVO Mapping Reference</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMappingReferenceImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOMappingReference()
   * @generated
   */
	int MAVO_MAPPING_REFERENCE = 9;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingReferenceImpl <em>Binary MAVO Mapping Reference</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingReferenceImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getBinaryMAVOMappingReference()
   * @generated
   */
	int BINARY_MAVO_MAPPING_REFERENCE = 10;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMappingImpl <em>MAVO Mapping</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMappingImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOMapping()
   * @generated
   */
	int MAVO_MAPPING = 5;

	/**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__SUPERTYPE = RelationshipPackage.MAPPING__SUPERTYPE;

	/**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__URI = RelationshipPackage.MAPPING__URI;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__NAME = RelationshipPackage.MAPPING__NAME;

	/**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__LEVEL = RelationshipPackage.MAPPING__LEVEL;

	/**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__METATYPE_URI = RelationshipPackage.MAPPING__METATYPE_URI;

	/**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__DYNAMIC = RelationshipPackage.MAPPING__DYNAMIC;

	/**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__CONSTRAINT = RelationshipPackage.MAPPING__CONSTRAINT;

	/**
   * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__MODEL_ELEM_ENDPOINTS = RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS;

	/**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS;

	/**
   * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__FORMULA_VARIABLE = RelationshipPackage.MAPPING_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>May</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__MAY = RelationshipPackage.MAPPING_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Set</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__SET = RelationshipPackage.MAPPING_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__VAR = RelationshipPackage.MAPPING_FEATURE_COUNT + 3;

	/**
   * The feature id for the '<em><b>Collections</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING__COLLECTIONS = RelationshipPackage.MAPPING_FEATURE_COUNT + 4;

	/**
   * The number of structural features of the '<em>MAVO Mapping</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_FEATURE_COUNT = RelationshipPackage.MAPPING_FEATURE_COUNT + 5;

	/**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___IS_LEVEL__MIDLEVEL = RelationshipPackage.MAPPING___IS_LEVEL__MIDLEVEL;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___IS_TYPES_LEVEL = RelationshipPackage.MAPPING___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.MAPPING___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___IS_INSTANCES_LEVEL = RelationshipPackage.MAPPING___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___GET_RUNTIME_TYPES = RelationshipPackage.MAPPING___GET_RUNTIME_TYPES;

	/**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int MAVO_MAPPING___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.MAPPING___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___VALIDATE_INSTANCE = RelationshipPackage.MAPPING___VALIDATE_INSTANCE;

	/**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___IS_WORKFLOWS_LEVEL = RelationshipPackage.MAPPING___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___GET_METATYPE = RelationshipPackage.MAPPING___GET_METATYPE;

	/**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___GET_SUPERTYPE = RelationshipPackage.MAPPING___GET_SUPERTYPE;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___GET_MID_CONTAINER = RelationshipPackage.MAPPING___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Create Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL = RelationshipPackage.MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL;

	/**
   * The operation id for the '<em>Create Subtype And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL = RelationshipPackage.MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL;

	/**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___DELETE_TYPE = RelationshipPackage.MAPPING___DELETE_TYPE;

	/**
   * The operation id for the '<em>Create Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL = RelationshipPackage.MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL;

	/**
   * The operation id for the '<em>Create Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = RelationshipPackage.MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL;

	/**
   * The operation id for the '<em>Create Instance And Reference And Endpoints And References</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST = RelationshipPackage.MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST;

	/**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___DELETE_INSTANCE = RelationshipPackage.MAPPING___DELETE_INSTANCE;

	/**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.MAPPING_OPERATION_COUNT + 0;

	/**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.MAPPING_OPERATION_COUNT + 1;

	/**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.MAPPING_OPERATION_COUNT + 2;

	/**
   * The number of operations of the '<em>MAVO Mapping</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_OPERATION_COUNT = RelationshipPackage.MAPPING_OPERATION_COUNT + 3;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl <em>Binary MAVO Mapping</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getBinaryMAVOMapping()
   * @generated
   */
	int BINARY_MAVO_MAPPING = 6;

	/**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__SUPERTYPE = RelationshipPackage.BINARY_MAPPING__SUPERTYPE;

	/**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__URI = RelationshipPackage.BINARY_MAPPING__URI;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__NAME = RelationshipPackage.BINARY_MAPPING__NAME;

	/**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__LEVEL = RelationshipPackage.BINARY_MAPPING__LEVEL;

	/**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__METATYPE_URI = RelationshipPackage.BINARY_MAPPING__METATYPE_URI;

	/**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__DYNAMIC = RelationshipPackage.BINARY_MAPPING__DYNAMIC;

	/**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__CONSTRAINT = RelationshipPackage.BINARY_MAPPING__CONSTRAINT;

	/**
   * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__MODEL_ELEM_ENDPOINTS = RelationshipPackage.BINARY_MAPPING__MODEL_ELEM_ENDPOINTS;

	/**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.BINARY_MAPPING__MODEL_ELEM_ENDPOINT_REFS;

	/**
   * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__FORMULA_VARIABLE = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>May</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__MAY = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Set</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__SET = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__VAR = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 3;

	/**
   * The feature id for the '<em><b>Collections</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING__COLLECTIONS = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 4;

	/**
   * The number of structural features of the '<em>Binary MAVO Mapping</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_FEATURE_COUNT = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 5;

	/**
   * The operation id for the '<em>Is Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___IS_LEVEL__MIDLEVEL = RelationshipPackage.BINARY_MAPPING___IS_LEVEL__MIDLEVEL;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___IS_TYPES_LEVEL = RelationshipPackage.BINARY_MAPPING___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Create Subtype Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___CREATE_SUBTYPE_URI__STRING_STRING = RelationshipPackage.BINARY_MAPPING___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
   * The operation id for the '<em>Add Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING = RelationshipPackage.BINARY_MAPPING___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___IS_INSTANCES_LEVEL = RelationshipPackage.BINARY_MAPPING___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Get Runtime Types</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___GET_RUNTIME_TYPES = RelationshipPackage.BINARY_MAPPING___GET_RUNTIME_TYPES;

	/**
   * The operation id for the '<em>Get Closest Type Constraint</em>' operation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int BINARY_MAVO_MAPPING___GET_CLOSEST_TYPE_CONSTRAINT = RelationshipPackage.BINARY_MAPPING___GET_CLOSEST_TYPE_CONSTRAINT;

    /**
   * The operation id for the '<em>Validate Instance Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = RelationshipPackage.BINARY_MAPPING___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
   * The operation id for the '<em>Validate Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___VALIDATE_INSTANCE = RelationshipPackage.BINARY_MAPPING___VALIDATE_INSTANCE;

	/**
   * The operation id for the '<em>Validate Instance In Editor</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = RelationshipPackage.BINARY_MAPPING___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___IS_WORKFLOWS_LEVEL = RelationshipPackage.BINARY_MAPPING___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING = RelationshipPackage.BINARY_MAPPING___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
   * The operation id for the '<em>Get Metatype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___GET_METATYPE = RelationshipPackage.BINARY_MAPPING___GET_METATYPE;

	/**
   * The operation id for the '<em>Get Supertype</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___GET_SUPERTYPE = RelationshipPackage.BINARY_MAPPING___GET_SUPERTYPE;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___GET_MID_CONTAINER = RelationshipPackage.BINARY_MAPPING___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Create Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL = RelationshipPackage.BINARY_MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL;

	/**
   * The operation id for the '<em>Create Subtype And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL = RelationshipPackage.BINARY_MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL;

	/**
   * The operation id for the '<em>Delete Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___DELETE_TYPE = RelationshipPackage.BINARY_MAPPING___DELETE_TYPE;

	/**
   * The operation id for the '<em>Create Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL = RelationshipPackage.BINARY_MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL;

	/**
   * The operation id for the '<em>Create Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = RelationshipPackage.BINARY_MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL;

	/**
   * The operation id for the '<em>Create Instance And Reference And Endpoints And References</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST = RelationshipPackage.BINARY_MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST;

	/**
   * The operation id for the '<em>Delete Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___DELETE_INSTANCE = RelationshipPackage.BINARY_MAPPING___DELETE_INSTANCE;

	/**
   * The operation id for the '<em>To MID Custom Print Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___TO_MID_CUSTOM_PRINT_LABEL = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 0;

	/**
   * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___TO_MID_CUSTOM_EDIT_LABEL = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 1;

	/**
   * The operation id for the '<em>Update MID Custom Label</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 2;

	/**
   * The number of operations of the '<em>Binary MAVO Mapping</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_OPERATION_COUNT = RelationshipPackage.BINARY_MAPPING_OPERATION_COUNT + 3;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementReferenceImpl <em>MAVO Model Element Reference</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementReferenceImpl
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelElementReference()
   * @generated
   */
	int MAVO_MODEL_ELEMENT_REFERENCE = 7;

	/**
   * The feature id for the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.MODEL_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
   * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.MODEL_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
   * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE__SUPERTYPE_REF = RelationshipPackage.MODEL_ELEMENT_REFERENCE__SUPERTYPE_REF;

	/**
   * The feature id for the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE__MODIFIABLE = RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODIFIABLE;

	/**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

	/**
   * The number of structural features of the '<em>MAVO Model Element Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE_FEATURE_COUNT = RelationshipPackage.MODEL_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
   * The operation id for the '<em>Get Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___GET_URI = RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_URI;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___GET_MID_CONTAINER = RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___IS_TYPES_LEVEL = RelationshipPackage.MODEL_ELEMENT_REFERENCE___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL = RelationshipPackage.MODEL_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL = RelationshipPackage.MODEL_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Get Supertype Ref</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF = RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF;

	/**
   * The operation id for the '<em>Delete Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE = RelationshipPackage.MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE;

	/**
   * The operation id for the '<em>Delete Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE = RelationshipPackage.MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE;

	/**
   * The operation id for the '<em>Get Object</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE___GET_OBJECT = RelationshipPackage.MODEL_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
   * The number of operations of the '<em>MAVO Model Element Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ELEMENT_REFERENCE_OPERATION_COUNT = RelationshipPackage.MODEL_ELEMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
   * The feature id for the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__REFERENCED_OBJECT;

	/**
   * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__CONTAINED_OBJECT;

	/**
   * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE__SUPERTYPE_REF = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__SUPERTYPE_REF;

	/**
   * The feature id for the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE__MODIFIABLE = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODIFIABLE;

	/**
   * The feature id for the '<em><b>Model Elem Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS = RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS;

	/**
   * The number of structural features of the '<em>MAVO Model Endpoint Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE_FEATURE_COUNT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_FEATURE_COUNT + 0;

	/**
   * The operation id for the '<em>Get Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___GET_URI = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_URI;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___GET_MID_CONTAINER = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___IS_TYPES_LEVEL = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Get Target Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___GET_TARGET_URI = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_TARGET_URI;

	/**
   * The operation id for the '<em>Get Supertype Ref</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF;

	/**
   * The operation id for the '<em>Accept Model Element Type</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT;

	/**
   * The operation id for the '<em>Delete Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN;

	/**
   * The operation id for the '<em>Accept Model Element Instance</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT;

	/**
   * The operation id for the '<em>Get Object</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___GET_OBJECT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT + 0;

	/**
   * The operation id for the '<em>Create Model Element Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT + 1;

	/**
   * The number of operations of the '<em>MAVO Model Endpoint Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT = RelationshipPackage.MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT + 2;

	/**
   * The feature id for the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.MAPPING_REFERENCE__REFERENCED_OBJECT;

	/**
   * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.MAPPING_REFERENCE__CONTAINED_OBJECT;

	/**
   * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE__SUPERTYPE_REF = RelationshipPackage.MAPPING_REFERENCE__SUPERTYPE_REF;

	/**
   * The feature id for the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE__MODIFIABLE = RelationshipPackage.MAPPING_REFERENCE__MODIFIABLE;

	/**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

	/**
   * The number of structural features of the '<em>MAVO Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE_FEATURE_COUNT = RelationshipPackage.MAPPING_REFERENCE_FEATURE_COUNT + 0;

	/**
   * The operation id for the '<em>Get Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___GET_URI = RelationshipPackage.MAPPING_REFERENCE___GET_URI;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___GET_MID_CONTAINER = RelationshipPackage.MAPPING_REFERENCE___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___IS_TYPES_LEVEL = RelationshipPackage.MAPPING_REFERENCE___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___IS_INSTANCES_LEVEL = RelationshipPackage.MAPPING_REFERENCE___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL = RelationshipPackage.MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Get Supertype Ref</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___GET_SUPERTYPE_REF = RelationshipPackage.MAPPING_REFERENCE___GET_SUPERTYPE_REF;

	/**
   * The operation id for the '<em>Delete Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___DELETE_TYPE_REFERENCE = RelationshipPackage.MAPPING_REFERENCE___DELETE_TYPE_REFERENCE;

	/**
   * The operation id for the '<em>Delete Type And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE = RelationshipPackage.MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE;

	/**
   * The operation id for the '<em>Delete Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE = RelationshipPackage.MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE;

	/**
   * The operation id for the '<em>Delete Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = RelationshipPackage.MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE;

	/**
   * The operation id for the '<em>Get Object</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE___GET_OBJECT = RelationshipPackage.MAPPING_REFERENCE_OPERATION_COUNT + 0;

	/**
   * The number of operations of the '<em>MAVO Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MAVO_MAPPING_REFERENCE_OPERATION_COUNT = RelationshipPackage.MAPPING_REFERENCE_OPERATION_COUNT + 1;

	/**
   * The feature id for the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.BINARY_MAPPING_REFERENCE__REFERENCED_OBJECT;

	/**
   * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.BINARY_MAPPING_REFERENCE__CONTAINED_OBJECT;

	/**
   * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE__SUPERTYPE_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__SUPERTYPE_REF;

	/**
   * The feature id for the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE__MODIFIABLE = RelationshipPackage.BINARY_MAPPING_REFERENCE__MODIFIABLE;

	/**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.BINARY_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

	/**
   * The feature id for the '<em><b>Source Model Elem Ref</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF;

	/**
   * The feature id for the '<em><b>Target Model Elem Ref</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF;

	/**
   * The number of structural features of the '<em>Binary MAVO Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE_FEATURE_COUNT = RelationshipPackage.BINARY_MAPPING_REFERENCE_FEATURE_COUNT + 0;

	/**
   * The operation id for the '<em>Get Uri</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___GET_URI = RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_URI;

	/**
   * The operation id for the '<em>Get MID Container</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___GET_MID_CONTAINER = RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_MID_CONTAINER;

	/**
   * The operation id for the '<em>Is Types Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___IS_TYPES_LEVEL = RelationshipPackage.BINARY_MAPPING_REFERENCE___IS_TYPES_LEVEL;

	/**
   * The operation id for the '<em>Is Instances Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___IS_INSTANCES_LEVEL = RelationshipPackage.BINARY_MAPPING_REFERENCE___IS_INSTANCES_LEVEL;

	/**
   * The operation id for the '<em>Is Workflows Level</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL = RelationshipPackage.BINARY_MAPPING_REFERENCE___IS_WORKFLOWS_LEVEL;

	/**
   * The operation id for the '<em>Get Supertype Ref</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___GET_SUPERTYPE_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_SUPERTYPE_REF;

	/**
   * The operation id for the '<em>Delete Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___DELETE_TYPE_REFERENCE = RelationshipPackage.BINARY_MAPPING_REFERENCE___DELETE_TYPE_REFERENCE;

	/**
   * The operation id for the '<em>Delete Type And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE = RelationshipPackage.BINARY_MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE;

	/**
   * The operation id for the '<em>Delete Instance Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE = RelationshipPackage.BINARY_MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE;

	/**
   * The operation id for the '<em>Delete Instance And Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = RelationshipPackage.BINARY_MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE;

	/**
   * The operation id for the '<em>Add Model Element Type Reference</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN = RelationshipPackage.BINARY_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN;

	/**
   * The operation id for the '<em>Get Object</em>' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE___GET_OBJECT = RelationshipPackage.BINARY_MAPPING_REFERENCE_OPERATION_COUNT + 1;

	/**
   * The number of operations of the '<em>Binary MAVO Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BINARY_MAVO_MAPPING_REFERENCE_OPERATION_COUNT = RelationshipPackage.BINARY_MAPPING_REFERENCE_OPERATION_COUNT + 2;

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel <em>MAVO Model</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAVO Model</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel
   * @generated
   */
	EClass getMAVOModel();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#createInstance(org.eclipse.emf.ecore.EObject, java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Create Instance</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Create Instance</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#createInstance(org.eclipse.emf.ecore.EObject, java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
   * @generated
   */
	EOperation getMAVOModel__CreateInstance__EObject_String_MID();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#importInstance(java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Import Instance</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Import Instance</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#importInstance(java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
   * @generated
   */
	EOperation getMAVOModel__ImportInstance__String_MID();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#validateInstanceInEditor(org.eclipse.emf.validation.IValidationContext) <em>Validate Instance In Editor</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Validate Instance In Editor</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#validateInstanceInEditor(org.eclipse.emf.validation.IValidationContext)
   * @generated
   */
	EOperation getMAVOModel__ValidateInstanceInEditor__IValidationContext();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#toMIDCustomPrintLabel() <em>To MID Custom Print Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>To MID Custom Print Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#toMIDCustomPrintLabel()
   * @generated
   */
	EOperation getMAVOModel__ToMIDCustomPrintLabel();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#toMIDCustomEditLabel() <em>To MID Custom Edit Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>To MID Custom Edit Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#toMIDCustomEditLabel()
   * @generated
   */
	EOperation getMAVOModel__ToMIDCustomEditLabel();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#updateMIDCustomLabel(java.lang.String) <em>Update MID Custom Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Update MID Custom Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel#updateMIDCustomLabel(java.lang.String)
   * @generated
   */
	EOperation getMAVOModel__UpdateMIDCustomLabel__String();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement <em>MAVO Model Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAVO Model Element</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement
   * @generated
   */
	EClass getMAVOModelElement();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement#toMIDCustomPrintLabel() <em>To MID Custom Print Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>To MID Custom Print Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement#toMIDCustomPrintLabel()
   * @generated
   */
	EOperation getMAVOModelElement__ToMIDCustomPrintLabel();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement#toMIDCustomEditLabel() <em>To MID Custom Edit Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>To MID Custom Edit Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement#toMIDCustomEditLabel()
   * @generated
   */
	EOperation getMAVOModelElement__ToMIDCustomEditLabel();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement#updateMIDCustomLabel(java.lang.String) <em>Update MID Custom Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Update MID Custom Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement#updateMIDCustomLabel(java.lang.String)
   * @generated
   */
	EOperation getMAVOModelElement__UpdateMIDCustomLabel__String();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel <em>MAVO Model Rel</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAVO Model Rel</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel
   * @generated
   */
	EClass getMAVOModelRel();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel#copyInstance(edu.toronto.cs.se.mmint.mid.Model, java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Copy Instance</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Copy Instance</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel#copyInstance(edu.toronto.cs.se.mmint.mid.Model, java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
   * @generated
   */
	EOperation getMAVOModelRel__CopyInstance__Model_String_MID();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOModelRel <em>Binary MAVO Model Rel</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary MAVO Model Rel</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOModelRel
   * @generated
   */
	EClass getBinaryMAVOModelRel();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint <em>MAVO Model Endpoint</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAVO Model Endpoint</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint
   * @generated
   */
	EClass getMAVOModelEndpoint();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint#getTarget() <em>Get Target</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Target</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint#getTarget()
   * @generated
   */
	EOperation getMAVOModelEndpoint__GetTarget();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference <em>MAVO Model Endpoint Reference</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAVO Model Endpoint Reference</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference
   * @generated
   */
	EClass getMAVOModelEndpointReference();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference#getObject() <em>Get Object</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Object</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference#getObject()
   * @generated
   */
	EOperation getMAVOModelEndpointReference__GetObject();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference#createModelElementInstanceAndReference(org.eclipse.emf.ecore.EObject, java.lang.String) <em>Create Model Element Instance And Reference</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Create Model Element Instance And Reference</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference#createModelElementInstanceAndReference(org.eclipse.emf.ecore.EObject, java.lang.String)
   * @generated
   */
	EOperation getMAVOModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference <em>MAVO Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAVO Mapping Reference</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference
   * @generated
   */
	EClass getMAVOMappingReference();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference#getObject() <em>Get Object</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Object</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference#getObject()
   * @generated
   */
	EOperation getMAVOMappingReference__GetObject();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference <em>Binary MAVO Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary MAVO Mapping Reference</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference
   * @generated
   */
	EClass getBinaryMAVOMappingReference();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference#getObject() <em>Get Object</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Object</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference#getObject()
   * @generated
   */
	EOperation getBinaryMAVOMappingReference__GetObject();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping <em>MAVO Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAVO Mapping</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping
   * @generated
   */
	EClass getMAVOMapping();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping#toMIDCustomPrintLabel() <em>To MID Custom Print Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>To MID Custom Print Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping#toMIDCustomPrintLabel()
   * @generated
   */
	EOperation getMAVOMapping__ToMIDCustomPrintLabel();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping#toMIDCustomEditLabel() <em>To MID Custom Edit Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>To MID Custom Edit Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping#toMIDCustomEditLabel()
   * @generated
   */
	EOperation getMAVOMapping__ToMIDCustomEditLabel();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping#updateMIDCustomLabel(java.lang.String) <em>Update MID Custom Label</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Update MID Custom Label</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping#updateMIDCustomLabel(java.lang.String)
   * @generated
   */
	EOperation getMAVOMapping__UpdateMIDCustomLabel__String();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMapping <em>Binary MAVO Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary MAVO Mapping</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMapping
   * @generated
   */
	EClass getBinaryMAVOMapping();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference <em>MAVO Model Element Reference</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAVO Model Element Reference</em>'.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference
   * @generated
   */
	EClass getMAVOModelElementReference();

	/**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference#getObject() <em>Get Object</em>}' operation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Object</em>' operation.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference#getObject()
   * @generated
   */
	EOperation getMAVOModelElementReference__GetObject();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	MAVOMIDFactory getMAVOMIDFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelImpl <em>MAVO Model</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModel()
     * @generated
     */
		EClass MAVO_MODEL = eINSTANCE.getMAVOModel();

		/**
     * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL___CREATE_INSTANCE__EOBJECT_STRING_MID = eINSTANCE.getMAVOModel__CreateInstance__EObject_String_MID();

		/**
     * The meta object literal for the '<em><b>Import Instance</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL___IMPORT_INSTANCE__STRING_MID = eINSTANCE.getMAVOModel__ImportInstance__String_MID();

		/**
     * The meta object literal for the '<em><b>Validate Instance In Editor</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = eINSTANCE.getMAVOModel__ValidateInstanceInEditor__IValidationContext();

		/**
     * The meta object literal for the '<em><b>To MID Custom Print Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL___TO_MID_CUSTOM_PRINT_LABEL = eINSTANCE.getMAVOModel__ToMIDCustomPrintLabel();

		/**
     * The meta object literal for the '<em><b>To MID Custom Edit Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL___TO_MID_CUSTOM_EDIT_LABEL = eINSTANCE.getMAVOModel__ToMIDCustomEditLabel();

		/**
     * The meta object literal for the '<em><b>Update MID Custom Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL___UPDATE_MID_CUSTOM_LABEL__STRING = eINSTANCE.getMAVOModel__UpdateMIDCustomLabel__String();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl <em>MAVO Model Element</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelElement()
     * @generated
     */
		EClass MAVO_MODEL_ELEMENT = eINSTANCE.getMAVOModelElement();

		/**
     * The meta object literal for the '<em><b>To MID Custom Print Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL = eINSTANCE.getMAVOModelElement__ToMIDCustomPrintLabel();

		/**
     * The meta object literal for the '<em><b>To MID Custom Edit Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL = eINSTANCE.getMAVOModelElement__ToMIDCustomEditLabel();

		/**
     * The meta object literal for the '<em><b>Update MID Custom Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING = eINSTANCE.getMAVOModelElement__UpdateMIDCustomLabel__String();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelRelImpl <em>MAVO Model Rel</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelRelImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelRel()
     * @generated
     */
		EClass MAVO_MODEL_REL = eINSTANCE.getMAVOModelRel();

		/**
     * The meta object literal for the '<em><b>Copy Instance</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID = eINSTANCE.getMAVOModelRel__CopyInstance__Model_String_MID();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOModelRelImpl <em>Binary MAVO Model Rel</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOModelRelImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getBinaryMAVOModelRel()
     * @generated
     */
		EClass BINARY_MAVO_MODEL_REL = eINSTANCE.getBinaryMAVOModelRel();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelEndpointImpl <em>MAVO Model Endpoint</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelEndpointImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelEndpoint()
     * @generated
     */
		EClass MAVO_MODEL_ENDPOINT = eINSTANCE.getMAVOModelEndpoint();

		/**
     * The meta object literal for the '<em><b>Get Target</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL_ENDPOINT___GET_TARGET = eINSTANCE.getMAVOModelEndpoint__GetTarget();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelEndpointReferenceImpl <em>MAVO Model Endpoint Reference</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelEndpointReferenceImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelEndpointReference()
     * @generated
     */
		EClass MAVO_MODEL_ENDPOINT_REFERENCE = eINSTANCE.getMAVOModelEndpointReference();

		/**
     * The meta object literal for the '<em><b>Get Object</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL_ENDPOINT_REFERENCE___GET_OBJECT = eINSTANCE.getMAVOModelEndpointReference__GetObject();

		/**
     * The meta object literal for the '<em><b>Create Model Element Instance And Reference</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING = eINSTANCE.getMAVOModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMappingReferenceImpl <em>MAVO Mapping Reference</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMappingReferenceImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOMappingReference()
     * @generated
     */
		EClass MAVO_MAPPING_REFERENCE = eINSTANCE.getMAVOMappingReference();

		/**
     * The meta object literal for the '<em><b>Get Object</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MAPPING_REFERENCE___GET_OBJECT = eINSTANCE.getMAVOMappingReference__GetObject();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingReferenceImpl <em>Binary MAVO Mapping Reference</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingReferenceImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getBinaryMAVOMappingReference()
     * @generated
     */
		EClass BINARY_MAVO_MAPPING_REFERENCE = eINSTANCE.getBinaryMAVOMappingReference();

		/**
     * The meta object literal for the '<em><b>Get Object</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation BINARY_MAVO_MAPPING_REFERENCE___GET_OBJECT = eINSTANCE.getBinaryMAVOMappingReference__GetObject();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMappingImpl <em>MAVO Mapping</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMappingImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOMapping()
     * @generated
     */
		EClass MAVO_MAPPING = eINSTANCE.getMAVOMapping();

		/**
     * The meta object literal for the '<em><b>To MID Custom Print Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MAPPING___TO_MID_CUSTOM_PRINT_LABEL = eINSTANCE.getMAVOMapping__ToMIDCustomPrintLabel();

		/**
     * The meta object literal for the '<em><b>To MID Custom Edit Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MAPPING___TO_MID_CUSTOM_EDIT_LABEL = eINSTANCE.getMAVOMapping__ToMIDCustomEditLabel();

		/**
     * The meta object literal for the '<em><b>Update MID Custom Label</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING = eINSTANCE.getMAVOMapping__UpdateMIDCustomLabel__String();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl <em>Binary MAVO Mapping</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getBinaryMAVOMapping()
     * @generated
     */
		EClass BINARY_MAVO_MAPPING = eINSTANCE.getBinaryMAVOMapping();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementReferenceImpl <em>MAVO Model Element Reference</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementReferenceImpl
     * @see edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDPackageImpl#getMAVOModelElementReference()
     * @generated
     */
		EClass MAVO_MODEL_ELEMENT_REFERENCE = eINSTANCE.getMAVOModelElementReference();

		/**
     * The meta object literal for the '<em><b>Get Object</b></em>' operation.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EOperation MAVO_MODEL_ELEMENT_REFERENCE___GET_OBJECT = eINSTANCE.getMAVOModelElementReference__GetObject();

	}

} //MAVOMIDPackage
