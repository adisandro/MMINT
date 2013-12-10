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

import java.util.Iterator;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Diagram;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
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
 * The factory to create/modify/remove "light" types, i.e. dynamic types at
 * runtime.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelLightTypeFactory extends MultiModelTypeFactory {

	private final static String ECORE_PIVOT_URI = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
	private final static String ECORE_INVOCATION_DELEGATE = "invocationDelegates";
	private final static String ECORE_SETTING_DELEGATE = "settingDelegates";
	private final static String ECORE_VALIDATION_DELEGATE = "validationDelegates";
	private final static String ECORE_REFLECTIVE_FILE_EXTENSION = "xmi";

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
	 * Adds a "light" model type to the Type MID, together with an editor type
	 * for it.
	 * 
	 * @param newModelType
	 *            The new model type to be added.
	 * @param modelType
	 *            The supertype of the new model type.
	 * @param newModelTypeName
	 *            The name of the new model type.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model type, null if no constraint is associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model type, null if no constraint is associated.
	 * @param isMetamodelExtension
	 *            True if the new model type is extending the supertype's
	 *            metamodel, false otherwise.
	 * @throws MMTFException
	 *             If the uri of the new model type is already registered in the
	 *             Type MID.
	 */
	public static void addLightModelType(Model newModelType, Model modelType, String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelType);
		addLightType(newModelType, modelType, modelType, null, newModelTypeName, multiModel);
		addModelType(newModelType, false, constraintLanguage, constraintImplementation, multiModel);
		newModelType.setOrigin(ModelOrigin.CREATED);
		newModelType.setFileExtension(modelType.getFileExtension());

		if (isMetamodelExtension) {
			try {
				String newMetamodelUri = MultiModelTypeRegistry.getExtendedMetamodelUri(newModelType);
				if (newMetamodelUri == null) { // create new metamodel file
					EPackage newEPackage = EcoreFactory.eINSTANCE.createEPackage();
					newEPackage.setName(newModelTypeName.toLowerCase());
					newEPackage.setNsPrefix(newModelTypeName.toLowerCase());
					newEPackage.setNsURI(newModelType.getUri());
					EAnnotation newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					newEAnnotation.setSource(EcorePackage.eNS_URI);
					EMap<String, String> newEAnnotationDetails = newEAnnotation.getDetails();
					newEAnnotationDetails.put(ECORE_INVOCATION_DELEGATE, ECORE_PIVOT_URI);
					newEAnnotationDetails.put(ECORE_SETTING_DELEGATE, ECORE_PIVOT_URI);
					newEAnnotationDetails.put(ECORE_VALIDATION_DELEGATE, ECORE_PIVOT_URI);
					newEPackage.getEAnnotations().add(newEAnnotation);
					EClass newRootEClass = EcoreFactory.eINSTANCE.createEClass();
					newRootEClass.setName(newModelTypeName);
					if (!MultiModelTypeHierarchy.isRootType(modelType)) {
						EClass rootEClass = (EClass) ((EPackage) MultiModelTypeIntrospection.getRoot(modelType)).getEClassifiers().get(0);
						newRootEClass.getESuperTypes().add(rootEClass);
					}
					newEPackage.getEClassifiers().add(newRootEClass);
					newMetamodelUri = newModelTypeName + "." + EcorePackage.eNAME;
					MultiModelUtils.createModelFileInState(newEPackage, newMetamodelUri);
				}
				newModelType.setFileExtension(ECORE_REFLECTIVE_FILE_EXTENSION);
			}
			catch (Exception e) {
				MMTFException.print(Type.WARNING, "Error creating extended metamodel file, fallback to no extension", e);
				newModelType.setFileExtension(modelType.getFileExtension());
				isMetamodelExtension = false;
			}
		}
		else {
			newModelType.setFileExtension(modelType.getFileExtension());
		}

		// create editors
		String newEditorTypeFragmentUri = newModelType.getName(), newEditorTypeName, modelTypeUri = newModelType.getUri(), editorId, wizardId, wizardDialogClassName;
		EClass newEditorTypeClass;
		for (Editor editorType : modelType.getEditors()) {
			if (isMetamodelExtension) {
				if (editorType instanceof Diagram) {
					continue;
				}
				newEditorTypeName = MMTF.ROOT_EDITOR_NAME;
				editorId = MMTF.ROOT_EDITOR_ID;
				wizardId = null;
				wizardDialogClassName = null;
			}
			else {
				newEditorTypeName = editorType.getName();
				editorId = editorType.getId();
				wizardId = editorType.getWizardId();
				wizardDialogClassName = editorType.getWizardDialogClass();
			}
			newEditorTypeClass = editorType.eClass();
			try {
				//TODO MMTF: a new editor is created instead of attaching existing ones
				//TODO MMTF: because I couldn't find a way then from an editor to understand which model was being created
				Editor newEditorType = createLightEditorType(editorType, newEditorTypeFragmentUri, newEditorTypeName, modelTypeUri, editorId, wizardId, wizardDialogClassName, newEditorTypeClass);
				addModelTypeEditor(newEditorType, newModelType);
				if (isMetamodelExtension) { // reflective editor only
					newEditorType.getFileExtensions().clear();
					newEditorType.getFileExtensions().add(ECORE_REFLECTIVE_FILE_EXTENSION);
					break;
				}
			}
			catch (MMTFException e) {
				// models created through this editor will have the supermodel as static type
				addModelTypeEditor(editorType, newModelType);
			}
		}
	}

	/**
	 * Creates and adds a "light" model type to the Type MID.
	 * 
	 * @param modelType
	 *            The supertype of the new model type.
	 * @param newModelTypeName
	 *            The name of the new model type.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model type, null if no constraint is associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model type, null if no constraint is associated.
	 * @param isMetamodelExtension
	 *            True if the new model type is extending the supertype's
	 *            metamodel, false otherwise.
	 * @return The created model type.
	 * @throws MMTFException
	 *             If the uri of the new model type is already registered in the
	 *             Type MID.
	 */
	public static Model createLightModelType(Model modelType, String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMTFException {

		Model newModelType = MidFactory.eINSTANCE.createModel();
		addLightModelType(newModelType, modelType, newModelTypeName, constraintLanguage, constraintImplementation, isMetamodelExtension);

		return newModelType;
	}

	/**
	 * Creates and adds a "light" model element type and a reference to it to
	 * the Type MID.
	 * 
	 * @param modelElemType
	 *            The supertype of the new model element type.
	 * @param modelElemTypeRef
	 *            The reference to the supertype of the new model element type,
	 *            null if such reference doesn't exist in the model type
	 *            endpoint reference container.
	 * @param newModelElemTypeName
	 *            The name of the new model element type.
	 * @param classLiteral
	 *            The class name of the new model element type.
	 * @param modelTypeEndpointRef
	 *            The reference to the model type endpoint that will contain the
	 *            new reference to the model element type.
	 * @return The created reference to the new model element type.
	 * @throws MMTFException
	 *             If the uri of the new model element type is already
	 *             registered in the Type MID.
	 */
	public static ModelElementReference createLightModelElementTypeAndModelElementTypeReference(ModelElement modelElemType, ModelElementReference modelElemTypeRef, String newModelElemTypeName, String classLiteral, ModelEndpointReference modelTypeEndpointRef) throws MMTFException {

		ModelRel modelRelType = (ModelRel) modelTypeEndpointRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		String newTypeUri = createNewLightTypeUri(modelTypeEndpointRef.getObject(), modelTypeEndpointRef.getObject().getName(), newModelElemTypeName);
		ModelElement newModelElemType = MultiModelRegistry.getExtendibleElement(newTypeUri, multiModel);
		if (newModelElemType == null) {
			// create the "thing"
			newModelElemType = MidFactory.eINSTANCE.createModelElement();
			addLightType(newModelElemType, modelElemType, modelTypeEndpointRef.getObject(), modelTypeEndpointRef.getObject().getName(), newModelElemTypeName, multiModel);
			addModelElementType(newModelElemType, classLiteral, modelTypeEndpointRef.getObject().getTarget());
		}
		// create the reference of the "thing"
		ModelElementReference newModelElemTypeRef = createModelElementTypeReference(newModelElemType, modelElemTypeRef, true, modelTypeEndpointRef);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
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

	/**
	 * Creates and adds a "light" model relationship type to the Type MID.
	 * 
	 * @param modelRelType
	 *            The supertype of the new model relationship type.
	 * @param newModelRelTypeName
	 *            The name of the new model relationship type.
	 * @param newModelRelTypeClass
	 *            The class of the new model relationship type.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model relationship type, null if no constraint is
	 *            associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model relationship type, null if no constraint is
	 *            associated.
	 * @return The created model relationship type.
	 * @throws MMTFException
	 *             If the uri of the new model relationship type is already
	 *             registered in the Type MID.
	 */
	public static ModelRel createLightModelRelType(ModelRel modelRelType, String newModelRelTypeName, EClass newModelRelTypeClass, String constraintLanguage, String constraintImplementation) throws MMTFException {

		ModelRel newModelRelType = (ModelRel) RelationshipFactory.eINSTANCE.create(newModelRelTypeClass);
		addLightModelType(newModelRelType, modelRelType, newModelRelTypeName, constraintLanguage, constraintImplementation, false);
		addModelRelType(newModelRelType, modelRelType);

		return newModelRelType;
	}

	/**
	 * Creates and adds a "light" model type endpoint and a reference to it to
	 * the Type MID.
	 * 
	 * @param modelTypeEndpoint
	 *            The supertype of the new model type endpoint.
	 * @param modelTypeEndpointRef
	 *            The reference to the supertype of the new model type endpoint,
	 *            null if such reference doesn't exist in the model relationship
	 *            type container.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param isBinarySrc
	 *            True if the model type endpoint is the source in the binary
	 *            model relationship type container, false otherwise.
	 * @param modelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the model type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model type endpoint is already
	 *             registered in the Type MID.
	 */
	public static ModelEndpointReference createLightModelTypeEndpointAndModelTypeEndpointReference(ModelEndpoint modelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, boolean isBinarySrc, ModelRel modelRelType) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		// create the "thing" and the corresponding reference
		ModelEndpoint newModelTypeEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		addLightType(newModelTypeEndpoint, modelTypeEndpoint, modelRelType, modelRelType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelType.getName(), newModelTypeEndpointName, multiModel);
		addModelTypeEndpoint(newModelTypeEndpoint, newModelType, isBinarySrc, modelRelType);
		ModelEndpointReference newModelTypeEndpointRef = createModelTypeEndpointReference(newModelTypeEndpoint, modelTypeEndpointRef, true, isBinarySrc, modelRelType);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			createModelTypeEndpointReference(newModelTypeEndpoint, modelSubtypeEndpointRef, false, isBinarySrc, modelRelSubtype);
		}

		return newModelTypeEndpointRef;
	}

	/**
	 * Replaces an old "light" model type endpoint and a reference to it with
	 * new ones in the Type MID.
	 * 
	 * @param oldModelTypeEndpoint
	 *            The old model type endpoint to be replaced.
	 * @param modelTypeEndpoint
	 *            The supertype of the new model type endpoint.
	 * @param modelTypeEndpointRef
	 *            The reference to the supertype of the new model type endpoint,
	 *            null if such reference doesn't exist in the model relationship
	 *            type container.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param modelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model type endpoint is already
	 *             registered in the Type MID.
	 */
	public static void replaceLightModelTypeEndpointAndModelTypeEndpointReference(ModelEndpoint oldModelTypeEndpoint, ModelEndpoint modelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, String newModelTypeEndpointName, Model newModelType, ModelRel modelRelType) throws MMTFException {

		// modify the "thing" and the corresponding reference
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		addLightType(oldModelTypeEndpoint, modelTypeEndpoint, modelRelType, modelRelType.getName() + MMTF.ENDPOINT_SEPARATOR + newModelType.getName(), newModelTypeEndpointName, multiModel);
		oldModelTypeEndpoint.setTarget(newModelType);
		if (modelTypeEndpointRef != null) {
			ModelEndpointReference oldModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelTypeEndpoint.getUri(), modelRelType.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelTypeEndpointRef);
		}
		// modify references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			ModelEndpointReference modelSubtypeEndpointRef = (modelTypeEndpointRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelEndpointReference oldModelTypeEndpointRef = MultiModelTypeHierarchy.getReference(oldModelTypeEndpoint.getUri(), modelRelSubtype.getModelEndpointRefs());
			oldModelTypeEndpointRef.setSupertypeRef(modelSubtypeEndpointRef);
		}
	}

	/**
	 * Creates and adds a "light" link type and a reference to it to the Type
	 * MID.
	 * 
	 * @param linkType
	 *            The supertype of the new link type.
	 * @param linkTypeRef
	 *            The reference to the supertype of the new link type, null if
	 *            such reference doesn't exist in the model relationship type
	 *            container.
	 * @param newLinkTypeName
	 *            The name of the new link type.
	 * @param newLinkTypeClass
	 *            The class of the new link type.
	 * @param newLinkTypeRefClass
	 *            The class of the new reference to the new link type.
	 * @param modelRelType
	 *            The model relationship type that will contain the new link
	 *            type.
	 * @return The created reference to the link type.
	 * @throws MMTFException
	 *             If the uri of the new link type is already registered in the
	 *             Type MID.
	 */
	public static LinkReference createLightLinkTypeAndLinkTypeReference(Link linkType, LinkReference linkTypeRef, String newLinkTypeName, EClass newLinkTypeClass, EClass newLinkTypeRefClass, ModelRel modelRelType) throws MMTFException {

		// create the "thing" and the corresponding reference
		Link newLinkType = (Link) RelationshipFactory.eINSTANCE.create(newLinkTypeClass);
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		addLightType(newLinkType, linkType, modelRelType, modelRelType.getName(), newLinkTypeName, multiModel);
		addLinkType(newLinkType, linkType, modelRelType);
		LinkReference newLinkTypeRef = createLinkTypeReference(newLinkType, linkTypeRef, newLinkTypeRefClass, true, modelRelType);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			LinkReference linkSubtypeRef = (linkTypeRef == null) ?
				null :
				MultiModelTypeHierarchy.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			createLinkTypeReference(newLinkType, linkSubtypeRef, newLinkTypeRefClass, false, modelRelSubtype);
		}

		return newLinkTypeRef;
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

	/**
	 * Creates and adds a "light" editor type to the Type MID.
	 * 
	 * @param editorType
	 *            The supertype of the new editor type.
	 * @param newEditorTypeFragmentUri
	 *            The uri fragment to be appended as part of the uri of the new
	 *            editor type.
	 * @param newEditorTypeName
	 *            The name of the new editor type.
	 * @param modelTypeUri
	 *            The uri of the model type handled by the new editor type.
	 * @param editorId
	 *            The id of the corresponding Eclipse editor.
	 * @param wizardId
	 *            The wizard id of the corresponding Eclipse editor.
	 * @param wizardDialogClassName
	 *            The fully qualified name of a Java class that handles the
	 *            creation of the model type through the new editor type.
	 * @param newEditorTypeClass
	 *            The class of the new editor type.
	 * @return The created editor type.
	 * @throws MMTFException
	 *             If the uri of the new editor type is already registered in
	 *             the Type MID.
	 */
	public static Editor createLightEditorType(Editor editorType, String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, EClass newEditorTypeClass) throws MMTFException {

		Editor newEditorType = (Editor) EditorFactory.eINSTANCE.create(newEditorTypeClass);
		MultiModel multiModel = MultiModelRegistry.getMultiModel(editorType);
		addLightType(newEditorType, editorType, editorType, newEditorTypeFragmentUri, newEditorTypeName, multiModel);
		addEditorType(newEditorType, modelTypeUri, editorId, wizardId, wizardDialogClassName, multiModel);

		for (String fileExtension : editorType.getFileExtensions()) {
			newEditorType.getFileExtensions().add(fileExtension);
		}

		return newEditorType;
	}

	/**
	 * Copies the components of an old "light" model relationship type into a
	 * new one in the Type MID.
	 * 
	 * @param oldModelRelType
	 *            The old model relationship type.
	 * @param newModelRelType
	 *            The new model relationship type.
	 * @throws MMTFException
	 *             If any uri of the components of the new model relationship
	 *             type is already registered in the Type MID.
	 */
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
			modelTypeEndpoint.createSubtypeAndReference(modelTypeEndpointRef, oldModelTypeEndpoint.getName(), newModelType, false, newModelRelType);
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
					modelElemType,
					modelElemTypeRef,
					oldModelElemTypeRef.getObject().getName(),
					oldModelElemTypeRef.getObject().getClassLiteral(),
					newModelTypeEndpointRef
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
				linkType,
				linkTypeRef,
				oldLinkType.getName(),
				oldLinkType.eClass(),
				newLinkTypeRefClass,
				newModelRelType
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
					modelElemTypeEndpoint,
					modelElemTypeEndpointRef,
					oldModelElemTypeEndpointRef.getObject().getName(),
					newModelElemTypeRef,
					false,
					newLinkTypeRef
				);
			}
		}
	}

}
