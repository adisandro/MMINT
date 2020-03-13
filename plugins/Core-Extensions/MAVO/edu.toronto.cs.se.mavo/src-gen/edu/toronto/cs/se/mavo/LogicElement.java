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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logic Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract element of a logic formula, i.e. an element that can be represented by a variable in a logic formula.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.LogicElement#getFormulaVariable <em>Formula Variable</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getLogicElement()
 * @model abstract="true"
 * @generated
 */
public interface LogicElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variable in the logic formula that corresponds to this logic element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Formula Variable</em>' attribute.
	 * @see #setFormulaVariable(String)
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getLogicElement_FormulaVariable()
	 * @model
	 * @generated
	 */
	String getFormulaVariable();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mavo.LogicElement#getFormulaVariable <em>Formula Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula Variable</em>' attribute.
	 * @see #getFormulaVariable()
	 * @generated
	 */
	void setFormulaVariable(String value);

} // LogicElement
