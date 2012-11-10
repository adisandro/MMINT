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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;

/**
 * The command to import an existing model.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelImportModelCommand extends Model2CreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public ModelImportModelCommand(CreateElementRequest req) {

		super(req);
	}

	/**
	 * Checks if a model can be imported.
	 * 
	 * @return True if a model can be imported, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() &&
			MultiModelConstraintChecker.isInstancesLevel((MultiModel) getElementToEdit());
	}

	protected Model doExecuteInstancesLevel() throws Exception {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		String newModelUri = MidDiagramTrait.selectModelToImport(false);
		Model newModel = MultiModelInstanceFactory.createModelAndEditor(null, newModelUri, ModelOrigin.IMPORTED, multiModel);

		return newModel;
	}

	/**
	 * Imports a model.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result, or the error result if the model could not be
	 *         imported.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			Model newElement = doExecuteInstancesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model imported", e);
			return CommandResult.newErrorCommandResult("No model imported");
		}
	}

}
