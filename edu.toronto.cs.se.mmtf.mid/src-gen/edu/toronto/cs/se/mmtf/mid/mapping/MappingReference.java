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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getModels <em>Models</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getMappingLinks <em>Mapping Links</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.MappingReference#getContainers <em>Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getMappingReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='modelContainers'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot modelContainers='models->size() = containers->size()'"
 * @generated
 */
public interface MappingReference extends ModelReference {
	/**
	 * Returns the value of the '<em><b>Models</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.ModelReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getMappingReference_Models()
	 * @model required="true"
	 * @generated
	 */
	EList<ModelReference> getModels();

	/**
	 * Returns the value of the '<em><b>Mapping Links</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.mapping.MappingLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Links</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getMappingReference_MappingLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingLink> getMappingLinks();

	/**
	 * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#getMappingReference_Containers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModelContainer> getContainers();

} // MappingReference
