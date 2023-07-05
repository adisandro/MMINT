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

import edu.toronto.cs.se.modelepedia.gsn.Goal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal#getHint <em>Hint</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getPropertyGoal()
 * @model
 * @generated
 */
public interface PropertyGoal extends Goal, PropertyDecompositionElement {
  /**
   * Returns the value of the '<em><b>Hint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hint</em>' attribute.
   * @see #setHint(String)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getPropertyGoal_Hint()
   * @model
   * @generated
   */
  String getHint();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal#getHint <em>Hint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hint</em>' attribute.
   * @see #getHint()
   * @generated
   */
  void setHint(String value);

} // PropertyGoal
