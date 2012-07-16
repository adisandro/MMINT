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

import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getExtendibleTable <em>Extendible Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getLevel <em>Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel()
 * @model
 * @generated
 */
public interface MultiModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Models</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.Model}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel_Models()
	 * @model containment="true"
	 * @generated
	 */
	EList<Model> getModels();

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.editor.Editor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel_Editors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.operator.Operator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel_Operators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operator> getOperators();

	/**
	 * Returns the value of the '<em><b>Extendible Table</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.mid.ExtendibleElement},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extendible Table</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extendible Table</em>' map.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel_ExtendibleTable()
	 * @model mapType="edu.toronto.cs.se.mmtf.mid.EStringToExtendibleElementMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.mid.ExtendibleElement>"
	 * @generated
	 */
	EMap<String, ExtendibleElement> getExtendibleTable();

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.MidLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.MidLevel
	 * @see #setLevel(MidLevel)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMultiModel_Level()
	 * @model required="true"
	 * @generated
	 */
	MidLevel getLevel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.MultiModel#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.MidLevel
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(MidLevel value);

} // MultiModel
