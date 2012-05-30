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
package edu.toronto.cs.se.mmtf.mid.operator;

import edu.toronto.cs.se.mmtf.mid.TypedElement;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getSignatureTable <em>Signature Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getExecutable <em>Executable</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.operator.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.operator.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getOutputs();

	/**
	 * Returns the value of the '<em><b>Signature Table</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.mid.operator.Parameter},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Table</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature Table</em>' map.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_SignatureTable()
	 * @model mapType="edu.toronto.cs.se.mmtf.mid.operator.EStringToParameterMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.mid.operator.Parameter>"
	 * @generated
	 */
	EMap<String, Parameter> getSignatureTable();

	/**
	 * Returns the value of the '<em><b>Executable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executable</em>' containment reference.
	 * @see #setExecutable(OperatorExecutable)
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_Executable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OperatorExecutable getExecutable();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getExecutable <em>Executable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executable</em>' containment reference.
	 * @see #getExecutable()
	 * @generated
	 */
	void setExecutable(OperatorExecutable value);

} // Operator
