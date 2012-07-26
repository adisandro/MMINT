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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * The command to delete a supertype.
 * 
 * @author Vivien Suen
 * 
 */
public class ExtendibleElementSupertypeDelCommand extends DestroyReferenceCommand {

	private boolean canExecute;
	
	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ExtendibleElementSupertypeDelCommand(DestroyReferenceRequest request, boolean canExec) {
		super(request);
		this.canExecute = canExec;
	}

	/**
	 * Checks if a model can be deleted.
	 * 
	 * @return True if a model can be deleted, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && this.canExecute;
	}

	/**
	 * Deletes a supertype.
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
		return CommandResult.newOKCommandResult();
	}

}
