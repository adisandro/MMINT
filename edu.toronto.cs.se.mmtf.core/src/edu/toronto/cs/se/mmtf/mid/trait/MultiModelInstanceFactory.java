/*
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
package edu.toronto.cs.se.mmtf.mid.trait;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.MAVOModel;
import edu.toronto.cs.se.mmtf.mavo.trait.MAVOUtils;
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
 * 
 */
public class MultiModelInstanceFactory {

	private static void addExtendibleElement(ExtendibleElement newElement, ExtendibleElement elementType, MultiModel multiModel, String newElementUri, String newElementName) {

		newElement.setUri(newElementUri);
		newElement.setName(newElementName);
		newElement.setLevel(MidLevel.INSTANCES);
		newElement.setDynamic(true);
		newElement.setSupertype(null);
		if (elementType == null) { // get runtime metatype
			//TODO MMTF: which entry to use, the most specific (operators) or the most conservative (import model)?
			//TODO MMTF: now is the first == the most conservative
			//TODO MMTF: do I fix everything by just letting the user choose with a dialog?
			//TODO MMTF: actually it's kind of useless for rels/links, i should just set the root type, because at creation time it's hard for the ee to already have all connections
			EList<ExtendibleElement> runtimeTypes = MultiModelTypeIntrospection.getRuntimeTypes(newElement);
			newElement.setMetatypeUri(runtimeTypes.get(0).getUri());
		}
		else { // use static metatype
			newElement.setMetatypeUri(elementType.getUri());
		}
	}

	protected static void addExtendibleElementEndpoint(ExtendibleElementEndpoint newElementEndpoint, ExtendibleElement newElement) {

		newElementEndpoint.setTarget(newElement);
		newElementEndpoint.setLowerBound(1);
		newElementEndpoint.setUpperBound(1);
	}

	/**
	 * Adds an extendible element to a multimodel.
	 * 
	 * @param element
	 *            The extendible element to add.
	 * @param type
	 *            The extendible element's type.
	 * @param multiModel
	 *            The root multimodel (possibly null).
	 * @param elementUri
	 *            The uri of the extendible element to add (possibly null).
	 * @param name
	 *            The name of the extendible element.
	 */
	private static void addExtendibleElementOld(ExtendibleElement element, ExtendibleElement type, MultiModel multiModel, URI elementUri, String name) {

		//TODO MMTF: migrate everything to use the new one
		// uri
		String uri;
		if (elementUri == null) {
			elementUri = EcoreUtil.getURI(element);
			uri = elementUri.toPlatformString(true);
		}
		else {
			uri = (element instanceof ModelElement) ?
				elementUri.toString().substring(18) : // strip "platform:/resource"
				elementUri.toPlatformString(true);
			if (multiModel != null) {
				// excludes the extendible elements in a standalone model relationship
				multiModel.getExtendibleTable().put(uri, element);
			}
		}
		element.setUri(uri);

		// basic attributes
		element.setName(name);
		element.setLevel(MidLevel.INSTANCES);
		element.setDynamic(true);
		if (type == null) { // get runtime metatype
			//TODO MMTF: which entry to use, the most specific (operators) or the most conservative (import model)?
			//TODO MMTF: now is the first == the most conservative
			//TODO MMTF: do I fix everything by just letting the user choose with a dialog?
			//TODO MMTF: actually it's kind of useless for rels/links, i should just set the root type, because at creation time it's hard for the ee to already have all connections
			EList<ExtendibleElement> runtimeTypes = MultiModelTypeIntrospection.getRuntimeTypes(element);
			element.setMetatypeUri(runtimeTypes.get(0).getUri());
		}
		else { // use static metatype
			element.setMetatypeUri(type.getUri());
		}

		// supertype
		element.setSupertype(null);
	}

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
	 * Adds a model to a multimodel.
	 * 
	 * @param model
	 *            The model to add.
	 * @param modelType
	 *            The model type (null if type is decided at runtime).
	 * @param origin
	 *            The origin of the model.
	 * @param multiModel
	 *            The root multimodel (possibly null).
	 * @param modelUri
	 *            The uri of the model to add (possibly null).
	 */
	private static void addModel(Model model, Model modelType, ModelOrigin origin, MultiModel multiModel, URI modelUri) {

		String fileName, fileExtension;
		// model relationship
		if (modelUri == null) {
			fileName = null;
			fileExtension = null;
		}
		// model or standalone model relationship
		else {
			fileName = modelUri.lastSegment();
			fileName = fileName.substring(0, fileName.lastIndexOf('.'));
			fileExtension = modelUri.fileExtension();
		}

		// add to multimodel container
		if (multiModel != null) {
			multiModel.getModels().add(model);
		}
		addExtendibleElementOld(model, modelType, multiModel, modelUri, fileName);

		// set attributes
		model.setOrigin(origin);
		model.setFileExtension(fileExtension);
	}

	/**
	 * Creates and adds a model to a multimodel.
	 * 
	 * @param modelType
	 *            The model type.
	 * @param origin
	 *            The origin of the model.
	 * @param multiModel
	 *            The root multimodel, null if the root is a relationship.
	 * @param modelUri
	 *            The uri of the model to add.
	 * @return The model just created.
	 */
	public static Model createModel(Model modelType, ModelOrigin origin, MultiModel multiModel, URI modelUri) {

		Model model = MidFactory.eINSTANCE.createModel();
		addModel(model, modelType, origin, multiModel, modelUri);

		return model;
	}

	public static Model createModel(Model modelType, ModelOrigin origin, MultiModel multiModel, URI modelUri, boolean uselessFIXME) throws MMTFException {

		//TODO MMTF: rework a bit
		MultiModelInstanceFactory.assertModelUnique(multiModel, modelUri);
		Model newModel = createModel(modelType, origin, multiModel, modelUri);
		EObject modelRoot = newModel.getRoot();
		if (modelRoot instanceof MAVOModel) {
			newModel.setInc(((MAVOModel) modelRoot).isInc());
		}
		Editor newEditor = MultiModelInstanceFactory.createEditor(newModel);
		if (newEditor != null) {
			MultiModelInstanceFactory.addModelEditor(newEditor, multiModel);
		}

		return newModel;
	}

	public static ModelElementReference createModelElementAndModelElementReference(ModelEndpointReference modelEndpointRef, ModelElement modelElemType, String newModelElemUri, String newModelElemName, ModelElementCategory category, String classLiteral) {

		ModelRel modelRel = (ModelRel) modelEndpointRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRel.eContainer();

		//TODO MMTF: String newModelElemUri = newModelElemUri + MMTF.URI_SEPARATOR + classLiteral;
		ModelElement newModelElem = MultiModelTypeRegistry.getModelElementType(multiModel, newModelElemUri);
		if (newModelElem == null) {
			newModelElem = MidFactory.eINSTANCE.createModelElement();
			addExtendibleElement(newModelElem, modelElemType, multiModel, newModelElemUri, newModelElemName);
			newModelElem.setCategory(category);
			newModelElem.setClassLiteral(classLiteral);
			modelEndpointRef.getObject().getTarget().getElements().add(newModelElem);
		}
		ModelElementReference newModelElemRef = createModelElementReference(modelEndpointRef, newModelElem);

		return newModelElemRef;
	}

	public static ModelElementReference createModelElementAndModelElementReference(ModelEndpointReference modelEndpointRef, String newModelElemName, EObject modelEObject) {

		//TODO MMTF: this should check for an existing model element with same uri and return it instead of creating it (something like checkModelUnique)
		ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelEObject);
		ModelElementCategory category = MultiModelRegistry.getEObjectCategory(modelEObject);
		String newModelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelEObject, true)[1];
		String classLiteral = MultiModelRegistry.getEObjectClassLiteral(modelEObject, true);
		if (newModelElemName == null) {
			newModelElemName = MultiModelRegistry.getEObjectLabel(modelEObject, true);
		}
		ModelElementReference newModelElemRef = createModelElementAndModelElementReference(
			modelEndpointRef,
			modelElemType,
			newModelElemUri,
			newModelElemName,
			category,
			classLiteral
		);
		MAVOUtils.annotateMAVODroppedEObject(modelEObject, newModelElemRef);

		return newModelElemRef;
	}

	/**
	 * Creates and adds a model relationship to a multimodel.
	 * 
	 * @param modelType
	 *            The model relationship type.
	 * @param origin
	 *            The origin of the model relationships.
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelRelUri
	 *            The uri of the model relationship to add, null if not
	 *            imported.
	 * @param modelRelClass
	 *            The specific model relationship class.
	 * @return The model relationship just created.
	 */
	public static ModelRel createModelRel(ModelRel modelRelType, MultiModel multiModel, ModelOrigin origin, URI modelRelUri, EClass modelRelClass) {

		ModelRel modelRel = (ModelRel) RelationshipFactory.eINSTANCE.create(modelRelClass);
		addModel(modelRel, modelRelType, origin, multiModel, modelRelUri);

		return modelRel;
	}

	public static ModelRel createModelRelAndModelEndpointsAndModelEndpointReferences(ModelRel modelRelType, ModelOrigin origin, URI modelRelUri, EClass modelRelClass, Model... models) {

		if (models.length == 0) {
			return null;
		}

		MultiModel multiModel = (MultiModel) models[0].eContainer();
		// create model rel
		ModelRel newModelRel = MultiModelInstanceFactory.createModelRel(
			modelRelType,
			multiModel,
			origin,
			modelRelUri,
			modelRelClass
		);
		// create model rel endpoints
		for (Model model : models) {
			MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
				null,
				newModelRel,
				model,
				false
			);
		}

		return newModelRel;
	}

	/**
	 * Creates and adds a model and model reference to a model relationship.
	 * 
	 * @param modelRel
	 *            The model relationship.
	 * @param newModel
	 *            The model that corresponds to the model reference.
	 * @return The model reference just created.
	 */
	public static ModelEndpointReference createModelEndpointAndModelEndpointReference(ModelEndpoint modelTypeEndpoint, ModelRel modelRel, Model newModel, boolean isBinarySrc) {

		ModelEndpoint newModelEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		MultiModel multiModel = (MultiModel) modelRel.eContainer();
		addExtendibleElement(newModelEndpoint, modelTypeEndpoint, multiModel, null, null);
		addExtendibleElementEndpoint(newModelEndpoint, newModel);
		if (isBinarySrc) {
			modelRel.getModelEndpoints().add(0, newModelEndpoint);
		}
		else {
			modelRel.getModelEndpoints().add(newModelEndpoint);
		}
		newModelEndpoint.setName(newModel.getName());
		ModelEndpointReference modelEndpointRef = createModelEndpointReference(modelRel, newModelEndpoint, isBinarySrc);

		return modelEndpointRef;
	}

	public static void replaceModelEndpointAndModelEndpointReference(ModelEndpoint oldModelEndpoint, ModelEndpoint modelTypeEndpoint, ModelRel modelRel, Model newModel) {

		MultiModel multiModel = (MultiModel) modelRel.eContainer();
		addExtendibleElement(oldModelEndpoint, modelTypeEndpoint, multiModel, null, null);
		oldModelEndpoint.setTarget(newModel);
	}

	/**
	 * Creates and adds a model reference to a model relationship.
	 * 
	 * @param modelRel
	 *            The model relationship.
	 * @param model
	 *            The model that corresponds to the model reference.
	 * @return The model reference just created.
	 */
	public static ModelEndpointReference createModelEndpointReference(ModelRel modelRel, ModelEndpoint newModelEndpoint, boolean isBinarySrc) {

		ModelEndpointReference newModelEndpointRef = RelationshipFactory.eINSTANCE.createModelEndpointReference();
		boolean isContainer = modelRel.eContainer() == null;
		addExtendibleElementReference(newModelEndpointRef, newModelEndpoint, isContainer);

		if (isBinarySrc) {
			modelRel.getModelEndpointRefs().add(0, newModelEndpointRef);
		} 
		else {
			modelRel.getModelEndpointRefs().add(newModelEndpointRef);
		}

		return newModelEndpointRef;
	}

	private static ModelElementReference createModelElementReference(ModelEndpointReference modelEndpointRef, ModelElement modelElem) {

		ModelElementReference modelElemRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		addExtendibleElementReference(modelElemRef, modelElem, false);
		modelEndpointRef.getModelElemRefs().add(modelElemRef);

		return modelElemRef;
	}

	/**
	 * Creates and adds a link to a model relationship.
	 * 
	 * @param modelRel
	 *            The model relationship.
	 * @param linkClass
	 *            The specific link class.
	 * @return The link just created.
	 */
	public static LinkReference createLinkAndLinkReference(Link linkType, ModelRel modelRel, EClass linkClass, EClass linkRefClass) {

		Link link = (Link) RelationshipFactory.eINSTANCE.create(linkClass);
		modelRel.getLinks().add(link);
		addExtendibleElementOld(link, linkType, null, null, null);
		LinkReference newLinkRef = createLinkReference(modelRel, link, linkRefClass);

		return newLinkRef;
	}

	public static LinkReference createLinkReference(ModelRel modelRel, Link link, EClass linkRefClass) {

		LinkReference linkRef = (LinkReference) RelationshipFactory.eINSTANCE.create(linkRefClass);
		addExtendibleElementReference(linkRef, link, false);
		modelRel.getLinkRefs().add(linkRef);

		return linkRef;
	}

	public static LinkReference createLinkAndLinkReferenceAndModelElementEndpointsAndModelElementEndpointReferences(Link linkType, EClass linkClass, EClass linkRefClass, ModelElementReference... modelElemRefs) {

		if (modelElemRefs.length == 0) {
			return null;
		}

		ModelRel modelRel = (ModelRel) modelElemRefs[0].eContainer().eContainer();
		// create link
		LinkReference newLinkRef = MultiModelInstanceFactory.createLinkAndLinkReference(
			linkType,
			modelRel,
			linkClass,
			linkRefClass
		);
		// create model element endpoints
		for (ModelElementReference modelElemRef : modelElemRefs) {
			ModelElementEndpointReference newModelElemEndpointRef = MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
				null,
				newLinkRef,
				modelElemRef,
				false
			);
			newModelElemEndpointRef.getObject().setName(modelElemRef.getObject().getName());
		}

		return newLinkRef;
	}

	public static ModelElementEndpointReference createModelElementEndpointAndModelElementEndpointReference(ModelElementEndpoint modelElemTypeEndpoint, LinkReference linkRef, ModelElementReference newModelElemRef, boolean isBinarySrc) {

		ModelElementEndpoint newModelElemEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		MultiModel multiModel = (MultiModel) linkRef.eContainer().eContainer();
		addExtendibleElement(newModelElemEndpoint, modelElemTypeEndpoint, multiModel, null, null);
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

	public static void replaceModelElementEndpointAndModelElementEndpointReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementEndpoint modelElemTypeEndpoint, LinkReference linkRef, ModelElementReference newModelElemRef) {

		MultiModel multiModel = (MultiModel) linkRef.eContainer().eContainer();
		ModelElementEndpoint oldModelElemEndpoint = oldModelElemEndpointRef.getObject();
		addExtendibleElement(oldModelElemEndpoint, modelElemTypeEndpoint, multiModel, null, null);
		oldModelElemEndpoint.setTarget(newModelElemRef.getObject());
		oldModelElemEndpointRef.setModelElemRef(newModelElemRef);
	}

	/**
	 * Creates an editor for a model.
	 * 
	 * @param model
	 *            The model.
	 * @return The editor just created.
	 */
	public static Editor createEditor(Model model) {

		URI modelUri = URI.createPlatformResourceURI(model.getUri(), true);
		EList<Editor> editorTypes = MultiModelTypeRegistry.getModelTypeEditors(model.getMetatypeUri());
		if (editorTypes.size() != 0) {
			//TODO MMTF: prioritize editors list instead of running twice
			//TODO MMTF: check if editor file really exists in model directory
			for (Editor editorType : editorTypes) {
				if (editorType instanceof Diagram) {
					return createEditor(editorType, modelUri);
				}
			}
			for (Editor editorType : editorTypes) {
				return createEditor(editorType, modelUri);
			}
		}

		return null;
	}

	/**
	 * Creates an editor for a model.
	 * 
	 * @param editorType
	 *            The editor type.
	 * @param modelUri
	 *            The uri of the model that will use the editor.
	 * @return The editor just created.
	 */
	public static Editor createEditor(Editor editorType, URI modelUri) {

		Editor editor = (Editor) EditorFactory.eINSTANCE.create(editorType.eClass());
		String editorName = editorType.getName() + " for model " + modelUri;
		String stringModelUri = modelUri.toPlatformString(true);
		URI editorUri = URI.createPlatformResourceURI(
			stringModelUri.substring(0, stringModelUri.lastIndexOf('.')+1) + editorType.getFileExtensions().get(0),
			true
			//TODO MMTF: metatypeuri here
		);
		addExtendibleElementOld(editor, editorType, null, editorUri, editorName);

		editor.setModelUri(stringModelUri);
		editor.setId(editorType.getId());
		editor.setWizardId(editorType.getWizardId());

		return editor;
	}

	/**
	 * Adds an editor to a model.
	 * 
	 * @param editor
	 *            The editor.
	 * @param multiModel
	 *            The root multimodel.
	 */
	public static void addModelEditor(Editor editor, MultiModel multiModel) {

		ExtendibleElement model = multiModel.getExtendibleTable().get(editor.getModelUri());
		if (model != null && model instanceof Model) {
			((Model) model).getEditors().add(editor);
			multiModel.getEditors().add(editor);
		}
	}

	/**
	 * Creates and adds a copy of a model relationship to a multimodel.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelRelUri
	 *            The uri of the original model relationship.
	 * @return The model relationship just created.
	 * @throws Exception
	 *             If the resource pointed by the modelRelUri could not be get.
	 */
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

	/**
	 * Removes a model from a multimodel.
	 * 
	 * @param model
	 *            The model to be removed.
	 */
	public static void removeModel(Model model) {

		MultiModel multiModel = (MultiModel) model.eContainer();
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
		ArrayList<ModelRel> delModelRels = new ArrayList<ModelRel>();
		ArrayList<ModelEndpoint> delModelEndpoints = new ArrayList<ModelEndpoint>();
		for (ModelRel modelRel : MultiModelTypeRegistry.getModelRelTypes(multiModel)) {//TODO MMTF: put this function into the generic registry
			for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
				if (modelEndpoint.getTargetUri().equals(model.getUri())) {
					if (modelRel instanceof BinaryModelRel) {
						delModelRels.add(modelRel);
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

	/**
	 * Removes a model reference from a model relationship.
	 * 
	 * @param modelRel
	 *            The model relationship.
	 * @param model
	 *            The model to be removed, referenced by the model reference.
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

		// TODO MMTF: For binary links, we need to remove the links (and thus the setting of 
		//			  the ModelEndpointRefs to null) outside of the for loop
		EList<LinkReference> linksToBeRemoved = new BasicEList<LinkReference>();
		
		for (ModelElementEndpointReference modelElemEndpointRef : modelElemRef.getModelElemEndpointRefs()) {
			LinkReference linkRef = (LinkReference) modelElemEndpointRef.eContainer();
			if (linkRef instanceof BinaryLinkReference) {
				linksToBeRemoved.add(linkRef);
			}
			else {
				removeModelElementEndpointAndModelElementEndpointReference(modelElemEndpointRef, true);
			}
		}
		
		for (LinkReference linkRef : linksToBeRemoved) {
			removeLinkAndLinkReference(linkRef);
		}
		
		((ModelEndpointReference) modelElemRef.eContainer()).getModelElemRefs().remove(modelElemRef);
	}

	public static void removeModelElementAndModelElementReference(ModelElementReference modelElemRef) {

		removeModelElementReference(modelElemRef);
		ModelElement modelElem = modelElemRef.getObject();
		((Model) modelElem.eContainer()).getElements().remove(modelElem);
		//TODO MMTF: should remove from all model rels too?
	}

	/**
	 * Removes an editor from a multimodel.
	 * 
	 * @param editor
	 *            The editor to be removed.
	 */
	public static void removeEditor(Editor editor) {

		MultiModel multiModel = (MultiModel) editor.eContainer();
		multiModel.getEditors().remove(editor);
	}

	/**
	 * Checks the uniqueness of a model in a MID.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelUri
	 *            The uri of the model to be checked.
	 * @return Null if the model is unique, the model already in the MID
	 *         otherwise.
	 */
	public static Model getModelUnique(MultiModel multiModel, URI modelUri) {

		ExtendibleElement model = multiModel.getExtendibleTable().get(modelUri.toPlatformString(true));
		if (model != null && model instanceof Model) {
			return (Model) model;
		}

		return null;
	}

	public static ModelElement getModelElementUnique(MultiModel multiModel, URI modelElemUri) {

		ExtendibleElement modelElem = multiModel.getExtendibleTable().get(modelElemUri.toString().substring(18)); // strip "platform:/resource"
		if (modelElem != null && modelElem instanceof ModelElement) {
			return (ModelElement) modelElem;
		}

		return null;
	}

	/**
	 * Checks the uniqueness of a model in a Relationship diagram.
	 * 
	 * @param modelRel
	 *            The root model relationship.
	 * @param modelUri
	 *            The uri of the model to be checked.
	 * @return Null if the model is unique, the model already in the MID
	 *         otherwise.
	 */
	public static Model getModelUnique(ModelRel modelRel, URI modelUri) {

		String uri = modelUri.toPlatformString(true);
		for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
			if (uri.equals(modelEndpoint.getTargetUri())) {
				return modelEndpoint.getTarget();
			}
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

	/**
	 * Checks the uniqueness of a model in a MID.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelUri
	 *            The uri of the model to be checked.
	 * @return True if the model is unique.
	 * @throws MMTFException
	 *             If the model is not unique.
	 */
	public static boolean assertModelUnique(MultiModel multiModel, URI modelUri) throws MMTFException {

		if (getModelUnique(multiModel, modelUri) != null) {
			throw new MMTFException("Model " + modelUri + " is already in the diagram");
		}

		return true;
	}

	/**
	 * Checks the uniqueness of a model in a Relationship diagram.
	 * 
	 * @param modelRel
	 *            The root model relationship.
	 * @param modelUri
	 *            The uri of the model to be checked.
	 * @return True if the model is unique.
	 * @throws MMTFException
	 *             If the model is not unique.
	 */
	public static boolean assertModelUnique(ModelRel modelRel, URI modelUri) throws MMTFException {

		if (getModelUnique(modelRel, modelUri) != null) {
			throw new MMTFException("Model " + modelUri + " is already in the diagram");
		}

		return true;
	}

}
