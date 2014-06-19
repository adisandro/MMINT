/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A decision to be made within a MAVO model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.MAVODecision#getLogic <em>Logic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.MAVODecision#getRequiredDecisions <em>Required Decisions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.MAVODecision#getAlternatives <em>Alternatives</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVODecision()
 * @model
 * @generated
 */
public interface MAVODecision extends LogicElement {
	/**
	 * Returns the value of the '<em><b>Logic</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mavo.MAVODecisionLogic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The logic relationship between alternative options in this decision.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Logic</em>' attribute.
	 * @see edu.toronto.cs.se.mavo.MAVODecisionLogic
	 * @see #setLogic(MAVODecisionLogic)
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVODecision_Logic()
	 * @model required="true"
	 * @generated
	 */
	MAVODecisionLogic getLogic();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mavo.MAVODecision#getLogic <em>Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logic</em>' attribute.
	 * @see edu.toronto.cs.se.mavo.MAVODecisionLogic
	 * @see #getLogic()
	 * @generated
	 */
	void setLogic(MAVODecisionLogic value);

	/**
	 * Returns the value of the '<em><b>Required Decisions</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mavo.MAVODecision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of required decisions that must be resolved before resolving this decision.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required Decisions</em>' reference list.
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVODecision_RequiredDecisions()
	 * @model
	 * @generated
	 */
	EList<MAVODecision> getRequiredDecisions();

	/**
	 * Returns the value of the '<em><b>Alternatives</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mavo.MAVOAlternative}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of alternatives options for this decision.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alternatives</em>' containment reference list.
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVODecision_Alternatives()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MAVOAlternative> getAlternatives();

} // MAVODecision
