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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Kleisli version. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#getKleisliModelEndpoint()
 * @model
 * @generated
 */
public interface KleisliModelEndpoint extends ModelEndpoint, KleisliExtendibleElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelTypeEndpointNameRequired="true" newModelTypeRequired="true" isBinarySrcRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	ModelEndpointReference createSubtypeAndReference(ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" oldModelTypeEndpointRequired="true" newModelTypeEndpointNameRequired="true" newModelTypeRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	void replaceSubtypeAndReference(ModelEndpoint oldModelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, ModelRel containerModelRelType) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isFullDeleteRequired="true"
	 * @generated
	 */
	void deleteTypeAndReference(boolean isFullDelete) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelRequired="true" isBinarySrcRequired="true" containerModelRelRequired="true"
	 * @generated
	 */
	ModelEndpointReference createInstanceAndReference(Model newModel, boolean isBinarySrc, ModelRel containerModelRel) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isFullDeleteRequired="true"
	 * @generated
	 */
	void deleteInstanceAndReference(boolean isFullDelete) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" oldModelEndpointRequired="true" newModelRequired="true"
	 * @generated
	 */
	void replaceInstanceAndReference(ModelEndpoint oldModelEndpoint, Model newModel) throws MMTFException;

} // KleisliModelEndpoint
