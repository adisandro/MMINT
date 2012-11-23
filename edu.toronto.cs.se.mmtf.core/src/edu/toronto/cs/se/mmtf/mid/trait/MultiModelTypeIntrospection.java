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
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

/**
 * The type introspection engine for multimodels.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeIntrospection implements MMTFConstants {

	private static List<ExtendibleElement> getRuntimeTypes(Model model) {

		List<ExtendibleElement> types = new ArrayList<ExtendibleElement>();

		// static type
		Model staticModelType;
		String staticModelTypeUri = model.getMetatypeUri();
		if (staticModelTypeUri == null) {
			// this means getRuntimeTypes itself is used to set the initial static metatype
			staticModelTypeUri = getRoot(model).eClass().getEPackage().getNsURI();
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

	private static List<ExtendibleElement> getRuntimeTypes(ModelRel modelRel) {

		List<ExtendibleElement> types = new ArrayList<ExtendibleElement>();

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

//		// not specialized yet
//		if (modelRel.getModels().size() == 0) {
//			for (ModelRel modelRelType : MultiModelTypeRegistry.getModelRelTypes()) {
//				if (MultiModelTypeRegistry.isSubtypeOf(modelRelType.getUri(), staticModelRelTypeUri)) {
//					types.add(modelRelType);
//				}
//			}
//			return types;
//		}
//
//		// explore model endpoints
//modelRelTypes:
//		for (ModelRel modelRelSubtype : MultiModelTypeRegistry.getModelRelTypes()) {
//
//			// only subtypes
//			if (!MultiModelTypeRegistry.isSubtypeOf(modelRelSubtype.getUri(), staticModelRelTypeUri)) {
//				continue;
//			}
//
//			// check cardinality
//			if (!(modelRelSubtype.isUnbounded() || modelRelSubtype.getModels().size() == modelRel.getModels().size())) {
//				continue;
//			}
//
//			// unbounded case
//			if (modelRelSubtype.isUnbounded()) {
//				HashSet<String> allowedModelTypes = new HashSet<String>();
//				for (Model modelType : modelRelSubtype.getModels()) {
//					allowedModelTypes.add(modelType.getUri());
//				}
//				for (Model model : modelRel.getModels()) {
//					if (allowedModelTypes.contains(model.getMetatypeUri())) {
//						continue;
//					}
//					boolean okModel = false;
//					for (String modelSupertypeUri : MultiModelTypeRegistry.getSupertypeUris(model.getMetatypeUri())) {
//						if (allowedModelTypes.contains(modelSupertypeUri)) {
//							okModel = true;
//							break;
//						}
//					}
//					if (!okModel) {
//						continue modelRelTypes;
//					}
//				}
//
//				// light model relationship subtype
//				if (modelRelSubtype.getConstraint() != null) {
//					if (!MultiModelConstraintChecker.checkOCLConstraint(modelRel, modelRelSubtype.getConstraint().getBody())) {
//						continue modelRelTypes;
//					}
//				}
//
//				types.add(modelRelSubtype);
//			}
//
//			//TODO MMTF: continue with other cases (not easy matching models when the number of endpoints is fixed)
//		}

		return types;
	}

	//TODO MMTF: not needed if specialization is not allowed
	private static List<ExtendibleElement> getRuntimeTypes(ModelElement modelElem) {

		//TODO MMTF: implementare
		List<ExtendibleElement> types = new ArrayList<ExtendibleElement>();

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
			types.add(MultiModelTypeRegistry.getExtendibleElementType(ROOT_MODELELEMENT_ENTITY_URI));
		}
		else {
			types.add(MultiModelTypeRegistry.getExtendibleElementType(ROOT_MODELELEMENT_RELATIONSHIP_URI));
		}

		return types;
	}

	//TODO MMTF: not needed if specialization is not allowed
	private static List<ExtendibleElement> getRuntimeTypes(Link link) {

		List<ExtendibleElement> types = new ArrayList<ExtendibleElement>();
		ModelRel modelRel = (ModelRel) link.eContainer();

//		// not specialized yet
//		if (link.getElements().size() == 0) {
//			types.addAll(MultiModelTypeRegistry.getLinkTypes(modelRel.getMetatype()));
//			return types;
//		}
//
//linkTypes:
//		for (Link linkType : MultiModelTypeRegistry.getLinkTypes(modelRel.getMetatype())) {
//
//			// check cardinality
//			if (!(linkType.isUnbounded() || linkType.getElements().size() == link.getElements().size())) {
//				continue;
//			}
//
//			// unbounded case
//			if (linkType.isUnbounded()) {
//				HashSet<String> allowedElements = new HashSet<String>();
//				for (ModelElement element : linkType.getElements()) {
//					allowedElements.add(element.getUri());
//				}
//				for (ModelElement element : link.getElements()) {
//					String elementTypeUri = element.getMetatypeUri();
//					if (!allowedElements.contains(elementTypeUri)) {
//						continue linkTypes;
//					}
//				}
//				types.add(linkType);
//			}
//
//			//TODO MMTF: continue with other cases
//		}

		// fallback to root type
		if (types.isEmpty()) {
			types.add(MultiModelTypeRegistry.getExtendibleElementType(ROOT_MODELREL_LINK_URI));
		}

		return types;
	}

	private static List<ExtendibleElement> getRuntimeTypes(Editor editor) {

		List<ExtendibleElement> types = new ArrayList<ExtendibleElement>();

		//TODO MMTF: fallback to root text editor?
		types.add(MultiModelTypeRegistry.getExtendibleElementType(editor.getUri()));

		return types;
	}

	private static List<ExtendibleElement> getRuntimeTypes(ModelEndpoint modelEndpoint) {

		List<ExtendibleElement> types = new ArrayList<ExtendibleElement>();

		types.add(MultiModelTypeRegistry.getExtendibleElementType(
			MultiModelTypeRegistry.getRootTypeUri(modelEndpoint))
		);

		return types;
	}

	private static List<ExtendibleElement> getRuntimeTypes(ModelElementEndpoint modelElemEndpoint) {

		List<ExtendibleElement> types = new ArrayList<ExtendibleElement>();

		types.add(MultiModelTypeRegistry.getExtendibleElementType(
			MultiModelTypeRegistry.getRootTypeUri(modelElemEndpoint))
		);

		return types;
	}

	public static List<ExtendibleElement> getRuntimeTypes(ExtendibleElement element) {

		if (element.getLevel() == MidLevel.TYPES) {
			return null;
		}

		if (element instanceof ModelRel) {
			return getRuntimeTypes((ModelRel) element);
		}
		if (element instanceof Model) {
			return getRuntimeTypes((Model) element);
		}
		if (element instanceof ModelEndpoint) {
			return getRuntimeTypes((ModelEndpoint) element);
		}
		if (element instanceof ModelElement) {
			return getRuntimeTypes((ModelElement) element);
		}
		if (element instanceof Link) {
			return getRuntimeTypes((Link) element);
		}
		if (element instanceof ModelElementEndpoint) {
			return getRuntimeTypes((ModelElementEndpoint) element);
		}
		if (element instanceof Editor) {
			return getRuntimeTypes((Editor) element);
		}
		return null;
	}

	public static ExtendibleElement getType(ExtendibleElement element) {

		if (!MultiModelConstraintChecker.isInstancesLevel(element)) {
			return null;
		}

		ExtendibleElement type = MultiModelTypeRegistry.getExtendibleElementType(element.getMetatypeUri());
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
			if (MultiModelConstraintChecker.isInstancesLevel(model)) {
				if (model instanceof ModelRel) {
					return model;
				}
				root = getRoot(uri);
			}
			else {
				// climb up light types
				while (model.isDynamic() != false) {
					model = model.getSupertype();
					uri = model.getUri();
				}
				root = EPackage.Registry.INSTANCE.getEPackage(uri);
				if (root == null) {
					throw new MMTFException("EPackage for URI " + uri + " is not registered");
				}
			}

			return root;
		}
		catch (Exception e) {

			MMTFException.print(MMTFException.Type.WARNING, "Error getting root for model " + uri, e);
			return null;
		}
	}

	public static void writeRoot(EObject root, URI uri) throws Exception {

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(root);
		resource.save(Collections.EMPTY_MAP);
	}

	public static void writeRoot(EObject root, String uri, boolean isWorkspace) throws Exception {

		URI emfUri = (isWorkspace) ?
			URI.createPlatformResourceURI(uri, true) :
			URI.createFileURI(uri);
		writeRoot(root, emfUri);
	}

	public static EObject getPointer(Resource resource, URI uri) throws Exception {

		EObject pointer = resource.getEObject(uri.fragment());

		return pointer;
	}

	public static EObject getPointer(Resource resource, String uri) throws Exception {

		URI emfUri = URI.createURI(uri, false, URI.FRAGMENT_LAST_SEPARATOR);

		return getPointer(resource, emfUri);
	}

	public static EObject getPointer(URI uri) throws Exception {

		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(uri, true);
		EObject pointer = resource.getEObject(uri.fragment());

		return pointer;
	}

	public static EObject getPointer(String uri) throws Exception {

		URI emfUri = URI.createURI(uri, false, URI.FRAGMENT_LAST_SEPARATOR);

		return getPointer(emfUri);
	}

	public static EObject getPointer(ModelElement modelElem) {

		Model model = (Model) modelElem.eContainer();
		EObject pointer = null;

		try {
			if (MultiModelConstraintChecker.isInstancesLevel(modelElem)) {
				pointer = getPointer(modelElem.getUri());
			}
			else {
				String[] literals = modelElem.getClassLiteral().split(MMTF.URI_SEPARATOR);
				pointer = ((EPackage) getRoot(model)).getEClassifier(literals[0]);
				if (literals.length > 1) {
					pointer = ((EClass) pointer).getEStructuralFeature(literals[1]);
				}
			}

			return pointer;
		}
		catch (Exception e) {

			MMTFException.print(MMTFException.Type.WARNING, "Error getting pointer for model element " + modelElem.getUri(), e);
			return null;
		}
	}

}
