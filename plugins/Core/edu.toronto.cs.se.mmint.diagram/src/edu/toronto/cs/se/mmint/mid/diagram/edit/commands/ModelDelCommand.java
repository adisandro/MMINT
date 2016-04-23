/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MIDConstraintChecker;

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
		if (!MIDConstraintChecker.isInstancesLevel(mid)) {
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
		if (!MIDConstraintChecker.isInstancesLevel(mid)) {
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

		return
			super.canExecute() && (
				MIDConstraintChecker.isInstancesLevel((MID) getElementToEdit()) ||
				!MIDTypeHierarchy.isRootType((Model) getElementToDestroy())
			);
	}

	protected void doExecuteInstancesLevel() throws MMINTException {

		((Model) getElementToDestroy()).deleteInstance();
	}

	protected void doExecuteTypesLevel() throws MMINTException {
		
		MID typeMID = (MID) getElementToEdit();
		((Model) getElementToDestroy()).deleteType();
		MMINT.createTypeHierarchy(typeMID);
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
			if (MIDConstraintChecker.isInstancesLevel((MID) getElementToEdit())) {
				doExecuteInstancesLevel();
			}
			else {
				doExecuteTypesLevel();
			}
	
			return super.doExecuteWithResult(monitor, info);
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model deleted", e);
			return CommandResult.newErrorCommandResult("No model deleted");
		}
	}

}
