/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid;

import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model type or a model instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getOrigin <em>Origin</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getModelElems <em>Model Elems</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getConversionOperators <em>Conversion Operators</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends ExtendibleElement, MAVOModel {
	/**
	 * Returns the value of the '<em><b>Origin</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmint.mid.ModelOrigin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The origin.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Origin</em>' attribute.
	 * @see edu.toronto.cs.se.mmint.mid.ModelOrigin
	 * @see #setOrigin(ModelOrigin)
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModel_Origin()
	 * @model required="true"
	 * @generated
	 */
	ModelOrigin getOrigin();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.Model#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see edu.toronto.cs.se.mmint.mid.ModelOrigin
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(ModelOrigin value);

	/**
	 * Returns the value of the '<em><b>File Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The file extension registered for the metamodel.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>File Extension</em>' attribute.
	 * @see #setFileExtension(String)
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModel_FileExtension()
	 * @model required="true"
	 * @generated
	 */
	String getFileExtension();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.Model#getFileExtension <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Extension</em>' attribute.
	 * @see #getFileExtension()
	 * @generated
	 */
	void setFileExtension(String value);

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.editor.Editor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of editors associated with this model (types: editor types; instances: editor instances).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModel_Editors()
	 * @model
	 * @generated
	 */
	EList<Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Model Elems</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of model elements (types: model element types; instances: model element instances).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elems</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModel_ModelElems()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElement> getModelElems();

	/**
	 * Returns the value of the '<em><b>Conversion Operators</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.operator.ConversionOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The conversion operator types that use this model type as input (instances: always null).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conversion Operators</em>' reference list.
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModel_ConversionOperators()
	 * @model
	 * @generated
	 */
	EList<ConversionOperator> getConversionOperators();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if the model type can't be instanciated, false otherwise (instances: always false).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModel_Abstract()
	 * @model required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.Model#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model type of this model instance.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (Model) metatype;'"
	 * @generated
	 */
	Model getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model supertype of this model type.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (Model) supertype;'"
	 * @generated
	 */
	Model getSupertype();

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this model type to
	 * the Type MID.
	 * 
	 * @param newModelTypeName
	 *            The name of the new model type.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model type, null if no constraint is associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model type, null if no constraint is associated.
	 * @param isMetamodelExtension
	 *            True if the new model type is extending the supertype's
	 *            metamodel, false otherwise.
	 * @return The created model type.
	 * @throws MMINTException
	 *             If this is a model instance, or if the uri of the new model
	 *             type is already registered in the Type MID. <!-- end-user-doc
	 *             -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 *        newModelTypeNameRequired="true"
	 *        isMetamodelExtensionRequired="true"
	 * @generated
	 */
	Model createSubtype(String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes this model type from the Type MID.
	 * 
	 * @throws MMINTException
	 *             If this is a model instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteType() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the EMF package root of this model type.
	 * 
	 * @throws MMINTException
	 *             If this is a model instance, or if the metamodel file can't
	 *             be accessed. <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	EPackage getEMFTypeRoot() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a model instance of
	 * this model type to an Instance MID.
	 * 
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param containerMultiModel
	 *            An Instance MID, null if the model isn't going to be added to
	 *            it.
	 * @return The created model.
	 * @throws MMINTException
	 *             If this is a model instance, or if the uri of the new model
	 *             instance is already registered in the Instance MID.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelUriRequired="true" originRequired="true"
	 * @generated
	 */
	Model createInstance(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds an editor instance to this model
	 * instance.
	 * 
	 * @throws MMINTException
	 *             If this is a model type, or if there are no editor types
	 *             registered for this model instance's type.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	Editor createInstanceEditor() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a model instance of this model
	 * type to an Instance MID, together with an editor for it.
	 * 
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param containerMultiModel
	 *            An Instance MID.
	 * @return The created model.
	 * @throws MMINTException
	 *             If this is a model instance, if the uri of the new model
	 *             instance is already registered in the Instance MID, or if
	 *             there are no editor types registered for this model type.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelUriRequired="true" originRequired="true" containerMultiModelRequired="true"
	 * @generated
	 */
	Model createInstanceAndEditor(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a model instance of
	 * this model type to an Instance MID, initializing its MAVO inc flag.
	 * 
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param containerMultiModel
	 *            An Instance MID, null if the model isn't going to be added to
	 *            it.
	 * @return The created model.
	 * @throws MMINTException
	 *             If this is a model instance, or if the uri of the new model
	 *             instance is already registered in the Instance MID.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelUriRequired="true" originRequired="true"
	 * @generated
	 */
	Model createMAVOInstance(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a model instance of this model
	 * type to an Instance MID, together with an editor for it, initializing its
	 * MAVO inc flag.
	 * 
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param containerMultiModel
	 *            An Instance MID.
	 * @return The created model.
	 * @throws MMINTException
	 *             If this is a model instance, if the uri of the new model
	 *             instance is already registered in the Instance MID, or if
	 *             there are no editor types registered for this model type.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelUriRequired="true" originRequired="true" containerMultiModelRequired="true"
	 * @generated
	 */
	Model createMAVOInstanceAndEditor(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a model instance of this model
	 * type to an Instance MID, together with an editor for it, copying its
	 * structure from another model instance (including its MAVO inc flag) and
	 * possibly all diagrams for it.
	 * 
	 * @param origModel
	 *            The original model instance to be copied into the new one.
	 * @param newModelName
	 *            The name of the new model.
	 * @param copyDiagram
	 *            True if the diagrams for the original model should be copied,
	 *            false otherwise.
	 * @param containerMultiModel
	 *            An Instance MID.
	 * @return The created model.
	 * @throws MMINTException
	 *             If this is a model instance, if the model file can't be
	 *             copied, if the uri of the new model instance is already
	 *             registered in the Instance MID, or if there are no editor
	 *             types registered for this model type. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" origModelRequired="true" newModelNameRequired="true" copyDiagramRequired="true" containerMultiModelRequired="true"
	 * @generated
	 */
	Model copyMAVOInstanceAndEditor(Model origModel, String newModelName, boolean copyDiagram, MultiModel containerMultiModel) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes this model instance from the Instance MID
	 * that contains it.
	 * 
	 * @throws MMINTException
	 *             If this is a model type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteInstance() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the EMF object root of this model.
	 * 
	 * @throws MMINTException
	 *             If this is a model type, or if the model file can't be
	 *             accessed. <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	EObject getEMFInstanceRoot() throws MMINTException;

} // Model
