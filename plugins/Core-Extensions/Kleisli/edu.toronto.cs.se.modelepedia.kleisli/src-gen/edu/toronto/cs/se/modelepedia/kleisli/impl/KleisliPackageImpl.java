/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.modelepedia.kleisli.BinaryKleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliFactory;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

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
	private EClass kleisliModelEClass = null;

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
	private EClass binaryKleisliModelRelEClass = null;

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
	private EClass kleisliModelEndpointReferenceEClass = null;

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
    Object registeredKleisliPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    KleisliPackageImpl theKleisliPackage = registeredKleisliPackage instanceof KleisliPackageImpl ? (KleisliPackageImpl)registeredKleisliPackage : new KleisliPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    MIDPackage.eINSTANCE.eClass();

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
	@Override
  public EClass getKleisliModel() {
    return kleisliModelEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModel__KleisliCreateType__KleisliModelEndpoint() {
    return kleisliModelEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModel__DeleteType() {
    return kleisliModelEClass.getEOperations().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModel__GetEMFTypeRoot() {
    return kleisliModelEClass.getEOperations().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModel__KleisliCreateInstance__KleisliModelEndpoint() {
    return kleisliModelEClass.getEOperations().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModel__DeleteInstance() {
    return kleisliModelEClass.getEOperations().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getKleisliModelRel() {
    return kleisliModelRelEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getKleisliModelRel_ExtendedUri() {
    return (EAttribute)kleisliModelRelEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelRel__CopySubtype__ModelRel() {
    return kleisliModelRelEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelRel__DeleteType() {
    return kleisliModelRelEClass.getEOperations().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelRel__DeleteInstance() {
    return kleisliModelRelEClass.getEOperations().get(6);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getBinaryKleisliModelRel() {
    return binaryKleisliModelRelEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelRel__OpenType() {
    return kleisliModelRelEClass.getEOperations().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelRel__OpenInstance() {
    return kleisliModelRelEClass.getEOperations().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelRel__GetOutlineResourceTypes() {
    return kleisliModelRelEClass.getEOperations().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelRel__GetOutlineResourceInstances() {
    return kleisliModelRelEClass.getEOperations().get(5);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getKleisliModelEndpoint() {
    return kleisliModelEndpointEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getKleisliModelEndpoint_ExtendedTarget() {
    return (EReference)kleisliModelEndpointEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getKleisliModelEndpoint_ExtendedTargetUri() {
    return (EAttribute)kleisliModelEndpointEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelEndpoint__CreateSubtype__String_Model_boolean_ModelRel() {
    return kleisliModelEndpointEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelEndpoint__ReplaceSubtype__ModelEndpoint_String_Model() {
    return kleisliModelEndpointEClass.getEOperations().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelEndpoint__DeleteType__boolean() {
    return kleisliModelEndpointEClass.getEOperations().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelEndpoint__CreateInstance__Model_ModelRel() {
    return kleisliModelEndpointEClass.getEOperations().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelEndpoint__ReplaceInstance__ModelEndpoint_Model() {
    return kleisliModelEndpointEClass.getEOperations().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelEndpoint__DeleteInstance__boolean() {
    return kleisliModelEndpointEClass.getEOperations().get(5);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getKleisliModelEndpointReference() {
    return kleisliModelEndpointReferenceEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getKleisliModelEndpointReference_ExtendedTargetUri() {
    return (EAttribute)kleisliModelEndpointReferenceEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelEndpointReference__AcceptModelElementType__EObject() {
    return kleisliModelEndpointReferenceEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getKleisliModelEndpointReference__AcceptModelElementInstance__EObject() {
    return kleisliModelEndpointReferenceEClass.getEOperations().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
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
    kleisliModelEClass = createEClass(KLEISLI_MODEL);
    createEOperation(kleisliModelEClass, KLEISLI_MODEL___KLEISLI_CREATE_TYPE__KLEISLIMODELENDPOINT);
    createEOperation(kleisliModelEClass, KLEISLI_MODEL___DELETE_TYPE);
    createEOperation(kleisliModelEClass, KLEISLI_MODEL___GET_EMF_TYPE_ROOT);
    createEOperation(kleisliModelEClass, KLEISLI_MODEL___KLEISLI_CREATE_INSTANCE__KLEISLIMODELENDPOINT);
    createEOperation(kleisliModelEClass, KLEISLI_MODEL___DELETE_INSTANCE);

    kleisliModelEndpointEClass = createEClass(KLEISLI_MODEL_ENDPOINT);
    createEReference(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET);
    createEAttribute(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT__EXTENDED_TARGET_URI);
    createEOperation(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT___CREATE_SUBTYPE__STRING_MODEL_BOOLEAN_MODELREL);
    createEOperation(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT___REPLACE_SUBTYPE__MODELENDPOINT_STRING_MODEL);
    createEOperation(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT___DELETE_TYPE__BOOLEAN);
    createEOperation(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_MODELREL);
    createEOperation(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT___REPLACE_INSTANCE__MODELENDPOINT_MODEL);
    createEOperation(kleisliModelEndpointEClass, KLEISLI_MODEL_ENDPOINT___DELETE_INSTANCE__BOOLEAN);

    kleisliModelRelEClass = createEClass(KLEISLI_MODEL_REL);
    createEAttribute(kleisliModelRelEClass, KLEISLI_MODEL_REL__EXTENDED_URI);
    createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___COPY_SUBTYPE__MODELREL);
    createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___OPEN_TYPE);
    createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_TYPES);
    createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___DELETE_TYPE);
    createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___OPEN_INSTANCE);
    createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES);
    createEOperation(kleisliModelRelEClass, KLEISLI_MODEL_REL___DELETE_INSTANCE);

    binaryKleisliModelRelEClass = createEClass(BINARY_KLEISLI_MODEL_REL);

    kleisliModelEndpointReferenceEClass = createEClass(KLEISLI_MODEL_ENDPOINT_REFERENCE);
    createEAttribute(kleisliModelEndpointReferenceEClass, KLEISLI_MODEL_ENDPOINT_REFERENCE__EXTENDED_TARGET_URI);
    createEOperation(kleisliModelEndpointReferenceEClass, KLEISLI_MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT);
    createEOperation(kleisliModelEndpointReferenceEClass, KLEISLI_MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT);
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
    RelationshipPackage theRelationshipPackage = (RelationshipPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    OperatorPackage theOperatorPackage = (OperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    kleisliModelEClass.getESuperTypes().add(theMIDPackage.getModel());
    kleisliModelEndpointEClass.getESuperTypes().add(theMIDPackage.getModelEndpoint());
    kleisliModelRelEClass.getESuperTypes().add(theRelationshipPackage.getModelRel());
    binaryKleisliModelRelEClass.getESuperTypes().add(this.getKleisliModelRel());
    binaryKleisliModelRelEClass.getESuperTypes().add(theRelationshipPackage.getBinaryModelRel());
    kleisliModelEndpointReferenceEClass.getESuperTypes().add(theRelationshipPackage.getModelEndpointReference());

    // Initialize classes, features, and operations; add parameters
    initEClass(kleisliModelEClass, KleisliModel.class, "KleisliModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    EOperation op = initEOperation(getKleisliModel__KleisliCreateType__KleisliModelEndpoint(), this.getKleisliModel(), "kleisliCreateType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getKleisliModelEndpoint(), "containerModelTypeEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModel__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModel__GetEMFTypeRoot(), ecorePackage.getEPackage(), "getEMFTypeRoot", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModel__KleisliCreateInstance__KleisliModelEndpoint(), this.getKleisliModel(), "kleisliCreateInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getKleisliModelEndpoint(), "containerModelEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModel__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(kleisliModelEndpointEClass, KleisliModelEndpoint.class, "KleisliModelEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getKleisliModelEndpoint_ExtendedTarget(), this.getKleisliModel(), null, "extendedTarget", null, 1, 1, KleisliModelEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKleisliModelEndpoint_ExtendedTargetUri(), ecorePackage.getEString(), "extendedTargetUri", null, 1, 1, KleisliModelEndpoint.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    op = initEOperation(getKleisliModelEndpoint__CreateSubtype__String_Model_boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "targetModelType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelEndpoint__ReplaceSubtype__ModelEndpoint_String_Model(), null, "replaceSubtype", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getModelEndpoint(), "oldModelTypeEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "targetModelType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelEndpoint__DeleteType__boolean(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelEndpoint__CreateInstance__Model_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelEndpoint__ReplaceInstance__ModelEndpoint_Model(), null, "replaceInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getModelEndpoint(), "oldModelEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelEndpoint__DeleteInstance__boolean(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(kleisliModelRelEClass, KleisliModelRel.class, "KleisliModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKleisliModelRel_ExtendedUri(), ecorePackage.getEString(), "extendedUri", null, 1, 1, KleisliModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = initEOperation(getKleisliModelRel__CopySubtype__ModelRel(), theRelationshipPackage.getModelRel(), "copySubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "origModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelRel__OpenType(), null, "openType", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    op = initEOperation(getKleisliModelRel__GetOutlineResourceTypes(), ecorePackage.getEResourceSet(), "getOutlineResourceTypes", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelRel__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelRel__OpenInstance(), null, "openInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    op = initEOperation(getKleisliModelRel__GetOutlineResourceInstances(), ecorePackage.getEResourceSet(), "getOutlineResourceInstances", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelRel__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(binaryKleisliModelRelEClass, BinaryKleisliModelRel.class, "BinaryKleisliModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(kleisliModelEndpointReferenceEClass, KleisliModelEndpointReference.class, "KleisliModelEndpointReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKleisliModelEndpointReference_ExtendedTargetUri(), ecorePackage.getEString(), "extendedTargetUri", null, 1, 1, KleisliModelEndpointReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    op = initEOperation(getKleisliModelEndpointReference__AcceptModelElementType__EObject(), ecorePackage.getEBoolean(), "acceptModelElementType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEObject(), "metamodelObj", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getKleisliModelEndpointReference__AcceptModelElementInstance__EObject(), theMIDPackage.getModelElement(), "acceptModelElementInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEObject(), "modelObj", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
    createPivotAnnotations();
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
      (getKleisliModelEndpoint_ExtendedTargetUri(),
       source,
       new String[] {
         "derivation", "extendedTarget.uri"
       });
    addAnnotation
      (getKleisliModelEndpointReference_ExtendedTargetUri(),
       source,
       new String[] {
         "derivation", "object.oclAsType(kleisli::KleisliModelEndpoint).extendedTargetUri"
       });
  }

} //KleisliPackageImpl
