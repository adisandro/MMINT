/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.impl;

import edu.toronto.cs.se.mmtf.mid.*;

import java.util.Map;

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
public class MidFactoryImpl extends EFactoryImpl implements MidFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MidFactory init() {
		try {
			MidFactory theMidFactory = (MidFactory)EPackage.Registry.INSTANCE.getEFactory(MidPackage.eNS_URI);
			if (theMidFactory != null) {
				return theMidFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MidFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidFactoryImpl() {
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
			case MidPackage.MULTI_MODEL: return createMultiModel();
			case MidPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP: return (EObject)createEStringToExtendibleElementMap();
			case MidPackage.MODEL: return createModel();
			case MidPackage.EXTENDIBLE_ELEMENT_CONSTRAINT: return createExtendibleElementConstraint();
			case MidPackage.MODEL_ELEMENT: return createModelElement();
			case MidPackage.MODEL_ELEMENT_WILDCARD: return createModelElementWildcard();
			case MidPackage.MODEL_ENDPOINT: return createModelEndpoint();
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
			case MidPackage.MID_LEVEL:
				return createMidLevelFromString(eDataType, initialValue);
			case MidPackage.MODEL_ORIGIN:
				return createModelOriginFromString(eDataType, initialValue);
			case MidPackage.EXTENDIBLE_ELEMENT_CONSTRAINT_LANGUAGE:
				return createExtendibleElementConstraintLanguageFromString(eDataType, initialValue);
			case MidPackage.EXCEPTION:
				return createExceptionFromString(eDataType, initialValue);
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
			case MidPackage.MID_LEVEL:
				return convertMidLevelToString(eDataType, instanceValue);
			case MidPackage.MODEL_ORIGIN:
				return convertModelOriginToString(eDataType, instanceValue);
			case MidPackage.EXTENDIBLE_ELEMENT_CONSTRAINT_LANGUAGE:
				return convertExtendibleElementConstraintLanguageToString(eDataType, instanceValue);
			case MidPackage.EXCEPTION:
				return convertExceptionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiModel createMultiModel() {
		MultiModelImpl multiModel = new MultiModelImpl();
		return multiModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElementConstraint createExtendibleElementConstraint() {
		ExtendibleElementConstraintImpl extendibleElementConstraint = new ExtendibleElementConstraintImpl();
		return extendibleElementConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, ExtendibleElement> createEStringToExtendibleElementMap() {
		EStringToExtendibleElementMapImpl eStringToExtendibleElementMap = new EStringToExtendibleElementMapImpl();
		return eStringToExtendibleElementMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement createModelElement() {
		ModelElementImpl modelElement = new ModelElementImpl();
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementWildcard createModelElementWildcard() {
		ModelElementWildcardImpl modelElementWildcard = new ModelElementWildcardImpl();
		return modelElementWildcard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelEndpoint createModelEndpoint() {
		ModelEndpointImpl modelEndpoint = new ModelEndpointImpl();
		return modelEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidLevel createMidLevelFromString(EDataType eDataType, String initialValue) {
		MidLevel result = MidLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMidLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelOrigin createModelOriginFromString(EDataType eDataType, String initialValue) {
		ModelOrigin result = ModelOrigin.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModelOriginToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendibleElementConstraintLanguage createExtendibleElementConstraintLanguageFromString(EDataType eDataType, String initialValue) {
		ExtendibleElementConstraintLanguage result = ExtendibleElementConstraintLanguage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExtendibleElementConstraintLanguageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exception createExceptionFromString(EDataType eDataType, String initialValue) {
		return (Exception)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidPackage getMidPackage() {
		return (MidPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MidPackage getPackage() {
		return MidPackage.eINSTANCE;
	}

} //MidFactoryImpl
