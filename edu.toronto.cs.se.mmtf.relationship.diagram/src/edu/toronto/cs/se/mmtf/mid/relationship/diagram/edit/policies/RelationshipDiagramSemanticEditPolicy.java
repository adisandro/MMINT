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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkNewNaryLinkCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelReferenceImportModelCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * The semantic edit policy for the Relationship diagram (i.e. a model
 * relationship).
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramSemanticEditPolicy extends ModelRelItemSemanticEditPolicy {

	/**
	 * Gets the command to create a new element in the diagram.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		if (MidElementTypes.ModelReference_2001 == req.getElementType()) {
			return getGEFWrapper(new ModelReferenceImportModelCommand(req));
		}
		if (MidElementTypes.Link_2002 == req.getElementType()) {
			return getGEFWrapper(new LinkNewNaryLinkCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
