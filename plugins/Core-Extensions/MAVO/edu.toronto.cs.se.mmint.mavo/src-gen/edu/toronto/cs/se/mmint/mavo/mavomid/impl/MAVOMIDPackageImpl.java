/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOBinaryMapping;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOBinaryMappingReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOBinaryModelRel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDFactory;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;

import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;

import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
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
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoModelRelEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoBinaryModelRelEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoModelEndpointEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoModelEndpointReferenceEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoMappingReferenceEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoBinaryMappingReferenceEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoMappingEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoBinaryMappingEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass mavoModelElementReferenceEClass = null;

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
    Object registeredMAVOMIDPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    MAVOMIDPackageImpl theMAVOMIDPackage = registeredMAVOMIDPackage instanceof MAVOMIDPackageImpl ? (MAVOMIDPackageImpl)registeredMAVOMIDPackage : new MAVOMIDPackageImpl();

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
	@Override
  public EClass getMAVOModel() {
    return mavoModelEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModel__CreateInstance__EObject_String_MID() {
    return mavoModelEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModel__ImportInstance__String_MID() {
    return mavoModelEClass.getEOperations().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModel__ValidateInstanceInEditor__IValidationContext() {
    return mavoModelEClass.getEOperations().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModel__ToMIDCustomPrintLabel() {
    return mavoModelEClass.getEOperations().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModel__ToMIDCustomEditLabel() {
    return mavoModelEClass.getEOperations().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModel__UpdateMIDCustomLabel__String() {
    return mavoModelEClass.getEOperations().get(5);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOModelElement() {
    return mavoModelElementEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModelElement__ToMIDCustomPrintLabel() {
    return mavoModelElementEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModelElement__ToMIDCustomEditLabel() {
    return mavoModelElementEClass.getEOperations().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModelElement__UpdateMIDCustomLabel__String() {
    return mavoModelElementEClass.getEOperations().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOModelRel() {
    return mavoModelRelEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModelRel__CopyInstance__Model_String_MID() {
    return mavoModelRelEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOBinaryModelRel() {
    return mavoBinaryModelRelEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOModelEndpoint() {
    return mavoModelEndpointEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModelEndpoint__GetTarget() {
    return mavoModelEndpointEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOModelEndpointReference() {
    return mavoModelEndpointReferenceEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModelEndpointReference__GetObject() {
    return mavoModelEndpointReferenceEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String() {
    return mavoModelEndpointReferenceEClass.getEOperations().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOMappingReference() {
    return mavoMappingReferenceEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOMappingReference__GetObject() {
    return mavoMappingReferenceEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOBinaryMappingReference() {
    return mavoBinaryMappingReferenceEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOBinaryMappingReference__GetObject() {
    return mavoBinaryMappingReferenceEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOMapping() {
    return mavoMappingEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOMapping__ToMIDCustomPrintLabel() {
    return mavoMappingEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOMapping__ToMIDCustomEditLabel() {
    return mavoMappingEClass.getEOperations().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOMapping__UpdateMIDCustomLabel__String() {
    return mavoMappingEClass.getEOperations().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOBinaryMapping() {
    return mavoBinaryMappingEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getMAVOModelElementReference() {
    return mavoModelElementReferenceEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EOperation getMAVOModelElementReference__GetObject() {
    return mavoModelElementReferenceEClass.getEOperations().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
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
    createEOperation(mavoModelEClass, MAVO_MODEL___CREATE_INSTANCE__EOBJECT_STRING_MID);
    createEOperation(mavoModelEClass, MAVO_MODEL___IMPORT_INSTANCE__STRING_MID);
    createEOperation(mavoModelEClass, MAVO_MODEL___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT);
    createEOperation(mavoModelEClass, MAVO_MODEL___TO_MID_CUSTOM_PRINT_LABEL);
    createEOperation(mavoModelEClass, MAVO_MODEL___TO_MID_CUSTOM_EDIT_LABEL);
    createEOperation(mavoModelEClass, MAVO_MODEL___UPDATE_MID_CUSTOM_LABEL__STRING);

    mavoModelElementEClass = createEClass(MAVO_MODEL_ELEMENT);
    createEOperation(mavoModelElementEClass, MAVO_MODEL_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL);
    createEOperation(mavoModelElementEClass, MAVO_MODEL_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL);
    createEOperation(mavoModelElementEClass, MAVO_MODEL_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING);

    mavoModelRelEClass = createEClass(MAVO_MODEL_REL);
    createEOperation(mavoModelRelEClass, MAVO_MODEL_REL___COPY_INSTANCE__MODEL_STRING_MID);

    mavoBinaryModelRelEClass = createEClass(MAVO_BINARY_MODEL_REL);

    mavoModelEndpointEClass = createEClass(MAVO_MODEL_ENDPOINT);
    createEOperation(mavoModelEndpointEClass, MAVO_MODEL_ENDPOINT___GET_TARGET);

    mavoMappingEClass = createEClass(MAVO_MAPPING);
    createEOperation(mavoMappingEClass, MAVO_MAPPING___TO_MID_CUSTOM_PRINT_LABEL);
    createEOperation(mavoMappingEClass, MAVO_MAPPING___TO_MID_CUSTOM_EDIT_LABEL);
    createEOperation(mavoMappingEClass, MAVO_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING);

    mavoBinaryMappingEClass = createEClass(MAVO_BINARY_MAPPING);

    mavoModelElementReferenceEClass = createEClass(MAVO_MODEL_ELEMENT_REFERENCE);
    createEOperation(mavoModelElementReferenceEClass, MAVO_MODEL_ELEMENT_REFERENCE___GET_OBJECT);

    mavoModelEndpointReferenceEClass = createEClass(MAVO_MODEL_ENDPOINT_REFERENCE);
    createEOperation(mavoModelEndpointReferenceEClass, MAVO_MODEL_ENDPOINT_REFERENCE___GET_OBJECT);
    createEOperation(mavoModelEndpointReferenceEClass, MAVO_MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING);

    mavoMappingReferenceEClass = createEClass(MAVO_MAPPING_REFERENCE);
    createEOperation(mavoMappingReferenceEClass, MAVO_MAPPING_REFERENCE___GET_OBJECT);

    mavoBinaryMappingReferenceEClass = createEClass(MAVO_BINARY_MAPPING_REFERENCE);
    createEOperation(mavoBinaryMappingReferenceEClass, MAVO_BINARY_MAPPING_REFERENCE___GET_OBJECT);
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
    RelationshipPackage theRelationshipPackage = (RelationshipPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    mavoModelEClass.getESuperTypes().add(theMIDPackage.getModel());
    mavoModelEClass.getESuperTypes().add(theMAVOPackage.getMAVORoot());
    mavoModelElementEClass.getESuperTypes().add(theMIDPackage.getModelElement());
    mavoModelElementEClass.getESuperTypes().add(theMAVOPackage.getMAVOElement());
    mavoModelRelEClass.getESuperTypes().add(theRelationshipPackage.getModelRel());
    mavoBinaryModelRelEClass.getESuperTypes().add(theRelationshipPackage.getBinaryModelRel());
    mavoBinaryModelRelEClass.getESuperTypes().add(this.getMAVOModelRel());
    mavoModelEndpointEClass.getESuperTypes().add(theMIDPackage.getModelEndpoint());
    mavoMappingEClass.getESuperTypes().add(theRelationshipPackage.getMapping());
    mavoMappingEClass.getESuperTypes().add(theMAVOPackage.getMAVOElement());
    mavoBinaryMappingEClass.getESuperTypes().add(theRelationshipPackage.getBinaryMapping());
    mavoBinaryMappingEClass.getESuperTypes().add(this.getMAVOMapping());
    mavoModelElementReferenceEClass.getESuperTypes().add(theRelationshipPackage.getModelElementReference());
    mavoModelEndpointReferenceEClass.getESuperTypes().add(theRelationshipPackage.getModelEndpointReference());
    mavoMappingReferenceEClass.getESuperTypes().add(theRelationshipPackage.getMappingReference());
    mavoBinaryMappingReferenceEClass.getESuperTypes().add(theRelationshipPackage.getBinaryMappingReference());
    mavoBinaryMappingReferenceEClass.getESuperTypes().add(this.getMAVOMappingReference());

    // Initialize classes, features, and operations; add parameters
    initEClass(mavoModelEClass, MAVOModel.class, "MAVOModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    EOperation op = initEOperation(getMAVOModel__CreateInstance__EObject_String_MID(), theMIDPackage.getModel(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEObject(), "rootModelObj", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelPath", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());
    addEException(op, theMIDPackage.getIOException());

    op = initEOperation(getMAVOModel__ImportInstance__String_MID(), theMIDPackage.getModel(), "importInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "modelPath", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMAVOModel__ValidateInstanceInEditor__IValidationContext(), theMIDPackage.getIStatus(), "validateInstanceInEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getIValidationContext(), "context", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEOperation(getMAVOModel__ToMIDCustomPrintLabel(), ecorePackage.getEString(), "toMIDCustomPrintLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getMAVOModel__ToMIDCustomEditLabel(), ecorePackage.getEString(), "toMIDCustomEditLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getMAVOModel__UpdateMIDCustomLabel__String(), null, "updateMIDCustomLabel", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(mavoModelElementEClass, MAVOModelElement.class, "MAVOModelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getMAVOModelElement__ToMIDCustomPrintLabel(), ecorePackage.getEString(), "toMIDCustomPrintLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getMAVOModelElement__ToMIDCustomEditLabel(), ecorePackage.getEString(), "toMIDCustomEditLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getMAVOModelElement__UpdateMIDCustomLabel__String(), null, "updateMIDCustomLabel", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(mavoModelRelEClass, MAVOModelRel.class, "MAVOModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = initEOperation(getMAVOModelRel__CopyInstance__Model_String_MID(), theMIDPackage.getModel(), "copyInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "origModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(mavoBinaryModelRelEClass, MAVOBinaryModelRel.class, "MAVOBinaryModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mavoModelEndpointEClass, MAVOModelEndpoint.class, "MAVOModelEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getMAVOModelEndpoint__GetTarget(), this.getMAVOModel(), "getTarget", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(mavoMappingEClass, MAVOMapping.class, "MAVOMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getMAVOMapping__ToMIDCustomPrintLabel(), ecorePackage.getEString(), "toMIDCustomPrintLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getMAVOMapping__ToMIDCustomEditLabel(), ecorePackage.getEString(), "toMIDCustomEditLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getMAVOMapping__UpdateMIDCustomLabel__String(), null, "updateMIDCustomLabel", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(mavoBinaryMappingEClass, MAVOBinaryMapping.class, "MAVOBinaryMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mavoModelElementReferenceEClass, MAVOModelElementReference.class, "MAVOModelElementReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getMAVOModelElementReference__GetObject(), this.getMAVOModelElement(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(mavoModelEndpointReferenceEClass, MAVOModelEndpointReference.class, "MAVOModelEndpointReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getMAVOModelEndpointReference__GetObject(), this.getMAVOModelEndpoint(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getMAVOModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String(), theRelationshipPackage.getModelElementReference(), "createModelElementInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEObject(), "modelObj", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelElemName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(mavoMappingReferenceEClass, MAVOMappingReference.class, "MAVOMappingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getMAVOMappingReference__GetObject(), this.getMAVOMapping(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(mavoBinaryMappingReferenceEClass, MAVOBinaryMappingReference.class, "MAVOBinaryMappingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getMAVOBinaryMappingReference__GetObject(), this.getMAVOBinaryMapping(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //MAVOMIDPackageImpl
