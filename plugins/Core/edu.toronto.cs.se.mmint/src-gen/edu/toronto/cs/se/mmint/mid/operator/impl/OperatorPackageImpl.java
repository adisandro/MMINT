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
package edu.toronto.cs.se.mmint.mid.operator.impl;

import java.util.Properties;
import java.util.Random;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.editor.impl.EditorPackageImpl;
import edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;
import edu.toronto.cs.se.mmint.mid.operator.util.OperatorValidator;
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

		// Initialize simple dependencies
		MAVOPackage.eINSTANCE.eClass();

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

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theOperatorPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return OperatorValidator.INSTANCE;
				 }
			 });

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
	public EOperation getOperator__DeleteType() {
		return operatorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__CheckAllowedInputs__EList() {
		return operatorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__CreateInstance__MultiModel() {
		return operatorEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__DeleteInstance() {
		return operatorEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__IsAllowedTargetGeneric__GenericEndpoint_GenericElement_EList() {
		return operatorEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__GetInputProperties() {
		return operatorEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__ReadInputProperties__Properties() {
		return operatorEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__Init() {
		return operatorEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__Run__Map_Map_Map() {
		return operatorEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperator__Start__EList_Map_MultiModel() {
		return operatorEClass.getEOperations().get(11);
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
		createEOperation(operatorEClass, OPERATOR___GET_METATYPE);
		createEOperation(operatorEClass, OPERATOR___GET_SUPERTYPE);
		createEOperation(operatorEClass, OPERATOR___DELETE_TYPE);
		createEOperation(operatorEClass, OPERATOR___CHECK_ALLOWED_INPUTS__ELIST);
		createEOperation(operatorEClass, OPERATOR___CREATE_INSTANCE__MULTIMODEL);
		createEOperation(operatorEClass, OPERATOR___DELETE_INSTANCE);
		createEOperation(operatorEClass, OPERATOR___IS_ALLOWED_TARGET_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST);
		createEOperation(operatorEClass, OPERATOR___GET_INPUT_PROPERTIES);
		createEOperation(operatorEClass, OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES);
		createEOperation(operatorEClass, OPERATOR___INIT);
		createEOperation(operatorEClass, OPERATOR___RUN__MAP_MAP_MAP);
		createEOperation(operatorEClass, OPERATOR___START__ELIST_MAP_MULTIMODEL);

		conversionOperatorEClass = createEClass(CONVERSION_OPERATOR);
		createEOperation(conversionOperatorEClass, CONVERSION_OPERATOR___DELETE_TYPE);
		createEOperation(conversionOperatorEClass, CONVERSION_OPERATOR___CLEANUP);

		randomOperatorEClass = createEClass(RANDOM_OPERATOR);
		createEAttribute(randomOperatorEClass, RANDOM_OPERATOR__STATE);

		genericEndpointEClass = createEClass(GENERIC_ENDPOINT);
		createEAttribute(genericEndpointEClass, GENERIC_ENDPOINT__METATARGET_URI);
		createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___GET_SUPERTYPE);
		createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___GET_TARGET);
		createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___SET_TARGET__EXTENDIBLEELEMENT);
		createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___GET_METATYPE);
		createEOperation(genericEndpointEClass, GENERIC_ENDPOINT___CREATE_INSTANCE__GENERICELEMENT_OPERATOR);

		operatorInputEClass = createEClass(OPERATOR_INPUT);
		createEReference(operatorInputEClass, OPERATOR_INPUT__MODEL);
		createEReference(operatorInputEClass, OPERATOR_INPUT__CONVERSIONS);
		createEReference(operatorInputEClass, OPERATOR_INPUT__MODEL_TYPE_ENDPOINT);

		// Create data types
		randomEDataType = createEDataType(RANDOM);
		exceptionEDataType = createEDataType(EXCEPTION);
		propertiesEDataType = createEDataType(PROPERTIES);
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

		// Set bounds for type parameters

		// Add supertypes to classes
		operatorEClass.getESuperTypes().add(theMIDPackage.getGenericElement());
		conversionOperatorEClass.getESuperTypes().add(this.getOperator());
		randomOperatorEClass.getESuperTypes().add(this.getOperator());
		genericEndpointEClass.getESuperTypes().add(theMIDPackage.getExtendibleElementEndpoint());

		// Initialize classes, features, and operations; add parameters
		initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperator_Inputs(), theMIDPackage.getModelEndpoint(), null, "inputs", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_Outputs(), theMIDPackage.getModelEndpoint(), null, "outputs", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_Generics(), this.getGenericEndpoint(), null, "generics", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_InputSubdir(), ecorePackage.getEString(), "inputSubdir", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_PreviousOperator(), this.getOperator(), null, "previousOperator", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_UpdateMID(), ecorePackage.getEBoolean(), "updateMID", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOperator__GetMetatype(), this.getOperator(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getOperator__GetSupertype(), this.getOperator(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getOperator__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getOperator__CheckAllowedInputs__EList(), this.getOperatorInput(), "checkAllowedInputs", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getModel(), "inputModels", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getOperator__CreateInstance__MultiModel(), this.getOperator(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMultiModel(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getOperator__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getOperator__IsAllowedTargetGeneric__GenericEndpoint_GenericElement_EList(), ecorePackage.getEBoolean(), "isAllowedTargetGeneric", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGenericEndpoint(), "genericTypeEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getGenericElement(), "genericType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEOperation(getOperator__GetInputProperties(), this.getProperties(), "getInputProperties", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getOperator__ReadInputProperties__Properties(), null, "readInputProperties", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProperties(), "inputProperties", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getOperator__Init(), null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getOperator__Run__Map_Map_Map(), null, "run", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
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
		g2 = createEGenericType(theMIDPackage.getMultiModel());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "outputMIDsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMIDPackage.getModel());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getOperator__Start__EList_Map_MultiModel(), null, "start", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperatorInput(), "inputs", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMIDPackage.getMultiModel());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "outputMIDsByName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMultiModel(), "instanceMID", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());

		initEClass(conversionOperatorEClass, ConversionOperator.class, "ConversionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getConversionOperator__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getConversionOperator__Cleanup(), null, "cleanup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());

		initEClass(randomOperatorEClass, RandomOperator.class, "RandomOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomOperator_State(), this.getRandom(), "state", null, 1, 1, RandomOperator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(operatorInputEClass, OperatorInput.class, "OperatorInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorInput_Model(), theMIDPackage.getModel(), null, "model", null, 1, 1, OperatorInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperatorInput_Conversions(), this.getConversionOperator(), null, "conversions", null, 0, -1, OperatorInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperatorInput_ModelTypeEndpoint(), theMIDPackage.getModelEndpoint(), null, "modelTypeEndpoint", null, 1, 1, OperatorInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(randomEDataType, Random.class, "Random", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(exceptionEDataType, Exception.class, "Exception", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(propertiesEDataType, Properties.class, "Properties", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });	
		addAnnotation
		  (conversionOperatorEClass, 
		   source, 
		   new String[] {
			 "constraints", "conversion"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";	
		addAnnotation
		  (conversionOperatorEClass, 
		   source, 
		   new String[] {
			 "conversion", "inputs->size() = 1 and outputs->size() = 1"
		   });
	}

} //OperatorPackageImpl
