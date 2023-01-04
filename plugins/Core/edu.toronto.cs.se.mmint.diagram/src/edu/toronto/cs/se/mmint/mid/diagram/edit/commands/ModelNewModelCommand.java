/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * The command to create a model.
 *
 * @author Alessio Di Sandro
 *
 */
public class ModelNewModelCommand extends ModelCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 *
	 * @param req
	 *            The request.
	 */
	public ModelNewModelCommand(CreateElementRequest req) {

		super(req);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
  protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		var status = super.doUndo(monitor, info);
		var mid = (MID) getElementToEdit();
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

		var status = super.doRedo(monitor, info);
		var mid = (MID) getElementToEdit();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

	/**
	 * Checks if a model can be created.
	 *
	 * @return True if a model can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		var mid = (MID) getElementToEdit();
		return super.canExecute() && (
			!mid.isWorkflowsLevel() ||
			mid.getOperators().isEmpty()
		);
	}

	protected Model doExecuteTypesLevel() throws MMINTException, MIDDialogCancellation {

		//TODO MMINT[MISC] Support undo/redo with metamodel extension file
		var typeMID = (MID) getElementToEdit();
		var modelType = MIDDialogs.selectModelTypeToExtend(typeMID);
		var newModelTypeName = MIDDialogs.getStringInput("Create new light model type", "Insert new model type name", null);
		var constraint = MIDDialogs.getConstraintInput("Create new light model type", null);
		var isMetamodelExtension = (MIDTypeHierarchy.isRootType(modelType)) ?
			true :
			MIDDialogs.getBooleanInput("Create new light model type", "Extend metamodel?");
		var newModelType = modelType.createSubtype(newModelTypeName, isMetamodelExtension);
		newModelType.addTypeConstraint(constraint[0], constraint[1]);
		MMINT.createTypeHierarchy(typeMID);

		return newModelType;
	}

	protected Model doExecuteInstancesLevel() throws MMINTException, IOException, MIDDialogCancellation {

		var instanceMID = (MID) getElementToEdit();
		var newEditor = MIDDialogs.selectModelTypeToCreate(instanceMID);
		Model modelType = MIDTypeRegistry.getType(newEditor.getMetatype().getModelUri());
		var newModel = modelType.createInstance(null, newEditor.getModelUri(), instanceMID);
		newModel.getEditors().add(newEditor);

		return newModel;
	}

	protected Model doExecuteWorkflowsLevel() throws MMINTException {

		var workflowMID = (MID) getElementToEdit();
		var modelType = MIDDialogs.selectWorkflowModelTypeToCreate(workflowMID);
		var newModelId = MIDRegistry.getNextWorkflowID(workflowMID);
		var newModel = modelType.createWorkflowInstance(newModelId, workflowMID);

		return newModel;
	}

	/**
	 * Creates a new model.
	 *
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result, or the error result if the model could not be
	 *         created.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			Model newElement;
			switch (((MID) getElementToEdit()).getLevel()) {
				case TYPES:
					newElement = this.doExecuteTypesLevel();
					break;
				case INSTANCES:
					newElement = this.doExecuteInstancesLevel();
					break;
				case WORKFLOWS:
					newElement = this.doExecuteWorkflowsLevel();
					break;
				default:
					throw new MMINTException("The MID level is missing");
			}
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
		catch (MMINTException | IOException e) {
			MMINTException.print(IStatus.ERROR, "No model created", e);
			return CommandResult.newErrorCommandResult("No model created");
		}
	}

}
