/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.operator;

import edu.toronto.cs.se.mmtf.mid.MidPackage;

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
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorFactory
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
	String eNS_URI = "http:///edu/toronto/cs/se/mmtf/model/mid.ecore/operator";

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
	OperatorPackage eINSTANCE = edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.EStringToParameterMapImpl <em>EString To Parameter Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.EStringToParameterMapImpl
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getEStringToParameterMap()
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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__NAME = MidPackage.TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__METATYPE = MidPackage.TYPED_ELEMENT__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__LEVEL = MidPackage.TYPED_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__TYPE = MidPackage.TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__INPUTS = MidPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OUTPUTS = MidPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Signature Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SIGNATURE_TABLE = MidPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Executable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__EXECUTABLE = MidPackage.TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = MidPackage.TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_OPERATION_COUNT = MidPackage.TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.ParameterImpl
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 2;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.EStringToOperatorMapImpl <em>EString To Operator Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.EStringToOperatorMapImpl
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getEStringToOperatorMap()
	 * @generated
	 */
	int ESTRING_TO_OPERATOR_MAP = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_OPERATOR_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_OPERATOR_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To Operator Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_OPERATOR_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To Operator Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_OPERATOR_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorImpl <em>Conversion Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorImpl
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getConversionOperator()
	 * @generated
	 */
	int CONVERSION_OPERATOR = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__NAME = OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__METATYPE = OPERATOR__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__LEVEL = OPERATOR__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__TYPE = OPERATOR__TYPE;

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
	 * The feature id for the '<em><b>Executable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR__EXECUTABLE = OPERATOR__EXECUTABLE;

	/**
	 * The number of structural features of the '<em>Conversion Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Conversion Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSION_OPERATOR_OPERATION_COUNT = OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl <em>Executable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getOperatorExecutable()
	 * @generated
	 */
	int OPERATOR_EXECUTABLE = 5;

	/**
	 * The number of structural features of the '<em>Executable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXECUTABLE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXECUTABLE___EXECUTE__ELIST = 0;

	/**
	 * The number of operations of the '<em>Executable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXECUTABLE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 6;


	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Parameter Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Parameter Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="edu.toronto.cs.se.mmtf.mid.operator.Parameter" valueRequired="true"
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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.operator.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Operator#getInputs()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Operator#getOutputs()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Outputs();

	/**
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getSignatureTable <em>Signature Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Signature Table</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Operator#getSignatureTable()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_SignatureTable();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getExecutable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Executable</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Operator#getExecutable()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_Executable();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#isVararg <em>Vararg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vararg</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Parameter#isVararg()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Vararg();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.Parameter#getModel()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Model();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Operator Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Operator Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="edu.toronto.cs.se.mmtf.mid.operator.Operator" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToOperatorMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToOperatorMap()
	 * @generated
	 */
	EAttribute getEStringToOperatorMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToOperatorMap()
	 * @generated
	 */
	EReference getEStringToOperatorMap_Value();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator <em>Conversion Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conversion Operator</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator
	 * @generated
	 */
	EClass getConversionOperator();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executable</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable
	 * @generated
	 */
	EClass getOperatorExecutable();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable#execute(org.eclipse.emf.common.util.EList) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable#execute(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getOperatorExecutable__Execute__EList();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.EStringToParameterMapImpl <em>EString To Parameter Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.EStringToParameterMapImpl
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getEStringToParameterMap()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getOperator()
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
		 * The meta object literal for the '<em><b>Executable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__EXECUTABLE = eINSTANCE.getOperator_Executable();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.ParameterImpl
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getParameter()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.EStringToOperatorMapImpl <em>EString To Operator Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.EStringToOperatorMapImpl
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getEStringToOperatorMap()
		 * @generated
		 */
		EClass ESTRING_TO_OPERATOR_MAP = eINSTANCE.getEStringToOperatorMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_OPERATOR_MAP__KEY = eINSTANCE.getEStringToOperatorMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRING_TO_OPERATOR_MAP__VALUE = eINSTANCE.getEStringToOperatorMap_Value();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorImpl <em>Conversion Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorImpl
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getConversionOperator()
		 * @generated
		 */
		EClass CONVERSION_OPERATOR = eINSTANCE.getConversionOperator();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl <em>Executable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getOperatorExecutable()
		 * @generated
		 */
		EClass OPERATOR_EXECUTABLE = eINSTANCE.getOperatorExecutable();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATOR_EXECUTABLE___EXECUTE__ELIST = eINSTANCE.getOperatorExecutable__Execute__EList();

		/**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Exception
		 * @see edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl#getException()
		 * @generated
		 */
		EDataType EXCEPTION = eINSTANCE.getException();

	}

} //OperatorPackage
