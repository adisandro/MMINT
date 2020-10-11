/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendible Element Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to an extendible element endpoint.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getExtendibleElementEndpointReference()
 * @model abstract="true"
 * @generated
 */
public interface ExtendibleElementEndpointReference extends ExtendibleElementReference {
    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The uri of the referenced endpoint's target.
   * <!-- end-model-doc -->
   * @model kind="operation"
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
   * @generated
   */
    ExtendibleElementEndpointReference getSupertypeRef();

} // ExtendibleElementEndpointReference
