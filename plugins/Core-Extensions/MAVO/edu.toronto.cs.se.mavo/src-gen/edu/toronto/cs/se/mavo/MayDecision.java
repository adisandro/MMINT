/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mavo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>May Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A May decision to be made within a MAVO model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.MayDecision#getLogic <em>Logic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.MayDecision#getAlternatives <em>Alternatives</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMayDecision()
 * @model
 * @generated
 */
public interface MayDecision extends MAVODecision {
	/**
	 * Returns the value of the '<em><b>Logic</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mavo.MayDecisionLogic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The logic relationship between alternative options in this decision.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Logic</em>' attribute.
	 * @see edu.toronto.cs.se.mavo.MayDecisionLogic
	 * @see #setLogic(MayDecisionLogic)
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMayDecision_Logic()
	 * @model required="true"
	 * @generated
	 */
	MayDecisionLogic getLogic();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mavo.MayDecision#getLogic <em>Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logic</em>' attribute.
	 * @see edu.toronto.cs.se.mavo.MayDecisionLogic
	 * @see #getLogic()
	 * @generated
	 */
	void setLogic(MayDecisionLogic value);

	/**
	 * Returns the value of the '<em><b>Alternatives</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mavo.MAVOCollection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of alternative options for this decision.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alternatives</em>' containment reference list.
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMayDecision_Alternatives()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MAVOCollection> getAlternatives();

} // MayDecision
