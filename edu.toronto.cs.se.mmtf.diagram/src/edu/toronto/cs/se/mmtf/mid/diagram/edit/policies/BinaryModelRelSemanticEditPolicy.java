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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryModelRelChangeModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryModelRelDelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryModelRelNewBinaryRelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelRelAddModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelRelChangeModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes;

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

		if (MidElementTypes.ModelRelModels_4002 == req.getElementType()) {
			return getGEFWrapper(new ModelRelAddModelCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryModelRel_4003 == req.getElementType()) {
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

		if (MidElementTypes.ModelRelModels_4002 == req.getElementType()) {
			return getGEFWrapper(new ModelRelAddModelCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryModelRel_4003 == req.getElementType()) {
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
			case BinaryModelRelEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryModelRelChangeModelCommand(req));
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

		switch (getVisualID(req)) {
			case ModelRelModelsEditPart.VISUAL_ID:
				return getGEFWrapper(new ModelRelChangeModelCommand(req));
		}
		return UnexecutableCommand.INSTANCE;
	}

}
