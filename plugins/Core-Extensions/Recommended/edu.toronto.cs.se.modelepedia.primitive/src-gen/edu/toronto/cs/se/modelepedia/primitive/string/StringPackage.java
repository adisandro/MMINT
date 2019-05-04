/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.primitive.string;

import java.lang.String;

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
 * @see edu.toronto.cs.se.modelepedia.primitive.string.StringFactory
 * @model kind="package"
 * @generated
 */
public interface StringPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "string";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/String";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "string";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	StringPackage eINSTANCE = edu.toronto.cs.se.modelepedia.primitive.string.impl.StringPackageImpl.init();

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.primitive.string.impl.StringImpl <em>String</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.primitive.string.impl.StringImpl
   * @see edu.toronto.cs.se.modelepedia.primitive.string.impl.StringPackageImpl#getString()
   * @generated
   */
	int STRING = 0;

	/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STRING__VALUE = 0;

	/**
   * The number of structural features of the '<em>String</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STRING_FEATURE_COUNT = 1;

	/**
   * The number of operations of the '<em>String</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STRING_OPERATION_COUNT = 0;


	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.primitive.string.String <em>String</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>String</em>'.
   * @see edu.toronto.cs.se.modelepedia.primitive.string.String
   * @generated
   */
	EClass getString();

	/**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.primitive.string.String#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.toronto.cs.se.modelepedia.primitive.string.String#getValue()
   * @see #getString()
   * @generated
   */
	EAttribute getString_Value();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	StringFactory getStringFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.primitive.string.impl.StringImpl <em>String</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.primitive.string.impl.StringImpl
     * @see edu.toronto.cs.se.modelepedia.primitive.string.impl.StringPackageImpl#getString()
     * @generated
     */
		EClass STRING = eINSTANCE.getString();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute STRING__VALUE = eINSTANCE.getString_Value();

	}

} //StringPackage
