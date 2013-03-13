/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getAssociation()
 * @model annotation="gmf.link source='source' target='target' target.decoration='arrow' label='name'"
 * @generated
 */
public interface Association extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsSource <em>Associations As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(edu.toronto.cs.se.modelepedia.classdiagram.Class)
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getAssociation_Source()
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsSource
	 * @model opposite="associationsAsSource" required="true"
	 * @generated
	 */
	edu.toronto.cs.se.modelepedia.classdiagram.Class getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(edu.toronto.cs.se.modelepedia.classdiagram.Class value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsTarget <em>Associations As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(edu.toronto.cs.se.modelepedia.classdiagram.Class)
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getAssociation_Target()
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsTarget
	 * @model opposite="associationsAsTarget" required="true"
	 * @generated
	 */
	edu.toronto.cs.se.modelepedia.classdiagram.Class getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(edu.toronto.cs.se.modelepedia.classdiagram.Class value);

} // Association
