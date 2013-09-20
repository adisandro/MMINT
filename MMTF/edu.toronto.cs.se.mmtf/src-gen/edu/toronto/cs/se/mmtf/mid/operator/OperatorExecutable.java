/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.operator;

import edu.toronto.cs.se.mmtf.mid.Model;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Executable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The executable implementation interface of an operator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable#getInputSubdir <em>Input Subdir</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable#getPreviousExecutable <em>Previous Executable</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperatorExecutable()
 * @model abstract="true"
 * @generated
 */
public interface OperatorExecutable extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Subdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The subdirectory from where to get the input, when used in an operator chain.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Subdir</em>' attribute.
	 * @see #setInputSubdir(String)
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperatorExecutable_InputSubdir()
	 * @model
	 * @generated
	 */
	String getInputSubdir();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable#getInputSubdir <em>Input Subdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Subdir</em>' attribute.
	 * @see #getInputSubdir()
	 * @generated
	 */
	void setInputSubdir(String value);

	/**
	 * Returns the value of the '<em><b>Previous Executable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The previous operator executable, when used in an operator chain.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Previous Executable</em>' reference.
	 * @see #setPreviousExecutable(OperatorExecutable)
	 * @see edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage#getOperatorExecutable_PreviousExecutable()
	 * @model
	 * @generated
	 */
	OperatorExecutable getPreviousExecutable();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable#getPreviousExecutable <em>Previous Executable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Executable</em>' reference.
	 * @see #getPreviousExecutable()
	 * @generated
	 */
	void setPreviousExecutable(OperatorExecutable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Executes the operator.
	 * @param actualParameters The list of model parameters.
	 * <!-- end-model-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.operator.Exception" actualParametersRequired="true" actualParametersMany="true"
	 * @generated
	 */
	EList<Model> execute(EList<Model> actualParameters) throws Exception;

} // OperatorExecutable
