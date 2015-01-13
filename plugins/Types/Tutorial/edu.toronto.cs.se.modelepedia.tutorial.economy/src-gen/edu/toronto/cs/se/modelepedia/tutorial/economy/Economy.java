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
package edu.toronto.cs.se.modelepedia.tutorial.economy;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Economy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.tutorial.economy.Economy#getGold <em>Gold</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.EconomyPackage#getEconomy()
 * @model
 * @generated
 */
public interface Economy extends EObject {
	/**
	 * Returns the value of the '<em><b>Gold</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.tutorial.economy.Gold}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gold</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gold</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.tutorial.economy.EconomyPackage#getEconomy_Gold()
	 * @model containment="true"
	 * @generated
	 */
	EList<Gold> getGold();

} // Economy
