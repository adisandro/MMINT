/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.TypedElement#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.TypedElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface TypedElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.classdiagram.Visibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Visibility
	 * @see #setVisibility(Visibility)
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getTypedElement_Visibility()
	 * @model required="true"
	 * @generated
	 */
	Visibility getVisibility();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.TypedElement#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Visibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(Visibility value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(edu.toronto.cs.se.modelepedia.classdiagram.Class)
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getTypedElement_Type()
	 * @model required="true"
	 * @generated
	 */
	edu.toronto.cs.se.modelepedia.classdiagram.Class getType();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.TypedElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(edu.toronto.cs.se.modelepedia.classdiagram.Class value);

} // TypedElement
