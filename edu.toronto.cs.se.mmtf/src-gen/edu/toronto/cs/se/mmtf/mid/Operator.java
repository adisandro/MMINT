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
package edu.toronto.cs.se.mmtf.mid;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Operator#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Operator#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.mid.Parameter},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' map.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getOperator_Inputs()
	 * @model mapType="edu.toronto.cs.se.mmtf.mid.EStringToParameterMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.mid.Parameter>"
	 * @generated
	 */
	EMap<String, Parameter> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.mid.Parameter},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' map.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getOperator_Outputs()
	 * @model mapType="edu.toronto.cs.se.mmtf.mid.EStringToParameterMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.mid.Parameter>"
	 * @generated
	 */
	EMap<String, Parameter> getOutputs();

} // Operator
