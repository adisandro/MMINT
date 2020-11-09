/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.primitive.boolean_;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see edu.toronto.cs.se.mmint.primitive.boolean_.BooleanFactory
 * @model kind="package"
 * @generated
 */
public interface BooleanPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "boolean";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://se.cs.toronto.edu/mmint/Boolean";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "boolean";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	BooleanPackage eINSTANCE = edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanPackageImpl.init();

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanImpl <em>Boolean</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanImpl
   * @see edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanPackageImpl#getBoolean()
   * @generated
   */
	int BOOLEAN = 0;

	/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BOOLEAN__VALUE = 0;

	/**
   * The number of structural features of the '<em>Boolean</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BOOLEAN_FEATURE_COUNT = 1;

	/**
   * The number of operations of the '<em>Boolean</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BOOLEAN_OPERATION_COUNT = 0;


	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.primitive.boolean_.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean</em>'.
   * @see edu.toronto.cs.se.mmint.primitive.boolean_.Boolean
   * @generated
   */
	EClass getBoolean();

	/**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.primitive.boolean_.Boolean#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.toronto.cs.se.mmint.primitive.boolean_.Boolean#isValue()
   * @see #getBoolean()
   * @generated
   */
	EAttribute getBoolean_Value();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	BooleanFactory getBooleanFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanImpl <em>Boolean</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanImpl
     * @see edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanPackageImpl#getBoolean()
     * @generated
     */
		EClass BOOLEAN = eINSTANCE.getBoolean();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute BOOLEAN__VALUE = eINSTANCE.getBoolean_Value();

	}

} //BooleanPackage
