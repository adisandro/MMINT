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
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getWorkflowOperator()
 * @model
 * @generated
 */
public interface WorkflowOperator extends NestingOperator {
	/**
	 * <!-- begin-user-doc --> Gets the Workflow MID that implements this operator type.
	 * 
	 * @throws MMINTException
	 *             If this is not an operator type.<!-- end-user-doc -->
	 * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='MMINTException.mustBeType(this);\n\ntry {\n\treturn (MID) FileUtils.readModelFileInState(this.getNestedMIDPath());\n}\ncatch (Exception e) {\n\treturn null;\n}'"
	 * @generated
	 */
	MID getNestedWorkflowMID() throws MMINTException;

} // WorkflowOperator
