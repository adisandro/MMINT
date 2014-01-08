/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
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

import java.util.Random;
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
			case OperatorPackage.CONVERSION_OPERATOR:
				return validateConversionOperator((ConversionOperator)value, diagnostics, context);
			case OperatorPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case OperatorPackage.OPERATOR_EXECUTABLE:
				return validateOperatorExecutable((OperatorExecutable)value, diagnostics, context);
			case OperatorPackage.CONVERSION_OPERATOR_EXECUTABLE:
				return validateConversionOperatorExecutable((ConversionOperatorExecutable)value, diagnostics, context);
			case OperatorPackage.RANDOM_OPERATOR_EXECUTABLE:
				return validateRandomOperatorExecutable((RandomOperatorExecutable)value, diagnostics, context);
			case OperatorPackage.RANDOM:
				return validateRandom((Random)value, diagnostics, context);
			case OperatorPackage.EXCEPTION:
				return validateException((Exception)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(operator, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConversionOperator(ConversionOperator conversionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(conversionOperator, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= midValidator.validateExtendibleElement_typeLevel(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateConversionOperator_conversion(conversionOperator, diagnostics, context);
		if (result || diagnostics != null) result &= validateConversionOperator_executable(conversionOperator, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the conversion constraint of '<em>Conversion Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CONVERSION_OPERATOR__CONVERSION__EEXPRESSION = "inputs->size() = 1 and outputs->size() = 1";

	/**
	 * Validates the conversion constraint of '<em>Conversion Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConversionOperator_conversion(ConversionOperator conversionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(OperatorPackage.Literals.CONVERSION_OPERATOR,
				 conversionOperator,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "conversion",
				 CONVERSION_OPERATOR__CONVERSION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the executable constraint of '<em>Conversion Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CONVERSION_OPERATOR__EXECUTABLE__EEXPRESSION = "executable.oclIsKindOf(ConversionOperatorExecutable)";

	/**
	 * Validates the executable constraint of '<em>Conversion Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConversionOperator_executable(ConversionOperator conversionOperator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(OperatorPackage.Literals.CONVERSION_OPERATOR,
				 conversionOperator,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "executable",
				 CONVERSION_OPERATOR__EXECUTABLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperatorExecutable(OperatorExecutable operatorExecutable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operatorExecutable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConversionOperatorExecutable(ConversionOperatorExecutable conversionOperatorExecutable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conversionOperatorExecutable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRandomOperatorExecutable(RandomOperatorExecutable randomOperatorExecutable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(randomOperatorExecutable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRandom(Random random, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateException(Exception exception, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
