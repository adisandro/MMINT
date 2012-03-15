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
package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.Repository#getMetamodels <em>Metamodels</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.Repository#getEditors <em>Editors</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends EObject {
	/**
	 * Returns the value of the '<em><b>Metamodels</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.repository.Metamodel},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodels</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodels</em>' map.
	 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getRepository_Metamodels()
	 * @model mapType="edu.toronto.cs.se.mmtf.repository.EStringToMetamodelMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.repository.Metamodel>"
	 * @generated
	 */
	EMap<String, Metamodel> getMetamodels();

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link edu.toronto.cs.se.mmtf.repository.Editor},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' map.
	 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getRepository_Editors()
	 * @model mapType="edu.toronto.cs.se.mmtf.repository.EStringToEditorMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmtf.repository.Editor>"
	 * @generated
	 */
	EMap<String, Editor> getEditors();

} // Repository
