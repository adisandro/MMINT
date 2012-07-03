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
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getRoot <em>Root</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getOrigin <em>Origin</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getConversionOperators <em>Conversion Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_Root()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EObject getRoot();

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.ModelOrigin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelOrigin
	 * @see #setOrigin(ModelOrigin)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_Origin()
	 * @model required="true"
	 * @generated
	 */
	ModelOrigin getOrigin();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.Model#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelOrigin
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(ModelOrigin value);

	/**
	 * Returns the value of the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Extension</em>' attribute.
	 * @see #setFileExtension(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_FileExtension()
	 * @model required="true"
	 * @generated
	 */
	String getFileExtension();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.Model#getFileExtension <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Extension</em>' attribute.
	 * @see #getFileExtension()
	 * @generated
	 */
	void setFileExtension(String value);

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.editor.Editor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_Editors()
	 * @model
	 * @generated
	 */
	EList<Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElement> getElements();

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference.
	 * @see #setConstraint(ModelConstraint)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	ModelConstraint getConstraint();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.Model#getConstraint <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' containment reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(ModelConstraint value);

	/**
	 * Returns the value of the '<em><b>Conversion Operators</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversion Operators</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_ConversionOperators()
	 * @model
	 * @generated
	 */
	EList<ConversionOperator> getConversionOperators();

} // Model
