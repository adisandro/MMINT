/*******************************************************************************
 * Copyright (c) 2020, 2025 Alessio Di Sandro.
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initial State</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getInitialState()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='atLeastOneOutgoing'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot atLeastOneOutgoing='Tuple {\n\tmessage : String = \'There must be at least one outgoing transition from the initial state\',\n\tstatus : Boolean = \n      outgoing-&gt;size() &gt;= 1\n}.status'"
 * @generated
 */
public interface InitialState extends State {
} // InitialState
