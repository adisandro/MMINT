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
 * A representation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An alternative for a MAVO decision.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.MAVOAlternative#getMavoElements <em>Mavo Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVOAlternative()
 * @model
 * @generated
 */
public interface MAVOAlternative extends DecisionElement {
	/**
	 * Returns the value of the '<em><b>Mavo Elements</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mavo.MAVOElement}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mavo.MAVOElement#getAlternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of MAVO elements in this alternative, possibly empty.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mavo Elements</em>' reference list.
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVOAlternative_MavoElements()
	 * @see edu.toronto.cs.se.mavo.MAVOElement#getAlternatives
	 * @model opposite="alternatives"
	 * @generated
	 */
	EList<MAVOElement> getMavoElements();

} // MAVOAlternative
