/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * An abstract decision to be made within a MAVO model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.MAVODecision#getRequiredDecisions <em>Required Decisions</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVODecision()
 * @model abstract="true"
 * @generated
 */
public interface MAVODecision extends DecisionElement {
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

} // MAVODecision
