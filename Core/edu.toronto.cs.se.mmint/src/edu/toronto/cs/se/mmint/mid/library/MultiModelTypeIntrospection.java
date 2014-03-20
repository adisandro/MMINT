/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.reasoning.Z3SMTUtils.MAVOTruthValue;

/**
 * The type introspection engine for multimodels.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeIntrospection {

	public static <T extends ExtendibleElement> MAVOTruthValue validateType(T element, T elementType, boolean validateInstance) {

		boolean validates;
		MAVOTruthValue mavoValidates;

		//TODO MMINT: other extendible elements

		if (element instanceof ModelRel) {
			validates = MultiModelConstraintChecker.areAllowedModelEndpoints((ModelRel) element, (ModelRel) elementType);
			if (!validates) {
				return MAVOTruthValue.FALSE;
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
					return MAVOTruthValue.FALSE;
				}
			}
			//TODO MMINT: do additional structure checks
		}

		// model rels go here too
		if (element instanceof Model) {
			boolean isModelRel = element instanceof ModelRel;
			if (!isModelRel && elementType instanceof ModelRel) { // checking against root model rel
				return MAVOTruthValue.FALSE;
			}
			// constraint validation
			mavoValidates = MultiModelConstraintChecker.checkConstraint(element, ((Model) elementType).getConstraint());
			if (!mavoValidates.toBoolean()) {
				return MAVOTruthValue.FALSE;
			}
			if (validateInstance && ((Model) element).getConstraint() != null) {
				mavoValidates = MultiModelConstraintChecker.checkConstraint(element, ((Model) element).getConstraint());
			}
			return mavoValidates;
		}

		if (element instanceof Link) {
			validates = MultiModelConstraintChecker.areAllowedModelElementEndpointReferences((Link) element, (Link) elementType);
			return MAVOTruthValue.toMAVOTruthValue(validates);
		}

		return MAVOTruthValue.FALSE;
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
			EObject rootModelObj;
			try {
				rootModelObj = ((Model) element).getEMFInstanceRoot();
			}
			catch (MMINTException e) {
				MMINTException.print(Type.WARNING, "Can't get model root, subtypes filtering skipped", e);
				return metamodelSubtypes;
			}
			String metamodelUri = rootModelObj.eClass().getEPackage().getNsURI();
			for (T filteredElementSubtype : filteredElementSubtypes) {
				if (
					metamodelUri.equals(filteredElementSubtype.getUri()) ||
					MultiModelTypeHierarchy.isSubtypeOf(filteredElementSubtype.getUri(), metamodelUri) ||
					MultiModelTypeHierarchy.isSubtypeOf(metamodelUri, filteredElementSubtype.getUri())
				) {
					metamodelSubtypes.add(filteredElementSubtype);
				}
				else { // try multiple inheritance
					//TODO MMINT: this is too tailored for UML_MAVO
					for (String multipleInheritanceUri : MultiModelTypeHierarchy.getMultipleInheritanceUris(metamodelUri)) {
						if (
							multipleInheritanceUri.equals(filteredElementSubtype.getUri()) ||
							MultiModelTypeHierarchy.isSubtypeOf(filteredElementSubtype.getUri(), multipleInheritanceUri) ||
							MultiModelTypeHierarchy.isSubtypeOf(multipleInheritanceUri, filteredElementSubtype.getUri())
						) {
							metamodelSubtypes.add(filteredElementSubtype);
						}
					}
				}
			}
			return metamodelSubtypes;
		}

		return filteredElementSubtypes;
	}

	private static <T extends ExtendibleElement> void getRuntimeTypes(T element, T elementType, List<T> elementTypes) {

		// no need to validate root type
		if (MultiModelTypeHierarchy.isRootType(elementType)) {
			elementTypes.add(elementType);
			// first stop condition: model relationship or link without endpoints
			if (element instanceof ModelRel && ((ModelRel) element).getModelEndpoints().isEmpty()) {
				return;
			}
			if (element instanceof Link && ((Link) element).getModelElemEndpoints().isEmpty()) {
				return;
			}
			// second stop condition: endpoints
			//TODO MMINT: needs container type + to be refined with override semantics
			if (element instanceof ModelEndpoint || element instanceof ModelElementEndpoint) {
				return;
			}
		}
		else {
			// third stop condition: validation
			if (!validateType(element, elementType, false).toBoolean()) {
				return;
			}
			elementTypes.add(elementType);
		}

		// recurse for each subtype
		List<T> elementSubtypes = filterSubtypes(element, elementType, MultiModelTypeHierarchy.getSubtypes(elementType));
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
		T rootType = MultiModelTypeRegistry.getType(MultiModelTypeHierarchy.getRootTypeUri(element));
		getRuntimeTypes(element, rootType, elementTypes);

		return elementTypes;
	}

	public static ExtendibleElement getType(ExtendibleElement element) {

		if (!MultiModelConstraintChecker.isInstancesLevel(element)) {
			return null;
		}

		ExtendibleElement type = MultiModelTypeRegistry.getType(element.getMetatypeUri());
		if (type == null) { // this can happen when a type is uninstalled
			//TODO MMINT[INTROSPECTION] find a way to try with runtime type in this read transaction?
			//element.setMetatypeUri(null);
			//type = getRuntimeTypes(element);
		}

		return type;
	}

	/**
	 * Gets the root of an ECore model file.
	 * 
	 * @param uri
	 *            The uri of the ECore model file.
	 * @return The root of the ECore model file.
	 * @throws Exception
	 *             If the uri is invalid or not corresponding to an ECore model
	 *             file.
	 */
	public static EObject getRoot(URI uri) throws Exception {

		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(uri, true);
		EObject root = resource.getContents().get(0);

		return root;
	}

	/**
	 * Writes the root of an ECore model into an ECore model file.
	 * 
	 * @param root
	 *            The ECore model root.
	 * @param uri
	 *            The uri of the ECore model file.
	 * @throws Exception
	 *             If the ECore model file could not be created or overwritten.
	 */
	public static void writeRoot(EObject root, URI uri) throws Exception {

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(root);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_SCHEMA_LOCATION, true);
		resource.save(options);
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

}
