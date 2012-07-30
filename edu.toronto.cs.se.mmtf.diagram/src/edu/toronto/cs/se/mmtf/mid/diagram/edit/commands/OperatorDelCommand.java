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
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeFactory;

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
	 * Checks if an operator can be deleted.
	 * 
	 * @return True if the operator can be deleted, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && false;
	}

	protected void doExecuteTypesLevel() {
		
		Operator operatorType = (Operator) getElementToDestroy();
		MultiModel multiModel = (MultiModel) operatorType.eContainer();		
		MultiModelTypeFactory.removeOperatorType(operatorType);
		MMTF.syncRepository(multiModel);
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
		
		doExecuteTypesLevel();

		return super.doExecuteWithResult(monitor, info);
	}

}
