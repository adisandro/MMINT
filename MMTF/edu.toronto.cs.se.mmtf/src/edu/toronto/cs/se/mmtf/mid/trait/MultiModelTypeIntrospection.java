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
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

/**
 * The type introspection engine for multimodels.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeIntrospection implements MMTFConstants {

	public static <T extends ExtendibleElement> boolean validateType(T element, T elementType) {

		//TODO MMTF: figure out how to have multiple functions that validate
		boolean validates = false;

		//TODO MMTF: other extendible elements

		if (element instanceof ModelRel) {
			validates = MultiModelConstraintChecker.areAllowedModelEndpoints((ModelRel) element, (ModelRel) elementType);
			if (!validates) {
				return false;
			}
			for (Link link : ((ModelRel) element).getLinks()) {
				validates = false;
				for (Link linkType : ((ModelRel) elementType).getLinks()) {
					validates = MultiModelConstraintChecker.areAllowedModelElementEndpointReferences(link, linkType);
					if (validates) {
						break;
					}
				}
				if (!validates) {
					return false;
				}
			}
			//TODO MMTF: do additional structure checks
		}

		if (element instanceof Model) {
			boolean isModelRel = element instanceof ModelRel;
			if (!isModelRel && elementType instanceof ModelRel) { // checking against root model rel
				return false;
			}
			// constraint validation
			validates = MultiModelConstraintChecker.checkConstraint(element, ((Model) elementType).getConstraint());
		}

		if (element instanceof Link) {
			validates = MultiModelConstraintChecker.areAllowedModelElementEndpointReferences((Link) element, (Link) elementType);
		}

		return validates;
	}

	private static <T extends ExtendibleElement> List<T> filterSubtypes(T element, T elementType, List<T> elementSubtypes) {

		List<T> filteredElementSubtypes = new ArrayList<T>();

		// only direct subtypes
		for (T elementSubtype : elementSubtypes) {
			if (elementSubtype.getSupertype().getUri().equals(elementType.getUri())) {
				filteredElementSubtypes.add(elementSubtype);
			}
		}

		if (elementType instanceof Model && !(elementType instanceof ModelRel)) { // explore metamodel-compatible supertrees and subtrees
			List<T> metamodelSubtypes = new ArrayList<T>();
			String metamodelUri = getRoot((Model) element).eClass().getEPackage().getNsURI();
			for (T filteredElementSubtype : filteredElementSubtypes) {
				if (
					metamodelUri.equals(filteredElementSubtype.getUri()) ||
					MultiModelTypeHierarchy.isSubtypeOf(filteredElementSubtype.getUri(), metamodelUri) ||
					MultiModelTypeHierarchy.isSubtypeOf(metamodelUri, filteredElementSubtype.getUri())
				) {
					metamodelSubtypes.add(filteredElementSubtype);
				}
			}
			return metamodelSubtypes;
		}

		return filteredElementSubtypes;
	}

	private static <T extends ExtendibleElement> void getRuntimeTypes(T element, T elementType, List<T> elementTypes) {

		// stop condition: validation
		if (!validateType(element, elementType)) {
			return;
		}

		elementTypes.add(elementType);
		List<T> elementSubtypes = filterSubtypes(element, elementType, MultiModelTypeHierarchy.getSubtypes(elementType));
		// recurse for each subtype
		for (T elementSubtype : elementSubtypes) {
			getRuntimeTypes(element, elementSubtype, elementTypes);
		}
	}

	public static <T extends ExtendibleElement> List<T> getRuntimeTypes(T element) {

		if (!MultiModelConstraintChecker.isInstancesLevel(element)) {
			return null;
		}

		// start from root
		List<T> elementTypes = new ArrayList<T>();
		T rootType = MultiModelTypeRegistry.getExtendibleElementType(MultiModelTypeRegistry.getRootTypeUri(element));
		getRuntimeTypes(element, rootType, elementTypes);

		return elementTypes;
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

	public static EObject getPointer(Resource resource, URI emfUri) throws Exception {

		EObject pointer = resource.getEObject(emfUri.fragment());

		return pointer;
	}

	public static EObject getPointer(Resource resource, String uri) throws Exception {

		URI emfUri = URI.createURI(uri, false, URI.FRAGMENT_LAST_SEPARATOR);

		return getPointer(resource, emfUri);
	}

	public static EObject getPointer(URI emfUri) throws Exception {

		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(emfUri, true);
		EObject pointer = resource.getEObject(emfUri.fragment());

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
				//TODO MMTF: MODELELEM->refine when introducing additional model element level
				pointer = getPointer(modelElem.getUri().substring(0, modelElem.getUri().indexOf(MMTF.ROLE_SEPARATOR)));
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
