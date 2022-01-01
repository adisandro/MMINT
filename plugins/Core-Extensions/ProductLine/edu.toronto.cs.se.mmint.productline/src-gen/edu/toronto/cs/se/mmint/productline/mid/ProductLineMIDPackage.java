/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.productline.mid;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDFactory
 * @model kind="package"
 * @generated
 */
public interface ProductLineMIDPackage extends EPackage {
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
  String eNS_URI = "rel://edu.toronto.cs.se.mmint.productline.mid.PLModelRel";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "productline.mid";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ProductLineMIDPackage eINSTANCE = edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLModelRelImpl <em>PL Model Rel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLModelRelImpl
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLModelRel()
   * @generated
   */
  int PL_MODEL_REL = 0;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__SUPERTYPE = RelationshipPackage.MODEL_REL__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__URI = RelationshipPackage.MODEL_REL__URI;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__NAME = RelationshipPackage.MODEL_REL__NAME;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__LEVEL = RelationshipPackage.MODEL_REL__LEVEL;

  /**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__METATYPE_URI = RelationshipPackage.MODEL_REL__METATYPE_URI;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__DYNAMIC = RelationshipPackage.MODEL_REL__DYNAMIC;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__CONSTRAINT = RelationshipPackage.MODEL_REL__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__ABSTRACT = RelationshipPackage.MODEL_REL__ABSTRACT;

  /**
   * The feature id for the '<em><b>Origin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__ORIGIN = RelationshipPackage.MODEL_REL__ORIGIN;

  /**
   * The feature id for the '<em><b>File Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__FILE_EXTENSION = RelationshipPackage.MODEL_REL__FILE_EXTENSION;

  /**
   * The feature id for the '<em><b>Editors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__EDITORS = RelationshipPackage.MODEL_REL__EDITORS;

  /**
   * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MODEL_ELEMS = RelationshipPackage.MODEL_REL__MODEL_ELEMS;

  /**
   * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__CONVERSION_OPERATORS = RelationshipPackage.MODEL_REL__CONVERSION_OPERATORS;

  /**
   * The feature id for the '<em><b>EMF Instance Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__EMF_INSTANCE_RESOURCE = RelationshipPackage.MODEL_REL__EMF_INSTANCE_RESOURCE;

  /**
   * The feature id for the '<em><b>EMF Instance Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__EMF_INSTANCE_ROOT = RelationshipPackage.MODEL_REL__EMF_INSTANCE_ROOT;

  /**
   * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MODEL_ENDPOINTS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MAPPINGS = RelationshipPackage.MODEL_REL__MAPPINGS;

  /**
   * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MODEL_ENDPOINT_REFS = RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL__MAPPING_REFS = RelationshipPackage.MODEL_REL__MAPPING_REFS;

  /**
   * The number of structural features of the '<em>PL Model Rel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MODEL_REL_FEATURE_COUNT = RelationshipPackage.MODEL_REL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryModelRelImpl <em>PL Binary Model Rel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryModelRelImpl
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLBinaryModelRel()
   * @generated
   */
  int PL_BINARY_MODEL_REL = 1;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__SUPERTYPE = RelationshipPackage.BINARY_MODEL_REL__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__URI = RelationshipPackage.BINARY_MODEL_REL__URI;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__NAME = RelationshipPackage.BINARY_MODEL_REL__NAME;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__LEVEL = RelationshipPackage.BINARY_MODEL_REL__LEVEL;

  /**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__METATYPE_URI = RelationshipPackage.BINARY_MODEL_REL__METATYPE_URI;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__DYNAMIC = RelationshipPackage.BINARY_MODEL_REL__DYNAMIC;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__CONSTRAINT = RelationshipPackage.BINARY_MODEL_REL__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__ABSTRACT = RelationshipPackage.BINARY_MODEL_REL__ABSTRACT;

  /**
   * The feature id for the '<em><b>Origin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__ORIGIN = RelationshipPackage.BINARY_MODEL_REL__ORIGIN;

  /**
   * The feature id for the '<em><b>File Extension</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__FILE_EXTENSION = RelationshipPackage.BINARY_MODEL_REL__FILE_EXTENSION;

  /**
   * The feature id for the '<em><b>Editors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__EDITORS = RelationshipPackage.BINARY_MODEL_REL__EDITORS;

  /**
   * The feature id for the '<em><b>Model Elems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MODEL_ELEMS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ELEMS;

  /**
   * The feature id for the '<em><b>Conversion Operators</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__CONVERSION_OPERATORS = RelationshipPackage.BINARY_MODEL_REL__CONVERSION_OPERATORS;

  /**
   * The feature id for the '<em><b>EMF Instance Resource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__EMF_INSTANCE_RESOURCE = RelationshipPackage.BINARY_MODEL_REL__EMF_INSTANCE_RESOURCE;

  /**
   * The feature id for the '<em><b>EMF Instance Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__EMF_INSTANCE_ROOT = RelationshipPackage.BINARY_MODEL_REL__EMF_INSTANCE_ROOT;

  /**
   * The feature id for the '<em><b>Model Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MODEL_ENDPOINTS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ENDPOINTS;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MAPPINGS = RelationshipPackage.BINARY_MODEL_REL__MAPPINGS;

  /**
   * The feature id for the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MODEL_ENDPOINT_REFS = RelationshipPackage.BINARY_MODEL_REL__MODEL_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Mapping Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__MAPPING_REFS = RelationshipPackage.BINARY_MODEL_REL__MAPPING_REFS;

  /**
   * The feature id for the '<em><b>Source Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__SOURCE_MODEL = RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL;

  /**
   * The feature id for the '<em><b>Target Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL__TARGET_MODEL = RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL;

  /**
   * The number of structural features of the '<em>PL Binary Model Rel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MODEL_REL_FEATURE_COUNT = RelationshipPackage.BINARY_MODEL_REL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLMappingImpl <em>PL Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLMappingImpl
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLMapping()
   * @generated
   */
  int PL_MAPPING = 2;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__SUPERTYPE = RelationshipPackage.MAPPING__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__URI = RelationshipPackage.MAPPING__URI;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__NAME = RelationshipPackage.MAPPING__NAME;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__LEVEL = RelationshipPackage.MAPPING__LEVEL;

  /**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__METATYPE_URI = RelationshipPackage.MAPPING__METATYPE_URI;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__DYNAMIC = RelationshipPackage.MAPPING__DYNAMIC;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__CONSTRAINT = RelationshipPackage.MAPPING__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__MODEL_ELEM_ENDPOINTS = RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS;

  /**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING__PRESENCE_CONDITION = RelationshipPackage.MAPPING_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PL Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_FEATURE_COUNT = RelationshipPackage.MAPPING_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingImpl <em>PL Binary Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingImpl
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLBinaryMapping()
   * @generated
   */
  int PL_BINARY_MAPPING = 3;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__SUPERTYPE = RelationshipPackage.BINARY_MAPPING__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__URI = RelationshipPackage.BINARY_MAPPING__URI;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__NAME = RelationshipPackage.BINARY_MAPPING__NAME;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__LEVEL = RelationshipPackage.BINARY_MAPPING__LEVEL;

  /**
   * The feature id for the '<em><b>Metatype Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__METATYPE_URI = RelationshipPackage.BINARY_MAPPING__METATYPE_URI;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__DYNAMIC = RelationshipPackage.BINARY_MAPPING__DYNAMIC;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__CONSTRAINT = RelationshipPackage.BINARY_MAPPING__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__MODEL_ELEM_ENDPOINTS = RelationshipPackage.BINARY_MAPPING__MODEL_ELEM_ENDPOINTS;

  /**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.BINARY_MAPPING__MODEL_ELEM_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING__PRESENCE_CONDITION = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PL Binary Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_FEATURE_COUNT = RelationshipPackage.BINARY_MAPPING_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLMappingReferenceImpl <em>PL Mapping Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLMappingReferenceImpl
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLMappingReference()
   * @generated
   */
  int PL_MAPPING_REFERENCE = 4;

  /**
   * The feature id for the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.MAPPING_REFERENCE__REFERENCED_OBJECT;

  /**
   * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.MAPPING_REFERENCE__CONTAINED_OBJECT;

  /**
   * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__SUPERTYPE_REF = RelationshipPackage.MAPPING_REFERENCE__SUPERTYPE_REF;

  /**
   * The feature id for the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__MODIFIABLE = RelationshipPackage.MAPPING_REFERENCE__MODIFIABLE;

  /**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

  /**
   * The number of structural features of the '<em>PL Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_MAPPING_REFERENCE_FEATURE_COUNT = RelationshipPackage.MAPPING_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingReferenceImpl <em>PL Binary Mapping Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingReferenceImpl
   * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLBinaryMappingReference()
   * @generated
   */
  int PL_BINARY_MAPPING_REFERENCE = 5;

  /**
   * The feature id for the '<em><b>Referenced Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__REFERENCED_OBJECT = RelationshipPackage.BINARY_MAPPING_REFERENCE__REFERENCED_OBJECT;

  /**
   * The feature id for the '<em><b>Contained Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__CONTAINED_OBJECT = RelationshipPackage.BINARY_MAPPING_REFERENCE__CONTAINED_OBJECT;

  /**
   * The feature id for the '<em><b>Supertype Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__SUPERTYPE_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__SUPERTYPE_REF;

  /**
   * The feature id for the '<em><b>Modifiable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__MODIFIABLE = RelationshipPackage.BINARY_MAPPING_REFERENCE__MODIFIABLE;

  /**
   * The feature id for the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS = RelationshipPackage.BINARY_MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS;

  /**
   * The feature id for the '<em><b>Source Model Elem Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF;

  /**
   * The feature id for the '<em><b>Target Model Elem Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF = RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF;

  /**
   * The number of structural features of the '<em>PL Binary Mapping Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PL_BINARY_MAPPING_REFERENCE_FEATURE_COUNT = RelationshipPackage.BINARY_MAPPING_REFERENCE_FEATURE_COUNT + 0;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.mid.PLModelRel <em>PL Model Rel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Model Rel</em>'.
   * @see edu.toronto.cs.se.mmint.productline.mid.PLModelRel
   * @generated
   */
  EClass getPLModelRel();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.mid.PLBinaryModelRel <em>PL Binary Model Rel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Binary Model Rel</em>'.
   * @see edu.toronto.cs.se.mmint.productline.mid.PLBinaryModelRel
   * @generated
   */
  EClass getPLBinaryModelRel();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.mid.PLMapping <em>PL Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Mapping</em>'.
   * @see edu.toronto.cs.se.mmint.productline.mid.PLMapping
   * @generated
   */
  EClass getPLMapping();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.mid.PLBinaryMapping <em>PL Binary Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Binary Mapping</em>'.
   * @see edu.toronto.cs.se.mmint.productline.mid.PLBinaryMapping
   * @generated
   */
  EClass getPLBinaryMapping();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.mid.PLMappingReference <em>PL Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Mapping Reference</em>'.
   * @see edu.toronto.cs.se.mmint.productline.mid.PLMappingReference
   * @generated
   */
  EClass getPLMappingReference();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.productline.mid.PLBinaryMappingReference <em>PL Binary Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PL Binary Mapping Reference</em>'.
   * @see edu.toronto.cs.se.mmint.productline.mid.PLBinaryMappingReference
   * @generated
   */
  EClass getPLBinaryMappingReference();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ProductLineMIDFactory getProductLineMIDFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLModelRelImpl <em>PL Model Rel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLModelRelImpl
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLModelRel()
     * @generated
     */
    EClass PL_MODEL_REL = ProductLineMIDPackage.eINSTANCE.getPLModelRel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryModelRelImpl <em>PL Binary Model Rel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryModelRelImpl
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLBinaryModelRel()
     * @generated
     */
    EClass PL_BINARY_MODEL_REL = ProductLineMIDPackage.eINSTANCE.getPLBinaryModelRel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLMappingImpl <em>PL Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLMappingImpl
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLMapping()
     * @generated
     */
    EClass PL_MAPPING = ProductLineMIDPackage.eINSTANCE.getPLMapping();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingImpl <em>PL Binary Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingImpl
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLBinaryMapping()
     * @generated
     */
    EClass PL_BINARY_MAPPING = ProductLineMIDPackage.eINSTANCE.getPLBinaryMapping();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLMappingReferenceImpl <em>PL Mapping Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLMappingReferenceImpl
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLMappingReference()
     * @generated
     */
    EClass PL_MAPPING_REFERENCE = ProductLineMIDPackage.eINSTANCE.getPLMappingReference();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingReferenceImpl <em>PL Binary Mapping Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.PLBinaryMappingReferenceImpl
     * @see edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl#getPLBinaryMappingReference()
     * @generated
     */
    EClass PL_BINARY_MAPPING_REFERENCE = ProductLineMIDPackage.eINSTANCE.getPLBinaryMappingReference();

  }

} //ProductLineMIDPackage
