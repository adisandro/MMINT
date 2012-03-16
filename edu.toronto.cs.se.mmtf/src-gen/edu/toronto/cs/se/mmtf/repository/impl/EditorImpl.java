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
package edu.toronto.cs.se.mmtf.repository.impl;

import edu.toronto.cs.se.mmtf.repository.Editor;
import edu.toronto.cs.se.mmtf.repository.RepositoryPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.impl.EditorImpl#getMetamodelUri <em>Metamodel Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.impl.EditorImpl#getEditorId <em>Editor Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.impl.EditorImpl#getWizardId <em>Wizard Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.repository.impl.EditorImpl#getFileExtensions <em>File Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EditorImpl extends ExtensionPointImpl implements Editor {
	/**
	 * The default value of the '{@link #getMetamodelUri() <em>Metamodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelUri()
	 * @generated
	 * @ordered
	 */
	protected static final String METAMODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetamodelUri() <em>Metamodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelUri()
	 * @generated
	 * @ordered
	 */
	protected String metamodelUri = METAMODEL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getEditorId() <em>Editor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorId()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditorId() <em>Editor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorId()
	 * @generated
	 * @ordered
	 */
	protected String editorId = EDITOR_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getWizardId() <em>Wizard Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardId()
	 * @generated
	 * @ordered
	 */
	protected static final String WIZARD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWizardId() <em>Wizard Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardId()
	 * @generated
	 * @ordered
	 */
	protected String wizardId = WIZARD_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFileExtensions() <em>File Extensions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> fileExtensions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.EDITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetamodelUri() {
		return metamodelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodelUri(String newMetamodelUri) {
		String oldMetamodelUri = metamodelUri;
		metamodelUri = newMetamodelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.EDITOR__METAMODEL_URI, oldMetamodelUri, metamodelUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditorId() {
		return editorId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorId(String newEditorId) {
		String oldEditorId = editorId;
		editorId = newEditorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.EDITOR__EDITOR_ID, oldEditorId, editorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWizardId() {
		return wizardId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWizardId(String newWizardId) {
		String oldWizardId = wizardId;
		wizardId = newWizardId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.EDITOR__WIZARD_ID, oldWizardId, wizardId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFileExtensions() {
		if (fileExtensions == null) {
			fileExtensions = new EDataTypeUniqueEList<String>(String.class, this, RepositoryPackage.EDITOR__FILE_EXTENSIONS);
		}
		return fileExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.EDITOR__METAMODEL_URI:
				return getMetamodelUri();
			case RepositoryPackage.EDITOR__EDITOR_ID:
				return getEditorId();
			case RepositoryPackage.EDITOR__WIZARD_ID:
				return getWizardId();
			case RepositoryPackage.EDITOR__FILE_EXTENSIONS:
				return getFileExtensions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.EDITOR__METAMODEL_URI:
				setMetamodelUri((String)newValue);
				return;
			case RepositoryPackage.EDITOR__EDITOR_ID:
				setEditorId((String)newValue);
				return;
			case RepositoryPackage.EDITOR__WIZARD_ID:
				setWizardId((String)newValue);
				return;
			case RepositoryPackage.EDITOR__FILE_EXTENSIONS:
				getFileExtensions().clear();
				getFileExtensions().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RepositoryPackage.EDITOR__METAMODEL_URI:
				setMetamodelUri(METAMODEL_URI_EDEFAULT);
				return;
			case RepositoryPackage.EDITOR__EDITOR_ID:
				setEditorId(EDITOR_ID_EDEFAULT);
				return;
			case RepositoryPackage.EDITOR__WIZARD_ID:
				setWizardId(WIZARD_ID_EDEFAULT);
				return;
			case RepositoryPackage.EDITOR__FILE_EXTENSIONS:
				getFileExtensions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RepositoryPackage.EDITOR__METAMODEL_URI:
				return METAMODEL_URI_EDEFAULT == null ? metamodelUri != null : !METAMODEL_URI_EDEFAULT.equals(metamodelUri);
			case RepositoryPackage.EDITOR__EDITOR_ID:
				return EDITOR_ID_EDEFAULT == null ? editorId != null : !EDITOR_ID_EDEFAULT.equals(editorId);
			case RepositoryPackage.EDITOR__WIZARD_ID:
				return WIZARD_ID_EDEFAULT == null ? wizardId != null : !WIZARD_ID_EDEFAULT.equals(wizardId);
			case RepositoryPackage.EDITOR__FILE_EXTENSIONS:
				return fileExtensions != null && !fileExtensions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (metamodelUri: ");
		result.append(metamodelUri);
		result.append(", editorId: ");
		result.append(editorId);
		result.append(", wizardId: ");
		result.append(wizardId);
		result.append(", fileExtensions: ");
		result.append(fileExtensions);
		result.append(')');
		return result.toString();
	}

} //EditorImpl
