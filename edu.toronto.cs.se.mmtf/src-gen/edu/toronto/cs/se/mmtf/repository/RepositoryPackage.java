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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmtf.repository.RepositoryFactory
 * @model kind="package"
 * @generated
 */
public interface RepositoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "repository";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///edu/toronto/cs/se/mmtf/model/repository.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "repository";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RepositoryPackage eINSTANCE = edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.repository.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryImpl
	 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Metamodels</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__METAMODELS = 0;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__EDITORS = 1;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.repository.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.repository.impl.ExtensionPointImpl
	 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getExtensionPoint()
	 * @generated
	 */
	int EXTENSION_POINT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_POINT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_POINT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Extension Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_POINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.repository.impl.MetamodelImpl <em>Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.repository.impl.MetamodelImpl
	 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getMetamodel()
	 * @generated
	 */
	int METAMODEL = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__ID = EXTENSION_POINT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__NAME = EXTENSION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__URI = EXTENSION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__FILE_EXTENSION = EXTENSION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__EDITORS = EXTENSION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_FEATURE_COUNT = EXTENSION_POINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.repository.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.repository.impl.EditorImpl
	 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__ID = EXTENSION_POINT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__NAME = EXTENSION_POINT__NAME;

	/**
	 * The feature id for the '<em><b>Metamodel Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__METAMODEL_URI = EXTENSION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Editor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__EDITOR_ID = EXTENSION_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Wizard Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__WIZARD_ID = EXTENSION_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File Extensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__FILE_EXTENSIONS = EXTENSION_POINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = EXTENSION_POINT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.repository.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.repository.impl.DiagramImpl
	 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__ID = EDITOR__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__NAME = EDITOR__NAME;

	/**
	 * The feature id for the '<em><b>Metamodel Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__METAMODEL_URI = EDITOR__METAMODEL_URI;

	/**
	 * The feature id for the '<em><b>Editor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__EDITOR_ID = EDITOR__EDITOR_ID;

	/**
	 * The feature id for the '<em><b>Wizard Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__WIZARD_ID = EDITOR__WIZARD_ID;

	/**
	 * The feature id for the '<em><b>File Extensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__FILE_EXTENSIONS = EDITOR__FILE_EXTENSIONS;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = EDITOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.repository.impl.EStringToMetamodelMapImpl <em>EString To Metamodel Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.repository.impl.EStringToMetamodelMapImpl
	 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getEStringToMetamodelMap()
	 * @generated
	 */
	int ESTRING_TO_METAMODEL_MAP = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_METAMODEL_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_METAMODEL_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To Metamodel Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_METAMODEL_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.repository.impl.EStringToEditorMapImpl <em>EString To Editor Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.repository.impl.EStringToEditorMapImpl
	 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getEStringToEditorMap()
	 * @generated
	 */
	int ESTRING_TO_EDITOR_MAP = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EDITOR_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EDITOR_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To Editor Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EDITOR_MAP_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.repository.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmtf.repository.Repository#getMetamodels <em>Metamodels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Metamodels</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Repository#getMetamodels()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Metamodels();

	/**
	 * Returns the meta object for the map '{@link edu.toronto.cs.se.mmtf.repository.Repository#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Editors</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Repository#getEditors()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Editors();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.repository.ExtensionPoint <em>Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Point</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.ExtensionPoint
	 * @generated
	 */
	EClass getExtensionPoint();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.repository.ExtensionPoint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.ExtensionPoint#getId()
	 * @see #getExtensionPoint()
	 * @generated
	 */
	EAttribute getExtensionPoint_Id();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.repository.ExtensionPoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.ExtensionPoint#getName()
	 * @see #getExtensionPoint()
	 * @generated
	 */
	EAttribute getExtensionPoint_Name();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.repository.Metamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Metamodel
	 * @generated
	 */
	EClass getMetamodel();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.repository.Metamodel#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Metamodel#getUri()
	 * @see #getMetamodel()
	 * @generated
	 */
	EAttribute getMetamodel_Uri();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.repository.Metamodel#getFileExtension <em>File Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Extension</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Metamodel#getFileExtension()
	 * @see #getMetamodel()
	 * @generated
	 */
	EAttribute getMetamodel_FileExtension();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmtf.repository.Metamodel#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Metamodel#getEditors()
	 * @see #getMetamodel()
	 * @generated
	 */
	EReference getMetamodel_Editors();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.repository.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.repository.Editor#getMetamodelUri <em>Metamodel Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel Uri</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Editor#getMetamodelUri()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_MetamodelUri();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.repository.Editor#getEditorId <em>Editor Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editor Id</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Editor#getEditorId()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_EditorId();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.repository.Editor#getWizardId <em>Wizard Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wizard Id</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Editor#getWizardId()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_WizardId();

	/**
	 * Returns the meta object for the attribute list '{@link edu.toronto.cs.se.mmtf.repository.Editor#getFileExtensions <em>File Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>File Extensions</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Editor#getFileExtensions()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_FileExtensions();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.repository.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see edu.toronto.cs.se.mmtf.repository.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Metamodel Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Metamodel Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="edu.toronto.cs.se.mmtf.repository.Metamodel" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToMetamodelMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToMetamodelMap()
	 * @generated
	 */
	EAttribute getEStringToMetamodelMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToMetamodelMap()
	 * @generated
	 */
	EReference getEStringToMetamodelMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Editor Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Editor Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="edu.toronto.cs.se.mmtf.repository.Editor" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToEditorMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEditorMap()
	 * @generated
	 */
	EAttribute getEStringToEditorMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEditorMap()
	 * @generated
	 */
	EReference getEStringToEditorMap_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RepositoryFactory getRepositoryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.repository.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryImpl
		 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Metamodels</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__METAMODELS = eINSTANCE.getRepository_Metamodels();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__EDITORS = eINSTANCE.getRepository_Editors();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.repository.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.repository.impl.ExtensionPointImpl
		 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getExtensionPoint()
		 * @generated
		 */
		EClass EXTENSION_POINT = eINSTANCE.getExtensionPoint();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_POINT__ID = eINSTANCE.getExtensionPoint_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_POINT__NAME = eINSTANCE.getExtensionPoint_Name();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.repository.impl.MetamodelImpl <em>Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.repository.impl.MetamodelImpl
		 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getMetamodel()
		 * @generated
		 */
		EClass METAMODEL = eINSTANCE.getMetamodel();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL__URI = eINSTANCE.getMetamodel_Uri();

		/**
		 * The meta object literal for the '<em><b>File Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL__FILE_EXTENSION = eINSTANCE.getMetamodel_FileExtension();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METAMODEL__EDITORS = eINSTANCE.getMetamodel_Editors();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.repository.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.repository.impl.EditorImpl
		 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '<em><b>Metamodel Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__METAMODEL_URI = eINSTANCE.getEditor_MetamodelUri();

		/**
		 * The meta object literal for the '<em><b>Editor Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__EDITOR_ID = eINSTANCE.getEditor_EditorId();

		/**
		 * The meta object literal for the '<em><b>Wizard Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__WIZARD_ID = eINSTANCE.getEditor_WizardId();

		/**
		 * The meta object literal for the '<em><b>File Extensions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__FILE_EXTENSIONS = eINSTANCE.getEditor_FileExtensions();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.repository.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.repository.impl.DiagramImpl
		 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.repository.impl.EStringToMetamodelMapImpl <em>EString To Metamodel Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.repository.impl.EStringToMetamodelMapImpl
		 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getEStringToMetamodelMap()
		 * @generated
		 */
		EClass ESTRING_TO_METAMODEL_MAP = eINSTANCE.getEStringToMetamodelMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_METAMODEL_MAP__KEY = eINSTANCE.getEStringToMetamodelMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRING_TO_METAMODEL_MAP__VALUE = eINSTANCE.getEStringToMetamodelMap_Value();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.repository.impl.EStringToEditorMapImpl <em>EString To Editor Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.repository.impl.EStringToEditorMapImpl
		 * @see edu.toronto.cs.se.mmtf.repository.impl.RepositoryPackageImpl#getEStringToEditorMap()
		 * @generated
		 */
		EClass ESTRING_TO_EDITOR_MAP = eINSTANCE.getEStringToEditorMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_EDITOR_MAP__KEY = eINSTANCE.getEStringToEditorMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRING_TO_EDITOR_MAP__VALUE = eINSTANCE.getEStringToEditorMap_Value();

	}

} //RepositoryPackage
