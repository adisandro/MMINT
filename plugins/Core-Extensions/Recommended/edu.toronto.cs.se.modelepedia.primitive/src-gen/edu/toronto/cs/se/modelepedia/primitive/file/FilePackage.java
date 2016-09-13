/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.primitive.file;

import edu.toronto.cs.se.mmint.mid.MIDPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
 * @see edu.toronto.cs.se.modelepedia.primitive.file.FileFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface FilePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "file";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/File";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "file";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FilePackage eINSTANCE = edu.toronto.cs.se.modelepedia.primitive.file.impl.FilePackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.primitive.file.impl.FileModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.primitive.file.impl.FileModelImpl
	 * @see edu.toronto.cs.se.modelepedia.primitive.file.impl.FilePackageImpl#getFileModel()
	 * @generated
	 */
	int FILE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__SUPERTYPE = MIDPackage.MODEL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__URI = MIDPackage.MODEL__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__NAME = MIDPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__LEVEL = MIDPackage.MODEL__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__METATYPE_URI = MIDPackage.MODEL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__DYNAMIC = MIDPackage.MODEL__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__CONSTRAINT = MIDPackage.MODEL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__ABSTRACT = MIDPackage.MODEL__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__ORIGIN = MIDPackage.MODEL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__FILE_EXTENSION = MIDPackage.MODEL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__EDITORS = MIDPackage.MODEL__EDITORS;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__MODEL_ELEMS = MIDPackage.MODEL__MODEL_ELEMS;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL__CONVERSION_OPERATORS = MIDPackage.MODEL__CONVERSION_OPERATORS;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL_FEATURE_COUNT = MIDPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___IS_LEVEL__MIDLEVEL = MIDPackage.MODEL___IS_LEVEL__MIDLEVEL;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___IS_TYPES_LEVEL = MIDPackage.MODEL___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.MODEL___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Add Type Constraint</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___ADD_TYPE_CONSTRAINT__STRING_STRING = MIDPackage.MODEL___ADD_TYPE_CONSTRAINT__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___IS_INSTANCES_LEVEL = MIDPackage.MODEL___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___GET_RUNTIME_TYPES = MIDPackage.MODEL___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.MODEL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___VALIDATE_INSTANCE = MIDPackage.MODEL___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___IS_WORKFLOWS_LEVEL = MIDPackage.MODEL___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>Update Workflow Instance Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___UPDATE_WORKFLOW_INSTANCE_ID__STRING = MIDPackage.MODEL___UPDATE_WORKFLOW_INSTANCE_ID__STRING;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.MODEL___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.MODEL___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.MODEL___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___GET_METATYPE = MIDPackage.MODEL___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___GET_SUPERTYPE = MIDPackage.MODEL___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___GET_MID_CONTAINER = MIDPackage.MODEL___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___CREATE_SUBTYPE__STRING_BOOLEAN = MIDPackage.MODEL___CREATE_SUBTYPE__STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___DELETE_TYPE = MIDPackage.MODEL___DELETE_TYPE;

	/**
	 * The operation id for the '<em>Get EMF Type Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___GET_EMF_TYPE_ROOT = MIDPackage.MODEL___GET_EMF_TYPE_ROOT;

	/**
	 * The operation id for the '<em>Open Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___OPEN_TYPE = MIDPackage.MODEL___OPEN_TYPE;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___CREATE_INSTANCE__STRING_MID = MIDPackage.MODEL___CREATE_INSTANCE__STRING_MID;

	/**
	 * The operation id for the '<em>Create Instance Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___CREATE_INSTANCE_EDITOR = MIDPackage.MODEL___CREATE_INSTANCE_EDITOR;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MID = MIDPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MID;

	/**
	 * The operation id for the '<em>Import Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___IMPORT_INSTANCE__STRING_MID = MIDPackage.MODEL___IMPORT_INSTANCE__STRING_MID;

	/**
	 * The operation id for the '<em>Import Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = MIDPackage.MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID;

	/**
	 * The operation id for the '<em>Copy Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___COPY_INSTANCE__MODEL_STRING_MID = MIDPackage.MODEL___COPY_INSTANCE__MODEL_STRING_MID;

	/**
	 * The operation id for the '<em>Copy Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = MIDPackage.MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___DELETE_INSTANCE = MIDPackage.MODEL___DELETE_INSTANCE;

	/**
	 * The operation id for the '<em>Get EMF Instance Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___GET_EMF_INSTANCE_ROOT = MIDPackage.MODEL___GET_EMF_INSTANCE_ROOT;

	/**
	 * The operation id for the '<em>Create Workflow Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID = MIDPackage.MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID;

	/**
	 * The operation id for the '<em>Delete Workflow Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___DELETE_WORKFLOW_INSTANCE = MIDPackage.MODEL___DELETE_WORKFLOW_INSTANCE;

	/**
	 * The operation id for the '<em>Open Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL___OPEN_INSTANCE = MIDPackage.MODEL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODEL_OPERATION_COUNT = MIDPackage.MODEL_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.primitive.file.FileModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see edu.toronto.cs.se.modelepedia.primitive.file.FileModel
	 * @generated
	 */
	EClass getFileModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.modelepedia.primitive.file.FileModel#openInstance() <em>Open Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Open Instance</em>' operation.
	 * @see edu.toronto.cs.se.modelepedia.primitive.file.FileModel#openInstance()
	 * @generated
	 */
	EOperation getFileModel__OpenInstance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FileFactory getFileFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.primitive.file.impl.FileModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.primitive.file.impl.FileModelImpl
		 * @see edu.toronto.cs.se.modelepedia.primitive.file.impl.FilePackageImpl#getFileModel()
		 * @generated
		 */
		EClass FILE_MODEL = eINSTANCE.getFileModel();

		/**
		 * The meta object literal for the '<em><b>Open Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FILE_MODEL___OPEN_INSTANCE = eINSTANCE.getFileModel__OpenInstance();

	}

} //FilePackage
