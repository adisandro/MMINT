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
package edu.toronto.cs.se.modelepedia.powerwindow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.powerwindow.Switch#isOverridable <em>Overridable</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.powerwindow.PowerWindowPackage#getSwitch()
 * @model abstract="true"
 * @generated
 */
public interface Switch extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Overridable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridable</em>' attribute.
	 * @see #setOverridable(boolean)
	 * @see edu.toronto.cs.se.modelepedia.powerwindow.PowerWindowPackage#getSwitch_Overridable()
	 * @model required="true"
	 * @generated
	 */
	boolean isOverridable();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.powerwindow.Switch#isOverridable <em>Overridable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overridable</em>' attribute.
	 * @see #isOverridable()
	 * @generated
	 */
	void setOverridable(boolean value);

} // Switch
