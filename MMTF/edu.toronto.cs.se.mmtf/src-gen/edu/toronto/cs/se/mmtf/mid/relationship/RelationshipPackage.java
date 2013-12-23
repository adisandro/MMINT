/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship;

import edu.toronto.cs.se.mmtf.mid.MidPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface RelationshipPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "relationship";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/mmtf/MID/Relationship";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "relationship";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationshipPackage eINSTANCE = edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl <em>Model Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelRel()
	 * @generated
	 */
	int MODEL_REL = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryModelRelImpl <em>Binary Model Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryModelRelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getBinaryModelRel()
	 * @generated
	 */
	int BINARY_MODEL_REL = 3;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelEndpointReferenceImpl <em>Model Endpoint Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelEndpointReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelEndpointReference()
	 * @generated
	 */
	int MODEL_ENDPOINT_REFERENCE = 4;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl <em>Extendible Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getExtendibleElementReference()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF = 3;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE = 4;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE__URI = 5;

	/**
	 * The number of structural features of the '<em>Extendible Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Extendible Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementEndpointReferenceImpl <em>Extendible Element Endpoint Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementEndpointReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getExtendibleElementEndpointReference()
	 * @generated
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__URI = EXTENDIBLE_ELEMENT_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__TARGET_URI = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extendible Element Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Extendible Element Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MAY = MidPackage.MODEL__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__SET = MidPackage.MODEL__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__VAR = MidPackage.MODEL__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__FORMULA_ID = MidPackage.MODEL__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__SUPERTYPE = MidPackage.MODEL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__METATYPE = MidPackage.MODEL__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__URI = MidPackage.MODEL__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__NAME = MidPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__LEVEL = MidPackage.MODEL__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__METATYPE_URI = MidPackage.MODEL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__DYNAMIC = MidPackage.MODEL__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__CONSTRAINT = MidPackage.MODEL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__INC = MidPackage.MODEL__INC;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__ORIGIN = MidPackage.MODEL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__FILE_EXTENSION = MidPackage.MODEL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__EDITORS = MidPackage.MODEL__EDITORS;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MODEL_ELEMS = MidPackage.MODEL__MODEL_ELEMS;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__CONVERSION_OPERATORS = MidPackage.MODEL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__ABSTRACT = MidPackage.MODEL__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MODEL_ENDPOINTS = MidPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__LINKS = MidPackage.MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MODEL_ENDPOINT_REFS = MidPackage.MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Link Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__LINK_REFS = MidPackage.MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL_FEATURE_COUNT = MidPackage.MODEL_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN = MidPackage.MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = MidPackage.MODEL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = MidPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_METATYPE = MidPackage.MODEL_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_SUPERTYPE = MidPackage.MODEL_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING = MidPackage.MODEL_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Copy Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___COPY_SUBTYPE__MODELREL = MidPackage.MODEL_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Outline Resource Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = MidPackage.MODEL_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___DELETE_TYPE = MidPackage.MODEL_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL = MidPackage.MODEL_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = MidPackage.MODEL_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___DELETE_INSTANCE = MidPackage.MODEL_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Open Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___OPEN_TYPE = MidPackage.MODEL_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Open Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL___OPEN_INSTANCE = MidPackage.MODEL_OPERATION_COUNT + 10;

	/**
	 * The number of operations of the '<em>Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL_OPERATION_COUNT = MidPackage.MODEL_OPERATION_COUNT + 11;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MAY = MODEL_REL__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__SET = MODEL_REL__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__VAR = MODEL_REL__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__FORMULA_ID = MODEL_REL__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__SUPERTYPE = MODEL_REL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__METATYPE = MODEL_REL__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__URI = MODEL_REL__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__NAME = MODEL_REL__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__LEVEL = MODEL_REL__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__METATYPE_URI = MODEL_REL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__DYNAMIC = MODEL_REL__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__CONSTRAINT = MODEL_REL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__INC = MODEL_REL__INC;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__ORIGIN = MODEL_REL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__FILE_EXTENSION = MODEL_REL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__EDITORS = MODEL_REL__EDITORS;

	/**
	 * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MODEL_ELEMS = MODEL_REL__MODEL_ELEMS;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__CONVERSION_OPERATORS = MODEL_REL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__ABSTRACT = MODEL_REL__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MODEL_ENDPOINTS = MODEL_REL__MODEL_ENDPOINTS;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__LINKS = MODEL_REL__LINKS;

	/**
	 * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MODEL_ENDPOINT_REFS = MODEL_REL__MODEL_ENDPOINT_REFS;

	/**
	 * The feature id for the '<em><b>Link Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__LINK_REFS = MODEL_REL__LINK_REFS;

	/**
	 * The feature id for the '<em><b>Source Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__SOURCE_MODEL = MODEL_REL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__TARGET_MODEL = MODEL_REL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL_FEATURE_COUNT = MODEL_REL_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN = MODEL_REL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL = MODEL_REL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Create Instance And Editor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL = MODEL_REL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_METATYPE = MODEL_REL___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_SUPERTYPE = MODEL_REL___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Create Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING = MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING;

	/**
	 * The operation id for the '<em>Copy Subtype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___COPY_SUBTYPE__MODELREL = MODEL_REL___COPY_SUBTYPE__MODELREL;

	/**
	 * The operation id for the '<em>Get Outline Resource Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = MODEL_REL___GET_OUTLINE_RESOURCE_TYPES;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___DELETE_TYPE = MODEL_REL___DELETE_TYPE;

	/**
	 * The operation id for the '<em>Create Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL = MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL;

	/**
	 * The operation id for the '<em>Get Outline Resource Instances</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___DELETE_INSTANCE = MODEL_REL___DELETE_INSTANCE;

	/**
	 * The operation id for the '<em>Open Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___OPEN_TYPE = MODEL_REL___OPEN_TYPE;

	/**
	 * The operation id for the '<em>Open Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL___OPEN_INSTANCE = MODEL_REL___OPEN_INSTANCE;

	/**
	 * The number of operations of the '<em>Binary Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL_OPERATION_COUNT = MODEL_REL_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__URI = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__TARGET_URI = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Model Elem Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Accept Model Element Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Accept Model Element Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Model Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ENDPOINT_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementReferenceImpl <em>Model Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelElementReference()
	 * @generated
	 */
	int MODEL_ELEMENT_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__URI = EXTENDIBLE_ELEMENT_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 6;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__MAY = MidPackage.EXTENDIBLE_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SET = MidPackage.EXTENDIBLE_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__VAR = MidPackage.EXTENDIBLE_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__FORMULA_ID = MidPackage.EXTENDIBLE_ELEMENT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SUPERTYPE = MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__METATYPE = MidPackage.EXTENDIBLE_ELEMENT__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__URI = MidPackage.EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__NAME = MidPackage.EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__LEVEL = MidPackage.EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__METATYPE_URI = MidPackage.EXTENDIBLE_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__DYNAMIC = MidPackage.EXTENDIBLE_ELEMENT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__CONSTRAINT = MidPackage.EXTENDIBLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__MODEL_ELEM_ENDPOINTS = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__MODEL_ELEM_ENDPOINT_REFS = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___GET_METATYPE = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___GET_SUPERTYPE = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___CREATE_TYPE_REFERENCE__LINKREFERENCE_BOOLEAN_MODELREL = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___CREATE_SUBTYPE_AND_REFERENCE__LINKREFERENCE_STRING_BOOLEAN_MODELREL = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___DELETE_TYPE = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Create Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___CREATE_INSTANCE_REFERENCE__MODELREL = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___DELETE_INSTANCE = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkImpl <em>Binary Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getBinaryLink()
	 * @generated
	 */
	int BINARY_LINK = 7;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__MAY = LINK__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__SET = LINK__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__VAR = LINK__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__FORMULA_ID = LINK__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__SUPERTYPE = LINK__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__METATYPE = LINK__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__URI = LINK__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__NAME = LINK__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__LEVEL = LINK__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__METATYPE_URI = LINK__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__DYNAMIC = LINK__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__CONSTRAINT = LINK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__MODEL_ELEM_ENDPOINTS = LINK__MODEL_ELEM_ENDPOINTS;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__MODEL_ELEM_ENDPOINT_REFS = LINK__MODEL_ELEM_ENDPOINT_REFS;

	/**
	 * The number of structural features of the '<em>Binary Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_FEATURE_COUNT = LINK_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK___GET_METATYPE = LINK___GET_METATYPE;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK___GET_SUPERTYPE = LINK___GET_SUPERTYPE;

	/**
	 * The operation id for the '<em>Create Subtype And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK___CREATE_SUBTYPE_AND_REFERENCE__LINKREFERENCE_STRING_BOOLEAN_MODELREL = LINK___CREATE_SUBTYPE_AND_REFERENCE__LINKREFERENCE_STRING_BOOLEAN_MODELREL;

	/**
	 * The operation id for the '<em>Delete Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK___DELETE_TYPE = LINK___DELETE_TYPE;

	/**
	 * The operation id for the '<em>Create Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = LINK___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL;

	/**
	 * The operation id for the '<em>Delete Instance</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK___DELETE_INSTANCE = LINK___DELETE_INSTANCE;

	/**
	 * The operation id for the '<em>Create Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK___CREATE_TYPE_REFERENCE__LINKREFERENCE_BOOLEAN_MODELREL = LINK_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Create Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK___CREATE_INSTANCE_REFERENCE__MODELREL = LINK_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Binary Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_OPERATION_COUNT = LINK_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointImpl <em>Model Element Endpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelElementEndpoint()
	 * @generated
	 */
	int MODEL_ELEMENT_ENDPOINT = 8;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__MAY = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__SET = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__VAR = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__FORMULA_ID = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__FORMULA_ID;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__SUPERTYPE = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__METATYPE = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__METATYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__URI = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__URI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__NAME = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__NAME;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__LEVEL = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LEVEL;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__METATYPE_URI = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__DYNAMIC = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__DYNAMIC;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__CONSTRAINT = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__LOWER_BOUND = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__UPPER_BOUND = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__TARGET = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT__TARGET_URI = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET_URI;

	/**
	 * The number of structural features of the '<em>Model Element Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_FEATURE_COUNT = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_TARGET = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Metatype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT___GET_METATYPE = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Model Element Endpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_OPERATION_COUNT = MidPackage.EXTENDIBLE_ELEMENT_ENDPOINT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkReferenceImpl <em>Link Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getLinkReference()
	 * @generated
	 */
	int LINK_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE__OBJECT = EXTENDIBLE_ELEMENT_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE__URI = EXTENDIBLE_ELEMENT_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Link Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE___DELETE_TYPE_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Delete Type And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE___DELETE_TYPE_AND_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Delete Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE___DELETE_INSTANCE_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Delete Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Link Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_REFERENCE_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkReferenceImpl <em>Binary Link Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getBinaryLinkReference()
	 * @generated
	 */
	int BINARY_LINK_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__REFERENCED_OBJECT = LINK_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__CONTAINED_OBJECT = LINK_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__OBJECT = LINK_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__SUPERTYPE_REF = LINK_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__MODIFIABLE = LINK_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__URI = LINK_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

	/**
	 * The feature id for the '<em><b>Source Model Elem Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__SOURCE_MODEL_ELEM_REF = LINK_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Model Elem Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE__TARGET_MODEL_ELEM_REF = LINK_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Link Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE_FEATURE_COUNT = LINK_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE___GET_SUPERTYPE_REF = LINK_REFERENCE___GET_SUPERTYPE_REF;

	/**
	 * The operation id for the '<em>Delete Type Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE___DELETE_TYPE_REFERENCE = LINK_REFERENCE___DELETE_TYPE_REFERENCE;

	/**
	 * The operation id for the '<em>Delete Type And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE___DELETE_TYPE_AND_REFERENCE = LINK_REFERENCE___DELETE_TYPE_AND_REFERENCE;

	/**
	 * The operation id for the '<em>Delete Instance Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE___DELETE_INSTANCE_REFERENCE = LINK_REFERENCE___DELETE_INSTANCE_REFERENCE;

	/**
	 * The operation id for the '<em>Delete Instance And Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = LINK_REFERENCE___DELETE_INSTANCE_AND_REFERENCE;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE___GET_OBJECT = LINK_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Link Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_REFERENCE_OPERATION_COUNT = LINK_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointReferenceImpl <em>Model Element Endpoint Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelElementEndpointReference()
	 * @generated
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__REFERENCED_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__CONTAINED_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__SUPERTYPE_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__SUPERTYPE_REF;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__MODIFIABLE = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__URI = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__TARGET_URI = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Model Elem Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Supertype Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model Element Endpoint Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT = EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE_OPERATION_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel <em>Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Rel</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel
	 * @generated
	 */
	EClass getModelRel();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModelEndpoints <em>Model Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Endpoints</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModelEndpoints()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_ModelEndpoints();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getLinks()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_Links();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModelEndpointRefs <em>Model Endpoint Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Endpoint Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModelEndpointRefs()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_ModelEndpointRefs();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getLinkRefs <em>Link Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getLinkRefs()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_LinkRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getMetatype()
	 * @generated
	 */
	EOperation getModelRel__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getSupertype()
	 * @generated
	 */
	EOperation getModelRel__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#createSubtype(java.lang.String, boolean, java.lang.String, java.lang.String) <em>Create Subtype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#createSubtype(java.lang.String, boolean, java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getModelRel__CreateSubtype__String_boolean_String_String();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#copySubtype(edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Copy Subtype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Copy Subtype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#copySubtype(edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getModelRel__CopySubtype__ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#deleteType()
	 * @generated
	 */
	EOperation getModelRel__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#createInstance(java.lang.String, boolean, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel) <em>Create Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#createInstance(java.lang.String, boolean, edu.toronto.cs.se.mmtf.mid.ModelOrigin, edu.toronto.cs.se.mmtf.mid.MultiModel)
	 * @generated
	 */
	EOperation getModelRel__CreateInstance__String_boolean_ModelOrigin_MultiModel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#deleteInstance()
	 * @generated
	 */
	EOperation getModelRel__DeleteInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#openType() <em>Open Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Open Type</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#openType()
	 * @generated
	 */
	EOperation getModelRel__OpenType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#openInstance() <em>Open Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Open Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#openInstance()
	 * @generated
	 */
	EOperation getModelRel__OpenInstance();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getOutlineResourceTypes() <em>Get Outline Resource Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outline Resource Types</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getOutlineResourceTypes()
	 * @generated
	 */
	EOperation getModelRel__GetOutlineResourceTypes();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getOutlineResourceInstances() <em>Get Outline Resource Instances</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Outline Resource Instances</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getOutlineResourceInstances()
	 * @generated
	 */
	EOperation getModelRel__GetOutlineResourceInstances();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel <em>Binary Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Model Rel</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel
	 * @generated
	 */
	EClass getBinaryModelRel();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel#getSourceModel <em>Source Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel#getSourceModel()
	 * @see #getBinaryModelRel()
	 * @generated
	 */
	EReference getBinaryModelRel_SourceModel();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel#getTargetModel <em>Target Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel#getTargetModel()
	 * @see #getBinaryModelRel()
	 * @generated
	 */
	EReference getBinaryModelRel_TargetModel();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference <em>Model Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Endpoint Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference
	 * @generated
	 */
	EClass getModelEndpointReference();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#getModelElemRefs <em>Model Elem Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elem Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#getModelElemRefs()
	 * @see #getModelEndpointReference()
	 * @generated
	 */
	EReference getModelEndpointReference_ModelElemRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#getObject()
	 * @generated
	 */
	EOperation getModelEndpointReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getModelEndpointReference__GetSupertypeRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#acceptModelElementType(org.eclipse.emf.ecore.EObject) <em>Accept Model Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept Model Element Type</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#acceptModelElementType(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getModelEndpointReference__AcceptModelElementType__EObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#deleteTypeReference(boolean) <em>Delete Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#deleteTypeReference(boolean)
	 * @generated
	 */
	EOperation getModelEndpointReference__DeleteTypeReference__boolean();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#acceptModelElementInstance(org.eclipse.emf.ecore.EObject) <em>Accept Model Element Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept Model Element Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#acceptModelElementInstance(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getModelEndpointReference__AcceptModelElementInstance__EObject();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference <em>Model Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference
	 * @generated
	 */
	EClass getModelElementReference();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Elem Endpoint Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getModelElemEndpointRefs()
	 * @see #getModelElementReference()
	 * @generated
	 */
	EReference getModelElementReference_ModelElemEndpointRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getObject()
	 * @generated
	 */
	EOperation getModelElementReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getModelElementReference__GetSupertypeRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#deleteTypeReference() <em>Delete Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#deleteTypeReference()
	 * @generated
	 */
	EOperation getModelElementReference__DeleteTypeReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#deleteInstanceReference() <em>Delete Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#deleteInstanceReference()
	 * @generated
	 */
	EOperation getModelElementReference__DeleteInstanceReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#getModelElemEndpoints <em>Model Elem Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elem Endpoints</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#getModelElemEndpoints()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_ModelElemEndpoints();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Elem Endpoint Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#getModelElemEndpointRefs()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_ModelElemEndpointRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#getMetatype()
	 * @generated
	 */
	EOperation getLink__GetMetatype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#getSupertype()
	 * @generated
	 */
	EOperation getLink__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.LinkReference, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.LinkReference, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getLink__CreateTypeReference__LinkReference_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#createSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.relationship.LinkReference, java.lang.String, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Subtype And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Subtype And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#createSubtypeAndReference(edu.toronto.cs.se.mmtf.mid.relationship.LinkReference, java.lang.String, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getLink__CreateSubtypeAndReference__LinkReference_String_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#deleteType() <em>Delete Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#deleteType()
	 * @generated
	 */
	EOperation getLink__DeleteType();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#createInstanceReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#createInstanceReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getLink__CreateInstanceReference__ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#createInstanceAndReference(boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#createInstanceAndReference(boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getLink__CreateInstanceAndReference__boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#deleteInstance() <em>Delete Instance</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#deleteInstance()
	 * @generated
	 */
	EOperation getLink__DeleteInstance();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink <em>Binary Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Link</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink
	 * @generated
	 */
	EClass getBinaryLink();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.LinkReference, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink#createTypeReference(edu.toronto.cs.se.mmtf.mid.relationship.LinkReference, boolean, edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getBinaryLink__CreateTypeReference__LinkReference_boolean_ModelRel();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink#createInstanceReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelRel) <em>Create Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink#createInstanceReference(edu.toronto.cs.se.mmtf.mid.relationship.ModelRel)
	 * @generated
	 */
	EOperation getBinaryLink__CreateInstanceReference__ModelRel();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint <em>Model Element Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Endpoint</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint
	 * @generated
	 */
	EClass getModelElementEndpoint();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint#getSupertype() <em>Get Supertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint#getSupertype()
	 * @generated
	 */
	EOperation getModelElementEndpoint__GetSupertype();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint#getTarget()
	 * @generated
	 */
	EOperation getModelElementEndpoint__GetTarget();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint#getMetatype() <em>Get Metatype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Metatype</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint#getMetatype()
	 * @generated
	 */
	EOperation getModelElementEndpoint__GetMetatype();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference <em>Extendible Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference
	 * @generated
	 */
	EClass getExtendibleElementReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getReferencedObject <em>Referenced Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Object</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getReferencedObject()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EReference getExtendibleElementReference_ReferencedObject();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getContainedObject <em>Contained Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Object</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getContainedObject()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EReference getExtendibleElementReference_ContainedObject();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getObject()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EReference getExtendibleElementReference_Object();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getSupertypeRef <em>Supertype Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supertype Ref</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getSupertypeRef()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EReference getExtendibleElementReference_SupertypeRef();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#isModifiable <em>Modifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifiable</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#isModifiable()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EAttribute getExtendibleElementReference_Modifiable();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference#getUri()
	 * @see #getExtendibleElementReference()
	 * @generated
	 */
	EAttribute getExtendibleElementReference_Uri();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference <em>Extendible Element Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extendible Element Endpoint Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference
	 * @generated
	 */
	EClass getExtendibleElementEndpointReference();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference#getTargetUri <em>Target Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Uri</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference#getTargetUri()
	 * @see #getExtendibleElementEndpointReference()
	 * @generated
	 */
	EAttribute getExtendibleElementEndpointReference_TargetUri();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference#getObject()
	 * @generated
	 */
	EOperation getExtendibleElementEndpointReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getExtendibleElementEndpointReference__GetSupertypeRef();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference <em>Link Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.LinkReference
	 * @generated
	 */
	EClass getLinkReference();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Elem Endpoint Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#getModelElemEndpointRefs()
	 * @see #getLinkReference()
	 * @generated
	 */
	EReference getLinkReference_ModelElemEndpointRefs();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#getObject()
	 * @generated
	 */
	EOperation getLinkReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getLinkReference__GetSupertypeRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#deleteTypeReference() <em>Delete Type Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#deleteTypeReference()
	 * @generated
	 */
	EOperation getLinkReference__DeleteTypeReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#deleteTypeAndReference() <em>Delete Type And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Type And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#deleteTypeAndReference()
	 * @generated
	 */
	EOperation getLinkReference__DeleteTypeAndReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#deleteInstanceReference() <em>Delete Instance Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#deleteInstanceReference()
	 * @generated
	 */
	EOperation getLinkReference__DeleteInstanceReference();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#deleteInstanceAndReference() <em>Delete Instance And Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delete Instance And Reference</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#deleteInstanceAndReference()
	 * @generated
	 */
	EOperation getLinkReference__DeleteInstanceAndReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference <em>Binary Link Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Link Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference
	 * @generated
	 */
	EClass getBinaryLinkReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference#getSourceModelElemRef <em>Source Model Elem Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Model Elem Ref</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference#getSourceModelElemRef()
	 * @see #getBinaryLinkReference()
	 * @generated
	 */
	EReference getBinaryLinkReference_SourceModelElemRef();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference#getTargetModelElemRef <em>Target Model Elem Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Model Elem Ref</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference#getTargetModelElemRef()
	 * @see #getBinaryLinkReference()
	 * @generated
	 */
	EReference getBinaryLinkReference_TargetModelElemRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference#getObject()
	 * @generated
	 */
	EOperation getBinaryLinkReference__GetObject();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference <em>Model Element Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Endpoint Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference
	 * @generated
	 */
	EClass getModelElementEndpointReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference#getModelElemRef <em>Model Elem Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Elem Ref</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference#getModelElemRef()
	 * @see #getModelElementEndpointReference()
	 * @generated
	 */
	EReference getModelElementEndpointReference_ModelElemRef();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference#getObject() <em>Get Object</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Object</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference#getObject()
	 * @generated
	 */
	EOperation getModelElementEndpointReference__GetObject();

	/**
	 * Returns the meta object for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference#getSupertypeRef() <em>Get Supertype Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Supertype Ref</em>' operation.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference#getSupertypeRef()
	 * @generated
	 */
	EOperation getModelElementEndpointReference__GetSupertypeRef();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RelationshipFactory getRelationshipFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl <em>Model Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelRel()
		 * @generated
		 */
		EClass MODEL_REL = eINSTANCE.getModelRel();

		/**
		 * The meta object literal for the '<em><b>Model Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__MODEL_ENDPOINTS = eINSTANCE.getModelRel_ModelEndpoints();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__LINKS = eINSTANCE.getModelRel_Links();

		/**
		 * The meta object literal for the '<em><b>Model Endpoint Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__MODEL_ENDPOINT_REFS = eINSTANCE.getModelRel_ModelEndpointRefs();

		/**
		 * The meta object literal for the '<em><b>Link Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__LINK_REFS = eINSTANCE.getModelRel_LinkRefs();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_METATYPE = eINSTANCE.getModelRel__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_SUPERTYPE = eINSTANCE.getModelRel__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Create Subtype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING = eINSTANCE.getModelRel__CreateSubtype__String_boolean_String_String();

		/**
		 * The meta object literal for the '<em><b>Copy Subtype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___COPY_SUBTYPE__MODELREL = eINSTANCE.getModelRel__CopySubtype__ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___DELETE_TYPE = eINSTANCE.getModelRel__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL = eINSTANCE.getModelRel__CreateInstance__String_boolean_ModelOrigin_MultiModel();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___DELETE_INSTANCE = eINSTANCE.getModelRel__DeleteInstance();

		/**
		 * The meta object literal for the '<em><b>Open Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___OPEN_TYPE = eINSTANCE.getModelRel__OpenType();

		/**
		 * The meta object literal for the '<em><b>Open Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___OPEN_INSTANCE = eINSTANCE.getModelRel__OpenInstance();

		/**
		 * The meta object literal for the '<em><b>Get Outline Resource Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_OUTLINE_RESOURCE_TYPES = eINSTANCE.getModelRel__GetOutlineResourceTypes();

		/**
		 * The meta object literal for the '<em><b>Get Outline Resource Instances</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES = eINSTANCE.getModelRel__GetOutlineResourceInstances();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryModelRelImpl <em>Binary Model Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryModelRelImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getBinaryModelRel()
		 * @generated
		 */
		EClass BINARY_MODEL_REL = eINSTANCE.getBinaryModelRel();

		/**
		 * The meta object literal for the '<em><b>Source Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MODEL_REL__SOURCE_MODEL = eINSTANCE.getBinaryModelRel_SourceModel();

		/**
		 * The meta object literal for the '<em><b>Target Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MODEL_REL__TARGET_MODEL = eINSTANCE.getBinaryModelRel_TargetModel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelEndpointReferenceImpl <em>Model Endpoint Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelEndpointReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelEndpointReference()
		 * @generated
		 */
		EClass MODEL_ENDPOINT_REFERENCE = eINSTANCE.getModelEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Model Elem Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS = eINSTANCE.getModelEndpointReference_ModelElemRefs();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___GET_OBJECT = eINSTANCE.getModelEndpointReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getModelEndpointReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Accept Model Element Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT = eINSTANCE.getModelEndpointReference__AcceptModelElementType__EObject();

		/**
		 * The meta object literal for the '<em><b>Delete Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN = eINSTANCE.getModelEndpointReference__DeleteTypeReference__boolean();

		/**
		 * The meta object literal for the '<em><b>Accept Model Element Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT = eINSTANCE.getModelEndpointReference__AcceptModelElementInstance__EObject();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementReferenceImpl <em>Model Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelElementReference()
		 * @generated
		 */
		EClass MODEL_ELEMENT_REFERENCE = eINSTANCE.getModelElementReference();

		/**
		 * The meta object literal for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = eINSTANCE.getModelElementReference_ModelElemEndpointRefs();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_REFERENCE___GET_OBJECT = eINSTANCE.getModelElementReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getModelElementReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Delete Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE = eINSTANCE.getModelElementReference__DeleteTypeReference();

		/**
		 * The meta object literal for the '<em><b>Delete Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE = eINSTANCE.getModelElementReference__DeleteInstanceReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Model Elem Endpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__MODEL_ELEM_ENDPOINTS = eINSTANCE.getLink_ModelElemEndpoints();

		/**
		 * The meta object literal for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__MODEL_ELEM_ENDPOINT_REFS = eINSTANCE.getLink_ModelElemEndpointRefs();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___GET_METATYPE = eINSTANCE.getLink__GetMetatype();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___GET_SUPERTYPE = eINSTANCE.getLink__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Create Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___CREATE_TYPE_REFERENCE__LINKREFERENCE_BOOLEAN_MODELREL = eINSTANCE.getLink__CreateTypeReference__LinkReference_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Subtype And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___CREATE_SUBTYPE_AND_REFERENCE__LINKREFERENCE_STRING_BOOLEAN_MODELREL = eINSTANCE.getLink__CreateSubtypeAndReference__LinkReference_String_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___DELETE_TYPE = eINSTANCE.getLink__DeleteType();

		/**
		 * The meta object literal for the '<em><b>Create Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___CREATE_INSTANCE_REFERENCE__MODELREL = eINSTANCE.getLink__CreateInstanceReference__ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL = eINSTANCE.getLink__CreateInstanceAndReference__boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___DELETE_INSTANCE = eINSTANCE.getLink__DeleteInstance();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkImpl <em>Binary Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getBinaryLink()
		 * @generated
		 */
		EClass BINARY_LINK = eINSTANCE.getBinaryLink();

		/**
		 * The meta object literal for the '<em><b>Create Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_LINK___CREATE_TYPE_REFERENCE__LINKREFERENCE_BOOLEAN_MODELREL = eINSTANCE.getBinaryLink__CreateTypeReference__LinkReference_boolean_ModelRel();

		/**
		 * The meta object literal for the '<em><b>Create Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_LINK___CREATE_INSTANCE_REFERENCE__MODELREL = eINSTANCE.getBinaryLink__CreateInstanceReference__ModelRel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointImpl <em>Model Element Endpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelElementEndpoint()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ENDPOINT = eINSTANCE.getModelElementEndpoint();

		/**
		 * The meta object literal for the '<em><b>Get Supertype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE = eINSTANCE.getModelElementEndpoint__GetSupertype();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___GET_TARGET = eINSTANCE.getModelElementEndpoint__GetTarget();

		/**
		 * The meta object literal for the '<em><b>Get Metatype</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT___GET_METATYPE = eINSTANCE.getModelElementEndpoint__GetMetatype();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl <em>Extendible Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getExtendibleElementReference()
		 * @generated
		 */
		EClass EXTENDIBLE_ELEMENT_REFERENCE = eINSTANCE.getExtendibleElementReference();

		/**
		 * The meta object literal for the '<em><b>Referenced Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT = eINSTANCE.getExtendibleElementReference_ReferencedObject();

		/**
		 * The meta object literal for the '<em><b>Contained Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT = eINSTANCE.getExtendibleElementReference_ContainedObject();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT_REFERENCE__OBJECT = eINSTANCE.getExtendibleElementReference_Object();

		/**
		 * The meta object literal for the '<em><b>Supertype Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF = eINSTANCE.getExtendibleElementReference_SupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Modifiable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE = eINSTANCE.getExtendibleElementReference_Modifiable();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_REFERENCE__URI = eINSTANCE.getExtendibleElementReference_Uri();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementEndpointReferenceImpl <em>Extendible Element Endpoint Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ExtendibleElementEndpointReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getExtendibleElementEndpointReference()
		 * @generated
		 */
		EClass EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE = eINSTANCE.getExtendibleElementEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Target Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__TARGET_URI = eINSTANCE.getExtendibleElementEndpointReference_TargetUri();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT = eINSTANCE.getExtendibleElementEndpointReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getExtendibleElementEndpointReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkReferenceImpl <em>Link Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getLinkReference()
		 * @generated
		 */
		EClass LINK_REFERENCE = eINSTANCE.getLinkReference();

		/**
		 * The meta object literal for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = eINSTANCE.getLinkReference_ModelElemEndpointRefs();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK_REFERENCE___GET_OBJECT = eINSTANCE.getLinkReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getLinkReference__GetSupertypeRef();

		/**
		 * The meta object literal for the '<em><b>Delete Type Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK_REFERENCE___DELETE_TYPE_REFERENCE = eINSTANCE.getLinkReference__DeleteTypeReference();

		/**
		 * The meta object literal for the '<em><b>Delete Type And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK_REFERENCE___DELETE_TYPE_AND_REFERENCE = eINSTANCE.getLinkReference__DeleteTypeAndReference();

		/**
		 * The meta object literal for the '<em><b>Delete Instance Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK_REFERENCE___DELETE_INSTANCE_REFERENCE = eINSTANCE.getLinkReference__DeleteInstanceReference();

		/**
		 * The meta object literal for the '<em><b>Delete Instance And Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK_REFERENCE___DELETE_INSTANCE_AND_REFERENCE = eINSTANCE.getLinkReference__DeleteInstanceAndReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkReferenceImpl <em>Binary Link Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getBinaryLinkReference()
		 * @generated
		 */
		EClass BINARY_LINK_REFERENCE = eINSTANCE.getBinaryLinkReference();

		/**
		 * The meta object literal for the '<em><b>Source Model Elem Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_LINK_REFERENCE__SOURCE_MODEL_ELEM_REF = eINSTANCE.getBinaryLinkReference_SourceModelElemRef();

		/**
		 * The meta object literal for the '<em><b>Target Model Elem Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_LINK_REFERENCE__TARGET_MODEL_ELEM_REF = eINSTANCE.getBinaryLinkReference_TargetModelElemRef();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_LINK_REFERENCE___GET_OBJECT = eINSTANCE.getBinaryLinkReference__GetObject();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointReferenceImpl <em>Model Element Endpoint Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelElementEndpointReference()
		 * @generated
		 */
		EClass MODEL_ELEMENT_ENDPOINT_REFERENCE = eINSTANCE.getModelElementEndpointReference();

		/**
		 * The meta object literal for the '<em><b>Model Elem Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF = eINSTANCE.getModelElementEndpointReference_ModelElemRef();

		/**
		 * The meta object literal for the '<em><b>Get Object</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT = eINSTANCE.getModelElementEndpointReference__GetObject();

		/**
		 * The meta object literal for the '<em><b>Get Supertype Ref</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF = eINSTANCE.getModelElementEndpointReference__GetSupertypeRef();

	}

} //RelationshipPackage
