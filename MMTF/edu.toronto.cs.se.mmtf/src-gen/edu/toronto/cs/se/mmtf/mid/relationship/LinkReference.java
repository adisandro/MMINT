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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to a link.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.LinkReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getLinkReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='linkType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot linkType='object.oclIsKindOf(Link)'"
 * @generated
 */
public interface LinkReference extends ExtendibleElementReference {
	/**
	 * Returns the value of the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to model element endpoints.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elem Endpoint Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getLinkReference_ModelElemEndpointRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementEndpointReference> getModelElemEndpointRefs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the referenced link.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement object = super.getObject();\nreturn (object == null) ? null : (Link) object;'"
	 * @generated
	 */
	Link getObject();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the link supertype reference of this link type reference.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementReference supertypeRef = super.getSupertypeRef();\nreturn (supertypeRef == null) ? null : (LinkReference) supertypeRef;'"
	 * @generated
	 */
	LinkReference getSupertypeRef();

} // LinkReference
