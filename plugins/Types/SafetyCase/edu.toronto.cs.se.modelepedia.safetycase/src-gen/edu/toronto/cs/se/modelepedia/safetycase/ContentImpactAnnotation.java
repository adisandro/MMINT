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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Impact Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getContentImpactAnnotation()
 * @model
 * @generated
 */
public interface ContentImpactAnnotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType
	 * @see #setType(ContentImpactType)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getContentImpactAnnotation_Type()
	 * @model required="true"
	 * @generated
	 */
	ContentImpactType getType();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ContentImpactType
	 * @see #getType()
	 * @generated
	 */
	void setType(ContentImpactType value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getContentImpactAnnotation_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentImpactAnnotation#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // ContentImpactAnnotation
