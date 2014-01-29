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
package edu.toronto.cs.se.mmtf.mid.relationship;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A link type among model element types or a link instance among model element instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#getModelElemEndpoints <em>Model Elem Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.Link#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of model element endpoints.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elem Endpoints</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getLink_ModelElemEndpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementEndpoint> getModelElemEndpoints();

	/**
	 * Returns the value of the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to model element endpoints. This is different from the list of model element endpoints because it includes inherited endpoints too.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elem Endpoint Refs</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getLink_ModelElemEndpointRefs()
	 * @model
	 * @generated
	 */
	EList<ModelElementEndpointReference> getModelElemEndpointRefs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the link type of this link instance.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (Link) metatype;'"
	 * @generated
	 */
	Link getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the link supertype of this link type.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (Link) supertype;'"
	 * @generated
	 */
	Link getSupertype();

	/**
	 * <!-- begin-user-doc --> Creates and adds a reference to this link type to
	 * the Type MID.
	 * 
	 * @param linkTypeRef
	 *            The reference to the supertype of the link type, null if
	 *            such reference doesn't exist in the model relationship type
	 *            container.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced link type, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new
	 *            reference to the link type.
	 * @return The created reference to the link type.
	 * @throws MMTFException
	 *             If this is a link instance. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isModifiableRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	LinkReference createTypeReference(LinkReference linkTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this link type and
	 * a reference to it to the Type MID.
	 * 
	 * @param linkTypeRef
	 *            The reference to the supertype of the new link type, null if
	 *            such reference doesn't exist in the model relationship type
	 *            container.
	 * @param newLinkTypeName
	 *            The name of the new link type.
	 * @param isBinary
	 *            True if the new link type is binary, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new link
	 *            type.
	 * @return The created reference to the new link type.
	 * @throws MMTFException
	 *             If this is a link instance, or if the uri of the new link
	 *             type is already registered in the Type MID.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newLinkTypeNameRequired="true" isBinaryRequired="true" containerModelRelTypeRequired="true"
	 * @generated
	 */
	LinkReference createSubtypeAndReference(LinkReference linkTypeRef, String newLinkTypeName, boolean isBinary, ModelRel containerModelRelType) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Deletes this link type from the Type MID.
	 * 
	 * @throws MMTFException
	 *             If this is a link instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteType() throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a reference to this link
	 * instance to an Instance MID.
	 * 
	 * @param containerModelRel
	 *            The model relationship that will contain the new reference to
	 *            the link.
	 * @return The created reference to the link.
	 * @throws MMTFException
	 *             If this is a link type. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" containerModelRelRequired="true"
	 * @generated
	 */
	LinkReference createInstanceReference(ModelRel containerModelRel) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a link instance of this link
	 * type and a reference to it to an Instance MID.
	 * 
	 * @param isBinary
	 *            True if the new link is binary, false otherwise.
	 * @param containerModelRel
	 *            The model relationship that will contain the new link.
	 * @return The created reference to the new link.
	 * @throws MMTFException
	 *             If this is a link instance. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isBinaryRequired="true" containerModelRelRequired="true"
	 * @generated
	 */
	LinkReference createInstanceAndReference(boolean isBinary, ModelRel containerModelRel) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a link instance of this link
	 * type and a reference to it to an Instance MID, together with its model
	 * element instance endpoints and references to them.
	 * 
	 * @param isBinary
	 *            True if the new link is binary, false otherwise.
	 * @param targetModelElemRefs
	 *            The references to the model elements that are the target of
	 *            the new model element endpoints.
	 * @return The created reference to the new link.
	 * @throws MMTFException
	 *             If this is a link instance, or if no target references to
	 *             model elements are specified. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isBinaryRequired="true" targetModelElemRefsRequired="true" targetModelElemRefsMany="true"
	 * @generated
	 */
	LinkReference createInstanceAndReferenceAndEndpointsAndReferences(boolean isBinary, EList<ModelElementReference> targetModelElemRefs) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Deletes this link instance from the Instance MID
	 * that contains it.
	 * 
	 * @throws MMTFException
	 *             If this is a link type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteInstance() throws MMTFException;

} // Link
