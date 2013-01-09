/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.trait;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
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

/**
 * The factory to create/modify/remove elements inside an instance multimodel.
 * 
 * @author Alessio Di Sandro
 * @author Vivien Suen
 * 
 */
public class MultiModelInstanceFactory {

	/**
	 * Adds the basic info to a new extendible element and registers its uri in
	 * a multimodel.
	 * 
	 * @param newElement
	 *            The new element.
	 * @param elementType
	 *            The element type.
	 * @param newElementUri
	 *            The uri of the new element.
	 * @param newElementName
	 *            The name of the new element.
	 * @param multiModel
	 *            The multimodel.
	 * @throws MMTFException
	 *             If the uri of the element is already registered.
	 */
	private static void addExtendibleElement(ExtendibleElement newElement, ExtendibleElement elementType, String newElementUri, String newElementName, MultiModel multiModel) throws MMTFException {

		if (multiModel.getExtendibleTable().containsKey(newElementUri)) {
			throw new MMTFException("Extendible element with uri " + newElementUri + " is already in this instance MID");
		}
		multiModel.getExtendibleTable().put(newElementUri, newElement);

		addBasicExtendibleElement(newElement, elementType, newElementUri, newElementName);
	}

	/**
	 * Adds the basic info to a new extendible element without registering its
	 * uri.
	 * 
	 * @param newElement
	 *            The new element.
	 * @param elementType
	 *            The element type.
	 * @param newElementUri
	 *            The uri of the new element.
	 * @param newElementName
	 *            The name of the new element.
	 */
	private static void addBasicExtendibleElement(ExtendibleElement newElement, ExtendibleElement elementType, String newElementUri, String newElementName) {

		newElement.setUri(newElementUri);
		newElement.setName(newElementName);
		newElement.setLevel(MidLevel.INSTANCES);
		newElement.setDynamic(true);
		newElement.setSupertype(null);
		if (elementType == null) { // get runtime metatype
			//TODO MMTF: which entry to use, the most specific (operators) or the most conservative (import model)?
			//TODO MMTF: now is the first == the most conservative
			//TODO MMTF: do I fix everything by just letting the user choose with a dialog?
			//TODO MMTF: actually it's kind of useless for rels/links, i should just set the root type, because at creation time it's hard to already have all connections
			List<ExtendibleElement> runtimeTypes = MultiModelTypeIntrospection.getRuntimeTypesOld(newElement);
			newElement.setMetatypeUri(runtimeTypes.get(0).getUri());
		}
		else { // use static metatype
			newElement.setMetatypeUri(elementType.getUri());
		}
	}

	/**
	 * Adds the target info to a new extendible element endpoint.
	 * 
	 * @param newElementEndpoint
	 *            The new endpoint.
	 * @param element
	 *            The target of the endpoint.
	 */
	private static void addExtendibleElementEndpoint(ExtendibleElementEndpoint newElementEndpoint, ExtendibleElement element) {

		newElementEndpoint.setTarget(element);
		newElementEndpoint.setLowerBound(1);
		newElementEndpoint.setUpperBound(1);
	}

	/**
	 * Adds the referenced element info to an extendible element reference.
	 * 
	 * @param elementRef
	 *            The element reference.
	 * @param element
	 *            The referenced element.
	 * @param isContainer
	 *            True if the referenced element is contained by the reference,
	 *            false if it is contained by something else.
	 */
	private static void addExtendibleElementReference(ExtendibleElementReference elementRef, ExtendibleElement element, boolean isContainer) {

		if (isContainer) {
			elementRef.setContainedObject(element);
		}
		else {
			elementRef.setReferencedObject(element);
		}
		elementRef.setModifiable(true);
		elementRef.setSupertypeRef(null);
	}

	/**
	 * Adds info to a new model and possibly adds it to a multimodel.
	 * 
	 * @param newModel
	 *            The new model.
	 * @param modelType
	 *            The model type.
	 * @param newModelUri
	 *            The uri of the new model (can be null if the new model is not
	 *            an external entity with respect to the multimodel; e.g. a
	 *            model and a standalone model relationship are external, a
	 *            plain model relationship is not).
	 * @param origin
	 *            The origin of the new model.
	 * @param multiModel
	 *            The multimodel (can be null if the model does not have to be
	 *            added to a multimodel).
	 * @throws MMTFException
	 *             If the uri of the model is already registered in the
	 *             multimodel.
	 */
	private static void addModel(Model newModel, Model modelType, String newModelUri, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		boolean externalElement = newModelUri != null;
		boolean updateMid = multiModel != null;
		boolean basicElement = !updateMid || !externalElement;

		String newModelName = null;
		String fileExtension = null;
		if (externalElement) {
			newModelName = MultiModelRegistry.getFileNameFromUri(newModelUri);
			fileExtension = MultiModelRegistry.getFileExtensionFromUri(newModelUri);
		}
		if (basicElement) {
			addBasicExtendibleElement(newModel, modelType, newModelUri, newModelName);
		}
		else {
			addExtendibleElement(newModel, modelType, newModelUri, newModelName, multiModel);
		}
		if (updateMid) {
			multiModel.getModels().add(newModel);
		}
		newModel.setOrigin(origin);
		newModel.setFileExtension(fileExtension);
	}

	/**
	 * Creates a new model and possibly adds it to a multimodel.
	 * 
	 * @param modelType
	 *            The model type.
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param multiModel
	 *            The multimodel (can be null if the model does not have to be
	 *            added to a multimodel).
	 * @return The new model.
	 * @throws MMTFException
	 *             If the uri of the model is already registered in the
	 *             multimodel.
	 */
	public static Model createModel(Model modelType, String newModelUri, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		Model newModel = MidFactory.eINSTANCE.createModel();
		addModel(newModel, modelType, newModelUri, origin, multiModel);

		return newModel;
	}

	/**
	 * Creates a new model together with an editor for it, and adds them to a
	 * multimodel.
	 * 
	 * @param modelType
	 *            The model type.
	 * @param newModelUri
	 *            The uri of the new model.
	 * @param origin
	 *            The origin of the new model.
	 * @param multiModel
	 *            The multimodel.
	 * @return The new model.
	 * @throws MMTFException
	 *             If the uri of the model is already registered in the
	 *             multimodel.
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
	 * Creates a new reference to a model element and adds it to a model
	 * endpoint reference.
	 * 
	 * @param modelEndpointRef
	 *            The reference to a model endpoint.
	 * @param modelElem
	 *            The model element.
	 * @return The new reference to the model element.
	 */
	private static ModelElementReference createModelElementReference(ModelEndpointReference modelEndpointRef, ModelElement modelElem) {

		ModelElementReference newModelElemRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		addExtendibleElementReference(newModelElemRef, modelElem, false);
		modelEndpointRef.getModelElemRefs().add(newModelElemRef);

		return newModelElemRef;
	}

	/**
	 * Creates a new model element together with a reference to it, and adds
	 * them to their respective containers.
	 * 
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the
	 *            model element.
	 * @param modelElemType
	 *            The model element type.
	 * @param newModelElemUri
	 *            The uri of the new model element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param category
	 *            The category of the new model element.
	 * @param classLiteral
	 *            The class literal of the new model element.
	 * @return The reference to the new model element.
	 * @throws MMTFException
	 *             If the uri of the model element is already registered in the
	 *             multimodel.
	 */
	public static ModelElementReference createModelElementAndModelElementReference(ModelEndpointReference modelEndpointRef, ModelElement modelElemType, String newModelElemUri, String newModelElemName, ModelElementCategory category, String classLiteral) throws MMTFException {

		ModelRel modelRel = (ModelRel) modelEndpointRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRel.eContainer();

		//TODO MMTF: String newModelElemUri = newModelElemUri + MMTF.URI_SEPARATOR + classLiteral;
		ModelElement newModelElem = MultiModelRegistry.getExtendibleElement(multiModel, newModelElemUri);
		if (newModelElem == null) {
			newModelElem = MidFactory.eINSTANCE.createModelElement();
			addExtendibleElement(newModelElem, modelElemType, newModelElemUri, newModelElemName, multiModel);
			newModelElem.setCategory(category);
			newModelElem.setClassLiteral(classLiteral);
			modelEndpointRef.getObject().getTarget().getElements().add(newModelElem);
		}
		ModelElementReference newModelElemRef = createModelElementReference(modelEndpointRef, newModelElem);

		return newModelElemRef;
	}

	/**
	 * Creates a new model element together with a reference to it, and adds
	 * them to their respective containers.
	 * 
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the
	 *            model element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param modelObj
	 *            The EMF model element, which will be wrapped by MMTF model
	 *            element.
	 * @return The reference to the new model element.
	 * @throws MMTFException
	 *             If the uri of the model element is already registered in the
	 *             multimodel.
	 */
	public static ModelElementReference createModelElementAndModelElementReference(ModelEndpointReference modelEndpointRef, String newModelElemName, EObject modelObj) throws MMTFException {

		//TODO MMTF: this should check for an existing model element with same uri and return it instead of creating it (something like checkModelUnique)
		ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelObj);
		ModelElementCategory category = MultiModelRegistry.getEObjectCategory(modelObj);
		String newModelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, true)[1];
		String classLiteral = MultiModelRegistry.getEObjectClassLiteral(modelObj, true);
		if (newModelElemName == null) {
			newModelElemName = MultiModelRegistry.getEObjectLabel(modelObj, true);
		}
		ModelElementReference newModelElemRef = createModelElementAndModelElementReference(
			modelEndpointRef,
			modelElemType,
			newModelElemUri,
			newModelElemName,
			category,
			classLiteral
		);

		return newModelElemRef;
	}

	/**
	 * Creates a new model relationship and possibly adds it to a multimodel.
	 * 
	 * @param modelRelType
	 *            The model relationship type.
	 * @param newModelRelUri
	 *            The uri of the new model relationship (can be null if the new
	 *            model relationship is not an external entity with respect to
	 *            the multimodel; e.g. a standalone model relationship is
	 *            external, a plain model relationship is not).
	 * @param origin
	 *            The origin of the new model relationship.
	 * @param modelRelClass
	 *            The class of the new model relationship (binary or nary).
	 * @param multiModel
	 *            The multimodel (can be null if the model relationship does not
	 *            have to be added to a multimodel).
	 * @return The new model relationship.
	 * @throws MMTFException
	 *             If the uri of the model relationship is already registered in
	 *             the multimodel.
	 */
	public static ModelRel createModelRel(ModelRel modelRelType, String newModelRelUri, ModelOrigin origin, EClass modelRelClass, MultiModel multiModel) throws MMTFException {

		ModelRel newModelRel = (ModelRel) RelationshipFactory.eINSTANCE.create(modelRelClass);
		addModel(newModelRel, modelRelType, newModelRelUri, origin, multiModel);

		return newModelRel;
	}

	/**
	 * Creates a new reference to a model endpoint and adds it to a model
	 * relationship.
	 * 
	 * @param modelRel
	 *            The model relationship.
	 * @param modelEndpoint
	 *            The model endpoint.
	 * @param isBinarySrc
	 *            True if the model endpoint is the source endpoint of a binary
	 *            model relationship, false otherwise.
	 * @return The new reference to the model endpoint.
	 */
	public static ModelEndpointReference createModelEndpointReference(ModelRel modelRel, ModelEndpoint modelEndpoint, boolean isBinarySrc) {

		ModelEndpointReference newModelEndpointRef = RelationshipFactory.eINSTANCE.createModelEndpointReference();
		boolean isContainer = modelRel.eContainer() == null;
		addExtendibleElementReference(newModelEndpointRef, modelEndpoint, isContainer);

		if (isBinarySrc) {
			modelRel.getModelEndpointRefs().add(0, newModelEndpointRef);
		} 
		else {
			modelRel.getModelEndpointRefs().add(newModelEndpointRef);
		}

		return newModelEndpointRef;
	}

	/**
	 * Creates a new model endpoint together with a reference to it, and adds
	 * them to their respective containers.
	 * 
	 * @param modelTypeEndpoint
	 *            The model type endpoint.
	 * @param modelRel
	 *            The model relationship that will contain the new model
	 *            endpoint.
	 * @param newModel
	 *            The model to be targeted by the new model endpoint.
	 * @param isBinarySrc
	 *            True if the new model endpoint is the source endpoint of a
	 *            binary model relationship, false otherwise.
	 * @return The reference to the new model endpoint.
	 */
	public static ModelEndpointReference createModelEndpointAndModelEndpointReference(ModelEndpoint modelTypeEndpoint, ModelRel modelRel, Model newModel, boolean isBinarySrc) {

		ModelEndpoint newModelEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		addBasicExtendibleElement(newModelEndpoint, modelTypeEndpoint, null, newModel.getName());
		addExtendibleElementEndpoint(newModelEndpoint, newModel);
		if (isBinarySrc) {
			modelRel.getModelEndpoints().add(0, newModelEndpoint);
		}
		else {
			modelRel.getModelEndpoints().add(newModelEndpoint);
		}
		ModelEndpointReference modelEndpointRef = createModelEndpointReference(modelRel, newModelEndpoint, isBinarySrc);

		return modelEndpointRef;
	}

	/**
	 * Creates a new model relationship together with its model endpoints, and
	 * adds it to a multimodel.
	 * 
	 * @param modelRelType
	 *            The model relationship type.
	 * @param newModelRelUri
	 *            The uri of the new model relationship (can be null if the new
	 *            model relationship is not an external entity with respect to
	 *            the multimodel; e.g. a standalone model relationship is
	 *            external, a plain model relationship is not).
	 * @param origin
	 *            The origin of the new model relationship.
	 * @param modelRelClass
	 *            The class of the new model relationship (binary or nary).
	 * @param models
	 *            The models to be targeted by the endpoints of the new model
	 *            relationship.
	 * @return The new model relationship.
	 * @throws MMTFException
	 *             If the uri of the model relationship is already registered in
	 *             the multimodel.
	 */
	public static ModelRel createModelRelAndModelEndpointsAndModelEndpointReferences(ModelRel modelRelType, String newModelRelUri, ModelOrigin origin, EClass modelRelClass, Model... models) throws MMTFException {

		if (models.length == 0) {
			return null;
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(models[0]);
		// create model rel
		ModelRel newModelRel = createModelRel(
			modelRelType,
			newModelRelUri,
			origin,
			modelRelClass,
			multiModel
		);
		// create model rel endpoints
		for (Model model : models) {
			createModelEndpointAndModelEndpointReference(
				null,
				newModelRel,
				model,
				false
			);
		}

		return newModelRel;
	}

	/**
	 * Replaces the target model of an existing model endpoint.
	 * 
	 * @param oldModelEndpoint
	 *            The existing model endpoint.
	 * @param modelTypeEndpoint
	 *            The model type endpoint.
	 * @param newModel
	 *            The model to be targeted by the existing model endpoint.
	 */
	public static void replaceModelEndpointAndModelEndpointReference(ModelEndpoint oldModelEndpoint, ModelEndpoint modelTypeEndpoint, Model newModel) {

		addBasicExtendibleElement(oldModelEndpoint, modelTypeEndpoint, null, null);
		oldModelEndpoint.setTarget(newModel);
	}

	public static LinkReference createLinkAndLinkReference(Link linkType, ModelRel modelRel, EClass linkClass, EClass linkRefClass) {

		Link newLink = (Link) RelationshipFactory.eINSTANCE.create(linkClass);
		modelRel.getLinks().add(newLink);
		addBasicExtendibleElement(newLink, linkType, null, null);
		LinkReference newLinkRef = createLinkReference(modelRel, newLink, linkRefClass);

		return newLinkRef;
	}

	public static LinkReference createLinkReference(ModelRel modelRel, Link link, EClass linkRefClass) {

		LinkReference linkRef = (LinkReference) RelationshipFactory.eINSTANCE.create(linkRefClass);
		addExtendibleElementReference(linkRef, link, false);
		modelRel.getLinkRefs().add(linkRef);

		return linkRef;
	}

	public static LinkReference createLinkAndLinkReferenceAndModelElementEndpointsAndModelElementEndpointReferences(Link linkType, EClass linkClass, EClass linkRefClass, ModelElementReference... modelElemRefs) throws MMTFException {

		if (modelElemRefs.length == 0) {
			return null;
		}

		ModelRel modelRel = (ModelRel) modelElemRefs[0].eContainer().eContainer();
		// create link
		LinkReference newLinkRef = createLinkAndLinkReference(
			linkType,
			modelRel,
			linkClass,
			linkRefClass
		);
		// create model element endpoints
		for (ModelElementReference modelElemRef : modelElemRefs) {
			ModelElementEndpointReference newModelElemEndpointRef = createModelElementEndpointAndModelElementEndpointReference(
				null,
				newLinkRef,
				modelElemRef,
				false
			);
			newModelElemEndpointRef.getObject().setName(modelElemRef.getObject().getName());
		}

		return newLinkRef;
	}

	public static ModelElementEndpointReference createModelElementEndpointAndModelElementEndpointReference(ModelElementEndpoint modelElemTypeEndpoint, LinkReference linkRef, ModelElementReference newModelElemRef, boolean isBinarySrc) throws MMTFException {

		ModelElementEndpoint newModelElemEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		addBasicExtendibleElement(newModelElemEndpoint, modelElemTypeEndpoint, null, newModelElemRef.getObject().getName());
		addExtendibleElementEndpoint(newModelElemEndpoint, newModelElemRef.getObject());
		if (isBinarySrc) {
			linkRef.getObject().getModelElemEndpoints().add(0, newModelElemEndpoint);
		}
		else {
			linkRef.getObject().getModelElemEndpoints().add(newModelElemEndpoint);
		}
		ModelElementEndpointReference modelElemEndpointRef = createModelElementEndpointReference(linkRef, newModelElemEndpoint, newModelElemRef, isBinarySrc);
		linkRef.getObject().getModelElemEndpointRefs().add(modelElemEndpointRef);

		return modelElemEndpointRef;
	}

	public static ModelElementEndpointReference createModelElementEndpointReference(LinkReference linkRef, ModelElementEndpoint newModelElemEndpoint, ModelElementReference newModelElemRef, boolean isBinarySrc) {

		ModelElementEndpointReference newModelElemEndpointRef = RelationshipFactory.eINSTANCE.createModelElementEndpointReference();
		boolean isContainer = linkRef.eContainer().eContainer() == null;
		addExtendibleElementReference(newModelElemEndpointRef, newModelElemEndpoint, isContainer);
		newModelElemEndpointRef.setModelElemRef(newModelElemRef);

		if (isBinarySrc) {
			linkRef.getModelElemEndpointRefs().add(0, newModelElemEndpointRef);
		} 
		else {
			linkRef.getModelElemEndpointRefs().add(newModelElemEndpointRef);
		}

		return newModelElemEndpointRef;
	}

	public static void replaceModelElementEndpointAndModelElementEndpointReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementEndpoint modelElemTypeEndpoint, LinkReference linkRef, ModelElementReference newModelElemRef) throws MMTFException {

		ModelElementEndpoint oldModelElemEndpoint = oldModelElemEndpointRef.getObject();
		addBasicExtendibleElement(oldModelElemEndpoint, modelElemTypeEndpoint, null, null);
		oldModelElemEndpoint.setTarget(newModelElemRef.getObject());
		oldModelElemEndpointRef.setModelElemRef(newModelElemRef);
	}

	/**
	 * Creates a new editor for a model.
	 * 
	 * @param model
	 *            The model.
	 * @return The new editor.
	 */
	public static Editor createEditor(Model model) {

		EList<Editor> editorTypes = MultiModelTypeRegistry.getModelTypeEditors(model.getMetatypeUri());
		if (editorTypes.size() != 0) {
			//TODO MMTF: prioritize editors list instead of running twice?
			//TODO MMTF: check if editor file really exists in model directory
			for (Editor editorType : editorTypes) {
				if (editorType instanceof Diagram) {
					return createEditor(editorType, model.getUri());
				}
			}
			for (Editor editorType : editorTypes) {
				return createEditor(editorType, model.getUri());
			}
		}

		return null;
	}

	/**
	 * Creates a new editor for a model.
	 * 
	 * @param editorType
	 *            The editor type.
	 * @param modelUri
	 *            The uri of the model.
	 * @return The new editor.
	 */
	public static Editor createEditor(Editor editorType, String modelUri) {

		Editor newEditor = (Editor) EditorFactory.eINSTANCE.create(editorType.eClass());
		String newEditorName = editorType.getName() + " for model " + modelUri;
		String newEditorUri = MultiModelRegistry.replaceFileExtensionInUri(modelUri, editorType.getFileExtensions().get(0));
		addBasicExtendibleElement(newEditor, editorType, newEditorUri, newEditorName);
		newEditor.setModelUri(modelUri);
		newEditor.setId(editorType.getId());
		newEditor.setWizardId(editorType.getWizardId());

		return newEditor;
	}

	/**
	 * Adds an editor to its model and to a multimodel.
	 * 
	 * @param editor
	 *            The editor.
	 * @param multiModel
	 *            The multimodel.
	 */
	public static void addModelEditor(Editor editor, MultiModel multiModel) {

		Model model = MultiModelRegistry.getExtendibleElement(multiModel, editor.getModelUri());
		if (model != null) {
			model.getEditors().add(editor);
			multiModel.getEditors().add(editor);
		}
	}

//	public static ModelRel copyModelRel(MultiModel multiModel, URI modelRelUri) throws Exception {
//
//		// this is needed to infer the model relationship class
//		ResourceSet set = new ResourceSetImpl();
//		Resource resource = set.getResource(modelRelUri, true);
//		EObject root = resource.getContents().get(0);
//		ModelRel modelRel = createModelRel(
//			((ModelRel) root).getMetatype(),
//			ModelOrigin.IMPORTED,
//			multiModel,
//			modelRelUri,
//			root.eClass()
//		);
//
//		// copy mapping structure
//		ModelRel origModelRel = (ModelRel) modelRel.getRoot();
//		modelRel.setName(origModelRel.getName());
//		HashMap<EObject, ModelElementReference> elementRefs = new HashMap<EObject, ModelElementReference>();
//		for (ModelReference origModelRef : origModelRel.getModelRefs()) {
//			Model origModel = (Model) origModelRef.getContainedObject();
//			URI modelUri = URI.createPlatformResourceURI(origModel.getUri(), true);
//			Model model = getModelUnique(multiModel, modelUri); // the model can already be in the MID
//			if (model == null) {
//				model = createModel(origModel.getMetatype(), ModelOrigin.IMPORTED, multiModel, modelUri);
//				model.setName(origModel.getName());
//				Editor editor = createEditor(model);
//				if (editor != null) {
//					addModelEditor(editor, multiModel);
//				}
//			}
//			modelRel.getModels().add(model);
//			ModelReference modelRef = createModelReference(modelRel, model);
//			for (ModelElementReference origElementRef : origModelRef.getElementRefs()) {
//				//TODO MMTF: fix and use something different than pointer as index
//				//ModelElementReference elementRef = createModelElementReference(modelRef, (origElementRef.getObject().getPointer());
//				//elementRefs.put(elementRef.getObject().getPointer(), elementRef);
//			}
//		}
//		for (Link origLink : origModelRel.getLinks()) {
//			Link link = createLink((Link) origLink.getMetatype(), modelRel, origLink.eClass());
//			link.setName(origLink.getName());
//			for (ModelElementReference origElementRef : origLink.getElementRefs()) {
//				link.getElementRefs().add(elementRefs.get(origElementRef.getObject().getPointer()));
//			}
//		}
//
//		return modelRel;
//	}

	private static ExtendibleElement removeExtendibleElement(MultiModel multiModel, String elementUri) {

		return multiModel.getExtendibleTable().removeKey(elementUri);
	}

	public static void removeModel(Model model) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(model);
		removeExtendibleElement(multiModel, model.getUri());
		multiModel.getModels().remove(model);

		//remove model elements
		for (ModelElement modelElem : model.getElements()) {
			removeExtendibleElement(multiModel, modelElem.getUri());
		}
		// remove editors
		for (Editor editor : model.getEditors()) {
			removeEditor(editor);
		}
		// remove model relationships and endpoints that use this model
		List<ModelRel> delModelRels = new ArrayList<ModelRel>();
		List<ModelEndpoint> delModelEndpoints = new ArrayList<ModelEndpoint>();
		for (ModelRel modelRel : MultiModelTypeRegistry.getModelRelTypes(multiModel)) {//TODO MMTF: put this function into the generic registry
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

	public static void removeModelRel(ModelRel modelRel) {

		removeModel(modelRel);
	}

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

	public static void removeLinkAndLinkReference(LinkReference linkRef) {

		ModelRel modelRel = (ModelRel) linkRef.eContainer();
		modelRel.getLinkRefs().remove(linkRef);
		for (ModelElementEndpointReference modelElemEndpointRef : linkRef.getModelElemEndpointRefs()) {
			modelElemEndpointRef.setModelElemRef(null);
		}
		modelRel.getLinks().remove(linkRef.getObject());
	}

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

	public static void removeModelElementReference(ModelElementReference modelElemRef) {

		List<LinkReference> delLinkRefs = new ArrayList<LinkReference>();
		for (ModelElementEndpointReference modelElemEndpointRef : modelElemRef.getModelElemEndpointRefs()) {
			LinkReference linkRef = (LinkReference) modelElemEndpointRef.eContainer();
			if (linkRef instanceof BinaryLinkReference) {
				if (!delLinkRefs.contains(linkRef)) {
					delLinkRefs.add(linkRef);
				}
			}
			else {
				removeModelElementEndpointAndModelElementEndpointReference(modelElemEndpointRef, true);
			}
		}
		for (LinkReference linkRef : delLinkRefs) {
			removeLinkAndLinkReference(linkRef);
		}

		((ModelEndpointReference) modelElemRef.eContainer()).getModelElemRefs().remove(modelElemRef);
	}

	public static void removeModelElementAndModelElementReference(ModelElementReference modelElemRef) {

		MultiModel multiModel = (MultiModel) modelElemRef.eContainer().eContainer().eContainer();
		removeExtendibleElement(multiModel, modelElemRef.getUri());
		removeModelElementReference(modelElemRef);
		ModelElement modelElem = modelElemRef.getObject();
		((Model) modelElem.eContainer()).getElements().remove(modelElem);
		//TODO MMTF: should remove from all model rels too?
	}

	public static void removeEditor(Editor editor) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(editor);
		multiModel.getEditors().remove(editor);
		// no need to removeExtendibleElement
	}

	public static ModelElement getModelElementUnique(MultiModel multiModel, URI modelElemUri) {

		ExtendibleElement modelElem = multiModel.getExtendibleTable().get(modelElemUri.toString().substring(18)); // strip "platform:/resource"
		if (modelElem != null && modelElem instanceof ModelElement) {
			return (ModelElement) modelElem;
		}

		return null;
	}

	public static ModelElement getModelElementUnique(Model model, URI modelElemUri) {

		String uri = modelElemUri.toString().substring(18); // strip "platform:/resource"
		for (ModelElement modelElem : model.getElements()) {
			if (uri.equals(modelElem.getUri())) {
				return modelElem;
			}
		}

		return null;
	}

}
