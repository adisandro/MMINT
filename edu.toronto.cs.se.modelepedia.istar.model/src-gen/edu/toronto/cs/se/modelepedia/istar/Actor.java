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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Actor#getIntentionalElements <em>Intentional Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Actor#getDependenciesAsDepender <em>Dependencies As Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Actor#getDependenciesAsDependee <em>Dependencies As Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Actor#getContributions <em>Contributions</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends EObject {
	/**
	 * Returns the value of the '<em><b>Intentional Elements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intentional Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intentional Elements</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getActor_IntentionalElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntentionalElement> getIntentionalElements();

	/**
	 * Returns the value of the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Dependency}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDepender <em>Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies As Depender</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies As Depender</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getActor_DependenciesAsDepender()
	 * @see edu.toronto.cs.se.modelepedia.istar.Dependency#getDepender
	 * @model opposite="depender"
	 * @generated
	 */
	EList<Dependency> getDependenciesAsDepender();

	/**
	 * Returns the value of the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Dependency}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDependee <em>Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies As Dependee</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies As Dependee</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getActor_DependenciesAsDependee()
	 * @see edu.toronto.cs.se.modelepedia.istar.Dependency#getDependee
	 * @model opposite="dependee"
	 * @generated
	 */
	EList<Dependency> getDependenciesAsDependee();

	/**
	 * Returns the value of the '<em><b>Contributions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Contribution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributions</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getActor_Contributions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Contribution> getContributions();

} // Actor
