/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Rick Salay, Sahar Kokaly.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.impl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNFactory;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNPackage;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNRoot;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.SafetyGoal;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLPackage;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GSNPackageImpl extends EPackageImpl implements GSNPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gsnRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass safetyGoalEClass = null;

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
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GSNPackageImpl() {
    super(eNS_URI, GSNFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link GSNPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GSNPackage init() {
    if (isInited) return (GSNPackage)EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredGSNPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    GSNPackageImpl theGSNPackage = registeredGSNPackage instanceof GSNPackageImpl ? (GSNPackageImpl)registeredGSNPackage : new GSNPackageImpl();

    isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(HARAPackage.eNS_URI);
    HARAPackageImpl theHARAPackage = (HARAPackageImpl)(registeredPackage instanceof HARAPackageImpl ? registeredPackage : HARAPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SysMLPackage.eNS_URI);
    SysMLPackageImpl theSysMLPackage = (SysMLPackageImpl)(registeredPackage instanceof SysMLPackageImpl ? registeredPackage : SysMLPackage.eINSTANCE);

    // Create package meta-data objects
    theGSNPackage.createPackageContents();
    theHARAPackage.createPackageContents();
    theSysMLPackage.createPackageContents();

    // Initialize created meta-data
    theGSNPackage.initializePackageContents();
    theHARAPackage.initializePackageContents();
    theSysMLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGSNPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GSNPackage.eNS_URI, theGSNPackage);
    return theGSNPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGSNRoot() {
    return gsnRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGSNRoot_Goals() {
    return (EReference)gsnRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSafetyGoal() {
    return safetyGoalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getSafetyGoal_Description() {
    return (EAttribute)safetyGoalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getSafetyGoal_ASIL() {
    return (EAttribute)safetyGoalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNFactory getGSNFactory() {
    return (GSNFactory)getEFactoryInstance();
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
    gsnRootEClass = createEClass(GSN_ROOT);
    createEReference(gsnRootEClass, GSN_ROOT__GOALS);

    safetyGoalEClass = createEClass(SAFETY_GOAL);
    createEAttribute(safetyGoalEClass, SAFETY_GOAL__DESCRIPTION);
    createEAttribute(safetyGoalEClass, SAFETY_GOAL__ASIL);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(gsnRootEClass, GSNRoot.class, "GSNRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGSNRoot_Goals(), this.getSafetyGoal(), null, "goals", null, 0, -1, GSNRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(safetyGoalEClass, SafetyGoal.class, "SafetyGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSafetyGoal_Description(), ecorePackage.getEString(), "description", null, 1, 1, SafetyGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSafetyGoal_ASIL(), ecorePackage.getEString(), "ASIL", null, 1, 1, SafetyGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //GSNPackageImpl
