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

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;

import edu.toronto.cs.se.mmint.mid.MID;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A mapping type among model element types or a mapping instance among model element instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#getModelElemEndpoints <em>Model Elem Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends ExtendibleElement {
    /**
     * Returns the value of the '<em><b>Model Elem Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The list of model element endpoints.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Model Elem Endpoints</em>' containment reference list.
     * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getMapping_ModelElemEndpoints()
     * @model containment="true"
     * @generated
     */
    EList<ModelElementEndpoint> getModelElemEndpoints();

    /**
     * Returns the value of the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
     * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The list of references to model element endpoints. This is different from the list of model element endpoints because it includes inherited endpoints too.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Model Elem Endpoint Refs</em>' reference list.
     * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getMapping_ModelElemEndpointRefs()
     * @model
     * @generated
     */
    EList<ModelElementEndpointReference> getModelElemEndpointRefs();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * {@inheritDoc}<br />
     * Gets the mapping type of this mapping instance.
     * <!-- end-model-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (Mapping) metatype;'"
     * @generated
     */
    Mapping getMetatype();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * {@inheritDoc}<br />
     * Gets the mapping supertype of this mapping type.
     * <!-- end-model-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (Mapping) supertype;'"
     * @generated
     */
    Mapping getSupertype();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (MID) this.eContainer().eContainer();'"
     * @generated
     */
    MID getMIDContainer();

    /**
     * <!-- begin-user-doc --> Creates and adds a reference to this mapping type to
     * the Type MID.
     * 
     * @param mappingTypeRef
     *            The reference to the supertype of the mapping type, null if
     *            such reference doesn't exist in the model relationship type
     *            container.
     * @param isModifiable
     *            True if the new reference will allow modifications of the
     *            referenced mapping type, false otherwise.
     * @param containerModelRelType
     *            The model relationship type that will contain the new
     *            reference to the mapping type.
     * @return The created reference to the mapping type.
     * @throws MMINTException
     *             If this is a mapping instance. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isModifiableRequired="true" containerModelRelTypeRequired="true"
     * @generated
     */
    MappingReference createTypeReference(MappingReference mappingTypeRef, boolean isModifiable, ModelRel containerModelRelType) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and adds a subtype of this mapping type and
     * a reference to it to the Type MID.
     * 
     * @param mappingTypeRef
     *            The reference to the supertype of the new mapping type, null if
     *            such reference doesn't exist in the model relationship type
     *            container.
     * @param newMappingTypeName
     *            The name of the new mapping type.
     * @param isBinary
     *            True if the new mapping type is binary, false otherwise.
     * @param containerModelRelType
     *            The model relationship type that will contain the new mapping
     *            type.
     * @return The created reference to the new mapping type.
     * @throws MMINTException
     *             If this is a mapping instance, or if the uri of the new mapping
     *             type is already registered in the Type MID.
     *             <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newMappingTypeNameRequired="true" isBinaryRequired="true" containerModelRelTypeRequired="true"
     * @generated
     */
    MappingReference createSubtypeAndReference(MappingReference mappingTypeRef, String newMappingTypeName, boolean isBinary, ModelRel containerModelRelType) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this mapping type from the Type MID.
     * 
     * @throws MMINTException
     *             If this is a mapping instance. <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    void deleteType() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and adds a reference to this mapping
     * instance to an Instance MID.
     * 
     * @param containerModelRel
     *            The model relationship that will contain the new reference to
     *            the mapping.
     * @return The created reference to the mapping.
     * @throws MMINTException
     *             If this is a mapping type. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" containerModelRelRequired="true"
     * @generated
     */
    MappingReference createInstanceReference(ModelRel containerModelRel) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and adds a mapping instance of this mapping
     * type and a reference to it to an Instance MID.
     * 
     * @param isBinary
     *            True if the new mapping is binary, false otherwise.
     * @param containerModelRel
     *            The model relationship that will contain the new mapping.
     * @return The created reference to the new mapping.
     * @throws MMINTException
     *             If this is a mapping instance. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isBinaryRequired="true" containerModelRelRequired="true"
     * @generated
     */
    MappingReference createInstanceAndReference(boolean isBinary, ModelRel containerModelRel) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and adds a mapping instance of this mapping type and a reference to it to an Instance
     * MID, together with its model element instance endpoints and references to them.
     * 
     * @param isBinary
     *            True if the new mapping is binary, false otherwise.
     * @param targetModelElemRefs
     *            The references to the model elements that are the target of the new model element endpoints.
     * @return The created reference to the new mapping.
     * @throws MMINTException
     *             If this is a mapping instance, if no target references to model elements are specified, or if the new
     *             mapping is binary but 2 target model elements are not specified. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isBinaryRequired="true" targetModelElemRefsRequired="true" targetModelElemRefsMany="true"
     * @generated
     */
    MappingReference createInstanceAndReferenceAndEndpointsAndReferences(boolean isBinary, EList<ModelElementReference> targetModelElemRefs) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this mapping instance from the Instance MID
     * that contains it.
     * 
     * @throws MMINTException
     *             If this is a mapping type. <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    void deleteInstance() throws MMINTException;

} // Mapping
