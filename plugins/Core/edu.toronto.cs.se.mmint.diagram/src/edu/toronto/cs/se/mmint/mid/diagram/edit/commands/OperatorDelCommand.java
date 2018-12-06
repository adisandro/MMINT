/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;

/**
 * The command to delete an operator.
 * 
 * @author Vivien Suen
 * 
 */
public class OperatorDelCommand extends DestroyElementCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public OperatorDelCommand(DestroyElementRequest request) {

		super(request);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MID mid = (MID) getElementToEdit();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MID mid = (MID) getElementToEdit();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

	/**
	 * Checks if an operator can be deleted.
	 * 
	 * @return True if the operator can be deleted, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	protected void doExecuteTypesLevel() throws MMINTException {

		MID typeMID = (MID) getElementToEdit();
		((Operator) getElementToDestroy()).deleteType();
		MMINT.createTypeHierarchy(typeMID);
	}

	protected void doExecuteInstancesLevel() throws MMINTException {

		Operator operator = (Operator) getElementToDestroy();
		MID instanceMID = operator.getMIDContainer();
		operator.deleteInstance();
		if (operator instanceof WorkflowOperator) {
			try {
				WorkspaceSynchronizer.getFile(instanceMID.eResource()).getParent().refreshLocal(IResource.DEPTH_ONE, null);
			}
			catch (CoreException e) {
				MMINTException.print(Status.WARNING, "Can't refresh the project directory, deleted workflows will remain visible until a manual refresh is done", e);
			}
		}
	}

	protected void doExecuteWorkflowsLevel() throws MMINTException {

		((Operator) getElementToDestroy()).deleteWorkflowInstance();
	}

	/**
	 * Deletes an operator.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If the super implementation throws it.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			switch (((MID) getElementToEdit()).getLevel()) {
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
			MMINTException.print(IStatus.ERROR, "No operator deleted", e);
			return CommandResult.newErrorCommandResult("No operator deleted");
		}
	}

}
