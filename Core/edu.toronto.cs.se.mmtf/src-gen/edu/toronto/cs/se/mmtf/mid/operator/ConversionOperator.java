/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.operator;

import edu.toronto.cs.se.mmtf.MMTFException;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conversion Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A conversion operator type or a conversion operator instance, enables substitution from the input parameter to the output parameter for other operators.
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getConversionOperator()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='conversion executable'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot conversion='inputs->size() = 1 and outputs->size() = 1' executable='executable.oclIsKindOf(ConversionOperatorExecutable)'"
 * @generated
 */
public interface ConversionOperator extends Operator {

	/**
	 * <!-- begin-user-doc --> Deletes this conversion operator type from the
	 * Type MID.
	 * 
	 * @throws MMTFException
	 *             If this is a conversion operator instance.
	 *             <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteType() throws MMTFException;

} // ConversionOperator
