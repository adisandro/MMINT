/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.papyrus;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 *
 * @see edu.toronto.cs.se.mmint.papyrus.PapyrusPackage
 * @generated
 */
public interface PapyrusFactory extends EFactory {
  /**
   * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  PapyrusFactory eINSTANCE = edu.toronto.cs.se.mmint.papyrus.impl.PapyrusFactoryImpl.init();

  /**
   * Returns a new object of class '<em>UML Model</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>UML Model</em>'.
   * @generated
   */
  UMLModel createUMLModel();

  /**
   * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the package supported by this factory.
   * @generated
   */
  PapyrusPackage getPapyrusPackage();

} // PapyrusFactory
