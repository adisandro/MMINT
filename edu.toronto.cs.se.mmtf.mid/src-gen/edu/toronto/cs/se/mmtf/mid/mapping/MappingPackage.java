/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping;

import edu.toronto.cs.se.mmtf.mid.MidPackage;

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
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface MappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///edu/toronto/cs/se/mmtf/mid/model/mid.ecore/mapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingPackage eINSTANCE = edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getMappingReference()
	 * @generated
	 */
	int MAPPING_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__NAME = MidPackage.MODEL_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__TYPE = MidPackage.MODEL_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__URI = MidPackage.MODEL_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__ROOT = MidPackage.MODEL_REFERENCE__ROOT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__ORIGIN = MidPackage.MODEL_REFERENCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__MODELS = MidPackage.MODEL_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__MAPPING_LINKS = MidPackage.MODEL_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__CONTAINERS = MidPackage.MODEL_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE_FEATURE_COUNT = MidPackage.MODEL_REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE_OPERATION_COUNT = MidPackage.MODEL_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingReferenceImpl <em>Binary Mapping Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getBinaryMappingReference()
	 * @generated
	 */
	int BINARY_MAPPING_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__NAME = MAPPING_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__TYPE = MAPPING_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__URI = MAPPING_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__ROOT = MAPPING_REFERENCE__ROOT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__ORIGIN = MAPPING_REFERENCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__MODELS = MAPPING_REFERENCE__MODELS;

	/**
	 * The feature id for the '<em><b>Mapping Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__MAPPING_LINKS = MAPPING_REFERENCE__MAPPING_LINKS;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__CONTAINERS = MAPPING_REFERENCE__CONTAINERS;

	/**
	 * The number of structural features of the '<em>Binary Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE_FEATURE_COUNT = MAPPING_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE_OPERATION_COUNT = MAPPING_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl <em>Model Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getModelContainer()
	 * @generated
	 */
	int MODEL_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__MODEL = 3;

	/**
	 * The feature id for the '<em><b>Referenced Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__REFERENCED_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Contained Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__CONTAINED_MODEL = 5;

	/**
	 * The number of structural features of the '<em>Model Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Model Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelElementReferenceImpl <em>Model Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelElementReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getModelElementReference()
	 * @generated
	 */
	int MODEL_ELEMENT_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__NAME = MidPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__TYPE = MidPackage.NAMED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Pointer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__POINTER = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__MAPPING_LINKS = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__CATEGORY = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_FEATURE_COUNT = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_OPERATION_COUNT = MidPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingLinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingLinkImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getMappingLink()
	 * @generated
	 */
	int MAPPING_LINK = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LINK__NAME = MidPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LINK__TYPE = MidPackage.NAMED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LINK__ELEMENTS = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LINK_FEATURE_COUNT = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LINK_OPERATION_COUNT = MidPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingLinkImpl <em>Binary Mapping Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingLinkImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getBinaryMappingLink()
	 * @generated
	 */
	int BINARY_MAPPING_LINK = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_LINK__NAME = MAPPING_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_LINK__TYPE = MAPPING_LINK__TYPE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_LINK__ELEMENTS = MAPPING_LINK__ELEMENTS;

	/**
	 * The number of structural features of the '<em>Binary Mapping Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_LINK_FEATURE_COUNT = MAPPING_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Mapping Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_LINK_OPERATION_COUNT = MAPPING_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.HomomorphicMappingReferenceImpl <em>Homomorphic Mapping Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.HomomorphicMappingReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getHomomorphicMappingReference()
	 * @generated
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE__NAME = BINARY_MAPPING_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE__TYPE = BINARY_MAPPING_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE__URI = BINARY_MAPPING_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE__ROOT = BINARY_MAPPING_REFERENCE__ROOT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE__ORIGIN = BINARY_MAPPING_REFERENCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE__MODELS = BINARY_MAPPING_REFERENCE__MODELS;

	/**
	 * The feature id for the '<em><b>Mapping Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE__MAPPING_LINKS = BINARY_MAPPING_REFERENCE__MAPPING_LINKS;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE__CONTAINERS = BINARY_MAPPING_REFERENCE__CONTAINERS;

	/**
	 * The number of structural features of the '<em>Homomorphic Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE_FEATURE_COUNT = BINARY_MAPPING_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Homomorphic Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_REFERENCE_OPERATION_COUNT = BINARY_MAPPING_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.HomomorphicMappingLinkImpl <em>Homomorphic Mapping Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.HomomorphicMappingLinkImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getHomomorphicMappingLink()
	 * @generated
	 */
	int HOMOMORPHIC_MAPPING_LINK = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_LINK__NAME = BINARY_MAPPING_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_LINK__TYPE = BINARY_MAPPING_LINK__TYPE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_LINK__ELEMENTS = BINARY_MAPPING_LINK__ELEMENTS;

	/**
	 * The number of structural features of the '<em>Homomorphic Mapping Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_LINK_FEATURE_COUNT = BINARY_MAPPING_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Homomorphic Mapping Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOMOMORPHIC_MAPPING_LINK_OPERATION_COUNT = BINARY_MAPPING_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory <em>Model Element Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getModelElementCategory()
	 * @generated
	 */
	int MODEL_ELEMENT_CATEGORY = 8;

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingReference
	 * @generated
	 */
	EClass getMappingReference();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Models</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getModels()
	 * @see #getMappingReference()
	 * @generated
	 */
	EReference getMappingReference_Models();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getMappingLinks <em>Mapping Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Links</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getMappingLinks()
	 * @see #getMappingReference()
	 * @generated
	 */
	EReference getMappingReference_MappingLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containers</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getContainers()
	 * @see #getMappingReference()
	 * @generated
	 */
	EReference getMappingReference_Containers();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference <em>Binary Mapping Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Mapping Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference
	 * @generated
	 */
	EClass getBinaryMappingReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer <em>Model Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Container</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer
	 * @generated
	 */
	EClass getModelContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getElements()
	 * @see #getModelContainer()
	 * @generated
	 */
	EReference getModelContainer_Elements();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getName()
	 * @see #getModelContainer()
	 * @generated
	 */
	EAttribute getModelContainer_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getType()
	 * @see #getModelContainer()
	 * @generated
	 */
	EAttribute getModelContainer_Type();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getModel()
	 * @see #getModelContainer()
	 * @generated
	 */
	EReference getModelContainer_Model();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getReferencedModel <em>Referenced Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getReferencedModel()
	 * @see #getModelContainer()
	 * @generated
	 */
	EReference getModelContainer_ReferencedModel();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getContainedModel <em>Contained Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer#getContainedModel()
	 * @see #getModelContainer()
	 * @generated
	 */
	EReference getModelContainer_ContainedModel();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference <em>Model Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference
	 * @generated
	 */
	EClass getModelElementReference();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getPointer <em>Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pointer</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getPointer()
	 * @see #getModelElementReference()
	 * @generated
	 */
	EReference getModelElementReference_Pointer();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getMappingLinks <em>Mapping Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mapping Links</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getMappingLinks()
	 * @see #getModelElementReference()
	 * @generated
	 */
	EReference getModelElementReference_MappingLinks();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getCategory()
	 * @see #getModelElementReference()
	 * @generated
	 */
	EAttribute getModelElementReference_Category();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingLink
	 * @generated
	 */
	EClass getMappingLink();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingLink#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingLink#getElements()
	 * @see #getMappingLink()
	 * @generated
	 */
	EReference getMappingLink_Elements();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingLink <em>Binary Mapping Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Mapping Link</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingLink
	 * @generated
	 */
	EClass getBinaryMappingLink();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.HomomorphicMappingReference <em>Homomorphic Mapping Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Homomorphic Mapping Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.HomomorphicMappingReference
	 * @generated
	 */
	EClass getHomomorphicMappingReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.HomomorphicMappingLink <em>Homomorphic Mapping Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Homomorphic Mapping Link</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.HomomorphicMappingLink
	 * @generated
	 */
	EClass getHomomorphicMappingLink();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory <em>Model Element Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Element Category</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory
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
	MappingFactory getMappingFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getMappingReference()
		 * @generated
		 */
		EClass MAPPING_REFERENCE = eINSTANCE.getMappingReference();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REFERENCE__MODELS = eINSTANCE.getMappingReference_Models();

		/**
		 * The meta object literal for the '<em><b>Mapping Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REFERENCE__MAPPING_LINKS = eINSTANCE.getMappingReference_MappingLinks();

		/**
		 * The meta object literal for the '<em><b>Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REFERENCE__CONTAINERS = eINSTANCE.getMappingReference_Containers();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingReferenceImpl <em>Binary Mapping Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getBinaryMappingReference()
		 * @generated
		 */
		EClass BINARY_MAPPING_REFERENCE = eINSTANCE.getBinaryMappingReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl <em>Model Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelContainerImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getModelContainer()
		 * @generated
		 */
		EClass MODEL_CONTAINER = eINSTANCE.getModelContainer();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONTAINER__ELEMENTS = eINSTANCE.getModelContainer_Elements();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CONTAINER__NAME = eINSTANCE.getModelContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CONTAINER__TYPE = eINSTANCE.getModelContainer_Type();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONTAINER__MODEL = eINSTANCE.getModelContainer_Model();

		/**
		 * The meta object literal for the '<em><b>Referenced Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONTAINER__REFERENCED_MODEL = eINSTANCE.getModelContainer_ReferencedModel();

		/**
		 * The meta object literal for the '<em><b>Contained Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONTAINER__CONTAINED_MODEL = eINSTANCE.getModelContainer_ContainedModel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelElementReferenceImpl <em>Model Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.ModelElementReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getModelElementReference()
		 * @generated
		 */
		EClass MODEL_ELEMENT_REFERENCE = eINSTANCE.getModelElementReference();

		/**
		 * The meta object literal for the '<em><b>Pointer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REFERENCE__POINTER = eINSTANCE.getModelElementReference_Pointer();

		/**
		 * The meta object literal for the '<em><b>Mapping Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REFERENCE__MAPPING_LINKS = eINSTANCE.getModelElementReference_MappingLinks();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_REFERENCE__CATEGORY = eINSTANCE.getModelElementReference_Category();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingLinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingLinkImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getMappingLink()
		 * @generated
		 */
		EClass MAPPING_LINK = eINSTANCE.getMappingLink();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LINK__ELEMENTS = eINSTANCE.getMappingLink_Elements();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingLinkImpl <em>Binary Mapping Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.BinaryMappingLinkImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getBinaryMappingLink()
		 * @generated
		 */
		EClass BINARY_MAPPING_LINK = eINSTANCE.getBinaryMappingLink();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.HomomorphicMappingReferenceImpl <em>Homomorphic Mapping Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.HomomorphicMappingReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getHomomorphicMappingReference()
		 * @generated
		 */
		EClass HOMOMORPHIC_MAPPING_REFERENCE = eINSTANCE.getHomomorphicMappingReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.HomomorphicMappingLinkImpl <em>Homomorphic Mapping Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.HomomorphicMappingLinkImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getHomomorphicMappingLink()
		 * @generated
		 */
		EClass HOMOMORPHIC_MAPPING_LINK = eINSTANCE.getHomomorphicMappingLink();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory <em>Model Element Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getModelElementCategory()
		 * @generated
		 */
		EEnum MODEL_ELEMENT_CATEGORY = eINSTANCE.getModelElementCategory();

	}

} //MappingPackage
