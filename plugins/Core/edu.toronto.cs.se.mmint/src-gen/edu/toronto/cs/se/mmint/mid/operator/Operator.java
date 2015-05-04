/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.MultiModel;

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
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getGenerics <em>Generics</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getInputSubdir <em>Input Subdir</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getPreviousOperator <em>Previous Operator</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#isUpdateMID <em>Update MID</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends GenericElement {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.ModelEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of input parameters of this operator (types: formal parameters; instances: actual parameters).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelEndpoint> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.ModelEndpoint}.
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
	EList<ModelEndpoint> getOutputs();

	/**
	 * Returns the value of the '<em><b>Generics</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of generics of this operator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generics</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_Generics()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenericEndpoint> getGenerics();

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
	 * Returns the value of the '<em><b>Update MID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update MID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update MID</em>' attribute.
	 * @see #setUpdateMID(boolean)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_UpdateMID()
	 * @model
	 * @generated
	 */
	boolean isUpdateMID();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#isUpdateMID <em>Update MID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update MID</em>' attribute.
	 * @see #isUpdateMID()
	 * @generated
	 */
	void setUpdateMID(boolean value);

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
	 * <!-- begin-user-doc --> Finds all input models that can be used as actual parameters to run this operator type.
	 * 
	 * @param inputMIDs
	 *            A list of MIDs where to look for input models. If it's one MID then all input models are taken from
	 *            it, otherwise each formal parameter is matched to a MID and input models are taken accordingly.
	 * @return A set of inputs to the operator, including necessary conversions.
	 * @throws MMINTException
	 *             If this is an operator instance. <!-- end-user-doc -->
	 * @model dataType=
	 *        "edu.toronto.cs.se.mmint.mid.operator.Set<org.eclipse.emf.ecore.EEList<edu.toronto.cs.se.mmint.mid.operator.OperatorInput>>"
	 *        required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputMIDsMany="true"
	 * @generated
	 */
	Set<EList<OperatorInput>> findAllowedInputs(EList<MultiModel> inputMIDs) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Checks if a list of input models can be used as actual parameters to run this operator
	 * type.
	 * 
	 * @param inputModels
	 *            The list of input models.
	 * @return The list of inputs to the operator, including necessary conversions.
	 * @throws MMINTException
	 *             If this is an operator instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputModelsMany="true"
	 * @generated
	 */
	EList<OperatorInput> checkAllowedInputs(EList<Model> inputModels) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds an operator instance of
	 * this operator type to an Instance MID.
	 * 
	 * @param instanceMID
	 *            An Instance MID, null if the operator isn't going to be added
	 *            to it.
	 * @return The created operator.
	 * @throws MMINTException
	 *             If this is an operator instance. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	Operator createInstance(MultiModel instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes this operator instance from an Instance MID.
	 * 
	 * @throws MMINTException
	 *             If this is an operator type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteInstance() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Checks if a generic type is allowed for this operator type.
	 * 
	 * @param genericTypeEndpoint
	 *            The generic type endpoint.
	 * @param genericType
	 *            The generic type.
	 * @param inputs
	 *            The list of inputs.
	 * @return Always true.
	 * @throws MMINTException
	 *             If this is an operator instance. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" genericTypeEndpointRequired="true" genericTypeRequired="true" inputsMany="true"
	 * @generated
	 */
	boolean isAllowedTargetGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, EList<OperatorInput> inputs) throws MMINTException;

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
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputPropertiesDataType="edu.toronto.cs.se.mmint.mid.operator.Properties" inputPropertiesRequired="true"
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
	 * <!-- begin-user-doc --> Runs this operator instance. This function contains the logic of the operator and must be
	 * overridden.
	 * 
	 * @param inputsByName
	 *            The input model instances, identified by their formal parameter name.
	 * @param genericsByName
	 *            The generic types, identified by their metatype name.
	 * @param outputMIDsByName
	 *            The instance MIDs where the output models are created, identified by the output name. A null instance
	 *            MID means that the output model isn't added to it.
	 * @return The output model instances, identified by their name.
	 * @throws Exception
	 *             If something went wrong running the operator. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception" inputsByNameRequired="true" genericsByNameRequired="true" outputMIDsByNameRequired="true"
	 * @generated
	 */
	Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName, Map<String, MultiModel> outputMIDsByName) throws Exception;

	/**
	 * <!-- begin-user-doc --> Starts an instance of this operator type, i.e. runs conversions for the input models and
	 * then invokes readInputProperties(), init(), run().
	 * 
	 * @param inputs
	 *            A list of inputs to the operator instance, including necessary conversions.
	 * @param outputMIDsByName
	 *            The instance MIDs where the output models are created, identified by the output name. A null instance
	 *            MID means that the output model isn't added to it.
	 * @param instanceMID
	 *            The Instance MID where the operator instance is run, null if the operator isn't going to be added to
	 *            it.
	 * @return The output model instances, identified by their name.
	 * @throws Exception
	 *             If something went wrong starting the operator. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception" inputsMany="true" outputMIDsByNameRequired="true" instanceMIDRequired="true"
	 * @generated
	 */
	Map<String, Model> start(EList<OperatorInput> inputs, Map<String, MultiModel> outputMIDsByName, MultiModel instanceMID) throws Exception;

} // Operator
