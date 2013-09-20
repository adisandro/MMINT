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
package edu.toronto.cs.se.mmtf.mid;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Entity Wildcard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The wildcard class for the most generic model element type of entity category.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelElementEntityWildcard#getModelElementRelationshipWildcard <em>Model Element Relationship Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelElementEntityWildcard()
 * @model
 * @generated
 */
public interface ModelElementEntityWildcard extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Element Relationship Wildcard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The wildcard reference for the most generic model element type of relationship category.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Element Relationship Wildcard</em>' reference.
	 * @see #setModelElementRelationshipWildcard(ModelElementEntityWildcard)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelElementEntityWildcard_ModelElementRelationshipWildcard()
	 * @model
	 * @generated
	 */
	ModelElementEntityWildcard getModelElementRelationshipWildcard();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelElementEntityWildcard#getModelElementRelationshipWildcard <em>Model Element Relationship Wildcard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Relationship Wildcard</em>' reference.
	 * @see #getModelElementRelationshipWildcard()
	 * @generated
	 */
	void setModelElementRelationshipWildcard(ModelElementEntityWildcard value);

} // ModelElementEntityWildcard
