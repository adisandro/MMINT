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

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNImpactStep;


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
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void validate() throws Exception;

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
   * @model dataType="edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNImpactStep" exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" stepDataType="edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNImpactStep" stepRequired="true" changeRequired="true"
   * @generated
   */
  EList<PLGSNImpactStep> impact(PLGSNImpactStep step, Object change) throws Exception;
} // GSNPLTemplate
