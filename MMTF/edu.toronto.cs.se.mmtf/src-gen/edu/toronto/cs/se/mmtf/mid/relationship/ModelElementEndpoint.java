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
package edu.toronto.cs.se.mmtf.mid.relationship;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The model element endpoint for a link.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelElementEndpoint()
 * @model
 * @generated
 */
public interface ModelElementEndpoint extends ExtendibleElementEndpoint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model element supertype endpoint of this model element type endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpoint supertype = super.getSupertype();\nreturn (supertype == null) ? null : (ModelElementEndpoint) supertype;'"
	 * @generated
	 */
	ModelElementEndpoint getSupertype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model element target of this model element endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement target = super.getTarget();\nreturn (target == null) ? null : (ModelElement) target;'"
	 * @generated
	 */
	ModelElement getTarget();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model element type endpoint of this model element instance endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpoint metatype = super.getMetatype();\nreturn (metatype == null) ? null : (ModelElementEndpoint) metatype;'"
	 * @generated
	 */
	ModelElementEndpoint getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * Creates and adds a model element type endpoint reference to a link type
	 * reference.
	 * 
	 * @param newModelElemTypeEndpoint
	 *            The new model element type endpoint for which the reference
	 *            has to be created.
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the new model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type reference container.
	 * @param newModelElemTypeRef
	 *            The new reference to the model element type that is the target
	 *            of the new model element type endpoint.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced model element type endpoint, false otherwise.
	 * @param isBinarySrc
	 *            True if the referenced model element type endpoint is the
	 *            source in the binary link type reference container, false
	 *            otherwise.
	 * @param linkTypeRef
	 *            The reference to the link type that will contain the new
	 *            reference to the model element type endpoint.
	 * @return The created reference to the new model element type endpoint.
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" targetModelElemTypeRefRequired="true" isModifiableRequired="true" isBinarySrcRequired="true" containerLinkTypeRefRequired="true"
	 * @generated
	 */
	ModelElementEndpointReference createTypeReference(ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference targetModelElemTypeRef, boolean isModifiable, boolean isBinarySrc, LinkReference containerLinkTypeRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Creates and adds a "light" model element type endpoint and a reference to
	 * it to the Type MID.
	 * 
	 * @param modelElemTypeEndpoint
	 *            The supertype of the new model element type endpoint.
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the new model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type container.
	 * @param newModelElemTypeEndpointName
	 *            The name of the new model element type endpoint.
	 * @param newModelElemTypeRef
	 *            The reference to the new model element type that is the target
	 *            of the new model element type endpoint.
	 * @param isBinarySrc
	 *            True if the model element type endpoint is the source in the
	 *            binary link type container, false otherwise.
	 * @param linkTypeRef
	 *            The reference to the link type that will contain the new model
	 *            element type endpoint.
	 * @return The created reference to the model element type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model element type endpoint is already
	 *             registered in the Type MID.
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelElemTypeEndpointNameRequired="true" targetModelElemTypeRefRequired="true" isBinarySrcRequired="true" containerLinkTypeRefRequired="true"
	 * @generated
	 */
	ModelElementEndpointReference createSubtypeAndReference(ModelElementEndpointReference modelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, boolean isBinarySrc, LinkReference containerLinkTypeRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Replaces an old "light" model element type endpoint and a reference to it
	 * with new ones in the Type MID.
	 * 
	 * @param oldModelElemTypeEndpointRef
	 *            The reference to the old model element type endpoint to be
	 *            replaced.
	 * @param modelElemTypeEndpoint
	 *            The supertype of the new model element type endpoint.
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the new model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type container.
	 * @param newModelElemTypeEndpointName
	 *            The name of the new model element type endpoint.
	 * @param newModelElemTypeRef
	 *            The reference to the new model element type that is the target
	 *            of the new model element type endpoint.
	 * @param linkTypeRef
	 *            The reference to the link type that will contain the new model
	 *            element type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model element type endpoint is already
	 *             registered in the Type MID.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" oldModelElemTypeEndpointRefRequired="true" newModelElemTypeEndpointNameRequired="true" targetModelElemTypeRefRequired="true" containerLinkTypeRefRequired="true"
	 * @generated
	 */
	void replaceSubtypeAndReference(ModelElementEndpointReference oldModelElemTypeEndpointRef, ModelElementEndpointReference modelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, LinkReference containerLinkTypeRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isBinarySrcRequired="true" containerLinkRefRequired="true"
	 * @generated
	 */
	ModelElementEndpointReference createInstanceReference(boolean isBinarySrc, LinkReference containerLinkRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" targetModelElemRefRequired="true" isBinarySrcRequired="true" containerLinkRefRequired="true"
	 * @generated
	 */
	ModelElementEndpointReference createInstanceAndReference(ModelElementReference targetModelElemRef, boolean isBinarySrc, LinkReference containerLinkRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" oldModelElemEndpointRefRequired="true" targetModelElemRefRequired="true"
	 * @generated
	 */
	void replaceInstanceAndReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementReference targetModelElemRef) throws MMTFException;

} // ModelElementEndpoint
