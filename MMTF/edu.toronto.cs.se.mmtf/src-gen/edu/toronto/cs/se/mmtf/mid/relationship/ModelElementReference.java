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

import edu.toronto.cs.se.mmtf.mid.ModelElement;
import org.eclipse.emf.common.util.EList;

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
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelElementReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='modelElementType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot modelElementType='object.oclIsKindOf(mid::ModelElement)'"
 * @generated
 */
public interface ModelElementReference extends ExtendibleElementReference {
	/**
	 * Returns the value of the '<em><b>Model Elem Endpoint Refs</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference#getModelElemRef <em>Model Elem Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to links that use this as an endpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elem Endpoint Refs</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage#getModelElementReference_ModelElemEndpointRefs()
	 * @see edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference#getModelElemRef
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

} // ModelElementReference
