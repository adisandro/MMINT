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
package edu.toronto.cs.se.mmtf.mid.operator.util;

import edu.toronto.cs.se.mmtf.mid.operator.*;

import edu.toronto.cs.se.mmtf.mid.util.MidValidator;

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
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage
 * @generated
 */
public class OperatorValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final OperatorValidator INSTANCE = new OperatorValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.mmtf.mid.operator";

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
	public OperatorValidator() {
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
	  return OperatorPackage.eINSTANCE;
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
			case OperatorPackage.ESTRING_TO_PARAMETER_MAP:
				return validateEStringToParameterMap((Map.Entry<?, ?>)value, diagnostics, context);
			case OperatorPackage.OPERATOR:
				return validateOperator((Operator)value, diagnostics, context);
			case OperatorPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case OperatorPackage.MODEL_PARAMETER:
				return validateModelParameter((ModelParameter)value, diagnostics, context);
			case OperatorPackage.ESTRING_TO_OPERATOR_MAP:
				return validateEStringToOperatorMap((Map.Entry<?, ?>)value, diagnostics, context);
			case OperatorPackage.COERCION_OPERATOR:
				return validateCoercionOperator((CoercionOperator)value, diagnostics, context);
			case OperatorPackage.PARAMETER_TYPE:
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
	public boolean validateEStringToParameterMap(Map.Entry<?, ?> eStringToParameterMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringToParameterMap, diagnostics, context);
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
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(operator, diagnostics, context);
		return result;
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
				(OperatorPackage.Literals.PARAMETER,
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
	public boolean validateEStringToOperatorMap(Map.Entry<?, ?> eStringToOperatorMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)eStringToOperatorMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoercionOperator(CoercionOperator coercionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(coercionOperator, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateTypedElement_typeLevel(coercionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateCoercionOperator_coercion(coercionOperator, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the coercion constraint of '<em>Coercion Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String COERCION_OPERATOR__COERCION__EEXPRESSION = "inputs->size() = 1 and outputs->size() = 2 and inputs->forAll(value.oclIsKindOf(ModelParameter)) and outputs->forAll(value.oclIsKindOf(ModelParameter)) and inputs->at(1).value.oclAsType(ModelParameter).model.supertype = outputs->at(1).value.oclAsType(ModelParameter).model";

	/**
	 * Validates the coercion constraint of '<em>Coercion Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoercionOperator_coercion(CoercionOperator coercionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(OperatorPackage.Literals.COERCION_OPERATOR,
				 coercionOperator,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "coercion",
				 COERCION_OPERATOR__COERCION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
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

} //OperatorValidator
