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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDependee <em>Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDepender <em>Depender</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getDependency()
 * @model
 * @generated
 */
public interface Dependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Dependee</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDependee <em>Dependencies As Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependee</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependee</em>' reference.
	 * @see #setDependee(edu.toronto.cs.se.modelepedia.classdiagram.Class)
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getDependency_Dependee()
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDependee
	 * @model opposite="dependenciesAsDependee" required="true"
	 * @generated
	 */
	edu.toronto.cs.se.modelepedia.classdiagram.Class getDependee();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDependee <em>Dependee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependee</em>' reference.
	 * @see #getDependee()
	 * @generated
	 */
	void setDependee(edu.toronto.cs.se.modelepedia.classdiagram.Class value);

	/**
	 * Returns the value of the '<em><b>Depender</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDepender <em>Dependencies As Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depender</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depender</em>' reference.
	 * @see #setDepender(edu.toronto.cs.se.modelepedia.classdiagram.Class)
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getDependency_Depender()
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDepender
	 * @model opposite="dependenciesAsDepender" required="true"
	 * @generated
	 */
	edu.toronto.cs.se.modelepedia.classdiagram.Class getDepender();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDepender <em>Depender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depender</em>' reference.
	 * @see #getDepender()
	 * @generated
	 */
	void setDepender(edu.toronto.cs.se.modelepedia.classdiagram.Class value);

} // Dependency
