/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLFactory;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IGSNPLAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GSNPLPackageImpl extends EPackageImpl implements GSNPLPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gsnplArgumentElementEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gsnplTemplateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gsnplAnalyticTemplateEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType igsnplAnalysisEDataType = null;
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
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GSNPLPackageImpl() {
    super(GSNPLPackage.eNS_URI, GSNPLFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link GSNPLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GSNPLPackage init() {
    if (GSNPLPackageImpl.isInited) {
      return (GSNPLPackage)EPackage.Registry.INSTANCE.getEPackage(GSNPLPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredGSNPLPackage = EPackage.Registry.INSTANCE.get(GSNPLPackage.eNS_URI);
    var theGSNPLPackage = registeredGSNPLPackage instanceof GSNPLPackageImpl ? (GSNPLPackageImpl)registeredGSNPLPackage : new GSNPLPackageImpl();

    GSNPLPackageImpl.isInited = true;

    // Initialize simple dependencies
    GSNPackage.eINSTANCE.eClass();
    GSNTemplatesPackage.eINSTANCE.eClass();
    PLPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theGSNPLPackage.createPackageContents();

    // Initialize created meta-data
    theGSNPLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGSNPLPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GSNPLPackage.eNS_URI, theGSNPLPackage);
    return theGSNPLPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGSNPLArgumentElement() {
    return this.gsnplArgumentElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getGSNPLArgumentElement__Validate__GSNPLTemplate() {
    return this.gsnplArgumentElementEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getGSNPLArgumentElement__Instantiate__GSNPLTemplate() {
    return this.gsnplArgumentElementEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGSNPLTemplate() {
    return this.gsnplTemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getGSNPLTemplate__Validate() {
    return this.gsnplTemplateEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getGSNPLTemplate__Import___ProductLine() {
    return this.gsnplTemplateEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getGSNPLTemplate__Instantiate() {
    return this.gsnplTemplateEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGSNPLAnalyticTemplate() {
    return this.gsnplAnalyticTemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getGSNPLAnalyticTemplate__GetAnalysis() {
    return this.gsnplAnalyticTemplateEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getIGSNPLAnalysis() {
    return this.igsnplAnalysisEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNPLFactory getGSNPLFactory() {
    return (GSNPLFactory)getEFactoryInstance();
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
    this.gsnplArgumentElementEClass = createEClass(GSNPLPackage.GSNPL_ARGUMENT_ELEMENT);
    createEOperation(this.gsnplArgumentElementEClass, GSNPLPackage.GSNPL_ARGUMENT_ELEMENT___VALIDATE__GSNPLTEMPLATE);
    createEOperation(this.gsnplArgumentElementEClass, GSNPLPackage.GSNPL_ARGUMENT_ELEMENT___INSTANTIATE__GSNPLTEMPLATE);

    this.gsnplTemplateEClass = createEClass(GSNPLPackage.GSNPL_TEMPLATE);
    createEOperation(this.gsnplTemplateEClass, GSNPLPackage.GSNPL_TEMPLATE___VALIDATE);
    createEOperation(this.gsnplTemplateEClass, GSNPLPackage.GSNPL_TEMPLATE___IMPORT____PRODUCTLINE);
    createEOperation(this.gsnplTemplateEClass, GSNPLPackage.GSNPL_TEMPLATE___INSTANTIATE);

    this.gsnplAnalyticTemplateEClass = createEClass(GSNPLPackage.GSNPL_ANALYTIC_TEMPLATE);
    createEOperation(this.gsnplAnalyticTemplateEClass, GSNPLPackage.GSNPL_ANALYTIC_TEMPLATE___GET_ANALYSIS);

    // Create data types
    this.igsnplAnalysisEDataType = createEDataType(GSNPLPackage.IGSNPL_ANALYSIS);
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
    setName(GSNPLPackage.eNAME);
    setNsPrefix(GSNPLPackage.eNS_PREFIX);
    setNsURI(GSNPLPackage.eNS_URI);

    // Obtain other dependent packages
    var thePLPackage = (PLPackage)EPackage.Registry.INSTANCE.getEPackage(PLPackage.eNS_URI);
    var theGSNPackage = (GSNPackage)EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.gsnplArgumentElementEClass.getESuperTypes().add(thePLPackage.getClass_());
    this.gsnplTemplateEClass.getESuperTypes().add(thePLPackage.getClass_());
    this.gsnplAnalyticTemplateEClass.getESuperTypes().add(this.getGSNPLTemplate());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.gsnplArgumentElementEClass, GSNPLArgumentElement.class, "GSNPLArgumentElement", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    var op = initEOperation(getGSNPLArgumentElement__Validate__GSNPLTemplate(), null, "validate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getGSNPLTemplate(), "template", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    op = initEOperation(getGSNPLArgumentElement__Instantiate__GSNPLTemplate(), null, "instantiate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getGSNPLTemplate(), "template", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    initEClass(this.gsnplTemplateEClass, GSNPLTemplate.class, "GSNPLTemplate", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    op = initEOperation(getGSNPLTemplate__Validate(), null, "validate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    op = initEOperation(getGSNPLTemplate__Import___ProductLine(), null, "import_", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, thePLPackage.getProductLine(), "productLine", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    op = initEOperation(getGSNPLTemplate__Instantiate(), null, "instantiate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    initEClass(this.gsnplAnalyticTemplateEClass, GSNPLAnalyticTemplate.class, "GSNPLAnalyticTemplate", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    op = initEOperation(getGSNPLAnalyticTemplate__GetAnalysis(), this.getIGSNPLAnalysis(), "getAnalysis", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theGSNPackage.getException());

    // Initialize data types
    initEDataType(this.igsnplAnalysisEDataType, IGSNPLAnalysis.class, "IGSNPLAnalysis", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(GSNPLPackage.eNS_URI);
  }

} //GSNPLPackageImpl
