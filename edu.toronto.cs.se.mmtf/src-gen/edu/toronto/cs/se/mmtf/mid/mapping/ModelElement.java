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
package edu.toronto.cs.se.mmtf.mid.mapping;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElement#getCategory <em>Category</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElement#getPointer <em>Pointer</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElement#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory
	 * @see #setCategory(ModelElementCategory)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElement_Category()
	 * @model required="true"
	 * @generated
	 */
	ModelElementCategory getCategory();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElement#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory
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
	 * @see #setPointer(EObject)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElement_Pointer()
	 * @model required="true"
	 * @generated
	 */
	EObject getPointer();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElement#getPointer <em>Pointer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pointer</em>' reference.
	 * @see #getPointer()
	 * @generated
	 */
	void setPointer(EObject value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.mapping.Link}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmtf.mid.mapping.Link#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElement_Links()
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.Link#getElements
	 * @model opposite="elements"
	 * @generated
	 */
	EList<Link> getLinks();

} // ModelElement
