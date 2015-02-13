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
package edu.toronto.cs.se.modelepedia.kleisli.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import edu.toronto.cs.se.mmint.mid.relationship.util.RelationshipValidator;
import edu.toronto.cs.se.mmint.mid.util.MIDValidator;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage
 * @generated
 */
public class KleisliValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final KleisliValidator INSTANCE = new KleisliValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.modelepedia.kleisli";

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationshipValidator relationshipValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliValidator() {
		super();
		midValidator = MIDValidator.INSTANCE;
		relationshipValidator = RelationshipValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return KleisliPackage.eINSTANCE;
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
			case KleisliPackage.KLEISLI_MODEL:
				return validateKleisliModel((KleisliModel)value, diagnostics, context);
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT:
				return validateKleisliModelEndpoint((KleisliModelEndpoint)value, diagnostics, context);
			case KleisliPackage.KLEISLI_MODEL_REL:
				return validateKleisliModelRel((KleisliModelRel)value, diagnostics, context);
			case KleisliPackage.KLEISLI_BINARY_MODEL_REL:
				return validateKleisliBinaryModelRel((KleisliBinaryModelRel)value, diagnostics, context);
			case KleisliPackage.KLEISLI_MODEL_ENDPOINT_REFERENCE:
				return validateKleisliModelEndpointReference((KleisliModelEndpointReference)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKleisliModel(KleisliModel kleisliModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(kleisliModel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(kleisliModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(kleisliModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(kleisliModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(kleisliModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(kleisliModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(kleisliModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(kleisliModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(kleisliModel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(kleisliModel, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKleisliModelRel(KleisliModelRel kleisliModelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(kleisliModelRel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(kleisliModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(kleisliModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(kleisliModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(kleisliModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(kleisliModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(kleisliModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(kleisliModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(kleisliModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(kleisliModelRel, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKleisliModelEndpoint(KleisliModelEndpoint kleisliModelEndpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(kleisliModelEndpoint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(kleisliModelEndpoint, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElementEndpoint_unboundedLevel(kleisliModelEndpoint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKleisliBinaryModelRel(KleisliBinaryModelRel kleisliBinaryModelRel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(kleisliBinaryModelRel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(kleisliBinaryModelRel, diagnostics, context);
		if (result || diagnostics != null) result &= relationshipValidator.validateBinaryModelRel_isBinaryModelRel(kleisliBinaryModelRel, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKleisliModelEndpointReference(KleisliModelEndpointReference kleisliModelEndpointReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(kleisliModelEndpointReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= relationshipValidator.validateExtendibleElementReference_oneObject(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= relationshipValidator.validateModelEndpointReference_modelEndpointType(kleisliModelEndpointReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateKleisliModelEndpointReference_kleisliModelEndpoint(kleisliModelEndpointReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the kleisliModelEndpoint constraint of '<em>Model Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String KLEISLI_MODEL_ENDPOINT_REFERENCE__KLEISLI_MODEL_ENDPOINT__EEXPRESSION = "object.oclIsKindOf(kleisli::KleisliModelEndpoint)";

	/**
	 * Validates the kleisliModelEndpoint constraint of '<em>Model Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKleisliModelEndpointReference_kleisliModelEndpoint(KleisliModelEndpointReference kleisliModelEndpointReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(KleisliPackage.Literals.KLEISLI_MODEL_ENDPOINT_REFERENCE,
				 kleisliModelEndpointReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "kleisliModelEndpoint",
				 KLEISLI_MODEL_ENDPOINT_REFERENCE__KLEISLI_MODEL_ENDPOINT__EEXPRESSION,
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

} //KleisliValidator
