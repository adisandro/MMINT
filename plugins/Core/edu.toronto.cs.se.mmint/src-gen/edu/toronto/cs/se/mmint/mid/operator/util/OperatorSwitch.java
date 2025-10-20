/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.operator.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import edu.toronto.cs.se.mmint.OperatorGeneric;
import edu.toronto.cs.se.mmint.OperatorInput;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.NestingOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage
 * @generated
 */
public class OperatorSwitch<T> extends Switch<T> {
    /**
   * The cached model package
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected static OperatorPackage modelPackage;

    /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public OperatorSwitch() {
    if (OperatorSwitch.modelPackage == null) {
      OperatorSwitch.modelPackage = OperatorPackage.eINSTANCE;
    }
  }

    /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == OperatorSwitch.modelPackage;
  }

    /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case OperatorPackage.OPERATOR: {
        var operator = (Operator)theEObject;
        var result = caseOperator(operator);
        if (result == null) {
          result = caseGenericElement(operator);
        }
        if (result == null) {
          result = caseExtendibleElement(operator);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case OperatorPackage.CONVERSION_OPERATOR: {
        var conversionOperator = (ConversionOperator)theEObject;
        var result = caseConversionOperator(conversionOperator);
        if (result == null) {
          result = caseOperator(conversionOperator);
        }
        if (result == null) {
          result = caseGenericElement(conversionOperator);
        }
        if (result == null) {
          result = caseExtendibleElement(conversionOperator);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case OperatorPackage.RANDOM_OPERATOR: {
        var randomOperator = (RandomOperator)theEObject;
        var result = caseRandomOperator(randomOperator);
        if (result == null) {
          result = caseOperator(randomOperator);
        }
        if (result == null) {
          result = caseGenericElement(randomOperator);
        }
        if (result == null) {
          result = caseExtendibleElement(randomOperator);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case OperatorPackage.NESTING_OPERATOR: {
        var nestingOperator = (NestingOperator)theEObject;
        var result = caseNestingOperator(nestingOperator);
        if (result == null) {
          result = caseOperator(nestingOperator);
        }
        if (result == null) {
          result = caseGenericElement(nestingOperator);
        }
        if (result == null) {
          result = caseExtendibleElement(nestingOperator);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case OperatorPackage.WORKFLOW_OPERATOR: {
        var workflowOperator = (WorkflowOperator)theEObject;
        var result = caseWorkflowOperator(workflowOperator);
        if (result == null) {
          result = caseNestingOperator(workflowOperator);
        }
        if (result == null) {
          result = caseOperator(workflowOperator);
        }
        if (result == null) {
          result = caseGenericElement(workflowOperator);
        }
        if (result == null) {
          result = caseExtendibleElement(workflowOperator);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case OperatorPackage.GENERIC_ENDPOINT: {
        var genericEndpoint = (GenericEndpoint)theEObject;
        var result = caseGenericEndpoint(genericEndpoint);
        if (result == null) {
          result = caseExtendibleElementEndpoint(genericEndpoint);
        }
        if (result == null) {
          result = caseExtendibleElement(genericEndpoint);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseOperator(Operator object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Conversion Operator</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conversion Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseConversionOperator(ConversionOperator object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Random Operator</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Random Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseRandomOperator(RandomOperator object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Nesting Operator</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nesting Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseNestingOperator(NestingOperator object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Workflow Operator</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Workflow Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseWorkflowOperator(WorkflowOperator object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Generic Endpoint</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Generic Endpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseGenericEndpoint(GenericEndpoint object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Input</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseOperatorInput(OperatorInput object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Generic</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Generic</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseOperatorGeneric(OperatorGeneric object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Extendible Element</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extendible Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseExtendibleElement(ExtendibleElement object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Generic Element</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Generic Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseGenericElement(GenericElement object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Extendible Element Endpoint</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extendible Element Endpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseExtendibleElementEndpoint(ExtendibleElementEndpoint object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
    @Override
    public T defaultCase(EObject object) {
    return null;
  }

} //OperatorSwitch
