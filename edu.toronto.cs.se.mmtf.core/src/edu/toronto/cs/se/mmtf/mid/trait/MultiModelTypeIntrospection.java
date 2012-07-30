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

import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;

/**
 * The type introspection engine for multimodels.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeIntrospection implements MMTFExtensionPoints {

	private static EList<ExtendibleElement> getRuntimeTypes(Model model) {

		EList<ExtendibleElement> types = new BasicEList<ExtendibleElement>();

		// static type
		Model staticModelType;
		String staticModelTypeUri = model.getMetatypeUri();
		if (staticModelTypeUri == null) {
			// this means getRuntimeTypes itself is used to set the initial static metatype
			staticModelTypeUri = model.getRoot().eClass().getEPackage().getNsURI();
			staticModelType = MultiModelTypeRegistry.getModelType(staticModelTypeUri);
		}
		else {
			staticModelType = model.getMetatype();
		}

		// fallback to root type
		if (staticModelType == null) {
			staticModelTypeUri = ROOT_MODEL_URI;
			staticModelType = MultiModelTypeRegistry.getModelType(ROOT_MODEL_URI);
		}

		// init
		types.add(staticModelType);

		// explore light model types
		for (Model lightModelSubtype : MultiModelTypeRegistry.getModelTypes()) {

			if (lightModelSubtype instanceof ModelRel) {
				continue;
			}

			// light model subtype
			if (lightModelSubtype.getConstraint() != null && MultiModelTypeRegistry.isSubtypeOf(lightModelSubtype.getUri(), staticModelTypeUri)) {
				if (MultiModelConstraintChecker.checkOCLConstraint(model, lightModelSubtype.getConstraint().getBody())) {
					types.add(lightModelSubtype);
				}
			}
		}

		return types;
	}

	private static EList<ExtendibleElement> getRuntimeTypes(ModelRel modelRel) {

		EList<ExtendibleElement> types = new BasicEList<ExtendibleElement>();

		// static type
		ModelRel staticModelRelType;
		String staticModelRelTypeUri = modelRel.getMetatypeUri();
		if (staticModelRelTypeUri == null) {
			// this means getRuntimeTypes itself is used to set the initial static metatype
			staticModelRelType = null;
		}
		else {
			staticModelRelType = modelRel.getMetatype();
		}

		// fallback to root type
		if (staticModelRelType == null) {
			staticModelRelTypeUri = ROOT_MODELREL_URI;
			staticModelRelType = MultiModelTypeRegistry.getModelRelType(ROOT_MODELREL_URI);
		}

		// init
		types.add(staticModelRelType);

		// not specialized yet
		if (modelRel.getModels().size() == 0) {
			for (ModelRel modelRelType : MultiModelTypeRegistry.getModelRelTypes()) {
				if (MultiModelTypeRegistry.isSubtypeOf(modelRelType.getUri(), staticModelRelTypeUri)) {
					types.add(modelRelType);
				}
			}
			return types;
		}

		// explore model endpoints
modelRelTypes:
		for (ModelRel modelRelSubtype : MultiModelTypeRegistry.getModelRelTypes()) {

			// only subtypes
			if (!MultiModelTypeRegistry.isSubtypeOf(modelRelSubtype.getUri(), staticModelRelTypeUri)) {
				continue;
			}

			// check cardinality
			if (!(modelRelSubtype.isUnbounded() || modelRelSubtype.getModels().size() == modelRel.getModels().size())) {
				continue;
			}

			// unbounded case
			if (modelRelSubtype.isUnbounded()) {
				HashSet<String> allowedModelTypes = new HashSet<String>();
				for (Model modelType : modelRelSubtype.getModels()) {
					allowedModelTypes.add(modelType.getUri());
				}
				for (Model model : modelRel.getModels()) {
					if (allowedModelTypes.contains(model.getMetatypeUri())) {
						continue;
					}
					boolean okModel = false;
					for (String modelSupertypeUri : MultiModelTypeRegistry.getSupertypeUris(model.getMetatypeUri())) {
						if (allowedModelTypes.contains(modelSupertypeUri)) {
							okModel = true;
							break;
						}
					}
					if (!okModel) {
						continue modelRelTypes;
					}
				}

				// light model relationship subtype
				if (modelRelSubtype.getConstraint() != null) {
					if (!MultiModelConstraintChecker.checkOCLConstraint(modelRel, modelRelSubtype.getConstraint().getBody())) {
						continue modelRelTypes;
					}
				}

				types.add(modelRelSubtype);
			}

			//TODO MMTF: continue with other cases (not easy matching models when the number of endpoints is fixed)
		}

		return types;
	}

	//TODO MMTF: not needed if specialization is not allowed
	private static EList<ExtendibleElement> getRuntimeTypes(ModelElement modelElem) {

		//TODO MMTF: implementare
		EList<ExtendibleElement> types = new BasicEList<ExtendibleElement>();

		ModelElement staticElementType;
		String elementTypeUri = modelElem.getMetatypeUri();
		if (elementTypeUri == null) { // this means getRuntimeTypes itself is used to set the initial static metatype
			//TODO passo il model che lo contiene, e in base al type del pointer capisco che oggetto è, non vedo altri modi
			//TODO ma questo non deve essere limitato al tipo di model rel che lo contiene stracazzo? e lo stesso elemento può essere puntato da differenti modelrel, aiuto?
			//TODO beh ne posso sempre aggiungere due al modello, puntano allo stesso oggetto ma hanno tipo diverso..sì e uri a livello INSTANCES? suffisso con /classLiteral
			//TODO tutto ok alla grande sto ragionamento, ma vuol semplicemente dire che qua elementTypeUri DEVE essere settato
			//staticElementType = 
		}
		else {
			staticElementType = modelElem.getMetatype();
		}

		// fallback to root type
		if (modelElem.getCategory() == ModelElementCategory.ENTITY) {
			types.add(MultiModelTypeRegistry.getExtendibleType(ROOT_MODELELEMENT_ENTITY_URI));
		}
		else {
			types.add(MultiModelTypeRegistry.getExtendibleType(ROOT_MODELELEMENT_RELATIONSHIP_URI));
		}

		return types;
	}

	//TODO MMTF: not needed if specialization is not allowed
	private static EList<ExtendibleElement> getRuntimeTypes(Link link) {

		EList<ExtendibleElement> types = new BasicEList<ExtendibleElement>();
		ModelRel modelRel = (ModelRel) link.eContainer();

		// not specialized yet
		if (link.getElementRefs().size() == 0) {
			types.addAll(MultiModelTypeRegistry.getLinkTypes(modelRel.getMetatype()));
			return types;
		}

linkTypes:
		for (Link linkType : MultiModelTypeRegistry.getLinkTypes(modelRel.getMetatype())) {

			// check cardinality
			if (!(linkType.isUnbounded() || linkType.getElementRefs().size() == link.getElementRefs().size())) {
				continue;
			}

			// unbounded case
			if (linkType.isUnbounded()) {
				HashSet<String> allowedElements = new HashSet<String>();
				for (ModelElementReference elementRef : linkType.getElementRefs()) {
					ModelElement element = (ModelElement) elementRef.getObject();
					allowedElements.add(element.getUri());
				}
				for (ModelElementReference elementRef : link.getElementRefs()) {
					ModelElement element = (ModelElement) elementRef.getObject();
					String elementTypeUri = element.getMetatypeUri();
					if (!allowedElements.contains(elementTypeUri)) {
						continue linkTypes;
					}
				}
				types.add(linkType);
			}

			//TODO MMTF: continue with other cases
		}

		// fallback to root type
		if (types.isEmpty()) {
			types.add(MultiModelTypeRegistry.getExtendibleType(ROOT_MODELREL_LINK_URI));
		}

		return types;
	}

	private static EList<ExtendibleElement> getRuntimeTypes(Editor editor) {

		EList<ExtendibleElement> types = new BasicEList<ExtendibleElement>();

		//TODO MMTF: fallback to root text editor?
		types.add(MultiModelTypeRegistry.getExtendibleType(editor.getUri()));

		return types;
	}

	public static EList<ExtendibleElement> getRuntimeTypes(ExtendibleElement element) {

		if (element.getLevel() == MidLevel.TYPES) {
			return null;
		}

		if (element instanceof Link) {
			return getRuntimeTypes((Link) element);
		}
		if (element instanceof ModelElement) {
			return getRuntimeTypes((ModelElement) element);
		}
		if (element instanceof ModelRel) {
			return getRuntimeTypes((ModelRel) element);
		}
		if (element instanceof Model) {
			return getRuntimeTypes((Model) element);
		}
		if (element instanceof Editor) {
			return getRuntimeTypes((Editor) element);
		}
		return null;
	}

	public static ExtendibleElement getType(ExtendibleElement element) {

		if (element.getLevel() == MidLevel.TYPES) {
			return null;
		}

		ExtendibleElement type = MultiModelTypeRegistry.getExtendibleType(element.getMetatypeUri());
		if (type == null) { // this can happen when a type is uninstalled
			//TODO MMTF: find a way to try with runtime type in this read transaction?
			//element.setMetatypeUri(null);
			//type = getRuntimeTypes(element);
		}

		return type;
	}

	public static EObject getRoot(URI uri) throws Exception {

		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(uri, true);
		EObject root = resource.getContents().get(0);

		return root;
	}

	public static EObject getRoot(String uri) throws Exception {

		URI emfUri = URI.createPlatformResourceURI(uri, true);

		return getRoot(emfUri);
	}

	public static EObject getRoot(Model model) {

		String uri = model.getUri();
		EObject root;

		try {
			if (model.getLevel() == MidLevel.TYPES) {
				// climb up light types
				while (model.getConstraint() != null) {
					model = model.getSupertype();
					uri = model.getUri();
				}
				root = EPackage.Registry.INSTANCE.getEPackage(uri);
				if (root == null) {
					throw new MMTFException("EPackage for URI " + uri + " is not registered");
				}
			}
			else {
				if (model instanceof ModelRel) {
					//TODO MMTF: fix this ugly hack
					ModelRel modelRel = (ModelRel) model;
					if (modelRel.getModels().size() > 0) {
						return modelRel.getModels().get(modelRel.getModels().size()-1).getRoot();
					}
					else {
						return model;
					}
				}
				root = getRoot(uri);
			}

			return root;
		}
		catch (Exception e) {

			MMTFException.print(MMTFException.Type.WARNING, "Error getting root for model " + uri, e);
			return null;
		}
	}

	private static EObject getPointer(String uri) throws Exception {

		URI emfUri = URI.createURI(uri, false, URI.FRAGMENT_LAST_SEPARATOR);

		return getRoot(emfUri);
	}

	public static EObject getPointer(ModelElement modelElem) {

		Model model = (Model) modelElem.eContainer();
		EObject pointer = null;

		try {
			if (modelElem.getLevel() == MidLevel.TYPES) {
				while (pointer == null && model != null) {
					pointer = MultiModelTypeRegistry.getModelTypeMetamodelElement(
						model,
						modelElem.getClassLiteral()
					);
					model = model.getSupertype();
				}
			}
			else {
				//TODO MMTF: do I need to get the model first, and then the fragment, or can I get it at once? need to try
				pointer = getPointer(modelElem.getUri());
			}

			return pointer;
		}
		catch (Exception e) {

			MMTFException.print(MMTFException.Type.WARNING, "Error getting pointer for model element " + modelElem.getUri(), e);
			return null;
		}
	}

}
