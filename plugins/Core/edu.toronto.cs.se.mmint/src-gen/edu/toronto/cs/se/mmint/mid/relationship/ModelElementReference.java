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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to a model element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelElementReference()
 * @model
 * @generated
 */
public interface ModelElementReference extends ExtendibleElementReference {
	/**
	 * Returns the value of the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getModelElemRef <em>Model Elem Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to mappings that use this as an endpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elem Endpoint Refs</em>' reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelElementReference_ModelElemEndpointRefs()
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference#getModelElemRef
	 * @model opposite="modelElemRef"
	 * @generated
	 */
	EList<ModelElementEndpointReference> getModelElemEndpointRefs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the referenced model element.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement object = super.getObject();\nreturn (object == null) ? null : (ModelElement) object;'"
	 * @generated
	 */
	ModelElement getObject();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model element supertype reference of this model element type reference.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementReference supertypeRef = super.getSupertypeRef();\nreturn (supertypeRef == null) ? null : (ModelElementReference) supertypeRef;'"
	 * @generated
	 */
	ModelElementReference getSupertypeRef();

	/**
	 * <!-- begin-user-doc -->
	 * Deletes this reference to a model element type and all its subreferences
	 * from the MID that contains them.
	 * 
	 * @throws MMINTException
	 *             If this reference to a model element is at the INSTANCES
	 *             level.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteTypeReference() throws MMINTException;

	/**
	 * <!-- begin-user-doc -->
	 * Removes this reference to a model element from the Instance MID that
	 * contains it.
	 * 
	 * @throws MMINTException
	 *             If this reference to a model element is at the TYPES level.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteInstanceReference() throws MMINTException;

} // ModelElementReference
