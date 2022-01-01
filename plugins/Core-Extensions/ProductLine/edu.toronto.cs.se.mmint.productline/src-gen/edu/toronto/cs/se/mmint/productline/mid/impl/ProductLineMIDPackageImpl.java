/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.mid.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.impl.ProductLinePackageImpl;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMapping;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryModelRel;
import edu.toronto.cs.se.mmint.productline.mid.PLMapping;
import edu.toronto.cs.se.mmint.productline.mid.PLMappingReference;
import edu.toronto.cs.se.mmint.productline.mid.PLModelRel;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDFactory;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductLineMIDPackageImpl extends EPackageImpl implements ProductLineMIDPackage {
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
   * @see edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ProductLineMIDPackageImpl() {
    super(ProductLineMIDPackage.eNS_URI, ProductLineMIDFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ProductLineMIDPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ProductLineMIDPackage init() {
    if (ProductLineMIDPackageImpl.isInited)
      return (ProductLineMIDPackage) EPackage.Registry.INSTANCE.getEPackage(ProductLineMIDPackage.eNS_URI);

    // Obtain or create and register package
    var registeredProductLineMIDPackage = EPackage.Registry.INSTANCE.get(ProductLineMIDPackage.eNS_URI);
    var theProductLineMIDPackage = registeredProductLineMIDPackage instanceof ProductLineMIDPackageImpl
      ? (ProductLineMIDPackageImpl) registeredProductLineMIDPackage
      : new ProductLineMIDPackageImpl();

    ProductLineMIDPackageImpl.isInited = true;

    // Initialize simple dependencies
    MIDPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProductLinePackage.eNS_URI);
    var theProductLinePackage = (ProductLinePackageImpl) (registeredPackage instanceof ProductLinePackageImpl
      ? registeredPackage
      : ProductLinePackage.eINSTANCE);

    // Create package meta-data objects
    theProductLineMIDPackage.createPackageContents();
    theProductLinePackage.createPackageContents();

    // Initialize created meta-data
    theProductLineMIDPackage.initializePackageContents();
    theProductLinePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theProductLineMIDPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ProductLineMIDPackage.eNS_URI, theProductLineMIDPackage);
    return theProductLineMIDPackage;
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
  public EClass getPLBinaryMappingReference() {
    return this.plBinaryMappingReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProductLineMIDFactory getProductLineMIDFactory() {
    return (ProductLineMIDFactory) getEFactoryInstance();
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
    if (this.isCreated)
      return;
    this.isCreated = true;

    // Create classes and their features
    this.plModelRelEClass = createEClass(ProductLineMIDPackage.PL_MODEL_REL);

    this.plBinaryModelRelEClass = createEClass(ProductLineMIDPackage.PL_BINARY_MODEL_REL);

    this.plMappingEClass = createEClass(ProductLineMIDPackage.PL_MAPPING);

    this.plBinaryMappingEClass = createEClass(ProductLineMIDPackage.PL_BINARY_MAPPING);

    this.plMappingReferenceEClass = createEClass(ProductLineMIDPackage.PL_MAPPING_REFERENCE);

    this.plBinaryMappingReferenceEClass = createEClass(ProductLineMIDPackage.PL_BINARY_MAPPING_REFERENCE);
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
    if (this.isInitialized)
      return;
    this.isInitialized = true;

    // Initialize package
    setName(ProductLineMIDPackage.eNAME);
    setNsPrefix(ProductLineMIDPackage.eNS_PREFIX);
    setNsURI(ProductLineMIDPackage.eNS_URI);

    // Obtain other dependent packages
    var theRelationshipPackage = (RelationshipPackage) EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    var theProductLinePackage = (ProductLinePackage) EPackage.Registry.INSTANCE.getEPackage(ProductLinePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.plModelRelEClass.getESuperTypes().add(theRelationshipPackage.getModelRel());
    this.plBinaryModelRelEClass.getESuperTypes().add(theRelationshipPackage.getBinaryModelRel());
    this.plBinaryModelRelEClass.getESuperTypes().add(this.getPLModelRel());
    this.plMappingEClass.getESuperTypes().add(theRelationshipPackage.getMapping());
    this.plMappingEClass.getESuperTypes().add(theProductLinePackage.getPLElement());
    this.plBinaryMappingEClass.getESuperTypes().add(theRelationshipPackage.getBinaryMapping());
    this.plBinaryMappingEClass.getESuperTypes().add(this.getPLMapping());
    this.plMappingReferenceEClass.getESuperTypes().add(theRelationshipPackage.getMappingReference());
    this.plBinaryMappingReferenceEClass.getESuperTypes().add(theRelationshipPackage.getBinaryMappingReference());
    this.plBinaryMappingReferenceEClass.getESuperTypes().add(this.getPLMappingReference());

    // Initialize classes and features; add operations and parameters
    initEClass(this.plModelRelEClass, PLModelRel.class, "PLModelRel", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.plBinaryModelRelEClass, PLBinaryModelRel.class, "PLBinaryModelRel", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.plMappingEClass, PLMapping.class, "PLMapping", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    addEOperation(this.plMappingEClass, this.ecorePackage.getEString(), "toMIDCustomPrintLabel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    addEOperation(this.plMappingEClass, this.ecorePackage.getEString(), "toMIDCustomEditLabel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    var op = addEOperation(this.plMappingEClass, null, "updateMIDCustomLabel", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newLabel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.plBinaryMappingEClass, PLBinaryMapping.class, "PLBinaryMapping", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.plMappingReferenceEClass, PLMappingReference.class, "PLMappingReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    addEOperation(this.plMappingReferenceEClass, this.getPLMapping(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.plBinaryMappingReferenceEClass, PLBinaryMappingReference.class, "PLBinaryMappingReference", !EPackageImpl.IS_ABSTRACT,
               !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    addEOperation(this.plBinaryMappingReferenceEClass, this.getPLBinaryMapping(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    // Create resource
    createResource(ProductLineMIDPackage.eNS_URI);
  }

} //ProductLineMIDPackageImpl
