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
package edu.toronto.cs.se.modelepedia.tutorial.state;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Administrative Division</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.tutorial.state.AdministrativeDivision#getCapital <em>Capital</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.tutorial.state.StatePackage#getAdministrativeDivision()
 * @model abstract="true"
 * @generated
 */
public interface AdministrativeDivision extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Capital</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capital</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capital</em>' reference.
	 * @see #setCapital(City)
	 * @see edu.toronto.cs.se.modelepedia.tutorial.state.StatePackage#getAdministrativeDivision_Capital()
	 * @model required="true"
	 * @generated
	 */
	City getCapital();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.tutorial.state.AdministrativeDivision#getCapital <em>Capital</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capital</em>' reference.
	 * @see #getCapital()
	 * @generated
	 */
	void setCapital(City value);

} // AdministrativeDivision
