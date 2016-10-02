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
package edu.toronto.cs.se.mmint.mid.operator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A rule of an operator's constraint, specifies what are the endpoints of an output model relationship.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintRule#getOutputModelRel <em>Output Model Rel</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintRule#getEndpointModels <em>Endpoint Models</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorConstraintRule()
 * @model
 * @generated
 */
public interface OperatorConstraintRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Output Model Rel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference to the output model relationship.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Model Rel</em>' containment reference.
	 * @see #setOutputModelRel(OperatorConstraintParameter)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorConstraintRule_OutputModelRel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OperatorConstraintParameter getOutputModelRel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintRule#getOutputModelRel <em>Output Model Rel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Model Rel</em>' containment reference.
	 * @see #getOutputModelRel()
	 * @generated
	 */
	void setOutputModelRel(OperatorConstraintParameter value);

	/**
	 * Returns the value of the '<em><b>Endpoint Models</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of references to other inputs/outputs of the operator that are the endpoints of the output model relationship.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Endpoint Models</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorConstraintRule_EndpointModels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<OperatorConstraintParameter> getEndpointModels();

} // OperatorConstraintRule
