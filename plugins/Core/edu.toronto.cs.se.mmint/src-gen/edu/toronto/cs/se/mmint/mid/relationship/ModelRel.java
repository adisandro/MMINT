/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;

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
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getModelEndpoints <em>Model Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMappings <em>Mappings</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getModelEndpointRefs <em>Model Endpoint Refs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMappingRefs <em>Mapping Refs</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel()
 * @model
 * @generated
 */
public interface ModelRel extends Model {
	/**
	 * Returns the value of the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.ModelEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of model endpoints.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Endpoints</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel_ModelEndpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelEndpoint> getModelEndpoints();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of mappings among model elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to model endpoints. This is different from the list of model endpoints because it includes inherited endpoints too.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Endpoint Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel_ModelEndpointRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelEndpointReference> getModelEndpointRefs();

	/**
	 * Returns the value of the '<em><b>Mapping Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to mappings. This is different from the list of mappings because it includes inherited mappings too.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel_MappingRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingReference> getMappingRefs();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (MID) this.eContainer();'"
	 * @generated
	 */
	MID getMIDContainer();

	/**
	 * <!-- begin-user-doc --> Creates and adds a binary subtype of this model relationship type to the Type MID.
	 * 
	 * @param newModelRelTypeName
	 *            The name of the new model relationship type.
	 * @param isMetamodelExtension
	 *            Not used.
	 * @return The created binary model relationship type.
	 * @throws MMINTException
	 *             If this is a not model relationship type, or if the uri of the new model relationship type is already
	 *             registered in the Type MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelTypeNameRequired="true" isMetamodelExtensionRequired="true"
	 * @generated
	 */
	BinaryModelRel createBinarySubtype(String newModelRelTypeName, boolean isMetamodelExtension) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this model relationship type to the Type MID, copying its
	 * structure from another model relationship type.
	 * 
	 * @param origModelRelType
	 *            The original model relationship type to be copied into the new one.
	 * @return The created model relationship type.
	 * @throws MMINTException
	 *             If this is not a model relationship type, or if any of the uris of the components of the new model
	 *             relationship type are already registered in the Type MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" origModelRelTypeRequired="true"
	 * @generated
	 */
	ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the model type resources to be used in the Relationship diagram outline for this
	 * model relationship type.
	 * 
	 * @throws MMINTException
	 *             If this is not a model relationship type. <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	ResourceSet getOutlineResourceTypes() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds an instance of this model relationship type to an Instance MID,
	 * together with its model instance endpoints.
	 * <p>
	 * (Support for model relationships in their own ECore file is future work, i.e. rootModelRelObj is always null)
	 * <p>
	 * Can be invoked in 2 ways:
	 * <ol>
	 * <li>(null, str, models, null) model rel file not created, model rel not added to the MID;
	 * <li>(null, str, models, mid) model rel file not created, model rel added to the MID;
	 * </ol>
	 * </p>
	 * 
	 * @param rootModelRelObj
	 *            Always considered to be null.
	 * @param newModelRelName
	 *            The name for the model relationship.
	 * @param endpointModels
	 *            The endpoint models.
	 * @param instanceMID
	 *            An Instance MID. Can be null if the model relationship is not going to be contained in one.
	 * @return The created model relationship.
	 * @throws MMINTException
	 *             If this is not a model relationship type, or no endpoint models are specified. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelNameRequired="true" endpointModelsRequired="true" endpointModelsMany="true"
	 * @generated
	 */
	ModelRel createInstanceAndEndpoints(EObject rootModelRelObj, String newModelRelName, EList<Model> endpointModels, MID instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a binary instance of this model relationship type to an
	 * Instance MID, together with its model instance endpoints.
	 * <p>
	 * (Support for model relationships in their own ECore file is future work, i.e. rootModelRelObj is always null)
	 * <p>
	 * Can be invoked in 2 ways:
	 * <ol>
	 * <li>(null, str, null) model rel file not created, model rel not added to the MID;
	 * <li>(null, str, mid) model rel file not created, model rel added to the MID;
	 * </ol>
	 * </p>
	 * 
	 * @param rootModelRelObj
	 *            Always considered to be null.
	 * @param newModelRelName
	 *            The name for the model relationship.
	 * @param instanceMID
	 *            An Instance MID. Can be null if the model relationship is not going to be contained in one.
	 * @return The created binary model relationship.
	 * @throws MMINTException
	 *             If this is not a model relationship type. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelNameRequired="true"
	 * @generated
	 */
	BinaryModelRel createBinaryInstance(EObject rootModelRelObj, String newModelRelName, MID instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a binary instance of this model relationship type to an
	 * Instance MID, together with its model instance endpoints.
	 * <p>
	 * (Support for model relationships in their own ECore file is future work, i.e. rootModelRelObj is always null)
	 * <p>
	 * Can be invoked in 2 ways:
	 * <ol>
	 * <li>(null, str, model, model, null) model rel file not created, model rel not added to the MID;
	 * <li>(null, str, model, model, mid) model rel file not created, model rel added to the MID;
	 * </ol>
	 * </p>
	 * 
	 * @param rootModelRelObj
	 *            Always considered to be null.
	 * @param newModelRelName
	 *            The name for the model relationship.
	 * @param endpointSourceModel
	 *            The source endpoint model.
	 * @param endpointTargetModel
	 *            The target endpoint model.
	 * @param instanceMID
	 *            An Instance MID. Can be null if the model relationship is not going to be contained in one.
	 * @return The created binary model relationship.
	 * @throws MMINTException
	 *             If this is not a model relationship type, or one endpoint model is not specified.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelNameRequired="true" endpointSourceModelRequired="true" endpointTargetModelRequired="true"
	 * @generated
	 */
	BinaryModelRel createBinaryInstanceAndEndpoints(EObject rootModelRelObj, String newModelRelName, Model endpointSourceModel, Model endpointTargetModel, MID instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the model instance resources to be used in the Relationship diagram outline for this
	 * model relationship instance.
	 * 
	 * @throws MMINTException
	 *             If this is not a model relationship instance. <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	ResourceSet getOutlineResourceInstances() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a model relationship instance of this model relationship type
	 * to a Workflow MID, together with its model instance endpoints.
	 * 
	 * @param newModelRelId
	 *            The id of the new model relationship.
	 * @param endpointModels
	 *            The endpoint models.
	 * @param workflowMID
	 *            A Workflow MID, null if the model relationship isn't going to be contained in one.
	 * @return The created model relationship.
	 * @throws MMINTException
	 *             If this is not a model relationship type, if no endpoint models are specified, or if the id of the
	 *             new model relationship is already registered in the Workflow MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelIdRequired="true" endpointModelsRequired="true" endpointModelsMany="true"
	 * @generated
	 */
	ModelRel createWorkflowInstanceAndEndpoints(String newModelRelId, EList<Model> endpointModels, MID workflowMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a binary model relationship instance of this model relationship
	 * type to a Workflow MID.
	 * 
	 * @param newModelRelId
	 *            The id of the new model relationship.
	 * @param workflowMID
	 *            A Workflow MID, null if the model relationship isn't going to be contained in one.
	 * @return The created binary model relationship.
	 * @throws MMINTException
	 *             If this is not a model relationship type, or if the id of the new model relationship is already
	 *             registered in the Workflow MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelIdRequired="true"
	 * @generated
	 */
	BinaryModelRel createWorkflowBinaryInstance(String newModelRelId, MID workflowMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a binary model relationship instance of this model relationship
	 * type to a Workflow MID, together with its model instance endpoints.
	 * 
	 * @param newModelRelId
	 *            The id of the new model relationship.
	 * @param endpointSourceModel
	 *            The source endpoint model.
	 * @param endpointTargetModel
	 *            The target endpoint model.
	 * @param workflowMID
	 *            A Workflow MID, null if the model relationship isn't going to be contained in one.
	 * @return The created binary model relationship.
	 * @throws MMINTException
	 *             If this is not a model relationship type, or if the id of the new model relationship is already
	 *             registered in the Workflow MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelIdRequired="true" endpointSourceModelRequired="true" endpointTargetModelRequired="true"
	 * @generated
	 */
	BinaryModelRel createWorkflowBinaryInstanceAndEndpoints(String newModelRelId, Model endpointSourceModel, Model endpointTargetModel, MID workflowMID) throws MMINTException;

} // ModelRel
