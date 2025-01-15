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
package edu.toronto.cs.se.modelepedia.istar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependee Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.DependeeLink#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.DependeeLink#getDependum <em>Dependum</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.DependeeLink#getDependee <em>Dependee</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependeeLink()
 * @model annotation="gmf.link target.decoration='arrow' source='dependum' target='dependee'"
 * @generated
 */
public interface DependeeLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependeeLink_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if dependum.oclIsUndefined() or dependee.oclIsUndefined() then \'\' else dependum.name.concat(\' 2 \').concat(dependee.name) endif'"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Dependum</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Intention#getDependeeLinks <em>Dependee Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependum</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependum</em>' container reference.
	 * @see #setDependum(Intention)
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependeeLink_Dependum()
	 * @see edu.toronto.cs.se.modelepedia.istar.Intention#getDependeeLinks
	 * @model opposite="dependeeLinks" required="true" transient="false"
	 * @generated
	 */
	Intention getDependum();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.DependeeLink#getDependum <em>Dependum</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependum</em>' container reference.
	 * @see #getDependum()
	 * @generated
	 */
	void setDependum(Intention value);

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
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependeeLink_Dependee()
	 * @see edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDependee
	 * @model opposite="dependenciesAsDependee" required="true"
	 * @generated
	 */
	DependencyEndpoint getDependee();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.DependeeLink#getDependee <em>Dependee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependee</em>' reference.
	 * @see #getDependee()
	 * @generated
	 */
	void setDependee(DependencyEndpoint value);

} // DependeeLink
