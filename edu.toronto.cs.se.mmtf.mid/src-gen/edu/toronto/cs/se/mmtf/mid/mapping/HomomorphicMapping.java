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
 * A representation of the model object '<em><b>Homomorphic Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getHomomorphicMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sameElementTypes'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot sameElementTypes='elements->forAll(e1 : ModelElementReference, e2 : ModelElementReference | e1.pointer.oclType() = e2.pointer.oclType())'"
 * @generated
 */
public interface HomomorphicMapping extends BinaryMapping {
} // HomomorphicMapping
