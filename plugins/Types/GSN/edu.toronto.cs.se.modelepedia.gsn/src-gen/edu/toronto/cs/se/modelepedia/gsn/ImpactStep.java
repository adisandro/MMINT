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
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.ImpactStep#getImpacted <em>Impacted</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.ImpactStep#getTrace <em>Trace</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getImpactStep()
 * @model
 * @generated
 */
public interface ImpactStep extends EObject {
  /**
   * Returns the value of the '<em><b>Impacted</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Impacted</em>' reference.
   * @see #setImpacted(ArgumentElement)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getImpactStep_Impacted()
   * @model required="true"
   * @generated
   */
  ArgumentElement getImpacted();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactStep#getImpacted <em>Impacted</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Impacted</em>' reference.
   * @see #getImpacted()
   * @generated
   */
  void setImpacted(ArgumentElement value);

  /**
   * Returns the value of the '<em><b>Trace</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getImpactStep_Trace()
   * @model
   * @generated
   */
  EList<EObject> getTrace();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" changeRequired="true"
   * @generated
   */
  void impact(Object change) throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model changeRequired="true" previousImpactRequired="true"
   * @generated
   */
  EList<ImpactStep> nextSteps(Object change, ImpactType previousImpact);

} // ImpactStep
