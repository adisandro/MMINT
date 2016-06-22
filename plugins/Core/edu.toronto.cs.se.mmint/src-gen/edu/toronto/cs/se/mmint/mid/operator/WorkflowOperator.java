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

import edu.toronto.cs.se.mmint.mid.MID;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A workflow operator type or a workflow operator instance, executes a Workflow MID.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator#getWorkflowMIDUri <em>Workflow MID Uri</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getWorkflowOperator()
 * @model
 * @generated
 */
public interface WorkflowOperator extends Operator {
	/**
	 * Returns the value of the '<em><b>Workflow MID Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workflow MID Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workflow MID Uri</em>' attribute.
	 * @see #setWorkflowMIDUri(String)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getWorkflowOperator_WorkflowMIDUri()
	 * @model required="true"
	 * @generated
	 */
	String getWorkflowMIDUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator#getWorkflowMIDUri <em>Workflow MID Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workflow MID Uri</em>' attribute.
	 * @see #getWorkflowMIDUri()
	 * @generated
	 */
	void setWorkflowMIDUri(String value);

	/**
	 * <!-- begin-user-doc --> Gets the Workflow MID that implements this operator. <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel body='try {\n\treturn (MID)
	 *        MIDUtils.readModelFileInState(this.getWorkflowMIDUri());\n}\ncatch (Exception e) {\n\treturn null;\n}'"
	 * @generated
	 */
	MID getWorkflowMID();

} // WorkflowOperator
