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
package edu.toronto.cs.se.mmint.mavo.mavomid.impl;

import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDFactory;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;

import edu.toronto.cs.se.mmint.mid.MIDPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MAVOMIDPackageImpl extends EPackageImpl implements MAVOMIDPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavoModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavoModelElementEClass = null;

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
	 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MAVOMIDPackageImpl() {
		super(eNS_URI, MAVOMIDFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MAVOMIDPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MAVOMIDPackage init() {
		if (isInited) return (MAVOMIDPackage)EPackage.Registry.INSTANCE.getEPackage(MAVOMIDPackage.eNS_URI);

		// Obtain or create and register package
		MAVOMIDPackageImpl theMAVOMIDPackage = (MAVOMIDPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MAVOMIDPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MAVOMIDPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MAVOPackage.eINSTANCE.eClass();
		MIDPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMAVOMIDPackage.createPackageContents();

		// Initialize created meta-data
		theMAVOMIDPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMAVOMIDPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MAVOMIDPackage.eNS_URI, theMAVOMIDPackage);
		return theMAVOMIDPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAVOModel() {
		return mavoModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMAVOModel__CreateSubtype__String_String_String_boolean() {
		return mavoModelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMAVOModel__CreateInstance__String_MID() {
		return mavoModelEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMAVOModel__CreateInstanceAndEditor__String_MID() {
		return mavoModelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMAVOModel__ImportInstance__String_MID() {
		return mavoModelEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMAVOModel__ImportInstanceAndEditor__String_MID() {
		return mavoModelEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMAVOModel__ValidateInstanceInEditor__IValidationContext() {
		return mavoModelEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAVOModelElement() {
		return mavoModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOMIDFactory getMAVOMIDFactory() {
		return (MAVOMIDFactory)getEFactoryInstance();
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
		mavoModelEClass = createEClass(MAVO_MODEL);
		createEOperation(mavoModelEClass, MAVO_MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN);
		createEOperation(mavoModelEClass, MAVO_MODEL___CREATE_INSTANCE__STRING_MID);
		createEOperation(mavoModelEClass, MAVO_MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MID);
		createEOperation(mavoModelEClass, MAVO_MODEL___IMPORT_INSTANCE__STRING_MID);
		createEOperation(mavoModelEClass, MAVO_MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID);
		createEOperation(mavoModelEClass, MAVO_MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT);

		mavoModelElementEClass = createEClass(MAVO_MODEL_ELEMENT);
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
		MAVOPackage theMAVOPackage = (MAVOPackage)EPackage.Registry.INSTANCE.getEPackage(MAVOPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mavoModelEClass.getESuperTypes().add(theMIDPackage.getModel());
		mavoModelEClass.getESuperTypes().add(theMAVOPackage.getMAVORoot());
		mavoModelElementEClass.getESuperTypes().add(theMIDPackage.getModelElement());
		mavoModelElementEClass.getESuperTypes().add(theMAVOPackage.getMAVOElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(mavoModelEClass, MAVOModel.class, "MAVOModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getMAVOModel__CreateSubtype__String_String_String_boolean(), theMIDPackage.getModel(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintImplementation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isMetamodelExtension", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMAVOModel__CreateInstance__String_MID(), theMIDPackage.getModel(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMAVOModel__CreateInstanceAndEditor__String_MID(), theMIDPackage.getModel(), "createInstanceAndEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMAVOModel__ImportInstance__String_MID(), theMIDPackage.getModel(), "importInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "modelUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMAVOModel__ImportInstanceAndEditor__String_MID(), theMIDPackage.getModel(), "importInstanceAndEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "modelUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMAVOModel__ValidateInstanceInEditor__IValidationContext(), theMIDPackage.getIStatus(), "validateInstanceInEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getIValidationContext(), "context", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(mavoModelElementEClass, MAVOModelElement.class, "MAVOModelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MAVOMIDPackageImpl
