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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;

/**
 * The command to change a model element reference of a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkChangeModelElementReferenceCommand extends LinkElementRefsReorientCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public LinkChangeModelElementReferenceCommand(ReorientReferenceRelationshipRequest request) {

		super(request);
	}

	/**
	 * Checks if a model element reference can be changed.
	 * 
	 * @return True if a model element reference can be changed, false
	 *         otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel((ModelRel) getOldSource().eContainer()) ||
				MultiModelConstraintChecker.isAllowedModelElementTypeReference(getOldSource())
			);
	}

	/**
	 * Checks if the source link can be changed.
	 * 
	 * @return True if the source link can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientSource() {

		return
			super.canReorientSource() && (
				!MultiModelConstraintChecker.isInstancesLevel((ModelRel) getOldSource().eContainer()) ||
				MultiModelConstraintChecker.isAllowedModelElementReference(getNewSource(), getOldTarget())
			);
	}

	/**
	 * Checks if the target model element reference can be changed.
	 * 
	 * @return True if the target model element reference can be changed, false
	 *         otherwise.
	 */
	@Override
	protected boolean canReorientTarget() {

		return
			super.canReorientTarget() && (
				!MultiModelConstraintChecker.isInstancesLevel((ModelRel) getOldSource().eContainer()) ||
				MultiModelConstraintChecker.isAllowedModelElementReference(getOldSource(), getNewTarget())
			);
	}

	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		MultiModel multiModel = (MultiModel) getOldSource().eContainer().eContainer();
		CommandResult result = super.reorientSource();
		if (!MultiModelConstraintChecker.isInstancesLevel((ModelRel) getOldSource().eContainer())) {
			MMTFRegistry.updateRepository(multiModel);
		}

		return result;
	}

	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		MultiModel multiModel = (MultiModel) getOldSource().eContainer().eContainer();
		CommandResult result = super.reorientTarget();
		if (!MultiModelConstraintChecker.isInstancesLevel((ModelRel) getOldSource().eContainer())) {
			MMTFRegistry.updateRepository(multiModel);
		}

		return result;
	}

}
