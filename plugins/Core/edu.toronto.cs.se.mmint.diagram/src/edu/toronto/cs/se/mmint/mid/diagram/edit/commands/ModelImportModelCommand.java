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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

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

		MID mid = (MID) getElementToEdit();
		return super.canExecute() && mid.isInstancesLevel();
	}

	protected Model doExecuteInstancesLevel() throws Exception, MIDDialogCancellation {

		MID instanceMID = (MID) getElementToEdit();
		String modelUri = MIDDialogs.selectModelToImport(false);
		Model modelType = MIDTypeRegistry.getType(FileUtils.readModelFile(modelUri, null, true).eClass().getEPackage().getNsURI());
		if (modelType == null) { // unregistered dynamic EMF file
			modelType = MIDTypeHierarchy.getRootModelType();
		}
		Model newModel = modelType.importInstanceAndEditor(modelUri, instanceMID);

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
		catch (MIDDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "No model imported", e);
			return CommandResult.newErrorCommandResult("No model imported");
		}
	}

}
