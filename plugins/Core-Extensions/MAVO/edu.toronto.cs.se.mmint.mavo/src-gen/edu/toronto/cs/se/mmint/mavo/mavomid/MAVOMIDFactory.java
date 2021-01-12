/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage
 * @generated
 */
public interface MAVOMIDFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	MAVOMIDFactory eINSTANCE = edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOMIDFactoryImpl.init();

	/**
   * Returns a new object of class '<em>MAVO Model</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>MAVO Model</em>'.
   * @generated
   */
	MAVOModel createMAVOModel();

	/**
   * Returns a new object of class '<em>MAVO Model Element</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>MAVO Model Element</em>'.
   * @generated
   */
	MAVOModelElement createMAVOModelElement();

	/**
   * Returns a new object of class '<em>MAVO Model Rel</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>MAVO Model Rel</em>'.
   * @generated
   */
	MAVOModelRel createMAVOModelRel();

	/**
   * Returns a new object of class '<em>Binary MAVO Model Rel</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary MAVO Model Rel</em>'.
   * @generated
   */
	BinaryMAVOModelRel createBinaryMAVOModelRel();

	/**
   * Returns a new object of class '<em>MAVO Model Endpoint</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>MAVO Model Endpoint</em>'.
   * @generated
   */
	MAVOModelEndpoint createMAVOModelEndpoint();

	/**
   * Returns a new object of class '<em>MAVO Model Endpoint Reference</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>MAVO Model Endpoint Reference</em>'.
   * @generated
   */
	MAVOModelEndpointReference createMAVOModelEndpointReference();

	/**
   * Returns a new object of class '<em>MAVO Mapping Reference</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>MAVO Mapping Reference</em>'.
   * @generated
   */
	MAVOMappingReference createMAVOMappingReference();

	/**
   * Returns a new object of class '<em>Binary MAVO Mapping Reference</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary MAVO Mapping Reference</em>'.
   * @generated
   */
	BinaryMAVOMappingReference createBinaryMAVOMappingReference();

	/**
   * Returns a new object of class '<em>MAVO Mapping</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>MAVO Mapping</em>'.
   * @generated
   */
	MAVOMapping createMAVOMapping();

	/**
   * Returns a new object of class '<em>Binary MAVO Mapping</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary MAVO Mapping</em>'.
   * @generated
   */
	BinaryMAVOMapping createBinaryMAVOMapping();

	/**
   * Returns a new object of class '<em>MAVO Model Element Reference</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>MAVO Model Element Reference</em>'.
   * @generated
   */
	MAVOModelElementReference createMAVOModelElementReference();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	MAVOMIDPackage getMAVOMIDPackage();

} //MAVOMIDFactory
