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
package edu.toronto.cs.se.mmtf.mid.operator;

import java.util.Random;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Operator Executable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The executable implementation interface of a random operator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.RandomOperatorExecutable#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getRandomOperatorExecutable()
 * @model abstract="true"
 * @generated
 */
public interface RandomOperatorExecutable extends OperatorExecutable {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The random variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #setState(Random)
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getRandomOperatorExecutable_State()
	 * @model dataType="edu.toronto.cs.se.mmtf.mid.operator.Random" required="true"
	 * @generated
	 */
	Random getState();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.RandomOperatorExecutable#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #getState()
	 * @generated
	 */
	void setState(Random value);

} // RandomOperatorExecutable
