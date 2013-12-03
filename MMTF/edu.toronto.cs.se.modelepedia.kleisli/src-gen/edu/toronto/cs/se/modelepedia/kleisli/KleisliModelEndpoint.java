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

import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelEndpoint()
 * @model
 * @generated
 */
public interface KleisliModelEndpoint extends ModelEndpoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates an extended metamodel for the endpoint type.
	 * <!-- end-model-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.Exception"
	 * @generated
	 */
	void newType() throws Exception;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Deletes the extended metamodel for the endpoint type.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void deleteType();

} // KleisliModelEndpoint
