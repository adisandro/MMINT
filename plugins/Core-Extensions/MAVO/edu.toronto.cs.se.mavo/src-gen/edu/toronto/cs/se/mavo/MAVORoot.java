/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract MAVO root. It represents a model root that can have MAVO open world annotations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.MAVORoot#isInc <em>Inc</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mavo.MAVORoot#getDecisions <em>Decisions</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVORoot()
 * @model abstract="true"
 * @generated
 */
public interface MAVORoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this model is incomplete (INC), false if it is complete (COMP).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inc</em>' attribute.
	 * @see #setInc(boolean)
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVORoot_Inc()
	 * @model
	 * @generated
	 */
	boolean isInc();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mavo.MAVORoot#isInc <em>Inc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inc</em>' attribute.
	 * @see #isInc()
	 * @generated
	 */
	void setInc(boolean value);

	/**
	 * Returns the value of the '<em><b>Decisions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mavo.MAVODecision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of decisions to be made within this MAVO model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Decisions</em>' containment reference list.
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVORoot_Decisions()
	 * @model containment="true"
	 * @generated
	 */
	EList<MAVODecision> getDecisions();

} // MAVORoot
