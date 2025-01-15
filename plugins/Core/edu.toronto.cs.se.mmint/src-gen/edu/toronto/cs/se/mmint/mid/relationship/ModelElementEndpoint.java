/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The model element endpoint for a mapping.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelElementEndpoint()
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
   * @generated
   */
    ModelElementEndpoint getSupertype();

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
    MID getMIDContainer();

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * {@inheritDoc}<br />
   * Gets the model element target of this model element endpoint.
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
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
   * @generated
   */
    ModelElementEndpoint getMetatype();

    /**
   * <!-- begin-user-doc --> Creates and adds a reference to this model element type endpoint to the Type MID.
     * 
     * @param modelElemTypeEndpointRef
     *            The reference to the supertype of the model element type endpoint, null if such reference doesn't
     *            exist in the mapping type reference container.
     * @param targetModelElemTypeRef
     *            The reference to the model element type that is the target of the model element type endpoint.
     * @param isModifiable
     *            True if the new reference will allow modifications of the referenced model element type endpoint,
     *            false otherwise.
     * @param isBinarySrc
     *            (Only for a binary mapping type reference container) True if the referenced model element type
     *            endpoint is the source in the binary mapping type reference container, false otherwise.
     * @param containerMappingTypeRef
     *            The reference to the mapping type that will contain the new reference to the model element type
     *            endpoint.
     * @return The created reference to the model element type endpoint.
     * @throws MMINTException
     *             If this is a model element instance endpoint. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" targetModelElemTypeRefRequired="true" isModifiableRequired="true" isBinarySrcRequired="true" containerMappingTypeRefRequired="true"
   * @generated
   */
    ModelElementEndpointReference createTypeReference(ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference targetModelElemTypeRef, boolean isModifiable, boolean isBinarySrc, MappingReference containerMappingTypeRef) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Creates and adds a subtype of this model element type endpoint and a reference to it to
     * the Type MID.
     * 
     * @param newModelElemTypeEndpointName
     *            The name of the new model element type endpoint.
     * @param targetModelElemTypeRef
     *            The reference to the model element type that is the target of the new model element type endpoint.
     * @param isBinarySrc
     *            (Only for a binary mapping type container) True if the model element type endpoint is the source in
     *            the binary mapping type container, false otherwise.
     * @param containerMappingTypeRef
     *            The reference to the mapping type that will contain the new model element type endpoint.
     * @return The created reference to the new model element type endpoint.
     * @throws MMINTException
     *             If this is a model element instance endpoint, if the container mapping type is binary and has already
     *             2 model element type endpoints, if the container mapping type is binary and there would be an invalid
     *             overriding of this model element type endpoint, or if the uri of the new model element type endpoint
     *             is already registered in the Type MID. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelElemTypeEndpointNameRequired="true" targetModelElemTypeRefRequired="true" isBinarySrcRequired="true" containerMappingTypeRefRequired="true"
   * @generated
   */
    ModelElementEndpointReference createSubtypeAndReference(String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef, boolean isBinarySrc, MappingReference containerMappingTypeRef) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Replaces an old subtype of this model element
     * type endpoint and a reference to it with new ones in the Type MID.
     * 
     * @param oldModelElemTypeEndpointRef
     *            The reference to the old model element type endpoint to be
     *            replaced.
     * @param newModelElemTypeEndpointName
     *            The name of the new model element type endpoint.
     * @param targetModelElemTypeRef
     *            The reference to the model element type that is the target of
     *            the new model element type endpoint.
     * @throws MMINTException
     *             If this is a model element instance endpoint, if the
     *             container mapping type is binary and there would be an invalid
     *             overriding of this model element type endpoint, or if the uri
     *             of the new model element type endpoint is already registered
     *             in the Type MID. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" oldModelElemTypeEndpointRefRequired="true" newModelElemTypeEndpointNameRequired="true" targetModelElemTypeRefRequired="true"
   * @generated
   */
    void replaceSubtypeAndReference(ModelElementEndpointReference oldModelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference targetModelElemTypeRef) throws MMINTException;

    /**
   * <!-- begin-user-doc -->
     * Removes a model element type endpoint from the MID that contains
     * it.
     * 
     * @param modelElemTypeEndpoint
     *            The model element type endpoint to be removed.
     * @param isFullRemove
     *            True if the model element type endpoint is going to be fully
     *            removed, false if it is going to be replaced later.
     * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
   * @generated
   */
    void deleteType(boolean isFullDelete) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Creates and adds a reference to this model element instance endpoint to an Instance MID.
     * 
     * @param targetModelElemRef
     *            The reference to the model element that is the target of the model element endpoint.
     * @param containerMappingRef
     *            The reference to the mapping that will contain the new reference to the model element endpoint.
     * @return The created reference to the model element endpoint.
     * @throws MMINTException
     *             If this is a model element type endpoint. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" targetModelElemRefRequired="true" containerMappingRefRequired="true"
   * @generated
   */
    ModelElementEndpointReference createInstanceReference(ModelElementReference targetModelElemRef, MappingReference containerMappingRef) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Creates and adds a model element instance endpoint of this model element type endpoint
     * and the reference to it to an Instance MID.
     * 
     * @param targetModelElemRef
     *            The reference to the model element that is the target of the new model element endpoint.
     * @param containerMappingRef
     *            The reference to the mapping that will contain the new model element endpoint.
     * @return The created reference to the new model element endpoint.
     * @throws MMINTException
     *             If this is a model element instance endpoint, or if the container mapping is binary and has already 2
     *             model element endpoints. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" targetModelElemRefRequired="true" containerMappingRefRequired="true"
   * @generated
   */
    ModelElementEndpointReference createInstanceAndReference(ModelElementReference targetModelElemRef, MappingReference containerMappingRef) throws MMINTException;

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
     * @throws MMINTException
     *             If this is a model element instance endpoint. <!--
     *             end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" oldModelElemEndpointRefRequired="true" targetModelElemRefRequired="true"
   * @generated
   */
    void replaceInstanceAndReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementReference targetModelElemRef) throws MMINTException;

} // ModelElementEndpoint
