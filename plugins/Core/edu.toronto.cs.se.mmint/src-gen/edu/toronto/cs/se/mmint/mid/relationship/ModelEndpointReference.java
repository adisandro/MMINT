/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to a model endpoint.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference#getModelElemRefs <em>Model Elem Refs</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelEndpointReference()
 * @model
 * @generated
 */
public interface ModelEndpointReference extends ExtendibleElementEndpointReference {
    /**
   * Returns the value of the '<em><b>Model Elem Refs</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference}.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The list of references to model elements. This is a subset of the list of model elements in the model.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Model Elem Refs</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelEndpointReference_ModelElemRefs()
   * @model containment="true"
   * @generated
   */
    EList<ModelElementReference> getModelElemRefs();

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * {@inheritDoc}<br />
   * Gets the referenced model endpoint.
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    ModelEndpoint getObject();

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * {@inheritDoc}<br />
   * Gets the model supertype endpoint reference of this model type endpoint reference.
   * <!-- end-model-doc -->
   * @model kind="operation"
   * @generated
   */
    ModelEndpointReference getSupertypeRef();

    /**
   * <!-- begin-user-doc --> Accepts a metamodel object as model element type
     * in this reference to model type endpoint.
     * 
     * @param metamodelObj
     *            The metamodel object.
     * @return True if the metamodel object is accepted, false otherwise.
     * @throws MMINTException
     *             If this is a reference to a model instance endpoint.
     *             <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" metamodelObjRequired="true"
   * @generated
   */
    boolean acceptModelElementType(EObject metamodelObj) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Deletes this reference to a model type endpoint
     * from the Type MID.
     * 
     * @param isFullDelete
     *            True if this reference to model type endpoint is going to be
     *            fully deleted, false if it is going to be replaced later.
     * @throws MMINTException
     *             If this is a reference to a model instance endpoint.
     *             <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" isFullDeleteRequired="true"
   * @generated
   */
    void deleteTypeReference(boolean isFullDelete) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Accepts a model object as model element instance
     * in this reference to model instance endpoint.
     * 
     * @param modelObj
     *            The model object.
     * @return The model element type of the model object if it is accepted,
     *         null otherwise.
     * @throws MMINTException
     *             If this is a reference to a model type endpoint.
     *             <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" modelObjRequired="true"
   * @generated
   */
    ModelElement acceptModelElementInstance(EObject modelObj) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Creates and adds a model element instance of a type to be automatically detected and a
     * reference to it to an Instance MID.
     * 
     * @param modelObj
     *            The EMF model object to be wrapped by the new model element.
     * @param newModelElemName
     *            The name of the new model element, null if the name should be automatically generated.
     * @return The created reference to the new model element.
     * @throws MMINTException
     *             If this is a reference to a model instance endpoint, or if the uri of the new model element is
     *             already registered in the Instance MID. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" modelObjRequired="true" newModelElemNameRequired="true"
   * @generated
   */
    ModelElementReference createModelElementInstanceAndReference(EObject modelObj, String newModelElemName) throws MMINTException;

} // ModelEndpointReference
