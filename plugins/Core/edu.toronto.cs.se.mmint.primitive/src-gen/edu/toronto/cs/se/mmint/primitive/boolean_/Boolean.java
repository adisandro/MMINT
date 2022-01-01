/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.primitive.boolean_;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.primitive.boolean_.Boolean#isValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.primitive.boolean_.BooleanPackage#getBoolean()
 * @model
 * @generated
 */
public interface Boolean extends EObject {
	/**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(boolean)
   * @see edu.toronto.cs.se.mmint.primitive.boolean_.BooleanPackage#getBoolean_Value()
   * @model required="true"
   * @generated
   */
	boolean isValue();

	/**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.primitive.boolean_.Boolean#isValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #isValue()
   * @generated
   */
	void setValue(boolean value);

} // Boolean
