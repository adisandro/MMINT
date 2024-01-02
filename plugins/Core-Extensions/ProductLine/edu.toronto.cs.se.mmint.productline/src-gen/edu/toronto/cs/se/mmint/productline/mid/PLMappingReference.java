/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PL Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage#getPLMappingReference()
 * @model
 * @generated
 */
public interface PLMappingReference extends MappingReference {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  @Override
  PLMapping getObject();

} // PLMappingReference
