/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.Domain;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesFactory;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GSNTemplatesPackageImpl extends EPackageImpl implements GSNTemplatesPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass decompositionStrategyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass decompositionTemplateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intDomainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass realDomainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumDomainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueDomainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainDecompositionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainDecompositionStrategyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainGoalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainDecompositionTemplateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyDecompositionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyDecompositionStrategyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyGoalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyDecompositionTemplateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType gsnTemplatesBuilderEDataType = null;

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
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GSNTemplatesPackageImpl() {
    super(GSNTemplatesPackage.eNS_URI, GSNTemplatesFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link GSNTemplatesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GSNTemplatesPackage init() {
    if (GSNTemplatesPackageImpl.isInited) return (GSNTemplatesPackage)EPackage.Registry.INSTANCE.getEPackage(GSNTemplatesPackage.eNS_URI);

    // Obtain or create and register package
    var registeredGSNTemplatesPackage = EPackage.Registry.INSTANCE.get(GSNTemplatesPackage.eNS_URI);
    var theGSNTemplatesPackage = registeredGSNTemplatesPackage instanceof GSNTemplatesPackageImpl ? (GSNTemplatesPackageImpl)registeredGSNTemplatesPackage : new GSNTemplatesPackageImpl();

    GSNTemplatesPackageImpl.isInited = true;

    // Initialize simple dependencies
    GSNPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theGSNTemplatesPackage.createPackageContents();

    // Initialize created meta-data
    theGSNTemplatesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGSNTemplatesPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GSNTemplatesPackage.eNS_URI, theGSNTemplatesPackage);
    return theGSNTemplatesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDecompositionStrategy() {
    return this.decompositionStrategyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDecompositionTemplate() {
    return this.decompositionTemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getDecompositionTemplate__Decompose__Goal_GSNTemplatesBuilder() {
    return this.decompositionTemplateEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDomain() {
    return this.domainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getDomain__ValidateDecomposition__EList() {
    return this.domainEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIntDomain() {
    return this.intDomainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getIntDomain_LowerBound() {
    return (EAttribute)this.intDomainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getIntDomain_UpperBound() {
    return (EAttribute)this.intDomainEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRealDomain() {
    return this.realDomainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRealDomain_LowerBound() {
    return (EAttribute)this.realDomainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRealDomain_UpperBound() {
    return (EAttribute)this.realDomainEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getEnumDomain() {
    return this.enumDomainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getEnumDomain_Values() {
    return (EAttribute)this.enumDomainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValueDomain() {
    return this.valueDomainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getValueDomain_Value() {
    return (EAttribute)this.valueDomainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDomainDecompositionElement() {
    return this.domainDecompositionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDomainDecompositionElement_Domain() {
    return (EReference)this.domainDecompositionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDomainDecompositionStrategy() {
    return this.domainDecompositionStrategyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDomainGoal() {
    return this.domainGoalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDomainDecompositionTemplate() {
    return this.domainDecompositionTemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getProperty() {
    return this.propertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getProperty_Formal() {
    return (EAttribute)this.propertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getProperty_Informal() {
    return (EAttribute)this.propertyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyDecompositionElement() {
    return this.propertyDecompositionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertyDecompositionElement_Property() {
    return (EReference)this.propertyDecompositionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyDecompositionStrategy() {
    return this.propertyDecompositionStrategyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPropertyDecompositionStrategy_ReasonerName() {
    return (EAttribute)this.propertyDecompositionStrategyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyGoal() {
    return this.propertyGoalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPropertyGoal_Hint() {
    return (EAttribute)this.propertyGoalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyDecompositionTemplate() {
    return this.propertyDecompositionTemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getGSNTemplatesBuilder() {
    return this.gsnTemplatesBuilderEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNTemplatesFactory getGSNTemplatesFactory() {
    return (GSNTemplatesFactory)getEFactoryInstance();
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
    if (this.isCreated) return;
    this.isCreated = true;

    // Create classes and their features
    this.decompositionStrategyEClass = createEClass(GSNTemplatesPackage.DECOMPOSITION_STRATEGY);

    this.decompositionTemplateEClass = createEClass(GSNTemplatesPackage.DECOMPOSITION_TEMPLATE);
    createEOperation(this.decompositionTemplateEClass, GSNTemplatesPackage.DECOMPOSITION_TEMPLATE___DECOMPOSE__GOAL_GSNTEMPLATESBUILDER);

    this.domainEClass = createEClass(GSNTemplatesPackage.DOMAIN);
    createEOperation(this.domainEClass, GSNTemplatesPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST);

    this.intDomainEClass = createEClass(GSNTemplatesPackage.INT_DOMAIN);
    createEAttribute(this.intDomainEClass, GSNTemplatesPackage.INT_DOMAIN__LOWER_BOUND);
    createEAttribute(this.intDomainEClass, GSNTemplatesPackage.INT_DOMAIN__UPPER_BOUND);

    this.realDomainEClass = createEClass(GSNTemplatesPackage.REAL_DOMAIN);
    createEAttribute(this.realDomainEClass, GSNTemplatesPackage.REAL_DOMAIN__LOWER_BOUND);
    createEAttribute(this.realDomainEClass, GSNTemplatesPackage.REAL_DOMAIN__UPPER_BOUND);

    this.enumDomainEClass = createEClass(GSNTemplatesPackage.ENUM_DOMAIN);
    createEAttribute(this.enumDomainEClass, GSNTemplatesPackage.ENUM_DOMAIN__VALUES);

    this.valueDomainEClass = createEClass(GSNTemplatesPackage.VALUE_DOMAIN);
    createEAttribute(this.valueDomainEClass, GSNTemplatesPackage.VALUE_DOMAIN__VALUE);

    this.domainDecompositionElementEClass = createEClass(GSNTemplatesPackage.DOMAIN_DECOMPOSITION_ELEMENT);
    createEReference(this.domainDecompositionElementEClass, GSNTemplatesPackage.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN);

    this.domainDecompositionStrategyEClass = createEClass(GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY);

    this.domainGoalEClass = createEClass(GSNTemplatesPackage.DOMAIN_GOAL);

    this.domainDecompositionTemplateEClass = createEClass(GSNTemplatesPackage.DOMAIN_DECOMPOSITION_TEMPLATE);

    this.propertyEClass = createEClass(GSNTemplatesPackage.PROPERTY);
    createEAttribute(this.propertyEClass, GSNTemplatesPackage.PROPERTY__FORMAL);
    createEAttribute(this.propertyEClass, GSNTemplatesPackage.PROPERTY__INFORMAL);

    this.propertyDecompositionElementEClass = createEClass(GSNTemplatesPackage.PROPERTY_DECOMPOSITION_ELEMENT);
    createEReference(this.propertyDecompositionElementEClass, GSNTemplatesPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY);

    this.propertyDecompositionStrategyEClass = createEClass(GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY);
    createEAttribute(this.propertyDecompositionStrategyEClass, GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME);

    this.propertyGoalEClass = createEClass(GSNTemplatesPackage.PROPERTY_GOAL);
    createEAttribute(this.propertyGoalEClass, GSNTemplatesPackage.PROPERTY_GOAL__HINT);

    this.propertyDecompositionTemplateEClass = createEClass(GSNTemplatesPackage.PROPERTY_DECOMPOSITION_TEMPLATE);

    // Create data types
    this.gsnTemplatesBuilderEDataType = createEDataType(GSNTemplatesPackage.GSN_TEMPLATES_BUILDER);
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
    if (this.isInitialized) return;
    this.isInitialized = true;

    // Initialize package
    setName(GSNTemplatesPackage.eNAME);
    setNsPrefix(GSNTemplatesPackage.eNS_PREFIX);
    setNsURI(GSNTemplatesPackage.eNS_URI);

    // Obtain other dependent packages
    var theGSNPackage = (GSNPackage)EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.decompositionStrategyEClass.getESuperTypes().add(theGSNPackage.getStrategy());
    this.decompositionStrategyEClass.getESuperTypes().add(theGSNPackage.getTemplateElement());
    this.decompositionTemplateEClass.getESuperTypes().add(theGSNPackage.getTemplate());
    this.intDomainEClass.getESuperTypes().add(this.getDomain());
    this.realDomainEClass.getESuperTypes().add(this.getDomain());
    this.enumDomainEClass.getESuperTypes().add(this.getDomain());
    this.valueDomainEClass.getESuperTypes().add(this.getDomain());
    this.domainDecompositionStrategyEClass.getESuperTypes().add(this.getDecompositionStrategy());
    this.domainDecompositionStrategyEClass.getESuperTypes().add(this.getDomainDecompositionElement());
    this.domainGoalEClass.getESuperTypes().add(theGSNPackage.getGoal());
    this.domainGoalEClass.getESuperTypes().add(this.getDomainDecompositionElement());
    this.domainGoalEClass.getESuperTypes().add(theGSNPackage.getTemplateElement());
    this.domainDecompositionTemplateEClass.getESuperTypes().add(this.getDecompositionTemplate());
    this.propertyDecompositionStrategyEClass.getESuperTypes().add(this.getDecompositionStrategy());
    this.propertyDecompositionStrategyEClass.getESuperTypes().add(this.getPropertyDecompositionElement());
    this.propertyGoalEClass.getESuperTypes().add(theGSNPackage.getGoal());
    this.propertyGoalEClass.getESuperTypes().add(this.getPropertyDecompositionElement());
    this.propertyGoalEClass.getESuperTypes().add(theGSNPackage.getTemplateElement());
    this.propertyDecompositionTemplateEClass.getESuperTypes().add(this.getDecompositionTemplate());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.decompositionStrategyEClass, DecompositionStrategy.class, "DecompositionStrategy", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.decompositionTemplateEClass, DecompositionTemplate.class, "DecompositionTemplate", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    var op = initEOperation(getDecompositionTemplate__Decompose__Goal_GSNTemplatesBuilder(), null, "decompose", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theGSNPackage.getGoal(), "decomposed", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getGSNTemplatesBuilder(), "builder", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    initEClass(this.domainEClass, Domain.class, "Domain", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    op = initEOperation(getDomain__ValidateDecomposition__EList(), null, "validateDecomposition", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getDomain(), "subDomains", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    initEClass(this.intDomainEClass, IntDomain.class, "IntDomain", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntDomain_LowerBound(), this.ecorePackage.getEInt(), "lowerBound", null, 1, 1, IntDomain.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getIntDomain_UpperBound(), this.ecorePackage.getEInt(), "upperBound", null, 1, 1, IntDomain.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.realDomainEClass, RealDomain.class, "RealDomain", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRealDomain_LowerBound(), this.ecorePackage.getEDouble(), "lowerBound", null, 1, 1, RealDomain.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getRealDomain_UpperBound(), this.ecorePackage.getEDouble(), "upperBound", null, 1, 1, RealDomain.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.enumDomainEClass, EnumDomain.class, "EnumDomain", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumDomain_Values(), this.ecorePackage.getEString(), "values", null, 2, -1, EnumDomain.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.valueDomainEClass, ValueDomain.class, "ValueDomain", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueDomain_Value(), this.ecorePackage.getEString(), "value", null, 1, 1, ValueDomain.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.domainDecompositionElementEClass, DomainDecompositionElement.class, "DomainDecompositionElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDomainDecompositionElement_Domain(), this.getDomain(), null, "domain", null, 1, 1, DomainDecompositionElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.domainDecompositionStrategyEClass, DomainDecompositionStrategy.class, "DomainDecompositionStrategy", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.domainGoalEClass, DomainGoal.class, "DomainGoal", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.domainDecompositionTemplateEClass, DomainDecompositionTemplate.class, "DomainDecompositionTemplate", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.propertyEClass, Property.class, "Property", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProperty_Formal(), this.ecorePackage.getEString(), "formal", null, 1, 1, Property.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getProperty_Informal(), this.ecorePackage.getEString(), "informal", null, 1, 1, Property.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.propertyDecompositionElementEClass, PropertyDecompositionElement.class, "PropertyDecompositionElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyDecompositionElement_Property(), this.getProperty(), null, "property", null, 1, 1, PropertyDecompositionElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.propertyDecompositionStrategyEClass, PropertyDecompositionStrategy.class, "PropertyDecompositionStrategy", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyDecompositionStrategy_ReasonerName(), this.ecorePackage.getEString(), "reasonerName", null, 1, 1, PropertyDecompositionStrategy.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.propertyGoalEClass, PropertyGoal.class, "PropertyGoal", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyGoal_Hint(), this.ecorePackage.getEString(), "hint", null, 0, 1, PropertyGoal.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.propertyDecompositionTemplateEClass, PropertyDecompositionTemplate.class, "PropertyDecompositionTemplate", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Initialize data types
    initEDataType(this.gsnTemplatesBuilderEDataType, GSNTemplatesBuilder.class, "GSNTemplatesBuilder", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(GSNTemplatesPackage.eNS_URI);
  }

} //GSNTemplatesPackageImpl
