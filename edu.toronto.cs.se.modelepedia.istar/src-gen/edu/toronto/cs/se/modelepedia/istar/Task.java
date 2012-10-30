/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Task#getEnd <em>End</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Task#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends IntentionalElement {
	/**
	 * Returns the value of the '<em><b>End</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Goal#getMeans <em>Means</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' reference.
	 * @see #setEnd(Goal)
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getTask_End()
	 * @see edu.toronto.cs.se.modelepedia.istar.Goal#getMeans
	 * @model opposite="means"
	 * @generated
	 */
	Goal getEnd();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.Task#getEnd <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Goal value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getTask_Components()
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getComposite
	 * @model opposite="composite"
	 * @generated
	 */
	EList<IntentionalElement> getComponents();

} // Task
