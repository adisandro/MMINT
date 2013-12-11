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
package edu.toronto.cs.se.mmtf.mid;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The model endpoint for a model relationship.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelEndpoint()
 * @model
 * @generated
 */
public interface ModelEndpoint extends ExtendibleElementEndpoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model supertype endpoint of this model type endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpoint supertype = super.getSupertype();\nreturn (supertype == null) ? null : (ModelEndpoint) supertype;'"
	 * @generated
	 */
	ModelEndpoint getSupertype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model target of this model endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement target = super.getTarget();\nreturn (target == null) ? null : (Model) target;'"
	 * @generated
	 */
	Model getTarget();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model type endpoint of this model instance endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpoint metatype = super.getMetatype();\nreturn (metatype == null) ? null : (ModelEndpoint) metatype;'"
	 * @generated
	 */
	ModelEndpoint getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * Creates and adds a subtype of this model type endpoint and a reference to
	 * it to the Type MID.
	 * 
	 * @param modelTypeEndpointRef
	 *            The reference to the supertype of the new model type endpoint,
	 *            null if such reference doesn't exist in the model relationship
	 *            type container.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param isBinarySrc
	 *            True if the model type endpoint is the source in the binary
	 *            model relationship type container, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the model type endpoint.
	 * @throws MMTFException
	 *             If this model endpoint is at the INSTANCES level, or if the
	 *             uri of the new model type endpoint is already registered in
	 *             the Type MID.
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelTypeEndpointNameRequired="true" newModelTypeRequired="true" isBinarySrcRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	ModelEndpointReference createSubtypeAndReference(ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, boolean isBinarySrc, ModelRel containerModelRelType) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Replaces an old subtype of this model type endpoint and a reference to it
	 * with new ones in the Type MID.
	 * 
	 * @param oldModelTypeEndpoint
	 *            The old model type endpoint to be replaced.
	 * @param modelTypeEndpointRef
	 *            The reference to the supertype of the new model type endpoint,
	 *            null if such reference doesn't exist in the model relationship
	 *            type container.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param modelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @throws MMTFException
	 *             If this model endpoint is at the INSTANCES level, or if the
	 *             uri of the new model type endpoint is already registered in
	 *             the Type MID.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" oldModelTypeEndpointRequired="true" newModelTypeEndpointNameRequired="true" newModelTypeRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	void replaceSubtypeAndReference(ModelEndpoint oldModelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, ModelRel containerModelRelType) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Deletes this model type endpoint and all references to it from the Type
	 * MID.
	 * 
	 * @param isFullDelete
	 *            True if this model type endpoint is going to be fully deleted,
	 *            false if it is going to be replaced later.
	 * @throws MMTFException
	 *             If this model endpoint is at the INSTANCES level.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isFullDeleteRequired="true"
	 * @generated
	 */
	void deleteTypeAndReference(boolean isFullDelete) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Creates and adds a model endpoint and a reference to it to an Instance
	 * MID.
	 * 
	 * @param newModel
	 *            The new model that is the target of the new model endpoint.
	 * @param isBinarySrc
	 *            True if the model endpoint is the source in the binary model
	 *            relationship container, false otherwise.
	 * @param modelRel
	 *            The model relationship that will contain the new model
	 *            endpoint.
	 * @return The created reference to the model endpoint.
	 * @throws MMTFException
	 *             If this model endpoint is at the INSTANCES level.
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelRequired="true" isBinarySrcRequired="true" containerModelRelRequired="true"
	 * @generated
	 */
	ModelEndpointReference createInstanceAndReference(Model newModel, boolean isBinarySrc, ModelRel containerModelRel) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Deletes this model endpoint and the reference to it from the Instance MID
	 * that contains them.
	 * 
	 * @param isFullDelete
	 *            True if this model endpoint is going to be fully deleted,
	 *            false if it is going to be replaced later.
	 * @throws MMTFException
	 *             If this model endpoint is at the TYPES level.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isFullDeleteRequired="true"
	 * @generated
	 */
	void deleteInstanceAndReference(boolean isFullDelete) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Replaces an old model endpoint and the reference to it with new ones in
	 * an Instance MID.
	 * 
	 * @param oldModelEndpoint
	 *            The old model endpoint to be replaced.
	 * @param newModel
	 *            The new model that is the target of the new model endpoint.
	 * @throws MMTFException
	 *             If this model endpoint is at the INSTANCES level, or if a
	 *             user-defined model endpoint is being replaced with a native
	 *             one.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" oldModelEndpointRequired="true" newModelRequired="true"
	 * @generated
	 */
	void replaceInstanceAndReference(ModelEndpoint oldModelEndpoint, Model newModel) throws MMTFException;

} // ModelEndpoint
