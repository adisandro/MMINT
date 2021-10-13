/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.mid;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage
 * @generated
 */
public interface ProductLineMIDFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ProductLineMIDFactory eINSTANCE = edu.toronto.cs.se.mmint.productline.mid.impl.ProductLineMIDFactoryImpl.init();

  /**
   * Returns a new object of class '<em>PL Model Rel</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PL Model Rel</em>'.
   * @generated
   */
  PLModelRel createPLModelRel();

  /**
   * Returns a new object of class '<em>PL Binary Model Rel</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PL Binary Model Rel</em>'.
   * @generated
   */
  PLBinaryModelRel createPLBinaryModelRel();

  /**
   * Returns a new object of class '<em>PL Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PL Mapping</em>'.
   * @generated
   */
  PLMapping createPLMapping();

  /**
   * Returns a new object of class '<em>PL Binary Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PL Binary Mapping</em>'.
   * @generated
   */
  PLBinaryMapping createPLBinaryMapping();

  /**
   * Returns a new object of class '<em>PL Mapping Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PL Mapping Reference</em>'.
   * @generated
   */
  PLMappingReference createPLMappingReference();

  /**
   * Returns a new object of class '<em>PL Binary Mapping Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PL Binary Mapping Reference</em>'.
   * @generated
   */
  PLBinaryMappingReference createPLBinaryMappingReference();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ProductLineMIDPackage getProductLineMIDPackage();

} //ProductLineMIDFactory
