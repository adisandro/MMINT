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
package edu.toronto.cs.se.mmtf.mid.util;

import edu.toronto.cs.se.mmtf.mid.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage
 * @generated
 */
public class MidValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MidValidator INSTANCE = new MidValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.mmtf.mid";

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
	public MidValidator() {
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
	  return MidPackage.eINSTANCE;
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
			case MidPackage.EXTENDIBLE_ELEMENT:
				return validateExtendibleElement((ExtendibleElement)value, diagnostics, context);
			case MidPackage.MULTI_MODEL:
				return validateMultiModel((MultiModel)value, diagnostics, context);
			case MidPackage.MODEL:
				return validateModel((Model)value, diagnostics, context);
			case MidPackage.TYPED_ELEMENT:
				return validateTypedElement((TypedElement)value, diagnostics, context);
			case MidPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP:
				return validateEStringToExtendibleElementMap((Map.Entry<?, ?>)value, diagnostics, context);
			case MidPackage.MODEL_ELEMENT:
				return validateModelElement((ModelElement)value, diagnostics, context);
			case MidPackage.MODEL_CONSTRAINT:
				return validateModelConstraint((ModelConstraint)value, diagnostics, context);
			case MidPackage.MID_LEVEL:
				return validateMidLevel((MidLevel)value, diagnostics, context);
			case MidPackage.MODEL_ORIGIN:
				return validateModelOrigin((ModelOrigin)value, diagnostics, context);
			case MidPackage.MODEL_ELEMENT_CATEGORY:
				return validateModelElementCategory((ModelElementCategory)value, diagnostics, context);
			case MidPackage.MODEL_CONSTRAINT_ENGINE:
				return validateModelConstraintEngine((ModelConstraintEngine)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtendibleElement(ExtendibleElement extendibleElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(extendibleElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElement_typeLevel(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElement_metatypeType(extendibleElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElement_supertypeType(extendibleElement, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the supertypeType constraint of '<em>Extendible Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EXTENDIBLE_ELEMENT__SUPERTYPE_TYPE__EEXPRESSION = "not supertype.oclIsUndefined() implies self.oclIsKindOf(supertype.oclType())";

	/**
	 * Validates the supertypeType constraint of '<em>Extendible Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtendibleElement_supertypeType(ExtendibleElement extendibleElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MidPackage.Literals.EXTENDIBLE_ELEMENT,
				 extendibleElement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "supertypeType",
				 EXTENDIBLE_ELEMENT__SUPERTYPE_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiModel(MultiModel multiModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(multiModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModel(Model model, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(model, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(model, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElement_typeLevel(model, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElement_metatypeType(model, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElement_supertypeType(model, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typedElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElement_typeLevel(typedElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElement_metatypeType(typedElement, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the typeLevel constraint of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TYPED_ELEMENT__TYPE_LEVEL__EEXPRESSION = "level = MidLevel::INSTANCES implies metatype.level = MidLevel::TYPES";

	/**
	 * Validates the typeLevel constraint of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement_typeLevel(TypedElement typedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MidPackage.Literals.TYPED_ELEMENT,
				 typedElement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "typeLevel",
				 TYPED_ELEMENT__TYPE_LEVEL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the metatypeType constraint of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TYPED_ELEMENT__METATYPE_TYPE__EEXPRESSION = "not metatype.oclIsUndefined() implies self.oclIsTypeOf(metatype.oclType())";

	/**
	 * Validates the metatypeType constraint of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement_metatypeType(TypedElement typedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MidPackage.Literals.TYPED_ELEMENT,
				 typedElement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "metatypeType",
				 TYPED_ELEMENT__METATYPE_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringToExtendibleElementMap(Map.Entry<?, ?> eStringToExtendibleElementMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringToExtendibleElementMap, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateTypedElement_typeLevel(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedElement_metatypeType(modelElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElement_supertypeType(modelElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConstraint(ModelConstraint modelConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMidLevel(MidLevel midLevel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelOrigin(ModelOrigin modelOrigin, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConstraintEngine(ModelConstraintEngine modelConstraintEngine, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //MidValidator
