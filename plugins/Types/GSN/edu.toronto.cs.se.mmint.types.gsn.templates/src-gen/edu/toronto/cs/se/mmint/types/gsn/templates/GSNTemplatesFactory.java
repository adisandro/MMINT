/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage
 * @generated
 */
public interface GSNTemplatesFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GSNTemplatesFactory eINSTANCE = edu.toronto.cs.se.mmint.types.gsn.templates.impl.GSNTemplatesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Int Domain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Domain</em>'.
   * @generated
   */
  IntDomain createIntDomain();

  /**
   * Returns a new object of class '<em>Real Domain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Domain</em>'.
   * @generated
   */
  RealDomain createRealDomain();

  /**
   * Returns a new object of class '<em>Enum Domain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Domain</em>'.
   * @generated
   */
  EnumDomain createEnumDomain();

  /**
   * Returns a new object of class '<em>Value Domain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Domain</em>'.
   * @generated
   */
  ValueDomain createValueDomain();

  /**
   * Returns a new object of class '<em>Domain Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Domain Decomposition Strategy</em>'.
   * @generated
   */
  DomainDecompositionStrategy createDomainDecompositionStrategy();

  /**
   * Returns a new object of class '<em>Domain Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Domain Goal</em>'.
   * @generated
   */
  DomainGoal createDomainGoal();

  /**
   * Returns a new object of class '<em>Domain Decomposition Template</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Domain Decomposition Template</em>'.
   * @generated
   */
  DomainDecompositionTemplate createDomainDecompositionTemplate();

  /**
   * Returns a new object of class '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property</em>'.
   * @generated
   */
  Property createProperty();

  /**
   * Returns a new object of class '<em>Property Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Decomposition Strategy</em>'.
   * @generated
   */
  PropertyDecompositionStrategy createPropertyDecompositionStrategy();

  /**
   * Returns a new object of class '<em>Property Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Goal</em>'.
   * @generated
   */
  PropertyGoal createPropertyGoal();

  /**
   * Returns a new object of class '<em>Property Decomposition Template</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Decomposition Template</em>'.
   * @generated
   */
  PropertyDecompositionTemplate createPropertyDecompositionTemplate();

  /**
   * Returns a new object of class '<em>Files Context</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Files Context</em>'.
   * @generated
   */
  FilesContext createFilesContext();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GSNTemplatesPackage getGSNTemplatesPackage();

} //GSNTemplatesFactory
