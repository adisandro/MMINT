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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An input for an operator instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getModel <em>Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getConversions <em>Conversions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getModelTypeEndpoint <em>Model Type Endpoint</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorInput()
 * @model
 * @generated
 */
public interface OperatorInput extends EObject {
    /**
   * Returns the value of the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The input actual parameter.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Model</em>' reference.
   * @see #setModel(Model)
   * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorInput_Model()
   * @model required="true"
   * @generated
   */
    Model getModel();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getModel <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' reference.
   * @see #getModel()
   * @generated
   */
    void setModel(Model value);

    /**
   * Returns the value of the '<em><b>Conversions</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.operator.ConversionOperator}.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The list of conversions to be executed on the input actual parameter.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Conversions</em>' reference list.
   * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorInput_Conversions()
   * @model
   * @generated
   */
    EList<ConversionOperator> getConversions();

    /**
   * Returns the value of the '<em><b>Model Type Endpoint</b></em>' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The input formal parameter.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Model Type Endpoint</em>' reference.
   * @see #setModelTypeEndpoint(ModelEndpoint)
   * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperatorInput_ModelTypeEndpoint()
   * @model required="true"
   * @generated
   */
    ModelEndpoint getModelTypeEndpoint();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.OperatorInput#getModelTypeEndpoint <em>Model Type Endpoint</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model Type Endpoint</em>' reference.
   * @see #getModelTypeEndpoint()
   * @generated
   */
    void setModelTypeEndpoint(ModelEndpoint value);

} // OperatorInput
