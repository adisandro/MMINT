/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Rick Salay, Sahar Kokaly.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.jase20.iso26262.hara;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.jase20.iso26262.hara.HARAPackage
 * @generated
 */
public interface HARAFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HARAFactory eINSTANCE = edu.toronto.cs.se.mmint.jase20.iso26262.hara.impl.HARAFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  HARARoot createHARARoot();

  /**
   * Returns a new object of class '<em>Hazard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hazard</em>'.
   * @generated
   */
  Hazard createHazard();

  /**
   * Returns a new object of class '<em>Operational Situation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operational Situation</em>'.
   * @generated
   */
  OperationalSituation createOperationalSituation();

  /**
   * Returns a new object of class '<em>Hazardous Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hazardous Event</em>'.
   * @generated
   */
  HazardousEvent createHazardousEvent();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  HARAPackage getHARAPackage();

} //HARAFactory
