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
package edu.toronto.cs.se.mmtf.mid;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getModels <em>Models</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel()
 * @model
 * @generated
 */
public interface MultiModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Models</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.mid.Model},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' map.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel_Models()
	 * @model mapType="edu.toronto.cs.se.mmtf.mid.EStringToModelMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.mid.Model>"
	 * @generated
	 */
	EMap<String, Model> getModels();

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.mid.Editor},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' map.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel_Editors()
	 * @model mapType="edu.toronto.cs.se.mmtf.mid.EStringToEditorMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.mid.Editor>"
	 * @generated
	 */
	EMap<String, Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.mid.Operator},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' map.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel_Operators()
	 * @model mapType="edu.toronto.cs.se.mmtf.mid.EStringToOperatorMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.mid.Operator>"
	 * @generated
	 */
	EMap<String, Operator> getOperators();

} // MultiModel
