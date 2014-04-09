/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;


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
 * @see edu.toronto.cs.se.mmint.mid.MidPackage#getModelEndpoint()
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
	 * <!-- begin-user-doc --> Creates and adds a reference to this model type
	 * endpoint to the Type MID.
	 * 
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced model type endpoint, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new
	 *            reference to the model type endpoint.
	 * @return The created reference to the model type endpoint.
	 * @throws MMINTException
	 *             If this is a model instance endpoint. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isModifiableRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	ModelEndpointReference createTypeReference(boolean isModifiable, ModelRel containerModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this model type
	 * endpoint and a reference to it to the Type MID.
	 * 
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param targetModelType
	 *            The model type that is the target of the new model type
	 *            endpoint.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the new model type endpoint.
	 * @throws MMINTException
	 *             If this is a model instance endpoint, if the container model
	 *             relationship type is binary and has already 2 model type
	 *             endpoints, or if the uri of the new model type endpoint is
	 *             already registered in the Type MID. <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 *        newModelTypeEndpointNameRequired="true"
	 *        targetModelTypeRequired="true"
	 *        containerModelRelTypeRequired="true"
	 * @generated
	 */
	ModelEndpointReference createSubtypeAndReference(String newModelTypeEndpointName, Model targetModelType, ModelRel containerModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Replaces an old subtype of this model type
	 * endpoint and a reference to it with new ones in the Type MID.
	 * 
	 * @param oldModelTypeEndpoint
	 *            The old model type endpoint to be replaced.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param targetModelType
	 *            The model type that is the target of the new model type
	 *            endpoint.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @throws MMINTException
	 *             If this is a model instance endpoint, or if the uri of the
	 *             new model type endpoint is already registered in the Type
	 *             MID. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" oldModelTypeEndpointRequired="true" newModelTypeEndpointNameRequired="true" targetModelTypeRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	void replaceSubtypeAndReference(ModelEndpoint oldModelTypeEndpoint, String newModelTypeEndpointName, Model targetModelType, ModelRel containerModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes this model type endpoint and all
	 * references to it from the Type MID.
	 * 
	 * @param isFullDelete
	 *            True if this model type endpoint is going to be fully deleted,
	 *            false if it is going to be replaced later.
	 * @throws MMINTException
	 *             If this is a model endpoint instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
	 * @generated
	 */
	void deleteTypeAndReference(boolean isFullDelete) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a reference to this model
	 * instance endpoint to an Instance MID.
	 * 
	 * @param containerModelRel
	 *            The model relationship that will contain the new reference to
	 *            the model endpoint.
	 * @return The created reference to the model endpoint.
	 * @throws MMINTException
	 *             If this is a model type endpoint. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" containerModelRelRequired="true"
	 * @generated
	 */
	ModelEndpointReference createInstanceReference(ModelRel containerModelRel) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a model instance endpoint of
	 * this model endpoint type and the reference to it to an Instance MID.
	 * 
	 * @param targetModel
	 *            The model that is the target of the new model endpoint.
	 * @param containerModelRel
	 *            The model relationship that will contain the new model
	 *            endpoint.
	 * @return The created reference to the new model endpoint.
	 * @throws MMINTException
	 *             If this is a model instance endpoint, or if the container
	 *             model relationship is binary and has already 2 model
	 *             endpoints. <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 *        targetModelRequired="true" containerModelRelRequired="true"
	 * @generated
	 */
	ModelEndpointReference createInstanceAndReference(Model targetModel, ModelRel containerModelRel) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes this model instance endpoint and the
	 * reference to it from the Instance MID that contains them.
	 * 
	 * @param isFullDelete
	 *            True if this model endpoint is going to be fully deleted,
	 *            false if it is going to be replaced later.
	 * @throws MMINTException
	 *             If this is a model type endpoint, or if there is no model
	 *             endpoint reference corresponding to this model endpoint.
	 *             <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
	 * @generated
	 */
	void deleteInstanceAndReference(boolean isFullDelete) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Replaces an old model instance endpoint and the
	 * reference to it with new ones in an Instance MID.
	 * 
	 * @param oldModelEndpoint
	 *            The old model endpoint to be replaced.
	 * @param targetModel
	 *            The model that is the target of the new model endpoint.
	 * @param containerModelRel
	 *            The model relationship that will contain the new model
	 *            endpoint.
	 * @throws MMINTException
	 *             If this is a model instance endpoint, or if a user-defined
	 *             model endpoint is being replaced with a native one.
	 *             <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" oldModelEndpointRequired="true" targetModelRequired="true" containerModelRelRequired="true"
	 * @generated
	 */
	void replaceInstanceAndReference(ModelEndpoint oldModelEndpoint, Model targetModel, ModelRel containerModelRel) throws MMINTException;

} // ModelEndpoint
