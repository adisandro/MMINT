/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mavo.MAVOModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getOrigin <em>Origin</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getModelElems <em>Model Elems</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#getConversionOperators <em>Conversion Operators</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.Model#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends ExtendibleElement, MAVOModel {
	/**
	 * Returns the value of the '<em><b>Origin</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.mmtf.mid.ModelOrigin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The origin.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Origin</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelOrigin
	 * @see #setOrigin(ModelOrigin)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_Origin()
	 * @model required="true"
	 * @generated
	 */
	ModelOrigin getOrigin();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.Model#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see edu.toronto.cs.se.mmtf.mid.ModelOrigin
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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_FileExtension()
	 * @model required="true"
	 * @generated
	 */
	String getFileExtension();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.Model#getFileExtension <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Extension</em>' attribute.
	 * @see #getFileExtension()
	 * @generated
	 */
	void setFileExtension(String value);

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.editor.Editor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of editors associated with this model (types: editor types; instances: editor instances).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_Editors()
	 * @model
	 * @generated
	 */
	EList<Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Model Elems</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of model elements (types: model element types; instances: model element instances).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Elems</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_ModelElems()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElement> getModelElems();

	/**
	 * Returns the value of the '<em><b>Conversion Operators</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The conversion operator types that use this model type as input (instances: always null).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conversion Operators</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_ConversionOperators()
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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getModel_Abstract()
	 * @model required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.Model#isAbstract <em>Abstract</em>}' attribute.
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
	 * @throws MMTFException
	 *             If this is a model instance, or if the uri of the new model
	 *             type is already registered in the Type MID. <!-- end-user-doc
	 *             -->
	 * @model required="true"
	 *        exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 *        newModelTypeNameRequired="true"
	 *        isMetamodelExtensionRequired="true"
	 * @generated
	 */
	Model createSubtype(String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Deletes this model type from the Type MID.
	 * 
	 * @throws MMTFException
	 *             If this is a model instance. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteType() throws MMTFException;

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
	 * @throws MMTFException
	 *             If this is a model instance, or if the uri of the new model
	 *             instance is already registered in the Instance MID.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelUriRequired="true" originRequired="true"
	 * @generated
	 */
	Model createInstance(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a model instance of
	 * this model type to an Instance MID, together with an editor for it.
	 * 
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param containerMultiModel
	 *            An Instance MID, null if the model isn't going to be added to
	 *            it.
	 * @return The created model.
	 * @throws MMTFException
	 *             If this is a model instance, or if the uri of the new model
	 *             instance is already registered in the Instance MID.
	 *             <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException" newModelUriRequired="true" originRequired="true"
	 * @generated
	 */
	Model createInstanceAndEditor(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Deletes this model instance from the Instance MID
	 * that contains it.
	 * 
	 * @throws MMTFException
	 *             If this is a model type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	void deleteInstance() throws MMTFException;

} // Model
