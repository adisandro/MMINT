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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

/**
 * The command to create a binary model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryModelRelNewBinaryRelCommand extends BinaryModelRelCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 * @param source
	 *            The source model.
	 * @param target
	 *            The target model.
	 */
	public BinaryModelRelNewBinaryRelCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MID mid = getContainer();
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
		MID mid = getContainer();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

	/**
	 * Checks if a binary model relationship can be created.
	 * 
	 * @return True if a binary model relationship can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		MID mid = getContainer();
		return super.canExecute() && (
			mid.isInstancesLevel() || (
				mid.isWorkflowsLevel() &&
				mid.getOperators().isEmpty()
			) || (
				!MIDTypeHierarchy.isRootType(getSource()) &&
				(getTarget() == null || !MIDTypeHierarchy.isRootType(getTarget()))
			)
		);
	}

	protected BinaryModelRel doExecuteTypesLevel() throws MMINTException, MIDDialogCancellation {

		MID typeMID = getContainer();
		Model srcModelType = getSource(), tgtModelType = getTarget();
		ModelRel modelRelType = MIDDialogs.selectModelRelTypeToExtend(typeMID, srcModelType, tgtModelType);
		String newModelRelTypeName = MIDDialogs.getStringInput("Create new light binary model relationship type", "Insert new binary model relationship type name", srcModelType.getName() + MMINT.BINARY_MODELREL_SEPARATOR + tgtModelType.getName());
		String[] constraint = MIDDialogs.getConstraintInput("Create new light binary model relationship type", null);
		BinaryModelRel newModelRelType = modelRelType.createBinarySubtype(newModelRelTypeName, false);
		newModelRelType.addTypeConstraint(constraint[0], constraint[1]);
		MMINT.createTypeHierarchy(typeMID);

		String newModelTypeEndpointName;
		ModelEndpoint modelTypeEndpoint = MIDTypeHierarchy.getOverriddenModelTypeEndpoint(newModelRelType, srcModelType);
		if (modelTypeEndpoint == null) {
			newModelRelType.addModelType(srcModelType, true);
		}
		else {
			newModelTypeEndpointName = MIDDialogs.getStringInput("Create new source model type endpoint", "Insert new source model type endpoint role", srcModelType.getName());
			modelTypeEndpoint.createSubtype(newModelTypeEndpointName, srcModelType, true, newModelRelType);
		}

		modelTypeEndpoint = MIDTypeHierarchy.getOverriddenModelTypeEndpoint(newModelRelType, tgtModelType);
		if (modelTypeEndpoint == null) {
			newModelRelType.addModelType(tgtModelType, false);
		}
		else {
			newModelTypeEndpointName = MIDDialogs.getStringInput("Create new target model type endpoint", "Insert new target model type endpoint role", tgtModelType.getName());
			modelTypeEndpoint.createSubtype(newModelTypeEndpointName, tgtModelType, false, newModelRelType);
		}

		return newModelRelType;
	}

	protected BinaryModelRel doExecuteInstancesLevel() throws MMINTException, MIDDialogCancellation {

		MID instanceMID = getContainer();
		ModelRel modelRelType = MIDDialogs.selectModelRelTypeToCreate(getSource(), getTarget());
		Model srcModel = getSource(), tgtModel = getTarget();
		BinaryModelRel newModelRel = modelRelType.createBinaryInstance(
			null,
			srcModel.getName() + MMINT.BINARY_MODELREL_SEPARATOR + tgtModel.getName(),
			instanceMID);

		List<String> modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints(newModelRel, null, getSource());
		ModelEndpointReference modelTypeEndpointRef = MIDDialogs.selectModelTypeEndpointToCreate(newModelRel, modelTypeEndpointUris, "src ");
		modelTypeEndpointRef.getObject().createInstance(srcModel, newModelRel);
		modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints(newModelRel, null, getTarget());
		modelTypeEndpointRef = MIDDialogs.selectModelTypeEndpointToCreate(newModelRel, modelTypeEndpointUris, "tgt ");
		modelTypeEndpointRef.getObject().createInstance(tgtModel, newModelRel);

		return newModelRel;
	}

	protected BinaryModelRel doExecuteWorkflowsLevel() throws MMINTException, MIDDialogCancellation {

		MID workflowMID = getContainer();
		ModelRel modelRelType = MIDDialogs.selectWorkflowModelRelTypeToCreate(getSource(), getTarget());
		String newModelRelId = MIDRegistry.getNextWorkflowID(workflowMID);
		BinaryModelRel newModelRel = modelRelType.createWorkflowBinaryInstance(newModelRelId, workflowMID);

		List<String> modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints(newModelRel, null, getSource());
		ModelEndpointReference modelTypeEndpointRef = MIDDialogs.selectModelTypeEndpointToCreate(newModelRel, modelTypeEndpointUris, "src ");
		modelTypeEndpointRef.getObject().createWorkflowInstance(getSource(), newModelRel);
		modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints(newModelRel, null, getTarget());
		modelTypeEndpointRef = MIDDialogs.selectModelTypeEndpointToCreate(newModelRel, modelTypeEndpointUris, "tgt ");
		modelTypeEndpointRef.getObject().createWorkflowInstance(getTarget(), newModelRel);

		return newModelRel;
	}

	/**
	 * Creates a new binary model relationship.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If this command can't be executed.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}
		try {
			BinaryModelRel newElement;
			switch (((MID) getContainer()).getLevel()) {
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
			MMINTException.print(IStatus.ERROR, "No binary model relationship created", e);
			return CommandResult.newErrorCommandResult("No binary model relationship created");
		}
	}

}
