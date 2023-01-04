/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getConversionOperator()
 * @model
 * @generated
 */
public interface ConversionOperator extends Operator {

    /**
   * <!-- begin-user-doc --> Deletes this conversion operator type from the
     * Type MID.
     * 
     * @throws MMINTException
     *             If this is a conversion operator instance.
     *             <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    void deleteType() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Cleans up temporary artifacts created during the
     * execution of the operator, when this operator is used in a conversion
     * chain and not standalone.
     * 
     * @throws Exception
     *             If something went wrong during the cleanup of the operator.
     *             <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception"
   * @generated
   */
    void cleanup() throws Exception;

} // ConversionOperator
