/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SafetyCaseFactoryImpl extends EFactoryImpl implements SafetyCaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SafetyCaseFactory init() {
		try {
			SafetyCaseFactory theSafetyCaseFactory = (SafetyCaseFactory)EPackage.Registry.INSTANCE.getEFactory(SafetyCasePackage.eNS_URI);
			if (theSafetyCaseFactory != null) {
				return theSafetyCaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SafetyCaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SafetyCasePackage.SAFETY_CASE: return createSafetyCase();
			case SafetyCasePackage.SUPPORTED_BY: return createSupportedBy();
			case SafetyCasePackage.IN_CONTEXT_OF: return createInContextOf();
			case SafetyCasePackage.GOAL: return createGoal();
			case SafetyCasePackage.BASIC_STRATEGY: return createBasicStrategy();
			case SafetyCasePackage.ASIL_DECOMPOSITION_STRATEGY: return createASILDecompositionStrategy();
			case SafetyCasePackage.SOLUTION: return createSolution();
			case SafetyCasePackage.CONTEXT: return createContext();
			case SafetyCasePackage.JUSTIFICATION: return createJustification();
			case SafetyCasePackage.ASIL: return createASIL();
			case SafetyCasePackage.CONTENT_IMPACT_ANNOTATION: return createContentImpactAnnotation();
			case SafetyCasePackage.STATE_IMPACT_ANNOTATION: return createStateImpactAnnotation();
			case SafetyCasePackage.ASIL_IMPACT_ANNOTATION: return createASILImpactAnnotation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SafetyCasePackage.ASIL_LEVEL:
				return createASILLevelFromString(eDataType, initialValue);
			case SafetyCasePackage.VALIDITY_VALUE:
				return createValidityValueFromString(eDataType, initialValue);
			case SafetyCasePackage.CONTENT_IMPACT_TYPE:
				return createContentImpactTypeFromString(eDataType, initialValue);
			case SafetyCasePackage.STATE_IMPACT_TYPE:
				return createStateImpactTypeFromString(eDataType, initialValue);
			case SafetyCasePackage.ASIL_IMPACT_TYPE:
				return createASILImpactTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SafetyCasePackage.ASIL_LEVEL:
				return convertASILLevelToString(eDataType, instanceValue);
			case SafetyCasePackage.VALIDITY_VALUE:
				return convertValidityValueToString(eDataType, instanceValue);
			case SafetyCasePackage.CONTENT_IMPACT_TYPE:
				return convertContentImpactTypeToString(eDataType, instanceValue);
			case SafetyCasePackage.STATE_IMPACT_TYPE:
				return convertStateImpactTypeToString(eDataType, instanceValue);
			case SafetyCasePackage.ASIL_IMPACT_TYPE:
				return convertASILImpactTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCase createSafetyCase() {
		SafetyCaseImpl safetyCase = new SafetyCaseImpl();
		return safetyCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportedBy createSupportedBy() {
		SupportedByImpl supportedBy = new SupportedByImpl();
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InContextOf createInContextOf() {
		InContextOfImpl inContextOf = new InContextOfImpl();
		return inContextOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal createGoal() {
		GoalImpl goal = new GoalImpl();
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicStrategy createBasicStrategy() {
		BasicStrategyImpl basicStrategy = new BasicStrategyImpl();
		return basicStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILDecompositionStrategy createASILDecompositionStrategy() {
		ASILDecompositionStrategyImpl asilDecompositionStrategy = new ASILDecompositionStrategyImpl();
		return asilDecompositionStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution createSolution() {
		SolutionImpl solution = new SolutionImpl();
		return solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Justification createJustification() {
		JustificationImpl justification = new JustificationImpl();
		return justification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASIL createASIL() {
		ASILImpl asil = new ASILImpl();
		return asil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentImpactAnnotation createContentImpactAnnotation() {
		ContentImpactAnnotationImpl contentImpactAnnotation = new ContentImpactAnnotationImpl();
		return contentImpactAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateImpactAnnotation createStateImpactAnnotation() {
		StateImpactAnnotationImpl stateImpactAnnotation = new StateImpactAnnotationImpl();
		return stateImpactAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILImpactAnnotation createASILImpactAnnotation() {
		ASILImpactAnnotationImpl asilImpactAnnotation = new ASILImpactAnnotationImpl();
		return asilImpactAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILLevel createASILLevelFromString(EDataType eDataType, String initialValue) {
		ASILLevel result = ASILLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertASILLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidityValue createValidityValueFromString(EDataType eDataType, String initialValue) {
		ValidityValue result = ValidityValue.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValidityValueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentImpactType createContentImpactTypeFromString(EDataType eDataType, String initialValue) {
		ContentImpactType result = ContentImpactType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContentImpactTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateImpactType createStateImpactTypeFromString(EDataType eDataType, String initialValue) {
		StateImpactType result = StateImpactType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStateImpactTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILImpactType createASILImpactTypeFromString(EDataType eDataType, String initialValue) {
		ASILImpactType result = ASILImpactType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertASILImpactTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCasePackage getSafetyCasePackage() {
		return (SafetyCasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SafetyCasePackage getPackage() {
		return SafetyCasePackage.eINSTANCE;
	}

} //SafetyCaseFactoryImpl
