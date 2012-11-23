/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelLightTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;

/**
 * The command to change a model of a mapping reference.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelChangeModelEndpointCommand extends ModelEndpointReorientCommand {

	private EList<String> modelTypeEndpointUris;

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
				MultiModelConstraintChecker.isInstancesLevel(getLink()) ||
				!MultiModelConstraintChecker.isRootType(getLink())
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
				!MultiModelConstraintChecker.isInstancesLevel(getLink()) ||
				(modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(getNewSource(), (Model) getOldTarget())) != null
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
				!MultiModelConstraintChecker.isInstancesLevel(getLink()) ||
				(modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(getOldSource(), (Model) getNewTarget())) != null
			);
	}

	protected void doExecuteInstancesLevel(ModelRel modelRel, Model model) throws Exception {

		MultiModelInstanceFactory.removeModelEndpointAndModelEndpointReference(getLink(), false);
		ModelEndpointReference modelTypeEndpointRef = MidDiagramTrait.selectModelTypeEndpointToCreate(modelRel, modelTypeEndpointUris, "");
		MultiModelInstanceFactory.replaceModelEndpointAndModelEndpointReference(
			getLink(),
			modelTypeEndpointRef.getObject(),
			model
		);
	}

	protected void doExecuteTypesLevel(ModelRel modelRelType, Model modelType) throws MMTFException {

		MultiModelTypeFactory.removeModelTypeEndpointAndModelTypeEndpointReference(getLink(), false);
		String newModelTypeEndpointName = getLink().getName();
		//TODO MMTF: search for override (only if we're not inheriting from a root type)
		ModelEndpointReference modelTypeEndpointRef = null;
		ModelEndpoint modelTypeEndpoint = (modelTypeEndpointRef == null) ? null : modelTypeEndpointRef.getObject();
		MultiModelLightTypeFactory.replaceLightModelTypeEndpointAndModelTypeEndpointReference(
			getLink(),
			modelRelType,
			modelTypeEndpoint,
			modelTypeEndpointRef,
			modelType,
			newModelTypeEndpointName
		);
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
			if (MultiModelConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel(getNewSource(), getLink().getTarget());
			}
			else {
				doExecuteTypesLevel(getNewSource(), getLink().getTarget());
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
	 * Changes the target model of a model relationship.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		try {
			if (MultiModelConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel((ModelRel) getLink().eContainer(), (Model) getNewTarget());
			}
			else {
				doExecuteTypesLevel((ModelRel) getLink().eContainer(), (Model) getNewTarget());
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
