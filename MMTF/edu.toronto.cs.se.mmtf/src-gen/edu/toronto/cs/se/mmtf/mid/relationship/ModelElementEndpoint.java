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
	 * <!-- begin-user-doc --> Creates and adds a reference to this model
	 * element type endpoint to the Type MID.
	 * 
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type reference container.
	 * @param targetModelElemTypeRef
	 *            The reference to the model element type that is the target of
	 *            the model element type endpoint.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced model element type endpoint, false otherwise.
	 * @param isBinarySrc
	 *            True if the referenced model element type endpoint is the
	 *            source in the binary link type reference container, false
	 *            otherwise.
	 * @param containerLinkTypeRef
	 *            The reference to the link type that will contain the new
	 *            reference to the model element type endpoint.
	 * @return The created reference to the model element type endpoint.
	 * @throws MMTFException
	 *             If this is a model element instance endpoint.
	 *             <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        targetModelElemTypeRefRequired="true" isModifiableRequired="true"
	 *        isBinarySrcRequired="true" containerLinkTypeRefRequired="true"
	 * @generated
	 */
	ModelElementEndpointReference createTypeReference(ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference targetModelElemTypeRef, boolean isModifiable, boolean isBinarySrc, LinkReference containerLinkTypeRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this model element
	 * type endpoint and a reference to it to the Type MID.
	 * 
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the new model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type container.
	 * @param newModelElemTypeEndpointName
	 *            The name of the new model element type endpoint.
	 * @param targetModelElemTypeRef
	 *            The reference to the model element type that is the target of
	 *            the new model element type endpoint.
	 * @param isBinarySrc
	 *            True if the model element type endpoint is the source in the
	 *            binary link type container, false otherwise.
	 * @param containerLinkTypeRef
	 *            The reference to the link type that will contain the new model
	 *            element type endpoint.
	 * @return The created reference to the new model element type endpoint.
	 * @throws MMTFException
	 *             If this is a model element instance endpoint, or if the uri
	 *             of the new model element type endpoint is already registered
	 *             in the Type MID. <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        newModelElemTypeEndpointNameRequired="true"
	 *        targetModelElemTypeRefRequired="true" isBinarySrcRequired="true"
	 *        containerLinkTypeRefRequired="true"
	 * @generated
	 */
	ModelElementEndpointReference createSubtypeAndReference(ModelElementEndpointReference modelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, boolean isBinarySrc, LinkReference containerLinkTypeRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Replaces an old subtype of this model element
	 * type endpoint and a reference to it with new ones in the Type MID.
	 * 
	 * @param oldModelElemTypeEndpointRef
	 *            The reference to the old model element type endpoint to be
	 *            replaced.
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the new model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type container.
	 * @param newModelElemTypeEndpointName
	 *            The name of the new model element type endpoint.
	 * @param targetModelElemTypeRef
	 *            The reference to the model element type that is the target of
	 *            the new model element type endpoint.
	 * @param containerLinkTypeRef
	 *            The reference to the link type that will contain the new model
	 *            element type endpoint.
	 * @throws MMTFException
	 *             If this is a model element instance endpoint, or if the uri
	 *             of the new model element type endpoint is already registered
	 *             in the Type MID. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        oldModelElemTypeEndpointRefRequired="true"
	 *        newModelElemTypeEndpointNameRequired="true"
	 *        targetModelElemTypeRefRequired="true"
	 *        containerLinkTypeRefRequired="true"
	 * @generated
	 */
	void replaceSubtypeAndReference(ModelElementEndpointReference oldModelElemTypeEndpointRef, ModelElementEndpointReference modelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, LinkReference containerLinkTypeRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a reference to this model
	 * element instance endpoint to an Instance MID.
	 * 
	 * @param targetModelElemRef
	 *            The reference to the model element that is the target of the
	 *            model element endpoint.
	 * @param isBinarySrc
	 *            True if the reference to the model element endpoint is the
	 *            source in the binary link reference container, false
	 *            otherwise.
	 * @param containerLinkRef
	 *            The reference to the link that will contain the new reference
	 *            to the model element endpoint.
	 * @return The created reference to the model element endpoint.
	 * @throws MMTFException
	 *             If this is a model element type endpoint.
	 *             <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        targetModelElemRefRequired="true" isBinarySrcRequired="true"
	 *        containerLinkRefRequired="true"
	 * @generated
	 */
	ModelElementEndpointReference createInstanceReference(ModelElementReference targetModelElemRef, boolean isBinarySrc, LinkReference containerLinkRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a model element instance
	 * endpoint of this model element type endpoint and the reference to it to
	 * an Instance MID.
	 * 
	 * @param targetModelElemRef
	 *            The reference to the model element that is the target of the
	 *            new model element endpoint.
	 * @param isBinarySrc
	 *            True if the model element endpoint is the source in the binary
	 *            link container, false otherwise.
	 * @param containerLinkRef
	 *            The reference to the link that will contain the new model
	 *            element endpoint.
	 * @return The created reference to the new model element endpoint.
	 * @throws MMTFException
	 *             If this is a model element instance endpoint.
	 *             <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        targetModelElemRefRequired="true" isBinarySrcRequired="true"
	 *        containerLinkRefRequired="true"
	 * @generated
	 */
	ModelElementEndpointReference createInstanceAndReference(ModelElementReference targetModelElemRef, boolean isBinarySrc, LinkReference containerLinkRef) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Replaces an old model element instance endpoint
	 * and the reference to it with new ones in an Instance MID.
	 * 
	 * @param oldModelElemEndpointRef
	 *            The reference to the old model element endpoint to be
	 *            replaced.
	 * @param targetModelElemRef
	 *            The reference to the model element that is the target of the
	 *            new model element endpoint.
	 * @throws MMTFException
	 *             If this is a model element instance endpoint. <!--
	 *             end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        oldModelElemEndpointRefRequired="true"
	 *        targetModelElemRefRequired="true"
	 * @generated
	 */
	void replaceInstanceAndReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementReference targetModelElemRef) throws MMTFException;

} // ModelElementEndpoint
