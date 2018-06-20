/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getTransitionsAsSource <em>Transitions As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getTransitionsAsTarget <em>Transitions As Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getAbstractState()
 * @model abstract="true"
 * @generated
 */
public interface AbstractState extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getAbstractState_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.statemachine.AbstractState#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Transitions As Source</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.statemachine.Transition}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.statemachine.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions As Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions As Source</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getAbstractState_TransitionsAsSource()
	 * @see edu.toronto.cs.se.modelepedia.statemachine.Transition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Transition> getTransitionsAsSource();

	/**
	 * Returns the value of the '<em><b>Transitions As Target</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.statemachine.Transition}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.statemachine.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions As Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions As Target</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage#getAbstractState_TransitionsAsTarget()
	 * @see edu.toronto.cs.se.modelepedia.statemachine.Transition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Transition> getTransitionsAsTarget();

} // AbstractState
