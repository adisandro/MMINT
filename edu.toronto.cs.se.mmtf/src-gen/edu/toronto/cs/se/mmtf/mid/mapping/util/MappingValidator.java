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
package edu.toronto.cs.se.mmtf.mid.mapping.util;

import edu.toronto.cs.se.mmtf.mid.mapping.*;

import edu.toronto.cs.se.mmtf.mid.util.MidValidator;

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MidValidator midValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingValidator() {
		super();
		midValidator = MidValidator.INSTANCE;
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
			case MappingPackage.MODEL_REL:
				return validateModelRel((ModelRel)value, diagnostics, context);
			case MappingPackage.BINARY_MODEL_REL:
				return validateBinaryModelRel((BinaryModelRel)value, diagnostics, context);
			case MappingPackage.HOMOMORPHISM_MODEL_REL:
				return validateHomomorphismModelRel((HomomorphismModelRel)value, diagnostics, context);
			case MappingPackage.MODEL_CONTAINER:
				return validateModelContainer((ModelContainer)value, diagnostics, context);
			case MappingPackage.MODEL_ELEMENT:
				return validateModelElement((ModelElement)value, diagnostics, context);
			case MappingPackage.LINK:
				return validateLink((Link)value, diagnostics, context);
			case MappingPackage.BINARY_LINK:
				return validateBinaryLink((BinaryLink)value, diagnostics, context);
			case MappingPackage.HOMOMORPHISM_LINK:
				return validateHomomorphismLink((HomomorphismLink)value, diagnostics, context);
			case MappingPackage.MODEL_ELEMENT_CATEGORY:
				return validateModelElementCategory((ModelElementCategory)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelRel(ModelRel modelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelRel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_supertypeType(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_modelContainers(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_unboundedLevel(modelRel, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the modelContainers constraint of '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL_REL__MODEL_CONTAINERS__EEXPRESSION = "models->size() = containers->size()";

	/**
	 * Validates the modelContainers constraint of '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelRel_modelContainers(ModelRel modelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.MODEL_REL,
				 modelRel,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "modelContainers",
				 MODEL_REL__MODEL_CONTAINERS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the unboundedLevel constraint of '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL_REL__UNBOUNDED_LEVEL__EEXPRESSION = "unbounded = true implies level = MidLevel::TYPES";

	/**
	 * Validates the unboundedLevel constraint of '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelRel_unboundedLevel(ModelRel modelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.MODEL_REL,
				 modelRel,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "unboundedLevel",
				 MODEL_REL__UNBOUNDED_LEVEL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryModelRel(BinaryModelRel binaryModelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(binaryModelRel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_supertypeType(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_modelContainers(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_unboundedLevel(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryModelRel_isBinaryRel(binaryModelRel, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinaryRel constraint of '<em>Binary Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_MODEL_REL__IS_BINARY_REL__EEXPRESSION = "models->size() = 2";

	/**
	 * Validates the isBinaryRel constraint of '<em>Binary Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryModelRel_isBinaryRel(BinaryModelRel binaryModelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.BINARY_MODEL_REL,
				 binaryModelRel,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "isBinaryRel",
				 BINARY_MODEL_REL__IS_BINARY_REL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphismModelRel(HomomorphismModelRel homomorphismModelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(homomorphismModelRel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_supertypeType(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_modelContainers(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_unboundedLevel(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryModelRel_isBinaryRel(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateHomomorphismModelRel_sameModelTypes(homomorphismModelRel, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the sameModelTypes constraint of '<em>Homomorphism Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String HOMOMORPHISM_MODEL_REL__SAME_MODEL_TYPES__EEXPRESSION = "models->forAll(m1 : Model, m2 : Model | m1.root.oclType() = m2.root.oclType())";

	/**
	 * Validates the sameModelTypes constraint of '<em>Homomorphism Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphismModelRel_sameModelTypes(HomomorphismModelRel homomorphismModelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.HOMOMORPHISM_MODEL_REL,
				 homomorphismModelRel,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "sameModelTypes",
				 HOMOMORPHISM_MODEL_REL__SAME_MODEL_TYPES__EEXPRESSION,
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
	public boolean validateModelElement(ModelElement modelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_supertypeType(modelElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLink(Link link, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(link, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(link, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(link, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(link, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(link, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(link, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(link, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(link, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(link, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(link, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_supertypeType(link, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryLink(BinaryLink binaryLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(binaryLink, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_supertypeType(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryLink_isBinaryLink(binaryLink, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinaryLink constraint of '<em>Binary Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_LINK__IS_BINARY_LINK__EEXPRESSION = "elements->size() = 2";

	/**
	 * Validates the isBinaryLink constraint of '<em>Binary Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryLink_isBinaryLink(BinaryLink binaryLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.BINARY_LINK,
				 binaryLink,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "isBinaryLink",
				 BINARY_LINK__IS_BINARY_LINK__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphismLink(HomomorphismLink homomorphismLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(homomorphismLink, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_supertypeType(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryLink_isBinaryLink(homomorphismLink, diagnostics, context);
		if (result || diagnostics != null) result &= validateHomomorphismLink_sameElementTypes(homomorphismLink, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the sameElementTypes constraint of '<em>Homomorphism Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String HOMOMORPHISM_LINK__SAME_ELEMENT_TYPES__EEXPRESSION = "invalid->forAll(e1 : ModelElement, e2 : ModelElement | e1.pointer.oclType() = e2.pointer.oclType())";

	/**
	 * Validates the sameElementTypes constraint of '<em>Homomorphism Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphismLink_sameElementTypes(HomomorphismLink homomorphismLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MappingPackage.Literals.HOMOMORPHISM_LINK,
				 homomorphismLink,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "sameElementTypes",
				 HOMOMORPHISM_LINK__SAME_ELEMENT_TYPES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementCategory(ModelElementCategory modelElementCategory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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
