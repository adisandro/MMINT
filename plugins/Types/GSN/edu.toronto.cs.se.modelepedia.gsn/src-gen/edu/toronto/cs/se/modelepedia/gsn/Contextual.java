/*******************************************************************************
 * Copyright (c) 2017, 2025 Alessio Di Sandro, Nick Fung.
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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Contextual Element</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.Contextual#getContextOf <em>Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getContextualElement()
 * @model abstract="true" annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ContextualElementSupporter
 *        ContextualElementContext'" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
 *        ContextualElementSupporter='self.oclAsType(DecomposableCoreElement).oclIsInvalid()'
 *        ContextualElementContext='self.oclAsType(DecomposableCoreElement).oclIsInvalid()'"
 * @generated
 */
public interface Contextual extends ArgumentElement {
  /**
   * Returns the value of the '<em><b>Context Of</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.InContextOf}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContext <em>Context</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the value of the '<em>Context Of</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getContextual_ContextOf()
   * @see edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContext
   * @model opposite="context" required="true"
   * @generated
   */
  EList<InContextOf> getContextOf();

} // ContextualElement
