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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmtf.mid.MidFactory
 * @model kind="package"
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
	String eNS_URI = "http:///edu/toronto/cs/se/mmtf/mid/model/mid.ecore";

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
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl <em>Multi Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMultiModel()
	 * @generated
	 */
	int MULTI_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Multi Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelReference()
	 * @generated
	 */
	int MODEL_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__URI = 1;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__ROOT = 2;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE__ORIGIN = 3;

	/**
	 * The number of structural features of the '<em>Model Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REFERENCE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.MappingReferenceImpl <em>Mapping Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MappingReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMappingReference()
	 * @generated
	 */
	int MAPPING_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__NAME = MODEL_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__URI = MODEL_REFERENCE__URI;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__ROOT = MODEL_REFERENCE__ROOT;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__ORIGIN = MODEL_REFERENCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE__MODELS = MODEL_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REFERENCE_FEATURE_COUNT = MODEL_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.impl.BinaryMappingReferenceImpl <em>Binary Mapping Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.impl.BinaryMappingReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getBinaryMappingReference()
	 * @generated
	 */
	int BINARY_MAPPING_REFERENCE = 3;

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
	 * The number of structural features of the '<em>Binary Mapping Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MAPPING_REFERENCE_FEATURE_COUNT = MAPPING_REFERENCE_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin <em>Model Reference Origin</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin
	 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelReferenceOrigin()
	 * @generated
	 */
	int MODEL_REFERENCE_ORIGIN = 4;


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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MultiModel#getElements()
	 * @see #getMultiModel()
	 * @generated
	 */
	EReference getMultiModel_Elements();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.ModelReference <em>Model Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReference
	 * @generated
	 */
	EClass getModelReference();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReference#getName()
	 * @see #getModelReference()
	 * @generated
	 */
	EAttribute getModelReference_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReference#getUri()
	 * @see #getModelReference()
	 * @generated
	 */
	EAttribute getModelReference_Uri();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReference#getRoot()
	 * @see #getModelReference()
	 * @generated
	 */
	EReference getModelReference_Root();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mid.ModelReference#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReference#getOrigin()
	 * @see #getModelReference()
	 * @generated
	 */
	EAttribute getModelReference_Origin();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.MappingReference <em>Mapping Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MappingReference
	 * @generated
	 */
	EClass getMappingReference();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.mid.MappingReference#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Models</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.MappingReference#getModels()
	 * @see #getMappingReference()
	 * @generated
	 */
	EReference getMappingReference_Models();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mid.BinaryMappingReference <em>Binary Mapping Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Mapping Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.BinaryMappingReference
	 * @generated
	 */
	EClass getBinaryMappingReference();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin <em>Model Reference Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Reference Origin</em>'.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin
	 * @generated
	 */
	EEnum getModelReferenceOrigin();

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
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
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
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_MODEL__ELEMENTS = eINSTANCE.getMultiModel_Elements();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.ModelReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelReference()
		 * @generated
		 */
		EClass MODEL_REFERENCE = eINSTANCE.getModelReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REFERENCE__NAME = eINSTANCE.getModelReference_Name();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REFERENCE__URI = eINSTANCE.getModelReference_Uri();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REFERENCE__ROOT = eINSTANCE.getModelReference_Root();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REFERENCE__ORIGIN = eINSTANCE.getModelReference_Origin();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.MappingReferenceImpl <em>Mapping Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MappingReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getMappingReference()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.impl.BinaryMappingReferenceImpl <em>Binary Mapping Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.impl.BinaryMappingReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getBinaryMappingReference()
		 * @generated
		 */
		EClass BINARY_MAPPING_REFERENCE = eINSTANCE.getBinaryMappingReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin <em>Model Reference Origin</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin
		 * @see edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl#getModelReferenceOrigin()
		 * @generated
		 */
		EEnum MODEL_REFERENCE_ORIGIN = eINSTANCE.getModelReferenceOrigin();

	}

} //MidPackage
