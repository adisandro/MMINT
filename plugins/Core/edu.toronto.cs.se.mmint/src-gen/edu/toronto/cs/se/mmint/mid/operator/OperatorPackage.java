/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.operator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface OperatorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/mmint/MID/Operator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "operator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperatorPackage eINSTANCE = edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SUPERTYPE = MIDPackage.GENERIC_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__URI = MIDPackage.GENERIC_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NAME = MIDPackage.GENERIC_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__LEVEL = MIDPackage.GENERIC_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__METATYPE_URI = MIDPackage.GENERIC_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__DYNAMIC = MIDPackage.GENERIC_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__CONSTRAINT = MIDPackage.GENERIC_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__ABSTRACT = MIDPackage.GENERIC_ELEMENT__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__INPUTS = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OUTPUTS = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__GENERICS = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input Subdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__INPUT_SUBDIR = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Previous Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__PREVIOUS_OPERATOR = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Update MID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__UPDATE_MID = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__EXECUTION_TIME = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Commutative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__COMMUTATIVE = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = MIDPackage.GENERIC_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.GENERIC_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_RUNTIME_TYPES = MIDPackage.GENERIC_ELEMENT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.GENERIC_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___VALIDATE_INSTANCE = MIDPackage.GENERIC_ELEMENT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.GENERIC_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.GENERIC_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.GENERIC_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.GENERIC_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_METATYPE = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_SUPERTYPE = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___DELETE_TYPE = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Find Allowed Inputs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___FIND_ALLOWED_INPUTS__ELIST = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Find First Allowed Input</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Check Allowed Inputs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___CHECK_ALLOWED_INPUTS__ELIST = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Allowed Input</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___IS_ALLOWED_INPUT__MAP = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Outputs By Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_OUTPUTS_BY_NAME = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___CREATE_INSTANCE__MID = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___DELETE_INSTANCE = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Select Allowed Generics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___SELECT_ALLOWED_GENERICS__ELIST = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Allowed Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___IS_ALLOWED_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Get Input Properties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_INPUT_PROPERTIES = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Read Input Properties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___INIT = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Run</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___RUN__MAP_MAP_MAP = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___START__ELIST_ELIST_MAP_MID = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 16;

	/**
	 * The number of operations of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_OPERATION_COUNT = MIDPackage.GENERIC_ELEMENT_OPERATION_COUNT + 17;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl <em>Conversion Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getConversionOperator()
	 * @generated
	 */
	int CONVERSION_OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__SUPERTYPE = OPERATOR__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__URI = OPERATOR__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__NAME = OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__LEVEL = OPERATOR__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__METATYPE_URI = OPERATOR__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__DYNAMIC = OPERATOR__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__CONSTRAINT = OPERATOR__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__ABSTRACT = OPERATOR__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__INPUTS = OPERATOR__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__OUTPUTS = OPERATOR__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Generics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__GENERICS = OPERATOR__GENERICS;

	/**
	 * The feature id for the '<em><b>Input Subdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__INPUT_SUBDIR = OPERATOR__INPUT_SUBDIR;

	/**
	 * The feature id for the '<em><b>Previous Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__PREVIOUS_OPERATOR = OPERATOR__PREVIOUS_OPERATOR;

	/**
	 * The feature id for the '<em><b>Update MID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__UPDATE_MID = OPERATOR__UPDATE_MID;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__EXECUTION_TIME = OPERATOR__EXECUTION_TIME;

	/**
	 * The feature id for the '<em><b>Commutative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__COMMUTATIVE = OPERATOR__COMMUTATIVE;

	/**
	 * The number of structural features of the '<em>Conversion Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___CREATE_SUBTYPE_URI__STRING_STRING = OPERATOR___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___GET_RUNTIME_TYPES = OPERATOR___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = OPERATOR___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___VALIDATE_INSTANCE = OPERATOR___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = OPERATOR___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___TO_MID_CUSTOM_PRINT_LABEL = OPERATOR___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___TO_MID_CUSTOM_EDIT_LABEL = OPERATOR___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___UPDATE_MID_CUSTOM_LABEL__STRING = OPERATOR___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___GET_METATYPE = OPERATOR___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___GET_SUPERTYPE = OPERATOR___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Find Allowed Inputs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___FIND_ALLOWED_INPUTS__ELIST = OPERATOR___FIND_ALLOWED_INPUTS__ELIST;

	/**
	 * The operation id for the '<em>Find First Allowed Input</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST = OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST;

	/**
	 * The operation id for the '<em>Check Allowed Inputs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___CHECK_ALLOWED_INPUTS__ELIST = OPERATOR___CHECK_ALLOWED_INPUTS__ELIST;

	/**
	 * The operation id for the '<em>Is Allowed Input</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___IS_ALLOWED_INPUT__MAP = OPERATOR___IS_ALLOWED_INPUT__MAP;

	/**
	 * The operation id for the '<em>Get Outputs By Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___GET_OUTPUTS_BY_NAME = OPERATOR___GET_OUTPUTS_BY_NAME;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___CREATE_INSTANCE__MID = OPERATOR___CREATE_INSTANCE__MID;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___DELETE_INSTANCE = OPERATOR___DELETE_INSTANCE;

	/**
	 * The operation id for the '<em>Select Allowed Generics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___SELECT_ALLOWED_GENERICS__ELIST = OPERATOR___SELECT_ALLOWED_GENERICS__ELIST;

	/**
	 * The operation id for the '<em>Is Allowed Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___IS_ALLOWED_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST = OPERATOR___IS_ALLOWED_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST;

	/**
	 * The operation id for the '<em>Get Input Properties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___GET_INPUT_PROPERTIES = OPERATOR___GET_INPUT_PROPERTIES;

	/**
	 * The operation id for the '<em>Read Input Properties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES = OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___INIT = OPERATOR___INIT;

	/**
	 * The operation id for the '<em>Run</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___RUN__MAP_MAP_MAP = OPERATOR___RUN__MAP_MAP_MAP;

	/**
	 * The operation id for the '<em>Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___START__ELIST_ELIST_MAP_MID = OPERATOR___START__ELIST_ELIST_MAP_MID;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___DELETE_TYPE = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Cleanup</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___CLEANUP = OPERATOR_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Conversion Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl <em>Random Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getRandomOperator()
	 * @generated
	 */
	int RANDOM_OPERATOR = 2;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__SUPERTYPE = OPERATOR__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__URI = OPERATOR__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__NAME = OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__LEVEL = OPERATOR__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__METATYPE_URI = OPERATOR__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__DYNAMIC = OPERATOR__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__CONSTRAINT = OPERATOR__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__ABSTRACT = OPERATOR__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__INPUTS = OPERATOR__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__OUTPUTS = OPERATOR__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Generics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__GENERICS = OPERATOR__GENERICS;

	/**
	 * The feature id for the '<em><b>Input Subdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__INPUT_SUBDIR = OPERATOR__INPUT_SUBDIR;

	/**
	 * The feature id for the '<em><b>Previous Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__PREVIOUS_OPERATOR = OPERATOR__PREVIOUS_OPERATOR;

	/**
	 * The feature id for the '<em><b>Update MID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__UPDATE_MID = OPERATOR__UPDATE_MID;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__EXECUTION_TIME = OPERATOR__EXECUTION_TIME;

	/**
	 * The feature id for the '<em><b>Commutative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__COMMUTATIVE = OPERATOR__COMMUTATIVE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__STATE = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Random Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___CREATE_SUBTYPE_URI__STRING_STRING = OPERATOR___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___GET_RUNTIME_TYPES = OPERATOR___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = OPERATOR___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___VALIDATE_INSTANCE = OPERATOR___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = OPERATOR___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___TO_MID_CUSTOM_PRINT_LABEL = OPERATOR___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___TO_MID_CUSTOM_EDIT_LABEL = OPERATOR___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___UPDATE_MID_CUSTOM_LABEL__STRING = OPERATOR___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___GET_METATYPE = OPERATOR___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___GET_SUPERTYPE = OPERATOR___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___DELETE_TYPE = OPERATOR___DELETE_TYPE;

	/**
	 * The operation id for the '<em>Find Allowed Inputs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___FIND_ALLOWED_INPUTS__ELIST = OPERATOR___FIND_ALLOWED_INPUTS__ELIST;

	/**
	 * The operation id for the '<em>Find First Allowed Input</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST = OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST;

	/**
	 * The operation id for the '<em>Check Allowed Inputs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___CHECK_ALLOWED_INPUTS__ELIST = OPERATOR___CHECK_ALLOWED_INPUTS__ELIST;

	/**
	 * The operation id for the '<em>Is Allowed Input</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___IS_ALLOWED_INPUT__MAP = OPERATOR___IS_ALLOWED_INPUT__MAP;

	/**
	 * The operation id for the '<em>Get Outputs By Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___GET_OUTPUTS_BY_NAME = OPERATOR___GET_OUTPUTS_BY_NAME;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___CREATE_INSTANCE__MID = OPERATOR___CREATE_INSTANCE__MID;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___DELETE_INSTANCE = OPERATOR___DELETE_INSTANCE;

	/**
	 * The operation id for the '<em>Select Allowed Generics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___SELECT_ALLOWED_GENERICS__ELIST = OPERATOR___SELECT_ALLOWED_GENERICS__ELIST;

	/**
	 * The operation id for the '<em>Is Allowed Generic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___IS_ALLOWED_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST = OPERATOR___IS_ALLOWED_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST;

	/**
	 * The operation id for the '<em>Get Input Properties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___GET_INPUT_PROPERTIES = OPERATOR___GET_INPUT_PROPERTIES;

	/**
	 * The operation id for the '<em>Read Input Properties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES = OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___INIT = OPERATOR___INIT;

	/**
	 * The operation id for the '<em>Run</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___RUN__MAP_MAP_MAP = OPERATOR___RUN__MAP_MAP_MAP;

	/**
	 * The operation id for the '<em>Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___START__ELIST_ELIST_MAP_MID = OPERATOR___START__ELIST_ELIST_MAP_MID;

	/**
	 * The number of operations of the '<em>Random Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.GenericEndpointImpl <em>Generic Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.GenericEndpointImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getGenericEndpoint()
	 * @generated
	 */
	int GENERIC_ENDPOINT = 3;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__SUPERTYPE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__URI = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__NAME = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__LEVEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__METATYPE_URI = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__DYNAMIC = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__CONSTRAINT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__LOWER_BOUND = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__UPPER_BOUND = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__TARGET = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__TARGET_URI = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Metatarget Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT__METATARGET_URI = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Generic Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT_FEATURE_COUNT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Get Runtime Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___GET_RUNTIME_TYPES = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_RUNTIME_TYPES;

	/**
	 * The operation id for the '<em>Validate Instance Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT;

	/**
	 * The operation id for the '<em>Validate Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___VALIDATE_INSTANCE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE;

	/**
	 * The operation id for the '<em>Validate Instance In Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT;

	/**
	 * The operation id for the '<em>To MID Custom Print Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___TO_MID_CUSTOM_PRINT_LABEL;

	/**
	 * The operation id for the '<em>To MID Custom Edit Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___TO_MID_CUSTOM_EDIT_LABEL;

	/**
	 * The operation id for the '<em>Update MID Custom Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___UPDATE_MID_CUSTOM_LABEL__STRING;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___GET_SUPERTYPE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___GET_TARGET = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___SET_TARGET__EXTENDIBLEELEMENT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___GET_METATYPE = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT___CREATE_INSTANCE__GENERICELEMENT_OPERATOR = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Generic Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_ENDPOINT_OPERATION_COUNT = MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorInputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorInputImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getOperatorInput()
	 * @generated
	 */
	int OPERATOR_INPUT = 4;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_INPUT__MODEL = 0;

	/**
	 * The feature id for the '<em><b>Conversions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_INPUT__CONVERSIONS = 1;

	/**
	 * The feature id for the '<em><b>Model Type Endpoint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_INPUT__MODEL_TYPE_ENDPOINT = 2;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_INPUT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorGenericImpl <em>Generic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorGenericImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getOperatorGeneric()
	 * @generated
	 */
	int OPERATOR_GENERIC = 5;

	/**
	 * The feature id for the '<em><b>Generic</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_GENERIC__GENERIC = 0;

	/**
	 * The feature id for the '<em><b>Generic Super Type Endpoint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT = 1;

	/**
	 * The number of structural features of the '<em>Generic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_GENERIC_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Generic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_GENERIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Random</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Random
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getRandom()
	 * @generated
	 */
	int RANDOM = 6;


	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 7;


	/**
	 * The meta object id for the '<em>Properties</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Properties
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getProperties()
	 * @generated
	 */
	int PROPERTIES = 8;


	/**
	 * The meta object id for the '<em>Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getSet()
	 * @generated
	 */
	int SET = 9;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.operator.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getInputs()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getOutputs()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Outputs();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getGenerics <em>Generics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generics</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getGenerics()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Generics();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getInputSubdir <em>Input Subdir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Subdir</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getInputSubdir()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_InputSubdir();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getPreviousOperator <em>Previous Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Operator</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getPreviousOperator()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_PreviousOperator();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#isUpdateMID <em>Update MID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Update MID</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#isUpdateMID()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_UpdateMID();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getExecutionTime <em>Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Time</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getExecutionTime()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_ExecutionTime();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#isCommutative <em>Commutative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Commutative</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#isCommutative()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Commutative();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getMetatype()
	 * @generated
	 */
	EOperation getOperator__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getSupertype()
	 * @generated
	 */
	EOperation getOperator__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#deleteType()
	 * @generated
	 */
	EOperation getOperator__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#findAllowedInputs(org.eclipse.emf.common.util.EList) <em>Find Allowed Inputs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Allowed Inputs</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#findAllowedInputs(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getOperator__FindAllowedInputs__EList();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#findFirstAllowedInput(org.eclipse.emf.common.util.EList) <em>Find First Allowed Input</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find First Allowed Input</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#findFirstAllowedInput(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getOperator__FindFirstAllowedInput__EList();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#checkAllowedInputs(org.eclipse.emf.common.util.EList) <em>Check Allowed Inputs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Check Allowed Inputs</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#checkAllowedInputs(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getOperator__CheckAllowedInputs__EList();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#isAllowedInput(java.util.Map) <em>Is Allowed Input</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Allowed Input</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#isAllowedInput(java.util.Map)
	 * @generated
	 */
	EOperation getOperator__IsAllowedInput__Map();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getOutputsByName() <em>Get Outputs By Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outputs By Name</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getOutputsByName()
	 * @generated
	 */
	EOperation getOperator__GetOutputsByName();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#createInstance(edu.toronto.cs.se.mmint.mid.MID) <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#createInstance(edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getOperator__CreateInstance__MID();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#deleteInstance()
	 * @generated
	 */
	EOperation getOperator__DeleteInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#selectAllowedGenerics(org.eclipse.emf.common.util.EList) <em>Select Allowed Generics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Select Allowed Generics</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#selectAllowedGenerics(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getOperator__SelectAllowedGenerics__EList();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#isAllowedGeneric(edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint, edu.toronto.cs.se.mmint.mid.GenericElement, org.eclipse.emf.common.util.EList) <em>Is Allowed Generic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Allowed Generic</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#isAllowedGeneric(edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint, edu.toronto.cs.se.mmint.mid.GenericElement, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getOperator__IsAllowedGeneric__GenericEndpoint_GenericElement_EList();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getInputProperties() <em>Get Input Properties</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Input Properties</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getInputProperties()
	 * @generated
	 */
	EOperation getOperator__GetInputProperties();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#readInputProperties(java.util.Properties) <em>Read Input Properties</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Read Input Properties</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#readInputProperties(java.util.Properties)
	 * @generated
	 */
	EOperation getOperator__ReadInputProperties__Properties();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#init() <em>Init</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#init()
	 * @generated
	 */
	EOperation getOperator__Init();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#run(java.util.Map, java.util.Map, java.util.Map) <em>Run</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Run</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#run(java.util.Map, java.util.Map, java.util.Map)
	 * @generated
	 */
	EOperation getOperator__Run__Map_Map_Map();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#start(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, java.util.Map, edu.toronto.cs.se.mmint.mid.MID) <em>Start</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Start</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#start(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, java.util.Map, edu.toronto.cs.se.mmint.mid.MID)
	 * @generated
	 */
	EOperation getOperator__Start__EList_EList_Map_MID();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.operator.ConversionOperator <em>Conversion Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conversion Operator</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.ConversionOperator
	 * @generated
	 */
	EClass getConversionOperator();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.ConversionOperator#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.ConversionOperator#deleteType()
	 * @generated
	 */
	EOperation getConversionOperator__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.ConversionOperator#cleanup() <em>Cleanup</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Cleanup</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.ConversionOperator#cleanup()
	 * @generated
	 */
	EOperation getConversionOperator__Cleanup();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.operator.RandomOperator <em>Random Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Operator</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.RandomOperator
	 * @generated
	 */
	EClass getRandomOperator();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.operator.RandomOperator#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.RandomOperator#getState()
	 * @see #getRandomOperator()
	 * @generated
	 */
	EAttribute getRandomOperator_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint <em>Generic Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint
	 * @generated
	 */
	EClass getGenericEndpoint();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getMetatargetUri <em>Metatarget Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metatarget Uri</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getMetatargetUri()
	 * @see #getGenericEndpoint()
	 * @generated
	 */
	EAttribute getGenericEndpoint_MetatargetUri();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getSupertype()
	 * @generated
	 */
	EOperation getGenericEndpoint__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getTarget()
	 * @generated
	 */
	EOperation getGenericEndpoint__GetTarget();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#setTarget(edu.toronto.cs.se.mmint.mid.ExtendibleElement) <em>Set Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Target</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#setTarget(edu.toronto.cs.se.mmint.mid.ExtendibleElement)
	 * @generated
	 */
	EOperation getGenericEndpoint__SetTarget__ExtendibleElement();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getMetatype()
	 * @generated
	 */
	EOperation getGenericEndpoint__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#createInstance(edu.toronto.cs.se.mmint.mid.GenericElement, edu.toronto.cs.se.mmint.mid.operator.Operator) <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#createInstance(edu.toronto.cs.se.mmint.mid.GenericElement, edu.toronto.cs.se.mmint.mid.operator.Operator)
	 * @generated
	 */
	EOperation getGenericEndpoint__CreateInstance__GenericElement_Operator();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorInput
	 * @generated
	 */
	EClass getOperatorInput();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getModel()
	 * @see #getOperatorInput()
	 * @generated
	 */
	EReference getOperatorInput_Model();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getConversions <em>Conversions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conversions</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getConversions()
	 * @see #getOperatorInput()
	 * @generated
	 */
	EReference getOperatorInput_Conversions();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getModelTypeEndpoint <em>Model Type Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Type Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getModelTypeEndpoint()
	 * @see #getOperatorInput()
	 * @generated
	 */
	EReference getOperatorInput_ModelTypeEndpoint();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric <em>Generic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric
	 * @generated
	 */
	EClass getOperatorGeneric();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric#getGeneric <em>Generic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generic</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric#getGeneric()
	 * @see #getOperatorGeneric()
	 * @generated
	 */
	EReference getOperatorGeneric_Generic();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric#getGenericSuperTypeEndpoint <em>Generic Super Type Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generic Super Type Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric#getGenericSuperTypeEndpoint()
	 * @see #getOperatorGeneric()
	 * @generated
	 */
	EReference getOperatorGeneric_GenericSuperTypeEndpoint();

	/**
	 * Returns the meta object for data type '{@link java.util.Random <em>Random</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Random</em>'.
	 * @see java.util.Random
	 * @model instanceClass="java.util.Random"
	 * @generated
	 */
	EDataType getRandom();

	/**
	 * Returns the meta object for data type '{@link java.lang.Exception <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exception</em>'.
	 * @see java.lang.Exception
	 * @model instanceClass="java.lang.Exception"
	 * @generated
	 */
	EDataType getException();

	/**
	 * Returns the meta object for data type '{@link java.util.Properties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Properties</em>'.
	 * @see java.util.Properties
	 * @model instanceClass="java.util.Properties"
	 * @generated
	 */
	EDataType getProperties();

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Set</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set" typeParameters="E"
	 * @generated
	 */
	EDataType getSet();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperatorFactory getOperatorFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__INPUTS = eINSTANCE.getOperator_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__OUTPUTS = eINSTANCE.getOperator_Outputs();

		/**
		 * The meta object literal for the '<em><b>Generics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__GENERICS = eINSTANCE.getOperator_Generics();

		/**
		 * The meta object literal for the '<em><b>Input Subdir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__INPUT_SUBDIR = eINSTANCE.getOperator_InputSubdir();

		/**
		 * The meta object literal for the '<em><b>Previous Operator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__PREVIOUS_OPERATOR = eINSTANCE.getOperator_PreviousOperator();

		/**
		 * The meta object literal for the '<em><b>Update MID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__UPDATE_MID = eINSTANCE.getOperator_UpdateMID();

		/**
		 * The meta object literal for the '<em><b>Execution Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__EXECUTION_TIME = eINSTANCE.getOperator_ExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Commutative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__COMMUTATIVE = eINSTANCE.getOperator_Commutative();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___GET_METATYPE = eINSTANCE.getOperator__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___GET_SUPERTYPE = eINSTANCE.getOperator__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___DELETE_TYPE = eINSTANCE.getOperator__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Find Allowed Inputs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___FIND_ALLOWED_INPUTS__ELIST = eINSTANCE.getOperator__FindAllowedInputs__EList();

		/**
		 * The meta object literal for the '<em><b>Find First Allowed Input</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST = eINSTANCE.getOperator__FindFirstAllowedInput__EList();

		/**
		 * The meta object literal for the '<em><b>Check Allowed Inputs</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___CHECK_ALLOWED_INPUTS__ELIST = eINSTANCE.getOperator__CheckAllowedInputs__EList();

		/**
		 * The meta object literal for the '<em><b>Is Allowed Input</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___IS_ALLOWED_INPUT__MAP = eINSTANCE.getOperator__IsAllowedInput__Map();

		/**
		 * The meta object literal for the '<em><b>Get Outputs By Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___GET_OUTPUTS_BY_NAME = eINSTANCE.getOperator__GetOutputsByName();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___CREATE_INSTANCE__MID = eINSTANCE.getOperator__CreateInstance__MID();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___DELETE_INSTANCE = eINSTANCE.getOperator__DeleteInstance();

		/**
		 * The meta object literal for the '<em><b>Select Allowed Generics</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___SELECT_ALLOWED_GENERICS__ELIST = eINSTANCE.getOperator__SelectAllowedGenerics__EList();

		/**
		 * The meta object literal for the '<em><b>Is Allowed Generic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___IS_ALLOWED_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST = eINSTANCE.getOperator__IsAllowedGeneric__GenericEndpoint_GenericElement_EList();

		/**
		 * The meta object literal for the '<em><b>Get Input Properties</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___GET_INPUT_PROPERTIES = eINSTANCE.getOperator__GetInputProperties();

		/**
		 * The meta object literal for the '<em><b>Read Input Properties</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES = eINSTANCE.getOperator__ReadInputProperties__Properties();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___INIT = eINSTANCE.getOperator__Init();

		/**
		 * The meta object literal for the '<em><b>Run</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___RUN__MAP_MAP_MAP = eINSTANCE.getOperator__Run__Map_Map_Map();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___START__ELIST_ELIST_MAP_MID = eINSTANCE.getOperator__Start__EList_EList_Map_MID();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl <em>Conversion Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getConversionOperator()
		 * @generated
		 */
		EClass CONVERSION_OPERATOR = eINSTANCE.getConversionOperator();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONVERSION_OPERATOR___DELETE_TYPE = eINSTANCE.getConversionOperator__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Cleanup</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONVERSION_OPERATOR___CLEANUP = eINSTANCE.getConversionOperator__Cleanup();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl <em>Random Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getRandomOperator()
		 * @generated
		 */
		EClass RANDOM_OPERATOR = eINSTANCE.getRandomOperator();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_OPERATOR__STATE = eINSTANCE.getRandomOperator_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.GenericEndpointImpl <em>Generic Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.GenericEndpointImpl
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getGenericEndpoint()
		 * @generated
		 */
		EClass GENERIC_ENDPOINT = eINSTANCE.getGenericEndpoint();

		/**
		 * The meta object literal for the '<em><b>Metatarget Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_ENDPOINT__METATARGET_URI = eINSTANCE.getGenericEndpoint_MetatargetUri();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GENERIC_ENDPOINT___GET_SUPERTYPE = eINSTANCE.getGenericEndpoint__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GENERIC_ENDPOINT___GET_TARGET = eINSTANCE.getGenericEndpoint__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Set Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GENERIC_ENDPOINT___SET_TARGET__EXTENDIBLEELEMENT = eINSTANCE.getGenericEndpoint__SetTarget__ExtendibleElement();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GENERIC_ENDPOINT___GET_METATYPE = eINSTANCE.getGenericEndpoint__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GENERIC_ENDPOINT___CREATE_INSTANCE__GENERICELEMENT_OPERATOR = eINSTANCE.getGenericEndpoint__CreateInstance__GenericElement_Operator();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorInputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorInputImpl
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getOperatorInput()
		 * @generated
		 */
		EClass OPERATOR_INPUT = eINSTANCE.getOperatorInput();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_INPUT__MODEL = eINSTANCE.getOperatorInput_Model();

		/**
		 * The meta object literal for the '<em><b>Conversions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_INPUT__CONVERSIONS = eINSTANCE.getOperatorInput_Conversions();

		/**
		 * The meta object literal for the '<em><b>Model Type Endpoint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_INPUT__MODEL_TYPE_ENDPOINT = eINSTANCE.getOperatorInput_ModelTypeEndpoint();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorGenericImpl <em>Generic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorGenericImpl
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getOperatorGeneric()
		 * @generated
		 */
		EClass OPERATOR_GENERIC = eINSTANCE.getOperatorGeneric();

		/**
		 * The meta object literal for the '<em><b>Generic</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_GENERIC__GENERIC = eINSTANCE.getOperatorGeneric_Generic();

		/**
		 * The meta object literal for the '<em><b>Generic Super Type Endpoint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT = eINSTANCE.getOperatorGeneric_GenericSuperTypeEndpoint();

		/**
		 * The meta object literal for the '<em>Random</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Random
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getRandom()
		 * @generated
		 */
		EDataType RANDOM = eINSTANCE.getRandom();

		/**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Exception
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getException()
		 * @generated
		 */
		EDataType EXCEPTION = eINSTANCE.getException();

		/**
		 * The meta object literal for the '<em>Properties</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Properties
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getProperties()
		 * @generated
		 */
		EDataType PROPERTIES = eINSTANCE.getProperties();

		/**
		 * The meta object literal for the '<em>Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Set
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getSet()
		 * @generated
		 */
		EDataType SET = eINSTANCE.getSet();

	}

} //OperatorPackage
