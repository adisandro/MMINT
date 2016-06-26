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

import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to an input or output parameter of an operator, to be used in an operator constraint.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintParameter#getParameter <em>Parameter</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintParameter#getEndpointIndex <em>Endpoint Index</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorConstraintParameter()
 * @model
 * @generated
 */
public interface OperatorConstraintParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reference to an input or output parameter of an operator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(ModelEndpointReference)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorConstraintParameter_Parameter()
	 * @model required="true"
	 * @generated
	 */
	ModelEndpointReference getParameter();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintParameter#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(ModelEndpointReference value);

	/**
	 * Returns the value of the '<em><b>Endpoint Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An index to identify a model endpoint, if the referenced input or output parameter is a model relationship.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Endpoint Index</em>' attribute.
	 * @see #setEndpointIndex(int)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorConstraintParameter_EndpointIndex()
	 * @model
	 * @generated
	 */
	int getEndpointIndex();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintParameter#getEndpointIndex <em>Endpoint Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Index</em>' attribute.
	 * @see #getEndpointIndex()
	 * @generated
	 */
	void setEndpointIndex(int value);

} // OperatorConstraintParameter
