/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>UML Model</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.papyrus.PapyrusPackage#getUMLModel()
 * @model
 * @generated
 */
public interface UMLModel extends Model {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
   * @generated
   */
  @Override
  void deleteInstanceAndFile() throws MMINTException;

} // UMLModel
