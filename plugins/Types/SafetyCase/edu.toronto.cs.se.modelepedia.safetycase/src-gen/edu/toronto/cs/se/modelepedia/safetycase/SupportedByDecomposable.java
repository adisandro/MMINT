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
 * A representation of the model object '<em><b>Supported By Decomposable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedByDecomposable#getPremise <em>Premise</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSupportedByDecomposable()
 * @model
 * @generated
 */
public interface SupportedByDecomposable extends SupportedBy {
	/**
	 * Returns the value of the '<em><b>Premise</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Premise</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Premise</em>' reference.
	 * @see #setPremise(DecomposableCoreElement)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSupportedByDecomposable_Premise()
	 * @model required="true"
	 * @generated
	 */
	DecomposableCoreElement getPremise();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedByDecomposable#getPremise <em>Premise</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise</em>' reference.
	 * @see #getPremise()
	 * @generated
	 */
	void setPremise(DecomposableCoreElement value);

} // SupportedByDecomposable
