/**
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
package edu.toronto.cs.se.mmint.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * The command to remove a model from a model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelRemoveModelEndpointCommand extends DestroyElementCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ModelRelRemoveModelEndpointCommand(DestroyElementRequest request) {

		super(request);
	}

	/**
	 * Checks if a model can be removed.
	 * 
	 * @return True if a model can be removed, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		ModelRel modelRel = (ModelRel) getElementToEdit();
		return super.canExecute() && (
			modelRel.isInstancesLevel() ||
			(modelRel.isWorkflowsLevel() && modelRel.getMIDContainer().getOperators().isEmpty()) ||
			!MIDTypeHierarchy.isRootType((ModelEndpoint) getElementToDestroy())
		);
	}

	protected void doExecuteTypesLevel() throws MMINTException {

		((ModelEndpoint) getElementToDestroy()).deleteType(true);
		// no need to init type hierarchy, no need for undo/redo
	}

	protected void doExecuteInstancesLevel() throws MMINTException {

		((ModelEndpoint) getElementToDestroy()).deleteInstance(true);
	}

	protected void doExecuteWorkflowsLevel() throws MMINTException {

		((ModelEndpoint) getElementToDestroy()).deleteWorkflowInstance();
	}

	/**
	 * Removes a model from a model relationship.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			switch (((ModelRel) getElementToEdit()).getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel();
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel();
					break;
				case WORKFLOWS:
					this.doExecuteWorkflowsLevel();
					break;
				default:
					throw new MMINTException("The MID level is missing");
			}
	
			return super.doExecuteWithResult(monitor, info);
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model endpoint deleted", e);
			return CommandResult.newErrorCommandResult("No model endpoint deleted");
		}
	}

}
