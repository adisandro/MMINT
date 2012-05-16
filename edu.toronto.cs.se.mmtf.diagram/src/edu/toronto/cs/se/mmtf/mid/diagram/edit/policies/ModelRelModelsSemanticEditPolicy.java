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
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelRelRemoveModelCommand;

/**
 * The semantic edit policy for model relationships' models.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelModelsSemanticEditPolicy extends ModelRelModelsItemSemanticEditPolicy {

	/**
	 * Gets the command to remove a model from a model relationship.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {

		return getGEFWrapper(new ModelRelRemoveModelCommand(req));
	}

}
