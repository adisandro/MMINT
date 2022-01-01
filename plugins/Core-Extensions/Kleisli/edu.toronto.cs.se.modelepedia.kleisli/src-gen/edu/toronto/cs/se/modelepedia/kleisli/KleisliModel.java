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
package edu.toronto.cs.se.modelepedia.kleisli;

import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Kleisli version, represents a hidden extended model. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModel()
 * @model
 * @generated
 */
public interface KleisliModel extends Model {
	/**
   * <!-- begin-user-doc --> Creates a Kleisli model type.
	 *
	 * @param containerModelTypeEndpoint
	 *            The Kleisli model type endpoint that will contain the new
	 *            Kleisli model type.
	 * @return The created Kleisli model type.
	 * @throws MMINTException
	 *             If this is a model instance, or if the extended metamodel
	 *             can't be created. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" containerModelTypeEndpointRequired="true"
   * @generated
   */
	KleisliModel kleisliCreateType(KleisliModelEndpoint containerModelTypeEndpoint) throws MMINTException;

	/**
   * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
	@Override
  void deleteType() throws MMINTException;

	/**
   * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
   * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
	@Override
  EPackage getEMFTypeRoot() throws MMINTException;

	/**
   * <!-- begin-user-doc --> Creates a Kleisli model instance.
	 *
	 * @param containerModelEndpoint
	 *            The Kleisli model endpoint that will contain the new Kleisli
	 *            model.
	 * @return The created Kleisli model.
	 * @throws MMINTException
	 *             If this is a model instance. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" containerModelEndpointRequired="true"
   * @generated
   */
	KleisliModel kleisliCreateInstance(KleisliModelEndpoint containerModelEndpoint) throws MMINTException;

	/**
   * <!-- begin-user-doc -->
	 * Kleisli version. {@inheritDoc}
	 * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
	@Override
  void deleteInstance() throws MMINTException;

} // KleisliModel
