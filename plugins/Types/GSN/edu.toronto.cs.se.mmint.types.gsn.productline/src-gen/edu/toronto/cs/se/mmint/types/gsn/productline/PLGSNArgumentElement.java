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
import java.util.Optional;

import edu.toronto.cs.se.modelepedia.gsn.ImpactType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage#getPLGSNArgumentElement()
 * @model
 * @generated
 */
public interface PLGSNArgumentElement extends edu.toronto.cs.se.mmint.productline.Class {
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
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void validate() throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  Map<ImpactType, Optional<String>> getImpact();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model impactTypesRequired="true"
   * @generated
   */
  void setImpact(Map<ImpactType, Optional<String>> impactTypes);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model impactTypeRequired="true"
   * @generated
   */
  void setImpact(ImpactType impactType);

} // GSNPLArgumentElement
