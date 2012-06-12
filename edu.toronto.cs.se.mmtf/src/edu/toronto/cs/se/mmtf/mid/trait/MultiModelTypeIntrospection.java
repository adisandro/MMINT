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
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.TypedElement;
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

	private static EList<TypedElement> getRuntimeTypes(Model model) {

		EList<TypedElement> types = new BasicEList<TypedElement>();

		// static type
		Model staticModelType;
		String staticModelTypeUri = model.getMetatypeUri();
		if (staticModelTypeUri == null) {
			// this means getRuntimeTypes itself is used to set the initial static metatype
			staticModelTypeUri = model.getRoot().eClass().getEPackage().getNsURI();
			staticModelType = MMTFRegistry.getModelType(staticModelTypeUri);
		}
		else {
			staticModelType = (Model) model.getMetatype();
		}

		// fallback to root type
		if (staticModelType == null) {
			staticModelTypeUri = ROOT_MODEL_URI;
			staticModelType = MMTFRegistry.getModelType(ROOT_MODEL_URI);
		}

		// init
		types.add(staticModelType);

		// explore light model types
		for (Model lightModelSubtype : MMTFRegistry.getModelTypes()) {

			if (lightModelSubtype instanceof ModelRel) {
				continue;
			}

			// light model subtype
			if (lightModelSubtype.getConstraint() != null && MMTFRegistry.isSubtypeOf(lightModelSubtype.getUri(), staticModelTypeUri)) {
				if (MultiModelConstraintChecker.checkOCLConstraint(model, lightModelSubtype.getConstraint().getBody())) {
					types.add(lightModelSubtype);
				}
			}
		}

		return types;
	}

	private static EList<TypedElement> getRuntimeTypes(ModelRel modelRel) {

		EList<TypedElement> types = new BasicEList<TypedElement>();

		// static type
		ModelRel staticModelRelType;
		String staticModelRelTypeUri = modelRel.getMetatypeUri();
		if (staticModelRelTypeUri == null) {
			// this means getRuntimeTypes itself is used to set the initial static metatype
			staticModelRelType = null;
		}
		else {
			staticModelRelType = (ModelRel) modelRel.getMetatype();
		}

		// fallback to root type
		if (staticModelRelType == null) {
			staticModelRelTypeUri = ROOT_RELATIONSHIP_URI;
			staticModelRelType = MMTFRegistry.getModelRelType(ROOT_RELATIONSHIP_URI);
		}

		// init
		types.add(staticModelRelType);

		// not specialized yet
		if (modelRel.getModels().size() == 0) {
			for (ModelRel modelRelType : MMTFRegistry.getModelRelTypes()) {
				if (MMTFRegistry.isSubtypeOf(modelRelType.getUri(), staticModelRelTypeUri)) {
					types.add(modelRelType);
				}
			}
			return types;
		}

		// explore model endpoints
modelRelTypes:
		for (ModelRel modelRelSubtype : MMTFRegistry.getModelRelTypes()) {

			// only subtypes
			if (!MMTFRegistry.isSubtypeOf(modelRelSubtype.getUri(), staticModelRelTypeUri)) {
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
					for (String modelSupertypeUri : MMTFRegistry.getSupertypeUris(model.getMetatypeUri())) {
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

			//TODO: MMTF continue with other cases (not easy matching models when the number of endpoints is fixed)
		}

		return types;
	}

	private static EList<TypedElement> getRuntimeTypes(ModelElement modelElem) {

		//TODO MMTF: implementare
		EList<TypedElement> types = new BasicEList<TypedElement>();

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
			staticElementType = (ModelElement) modelElem.getMetatype();
		}

		// fallback to root type
		if (modelElem.getCategory() == ModelElementCategory.ENTITY) {
			types.add(MMTFRegistry.getExtendibleType(ROOT_MODEL_ELEMENT_ENTITY_URI));
		}
		else {
			types.add(MMTFRegistry.getExtendibleType(ROOT_MODEL_ELEMENT_RELATIONSHIP_URI));
		}

		return types;
	}

	//TODO MMTF: not needed if specialization is not allowed
	private static EList<TypedElement> getRuntimeTypes(Link link) {

		EList<TypedElement> types = new BasicEList<TypedElement>();
		ModelRel modelRel = (ModelRel) link.eContainer();

		// not specialized yet
		if (link.getElementRefs().size() == 0) {
			types.addAll(MMTFRegistry.getLinkTypes((ModelRel) modelRel.getMetatype()));
			return types;
		}

linkTypes:
		for (Link linkType : MMTFRegistry.getLinkTypes((ModelRel) modelRel.getMetatype())) {

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

			//TODO: MMTF continue with other cases
		}

		// fallback to root type
		if (types.isEmpty()) {
			types.add(MMTFRegistry.getExtendibleType(ROOT_RELATIONSHIP_LINK_URI));
		}

		return types;
	}

	private static EList<TypedElement> getRuntimeTypes(Editor editor) {

		EList<TypedElement> types = new BasicEList<TypedElement>();

		//TODO MMTF: fallback to root text editor?
		types.add(MMTFRegistry.getExtendibleType(editor.getUri()));

		return types;
	}

	public static EList<TypedElement> getRuntimeTypes(TypedElement element) {

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

	public static TypedElement getType(TypedElement element) {

		if (element.getLevel() == MidLevel.TYPES) {
			return null;
		}

		TypedElement type = MMTFRegistry.getExtendibleType(element.getMetatypeUri());
		if (type == null) { // this can happen when a type is uninstalled
			//TODO MMTF: find a way to try with runtime type in this read transaction?
			//element.setMetatypeUri(null);
			//type = getRuntimeTypes(element);
		}

		return type;
	}

	private static EObject getRoot(URI uri) throws Exception {

		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(uri, true);
		EObject root = resource.getContents().get(0);

		return root;
	}

	private static EObject getRoot(String uri) throws Exception {

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
					model = (Model) model.getSupertype();
					uri = model.getUri();
				}
				root = EPackage.Registry.INSTANCE.getEPackage(uri);
				if (root == null) {
					throw new MMTFException("EPackage for URI " + uri + " is not registered");
				}
			}
			else {
				if (model instanceof ModelRel) {
					return model;
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

	public static EObject getPointer(ModelElement modelElem) {

		Model model = (Model) modelElem.eContainer();
		EObject pointer;

		if (modelElem.getLevel() == MidLevel.TYPES) {
			pointer = MMTFRegistry.getModelTypeMetamodelElement(
				model,
				modelElem.getClassLiteral()
			);
		}
		else {
			//TODO MMTF: do I need to get the model first, and then the fragment, or can I get it at once? need to try
			pointer = null;
		}

		return pointer;
	}

}
