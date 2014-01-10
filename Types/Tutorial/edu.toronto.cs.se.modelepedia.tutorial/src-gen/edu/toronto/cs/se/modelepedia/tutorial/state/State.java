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
package edu.toronto.cs.se.modelepedia.tutorial.state;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.tutorial.state.State#getProvinces <em>Provinces</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.tutorial.state.StatePackage#getState()
 * @model
 * @generated
 */
public interface State extends Region {
	/**
	 * Returns the value of the '<em><b>Provinces</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.tutorial.state.Province}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provinces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provinces</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.tutorial.state.StatePackage#getState_Provinces()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Province> getProvinces();

} // State
