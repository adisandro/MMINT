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
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.BinaryMappingChangeElementCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.BinaryMappingCreateMappingCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.MappingElementsCreateCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.BinaryMappingEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers.MIDElementTypes;

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

		if (MIDElementTypes.MappingElements_4002 == req.getElementType()) {
			return null;
		}
		if (MIDElementTypes.BinaryMapping_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryMappingCreateMappingCommand(req,
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

		if (MIDElementTypes.MappingElements_4002 == req.getElementType()) {
			return getGEFWrapper(new MappingElementsCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryMapping_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryMappingCreateMappingCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to reorient a link (represented in the model with an
	 * EClass) originating from a model element reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		switch (getVisualID(req)) {
			case BinaryMappingEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryMappingChangeElementCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
