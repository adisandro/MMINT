/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Supportable</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.Supportable#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.Supportable#getUndeveloped <em>Undeveloped</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSupportable()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SupportCycle StrategySupportsGoals'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot SupportCycle='self.supportedBy.target-&gt;closure(p | if p.oclIsKindOf(Supportable) then p.oclAsType(Supportable).supportedBy.target else p.oclAsSet() endif)-&gt;excludes(self)' StrategySupportsGoals='if self.oclIsKindOf(gsn::Strategy) then self.supportedBy-&gt;forAll(sb | sb.target.oclIsKindOf(gsn::Goal)) else true endif'"
 * @generated
 */
public interface Supportable extends Decoratable {
  /**
   * Returns the value of the '<em><b>Supported By</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getSource <em>Source</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the value of the '<em>Supported By</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSupportable_SupportedBy()
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getSource
   * @model opposite="source" containment="true" required="true"
   * @generated
   */
  EList<SupportedBy> getSupportedBy();

  /**
   * Returns the value of the '<em><b>Undeveloped</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Undeveloped</em>' containment reference.
   * @see #setUndeveloped(Undeveloped)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSupportable_Undeveloped()
   * @model containment="true"
   * @generated
   */
  Undeveloped getUndeveloped();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.Supportable#getUndeveloped <em>Undeveloped</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Undeveloped</em>' containment reference.
   * @see #getUndeveloped()
   * @generated
   */
  void setUndeveloped(Undeveloped value);

} // Supportable
