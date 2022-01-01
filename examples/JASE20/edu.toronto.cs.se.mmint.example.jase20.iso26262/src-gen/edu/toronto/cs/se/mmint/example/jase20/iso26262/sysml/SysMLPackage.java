/*******************************************************************************
 * Copyright (c) 2012, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLFactory
 * @model kind="package"
 * @generated
 */
public interface SysMLPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "sysml";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "sysml";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SysMLPackage eINSTANCE = edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLRootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLRootImpl
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLPackageImpl#getSysMLRoot()
   * @generated
   */
  int SYS_ML_ROOT = 0;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYS_ML_ROOT__ITEMS = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYS_ML_ROOT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYS_ML_ROOT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.ItemImpl <em>Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.ItemImpl
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLPackageImpl#getItem()
   * @generated
   */
  int ITEM = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM__NAME = 0;

  /**
   * The number of structural features of the '<em>Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLRoot
   * @generated
   */
  EClass getSysMLRoot();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLRoot#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLRoot#getItems()
   * @see #getSysMLRoot()
   * @generated
   */
  EReference getSysMLRoot_Items();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.Item <em>Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Item</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.Item
   * @generated
   */
  EClass getItem();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.Item#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.Item#getName()
   * @see #getItem()
   * @generated
   */
  EAttribute getItem_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SysMLFactory getSysMLFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLRootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLRootImpl
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLPackageImpl#getSysMLRoot()
     * @generated
     */
    EClass SYS_ML_ROOT = eINSTANCE.getSysMLRoot();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYS_ML_ROOT__ITEMS = eINSTANCE.getSysMLRoot_Items();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.ItemImpl
     * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLPackageImpl#getItem()
     * @generated
     */
    EClass ITEM = eINSTANCE.getItem();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITEM__NAME = eINSTANCE.getItem_Name();

  }

} //SysMLPackage
