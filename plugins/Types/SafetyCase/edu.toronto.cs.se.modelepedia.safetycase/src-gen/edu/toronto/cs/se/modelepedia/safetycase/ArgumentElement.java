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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getStatuses <em>Statuses</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getContentValidity <em>Content Validity</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getArgumentElement()
 * @model abstract="true"
 * @generated
 */
public interface ArgumentElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getArgumentElement_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getArgumentElement_Description()
	 * @model annotation="gmf.label label='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Statuses</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statuses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statuses</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getArgumentElement_Statuses()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImpactAnnotation> getStatuses();

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getArgumentElement_ContentValidity()
	 * @model
	 * @generated
	 */
	ValidityValue getContentValidity();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getContentValidity <em>Content Validity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Validity</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ValidityValue
	 * @see #getContentValidity()
	 * @generated
	 */
	void setContentValidity(ValidityValue value);

} // ArgumentElement
