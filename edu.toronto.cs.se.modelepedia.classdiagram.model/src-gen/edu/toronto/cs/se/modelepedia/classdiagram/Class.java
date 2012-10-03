/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDependee <em>Dependencies As Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDepender <em>Dependencies As Depender</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassdiagramPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement {
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
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassdiagramPackage#getClass_OwnedAttributes()
	 * @model containment="true"
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
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassdiagramPackage#getClass_OwnedOperations()
	 * @model containment="true"
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
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassdiagramPackage#getClass_DependenciesAsDependee()
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
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassdiagramPackage#getClass_DependenciesAsDepender()
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDepender
	 * @model opposite="depender"
	 * @generated
	 */
	EList<Dependency> getDependenciesAsDepender();

} // Class
