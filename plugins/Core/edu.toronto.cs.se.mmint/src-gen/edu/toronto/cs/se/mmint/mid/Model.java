/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;

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
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getOrigin <em>Origin</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getModelElems <em>Model Elems</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.Model#getConversionOperators <em>Conversion Operators</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends GenericElement {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (MID) this.eContainer();'"
     * @generated
     */
    MID getMIDContainer();

    /**
     * <!-- begin-user-doc --> Creates and adds a subtype of this model type to the Type MID.
     *
     * @param newModelTypeName
     *            The name of the new model type.
     * @param isMetamodelExtension
     *            True if the new model type is extending the supertype's metamodel, false otherwise.
     * @return The created model type.
     * @throws MMINTException
     *             If this is not a model type, or if the uri of the new model type is already registered in the Type
     *             MID. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelTypeNameRequired="true" isMetamodelExtensionRequired="true"
     * @generated
     */
    Model createSubtype(String newModelTypeName, boolean isMetamodelExtension) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this model type from the Type MID.
     *
     * @throws MMINTException
     *             If this is not a model type. <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    void deleteType() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Gets the EMF package root of this model type.
     *
     * @throws MMINTException
     *             If this is not a model type, or if the metamodel file can't be accessed. <!-- end-user-doc -->
     * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    EPackage getEMFTypeRoot() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Opens the editor associated with this model type.
     *
     * @throws Exception
     *             If this is not a model type, or if the editor can't be opened.<!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception"
     * @generated
     */
    void openType() throws Exception;

    /**
     * <!-- begin-user-doc --> Creates and possibly adds an instance of this model type to an Instance MID. Possibly
     * creates the ECore model file in the process.
     * <p>
     * Can be invoked in 4 ways:
     * <ol>
     * <li>(null, str, null) model file not created, model not added to the MID;
     * <li>(obj, str, null) model root kept in memory ({@link #getEMFInstanceRoot()} works as expected), model not added
     * to the MID;
     * <li>(null, str, mid) model file not created, model added to the MID;
     * <li>(obj, str, mid) model file created, model added to the MID.
     * </ol>
     * </p>
     *
     * @param rootModelObj
     *            The root of the ECore model. Can be null if the ECore model file is going to be created separately.
     * @param newModelPath
     *            The file path of the ECore model (the model name is taken from the file name). When instanceMID is
     *            null, it is just a name for the model.
     * @param instanceMID
     *            An Instance MID. Can be null if the model is not going to be contained in one and the ECore model file
     *            not going to be created.
     * @return The created model.
     * @throws MMINTException
     *             If this is not a model type, or the path of the new model instance is already registered in the
     *             Instance MID.
     * @throws IOException
     *             If the ECore model file could not be created or overwritten. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException edu.toronto.cs.se.mmint.mid.IOException" newModelPathRequired="true"
     * @generated
     */
    Model createInstance(EObject rootModelObj, String newModelPath, MID instanceMID) throws MMINTException, IOException;

    /**
     * <!-- begin-user-doc --> Creates and adds an editor instance to this model instance.
     *
     * @param createEditorFile
     *            True if the editor file is going to be created, false if it exists already.
     * @throws MMINTException
     *             If this is not a model instance, or there are no editor types registered for this model instance's
     *             type. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    Editor createInstanceEditor(boolean createEditorFile) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and possibly adds an instance of this model type to an Instance MID, together
     * with an editor for it. Possibly creates the ECore model file in the process.
     * <p>
     * Can be invoked in 4 ways:
     * <ol>
     * <li>(null, str, null) model file not created, model not added to the MID, editor not created;
     * <li>(obj, str, null) model root kept in memory ({@link #getEMFInstanceRoot()} works as expected), model not added
     * to the MID, editor not created;
     * <li>(null, str, mid) model file not created, model added to the MID, editor created;
     * <li>(obj, str, mid) model file created, model added to the MID, editor created.
     * </ol>
     * </p>
     *
     * @param rootModelObj
     *            The root of the ECore model. Can be null if the ECore model file is going to be created separately.
     * @param newModelPath
     *            The file path of the ECore model (the model name is taken from the file name). When instanceMID is
     *            null, it is just a name for the model.
     * @param instanceMID
     *            An Instance MID. Can be null if the model is not going to be contained in one, the editor and the
     *            ECore model file not going to be created.
     * @return The created model.
     * @throws MMINTException
     *             If this is not a model type, the path of the new model instance is already registered in the Instance
     *             MID, or there are no editor types registered for this model type.
     * @throws IOException
     *             If the ECore model file could not be created or overwritten.
     * @see #createInstance(EObject, String, MID) <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException edu.toronto.cs.se.mmint.mid.IOException" newModelPathRequired="true"
     * @generated
     */
    Model createInstanceAndEditor(EObject rootModelObj, String newModelPath, MID instanceMID) throws MMINTException, IOException;

    /**
     * <!-- begin-user-doc --> Creates and possibly adds an instance of this model type to an Instance MID, importing an
     * already existing ECore model file.
     *
     * @param modelPath
     *            The file path of the ECore model (the model name is taken from the file name).
     * @param instanceMID
     *            An Instance MID. Can be null if the model is not going to be contained in one.
     * @return The imported model.
     * @throws MMINTException
     *             If this is not a model type, or the path of the imported model instance is already registered in the
     *             Instance MID. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" modelPathRequired="true"
     * @generated
     */
    Model importInstance(String modelPath, MID instanceMID) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Creates and possibly adds an instance of this model type to an Instance MID, together
     * with an editor for it, importing an already existing ECore model file.
     *
     * @param modelPath
     *            The file path of the ECore model (the model name is taken from the file name).
     * @param instanceMID
     *            An Instance MID. Can be null if the model is not going to be contained in one and the editor not going
     *            to be created.
     * @return The imported model.
     * @throws MMINTException
     *             If this is not a model type, or the path of the imported model instance is already registered in the
     *             Instance MID, or there are no editor types registered for this model type. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" modelPathRequired="true"
     * @generated
     */
    Model importInstanceAndEditor(String modelPath, MID instanceMID) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Copies an existing instance of this model type and possibly adds it to an Instance MID.
     * Possibly copies the ECore model file in the process.
     * <p>
     * Can be invoked in 2 ways:
     * <ol>
     * <li>(model, str, null) model root copied in memory ({@link #getEMFInstanceRoot()} works as expected), model not
     * added to the MID;
     * <li>(model, str, mid) model file copied, model added to the MID.
     * </ol>
     * </p>
     *
     * @param origModel
     *            The original model instance to be copied.
     * @param newModelName
     *            The name of the new model.
     * @param instanceMID
     *            An Instance MID. Can be null if the model is not going to be contained in one and the ECore model file
     *            not going to be copied.
     * @return The created model.
     * @throws MMINTException
     *             If this is not a model type, or the path of the new model instance is already registered in the
     *             Instance MID.
     * @throws IOException
     *             If the ECore model file could not be copied. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException edu.toronto.cs.se.mmint.mid.IOException" origModelRequired="true" newModelNameRequired="true" instanceMIDRequired="true"
     * @generated
     */
    Model copyInstance(Model origModel, String newModelName, MID instanceMID) throws MMINTException, IOException;

    /**
     * <!-- begin-user-doc --> Copies an existing instance of this model type and possibly adds it to an Instance MID,
     * together with an editor for it. Possibly copies the ECore model file and the GMF diagram files in the process.
     * <p>
     * Can be invoked in 3 ways:
     * <ol>
     * <li>(model, str, true/false, null) model root copied in memory ({@link #getEMFInstanceRoot()} works as expected),
     * diagram files not copied, model not added to the MID;
     * <li>(model, str, false, mid) model file copied, diagram files not copied, model added to the MID.
     * <li>(model, str, true, mid) model file copied, diagram files copied, model added to the MID.
     * </ol>
     * </p>
     *
     * @param origModel
     *            The original model instance to be copied.
     * @param newModelName
     *            The name of the new model.
     * @param copyDiagram
     *            True if the GMF diagrams for the original model should be copied, false otherwise.
     * @param instanceMID
     *            An Instance MID. Can be null if the model is not going to be contained in one, the ECore model file
     *            and the GMF diagram files not going to be copied.
     * @return The created model.
     * @throws MMINTException
     *             If this is not a model type, the path of the new model instance is already registered in the Instance
     *             MID, or there are no editor types registered for this model type.
     * @throws IOException
     *             If the ECore model file or the GMF diagram files could not be copied. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException edu.toronto.cs.se.mmint.mid.IOException" origModelRequired="true" newModelNameRequired="true" copyDiagramRequired="true" instanceMIDRequired="true"
     * @generated
     */
    Model copyInstanceAndEditor(Model origModel, String newModelName, boolean copyDiagram, MID instanceMID) throws MMINTException, IOException;

    /**
     * <!-- begin-user-doc --> Deletes this model instance from the Instance MID that contains it.
     *
     * @throws MMINTException
     *             If this is not a model instance. <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    void deleteInstance() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this model instance from the Instance MID that contains it and from the file
     * system.
     *
     * @throws MMINTException
     *             If this is not a model instance. <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    void deleteInstanceAndFile() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Gets the EMF object root of this model.
     *
     * @throws MMINTException
     *             If this is not a model instance, or if the model file can't be accessed. <!-- end-user-doc -->
     * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    EObject getEMFInstanceRoot() throws MMINTException;

    /**
     * <!-- begin-user-doc --> Opens the editor associated with this model instance.
     *
     * @throws Exception
     *             If this is not a model instance, or if the editor can't be opened.<!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.operator.Exception"
     * @generated
     */
    void openInstance() throws Exception;

    /**
     * <!-- begin-user-doc --> Creates and possibly adds a model instance of this model type to a Workflow MID.
     *
     * @param newModelId
     *            The id of the new model.
     * @param workflowMID
     *            A Workflow MID, null if the model isn't going to be contained in one.
     * @return The created model.
     * @throws MMINTException
     *             If this is not a model type, or if the id of the new model instance is already registered in the
     *             Workflow MID. <!-- end-user-doc -->
     * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelIdRequired="true"
     * @generated
     */
    Model createWorkflowInstance(String newModelId, MID workflowMID) throws MMINTException;

    /**
     * <!-- begin-user-doc --> Deletes this model instance from the Workflow MID that contains it.
     *
     * @throws MMINTException
     *             If this is not a model instance in a workflow. <!-- end-user-doc -->
     * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
     * @generated
     */
    void deleteWorkflowInstance() throws MMINTException;

} // Model
