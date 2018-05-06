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
 * A representation of the model object '<em><b>Justification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.Justification#getContentValidity <em>Content Validity</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getJustification()
 * @model
 * @generated
 */
public interface Justification extends ContextualElement {
	/**
	 * Returns the value of the '<em><b>Content Validity</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.safetycase.ValidityValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Validity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Validity</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
	 * @see #setContentValidity(ValidityValue)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getJustification_ContentValidity()
	 * @model
	 * @generated
	 */
	ValidityValue getContentValidity();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.Justification#getContentValidity <em>Content Validity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Validity</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
	 * @see #getContentValidity()
	 * @generated
	 */
	void setContentValidity(ValidityValue value);

} // Justification
