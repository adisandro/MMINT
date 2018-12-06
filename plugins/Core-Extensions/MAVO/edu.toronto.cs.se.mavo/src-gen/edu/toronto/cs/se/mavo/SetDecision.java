/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Set decision to be made within a MAVO model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.SetDecision#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getSetDecision()
 * @model
 * @generated
 */
public interface SetDecision extends MAVODecision {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set entity for this decision.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entity</em>' containment reference.
	 * @see #setEntity(MAVOCollection)
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getSetDecision_Entity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MAVOCollection getEntity();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mavo.SetDecision#getEntity <em>Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' containment reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(MAVOCollection value);

} // SetDecision
