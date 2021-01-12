/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage
 * @generated
 */
public interface OperatorFactory extends EFactory {
    /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    OperatorFactory eINSTANCE = edu.toronto.cs.se.mmint.mid.operator.impl.OperatorFactoryImpl.init();

    /**
   * Returns a new object of class '<em>Operator</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Operator</em>'.
   * @generated
   */
    Operator createOperator();

    /**
   * Returns a new object of class '<em>Conversion Operator</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Conversion Operator</em>'.
   * @generated
   */
    ConversionOperator createConversionOperator();

    /**
   * Returns a new object of class '<em>Random Operator</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Random Operator</em>'.
   * @generated
   */
    RandomOperator createRandomOperator();

    /**
   * Returns a new object of class '<em>Nesting Operator</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Nesting Operator</em>'.
   * @generated
   */
    NestingOperator createNestingOperator();

    /**
   * Returns a new object of class '<em>Workflow Operator</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Workflow Operator</em>'.
   * @generated
   */
    WorkflowOperator createWorkflowOperator();

    /**
   * Returns a new object of class '<em>Generic Endpoint</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Generic Endpoint</em>'.
   * @generated
   */
    GenericEndpoint createGenericEndpoint();

    /**
   * Returns a new object of class '<em>Input</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Input</em>'.
   * @generated
   */
    OperatorInput createOperatorInput();

    /**
   * Returns a new object of class '<em>Generic</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Generic</em>'.
   * @generated
   */
    OperatorGeneric createOperatorGeneric();

    /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
    OperatorPackage getOperatorPackage();

} //OperatorFactory
