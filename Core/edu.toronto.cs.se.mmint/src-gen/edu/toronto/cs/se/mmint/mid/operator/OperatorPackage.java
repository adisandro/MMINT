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
package edu.toronto.cs.se.mmint.mid.operator;

import edu.toronto.cs.se.mmint.mid.MidPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.EStringToParameterMapImpl <em>EString To Parameter Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.EStringToParameterMapImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getEStringToParameterMap()
	 * @generated
	 */
	int ESTRING_TO_PARAMETER_MAP = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_PARAMETER_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_PARAMETER_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To Parameter Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_PARAMETER_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To Parameter Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_PARAMETER_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__MAY = MidPackage.EXTENDIBLE_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SET = MidPackage.EXTENDIBLE_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__VAR = MidPackage.EXTENDIBLE_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__FORMULA_ID = MidPackage.EXTENDIBLE_ELEMENT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SUPERTYPE = MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__METATYPE = MidPackage.EXTENDIBLE_ELEMENT__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__URI = MidPackage.EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NAME = MidPackage.EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__LEVEL = MidPackage.EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__METATYPE_URI = MidPackage.EXTENDIBLE_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__DYNAMIC = MidPackage.EXTENDIBLE_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__CONSTRAINT = MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__INPUTS = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OUTPUTS = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Signature Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SIGNATURE_TABLE = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input Subdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__INPUT_SUBDIR = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Previous Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__PREVIOUS_OPERATOR = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___CREATE_SUBTYPE_URI__STRING_STRING = MidPackage.EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_METATYPE = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_SUPERTYPE = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___DELETE_TYPE = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Executables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_EXECUTABLES__ELIST_ELIST_ELIST_ELIST = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Input Properties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___GET_INPUT_PROPERTIES = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Read Input Properties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR___EXECUTE__ELIST = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_OPERATION_COUNT = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.ParameterImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 4;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl <em>Conversion Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getConversionOperator()
	 * @generated
	 */
	int CONVERSION_OPERATOR = 2;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__MAY = OPERATOR__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__SET = OPERATOR__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__VAR = OPERATOR__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__FORMULA_ID = OPERATOR__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__SUPERTYPE = OPERATOR__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__METATYPE = OPERATOR__METATYPE;

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
	 * The feature id for the '<em><b>Signature Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__SIGNATURE_TABLE = OPERATOR__SIGNATURE_TABLE;

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
	 * The operation id for the '<em>Get Executables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___GET_EXECUTABLES__ELIST_ELIST_ELIST_ELIST = OPERATOR___GET_EXECUTABLES__ELIST_ELIST_ELIST_ELIST;

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
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR___EXECUTE__ELIST = OPERATOR___EXECUTE__ELIST;

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
	int RANDOM_OPERATOR = 3;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__MAY = OPERATOR__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__SET = OPERATOR__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__VAR = OPERATOR__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__FORMULA_ID = OPERATOR__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__SUPERTYPE = OPERATOR__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__METATYPE = OPERATOR__METATYPE;

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
	 * The feature id for the '<em><b>Signature Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR__SIGNATURE_TABLE = OPERATOR__SIGNATURE_TABLE;

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
	 * The operation id for the '<em>Get Executables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___GET_EXECUTABLES__ELIST_ELIST_ELIST_ELIST = OPERATOR___GET_EXECUTABLES__ELIST_ELIST_ELIST_ELIST;

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
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR___EXECUTE__ELIST = OPERATOR___EXECUTE__ELIST;

	/**
	 * The number of operations of the '<em>Random Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_OPERATOR_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Vararg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VARARG = 1;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MODEL = 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Random</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Random
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getRandom()
	 * @generated
	 */
	int RANDOM = 5;


	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 6;


	/**
	 * The meta object id for the '<em>Properties</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Properties
	 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getProperties()
	 * @generated
	 */
	int PROPERTIES = 7;


	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Parameter Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Parameter Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="edu.toronto.cs.se.mmint.mid.operator.Parameter" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToParameterMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToParameterMap()
	 * @generated
	 */
	EAttribute getEStringToParameterMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToParameterMap()
	 * @generated
	 */
	EReference getEStringToParameterMap_Value();

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
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getSignatureTable <em>Signature Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Signature Table</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getSignatureTable()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_SignatureTable();

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
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#execute(org.eclipse.emf.common.util.EList) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#execute(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getOperator__Execute__EList();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getExecutables(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Get Executables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Executables</em>' operation.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Operator#getExecutables(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getOperator__GetExecutables__EList_EList_EList_EList();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.mid.operator.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#isVararg <em>Vararg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vararg</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Parameter#isVararg()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Vararg();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see edu.toronto.cs.se.mmint.mid.operator.Parameter#getModel()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Model();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.EStringToParameterMapImpl <em>EString To Parameter Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.EStringToParameterMapImpl
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getEStringToParameterMap()
		 * @generated
		 */
		EClass ESTRING_TO_PARAMETER_MAP = eINSTANCE.getEStringToParameterMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_PARAMETER_MAP__KEY = eINSTANCE.getEStringToParameterMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRING_TO_PARAMETER_MAP__VALUE = eINSTANCE.getEStringToParameterMap_Value();

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
		 * The meta object literal for the '<em><b>Signature Table</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__SIGNATURE_TABLE = eINSTANCE.getOperator_SignatureTable();

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
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___EXECUTE__ELIST = eINSTANCE.getOperator__Execute__EList();

		/**
		 * The meta object literal for the '<em><b>Get Executables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR___GET_EXECUTABLES__ELIST_ELIST_ELIST_ELIST = eINSTANCE.getOperator__GetExecutables__EList_EList_EList_EList();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmint.mid.operator.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.ParameterImpl
		 * @see edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Vararg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__VARARG = eINSTANCE.getParameter_Vararg();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__MODEL = eINSTANCE.getParameter_Model();

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

	}

} //OperatorPackage
