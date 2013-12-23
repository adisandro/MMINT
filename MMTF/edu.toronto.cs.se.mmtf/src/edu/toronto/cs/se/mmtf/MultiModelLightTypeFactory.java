/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;

/**
 * The factory to create/modify/remove "light" types, i.e. dynamic types at
 * runtime.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelLightTypeFactory extends MultiModelTypeFactory {

	/**
	 * Gets the base uri of a "light" type by cutting its last fragment.
	 * 
	 * @param type
	 *            The type.
	 * @return The base uri of the type.
	 */
	private static String getLightTypeBaseUri(ExtendibleElement type) {

		String baseUri = type.getUri();
		int cut = baseUri.lastIndexOf(MMTF.URI_SEPARATOR);
		if (cut == -1) {
			cut = type.getUri().length();
		}
		baseUri = type.getUri().substring(0, cut);

		return baseUri;
	}

	/**
	 * Creates a uri for a new "light" type (the base uri + the eventual uri
	 * fragment + the name of the new type).
	 * 
	 * @param baseType
	 *            The base type from which the uri of the new type will be
	 *            constructed.
	 * @param newTypeFragmentUri
	 *            The uri fragment to be appended as part of the uri of the new
	 *            type, can be null.
	 * @param newTypeName
	 *            The name of the new type.
	 * @return The uri of the new type.
	 */
	public static String createNewLightTypeUri(ExtendibleElement baseType, String newTypeFragmentUri, String newTypeName) {

		String baseUri = getLightTypeBaseUri(baseType);
		String newTypeUri = (newTypeFragmentUri == null) ?
			baseUri + MMTF.URI_SEPARATOR + newTypeName :
			baseUri + MMTF.URI_SEPARATOR + newTypeFragmentUri + MMTF.URI_SEPARATOR + newTypeName;

		return newTypeUri;
	}

	/**
	 * Adds a "light" type to a multimodel.
	 * 
	 * @param newType
	 *            The new type to be added.
	 * @param type
	 *            The supertype of the new type.
	 * @param baseType
	 *            The base type from which the uri of the new type will be
	 *            constructed.
	 * @param newTypeFragmentUri
	 *            The uri fragment to be appended as part of the uri of the new
	 *            type, can be null.
	 * @param newTypeName
	 *            The name of the new type.
	 * @param multiModel
	 *            The multimodel that will contain the new type.
	 * @throws MMTFException
	 *             If the uri of the new type is already registered in the Type
	 *             MID.
	 */
	public static void addLightType(ExtendibleElement newType, ExtendibleElement type, ExtendibleElement baseType, String newTypeFragmentUri, String newTypeName, MultiModel multiModel) throws MMTFException {

		String newTypeUri = createNewLightTypeUri(baseType, newTypeFragmentUri, newTypeName);
		addType(newType, type, newTypeUri, newTypeName, multiModel);
		newType.setDynamic(true);
	}

	/**
	 * Creates and adds a "light" model element type endpoint and a reference to
	 * it to the Type MID.
	 * 
	 * @param modelElemTypeEndpoint
	 *            The supertype of the new model element type endpoint.
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the new model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type container.
	 * @param newModelElemTypeEndpointName
	 *            The name of the new model element type endpoint.
	 * @param newModelElemTypeRef
	 *            The reference to the new model element type that is the target
	 *            of the new model element type endpoint.
	 * @param isBinarySrc
	 *            True if the model element type endpoint is the source in the
	 *            binary link type container, false otherwise.
	 * @param linkTypeRef
	 *            The reference to the link type that will contain the new model
	 *            element type endpoint.
	 * @return The created reference to the model element type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model element type endpoint is already
	 *             registered in the Type MID.
	 */
	public static ModelElementEndpointReference createLightModelElementTypeEndpointAndModelElementTypeEndpointReference(ModelElementEndpoint modelElemTypeEndpoint, ModelElementEndpointReference modelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference newModelElemTypeRef, boolean isBinarySrc, LinkReference linkTypeRef) throws MMTFException {

		Link linkType = linkTypeRef.getObject();
		ModelElement newModelElemType = newModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) newModelElemTypeRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		// create the "thing" and the corresponding reference
		ModelElementEndpoint newModelElemTypeEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		addLightType(newModelElemTypeEndpoint, modelElemTypeEndpoint, linkType, linkType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelElemTypeRef.getObject().getName(), newModelElemTypeEndpointName, multiModel);
		addModelElementTypeEndpoint(newModelElemTypeEndpoint, newModelElemType, isBinarySrc, linkType);
		ModelElementEndpointReference newModelElemTypeEndpointRef = createModelElementTypeEndpointReference(newModelElemTypeEndpoint, modelElemTypeEndpointRef, newModelElemTypeRef, true, isBinarySrc, linkTypeRef);
		addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, linkType);
		// create references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = null;
			if (modelElemTypeEndpointRef != null) {
				LinkReference linkTypeRefSuper = (LinkReference) modelElemTypeEndpointRef.eContainer();
				LinkReference linkSubtypeRefSuper = MultiModelTypeHierarchy.getReference(linkTypeRefSuper, modelRelSubtype.getLinkRefs());
				modelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpointRef, linkSubtypeRefSuper.getModelElemEndpointRefs());
			}
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference newModelElemSubtypeRef = MultiModelTypeHierarchy.getReference(newModelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			createModelElementTypeEndpointReference(newModelElemTypeEndpoint, modelElemSubtypeEndpointRef, newModelElemSubtypeRef, false, isBinarySrc, linkSubtypeRef);
		}
		// create references of the "thing" in subtypes of the container
		for (Link linkSubtype : MultiModelTypeHierarchy.getSubtypes(linkType, multiModel)) {
			addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, linkSubtype);
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * Replaces an old "light" model element type endpoint and a reference to it
	 * with new ones in the Type MID.
	 * 
	 * @param oldModelElemTypeEndpointRef
	 *            The reference to the old model element type endpoint to be
	 *            replaced.
	 * @param modelElemTypeEndpoint
	 *            The supertype of the new model element type endpoint.
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the new model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type container.
	 * @param newModelElemTypeEndpointName
	 *            The name of the new model element type endpoint.
	 * @param newModelElemTypeRef
	 *            The reference to the new model element type that is the target
	 *            of the new model element type endpoint.
	 * @param linkTypeRef
	 *            The reference to the link type that will contain the new model
	 *            element type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model element type endpoint is already
	 *             registered in the Type MID.
	 */
	public static void replaceLightModelElementTypeEndpointAndModelElementTypeEndpointReference(ModelElementEndpointReference oldModelElemTypeEndpointRef, ModelElementEndpoint modelElemTypeEndpoint, ModelElementEndpointReference modelElemTypeEndpointRef, String newModelElemTypeEndpointName, ModelElementReference newModelElemTypeRef, LinkReference linkTypeRef) throws MMTFException {

		ModelElementEndpoint oldModelElemTypeEndpoint = oldModelElemTypeEndpointRef.getObject();
		Link linkType = linkTypeRef.getObject();
		ModelElement newModelElemType = newModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) newModelElemTypeRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(linkTypeRef);
		// modify the "thing" and the corresponding reference
		addLightType(oldModelElemTypeEndpoint, modelElemTypeEndpoint, linkType, linkType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelElemType.getName(), newModelElemTypeEndpointName, multiModel);
		oldModelElemTypeEndpoint.setTarget(newModelElemType);
		oldModelElemTypeEndpointRef.setModelElemRef(newModelElemTypeRef);
		if (modelElemTypeEndpointRef != null) {
			oldModelElemTypeEndpointRef.setSupertypeRef(modelElemTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = null;
			if (modelElemTypeEndpointRef != null) {
				LinkReference linkTypeRefSuper = (LinkReference) modelElemTypeEndpointRef.eContainer();
				LinkReference linkSubtypeRefSuper = MultiModelTypeHierarchy.getReference(linkTypeRefSuper, modelRelSubtype.getLinkRefs());
				modelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpointRef, linkSubtypeRefSuper.getModelElemEndpointRefs());
			}
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference newModelElemSubtypeRef = MultiModelTypeHierarchy.getReference(newModelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			ModelElementEndpointReference oldModelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelElemTypeEndpointRef, linkSubtypeRef.getModelElemEndpointRefs());
			oldModelElemTypeEndpointRef.setModelElemRef(newModelElemSubtypeRef);
			oldModelElemSubtypeEndpointRef.setSupertypeRef(modelElemSubtypeEndpointRef);
		}
	}

}
