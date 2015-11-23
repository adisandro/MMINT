/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine.Transition#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getTransition()
 * @model annotation="gmf.link label='trigger,action' label.pattern='{0}/{1}' label.icon='true' source='source' target='target' target.decoration='arrow'"
 * @generated
 */
public interface Transition extends FiringElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getTransitionsAsSource <em>Transitions As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(AbstractState)
	 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getTransition_Source()
	 * @see edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getTransitionsAsSource
	 * @model opposite="transitionsAsSource" required="true"
	 * @generated
	 */
	AbstractState getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.statemachine.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(AbstractState value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getTransitionsAsTarget <em>Transitions As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(AbstractState)
	 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getTransition_Target()
	 * @see edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getTransitionsAsTarget
	 * @model opposite="transitionsAsTarget" required="true"
	 * @generated
	 */
	AbstractState getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.statemachine.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AbstractState value);

} // Transition
