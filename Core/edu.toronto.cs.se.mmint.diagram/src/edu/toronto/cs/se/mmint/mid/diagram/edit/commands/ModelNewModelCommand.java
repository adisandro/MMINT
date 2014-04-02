/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelCreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmint.mid.diagram.library.MidDialogCancellation;
import edu.toronto.cs.se.mmint.mid.editor.Editor;

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
		MultiModel multiModel = (MultiModel) getElementToEdit();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMINT.createTypeHierarchy(multiModel);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MultiModel multiModel = (MultiModel) getElementToEdit();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMINT.createTypeHierarchy(multiModel);
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

		return super.canExecute();
	}

	protected Model doExecuteInstancesLevel() throws MMINTException, MidDialogCancellation {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		Editor newEditor = MidDiagramUtils.selectModelTypeToCreate(multiModel);
		Model modelType = MultiModelTypeRegistry.getType(newEditor.getMetatype().getModelUri());
		Model newModel = modelType.createInstance(newEditor.getModelUri(), ModelOrigin.CREATED, multiModel);
		newModel.getEditors().add(newEditor);

		return newModel;
	}

	protected Model doExecuteTypesLevel() throws MMINTException, MidDialogCancellation {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		Model modelType = MidDiagramUtils.selectModelTypeToExtend(multiModel);
		String newModelTypeName = MidDiagramUtils.getStringInput("Create new light model type", "Insert new model type name", null);
		String[] constraint = MidDiagramUtils.getConstraintInput("Create new light model type", null);
		if (!MultiModelConstraintChecker.checkConstraintConsistency(modelType, constraint[0], constraint[1])) {
			throw new MMINTException("The combined constraint (this type + supertypes) is inconsistent");
		}
		boolean isMetamodelExtension = (MultiModelTypeHierarchy.isRootType(modelType)) ?
			true :
			MidDiagramUtils.getBooleanInput("Create new light model type", "Extend metamodel?");
		Model newModelType = modelType.createSubtype(newModelTypeName, constraint[0], constraint[1], isMetamodelExtension);
		MMINT.createTypeHierarchy(multiModel);

		return newModelType;
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
			Model newElement = (MultiModelConstraintChecker.isInstancesLevel((MultiModel) getElementToEdit())) ?
				doExecuteInstancesLevel() :
				doExecuteTypesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (MidDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(Type.ERROR, "No model created", e);
			return CommandResult.newErrorCommandResult("No model created");
		}
	}

}
