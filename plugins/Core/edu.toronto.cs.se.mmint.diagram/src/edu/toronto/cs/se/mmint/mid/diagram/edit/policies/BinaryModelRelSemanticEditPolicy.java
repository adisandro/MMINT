/*
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.BinaryModelRelChangeModelEndpointCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.BinaryModelRelDelCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.BinaryModelRelNewBinaryRelCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRelAddModelEndpointCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRelChangeModelEndpointCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;

/**
 * The semantic edit policy for binary model relationships.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryModelRelSemanticEditPolicy extends BinaryModelRelItemSemanticEditPolicy {

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		return getGEFWrapper(new BinaryModelRelDelCommand(req));
	}

	/**
	 * Gets the command to start creating a new link originating from a binary
	 * model relationship.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.ModelEndpoint_4002 == req.getElementType()) {
			return getGEFWrapper(new ModelRelAddModelEndpointCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryModelRel_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryModelRelNewBinaryRelCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to complete the creation of a new link originating from
	 * a binary model relationship.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.ModelEndpoint_4002 == req.getElementType()) {
			return getGEFWrapper(new ModelRelAddModelEndpointCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryModelRel_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryModelRelNewBinaryRelCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to reorient a link (implemented with an EClass)
	 * originating from a binary model relationship.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		switch (getVisualID(req)) {
			case ModelEndpointEditPart.VISUAL_ID:
				return getGEFWrapper(new ModelRelChangeModelEndpointCommand(req));
			case BinaryModelRelEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryModelRelChangeModelEndpointCommand(req));
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the command to reorient a link (implemented with an EReference)
	 * originating from a binary model relationship.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

}
