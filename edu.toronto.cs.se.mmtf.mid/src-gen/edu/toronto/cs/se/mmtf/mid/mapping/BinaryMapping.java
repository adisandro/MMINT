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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMapping#getElement0 <em>Element0</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMapping#getElement1 <em>Element1</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getBinaryMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='targetElement isBinaryMapping sourceElement'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot targetElement='element1 = elements->at(2)' isBinaryMapping='elements->size() = 2' sourceElement='element0 = elements->at(1)'"
 * @generated
 */
public interface BinaryMapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Element0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element0</em>' reference.
	 * @see #setElement0(ModelElementReference)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getBinaryMapping_Element0()
	 * @model required="true"
	 * @generated
	 */
	ModelElementReference getElement0();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMapping#getElement0 <em>Element0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element0</em>' reference.
	 * @see #getElement0()
	 * @generated
	 */
	void setElement0(ModelElementReference value);

	/**
	 * Returns the value of the '<em><b>Element1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element1</em>' reference.
	 * @see #setElement1(ModelElementReference)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getBinaryMapping_Element1()
	 * @model required="true"
	 * @generated
	 */
	ModelElementReference getElement1();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMapping#getElement1 <em>Element1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element1</em>' reference.
	 * @see #getElement1()
	 * @generated
	 */
	void setElement1(ModelElementReference value);

} // BinaryMapping
