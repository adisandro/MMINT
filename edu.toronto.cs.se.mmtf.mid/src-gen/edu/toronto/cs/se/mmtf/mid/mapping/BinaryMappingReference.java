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

import edu.toronto.cs.se.mmtf.mid.ModelReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference#getModel0 <em>Model0</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference#getModel1 <em>Model1</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getBinaryMappingReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isBinaryReference sourceModel targetModel'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot isBinaryReference='models->size() = 2' sourceModel='model0 = models->at(1)' targetModel='model1 = models->at(2)'"
 * @generated
 */
public interface BinaryMappingReference extends MappingReference {

	/**
	 * Returns the value of the '<em><b>Model0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model0</em>' reference.
	 * @see #setModel0(ModelReference)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getBinaryMappingReference_Model0()
	 * @model required="true"
	 * @generated
	 */
	ModelReference getModel0();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference#getModel0 <em>Model0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model0</em>' reference.
	 * @see #getModel0()
	 * @generated
	 */
	void setModel0(ModelReference value);

	/**
	 * Returns the value of the '<em><b>Model1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model1</em>' reference.
	 * @see #setModel1(ModelReference)
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getBinaryMappingReference_Model1()
	 * @model required="true"
	 * @generated
	 */
	ModelReference getModel1();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference#getModel1 <em>Model1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model1</em>' reference.
	 * @see #getModel1()
	 * @generated
	 */
	void setModel1(ModelReference value);
} // BinaryMappingReference
