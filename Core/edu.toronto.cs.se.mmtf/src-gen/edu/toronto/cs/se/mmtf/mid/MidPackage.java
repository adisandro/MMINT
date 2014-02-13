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
package edu.toronto.cs.se.mmtf.mid;

import edu.toronto.cs.se.mmtf.mavo.MavoPackage;
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
 * @see edu.toronto.cs.se.mmtf.mid.MidFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface MidPackage extends EPackage {
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
	String eNS_URI = "http://se.cs.toronto.edu/mmtf/MID";

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
	MidPackage eINSTANCE = edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl <em>Extendible Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElement()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementEndpointImpl <em>Extendible Element Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementEndpointImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElementEndpoint()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT = 3;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl <em>Multi Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMultiModel()
	 * @generated
	 */
	int MULTI_MODEL = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 4;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.EStringToExtendibleElementMapImpl <em>EString To Extendible Element Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.EStringToExtendibleElementMapImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getEStringToExtendibleElementMap()
	 * @generated
	 */
	int ESTRING_TO_EXTENDIBLE_ELEMENT_MAP = 1;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__INC = MavoPackage.MAVO_MODEL__INC;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__MODELS = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__EDITORS = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__OPERATORS = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extendible Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__EXTENDIBLE_TABLE = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__LEVEL = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Multi Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL_FEATURE_COUNT = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Multi Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL_OPERATION_COUNT = MavoPackage.MAVO_MODEL_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__MAY = MavoPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__SET = MavoPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__VAR = MavoPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__FORMULA_ID = MavoPackage.MAVO_ELEMENT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__SUPERTYPE = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__METATYPE = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__URI = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__NAME = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__LEVEL = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__METATYPE_URI = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__DYNAMIC = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__CONSTRAINT = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Extendible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_FEATURE_COUNT = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING = MavoPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Extendible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_OPERATION_COUNT = MavoPackage.MAVO_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__MAY = EXTENDIBLE_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__SET = EXTENDIBLE_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__VAR = EXTENDIBLE_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__FORMULA_ID = EXTENDIBLE_ELEMENT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__SUPERTYPE = EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT__METATYPE = EXTENDIBLE_ELEMENT__METATYPE;

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
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

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
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__MAY = EXTENDIBLE_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SET = EXTENDIBLE_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__VAR = EXTENDIBLE_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__FORMULA_ID = EXTENDIBLE_ELEMENT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SUPERTYPE = EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__METATYPE = EXTENDIBLE_ELEMENT__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__URI = EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__LEVEL = EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__METATYPE_URI = EXTENDIBLE_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DYNAMIC = EXTENDIBLE_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CONSTRAINT = EXTENDIBLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__INC = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ORIGIN = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__FILE_EXTENSION = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__EDITORS = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__MODEL_ELEMS = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CONVERSION_OPERATORS = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ABSTRACT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_SUBTYPE_URI__STRING_STRING = EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_METATYPE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_SUPERTYPE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___DELETE_TYPE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get EMF Type Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_EMF_TYPE_ROOT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Create MAVO Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_MAVO_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Create MAVO Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CREATE_MAVO_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Copy MAVO Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___COPY_MAVO_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MULTIMODEL = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___DELETE_INSTANCE = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Get EMF Instance Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GET_EMF_INSTANCE_ROOT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementConstraintImpl <em>Extendible Element Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementConstraintImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElementConstraint()
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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl <em>Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__MAY = EXTENDIBLE_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__SET = EXTENDIBLE_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__VAR = EXTENDIBLE_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__FORMULA_ID = EXTENDIBLE_ELEMENT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__SUPERTYPE = EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__METATYPE = EXTENDIBLE_ELEMENT__METATYPE;

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
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING = EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl <em>Model Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelEndpoint()
	 * @generated
	 */
	int MODEL_ENDPOINT = 7;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__MAY = EXTENDIBLE_ELEMENT_ENDPOINT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__SET = EXTENDIBLE_ELEMENT_ENDPOINT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__VAR = EXTENDIBLE_ELEMENT_ENDPOINT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__FORMULA_ID = EXTENDIBLE_ELEMENT_ENDPOINT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__SUPERTYPE = EXTENDIBLE_ELEMENT_ENDPOINT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT__METATYPE = EXTENDIBLE_ELEMENT_ENDPOINT__METATYPE;

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
	 * The operation id for the '<em>Create Subtype Uri</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING = EXTENDIBLE_ELEMENT_ENDPOINT___CREATE_SUBTYPE_URI__STRING_STRING;

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
	int MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__MODELENDPOINTREFERENCE_BOOLEAN_BOOLEAN_MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__MODELENDPOINTREFERENCE_STRING_MODEL_BOOLEAN_MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Replace Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_MODELENDPOINTREFERENCE_STRING_MODEL_MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 5;

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
	int MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__BOOLEAN_MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_BOOLEAN_MODELREL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Replace Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Delete Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>Model Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_OPERATION_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 11;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.EMFInfoImpl <em>EMF Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.EMFInfoImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getEMFInfo()
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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.MidLevel <em>Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.MidLevel
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMidLevel()
	 * @generated
	 */
	int MID_LEVEL = 9;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.ModelOrigin <em>Model Origin</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.ModelOrigin
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelOrigin()
	 * @generated
	 */
	int MODEL_ORIGIN = 10;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage <em>Extendible Element Constraint Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElementConstraintLanguage()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_CONSTRAINT_LANGUAGE = 11;

	/**
	 * The meta object id for the '<em>MMTF Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.MMTFException
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMMTFException()
	 * @generated
	 */
	int MMTF_EXCEPTION = 12;

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement <em>Extendible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement
	 * @generated
	 */
	EClass getExtendibleElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getUri()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_Uri();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getSupertype <em>Supertype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supertype</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getSupertype()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EReference getExtendibleElement_Supertype();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getName()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_Name();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getMetatype <em>Metatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metatype</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getMetatype()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EReference getExtendibleElement_Metatype();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getLevel()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_Level();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getMetatypeUri <em>Metatype Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metatype Uri</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getMetatypeUri()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_MetatypeUri();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#isDynamic <em>Dynamic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamic</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#isDynamic()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EAttribute getExtendibleElement_Dynamic();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#getConstraint()
	 * @see #getExtendibleElement()
	 * @generated
	 */
	EReference getExtendibleElement_Constraint();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement#createSubtypeUri(java.lang.String, java.lang.String) <em>Create Subtype Uri</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype Uri</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElement#createSubtypeUri(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getExtendibleElement__CreateSubtypeUri__String_String();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint <em>Extendible Element Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint
	 * @generated
	 */
	EClass getExtendibleElementEndpoint();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getLowerBound()
	 * @see #getExtendibleElementEndpoint()
	 * @generated
	 */
	EAttribute getExtendibleElementEndpoint_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getUpperBound()
	 * @see #getExtendibleElementEndpoint()
	 * @generated
	 */
	EAttribute getExtendibleElementEndpoint_UpperBound();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getTarget()
	 * @see #getExtendibleElementEndpoint()
	 * @generated
	 */
	EReference getExtendibleElementEndpoint_Target();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getTargetUri <em>Target Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Uri</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getTargetUri()
	 * @see #getExtendibleElementEndpoint()
	 * @generated
	 */
	EAttribute getExtendibleElementEndpoint_TargetUri();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getMetatype()
	 * @generated
	 */
	EOperation getExtendibleElementEndpoint__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint#getSupertype()
	 * @generated
	 */
	EOperation getExtendibleElementEndpoint__GetSupertype();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.MultiModel <em>Multi Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel
	 * @generated
	 */
	EClass getMultiModel();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getModels()
	 * @see #getMultiModel()
	 * @generated
	 */
	EReference getMultiModel_Models();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editors</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getEditors()
	 * @see #getMultiModel()
	 * @generated
	 */
	EReference getMultiModel_Editors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getOperators()
	 * @see #getMultiModel()
	 * @generated
	 */
	EReference getMultiModel_Operators();

	/**
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getExtendibleTable <em>Extendible Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Extendible Table</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getExtendibleTable()
	 * @see #getMultiModel()
	 * @generated
	 */
	EReference getMultiModel_ExtendibleTable();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getLevel()
	 * @see #getMultiModel()
	 * @generated
	 */
	EAttribute getMultiModel_Level();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.Model#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getOrigin()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Origin();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.Model#getFileExtension <em>File Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Extension</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getFileExtension()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_FileExtension();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.Model#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getEditors()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Editors();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.Model#getModelElems <em>Model Elems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elems</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getModelElems()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ModelElems();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.Model#getConversionOperators <em>Conversion Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conversion Operators</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getConversionOperators()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ConversionOperators();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.Model#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#isAbstract()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Abstract();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getMetatype()
	 * @generated
	 */
	EOperation getModel__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getSupertype()
	 * @generated
	 */
	EOperation getModel__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#createSubtype(java.lang.String, java.lang.String, java.lang.String, boolean) <em>Create Subtype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#createSubtype(java.lang.String, java.lang.String, java.lang.String, boolean)
	 * @generated
	 */
	EOperation getModel__CreateSubtype__String_String_String_boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#deleteType()
	 * @generated
	 */
	EOperation getModel__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#getEMFTypeRoot() <em>Get EMF Type Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Type Root</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getEMFTypeRoot()
	 * @generated
	 */
	EOperation getModel__GetEMFTypeRoot();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#createInstance(java.lang.String, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel) <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#createInstance(java.lang.String, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel)
	 * @generated
	 */
	EOperation getModel__CreateInstance__String_ModelOrigin_MultiModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#createInstanceAndEditor(java.lang.String, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel) <em>Create Instance And Editor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Editor</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#createInstanceAndEditor(java.lang.String, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel)
	 * @generated
	 */
	EOperation getModel__CreateInstanceAndEditor__String_ModelOrigin_MultiModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#createMAVOInstance(java.lang.String, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel) <em>Create MAVO Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create MAVO Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#createMAVOInstance(java.lang.String, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel)
	 * @generated
	 */
	EOperation getModel__CreateMAVOInstance__String_ModelOrigin_MultiModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#createMAVOInstanceAndEditor(java.lang.String, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel) <em>Create MAVO Instance And Editor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create MAVO Instance And Editor</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#createMAVOInstanceAndEditor(java.lang.String, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel)
	 * @generated
	 */
	EOperation getModel__CreateMAVOInstanceAndEditor__String_ModelOrigin_MultiModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#copyMAVOInstanceAndEditor(edu.toronto.cs.se.mmtf.mid.Model, java.lang.String, boolean, edu.toronto.cs.se.mmtf.mid.MultiModel) <em>Copy MAVO Instance And Editor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy MAVO Instance And Editor</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#copyMAVOInstanceAndEditor(edu.toronto.cs.se.mmtf.mid.Model, java.lang.String, boolean, edu.toronto.cs.se.mmtf.mid.MultiModel)
	 * @generated
	 */
	EOperation getModel__CopyMAVOInstanceAndEditor__Model_String_boolean_MultiModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#deleteInstance()
	 * @generated
	 */
	EOperation getModel__DeleteInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.Model#getEMFInstanceRoot() <em>Get EMF Instance Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Instance Root</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getEMFInstanceRoot()
	 * @generated
	 */
	EOperation getModel__GetEMFInstanceRoot();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint <em>Extendible Element Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element Constraint</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint
	 * @generated
	 */
	EClass getExtendibleElementConstraint();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint#getImplementation()
	 * @see #getExtendibleElementConstraint()
	 * @generated
	 */
	EAttribute getExtendibleElementConstraint_Implementation();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint#getLanguage()
	 * @see #getExtendibleElementConstraint()
	 * @generated
	 */
	EAttribute getExtendibleElementConstraint_Language();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Extendible Element Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Extendible Element Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="edu.toronto.cs.se.mmtf.mid.ExtendibleElement" valueRequired="true"
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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getEInfo <em>EInfo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>EInfo</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#getEInfo()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_EInfo();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#getMetatype()
	 * @generated
	 */
	EOperation getModelElement__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#getSupertype()
	 * @generated
	 */
	EOperation getModelElement__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference)
	 * @generated
	 */
	EOperation getModelElement__CreateTypeReference__ModelElementReference_boolean_ModelEndpointReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#createSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference, java.lang.String, java.lang.String, edu.toronto.cs.se.mmtf.mid.EMFInfo, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference) <em>Create Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#createSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference, java.lang.String, java.lang.String, edu.toronto.cs.se.mmtf.mid.EMFInfo, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference)
	 * @generated
	 */
	EOperation getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_EMFInfo_ModelEndpointReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#deleteInstance()
	 * @generated
	 */
	EOperation getModelElement__DeleteInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getEMFInstanceObject() <em>Get EMF Instance Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Instance Object</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#getEMFInstanceObject()
	 * @generated
	 */
	EOperation getModelElement__GetEMFInstanceObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#deleteType()
	 * @generated
	 */
	EOperation getModelElement__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getEMFTypeObject() <em>Get EMF Type Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get EMF Type Object</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#getEMFTypeObject()
	 * @generated
	 */
	EOperation getModelElement__GetEMFTypeObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#createInstanceReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#createInstanceReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference)
	 * @generated
	 */
	EOperation getModelElement__CreateInstanceReference__ModelEndpointReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#createInstanceAndReference(java.lang.String, java.lang.String, edu.toronto.cs.se.mmtf.mid.EMFInfo, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference) <em>Create Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#createInstanceAndReference(java.lang.String, java.lang.String, edu.toronto.cs.se.mmtf.mid.EMFInfo, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference)
	 * @generated
	 */
	EOperation getModelElement__CreateInstanceAndReference__String_String_EMFInfo_ModelEndpointReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint <em>Model Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint
	 * @generated
	 */
	EClass getModelEndpoint();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#getSupertype()
	 * @generated
	 */
	EOperation getModelEndpoint__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#getTarget()
	 * @generated
	 */
	EOperation getModelEndpoint__GetTarget();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#getMetatype()
	 * @generated
	 */
	EOperation getModelEndpoint__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#createSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, java.lang.String, edu.toronto.cs.se.mmtf.mid.Model, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#createSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, java.lang.String, edu.toronto.cs.se.mmtf.mid.Model, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateSubtypeAndReference__ModelEndpointReference_String_Model_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#replaceSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.ModelEndpoint, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, java.lang.String, edu.toronto.cs.se.mmtf.mid.Model, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Replace Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Replace Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#replaceSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.ModelEndpoint, edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, java.lang.String, edu.toronto.cs.se.mmtf.mid.Model, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__ReplaceSubtypeAndReference__ModelEndpoint_ModelEndpointReference_String_Model_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#deleteTypeAndReference(boolean) <em>Delete Type And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#deleteTypeAndReference(boolean)
	 * @generated
	 */
	EOperation getModelEndpoint__DeleteTypeAndReference__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#createInstanceAndReference(edu.toronto.cs.se.mmtf.mid.Model, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#createInstanceAndReference(edu.toronto.cs.se.mmtf.mid.Model, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateInstanceAndReference__Model_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#deleteInstanceAndReference(boolean) <em>Delete Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#deleteInstanceAndReference(boolean)
	 * @generated
	 */
	EOperation getModelEndpoint__DeleteInstanceAndReference__boolean();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo <em>EMF Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Info</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.EMFInfo
	 * @generated
	 */
	EClass getEMFInfo();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.EMFInfo#getClassName()
	 * @see #getEMFInfo()
	 * @generated
	 */
	EAttribute getEMFInfo_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.EMFInfo#getFeatureName()
	 * @see #getEMFInfo()
	 * @generated
	 */
	EAttribute getEMFInfo_FeatureName();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#isAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.EMFInfo#isAttribute()
	 * @see #getEMFInfo()
	 * @generated
	 */
	EAttribute getEMFInfo_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getRelatedClassName <em>Related Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Related Class Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.EMFInfo#getRelatedClassName()
	 * @see #getEMFInfo()
	 * @generated
	 */
	EAttribute getEMFInfo_RelatedClassName();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#toTypeString() <em>To Type String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Type String</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.EMFInfo#toTypeString()
	 * @generated
	 */
	EOperation getEMFInfo__ToTypeString();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#toInstanceString() <em>To Instance String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Instance String</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.EMFInfo#toInstanceString()
	 * @generated
	 */
	EOperation getEMFInfo__ToInstanceString();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#replaceInstanceAndReference(edu.toronto.cs.se.mmtf.mid.ModelEndpoint, edu.toronto.cs.se.mmtf.mid.Model) <em>Replace Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Replace Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#replaceInstanceAndReference(edu.toronto.cs.se.mmtf.mid.ModelEndpoint, edu.toronto.cs.se.mmtf.mid.Model)
	 * @generated
	 */
	EOperation getModelEndpoint__ReplaceInstanceAndReference__ModelEndpoint_Model();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, boolean, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference, boolean, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateTypeReference__ModelEndpointReference_boolean_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint#createInstanceReference(boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelEndpoint#createInstanceReference(boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelEndpoint__CreateInstanceReference__boolean_ModelRel();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmtf.mid.MidLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Level</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MidLevel
	 * @generated
	 */
	EEnum getMidLevel();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmtf.mid.ModelOrigin <em>Model Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Origin</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelOrigin
	 * @generated
	 */
	EEnum getModelOrigin();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage <em>Extendible Element Constraint Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Extendible Element Constraint Language</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage
	 * @generated
	 */
	EEnum getExtendibleElementConstraintLanguage();

	/**
	 * Returns the meta object for data type '{@link edu.toronto.cs.se.mmtf.MMTFException <em>MMTF Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>MMTF Exception</em>'.
	 * @see edu.toronto.cs.se.mmtf.MMTFException
	 * @model instanceClass="edu.toronto.cs.se.mmtf.MMTFException"
	 * @generated
	 */
	EDataType getMMTFException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MidFactory getMidFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl <em>Extendible Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElement()
		 * @generated
		 */
		EClass EXTENDIBLE_ELEMENT = eINSTANCE.getExtendibleElement();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT__URI = eINSTANCE.getExtendibleElement_Uri();

		/**
		 * The meta object literal for the '<em><b>Supertype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT__SUPERTYPE = eINSTANCE.getExtendibleElement_Supertype();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT__NAME = eINSTANCE.getExtendibleElement_Name();

		/**
		 * The meta object literal for the '<em><b>Metatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT__METATYPE = eINSTANCE.getExtendibleElement_Metatype();

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
		 * The meta object literal for the '<em><b>Create Subtype Uri</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING = eINSTANCE.getExtendibleElement__CreateSubtypeUri__String_String();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementEndpointImpl <em>Extendible Element Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementEndpointImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElementEndpoint()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl <em>Multi Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMultiModel()
		 * @generated
		 */
		EClass MULTI_MODEL = eINSTANCE.getMultiModel();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_MODEL__MODELS = eINSTANCE.getMultiModel_Models();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_MODEL__EDITORS = eINSTANCE.getMultiModel_Editors();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_MODEL__OPERATORS = eINSTANCE.getMultiModel_Operators();

		/**
		 * The meta object literal for the '<em><b>Extendible Table</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_MODEL__EXTENDIBLE_TABLE = eINSTANCE.getMultiModel_ExtendibleTable();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_MODEL__LEVEL = eINSTANCE.getMultiModel_Level();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModel()
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
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ABSTRACT = eINSTANCE.getModel_Abstract();

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
		EOperation MODEL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = eINSTANCE.getModel__CreateInstance__String_ModelOrigin_MultiModel();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Editor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = eINSTANCE.getModel__CreateInstanceAndEditor__String_ModelOrigin_MultiModel();

		/**
		 * The meta object literal for the '<em><b>Create MAVO Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___CREATE_MAVO_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = eINSTANCE.getModel__CreateMAVOInstance__String_ModelOrigin_MultiModel();

		/**
		 * The meta object literal for the '<em><b>Create MAVO Instance And Editor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___CREATE_MAVO_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = eINSTANCE.getModel__CreateMAVOInstanceAndEditor__String_ModelOrigin_MultiModel();

		/**
		 * The meta object literal for the '<em><b>Copy MAVO Instance And Editor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL___COPY_MAVO_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MULTIMODEL = eINSTANCE.getModel__CopyMAVOInstanceAndEditor__Model_String_boolean_MultiModel();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementConstraintImpl <em>Extendible Element Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementConstraintImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElementConstraint()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.EStringToExtendibleElementMapImpl <em>EString To Extendible Element Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.EStringToExtendibleElementMapImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getEStringToExtendibleElementMap()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl <em>Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelElement()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl <em>Model Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelEndpoint()
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
		 * The meta object literal for the '<em><b>Create Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__MODELENDPOINTREFERENCE_STRING_MODEL_BOOLEAN_MODELREL = eINSTANCE.getModelEndpoint__CreateSubtypeAndReference__ModelEndpointReference_String_Model_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Replace Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_MODELENDPOINTREFERENCE_STRING_MODEL_MODELREL = eINSTANCE.getModelEndpoint__ReplaceSubtypeAndReference__ModelEndpoint_ModelEndpointReference_String_Model_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Type And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN = eINSTANCE.getModelEndpoint__DeleteTypeAndReference__boolean();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_BOOLEAN_MODELREL = eINSTANCE.getModelEndpoint__CreateInstanceAndReference__Model_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN = eINSTANCE.getModelEndpoint__DeleteInstanceAndReference__boolean();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.EMFInfoImpl <em>EMF Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.EMFInfoImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getEMFInfo()
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
		 * The meta object literal for the '<em><b>Replace Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL = eINSTANCE.getModelEndpoint__ReplaceInstanceAndReference__ModelEndpoint_Model();

		/**
		 * The meta object literal for the '<em><b>Create Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__MODELENDPOINTREFERENCE_BOOLEAN_BOOLEAN_MODELREL = eINSTANCE.getModelEndpoint__CreateTypeReference__ModelEndpointReference_boolean_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__BOOLEAN_MODELREL = eINSTANCE.getModelEndpoint__CreateInstanceReference__boolean_ModelRel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.MidLevel <em>Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.MidLevel
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMidLevel()
		 * @generated
		 */
		EEnum MID_LEVEL = eINSTANCE.getMidLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.ModelOrigin <em>Model Origin</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.ModelOrigin
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelOrigin()
		 * @generated
		 */
		EEnum MODEL_ORIGIN = eINSTANCE.getModelOrigin();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage <em>Extendible Element Constraint Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElementConstraintLanguage()
		 * @generated
		 */
		EEnum EXTENDIBLE_ELEMENT_CONSTRAINT_LANGUAGE = eINSTANCE.getExtendibleElementConstraintLanguage();

		/**
		 * The meta object literal for the '<em>MMTF Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.MMTFException
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMMTFException()
		 * @generated
		 */
		EDataType MMTF_EXCEPTION = eINSTANCE.getMMTFException();

	}

} //MidPackage
