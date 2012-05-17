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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.MidBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class BinaryLinkReorientCommand extends EditElementCommand {

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
	public BinaryLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof BinaryLink) {
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
		if (!(oldEnd instanceof ModelElementReference && newEnd instanceof ModelElementReference)) {
			return false;
		}
		if (getLink().getElementRefs().size() != 1) {
			return false;
		}
		ModelElementReference target = (ModelElementReference) getLink()
				.getElementRefs().get(0);
		if (!(getLink().eContainer() instanceof ModelRel)) {
			return false;
		}
		ModelRel container = (ModelRel) getLink().eContainer();
		return MidBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistBinaryLink_4003(container, getLink(), getNewSource(),
						target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ModelElementReference && newEnd instanceof ModelElementReference)) {
			return false;
		}
		if (getLink().getElementRefs().size() != 1) {
			return false;
		}
		ModelElementReference source = (ModelElementReference) getLink()
				.getElementRefs().get(0);
		if (!(getLink().eContainer() instanceof ModelRel)) {
			return false;
		}
		ModelRel container = (ModelRel) getLink().eContainer();
		return MidBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistBinaryLink_4003(container, getLink(), source,
						getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
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
		getLink().getElementRefs().remove(getOldSource());
		getLink().getElementRefs().add(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getElementRefs().remove(getOldTarget());
		getLink().getElementRefs().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected BinaryLink getLink() {
		return (BinaryLink) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected ModelElementReference getOldSource() {
		return (ModelElementReference) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ModelElementReference getNewSource() {
		return (ModelElementReference) newEnd;
	}

	/**
	 * @generated
	 */
	protected ModelElementReference getOldTarget() {
		return (ModelElementReference) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ModelElementReference getNewTarget() {
		return (ModelElementReference) newEnd;
	}
}
