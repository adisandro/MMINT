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
 * A representation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Goal#getMeans <em>Means</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends IntentionalElement {
	/**
	 * Returns the value of the '<em><b>Means</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Task}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Task#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Means</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Means</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getGoal_Means()
	 * @see edu.toronto.cs.se.modelepedia.istar.Task#getEnd
	 * @model opposite="end"
	 * @generated
	 */
	EList<Task> getMeans();

} // Goal
