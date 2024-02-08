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
package edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.examples.safecomp24.gsn.AMLASrFactory;
import edu.toronto.cs.se.mmint.examples.safecomp24.gsn.AMLASrPackage;
import edu.toronto.cs.se.mmint.examples.safecomp24.gsn.Stage1Template;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AMLASrPackageImpl extends EPackageImpl implements AMLASrPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stage1TemplateEClass = null;

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
   * @see edu.toronto.cs.se.mmint.examples.safecomp24.gsn.AMLASrPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AMLASrPackageImpl() {
    super(AMLASrPackage.eNS_URI, AMLASrFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link AMLASrPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AMLASrPackage init() {
    if (AMLASrPackageImpl.isInited) {
      return (AMLASrPackage)EPackage.Registry.INSTANCE.getEPackage(AMLASrPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredAMLASrPackage = EPackage.Registry.INSTANCE.get(AMLASrPackage.eNS_URI);
    var theAMLASrPackage = registeredAMLASrPackage instanceof AMLASrPackageImpl ? (AMLASrPackageImpl)registeredAMLASrPackage : new AMLASrPackageImpl();

    AMLASrPackageImpl.isInited = true;

    // Initialize simple dependencies
    GSNPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theAMLASrPackage.createPackageContents();

    // Initialize created meta-data
    theAMLASrPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAMLASrPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AMLASrPackage.eNS_URI, theAMLASrPackage);
    return theAMLASrPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStage1Template() {
    return this.stage1TemplateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AMLASrFactory getAMLASrFactory() {
    return (AMLASrFactory)getEFactoryInstance();
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
    this.stage1TemplateEClass = createEClass(AMLASrPackage.STAGE1_TEMPLATE);
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
    setName(AMLASrPackage.eNAME);
    setNsPrefix(AMLASrPackage.eNS_PREFIX);
    setNsURI(AMLASrPackage.eNS_URI);

    // Obtain other dependent packages
    var theGSNPackage = (GSNPackage)EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.stage1TemplateEClass.getESuperTypes().add(theGSNPackage.getTemplate());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.stage1TemplateEClass, Stage1Template.class, "Stage1Template", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(AMLASrPackage.eNS_URI);
  }

} //AMLASrPackageImpl
