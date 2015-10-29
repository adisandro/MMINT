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
package edu.toronto.cs.se.mmint.mavo.mavomid.impl;

import edu.toronto.cs.se.mmint.mavo.mavomid.*;

import org.eclipse.emf.ecore.EClass;
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
public class MAVOMIDFactoryImpl extends EFactoryImpl implements MAVOMIDFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MAVOMIDFactory init() {
		try {
			MAVOMIDFactory theMAVOMIDFactory = (MAVOMIDFactory)EPackage.Registry.INSTANCE.getEFactory(MAVOMIDPackage.eNS_URI);
			if (theMAVOMIDFactory != null) {
				return theMAVOMIDFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MAVOMIDFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOMIDFactoryImpl() {
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
			case MAVOMIDPackage.MAVO_MODEL: return createMAVOModel();
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT: return createMAVOModelElement();
			case MAVOMIDPackage.MAVO_MODEL_REL: return createMAVOModelRel();
			case MAVOMIDPackage.MAVO_BINARY_MODEL_REL: return createMAVOBinaryModelRel();
			case MAVOMIDPackage.MAVO_MAPPING: return createMAVOMapping();
			case MAVOMIDPackage.MAVO_BINARY_MAPPING: return createMAVOBinaryMapping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOModel createMAVOModel() {
		MAVOModelImpl mavoModel = new MAVOModelImpl();
		return mavoModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOModelElement createMAVOModelElement() {
		MAVOModelElementImpl mavoModelElement = new MAVOModelElementImpl();
		return mavoModelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOModelRel createMAVOModelRel() {
		MAVOModelRelImpl mavoModelRel = new MAVOModelRelImpl();
		return mavoModelRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOBinaryModelRel createMAVOBinaryModelRel() {
		MAVOBinaryModelRelImpl mavoBinaryModelRel = new MAVOBinaryModelRelImpl();
		return mavoBinaryModelRel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOMapping createMAVOMapping() {
		MAVOMappingImpl mavoMapping = new MAVOMappingImpl();
		return mavoMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOBinaryMapping createMAVOBinaryMapping() {
		MAVOBinaryMappingImpl mavoBinaryMapping = new MAVOBinaryMappingImpl();
		return mavoBinaryMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOMIDPackage getMAVOMIDPackage() {
		return (MAVOMIDPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MAVOMIDPackage getPackage() {
		return MAVOMIDPackage.eINSTANCE;
	}

} //MAVOMIDFactoryImpl
