/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping;

import edu.toronto.cs.se.mmtf.mid.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getPointer <em>Pointer</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getMappingLinks <em>Mapping Links</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElementReference()
 * @model
 * @generated
 */
public interface ModelElementReference extends NamedElement {
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
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElementReference_Pointer()
	 * @model required="true"
	 * @generated
	 */
	EObject getPointer();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getPointer <em>Pointer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pointer</em>' reference.
	 * @see #getPointer()
	 * @generated
	 */
	void setPointer(EObject value);

	/**
	 * Returns the value of the '<em><b>Mapping Links</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.mapping.MappingLink}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingLink#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Links</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElementReference_MappingLinks()
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingLink#getElements
	 * @model opposite="elements"
	 * @generated
	 */
	EList<MappingLink> getMappingLinks();

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
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getModelElementReference_Category()
	 * @model required="true"
	 * @generated
	 */
	ModelElementCategory getCategory();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(ModelElementCategory value);

} // ModelElementReference
