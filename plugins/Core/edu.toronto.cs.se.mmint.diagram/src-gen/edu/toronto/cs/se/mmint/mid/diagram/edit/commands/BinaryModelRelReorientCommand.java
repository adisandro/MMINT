/*
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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.edit.policies.MIDBaseItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;

/**
 * @generated
 */
public class BinaryModelRelReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject oldEnd;

	/**
	* @generated
	*/
	private final EObject newEnd;

	/**
	* @generated
	*/
	public BinaryModelRelReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof BinaryModelRel) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Model && newEnd instanceof Model)) {
			return false;
		}
		Model target = getLink().getTargetModel();
		if (!(getLink().eContainer() instanceof edu.toronto.cs.se.mmint.mid.MID)) {
			return false;
		}
		edu.toronto.cs.se.mmint.mid.MID container = (edu.toronto.cs.se.mmint.mid.MID) getLink().eContainer();
		return MIDBaseItemSemanticEditPolicy
			.getLinkConstraints()
			.canExistBinaryModelRel_4003(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Model && newEnd instanceof Model)) {
			return false;
		}
		Model source = getLink().getSourceModel();
		if (!(getLink().eContainer() instanceof edu.toronto.cs.se.mmint.mid.MID)) {
			return false;
		}
		edu.toronto.cs.se.mmint.mid.MID container = (edu.toronto.cs.se.mmint.mid.MID) getLink().eContainer();
		return MIDBaseItemSemanticEditPolicy
			.getLinkConstraints()
			.canExistBinaryModelRel_4003(container, getLink(), source, getNewTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	* @generated
	*/
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSourceModel(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTargetModel(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected BinaryModelRel getLink() {
		return (BinaryModelRel) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected Model getOldSource() {
		return (Model) oldEnd;
	}

	/**
	* @generated
	*/
	protected Model getNewSource() {
		return (Model) newEnd;
	}

	/**
	* @generated
	*/
	protected Model getOldTarget() {
		return (Model) oldEnd;
	}

	/**
	* @generated
	*/
	protected Model getNewTarget() {
		return (Model) newEnd;
	}
}
