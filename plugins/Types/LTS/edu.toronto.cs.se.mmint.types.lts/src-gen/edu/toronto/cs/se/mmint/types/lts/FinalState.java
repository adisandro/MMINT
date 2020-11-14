/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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
 * A representation of the model object '<em><b>Final State</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage#getFinalState()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='noOutgoing'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot noOutgoing='Tuple {\n\tmessage : String = \'A final state can\\\'t have outgoing transitions\',\n\tstatus : Boolean = \n      outgoing-&gt;size() = 0\n}.status'"
 * @generated
 */
public interface FinalState extends State {
} // FinalState
