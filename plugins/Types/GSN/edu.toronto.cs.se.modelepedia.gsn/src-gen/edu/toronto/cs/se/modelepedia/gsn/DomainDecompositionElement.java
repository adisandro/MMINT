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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Domain Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getDomainDecompositionElement()
 * @model abstract="true"
 * @generated
 */
public interface DomainDecompositionElement extends EObject {
  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @return the value of the '<em>Domain</em>' containment reference.
   * @see #setDomain(Domain)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getDomainDecompositionElement_Domain()
   * @model containment="true" required="true"
   * @generated
   */
  Domain getDomain();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Domain value);

} // DomainElement
