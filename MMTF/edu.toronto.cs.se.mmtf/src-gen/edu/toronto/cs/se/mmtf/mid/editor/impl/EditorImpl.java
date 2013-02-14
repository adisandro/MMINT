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
package edu.toronto.cs.se.mmtf.mid.editor.impl;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;

import edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl;

import java.lang.reflect.InvocationTargetException;
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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getModelUri <em>Model Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getWizardId <em>Wizard Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getFileExtensions <em>File Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EditorImpl extends ExtendibleElementImpl implements Editor {
	/**
	 * The default value of the '{@link #getModelUri() <em>Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelUri()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelUri() <em>Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelUri()
	 * @generated
	 * @ordered
	 */
	protected String modelUri = MODEL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
		return EditorPackage.Literals.EDITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelUri() {
		return modelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelUri(String newModelUri) {
		String oldModelUri = modelUri;
		modelUri = newModelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__MODEL_URI, oldModelUri, modelUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__WIZARD_ID, oldWizardId, wizardId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFileExtensions() {
		if (fileExtensions == null) {
			fileExtensions = new EDataTypeUniqueEList<String>(String.class, this, EditorPackage.EDITOR__FILE_EXTENSIONS);
		}
		return fileExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (Editor) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (Editor) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EditorPackage.EDITOR__MODEL_URI:
				return getModelUri();
			case EditorPackage.EDITOR__ID:
				return getId();
			case EditorPackage.EDITOR__WIZARD_ID:
				return getWizardId();
			case EditorPackage.EDITOR__FILE_EXTENSIONS:
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
			case EditorPackage.EDITOR__MODEL_URI:
				setModelUri((String)newValue);
				return;
			case EditorPackage.EDITOR__ID:
				setId((String)newValue);
				return;
			case EditorPackage.EDITOR__WIZARD_ID:
				setWizardId((String)newValue);
				return;
			case EditorPackage.EDITOR__FILE_EXTENSIONS:
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
			case EditorPackage.EDITOR__MODEL_URI:
				setModelUri(MODEL_URI_EDEFAULT);
				return;
			case EditorPackage.EDITOR__ID:
				setId(ID_EDEFAULT);
				return;
			case EditorPackage.EDITOR__WIZARD_ID:
				setWizardId(WIZARD_ID_EDEFAULT);
				return;
			case EditorPackage.EDITOR__FILE_EXTENSIONS:
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
			case EditorPackage.EDITOR__MODEL_URI:
				return MODEL_URI_EDEFAULT == null ? modelUri != null : !MODEL_URI_EDEFAULT.equals(modelUri);
			case EditorPackage.EDITOR__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case EditorPackage.EDITOR__WIZARD_ID:
				return WIZARD_ID_EDEFAULT == null ? wizardId != null : !WIZARD_ID_EDEFAULT.equals(wizardId);
			case EditorPackage.EDITOR__FILE_EXTENSIONS:
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EditorPackage.EDITOR___GET_METATYPE:
				return getMetatype();
			case EditorPackage.EDITOR___GET_SUPERTYPE:
				return getSupertype();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (modelUri: ");
		result.append(modelUri);
		result.append(", id: ");
		result.append(id);
		result.append(", wizardId: ");
		result.append(wizardId);
		result.append(", fileExtensions: ");
		result.append(fileExtensions);
		result.append(')');
		return result.toString();
	}

} //EditorImpl
