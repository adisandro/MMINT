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
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.Editor#getMetamodelUri <em>Metamodel Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.Editor#getEditorId <em>Editor Id</em>}</li>
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
	 * Returns the value of the '<em><b>Metamodel Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Uri</em>' attribute.
	 * @see #setMetamodelUri(String)
	 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getEditor_MetamodelUri()
	 * @model required="true"
	 * @generated
	 */
	String getMetamodelUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.repository.Editor#getMetamodelUri <em>Metamodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel Uri</em>' attribute.
	 * @see #getMetamodelUri()
	 * @generated
	 */
	void setMetamodelUri(String value);

	/**
	 * Returns the value of the '<em><b>Editor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor Id</em>' attribute.
	 * @see #setEditorId(String)
	 * @see edu.toronto.cs.se.mmtf.repository.RepositoryPackage#getEditor_EditorId()
	 * @model required="true"
	 * @generated
	 */
	String getEditorId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.repository.Editor#getEditorId <em>Editor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor Id</em>' attribute.
	 * @see #getEditorId()
	 * @generated
	 */
	void setEditorId(String value);

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
