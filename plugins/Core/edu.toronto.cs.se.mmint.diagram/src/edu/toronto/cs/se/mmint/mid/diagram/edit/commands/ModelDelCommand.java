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
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;

/**
 * The command to delete a model.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelDelCommand extends DestroyElementCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ModelDelCommand(DestroyElementRequest request) {

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
	 * Checks if a model can be deleted.
	 * 
	 * @return True if a model can be deleted, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		MID mid = (MID) getElementToEdit();
		return super.canExecute() && (
			mid.isInstancesLevel() ||
			(mid.isWorkflowsLevel() && mid.getOperators().isEmpty()) ||
			!MIDTypeHierarchy.isRootType((Model) getElementToDestroy())
		);
	}

	protected void doExecuteTypesLevel() throws MMINTException {
		
		MID typeMID = (MID) getElementToEdit();
		((Model) getElementToDestroy()).deleteType();
		MMINT.createTypeHierarchy(typeMID);
	}

	protected void doExecuteInstancesLevel() throws MMINTException {

		Model model = (Model) getElementToDestroy();
		MID instanceMID = model.getMIDContainer();
		if (Boolean.parseBoolean(MMINT.getPreference(MMINT.PREFERENCE_MENU_DELETEMODELFILE_ENABLED))) {
			model.deleteInstanceAndFile();
			try {
				WorkspaceSynchronizer.getFile(instanceMID.eResource()).getParent().refreshLocal(IResource.DEPTH_ONE, null);
			}
			catch (CoreException e) {
				MMINTException.print(Status.WARNING, "Can't refresh the project directory, deleted models will remain visible until a manual refresh is done", e);
			}
		}
		else {
			model.deleteInstance();
		}
	}

	protected void doExecuteWorkflowsLevel() throws MMINTException {

		((Model) getElementToDestroy()).deleteWorkflowInstance();
	}

	/**
	 * Deletes a model.
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
			MMINTException.print(IStatus.ERROR, "No model deleted", e);
			return CommandResult.newErrorCommandResult("No model deleted");
		}
	}

}
