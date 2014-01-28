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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
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
	 * @param isbinary
	 *            x.
	 * @param origin
	 *            The origin of the new model relationship.
	 * @param targetModels
	 *            The models that are the targets of the new model
	 *            endpoints.
	 * @return The created model relationship.
	 * @throws MMTFException
	 *             If the uri of the new model relationship is already
	 *             registered in the Instance MID.
	 */
	public static ModelRel createModelRelAndModelEndpointsAndModelEndpointReferences(ModelRel modelRelType, String newModelRelUri, boolean isBinary, ModelOrigin origin, Model... targetModels) throws MMTFException {

		if (targetModels.length == 0) {
			return null;
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(targetModels[0]);
		// create model rel
		ModelRel newModelRel = modelRelType.createInstance(newModelRelUri, isBinary, origin, multiModel);
		// create model rel endpoints
		for (Model targetModel : targetModels) {
			String modelTypeEndpointUri = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, targetModel).get(0);
			ModelEndpoint modelTypeEndpoint = MultiModelTypeRegistry.getType(modelTypeEndpointUri);
			modelTypeEndpoint.createInstanceAndReference(targetModel, false, newModelRel);
		}

		return newModelRel;
	}

	/**
	 * Creates and adds a link, a reference to it, its model endpoints and
	 * references to them to an Instance MID.
	 * 
	 * @param linkType
	 *            The type of the new link.
	 * @param isBinary
	 *            x.
	 * @param targetModelElemRefs
	 *            The references to the model elements that are the targets of
	 *            the new model element endpoints.
	 * @return The created reference to the new link.
	 * @throws MMTFException
	 */
	public static LinkReference createLinkAndLinkReferenceAndModelElementEndpointsAndModelElementEndpointReferences(Link linkType, boolean isBinary, ModelElementReference... targetModelElemRefs) throws MMTFException {

		if (targetModelElemRefs.length == 0) {
			return null;
		}

		ModelRel containerModelRel = (ModelRel) targetModelElemRefs[0].eContainer().eContainer();
		// create link
		LinkReference newLinkRef = linkType.createInstanceAndReference(isBinary, containerModelRel);
		// create model element endpoints
		for (ModelElementReference targetModelElemRef : targetModelElemRefs) {
			String modelElemTypeEndpointUri = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(newLinkRef, targetModelElemRef).get(0);
			ModelElementEndpoint modelElemTypeEndpoint = MultiModelTypeRegistry.getType(modelElemTypeEndpointUri);
			modelElemTypeEndpoint.createInstanceAndReference(targetModelElemRef, false, newLinkRef);
		}

		return newLinkRef;
	}

}
