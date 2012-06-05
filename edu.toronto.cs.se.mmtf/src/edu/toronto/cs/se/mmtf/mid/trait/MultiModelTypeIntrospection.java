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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.TypedElement;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;

/**
 * The type introspection engine for multimodels.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeIntrospection implements MMTFExtensionPoints {

	private static TypedElement getType(Model model) {

		String modelTypeUri = model.getRoot().eClass().getEPackage().getNsURI();
		ExtendibleElement inferred = MMTFRegistry.getExtendibleType(modelTypeUri);
		int inferredDepth = -1;

		//TODO MMTF: polish, a lot
		for (Model lightModelSubtype : MMTFRegistry.getModelTypes()) {

			if (lightModelSubtype instanceof ModelRel) {
				continue;
			}

			// real light subtype
			if (lightModelSubtype.getConstraint() != null && MMTFRegistry.isSubtypeOf(lightModelSubtype.getUri(), modelTypeUri)) {
				if (MultiModelConstraintChecker.checkOCLConstraint(model, lightModelSubtype.getConstraint().getBody())) {
					int depth = 0;
					ExtendibleElement subtype = lightModelSubtype;
					while (!subtype.getSupertype().getUri().equals(modelTypeUri)) {
						subtype = subtype.getSupertype();
						depth++;
					}
					// choose max inferred depth
					//TODO MMTF: with different subtype trees a dialog should be presented to the user
					if (depth > inferredDepth) {
						inferred = lightModelSubtype;
						inferredDepth = depth;
					}
				}
			}
		}

		// fallback to root type
		if (inferred == null) {
			inferred = MMTFRegistry.getExtendibleType(ROOT_MODEL_URI);
		}

		return inferred;
	}

	private static TypedElement getType(ModelRel modelRel) {

		// not specialized yet
		if (modelRel.getModels().size() == 0) {
			return MMTFRegistry.getExtendibleType(ROOT_RELATIONSHIP_URI);
		}

		//TODO MMTF: look for light types and evaluate constraints
		TypedElement inferred = null;

modelTypes:
		for (Model modelType : MMTFRegistry.getModelTypes()) {

			// get only model relationship types
			if (!(modelType instanceof ModelRel)) {
				continue;
			}
			ModelRel modelRelType = (ModelRel) modelType;

			// check cardinality
			if (!(modelRelType.isUnbounded() || modelRelType.getModels().size() == modelRel.getModels().size())) {
				continue;
			}

			// unbounded case
			if (modelRelType.isUnbounded()) {
				HashSet<String> allowedModels = new HashSet<String>();
				for (Model model : modelRelType.getModels()) {
					allowedModels.add(model.getUri());
				}
				for (Model model : modelRel.getModels()) {
					String modelTypeUri = model.getRoot().eClass().getEPackage().getNsURI();
					if (!allowedModels.contains(modelTypeUri)) {
						continue modelTypes;
					}
				}
				inferred = modelRelType;
				break;
			}

			//TODO: MMTF continue with other cases
		}
		//TODO: MMTF now after models endpoints, run infer based on light types

		// fallback to root type
		if (inferred == null) {
			inferred = MMTFRegistry.getExtendibleType(ROOT_RELATIONSHIP_URI);
		}

		return inferred;
	}

	private static TypedElement getType(ModelElement modelElem) {

		//TODO MMTF: implementare

		// fallback to root type
		if (modelElem.getCategory() == ModelElementCategory.ENTITY) {
			return MMTFRegistry.getExtendibleType(ROOT_MODEL_ELEMENT_ENTITY_URI);
		}
		else {
			return MMTFRegistry.getExtendibleType(ROOT_MODEL_ELEMENT_RELATIONSHIP_URI);
		}
	}

	private static TypedElement getType(Link link) {

		//TODO MMTF: implementare

		// fallback to root type
		return MMTFRegistry.getExtendibleType(ROOT_RELATIONSHIP_LINK_URI);
	}

	private static TypedElement getType(Editor editor) {

		return MMTFRegistry.getExtendibleType(editor.getUri());
		//TODO MMTF: fallback to root text editor?
	}

	public static TypedElement getType(TypedElement element) {

		if (element.getLevel() == MidLevel.TYPES) {
			return null;
		}

		if (element instanceof Link) {
			return getType((Link) element);
		}
		if (element instanceof ModelElement) {
			return getType((ModelElement) element);
		}
		if (element instanceof ModelRel) {
			return getType((ModelRel) element);
		}
		if (element instanceof Model) {
			return getType((Model) element);
		}
		if (element instanceof Editor) {
			return getType((Editor) element);
		}
		return null;
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
				URI modelUri = URI.createPlatformResourceURI(uri, true);
				ResourceSet set = new ResourceSetImpl();
				Resource resource = set.getResource(modelUri, true);
				root = resource.getContents().get(0);
			}

			return root;
		}
		catch (Exception e) {

			MMTFException.print(MMTFException.Type.WARNING, "Error getting root for model " + uri, e);
			return null;
		}
	}

}
