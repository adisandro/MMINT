/**
 */
package edu.toronto.cs.se.mmint.productline.impl;

import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.Reference;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
    super(eNS_URI, ProductLineFactory.eINSTANCE);
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
    if (isInited)
      return (ProductLinePackage) EPackage.Registry.INSTANCE.getEPackage(ProductLinePackage.eNS_URI);

    // Obtain or create and register package
    Object registeredProductLinePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    ProductLinePackageImpl theProductLinePackage = registeredProductLinePackage instanceof ProductLinePackageImpl
      ? (ProductLinePackageImpl) registeredProductLinePackage
      : new ProductLinePackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theProductLinePackage.createPackageContents();

    // Initialize created meta-data
    theProductLinePackage.initializePackageContents();

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
    return productLineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getProductLine_Features() {
    return (EAttribute) productLineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProductLine_Classes() {
    return (EReference) productLineEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getProductLine_References() {
    return (EReference) productLineEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLElement() {
    return plElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPLElement_PresenceCondition() {
    return (EAttribute) plElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClass_() {
    return classEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_ReferencesAsSource() {
    return (EReference) classEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_ReferencesAsTargets() {
    return (EReference) classEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_Attributes() {
    return (EReference) classEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_Type() {
    return (EReference) classEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReference() {
    return referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Source() {
    return (EReference) referenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Targets() {
    return (EReference) referenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Type() {
    return (EReference) referenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAttribute() {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAttribute_Value() {
    return (EAttribute) attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAttribute_Type() {
    return (EReference) attributeEClass.getEStructuralFeatures().get(1);
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
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    productLineEClass = createEClass(PRODUCT_LINE);
    createEAttribute(productLineEClass, PRODUCT_LINE__FEATURES);
    createEReference(productLineEClass, PRODUCT_LINE__CLASSES);
    createEReference(productLineEClass, PRODUCT_LINE__REFERENCES);

    plElementEClass = createEClass(PL_ELEMENT);
    createEAttribute(plElementEClass, PL_ELEMENT__PRESENCE_CONDITION);

    classEClass = createEClass(CLASS);
    createEReference(classEClass, CLASS__REFERENCES_AS_SOURCE);
    createEReference(classEClass, CLASS__REFERENCES_AS_TARGETS);
    createEReference(classEClass, CLASS__ATTRIBUTES);
    createEReference(classEClass, CLASS__TYPE);

    referenceEClass = createEClass(REFERENCE);
    createEReference(referenceEClass, REFERENCE__SOURCE);
    createEReference(referenceEClass, REFERENCE__TARGETS);
    createEReference(referenceEClass, REFERENCE__TYPE);

    attributeEClass = createEClass(ATTRIBUTE);
    createEAttribute(attributeEClass, ATTRIBUTE__VALUE);
    createEReference(attributeEClass, ATTRIBUTE__TYPE);
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
    if (isInitialized)
      return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    classEClass.getESuperTypes().add(this.getPLElement());
    referenceEClass.getESuperTypes().add(this.getPLElement());
    attributeEClass.getESuperTypes().add(this.getPLElement());

    // Initialize classes and features; add operations and parameters
    initEClass(productLineEClass, ProductLine.class, "ProductLine", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProductLine_Features(), ecorePackage.getEString(), "features", null, 1, 1, ProductLine.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                   IS_ORDERED);
    initEReference(getProductLine_Classes(), this.getClass_(), null, "classes", null, 0, -1, ProductLine.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                   IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProductLine_References(), this.getReference(), null, "references", null, 0, -1, ProductLine.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                   IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(plElementEClass, PLElement.class, "PLElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPLElement_PresenceCondition(), ecorePackage.getEString(), "presenceCondition", null, 0, 1,
                   PLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                   !IS_DERIVED, IS_ORDERED);

    initEClass(classEClass, edu.toronto.cs.se.mmint.productline.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClass_ReferencesAsSource(), this.getReference(), this.getReference_Source(), "referencesAsSource",
                   null, 0, -1, edu.toronto.cs.se.mmint.productline.Class.class, !IS_TRANSIENT, !IS_VOLATILE,
                   IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                   IS_ORDERED);
    initEReference(getClass_ReferencesAsTargets(), this.getReference(), this.getReference_Targets(),
                   "referencesAsTargets", null, 0, -1, edu.toronto.cs.se.mmint.productline.Class.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                   !IS_DERIVED, IS_ORDERED);
    initEReference(getClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1,
                   edu.toronto.cs.se.mmint.productline.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                   IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClass_Type(), theEcorePackage.getEClass(), null, "type", null, 1, 1,
                   edu.toronto.cs.se.mmint.productline.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                   !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReference_Source(), this.getClass_(), this.getClass_ReferencesAsSource(), "source", null, 1, 1,
                   Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                   !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReference_Targets(), this.getClass_(), this.getClass_ReferencesAsTargets(), "targets", null, 1,
                   -1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                   !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReference_Type(), theEcorePackage.getEReference(), null, "type", null, 1, 1, Reference.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                   IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribute_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, Attribute.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                   IS_ORDERED);
    initEReference(getAttribute_Type(), theEcorePackage.getEAttribute(), null, "type", null, 1, 1, Attribute.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                   IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ProductLinePackageImpl
