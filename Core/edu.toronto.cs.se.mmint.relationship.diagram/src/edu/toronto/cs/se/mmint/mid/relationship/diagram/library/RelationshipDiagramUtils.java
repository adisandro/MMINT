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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.library;

import java.util.List;

import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmint.mid.diagram.library.MidDialogCancellation;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelTreeSelectionDialog;

/**
 * A container for common functions of a Relationship diagram.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramUtils extends MidDiagramUtils {

	public static LinkReference selectLinkTypeReferenceToCreate(ModelRel modelRel, ModelElementReference srcModelElemRef, ModelElementReference tgtModelElemRef) throws MidDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getLinkReferenceCreationDialog(srcModelElemRef, tgtModelElemRef, modelRel);
		String title = "Create new link";
		String message = "Choose link type";

		return (LinkReference) openSelectDialog(dialog, title, message);
	}

	public static LinkReference selectLinkTypeReferenceToExtend(ModelRel modelRelType, ModelElementReference srcModelElemTypeRef, ModelElementReference tgtModelElemTypeRef) throws MidDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getLinkTypeReferenceCreationDialog(srcModelElemTypeRef, tgtModelElemTypeRef, modelRelType);
		String title = "Create new light link type";
		String message = "Choose link supertype";

		return (LinkReference) openSelectDialog(dialog, title, message);
	}

	public static ModelElementEndpointReference selectModelElementTypeEndpointToCreate(LinkReference linkRef, List<String> modelElemTypeEndpointUris) throws MidDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelElementEndpointCreationDialog(linkRef, modelElemTypeEndpointUris);
		String title = "Create new model endpoint";
		String message = "Choose model type endpoint role";

		return (ModelElementEndpointReference) openSelectDialog(dialog, title, message);
	}

}
