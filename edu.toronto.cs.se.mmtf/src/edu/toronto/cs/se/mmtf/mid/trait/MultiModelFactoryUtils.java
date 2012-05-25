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
package edu.toronto.cs.se.mmtf.mid.trait;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Diagram;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * A container for common functions of a mid/mapping model.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelFactoryUtils {

	/**
	 * Adds an extendible element to a multimodel.
	 * 
	 * @param element
	 *            The extendible element to add.
	 * @param multiModel
	 *            The root multimodel (possibly null).
	 * @param elementUri
	 *            The uri of the extendible element to add (possibly null).
	 * @param name
	 *            The name of the extendible element.
	 */
	private static void addExtendibleElement(ExtendibleElement element, MultiModel multiModel, URI elementUri, String name) {

		// uri
		if (elementUri == null) {
			elementUri = EcoreUtil.getURI(element);
		}
		else if (multiModel != null) {
			// only models get added to the table, excluding the ones in a standalone model relationship
			//TODO MMTF: check also standalone modelrel when they get imported
			multiModel.getExtendibleTable().put(elementUri.toPlatformString(true), element);
		}
		element.setUri(elementUri.toPlatformString(true));

		// basic attributes
		element.setName(name);
		element.setLevel(MidLevel.INSTANCES);

		// supertype
		element.setSupertype(null);
	}

	/**
	 * Adds a model to a multimodel.
	 * 
	 * @param model
	 *            The model to add.
	 * @param origin
	 *            The origin of the model.
	 * @param multiModel
	 *            The root multimodel (possibly null).
	 * @param modelUri
	 *            The uri of the model to add (possibly null).
	 * @throws Exception
	 *             If the resource pointed by the model uri could not be get.
	 */
	private static void addModel(Model model, ModelOrigin origin, MultiModel multiModel, URI modelUri) throws Exception {

		// possibly raise exceptions as first thing
		EObject root;
		String fileName, fileExtension;
		if (modelUri == null) { // model relationship
			root = model;
			fileName = null;
			fileExtension = null;
		}
		else { // model or standalone model relationship
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(modelUri, true);
			root = resource.getContents().get(0);
			fileName = modelUri.lastSegment();
			fileName = fileName.substring(0, fileName.lastIndexOf('.'));
			fileExtension = modelUri.fileExtension();
		}

		// add to multimodel container
		if (multiModel != null) {
			multiModel.getModels().add(model);
		}
		addExtendibleElement(model, multiModel, modelUri, fileName);

		// set attributes
		model.setOrigin(origin);
		model.setRoot(root);
		model.setFileExtension(fileExtension);
	}

	/**
	 * Creates and adds a model to a multimodel.
	 * 
	 * @param origin
	 *            The origin of the model.
	 * @param multiModel
	 *            The root multimodel, null if the root is a relationship.
	 * @param modelUri
	 *            The uri of the model to add.
	 * @return The model just created.
	 * @throws Exception
	 *             If the resource pointed by the model uri could not be get.
	 */
	public static Model createModel(ModelOrigin origin, MultiModel multiModel, URI modelUri) throws Exception {

		Model model = MidFactory.eINSTANCE.createModel();
		addModel(model, origin, multiModel, modelUri);

		return model;
	}

	/**
	 * Creates and adds a model relationship to a multimodel.
	 * 
	 * @param origin
	 *            The origin of the model relationships.
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelRelUri
	 *            The uri of the model relationship to add, null if not
	 *            imported.
	 * @param modelRelType
	 *            The specific model relationship class type.
	 * @return The model relationship just created.
	 * @throws Exception
	 *             If the resource pointed by the model relationship uri could
	 *             not be get.
	 */
	public static ModelRel createModelRel(ModelOrigin origin, MultiModel multiModel, URI modelRelUri, EClass modelRelType) throws Exception {

		ModelRel modelRel = (ModelRel) RelationshipFactory.eINSTANCE.create(modelRelType);
		addModel(modelRel, origin, multiModel, modelRelUri);
		modelRel.setUnbounded(false);

		return modelRel;
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
	public static ModelReference createModelReference(ModelRel modelRel, Model model) {

		ModelReference modelRef = RelationshipFactory.eINSTANCE.createModelReference();
		if (modelRel.eContainer() == null) { // standalone model relationship
			modelRef.setContainedObject(model);
		}
		else {
			modelRef.setReferencedObject(model);
		}
		modelRel.getModelRefs().add(modelRef);

		return modelRef;
	}

	/**
	 * Creates and adds a model element reference to a model reference.
	 * 
	 * @param modelRef
	 *            The model reference.
	 * @param elementPointer
	 *            The pointer to the real model element.
	 * @return The model element reference just created.
	 */
	public static ModelElementReference createModelElementReference(ModelReference modelRef, EObject elementPointer) {

		// create model element (duplicates are avoided by dnd policy)
		ModelElement modelElem = MidFactory.eINSTANCE.createModelElement();
		ModelElementCategory category = (elementPointer instanceof EReference) ?
			ModelElementCategory.RELATIONSHIP :
			ModelElementCategory.ENTITY;
		modelElem.setCategory(category);
		modelElem.setPointer(elementPointer);
		ItemProviderAdapter itemAdapter = null;
		for (Adapter adapter : elementPointer.eAdapters()) {
			if (adapter instanceof ItemProviderAdapter) {
				itemAdapter = (ItemProviderAdapter) adapter;
				break;
			}
		}
		String name = (itemAdapter == null) ? "" : itemAdapter.getText(elementPointer);
		((Model) modelRef.getObject()).getElements().add(modelElem);
		addExtendibleElement(modelElem, null, null, name);

		// create model element reference
		ModelElementReference modelElemRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		if (modelRef.eContainer().eContainer() == null) { // standalone model relationship
			modelElemRef.setContainedObject(modelElem);
		}
		else {
			modelElemRef.setReferencedObject(modelElem);
		}
		modelRef.getElementRefs().add(modelElemRef);

		return modelElemRef;
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
		EList<Editor> editorTypes = MMTFRegistry.getEditorsForModelType(
			((ExtendibleElement) model.getMetatype()).getUri()
		);
		if (editorTypes.size() != 0) {
			//TODO MMTF: prioritize editors list
			for (Editor editorType : editorTypes) {
				//TODO MMTF: check if editor file really exists in model directory
				if (editorType instanceof Diagram) {
					return createEditor(editorType, modelUri);
				}
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
		);
		addExtendibleElement(editor, null, editorUri, editorName);

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
	 *             If the resources pointed by the various uris could not be
	 *             get.
	 */
	public static ModelRel copyModelRel(MultiModel multiModel, URI modelRelUri) throws Exception {

		// this duplicate code is needed to infer the model relationship class
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(modelRelUri, true);
		EObject root = resource.getContents().get(0);
		ModelRel modelRel = createModelRel(
			ModelOrigin.IMPORTED,
			multiModel,
			modelRelUri,
			root.eClass()
		);

		// copy mapping structure
		ModelRel origModelRel = (ModelRel) modelRel.getRoot();
		HashMap<EObject, ModelElementReference> elementRefs = new HashMap<EObject, ModelElementReference>();
		for (ModelReference origModelRef : origModelRel.getModelRefs()) {
			URI modelUri = URI.createPlatformResourceURI(((Model) origModelRef.getContainedObject()).getUri(), true);
			Model model = getModelUnique(multiModel, modelUri); // the model can already be in the MID
			if (model == null) {
				model = createModel(ModelOrigin.IMPORTED, multiModel, modelUri);
			}
			modelRel.getModels().add(model);
			ModelReference modelRef = createModelReference(modelRel, model);
			for (ModelElementReference origElementRef : origModelRef.getElementRefs()) {
//				ModelElementReference elementRef = createModelElementReference(modelRef, origElementRef.getPointer());
//				elementRef.setName(origElement.getName());
//				elementRefs.put(elementRef.getPointer(), elementRef);
				//TODO MMTF: fix when createModelElementReference is finalized
			}
		}
		for (Link origLink : origModelRel.getLinks()) {
			Link link = (Link) RelationshipFactory.eINSTANCE.create(origLink.eClass());
			link.setName(origLink.getName());
			modelRel.getLinks().add(link);
			for (ModelElementReference origElementRef : origLink.getElementRefs()) {
//				link.getElementRefs().add(elementRefs.get(origElementRef.getPointer()));
			}
		}

		return modelRel;
	}

	/**
	 * Removes a model from a multimodel.
	 * 
	 * @param model
	 *            The model to be removed.
	 */
	public static void removeModel(Model model) {

		MultiModel multiModel = (MultiModel) model.eContainer();
		multiModel.getExtendibleTable().removeKey(model.getUri());
		for (Editor editor : model.getEditors()) {
			removeEditor(editor);
		}
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
	 * Removes a model reference from a model relationship.
	 * 
	 * @param modelRel
	 *            The model relationship.
	 * @param model
	 *            The model to be removed, referenced by the model reference.
	 */
	public static void removeModelReference(ModelRel modelRel, Model model) {

		for (ModelReference modelRef : modelRel.getModelRefs()) {
			if (modelRef.getObject() == model) {
				modelRel.getModelRefs().remove(modelRef);
				ArrayList<Link> delLinks = new ArrayList<Link>();
				for (ModelElementReference elementRef : modelRef.getElementRefs()) {
					for (Link link : elementRef.getLinks()) {
						// binary links have no longer sense, delete them later to avoid concurrent modification problems
						if (link instanceof BinaryLink) {
							delLinks.add(link);
						}
					}
					elementRef.getLinks().clear();
				}
				for (Link delLink : delLinks) {
					delLink.getElementRefs().clear();
					modelRel.getLinks().remove(delLink);
				}
				break;
			}
		}
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
		else {
			return null;
		}
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

		for (Model model : modelRel.getModels()) {
			if (modelUri.equals(model.getUri())) {
				return model;
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
