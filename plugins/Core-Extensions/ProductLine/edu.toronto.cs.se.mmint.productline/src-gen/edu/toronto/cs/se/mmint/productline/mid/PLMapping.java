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

import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.productline.PLElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PL Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage#getPLMapping()
 * @model
 * @generated
 */
public interface PLMapping extends Mapping, PLElement {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
  @Override
  String toMIDCustomPrintLabel();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
  @Override
  String toMIDCustomEditLabel();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model newLabelRequired="true"
   * @generated
   */
  @Override
  void updateMIDCustomLabel(String newLabel);

} // PLMapping
