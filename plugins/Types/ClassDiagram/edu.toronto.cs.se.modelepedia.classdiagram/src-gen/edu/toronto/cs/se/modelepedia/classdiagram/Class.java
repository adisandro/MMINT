/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDependee <em>Dependencies As Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDepender <em>Dependencies As Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getNestedIn <em>Nested In</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getNested <em>Nested</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getSuperclass <em>Superclass</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getSubclasses <em>Subclasses</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsSource <em>Associations As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsTarget <em>Associations As Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsConstituent <em>Compositions As Constituent</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsComposite <em>Compositions As Composite</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Class extends Typeable {
	/**
   * Returns the value of the '<em><b>Owned Attributes</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Attribute}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Attributes</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_OwnedAttributes()
   * @model containment="true"
   *        annotation="gmf.compartment layout='list'"
   * @generated
   */
	EList<Attribute> getOwnedAttributes();

	/**
   * Returns the value of the '<em><b>Owned Operations</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Operation}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Operations</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_OwnedOperations()
   * @model containment="true"
   *        annotation="gmf.compartment layout='list'"
   * @generated
   */
	EList<Operation> getOwnedOperations();

	/**
   * Returns the value of the '<em><b>Dependencies As Dependee</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDependee <em>Dependee</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies As Dependee</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Dependencies As Dependee</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_DependenciesAsDependee()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDependee
   * @model opposite="dependee"
   * @generated
   */
	EList<Dependency> getDependenciesAsDependee();

	/**
   * Returns the value of the '<em><b>Dependencies As Depender</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDepender <em>Depender</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies As Depender</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Dependencies As Depender</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_DependenciesAsDepender()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDepender
   * @model opposite="depender"
   * @generated
   */
	EList<Dependency> getDependenciesAsDepender();

	/**
   * Returns the value of the '<em><b>Nested In</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getNested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Nested In</em>' reference.
   * @see #setNestedIn(Class)
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_NestedIn()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getNested
   * @model opposite="nested"
   *        annotation="gmf.link target.decoration='square'"
   * @generated
   */
	Class getNestedIn();

	/**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getNestedIn <em>Nested In</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nested In</em>' reference.
   * @see #getNestedIn()
   * @generated
   */
	void setNestedIn(Class value);

	/**
   * Returns the value of the '<em><b>Nested</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Class}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getNestedIn <em>Nested In</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Nested</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_Nested()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getNestedIn
   * @model opposite="nestedIn"
   * @generated
   */
	EList<Class> getNested();

	/**
   * Returns the value of the '<em><b>Superclass</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getSubclasses <em>Subclasses</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Superclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Superclass</em>' reference.
   * @see #setSuperclass(Class)
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_Superclass()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getSubclasses
   * @model opposite="subclasses"
   *        annotation="gmf.link target.decoration='closedarrow'"
   * @generated
   */
	Class getSuperclass();

	/**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getSuperclass <em>Superclass</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Superclass</em>' reference.
   * @see #getSuperclass()
   * @generated
   */
	void setSuperclass(Class value);

	/**
   * Returns the value of the '<em><b>Subclasses</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Class}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getSuperclass <em>Superclass</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subclasses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Subclasses</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_Subclasses()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getSuperclass
   * @model opposite="superclass"
   * @generated
   */
	EList<Class> getSubclasses();

	/**
   * Returns the value of the '<em><b>Associations As Source</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Association}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations As Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Associations As Source</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_AssociationsAsSource()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Association#getSource
   * @model opposite="source"
   * @generated
   */
	EList<Association> getAssociationsAsSource();

	/**
   * Returns the value of the '<em><b>Associations As Target</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Association}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations As Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Associations As Target</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_AssociationsAsTarget()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Association#getTarget
   * @model opposite="target"
   * @generated
   */
	EList<Association> getAssociationsAsTarget();

	/**
   * Returns the value of the '<em><b>Compositions As Constituent</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Composition}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getConstituent <em>Constituent</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compositions As Constituent</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Compositions As Constituent</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_CompositionsAsConstituent()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Composition#getConstituent
   * @model opposite="constituent"
   * @generated
   */
	EList<Composition> getCompositionsAsConstituent();

	/**
   * Returns the value of the '<em><b>Compositions As Composite</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Composition}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getComposite <em>Composite</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compositions As Composite</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Compositions As Composite</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClass_CompositionsAsComposite()
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Composition#getComposite
   * @model opposite="composite"
   * @generated
   */
	EList<Composition> getCompositionsAsComposite();

} // Class
