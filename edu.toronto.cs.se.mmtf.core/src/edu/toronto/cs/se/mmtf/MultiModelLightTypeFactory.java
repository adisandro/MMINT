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
package edu.toronto.cs.se.mmtf;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelHierarchyUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;

public class MultiModelLightTypeFactory extends MultiModelTypeFactory {

	private static String getExtendibleTypeRootUri(ExtendibleElement type) {

		String rootUri = type.getUri();
		int cut = rootUri.lastIndexOf(MMTF.URI_SEPARATOR);
		if (cut == -1) {
			cut = type.getUri().length();
		}
		rootUri = type.getUri().substring(0, cut);

		return rootUri;
	}

	public static String getNewExtendibleTypeUri(ExtendibleElement type, String newTypeUriFragment, String newTypeName) {

		String rootUri = getExtendibleTypeRootUri(type);
		String newTypeUri = (newTypeUriFragment == null) ?
			rootUri + MMTF.URI_SEPARATOR + newTypeName :
			rootUri + MMTF.URI_SEPARATOR + newTypeUriFragment + MMTF.URI_SEPARATOR + newTypeName;

		return newTypeUri;
	}

	private static void addLightExtendibleType(ExtendibleElement newType, ExtendibleElement type, ExtendibleElement rootUriType, String newTypeUriFragment, String newTypeName, MultiModel multiModel) throws MMTFException {

		String newTypeUri = getNewExtendibleTypeUri(rootUriType, newTypeUriFragment, newTypeName);
		addExtendibileElementType(newType, type, newTypeUri, newTypeName, multiModel);
		newType.setDynamic(true);
	}

	private static void addLightModelType(Model newModelType, Model modelType, String newModelTypeName, String constraint) throws MMTFException {

		MultiModel multiModel = (MultiModel) modelType.eContainer();
		addLightExtendibleType(newModelType, modelType, modelType, null, newModelTypeName, multiModel);
		addModelType(newModelType, constraint, multiModel);
		newModelType.setOrigin(ModelOrigin.CREATED);
		newModelType.setFileExtension(modelType.getFileExtension());
		for (Editor editorType : modelType.getEditors()) {
			//TODO MMTF: a new editor is created instead of attaching existing ones
			//TODO MMTF: because I couldn't find a way then from an editor to understand which model was being created
			try {
				Editor newEditorType = createLightEditorType(editorType, newModelType.getName(), editorType.getName(), newModelType.getUri(), editorType.getId(), editorType.getWizardId(), editorType.eClass());
				addModelTypeEditor(newEditorType, newModelType);
			}
			catch (MMTFException e) {
				// models created through this editor will have the supermodel as static type
				addModelTypeEditor(editorType, newModelType);
			}
		}
	}

	public static Model createLightModelType(Model modelType, String newModelTypeName, String constraint) throws MMTFException {

		Model newModelType = MidFactory.eINSTANCE.createModel();
		addLightModelType(newModelType, modelType, newModelTypeName, constraint);

		return newModelType;
	}

	public static ModelElementReference createLightModelElementTypeAndModelElementTypeReference(ModelEndpointReference modelTypeEndpointRef, ModelElement modelElemType, ModelElementReference modelElemTypeRef, String newModelElemTypeName, ModelElementCategory category, String classLiteral) throws MMTFException {

		ModelRel modelRelType = (ModelRel) modelTypeEndpointRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		String newTypeUri = getNewExtendibleTypeUri(modelTypeEndpointRef.getObject(), modelTypeEndpointRef.getObject().getName(), newModelElemTypeName);
		ModelElement newModelElemType = MultiModelTypeRegistry.getModelElementType(multiModel, newTypeUri);
		if (newModelElemType == null) {
			// create the "thing"
			newModelElemType = MidFactory.eINSTANCE.createModelElement();
			addLightExtendibleType(newModelElemType, modelElemType, modelTypeEndpointRef.getObject(), modelTypeEndpointRef.getObject().getName(), newModelElemTypeName, multiModel);
			addModelElementType(modelTypeEndpointRef.getObject().getTarget(), newModelElemType, category, classLiteral);
		}
		// create the reference of the "thing"
		ModelElementReference newModelElemTypeRef = createModelElementTypeReference(modelTypeEndpointRef, modelElemTypeRef, newModelElemType, true);
		// create references of the "thing" in subtypes of the container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelTypeRegistry.getModelRelType(multiModel, modelRelSubtypeUri);
			ModelEndpointReference modelSubtypeRef = MultiModelHierarchyUtils.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference modelElemSubtypeRef = null;
			if (modelElemTypeRef != null) {
				ModelEndpointReference modelSubtypeRefSuper = MultiModelHierarchyUtils.getReference((ModelEndpointReference) modelElemTypeRef.eContainer(), modelRelSubtype.getModelEndpointRefs());
				modelElemSubtypeRef = MultiModelHierarchyUtils.getReference(modelElemTypeRef, modelSubtypeRefSuper.getModelElemRefs());
			}
			createModelElementTypeReference(modelSubtypeRef, modelElemSubtypeRef, newModelElemType, false);
		}

		return newModelElemTypeRef;
	}

	public static ModelRel createLightModelRelType(ModelRel modelRelType, String newModelRelTypeName, String constraint, EClass modelRelTypeClass) throws MMTFException {

		ModelRel newModelRelType = (ModelRel) RelationshipFactory.eINSTANCE.create(modelRelTypeClass);
		addLightModelType(newModelRelType, modelRelType, newModelRelTypeName, constraint);
		addModelRelType(newModelRelType, modelRelType);

		return newModelRelType;
	}

	public static ModelEndpointReference createLightModelTypeEndpointAndModelTypeEndpointReference(ModelRel modelRelType, ModelEndpoint modelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, Model newModelType, String newModelTypeEndpointName, boolean isBinarySrc) throws MMTFException {

		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		// create the "thing" and the corresponding reference
		ModelEndpoint newModelTypeEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		addLightExtendibleType(newModelTypeEndpoint, modelTypeEndpoint, modelRelType, modelRelType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelType.getName(), newModelTypeEndpointName, multiModel);
		addModelTypeEndpoint(modelRelType, newModelTypeEndpoint, newModelType, isBinarySrc);
		ModelEndpointReference newModelTypeEndpointRef = createModelTypeEndpointReference(modelRelType, modelTypeEndpointRef, newModelTypeEndpoint, true, isBinarySrc);
		// create references of the "thing" in subtypes of the container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelTypeRegistry.getModelRelType(multiModel, modelRelSubtypeUri);
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MultiModelHierarchyUtils.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			createModelTypeEndpointReference(modelRelSubtype, modelSubtypeEndpointRef, newModelTypeEndpoint, false, isBinarySrc);
		}

		return newModelTypeEndpointRef;
	}

	public static void replaceLightModelTypeEndpointAndModelTypeEndpointReference(ModelEndpoint oldModelTypeEndpoint, ModelRel modelRelType, ModelEndpoint modelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, Model newModelType, String newModelTypeEndpointName) throws MMTFException {

		// modify the "thing" and the corresponding reference
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		addLightExtendibleType(oldModelTypeEndpoint, modelTypeEndpoint, modelRelType, modelRelType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelType.getName(), newModelTypeEndpointName, multiModel);
		oldModelTypeEndpoint.setTarget(newModelType);
		if (modelTypeEndpointRef != null) {
			ModelEndpointReference oldModelTypeEndpointRef = MultiModelHierarchyUtils.getReference(oldModelTypeEndpoint.getUri(), modelRelType.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelTypeRegistry.getModelRelType(multiModel, modelRelSubtypeUri);
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MultiModelHierarchyUtils.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelEndpointReference oldModelTypeEndpointRef = MultiModelHierarchyUtils.getReference(oldModelTypeEndpoint.getUri(), modelRelSubtype.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelSubtypeEndpointRef);
		}
	}

	public static LinkReference createLightLinkTypeAndLinkTypeReference(ModelRel modelRelType, Link linkType, LinkReference linkTypeRef, String newLinkTypeName, EClass newLinkTypeClass, EClass newLinkTypeRefClass) throws MMTFException {

		// create the "thing" and the corresponding reference
		Link newLinkType = (Link) RelationshipFactory.eINSTANCE.create(newLinkTypeClass);
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		addLightExtendibleType(newLinkType, linkType, modelRelType, modelRelType.getName(), newLinkTypeName, multiModel);
		addLinkType(modelRelType, newLinkType, linkType);
		LinkReference newLinkTypeRef = createLinkTypeReference(modelRelType, linkTypeRef, newLinkType, newLinkTypeRefClass, true);
		// create references of the "thing" in subtypes of the container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelTypeRegistry.getModelRelType(multiModel, modelRelSubtypeUri);
			LinkReference linkSubtypeRef = (linkTypeRef == null) ?
				null :
				MultiModelHierarchyUtils.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			createLinkTypeReference(modelRelSubtype, linkSubtypeRef, newLinkType, newLinkTypeRefClass, false);
		}

		return newLinkTypeRef;
	}

	public static ModelElementEndpointReference createLightModelElementTypeEndpointAndModelElementTypeEndpointReference(LinkReference linkTypeRef, ModelElementEndpoint modelElemTypeEndpoint, ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference newModelElemTypeRef, String newModelElemTypeEndpointName, boolean isBinarySrc) throws MMTFException {

		Link linkType = linkTypeRef.getObject();
		ModelElement newModelElemType = newModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) newModelElemTypeRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		// create the "thing" and the corresponding reference
		ModelElementEndpoint newModelElemTypeEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		addLightExtendibleType(newModelElemTypeEndpoint, modelElemTypeEndpoint, linkType, linkType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelElemTypeRef.getObject().getName(), newModelElemTypeEndpointName, multiModel);
		addModelElementTypeEndpoint(linkType, newModelElemTypeEndpoint, newModelElemType, isBinarySrc);
		ModelElementEndpointReference newModelElemTypeEndpointRef = createModelElementTypeEndpointReference(linkTypeRef, modelElemTypeEndpointRef, newModelElemTypeEndpoint, newModelElemTypeRef, true, isBinarySrc);
		addModelElementTypeEndpointReference(linkType, newModelElemTypeEndpointRef);
		// create references of the "thing" in subtypes of the container's container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelTypeRegistry.getModelRelType(multiModel, modelRelSubtypeUri);
			LinkReference linkSubtypeRef = MultiModelHierarchyUtils.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = null;
			if (modelElemTypeEndpointRef != null) {
				LinkReference linkTypeRefSuper = (LinkReference) modelElemTypeEndpointRef.eContainer();
				LinkReference linkSubtypeRefSuper = MultiModelHierarchyUtils.getReference(linkTypeRefSuper, modelRelSubtype.getLinkRefs());
				modelElemSubtypeEndpointRef = MultiModelHierarchyUtils.getReference(modelElemTypeEndpointRef, linkSubtypeRefSuper.getModelElemEndpointRefs());
			}
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelHierarchyUtils.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference newModelElemSubtypeRef = MultiModelHierarchyUtils.getReference(newModelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			createModelElementTypeEndpointReference(linkSubtypeRef, modelElemSubtypeEndpointRef, newModelElemTypeEndpoint, newModelElemSubtypeRef, false, isBinarySrc);
		}
		// create references of the "thing" in subtypes of the container
		for (String linkSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, linkType)) {
			Link linkSubtype = MultiModelTypeRegistry.getLinkType(multiModel, linkSubtypeUri);
			addModelElementTypeEndpointReference(linkSubtype, newModelElemTypeEndpointRef);
		}

		return newModelElemTypeEndpointRef;
	}

	public static void replaceLightModelElementTypeEndpointAndModelElementTypeEndpointReference(ModelElementEndpointReference oldModelElemTypeEndpointRef, LinkReference linkTypeRef, ModelElementEndpoint modelElemTypeEndpoint, ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference newModelElemTypeRef, String newModelElemTypeEndpointName) throws MMTFException {

		ModelElementEndpoint oldModelElemTypeEndpoint = oldModelElemTypeEndpointRef.getObject();
		Link linkType = linkTypeRef.getObject();
		ModelElement newModelElemType = newModelElemTypeRef.getObject();
		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) newModelElemTypeRef.eContainer();
		MultiModel multiModel = (MultiModel) linkTypeRef.eContainer().eContainer();
		// modify the "thing" and the corresponding reference
		addLightExtendibleType(oldModelElemTypeEndpoint, modelElemTypeEndpoint, linkType, linkType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelElemType.getName(), newModelElemTypeEndpointName, multiModel);
		oldModelElemTypeEndpoint.setTarget(newModelElemType);
		oldModelElemTypeEndpointRef.setModelElemRef(newModelElemTypeRef);
		if (modelElemTypeEndpointRef != null) {
			oldModelElemTypeEndpointRef.setSupertypeRef(modelElemTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container's container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelTypeRegistry.getModelRelType(multiModel, modelRelSubtypeUri);
			LinkReference linkSubtypeRef = MultiModelHierarchyUtils.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = null;
			if (modelElemTypeEndpointRef != null) {
				LinkReference linkTypeRefSuper = (LinkReference) modelElemTypeEndpointRef.eContainer();
				LinkReference linkSubtypeRefSuper = MultiModelHierarchyUtils.getReference(linkTypeRefSuper, modelRelSubtype.getLinkRefs());
				modelElemSubtypeEndpointRef = MultiModelHierarchyUtils.getReference(modelElemTypeEndpointRef, linkSubtypeRefSuper.getModelElemEndpointRefs());
			}
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelHierarchyUtils.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference newModelElemSubtypeRef = MultiModelHierarchyUtils.getReference(newModelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			ModelElementEndpointReference oldModelElemSubtypeEndpointRef = MultiModelHierarchyUtils.getReference(oldModelElemTypeEndpointRef, linkSubtypeRef.getModelElemEndpointRefs());
			oldModelElemTypeEndpointRef.setModelElemRef(newModelElemSubtypeRef);
			oldModelElemSubtypeEndpointRef.setSupertypeRef(modelElemSubtypeEndpointRef);
		}
	}

	public static Editor createLightEditorType(Editor editorType, String newEditorTypeUriFragment, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, EClass newEditorTypeClass) throws MMTFException {

		Editor newEditorType = (Editor) EditorFactory.eINSTANCE.create(editorType.eClass());
		MultiModel multiModel = (MultiModel) editorType.eContainer();
		addLightExtendibleType(newEditorType, editorType, editorType, newEditorTypeUriFragment, newEditorTypeName, multiModel);
		addEditorType(newEditorType, modelTypeUri, editorId, wizardId, multiModel);

		for (String fileExtension : editorType.getFileExtensions()) {
			newEditorType.getFileExtensions().add(fileExtension);
		}

		return newEditorType;
	}

	public static void copyLightModelRelType(ModelRel oldModelRelType, ModelRel newModelRelType) throws MMTFException {

		// models
		MultiModel multiModel = (MultiModel) newModelRelType.eContainer();
		Iterator<ModelEndpoint> oldModelTypeEndpointIter = MultiModelHierarchyUtils.getTypeHierarchyIterator(oldModelRelType.getModelEndpoints());
		while (oldModelTypeEndpointIter.hasNext()) {
			ModelEndpoint oldModelTypeEndpoint = oldModelTypeEndpointIter.next();
			Model newModelType = MultiModelRegistry.getModel(multiModel, oldModelTypeEndpoint.getTargetUri());
			ModelEndpoint modelTypeEndpoint = null;
			ModelEndpointReference modelTypeEndpointRef = null;
			if (oldModelTypeEndpoint.getSupertype() != null) { //TODO MMTF: remove all such checks from endpoints when they have root supertype
				modelTypeEndpoint = MultiModelTypeRegistry.getModelTypeEndpoint(multiModel, oldModelTypeEndpoint.getSupertype().getUri());
				modelTypeEndpointRef = MultiModelHierarchyUtils.getReference(oldModelTypeEndpoint.getSupertype().getUri(), newModelRelType.getModelEndpointRefs());
			}
			createLightModelTypeEndpointAndModelTypeEndpointReference(newModelRelType, modelTypeEndpoint, modelTypeEndpointRef, newModelType, oldModelTypeEndpoint.getName(), false);
		}
		// model element types
		Iterator<ModelEndpointReference> oldModelTypeEndpointRefIter = MultiModelHierarchyUtils.getTypeRefHierarchyIterator(oldModelRelType.getModelEndpointRefs());
		while (oldModelTypeEndpointRefIter.hasNext()) {
			ModelEndpointReference oldModelTypeEndpointRef = oldModelTypeEndpointRefIter.next();
			ModelEndpointReference newModelTypeEndpointRef = MultiModelHierarchyUtils.getReference(oldModelTypeEndpointRef, newModelRelType.getModelEndpointRefs());
			Iterator<ModelElementReference> oldModelElemTypeRefIter = MultiModelHierarchyUtils.getTypeRefHierarchyIterator(oldModelTypeEndpointRef.getModelElemRefs());
			while (oldModelElemTypeRefIter.hasNext()) {
				ModelElementReference oldModelElemTypeRef = oldModelElemTypeRefIter.next();
				ModelElement modelElemType = MultiModelTypeRegistry.getModelElementType(multiModel, oldModelElemTypeRef.getObject().getSupertype().getUri());
				ModelEndpointReference newModelTypeEndpointRefSuper = MultiModelHierarchyUtils.getReference((ModelEndpointReference) oldModelElemTypeRef.getSupertypeRef().eContainer(), newModelRelType.getModelEndpointRefs());
				ModelElementReference modelElemTypeRef = MultiModelHierarchyUtils.getReference(modelElemType.getUri(), newModelTypeEndpointRefSuper.getModelElemRefs());
				createLightModelElementTypeAndModelElementTypeReference(
					newModelTypeEndpointRef,
					modelElemType,
					modelElemTypeRef,
					oldModelElemTypeRef.getObject().getName(),
					oldModelElemTypeRef.getObject().getCategory(),
					oldModelElemTypeRef.getObject().getClassLiteral()
				);
			}
		}
		// link types
		Iterator<Link> oldLinkTypeIter = MultiModelHierarchyUtils.getTypeHierarchyIterator(oldModelRelType.getLinks());
		while (oldLinkTypeIter.hasNext()) {
			Link oldLinkType = oldLinkTypeIter.next();
			Link linkType = MultiModelTypeRegistry.getLinkType(multiModel, oldLinkType.getSupertype().getUri());
			LinkReference linkTypeRef = MultiModelHierarchyUtils.getReference(oldLinkType.getSupertype().getUri(), newModelRelType.getLinkRefs());
			EClass newLinkTypeRefClass = (oldLinkType instanceof BinaryLink) ?
				RelationshipPackage.eINSTANCE.getBinaryLinkReference() :
				RelationshipPackage.eINSTANCE.getLinkReference();
			LinkReference newLinkTypeRef = createLightLinkTypeAndLinkTypeReference(
				newModelRelType,
				linkType,
				linkTypeRef,
				oldLinkType.getName(),
				oldLinkType.eClass(),
				newLinkTypeRefClass
			);
			// connect it to model element type references (takes care of binary too)
			LinkReference oldLinkTypeRef = MultiModelHierarchyUtils.getReference(newLinkTypeRef, oldModelRelType.getLinkRefs());
			Iterator<ModelElementEndpointReference> oldModelElemTypeEndpointRefIter = MultiModelHierarchyUtils.getTypeRefHierarchyIterator(oldLinkTypeRef.getModelElemEndpointRefs());
			while (oldModelElemTypeEndpointRefIter.hasNext()) {
				ModelElementEndpointReference oldModelElemTypeEndpointRef = oldModelElemTypeEndpointRefIter.next();
				ModelElementReference oldModelElemTypeRef = oldModelElemTypeEndpointRef.getModelElemRef();
				ModelEndpointReference newModelTypeEndpointRef = MultiModelHierarchyUtils.getReference((ModelEndpointReference) oldModelElemTypeRef.eContainer(), newModelRelType.getModelEndpointRefs());
				ModelElementReference newModelElemTypeRef = MultiModelHierarchyUtils.getReference(oldModelElemTypeRef, newModelTypeEndpointRef.getModelElemRefs());
				ModelElementEndpoint modelElemTypeEndpoint = null;
				ModelElementEndpointReference modelElemTypeEndpointRef = null;
				if (oldModelElemTypeEndpointRef.getObject().getSupertype() != null) {
					modelElemTypeEndpoint = MultiModelTypeRegistry.getModelElementTypeEndpoint(multiModel, oldModelElemTypeEndpointRef.getObject().getSupertype().getUri());
					LinkReference newLinkTypeRefSuper = MultiModelHierarchyUtils.getReference((LinkReference) oldModelElemTypeEndpointRef.getObject().getSupertype().eContainer(), newModelRelType.getLinkRefs());
					modelElemTypeEndpointRef = MultiModelHierarchyUtils.getReference(oldModelElemTypeEndpointRef.getSupertypeRef(), newLinkTypeRefSuper.getModelElemEndpointRefs());
				}
				createLightModelElementTypeEndpointAndModelElementTypeEndpointReference(
					newLinkTypeRef,
					modelElemTypeEndpoint,
					modelElemTypeEndpointRef,
					newModelElemTypeRef,
					oldModelElemTypeEndpointRef.getObject().getName(),
					false
				);
			}
		}
	}

}
