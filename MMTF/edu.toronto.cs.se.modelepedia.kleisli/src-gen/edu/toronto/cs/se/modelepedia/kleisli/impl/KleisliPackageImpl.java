/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.kleisli.impl;

import edu.toronto.cs.se.mmtf.mavo.MavoPackage;

import edu.toronto.cs.se.mmtf.mid.MidPackage;

import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

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
public class KleisliPackageImpl extends EPackageImpl implements KleisliPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kleisliModelRelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kleisliModelEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kleisliBinaryModelRelEClass = null;

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
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private KleisliPackageImpl() {
		super(eNS_URI, KleisliFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link KleisliPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static KleisliPackage init() {
		if (isInited) return (KleisliPackage)EPackage.Registry.INSTANCE.getEPackage(KleisliPackage.eNS_URI);

		// Obtain or create and register package
		KleisliPackageImpl theKleisliPackage = (KleisliPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof KleisliPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new KleisliPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MidPackage.eINSTANCE.eClass();
		MavoPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theKleisliPackage.createPackageContents();

		// Initialize created meta-data
		theKleisliPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theKleisliPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(KleisliPackage.eNS_URI, theKleisliPackage);
		return theKleisliPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKleisliModelRel() {
		return kleisliModelRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getKleisliModelRel__CreateSubtype__String_boolean_String_String() {
		return kleisliModelRelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getKleisliModelRel__DeleteType() {
		return kleisliModelRelEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getKleisliModelRel__CreateInstance__String_boolean_ModelOrigin_MultiModel() {
		return kleisliModelRelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getKleisliModelRel__DeleteInstance() {
		return kleisliModelRelEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKleisliModelEndpoint() {
		return kleisliModelEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getKleisliModelEndpoint__CreateSubtypeAndReference__ModelEndpointReference_String_Model_boolean_ModelRel() {
		return kleisliModelEndpointEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getKleisliModelEndpoint__DeleteTypeAndReference__boolean() {
		return kleisliModelEndpointEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKleisliBinaryModelRel() {
		return kleisliBinaryModelRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliFactory getKleisliFactory() {
		return (KleisliFactory)getEFactoryInstance();
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
		kleisliModelRelEClass = createEClass(KLEISLI_MODEL_REL);
		createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING);
		createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___DELETE_TYPE);
		createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL);
		createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___DELETE_INSTANCE);

		kleisliModelEndpointEClass = createEClass(KLEISLI_MODEL_ENDPOINT);
		createEOperation(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__MODELENDPOINTREFERENCE_STRING_MODEL_BOOLEAN_MODELREL);
		createEOperation(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN);

		kleisliBinaryModelRelEClass = createEClass(KLEISLI_BINARY_MODEL_REL);
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
		RelationshipPackage theRelationshipPackage = (RelationshipPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
		MidPackage theMidPackage = (MidPackage)EPackage.Registry.INSTANCE.getEPackage(MidPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		kleisliModelRelEClass.getESuperTypes().add(theRelationshipPackage.getModelRel());
		kleisliModelEndpointEClass.getESuperTypes().add(theMidPackage.getModelEndpoint());
		kleisliBinaryModelRelEClass.getESuperTypes().add(theRelationshipPackage.getBinaryModelRel());
		kleisliBinaryModelRelEClass.getESuperTypes().add(this.getKleisliModelRel());

		// Initialize classes, features, and operations; add parameters
		initEClass(kleisliModelRelEClass, KleisliModelRel.class, "KleisliModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getKleisliModelRel__CreateSubtype__String_boolean_String_String(), theRelationshipPackage.getModelRel(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintImplementation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMTFException());

		op = initEOperation(getKleisliModelRel__DeleteType(), null, "deleteType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMTFException());

		op = initEOperation(getKleisliModelRel__CreateInstance__String_boolean_ModelOrigin_MultiModel(), theRelationshipPackage.getModelRel(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getModelOrigin(), "origin", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getMultiModel(), "containerMultiModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMTFException());

		op = initEOperation(getKleisliModelRel__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMTFException());

		initEClass(kleisliModelEndpointEClass, KleisliModelEndpoint.class, "KleisliModelEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getKleisliModelEndpoint__CreateSubtypeAndReference__ModelEndpointReference_String_Model_boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createSubtypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "modelTypeEndpointRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getModel(), "newModelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMTFException());

		op = initEOperation(getKleisliModelEndpoint__DeleteTypeAndReference__boolean(), null, "deleteTypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMTFException());

		initEClass(kleisliBinaryModelRelEClass, KleisliBinaryModelRel.class, "KleisliBinaryModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //KleisliPackageImpl
