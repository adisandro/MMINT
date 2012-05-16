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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTrait;

/**
 * The command to change a model of a mapping reference.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelChangeModelCommand extends ModelRelModelsReorientCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ModelRelChangeModelCommand(ReorientReferenceRelationshipRequest request) {

		super(request);
	}

	/**
	 * Changes the source model of a model relationship.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		MultiModelTrait.removeModelReference(getOldSource(), getOldTarget());
		MultiModelTrait.createModelReference(getNewSource(), getOldTarget());

		return super.reorientSource();
	}

	/**
	 * Changes the target model of a model relationship.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		MultiModelTrait.removeModelReference(getOldSource(), getOldTarget());
		MultiModelTrait.createModelReference(getOldSource(), getNewTarget());

		return super.reorientTarget();
	}

}
