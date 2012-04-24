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
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies.MIDBaseItemSemanticEditPolicy;

/**
 * The command to change a model element reference of a binary mapping.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryMappingChangeElementCommand extends BinaryMappingReorientCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public BinaryMappingChangeElementCommand(ReorientRelationshipRequest request) {

		super(request);
	}

	/**
	 * Checks if the source can be reoriented.
	 * 
	 * @return True if the source can be reoriented, false otherwise.
	 */
	protected boolean canReorientSource() {

		if (!(getOldSource() instanceof ModelElementReference && getNewSource() instanceof ModelElementReference)) {
			return false;
		}
		if (getLink().getElements().size() != 2) {
			return false;
		}
		ModelElementReference target = (ModelElementReference) getLink()
				.getElements().get(1);
		if (!(getLink().eContainer() instanceof MappingReference)) {
			return false;
		}
		MappingReference container = (MappingReference) getLink().eContainer();

		return MIDBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistBinaryMapping_4003(container, getLink(),
						getNewSource(), target);
	}

	/**
	 * Checks if the target can be reoriented.
	 * 
	 * @return True if the target can be reoriented, false otherwise.
	 */
	protected boolean canReorientTarget() {

		if (!(getOldSource() instanceof ModelElementReference && getNewSource() instanceof ModelElementReference)) {
			return false;
		}
		if (getLink().getElements().size() != 2) {
			return false;
		}
		ModelElementReference source = (ModelElementReference) getLink()
				.getElements().get(0);
		if (!(getLink().eContainer() instanceof MappingReference)) {
			return false;
		}
		MappingReference container = (MappingReference) getLink().eContainer();

		return MIDBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistBinaryMapping_4003(container, getLink(), source,
						getNewTarget());
	}

	/**
	 * Changes the source model element reference of a binary mapping.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		getLink().getElements().set(0, getNewSource());

		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * Changes the target model element reference of a binary mapping.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		getLink().getElements().set(1, getNewTarget());

		return CommandResult.newOKCommandResult(getLink());
	}

}
