/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Map;
import java.util.Properties;
import org.eclipse.emf.common.util.EList;

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
   * The path to the Instance MID to trace the nested artifacts.
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
   * <!-- begin-user-doc --> Gets the Instance MID containing the nested artifacts created by this operator instance.
     * 
     * @throws MMINTException
     *             If this is not an operator instance.<!-- end-user-doc -->
   * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    MID getNestedInstanceMID() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Starts a nested instance of an operator type, i.e. invokes its
     * {@link Operator#startInstance} within the nested Instance MID.
     * 
     * @param nestedOperatorType
     *            The operator type to run nested.
     * @param inputs
     *            A list of inputs to run the nested operator instance, including necessary conversions.
     * @param inputProperties
     *            The input properties for the nested operator instance, or null to read them from a file named
     *            OperatorNameIn.properties.
     * @param generics
     *            A list of generics to run the nested operator instance.
     * @param outputMIDsByName
     *            The instance MIDs where the output models are created, identified by the output name. A null instance
     *            MID means that the output model is added to the nested Instance MID.
     * @return The executed nested operator instance.
     * @throws Exception
     *             If this is not an operator instance, or if something went wrong starting the nested operator. <!--
     *             end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception" nestedOperatorTypeRequired="true" inputsMany="true" inputPropertiesDataType="edu.toronto.cs.se.mmint.mid.operator.Properties" genericsMany="true" outputMIDsByNameRequired="true"
   * @generated
   */
    Operator startNestedInstance(Operator nestedOperatorType, EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName) throws Exception;

} // NestingOperator
