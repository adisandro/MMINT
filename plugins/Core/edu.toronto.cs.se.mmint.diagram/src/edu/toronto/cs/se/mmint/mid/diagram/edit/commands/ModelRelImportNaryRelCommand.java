/*
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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;

/**
 * The command to import an existing model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelImportNaryRelCommand extends ModelRel2CreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public ModelRelImportNaryRelCommand(CreateElementRequest req) {

		super(req);
	}

	/**
	 * Checks if a model relationship can be created.
	 * 
	 * @return True if a model relationship can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() &&
			((MID) getElementToEdit()).isInstancesLevel();
	}

	protected ModelRel doExecuteInstancesLevel() throws Exception {

		MID instanceMID = (MID) getElementToEdit();
		String newModelRelUri = MIDDialogs.selectModelToImport(true);
		ModelRel newModelRel = null;
		//TODO MMINT[MODELREL] MultiModelInstanceFactory.copyModelRel(multiModel, newModelRelUri);

		return newModelRel;
	}

	/**
	 * Imports an existing model relationship.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			ModelRel newElement = doExecuteInstancesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "No model relationship imported", e);
			return CommandResult.newErrorCommandResult("No model relationship imported");
		}
	}

}
