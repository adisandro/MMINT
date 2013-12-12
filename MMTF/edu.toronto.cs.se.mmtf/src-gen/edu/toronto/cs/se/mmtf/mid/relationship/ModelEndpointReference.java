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
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

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
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference#getModelElemRefs <em>Model Elem Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelEndpointReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='modelEndpointType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot modelEndpointType='object.oclIsKindOf(mid::ModelEndpoint)'"
 * @generated
 */
public interface ModelEndpointReference extends ExtendibleElementEndpointReference {
	/**
	 * Returns the value of the '<em><b>Model Elem Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to model elements. This is a subset of the list of model elements in the model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elem Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelEndpointReference_ModelElemRefs()
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpoint object = super.getObject();\nreturn (object == null) ? null : (ModelEndpoint) object;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpointReference supertypeRef = super.getSupertypeRef();\nreturn (supertypeRef == null) ? null : (ModelEndpointReference) supertypeRef;'"
	 * @generated
	 */
	ModelEndpointReference getSupertypeRef();

	/**
	 * <!-- begin-user-doc -->
	 * Accepts a metamodel object as model element type in this reference to
	 * model type endpoint.
	 * 
	 * @param metamodelObj
	 *            The metamodel object.
	 * @return True if the metamodel object is accepted, false otherwise.
	 * @throws MMTFException
	 *             If this reference to model endpoint is at the INSTANCES
	 *             level.
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        metamodelObjRequired="true"
	 * @generated
	 */
	boolean acceptModelElementType(EObject metamodelObj) throws MMTFException;

	/**
	 * <!-- begin-user-doc -->
	 * Accepts a model object as model element in this reference to model
	 * endpoint.
	 * 
	 * @param modelObj
	 *            The model object.
	 * @return The model element type of the model object if it is accepted,
	 *         null otherwise.
	 * @throws MMTFException
	 *             If this reference to model endpoint is at the TYPES level.
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        modelObjRequired="true"
	 * @generated
	 */
	ModelElement acceptModelElement(EObject modelObj) throws MMTFException;

} // ModelEndpointReference
