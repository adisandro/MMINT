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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	String eNS_URI = "http:///edu/toronto/cs/se/mmtf/model/mid.ecore";

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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__METATYPE = 1;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__LEVEL = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl <em>Extendible Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getExtendibleElement()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__METATYPE = TYPED_ELEMENT__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__LEVEL = TYPED_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__URI = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT__SUPERTYPE = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Extendible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Extendible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl <em>Multi Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMultiModel()
	 * @generated
	 */
	int MULTI_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__MODELS = 0;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__EDITORS = 1;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__OPERATORS = 2;

	/**
	 * The feature id for the '<em><b>Extendibles</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__EXTENDIBLES = 3;

	/**
	 * The number of structural features of the '<em>Multi Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Multi Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__METATYPE = EXTENDIBLE_ELEMENT__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__LEVEL = EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__TYPE = EXTENDIBLE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__URI = EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SUPERTYPE = EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ROOT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.EStringToExtendibleElementMapImpl <em>EString To Extendible Element Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.EStringToExtendibleElementMapImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getEStringToExtendibleElementMap()
	 * @generated
	 */
	int ESTRING_TO_EXTENDIBLE_ELEMENT_MAP = 4;

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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl <em>Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__NAME = EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__METATYPE = EXTENDIBLE_ELEMENT__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__LEVEL = EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__TYPE = EXTENDIBLE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__URI = EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__SUPERTYPE = EXTENDIBLE_ELEMENT__SUPERTYPE;

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
	 * The number of structural features of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = EXTENDIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_OPERATION_COUNT = EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.MidLevel <em>Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.MidLevel
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMidLevel()
	 * @generated
	 */
	int MID_LEVEL = 6;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.ModelOrigin <em>Model Origin</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.ModelOrigin
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelOrigin()
	 * @generated
	 */
	int MODEL_ORIGIN = 7;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.ModelElementCategory <em>Model Element Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElementCategory
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelElementCategory()
	 * @generated
	 */
	int MODEL_ELEMENT_CATEGORY = 8;

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
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Editors</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getEditors()
	 * @see #getMultiModel()
	 * @generated
	 */
	EReference getMultiModel_Editors();

	/**
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Operators</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getOperators()
	 * @see #getMultiModel()
	 * @generated
	 */
	EReference getMultiModel_Operators();

	/**
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getExtendibles <em>Extendibles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Extendibles</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getExtendibles()
	 * @see #getMultiModel()
	 * @generated
	 */
	EReference getMultiModel_Extendibles();

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
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.Model#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.Model#getRoot()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Root();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.TypedElement#getName()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_Name();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getMetatype <em>Metatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metatype</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.TypedElement#getMetatype()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Metatype();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.TypedElement#getLevel()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_Level();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_Type();

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
		 * The meta object literal for the '<em><b>Editors</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_MODEL__EDITORS = eINSTANCE.getMultiModel_Editors();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_MODEL__OPERATORS = eINSTANCE.getMultiModel_Operators();

		/**
		 * The meta object literal for the '<em><b>Extendibles</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_MODEL__EXTENDIBLES = eINSTANCE.getMultiModel_Extendibles();

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
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ROOT = eINSTANCE.getModel_Root();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__NAME = eINSTANCE.getTypedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Metatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__METATYPE = eINSTANCE.getTypedElement_Metatype();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__LEVEL = eINSTANCE.getTypedElement_Level();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

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

	}

} //MidPackage
