/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAVO Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MAVO version. {@inheritDoc}
 * <!-- end-model-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage#getMAVOMappingReference()
 * @model
 * @generated
 */
public interface MAVOMappingReference extends MappingReference {

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * {@inheritDoc}<br />
   * Gets the referenced MAVO mapping.
   * <!-- end-model-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
	MAVOMapping getObject();
} // MAVOMappingReference
