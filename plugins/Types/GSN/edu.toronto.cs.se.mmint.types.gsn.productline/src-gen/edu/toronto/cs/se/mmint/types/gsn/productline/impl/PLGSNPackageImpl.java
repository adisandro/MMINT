/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNFactory;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PLGSNPackageImpl extends EPackageImpl implements PLGSNPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plgsnArgumentElementEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plgsnTemplateEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plgsnAnalyticTemplateEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iplgsnAnalysisEDataType = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType plgsnChangeStepEDataType = null;
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
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PLGSNPackageImpl() {
    super(PLGSNPackage.eNS_URI, PLGSNFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PLGSNPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PLGSNPackage init() {
    if (PLGSNPackageImpl.isInited) {
      return (PLGSNPackage)EPackage.Registry.INSTANCE.getEPackage(PLGSNPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredPLGSNPackage = EPackage.Registry.INSTANCE.get(PLGSNPackage.eNS_URI);
    var thePLGSNPackage = registeredPLGSNPackage instanceof PLGSNPackageImpl ? (PLGSNPackageImpl)registeredPLGSNPackage : new PLGSNPackageImpl();

    PLGSNPackageImpl.isInited = true;

    // Initialize simple dependencies
    GSNPackage.eINSTANCE.eClass();
    GSNTemplatesPackage.eINSTANCE.eClass();
    PLPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    thePLGSNPackage.createPackageContents();

    // Initialize created meta-data
    thePLGSNPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePLGSNPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PLGSNPackage.eNS_URI, thePLGSNPackage);
    return thePLGSNPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLGSNArgumentElement() {
    return this.plgsnArgumentElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNArgumentElement__Instantiate() {
    return this.plgsnArgumentElementEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNArgumentElement__Validate() {
    return this.plgsnArgumentElementEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLGSNTemplate() {
    return this.plgsnTemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNTemplate__GetElementsById() {
    return this.plgsnTemplateEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNTemplate__Validate() {
    return this.plgsnTemplateEClass.getEOperations().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNTemplate__Impact__PLGSNChangeStep() {
    return this.plgsnTemplateEClass.getEOperations().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNTemplate__Repair__PLGSNChangeStep() {
    return this.plgsnTemplateEClass.getEOperations().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNTemplate__Import___ProductLine() {
    return this.plgsnTemplateEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNTemplate__Instantiate() {
    return this.plgsnTemplateEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPLGSNAnalyticTemplate() {
    return this.plgsnAnalyticTemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getPLGSNAnalyticTemplate__GetAnalysis() {
    return this.plgsnAnalyticTemplateEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getIPLGSNAnalysis() {
    return this.iplgsnAnalysisEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getPLGSNChangeStep() {
    return this.plgsnChangeStepEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PLGSNFactory getPLGSNFactory() {
    return (PLGSNFactory)getEFactoryInstance();
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
    this.plgsnArgumentElementEClass = createEClass(PLGSNPackage.PLGSN_ARGUMENT_ELEMENT);
    createEOperation(this.plgsnArgumentElementEClass, PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___INSTANTIATE);
    createEOperation(this.plgsnArgumentElementEClass, PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___VALIDATE);

    this.plgsnTemplateEClass = createEClass(PLGSNPackage.PLGSN_TEMPLATE);
    createEOperation(this.plgsnTemplateEClass, PLGSNPackage.PLGSN_TEMPLATE___GET_ELEMENTS_BY_ID);
    createEOperation(this.plgsnTemplateEClass, PLGSNPackage.PLGSN_TEMPLATE___IMPORT____PRODUCTLINE);
    createEOperation(this.plgsnTemplateEClass, PLGSNPackage.PLGSN_TEMPLATE___INSTANTIATE);
    createEOperation(this.plgsnTemplateEClass, PLGSNPackage.PLGSN_TEMPLATE___VALIDATE);
    createEOperation(this.plgsnTemplateEClass, PLGSNPackage.PLGSN_TEMPLATE___IMPACT__PLGSNCHANGESTEP);
    createEOperation(this.plgsnTemplateEClass, PLGSNPackage.PLGSN_TEMPLATE___REPAIR__PLGSNCHANGESTEP);

    this.plgsnAnalyticTemplateEClass = createEClass(PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE);
    createEOperation(this.plgsnAnalyticTemplateEClass, PLGSNPackage.PLGSN_ANALYTIC_TEMPLATE___GET_ANALYSIS);

    // Create data types
    this.iplgsnAnalysisEDataType = createEDataType(PLGSNPackage.IPLGSN_ANALYSIS);
    this.plgsnChangeStepEDataType = createEDataType(PLGSNPackage.PLGSN_CHANGE_STEP);
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
    setName(PLGSNPackage.eNAME);
    setNsPrefix(PLGSNPackage.eNS_PREFIX);
    setNsURI(PLGSNPackage.eNS_URI);

    // Obtain other dependent packages
    var thePLPackage = (PLPackage)EPackage.Registry.INSTANCE.getEPackage(PLPackage.eNS_URI);
    var theGSNPackage = (GSNPackage)EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.plgsnArgumentElementEClass.getESuperTypes().add(thePLPackage.getClass_());
    this.plgsnTemplateEClass.getESuperTypes().add(thePLPackage.getClass_());
    this.plgsnAnalyticTemplateEClass.getESuperTypes().add(this.getPLGSNTemplate());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.plgsnArgumentElementEClass, PLGSNArgumentElement.class, "PLGSNArgumentElement", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    var op = initEOperation(getPLGSNArgumentElement__Instantiate(), null, "instantiate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    op = initEOperation(getPLGSNArgumentElement__Validate(), null, "validate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    initEClass(this.plgsnTemplateEClass, PLGSNTemplate.class, "PLGSNTemplate", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    op = initEOperation(getPLGSNTemplate__GetElementsById(), null, "getElementsById", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    var g1 = createEGenericType(this.ecorePackage.getEMap());
    var g2 = createEGenericType(this.ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(this.getPLGSNArgumentElement());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getPLGSNTemplate__Import___ProductLine(), null, "import_", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, thePLPackage.getProductLine(), "productLine", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    op = initEOperation(getPLGSNTemplate__Instantiate(), null, "instantiate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    op = initEOperation(getPLGSNTemplate__Validate(), null, "validate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    op = initEOperation(getPLGSNTemplate__Impact__PLGSNChangeStep(), this.getPLGSNChangeStep(), "impact", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getPLGSNChangeStep(), "step", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    op = initEOperation(getPLGSNTemplate__Repair__PLGSNChangeStep(), this.getPLGSNChangeStep(), "repair", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getPLGSNChangeStep(), "step", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    initEClass(this.plgsnAnalyticTemplateEClass, PLGSNAnalyticTemplate.class, "PLGSNAnalyticTemplate", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    op = initEOperation(getPLGSNAnalyticTemplate__GetAnalysis(), this.getIPLGSNAnalysis(), "getAnalysis", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    // Initialize data types
    initEDataType(this.iplgsnAnalysisEDataType, IPLGSNAnalysis.class, "IPLGSNAnalysis", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.plgsnChangeStepEDataType, PLGSNChangeStep.class, "PLGSNChangeStep", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(PLGSNPackage.eNS_URI);
  }

} //GSNPLPackageImpl
