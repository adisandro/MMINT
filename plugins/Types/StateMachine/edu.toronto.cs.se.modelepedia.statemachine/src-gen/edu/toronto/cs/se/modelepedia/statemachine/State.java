/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine.State#getNestedStates <em>Nested States</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getState()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface State extends AbstractState {
	/**
	 * Returns the value of the '<em><b>Nested States</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.statemachine.AbstractState}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getParentState <em>Parent State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested States</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getState_NestedStates()
	 * @see edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getParentState
	 * @model opposite="parentState" containment="true"
	 * @generated
	 */
	EList<AbstractState> getNestedStates();

} // State
