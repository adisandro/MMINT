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

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage#getPLGSNTemplate()
 * @model
 * @generated
 */
public interface PLGSNTemplate extends edu.toronto.cs.se.mmint.productline.Class {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  Map<String, PLGSNArgumentElement> getElementsById();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void validate() throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNChangeStep" exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" stepDataType="edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNChangeStep" stepRequired="true"
   * @generated
   */
  EList<PLGSNChangeStep> nextImpactSteps(PLGSNChangeStep step) throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" stepDataType="edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNChangeStep" stepRequired="true"
   * @generated
   */
  void impact(PLGSNChangeStep step) throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" productLineRequired="true"
   * @generated
   */
  void import_(ProductLine productLine) throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void instantiate() throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNChangeStep" exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" stepDataType="edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNChangeStep" stepRequired="true"
   * @generated
   */
  EList<PLGSNChangeStep> repair(PLGSNChangeStep step) throws Exception;
} // GSNPLTemplate
