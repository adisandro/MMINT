/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine_mavo;

import edu.toronto.cs.se.mavo.MAVORoot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine#getStates <em>States</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends MAVORoot {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage#getStateMachine_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractState> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage#getStateMachine_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // StateMachine
