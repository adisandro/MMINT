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

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;

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
	 * Checks if a model can be deleted.
	 * 
	 * @return True if a model can be deleted, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel((MultiModel) getElementToDestroy().eContainer()) ||
				((Model) getElementToDestroy()).isDynamic()
			);
	}

	protected void doExecuteTypesLevel() {
		
		Model modelType = (Model) getElementToDestroy();
		MultiModel multiModel = (MultiModel) modelType.eContainer();
		MMTFRegistry.removeModelType(modelType);
		MMTFRegistry.updateRepository(multiModel);
	}

	protected void doExecuteInstancesLevel() {

		MultiModelFactoryUtils.removeModel((Model) getElementToDestroy());
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

		if (MultiModelConstraintChecker.isInstancesLevel((MultiModel) getElementToDestroy().eContainer())) {
			doExecuteInstancesLevel();
		}
		else {
			doExecuteTypesLevel();
		}

		return super.doExecuteWithResult(monitor, info);
	}

}
