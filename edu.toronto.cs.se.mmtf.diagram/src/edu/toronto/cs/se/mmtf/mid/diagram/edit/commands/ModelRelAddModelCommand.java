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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeFactory;

/**
 * The command to add a model to a model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelAddModelCommand extends ModelRelModelsCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 * @param source
	 *            The source model relationship.
	 * @param target
	 *            The target model.
	 */
	public ModelRelAddModelCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	/**
	 * Checks if a model can be added.
	 * 
	 * @return True if a model can be added, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		boolean instance = MultiModelConstraintChecker.isInstancesLevel(getSource());

		return
			super.canExecute() && (
				(instance && MultiModelConstraintChecker.isAllowedModel(getSource(), getTarget())) ||
				(!instance && MultiModelConstraintChecker.isAllowedModelType(getSource()))
			);
	}

	protected void doExecuteInstancesLevel() {

		MultiModelInstanceFactory.createModelReference(getSource(), getTarget());
	}

	protected void doExecuteTypesLevel() {

		MultiModelTypeFactory.createLightModelTypeRef(getSource(), getTarget());
	}

	/**
	 * Adds a model to a model relationship.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If this command can't be executed.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}

		if (getSource() != null && getTarget() != null) {
			getSource().getModels().add(getTarget());
			if (MultiModelConstraintChecker.isInstancesLevel(getSource())) {
				doExecuteInstancesLevel();
			}
			else {
				doExecuteTypesLevel();
			}
		}

		return CommandResult.newOKCommandResult();
	}

}
