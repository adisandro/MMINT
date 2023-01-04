/*******************************************************************************
 * Copyright (c) 2017, 2023 Alessio Di Sandro, Nick Fung.
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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Supporter</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.Supporter#getSupports <em>Supports</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSupporter()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='GoalRoot'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot GoalRoot='self.supports.source -&gt; isEmpty() implies self.oclIsTypeOf(BasicGoal)'"
 * @generated
 */
public interface Supporter extends EObject {
  /**
   * Returns the value of the '<em><b>Supports</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the value of the '<em>Supports</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSupporter_Supports()
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy#getTarget
   * @model opposite="target"
   * @generated
   */
  EList<SupportedBy> getSupports();

} // Supporter
