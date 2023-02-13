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
package edu.toronto.cs.se.mmint.mid.operator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.NestingOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperatorFactoryImpl extends EFactoryImpl implements OperatorFactory {
    /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public static OperatorFactory init() {
    try {
      var theOperatorFactory = (OperatorFactory)EPackage.Registry.INSTANCE.getEFactory(OperatorPackage.eNS_URI);
      if (theOperatorFactory != null) {
        return theOperatorFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new OperatorFactoryImpl();
  }

    /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public OperatorFactoryImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EObject create(EClass eClass) {
    return switch (eClass.getClassifierID()) {
    case OperatorPackage.OPERATOR -> createOperator();
    case OperatorPackage.CONVERSION_OPERATOR -> createConversionOperator();
    case OperatorPackage.RANDOM_OPERATOR -> createRandomOperator();
    case OperatorPackage.NESTING_OPERATOR -> createNestingOperator();
    case OperatorPackage.WORKFLOW_OPERATOR -> createWorkflowOperator();
    case OperatorPackage.GENERIC_ENDPOINT -> createGenericEndpoint();
    case OperatorPackage.OPERATOR_INPUT -> createOperatorInput();
    case OperatorPackage.OPERATOR_GENERIC -> createOperatorGeneric();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Operator createOperator() {
    OperatorImpl operator = new OperatorImpl();
    return operator;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ConversionOperator createConversionOperator() {
    ConversionOperatorImpl conversionOperator = new ConversionOperatorImpl();
    return conversionOperator;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public RandomOperator createRandomOperator() {
    RandomOperatorImpl randomOperator = new RandomOperatorImpl();
    return randomOperator;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public NestingOperator createNestingOperator() {
    NestingOperatorImpl nestingOperator = new NestingOperatorImpl();
    return nestingOperator;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public WorkflowOperator createWorkflowOperator() {
    WorkflowOperatorImpl workflowOperator = new WorkflowOperatorImpl();
    return workflowOperator;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public GenericEndpoint createGenericEndpoint() {
    GenericEndpointImpl genericEndpoint = new GenericEndpointImpl();
    return genericEndpoint;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public OperatorInput createOperatorInput() {
    OperatorInputImpl operatorInput = new OperatorInputImpl();
    return operatorInput;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public OperatorGeneric createOperatorGeneric() {
    OperatorGenericImpl operatorGeneric = new OperatorGenericImpl();
    return operatorGeneric;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public OperatorPackage getOperatorPackage() {
    return (OperatorPackage)getEPackage();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
    @Deprecated
    public static OperatorPackage getPackage() {
    return OperatorPackage.eINSTANCE;
  }

} //OperatorFactoryImpl
