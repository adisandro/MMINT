/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to a model element endpoint.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getModelElemRef <em>Model Elem Ref</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelElementEndpointReference()
 * @model
 * @generated
 */
public interface ModelElementEndpointReference extends ExtendibleElementEndpointReference {
    /**
     * Returns the value of the '<em><b>Model Elem Ref</b></em>' reference.
     * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The reference to the endpoint target model element.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Model Elem Ref</em>' reference.
     * @see #setModelElemRef(ModelElementReference)
     * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelElementEndpointReference_ModelElemRef()
     * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getModelElemEndpointRefs
     * @model opposite="modelElemEndpointRefs" required="true"
     * @generated
     */
    ModelElementReference getModelElemRef();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getModelElemRef <em>Model Elem Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Model Elem Ref</em>' reference.
     * @see #getModelElemRef()
     * @generated
     */
    void setModelElemRef(ModelElementReference value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * {@inheritDoc}<br />
     * Gets the referenced model element endpoint.
     * <!-- end-model-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpoint object = super.getObject();\nreturn (object == null) ? null : (ModelElementEndpoint) object;'"
     * @generated
     */
    ModelElementEndpoint getObject();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * {@inheritDoc}<br />
     * Gets the model element supertype endpoint reference of this model element type endpoint reference.
     * <!-- end-model-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpointReference supertypeRef = super.getSupertypeRef();\nreturn (supertypeRef == null) ? null : (ModelElementEndpointReference) supertypeRef;'"
     * @generated
     */
    ModelElementEndpointReference getSupertypeRef();

    /**
     * <!-- begin-user-doc --> Deletes this reference to a model element type
     * endpoint from the Type MID.
     * 
     * @param isFullDelete
     *            True if the reference to the model element type endpoint is
     *            going to be fully removed, false if it is going to be replaced
     *            later.
     * @throws MMINTException
     *             If this is a reference to a model element instance endpoint.
     *             <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
     * @generated
     */
    void deleteTypeReference(boolean isFullDelete) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this referenced model element type
     * endpoint and all references to it from the Type MID.
     * 
     * @param isFullDelete
     *            True if the model element type endpoint is going to be fully
     *            removed, false if it is going to be replaced later.
     * @throws MMINTException
     *             If this is a reference to a model element instance endpoint.
     *             <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
     * @generated
     */
    void deleteTypeAndReference(boolean isFullDelete) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this referenced model element instance
     * endpoint and the reference to it from the Instance MID that contains
     * them.
     * 
     * @param isFullDelete
     *            True if the model element endpoint is going to be fully
     *            removed, false if it is going to be replaced later.
     * @throws MMINTException
     *             If this is a reference to a model element type endpoint.
     *             <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
     * @generated
     */
    void deleteInstanceAndReference(boolean isFullDelete) throws MMINTException;

} // ModelElementEndpointReference
