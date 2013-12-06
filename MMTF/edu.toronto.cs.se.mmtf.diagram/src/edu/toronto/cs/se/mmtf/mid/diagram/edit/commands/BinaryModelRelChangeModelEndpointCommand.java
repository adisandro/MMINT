/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelLightTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;

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

	protected void doExecuteInstancesLevel(BinaryModelRel modelRel, Model model, boolean isBinarySrc) throws Exception {

		ModelEndpoint oldModelEndpoint = (isBinarySrc) ?
			modelRel.getModelEndpoints().get(0) :
			modelRel.getModelEndpoints().get(1);
		MultiModelInstanceFactory.removeModelEndpointAndModelEndpointReference(oldModelEndpoint, false);
		ModelEndpointReference modelTypeEndpointRef = MidDiagramUtils.selectModelTypeEndpointToCreate(modelRel, modelTypeEndpointUris, ((isBinarySrc) ? "src " : "tgt "));
		MultiModelInstanceFactory.replaceModelEndpointAndModelEndpointReference(
			oldModelEndpoint,
			modelTypeEndpointRef.getObject(),
			model
		);
	}

	protected void doExecuteTypesLevel(BinaryModelRel modelRelType, Model modelType, boolean isBinarySrc) throws MMTFException {

		ModelEndpoint oldModelTypeEndpoint = (isBinarySrc) ?
			modelRelType.getModelEndpoints().get(0) :
			modelRelType.getModelEndpoints().get(1);
		MultiModelTypeFactory.removeModelTypeEndpointAndModelTypeEndpointReference(oldModelTypeEndpoint, false);
		String newModelTypeEndpointName = oldModelTypeEndpoint.getName();
		//TODO MMTF: search for override (only if we're not inheriting from a root type)
		ModelEndpointReference modelTypeEndpointRef = null;
		ModelEndpoint modelTypeEndpoint = (modelTypeEndpointRef == null) ? null : modelTypeEndpointRef.getObject();
		MultiModelLightTypeFactory.replaceLightModelTypeEndpointAndModelTypeEndpointReference(
			oldModelTypeEndpoint,
			modelTypeEndpoint,
			modelTypeEndpointRef,
			newModelTypeEndpointName,
			modelType,
			modelRelType
		);
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
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model endpoint changed", e);
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
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model endpoint changed");
		}
	}

}
