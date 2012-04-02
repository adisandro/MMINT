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
		if (result || diagnostics != null) result &= validateBinaryMappingReference_isBinary(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryMappingReference_sourceModel(binaryMappingReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryMappingReference_targetModel(binaryMappingReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinary constraint of '<em>Binary Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_MAPPING_REFERENCE__IS_BINARY__EEXPRESSION = "models->size() = 2";

	/**
	 * Validates the isBinary constraint of '<em>Binary Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryMappingReference_isBinary(BinaryMappingReference binaryMappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.BINARY_MAPPING_REFERENCE,
				 binaryMappingReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "isBinary",
				 BINARY_MAPPING_REFERENCE__IS_BINARY__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the sourceModel constraint of '<em>Binary Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_MAPPING_REFERENCE__SOURCE_MODEL__EEXPRESSION = "model0 = models->at(0)";

	/**
	 * Validates the sourceModel constraint of '<em>Binary Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryMappingReference_sourceModel(BinaryMappingReference binaryMappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.BINARY_MAPPING_REFERENCE,
				 binaryMappingReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "sourceModel",
				 BINARY_MAPPING_REFERENCE__SOURCE_MODEL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the targetModel constraint of '<em>Binary Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_MAPPING_REFERENCE__TARGET_MODEL__EEXPRESSION = "model1 = models->at(1)";

	/**
	 * Validates the targetModel constraint of '<em>Binary Mapping Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryMappingReference_targetModel(BinaryMappingReference binaryMappingReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.BINARY_MAPPING_REFERENCE,
				 binaryMappingReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "targetModel",
				 BINARY_MAPPING_REFERENCE__TARGET_MODEL__EEXPRESSION,
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
		return validate_EveryDefaultConstraint(modelContainer, diagnostics, context);
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
