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
 * A representation of the model object '<em><b>Intentional Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getDependency <em>Dependency</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getComposite <em>Composite</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getContributionsAsContributor <em>Contributions As Contributor</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getIntentionalElement()
 * @model abstract="true"
 * @generated
 */
public interface IntentionalElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Dependency#getDependum <em>Dependum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' container reference.
	 * @see #setDependency(Dependency)
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getIntentionalElement_Dependency()
	 * @see edu.toronto.cs.se.modelepedia.istar.Dependency#getDependum
	 * @model opposite="dependum" transient="false"
	 * @generated
	 */
	Dependency getDependency();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getDependency <em>Dependency</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency</em>' container reference.
	 * @see #getDependency()
	 * @generated
	 */
	void setDependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getIntentionalElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Composite</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Task#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite</em>' reference.
	 * @see #setComposite(Task)
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getIntentionalElement_Composite()
	 * @see edu.toronto.cs.se.modelepedia.istar.Task#getComponents
	 * @model opposite="components"
	 * @generated
	 */
	Task getComposite();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getComposite <em>Composite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite</em>' reference.
	 * @see #getComposite()
	 * @generated
	 */
	void setComposite(Task value);

	/**
	 * Returns the value of the '<em><b>Contributions As Contributor</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Contribution}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getContributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributions As Contributor</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributions As Contributor</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getIntentionalElement_ContributionsAsContributor()
	 * @see edu.toronto.cs.se.modelepedia.istar.Contribution#getContributor
	 * @model opposite="contributor"
	 * @generated
	 */
	EList<Contribution> getContributionsAsContributor();

} // IntentionalElement
