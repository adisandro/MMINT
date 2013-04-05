/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendible Element Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to an extendible element endpoint.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference#getTargetUri <em>Target Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getExtendibleElementEndpointReference()
 * @model abstract="true"
 * @generated
 */
public interface ExtendibleElementEndpointReference extends ExtendibleElementReference {
	/**
	 * Returns the value of the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uri of the referenced endpoint's target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Uri</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getExtendibleElementEndpointReference_TargetUri()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='object.oclAsType(mid::ExtendibleElementEndpoint).targetUri'"
	 * @generated
	 */
	String getTargetUri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the referenced element endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement object = super.getObject();\nreturn (object == null) ? null : (ExtendibleElementEndpoint) object;'"
	 * @generated
	 */
	ExtendibleElementEndpoint getObject();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the element supertype endpoint reference of this element type endpoint reference.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementReference supertypeRef = super.getSupertypeRef();\nreturn (supertypeRef == null) ? null : (ExtendibleElementEndpointReference) supertypeRef;'"
	 * @generated
	 */
	ExtendibleElementEndpointReference getSupertypeRef();

} // ExtendibleElementEndpointReference
