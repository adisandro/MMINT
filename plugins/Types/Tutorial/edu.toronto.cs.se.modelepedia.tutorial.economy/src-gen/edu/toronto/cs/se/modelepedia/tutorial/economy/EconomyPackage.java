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
package edu.toronto.cs.se.modelepedia.tutorial.economy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.EconomyFactory
 * @model kind="package"
 * @generated
 */
public interface EconomyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "economy";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/Economy";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "economy";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EconomyPackage eINSTANCE = edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyImpl <em>Economy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyImpl
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyPackageImpl#getEconomy()
	 * @generated
	 */
	int ECONOMY = 0;

	/**
	 * The feature id for the '<em><b>Gold</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONOMY__GOLD = 0;

	/**
	 * The number of structural features of the '<em>Economy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONOMY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Economy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONOMY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.tutorial.economy.impl.GoldImpl <em>Gold</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.impl.GoldImpl
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyPackageImpl#getGold()
	 * @generated
	 */
	int GOLD = 1;

	/**
	 * The number of structural features of the '<em>Gold</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOLD_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Gold</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOLD_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.tutorial.economy.Economy <em>Economy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Economy</em>'.
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.Economy
	 * @generated
	 */
	EClass getEconomy();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.tutorial.economy.Economy#getGold <em>Gold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gold</em>'.
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.Economy#getGold()
	 * @see #getEconomy()
	 * @generated
	 */
	EReference getEconomy_Gold();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.tutorial.economy.Gold <em>Gold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gold</em>'.
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.Gold
	 * @generated
	 */
	EClass getGold();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EconomyFactory getEconomyFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyImpl <em>Economy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyImpl
		 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyPackageImpl#getEconomy()
		 * @generated
		 */
		EClass ECONOMY = eINSTANCE.getEconomy();

		/**
		 * The meta object literal for the '<em><b>Gold</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECONOMY__GOLD = eINSTANCE.getEconomy_Gold();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.tutorial.economy.impl.GoldImpl <em>Gold</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.impl.GoldImpl
		 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.impl.EconomyPackageImpl#getGold()
		 * @generated
		 */
		EClass GOLD = eINSTANCE.getGold();

	}

} //EconomyPackage
