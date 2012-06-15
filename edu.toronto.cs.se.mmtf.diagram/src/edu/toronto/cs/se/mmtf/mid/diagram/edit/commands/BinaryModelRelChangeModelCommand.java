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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.MidBaseItemSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;

/**
 * The command to change a model of a binary model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryModelRelChangeModelCommand extends BinaryModelRelReorientCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public BinaryModelRelChangeModelCommand(ReorientRelationshipRequest request) {

		super(request);
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
				MultiModelConstraintChecker.isInstanceLevel(getLink()) ||
				MultiModelConstraintChecker.isAllowedModelType(getLink())
			);
	}

	/**
	 * Checks if the source model can be changed.
	 * 
	 * @return True if the source model can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientSource() {

		if (!(getOldSource() instanceof Model && getNewSource() instanceof Model)) {
			return false;
		}
		if (getLink().getModels().size() != 2) {
			return false;
		}
		Model target = (Model) getLink().getModels().get(1);
		if (!(getLink().eContainer() instanceof MultiModel)) {
			return false;
		}
		MultiModel container = (MultiModel) getLink().eContainer();

		return
			MidBaseItemSemanticEditPolicy.getLinkConstraints().canExistBinaryModelRel_4003(container, getLink(), getNewSource(), target) && (
				!MultiModelConstraintChecker.isInstanceLevel(getLink()) ||
				MultiModelConstraintChecker.isAllowedModel(getLink(), getNewSource())
			);
	}

	/**
	 * Checks if the target model can be changed.
	 * 
	 * @return True if the target model can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientTarget() {

		if (!(getOldSource() instanceof Model && getNewSource() instanceof Model)) {
			return false;
		}
		if (getLink().getModels().size() != 2) {
			return false;
		}
		Model source = (Model) getLink().getModels().get(0);
		if (!(getLink().eContainer() instanceof MultiModel)) {
			return false;
		}
		MultiModel container = (MultiModel) getLink().eContainer();

		return
			MidBaseItemSemanticEditPolicy.getLinkConstraints().canExistBinaryModelRel_4003(container, getLink(), source, getNewTarget()) && (
				!MultiModelConstraintChecker.isInstanceLevel(getLink()) ||
				MultiModelConstraintChecker.isAllowedModel(getLink(), getNewTarget())
			);
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

		getLink().getModels().set(0, getNewSource());
		if (MultiModelConstraintChecker.isInstanceLevel(getLink())) {
			MultiModelFactoryUtils.removeModelReference(getLink(), getOldSource());
			MultiModelFactoryUtils.createModelReference(getLink(), getNewSource());
		}
		else {
			MMTFRegistry.removeLightModelTypeRef(getLink(), getOldSource());
			MMTFRegistry.createLightModelTypeRef(getLink(), getNewSource());
			MMTFRegistry.updateRepository((MultiModel) getLink().eContainer());
		}

		return CommandResult.newOKCommandResult(getLink());
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

		getLink().getModels().set(1, getNewTarget());
		if (MultiModelConstraintChecker.isInstanceLevel(getLink())) {
			MultiModelFactoryUtils.removeModelReference(getLink(), getOldTarget());
			MultiModelFactoryUtils.createModelReference(getLink(), getNewTarget());
		}
		else {
			MMTFRegistry.removeLightModelTypeRef(getLink(), getOldTarget());
			MMTFRegistry.createLightModelTypeRef(getLink(), getNewTarget());
			MMTFRegistry.updateRepository((MultiModel) getLink().eContainer());
		}

		return CommandResult.newOKCommandResult(getLink());
	}

}
