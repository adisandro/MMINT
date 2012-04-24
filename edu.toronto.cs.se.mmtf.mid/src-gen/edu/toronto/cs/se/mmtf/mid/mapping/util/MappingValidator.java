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
package edu.toronto.cs.se.mmtf.mid.mapping.util;

import edu.toronto.cs.se.mmtf.mid.mapping.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage
 * @generated
 */
public class MappingValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MappingValidator INSTANCE = new MappingValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.mmtf.mid.mapping";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MappingPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MappingPackage.MAPPING_REFERENCE:
				return validateMappingReference((MappingReference)value, diagnostics, context);
			case MappingPackage.BINARY_MAPPING_REFERENCE:
				return validateBinaryMappingReference((BinaryMappingReference)value, diagnostics, context);
			case MappingPackage.MODEL_CONTAINER:
				return validateModelContainer((ModelContainer)value, diagnostics, context);
			case MappingPackage.MODEL_ELEMENT_REFERENCE:
				return validateModelElementReference((ModelElementReference)value, diagnostics, context);
			case MappingPackage.MAPPING:
				return validateMapping((Mapping)value, diagnostics, context);
			case MappingPackage.BINARY_MAPPING:
				return validateBinaryMapping((BinaryMapping)value, diagnostics, context);
			case MappingPackage.HOMOMORPHIC_MAPPING_REFERENCE:
				return validateHomomorphicMappingReference((HomomorphicMappingReference)value, diagnostics, context);
			case MappingPackage.HOMOMORPHIC_MAPPING:
				return validateHomomorphicMapping((HomomorphicMapping)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingReference(MappingReference mappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingReference_modelContainers(mappingReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the modelContainers constraint of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MAPPING_REFERENCE__MODEL_CONTAINERS__EEXPRESSION = "models->size() = containers->size()";

	/**
	 * Validates the modelContainers constraint of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingReference_modelContainers(MappingReference mappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.MAPPING_REFERENCE,
				 mappingReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "modelContainers",
				 MAPPING_REFERENCE__MODEL_CONTAINERS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryMappingReference(BinaryMappingReference binaryMappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(binaryMappingReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingReference_modelContainers(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryMappingReference_isBinaryReference(binaryMappingReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinaryReference constraint of '<em>Binary Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_MAPPING_REFERENCE__IS_BINARY_REFERENCE__EEXPRESSION = "models->size() = 2";

	/**
	 * Validates the isBinaryReference constraint of '<em>Binary Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryMappingReference_isBinaryReference(BinaryMappingReference binaryMappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.BINARY_MAPPING_REFERENCE,
				 binaryMappingReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "isBinaryReference",
				 BINARY_MAPPING_REFERENCE__IS_BINARY_REFERENCE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelContainer(ModelContainer modelContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelContainer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelContainer_oneModel(modelContainer, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the oneModel constraint of '<em>Model Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL_CONTAINER__ONE_MODEL__EEXPRESSION = "referencedModel.oclIsUndefined() xor containedModel.oclIsUndefined()";

	/**
	 * Validates the oneModel constraint of '<em>Model Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelContainer_oneModel(ModelContainer modelContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.MODEL_CONTAINER,
				 modelContainer,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "oneModel",
				 MODEL_CONTAINER__ONE_MODEL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementReference(ModelElementReference modelElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelElementReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mapping, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryMapping(BinaryMapping binaryMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(binaryMapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(binaryMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binaryMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binaryMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binaryMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(binaryMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(binaryMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(binaryMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binaryMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryMapping_isBinaryMapping(binaryMapping, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinaryMapping constraint of '<em>Binary Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_MAPPING__IS_BINARY_MAPPING__EEXPRESSION = "elements->size() = 2";

	/**
	 * Validates the isBinaryMapping constraint of '<em>Binary Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryMapping_isBinaryMapping(BinaryMapping binaryMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.BINARY_MAPPING,
				 binaryMapping,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "isBinaryMapping",
				 BINARY_MAPPING__IS_BINARY_MAPPING__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphicMappingReference(HomomorphicMappingReference homomorphicMappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(homomorphicMappingReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingReference_modelContainers(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryMappingReference_isBinaryReference(homomorphicMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateHomomorphicMappingReference_sameModelTypes(homomorphicMappingReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the sameModelTypes constraint of '<em>Homomorphic Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String HOMOMORPHIC_MAPPING_REFERENCE__SAME_MODEL_TYPES__EEXPRESSION = "models->forAll(m1 : ModelReference, m2 : ModelReference | m1.root.oclType() = m2.root.oclType())";

	/**
	 * Validates the sameModelTypes constraint of '<em>Homomorphic Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphicMappingReference_sameModelTypes(HomomorphicMappingReference homomorphicMappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.HOMOMORPHIC_MAPPING_REFERENCE,
				 homomorphicMappingReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "sameModelTypes",
				 HOMOMORPHIC_MAPPING_REFERENCE__SAME_MODEL_TYPES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphicMapping(HomomorphicMapping homomorphicMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(homomorphicMapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryMapping_isBinaryMapping(homomorphicMapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateHomomorphicMapping_sameElementTypes(homomorphicMapping, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the sameElementTypes constraint of '<em>Homomorphic Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String HOMOMORPHIC_MAPPING__SAME_ELEMENT_TYPES__EEXPRESSION = "elements->forAll(e1 : ModelElementReference, e2 : ModelElementReference | e1.pointer.oclType() = e2.pointer.oclType())";

	/**
	 * Validates the sameElementTypes constraint of '<em>Homomorphic Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphicMapping_sameElementTypes(HomomorphicMapping homomorphicMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.HOMOMORPHIC_MAPPING,
				 homomorphicMapping,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "sameElementTypes",
				 HOMOMORPHIC_MAPPING__SAME_ELEMENT_TYPES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MappingValidator
