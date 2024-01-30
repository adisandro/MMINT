/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decoratable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.Decoratable#getDecorators <em>Decorators</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getDecoratable()
 * @model abstract="true"
 * @generated
 */
public interface Decoratable extends ArgumentElement {
  /**
   * Returns the value of the '<em><b>Decorators</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decorators</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getDecoratable_Decorators()
   * @model containment="true"
   * @generated
   */
  EList<RelationshipDecorator> getDecorators();

} // Decoratable
