/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.LinkReferenceNewNaryLinkCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelEndpointReferenceImportModelCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.ModelRelItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;

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

		if (MIDElementTypes.ModelEndpointReference_2007 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpointReferenceImportModelCommand(req));
		}
		if (MIDElementTypes.LinkReference_2008 == req.getElementType()) {
			return getGEFWrapper(new LinkReferenceNewNaryLinkCommand(req));
		}
		return null;
	}

}
