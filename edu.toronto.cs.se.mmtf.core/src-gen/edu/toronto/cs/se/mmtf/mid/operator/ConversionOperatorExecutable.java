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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conversion Operator Executable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The executable implementation interface of a conversion operator.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getConversionOperatorExecutable()
 * @model abstract="true"
 * @generated
 */
public interface ConversionOperatorExecutable extends OperatorExecutable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cleans up the output of the conversion operator, to allow for a transparent conversion.
	 * <!-- end-model-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.operator.Exception"
	 * @generated
	 */
	void cleanup() throws Exception;

} // ConversionOperatorExecutable
