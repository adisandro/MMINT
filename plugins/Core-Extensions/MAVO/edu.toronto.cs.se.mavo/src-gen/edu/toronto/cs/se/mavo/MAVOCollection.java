/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A collection of MAVO elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.MAVOCollection#getMavoElements <em>Mavo Elements</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVOCollection()
 * @model
 * @generated
 */
public interface MAVOCollection extends DecisionElement {
	/**
	 * Returns the value of the '<em><b>Mavo Elements</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mavo.MAVOElement}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mavo.MAVOElement#getCollections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of MAVO elements in this collection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mavo Elements</em>' reference list.
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getMAVOCollection_MavoElements()
	 * @see edu.toronto.cs.se.mavo.MAVOElement#getCollections
	 * @model opposite="collections"
	 * @generated
	 */
	EList<MAVOElement> getMavoElements();

} // MAVOCollection
