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
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;

import edu.toronto.cs.se.mmtf.mid.Model;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getSignatureTable <em>Signature Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getInputSubdir <em>Input Subdir</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getPreviousOperator <em>Previous Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.operator.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of input parameters of this operator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.operator.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of output parameters of this operator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getOutputs();

	/**
	 * Returns the value of the '<em><b>Signature Table</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.mid.operator.Parameter},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The hash map for all input and output parameters of this operator, using their names as keys.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signature Table</em>' map.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_SignatureTable()
	 * @model mapType="edu.toronto.cs.se.mmtf.mid.operator.EStringToParameterMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.mid.operator.Parameter>"
	 * @generated
	 */
	EMap<String, Parameter> getSignatureTable();

	/**
	 * Returns the value of the '<em><b>Input Subdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The subdirectory from where to get the input, when used in an operator chain.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Subdir</em>' attribute.
	 * @see #setInputSubdir(String)
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_InputSubdir()
	 * @model
	 * @generated
	 */
	String getInputSubdir();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getInputSubdir <em>Input Subdir</em>}' attribute.
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
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperator_PreviousOperator()
	 * @model
	 * @generated
	 */
	Operator getPreviousOperator();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.Operator#getPreviousOperator <em>Previous Operator</em>}' reference.
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
	 * @throws MMTFException
	 *             If this is an operator instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteType() throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Executes an instance of this operator type.
	 * 
	 * @param actualParameters
	 *            A list of input model instances.
	 * @return A list of output model instances.
	 * @throws Exception
	 *             If something went wrong during the execution of the operator.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.operator.Exception" actualParametersRequired="true" actualParametersMany="true"
	 * @generated
	 */
	EList<Model> execute(EList<Model> actualParameters) throws Exception;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" actualModelsMany="true" actualModelTypesMany="true"
	 * @generated
	 */
	Map<Integer, EList<ConversionOperator>> isExecutable(EList<Model> actualModels, EList<EList<Model>> actualModelTypes);

} // Operator
