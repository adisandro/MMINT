/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.tutorial.economy.impl;

import edu.toronto.cs.se.modelepedia.tutorial.army.ArmyPackage;

import edu.toronto.cs.se.modelepedia.tutorial.army.impl.ArmyPackageImpl;

import edu.toronto.cs.se.modelepedia.tutorial.economy.Economy;
import edu.toronto.cs.se.modelepedia.tutorial.economy.EconomyFactory;
import edu.toronto.cs.se.modelepedia.tutorial.economy.EconomyPackage;
import edu.toronto.cs.se.modelepedia.tutorial.economy.Gold;

import edu.toronto.cs.se.modelepedia.tutorial.state.StatePackage;

import edu.toronto.cs.se.modelepedia.tutorial.state.impl.StatePackageImpl;

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
public class EconomyPackageImpl extends EPackageImpl implements EconomyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass economyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goldEClass = null;

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
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.EconomyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EconomyPackageImpl() {
		super(eNS_URI, EconomyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EconomyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EconomyPackage init() {
		if (isInited) return (EconomyPackage)EPackage.Registry.INSTANCE.getEPackage(EconomyPackage.eNS_URI);

		// Obtain or create and register package
		EconomyPackageImpl theEconomyPackage = (EconomyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EconomyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EconomyPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		StatePackageImpl theStatePackage = (StatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatePackage.eNS_URI) instanceof StatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatePackage.eNS_URI) : StatePackage.eINSTANCE);
		ArmyPackageImpl theArmyPackage = (ArmyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ArmyPackage.eNS_URI) instanceof ArmyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ArmyPackage.eNS_URI) : ArmyPackage.eINSTANCE);

		// Create package meta-data objects
		theEconomyPackage.createPackageContents();
		theStatePackage.createPackageContents();
		theArmyPackage.createPackageContents();

		// Initialize created meta-data
		theEconomyPackage.initializePackageContents();
		theStatePackage.initializePackageContents();
		theArmyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEconomyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EconomyPackage.eNS_URI, theEconomyPackage);
		return theEconomyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEconomy() {
		return economyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEconomy_Gold() {
		return (EReference)economyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGold() {
		return goldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EconomyFactory getEconomyFactory() {
		return (EconomyFactory)getEFactoryInstance();
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
		economyEClass = createEClass(ECONOMY);
		createEReference(economyEClass, ECONOMY__GOLD);

		goldEClass = createEClass(GOLD);
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
		initEClass(economyEClass, Economy.class, "Economy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEconomy_Gold(), this.getGold(), null, "gold", null, 0, -1, Economy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goldEClass, Gold.class, "Gold", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EconomyPackageImpl
