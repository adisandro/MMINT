/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;

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
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getGenerics <em>Generics</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getWorkingPath <em>Working Path</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Operator#isCommutative <em>Commutative</em>}</li>
 * </ul>
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
   * Returns the value of the '<em><b>Working Path</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The path where the operator is working, e.g. where it creates its output models.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Working Path</em>' attribute.
   * @see #setWorkingPath(String)
   * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_WorkingPath()
   * @model
   * @generated
   */
    String getWorkingPath();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getWorkingPath <em>Working Path</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Working Path</em>' attribute.
   * @see #getWorkingPath()
   * @generated
   */
    void setWorkingPath(String value);

    /**
   * Returns the value of the '<em><b>Execution Time</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The execution time of this operator instance in nanoseconds (types: not used).
   * <!-- end-model-doc -->
   * @return the value of the '<em>Execution Time</em>' attribute.
   * @see #setExecutionTime(long)
   * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_ExecutionTime()
   * @model required="true"
   * @generated
   */
    long getExecutionTime();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#getExecutionTime <em>Execution Time</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execution Time</em>' attribute.
   * @see #getExecutionTime()
   * @generated
   */
    void setExecutionTime(long value);

    /**
   * Returns the value of the '<em><b>Commutative</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A flag to indicate if this operator is commutative, i.e. the order of input models doesn't matter.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Commutative</em>' attribute.
   * @see #setCommutative(boolean)
   * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getOperator_Commutative()
   * @model required="true"
   * @generated
   */
    boolean isCommutative();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Operator#isCommutative <em>Commutative</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Commutative</em>' attribute.
   * @see #isCommutative()
   * @generated
   */
    void setCommutative(boolean value);

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * {@inheritDoc}<br />
   * Gets the operator type of this operator instance.
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
    @Override
    Operator getMetatype();

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * {@inheritDoc}<br />
   * Gets the operator supertype of this operator type.
   * <!-- end-model-doc -->
   * @model kind="operation"
   * @generated
   */
    @Override
    Operator getSupertype();

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
    @Override
    MID getMIDContainer();

    /**
   * <!-- begin-user-doc --> Gets the signature of this operator type as a string, optionally with the given actual
     * inputs.
     *
     * @param inputs
     *            The actual inputs to this operator type, or null for a signature with formal parameters only.
     * @return The operator signature.
     * @throws MMINTException
     *             If this is not an operator type. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputsMany="true"
   * @generated
   */
    String getTypeSignature(EList<OperatorInput> inputs) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Creates and adds a subtype of this operator type to the Type MID.
     *
     * @param newOperatorTypeName
     *            The name of the new operator type.
     * @param implementationUri
     *            The uri of the new operator's implementation.
     * @return The created operator type.
     * @throws MMINTException
     *             If this is not an operator type, or if the uri of the new operator type is already registered in the
     *             Type MID. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newOperatorTypeNameRequired="true" implementationPathRequired="true"
   * @generated
   */
    Operator createSubtype(String newOperatorTypeName, String implementationPath) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Deletes this operator type from the Type MID.
     *
     * @throws MMINTException
     *             If this is not an operator type. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    void deleteType() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Opens the java implementation of this operator type.
     *
     * @throws Exception
     *             If this is not an operator type, or if the java editor can't be opened. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception"
   * @generated
   */
    void openType() throws Exception;

    /**
   * <!-- begin-user-doc --> Finds all inputs that can be used to run this operator type.
     *
     * @param inputMIDs
     *            A list of instance MIDs where to get input models. Each formal parameter gets input models from a
     *            different instance MID, following their order. If there are not enough instance MIDs, the last
     *            instance MID is used for all subsequent formal parameters.
     * @param inputModelBlacklists
     *            A List of blacklisted models not to be considered as input, following the same order as the inputMIDs.
     * @return A set of inputs to the operator, including necessary conversions.
     * @throws MMINTException
     *             If this is not an operator type. <!-- end-user-doc -->
   * @model dataType="edu.toronto.cs.se.mmint.mid.operator.Set&lt;org.eclipse.emf.ecore.EEList&lt;edu.toronto.cs.se.mmint.mid.operator.OperatorInput&gt;&gt;" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputMIDsMany="true" inputModelBlacklistsDataType="edu.toronto.cs.se.mmint.mid.operator.Set&lt;edu.toronto.cs.se.mmint.mid.Model&gt;" inputModelBlacklistsMany="true"
   * @generated
   */
    Set<EList<OperatorInput>> findAllowedInputs(EList<MID> inputMIDs, EList<Set<Model>> inputModelBlacklists) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Finds the first input that can be used to run this operator type.
     *
     * @param inputMIDs
     *            A list of instance MIDs where to get input models. Each formal parameter gets input models from a
     *            different instance MID, following their order. If there are not enough instance MIDs, the last
     *            instance MID is used for all subsequent formal parameters.
     * @param inputModelBlacklists
     *            A List of blacklisted models not to be considered as input, following the same order as the inputMIDs.
     * @return An input to the operator, including necessary conversions.
     * @throws MMINTException
     *             If this is not an operator type. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputMIDsMany="true" inputModelBlacklistsDataType="edu.toronto.cs.se.mmint.mid.operator.Set&lt;edu.toronto.cs.se.mmint.mid.Model&gt;" inputModelBlacklistsMany="true"
   * @generated
   */
    EList<OperatorInput> findFirstAllowedInput(EList<MID> inputMIDs, EList<Set<Model>> inputModelBlacklists) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Checks if a list of input models can be used as actual parameters to run this operator
     * type.
     *
     * @param inputModels
     *            The list of input models.
     * @return The input to run the operator, including necessary conversions, or null if the input models can't be
     *         used.
     * @throws MMINTException
     *             If this is not an operator type. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputModelsMany="true"
   * @generated
   */
    EList<OperatorInput> checkAllowedInputs(EList<Model> inputModels) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Gets the output model instances of this operator instance, if it has been previously run.
     *
     * @return The output model instances, identified by their formal parameter name.
     * @throws MMINTException
     *             If this is not an operator instance. <!-- end-user-doc -->
   * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    Map<String, Model> getOutputsByName() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Gets the output model instances of this operator instance, if it has been previously run.
     *
     * @return The output model instances.
     * @throws MMINTException
     *             If this is not an operator instance. <!-- end-user-doc -->
   * @model kind="operation" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    EList<Model> getOutputModels() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Creates and possibly adds an operator instance of this operator type to an Instance MID.
     *
     * @param instanceMID
     *            An Instance MID, null if the operator isn't going to be added to one.
     * @return The created operator.
     * @throws MMINTException
     *             If this is not an operator type. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    Operator createInstance(MID instanceMID) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Deletes this operator instance from an Instance MID.
     *
     * @throws MMINTException
     *             If this is not an operator instance. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    void deleteInstance() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Selects a list of generics to be used to run this operator type.
     *
     * @param inputs
     *            The list of operator inputs.
     * @return The generics to run the operator.
     * @throws MMINTException
     *             If this is not an operator type, or if a required generic has not been selected.
     *             <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputsMany="true"
   * @generated
   */
    EList<OperatorGeneric> selectAllowedGenerics(EList<OperatorInput> inputs) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Gets the input properties of this operator.
     *
     * @return The input properties of this operator. <!-- end-user-doc -->
   * @model kind="operation" dataType="edu.toronto.cs.se.mmint.mid.operator.Properties" required="true"
   * @generated
   */
    Properties getInputProperties();

    /**
   * <!-- begin-user-doc --> Reads the input properties of this operator instance. Used by
     * {@link #start(EList, Map, MID)}, may be overridden.
     *
     * @param inputProperties
     *            The input properties of this operator.
     * @throws MMINTException
     *             If any required property is not available, or if a property is not in its intended format.
     *             <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputPropertiesDataType="edu.toronto.cs.se.mmint.mid.operator.Properties" inputPropertiesRequired="true"
   * @generated
   */
    void readInputProperties(Properties inputProperties) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Runs this operator instance. This function contains the logic of the operator and must be
     * overridden.
     *
     * @param inputsByName
     *            The input model instances, identified by their formal parameter name.
     * @param genericsByName
     *            The generic types, identified by their metatype name.
     * @param outputMIDsByName
     *            The instance MIDs where the output models are created, identified by the output name. A null Instance
     *            MID means that the output model isn't added to it.
     * @return The output model instances, identified by their name.
     * @throws Exception
     *             If something went wrong running the operator. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception" inputsByNameRequired="true" genericsByNameRequired="true" outputMIDsByNameRequired="true"
   * @generated
   */
    Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName, Map<String, MID> outputMIDsByName) throws Exception;

    /**
   * <!-- begin-user-doc --> Starts an instance of this operator type, i.e. runs conversions for the input models,
     * creates an operator instance, invokes {@link #readInputProperties}, {@link #run}, records the execution time.
     *
     * @param inputs
     *            A list of inputs to run the operator instance, including necessary conversions.
     * @param inputProperties
     *            The input properties, or null to read them from a file named OperatorNameIn.properties.
     * @param generics
     *            A list of generics to run the operator instance.
     * @param outputMIDsByName
     *            The instance MIDs where the output models are created, identified by the output name. A null instance
     *            MID means that the output model isn't added to it.
     * @param instanceMID
     *            The Instance MID where the operator instance will run, null if the operator isn't going to be added to
     *            it.
     * @return The executed operator instance.
     * @throws Exception
     *             If this is not an operator type, or if something went wrong starting the operator.
     *             <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception" inputsMany="true" inputPropertiesDataType="edu.toronto.cs.se.mmint.mid.operator.Properties" genericsMany="true" outputMIDsByNameRequired="true"
   * @generated
   */
    Operator startInstance(EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName, MID instanceMID) throws Exception;

    /**
   * <!-- begin-user-doc --> Opens the java implementation of this operator instance.
     *
     * @throws Exception
     *             If this is not an operator instance, or if the java editor can't be opened. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception"
   * @generated
   */
    void openInstance() throws Exception;

    /**
   * <!-- begin-user-doc --> Creates and possibly adds an operator instance of this operator type to a Workflow MID.
     *
     * @param workflowMID
     *            A Workflow MID, null if the operator isn't going to be contained in one.
     * @return The created operator.
     * @throws MMINTException
     *             If this is not an operator type. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    Operator createWorkflowInstance(MID workflowMID) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Deletes this operator instance from a Workflow MID.
     *
     * @throws MMINTException
     *             If this is not an operator instance in a workflow. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
    void deleteWorkflowInstance() throws MMINTException;

    /**
   * <!-- begin-user-doc --> Creates the outputs of a new instance of this operator type in a workflow.
     *
     * @param newOperator
     *            The new instance of this operator type in a workflow.
     * @param genericsByName
     *            The generics, identified by their formal name.
     * @param inputsByName
     *            The input model instances, identified by their formal parameter name.
     * @param workflowMID
     *            A Workflow, null if the operator isn't going to be added to it.
     * @throws MMINTException
     *             If this is not an operator type, or if this operator type has a variable number of outputs and
     *             doesn't override this api. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newOperatorRequired="true" inputsByNameRequired="true" workflowMIDRequired="true"
   * @generated
   */
    void createWorkflowInstanceOutputs(Operator newOperator, Map<String, GenericElement> genericsByName, Map<String, Model> inputsByName, MID workflowMID) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Creates an instance of this operator type in a workflow, connects it to its inputs and
     * creates its outputs. This api must be overridden by operator types with a variable number of outputs.
     *
     * @param inputs
     *            A list of inputs to create the operator instance.
     * @param generics
     *            A list of generics to create the operator instance.
     * @param workflowMID
     *            A Workflow, null if the operator isn't going to be added to it.
     * @return The created operator instance.
     * @throws MMINTException
     *             If this is not an operator type. <!-- end-user-doc -->
   * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" inputsMany="true" genericsMany="true"
   * @generated
   */
    Operator startWorkflowInstance(EList<OperatorInput> inputs, EList<OperatorGeneric> generics, MID workflowMID) throws MMINTException;

    /**
   * <!-- begin-user-doc --> Opens the java implementation of this operator instance.
     *
     * @throws Exception
     *             If this is not an operator instance in a workflow, or if the java editor can't be opened. <!--
     *             end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception"
   * @generated
   */
    void openWorkflowInstance() throws Exception;

} // Operator
