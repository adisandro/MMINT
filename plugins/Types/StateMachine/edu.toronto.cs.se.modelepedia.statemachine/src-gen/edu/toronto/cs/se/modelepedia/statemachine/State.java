/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine.State#getInternalActions <em>Internal Actions</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getState()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface State extends AbstractState {
	/**
	 * Returns the value of the '<em><b>Internal Actions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.statemachine.StateAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Actions</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getState_InternalActions()
	 * @model containment="true"
	 *        annotation="gmf.compartment layout='list'"
	 * @generated
	 */
	EList<StateAction> getInternalActions();

} // State
