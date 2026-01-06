/*******************************************************************************
 * Copyright (c) 2026, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.fta.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.types.fta.Event;
import edu.toronto.cs.se.mmint.types.fta.FTAFactory;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;
import edu.toronto.cs.se.mmint.types.fta.FaultTree;
import edu.toronto.cs.se.mmint.types.fta.Gate;
import edu.toronto.cs.se.mmint.types.fta.GateLogic;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FTAPackageImpl extends EPackageImpl implements FTAPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass faultTreeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum gateLogicEEnum = null;

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
   * @see edu.toronto.cs.se.mmint.types.fta.FTAPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FTAPackageImpl() {
    super(FTAPackage.eNS_URI, FTAFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FTAPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FTAPackage init() {
    if (FTAPackageImpl.isInited) {
      return (FTAPackage) EPackage.Registry.INSTANCE.getEPackage(FTAPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredFTAPackage = EPackage.Registry.INSTANCE.get(FTAPackage.eNS_URI);
    var theFTAPackage = registeredFTAPackage instanceof FTAPackageImpl f
      ? f
      : new FTAPackageImpl();

    FTAPackageImpl.isInited = true;

    // Create package meta-data objects
    theFTAPackage.createPackageContents();

    // Initialize created meta-data
    theFTAPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFTAPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FTAPackage.eNS_URI, theFTAPackage);
    return theFTAPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFaultTree() {
    return this.faultTreeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFaultTree_Events() {
    return (EReference) this.faultTreeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFaultTree_Root() {
    return (EReference) this.faultTreeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getEvent() {
    return this.eventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getEvent_Probability() {
    return (EAttribute) this.eventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getEvent_Name() {
    return (EAttribute) this.eventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getEvent_Gate() {
    return (EReference) this.eventEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getEvent_SuperGate() {
    return (EReference) this.eventEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGate() {
    return this.gateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGate_SubEvents() {
    return (EReference) this.gateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getGate_Logic() {
    return (EAttribute) this.gateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGate_Event() {
    return (EReference) this.gateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getGateLogic() {
    return this.gateLogicEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FTAFactory getFTAFactory() {
    return (FTAFactory) getEFactoryInstance();
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
    this.faultTreeEClass = createEClass(FTAPackage.FAULT_TREE);
    createEReference(this.faultTreeEClass, FTAPackage.FAULT_TREE__EVENTS);
    createEReference(this.faultTreeEClass, FTAPackage.FAULT_TREE__ROOT);

    this.eventEClass = createEClass(FTAPackage.EVENT);
    createEAttribute(this.eventEClass, FTAPackage.EVENT__PROBABILITY);
    createEAttribute(this.eventEClass, FTAPackage.EVENT__NAME);
    createEReference(this.eventEClass, FTAPackage.EVENT__GATE);
    createEReference(this.eventEClass, FTAPackage.EVENT__SUPER_GATE);

    this.gateEClass = createEClass(FTAPackage.GATE);
    createEReference(this.gateEClass, FTAPackage.GATE__SUB_EVENTS);
    createEAttribute(this.gateEClass, FTAPackage.GATE__LOGIC);
    createEReference(this.gateEClass, FTAPackage.GATE__EVENT);

    // Create enums
    this.gateLogicEEnum = createEEnum(FTAPackage.GATE_LOGIC);
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
    setName(FTAPackage.eNAME);
    setNsPrefix(FTAPackage.eNS_PREFIX);
    setNsURI(FTAPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(this.faultTreeEClass, FaultTree.class, "FaultTree", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFaultTree_Events(), this.getEvent(), null, "events", null, 1, -1, FaultTree.class, !EPackageImpl.IS_TRANSIENT,
                   !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE,
                   !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getFaultTree_Root(), this.getEvent(), null, "root", null, 1, 1, FaultTree.class, EPackageImpl.IS_TRANSIENT,
                   EPackageImpl.IS_VOLATILE, !EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE,
                   EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.eventEClass, Event.class, "Event", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEvent_Probability(), this.ecorePackage.getEBigDecimal(), "probability", null, 0, 1, Event.class,
                   !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED,
                   EPackageImpl.IS_ORDERED);
    initEAttribute(getEvent_Name(), this.ecorePackage.getEString(), "name", null, 1, 1, Event.class, !EPackageImpl.IS_TRANSIENT,
                   !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getEvent_Gate(), this.getGate(), this.getGate_Event(), "gate", null, 0, 1, Event.class,
                   !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
                   EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getEvent_SuperGate(), this.getGate(), this.getGate_SubEvents(), "superGate", null, 0, 1, Event.class,
                   !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
                   EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.gateEClass, Gate.class, "Gate", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGate_SubEvents(), this.getEvent(), this.getEvent_SuperGate(), "subEvents", null, 1, -1,
                   Gate.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES,
                   !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getGate_Logic(), this.getGateLogic(), "logic", null, 1, 1, Gate.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE,
                   EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getGate_Event(), this.getEvent(), this.getEvent_Gate(), "event", null, 1, 1, Gate.class,
                   !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
                   EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(this.gateLogicEEnum, GateLogic.class, "GateLogic");
    addEEnumLiteral(this.gateLogicEEnum, GateLogic.AND);
    addEEnumLiteral(this.gateLogicEEnum, GateLogic.OR);

    // Create resource
    createResource(FTAPackage.eNS_URI);
  }

} //FTAPackageImpl
