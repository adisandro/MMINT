/*******************************************************************************
 * Copyright (c) 2020, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.lts;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LTS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.LTS#getStates <em>States</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.lts.LTS#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getLTS()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='oneInitial'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot oneInitial='Tuple {\n\tmessage : String = \'There must be one and only one initial state\',\n\tstatus : Boolean = \n      states-&gt;select(oclIsKindOf(InitialState))-&gt;size() = 1\n}.status'"
 * @generated
 */
public interface LTS extends EObject {
  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.types.lts.State}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getLTS_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.types.lts.Transition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getLTS_Transitions()
   * @model containment="true"
   * @generated
   */
  EList<Transition> getTransitions();

} // LTS
