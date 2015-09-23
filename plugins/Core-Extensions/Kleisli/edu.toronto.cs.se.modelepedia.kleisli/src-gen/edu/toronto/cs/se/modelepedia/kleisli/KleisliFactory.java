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
package edu.toronto.cs.se.modelepedia.kleisli;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage
 * @generated
 */
public interface KleisliFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KleisliFactory eINSTANCE = edu.toronto.cs.se.modelepedia.kleisli.impl.KleisliFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	KleisliModel createKleisliModel();

	/**
	 * Returns a new object of class '<em>Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Rel</em>'.
	 * @generated
	 */
	KleisliModelRel createKleisliModelRel();

	/**
	 * Returns a new object of class '<em>Model Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Endpoint</em>'.
	 * @generated
	 */
	KleisliModelEndpoint createKleisliModelEndpoint();

	/**
	 * Returns a new object of class '<em>Binary Model Rel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Model Rel</em>'.
	 * @generated
	 */
	KleisliBinaryModelRel createKleisliBinaryModelRel();

	/**
	 * Returns a new object of class '<em>Model Endpoint Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Endpoint Reference</em>'.
	 * @generated
	 */
	KleisliModelEndpointReference createKleisliModelEndpointReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	KleisliPackage getKleisliPackage();

} //KleisliFactory
