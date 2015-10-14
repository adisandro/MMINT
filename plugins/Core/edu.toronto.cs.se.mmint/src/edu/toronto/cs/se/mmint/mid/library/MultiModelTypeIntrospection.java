/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * The type introspection engine for multimodels.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeIntrospection {

	public static <T extends ExtendibleElement> boolean validateType(T element, T elementType, boolean validateInstance) {

		boolean validates;

		//TODO MMINT[INTROSPECTION] other extendible elements

		if (element instanceof ModelRel) {
			validates = MultiModelConstraintChecker.areAllowedModelEndpoints((ModelRel) element, (ModelRel) elementType);
			if (!validates) {
				return false;
			}
			for (Mapping mapping : ((ModelRel) element).getMappings()) {
				validates = false;
				for (Mapping mappingType : ((ModelRel) elementType).getMappings()) {
					validates = MultiModelConstraintChecker.areAllowedModelElementEndpointReferences(mapping, mappingType);
					if (validates) {
						break;
					}
				}
				if (!validates) {
					return false;
				}
			}
			//TODO MMINT[INTROSPECTION] do additional structure checks
		}

		// model rels go here too
		if (element instanceof Model) {
			boolean isModelRel = element instanceof ModelRel;
			if (!isModelRel && elementType instanceof ModelRel) { // checking against root model rel
				return false;
			}
			// constraint validation
			validates = MultiModelConstraintChecker.checkConstraint(element, ((Model) elementType).getConstraint());
			if (!validates) {
				return false;
			}
			if (validateInstance && ((Model) element).getConstraint() != null) {
				validates = MultiModelConstraintChecker.checkConstraint(element, ((Model) element).getConstraint());
			}
			return validates;
		}

		if (element instanceof Mapping) {
			validates = MultiModelConstraintChecker.areAllowedModelElementEndpointReferences((Mapping) element, (Mapping) elementType);
			return validates;
		}

		return false;
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
			EPackage rootStaticModelTypeObj;
			try {
				rootStaticModelTypeObj = ((Model) element).getMetatype().getEMFTypeRoot();
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "Can't get model root, skipping subtypes filtering", e);
				return metamodelSubtypes;
			}
			String metamodelUri = rootStaticModelTypeObj.getNsURI();
			for (T filteredElementSubtype : filteredElementSubtypes) {
				if (
					metamodelUri.equals(filteredElementSubtype.getUri()) ||
					MultiModelTypeHierarchy.isSubtypeOf(filteredElementSubtype.getUri(), metamodelUri) ||
					MultiModelTypeHierarchy.isSubtypeOf(metamodelUri, filteredElementSubtype.getUri())
				) {
					metamodelSubtypes.add(filteredElementSubtype);
				}
				else { // try multiple inheritance
					//TODO MMINT[MID] this is too tailored for UML_MAVO
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
	public static @NonNull EObject getRoot(@NonNull URI uri) throws Exception {

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
	public static void writeRoot(@NonNull EObject root, @NonNull URI uri) throws Exception {

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
