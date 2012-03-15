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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.Editor#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.Editor#getViewId <em>View Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.Editor#getWizardId <em>Wizard Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.Editor#getFileExtensions <em>File Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getEditor()
 * @model
 * @generated
 */
public interface Editor extends ExtensionPoint {
	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(Metamodel)
	 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getEditor_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	Metamodel getMetamodel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.repository.Editor#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(Metamodel value);

	/**
	 * Returns the value of the '<em><b>View Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Id</em>' attribute.
	 * @see #setViewId(String)
	 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getEditor_ViewId()
	 * @model required="true"
	 * @generated
	 */
	String getViewId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.repository.Editor#getViewId <em>View Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Id</em>' attribute.
	 * @see #getViewId()
	 * @generated
	 */
	void setViewId(String value);

	/**
	 * Returns the value of the '<em><b>Wizard Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wizard Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wizard Id</em>' attribute.
	 * @see #setWizardId(String)
	 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getEditor_WizardId()
	 * @model required="true"
	 * @generated
	 */
	String getWizardId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.repository.Editor#getWizardId <em>Wizard Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wizard Id</em>' attribute.
	 * @see #getWizardId()
	 * @generated
	 */
	void setWizardId(String value);

	/**
	 * Returns the value of the '<em><b>File Extensions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Extensions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Extensions</em>' attribute list.
	 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getEditor_FileExtensions()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getFileExtensions();

} // Editor
