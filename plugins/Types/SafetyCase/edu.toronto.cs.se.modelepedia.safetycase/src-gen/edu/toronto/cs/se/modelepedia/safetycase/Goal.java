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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getStateValidity <em>State Validity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getAsil <em>Asil</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getContentValidity <em>Content Validity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getSupportedBy <em>Supported By</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends DecomposableCoreElement {
	/**
	 * Returns the value of the '<em><b>State Validity</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.safetycase.ValidityValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Validity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Validity</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
	 * @see #setStateValidity(ValidityValue)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getGoal_StateValidity()
	 * @model
	 * @generated
	 */
	ValidityValue getStateValidity();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getStateValidity <em>State Validity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Validity</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
	 * @see #getStateValidity()
	 * @generated
	 */
	void setStateValidity(ValidityValue value);

	/**
	 * Returns the value of the '<em><b>Asil</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asil</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asil</em>' containment reference.
	 * @see #setAsil(ASIL)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getGoal_Asil()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	ASIL getAsil();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getAsil <em>Asil</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asil</em>' containment reference.
	 * @see #getAsil()
	 * @generated
	 */
	void setAsil(ASIL value);

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getGoal_ContentValidity()
	 * @model
	 * @generated
	 */
	ValidityValue getContentValidity();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getContentValidity <em>Content Validity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Validity</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
	 * @see #getContentValidity()
	 * @generated
	 */
	void setContentValidity(ValidityValue value);

	/**
	 * Returns the value of the '<em><b>Supported By</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.GoalSupportedBy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported By</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported By</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getGoal_SupportedBy()
	 * @model containment="true"
	 * @generated
	 */
	EList<GoalSupportedBy> getSupportedBy();

} // Goal
