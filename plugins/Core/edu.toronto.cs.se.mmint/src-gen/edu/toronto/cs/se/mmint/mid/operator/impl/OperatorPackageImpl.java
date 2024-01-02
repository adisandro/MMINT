/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
    super(OperatorPackage.eNS_URI, OperatorFactory.eINSTANCE);
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
    if (OperatorPackageImpl.isInited) return (OperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);

    // Obtain or create and register package
    var registeredOperatorPackage = EPackage.Registry.INSTANCE.get(OperatorPackage.eNS_URI);
    var theOperatorPackage = registeredOperatorPackage instanceof OperatorPackageImpl ? (OperatorPackageImpl)registeredOperatorPackage : new OperatorPackageImpl();

    OperatorPackageImpl.isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);
    var theMIDPackage = (MIDPackageImpl)(registeredPackage instanceof MIDPackageImpl ? registeredPackage : MIDPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    var theRelationshipPackage = (RelationshipPackageImpl)(registeredPackage instanceof RelationshipPackageImpl ? registeredPackage : RelationshipPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
    var theEditorPackage = (EditorPackageImpl)(registeredPackage instanceof EditorPackageImpl ? registeredPackage : EditorPackage.eINSTANCE);

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
    @Override
    public EClass getOperator() {
    return this.operatorEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getOperator_Inputs() {
    return (EReference)this.operatorEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getOperator_Outputs() {
    return (EReference)this.operatorEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getOperator_Generics() {
    return (EReference)this.operatorEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOperator_WorkingPath() {
    return (EAttribute)this.operatorEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getOperator_ExecutionTime() {
    return (EAttribute)this.operatorEClass.getEStructuralFeatures().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getOperator_Commutative() {
    return (EAttribute)this.operatorEClass.getEStructuralFeatures().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__GetMetatype() {
    return this.operatorEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__GetSupertype() {
    return this.operatorEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__GetMIDContainer() {
    return this.operatorEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__GetTypeSignature__EList() {
    return this.operatorEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__CreateSubtype__String_String() {
    return this.operatorEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__DeleteType() {
    return this.operatorEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__OpenType() {
    return this.operatorEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__FindAllowedInputs__EList_EList() {
    return this.operatorEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__FindFirstAllowedInput__EList_EList() {
    return this.operatorEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__CheckAllowedInputs__EList() {
    return this.operatorEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__GetOutputsByName() {
    return this.operatorEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__GetOutputModels() {
    return this.operatorEClass.getEOperations().get(11);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__CreateInstance__MID() {
    return this.operatorEClass.getEOperations().get(12);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__DeleteInstance() {
    return this.operatorEClass.getEOperations().get(13);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__SelectAllowedGenerics__EList() {
    return this.operatorEClass.getEOperations().get(14);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__GetInputProperties() {
    return this.operatorEClass.getEOperations().get(15);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__ReadInputProperties__Properties() {
    return this.operatorEClass.getEOperations().get(16);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__Run__Map_Map_Map() {
    return this.operatorEClass.getEOperations().get(17);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__StartInstance__EList_Properties_EList_Map_MID() {
    return this.operatorEClass.getEOperations().get(18);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__OpenInstance() {
    return this.operatorEClass.getEOperations().get(19);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__CreateWorkflowInstance__MID() {
    return this.operatorEClass.getEOperations().get(20);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__DeleteWorkflowInstance() {
    return this.operatorEClass.getEOperations().get(21);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getOperator__CreateWorkflowInstanceOutputs__Operator_Map_Map_MID() {
    return this.operatorEClass.getEOperations().get(22);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__StartWorkflowInstance__EList_EList_MID() {
    return this.operatorEClass.getEOperations().get(23);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getOperator__OpenWorkflowInstance() {
    return this.operatorEClass.getEOperations().get(24);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getConversionOperator() {
    return this.conversionOperatorEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getConversionOperator__DeleteType() {
    return this.conversionOperatorEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getConversionOperator__Cleanup() {
    return this.conversionOperatorEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getRandomOperator() {
    return this.randomOperatorEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getRandomOperator_State() {
    return (EAttribute)this.randomOperatorEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getNestingOperator() {
    return this.nestingOperatorEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getNestingOperator_NestedMIDPath() {
    return (EAttribute)this.nestingOperatorEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getNestingOperator__GetNestedInstanceMID() {
    return this.nestingOperatorEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getNestingOperator__StartNestedInstance__Operator_EList_Properties_EList_Map() {
    return this.nestingOperatorEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getWorkflowOperator() {
    return this.workflowOperatorEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getWorkflowOperator__GetNestedWorkflowMID() {
    return this.workflowOperatorEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getGenericEndpoint() {
    return this.genericEndpointEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getGenericEndpoint_MetatargetUri() {
    return (EAttribute)this.genericEndpointEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getGenericEndpoint__GetSupertype() {
    return this.genericEndpointEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getGenericEndpoint__GetTarget() {
    return this.genericEndpointEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getGenericEndpoint__SetTarget__ExtendibleElement() {
    return this.genericEndpointEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getGenericEndpoint__GetMetatype() {
    return this.genericEndpointEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getGenericEndpoint__CreateInstance__GenericElement_Operator() {
    return this.genericEndpointEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getGenericEndpoint__CreateWorkflowInstance__GenericElement_Operator() {
    return this.genericEndpointEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getOperatorInput() {
    return this.operatorInputEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getOperatorInput_Model() {
    return (EReference)this.operatorInputEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getOperatorInput_Conversions() {
    return (EReference)this.operatorInputEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getOperatorInput_ModelTypeEndpoint() {
    return (EReference)this.operatorInputEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getOperatorGeneric() {
    return this.operatorGenericEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getOperatorGeneric_Generic() {
    return (EReference)this.operatorGenericEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getOperatorGeneric_GenericSuperTypeEndpoint() {
    return (EReference)this.operatorGenericEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getRandom() {
    return this.randomEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getException() {
    return this.exceptionEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getProperties() {
    return this.propertiesEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getSet() {
    return this.setEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
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
    if (this.isCreated) return;
    this.isCreated = true;

    // Create classes and their features
    this.operatorEClass = createEClass(OperatorPackage.OPERATOR);
    createEReference(this.operatorEClass, OperatorPackage.OPERATOR__INPUTS);
    createEReference(this.operatorEClass, OperatorPackage.OPERATOR__OUTPUTS);
    createEReference(this.operatorEClass, OperatorPackage.OPERATOR__GENERICS);
    createEAttribute(this.operatorEClass, OperatorPackage.OPERATOR__WORKING_PATH);
    createEAttribute(this.operatorEClass, OperatorPackage.OPERATOR__EXECUTION_TIME);
    createEAttribute(this.operatorEClass, OperatorPackage.OPERATOR__COMMUTATIVE);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___GET_METATYPE);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___GET_SUPERTYPE);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___GET_MID_CONTAINER);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___GET_TYPE_SIGNATURE__ELIST);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___CREATE_SUBTYPE__STRING_STRING);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___DELETE_TYPE);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___OPEN_TYPE);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___FIND_ALLOWED_INPUTS__ELIST_ELIST);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST_ELIST);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___CHECK_ALLOWED_INPUTS__ELIST);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___GET_OUTPUTS_BY_NAME);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___GET_OUTPUT_MODELS);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___CREATE_INSTANCE__MID);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___DELETE_INSTANCE);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___SELECT_ALLOWED_GENERICS__ELIST);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___GET_INPUT_PROPERTIES);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___RUN__MAP_MAP_MAP);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___START_INSTANCE__ELIST_PROPERTIES_ELIST_MAP_MID);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___OPEN_INSTANCE);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___CREATE_WORKFLOW_INSTANCE__MID);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___DELETE_WORKFLOW_INSTANCE);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___CREATE_WORKFLOW_INSTANCE_OUTPUTS__OPERATOR_MAP_MAP_MID);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___START_WORKFLOW_INSTANCE__ELIST_ELIST_MID);
    createEOperation(this.operatorEClass, OperatorPackage.OPERATOR___OPEN_WORKFLOW_INSTANCE);

    this.conversionOperatorEClass = createEClass(OperatorPackage.CONVERSION_OPERATOR);
    createEOperation(this.conversionOperatorEClass, OperatorPackage.CONVERSION_OPERATOR___DELETE_TYPE);
    createEOperation(this.conversionOperatorEClass, OperatorPackage.CONVERSION_OPERATOR___CLEANUP);

    this.randomOperatorEClass = createEClass(OperatorPackage.RANDOM_OPERATOR);
    createEAttribute(this.randomOperatorEClass, OperatorPackage.RANDOM_OPERATOR__STATE);

    this.nestingOperatorEClass = createEClass(OperatorPackage.NESTING_OPERATOR);
    createEAttribute(this.nestingOperatorEClass, OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH);
    createEOperation(this.nestingOperatorEClass, OperatorPackage.NESTING_OPERATOR___GET_NESTED_INSTANCE_MID);
    createEOperation(this.nestingOperatorEClass, OperatorPackage.NESTING_OPERATOR___START_NESTED_INSTANCE__OPERATOR_ELIST_PROPERTIES_ELIST_MAP);

    this.workflowOperatorEClass = createEClass(OperatorPackage.WORKFLOW_OPERATOR);
    createEOperation(this.workflowOperatorEClass, OperatorPackage.WORKFLOW_OPERATOR___GET_NESTED_WORKFLOW_MID);

    this.genericEndpointEClass = createEClass(OperatorPackage.GENERIC_ENDPOINT);
    createEAttribute(this.genericEndpointEClass, OperatorPackage.GENERIC_ENDPOINT__METATARGET_URI);
    createEOperation(this.genericEndpointEClass, OperatorPackage.GENERIC_ENDPOINT___GET_SUPERTYPE);
    createEOperation(this.genericEndpointEClass, OperatorPackage.GENERIC_ENDPOINT___GET_TARGET);
    createEOperation(this.genericEndpointEClass, OperatorPackage.GENERIC_ENDPOINT___SET_TARGET__EXTENDIBLEELEMENT);
    createEOperation(this.genericEndpointEClass, OperatorPackage.GENERIC_ENDPOINT___GET_METATYPE);
    createEOperation(this.genericEndpointEClass, OperatorPackage.GENERIC_ENDPOINT___CREATE_INSTANCE__GENERICELEMENT_OPERATOR);
    createEOperation(this.genericEndpointEClass, OperatorPackage.GENERIC_ENDPOINT___CREATE_WORKFLOW_INSTANCE__GENERICELEMENT_OPERATOR);

    this.operatorInputEClass = createEClass(OperatorPackage.OPERATOR_INPUT);
    createEReference(this.operatorInputEClass, OperatorPackage.OPERATOR_INPUT__MODEL);
    createEReference(this.operatorInputEClass, OperatorPackage.OPERATOR_INPUT__CONVERSIONS);
    createEReference(this.operatorInputEClass, OperatorPackage.OPERATOR_INPUT__MODEL_TYPE_ENDPOINT);

    this.operatorGenericEClass = createEClass(OperatorPackage.OPERATOR_GENERIC);
    createEReference(this.operatorGenericEClass, OperatorPackage.OPERATOR_GENERIC__GENERIC);
    createEReference(this.operatorGenericEClass, OperatorPackage.OPERATOR_GENERIC__GENERIC_SUPER_TYPE_ENDPOINT);

    // Create data types
    this.randomEDataType = createEDataType(OperatorPackage.RANDOM);
    this.exceptionEDataType = createEDataType(OperatorPackage.EXCEPTION);
    this.propertiesEDataType = createEDataType(OperatorPackage.PROPERTIES);
    this.setEDataType = createEDataType(OperatorPackage.SET);
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
    if (this.isInitialized) return;
    this.isInitialized = true;

    // Initialize package
    setName(OperatorPackage.eNAME);
    setNsPrefix(OperatorPackage.eNS_PREFIX);
    setNsURI(OperatorPackage.eNS_URI);

    // Obtain other dependent packages
    var theMIDPackage = (MIDPackage)EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);

    // Create type parameters
    addETypeParameter(this.setEDataType, "E");

    // Set bounds for type parameters

    // Add supertypes to classes
    this.operatorEClass.getESuperTypes().add(theMIDPackage.getGenericElement());
    this.conversionOperatorEClass.getESuperTypes().add(this.getOperator());
    this.randomOperatorEClass.getESuperTypes().add(this.getOperator());
    this.nestingOperatorEClass.getESuperTypes().add(this.getOperator());
    this.workflowOperatorEClass.getESuperTypes().add(this.getNestingOperator());
    this.genericEndpointEClass.getESuperTypes().add(theMIDPackage.getExtendibleElementEndpoint());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.operatorEClass, Operator.class, "Operator", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperator_Inputs(), theMIDPackage.getModelEndpoint(), null, "inputs", null, 0, -1, Operator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getOperator_Outputs(), theMIDPackage.getModelEndpoint(), null, "outputs", null, 0, -1, Operator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getOperator_Generics(), this.getGenericEndpoint(), null, "generics", null, 0, -1, Operator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getOperator_WorkingPath(), this.ecorePackage.getEString(), "workingPath", null, 0, 1, Operator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getOperator_ExecutionTime(), this.ecorePackage.getELong(), "executionTime", null, 1, 1, Operator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getOperator_Commutative(), this.ecorePackage.getEBoolean(), "commutative", null, 1, 1, Operator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getOperator__GetMetatype(), this.getOperator(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getOperator__GetSupertype(), this.getOperator(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getOperator__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    var op = initEOperation(getOperator__GetTypeSignature__EList(), this.ecorePackage.getEString(), "getTypeSignature", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__CreateSubtype__String_String(), this.getOperator(), "createSubtype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newOperatorTypeName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "implementationPath", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__DeleteType(), null, "deleteType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__OpenType(), null, "openType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    op = initEOperation(getOperator__FindAllowedInputs__EList_EList(), null, "findAllowedInputs", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "inputMIDs", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    var g1 = createEGenericType(this.getSet());
    var g2 = createEGenericType(theMIDPackage.getModel());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "inputModelBlacklists", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());
    g1 = createEGenericType(this.getSet());
    g2 = createEGenericType(this.ecorePackage.getEEList());
    g1.getETypeArguments().add(g2);
    var g3 = createEGenericType(this.getOperatorInput());
    g2.getETypeArguments().add(g3);
    initEOperation(op, g1);

    op = initEOperation(getOperator__FindFirstAllowedInput__EList_EList(), this.getOperatorInput(), "findFirstAllowedInput", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "inputMIDs", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.getSet());
    g2 = createEGenericType(theMIDPackage.getModel());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "inputModelBlacklists", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__CheckAllowedInputs__EList(), this.getOperatorInput(), "checkAllowedInputs", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "inputModels", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__GetOutputsByName(), null, "getOutputsByName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getModel());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getOperator__GetOutputModels(), theMIDPackage.getModel(), "getOutputModels", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__CreateInstance__MID(), this.getOperator(), "createInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__DeleteInstance(), null, "deleteInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__SelectAllowedGenerics__EList(), this.getOperatorGeneric(), "selectAllowedGenerics", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEOperation(getOperator__GetInputProperties(), this.getProperties(), "getInputProperties", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getOperator__ReadInputProperties__Properties(), null, "readInputProperties", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getProperties(), "inputProperties", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__Run__Map_Map_Map(), null, "run", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getModel());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "inputsByName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getGenericElement());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "genericsByName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getMID());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "outputMIDsByName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getModel());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getOperator__StartInstance__EList_Properties_EList_Map_MID(), this.getOperator(), "startInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getProperties(), "inputProperties", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperatorGeneric(), "generics", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getMID());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "outputMIDsByName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    op = initEOperation(getOperator__OpenInstance(), null, "openInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    op = initEOperation(getOperator__CreateWorkflowInstance__MID(), this.getOperator(), "createWorkflowInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__DeleteWorkflowInstance(), null, "deleteWorkflowInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__CreateWorkflowInstanceOutputs__Operator_Map_Map_MID(), null, "createWorkflowInstanceOutputs", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperator(), "newOperator", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getGenericElement());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "genericsByName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getModel());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "inputsByName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "workflowMID", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__StartWorkflowInstance__EList_EList_MID(), this.getOperator(), "startWorkflowInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperatorGeneric(), "generics", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getOperator__OpenWorkflowInstance(), null, "openWorkflowInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    initEClass(this.conversionOperatorEClass, ConversionOperator.class, "ConversionOperator", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    op = initEOperation(getConversionOperator__DeleteType(), null, "deleteType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getConversionOperator__Cleanup(), null, "cleanup", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    initEClass(this.randomOperatorEClass, RandomOperator.class, "RandomOperator", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRandomOperator_State(), this.getRandom(), "state", null, 1, 1, RandomOperator.class, EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.nestingOperatorEClass, NestingOperator.class, "NestingOperator", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNestingOperator_NestedMIDPath(), this.ecorePackage.getEString(), "nestedMIDPath", null, 1, 1, NestingOperator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    op = initEOperation(getNestingOperator__GetNestedInstanceMID(), theMIDPackage.getMID(), "getNestedInstanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getNestingOperator__StartNestedInstance__Operator_EList_Properties_EList_Map(), this.getOperator(), "startNestedInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperator(), "nestedOperatorType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getProperties(), "inputProperties", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperatorGeneric(), "generics", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.ecorePackage.getEMap());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(theMIDPackage.getMID());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "outputMIDsByName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    initEClass(this.workflowOperatorEClass, WorkflowOperator.class, "WorkflowOperator", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    op = initEOperation(getWorkflowOperator__GetNestedWorkflowMID(), theMIDPackage.getMID(), "getNestedWorkflowMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.genericEndpointEClass, GenericEndpoint.class, "GenericEndpoint", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGenericEndpoint_MetatargetUri(), this.ecorePackage.getEString(), "metatargetUri", null, 1, 1, GenericEndpoint.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getGenericEndpoint__GetSupertype(), this.getGenericEndpoint(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getGenericEndpoint__GetTarget(), theMIDPackage.getGenericElement(), "getTarget", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getGenericEndpoint__SetTarget__ExtendibleElement(), null, "setTarget", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getExtendibleElement(), "newTarget", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getGenericEndpoint__GetMetatype(), this.getGenericEndpoint(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getGenericEndpoint__CreateInstance__GenericElement_Operator(), this.getGenericEndpoint(), "createInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getGenericElement(), "targetGeneric", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperator(), "containerOperator", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getGenericEndpoint__CreateWorkflowInstance__GenericElement_Operator(), this.getGenericEndpoint(), "createWorkflowInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getGenericElement(), "targetGeneric", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getOperator(), "containerOperator", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.operatorInputEClass, OperatorInput.class, "OperatorInput", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperatorInput_Model(), theMIDPackage.getModel(), null, "model", null, 1, 1, OperatorInput.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getOperatorInput_Conversions(), this.getConversionOperator(), null, "conversions", null, 0, -1, OperatorInput.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getOperatorInput_ModelTypeEndpoint(), theMIDPackage.getModelEndpoint(), null, "modelTypeEndpoint", null, 1, 1, OperatorInput.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.operatorGenericEClass, OperatorGeneric.class, "OperatorGeneric", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperatorGeneric_Generic(), theMIDPackage.getGenericElement(), null, "generic", null, 1, 1, OperatorGeneric.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getOperatorGeneric_GenericSuperTypeEndpoint(), this.getGenericEndpoint(), null, "genericSuperTypeEndpoint", null, 1, 1, OperatorGeneric.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    // Initialize data types
    initEDataType(this.randomEDataType, Random.class, "Random", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.exceptionEDataType, Exception.class, "Exception", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.propertiesEDataType, Properties.class, "Properties", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.setEDataType, Set.class, "Set", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
  }

} //OperatorPackageImpl
