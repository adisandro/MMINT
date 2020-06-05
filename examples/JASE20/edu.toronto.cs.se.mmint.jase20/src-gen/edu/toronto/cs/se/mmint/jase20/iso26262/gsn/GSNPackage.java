/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Rick Salay, Sahar Kokaly.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.jase20.iso26262.gsn;

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
 * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.GSNFactory
 * @model kind="package"
 * @generated
 */
public interface GSNPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gsn";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "edu.toronto.cs.se.mmint.jase20.iso26262.gsn";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gsn";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GSNPackage eINSTANCE = edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNRootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNRootImpl
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNPackageImpl#getGSNRoot()
   * @generated
   */
  int GSN_ROOT = 0;

  /**
   * The feature id for the '<em><b>Goals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSN_ROOT__GOALS = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSN_ROOT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GSN_ROOT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.SafetyGoalImpl <em>Safety Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.SafetyGoalImpl
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNPackageImpl#getSafetyGoal()
   * @generated
   */
  int SAFETY_GOAL = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_GOAL__DESCRIPTION = 0;

  /**
   * The feature id for the '<em><b>ASIL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_GOAL__ASIL = 1;

  /**
   * The number of structural features of the '<em>Safety Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_GOAL_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Safety Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFETY_GOAL_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.GSNRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.GSNRoot
   * @generated
   */
  EClass getGSNRoot();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.GSNRoot#getGoals <em>Goals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Goals</em>'.
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.GSNRoot#getGoals()
   * @see #getGSNRoot()
   * @generated
   */
  EReference getGSNRoot_Goals();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal <em>Safety Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Safety Goal</em>'.
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal
   * @generated
   */
  EClass getSafetyGoal();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal#getDescription()
   * @see #getSafetyGoal()
   * @generated
   */
  EAttribute getSafetyGoal_Description();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal#getASIL <em>ASIL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ASIL</em>'.
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal#getASIL()
   * @see #getSafetyGoal()
   * @generated
   */
  EAttribute getSafetyGoal_ASIL();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GSNFactory getGSNFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNRootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNRootImpl
     * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNPackageImpl#getGSNRoot()
     * @generated
     */
    EClass GSN_ROOT = eINSTANCE.getGSNRoot();

    /**
     * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GSN_ROOT__GOALS = eINSTANCE.getGSNRoot_Goals();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.SafetyGoalImpl <em>Safety Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.SafetyGoalImpl
     * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.impl.GSNPackageImpl#getSafetyGoal()
     * @generated
     */
    EClass SAFETY_GOAL = eINSTANCE.getSafetyGoal();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFETY_GOAL__DESCRIPTION = eINSTANCE.getSafetyGoal_Description();

    /**
     * The meta object literal for the '<em><b>ASIL</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFETY_GOAL__ASIL = eINSTANCE.getSafetyGoal_ASIL();

  }

} //GSNPackage
