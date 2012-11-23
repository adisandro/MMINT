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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.trait;

import java.util.List;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.ui.MultiModelTreeSelectionDialog;

/**
 * A container for common functions of a Relationship diagram.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramTrait extends MidDiagramTrait {

	public static LinkReference selectLinkTypeReferenceToCreate(ModelRel modelRel, ModelElementReference srcModelElemRef, ModelElementReference tgtModelElemRef) throws MMTFException {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getLinkReferenceCreationDialog(modelRel, srcModelElemRef, tgtModelElemRef);
		String title = "Create new link";
		String message = "Choose link type";

		return (LinkReference) openSelectDialog(dialog, title, message);
	}

	public static LinkReference selectLinkTypeReferenceToExtend(ModelRel modelRelType, ModelElementReference srcModelElemTypeRef, ModelElementReference tgtModelElemTypeRef) throws MMTFException {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getLinkTypeReferenceCreationDialog(modelRelType, srcModelElemTypeRef, tgtModelElemTypeRef);
		String title = "Create new light link type";
		String message = "Choose link supertype";

		return (LinkReference) openSelectDialog(dialog, title, message);
	}

	public static ModelElementEndpointReference selectModelElementTypeEndpointToCreate(LinkReference linkRef, List<String> modelElemTypeEndpointUris) throws MMTFException {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelElementEndpointCreationDialog(linkRef, modelElemTypeEndpointUris);
		String title = "Create new model endpoint";
		String message = "Choose model type endpoint role";

		return (ModelElementEndpointReference) openSelectDialog(dialog, title, message);
	}

}
