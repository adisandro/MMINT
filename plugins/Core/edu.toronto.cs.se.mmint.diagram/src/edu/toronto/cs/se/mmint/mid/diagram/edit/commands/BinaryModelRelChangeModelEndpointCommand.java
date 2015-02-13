/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDialogCancellation;

/**
 * The command to change a model of a binary model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryModelRelChangeModelEndpointCommand extends BinaryModelRelReorientCommand {

	private List<String> modelTypeEndpointUris;

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public BinaryModelRelChangeModelEndpointCommand(ReorientRelationshipRequest request) {

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
				MultiModelConstraintChecker.isInstancesLevel(getLink()) ||
				!MultiModelTypeHierarchy.isRootType(getLink())
			);
	}

	/**
	 * Checks if the source model can be changed.
	 * 
	 * @return True if the source model can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientSource() {

		boolean instance = MultiModelConstraintChecker.isInstancesLevel(getLink());

		return
			super.canReorientSource() && ((
				instance &&
				(modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(getLink(), getLink().getModelEndpoints().get(0), getNewSource())) != null
			) || (
				!instance &&
				MultiModelConstraintChecker.isAllowedModelTypeEndpoint(getLink(), getNewSource(), null)
			));
	}

	/**
	 * Checks if the target model can be changed.
	 * 
	 * @return True if the target model can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientTarget() {

		boolean instance = MultiModelConstraintChecker.isInstancesLevel(getLink());

		return
			super.canReorientTarget() && ((
				instance &&
				(modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(getLink(), getLink().getModelEndpoints().get(1), getNewTarget())) != null
			) || (
				!instance &&
				MultiModelConstraintChecker.isAllowedModelTypeEndpoint(getLink(), null, getNewTarget())
			));
	}

	protected void doExecuteInstancesLevel(BinaryModelRel containerModelRel, Model targetModel, boolean isBinarySrc) throws MMINTException, MultiModelDialogCancellation {

		ModelEndpoint oldModelEndpoint = (isBinarySrc) ?
			containerModelRel.getModelEndpoints().get(0) :
			containerModelRel.getModelEndpoints().get(1);
		ModelEndpointReference modelTypeEndpointRef = MultiModelDiagramUtils.selectModelTypeEndpointToCreate(containerModelRel, modelTypeEndpointUris, ((isBinarySrc) ? "src " : "tgt "));
		modelTypeEndpointRef.getObject().replaceInstanceAndReference(oldModelEndpoint, targetModel);
	}

	protected void doExecuteTypesLevel(BinaryModelRel containerModelRelType, Model targetModelType, boolean isBinarySrc) throws MMINTException, MultiModelDialogCancellation {

		boolean wasOverriding = false;
		ModelEndpoint oldModelTypeEndpoint = null;
		if (containerModelRelType.getModelEndpoints().size() == 2) {
			oldModelTypeEndpoint = (isBinarySrc) ?
				containerModelRelType.getModelEndpoints().get(0) :
				containerModelRelType.getModelEndpoints().get(1);
			wasOverriding = true;
		}
		else if (containerModelRelType.getModelEndpoints().size() == 1) {
			ModelEndpoint singleModelTypeEndpoint = containerModelRelType.getModelEndpoints().get(0);
			wasOverriding = (isBinarySrc) ?
				(containerModelRelType.getSourceModel() == singleModelTypeEndpoint.getTarget()) :
				(containerModelRelType.getTargetModel() == singleModelTypeEndpoint.getTarget());
			if (wasOverriding) {
				oldModelTypeEndpoint = singleModelTypeEndpoint;
			}
		}

		ModelEndpoint modelTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelTypeEndpoint(containerModelRelType, targetModelType);
		if (modelTypeEndpoint == null) {
			if (wasOverriding) { // was overriding, becomes non-overriding
				oldModelTypeEndpoint.deleteTypeAndReference(true);
			}
			// was overriding, becomes non-overriding
			// was non-overriding, remains non-overriding
			containerModelRelType.addModelType(targetModelType, isBinarySrc);
		}
		else {
			if (wasOverriding) { // was overriding, remains overriding
				modelTypeEndpoint.replaceSubtypeAndReference(oldModelTypeEndpoint, oldModelTypeEndpoint.getName(), targetModelType);
			}
			else { // was non-overriding, becomes overriding
				String detail = (isBinarySrc) ? "source" : "target";
				String newModelTypeEndpointName = MultiModelDiagramUtils.getStringInput("Create new " + detail + " model type endpoint", "Insert new " + detail + " model type endpoint role", targetModelType.getName());
				if (isBinarySrc && containerModelRelType.getModelEndpoints().size() == 1) { // guarantee that src endpoint comes before tgt endpoint
					ModelEndpoint tgtModelTypeEndpoint = containerModelRelType.getModelEndpoints().get(0);
					tgtModelTypeEndpoint.deleteTypeAndReference(true);
					modelTypeEndpoint.createSubtypeAndReference(newModelTypeEndpointName, targetModelType, true, containerModelRelType);
					tgtModelTypeEndpoint.getSupertype().createSubtypeAndReference(tgtModelTypeEndpoint.getName(), tgtModelTypeEndpoint.getTarget(), false, containerModelRelType);
				}
				else {
					modelTypeEndpoint.createSubtypeAndReference(newModelTypeEndpointName, targetModelType, isBinarySrc, containerModelRelType);
				}
			}
		}
		// no need to init type hierarchy, no need for undo/redo
	}

	/**
	 * Changes the source model of a binary model relationship.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		try {
			if (MultiModelConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel(getLink(), getNewSource(), true);
			}
			else {
				doExecuteTypesLevel(getLink(), getNewSource(), true);
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (MultiModelDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model endpoint changed");
		}
	}

	/**
	 * Changes the target model of a binary model relationship.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		try {
			if (MultiModelConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel(getLink(), getNewTarget(), false);
			}
			else {
				doExecuteTypesLevel(getLink(), getNewTarget(), false);
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (MultiModelDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model endpoint changed");
		}
	}

}
