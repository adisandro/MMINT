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
package edu.toronto.cs.se.mmint.mid.operator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.Model;

import java.util.Map;

import java.util.Properties;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An operator type or an operator instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getInputSubdir <em>Input Subdir</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getPreviousOperator <em>Previous Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.operator.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of input parameters of this operator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.operator.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of output parameters of this operator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getOutputs();

	/**
	 * Returns the value of the '<em><b>Input Subdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The subdirectory from where to get the input, when used in an operator chain.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Subdir</em>' attribute.
	 * @see #setInputSubdir(String)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_InputSubdir()
	 * @model
	 * @generated
	 */
	String getInputSubdir();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getInputSubdir <em>Input Subdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Subdir</em>' attribute.
	 * @see #getInputSubdir()
	 * @generated
	 */
	void setInputSubdir(String value);

	/**
	 * Returns the value of the '<em><b>Previous Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The previous operator, when used in an operator chain.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Previous Operator</em>' reference.
	 * @see #setPreviousOperator(Operator)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_PreviousOperator()
	 * @model
	 * @generated
	 */
	Operator getPreviousOperator();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getPreviousOperator <em>Previous Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Operator</em>' reference.
	 * @see #getPreviousOperator()
	 * @generated
	 */
	void setPreviousOperator(Operator value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the operator type of this operator instance.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (Operator) metatype;'"
	 * @generated
	 */
	Operator getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the operator supertype of this operator type.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (Operator) supertype;'"
	 * @generated
	 */
	Operator getSupertype();

	/**
	 * <!-- begin-user-doc --> Deletes this operator type from the Type MID.
	 * 
	 * @throws MMINTException
	 *             If this is an operator instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteType() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the list of executable operator types given
	 * a list of actual parameters to be used for their invocation. Contract:
	 * for each executable operator type, populate conversions and generics with
	 * the corresponding structures.
	 * 
	 * @param actualModels
	 *            The list of actual model parameters.
	 * @param actualModelTypes
	 *            A list of model types obtained through polymorphism for each
	 *            actual model parameter.
	 * @param conversions
	 *            Used as output, a list of conversion operator types for each
	 *            executable operator type and for each actual model parameter
	 *            to be converted into an equivalent one. The actual model
	 *            parameter to be converted is given by the integer index of the
	 *            map, to avoid the creation of many empty lists.
	 * @param generics
	 *            Used as output, a list of model types for each executable
	 *            operator type to parameterize its execution.
	 * @return The list of executable operator types.
	 * @throws MMINTException
	 *             If this is an operator instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" actualModelsMany="true" actualModelTypesMany="true" conversionsMany="true" genericsMany="true"
	 * @generated
	 */
	EList<Operator> getExecutables(EList<Model> actualModels, EList<EList<Model>> actualModelTypes, EList<Map<Integer, EList<ConversionOperator>>> conversions, EList<EList<Model>> generics) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the input properties of this operator.
	 * 
	 * @return The input properties of this operator. <!-- end-user-doc -->
	 * @model kind="operation" dataType="edu.toronto.cs.se.mmint.mid.operator.Properties" required="true"
	 * @generated
	 */
	Properties getInputProperties();

	/**
	 * <!-- begin-user-doc --> Reads the input properties of this operator
	 * instance. When running an operator instance, MMINT invokes
	 * readInputProperties() -> init() -> execute().
	 * 
	 * @param inputProperties
	 *            The input properties of this operator.
	 * @throws MMINTException
	 *             If any required property is not available, or if a property
	 *             is not in its intended format. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 *        inputPropertiesDataType
	 *        ="edu.toronto.cs.se.mmint.mid.operator.Properties"
	 *        inputPropertiesRequired="true"
	 * @generated
	 */
	void readInputProperties(Properties inputProperties) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Initializes the state and output variables of
	 * this operator instance. When running an operator instance, MMINT invokes
	 * readInputProperties() -> init() -> execute().
	 * 
	 * @throws MMINTException
	 *             If the operator variables can't be initialized.
	 *             <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void init() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Executes this operator instance. When running an
	 * operator instance, MMINT invokes readInputProperties() -> init() ->
	 * execute().
	 * 
	 * @param actualParameters
	 *            A list of input model instances.
	 * @return A list of output model instances.
	 * @throws Exception
	 *             If something went wrong during the execution of the operator.
	 *             <!-- end-user-doc -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception"
	 *        actualParametersRequired="true" actualParametersMany="true"
	 * @generated
	 */
	EList<Model> execute(EList<Model> actualParameters) throws Exception;

} // Operator
