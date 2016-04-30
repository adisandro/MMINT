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
package edu.toronto.cs.se.mmint.mid;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see edu.toronto.cs.se.mmint.mid.MIDFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface MIDPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mid";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/mmint/MID";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mid";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MIDPackage eINSTANCE = edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.MIDImpl <em>MID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getMID()
	 * @generated
	 */
	int MID = 0;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID__MODELS = 0;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID__EDITORS = 1;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID__OPERATORS = 2;

	/**
	 * The feature id for the '<em><b>Extendible Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID__EXTENDIBLE_TABLE = 3;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID__LEVEL = 4;

	/**
	 * The number of structural features of the '<em>MID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID___IS_TYPES_LEVEL = 0;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID___IS_INSTANCES_LEVEL = 1;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID___IS_WORKFLOWS_LEVEL = 2;

	/**
	 * The number of operations of the '<em>MID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MID_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.EStringToExtendibleElementMapImpl <em>EString To Extendible Element Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.EStringToExtendibleElementMapImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getEStringToExtendibleElementMap()
	 * @generated
	 */
	int ESTRING_TO_EXTENDIBLE_ELEMENT_MAP = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To Extendible Element Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EXTENDIBLE_ELEMENT_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To Extendible Element Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EXTENDIBLE_ELEMENT_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl <em>Extendible Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getExtendibleElement()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__SUPERTYPE = 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__URI = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__LEVEL = 3;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__METATYPE_URI = 4;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__DYNAMIC = 5;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__CONSTRAINT = 6;

	/**
	 * The number of structural features of the '<em>Extendible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_FEATURE_COUNT = 7;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___GET_METATYPE = 0;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___GET_MID_CONTAINER = 1;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___IS_TYPES_LEVEL = 2;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING = 3;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___IS_INSTANCES_LEVEL = 4;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES = 5;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = 6;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE = 7;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = 8;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___IS_WORKFLOWS_LEVEL = 9;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL = 10;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL = 11;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING = 12;

	/**
	 * The number of operations of the '<em>Extendible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_OPERATION_COUNT = 13;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl <em>Extendible Element Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getExtendibleElementEndpoint()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT = 3;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__SUPERTYPE = EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__URI = EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__NAME = EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__LEVEL = EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__METATYPE_URI = EXTENDIBLE_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__DYNAMIC = EXTENDIBLE_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__CONSTRAINT = EXTENDIBLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__TARGET = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__TARGET_URI = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Extendible Element Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_FEATURE_COUNT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___GET_RUNTIME_TYPES = EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL = EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL = EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING = EXTENDIBLE_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Extendible Element Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.GenericElementImpl <em>Generic Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.GenericElementImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getGenericElement()
	 * @generated
	 */
	int GENERIC_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT__SUPERTYPE = EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT__URI = EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT__NAME = EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT__LEVEL = EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT__METATYPE_URI = EXTENDIBLE_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT__DYNAMIC = EXTENDIBLE_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT__CONSTRAINT = EXTENDIBLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT__ABSTRACT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Generic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT_FEATURE_COUNT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___GET_METATYPE = EXTENDIBLE_ELEMENT___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING = EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___GET_RUNTIME_TYPES = EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___VALIDATE_INSTANCE = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL = EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL = EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING = EXTENDIBLE_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The number of operations of the '<em>Generic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ELEMENT_OPERATION_COUNT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.ModelImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 4;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SUPERTYPE = GENERIC_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__URI = GENERIC_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = GENERIC_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__LEVEL = GENERIC_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__METATYPE_URI = GENERIC_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DYNAMIC = GENERIC_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CONSTRAINT = GENERIC_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ABSTRACT = GENERIC_ELEMENT__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ORIGIN = GENERIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__FILE_EXTENSION = GENERIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__EDITORS = GENERIC_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__MODEL_ELEMS = GENERIC_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CONVERSION_OPERATORS = GENERIC_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = GENERIC_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_MID_CONTAINER = GENERIC_ELEMENT___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___IS_TYPES_LEVEL = GENERIC_ELEMENT___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_SUBTYPE_URI__STRING_STRING = GENERIC_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___IS_INSTANCES_LEVEL = GENERIC_ELEMENT___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_RUNTIME_TYPES = GENERIC_ELEMENT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = GENERIC_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___VALIDATE_INSTANCE = GENERIC_ELEMENT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = GENERIC_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___IS_WORKFLOWS_LEVEL = GENERIC_ELEMENT___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___TO_MID_CUSTOM_PRINT_LABEL = GENERIC_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___TO_MID_CUSTOM_EDIT_LABEL = GENERIC_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___UPDATE_MID_CUSTOM_LABEL__STRING = GENERIC_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_METATYPE = GENERIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_SUPERTYPE = GENERIC_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN = GENERIC_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___DELETE_TYPE = GENERIC_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get EMF Type Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_EMF_TYPE_ROOT = GENERIC_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Open Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___OPEN_TYPE = GENERIC_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_INSTANCE__STRING_MID = GENERIC_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Create Instance Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_INSTANCE_EDITOR = GENERIC_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MID = GENERIC_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Import Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___IMPORT_INSTANCE__STRING_MID = GENERIC_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Import Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = GENERIC_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Copy Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___COPY_INSTANCE__MODEL_STRING_MID = GENERIC_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Copy Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = GENERIC_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___DELETE_INSTANCE = GENERIC_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Get EMF Instance Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_EMF_INSTANCE_ROOT = GENERIC_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Open Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___OPEN_INSTANCE = GENERIC_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = GENERIC_ELEMENT_OPERATION_COUNT + 16;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementConstraintImpl <em>Extendible Element Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementConstraintImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getExtendibleElementConstraint()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION = 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE = 1;

	/**
	 * The number of structural features of the '<em>Extendible Element Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Extendible Element Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl <em>Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__SUPERTYPE = EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__URI = EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__NAME = EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__LEVEL = EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__METATYPE_URI = EXTENDIBLE_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__DYNAMIC = EXTENDIBLE_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__CONSTRAINT = EXTENDIBLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>EInfo</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__EINFO = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING = EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___GET_RUNTIME_TYPES = EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___VALIDATE_INSTANCE = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL = EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL = EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING = EXTENDIBLE_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___GET_METATYPE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___GET_SUPERTYPE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___DELETE_TYPE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get EMF Type Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___GET_EMF_TYPE_OBJECT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___DELETE_INSTANCE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Get EMF Instance Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___GET_EMF_INSTANCE_OBJECT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The number of operations of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OPERATION_COUNT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.ModelEndpointImpl <em>Model Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.ModelEndpointImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getModelEndpoint()
	 * @generated
	 */
	int MODEL_ENDPOINT = 7;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__SUPERTYPE = EXTENDIBLE_ELEMENT_ENDPOINT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__URI = EXTENDIBLE_ELEMENT_ENDPOINT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__NAME = EXTENDIBLE_ELEMENT_ENDPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__METATYPE_URI = EXTENDIBLE_ELEMENT_ENDPOINT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__DYNAMIC = EXTENDIBLE_ELEMENT_ENDPOINT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__CONSTRAINT = EXTENDIBLE_ELEMENT_ENDPOINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__LOWER_BOUND = EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__UPPER_BOUND = EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__TARGET = EXTENDIBLE_ELEMENT_ENDPOINT__TARGET;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__TARGET_URI = EXTENDIBLE_ELEMENT_ENDPOINT__TARGET_URI;

	/**
	 * The number of structural features of the '<em>Model Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_FEATURE_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get MID Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___GET_MID_CONTAINER = EXTENDIBLE_ELEMENT_ENDPOINT___GET_MID_CONTAINER;

	/**
	 * The operation id for the '<em>Is Types Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___IS_TYPES_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT___IS_TYPES_LEVEL;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = EXTENDIBLE_ELEMENT_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Is Instances Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___IS_INSTANCES_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT___IS_INSTANCES_LEVEL;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___GET_RUNTIME_TYPES = EXTENDIBLE_ELEMENT_ENDPOINT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___VALIDATE_INSTANCE = EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>Is Workflows Level</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___IS_WORKFLOWS_LEVEL = EXTENDIBLE_ELEMENT_ENDPOINT___IS_WORKFLOWS_LEVEL;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL = EXTENDIBLE_ELEMENT_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL = EXTENDIBLE_ELEMENT_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING = EXTENDIBLE_ELEMENT_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___GET_SUPERTYPE = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___GET_TARGET = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___GET_METATYPE = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODEL_BOOLEAN_MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Replace Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_STRING_MODEL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Delete Type And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Create Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Replace Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Delete Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 11;

	/**
	 * The number of operations of the '<em>Model Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_OPERATION_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 12;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl <em>EMF Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getEMFInfo()
	 * @generated
	 */
	int EMF_INFO = 8;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_INFO__CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_INFO__FEATURE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_INFO__ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Related Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_INFO__RELATED_CLASS_NAME = 3;

	/**
	 * The number of structural features of the '<em>EMF Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_INFO_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>To Type String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_INFO___TO_TYPE_STRING = 0;

	/**
	 * The operation id for the '<em>To Instance String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_INFO___TO_INSTANCE_STRING = 1;

	/**
	 * The number of operations of the '<em>EMF Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_INFO_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.MIDLevel <em>Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.MIDLevel
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getMIDLevel()
	 * @generated
	 */
	int MID_LEVEL = 10;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.ModelOrigin <em>Model Origin</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.ModelOrigin
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getModelOrigin()
	 * @generated
	 */
	int MODEL_ORIGIN = 11;

	/**
	 * The meta object id for the '<em>MMINT Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.MMINTException
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getMMINTException()
	 * @generated
	 */
	int MMINT_EXCEPTION = 12;


	/**
	 * The meta object id for the '<em>IStatus</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IStatus
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getIStatus()
	 * @generated
	 */
	int ISTATUS = 13;

	/**
	 * The meta object id for the '<em>IValidation Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.validation.IValidationContext
	 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getIValidationContext()
	 * @generated
	 */
	int IVALIDATION_CONTEXT = 14;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.MID <em>MID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MID</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.MID
	 * @generated
	 */
	EClass getMID();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.MID#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.MID#getModels()
	 * @see #getMID()
	 * @generated
	 */
	EReference getMID_Models();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.MID#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editors</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.MID#getEditors()
	 * @see #getMID()
	 * @generated
	 */
	EReference getMID_Editors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.MID#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.MID#getOperators()
	 * @see #getMID()
	 * @generated
	 */
	EReference getMID_Operators();

	/**
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmint.mid.MID#getExtendibleTable <em>Extendible Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Extendible Table</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.MID#getExtendibleTable()
	 * @see #getMID()
	 * @generated
	 */
	EReference getMID_ExtendibleTable();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.MID#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.MID#getLevel()
	 * @see #getMID()
	 * @generated
	 */
	EAttribute getMID_Level();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.MID#isTypesLevel() <em>Is Types Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Types Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.MID#isTypesLevel()
	 * @generated
	 */
	EOperation getMID__IsTypesLevel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.MID#isInstancesLevel() <em>Is Instances Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Instances Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.MID#isInstancesLevel()
	 * @generated
	 */
	EOperation getMID__IsInstancesLevel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.MID#isWorkflowsLevel() <em>Is Workflows Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Workflows Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.MID#isWorkflowsLevel()
	 * @generated
	 */
	EOperation getMID__IsWorkflowsLevel();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Extendible Element Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Extendible Element Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="edu.toronto.cs.se.mmint.mid.ExtendibleElement" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToExtendibleElementMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToExtendibleElementMap()
	 * @generated
	 */
	EAttribute getEStringToExtendibleElementMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToExtendibleElementMap()
	 * @generated
	 */
	EReference getEStringToExtendibleElementMap_Value();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement <em>Extendible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement
	 * @generated
	 */
	EClass getExtendibleElement();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getSupertype <em>Supertype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supertype</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getSupertype()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EReference getExtendibleElement_Supertype();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getUri()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_Uri();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getName()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getLevel()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_Level();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getMetatypeUri <em>Metatype Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metatype Uri</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getMetatypeUri()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_MetatypeUri();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#isDynamic <em>Dynamic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamic</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#isDynamic()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_Dynamic();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getConstraint()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EReference getExtendibleElement_Constraint();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getMetatype()
	 * @generated
	 */
	EOperation getExtendibleElement__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getMIDContainer() <em>Get MID Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get MID Container</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getMIDContainer()
	 * @generated
	 */
	EOperation getExtendibleElement__GetMIDContainer();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#isTypesLevel() <em>Is Types Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Types Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#isTypesLevel()
	 * @generated
	 */
	EOperation getExtendibleElement__IsTypesLevel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#getRuntimeTypes() <em>Get Runtime Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Runtime Types</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#getRuntimeTypes()
	 * @generated
	 */
	EOperation getExtendibleElement__GetRuntimeTypes();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#validateInstanceType(edu.toronto.cs.se.mmint.mid.ExtendibleElement) <em>Validate Instance Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Instance Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#validateInstanceType(edu.toronto.cs.se.mmint.mid.ExtendibleElement)
	 * @generated
	 */
	EOperation getExtendibleElement__ValidateInstanceType__ExtendibleElement();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#validateInstance() <em>Validate Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#validateInstance()
	 * @generated
	 */
	EOperation getExtendibleElement__ValidateInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#validateInstanceInEditor(org.eclipse.emf.validation.IValidationContext) <em>Validate Instance In Editor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Instance In Editor</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#validateInstanceInEditor(org.eclipse.emf.validation.IValidationContext)
	 * @generated
	 */
	EOperation getExtendibleElement__ValidateInstanceInEditor__IValidationContext();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#isWorkflowsLevel() <em>Is Workflows Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Workflows Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#isWorkflowsLevel()
	 * @generated
	 */
	EOperation getExtendibleElement__IsWorkflowsLevel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#toMIDCustomPrintLabel() <em>To MID Custom Print Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To MID Custom Print Label</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#toMIDCustomPrintLabel()
	 * @generated
	 */
	EOperation getExtendibleElement__ToMIDCustomPrintLabel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#toMIDCustomEditLabel() <em>To MID Custom Edit Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To MID Custom Edit Label</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#toMIDCustomEditLabel()
	 * @generated
	 */
	EOperation getExtendibleElement__ToMIDCustomEditLabel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#updateMIDCustomLabel(java.lang.String) <em>Update MID Custom Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Update MID Custom Label</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#updateMIDCustomLabel(java.lang.String)
	 * @generated
	 */
	EOperation getExtendibleElement__UpdateMIDCustomLabel__String();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#createSubtypeUri(java.lang.String, java.lang.String) <em>Create Subtype Uri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype Uri</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#createSubtypeUri(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getExtendibleElement__CreateSubtypeUri__String_String();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement#isInstancesLevel() <em>Is Instances Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Instances Level</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement#isInstancesLevel()
	 * @generated
	 */
	EOperation getExtendibleElement__IsInstancesLevel();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint <em>Extendible Element Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint
	 * @generated
	 */
	EClass getExtendibleElementEndpoint();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getLowerBound()
	 * @see #getExtendibleElementEndpoint()
	 * @generated
	 */
	EAttribute getExtendibleElementEndpoint_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getUpperBound()
	 * @see #getExtendibleElementEndpoint()
	 * @generated
	 */
	EAttribute getExtendibleElementEndpoint_UpperBound();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getTarget()
	 * @see #getExtendibleElementEndpoint()
	 * @generated
	 */
	EReference getExtendibleElementEndpoint_Target();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getTargetUri <em>Target Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Uri</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getTargetUri()
	 * @see #getExtendibleElementEndpoint()
	 * @generated
	 */
	EAttribute getExtendibleElementEndpoint_TargetUri();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getMetatype()
	 * @generated
	 */
	EOperation getExtendibleElementEndpoint__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getSupertype()
	 * @generated
	 */
	EOperation getExtendibleElementEndpoint__GetSupertype();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.Model#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getOrigin()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Origin();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.Model#getFileExtension <em>File Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Extension</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getFileExtension()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_FileExtension();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.mid.Model#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getEditors()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Editors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.Model#getModelElems <em>Model Elems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elems</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getModelElems()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ModelElems();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.mid.Model#getConversionOperators <em>Conversion Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conversion Operators</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getConversionOperators()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ConversionOperators();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getMetatype()
	 * @generated
	 */
	EOperation getModel__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getSupertype()
	 * @generated
	 */
	EOperation getModel__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#createSubtype(java.lang.String, java.lang.String, java.lang.String, boolean) <em>Create Subtype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#createSubtype(java.lang.String, java.lang.String, java.lang.String, boolean)
	 * @generated
	 */
	EOperation getModel__CreateSubtype__String_String_String_boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#deleteType()
	 * @generated
	 */
	EOperation getModel__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#getEMFTypeRoot() <em>Get EMF Type Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Type Root</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getEMFTypeRoot()
	 * @generated
	 */
	EOperation getModel__GetEMFTypeRoot();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#createInstance(java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#createInstance(java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModel__CreateInstance__String_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#createInstanceEditor() <em>Create Instance Editor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Editor</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#createInstanceEditor()
	 * @generated
	 */
	EOperation getModel__CreateInstanceEditor();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#createInstanceAndEditor(java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Create Instance And Editor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Editor</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#createInstanceAndEditor(java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModel__CreateInstanceAndEditor__String_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#importInstance(java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Import Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Import Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#importInstance(java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModel__ImportInstance__String_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#importInstanceAndEditor(java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Import Instance And Editor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Import Instance And Editor</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#importInstanceAndEditor(java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModel__ImportInstanceAndEditor__String_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#copyInstance(edu.toronto.cs.se.mmint.mid.Model, java.lang.String, edu.toronto.cs.se.mmint.mid.MID) <em>Copy Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#copyInstance(edu.toronto.cs.se.mmint.mid.Model, java.lang.String, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModel__CopyInstance__Model_String_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#copyInstanceAndEditor(edu.toronto.cs.se.mmint.mid.Model, java.lang.String, boolean, edu.toronto.cs.se.mmint.mid.MID) <em>Copy Instance And Editor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy Instance And Editor</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#copyInstanceAndEditor(edu.toronto.cs.se.mmint.mid.Model, java.lang.String, boolean, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getModel__CopyInstanceAndEditor__Model_String_boolean_MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#deleteInstance()
	 * @generated
	 */
	EOperation getModel__DeleteInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#getEMFInstanceRoot() <em>Get EMF Instance Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Instance Root</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#getEMFInstanceRoot()
	 * @generated
	 */
	EOperation getModel__GetEMFInstanceRoot();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#openType() <em>Open Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Open Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#openType()
	 * @generated
	 */
	EOperation getModel__OpenType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.Model#openInstance() <em>Open Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Open Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.Model#openInstance()
	 * @generated
	 */
	EOperation getModel__OpenInstance();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint <em>Extendible Element Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element Constraint</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint
	 * @generated
	 */
	EClass getExtendibleElementConstraint();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint#getImplementation()
	 * @see #getExtendibleElementConstraint()
	 * @generated
	 */
	EAttribute getExtendibleElementConstraint_Implementation();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint#getLanguage()
	 * @see #getExtendibleElementConstraint()
	 * @generated
	 */
	EAttribute getExtendibleElementConstraint_Language();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint.mid.ModelElement#getEInfo <em>EInfo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EInfo</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#getEInfo()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_EInfo();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#getMetatype()
	 * @generated
	 */
	EOperation getModelElement__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#getSupertype()
	 * @generated
	 */
	EOperation getModelElement__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#createTypeReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#createTypeReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference)
	 * @generated
	 */
	EOperation getModelElement__CreateTypeReference__ModelElementReference_boolean_ModelEndpointReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#createSubtypeAndReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, java.lang.String, java.lang.String, edu.toronto.cs.se.mmint.mid.EMFInfo, edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference) <em>Create Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#createSubtypeAndReference(edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference, java.lang.String, java.lang.String, edu.toronto.cs.se.mmint.mid.EMFInfo, edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference)
	 * @generated
	 */
	EOperation getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_EMFInfo_ModelEndpointReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#deleteType()
	 * @generated
	 */
	EOperation getModelElement__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#getEMFTypeObject() <em>Get EMF Type Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Type Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#getEMFTypeObject()
	 * @generated
	 */
	EOperation getModelElement__GetEMFTypeObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#createInstanceReference(edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#createInstanceReference(edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference)
	 * @generated
	 */
	EOperation getModelElement__CreateInstanceReference__ModelEndpointReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#createInstanceAndReference(java.lang.String, java.lang.String, edu.toronto.cs.se.mmint.mid.EMFInfo, edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference) <em>Create Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#createInstanceAndReference(java.lang.String, java.lang.String, edu.toronto.cs.se.mmint.mid.EMFInfo, edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference)
	 * @generated
	 */
	EOperation getModelElement__CreateInstanceAndReference__String_String_EMFInfo_ModelEndpointReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#deleteInstance()
	 * @generated
	 */
	EOperation getModelElement__DeleteInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#getEMFInstanceObject() <em>Get EMF Instance Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Instance Object</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelElement#getEMFInstanceObject()
	 * @generated
	 */
	EOperation getModelElement__GetEMFInstanceObject();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint <em>Model Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint
	 * @generated
	 */
	EClass getModelEndpoint();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#getSupertype()
	 * @generated
	 */
	EOperation getModelEndpoint__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#getTarget()
	 * @generated
	 */
	EOperation getModelEndpoint__GetTarget();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#getMetatype()
	 * @generated
	 */
	EOperation getModelEndpoint__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#createTypeReference(boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#createTypeReference(boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateTypeReference__boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#createSubtypeAndReference(java.lang.String, edu.toronto.cs.se.mmint.mid.Model, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#createSubtypeAndReference(java.lang.String, edu.toronto.cs.se.mmint.mid.Model, boolean, edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateSubtypeAndReference__String_Model_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#replaceSubtypeAndReference(edu.toronto.cs.se.mmint.mid.ModelEndpoint, java.lang.String, edu.toronto.cs.se.mmint.mid.Model) <em>Replace Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Replace Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#replaceSubtypeAndReference(edu.toronto.cs.se.mmint.mid.ModelEndpoint, java.lang.String, edu.toronto.cs.se.mmint.mid.Model)
	 * @generated
	 */
	EOperation getModelEndpoint__ReplaceSubtypeAndReference__ModelEndpoint_String_Model();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#deleteTypeAndReference(boolean) <em>Delete Type And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#deleteTypeAndReference(boolean)
	 * @generated
	 */
	EOperation getModelEndpoint__DeleteTypeAndReference__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#createInstanceReference(edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#createInstanceReference(edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateInstanceReference__ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#createInstanceAndReference(edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.relationship.ModelRel) <em>Create Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#createInstanceAndReference(edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateInstanceAndReference__Model_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#createInstance(edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.operator.Operator, java.lang.String) <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#createInstance(edu.toronto.cs.se.mmint.mid.Model, edu.toronto.cs.se.mmint.mid.operator.Operator, java.lang.String)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateInstance__Model_Operator_String();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#replaceInstanceAndReference(edu.toronto.cs.se.mmint.mid.ModelEndpoint, edu.toronto.cs.se.mmint.mid.Model) <em>Replace Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Replace Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#replaceInstanceAndReference(edu.toronto.cs.se.mmint.mid.ModelEndpoint, edu.toronto.cs.se.mmint.mid.Model)
	 * @generated
	 */
	EOperation getModelEndpoint__ReplaceInstanceAndReference__ModelEndpoint_Model();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint#deleteInstanceAndReference(boolean) <em>Delete Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint#deleteInstanceAndReference(boolean)
	 * @generated
	 */
	EOperation getModelEndpoint__DeleteInstanceAndReference__boolean();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.EMFInfo <em>EMF Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Info</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.EMFInfo
	 * @generated
	 */
	EClass getEMFInfo();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.EMFInfo#getClassName()
	 * @see #getEMFInfo()
	 * @generated
	 */
	EAttribute getEMFInfo_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.EMFInfo#getFeatureName()
	 * @see #getEMFInfo()
	 * @generated
	 */
	EAttribute getEMFInfo_FeatureName();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#isAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.EMFInfo#isAttribute()
	 * @see #getEMFInfo()
	 * @generated
	 */
	EAttribute getEMFInfo_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getRelatedClassName <em>Related Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Related Class Name</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.EMFInfo#getRelatedClassName()
	 * @see #getEMFInfo()
	 * @generated
	 */
	EAttribute getEMFInfo_RelatedClassName();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#toTypeString() <em>To Type String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Type String</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.EMFInfo#toTypeString()
	 * @generated
	 */
	EOperation getEMFInfo__ToTypeString();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#toInstanceString() <em>To Instance String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Instance String</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.EMFInfo#toInstanceString()
	 * @generated
	 */
	EOperation getEMFInfo__ToInstanceString();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.GenericElement <em>Generic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Element</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.GenericElement
	 * @generated
	 */
	EClass getGenericElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.GenericElement#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.GenericElement#isAbstract()
	 * @see #getGenericElement()
	 * @generated
	 */
	EAttribute getGenericElement_Abstract();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmint.mid.MIDLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Level</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.MIDLevel
	 * @generated
	 */
	EEnum getMIDLevel();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmint.mid.ModelOrigin <em>Model Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Origin</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.ModelOrigin
	 * @generated
	 */
	EEnum getModelOrigin();

	/**
	 * Returns the meta object for data type '{@link edu.toronto.cs.se.mmint.MMINTException <em>MMINT Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>MMINT Exception</em>'.
	 * @see edu.toronto.cs.se.mmint.MMINTException
	 * @model instanceClass="edu.toronto.cs.se.mmint.MMINTException"
	 * @generated
	 */
	EDataType getMMINTException();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IStatus <em>IStatus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IStatus</em>'.
	 * @see org.eclipse.core.runtime.IStatus
	 * @model instanceClass="org.eclipse.core.runtime.IStatus"
	 * @generated
	 */
	EDataType getIStatus();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.validation.IValidationContext <em>IValidation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IValidation Context</em>'.
	 * @see org.eclipse.emf.validation.IValidationContext
	 * @model instanceClass="org.eclipse.emf.validation.IValidationContext"
	 * @generated
	 */
	EDataType getIValidationContext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MIDFactory getMIDFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.MIDImpl <em>MID</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getMID()
		 * @generated
		 */
		EClass MID = eINSTANCE.getMID();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MID__MODELS = eINSTANCE.getMID_Models();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MID__EDITORS = eINSTANCE.getMID_Editors();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MID__OPERATORS = eINSTANCE.getMID_Operators();

		/**
		 * The meta object literal for the '<em><b>Extendible Table</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MID__EXTENDIBLE_TABLE = eINSTANCE.getMID_ExtendibleTable();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MID__LEVEL = eINSTANCE.getMID_Level();

		/**
		 * The meta object literal for the '<em><b>Is Types Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MID___IS_TYPES_LEVEL = eINSTANCE.getMID__IsTypesLevel();

		/**
		 * The meta object literal for the '<em><b>Is Instances Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MID___IS_INSTANCES_LEVEL = eINSTANCE.getMID__IsInstancesLevel();

		/**
		 * The meta object literal for the '<em><b>Is Workflows Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MID___IS_WORKFLOWS_LEVEL = eINSTANCE.getMID__IsWorkflowsLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.EStringToExtendibleElementMapImpl <em>EString To Extendible Element Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.EStringToExtendibleElementMapImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getEStringToExtendibleElementMap()
		 * @generated
		 */
		EClass ESTRING_TO_EXTENDIBLE_ELEMENT_MAP = eINSTANCE.getEStringToExtendibleElementMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY = eINSTANCE.getEStringToExtendibleElementMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE = eINSTANCE.getEStringToExtendibleElementMap_Value();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl <em>Extendible Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getExtendibleElement()
		 * @generated
		 */
		EClass EXTENDIBLE_ELEMENT = eINSTANCE.getExtendibleElement();

		/**
		 * The meta object literal for the '<em><b>Supertype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT__SUPERTYPE = eINSTANCE.getExtendibleElement_Supertype();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT__URI = eINSTANCE.getExtendibleElement_Uri();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT__NAME = eINSTANCE.getExtendibleElement_Name();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT__LEVEL = eINSTANCE.getExtendibleElement_Level();

		/**
		 * The meta object literal for the '<em><b>Metatype Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT__METATYPE_URI = eINSTANCE.getExtendibleElement_MetatypeUri();

		/**
		 * The meta object literal for the '<em><b>Dynamic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT__DYNAMIC = eINSTANCE.getExtendibleElement_Dynamic();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT__CONSTRAINT = eINSTANCE.getExtendibleElement_Constraint();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___GET_METATYPE = eINSTANCE.getExtendibleElement__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get MID Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___GET_MID_CONTAINER = eINSTANCE.getExtendibleElement__GetMIDContainer();

		/**
		 * The meta object literal for the '<em><b>Is Types Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___IS_TYPES_LEVEL = eINSTANCE.getExtendibleElement__IsTypesLevel();

		/**
		 * The meta object literal for the '<em><b>Get Runtime Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES = eINSTANCE.getExtendibleElement__GetRuntimeTypes();

		/**
		 * The meta object literal for the '<em><b>Validate Instance Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = eINSTANCE.getExtendibleElement__ValidateInstanceType__ExtendibleElement();

		/**
		 * The meta object literal for the '<em><b>Validate Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE = eINSTANCE.getExtendibleElement__ValidateInstance();

		/**
		 * The meta object literal for the '<em><b>Validate Instance In Editor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = eINSTANCE.getExtendibleElement__ValidateInstanceInEditor__IValidationContext();

		/**
		 * The meta object literal for the '<em><b>Is Workflows Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___IS_WORKFLOWS_LEVEL = eINSTANCE.getExtendibleElement__IsWorkflowsLevel();

		/**
		 * The meta object literal for the '<em><b>To MID Custom Print Label</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL = eINSTANCE.getExtendibleElement__ToMIDCustomPrintLabel();

		/**
		 * The meta object literal for the '<em><b>To MID Custom Edit Label</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL = eINSTANCE.getExtendibleElement__ToMIDCustomEditLabel();

		/**
		 * The meta object literal for the '<em><b>Update MID Custom Label</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING = eINSTANCE.getExtendibleElement__UpdateMIDCustomLabel__String();

		/**
		 * The meta object literal for the '<em><b>Create Subtype Uri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING = eINSTANCE.getExtendibleElement__CreateSubtypeUri__String_String();

		/**
		 * The meta object literal for the '<em><b>Is Instances Level</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___IS_INSTANCES_LEVEL = eINSTANCE.getExtendibleElement__IsInstancesLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl <em>Extendible Element Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getExtendibleElementEndpoint()
		 * @generated
		 */
		EClass EXTENDIBLE_ELEMENT_ENDPOINT = eINSTANCE.getExtendibleElementEndpoint();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND = eINSTANCE.getExtendibleElementEndpoint_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND = eINSTANCE.getExtendibleElementEndpoint_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT_ENDPOINT__TARGET = eINSTANCE.getExtendibleElementEndpoint_Target();

		/**
		 * The meta object literal for the '<em><b>Target Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_ENDPOINT__TARGET_URI = eINSTANCE.getExtendibleElementEndpoint_TargetUri();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE = eINSTANCE.getExtendibleElementEndpoint__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE = eINSTANCE.getExtendibleElementEndpoint__GetSupertype();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.ModelImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ORIGIN = eINSTANCE.getModel_Origin();

		/**
		 * The meta object literal for the '<em><b>File Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__FILE_EXTENSION = eINSTANCE.getModel_FileExtension();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__EDITORS = eINSTANCE.getModel_Editors();

		/**
		 * The meta object literal for the '<em><b>Model Elems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__MODEL_ELEMS = eINSTANCE.getModel_ModelElems();

		/**
		 * The meta object literal for the '<em><b>Conversion Operators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__CONVERSION_OPERATORS = eINSTANCE.getModel_ConversionOperators();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___GET_METATYPE = eINSTANCE.getModel__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___GET_SUPERTYPE = eINSTANCE.getModel__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Create Subtype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN = eINSTANCE.getModel__CreateSubtype__String_String_String_boolean();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___DELETE_TYPE = eINSTANCE.getModel__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Get EMF Type Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___GET_EMF_TYPE_ROOT = eINSTANCE.getModel__GetEMFTypeRoot();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___CREATE_INSTANCE__STRING_MID = eINSTANCE.getModel__CreateInstance__String_MID();

		/**
		 * The meta object literal for the '<em><b>Create Instance Editor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___CREATE_INSTANCE_EDITOR = eINSTANCE.getModel__CreateInstanceEditor();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Editor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MID = eINSTANCE.getModel__CreateInstanceAndEditor__String_MID();

		/**
		 * The meta object literal for the '<em><b>Import Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___IMPORT_INSTANCE__STRING_MID = eINSTANCE.getModel__ImportInstance__String_MID();

		/**
		 * The meta object literal for the '<em><b>Import Instance And Editor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID = eINSTANCE.getModel__ImportInstanceAndEditor__String_MID();

		/**
		 * The meta object literal for the '<em><b>Copy Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___COPY_INSTANCE__MODEL_STRING_MID = eINSTANCE.getModel__CopyInstance__Model_String_MID();

		/**
		 * The meta object literal for the '<em><b>Copy Instance And Editor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID = eINSTANCE.getModel__CopyInstanceAndEditor__Model_String_boolean_MID();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___DELETE_INSTANCE = eINSTANCE.getModel__DeleteInstance();

		/**
		 * The meta object literal for the '<em><b>Get EMF Instance Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___GET_EMF_INSTANCE_ROOT = eINSTANCE.getModel__GetEMFInstanceRoot();

		/**
		 * The meta object literal for the '<em><b>Open Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___OPEN_TYPE = eINSTANCE.getModel__OpenType();

		/**
		 * The meta object literal for the '<em><b>Open Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___OPEN_INSTANCE = eINSTANCE.getModel__OpenInstance();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementConstraintImpl <em>Extendible Element Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementConstraintImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getExtendibleElementConstraint()
		 * @generated
		 */
		EClass EXTENDIBLE_ELEMENT_CONSTRAINT = eINSTANCE.getExtendibleElementConstraint();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION = eINSTANCE.getExtendibleElementConstraint_Implementation();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE = eINSTANCE.getExtendibleElementConstraint_Language();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl <em>Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getModelElement()
		 * @generated
		 */
		EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

		/**
		 * The meta object literal for the '<em><b>EInfo</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__EINFO = eINSTANCE.getModelElement_EInfo();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___GET_METATYPE = eINSTANCE.getModelElement__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___GET_SUPERTYPE = eINSTANCE.getModelElement__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Create Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE = eINSTANCE.getModelElement__CreateTypeReference__ModelElementReference_boolean_ModelEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Create Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE = eINSTANCE.getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_EMFInfo_ModelEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___DELETE_TYPE = eINSTANCE.getModelElement__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Get EMF Type Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___GET_EMF_TYPE_OBJECT = eINSTANCE.getModelElement__GetEMFTypeObject();

		/**
		 * The meta object literal for the '<em><b>Create Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE = eINSTANCE.getModelElement__CreateInstanceReference__ModelEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE = eINSTANCE.getModelElement__CreateInstanceAndReference__String_String_EMFInfo_ModelEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___DELETE_INSTANCE = eINSTANCE.getModelElement__DeleteInstance();

		/**
		 * The meta object literal for the '<em><b>Get EMF Instance Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT___GET_EMF_INSTANCE_OBJECT = eINSTANCE.getModelElement__GetEMFInstanceObject();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.ModelEndpointImpl <em>Model Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.ModelEndpointImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getModelEndpoint()
		 * @generated
		 */
		EClass MODEL_ENDPOINT = eINSTANCE.getModelEndpoint();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___GET_SUPERTYPE = eINSTANCE.getModelEndpoint__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___GET_TARGET = eINSTANCE.getModelEndpoint__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___GET_METATYPE = eINSTANCE.getModelEndpoint__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Create Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL = eINSTANCE.getModelEndpoint__CreateTypeReference__boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODEL_BOOLEAN_MODELREL = eINSTANCE.getModelEndpoint__CreateSubtypeAndReference__String_Model_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Replace Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_STRING_MODEL = eINSTANCE.getModelEndpoint__ReplaceSubtypeAndReference__ModelEndpoint_String_Model();

		/**
		 * The meta object literal for the '<em><b>Delete Type And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN = eINSTANCE.getModelEndpoint__DeleteTypeAndReference__boolean();

		/**
		 * The meta object literal for the '<em><b>Create Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL = eINSTANCE.getModelEndpoint__CreateInstanceReference__ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_MODELREL = eINSTANCE.getModelEndpoint__CreateInstanceAndReference__Model_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING = eINSTANCE.getModelEndpoint__CreateInstance__Model_Operator_String();

		/**
		 * The meta object literal for the '<em><b>Replace Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL = eINSTANCE.getModelEndpoint__ReplaceInstanceAndReference__ModelEndpoint_Model();

		/**
		 * The meta object literal for the '<em><b>Delete Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN = eINSTANCE.getModelEndpoint__DeleteInstanceAndReference__boolean();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl <em>EMF Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getEMFInfo()
		 * @generated
		 */
		EClass EMF_INFO = eINSTANCE.getEMFInfo();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_INFO__CLASS_NAME = eINSTANCE.getEMFInfo_ClassName();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_INFO__FEATURE_NAME = eINSTANCE.getEMFInfo_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_INFO__ATTRIBUTE = eINSTANCE.getEMFInfo_Attribute();

		/**
		 * The meta object literal for the '<em><b>Related Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_INFO__RELATED_CLASS_NAME = eINSTANCE.getEMFInfo_RelatedClassName();

		/**
		 * The meta object literal for the '<em><b>To Type String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EMF_INFO___TO_TYPE_STRING = eINSTANCE.getEMFInfo__ToTypeString();

		/**
		 * The meta object literal for the '<em><b>To Instance String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EMF_INFO___TO_INSTANCE_STRING = eINSTANCE.getEMFInfo__ToInstanceString();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.impl.GenericElementImpl <em>Generic Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.impl.GenericElementImpl
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getGenericElement()
		 * @generated
		 */
		EClass GENERIC_ELEMENT = eINSTANCE.getGenericElement();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_ELEMENT__ABSTRACT = eINSTANCE.getGenericElement_Abstract();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.MIDLevel <em>Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.MIDLevel
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getMIDLevel()
		 * @generated
		 */
		EEnum MID_LEVEL = eINSTANCE.getMIDLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.ModelOrigin <em>Model Origin</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.ModelOrigin
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getModelOrigin()
		 * @generated
		 */
		EEnum MODEL_ORIGIN = eINSTANCE.getModelOrigin();

		/**
		 * The meta object literal for the '<em>MMINT Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.MMINTException
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getMMINTException()
		 * @generated
		 */
		EDataType MMINT_EXCEPTION = eINSTANCE.getMMINTException();

		/**
		 * The meta object literal for the '<em>IStatus</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IStatus
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getIStatus()
		 * @generated
		 */
		EDataType ISTATUS = eINSTANCE.getIStatus();

		/**
		 * The meta object literal for the '<em>IValidation Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.validation.IValidationContext
		 * @see edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl#getIValidationContext()
		 * @generated
		 */
		EDataType IVALIDATION_CONTEXT = eINSTANCE.getIValidationContext();

	}

} //MIDPackage
