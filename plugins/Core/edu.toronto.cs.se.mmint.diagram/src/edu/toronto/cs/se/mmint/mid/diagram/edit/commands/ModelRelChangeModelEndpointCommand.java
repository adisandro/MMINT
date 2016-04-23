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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.constraint.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogUtils;
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

		return
			super.canExecute() && (
				MIDConstraintChecker.isInstancesLevel(getLink()) ||
				!MIDTypeHierarchy.isRootType(getLink())
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

		return
			super.canReorientSource() && (
				!MIDConstraintChecker.isInstancesLevel(getLink()) ||
				(modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints(getNewSource(), null, getLink().getTarget())) != null
			);
	}

	/**
	 * Checks if the target model can be changed.
	 * 
	 * @return True if the target model can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientTarget() {

		return
			super.canReorientTarget() && (
				!MIDConstraintChecker.isInstancesLevel(getLink()) ||
				(modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints((ModelRel) getLink().eContainer(), getLink(), (Model) getNewTarget())) != null
			);
	}

	protected void doExecuteInstancesLevel(ModelRel modelRel, Model model, boolean isFullDelete) throws MMINTException, MIDDialogCancellation {

		ModelEndpointReference modelTypeEndpointRef = MIDDialogUtils.selectModelTypeEndpointToCreate(modelRel, modelTypeEndpointUris, "");
		if (isFullDelete) {
			getLink().deleteInstanceAndReference(isFullDelete);
			modelTypeEndpointRef.getObject().createInstanceAndReference(model, modelRel);
		}
		else {
			modelTypeEndpointRef.getObject().replaceInstanceAndReference(getLink(), model);
		}
	}

	protected void doExecuteTypesLevel(ModelRel modelRelType, Model modelType, boolean isFullDelete) throws MMINTException {

		ModelEndpoint modelTypeEndpoint = MIDTypeHierarchy.getOverriddenModelTypeEndpoint(modelRelType, modelType);
		if (isFullDelete) {
			getLink().deleteTypeAndReference(isFullDelete);
			modelTypeEndpoint.createSubtypeAndReference(getLink().getName(), modelType, false, modelRelType);
		}
		else {
			modelTypeEndpoint.replaceSubtypeAndReference(getLink(), getLink().getName(), modelType);
		}
		// no need to init type hierarchy, no need for undo/redo
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
			if (MIDConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel(getNewSource(), getLink().getTarget(), true);
			}
			else {
				doExecuteTypesLevel(getNewSource(), getLink().getTarget(), true);
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
			if (MIDConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel((ModelRel) getLink().eContainer(), (Model) getNewTarget(), false);
			}
			else {
				doExecuteTypesLevel((ModelRel) getLink().eContainer(), (Model) getNewTarget(), false);
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
