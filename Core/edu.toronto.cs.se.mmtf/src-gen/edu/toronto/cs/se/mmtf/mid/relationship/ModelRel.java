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
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model relationship type among model types or a model relationship instance among model instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModelEndpoints <em>Model Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getLinks <em>Links</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getModelEndpointRefs <em>Model Endpoint Refs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelRel#getLinkRefs <em>Link Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelRel()
 * @model
 * @generated
 */
public interface ModelRel extends Model {
	/**
	 * Returns the value of the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.ModelEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of model endpoints.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Endpoints</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelRel_ModelEndpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelEndpoint> getModelEndpoints();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.Link}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of links among model elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelRel_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to model endpoints. This is different from the list of model endpoints because it includes inherited endpoints too.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Endpoint Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelRel_ModelEndpointRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelEndpointReference> getModelEndpointRefs();

	/**
	 * Returns the value of the '<em><b>Link Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to links. This is different from the list of links because it includes inherited links too.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelRel_LinkRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<LinkReference> getLinkRefs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model relationship type of this model relationship instance.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (ModelRel) metatype;'"
	 * @generated
	 */
	ModelRel getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model relationship supertype of this model relationship type.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (Model) supertype;'"
	 * @generated
	 */
	Model getSupertype();

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this model
	 * relationship type to the Type MID.
	 * 
	 * @param newModelRelTypeName
	 *            The name of the new model relationship type.
	 * @param isBinary
	 *            True if the new model relationship type is binary, false
	 *            otherwise.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model relationship type, null if no constraint is
	 *            associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model relationship type, null if no constraint is
	 *            associated.
	 * @return The created model relationship type.
	 * @throws MMTFException
	 *             If this is a model relationship instance, or if the uri of
	 *             the new model relationship type is already registered in the
	 *             Type MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelRelTypeNameRequired="true" isBinaryRequired="true"
	 * @generated
	 */
	ModelRel createSubtype(String newModelRelTypeName, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this model
	 * relationship type to the Type MID, copying its structure from another
	 * model relationship type.
	 * 
	 * @param origModelRelType
	 *            The original model relationship type to be copied into the new
	 *            one.
	 * @return The created model relationship type.
	 * @throws MMTFException
	 *             If this is a model relationship instance, or if any of the
	 *             uris of the components of the new model relationship type are
	 *             already registered in the Type MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" origModelRelTypeRequired="true"
	 * @generated
	 */
	ModelRel copySubtype(ModelRel origModelRelType) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Deletes this model relationship type from the
	 * Type MID.
	 * 
	 * @throws MMTFException
	 *             If this is a model relationship instance.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteType() throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Gets the transformation operator based on this
	 * model relationship type.
	 * 
	 * @param srcModel
	 *            The source model to be transformed through the model
	 *            relationship type.
	 * @return The transformation operator.
	 * @throws MMTFException
	 *             If this is a model relationship instance, if this model
	 *             relationship type doesn't satisfy the transformation
	 *             constraint, or if the source model is not allowed by this
	 *             model relationship type. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" srcModelRequired="true"
	 * @generated
	 */
	ConversionOperator getTypeTransformationOperator(Model srcModel) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a model relationship
	 * instance of this model relationship type to an Instance MID.
	 * 
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model
	 *            relationship is not in a separate file; e.g. a standalone
	 *            model relationship is in its own files, a plain model
	 *            relationship is not.
	 * @param isBinary
	 *            True if the new model relationship is binary, false otherwise.
	 * @param origin
	 *            The origin of the new model relationship.
	 * @param containerMultiModel
	 *            An Instance MID, null if the model relationship isn't going to
	 *            be added to it.
	 * @return The created model relationship.
	 * @throws MMTFException
	 *             If this is a model relationship instance, or if the uri of
	 *             the new model relationship is already registered in the
	 *             Instance MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isBinaryRequired="true" originRequired="true"
	 * @generated
	 */
	ModelRel createInstance(String newModelRelUri, boolean isBinary, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a model relationship instance of
	 * this model relationship type to an Instance MID, together with its model
	 * instance endpoints and references to them.
	 * 
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model
	 *            relationship is not in a separate file; e.g. a standalone
	 *            model relationship is in its own files, a plain model
	 *            relationship is not.
	 * @param isBinary
	 *            True if the new model relationship is binary, false otherwise.
	 * @param origin
	 *            The origin of the new model relationship.
	 * @param targetModels
	 *            The models that are the target of the new model endpoints.
	 * @return The created model relationship.
	 * @throws MMTFException
	 *             If this is a model relationship instance, if no target models
	 *             are specified, or if the uri of the new model relationship is
	 *             already registered in the Instance MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" isBinaryRequired="true" originRequired="true" targetModelsRequired="true" targetModelsMany="true"
	 * @generated
	 */
	ModelRel createInstanceAndEndpointsAndReferences(String newModelRelUri, boolean isBinary, ModelOrigin origin, EList<Model> targetModels) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->Creates and adds a model relationship instance of
	 * this model relationship type to an Instance MID, copying its structure
	 * from another model relationship instance (including any MAVO flags).
	 * 
	 * @param origModelRel
	 *            The original model relationship instance to be copied into the
	 *            new one.
	 * @param containerMultiModel
	 *            An Instance MID, null if the model relationship isn't going to
	 *            be added to it.
	 * @return The created model relationship.
	 * @throws MMTFException
	 *             If this is a model relationship instance, or if the uri of
	 *             the new model relationship is already registered in the
	 *             Instance MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" origModelRelRequired="true" containerMultiModelRequired="true"
	 * @generated
	 */
	ModelRel copyMAVOInstance(ModelRel origModelRel, MultiModel containerMultiModel) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Deletes this model relationship instance from the
	 * Instance MID that contains it.
	 * 
	 * @throws MMTFException
	 *             If this is a model relationship type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteInstance() throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Opens this editor type.
	 * 
	 * @throws MMTFException
	 *             If this is an editor instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void openType() throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Opens this editor instance.
	 * 
	 * @throws MMTFException
	 *             If this is an editor type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void openInstance() throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Gets the model type resources to be used in the
	 * Relationship diagram outline for this model relationship type.
	 * 
	 * @throws MMTFException
	 *             If this is a model relationship instance.
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	ResourceSet getOutlineResourceTypes() throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Gets the model instance resources to be used in
	 * the Relationship diagram outline for this model relationship instance.
	 * 
	 * @throws MMTFException
	 *             If this is a model relationship type. <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	ResourceSet getOutlineResourceInstances() throws MMTFException;

} // ModelRel
