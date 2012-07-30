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

import org.eclipse.jface.window.Window;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeRegistry;

/**
 * A container for common functions of a Relationship diagram.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramTrait {

	public static Link selectLinkTypeToCreate(ModelRel modelRel, ModelElementReference source, ModelElementReference target) throws Exception {

		ElementTreeSelectionDialog dialog = MultiModelTypeRegistry.getLinkCreationDialog(modelRel, source, target);
		dialog.setTitle("Create new link");
		dialog.setMessage("Choose link type");
		dialog.setAllowMultiple(false);

		if (dialog.open() == Window.CANCEL) {
			throw new MMTFException("Dialog cancel button pressed");
		}
		Object selection = dialog.getFirstResult();
		if (selection == null) {
			throw new MMTFException("Dialog ok button pressed with no selection");
		}
		Link linkType = (Link) selection;

		return linkType;
	}

}
