/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element type of a model type or an element instance of a model instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ModelElement#getEInfo <em>EInfo</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends ExtendibleElement {
    /**
     * Returns the value of the '<em><b>EInfo</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The EMF information (types: metamodel info; instances: metamodel info).
     * <!-- end-model-doc -->
     * @return the value of the '<em>EInfo</em>' containment reference.
     * @see #setEInfo(EMFInfo)
     * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModelElement_EInfo()
     * @model containment="true" required="true"
     * @generated
     */
    EMFInfo getEInfo();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ModelElement#getEInfo <em>EInfo</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>EInfo</em>' containment reference.
     * @see #getEInfo()
     * @generated
     */
    void setEInfo(EMFInfo value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * {@inheritDoc}<br />
     * Gets the model element type of this model element instance.
     * <!-- end-model-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (ModelElement) metatype;'"
     * @generated
     */
    ModelElement getMetatype();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * {@inheritDoc}<br />
     * Gets the model element supertype of this model element type.
     * <!-- end-model-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (ModelElement) supertype;'"
     * @generated
     */
    ModelElement getSupertype();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (MID) this.eContainer().eContainer();'"
     * @generated
     */
    MID getMIDContainer();

    /**
     * <!-- begin-user-doc --> Creates and adds a reference to this model
     * element type to the Type MID.
     *
     * @param modelElemTypeRef
     *            The reference to the supertype of the model element type, null
     *            if such reference doesn't exist in the model type endpoint
     *            reference container.
     * @param isModifiable
     *            True if the new reference will allow modifications of the
     *            referenced model element type, false otherwise.
     * @param containerModelTypeEndpointRef
     *            The reference to the model type endpoint that will contain the
     *            new reference to the model element type.
     * @return The created reference to the model element type.
     * @throws MMINTException
     *             If this is a model element instance. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isModifiableRequired="true" containerModelTypeEndpointRefRequired="true"
     * @generated
     */
    ModelElementReference createTypeReference(ModelElementReference modelElemTypeRef, boolean isModifiable, ModelEndpointReference containerModelTypeEndpointRef) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and adds a subtype of this model element
     * type and a reference to it to the Type MID.
     *
     * @param modelElemTypeRef
     *            The reference to the supertype of the new model element type,
     *            null if such reference doesn't exist in the model type
     *            endpoint reference container.
     * @param newModelElemTypeUri
     *            The uri of the new model element type.
     * @param newModelElemTypeName
     *            The name of the new model element type.
     * @param eInfo
     *            The EMF info of the new model element type.
     * @param modelTypeEndpointRef
     *            The reference to the model type endpoint that will contain the
     *            new reference to the new model element type.
     * @return The created reference to the new model element type.
     * @throws MMINTException
     *             If this is a model element instance, or if the uri of the new
     *             model element type is already registered in the Type MID.
     *             <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelElemTypeUriRequired="true" newModelElemTypeNameRequired="true" eInfoRequired="true" containerModelTypeEndpointRefRequired="true"
     * @generated
     */
    ModelElementReference createSubtypeAndReference(ModelElementReference modelElemTypeRef, String newModelElemTypeUri, String newModelElemTypeName, EMFInfo eInfo, ModelEndpointReference containerModelTypeEndpointRef) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this model element type from the Type
     * MID.
     *
     * @throws MMINTException
     *             If this is a model element instance. <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    void deleteType() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Gets the EMF metamodel object of this model
     * element type.
     *
     * @throws MMINTException
     *             If this is a model element instance, or if the metamodel file
     *             can't be accessed. <!-- end-user-doc -->
     * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    ENamedElement getEMFTypeObject() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and adds a reference to this model
     * element to an Instance MID.
     *
     * @param containerModelEndpointRef
     *            The reference to the model endpoint that will contain the new
     *            reference to the model element.
     * @return The created reference to the model element.
     * @throws MMINTException
     *             If this is a model element type. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" containerModelEndpointRefRequired="true"
     * @generated
     */
    ModelElementReference createInstanceReference(ModelEndpointReference containerModelEndpointRef) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and adds a model element instance of this
     * model element type and a reference to it to an Instance MID.
     *
     * @param newModelElemUri
     *            The uri of the new model element.
     * @param newModelElemName
     *            The name of the new model element.
     * @param eInfo
     *            The EMF info of the new model element.
     * @param containerModelEndpointRef
     *            The reference to the model endpoint that will contain the new
     *            reference to the new model element.
     * @return The created reference to the new model element.
     * @throws MMINTException
     *             If this is a model element instance, or if the uri of the new
     *             model element is already registered in the Instance MID.
     *             <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelElemUriRequired="true" newModelElemNameRequired="true" eInfoRequired="true" containerModelEndpointRefRequired="true"
     * @generated
     */
    ModelElementReference createInstanceAndReference(String newModelElemUri, String newModelElemName, EMFInfo eInfo, ModelEndpointReference containerModelEndpointRef) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this model element instance from the
     * Instance MID that contains it.
     *
     * @throws MMINTException
     *             If this is a model element type. <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    void deleteInstance() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Gets the EMF model object of this model element instance.
     *
     * @param emfResource
     *            An existing EMF model resource to get the model from.
     *
     * @throws MMINTException
     *             If this is a model element type, or if the model file can't be accessed. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    EObject getEMFInstanceObject(Resource emfResource) throws MMINTException;

} // ModelElement
