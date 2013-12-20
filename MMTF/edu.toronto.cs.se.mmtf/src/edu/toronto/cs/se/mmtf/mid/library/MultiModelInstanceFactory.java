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
package edu.toronto.cs.se.mmtf.mid.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * The factory to create/modify/remove instances.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelInstanceFactory {

	/** The empty uri. */
	public final static String EMPTY_URI = "";
	/** The empty name. */
	public final static String EMPTY_NAME = "";
	/** The empty file extension for a model. */
	public final static String EMPTY_MODEL_FILE_EXTENSION = "";

	/**
	 * Adds an instance to an Instance MID.
	 * 
	 * @param newInstance
	 *            The new instance to be added.
	 * @param type
	 *            The type of the new instance.
	 * @param newInstanceUri
	 *            The uri of the new instance.
	 * @param newInstanceName
	 *            The name of the new instance.
	 * @param multiModel
	 *            An Instance MID.
	 * @throws MMTFException
	 *             If the uri of the new instance is already registered in the
	 *             Instance MID.
	 */
	public static void addInstance(ExtendibleElement newInstance, ExtendibleElement type, String newInstanceUri, String newInstanceName, MultiModel multiModel) throws MMTFException {

		if (multiModel.getExtendibleTable().containsKey(newInstanceUri)) {
			throw new MMTFException("Instance with uri " + newInstanceUri + " is already registered");
		}
		multiModel.getExtendibleTable().put(newInstanceUri, newInstance);

		addBasicInstance(newInstance, type, newInstanceUri, newInstanceName);
	}

	/**
	 * Adds an instance to an Instance MID without registering its uri.
	 * 
	 * @param newInstance
	 *            The new instance to be added.
	 * @param type
	 *            The type of the new instance.
	 * @param newInstanceUri
	 *            The uri of the new instance.
	 * @param newInstanceName
	 *            The name of the new instance.
	 */
	public static void addBasicInstance(ExtendibleElement newInstance, ExtendibleElement type, String newInstanceUri, String newInstanceName) {

		if (newInstanceUri == null) {
			newInstanceUri = EMPTY_URI;
		}
		newInstance.setUri(newInstanceUri);
		if (newInstanceName == null) {
			newInstanceName = EMPTY_NAME;
		}
		newInstance.setName(newInstanceName);
		newInstance.setLevel(MidLevel.INSTANCES);
		newInstance.setDynamic(true);
		newInstance.setSupertype(null);
		//TODO MMTF[OO] this might be a corner case, is it still used?
		if (type == null) { // use type introspection
			List<ExtendibleElement> elementTypes = MultiModelTypeIntrospection.getRuntimeTypes(newInstance);
			type = elementTypes.get(elementTypes.size()-1);
			//TODO MMTF: ask the user?
		}
		newInstance.setMetatypeUri(type.getUri());
	}

	/**
	 * Adds the target to a new instance endpoint.
	 * 
	 * @param newInstanceEndpoint
	 *            The new instance endpoint.
	 * @param newInstance
	 *            The new instance that is the target of the new instance
	 *            endpoint.
	 */
	public static void addInstanceEndpoint(ExtendibleElementEndpoint newInstanceEndpoint, ExtendibleElement newInstance) {

		newInstanceEndpoint.setTarget(newInstance);
		newInstanceEndpoint.setLowerBound(1);
		newInstanceEndpoint.setUpperBound(1);
	}

	/**
	 * Adds additional info for a reference to an instance.
	 * 
	 * @param newInstanceRef
	 *            The new reference being added.
	 * @param newInstance
	 *            The new instance for which the reference was created.
	 * @param isContainer
	 *            True if the new reference is also the actual container of the
	 *            new instance and not just a pointer to it, false otherwise.
	 */
	public static void addInstanceReference(ExtendibleElementReference newInstanceRef, ExtendibleElement newInstance, boolean isContainer) {

		if (isContainer) {
			newInstanceRef.setContainedObject(newInstance);
		}
		else {
			newInstanceRef.setReferencedObject(newInstance);
		}
		newInstanceRef.setModifiable(true);
		newInstanceRef.setSupertypeRef(null);
	}

	/**
	 * Creates and adds a reference to a model element to an Instance MID.
	 * 
	 * @param newModelElem
	 *            The model element for which the reference is being created.
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the model element.
	 * @return The created reference to the model element.
	 */
	public static ModelElementReference createModelElementReference(ModelElement newModelElem, ModelEndpointReference modelEndpointRef) {

		ModelElementReference newModelElemRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		addInstanceReference(newModelElemRef, newModelElem, false);
		modelEndpointRef.getModelElemRefs().add(newModelElemRef);

		return newModelElemRef;
	}

	/**
	 * Creates and adds a model element and a reference to it to an Instance
	 * MID.
	 * 
	 * @param modelElemType
	 *            The type of the new model element.
	 * @param newModelElemUri
	 *            The uri of the new model element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param classLiteral
	 *            The class name of the new model element.
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the model element.
	 * @return The created reference to the new model element.
	 * @throws MMTFException
	 *             If the uri of the new model element is already registered in
	 *             the Instance MID.
	 */
	public static ModelElementReference createModelElementAndModelElementReference(ModelElement modelElemType, String newModelElemUri, String newModelElemName, String classLiteral, ModelEndpointReference modelEndpointRef) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelEndpointRef);

		newModelElemUri += MMTF.ROLE_SEPARATOR + modelElemType.getUri();
		ModelElement newModelElem = MultiModelRegistry.getExtendibleElement(newModelElemUri, multiModel);
		if (newModelElem == null) {
			newModelElem = MidFactory.eINSTANCE.createModelElement();
			addInstance(newModelElem, modelElemType, newModelElemUri, newModelElemName, multiModel);
			newModelElem.setClassLiteral(classLiteral);
			modelEndpointRef.getObject().getTarget().getModelElems().add(newModelElem);
		}
		ModelElementReference newModelElemRef = createModelElementReference(newModelElem, modelEndpointRef);

		return newModelElemRef;
	}

	/**
	 * Creates and adds a model element and a reference to it to an Instance
	 * MID.
	 * 
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param modelObj
	 *            The EMF model element, that will be wrapped by the MMTF model
	 *            element.
	 * @param modelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the model element.
	 * @return The reference to the new model element.
	 * @throws MMTFException
	 *             If the uri of the new model element is already registered in
	 *             the Instance MID.
	 */
	public static ModelElementReference createModelElementAndModelElementReference(String newModelElemName, EObject modelObj, ModelEndpointReference modelEndpointRef) throws MMTFException {

		ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelObj);
		String newModelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, true)[1];
		String classLiteral = MultiModelRegistry.getModelElementClassLiteral(modelObj, true);
		if (newModelElemName == null) {
			newModelElemName = MultiModelRegistry.getModelElementName(modelObj, true);
		}
		ModelElementReference newModelElemRef = createModelElementAndModelElementReference(
			modelElemType,
			newModelElemUri,
			newModelElemName,
			classLiteral,
			modelEndpointRef
		);

		return newModelElemRef;
	}

	/**
	 * Creates and adds a model relationship and its model endpoints to an
	 * Instance MID.
	 * 
	 * @param modelRelType
	 *            The type of the new model relationship.
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model
	 *            relationship is not in a separate file; e.g. a standalone
	 *            model relationship is in its own files, a plain model
	 *            relationship is not.
	 * @param newModelRelClass
	 *            The class of the new model relationship.
	 * @param origin
	 *            The origin of the new model relationship.
	 * @param newModels
	 *            The new models that are the targets of the new model
	 *            endpoints.
	 * @return The created model relationship.
	 * @throws MMTFException
	 *             If the uri of the new model relationship is already
	 *             registered in the Instance MID.
	 */
	public static ModelRel createModelRelAndModelEndpointsAndModelEndpointReferences(ModelRel modelRelType, String newModelRelUri, EClass newModelRelClass, ModelOrigin origin, Model... newModels) throws MMTFException {

		if (newModels.length == 0) {
			return null;
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(newModels[0]);
		// create model rel
		ModelRel newModelRel = modelRelType.createInstance(newModelRelUri, (BinaryModelRel.class.isAssignableFrom(newModelRelClass.getClass())), origin, multiModel);
		// create model rel endpoints
		for (Model model : newModels) {
			String modelEndpointTypeUri = MultiModelConstraintChecker.getAllowedModelEndpoints(modelRelType, model).get(0);
			ModelEndpoint modelEndpointType = MultiModelTypeRegistry.getType(modelEndpointTypeUri);
			modelEndpointType.createInstanceAndReference(model, false, newModelRel);
		}

		return newModelRel;
	}

	/**
	 * Creates and adds a link, a reference to it, its model endpoints and
	 * references to them to an Instance MID.
	 * 
	 * @param linkType
	 *            The type of the new link.
	 * @param newLinkClass
	 *            The class of the new link.
	 * @param newLinkRefClass
	 *            The class of the new reference to the new link.
	 * @param newModelElemRefs
	 *            The new references to the model elements that are the targets
	 *            of the new model element endpoints.
	 * @return The created reference to the new link.
	 * @throws MMTFException 
	 */
	public static LinkReference createLinkAndLinkReferenceAndModelElementEndpointsAndModelElementEndpointReferences(Link linkType, EClass newLinkClass, EClass newLinkRefClass, ModelElementReference... newModelElemRefs) throws MMTFException {

		if (newModelElemRefs.length == 0) {
			return null;
		}

		ModelRel modelRel = (ModelRel) newModelElemRefs[0].eContainer().eContainer();
		// create link
		LinkReference newLinkRef = linkType.createInstanceAndReference((BinaryLink.class.isAssignableFrom(newLinkClass.getClass())), modelRel);
		// create model element endpoints
		for (ModelElementReference modelElemRef : newModelElemRefs) {
			ModelElementEndpointReference newModelElemEndpointRef = createModelElementEndpointAndModelElementEndpointReference(
				null,
				modelElemRef,
				false,
				newLinkRef
			);
			newModelElemEndpointRef.getObject().setName(modelElemRef.getObject().getName());
		}

		return newLinkRef;
	}

	/**
	 * Creates and adds a model element endpoint and a reference to it to an
	 * Instance MID.
	 * 
	 * @param modelElemTypeEndpoint
	 *            The type of the new model element endpoint.
	 * @param newModelElemRef
	 *            The reference to the new model element that is the target of
	 *            the new model element endpoint.
	 * @param isBinarySrc
	 *            True if the model element endpoint is the source in the binary
	 *            link container, false otherwise.
	 * @param linkRef
	 *            The reference to the link that will contain the new model
	 *            element endpoint.
	 * @return The created reference to the new model element endpoint.
	 */
	public static ModelElementEndpointReference createModelElementEndpointAndModelElementEndpointReference(ModelElementEndpoint modelElemTypeEndpoint, ModelElementReference newModelElemRef, boolean isBinarySrc, LinkReference linkRef) {

		ModelElementEndpoint newModelElemEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		addBasicInstance(newModelElemEndpoint, modelElemTypeEndpoint, null, newModelElemRef.getObject().getName());
		addInstanceEndpoint(newModelElemEndpoint, newModelElemRef.getObject());
		if (isBinarySrc) {
			linkRef.getObject().getModelElemEndpoints().add(0, newModelElemEndpoint);
		}
		else {
			linkRef.getObject().getModelElemEndpoints().add(newModelElemEndpoint);
		}
		ModelElementEndpointReference modelElemEndpointRef = createModelElementEndpointReference(newModelElemEndpoint, newModelElemRef, isBinarySrc, linkRef);
		linkRef.getObject().getModelElemEndpointRefs().add(modelElemEndpointRef);

		return modelElemEndpointRef;
	}

	/**
	 * Creates and adds a reference to a model element endpoint to an Instance
	 * MID.
	 * 
	 * @param newModelElemEndpoint
	 *            The model element endpoint for which the reference is being
	 *            created.
	 * @param newModelElemRef
	 *            The reference to the new model element that is the target of
	 *            the new model element endpoint.
	 * @param isBinarySrc
	 *            True if the reference to the model element endpoint is the
	 *            source in the binary link reference container, false
	 *            otherwise.
	 * @param linkRef
	 *            The reference to the link that will contain the new model
	 *            element endpoint.
	 * @return The created reference to the model element endpoint.
	 */
	public static ModelElementEndpointReference createModelElementEndpointReference(ModelElementEndpoint newModelElemEndpoint, ModelElementReference newModelElemRef, boolean isBinarySrc, LinkReference linkRef) {

		ModelElementEndpointReference newModelElemEndpointRef = RelationshipFactory.eINSTANCE.createModelElementEndpointReference();
		boolean isContainer = linkRef.eContainer().eContainer() == null;
		addInstanceReference(newModelElemEndpointRef, newModelElemEndpoint, isContainer);
		newModelElemEndpointRef.setModelElemRef(newModelElemRef);

		if (isBinarySrc) {
			linkRef.getModelElemEndpointRefs().add(0, newModelElemEndpointRef);
		} 
		else {
			linkRef.getModelElemEndpointRefs().add(newModelElemEndpointRef);
		}

		return newModelElemEndpointRef;
	}

	/**
	 * Replaces an old model element endpoint and a reference to it with new
	 * ones in an Instance MID.
	 * 
	 * @param oldModelElemEndpointRef
	 *            The reference to the old model element endpoint to be
	 *            replaced.
	 * @param modelElemTypeEndpoint
	 *            The type of the new model element endpoint.
	 * @param newModelElemRef
	 *            The reference to the new model element that is the target of
	 *            the new model element endpoint.
	 */
	public static void replaceModelElementEndpointAndModelElementEndpointReference(ModelElementEndpointReference oldModelElemEndpointRef, ModelElementEndpoint modelElemTypeEndpoint, ModelElementReference newModelElemRef) {

		ModelElementEndpoint oldModelElemEndpoint = oldModelElemEndpointRef.getObject();
		addBasicInstance(oldModelElemEndpoint, modelElemTypeEndpoint, null, null);
		oldModelElemEndpoint.setTarget(newModelElemRef.getObject());
		oldModelElemEndpointRef.setModelElemRef(newModelElemRef);
	}

	/**
	 * Adds an editor to its model and to an Instance MID.
	 * 
	 * @param editor
	 *            The editor.
	 * @param multiModel
	 *            The Instance MID.
	 */
	public static void addModelEditor(Editor editor, MultiModel multiModel) {

		Model model = MultiModelRegistry.getExtendibleElement(editor.getModelUri(), multiModel);
		if (model != null) {
			model.getEditors().add(editor);
			multiModel.getEditors().add(editor);
		}
	}

	/**
	 * Removes an instance from an Instance MID.
	 * 
	 * @param instanceUri
	 *            The uri of the instance to be removed.
	 * @param multiModel
	 *            The Instance MID that contains the instance.
	 * @return The removed instance, null if the uri was not registered in the
	 *         Instance MID.
	 */
	public static ExtendibleElement removeInstance(String instanceUri, MultiModel multiModel) {

		return multiModel.getExtendibleTable().removeKey(instanceUri);
	}

	/**
	 * Removes a model element endpoint and the reference to it from the
	 * Instance MID that contains them.
	 * 
	 * @param modelElemEndpointRef
	 *            The reference to be removed to the model element endpoint to
	 *            be removed.
	 * @param isFullRemove
	 *            True if the model element endpoint is going to be fully
	 *            removed, false if it is going to be replaced later.
	 */
	public static void removeModelElementEndpointAndModelElementEndpointReference(ModelElementEndpointReference modelElemEndpointRef, boolean isFullRemove) {

		LinkReference linkRef = (LinkReference) modelElemEndpointRef.eContainer();
		Link link = linkRef.getObject();
		if (isFullRemove) {
			link.getModelElemEndpoints().remove(modelElemEndpointRef.getObject());
			linkRef.getModelElemEndpointRefs().remove(modelElemEndpointRef);
			link.getModelElemEndpointRefs().remove(modelElemEndpointRef);
			modelElemEndpointRef.setModelElemRef(null);
		}
	}

	/**
	 * Removes a reference to a model element from the Instance MID that
	 * contains it.
	 * 
	 * @param modelElemRef
	 *            The reference to be removed to the modle element.
	 */
	public static void removeModelElementReference(ModelElementReference modelElemRef) {

		List<LinkReference> delLinkRefs = new ArrayList<LinkReference>();
		List<ModelElementEndpointReference> delModelElemEndpointRefs = new ArrayList<ModelElementEndpointReference>();
		for (ModelElementEndpointReference modelElemEndpointRef : modelElemRef.getModelElemEndpointRefs()) {
			LinkReference linkRef = (LinkReference) modelElemEndpointRef.eContainer();
			if (linkRef instanceof BinaryLinkReference) {
				if (!delLinkRefs.contains(linkRef)) {
					delLinkRefs.add(linkRef);
				}
			}
			else {
				if (!delModelElemEndpointRefs.contains(modelElemEndpointRef)) {
					delModelElemEndpointRefs.add(modelElemEndpointRef);
				}
			}
		}
		for (LinkReference linkRef : delLinkRefs) {
			try {
				linkRef.deleteInstanceAndReference();
			}
			catch (MMTFException e) {
				//TODO MMTF[OO] remove this
			}
		}
		for (ModelElementEndpointReference modelElemEndpointRef : delModelElemEndpointRefs) {
			removeModelElementEndpointAndModelElementEndpointReference(modelElemEndpointRef, true);
		}

		((ModelEndpointReference) modelElemRef.eContainer()).getModelElemRefs().remove(modelElemRef);
	}

	/**
	 * Removes a model element and the reference to it from the Instance MID
	 * that contains them.
	 * 
	 * @param modelElemRef
	 *            The reference to be removed to the model element to be
	 *            removed.
	 */
	public static void removeModelElementAndModelElementReference(ModelElementReference modelElemRef) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelElemRef);
		removeInstance(modelElemRef.getUri(), multiModel);
		removeModelElementReference(modelElemRef);
		ModelElement modelElem = modelElemRef.getObject();
		((Model) modelElem.eContainer()).getModelElems().remove(modelElem);
		//TODO MMTF: should remove from all model rels too?
	}

}
