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
package edu.toronto.cs.se.mmtf.mid.library;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
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
		ModelElementReference newModelElemRef = modelElemType.createInstanceAndReference(newModelElemUri, newModelElemName, classLiteral, modelEndpointRef);

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
			String modelTypeEndpointUri = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, model).get(0);
			ModelEndpoint modelTypeEndpoint = MultiModelTypeRegistry.getType(modelTypeEndpointUri);
			modelTypeEndpoint.createInstanceAndReference(model, false, newModelRel);
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
			String modelElemTypeEndpointUri = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(newLinkRef, modelElemRef).get(0);
			ModelElementEndpoint modelElemTypeEndpoint = MultiModelTypeRegistry.getType(modelElemTypeEndpointUri);
			ModelElementEndpointReference newModelElemEndpointRef = modelElemTypeEndpoint.createInstanceAndReference(modelElemRef, false, newLinkRef);
			newModelElemEndpointRef.getObject().setName(modelElemRef.getObject().getName());
		}

		return newLinkRef;
	}

}
