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
package edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.impl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNPackage;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.impl.GSNPackageImpl;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAFactory;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARARoot;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.Hazard;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HazardousEvent;
import edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.OperationalSituation;

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
public class HARAPackageImpl extends EPackageImpl implements HARAPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass haraRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hazardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationalSituationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hazardousEventEClass = null;

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
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.hara.HARAPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private HARAPackageImpl() {
    super(eNS_URI, HARAFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link HARAPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static HARAPackage init() {
    if (isInited) return (HARAPackage)EPackage.Registry.INSTANCE.getEPackage(HARAPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredHARAPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    HARAPackageImpl theHARAPackage = registeredHARAPackage instanceof HARAPackageImpl ? (HARAPackageImpl)registeredHARAPackage : new HARAPackageImpl();

    isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);
    GSNPackageImpl theGSNPackage = (GSNPackageImpl)(registeredPackage instanceof GSNPackageImpl ? registeredPackage : GSNPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SysMLPackage.eNS_URI);
    SysMLPackageImpl theSysMLPackage = (SysMLPackageImpl)(registeredPackage instanceof SysMLPackageImpl ? registeredPackage : SysMLPackage.eINSTANCE);

    // Create package meta-data objects
    theHARAPackage.createPackageContents();
    theGSNPackage.createPackageContents();
    theSysMLPackage.createPackageContents();

    // Initialize created meta-data
    theHARAPackage.initializePackageContents();
    theGSNPackage.initializePackageContents();
    theSysMLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theHARAPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(HARAPackage.eNS_URI, theHARAPackage);
    return theHARAPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getHARARoot() {
    return haraRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getHARARoot_Hazards() {
    return (EReference)haraRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getHARARoot_Situations() {
    return (EReference)haraRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getHARARoot_Events() {
    return (EReference)haraRootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getHazard() {
    return hazardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getHazard_Description() {
    return (EAttribute)hazardEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getHazard_Events() {
    return (EReference)hazardEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getOperationalSituation() {
    return operationalSituationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOperationalSituation_Description() {
    return (EAttribute)operationalSituationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOperationalSituation_Events() {
    return (EReference)operationalSituationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getHazardousEvent() {
    return hazardousEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getHazardousEvent_Hazard() {
    return (EReference)hazardousEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getHazardousEvent_Situation() {
    return (EReference)hazardousEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getHazardousEvent_Severity() {
    return (EAttribute)hazardousEventEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getHazardousEvent_Exposure() {
    return (EAttribute)hazardousEventEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getHazardousEvent_Controllability() {
    return (EAttribute)hazardousEventEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getHazardousEvent_ASIL() {
    return (EAttribute)hazardousEventEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HARAFactory getHARAFactory() {
    return (HARAFactory)getEFactoryInstance();
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
    haraRootEClass = createEClass(HARA_ROOT);
    createEReference(haraRootEClass, HARA_ROOT__HAZARDS);
    createEReference(haraRootEClass, HARA_ROOT__SITUATIONS);
    createEReference(haraRootEClass, HARA_ROOT__EVENTS);

    hazardEClass = createEClass(HAZARD);
    createEAttribute(hazardEClass, HAZARD__DESCRIPTION);
    createEReference(hazardEClass, HAZARD__EVENTS);

    operationalSituationEClass = createEClass(OPERATIONAL_SITUATION);
    createEAttribute(operationalSituationEClass, OPERATIONAL_SITUATION__DESCRIPTION);
    createEReference(operationalSituationEClass, OPERATIONAL_SITUATION__EVENTS);

    hazardousEventEClass = createEClass(HAZARDOUS_EVENT);
    createEReference(hazardousEventEClass, HAZARDOUS_EVENT__HAZARD);
    createEReference(hazardousEventEClass, HAZARDOUS_EVENT__SITUATION);
    createEAttribute(hazardousEventEClass, HAZARDOUS_EVENT__SEVERITY);
    createEAttribute(hazardousEventEClass, HAZARDOUS_EVENT__EXPOSURE);
    createEAttribute(hazardousEventEClass, HAZARDOUS_EVENT__CONTROLLABILITY);
    createEAttribute(hazardousEventEClass, HAZARDOUS_EVENT__ASIL);
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
    initEClass(haraRootEClass, HARARoot.class, "HARARoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHARARoot_Hazards(), this.getHazard(), null, "hazards", null, 0, -1, HARARoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHARARoot_Situations(), this.getOperationalSituation(), null, "situations", null, 0, -1, HARARoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHARARoot_Events(), this.getHazardousEvent(), null, "events", null, 0, -1, HARARoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hazardEClass, Hazard.class, "Hazard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHazard_Description(), ecorePackage.getEString(), "description", null, 1, 1, Hazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHazard_Events(), this.getHazardousEvent(), this.getHazardousEvent_Hazard(), "events", null, 0, -1, Hazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationalSituationEClass, OperationalSituation.class, "OperationalSituation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOperationalSituation_Description(), ecorePackage.getEString(), "description", null, 1, 1, OperationalSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationalSituation_Events(), this.getHazardousEvent(), this.getHazardousEvent_Situation(), "events", null, 0, -1, OperationalSituation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hazardousEventEClass, HazardousEvent.class, "HazardousEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHazardousEvent_Hazard(), this.getHazard(), this.getHazard_Events(), "hazard", null, 1, 1, HazardousEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHazardousEvent_Situation(), this.getOperationalSituation(), this.getOperationalSituation_Events(), "situation", null, 1, 1, HazardousEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHazardousEvent_Severity(), ecorePackage.getEString(), "severity", null, 1, 1, HazardousEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHazardousEvent_Exposure(), ecorePackage.getEString(), "exposure", null, 1, 1, HazardousEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHazardousEvent_Controllability(), ecorePackage.getEString(), "controllability", null, 1, 1, HazardousEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHazardousEvent_ASIL(), ecorePackage.getEString(), "ASIL", null, 1, 1, HazardousEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //HARAPackageImpl
