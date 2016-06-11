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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

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
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MID mid = (MID) getElementToEdit();
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

		MID mid = (MID) getElementToEdit();
		return super.canExecute() && (
			!mid.isWorkflowsLevel() ||
			mid.getOperators().isEmpty()
		);
	}

	protected Model doExecuteTypesLevel() throws MMINTException, MIDDialogCancellation {

		MID typeMID = (MID) getElementToEdit();
		Model modelType = MIDDialogUtils.selectModelTypeToExtend(typeMID);
		String newModelTypeName = MIDDialogUtils.getStringInput("Create new light model type", "Insert new model type name", null);
		String[] constraint = MIDDialogUtils.getConstraintInput("Create new light model type", null);
		if (!MIDConstraintChecker.checkConstraintConsistency(modelType, constraint[0], constraint[1])) {
			throw new MMINTException("The combined constraint (this type + supertypes) is inconsistent");
		}
		boolean isMetamodelExtension = (MIDTypeHierarchy.isRootType(modelType)) ?
			true :
			MIDDialogUtils.getBooleanInput("Create new light model type", "Extend metamodel?");
		Model newModelType = modelType.createSubtype(newModelTypeName, constraint[0], constraint[1], isMetamodelExtension);
		MMINT.createTypeHierarchy(typeMID);

		return newModelType;
	}

	protected Model doExecuteInstancesLevel() throws MMINTException, MIDDialogCancellation {

		MID instanceMID = (MID) getElementToEdit();
		Editor newEditor = MIDDialogUtils.selectModelTypeToCreate(instanceMID);
		Model modelType = MIDTypeRegistry.getType(newEditor.getMetatype().getModelUri());
		Model newModel = modelType.createInstance(newEditor.getModelUri(), instanceMID);
		newModel.getEditors().add(newEditor);

		return newModel;
	}

	protected Model doExecuteWorkflowsLevel() throws MMINTException {

		/*TODO MMINT[WORKFLOW]
		 * Connect id with label change
		 * Add a way to create a workflow MID + think about the need for a MIDWorkflow model type
		 * Add a way to create an operator out of a workflow MID:
		 * * add operator gmf creation menu, policies and commands (maybe remove import model rel)
		 * * add operator createSubtype api
		 * * select mid workflow file
		 * * copy it to the type repository and compute i/o
		 * * add persistence between restarts
		 * Add execution engine
		 * Big problem: when you "run" workflow operators and create model rels, nobody is connecting them to models
		 */
		MID workflowMID = (MID) getElementToEdit();
		Model modelType = MIDDialogUtils.selectWorkflowModelTypeToCreate(workflowMID);
		String newModelId = MIDRegistry.getNextWorkflowID(workflowMID);
		Model newModel = modelType.createWorkflowInstance(newModelId, workflowMID);

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
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model created", e);
			return CommandResult.newErrorCommandResult("No model created");
		}
	}

}
