/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.editor.impl.EditorPackageImpl;
import edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl;
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
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperatorPackageImpl extends EPackageImpl implements OperatorPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass conversionOperatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass randomOperatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nestingOperatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass workflowOperatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genericEndpointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operatorInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operatorGenericEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType randomEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType exceptionEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType propertiesEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType setEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private OperatorPackageImpl() {
        super(eNS_URI, OperatorFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link OperatorPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static OperatorPackage init() {
        if (isInited) return (OperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);

        // Obtain or create and register package
        OperatorPackageImpl theOperatorPackage = (OperatorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OperatorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OperatorPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        MIDPackageImpl theMIDPackage = (MIDPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI) instanceof MIDPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI) : MIDPackage.eINSTANCE);
        RelationshipPackageImpl theRelationshipPackage = (RelationshipPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI) instanceof RelationshipPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI) : RelationshipPackage.eINSTANCE);
        EditorPackageImpl theEditorPackage = (EditorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) instanceof EditorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) : EditorPackage.eINSTANCE);

        // Create package meta-data objects
        theOperatorPackage.createPackageContents();
        theMIDPackage.createPackageContents();
        theRelationshipPackage.createPackageContents();
        theEditorPackage.createPackageContents();

        // Initialize created meta-data
        theOperatorPackage.initializePackageContents();
        theMIDPackage.initializePackageContents();
        theRelationshipPackage.initializePackageContents();
        theEditorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theOperatorPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(OperatorPackage.eNS_URI, theOperatorPackage);
        return theOperatorPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperator() {
        return operatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperator_Inputs() {
        return (EReference)operatorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperator_Outputs() {
        return (EReference)operatorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperator_Generics() {
        return (EReference)operatorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperator_InputSubdir() {
        return (EAttribute)operatorEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperator_PreviousOperator() {
        return (EReference)operatorEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperator_UpdateMID() {
        return (EAttribute)operatorEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperator_ExecutionTime() {
        return (EAttribute)operatorEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperator_Commutative() {
        return (EAttribute)operatorEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__GetMetatype() {
        return operatorEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__GetSupertype() {
        return operatorEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__GetMIDContainer() {
        return operatorEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__GetTypeSignature() {
        return operatorEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__CreateSubtype__String_String() {
        return operatorEClass.getEOperations().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__DeleteType() {
        return operatorEClass.getEOperations().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__OpenType() {
        return operatorEClass.getEOperations().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__FindAllowedInputs__EList_EList() {
        return operatorEClass.getEOperations().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__FindFirstAllowedInput__EList_EList() {
        return operatorEClass.getEOperations().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__CheckAllowedInputs__EList() {
        return operatorEClass.getEOperations().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__GetOutputsByName() {
        return operatorEClass.getEOperations().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__GetOutputModels() {
        return operatorEClass.getEOperations().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__GetInstanceSignature__EList() {
        return operatorEClass.getEOperations().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__CreateInstance__MID() {
        return operatorEClass.getEOperations().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__DeleteInstance() {
        return operatorEClass.getEOperations().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__SelectAllowedGenerics__EList() {
        return operatorEClass.getEOperations().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__GetInputProperties() {
        return operatorEClass.getEOperations().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__ReadInputProperties__Properties() {
        return operatorEClass.getEOperations().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__Run__Map_Map_Map() {
        return operatorEClass.getEOperations().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__StartInstance__EList_Properties_EList_Map_MID() {
        return operatorEClass.getEOperations().get(19);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__OpenInstance() {
        return operatorEClass.getEOperations().get(20);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__CreateWorkflowInstance__MID() {
        return operatorEClass.getEOperations().get(21);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__DeleteWorkflowInstance() {
        return operatorEClass.getEOperations().get(22);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__CreateWorkflowInstanceOutputs__Operator_Map_MID() {
        return operatorEClass.getEOperations().get(23);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__StartWorkflowInstance__EList_EList_MID() {
        return operatorEClass.getEOperations().get(24);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getOperator__OpenWorkflowInstance() {
        return operatorEClass.getEOperations().get(25);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConversionOperator() {
        return conversionOperatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getConversionOperator__DeleteType() {
        return conversionOperatorEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getConversionOperator__Cleanup() {
        return conversionOperatorEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRandomOperator() {
        return randomOperatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRandomOperator_State() {
        return (EAttribute)randomOperatorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNestingOperator() {
        return nestingOperatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNestingOperator_NestedMIDPath() {
        return (EAttribute)nestingOperatorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getNestingOperator__GetNestedInstanceMID() {
        return nestingOperatorEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getNestingOperator__StartNestedInstance__Operator_EList_Properties_EList_Map() {
        return nestingOperatorEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWorkflowOperator() {
        return workflowOperatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getWorkflowOperator__GetNestedWorkflowMID() {
        return workflowOperatorEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenericEndpoint() {
        return genericEndpointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenericEndpoint_MetatargetUri() {
        return (EAttribute)genericEndpointEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getGenericEndpoint__GetSupertype() {
        return genericEndpointEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getGenericEndpoint__GetTarget() {
        return genericEndpointEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getGenericEndpoint__SetTarget__ExtendibleElement() {
        return genericEndpointEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getGenericEndpoint__GetMetatype() {
        return genericEndpointEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getGenericEndpoint__CreateInstance__GenericElement_Operator() {
        return genericEndpointEClass.getEOperations().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getGenericEndpoint__CreateWorkflowInstance__GenericElement_Operator() {
        return genericEndpointEClass.getEOperations().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperatorInput() {
        return operatorInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperatorInput_Model() {
        return (EReference)operatorInputEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperatorInput_Conversions() {
        return (EReference)operatorInputEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperatorInput_ModelTypeEndpoint() {
        return (EReference)operatorInputEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperatorGeneric() {
        return operatorGenericEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperatorGeneric_Generic() {
        return (EReference)operatorGenericEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperatorGeneric_GenericSuperTypeEndpoint() {
        return (EReference)operatorGenericEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getRandom() {
        return randomEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getException() {
        return exceptionEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getProperties() {
        return propertiesEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getSet() {
        return setEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperatorFactory getOperatorFactory() {
        return (OperatorFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        operatorEClass = createEClass(OPERATOR);
        createEReference(operatorEClass, OPERATOR__INPUTS);
        createEReference(operatorEClass, OPERATOR__OUTPUTS);
        createEReference(operatorEClass, OPERATOR__GENERICS);
        createEAttribute(operatorEClass, OPERATOR__INPUT_SUBDIR);
        createEReference(operatorEClass, OPERATOR__PREVIOUS_OPERATOR);
        createEAttribute(operatorEClass, OPERATOR__UPDATE_MID);
        createEAttribute(operatorEClass, OPERATOR__EXECUTION_TIME);
        createEAttribute(operatorEClass, OPERATOR__COMMUTATIVE);
        createEOperation(operatorEClass, OPERATOR___GET_METATYPE);
        createEOperation(operatorEClass, OPERATOR___GET_SUPERTYPE);
        createEOperation(operatorEClass, OPERATOR___GET_MID_CONTAINER);
        createEOperation(operatorEClass, OPERATOR___GET_TYPE_SIGNATURE);
        createEOperation(operatorEClass, OPERATOR___CREATE_SUBTYPE__STRING_STRING);
        createEOperation(operatorEClass, OPERATOR___DELETE_TYPE);
        createEOperation(operatorEClass, OPERATOR___OPEN_TYPE);
        createEOperation(operatorEClass, OPERATOR___FIND_ALLOWED_INPUTS__ELIST_ELIST);
        createEOperation(operatorEClass, OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST_ELIST);
        createEOperation(operatorEClass, OPERATOR___CHECK_ALLOWED_INPUTS__ELIST);
        createEOperation(operatorEClass, OPERATOR___GET_OUTPUTS_BY_NAME);
        createEOperation(operatorEClass, OPERATOR___GET_OUTPUT_MODELS);
        createEOperation(operatorEClass, OPERATOR___GET_INSTANCE_SIGNATURE__ELIST);
        createEOperation(operatorEClass, OPERATOR___CREATE_INSTANCE__MID);
        createEOperation(operatorEClass, OPERATOR___DELETE_INSTANCE);
        createEOperation(operatorEClass, OPERATOR___SELECT_ALLOWED_GENERICS__ELIST);
        createEOperation(operatorEClass, OPERATOR___GET_INPUT_PROPERTIES);
        createEOperation(operatorEClass, OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES);
        createEOperation(operatorEClass, OPERATOR___RUN__MAP_MAP_MAP);
        createEOperation(operatorEClass, OPERATOR___START_INSTANCE__ELIST_PROPERTIES_ELIST_MAP_MID);
        createEOperation(operatorEClass, OPERATOR___OPEN_INSTANCE);
        createEOperation(operatorEClass, OPERATOR___CREATE_WORKFLOW_INSTANCE__MID);
        createEOperation(operatorEClass, OPERATOR___DELETE_WORKFLOW_INSTANCE);
        createEOperation(operatorEClass, OPERATOR___CREATE_WORKFLOW_INSTANCE_OUTPUTS__OPERATOR_MAP_MID);
        createEOperation(operatorEClass, OPERATOR___START_WORKFLOW_INSTANCE__ELIST_ELIST_MID);
        createEOperation(operatorEClass, OPERATOR___OPEN_WORKFLOW_INSTANCE);

        conversionOperatorEClass = createEClass(CONVERSION_OPERATOR);
        createEOperation(conversionOperatorEClass, CONVERSION_OPERATOR___DELETE_TYPE);
        createEOperation(conversionOperatorEClass, CONVERSION_OPERATOR___CLEANUP);

        randomOperatorEClass = createEClass(RANDOM_OPERATOR);
        createEAttribute(randomOperatorEClass, RANDOM_OPERATOR__STATE);

        nestingOperatorEClass = createEClass(NESTING_OPERATOR);
        createEAttribute(nestingOperatorEClass, NESTING_OPERATOR__NESTED_MID_PATH);
        createEOperation(nestingOperatorEClass, NESTING_OPERATOR___GET_NESTED_INSTANCE_MID);
        createEOperation(nestingOperatorEClass, NESTING_OPERATOR___START_NESTED_INSTANCE__OPERATOR_ELIST_PROPERTIES_ELIST_MAP);

        workflowOperatorEClass = createEClass(WORKFLOW_OPERATOR);
        createEOperation(workflowOperatorEClass, WORKFLOW_OPERATOR___GET_NESTED_WORKFLOW_MID);

        genericEndpointEClass = createEClass(GENERIC_ENDPOINT);
        createEAttribute(genericEndpointEClass, GENERIC_ENDPOINT__METATARGET_URI);
        createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___GET_SUPERTYPE);
        createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___GET_TARGET);
        createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___SET_TARGET__EXTENDIBLEELEMENT);
        createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___GET_METATYPE);
        createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___CREATE_INSTANCE__GENERICELEMENT_OPERATOR);
        createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___CREATE_WORKFLOW_INSTANCE__GENERICELEMENT_OPERATOR);

        operatorInputEClass = createEClass(OPERATOR_INPUT);
        createEReference(operatorInputEClass, OPERATOR_INPUT__MODEL);
        createEReference(operatorInputEClass, OPERATOR_INPUT__CONVERSIONS);
        createEReference(operatorInputEClass, OPERATOR_INPUT__MODEL_TYPE_ENDPOINT);

        operatorGenericEClass = createEClass(OPERATOR_GENERIC);
        createEReference(operatorGenericEClass, OPERATOR_GENERIC__GENERIC);
        createEReference(operatorGenericEClass, OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT);

        // Create data types
        randomEDataType = createEDataType(RANDOM);
        exceptionEDataType = createEDataType(EXCEPTION);
        propertiesEDataType = createEDataType(PROPERTIES);
        setEDataType = createEDataType(SET);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        MIDPackage theMIDPackage = (MIDPackage)EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);

        // Create type parameters
        addETypeParameter(setEDataType, "E");

        // Set bounds for type parameters

        // Add supertypes to classes
        operatorEClass.getESuperTypes().add(theMIDPackage.getGenericElement());
        conversionOperatorEClass.getESuperTypes().add(this.getOperator());
        randomOperatorEClass.getESuperTypes().add(this.getOperator());
        nestingOperatorEClass.getESuperTypes().add(this.getOperator());
        workflowOperatorEClass.getESuperTypes().add(this.getNestingOperator());
        genericEndpointEClass.getESuperTypes().add(theMIDPackage.getExtendibleElementEndpoint());

        // Initialize classes, features, and operations; add parameters
        initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperator_Inputs(), theMIDPackage.getModelEndpoint(), null, "inputs", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperator_Outputs(), theMIDPackage.getModelEndpoint(), null, "outputs", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperator_Generics(), this.getGenericEndpoint(), null, "generics", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperator_InputSubdir(), ecorePackage.getEString(), "inputSubdir", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperator_PreviousOperator(), this.getOperator(), null, "previousOperator", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperator_UpdateMID(), ecorePackage.getEBoolean(), "updateMID", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperator_ExecutionTime(), ecorePackage.getELong(), "executionTime", null, 1, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperator_Commutative(), ecorePackage.getEBoolean(), "commutative", null, 1, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getOperator__GetMetatype(), this.getOperator(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getOperator__GetSupertype(), this.getOperator(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getOperator__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

        EOperation op = initEOperation(getOperator__GetTypeSignature(), ecorePackage.getEString(), "getTypeSignature", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__CreateSubtype__String_String(), this.getOperator(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "newOperatorTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "implementationPath", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__OpenType(), null, "openType", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, this.getException());

        op = initEOperation(getOperator__FindAllowedInputs__EList_EList(), null, "findAllowedInputs", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getMID(), "inputMIDs", 0, -1, IS_UNIQUE, IS_ORDERED);
        EGenericType g1 = createEGenericType(this.getSet());
        EGenericType g2 = createEGenericType(theMIDPackage.getModel());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "inputModelBlacklists", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());
        g1 = createEGenericType(this.getSet());
        g2 = createEGenericType(ecorePackage.getEEList());
        g1.getETypeArguments().add(g2);
        EGenericType g3 = createEGenericType(this.getOperatorInput());
        g2.getETypeArguments().add(g3);
        initEOperation(op, g1);

        op = initEOperation(getOperator__FindFirstAllowedInput__EList_EList(), this.getOperatorInput(), "findFirstAllowedInput", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getMID(), "inputMIDs", 0, -1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(this.getSet());
        g2 = createEGenericType(theMIDPackage.getModel());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "inputModelBlacklists", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__CheckAllowedInputs__EList(), this.getOperatorInput(), "checkAllowedInputs", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getModel(), "inputModels", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__GetOutputsByName(), null, "getOutputsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMIDPackage.getModel());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        op = initEOperation(getOperator__GetOutputModels(), theMIDPackage.getModel(), "getOutputModels", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__GetInstanceSignature__EList(), ecorePackage.getEString(), "getInstanceSignature", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__CreateInstance__MID(), this.getOperator(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__SelectAllowedGenerics__EList(), this.getOperatorGeneric(), "selectAllowedGenerics", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        initEOperation(getOperator__GetInputProperties(), this.getProperties(), "getInputProperties", 1, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getOperator__ReadInputProperties__Properties(), null, "readInputProperties", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getProperties(), "inputProperties", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__Run__Map_Map_Map(), null, "run", 1, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMIDPackage.getModel());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "inputsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMIDPackage.getGenericElement());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "genericsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMIDPackage.getMID());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "outputMIDsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, this.getException());
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMIDPackage.getModel());
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        op = initEOperation(getOperator__StartInstance__EList_Properties_EList_Map_MID(), this.getOperator(), "startInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getProperties(), "inputProperties", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperatorGeneric(), "generics", 0, -1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMIDPackage.getMID());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "outputMIDsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, this.getException());

        op = initEOperation(getOperator__OpenInstance(), null, "openInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, this.getException());

        op = initEOperation(getOperator__CreateWorkflowInstance__MID(), this.getOperator(), "createWorkflowInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__DeleteWorkflowInstance(), null, "deleteWorkflowInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__CreateWorkflowInstanceOutputs__Operator_Map_MID(), null, "createWorkflowInstanceOutputs", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperator(), "newOperator", 1, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMIDPackage.getModel());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "inputsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getMID(), "workflowMID", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__StartWorkflowInstance__EList_EList_MID(), this.getOperator(), "startWorkflowInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperatorGeneric(), "generics", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getOperator__OpenWorkflowInstance(), null, "openWorkflowInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, this.getException());

        initEClass(conversionOperatorEClass, ConversionOperator.class, "ConversionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = initEOperation(getConversionOperator__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getConversionOperator__Cleanup(), null, "cleanup", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, this.getException());

        initEClass(randomOperatorEClass, RandomOperator.class, "RandomOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRandomOperator_State(), this.getRandom(), "state", null, 1, 1, RandomOperator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(nestingOperatorEClass, NestingOperator.class, "NestingOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNestingOperator_NestedMIDPath(), ecorePackage.getEString(), "nestedMIDPath", null, 1, 1, NestingOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getNestingOperator__GetNestedInstanceMID(), theMIDPackage.getMID(), "getNestedInstanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getNestingOperator__StartNestedInstance__Operator_EList_Properties_EList_Map(), this.getOperator(), "startNestedInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperator(), "nestedOperatorType", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getProperties(), "inputProperties", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperatorGeneric(), "generics", 0, -1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theMIDPackage.getMID());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "outputMIDsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, this.getException());

        initEClass(workflowOperatorEClass, WorkflowOperator.class, "WorkflowOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = initEOperation(getWorkflowOperator__GetNestedWorkflowMID(), theMIDPackage.getMID(), "getNestedWorkflowMID", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        initEClass(genericEndpointEClass, GenericEndpoint.class, "GenericEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGenericEndpoint_MetatargetUri(), ecorePackage.getEString(), "metatargetUri", null, 1, 1, GenericEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getGenericEndpoint__GetSupertype(), this.getGenericEndpoint(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getGenericEndpoint__GetTarget(), theMIDPackage.getGenericElement(), "getTarget", 1, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getGenericEndpoint__SetTarget__ExtendibleElement(), null, "setTarget", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getExtendibleElement(), "newTarget", 1, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getGenericEndpoint__GetMetatype(), this.getGenericEndpoint(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getGenericEndpoint__CreateInstance__GenericElement_Operator(), this.getGenericEndpoint(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getGenericElement(), "targetGeneric", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperator(), "containerOperator", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        op = initEOperation(getGenericEndpoint__CreateWorkflowInstance__GenericElement_Operator(), this.getGenericEndpoint(), "createWorkflowInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theMIDPackage.getGenericElement(), "targetGeneric", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getOperator(), "containerOperator", 1, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theMIDPackage.getMMINTException());

        initEClass(operatorInputEClass, OperatorInput.class, "OperatorInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperatorInput_Model(), theMIDPackage.getModel(), null, "model", null, 1, 1, OperatorInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperatorInput_Conversions(), this.getConversionOperator(), null, "conversions", null, 0, -1, OperatorInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperatorInput_ModelTypeEndpoint(), theMIDPackage.getModelEndpoint(), null, "modelTypeEndpoint", null, 1, 1, OperatorInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operatorGenericEClass, OperatorGeneric.class, "OperatorGeneric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperatorGeneric_Generic(), theMIDPackage.getGenericElement(), null, "generic", null, 1, 1, OperatorGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperatorGeneric_GenericSuperTypeEndpoint(), this.getGenericEndpoint(), null, "genericSuperTypeEndpoint", null, 1, 1, OperatorGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(randomEDataType, Random.class, "Random", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(exceptionEDataType, Exception.class, "Exception", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(propertiesEDataType, Properties.class, "Properties", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(setEDataType, Set.class, "Set", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    }

} //OperatorPackageImpl
