/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mavo;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mavo.MAVOPackage
 * @generated
 */
public interface MAVOFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MAVOFactory eINSTANCE = edu.toronto.cs.se.mavo.impl.MAVOFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection</em>'.
	 * @generated
	 */
	MAVOCollection createMAVOCollection();

	/**
	 * Returns a new object of class '<em>May Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>May Decision</em>'.
	 * @generated
	 */
	MayDecision createMayDecision();

	/**
	 * Returns a new object of class '<em>Var Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Decision</em>'.
	 * @generated
	 */
	VarDecision createVarDecision();

	/**
	 * Returns a new object of class '<em>Set Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Decision</em>'.
	 * @generated
	 */
	SetDecision createSetDecision();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MAVOPackage getMAVOPackage();

} //MAVOFactory
