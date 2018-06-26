/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getGoals <em>Goals</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getStrategies <em>Strategies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getContexts <em>Contexts</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getJustifications <em>Justifications</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SafetyCase#getAssumptions <em>Assumptions</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSafetyCase()
 * @model
 * @generated
 */
public interface SafetyCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.Goal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSafetyCase_Goals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Goal> getGoals();

	/**
	 * Returns the value of the '<em><b>Strategies</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.Strategy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategies</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSafetyCase_Strategies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Strategy> getStrategies();

	/**
	 * Returns the value of the '<em><b>Solutions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.Solution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solutions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutions</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSafetyCase_Solutions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Solution> getSolutions();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSafetyCase_Contexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Context> getContexts();

	/**
	 * Returns the value of the '<em><b>Justifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.Justification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Justifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Justifications</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSafetyCase_Justifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<Justification> getJustifications();

	/**
	 * Returns the value of the '<em><b>Assumptions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.Assumption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assumptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assumptions</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSafetyCase_Assumptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assumption> getAssumptions();

} // SafetyCase
