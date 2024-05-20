/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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

import java.util.stream.Stream;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.productline.MIDPLPackage;
import edu.toronto.cs.se.mmint.mid.productline.impl.MIDPLPackageImpl;
import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.Reference;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PLPackageImpl extends EPackageImpl implements PLPackage {
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType mmintExceptionEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iplFeaturesTraitEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType streamEDataType = null;

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
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PLPackageImpl() {
    super(PLPackage.eNS_URI, PLFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PLPackage init() {
    if (PLPackageImpl.isInited) {
      return (PLPackage) EPackage.Registry.INSTANCE.getEPackage(PLPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredPLPackage = EPackage.Registry.INSTANCE.get(PLPackage.eNS_URI);
    var thePLPackage = registeredPLPackage instanceof PLPackageImpl ? (PLPackageImpl) registeredPLPackage
      : new PLPackageImpl();

    PLPackageImpl.isInited = true;

    // Initialize simple dependencies
    MIDPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MIDPLPackage.eNS_URI);
    var theMIDPLPackage = (MIDPLPackageImpl) (registeredPackage instanceof MIDPLPackageImpl
      ? registeredPackage
      : MIDPLPackage.eINSTANCE);

    // Create package meta-data objects
    thePLPackage.createPackageContents();
    theMIDPLPackage.createPackageContents();

    // Initialize created meta-data
    thePLPackage.initializePackageContents();
    theMIDPLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePLPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PLPackage.eNS_URI, thePLPackage);
    return thePLPackage;
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
  public EReference getProductLine_Metamodel() {
    return (EReference) this.productLineEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getProductLine__GetReasoner() {
    return this.productLineEClass.getEOperations().get(0);
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
  public EOperation getPLElement__GetProductLine() {
    return this.plElementEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLElement__IsAlwaysPresent() {
    return this.plElementEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLElement__GetPresenceConditionLabel__boolean() {
    return this.plElementEClass.getEOperations().get(2);
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
  public EReference getClass_Attributes() {
    return (EReference) this.classEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_References() {
    return (EReference) this.classEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClass_ReferencesAsTarget() {
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
  public EOperation getClass__GetStreamOfReference__EReference() {
    return this.classEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__GetReference__EReference() {
    return this.classEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__AddReference__EReference_Class_String() {
    return this.classEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__AddReference__EReference_Class() {
    return this.classEClass.getEOperations().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__SetReference__EReference_Class() {
    return this.classEClass.getEOperations().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__GetStreamOfAttribute__EAttribute() {
    return this.classEClass.getEOperations().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__GetAttribute__EAttribute() {
    return this.classEClass.getEOperations().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__GetManyAttribute__EAttribute() {
    return this.classEClass.getEOperations().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__AddAttribute__EAttribute_String() {
    return this.classEClass.getEOperations().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__AddManyAttribute__EAttribute_EList() {
    return this.classEClass.getEOperations().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__SetAttribute__EAttribute_String() {
    return this.classEClass.getEOperations().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__SetManyAttribute__EAttribute_EList() {
    return this.classEClass.getEOperations().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__InstanceOf__EClass() {
    return this.classEClass.getEOperations().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__GetEContainer() {
    return this.classEClass.getEOperations().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getClass__Delete() {
    return this.classEClass.getEOperations().get(14);
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
  public EReference getReference_Target() {
    return (EReference) this.referenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReference_Type() {
    return (EReference) this.referenceEClass.getEStructuralFeatures().get(1);
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
  public EDataType getMMINTException() {
    return this.mmintExceptionEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getIPLFeaturesTrait() {
    return this.iplFeaturesTraitEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getStream() {
    return this.streamEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLFactory getPLFactory() {
    return (PLFactory) getEFactoryInstance();
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
    this.productLineEClass = createEClass(PLPackage.PRODUCT_LINE);
    createEAttribute(this.productLineEClass, PLPackage.PRODUCT_LINE__FEATURES_CONSTRAINT);
    createEAttribute(this.productLineEClass, PLPackage.PRODUCT_LINE__REASONER_NAME);
    createEReference(this.productLineEClass, PLPackage.PRODUCT_LINE__CLASSES);
    createEReference(this.productLineEClass, PLPackage.PRODUCT_LINE__METAMODEL);
    createEOperation(this.productLineEClass, PLPackage.PRODUCT_LINE___GET_REASONER);

    this.plElementEClass = createEClass(PLPackage.PL_ELEMENT);
    createEAttribute(this.plElementEClass, PLPackage.PL_ELEMENT__PRESENCE_CONDITION);
    createEOperation(this.plElementEClass, PLPackage.PL_ELEMENT___GET_PRODUCT_LINE);
    createEOperation(this.plElementEClass, PLPackage.PL_ELEMENT___IS_ALWAYS_PRESENT);
    createEOperation(this.plElementEClass, PLPackage.PL_ELEMENT___GET_PRESENCE_CONDITION_LABEL__BOOLEAN);

    this.classEClass = createEClass(PLPackage.CLASS);
    createEReference(this.classEClass, PLPackage.CLASS__ATTRIBUTES);
    createEReference(this.classEClass, PLPackage.CLASS__REFERENCES);
    createEReference(this.classEClass, PLPackage.CLASS__REFERENCES_AS_TARGET);
    createEReference(this.classEClass, PLPackage.CLASS__TYPE);
    createEOperation(this.classEClass, PLPackage.CLASS___GET_STREAM_OF_REFERENCE__EREFERENCE);
    createEOperation(this.classEClass, PLPackage.CLASS___GET_REFERENCE__EREFERENCE);
    createEOperation(this.classEClass, PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS_STRING);
    createEOperation(this.classEClass, PLPackage.CLASS___ADD_REFERENCE__EREFERENCE_CLASS);
    createEOperation(this.classEClass, PLPackage.CLASS___SET_REFERENCE__EREFERENCE_CLASS);
    createEOperation(this.classEClass, PLPackage.CLASS___GET_STREAM_OF_ATTRIBUTE__EATTRIBUTE);
    createEOperation(this.classEClass, PLPackage.CLASS___GET_ATTRIBUTE__EATTRIBUTE);
    createEOperation(this.classEClass, PLPackage.CLASS___GET_MANY_ATTRIBUTE__EATTRIBUTE);
    createEOperation(this.classEClass, PLPackage.CLASS___ADD_ATTRIBUTE__EATTRIBUTE_STRING);
    createEOperation(this.classEClass, PLPackage.CLASS___ADD_MANY_ATTRIBUTE__EATTRIBUTE_ELIST);
    createEOperation(this.classEClass, PLPackage.CLASS___SET_ATTRIBUTE__EATTRIBUTE_STRING);
    createEOperation(this.classEClass, PLPackage.CLASS___SET_MANY_ATTRIBUTE__EATTRIBUTE_ELIST);
    createEOperation(this.classEClass, PLPackage.CLASS___INSTANCE_OF__ECLASS);
    createEOperation(this.classEClass, PLPackage.CLASS___GET_ECONTAINER);
    createEOperation(this.classEClass, PLPackage.CLASS___DELETE);

    this.referenceEClass = createEClass(PLPackage.REFERENCE);
    createEReference(this.referenceEClass, PLPackage.REFERENCE__TARGET);
    createEReference(this.referenceEClass, PLPackage.REFERENCE__TYPE);

    this.attributeEClass = createEClass(PLPackage.ATTRIBUTE);
    createEAttribute(this.attributeEClass, PLPackage.ATTRIBUTE__VALUE);
    createEReference(this.attributeEClass, PLPackage.ATTRIBUTE__TYPE);

    // Create data types
    this.mmintExceptionEDataType = createEDataType(PLPackage.MMINT_EXCEPTION);
    this.iplFeaturesTraitEDataType = createEDataType(PLPackage.IPL_FEATURES_TRAIT);
    this.streamEDataType = createEDataType(PLPackage.STREAM);
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
    setName(PLPackage.eNAME);
    setNsPrefix(PLPackage.eNS_PREFIX);
    setNsURI(PLPackage.eNS_URI);

    // Create type parameters
    addETypeParameter(this.streamEDataType, "T");

    // Set bounds for type parameters

    // Add supertypes to classes
    this.classEClass.getESuperTypes().add(this.getPLElement());
    this.referenceEClass.getESuperTypes().add(this.getPLElement());
    this.attributeEClass.getESuperTypes().add(this.getPLElement());

    // Initialize classes, features, and operations; add parameters
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
    initEReference(getProductLine_Metamodel(), this.ecorePackage.getEPackage(), null, "metamodel", null, 1, 1,
                   ProductLine.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES,
                   !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    var op = initEOperation(getProductLine__GetReasoner(), this.getIPLFeaturesTrait(), "getReasoner", 1, 1,
                                   EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEClass(this.plElementEClass, PLElement.class, "PLElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPLElement_PresenceCondition(), this.ecorePackage.getEString(), "presenceCondition", null, 0, 1,
                   PLElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE,
                   !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getPLElement__GetProductLine(), this.getProductLine(), "getProductLine", 1, 1, EPackageImpl.IS_UNIQUE,
                   EPackageImpl.IS_ORDERED);

    initEOperation(getPLElement__IsAlwaysPresent(), this.ecorePackage.getEBoolean(), "isAlwaysPresent", 1, 1, EPackageImpl.IS_UNIQUE,
                   EPackageImpl.IS_ORDERED);

    op = initEOperation(getPLElement__GetPresenceConditionLabel__boolean(), this.ecorePackage.getEString(),
                        "getPresenceConditionLabel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "withParenthesis", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.classEClass, edu.toronto.cs.se.mmint.productline.Class.class, "Class", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
               EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1,
                   edu.toronto.cs.se.mmint.productline.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE,
                   EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_References(), this.getReference(), null, "references", null, 0, -1,
                   edu.toronto.cs.se.mmint.productline.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE,
                   EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_ReferencesAsTarget(), this.getReference(), this.getReference_Target(), "referencesAsTarget",
                   null, 0, -1, edu.toronto.cs.se.mmint.productline.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE,
                   EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED,
                   EPackageImpl.IS_ORDERED);
    initEReference(getClass_Type(), this.ecorePackage.getEClass(), null, "type", null, 1, 1,
                   edu.toronto.cs.se.mmint.productline.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE,
                   !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__GetStreamOfReference__EReference(), null, "getStreamOfReference", 1, 1, EPackageImpl.IS_UNIQUE,
                        EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEReference(), "referenceType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    var g1 = createEGenericType(this.getStream());
    var g2 = createEGenericType(this.getClass_());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getClass__GetReference__EReference(), this.getClass_(), "getReference", 0, -1, EPackageImpl.IS_UNIQUE,
                        EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEReference(), "referenceType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__AddReference__EReference_Class_String(), this.getReference(), "addReference", 1, 1,
                        EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEReference(), "referenceType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getClass_(), "tgtClass", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "presenceCondition", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__AddReference__EReference_Class(), this.getReference(), "addReference", 1, 1,
                        EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEReference(), "referenceType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getClass_(), "tgtClass", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__SetReference__EReference_Class(), null, "setReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEReference(), "referenceType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getClass_(), "tgtClass", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__GetStreamOfAttribute__EAttribute(), null, "getStreamOfAttribute", 1, 1, EPackageImpl.IS_UNIQUE,
                        EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEAttribute(), "attributeType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.getStream());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getClass__GetAttribute__EAttribute(), this.ecorePackage.getEString(), "getAttribute", 0, -1,
                        EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEAttribute(), "attributeType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__GetManyAttribute__EAttribute(), null, "getManyAttribute", 0, -1, EPackageImpl.IS_UNIQUE,
                        EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEAttribute(), "attributeType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(this.ecorePackage.getEEList());
    g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getClass__AddAttribute__EAttribute_String(), this.getAttribute(), "addAttribute", 1, 1,
                        EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEAttribute(), "attributeType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "value", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__AddManyAttribute__EAttribute_EList(), this.getAttribute(), "addManyAttribute", 1, 1,
                        EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEAttribute(), "attributeType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "values", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__SetAttribute__EAttribute_String(), null, "setAttribute", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEAttribute(), "attributeType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "value", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__SetManyAttribute__EAttribute_EList(), null, "setManyAttribute", 0, 1, EPackageImpl.IS_UNIQUE,
                        EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEAttribute(), "attributeType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "values", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getClass__InstanceOf__EClass(), this.ecorePackage.getEBoolean(), "instanceOf", 1, 1, EPackageImpl.IS_UNIQUE,
                        EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEClass(), "type", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getClass__GetEContainer(), this.getClass_(), "getEContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getClass__Delete(), null, "delete", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.referenceEClass, Reference.class, "Reference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReference_Target(), this.getClass_(), this.getClass_ReferencesAsTarget(), "target", null, 1, 1,
                   Reference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES,
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

    // Initialize data types
    initEDataType(this.mmintExceptionEDataType, MMINTException.class, "MMINTException", !EPackageImpl.IS_SERIALIZABLE,
                  !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.iplFeaturesTraitEDataType, IPLFeaturesTrait.class, "IPLFeaturesTrait", !EPackageImpl.IS_SERIALIZABLE,
                  !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.streamEDataType, Stream.class, "Stream", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(PLPackage.eNS_URI);
  }

} //PLPackageImpl
