/*
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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.BinaryLinkReferenceChangeModelElementReferenceCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.BinaryLinkReferenceNewBinaryLinkCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.LinkReferenceAddModelElementEndpointReferenceCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.LinkReferenceChangeModelElementEndpointReferenceCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryLinkReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.ModelElementReference3ItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MidElementTypes;

/**
 * The semantic edit policy for model element references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceSuperSemanticEditPolicy extends ModelElementReference3ItemSemanticEditPolicy {

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the command to start creating a new link originating from a model
	 * element reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MidElementTypes.BinaryLinkReference_4012 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkReferenceNewBinaryLinkCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to complete the creation of a new link originating from
	 * a model element reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MidElementTypes.ModelElementEndpointReference_4011 == req
				.getElementType()) {
			return getGEFWrapper(new LinkReferenceAddModelElementEndpointReferenceCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryLinkReference_4012 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkReferenceNewBinaryLinkCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to reorient a link (implemented with an EClass)
	 * originating from a model element reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		switch (getVisualID(req)) {
			case ModelElementEndpointReferenceEditPart.VISUAL_ID:
				return getGEFWrapper(new LinkReferenceChangeModelElementEndpointReferenceCommand(
						req));
			case BinaryLinkReferenceEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryLinkReferenceChangeModelElementReferenceCommand(req));
		}
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

}
