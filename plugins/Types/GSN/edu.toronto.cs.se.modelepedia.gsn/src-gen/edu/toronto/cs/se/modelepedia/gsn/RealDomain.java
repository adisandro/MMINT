/*******************************************************************************
 * Copyright (c) 2020, 2023 Alessio Di Sandro.
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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Real Domain</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.RealDomain#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.RealDomain#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getRealDomain()
 * @model
 * @generated
 */
public interface RealDomain extends Domain {
  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #setLowerBound(double)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getRealDomain_LowerBound()
   * @model required="true"
   * @generated
   */
  double getLowerBound();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.RealDomain#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(double value);

  /**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #setUpperBound(double)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getRealDomain_UpperBound()
   * @model required="true"
   * @generated
   */
  double getUpperBound();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.RealDomain#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #getUpperBound()
   * @generated
   */
  void setUpperBound(double value);

} // RealDomain
