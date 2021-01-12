/*******************************************************************************
 * Copyright (c) 2012, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNPackage;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.impl.GSNPackageImpl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl.HARAPackageImpl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.Item;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLFactory;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLPackage;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLRoot;

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
public class SysMLPackageImpl extends EPackageImpl implements SysMLPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sysMLRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass itemEClass = null;

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
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SysMLPackageImpl() {
    super(eNS_URI, SysMLFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link SysMLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SysMLPackage init() {
    if (isInited) return (SysMLPackage)EPackage.Registry.INSTANCE.getEPackage(SysMLPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredSysMLPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    SysMLPackageImpl theSysMLPackage = registeredSysMLPackage instanceof SysMLPackageImpl ? (SysMLPackageImpl)registeredSysMLPackage : new SysMLPackageImpl();

    isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);
    GSNPackageImpl theGSNPackage = (GSNPackageImpl)(registeredPackage instanceof GSNPackageImpl ? registeredPackage : GSNPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(HARAPackage.eNS_URI);
    HARAPackageImpl theHARAPackage = (HARAPackageImpl)(registeredPackage instanceof HARAPackageImpl ? registeredPackage : HARAPackage.eINSTANCE);

    // Create package meta-data objects
    theSysMLPackage.createPackageContents();
    theGSNPackage.createPackageContents();
    theHARAPackage.createPackageContents();

    // Initialize created meta-data
    theSysMLPackage.initializePackageContents();
    theGSNPackage.initializePackageContents();
    theHARAPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSysMLPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SysMLPackage.eNS_URI, theSysMLPackage);
    return theSysMLPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSysMLRoot() {
    return sysMLRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSysMLRoot_Items() {
    return (EReference)sysMLRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getItem() {
    return itemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getItem_Name() {
    return (EAttribute)itemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SysMLFactory getSysMLFactory() {
    return (SysMLFactory)getEFactoryInstance();
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
    sysMLRootEClass = createEClass(SYS_ML_ROOT);
    createEReference(sysMLRootEClass, SYS_ML_ROOT__ITEMS);

    itemEClass = createEClass(ITEM);
    createEAttribute(itemEClass, ITEM__NAME);
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
    initEClass(sysMLRootEClass, SysMLRoot.class, "SysMLRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSysMLRoot_Items(), this.getItem(), null, "items", null, 0, -1, SysMLRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(itemEClass, Item.class, "Item", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getItem_Name(), ecorePackage.getEString(), "name", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //SysMLPackageImpl
