/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>Composition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getConstituent <em>Constituent</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getComposite <em>Composite</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getComposition()
 * @model
 * @generated
 */
public interface Composition extends NamedElement {
	/**
   * Returns the value of the '<em><b>Constituent</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsConstituent <em>Compositions As Constituent</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constituent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Constituent</em>' reference.
   * @see #setConstituent(edu.toronto.cs.se.modelepedia.classdiagram.Class)
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getComposition_Constituent()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsConstituent
   * @model opposite="compositionsAsConstituent" required="true"
   * @generated
   */
	edu.toronto.cs.se.modelepedia.classdiagram.Class getConstituent();

	/**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getConstituent <em>Constituent</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constituent</em>' reference.
   * @see #getConstituent()
   * @generated
   */
	void setConstituent(edu.toronto.cs.se.modelepedia.classdiagram.Class value);

	/**
   * Returns the value of the '<em><b>Composite</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsComposite <em>Compositions As Composite</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Composite</em>' reference.
   * @see #setComposite(edu.toronto.cs.se.modelepedia.classdiagram.Class)
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getComposition_Composite()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsComposite
   * @model opposite="compositionsAsComposite" required="true"
   * @generated
   */
	edu.toronto.cs.se.modelepedia.classdiagram.Class getComposite();

	/**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getComposite <em>Composite</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Composite</em>' reference.
   * @see #getComposite()
   * @generated
   */
	void setComposite(edu.toronto.cs.se.modelepedia.classdiagram.Class value);

	/**
   * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' attribute.
   * @see #setMultiplicity(String)
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getComposition_Multiplicity()
   * @model default=""
   * @generated
   */
	String getMultiplicity();

	/**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getMultiplicity <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' attribute.
   * @see #getMultiplicity()
   * @generated
   */
	void setMultiplicity(String value);

} // Composition
