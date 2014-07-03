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
package edu.toronto.cs.se.mmint.mid.impl;

import edu.toronto.cs.se.mmint.MMINTException;

import edu.toronto.cs.se.mmint.mid.*;

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
public class MIDFactoryImpl extends EFactoryImpl implements MIDFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MIDFactory init() {
		try {
			MIDFactory theMIDFactory = (MIDFactory)EPackage.Registry.INSTANCE.getEFactory(MIDPackage.eNS_URI);
			if (theMIDFactory != null) {
				return theMIDFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MIDFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MIDFactoryImpl() {
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
			case MIDPackage.MULTI_MODEL: return createMultiModel();
			case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP: return (EObject)createEStringToExtendibleElementMap();
			case MIDPackage.MODEL: return createModel();
			case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT: return createExtendibleElementConstraint();
			case MIDPackage.MODEL_ELEMENT: return createModelElement();
			case MIDPackage.MODEL_ENDPOINT: return createModelEndpoint();
			case MIDPackage.EMF_INFO: return createEMFInfo();
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
			case MIDPackage.MID_LEVEL:
				return createMIDLevelFromString(eDataType, initialValue);
			case MIDPackage.MODEL_ORIGIN:
				return createModelOriginFromString(eDataType, initialValue);
			case MIDPackage.MMINT_EXCEPTION:
				return createMMINTExceptionFromString(eDataType, initialValue);
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
			case MIDPackage.MID_LEVEL:
				return convertMIDLevelToString(eDataType, instanceValue);
			case MIDPackage.MODEL_ORIGIN:
				return convertModelOriginToString(eDataType, instanceValue);
			case MIDPackage.MMINT_EXCEPTION:
				return convertMMINTExceptionToString(eDataType, instanceValue);
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
	public Map.Entry<String, ExtendibleElement> createEStringToExtendibleElementMap() {
		EStringToExtendibleElementMapImpl eStringToExtendibleElementMap = new EStringToExtendibleElementMapImpl();
		return eStringToExtendibleElementMap;
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
	public ModelElement createModelElement() {
		ModelElementImpl modelElement = new ModelElementImpl();
		return modelElement;
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
	public EMFInfo createEMFInfo() {
		EMFInfoImpl emfInfo = new EMFInfoImpl();
		return emfInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MIDLevel createMIDLevelFromString(EDataType eDataType, String initialValue) {
		MIDLevel result = MIDLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMIDLevelToString(EDataType eDataType, Object instanceValue) {
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
	public MMINTException createMMINTExceptionFromString(EDataType eDataType, String initialValue) {
		return (MMINTException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMMINTExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MIDPackage getMIDPackage() {
		return (MIDPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MIDPackage getPackage() {
		return MIDPackage.eINSTANCE;
	}

} //MIDFactoryImpl
