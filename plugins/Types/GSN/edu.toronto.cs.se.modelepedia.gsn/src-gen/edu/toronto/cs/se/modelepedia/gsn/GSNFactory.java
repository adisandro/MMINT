/*******************************************************************************
 * Copyright (c) 2017, 2025 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage
 * @generated
 */
public interface GSNFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  GSNFactory eINSTANCE = edu.toronto.cs.se.modelepedia.gsn.impl.GSNFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Safety Case</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Safety Case</em>'.
   * @generated
   */
  SafetyCase createSafetyCase();

  /**
   * Returns a new object of class '<em>Supported By</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Supported By</em>'.
   * @generated
   */
  SupportedBy createSupportedBy();

  /**
   * Returns a new object of class '<em>In Context Of</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>In Context Of</em>'.
   * @generated
   */
  InContextOf createInContextOf();

  /**
   * Returns a new object of class '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Goal</em>'.
   * @generated
   */
  Goal createGoal();

  /**
   * Returns a new object of class '<em>Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Strategy</em>'.
   * @generated
   */
  Strategy createStrategy();

  /**
   * Returns a new object of class '<em>Solution</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Solution</em>'.
   * @generated
   */
  Solution createSolution();

  /**
   * Returns a new object of class '<em>Context</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Context</em>'.
   * @generated
   */
  Context createContext();

  /**
   * Returns a new object of class '<em>Justification</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Justification</em>'.
   * @generated
   */
  Justification createJustification();

  /**
   * Returns a new object of class '<em>Assumption</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Assumption</em>'.
   * @generated
   */
  Assumption createAssumption();

  /**
   * Returns a new object of class '<em>ASIL</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>ASIL</em>'.
   * @generated
   */
  ASIL createASIL();

  /**
   * Returns a new object of class '<em>Impact Annotation</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Impact Annotation</em>'.
   * @generated
   */
  ImpactAnnotation createImpactAnnotation();

  /**
   * Returns a new object of class '<em>Template</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Template</em>'.
   * @generated
   */
  Template createTemplate();

  /**
   * Returns a new object of class '<em>Relationship Decorator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relationship Decorator</em>'.
   * @generated
   */
  RelationshipDecorator createRelationshipDecorator();

  /**
   * Returns a new object of class '<em>Undeveloped</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Undeveloped</em>'.
   * @generated
   */
  Undeveloped createUndeveloped();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GSNPackage getGSNPackage();

} // GSNFactory
