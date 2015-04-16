/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import edu.toronto.cs.se.mmint.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.util.MIDValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage
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
	public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.mmint.mid.relationship";

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
	protected MIDValidator midValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipValidator() {
		super();
		midValidator = MIDValidator.INSTANCE;
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
			case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE:
				return validateExtendibleElementReference((ExtendibleElementReference)value, diagnostics, context);
			case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE:
				return validateExtendibleElementEndpointReference((ExtendibleElementEndpointReference)value, diagnostics, context);
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE:
				return validateModelEndpointReference((ModelEndpointReference)value, diagnostics, context);
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE:
				return validateModelElementReference((ModelElementReference)value, diagnostics, context);
			case RelationshipPackage.LINK:
				return validateLink((Link)value, diagnostics, context);
			case RelationshipPackage.BINARY_LINK:
				return validateBinaryLink((BinaryLink)value, diagnostics, context);
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT:
				return validateModelElementEndpoint((ModelElementEndpoint)value, diagnostics, context);
			case RelationshipPackage.LINK_REFERENCE:
				return validateLinkReference((LinkReference)value, diagnostics, context);
			case RelationshipPackage.BINARY_LINK_REFERENCE:
				return validateBinaryLinkReference((BinaryLinkReference)value, diagnostics, context);
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE:
				return validateModelElementEndpointReference((ModelElementEndpointReference)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(modelRel, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(binaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryModelRel_isBinaryModelRel(binaryModelRel, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinaryModelRel constraint of '<em>Binary Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_MODEL_REL__IS_BINARY_MODEL_REL__EEXPRESSION = "modelEndpoints->size() = 2";

	/**
	 * Validates the isBinaryModelRel constraint of '<em>Binary Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryModelRel_isBinaryModelRel(BinaryModelRel binaryModelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.BINARY_MODEL_REL,
				 binaryModelRel,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "isBinaryModelRel",
				 BINARY_MODEL_REL__IS_BINARY_MODEL_REL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelEndpointReference(ModelEndpointReference modelEndpointReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelEndpointReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElementReference_oneObject(modelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelEndpointReference_modelEndpointType(modelEndpointReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the modelEndpointType constraint of '<em>Model Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL_ENDPOINT_REFERENCE__MODEL_ENDPOINT_TYPE__EEXPRESSION = "object.oclIsKindOf(mid::ModelEndpoint)";

	/**
	 * Validates the modelEndpointType constraint of '<em>Model Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelEndpointReference_modelEndpointType(ModelEndpointReference modelEndpointReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.MODEL_ENDPOINT_REFERENCE,
				 modelEndpointReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "modelEndpointType",
				 MODEL_ENDPOINT_REFERENCE__MODEL_ENDPOINT_TYPE__EEXPRESSION,
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
		if (!validate_NoCircularContainment(modelElementReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElementReference_oneObject(modelElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelElementReference_modelElementType(modelElementReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the modelElementType constraint of '<em>Model Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT_TYPE__EEXPRESSION = "object.oclIsKindOf(mid::ModelElement)";

	/**
	 * Validates the modelElementType constraint of '<em>Model Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementReference_modelElementType(ModelElementReference modelElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.MODEL_ELEMENT_REFERENCE,
				 modelElementReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "modelElementType",
				 MODEL_ELEMENT_REFERENCE__MODEL_ELEMENT_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
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
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(link, diagnostics, context);
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
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(binaryLink, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryLink_isBinaryLink(binaryLink, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinaryLink constraint of '<em>Binary Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_LINK__IS_BINARY_LINK__EEXPRESSION = "modelElemEndpoints->size() = 2";

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
	public boolean validateModelElementEndpoint(ModelElementEndpoint modelElementEndpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelElementEndpoint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(modelElementEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElementEndpoint_unboundedLevel(modelElementEndpoint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtendibleElementReference(ExtendibleElementReference extendibleElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(extendibleElementReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(extendibleElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(extendibleElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(extendibleElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(extendibleElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(extendibleElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(extendibleElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(extendibleElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(extendibleElementReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElementReference_oneObject(extendibleElementReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the oneObject constraint of '<em>Extendible Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EXTENDIBLE_ELEMENT_REFERENCE__ONE_OBJECT__EEXPRESSION = "referencedObject.oclIsUndefined() xor containedObject.oclIsUndefined()";

	/**
	 * Validates the oneObject constraint of '<em>Extendible Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtendibleElementReference_oneObject(ExtendibleElementReference extendibleElementReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.EXTENDIBLE_ELEMENT_REFERENCE,
				 extendibleElementReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "oneObject",
				 EXTENDIBLE_ELEMENT_REFERENCE__ONE_OBJECT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtendibleElementEndpointReference(ExtendibleElementEndpointReference extendibleElementEndpointReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(extendibleElementEndpointReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(extendibleElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(extendibleElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(extendibleElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(extendibleElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(extendibleElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(extendibleElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(extendibleElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(extendibleElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElementReference_oneObject(extendibleElementEndpointReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkReference(LinkReference linkReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(linkReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElementReference_oneObject(linkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateLinkReference_linkType(linkReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the linkType constraint of '<em>Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String LINK_REFERENCE__LINK_TYPE__EEXPRESSION = "object.oclIsKindOf(Link)";

	/**
	 * Validates the linkType constraint of '<em>Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkReference_linkType(LinkReference linkReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.LINK_REFERENCE,
				 linkReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "linkType",
				 LINK_REFERENCE__LINK_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryLinkReference(BinaryLinkReference binaryLinkReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(binaryLinkReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElementReference_oneObject(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateLinkReference_linkType(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryLinkReference_isBinaryLinkRef(binaryLinkReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateBinaryLinkReference_binaryLinkType(binaryLinkReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isBinaryLinkRef constraint of '<em>Binary Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_LINK_REFERENCE__IS_BINARY_LINK_REF__EEXPRESSION = "modelElemEndpointRefs->size() = 2";

	/**
	 * Validates the isBinaryLinkRef constraint of '<em>Binary Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryLinkReference_isBinaryLinkRef(BinaryLinkReference binaryLinkReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.BINARY_LINK_REFERENCE,
				 binaryLinkReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "isBinaryLinkRef",
				 BINARY_LINK_REFERENCE__IS_BINARY_LINK_REF__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the binaryLinkType constraint of '<em>Binary Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BINARY_LINK_REFERENCE__BINARY_LINK_TYPE__EEXPRESSION = "object.oclIsKindOf(BinaryLink)";

	/**
	 * Validates the binaryLinkType constraint of '<em>Binary Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryLinkReference_binaryLinkType(BinaryLinkReference binaryLinkReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.BINARY_LINK_REFERENCE,
				 binaryLinkReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "binaryLinkType",
				 BINARY_LINK_REFERENCE__BINARY_LINK_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementEndpointReference(ModelElementEndpointReference modelElementEndpointReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelElementEndpointReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElementReference_oneObject(modelElementEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateModelElementEndpointReference_modelElemEndpointType(modelElementEndpointReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the modelElemEndpointType constraint of '<em>Model Element Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_ENDPOINT_TYPE__EEXPRESSION = "object.oclIsKindOf(ModelElementEndpoint)";

	/**
	 * Validates the modelElemEndpointType constraint of '<em>Model Element Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelElementEndpointReference_modelElemEndpointType(ModelElementEndpointReference modelElementEndpointReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RelationshipPackage.Literals.MODEL_ELEMENT_ENDPOINT_REFERENCE,
				 modelElementEndpointReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "modelElemEndpointType",
				 MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_ENDPOINT_TYPE__EEXPRESSION,
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
