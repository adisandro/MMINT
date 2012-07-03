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
package edu.toronto.cs.se.mmtf.mid.relationship;

import edu.toronto.cs.se.mmtf.mid.MidPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	String eNS_URI = "http:///edu/toronto/cs/se/mmtf/model/mid.ecore/relationship";

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
	int MODEL_REL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__NAME = MidPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__METATYPE = MidPackage.MODEL__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__LEVEL = MidPackage.MODEL__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__TYPE = MidPackage.MODEL__TYPE;

	/**
	 * The feature id for the '<em><b>Runtime Metatypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__RUNTIME_METATYPES = MidPackage.MODEL__RUNTIME_METATYPES;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__METATYPE_URI = MidPackage.MODEL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__URI = MidPackage.MODEL__URI;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__SUPERTYPE = MidPackage.MODEL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__ROOT = MidPackage.MODEL__ROOT;

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
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__ELEMENTS = MidPackage.MODEL__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__CONSTRAINT = MidPackage.MODEL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__CONVERSION_OPERATORS = MidPackage.MODEL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MODELS = MidPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__LINKS = MidPackage.MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__MODEL_REFS = MidPackage.MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL__UNBOUNDED = MidPackage.MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL_FEATURE_COUNT = MidPackage.MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REL_OPERATION_COUNT = MidPackage.MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryModelRelImpl <em>Binary Model Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryModelRelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getBinaryModelRel()
	 * @generated
	 */
	int BINARY_MODEL_REL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__NAME = MODEL_REL__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__METATYPE = MODEL_REL__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__LEVEL = MODEL_REL__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__TYPE = MODEL_REL__TYPE;

	/**
	 * The feature id for the '<em><b>Runtime Metatypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__RUNTIME_METATYPES = MODEL_REL__RUNTIME_METATYPES;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__METATYPE_URI = MODEL_REL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__URI = MODEL_REL__URI;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__SUPERTYPE = MODEL_REL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__ROOT = MODEL_REL__ROOT;

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
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__ELEMENTS = MODEL_REL__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__CONSTRAINT = MODEL_REL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__CONVERSION_OPERATORS = MODEL_REL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MODELS = MODEL_REL__MODELS;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__LINKS = MODEL_REL__LINKS;

	/**
	 * The feature id for the '<em><b>Model Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__MODEL_REFS = MODEL_REL__MODEL_REFS;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL__UNBOUNDED = MODEL_REL__UNBOUNDED;

	/**
	 * The number of structural features of the '<em>Binary Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL_FEATURE_COUNT = MODEL_REL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MODEL_REL_OPERATION_COUNT = MODEL_REL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.HomomorphismModelRelImpl <em>Homomorphism Model Rel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.HomomorphismModelRelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getHomomorphismModelRel()
	 * @generated
	 */
	int HOMOMORPHISM_MODEL_REL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__NAME = BINARY_MODEL_REL__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__METATYPE = BINARY_MODEL_REL__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__LEVEL = BINARY_MODEL_REL__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__TYPE = BINARY_MODEL_REL__TYPE;

	/**
	 * The feature id for the '<em><b>Runtime Metatypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__RUNTIME_METATYPES = BINARY_MODEL_REL__RUNTIME_METATYPES;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__METATYPE_URI = BINARY_MODEL_REL__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__URI = BINARY_MODEL_REL__URI;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__SUPERTYPE = BINARY_MODEL_REL__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__ROOT = BINARY_MODEL_REL__ROOT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__ORIGIN = BINARY_MODEL_REL__ORIGIN;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__FILE_EXTENSION = BINARY_MODEL_REL__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__EDITORS = BINARY_MODEL_REL__EDITORS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__ELEMENTS = BINARY_MODEL_REL__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__CONSTRAINT = BINARY_MODEL_REL__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__CONVERSION_OPERATORS = BINARY_MODEL_REL__CONVERSION_OPERATORS;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__MODELS = BINARY_MODEL_REL__MODELS;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__LINKS = BINARY_MODEL_REL__LINKS;

	/**
	 * The feature id for the '<em><b>Model Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__MODEL_REFS = BINARY_MODEL_REL__MODEL_REFS;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL__UNBOUNDED = BINARY_MODEL_REL__UNBOUNDED;

	/**
	 * The number of structural features of the '<em>Homomorphism Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL_FEATURE_COUNT = BINARY_MODEL_REL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Homomorphism Model Rel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_MODEL_REL_OPERATION_COUNT = BINARY_MODEL_REL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl <em>Typed Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getTypedElementReference()
	 * @generated
	 */
	int TYPED_ELEMENT_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_REFERENCE__OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_REFERENCE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_REFERENCE__TYPE = 4;

	/**
	 * The number of structural features of the '<em>Typed Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_REFERENCE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Typed Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelReference()
	 * @generated
	 */
	int MODEL_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__REFERENCED_OBJECT = TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__CONTAINED_OBJECT = TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__OBJECT = TYPED_ELEMENT_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__NAME = TYPED_ELEMENT_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__TYPE = TYPED_ELEMENT_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Element Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__ELEMENT_REFS = TYPED_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE_FEATURE_COUNT = TYPED_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE_OPERATION_COUNT = TYPED_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementReferenceImpl <em>Model Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelElementReference()
	 * @generated
	 */
	int MODEL_ELEMENT_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__REFERENCED_OBJECT = TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT;

	/**
	 * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__CONTAINED_OBJECT = TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__OBJECT = TYPED_ELEMENT_REFERENCE__OBJECT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__NAME = TYPED_ELEMENT_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__TYPE = TYPED_ELEMENT_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__LINKS = TYPED_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_FEATURE_COUNT = TYPED_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_OPERATION_COUNT = TYPED_ELEMENT_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__NAME = MidPackage.EXTENDIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__METATYPE = MidPackage.EXTENDIBLE_ELEMENT__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__LEVEL = MidPackage.EXTENDIBLE_ELEMENT__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TYPE = MidPackage.EXTENDIBLE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Runtime Metatypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__RUNTIME_METATYPES = MidPackage.EXTENDIBLE_ELEMENT__RUNTIME_METATYPES;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__METATYPE_URI = MidPackage.EXTENDIBLE_ELEMENT__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__URI = MidPackage.EXTENDIBLE_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SUPERTYPE = MidPackage.EXTENDIBLE_ELEMENT__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Element Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__ELEMENT_REFS = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__UNBOUNDED = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = MidPackage.EXTENDIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = MidPackage.EXTENDIBLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkImpl <em>Binary Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getBinaryLink()
	 * @generated
	 */
	int BINARY_LINK = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__NAME = LINK__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__METATYPE = LINK__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__LEVEL = LINK__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__TYPE = LINK__TYPE;

	/**
	 * The feature id for the '<em><b>Runtime Metatypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__RUNTIME_METATYPES = LINK__RUNTIME_METATYPES;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__METATYPE_URI = LINK__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__URI = LINK__URI;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__SUPERTYPE = LINK__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Element Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__ELEMENT_REFS = LINK__ELEMENT_REFS;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK__UNBOUNDED = LINK__UNBOUNDED;

	/**
	 * The number of structural features of the '<em>Binary Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_FEATURE_COUNT = LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LINK_OPERATION_COUNT = LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.HomomorphismLinkImpl <em>Homomorphism Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.HomomorphismLinkImpl
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getHomomorphismLink()
	 * @generated
	 */
	int HOMOMORPHISM_LINK = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__NAME = BINARY_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Metatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__METATYPE = BINARY_LINK__METATYPE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__LEVEL = BINARY_LINK__LEVEL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__TYPE = BINARY_LINK__TYPE;

	/**
	 * The feature id for the '<em><b>Runtime Metatypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__RUNTIME_METATYPES = BINARY_LINK__RUNTIME_METATYPES;

	/**
	 * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__METATYPE_URI = BINARY_LINK__METATYPE_URI;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__URI = BINARY_LINK__URI;

	/**
	 * The feature id for the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__SUPERTYPE = BINARY_LINK__SUPERTYPE;

	/**
	 * The feature id for the '<em><b>Element Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__ELEMENT_REFS = BINARY_LINK__ELEMENT_REFS;

	/**
	 * The feature id for the '<em><b>Unbounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK__UNBOUNDED = BINARY_LINK__UNBOUNDED;

	/**
	 * The number of structural features of the '<em>Homomorphism Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK_FEATURE_COUNT = BINARY_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Homomorphism Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHISM_LINK_OPERATION_COUNT = BINARY_LINK_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Models</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModels()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_Models();

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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModelRefs <em>Model Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModelRefs()
	 * @see #getModelRel()
	 * @generated
	 */
	EReference getModelRel_ModelRefs();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#isUnbounded <em>Unbounded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unbounded</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#isUnbounded()
	 * @see #getModelRel()
	 * @generated
	 */
	EAttribute getModelRel_Unbounded();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.HomomorphismModelRel <em>Homomorphism Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Homomorphism Model Rel</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.HomomorphismModelRel
	 * @generated
	 */
	EClass getHomomorphismModelRel();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelReference <em>Model Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelReference
	 * @generated
	 */
	EClass getModelReference();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelReference#getElementRefs <em>Element Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelReference#getElementRefs()
	 * @see #getModelReference()
	 * @generated
	 */
	EReference getModelReference_ElementRefs();

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
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getLinks()
	 * @see #getModelElementReference()
	 * @generated
	 */
	EReference getModelElementReference_Links();

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
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#getElementRefs <em>Element Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Element Refs</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#getElementRefs()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_ElementRefs();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#isUnbounded <em>Unbounded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unbounded</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.Link#isUnbounded()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Unbounded();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.HomomorphismLink <em>Homomorphism Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Homomorphism Link</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.HomomorphismLink
	 * @generated
	 */
	EClass getHomomorphismLink();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference <em>Typed Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference
	 * @generated
	 */
	EClass getTypedElementReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getReferencedObject <em>Referenced Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Object</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getReferencedObject()
	 * @see #getTypedElementReference()
	 * @generated
	 */
	EReference getTypedElementReference_ReferencedObject();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getContainedObject <em>Contained Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Object</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getContainedObject()
	 * @see #getTypedElementReference()
	 * @generated
	 */
	EReference getTypedElementReference_ContainedObject();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getObject()
	 * @see #getTypedElementReference()
	 * @generated
	 */
	EReference getTypedElementReference_Object();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getName()
	 * @see #getTypedElementReference()
	 * @generated
	 */
	EAttribute getTypedElementReference_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.TypedElementReference#getType()
	 * @see #getTypedElementReference()
	 * @generated
	 */
	EAttribute getTypedElementReference_Type();

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
		 * The meta object literal for the '<em><b>Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__MODELS = eINSTANCE.getModelRel_Models();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__LINKS = eINSTANCE.getModelRel_Links();

		/**
		 * The meta object literal for the '<em><b>Model Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REL__MODEL_REFS = eINSTANCE.getModelRel_ModelRefs();

		/**
		 * The meta object literal for the '<em><b>Unbounded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REL__UNBOUNDED = eINSTANCE.getModelRel_Unbounded();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.HomomorphismModelRelImpl <em>Homomorphism Model Rel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.HomomorphismModelRelImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getHomomorphismModelRel()
		 * @generated
		 */
		EClass HOMOMORPHISM_MODEL_REL = eINSTANCE.getHomomorphismModelRel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getModelReference()
		 * @generated
		 */
		EClass MODEL_REFERENCE = eINSTANCE.getModelReference();

		/**
		 * The meta object literal for the '<em><b>Element Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REFERENCE__ELEMENT_REFS = eINSTANCE.getModelReference_ElementRefs();

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
		 * The meta object literal for the '<em><b>Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REFERENCE__LINKS = eINSTANCE.getModelElementReference_Links();

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
		 * The meta object literal for the '<em><b>Element Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__ELEMENT_REFS = eINSTANCE.getLink_ElementRefs();

		/**
		 * The meta object literal for the '<em><b>Unbounded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__UNBOUNDED = eINSTANCE.getLink_Unbounded();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.HomomorphismLinkImpl <em>Homomorphism Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.HomomorphismLinkImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getHomomorphismLink()
		 * @generated
		 */
		EClass HOMOMORPHISM_LINK = eINSTANCE.getHomomorphismLink();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl <em>Typed Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.TypedElementReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl#getTypedElementReference()
		 * @generated
		 */
		EClass TYPED_ELEMENT_REFERENCE = eINSTANCE.getTypedElementReference();

		/**
		 * The meta object literal for the '<em><b>Referenced Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT = eINSTANCE.getTypedElementReference_ReferencedObject();

		/**
		 * The meta object literal for the '<em><b>Contained Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT = eINSTANCE.getTypedElementReference_ContainedObject();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT_REFERENCE__OBJECT = eINSTANCE.getTypedElementReference_Object();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_REFERENCE__NAME = eINSTANCE.getTypedElementReference_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT_REFERENCE__TYPE = eINSTANCE.getTypedElementReference_Type();

	}

} //RelationshipPackage
