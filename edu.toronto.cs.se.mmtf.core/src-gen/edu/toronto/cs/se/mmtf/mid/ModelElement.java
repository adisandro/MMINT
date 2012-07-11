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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getCategory <em>Category</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getPointer <em>Pointer</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getClassLiteral <em>Class Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.ModelElementCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElementCategory
	 * @see #setCategory(ModelElementCategory)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelElement_Category()
	 * @model required="true"
	 * @generated
	 */
	ModelElementCategory getCategory();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelElementCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(ModelElementCategory value);

	/**
	 * Returns the value of the '<em><b>Pointer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pointer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pointer</em>' reference.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelElement_Pointer()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EObject getPointer();

	/**
	 * Returns the value of the '<em><b>Class Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Literal</em>' attribute.
	 * @see #setClassLiteral(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModelElement_ClassLiteral()
	 * @model required="true"
	 * @generated
	 */
	String getClassLiteral();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.ModelElement#getClassLiteral <em>Class Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Literal</em>' attribute.
	 * @see #getClassLiteral()
	 * @generated
	 */
	void setClassLiteral(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (ModelElement) super.getMetatype();'"
	 * @generated
	 */
	ModelElement getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (ModelElement) super.getSupertype();'"
	 * @generated
	 */
	ModelElement getSupertype();

} // ModelElement
