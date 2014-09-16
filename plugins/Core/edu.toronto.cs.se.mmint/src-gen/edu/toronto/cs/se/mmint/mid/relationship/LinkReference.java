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
package edu.toronto.cs.se.mmint.mid.relationship;

import edu.toronto.cs.se.mmint.MMINTException;

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
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.LinkReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getLinkReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='linkType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot linkType='object.oclIsKindOf(Link)'"
 * @generated
 */
public interface LinkReference extends ExtendibleElementReference {
	/**
	 * Returns the value of the '<em><b>Model Elem Endpoint Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to model element endpoints.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elem Endpoint Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getLinkReference_ModelElemEndpointRefs()
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

	/**
	 * <!-- begin-user-doc --> Deletes this reference to a link type from the
	 * Type MID.
	 * 
	 * @throws MMINTException
	 *             If this is a reference to a link instance.
	 *             <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteTypeReference() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes the referenced link type, this and all
	 * reference to it from the Type MID.
	 * 
	 * @throws MMINTException
	 *             If this is a reference to a link instance. <!-- end-user-doc
	 *             -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteTypeAndReference() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes this reference to a link instance from
	 * the Instance MID that contains it.
	 * 
	 * @throws MMINTException
	 *             If this is a reference to a link type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteInstanceReference() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes the referenced link instance and this
	 * reference to it from the Instance MID that contains them.
	 * 
	 * @throws MMINTException
	 *             If this is a reference to a link type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteInstanceAndReference() throws MMINTException;

} // LinkReference
