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

} // Link
