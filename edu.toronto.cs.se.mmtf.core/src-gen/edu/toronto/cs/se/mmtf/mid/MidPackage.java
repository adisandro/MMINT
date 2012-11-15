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
package edu.toronto.cs.se.mmtf.mid;

import edu.toronto.cs.se.mmtf.mavo.MavoPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	int EXTENDIBLE_ELEMENT = 1;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementEndpointImpl <em>Extendible Element Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementEndpointImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElementEndpoint()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl <em>Multi Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMultiModel()
	 * @generated
	 */
	int MULTI_MODEL = 3;

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
	int ESTRING_TO_EXTENDIBLE_ELEMENT_MAP = 0;

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
	 * The number of structural features of the '<em>Extendible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_FEATURE_COUNT = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Extendible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_OPERATION_COUNT = MavoPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ELEMENTS = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CONSTRAINT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CONVERSION_OPERATORS = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 7;

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
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 2;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelConstraintImpl <em>Model Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelConstraintImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelConstraint()
	 * @generated
	 */
	int MODEL_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONSTRAINT__BODY = 0;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONSTRAINT__ENGINE = 1;

	/**
	 * The number of structural features of the '<em>Model Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONSTRAINT_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__CATEGORY = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pointer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__POINTER = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__CLASS_LITERAL = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 3;

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
	 * The number of operations of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OPERATION_COUNT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementEntityWildcardImpl <em>Model Element Entity Wildcard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelElementEntityWildcardImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelElementEntityWildcard()
	 * @generated
	 */
	int MODEL_ELEMENT_ENTITY_WILDCARD = 7;

	/**
	 * The feature id for the '<em><b>Model Element Relationship Wildcard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENTITY_WILDCARD__MODEL_ELEMENT_RELATIONSHIP_WILDCARD = 0;

	/**
	 * The number of structural features of the '<em>Model Element Entity Wildcard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENTITY_WILDCARD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model Element Entity Wildcard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENTITY_WILDCARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl <em>Model Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelEndpointImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelEndpoint()
	 * @generated
	 */
	int MODEL_ENDPOINT = 8;

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
	 * The number of operations of the '<em>Model Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_OPERATION_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 3;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElementCategory <em>Model Element Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElementCategory
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelElementCategory()
	 * @generated
	 */
	int MODEL_ELEMENT_CATEGORY = 12;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine <em>Model Constraint Engine</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelConstraintEngine()
	 * @generated
	 */
	int MODEL_CONSTRAINT_ENGINE = 11;

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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.Model#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getElements()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmtf.mid.Model#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getConstraint()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Constraint();

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
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#getCategory()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Category();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getPointer <em>Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pointer</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#getPointer()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_Pointer();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getClassLiteral <em>Class Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Literal</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElement#getClassLiteral()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_ClassLiteral();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint <em>Model Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Constraint</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraint
	 * @generated
	 */
	EClass getModelConstraint();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraint#getBody()
	 * @see #getModelConstraint()
	 * @generated
	 */
	EAttribute getModelConstraint_Body();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraint#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Engine</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraint#getEngine()
	 * @see #getModelConstraint()
	 * @generated
	 */
	EAttribute getModelConstraint_Engine();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.ModelElementEntityWildcard <em>Model Element Entity Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Entity Wildcard</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElementEntityWildcard
	 * @generated
	 */
	EClass getModelElementEntityWildcard();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.ModelElementEntityWildcard#getModelElementRelationshipWildcard <em>Model Element Relationship Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element Relationship Wildcard</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElementEntityWildcard#getModelElementRelationshipWildcard()
	 * @see #getModelElementEntityWildcard()
	 * @generated
	 */
	EReference getModelElementEntityWildcard_ModelElementRelationshipWildcard();

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
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmtf.mid.ModelElementCategory <em>Model Element Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Element Category</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElementCategory
	 * @generated
	 */
	EEnum getModelElementCategory();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine <em>Model Constraint Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Constraint Engine</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine
	 * @generated
	 */
	EEnum getModelConstraintEngine();

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
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__CONSTRAINT = eINSTANCE.getModel_Constraint();

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
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__CATEGORY = eINSTANCE.getModelElement_Category();

		/**
		 * The meta object literal for the '<em><b>Pointer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__POINTER = eINSTANCE.getModelElement_Pointer();

		/**
		 * The meta object literal for the '<em><b>Class Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__CLASS_LITERAL = eINSTANCE.getModelElement_ClassLiteral();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelConstraintImpl <em>Model Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelConstraintImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelConstraint()
		 * @generated
		 */
		EClass MODEL_CONSTRAINT = eINSTANCE.getModelConstraint();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CONSTRAINT__BODY = eINSTANCE.getModelConstraint_Body();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CONSTRAINT__ENGINE = eINSTANCE.getModelConstraint_Engine();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementEntityWildcardImpl <em>Model Element Entity Wildcard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelElementEntityWildcardImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelElementEntityWildcard()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ENTITY_WILDCARD = eINSTANCE.getModelElementEntityWildcard();

		/**
		 * The meta object literal for the '<em><b>Model Element Relationship Wildcard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_ENTITY_WILDCARD__MODEL_ELEMENT_RELATIONSHIP_WILDCARD = eINSTANCE.getModelElementEntityWildcard_ModelElementRelationshipWildcard();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElementCategory <em>Model Element Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.ModelElementCategory
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelElementCategory()
		 * @generated
		 */
		EEnum MODEL_ELEMENT_CATEGORY = eINSTANCE.getModelElementCategory();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine <em>Model Constraint Engine</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelConstraintEngine()
		 * @generated
		 */
		EEnum MODEL_CONSTRAINT_ENGINE = eINSTANCE.getModelConstraintEngine();

	}

} //MidPackage
