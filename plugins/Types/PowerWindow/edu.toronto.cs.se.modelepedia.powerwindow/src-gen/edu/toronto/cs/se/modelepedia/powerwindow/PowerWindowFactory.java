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
package edu.toronto.cs.se.modelepedia.powerwindow;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.powerwindow.PowerWindowPackage
 * @generated
 */
public interface PowerWindowFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PowerWindowFactory eINSTANCE = edu.toronto.cs.se.modelepedia.powerwindow.impl.PowerWindowFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Window</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Window</em>'.
	 * @generated
	 */
	Window createWindow();

	/**
	 * Returns a new object of class '<em>Infrared</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infrared</em>'.
	 * @generated
	 */
	Infrared createInfrared();

	/**
	 * Returns a new object of class '<em>Force Detecting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Force Detecting</em>'.
	 * @generated
	 */
	ForceDetecting createForceDetecting();

	/**
	 * Returns a new object of class '<em>Lock Out</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lock Out</em>'.
	 * @generated
	 */
	LockOut createLockOut();

	/**
	 * Returns a new object of class '<em>Rocker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rocker</em>'.
	 * @generated
	 */
	Rocker createRocker();

	/**
	 * Returns a new object of class '<em>Push Pull</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Push Pull</em>'.
	 * @generated
	 */
	PushPull createPushPull();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PowerWindowPackage getPowerWindowPackage();

} //PowerWindowFactory
