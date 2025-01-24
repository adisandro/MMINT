/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage
 * @generated
 */
public interface PLGSNFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PLGSNFactory eINSTANCE = edu.toronto.cs.se.mmint.types.gsn.productline.impl.PLGSNFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Argument Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Argument Element</em>'.
   * @generated
   */
  PLGSNArgumentElement createPLGSNArgumentElement();

  /**
   * Returns a new object of class '<em>Template</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Template</em>'.
   * @generated
   */
  PLGSNTemplate createPLGSNTemplate();

  /**
   * Returns a new object of class '<em>Analytic Template</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Analytic Template</em>'.
   * @generated
   */
  PLGSNAnalyticTemplate createPLGSNAnalyticTemplate();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PLGSNPackage getPLGSNPackage();

} //GSNPLFactory
