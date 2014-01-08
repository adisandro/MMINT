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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * The command to create a model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelNewNaryRelCommand extends ModelRelCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public ModelRelNewNaryRelCommand(CreateElementRequest req) {

		super(req);
	}
	
    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MultiModel multiModel = (MultiModel) getElementToEdit();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.createTypeHierarchy(multiModel);
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
			MMTF.createTypeHierarchy(multiModel);
		}

		return status;
    }

	/**
	 * Checks if a model relationship can be created.
	 * 
	 * @return True if a model relationship can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	protected ModelRel doExecuteInstancesLevel() throws MMTFException {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		ModelRel modelRelType = MidDiagramUtils.selectModelRelTypeToCreate(null, null);
		ModelRel newModelRel = modelRelType.createInstance(null, false, ModelOrigin.CREATED, multiModel);

		return newModelRel;
	}

	protected ModelRel doExecuteTypesLevel() throws MMTFException {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		ModelRel modelRelType = MidDiagramUtils.selectModelRelTypeToExtend(multiModel, null, null);
		String newModelRelTypeName = MidDiagramUtils.getStringInput("Create new light model relationship type", "Insert new model relationship type name", null);
		String[] constraint = MidDiagramUtils.getConstraintInput("Create new light model relationship type", null);
		ModelRel newModelRelType = modelRelType.createSubtype(newModelRelTypeName, false, constraint[0], constraint[1]);
		MMTF.createTypeHierarchy(multiModel);

		return newModelRelType;
	}

	/**
	 * Creates a new model relationship.
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
			ModelRel newElement = (MultiModelConstraintChecker.isInstancesLevel((MultiModel) getElementToEdit())) ?
				doExecuteInstancesLevel() :
				doExecuteTypesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
	
			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (MMTFException e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model relationship created", e);
			return CommandResult.newErrorCommandResult("No model relationship created");
		}
	}

}
