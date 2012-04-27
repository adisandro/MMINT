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
			case MidPackage.OPERATOR:
				return validateOperator((Operator)value, diagnostics, context);
			case MidPackage.ESTRING_TO_MODEL_MAP:
				return validateEStringToModelMap((Map.Entry<?, ?>)value, diagnostics, context);
			case MidPackage.ESTRING_TO_EDITOR_MAP:
				return validateEStringToEditorMap((Map.Entry<?, ?>)value, diagnostics, context);
			case MidPackage.ESTRING_TO_OPERATOR_MAP:
				return validateEStringToOperatorMap((Map.Entry<?, ?>)value, diagnostics, context);
			case MidPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case MidPackage.MODEL_PARAMETER:
				return validateModelParameter((ModelParameter)value, diagnostics, context);
			case MidPackage.EDITOR:
				return validateEditor((Editor)value, diagnostics, context);
			case MidPackage.DIAGRAM:
				return validateDiagram((Diagram)value, diagnostics, context);
			case MidPackage.ESTRING_TO_PARAMETER_MAP:
				return validateEStringToParameterMap((Map.Entry<?, ?>)value, diagnostics, context);
			case MidPackage.MID_LEVEL:
				return validateMidLevel((MidLevel)value, diagnostics, context);
			case MidPackage.MODEL_ORIGIN:
				return validateModelOrigin((ModelOrigin)value, diagnostics, context);
			case MidPackage.PARAMETER_TYPE:
				return validateParameterType((ParameterType)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateExtendibleElement_typeLevel(extendibleElement, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the typeLevel constraint of '<em>Extendible Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EXTENDIBLE_ELEMENT__TYPE_LEVEL__EEXPRESSION = "level = MidLevel::INSTANCES implies type.level = MidLevel::TYPES";

	/**
	 * Validates the typeLevel constraint of '<em>Extendible Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtendibleElement_typeLevel(ExtendibleElement extendibleElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MidPackage.Literals.EXTENDIBLE_ELEMENT,
				 extendibleElement,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "typeLevel",
				 EXTENDIBLE_ELEMENT__TYPE_LEVEL__EEXPRESSION,
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
		if (result || diagnostics != null) result &= validateExtendibleElement_typeLevel(model, diagnostics, context);
		if (result || diagnostics != null) result &= validateModel_supertypeType(model, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the supertypeType constraint of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL__SUPERTYPE_TYPE__EEXPRESSION = "if supertype.oclIsUndefined() then true else self.oclIsKindOf(supertype.oclType()) endif";

	/**
	 * Validates the supertypeType constraint of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModel_supertypeType(Model model, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MidPackage.Literals.MODEL,
				 model,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "supertypeType",
				 MODEL__SUPERTYPE_TYPE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperator(Operator operator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operator, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(operator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operator, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElement_typeLevel(operator, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringToModelMap(Map.Entry<?, ?> eStringToModelMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringToModelMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringToEditorMap(Map.Entry<?, ?> eStringToEditorMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringToEditorMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringToOperatorMap(Map.Entry<?, ?> eStringToOperatorMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringToOperatorMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameter_isModelParameter(parameter, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the isModelParameter constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PARAMETER__IS_MODEL_PARAMETER__EEXPRESSION = "type = ParameterType::MODEL or type = ParameterType::MODEL_REL implies self.oclIsKindOf(ModelParameter)";

	/**
	 * Validates the isModelParameter constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_isModelParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MidPackage.Literals.PARAMETER,
				 parameter,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "isModelParameter",
				 PARAMETER__IS_MODEL_PARAMETER__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelParameter(ModelParameter modelParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameter_isModelParameter(modelParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEditor(Editor editor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(editor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(editor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(editor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(editor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(editor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(editor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(editor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(editor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(editor, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElement_typeLevel(editor, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiagram(Diagram diagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(diagram, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(diagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(diagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(diagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(diagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(diagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(diagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(diagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(diagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateExtendibleElement_typeLevel(diagram, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringToParameterMap(Map.Entry<?, ?> eStringToParameterMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringToParameterMap, diagnostics, context);
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
	public boolean validateParameterType(ParameterType parameterType, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
