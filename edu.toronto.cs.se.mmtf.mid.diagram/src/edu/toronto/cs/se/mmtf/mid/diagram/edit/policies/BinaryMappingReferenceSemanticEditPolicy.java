/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryMappingReferenceChangeModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryMappingReferenceCreateMappingCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceAddModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceChangeModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;

/**
 * The semantic edit policy for binary mapping references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryMappingReferenceSemanticEditPolicy extends BinaryMappingReferenceItemSemanticEditPolicy {

	/**
	 * Gets the command to start creating a new link originating from a binary
	 * mapping reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.MappingReferenceModels_4003 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceAddModelCommand(req,
				req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryMappingReference_4004 == req.getElementType()) {
			return getGEFWrapper(new BinaryMappingReferenceCreateMappingCommand(
				req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to complete the creation of a new link originating from
	 * a binary mapping reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.MappingReferenceModels_4003 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceAddModelCommand(req,
				req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryMappingReference_4004 == req.getElementType()) {
			return getGEFWrapper(new BinaryMappingReferenceCreateMappingCommand(
				req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to reorient a link (represented in the model with an
	 * EClass) originating from a binary mapping reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		switch (getVisualID(req)) {
			case BinaryMappingReferenceEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryMappingReferenceChangeModelCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Gets the command to reorient a link (represented in the model with an
	 * EReference) originating from a binary mapping reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		switch (getVisualID(req)) {
			case MappingReferenceModelsEditPart.VISUAL_ID:
				return getGEFWrapper(new MappingReferenceChangeModelCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
