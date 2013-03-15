/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.mmtf.mavo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAVO Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract MAVO element. It represents an element that can have MAVO partiality annotations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isMay <em>May</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isSet <em>Set</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isVar <em>Var</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#getFormulaId <em>Formula Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mavo.MavoPackage#getMAVOElement()
 * @model abstract="true"
 * @generated
 */
public interface MAVOElement extends EObject {
	/**
	 * Returns the value of the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this element may exist (M), false if it must exist (E).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>May</em>' attribute.
	 * @see #setMay(boolean)
	 * @see edu.toronto.cs.se.mmtf.mavo.MavoPackage#getMAVOElement_May()
	 * @model
	 * @generated
	 */
	boolean isMay();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isMay <em>May</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>May</em>' attribute.
	 * @see #isMay()
	 * @generated
	 */
	void setMay(boolean value);

	/**
	 * Returns the value of the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this element represents a set (S), false if it represents a particular (P).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Set</em>' attribute.
	 * @see #setSet(boolean)
	 * @see edu.toronto.cs.se.mmtf.mavo.MavoPackage#getMAVOElement_Set()
	 * @model
	 * @generated
	 */
	boolean isSet();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isSet <em>Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set</em>' attribute.
	 * @see #isSet()
	 * @generated
	 */
	void setSet(boolean value);

	/**
	 * Returns the value of the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this element is a variable (V), false if it a constant (C).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Var</em>' attribute.
	 * @see #setVar(boolean)
	 * @see edu.toronto.cs.se.mmtf.mavo.MavoPackage#getMAVOElement_Var()
	 * @model
	 * @generated
	 */
	boolean isVar();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isVar <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' attribute.
	 * @see #isVar()
	 * @generated
	 */
	void setVar(boolean value);

	/**
	 * Returns the value of the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The identifier to be used in MAVO formulas.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Formula Id</em>' attribute.
	 * @see #setFormulaId(String)
	 * @see edu.toronto.cs.se.mmtf.mavo.MavoPackage#getMAVOElement_FormulaId()
	 * @model
	 * @generated
	 */
	String getFormulaId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#getFormulaId <em>Formula Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula Id</em>' attribute.
	 * @see #getFormulaId()
	 * @generated
	 */
	void setFormulaId(String value);

} // MAVOElement
