/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
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

/**
 * The factory for creating "light" types, i.e. dynamic types created at
 * runtime.
 * 
 * @author Alessio Di Sandro
 * 
 */
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
		addType(newType, type, newTypeUri, newTypeName, multiModel);
		newType.setDynamic(true);
	}

	private static void addLightModelType(Model newModelType, Model modelType, String newModelTypeName, String constraintLanguage, String constraintImplementation) throws MMTFException {

		MultiModel multiModel = (MultiModel) modelType.eContainer();
		addLightExtendibleType(newModelType, modelType, modelType, null, newModelTypeName, multiModel);
		addModelType(newModelType, false, constraintLanguage, constraintImplementation, multiModel);
		newModelType.setOrigin(ModelOrigin.CREATED);
		newModelType.setFileExtension(modelType.getFileExtension());
		for (Editor editorType : modelType.getEditors()) {
			//TODO MMTF: a new editor is created instead of attaching existing ones
			//TODO MMTF: because I couldn't find a way then from an editor to understand which model was being created
			try {
				Editor newEditorType = createLightEditorType(editorType, newModelType.getName(), editorType.getName(), newModelType.getUri(), editorType.getId(), editorType.getWizardId(), editorType.getWizardDialogClass(), editorType.eClass());
				addModelTypeEditor(newEditorType, newModelType);
			}
			catch (MMTFException e) {
				// models created through this editor will have the supermodel as static type
				addModelTypeEditor(editorType, newModelType);
			}
		}
	}

	public static Model createLightModelType(Model modelType, String newModelTypeName, String constraintLanguage, String constraintImplementation) throws MMTFException {

		Model newModelType = MidFactory.eINSTANCE.createModel();
		addLightModelType(newModelType, modelType, newModelTypeName, constraintLanguage, constraintImplementation);

		return newModelType;
	}

	public static ModelElementReference createLightModelElementTypeAndModelElementTypeReference(ModelEndpointReference modelTypeEndpointRef, ModelElement modelElemType, ModelElementReference modelElemTypeRef, String newModelElemTypeName, ModelElementCategory category, String classLiteral) throws MMTFException {

		ModelRel modelRelType = (ModelRel) modelTypeEndpointRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		String newTypeUri = getNewExtendibleTypeUri(modelTypeEndpointRef.getObject(), modelTypeEndpointRef.getObject().getName(), newModelElemTypeName);
		ModelElement newModelElemType = MultiModelRegistry.getExtendibleElement(newTypeUri, multiModel);
		if (newModelElemType == null) {
			// create the "thing"
			newModelElemType = MidFactory.eINSTANCE.createModelElement();
			addLightExtendibleType(newModelElemType, modelElemType, modelTypeEndpointRef.getObject(), modelTypeEndpointRef.getObject().getName(), newModelElemTypeName, multiModel);
			addModelElementType(newModelElemType, category, classLiteral, modelTypeEndpointRef.getObject().getTarget());
		}
		// create the reference of the "thing"
		ModelElementReference newModelElemTypeRef = createModelElementTypeReference(newModelElemType, modelElemTypeRef, true, modelTypeEndpointRef);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			ModelEndpointReference modelSubtypeRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference modelElemSubtypeRef = null;
			if (modelElemTypeRef != null) {
				ModelEndpointReference modelSubtypeRefSuper = MultiModelTypeHierarchy.getReference((ModelEndpointReference) modelElemTypeRef.eContainer(), modelRelSubtype.getModelEndpointRefs());
				modelElemSubtypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeRef, modelSubtypeRefSuper.getModelElemRefs());
			}
			createModelElementTypeReference(newModelElemType, modelElemSubtypeRef, false, modelSubtypeRef);
		}

		return newModelElemTypeRef;
	}

	public static ModelRel createLightModelRelType(ModelRel modelRelType, String newModelRelTypeName, String constraintLanguage, String constraintImplementation, EClass modelRelTypeClass) throws MMTFException {

		ModelRel newModelRelType = (ModelRel) RelationshipFactory.eINSTANCE.create(modelRelTypeClass);
		addLightModelType(newModelRelType, modelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation);
		addModelRelType(newModelRelType, modelRelType);

		return newModelRelType;
	}

	public static ModelEndpointReference createLightModelTypeEndpointAndModelTypeEndpointReference(ModelRel modelRelType, ModelEndpoint modelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, Model newModelType, String newModelTypeEndpointName, boolean isBinarySrc) throws MMTFException {

		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		// create the "thing" and the corresponding reference
		ModelEndpoint newModelTypeEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		addLightExtendibleType(newModelTypeEndpoint, modelTypeEndpoint, modelRelType, modelRelType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelType.getName(), newModelTypeEndpointName, multiModel);
		addModelTypeEndpoint(newModelTypeEndpoint, newModelType, isBinarySrc, modelRelType);
		ModelEndpointReference newModelTypeEndpointRef = createModelTypeEndpointReference(newModelTypeEndpoint, modelTypeEndpointRef, true, isBinarySrc, modelRelType);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			createModelTypeEndpointReference(newModelTypeEndpoint, modelSubtypeEndpointRef, false, isBinarySrc, modelRelSubtype);
		}

		return newModelTypeEndpointRef;
	}

	public static void replaceLightModelTypeEndpointAndModelTypeEndpointReference(ModelEndpoint oldModelTypeEndpoint, ModelRel modelRelType, ModelEndpoint modelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, Model newModelType, String newModelTypeEndpointName) throws MMTFException {

		// modify the "thing" and the corresponding reference
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		addLightExtendibleType(oldModelTypeEndpoint, modelTypeEndpoint, modelRelType, modelRelType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelType.getName(), newModelTypeEndpointName, multiModel);
		oldModelTypeEndpoint.setTarget(newModelType);
		if (modelTypeEndpointRef != null) {
			ModelEndpointReference oldModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelTypeEndpoint.getUri(), modelRelType.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelEndpointReference oldModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelTypeEndpoint.getUri(), modelRelSubtype.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelSubtypeEndpointRef);
		}
	}

	public static LinkReference createLightLinkTypeAndLinkTypeReference(ModelRel modelRelType, Link linkType, LinkReference linkTypeRef, String newLinkTypeName, EClass newLinkTypeClass, EClass newLinkTypeRefClass) throws MMTFException {

		// create the "thing" and the corresponding reference
		Link newLinkType = (Link) RelationshipFactory.eINSTANCE.create(newLinkTypeClass);
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		addLightExtendibleType(newLinkType, linkType, modelRelType, modelRelType.getName(), newLinkTypeName, multiModel);
		addLinkType(newLinkType, linkType, modelRelType);
		LinkReference newLinkTypeRef = createLinkTypeReference(newLinkType, linkTypeRef, newLinkTypeRefClass, true, modelRelType);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			LinkReference linkSubtypeRef = (linkTypeRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			createLinkTypeReference(newLinkType, linkSubtypeRef, newLinkTypeRefClass, false, modelRelSubtype);
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
		addModelElementTypeEndpoint(newModelElemTypeEndpoint, newModelElemType, isBinarySrc, linkType);
		ModelElementEndpointReference newModelElemTypeEndpointRef = createModelElementTypeEndpointReference(newModelElemTypeEndpoint, modelElemTypeEndpointRef, newModelElemTypeRef, true, isBinarySrc, linkTypeRef);
		addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, linkType);
		// create references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
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
		for (Link linkSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, linkType)) {
			addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, linkSubtype);
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
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
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

	public static Editor createLightEditorType(Editor editorType, String newEditorTypeUriFragment, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, EClass newEditorTypeClass) throws MMTFException {

		Editor newEditorType = (Editor) EditorFactory.eINSTANCE.create(editorType.eClass());
		MultiModel multiModel = (MultiModel) editorType.eContainer();
		addLightExtendibleType(newEditorType, editorType, editorType, newEditorTypeUriFragment, newEditorTypeName, multiModel);
		addEditorType(newEditorType, modelTypeUri, editorId, wizardId, wizardDialogClassName, multiModel);

		for (String fileExtension : editorType.getFileExtensions()) {
			newEditorType.getFileExtensions().add(fileExtension);
		}

		return newEditorType;
	}

	public static void copyLightModelRelType(ModelRel oldModelRelType, ModelRel newModelRelType) throws MMTFException {

		// model types
		MultiModel multiModel = MultiModelRegistry.getMultiModel(newModelRelType);
		Iterator<ModelEndpoint> oldModelTypeEndpointIter = MultiModelTypeHierarchy.getTypeHierarchyIterator(oldModelRelType.getModelEndpoints());
		while (oldModelTypeEndpointIter.hasNext()) {
			ModelEndpoint oldModelTypeEndpoint = oldModelTypeEndpointIter.next();
			Model newModelType = MultiModelRegistry.getExtendibleElement(oldModelTypeEndpoint.getTargetUri(), multiModel);
			ModelEndpoint modelTypeEndpoint = null;
			ModelEndpointReference modelTypeEndpointRef = null;
			if (oldModelTypeEndpoint.getSupertype() != null) { //TODO MMTF: remove all such checks from endpoints when they have root supertype
				modelTypeEndpoint = MultiModelRegistry.getExtendibleElement(oldModelTypeEndpoint.getSupertype().getUri(), multiModel);
				modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelTypeEndpoint.getSupertype().getUri(), newModelRelType.getModelEndpointRefs());
			}
			createLightModelTypeEndpointAndModelTypeEndpointReference(newModelRelType, modelTypeEndpoint, modelTypeEndpointRef, newModelType, oldModelTypeEndpoint.getName(), false);
		}
		// model element types
		Iterator<ModelEndpointReference> oldModelTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(oldModelRelType.getModelEndpointRefs());
		while (oldModelTypeEndpointRefIter.hasNext()) {
			ModelEndpointReference oldModelTypeEndpointRef = oldModelTypeEndpointRefIter.next();
			ModelEndpointReference newModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelTypeEndpointRef, newModelRelType.getModelEndpointRefs());
			Iterator<ModelElementReference> oldModelElemTypeRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(oldModelTypeEndpointRef.getModelElemRefs());
			while (oldModelElemTypeRefIter.hasNext()) {
				ModelElementReference oldModelElemTypeRef = oldModelElemTypeRefIter.next();
				ModelElement modelElemType = MultiModelRegistry.getExtendibleElement(oldModelElemTypeRef.getObject().getSupertype().getUri(), multiModel);
				ModelEndpointReference newModelTypeEndpointRefSuper = null;
				ModelElementReference modelElemTypeRef = null;
				if (oldModelElemTypeRef.getSupertypeRef() != null) {
					newModelTypeEndpointRefSuper = MultiModelTypeHierarchy.getReference((ModelEndpointReference) oldModelElemTypeRef.getSupertypeRef().eContainer(), newModelRelType.getModelEndpointRefs());
					modelElemTypeRef = MultiModelTypeHierarchy.getReference(modelElemType.getUri(), newModelTypeEndpointRefSuper.getModelElemRefs());
				}
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
		Iterator<Link> oldLinkTypeIter = MultiModelTypeHierarchy.getTypeHierarchyIterator(oldModelRelType.getLinks());
		while (oldLinkTypeIter.hasNext()) {
			Link oldLinkType = oldLinkTypeIter.next();
			Link linkType = MultiModelRegistry.getExtendibleElement(oldLinkType.getSupertype().getUri(), multiModel);
			LinkReference linkTypeRef = MultiModelTypeHierarchy.getReference(oldLinkType.getSupertype().getUri(), newModelRelType.getLinkRefs());
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
			LinkReference oldLinkTypeRef = MultiModelTypeHierarchy.getReference(newLinkTypeRef, oldModelRelType.getLinkRefs());
			Iterator<ModelElementEndpointReference> oldModelElemTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(oldLinkTypeRef.getModelElemEndpointRefs());
			while (oldModelElemTypeEndpointRefIter.hasNext()) {
				ModelElementEndpointReference oldModelElemTypeEndpointRef = oldModelElemTypeEndpointRefIter.next();
				ModelElementReference oldModelElemTypeRef = oldModelElemTypeEndpointRef.getModelElemRef();
				ModelEndpointReference newModelTypeEndpointRef = MultiModelTypeHierarchy.getReference((ModelEndpointReference) oldModelElemTypeRef.eContainer(), newModelRelType.getModelEndpointRefs());
				ModelElementReference newModelElemTypeRef = MultiModelTypeHierarchy.getReference(oldModelElemTypeRef, newModelTypeEndpointRef.getModelElemRefs());
				ModelElementEndpoint modelElemTypeEndpoint = null;
				ModelElementEndpointReference modelElemTypeEndpointRef = null;
				if (oldModelElemTypeEndpointRef.getObject().getSupertype() != null) {
					modelElemTypeEndpoint = MultiModelRegistry.getExtendibleElement(oldModelElemTypeEndpointRef.getObject().getSupertype().getUri(), multiModel);
					LinkReference newLinkTypeRefSuper = MultiModelTypeHierarchy.getReference((LinkReference) oldModelElemTypeEndpointRef.getObject().getSupertype().eContainer(), newModelRelType.getLinkRefs());
					modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelElemTypeEndpointRef.getSupertypeRef(), newLinkTypeRefSuper.getModelElemEndpointRefs());
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
