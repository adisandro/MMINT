/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.mid.productline.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryModelRel;
import edu.toronto.cs.se.mmint.mid.productline.PLMIDFactory;
import edu.toronto.cs.se.mmint.mid.productline.PLMIDPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.impl.PLPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PLMIDPackageImpl extends EPackageImpl implements PLMIDPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plModelRelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plBinaryModelRelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plMappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plBinaryMappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plMappingReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plBinaryMappingReferenceEClass = null;

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
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMIDPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PLMIDPackageImpl() {
    super(PLMIDPackage.eNS_URI, PLMIDFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PLMIDPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PLMIDPackage init() {
    if (PLMIDPackageImpl.isInited) {
      return (PLMIDPackage) EPackage.Registry.INSTANCE.getEPackage(PLMIDPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredPLMIDPackage = EPackage.Registry.INSTANCE.get(PLMIDPackage.eNS_URI);
    var thePLMIDPackage = registeredPLMIDPackage instanceof PLMIDPackageImpl
      ? (PLMIDPackageImpl) registeredPLMIDPackage
      : new PLMIDPackageImpl();

    PLMIDPackageImpl.isInited = true;

    // Initialize simple dependencies
    MIDPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PLPackage.eNS_URI);
    var thePLPackage = (PLPackageImpl) (registeredPackage instanceof PLPackageImpl ? registeredPackage
      : PLPackage.eINSTANCE);

    // Create package meta-data objects
    thePLMIDPackage.createPackageContents();
    thePLPackage.createPackageContents();

    // Initialize created meta-data
    thePLMIDPackage.initializePackageContents();
    thePLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePLMIDPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PLMIDPackage.eNS_URI, thePLMIDPackage);
    return thePLMIDPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLModelRel() {
    return this.plModelRelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLBinaryModelRel() {
    return this.plBinaryModelRelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLMapping() {
    return this.plMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLMapping__ToMIDCustomPrintLabel() {
    return this.plMappingEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLMapping__ToMIDCustomEditLabel() {
    return this.plMappingEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLMapping__UpdateMIDCustomLabel__String() {
    return this.plMappingEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLBinaryMapping() {
    return this.plBinaryMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLMappingReference() {
    return this.plMappingReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLMappingReference__GetObject() {
    return this.plMappingReferenceEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLBinaryMappingReference() {
    return this.plBinaryMappingReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLBinaryMappingReference__GetObject() {
    return this.plBinaryMappingReferenceEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLMIDFactory getPLMIDFactory() {
    return (PLMIDFactory) getEFactoryInstance();
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
    if (this.isCreated) {
      return;
    }
    this.isCreated = true;

    // Create classes and their features
    this.plModelRelEClass = createEClass(PLMIDPackage.PL_MODEL_REL);

    this.plBinaryModelRelEClass = createEClass(PLMIDPackage.PL_BINARY_MODEL_REL);

    this.plMappingEClass = createEClass(PLMIDPackage.PL_MAPPING);
    createEOperation(this.plMappingEClass, PLMIDPackage.PL_MAPPING___TO_MID_CUSTOM_PRINT_LABEL);
    createEOperation(this.plMappingEClass, PLMIDPackage.PL_MAPPING___TO_MID_CUSTOM_EDIT_LABEL);
    createEOperation(this.plMappingEClass, PLMIDPackage.PL_MAPPING___UPDATE_MID_CUSTOM_LABEL__STRING);

    this.plBinaryMappingEClass = createEClass(PLMIDPackage.PL_BINARY_MAPPING);

    this.plMappingReferenceEClass = createEClass(PLMIDPackage.PL_MAPPING_REFERENCE);
    createEOperation(this.plMappingReferenceEClass, PLMIDPackage.PL_MAPPING_REFERENCE___GET_OBJECT);

    this.plBinaryMappingReferenceEClass = createEClass(PLMIDPackage.PL_BINARY_MAPPING_REFERENCE);
    createEOperation(this.plBinaryMappingReferenceEClass, PLMIDPackage.PL_BINARY_MAPPING_REFERENCE___GET_OBJECT);
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
    if (this.isInitialized) {
      return;
    }
    this.isInitialized = true;

    // Initialize package
    setName(PLMIDPackage.eNAME);
    setNsPrefix(PLMIDPackage.eNS_PREFIX);
    setNsURI(PLMIDPackage.eNS_URI);

    // Obtain other dependent packages
    var theRelationshipPackage = (RelationshipPackage) EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    var thePLPackage = (PLPackage) EPackage.Registry.INSTANCE.getEPackage(PLPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.plModelRelEClass.getESuperTypes().add(theRelationshipPackage.getModelRel());
    this.plBinaryModelRelEClass.getESuperTypes().add(theRelationshipPackage.getBinaryModelRel());
    this.plBinaryModelRelEClass.getESuperTypes().add(this.getPLModelRel());
    this.plMappingEClass.getESuperTypes().add(theRelationshipPackage.getMapping());
    this.plMappingEClass.getESuperTypes().add(thePLPackage.getPLElement());
    this.plBinaryMappingEClass.getESuperTypes().add(theRelationshipPackage.getBinaryMapping());
    this.plBinaryMappingEClass.getESuperTypes().add(this.getPLMapping());
    this.plMappingReferenceEClass.getESuperTypes().add(theRelationshipPackage.getMappingReference());
    this.plBinaryMappingReferenceEClass.getESuperTypes().add(theRelationshipPackage.getBinaryMappingReference());
    this.plBinaryMappingReferenceEClass.getESuperTypes().add(this.getPLMappingReference());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.plModelRelEClass, PLModelRel.class, "PLModelRel", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.plBinaryModelRelEClass, PLBinaryModelRel.class, "PLBinaryModelRel", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.plMappingEClass, PLMapping.class, "PLMapping", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getPLMapping__ToMIDCustomPrintLabel(), this.ecorePackage.getEString(), "toMIDCustomPrintLabel", 1, 1,
                   EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getPLMapping__ToMIDCustomEditLabel(), this.ecorePackage.getEString(), "toMIDCustomEditLabel", 1, 1,
                   EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    var op = initEOperation(getPLMapping__UpdateMIDCustomLabel__String(), null, "updateMIDCustomLabel", 0, 1,
                                   EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newLabel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.plBinaryMappingEClass, PLBinaryMapping.class, "PLBinaryMapping", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.plMappingReferenceEClass, PLMappingReference.class, "PLMappingReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getPLMappingReference__GetObject(), this.getPLMapping(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.plBinaryMappingReferenceEClass, PLBinaryMappingReference.class, "PLBinaryMappingReference", !EPackageImpl.IS_ABSTRACT,
               !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getPLBinaryMappingReference__GetObject(), this.getPLBinaryMapping(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE,
                   EPackageImpl.IS_ORDERED);

    // Create resource
    createResource(PLMIDPackage.eNS_URI);
  }

} //PLMIDPackageImpl
