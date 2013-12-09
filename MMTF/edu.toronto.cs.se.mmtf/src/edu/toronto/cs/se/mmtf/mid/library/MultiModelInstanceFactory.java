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
package edu.toronto.cs.se.mmtf.mid.library;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.presentation.DynamicModelWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Diagram;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.ui.EditorCreationWizardDialog;
import edu.toronto.cs.se.mmtf.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

/**
 * The factory to create/modify/remove instances.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelInstanceFactory {

	/** The empty uri. */
	private final static String EMPTY_URI = "";
	/** The empty name. */
	private final static String EMPTY_NAME = "";
	/** The empty file extension for a model. */
	private final static String EMPTY_MODEL_FILE_EXTENSION = "";

	/**
	 * Adds an instance to an Instance MID.
	 * 
	 * @param newInstance
	 *            The new instance to be added.
	 * @param type
	 *            The type of the new instance.
	 * @param newInstanceUri
	 *            The uri of the new instance.
	 * @param newInstanceName
	 *            The name of the new instance.
	 * @param multiModel
	 *            An Instance MID.
	 * @throws MMTFException
	 *             If the uri of the new instance is already registered in the
	 *             Instance MID.
	 */
	private static void addInstance(ExtendibleElement newInstance, ExtendibleElement type, String newInstanceUri, String newInstanceName, MultiModel multiModel) throws MMTFException {

		if (multiModel.getExtendibleTable().containsKey(newInstanceUri)) {
			throw new MMTFException("Instance with uri " + newInstanceUri + " is already registered");
		}
		multiModel.getExtendibleTable().put(newInstanceUri, newInstance);

		addBasicInstance(newInstance, type, newInstanceUri, newInstanceName);
	}

	/**
	 * Adds an instance to an Instance MID without registering its uri.
	 * 
	 * @param newInstance
	 *            The new instance to be added.
	 * @param type
	 *            The type of the new instance.
	 * @param newInstanceUri
	 *            The uri of the new instance.
	 * @param newInstanceName
	 *            The name of the new instance.
	 */
	public static void addBasicInstance(ExtendibleElement newInstance, ExtendibleElement type, String newInstanceUri, String newInstanceName) {

		if (newInstanceUri == null) {
			newInstanceUri = EMPTY_URI;
		}
		newInstance.setUri(newInstanceUri);
		if (newInstanceName == null) {
			newInstanceName = EMPTY_NAME;
		}
		newInstance.setName(newInstanceName);
		newInstance.setLevel(MidLevel.INSTANCES);
		newInstance.setDynamic(true);
		newInstance.setSupertype(null);
		if (type == null) { // use type introspection
			List<ExtendibleElement> elementTypes = MultiModelTypeIntrospection.getRuntimeTypes(newInstance);
			type = elementTypes.get(elementTypes.size()-1);
			//TODO MMTF: ask the user?
		}
		newInstance.setMetatypeUri(type.getUri());
	}

	/**
	 * Adds the target to a new instance endpoint.
	 * 
	 * @param newInstanceEndpoint
	 *            The new instance endpoint.
	 * @param newInstance
	 *            The new instance that is the target of the new instance
	 *            endpoint.
	 */
	public static void addInstanceEndpoint(ExtendibleElementEndpoint newInstanceEndpoint, ExtendibleElement newInstance) {

		newInstanceEndpoint.setTarget(newInstance);
		newInstanceEndpoint.setLowerBound(1);
		newInstanceEndpoint.setUpperBound(1);
	}

	/**
	 * Adds additional info for a reference to an instance.
	 * 
	 * @param newInstanceRef
	 *            The new reference being added.
	 * @param newInstance
	 *            The new instance for which the reference was created.
	 * @param isContainer
	 *            True if the new reference is also the actual container of the
	 *            new instance and not just a pointer to it, false otherwise.
	 */
	private static void addInstanceReference(ExtendibleElementReference newInstanceRef, ExtendibleElement newInstance, boolean isContainer) {

		if (isContainer) {
			newInstanceRef.setContainedObject(newInstance);
		}
		else {
			newInstanceRef.setReferencedObject(newInstance);
		}
		newInstanceRef.setModifiable(true);
		newInstanceRef.setSupertypeRef(null);
	}

	/**
	 * Adds a model to an Instance MID or just adds additional info to the
	 * model.
	 * 
	 * @param newModel
	 *            The new model.
	 * @param modelType
	 *            The type of the new model.
	 * @param newModelUri
	 *            The uri of the new model, null if the new model is not in a
	 *            separate file; e.g. a model and a standalone model
	 *            relationship are in their own files, a plain model
	 *            relationship is not.
	 * @param origin
	 *            The origin of the new model.
	 * @param multiModel
	 *            An Instance MID, null if the model isn't going to be added to
	 *            it.
	 * @throws MMTFException
	 *             If the uri of the new model is already registered in the
	 *             Instance MID.
	 */
	public static void addModel(Model newModel, Model modelType, String newModelUri, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		boolean externalElement = newModelUri != null;
		boolean updateMid = multiModel != null;
		boolean basicElement = !updateMid || !externalElement;

		String newModelName = null;
		String fileExtension = EMPTY_MODEL_FILE_EXTENSION;
		if (externalElement) {
			newModelName = MultiModelUtils.getFileNameFromUri(newModelUri);
			fileExtension = MultiModelUtils.getFileExtensionFromUri(newModelUri);
		}
		if (basicElement) {
			addBasicInstance(newModel, modelType, newModelUri, newModelName);
		}
		else {
			addInstance(newModel, modelType, newModelUri, newModelName, multiModel);
		}
		if (updateMid) {
			multiModel.getModels().add(newModel);
		}
		newModel.setOrigin(origin);
		newModel.setFileExtension(fileExtension);
	}

	/**
	 * Creates and possibly adds a model to an Instance MID.
	 * 
	 * @param modelType
	 *            The type of the new model.
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param multiModel
	 *            An Instance MID, null if the model isn't going to be added to
	 *            it.
	 * @return The created model.
	 * @throws MMTFException
	 *             If the uri of the new model is already registered in the
	 *             Instance MID.
	 */
	public static Model createModel(Model modelType, String newModelUri, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		Model newModel = MidFactory.eINSTANCE.createModel();
		addModel(newModel, modelType, newModelUri, origin, multiModel);

		return newModel;
	}

	/**
	 * Creates and adds a model and an editor for it to an Instance MID.
	 * 
	 * @param modelType
	 *            The type of the new model.
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param multiModel
	 *            An Instance MID.
	 * @return The created model.
	 * @throws MMTFException
	 *             If the uri of the new model is already registered in the
	 *             Instance MID.
	 */
	public static Model createModelAndEditor(Model modelType, String newModelUri, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		Model newModel = createModel(modelType, newModelUri, origin, multiModel);
		Editor newEditor = createEditor(newModel);
		if (newEditor != null) {
			addModelEditor(newEditor, multiModel);
		}

		return newModel;
	}

	/**
	 * Creates and adds a reference to a model element to an Instance MID.
	 * 
	 * @param newModelElem
	 *            The model element for which the reference is being created.
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the model element.
	 * @return The created reference to the model element.
	 */
	private static ModelElementReference createModelElementReference(ModelElement newModelElem, ModelEndpointReference modelEndpointRef) {

		ModelElementReference newModelElemRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		addInstanceReference(newModelElemRef, newModelElem, false);
		modelEndpointRef.getModelElemRefs().add(newModelElemRef);

		return newModelElemRef;
	}

	/**
	 * Creates and adds a model element and a reference to it to an Instance
	 * MID.
	 * 
	 * @param modelElemType
	 *            The type of the new model element.
	 * @param newModelElemUri
	 *            The uri of the new model element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param classLiteral
	 *            The class name of the new model element type.
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the model element.
	 * @return The created reference to the new model element.
	 * @throws MMTFException
	 *             If the uri of the new model element is already registered in
	 *             the Instance MID.
	 */
	public static ModelElementReference createModelElementAndModelElementReference(ModelElement modelElemType, String newModelElemUri, String newModelElemName, String classLiteral, ModelEndpointReference modelEndpointRef) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelEndpointRef);

		newModelElemUri += MMTF.ROLE_SEPARATOR + modelElemType.getUri();
		ModelElement newModelElem = MultiModelRegistry.getExtendibleElement(newModelElemUri, multiModel);
		if (newModelElem == null) {
			newModelElem = MidFactory.eINSTANCE.createModelElement();
			addInstance(newModelElem, modelElemType, newModelElemUri, newModelElemName, multiModel);
			newModelElem.setClassLiteral(classLiteral);
			modelEndpointRef.getObject().getTarget().getModelElems().add(newModelElem);
		}
		ModelElementReference newModelElemRef = createModelElementReference(newModelElem, modelEndpointRef);

		return newModelElemRef;
	}

	/**
	 * Creates and adds a model element and a reference to it to an Instance
	 * MID.
	 * 
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param modelObj
	 *            The EMF model element, that will be wrapped by the MMTF model
	 *            element.
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the model element.
	 * @return The reference to the new model element.
	 * @throws MMTFException
	 *             If the uri of the new model element is already registered in
	 *             the Instance MID.
	 */
	public static ModelElementReference createModelElementAndModelElementReference(String newModelElemName, EObject modelObj, ModelEndpointReference modelEndpointRef) throws MMTFException {

		ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelObj);
		String newModelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, true)[1];
		String classLiteral = MultiModelRegistry.getModelElementClassLiteral(modelObj, true);
		if (newModelElemName == null) {
			newModelElemName = MultiModelRegistry.getModelElementName(modelObj, true);
		}
		ModelElementReference newModelElemRef = createModelElementAndModelElementReference(
			modelElemType,
			newModelElemUri,
			newModelElemName,
			classLiteral,
			modelEndpointRef
		);

		return newModelElemRef;
	}

	/**
	 * Creates and possibly adds a model relationship to an Instance MID.
	 * 
	 * @param modelRelType
	 *            The type of the new model relationship.
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model
	 *            relationship is not in a separate file; e.g. a standalone
	 *            model relationship is in its own files, a plain model
	 *            relationship is not.
	 * @param newModelRelClass
	 *            The class of the new model relationship.
	 * @param origin
	 *            The origin of the new model relationship.
	 * @param multiModel
	 *            An Instance MID, null if the model relationship isn't going to
	 *            be added to it.
	 * @return The created model relationship.
	 * @throws MMTFException
	 *             If the uri of the new model relationship is already
	 *             registered in the Instance MID.
	 */
	public static ModelRel createModelRel(ModelRel modelRelType, String newModelRelUri, EClass newModelRelClass, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		ModelRel newModelRel = (ModelRel) RelationshipFactory.eINSTANCE.create(newModelRelClass);
		addModel(newModelRel, modelRelType, newModelRelUri, origin, multiModel);

		return newModelRel;
	}

	/**
	 * Creates and adds a reference to a model endpoint to an Instance MID.
	 * 
	 * @param newModelEndpoint
	 *            The model endpoint for which the reference is being created.
	 * @param isBinarySrc
	 *            True if the model endpoint is the source in the binary model
	 *            relationship container, false otherwise.
	 * @param modelRel
	 *            The model relationship that will contain the new reference to
	 *            the model endpoint.
	 * @return The created reference to the model endpoint.
	 */
	public static ModelEndpointReference createModelEndpointReference(ModelEndpoint newModelEndpoint, boolean isBinarySrc, ModelRel modelRel) {

		ModelEndpointReference newModelEndpointRef = RelationshipFactory.eINSTANCE.createModelEndpointReference();
		boolean isContainer = (modelRel.eContainer() == null);
		addInstanceReference(newModelEndpointRef, newModelEndpoint, isContainer);

		if (isBinarySrc) {
			modelRel.getModelEndpointRefs().add(0, newModelEndpointRef);
		} 
		else {
			modelRel.getModelEndpointRefs().add(newModelEndpointRef);
		}

		return newModelEndpointRef;
	}

	/**
	 * Creates and adds a model endpoint and a reference to it to an Instance
	 * MID.
	 * 
	 * @param modelTypeEndpoint
	 *            The type of the new model endpoint.
	 * @param newModel
	 *            The new model that is the target of the new model endpoint.
	 * @param isBinarySrc
	 *            True if the model endpoint is the source in the binary model
	 *            relationship container, false otherwise.
	 * @param modelRel
	 *            The model relationship that will contain the new model
	 *            endpoint.
	 * @return The created reference to the model endpoint.
	 */
	public static ModelEndpointReference createModelEndpointAndModelEndpointReference(ModelEndpoint modelTypeEndpoint, Model newModel, boolean isBinarySrc, ModelRel modelRel) {

		ModelEndpoint newModelEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		addBasicInstance(newModelEndpoint, modelTypeEndpoint, null, newModel.getName());
		addInstanceEndpoint(newModelEndpoint, newModel);
		if (isBinarySrc) {
			modelRel.getModelEndpoints().add(0, newModelEndpoint);
		}
		else {
			modelRel.getModelEndpoints().add(newModelEndpoint);
		}
		ModelEndpointReference modelEndpointRef = createModelEndpointReference(newModelEndpoint, isBinarySrc, modelRel);

		return modelEndpointRef;
	}

	/**
	 * Creates and adds a model relationship and its model endpoints to an
	 * Instance MID.
	 * 
	 * @param modelRelType
	 *            The type of the new model relationship.
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model
	 *            relationship is not in a separate file; e.g. a standalone
	 *            model relationship is in its own files, a plain model
	 *            relationship is not.
	 * @param newModelRelClass
	 *            The class of the new model relationship.
	 * @param origin
	 *            The origin of the new model relationship.
	 * @param newModels
	 *            The new models that are the targets of the new model
	 *            endpoints.
	 * @return The created model relationship.
	 * @throws MMTFException
	 *             If the uri of the new model relationship is already
	 *             registered in the Instance MID.
	 */
	public static ModelRel createModelRelAndModelEndpointsAndModelEndpointReferences(ModelRel modelRelType, String newModelRelUri, EClass newModelRelClass, ModelOrigin origin, Model... newModels) throws MMTFException {

		if (newModels.length == 0) {
			return null;
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(newModels[0]);
		// create model rel
		ModelRel newModelRel = createModelRel(
			modelRelType,
			newModelRelUri,
			newModelRelClass,
			origin,
			multiModel
		);
		// create model rel endpoints
		for (Model model : newModels) {
			createModelEndpointAndModelEndpointReference(
				null,
				model,
				false,
				newModelRel
			);
		}

		return newModelRel;
	}

	/**
	 * Replaces an old model endpoint and a reference to it with new ones in an
	 * Instance MID.
	 * 
	 * @param oldModelEndpoint
	 *            The old model endpoint to be replaced.
	 * @param modelTypeEndpoint
	 *            The type of the new model endpoint.
	 * @param newModel
	 *            The new model that is the target of the new model endpoint.
	 */
	public static void replaceModelEndpointAndModelEndpointReference(ModelEndpoint oldModelEndpoint, ModelEndpoint modelTypeEndpoint, Model newModel) {

		addBasicInstance(oldModelEndpoint, modelTypeEndpoint, null, null);
		oldModelEndpoint.setTarget(newModel);
	}

	/**
	 * Creates and adds a new link and a reference to it to an Instance MID.
	 * 
	 * @param linkType
	 *            The type of the new link.
	 * @param newLinkClass
	 *            The class of the new link.
	 * @param newLinkRefClass
	 *            The class of the new reference to the new link.
	 * @param modelRel
	 *            The model relationship that will contain the new link.
	 * @return The created reference to the new link.
	 */
	public static LinkReference createLinkAndLinkReference(Link linkType, EClass newLinkClass, EClass newLinkRefClass, ModelRel modelRel) {

		Link newLink = (Link) RelationshipFactory.eINSTANCE.create(newLinkClass);
		modelRel.getLinks().add(newLink);
		addBasicInstance(newLink, linkType, null, null);
		LinkReference newLinkRef = createLinkReference(newLink, newLinkRefClass, modelRel);

		return newLinkRef;
	}

	/**
	 * Creates and adds a reference to a link to an Instance MID.
	 * 
	 * @param newLink
	 *            The link for which the reference is being created.
	 * @param newLinkRefClass
	 *            The class of the new reference to the link.
	 * @param modelRel
	 *            The model relationship that will contain the new reference to
	 *            the link.
	 * @return The created reference to the link.
	 */
	public static LinkReference createLinkReference(Link newLink, EClass newLinkRefClass, ModelRel modelRel) {

		LinkReference linkRef = (LinkReference) RelationshipFactory.eINSTANCE.create(newLinkRefClass);
		addInstanceReference(linkRef, newLink, false);
		modelRel.getLinkRefs().add(linkRef);

		return linkRef;
	}

	/**
	 * Creates and adds a link, a reference to it, its model endpoints and
	 * references to them to an Instance MID.
	 * 
	 * @param linkType
	 *            The type of the new link.
	 * @param newLinkClass
	 *            The class of the new link.
	 * @param newLinkRefClass
	 *            The class of the new reference to the new link.
	 * @param newModelElemRefs
	 *            The new references to the model elements that are the targets
	 *            of the new model element endpoints.
	 * @return The created reference to the new link.
	 */
	public static LinkReference createLinkAndLinkReferenceAndModelElementEndpointsAndModelElementEndpointReferences(Link linkType, EClass newLinkClass, EClass newLinkRefClass, ModelElementReference... newModelElemRefs) {

		if (newModelElemRefs.length == 0) {
			return null;
		}

		ModelRel modelRel = (ModelRel) newModelElemRefs[0].eContainer().eContainer();
		// create link
		LinkReference newLinkRef = createLinkAndLinkReference(
			linkType,
			newLinkClass,
			newLinkRefClass,
			modelRel
		);
		// create model element endpoints
		for (ModelElementReference modelElemRef : newModelElemRefs) {
			ModelElementEndpointReference newModelElemEndpointRef = createModelElementEndpointAndModelElementEndpointReference(
				null,
				modelElemRef,
				false,
				newLinkRef
			);
			newModelElemEndpointRef.getObject().setName(modelElemRef.getObject().getName());
		}

		return newLinkRef;
	}

	/**
	 * Creates and adds a model element endpoint and a reference to it to an
	 * Instance MID.
	 * 
	 * @param modelElemTypeEndpoint
	 *            The type of the new model element endpoint.
	 * @param newModelElemRef
	 *            The reference to the new model element that is the target of
	 *            the new model element endpoint.
	 * @param isBinarySrc
	 *            True if the model element endpoint is the source in the binary
	 *            link container, false otherwise.
	 * @param linkRef
	 *            The reference to the link that will contain the new model
	 *            element endpoint.
	 * @return The created reference to the new model element endpoint.
	 */
	public static ModelElementEndpointReference createModelElementEndpointAndModelElementEndpointReference(ModelElementEndpoint modelElemTypeEndpoint, ModelElementReference newModelElemRef, boolean isBinarySrc, LinkReference linkRef) {

		ModelElementEndpoint newModelElemEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		addBasicInstance(newModelElemEndpoint, modelElemTypeEndpoint, null, newModelElemRef.getObject().getName());
		addInstanceEndpoint(newModelElemEndpoint, newModelElemRef.getObject());
		if (isBinarySrc) {
			linkRef.getObject().getModelElemEndpoints().add(0, newModelElemEndpoint);
		}
		else {
			linkRef.getObject().getModelElemEndpoints().add(newModelElemEndpoint);
		}
		ModelElementEndpointReference modelElemEndpointRef = createModelElementEndpointReference(newModelElemEndpoint, newModelElemRef, isBinarySrc, linkRef);
		linkRef.getObject().getModelElemEndpointRefs().add(modelElemEndpointRef);

		return modelElemEndpointRef;
	}

	/**
	 * Creates and adds a reference to a model element endpoint to an Instance
	 * MID.
	 * 
	 * @param newModelElemEndpoint
	 *            The model element endpoint for which the reference is being
	 *            created.
	 * @param newModelElemRef
	 *            The reference to the new model element that is the target of
	 *            the new model element endpoint.
	 * @param isBinarySrc
	 *            True if the reference to the model element endpoint is the
	 *            source in the binary link reference container, false
	 *            otherwise.
	 * @param linkRef
	 *            The reference to the link that will contain the new model
	 *            element endpoint.
	 * @return The created reference to the model element endpoint.
	 */
	public static ModelElementEndpointReference createModelElementEndpointReference(ModelElementEndpoint newModelElemEndpoint, ModelElementReference newModelElemRef, boolean isBinarySrc, LinkReference linkRef) {

		ModelElementEndpointReference newModelElemEndpointRef = RelationshipFactory.eINSTANCE.createModelElementEndpointReference();
		boolean isContainer = linkRef.eContainer().eContainer() == null;
		addInstanceReference(newModelElemEndpointRef, newModelElemEndpoint, isContainer);
		newModelElemEndpointRef.setModelElemRef(newModelElemRef);

		if (isBinarySrc) {
			linkRef.getModelElemEndpointRefs().add(0, newModelElemEndpointRef);
		} 
		else {
			linkRef.getModelElemEndpointRefs().add(newModelElemEndpointRef);
		}

		return newModelElemEndpointRef;
	}

	/**
	 * Replaces an old model element endpoint and a reference to it with new
	 * ones in an Instance MID.
	 * 
	 * @param oldModelElemEndpointRef
	 *            The reference to the old model element endpoint to be
	 *            replaced.
	 * @param modelElemTypeEndpoint
	 *            The type of the new model element endpoint.
	 * @param newModelElemRef
	 *            The reference to the new model element that is the target of
	 *            the new model element endpoint.
	 */
	public static void replaceModelElementEndpointAndModelElementEndpointReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementEndpoint modelElemTypeEndpoint, ModelElementReference newModelElemRef) {

		ModelElementEndpoint oldModelElemEndpoint = oldModelElemEndpointRef.getObject();
		addBasicInstance(oldModelElemEndpoint, modelElemTypeEndpoint, null, null);
		oldModelElemEndpoint.setTarget(newModelElemRef.getObject());
		oldModelElemEndpointRef.setModelElemRef(newModelElemRef);
	}

	/**
	 * Creates and adds an editor to an Instance MID.
	 * 
	 * @param model
	 *            The model handled by the new editor.
	 * @return The created editor, null if the editor couldn't be created.
	 */
	public static Editor createEditor(Model model) {

		EList<Editor> editorTypes = MultiModelTypeRegistry.getModelTypeEditors(model.getMetatypeUri());
		if (editorTypes.size() == 0) {
			return null;
		}

		//TODO MMTF: prioritize editors list instead of running twice?
		// all diagrams are tried..
		for (Editor editorType : editorTypes) {
			if (!(editorType instanceof Diagram)) {
				continue;
			}
			Diagram newDiagram = createDiagram((Diagram) editorType, model.getUri());
			if (newDiagram != null) {
				return newDiagram;
			}
		}
		// ..or first editor is used
		for (Editor editorType : editorTypes) {
			if (editorType instanceof Diagram) {
				continue;
			}
			return createEditor(editorType, model.getUri());
		}

		return null;
	}

	/**
	 * Creates and adds an editor to an Instance MID.
	 * 
	 * @param editorType
	 *            The type of the new editor.
	 * @param modelUri
	 *            The uri of the model handled by the new editor.
	 * @return The created editor.
	 */
	public static Editor createEditor(Editor editorType, String modelUri) {

		Editor newEditor = (Editor) EditorFactory.eINSTANCE.create(editorType.eClass());
		String newEditorName = editorType.getName() + " for model " + modelUri;
		String newEditorUri = MultiModelUtils.replaceFileExtensionInUri(modelUri, editorType.getFileExtensions().get(0));
		addBasicInstance(newEditor, editorType, newEditorUri, newEditorName);
		newEditor.setModelUri(modelUri);
		newEditor.setId(editorType.getId());
		newEditor.setWizardId(editorType.getWizardId());
		newEditor.getFileExtensions().add(editorType.getFileExtensions().get(0));

		return newEditor;
	}

	/**
	 * Creates and adds a diagram to an Instance MID.
	 * 
	 * @param diagramType
	 *            The type of the new diagram.
	 * @param modelUri
	 *            The uri of the model handled by the new diagram.
	 * @return The created diagram, null if the diagram couldn't be created.
	 */
	public static Diagram createDiagram(Diagram diagramType, String modelUri) {

		// check if editor file already exists in model directory
		File editorFile = new File(
			MultiModelUtils.prependWorkspaceToUri(
				MultiModelUtils.replaceFileExtensionInUri(modelUri, diagramType.getFileExtensions().get(0))
			)
		);
		if (!editorFile.exists()) {
			if (!(boolean) MMTF.getSetting(MMTFConstants.SETTING_MENU_DIAGRAMS_CREATION_ENABLED)) {
				return null;
			}
			// try to build a new diagram through its wizard, inited with the existing model file
			IStructuredSelection modelFile = new StructuredSelection(
				ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(modelUri)
				)
			);
			EditorCreationWizardDialog wizDialog;
			try {
				wizDialog = invokeEditorWizard(diagramType, modelFile);
			}
			catch (Exception e) {
				return null;
			}
			if (wizDialog == null) {
				return null;
			}
		}

		return (Diagram) createEditor(diagramType, modelUri);
	}

	/**
	 * Adds an editor to its model and to an Instance MID.
	 * 
	 * @param editor
	 *            The editor.
	 * @param multiModel
	 *            The Instance MID.
	 */
	public static void addModelEditor(Editor editor, MultiModel multiModel) {

		Model model = MultiModelRegistry.getExtendibleElement(editor.getModelUri(), multiModel);
		if (model != null) {
			model.getEditors().add(editor);
			multiModel.getEditors().add(editor);
		}
	}

	/**
	 * Invokes an editor creation wizard. The wizard can be initialized with an
	 * existing model, or create the underlying model as a side effect.
	 * 
	 * @param editorType
	 *            The editor type.
	 * @param initialSelection
	 *            The selection used to initialize the wizard. It can be an
	 *            existing model file, or its container when the underlying
	 *            model file has to be created.
	 * @return The editor creation wizard dialog, null if the user canceled the
	 *         operation.
	 * @throws Exception
	 *             If the editor creation wizard could not be invoked.
	 */
	public static EditorCreationWizardDialog invokeEditorWizard(Editor editorType, IStructuredSelection initialSelection) throws Exception {

		Model modelType = MultiModelTypeRegistry.<Model>getType(editorType.getModelUri());
		IWorkbenchWizard wizard;
		if (editorType.getWizardId() == null) {
			EClass rootEClass = (EClass) ((EPackage) MultiModelTypeIntrospection.getRoot(modelType)).getEClassifiers().get(0);
			wizard = new DynamicModelWizard(rootEClass);
		}
		else {
			IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(editorType.getWizardId());
			if (descriptor == null) {
				throw new MMTFException("Wizard " + editorType.getId() + " not found");
			}
			wizard = descriptor.createWizard();
		}
		wizard.init(PlatformUI.getWorkbench(), initialSelection);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		String wizardDialogClassName = editorType.getWizardDialogClass();
		EditorCreationWizardDialog wizDialog = null;
		if (wizardDialogClassName == null) {
			if (editorType instanceof Diagram && initialSelection.getFirstElement() instanceof IFile) {
				String modelUri = MultiModelUtils.prependWorkspaceToUri(
					((IFile) initialSelection.getFirstElement()).getFullPath().toOSString()
				);
				String diagramUri = MultiModelUtils.replaceFileExtensionInUri(modelUri, editorType.getFileExtensions().get(0));
				String diagramKind = MultiModelTypeRegistry.getType(editorType.getModelUri()).getName();
				String diagramPluginId = MultiModelTypeRegistry.getTypeBundle(editorType.getUri()).getSymbolicName();
				// create the diagram directly and do not open the wizard
				GMFDiagramUtils.createGMFDiagram(modelUri, diagramUri, diagramKind, diagramPluginId);
				GMFDiagramUtils.openGMFDiagram(diagramUri, editorType.getId());
				return new EditorCreationWizardDialog(shell, wizard);
			}
			else {
				wizDialog = new EditorCreationWizardDialog(shell, wizard);
			}
		}
		else {
			try {
				wizDialog = (EditorCreationWizardDialog)
					MultiModelTypeRegistry.getTypeBundle(editorType.getUri()).
					loadClass(wizardDialogClassName).
					getConstructor(Shell.class, IWizard.class).
					newInstance(shell, wizard);
			}
			catch (Exception e) {
				MMTFException.print(MMTFException.Type.WARNING, "Custom editor creation wizard not found: " + wizardDialogClassName + " , using default as fallback", e);
				wizDialog = new EditorCreationWizardDialog(shell, wizard);
			}
		}
		wizDialog.setTitle(wizard.getWindowTitle());
		if (wizDialog.open() == Window.CANCEL) {
			return null;
		}

		return wizDialog;
	}

	/**
	 * Removes an instance from an Instance MID.
	 * 
	 * @param instanceUri
	 *            The uri of the instance to be removed.
	 * @param multiModel
	 *            The Instance MID that contains the instance.
	 * @return The removed instance, null if the uri was not registered in the
	 *         Instance MID.
	 */
	private static ExtendibleElement removeInstance(String instanceUri, MultiModel multiModel) {

		return multiModel.getExtendibleTable().removeKey(instanceUri);
	}

	/**
	 * Removes a model from the Instance MID that contains it.
	 * 
	 * @param model
	 *            The model to be removed.
	 */
	public static void removeModel(Model model) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(model);
		removeInstance(model.getUri(), multiModel);
		multiModel.getModels().remove(model);

		//remove model elements
		for (ModelElement modelElem : model.getModelElems()) {
			removeInstance(modelElem.getUri(), multiModel);
		}
		// remove editors
		for (Editor editor : model.getEditors()) {
			removeEditor(editor);
		}
		// remove model relationships and endpoints that use this model
		List<ModelRel> delModelRels = new ArrayList<ModelRel>();
		List<ModelEndpoint> delModelEndpoints = new ArrayList<ModelEndpoint>();
		for (ModelRel modelRel : MultiModelRegistry.getModelRels(multiModel)) {
			for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
				if (modelEndpoint.getTargetUri().equals(model.getUri())) {
					if (modelRel instanceof BinaryModelRel) {
						if (!delModelRels.contains(modelRel)) {
							delModelRels.add(modelRel);
						}
					}
					else {
						delModelEndpoints.add(modelEndpoint);
					}
				}
			}
		}
		for (ModelEndpoint modelEndpoint : delModelEndpoints) {
			removeModelEndpointAndModelEndpointReference(modelEndpoint, true);
		}
		for (ModelRel modelRel : delModelRels) {
			removeModelRel(modelRel);
		}
	}

	/**
	 * Removes a model relationship from the Instance MID that contains it.
	 * 
	 * @param modelRel
	 *            The model relationship to be removed.
	 */
	public static void removeModelRel(ModelRel modelRel) {

		removeModel(modelRel);
	}

	/**
	 * Removes a model endpoint and the reference to it from the Instance MID
	 * that contains them.
	 * 
	 * @param modelEndpoint
	 *            The model endpoint to be removed.
	 * @param isFullRemove
	 *            True if the model endpoint is going to be fully removed, false
	 *            if it is going to be replaced later.
	 */
	public static void removeModelEndpointAndModelEndpointReference(ModelEndpoint modelEndpoint, boolean isFullRemove) {

		ModelRel modelRel = (ModelRel) modelEndpoint.eContainer();
		ModelEndpointReference modelEndpointRef = null;
		for (ModelEndpointReference modelEndpointRef2 : modelRel.getModelEndpointRefs()) {
			if (modelEndpointRef2.getObject() == modelEndpoint) {
				modelEndpointRef = modelEndpointRef2;
				break;
			}
		}
		while (modelEndpointRef.getModelElemRefs().size() > 0) {
			removeModelElementReference(modelEndpointRef.getModelElemRefs().get(0));
		}
		if (isFullRemove) {
			modelRel.getModelEndpoints().remove(modelEndpoint);
			modelRel.getModelEndpointRefs().remove(modelEndpointRef);
		}
	}

	/**
	 * Removes a link and the reference to it from the Instance MID that
	 * contains them.
	 * 
	 * @param linkRef
	 *            The reference to be removed to the link to be removed.
	 */
	public static void removeLinkAndLinkReference(LinkReference linkRef) {

		ModelRel modelRel = (ModelRel) linkRef.eContainer();
		modelRel.getLinkRefs().remove(linkRef);
		for (ModelElementEndpointReference modelElemEndpointRef : linkRef.getModelElemEndpointRefs()) {
			modelElemEndpointRef.setModelElemRef(null);
		}
		modelRel.getLinks().remove(linkRef.getObject());
	}

	/**
	 * Removes a model element endpoint and the reference to it from the
	 * Instance MID that contains them.
	 * 
	 * @param modelElemEndpointRef
	 *            The reference to be removed to the model element endpoint to
	 *            be removed.
	 * @param isFullRemove
	 *            True if the model element endpoint is going to be fully
	 *            removed, false if it is going to be replaced later.
	 */
	public static void removeModelElementEndpointAndModelElementEndpointReference(ModelElementEndpointReference modelElemEndpointRef, boolean isFullRemove) {

		LinkReference linkRef = (LinkReference) modelElemEndpointRef.eContainer();
		Link link = linkRef.getObject();
		if (isFullRemove) {
			link.getModelElemEndpoints().remove(modelElemEndpointRef.getObject());
			linkRef.getModelElemEndpointRefs().remove(modelElemEndpointRef);
			link.getModelElemEndpointRefs().remove(modelElemEndpointRef);
			modelElemEndpointRef.setModelElemRef(null);
		}
	}

	/**
	 * Removes a reference to a model element from the Instance MID that
	 * contains it.
	 * 
	 * @param modelElemRef
	 *            The reference to be removed to the modle element.
	 */
	public static void removeModelElementReference(ModelElementReference modelElemRef) {

		List<LinkReference> delLinkRefs = new ArrayList<LinkReference>();
		List<ModelElementEndpointReference> delModelElemEndpointRefs = new ArrayList<ModelElementEndpointReference>();
		for (ModelElementEndpointReference modelElemEndpointRef : modelElemRef.getModelElemEndpointRefs()) {
			LinkReference linkRef = (LinkReference) modelElemEndpointRef.eContainer();
			if (linkRef instanceof BinaryLinkReference) {
				if (!delLinkRefs.contains(linkRef)) {
					delLinkRefs.add(linkRef);
				}
			}
			else {
				if (!delModelElemEndpointRefs.contains(modelElemEndpointRef)) {
					delModelElemEndpointRefs.add(modelElemEndpointRef);
				}
			}
		}
		for (LinkReference linkRef : delLinkRefs) {
			removeLinkAndLinkReference(linkRef);
		}
		for (ModelElementEndpointReference modelElemEndpointRef : delModelElemEndpointRefs) {
			removeModelElementEndpointAndModelElementEndpointReference(modelElemEndpointRef, true);
		}

		((ModelEndpointReference) modelElemRef.eContainer()).getModelElemRefs().remove(modelElemRef);
	}

	/**
	 * Removes a model element and the reference to it from the Instance MID
	 * that contains them.
	 * 
	 * @param modelElemRef
	 *            The reference to be removed to the model element to be
	 *            removed.
	 */
	public static void removeModelElementAndModelElementReference(ModelElementReference modelElemRef) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelElemRef);
		removeInstance(modelElemRef.getUri(), multiModel);
		removeModelElementReference(modelElemRef);
		ModelElement modelElem = modelElemRef.getObject();
		((Model) modelElem.eContainer()).getModelElems().remove(modelElem);
		//TODO MMTF: should remove from all model rels too?
	}

	/**
	 * Removes an editor from the Instance MID that contains it.
	 * 
	 * @param editor
	 *            The editor to be removed.
	 */
	public static void removeEditor(Editor editor) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(editor);
		multiModel.getEditors().remove(editor);
		// no need to removeExtendibleElement
	}

}
