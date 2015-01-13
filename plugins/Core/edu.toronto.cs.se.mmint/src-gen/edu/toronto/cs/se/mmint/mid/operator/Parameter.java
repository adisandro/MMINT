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
package edu.toronto.cs.se.mmint.mid.operator;

import edu.toronto.cs.se.mmint.mid.Model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An operator's parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#isVararg <em>Vararg</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getParameter_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Vararg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this parameter represents a variable argument, i.e. any number of actual arguments.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vararg</em>' attribute.
	 * @see #setVararg(boolean)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getParameter_Vararg()
	 * @model required="true"
	 * @generated
	 */
	boolean isVararg();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#isVararg <em>Vararg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vararg</em>' attribute.
	 * @see #isVararg()
	 * @generated
	 */
	void setVararg(boolean value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The model type or model instance identified by this parameter (types: formal argument; instances: actual argument).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(Model)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getParameter_Model()
	 * @model required="true"
	 * @generated
	 */
	Model getModel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.Parameter#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Model value);

} // Parameter
