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
 * A representation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getContributor <em>Contributor</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getContributee <em>Contributee</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getContribution()
 * @model
 * @generated
 */
public interface Contribution extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getContribution_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Contributor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getContributionsAsContributor <em>Contributions As Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributor</em>' reference.
	 * @see #setContributor(IntentionalElement)
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getContribution_Contributor()
	 * @see edu.toronto.cs.se.modelepedia.istar.IntentionalElement#getContributionsAsContributor
	 * @model opposite="contributionsAsContributor" required="true"
	 * @generated
	 */
	IntentionalElement getContributor();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getContributor <em>Contributor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contributor</em>' reference.
	 * @see #getContributor()
	 * @generated
	 */
	void setContributor(IntentionalElement value);

	/**
	 * Returns the value of the '<em><b>Contributee</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.SoftGoal#getContributionsAsContributee <em>Contributions As Contributee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributee</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributee</em>' reference.
	 * @see #setContributee(SoftGoal)
	 * @see edu.toronto.cs.se.modelepedia.istar.IstarPackage#getContribution_Contributee()
	 * @see edu.toronto.cs.se.modelepedia.istar.SoftGoal#getContributionsAsContributee
	 * @model opposite="contributionsAsContributee" required="true"
	 * @generated
	 */
	SoftGoal getContributee();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getContributee <em>Contributee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contributee</em>' reference.
	 * @see #getContributee()
	 * @generated
	 */
	void setContributee(SoftGoal value);

} // Contribution
