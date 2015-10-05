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
	 * Returns a new object of class '<em>MAVOMID</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MAVOMID</em>'.
	 * @generated
	 */
	MAVOMID createMAVOMID();

	/**
	 * Returns a new object of class '<em>MAVO Extendible Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MAVO Extendible Element</em>'.
	 * @generated
	 */
	MAVOExtendibleElement createMAVOExtendibleElement();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MAVOMIDPackage getMAVOMIDPackage();

} //MAVOMIDFactory
