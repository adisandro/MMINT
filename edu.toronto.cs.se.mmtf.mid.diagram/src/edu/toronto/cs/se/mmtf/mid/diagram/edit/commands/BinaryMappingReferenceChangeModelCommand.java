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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * The command to change a model of a binary mapping reference.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryMappingReferenceChangeModelCommand extends BinaryMappingReferenceReorientCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public BinaryMappingReferenceChangeModelCommand(ReorientRelationshipRequest request) {

		super(request);
	}

	/**
	 * Changes the source model reference of a binary mapping reference.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		MultiModelCommandsTrait.removeMappingReferenceModel(getLink(), getOldSource());
		MultiModelCommandsTrait.addMappingReferenceModel(getLink(), getNewSource());
		getLink().getModels().set(0, getNewSource());

		return super.reorientSource();
	}

	/**
	 * Changes the target model reference of a binary mapping reference.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		MultiModelCommandsTrait.removeMappingReferenceModel(getLink(), getOldTarget());
		MultiModelCommandsTrait.addMappingReferenceModel(getLink(), getNewTarget());
		getLink().getModels().set(1, getNewTarget());

		return super.reorientTarget();
	}

}
