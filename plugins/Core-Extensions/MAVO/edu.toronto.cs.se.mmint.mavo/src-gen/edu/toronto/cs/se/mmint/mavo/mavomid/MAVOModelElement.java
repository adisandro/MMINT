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
package edu.toronto.cs.se.mmint.mavo.mavomid;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAVO Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MAVO version. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage#getMAVOModelElement()
 * @model
 * @generated
 */
public interface MAVOModelElement extends ModelElement, MAVOElement {

	/**
   * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
	String toMIDCustomPrintLabel();

	/**
   * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
	String toMIDCustomEditLabel();

	/**
   * <!-- begin-user-doc -->
	 * MAVO version. {@inheritDoc}
	 * <!-- end-user-doc -->
   * @model newLabelRequired="true"
   * @generated
   */
	void updateMIDCustomLabel(String newLabel);
} // MAVOModelElement
