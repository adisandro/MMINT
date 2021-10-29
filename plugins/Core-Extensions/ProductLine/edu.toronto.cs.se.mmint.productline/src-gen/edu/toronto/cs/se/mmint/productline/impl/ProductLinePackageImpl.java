/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.Reference;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage;
import edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductLinePackageImpl extends EPackageImpl implements ProductLinePackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass productLineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

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
   * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ProductLinePackageImpl() {
    super(ProductLinePackage.eNS_URI, ProductLineFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ProductLinePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ProductLinePackage init() {
    if (ProductLinePackageImpl.isInited)
      return (ProductLinePackage) EPackage.Registry.INSTANCE.getEPackage(ProductLinePackage.eNS_URI);

    // Obtain or create and register package
    var registeredProductLinePackage = EPackage.Registry.INSTANCE.get(ProductLinePackage.eNS_URI);
    var theProductLinePackage = registeredProductLinePackage instanceof ProductLinePackageImpl
      ? (ProductLinePackageImpl) registeredProductLinePackage
      : new ProductLinePackageImpl();

    ProductLinePackageImpl.isInited = true;

    // Initialize simple dependencies
    MIDPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProductLineMIDPackage.eNS_URI);
    var theProductLineMIDPackage = (ProductLineMIDPackageImpl) (registeredPackage instanceof ProductLineMIDPackageImpl
      ? registeredPackage
      : ProductLineMIDPackage.eINSTANCE);

    // Create package meta-data objects
    theProductLinePackage.createPackageContents();
    theProductLineMIDPackage.createPackageContents();

    // Initialize created meta-data
    theProductLinePackage.initializePackageContents();
    theProductLineMIDPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theProductLinePackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ProductLinePackage.eNS_URI, theProductLinePackage);
    return theProductLinePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getProductLine() {
    return this.productLineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getProductLine_FeaturesConstraint() {
    return (EAttribute) this.productLineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getProductLine_ReasonerName() {
    return (EAttribute) this.productLineEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProductLine_Classes() {
    return (EReference) this.productLineEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProductLine_References() {
    return (EReference) this.productLineEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProductLine_Metamodel() {
    return (EReference) this.productLineEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLElement() {
    return this.plElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPLElement_PresenceCondition() {
    return (EAttribute) this.plElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClass_() {
    return this.classEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_ReferencesAsSource() {
    return (EReference) this.classEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_ReferencesAsTargets() {
    return (EReference) this.classEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_Attributes() {
    return (EReference) this.classEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_Type() {
    return (EReference) this.classEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReference() {
    return this.referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Source() {
    return (EReference) this.referenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Targets() {
    return (EReference) this.referenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Type() {
    return (EReference) this.referenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttribute() {
    return this.attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAttribute_Value() {
    return (EAttribute) this.attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttribute_Type() {
    return (EReference) this.attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProductLineFactory getProductLineFactory() {
    return (ProductLineFactory) getEFactoryInstance();
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
    this.productLineEClass = createEClass(ProductLinePackage.PRODUCT_LINE);
    createEAttribute(this.productLineEClass, ProductLinePackage.PRODUCT_LINE__FEATURES_CONSTRAINT);
    createEAttribute(this.productLineEClass, ProductLinePackage.PRODUCT_LINE__REASONER_NAME);
    createEReference(this.productLineEClass, ProductLinePackage.PRODUCT_LINE__CLASSES);
    createEReference(this.productLineEClass, ProductLinePackage.PRODUCT_LINE__REFERENCES);
    createEReference(this.productLineEClass, ProductLinePackage.PRODUCT_LINE__METAMODEL);

    this.plElementEClass = createEClass(ProductLinePackage.PL_ELEMENT);
    createEAttribute(this.plElementEClass, ProductLinePackage.PL_ELEMENT__PRESENCE_CONDITION);

    this.classEClass = createEClass(ProductLinePackage.CLASS);
    createEReference(this.classEClass, ProductLinePackage.CLASS__REFERENCES_AS_SOURCE);
    createEReference(this.classEClass, ProductLinePackage.CLASS__REFERENCES_AS_TARGETS);
    createEReference(this.classEClass, ProductLinePackage.CLASS__ATTRIBUTES);
    createEReference(this.classEClass, ProductLinePackage.CLASS__TYPE);

    this.referenceEClass = createEClass(ProductLinePackage.REFERENCE);
    createEReference(this.referenceEClass, ProductLinePackage.REFERENCE__SOURCE);
    createEReference(this.referenceEClass, ProductLinePackage.REFERENCE__TARGETS);
    createEReference(this.referenceEClass, ProductLinePackage.REFERENCE__TYPE);

    this.attributeEClass = createEClass(ProductLinePackage.ATTRIBUTE);
    createEAttribute(this.attributeEClass, ProductLinePackage.ATTRIBUTE__VALUE);
    createEReference(this.attributeEClass, ProductLinePackage.ATTRIBUTE__TYPE);
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
    setName(ProductLinePackage.eNAME);
    setNsPrefix(ProductLinePackage.eNS_PREFIX);
    setNsURI(ProductLinePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.classEClass.getESuperTypes().add(this.getPLElement());
    this.referenceEClass.getESuperTypes().add(this.getPLElement());
    this.attributeEClass.getESuperTypes().add(this.getPLElement());

    // Initialize classes and features; add operations and parameters
    initEClass(this.productLineEClass, ProductLine.class, "ProductLine", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProductLine_FeaturesConstraint(), this.ecorePackage.getEString(), "featuresConstraint", null, 1, 1,
                   ProductLine.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE,
                   !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getProductLine_ReasonerName(), this.ecorePackage.getEString(), "reasonerName", null, 1, 1,
                   ProductLine.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE,
                   !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getProductLine_Classes(), this.getClass_(), null, "classes", null, 0, -1, ProductLine.class,
                   !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
                   EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getProductLine_References(), this.getReference(), null, "references", null, 0, -1, ProductLine.class,
                   !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
                   EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getProductLine_Metamodel(), this.ecorePackage.getEPackage(), null, "metamodel", null, 1, 1,
                   ProductLine.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES,
                   !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.plElementEClass, PLElement.class, "PLElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPLElement_PresenceCondition(), this.ecorePackage.getEString(), "presenceCondition", "true", 0, 1,
                   PLElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE,
                   !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.classEClass, edu.toronto.cs.se.mmint.productline.Class.class, "Class", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClass_ReferencesAsSource(), this.getReference(), this.getReference_Source(), "referencesAsSource",
                   null, 0, -1, edu.toronto.cs.se.mmint.productline.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE,
                   EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED,
                   EPackageImpl.IS_ORDERED);
    initEReference(getClass_ReferencesAsTargets(), this.getReference(), this.getReference_Targets(),
                   "referencesAsTargets", null, 0, -1, edu.toronto.cs.se.mmint.productline.Class.class, !EPackageImpl.IS_TRANSIENT,
                   !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE,
                   !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1,
                   edu.toronto.cs.se.mmint.productline.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE,
                   EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_Type(), this.ecorePackage.getEClass(), null, "type", null, 1, 1,
                   edu.toronto.cs.se.mmint.productline.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE,
                   !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.referenceEClass, Reference.class, "Reference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReference_Source(), this.getClass_(), this.getClass_ReferencesAsSource(), "source", null, 1, 1,
                   Reference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES,
                   !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getReference_Targets(), this.getClass_(), this.getClass_ReferencesAsTargets(), "targets", null, 1,
                   -1, Reference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES,
                   !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getReference_Type(), this.ecorePackage.getEReference(), null, "type", null, 1, 1, Reference.class,
                   !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
                   EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.attributeEClass, Attribute.class, "Attribute", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribute_Value(), this.ecorePackage.getEString(), "value", null, 1, 1, Attribute.class, !EPackageImpl.IS_TRANSIENT,
                   !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getAttribute_Type(), this.ecorePackage.getEAttribute(), null, "type", null, 1, 1, Attribute.class,
                   !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
                   EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    // Create resource
    createResource(ProductLinePackage.eNS_URI);
  }

} //ProductLinePackageImpl
