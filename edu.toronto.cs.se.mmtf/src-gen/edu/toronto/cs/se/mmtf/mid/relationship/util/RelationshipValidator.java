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
package edu.toronto.cs.se.mmtf.mid.relationship.util;

import edu.toronto.cs.se.mmtf.mid.relationship.*;

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
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage
 * @generated
 */
public class RelationshipValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final RelationshipValidator INSTANCE = new RelationshipValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.mmtf.mid.relationship";

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
	public RelationshipValidator() {
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
	  return RelationshipPackage.eINSTANCE;
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
			case RelationshipPackage.MODEL_REL:
				return validateModelRel((ModelRel)value, diagnostics, context);
			case RelationshipPackage.BINARY_MODEL_REL:
				return validateBinaryModelRel((BinaryModelRel)value, diagnostics, context);
			case RelationshipPackage.HOMOMORPHISM_MODEL_REL:
				return validateHomomorphismModelRel((HomomorphismModelRel)value, diagnostics, context);
			case RelationshipPackage.MODEL_REFERENCE:
				return validateModelReference((ModelReference)value, diagnostics, context);
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE:
				return validateModelElementReference((ModelElementReference)value, diagnostics, context);
			case RelationshipPackage.LINK:
				return validateLink((Link)value, diagnostics, context);
			case RelationshipPackage.BINARY_LINK:
				return validateBinaryLink((BinaryLink)value, diagnostics, context);
			case RelationshipPackage.HOMOMORPHISM_LINK:
				return validateHomomorphismLink((HomomorphismLink)value, diagnostics, context);
			case RelationshipPackage.TYPED_ELEMENT_REFERENCE:
				return validateTypedElementReference((TypedElementReference)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateModelRel_unboundedLevel(modelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_modelRefs(modelRel, diagnostics, context);
		return result;
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
				(RelationshipPackage.Literals.MODEL_REL,
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
	 * The cached validation expression for the modelRefs constraint of '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL_REL__MODEL_REFS__EEXPRESSION = "models->size() = modelRefs->size()";

	/**
	 * Validates the modelRefs constraint of '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelRel_modelRefs(ModelRel modelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.MODEL_REL,
				 modelRel,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "modelRefs",
				 MODEL_REL__MODEL_REFS__EEXPRESSION,
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
		if (result || diagnostics != null) result &= validateModelRel_unboundedLevel(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_modelRefs(binaryModelRel, diagnostics, context);
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
				(RelationshipPackage.Literals.BINARY_MODEL_REL,
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
		if (result || diagnostics != null) result &= validateModelRel_unboundedLevel(homomorphismModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelRel_modelRefs(homomorphismModelRel, diagnostics, context);
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
	protected static final String HOMOMORPHISM_MODEL_REL__SAME_MODEL_TYPES__EEXPRESSION = "models->forAll(m1 : Model, m2 : Model | m1.type = m2.type)";

	/**
	 * Validates the sameModelTypes constraint of '<em>Homomorphism Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphismModelRel_sameModelTypes(HomomorphismModelRel homomorphismModelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.HOMOMORPHISM_MODEL_REL,
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
	public boolean validateModelReference(ModelReference modelReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElementReference_oneObject(modelReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementReference(ModelElementReference modelElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelElementReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElementReference_oneObject(modelElementReference, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateLink_unboundedLevel(link, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the unboundedLevel constraint of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String LINK__UNBOUNDED_LEVEL__EEXPRESSION = "unbounded = true implies level = MidLevel::TYPES";

	/**
	 * Validates the unboundedLevel constraint of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLink_unboundedLevel(Link link, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.LINK,
				 link,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "unboundedLevel",
				 LINK__UNBOUNDED_LEVEL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
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
		if (result || diagnostics != null) result &= validateLink_unboundedLevel(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryLink_isBinaryLink(binaryLink, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinaryLink constraint of '<em>Binary Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_LINK__IS_BINARY_LINK__EEXPRESSION = "elementRefs->size() = 2";

	/**
	 * Validates the isBinaryLink constraint of '<em>Binary Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryLink_isBinaryLink(BinaryLink binaryLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.BINARY_LINK,
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
		if (result || diagnostics != null) result &= validateLink_unboundedLevel(homomorphismLink, diagnostics, context);
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
	protected static final String HOMOMORPHISM_LINK__SAME_ELEMENT_TYPES__EEXPRESSION = "elementRefs->forAll(e1 : ModelElementReference, e2 : ModelElementReference | e1.object.oclAsType(ModelElement).pointer.oclType() = e2.object.oclAsType(ModelElement).pointer.oclType())";

	/**
	 * Validates the sameElementTypes constraint of '<em>Homomorphism Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHomomorphismLink_sameElementTypes(HomomorphismLink homomorphismLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.HOMOMORPHISM_LINK,
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
	public boolean validateTypedElementReference(TypedElementReference typedElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typedElementReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typedElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typedElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typedElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typedElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typedElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typedElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typedElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typedElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElementReference_oneObject(typedElementReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the oneObject constraint of '<em>Typed Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TYPED_ELEMENT_REFERENCE__ONE_OBJECT__EEXPRESSION = "referencedObject.oclIsUndefined() xor containedObject.oclIsUndefined()";

	/**
	 * Validates the oneObject constraint of '<em>Typed Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElementReference_oneObject(TypedElementReference typedElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.TYPED_ELEMENT_REFERENCE,
				 typedElementReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "oneObject",
				 TYPED_ELEMENT_REFERENCE__ONE_OBJECT__EEXPRESSION,
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

} //RelationshipValidator
