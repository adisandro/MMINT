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

import edu.toronto.cs.se.mmint.MMINTException;
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
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator#getMidUri <em>Mid Uri</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getWorkflowOperator()
 * @model
 * @generated
 */
public interface WorkflowOperator extends Operator {
	/**
	 * Returns the value of the '<em><b>Mid Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uri of the Workflow MID.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mid Uri</em>' attribute.
	 * @see #setMidUri(String)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getWorkflowOperator_MidUri()
	 * @model required="true"
	 * @generated
	 */
	String getMidUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator#getMidUri <em>Mid Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mid Uri</em>' attribute.
	 * @see #getMidUri()
	 * @generated
	 */
	void setMidUri(String value);

	/**
	 * <!-- begin-user-doc --> Gets the Workflow MID that implements this operator type.
	 * 
	 * @throws MMINTException
	 *             If this is not an operator type.<!-- end-user-doc -->
	 * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='MMINTException.mustBeType(this);\n\ntry {\n\treturn (MID) MIDUtils.readModelFileInState(this.getMidUri());\n}\ncatch (Exception e) {\n\treturn null;\n}'"
	 * @generated
	 */
	MID getWorkflowMID() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the Instance MID containing the intermediate artifacts created by this operator
	 * instance.
	 * 
	 * @throws MMINTException
	 *             If this is not an operator instance.<!-- end-user-doc -->
	 * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='MMINTException.mustBeInstance(this);\n\ntry {\n\treturn (MID) MIDUtils.readModelFile(this.getMidUri(), true);\n}\ncatch (Exception e) {\n\treturn null;\n}'"
	 * @generated
	 */
	MID getInstanceMID() throws MMINTException;

} // WorkflowOperator
