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
 * A representation of the model object '<em><b>Nesting Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A nesting operator type or a nesting operator instance, i.e. an operator that in turn runs other operators and uses a nested Instance MID to trace intermediate artifacts.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.NestingOperator#getNestedMIDPath <em>Nested MID Path</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getNestingOperator()
 * @model
 * @generated
 */
public interface NestingOperator extends Operator {
	/**
	 * Returns the value of the '<em><b>Nested MID Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The path to the nested MID to trace the intermediate artifacts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nested MID Path</em>' attribute.
	 * @see #setNestedMIDPath(String)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getNestingOperator_NestedMIDPath()
	 * @model required="true"
	 * @generated
	 */
	String getNestedMIDPath();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.NestingOperator#getNestedMIDPath <em>Nested MID Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nested MID Path</em>' attribute.
	 * @see #getNestedMIDPath()
	 * @generated
	 */
	void setNestedMIDPath(String value);

	/**
	 * <!-- begin-user-doc --> Gets the Instance MID containing the intermediate artifacts created by this operator
	 * instance.
	 * 
	 * @throws MMINTException
	 *             If this is not an operator instance.<!-- end-user-doc -->
	 * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='MMINTException.mustBeInstance(this);\n\ntry {\n\treturn (MID) FileUtils.readModelFile(this.getNestedMIDPath(), true);\n}\ncatch (Exception e) {\n\treturn null;\n}'"
	 * @generated
	 */
	MID getNestedInstanceMID() throws MMINTException;

} // NestingOperator
