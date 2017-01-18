/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>Depender Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.DependerLink#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.DependerLink#getDepender <em>Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.DependerLink#getDependum <em>Dependum</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependerLink()
 * @model annotation="gmf.link target.decoration='arrow' source='depender' target='dependum'"
 * @generated
 */
public interface DependerLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependerLink_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='if depender.oclIsUndefined() or dependum.oclIsUndefined() then \'\' else depender.name.concat(\' 2 \').concat(dependum.name) endif'"
	 * @generated
	 */
	String getName();

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
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependerLink_Depender()
	 * @see edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint#getDependenciesAsDepender
	 * @model opposite="dependenciesAsDepender" required="true"
	 * @generated
	 */
	DependencyEndpoint getDepender();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.DependerLink#getDepender <em>Depender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depender</em>' reference.
	 * @see #getDepender()
	 * @generated
	 */
	void setDepender(DependencyEndpoint value);

	/**
	 * Returns the value of the '<em><b>Dependum</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Intention#getDependerLinks <em>Depender Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependum</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependum</em>' container reference.
	 * @see #setDependum(Intention)
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getDependerLink_Dependum()
	 * @see edu.toronto.cs.se.modelepedia.istar.Intention#getDependerLinks
	 * @model opposite="dependerLinks" required="true" transient="false"
	 * @generated
	 */
	Intention getDependum();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.DependerLink#getDependum <em>Dependum</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependum</em>' container reference.
	 * @see #getDependum()
	 * @generated
	 */
	void setDependum(Intention value);

} // DependerLink
