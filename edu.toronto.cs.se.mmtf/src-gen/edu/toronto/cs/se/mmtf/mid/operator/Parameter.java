/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.operator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#isVararg <em>Vararg</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getParameter()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isModelParameter'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot isModelParameter='type = ParameterType::MODEL or type = ParameterType::MODEL_REL implies self.oclIsKindOf(ModelParameter)'"
 * @generated
 */
public interface Parameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getParameter_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.operator.ParameterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.ParameterType
	 * @see #setType(ParameterType)
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getParameter_Type()
	 * @model required="true"
	 * @generated
	 */
	ParameterType getType();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.operator.ParameterType
	 * @see #getType()
	 * @generated
	 */
	void setType(ParameterType value);

	/**
	 * Returns the value of the '<em><b>Vararg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vararg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vararg</em>' attribute.
	 * @see #setVararg(boolean)
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getParameter_Vararg()
	 * @model required="true"
	 * @generated
	 */
	boolean isVararg();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.Parameter#isVararg <em>Vararg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vararg</em>' attribute.
	 * @see #isVararg()
	 * @generated
	 */
	void setVararg(boolean value);

} // Parameter
