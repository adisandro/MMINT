/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Rick Salay, Sahar Kokaly.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.SysMLPackage
 * @generated
 */
public interface SysMLFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SysMLFactory eINSTANCE = edu.toronto.cs.se.mmint.example.jase20.iso26262.sysml.impl.SysMLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  SysMLRoot createSysMLRoot();

  /**
   * Returns a new object of class '<em>Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Item</em>'.
   * @generated
   */
  Item createItem();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SysMLPackage getSysMLPackage();

} //SysMLFactory
