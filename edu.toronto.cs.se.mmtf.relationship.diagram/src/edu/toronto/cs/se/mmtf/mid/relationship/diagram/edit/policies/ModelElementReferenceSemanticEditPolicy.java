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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.BinaryLinkChangeModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.BinaryLinkNewBinaryLinkCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkElementRefsCreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * The semantic edit policy for model element references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceSemanticEditPolicy extends ModelElementReferenceItemSemanticEditPolicy {

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

		if (MidElementTypes.LinkElementRefs_4002 == req.getElementType()) {
			return null;
		}
		if (MidElementTypes.BinaryLink_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkNewBinaryLinkCommand(req,
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

		if (MidElementTypes.LinkElementRefs_4002 == req.getElementType()) {
			return getGEFWrapper(new LinkElementRefsCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryLink_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkNewBinaryLinkCommand(req,
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
			case BinaryLinkEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryLinkChangeModelElementReferenceCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
