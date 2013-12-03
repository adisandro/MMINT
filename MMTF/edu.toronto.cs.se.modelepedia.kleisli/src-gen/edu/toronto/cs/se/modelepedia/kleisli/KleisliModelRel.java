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
package edu.toronto.cs.se.modelepedia.kleisli;

import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelRel()
 * @model
 * @generated
 */
public interface KleisliModelRel extends ModelRel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates a directory to store extended metamodels for the endpoint types.
	 * <!-- end-model-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.Exception"
	 * @generated
	 */
	void newType() throws Exception;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Deletes the directory where extended metamodels for the endpoint types are stored.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void deleteType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates a directory to store extended models for the endpoints.
	 * <!-- end-model-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.Exception"
	 * @generated
	 */
	void newInstance() throws Exception;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Deletes the directory where extended models for the endpoints are stored.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void deleteInstance();

} // KleisliModelRel
