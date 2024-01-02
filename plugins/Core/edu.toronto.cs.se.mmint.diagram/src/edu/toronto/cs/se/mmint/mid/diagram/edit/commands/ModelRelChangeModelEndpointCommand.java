/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

/**
 * The command to change a model of a mapping reference.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelChangeModelEndpointCommand extends ModelEndpointReorientCommand {

	private List<String> modelTypeEndpointUris;

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ModelRelChangeModelEndpointCommand(ReorientRelationshipRequest request) {

		super(request);
		modelTypeEndpointUris = null;
	}

	/**
	 * Checks if a model can be changed.
	 * 
	 * @return True if a model can be changed, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		ModelEndpoint modelEndpoint = getLink();
		return super.canExecute() && (
			modelEndpoint.isInstancesLevel() ||
			(modelEndpoint.isWorkflowsLevel() && modelEndpoint.getMIDContainer().getOperators().isEmpty()) ||
			!MIDTypeHierarchy.isRootType(modelEndpoint)
		);
	}

	/**
	 * Checks if the source model relationship can be changed.
	 * 
	 * @return True if the source model relationship can be changed, false
	 *         otherwise.
	 */
	@Override
	protected boolean canReorientSource() {

		ModelEndpoint modelEndpoint = getLink();
		return super.canReorientSource() && (
			modelEndpoint.isTypesLevel() ||
			(modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints(getNewSource(), null, modelEndpoint.getTarget())) != null
		);
	}

	/**
	 * Checks if the target model can be changed.
	 * 
	 * @return True if the target model can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientTarget() {

		ModelEndpoint modelEndpoint = getLink();
		return super.canReorientTarget() && (
			modelEndpoint.isTypesLevel() ||
			(modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints((ModelRel) modelEndpoint.eContainer(), modelEndpoint, (Model) getNewTarget())) != null
		);
	}

	protected void doExecuteTypesLevel(ModelRel modelRelType, Model modelType, boolean isFullDelete) throws MMINTException {

		ModelEndpoint modelTypeEndpoint = MIDTypeHierarchy.getOverriddenModelTypeEndpoint(modelRelType, modelType);
		if (isFullDelete) {
			getLink().deleteType(isFullDelete);
			modelTypeEndpoint.createSubtype(getLink().getName(), modelType, false, modelRelType);
		}
		else {
			modelTypeEndpoint.replaceSubtype(getLink(), getLink().getName(), modelType);
		}
		// no need to init type hierarchy, no need for undo/redo
	}

	protected void doExecuteInstancesLevel(ModelRel modelRel, Model model, boolean isFullDelete) throws MMINTException, MIDDialogCancellation {

		ModelEndpointReference modelTypeEndpointRef = MIDDialogs.selectModelTypeEndpointToCreate(modelRel, modelTypeEndpointUris, "");
		if (isFullDelete) {
			getLink().deleteInstance(isFullDelete);
			modelTypeEndpointRef.getObject().createInstance(model, modelRel);
		}
		else {
			modelTypeEndpointRef.getObject().replaceInstance(getLink(), model);
		}
	}

	protected void doExecuteWorkflowsLevel(ModelRel modelRel, Model model, boolean isFullDelete) throws MMINTException, MIDDialogCancellation {

		ModelEndpointReference modelTypeEndpointRef = MIDDialogs.selectModelTypeEndpointToCreate(modelRel, modelTypeEndpointUris, "");
		if (isFullDelete) {
			getLink().deleteWorkflowInstance();
			modelTypeEndpointRef.getObject().createWorkflowInstance(model, modelRel);
		}
		else {
			modelTypeEndpointRef.getObject().replaceWorkflowInstance(getLink(), model);
		}
	}

	/**
	 * Changes the source model of a model relationship.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		try {
			switch (getLink().getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel(getNewSource(), getLink().getTarget(), true);
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel(getNewSource(), getLink().getTarget(), true);
					break;
				case WORKFLOWS:
					this.doExecuteWorkflowsLevel(getNewSource(), getLink().getTarget(), true);
					break;
				default:
					throw new MMINTException("The MID level is missing");
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (MIDDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model endpoint changed");
		}
	}

	/**
	 * Changes the target model of a model relationship.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		try {
			switch (getLink().getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel((ModelRel) getLink().eContainer(), (Model) getNewTarget(), false);
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel((ModelRel) getLink().eContainer(), (Model) getNewTarget(), false);
					break;
				case WORKFLOWS:
					this.doExecuteWorkflowsLevel((ModelRel) getLink().eContainer(), (Model) getNewTarget(), false);
					break;
				default:
					throw new MMINTException("The MID level is missing");
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (MIDDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model endpoint changed");
		}
	}

}
