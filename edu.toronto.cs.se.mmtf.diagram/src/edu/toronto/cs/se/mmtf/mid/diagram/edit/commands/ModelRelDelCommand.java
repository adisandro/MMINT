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

import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;

/**
 * The command to delete a model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelDelCommand extends DestroyElementCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ModelRelDelCommand(DestroyElementRequest request) {

		super(request);
	}

	/**
	 * Checks if a model relationship can be deleted.
	 * 
	 * @return True if a model relationship can be deleted, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() &&
			MultiModelConstraintChecker.isInstancesLevel((ModelRel) getElementToDestroy());
	}

}
