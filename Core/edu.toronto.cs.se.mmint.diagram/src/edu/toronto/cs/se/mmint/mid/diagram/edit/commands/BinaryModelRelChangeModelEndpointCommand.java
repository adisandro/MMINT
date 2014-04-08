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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.BinaryModelRelReorientCommand;
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
				(modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(getLink(), getNewSource())) != null
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
				(modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(getLink(), getNewTarget())) != null
			) || (
				!instance &&
				MultiModelConstraintChecker.isAllowedModelTypeEndpoint(getLink(), null, getNewTarget())
			));
	}

	protected void doExecuteInstancesLevel(BinaryModelRel modelRel, Model model, boolean isBinarySrc) throws MMINTException, MultiModelDialogCancellation {

		ModelEndpoint oldModelEndpoint = (isBinarySrc) ?
			modelRel.getModelEndpoints().get(0) :
			modelRel.getModelEndpoints().get(1);
		ModelEndpointReference modelTypeEndpointRef = MultiModelDiagramUtils.selectModelTypeEndpointToCreate(modelRel, modelTypeEndpointUris, ((isBinarySrc) ? "src " : "tgt "));
		modelTypeEndpointRef.getObject().replaceInstanceAndReference(oldModelEndpoint, model, modelRel);
	}

	protected void doExecuteTypesLevel(BinaryModelRel modelRelType, Model modelType, boolean isBinarySrc) throws MMINTException {

		//TODO[MODELREL] the old endpoint could be null, or the target could be index 0
		ModelEndpoint oldModelTypeEndpoint = (isBinarySrc) ?
			modelRelType.getModelEndpoints().get(0) :
			modelRelType.getModelEndpoints().get(1);
		ModelEndpoint modelTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelTypeEndpoint(modelRelType, modelType);
//		if (modelTypeEndpoint == null) {
//			if (isBinarySrc) {
//				modelRelType.setSourceModel(modelType);
//			}
//			else {
//				modelRelType.setTargetModel(modelType);
//			}
//		}
		modelTypeEndpoint.replaceSubtypeAndReference(oldModelTypeEndpoint, modelTypeEndpointRef, oldModelTypeEndpoint.getName(), modelType, modelRelType);
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
			MMINTException.print(MMINTException.Type.ERROR, "No model endpoint changed", e);
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
			MMINTException.print(MMINTException.Type.ERROR, "No model endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model endpoint changed");
		}
	}

}
