/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.operator;

import edu.toronto.cs.se.mmint.mid.GenericElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A generic for an operator instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric#getGeneric <em>Generic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric#getGenericSuperTypeEndpoint <em>Generic Super Type Endpoint</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorGeneric()
 * @model
 * @generated
 */
public interface OperatorGeneric extends EObject {
    /**
     * Returns the value of the '<em><b>Generic</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The generic actual parameter.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Generic</em>' reference.
     * @see #setGeneric(GenericElement)
     * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorGeneric_Generic()
     * @model required="true"
     * @generated
     */
    GenericElement getGeneric();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric#getGeneric <em>Generic</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Generic</em>' reference.
     * @see #getGeneric()
     * @generated
     */
    void setGeneric(GenericElement value);

    /**
     * Returns the value of the '<em><b>Generic Super Type Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The generic formal parameter.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Generic Super Type Endpoint</em>' reference.
     * @see #setGenericSuperTypeEndpoint(GenericEndpoint)
     * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorGeneric_GenericSuperTypeEndpoint()
     * @model required="true"
     * @generated
     */
    GenericEndpoint getGenericSuperTypeEndpoint();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric#getGenericSuperTypeEndpoint <em>Generic Super Type Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Generic Super Type Endpoint</em>' reference.
     * @see #getGenericSuperTypeEndpoint()
     * @generated
     */
    void setGenericSuperTypeEndpoint(GenericEndpoint value);

} // OperatorGeneric
