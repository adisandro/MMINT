/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Validity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.StateValidity#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getStateValidity()
 * @model
 * @generated
 */
public interface StateValidity extends ElementValidity {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.StatefulElement#getStateValidity <em>State Validity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' container reference.
	 * @see #setTarget(StatefulElement)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getStateValidity_Target()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.StatefulElement#getStateValidity
	 * @model opposite="stateValidity" required="true" transient="false"
	 * @generated
	 */
	StatefulElement getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.StateValidity#getTarget <em>Target</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' container reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(StatefulElement value);

} // StateValidity
