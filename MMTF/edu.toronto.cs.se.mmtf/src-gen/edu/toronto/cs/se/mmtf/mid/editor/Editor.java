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
package edu.toronto.cs.se.mmtf.mid.editor;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An editor type or an editor instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getModelUri <em>Model Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getWizardId <em>Wizard Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getFileExtensions <em>File Extensions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getWizardDialogClass <em>Wizard Dialog Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.editor.EditorPackage#getEditor()
 * @model
 * @generated
 */
public interface Editor extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Model Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uri of the model type or model instance to be edited by this editor type or editor instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Uri</em>' attribute.
	 * @see #setModelUri(String)
	 * @see edu.toronto.cs.se.mmtf.mid.editor.EditorPackage#getEditor_ModelUri()
	 * @model required="true"
	 * @generated
	 */
	String getModelUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getModelUri <em>Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Uri</em>' attribute.
	 * @see #getModelUri()
	 * @generated
	 */
	void setModelUri(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The editor id used to register this editor in Eclipse.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see edu.toronto.cs.se.mmtf.mid.editor.EditorPackage#getEditor_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Wizard Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The wizard id used to register this editor's wizard in Eclipse.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wizard Id</em>' attribute.
	 * @see #setWizardId(String)
	 * @see edu.toronto.cs.se.mmtf.mid.editor.EditorPackage#getEditor_WizardId()
	 * @model required="true"
	 * @generated
	 */
	String getWizardId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getWizardId <em>Wizard Id</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of file extensions registered for this editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>File Extensions</em>' attribute list.
	 * @see edu.toronto.cs.se.mmtf.mid.editor.EditorPackage#getEditor_FileExtensions()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getFileExtensions();

	/**
	 * Returns the value of the '<em><b>Wizard Dialog Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The wizard dialog used to create a model instance through this editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Wizard Dialog Class</em>' attribute.
	 * @see #setWizardDialogClass(String)
	 * @see edu.toronto.cs.se.mmtf.mid.editor.EditorPackage#getEditor_WizardDialogClass()
	 * @model
	 * @generated
	 */
	String getWizardDialogClass();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.editor.Editor#getWizardDialogClass <em>Wizard Dialog Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wizard Dialog Class</em>' attribute.
	 * @see #getWizardDialogClass()
	 * @generated
	 */
	void setWizardDialogClass(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the editor type of this model instance.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (Editor) metatype;'"
	 * @generated
	 */
	Editor getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the editor supertype of this editor type.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (Editor) supertype;'"
	 * @generated
	 */
	Editor getSupertype();

} // Editor
