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
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__MAPPINGS = MidPackage.MODEL_REFERENCE_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__MAPPINGS = MAPPING_REFERENCE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__CONTAINERS = MAPPING_REFERENCE__CONTAINERS;

	/**
	 * The feature id for the '<em><b>Model0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__MODEL0 = MAPPING_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE__MODEL1 = MAPPING_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE_FEATURE_COUNT = MAPPING_REFERENCE_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__MODEL = 2;

	/**
	 * The number of structural features of the '<em>Model Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER_FEATURE_COUNT = 3;

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
	 * The feature id for the '<em><b>Pointer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__POINTER = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE__MAPPINGS = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_FEATURE_COUNT = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Model Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_REFERENCE_OPERATION_COUNT = MidPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingImpl
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = MidPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ELEMENTS = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = MidPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = MidPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getMappings()
	 * @see #getMappingReference()
	 * @generated
	 */
	EReference getMappingReference_Mappings();

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
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference#getModel0 <em>Model0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model0</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference#getModel0()
	 * @see #getBinaryMappingReference()
	 * @generated
	 */
	EReference getBinaryMappingReference_Model0();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference#getModel1 <em>Model1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model1</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference#getModel1()
	 * @see #getBinaryMappingReference()
	 * @generated
	 */
	EReference getBinaryMappingReference_Model1();

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
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mappings</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getMappings()
	 * @see #getModelElementReference()
	 * @generated
	 */
	EReference getModelElementReference_Mappings();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.mapping.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.mapping.Mapping#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.Mapping#getElements()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Elements();

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
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REFERENCE__MAPPINGS = eINSTANCE.getMappingReference_Mappings();

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
		 * The meta object literal for the '<em><b>Model0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MAPPING_REFERENCE__MODEL0 = eINSTANCE.getBinaryMappingReference_Model0();

		/**
		 * The meta object literal for the '<em><b>Model1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MAPPING_REFERENCE__MODEL1 = eINSTANCE.getBinaryMappingReference_Model1();

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
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONTAINER__MODEL = eINSTANCE.getModelContainer_Model();

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
		 * The meta object literal for the '<em><b>Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_REFERENCE__MAPPINGS = eINSTANCE.getModelElementReference_Mappings();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingImpl
		 * @see edu.toronto.cs.se.mmtf.mid.mapping.impl.MappingPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__ELEMENTS = eINSTANCE.getMapping_Elements();

	}

} //MappingPackage
