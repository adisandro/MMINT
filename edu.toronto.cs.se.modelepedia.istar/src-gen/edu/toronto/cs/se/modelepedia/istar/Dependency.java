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
package edu.toronto.cs.se.modelepedia.istar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDepender <em>Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDependee <em>Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDependum <em>Dependum</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependency()
 * @model
 * @generated
 */
public interface Dependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Depender</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDepender <em>Dependencies As Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depender</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depender</em>' reference.
	 * @see #setDepender(DependencyEndpoint)
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependency_Depender()
	 * @see edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDepender
	 * @model opposite="dependenciesAsDepender" required="true"
	 * @generated
	 */
	DependencyEndpoint getDepender();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDepender <em>Depender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depender</em>' reference.
	 * @see #getDepender()
	 * @generated
	 */
	void setDepender(DependencyEndpoint value);

	/**
	 * Returns the value of the '<em><b>Dependee</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDependee <em>Dependencies As Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependee</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependee</em>' reference.
	 * @see #setDependee(DependencyEndpoint)
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependency_Dependee()
	 * @see edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDependee
	 * @model opposite="dependenciesAsDependee" required="true"
	 * @generated
	 */
	DependencyEndpoint getDependee();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDependee <em>Dependee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependee</em>' reference.
	 * @see #getDependee()
	 * @generated
	 */
	void setDependee(DependencyEndpoint value);

	/**
	 * Returns the value of the '<em><b>Dependum</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependum</em>' containment reference.
	 * @see #setDependum(IntentionalElement)
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependency_Dependum()
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getDependency
	 * @model opposite="dependency" containment="true" required="true"
	 * @generated
	 */
	IntentionalElement getDependum();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDependum <em>Dependum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependum</em>' containment reference.
	 * @see #getDependum()
	 * @generated
	 */
	void setDependum(IntentionalElement value);

} // Dependency
