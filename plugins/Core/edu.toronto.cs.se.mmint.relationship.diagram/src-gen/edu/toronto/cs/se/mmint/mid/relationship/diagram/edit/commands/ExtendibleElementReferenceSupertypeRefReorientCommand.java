/*
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.MIDBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ExtendibleElementReferenceSupertypeRefReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject referenceOwner;

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
	public ExtendibleElementReferenceSupertypeRefReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == referenceOwner instanceof ExtendibleElementReference) {
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
		if (!(oldEnd instanceof ExtendibleElementReference && newEnd instanceof ExtendibleElementReference)) {
			return false;
		}
		return MIDBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistExtendibleElementReferenceSupertypeRef_4001(getNewSource(), getOldTarget());
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ExtendibleElementReference && newEnd instanceof ExtendibleElementReference)) {
			return false;
		}
		return MIDBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistExtendibleElementReferenceSupertypeRef_4001(getOldSource(), getNewTarget());
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
		getOldSource().setSupertypeRef(null);
		getNewSource().setSupertypeRef(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().setSupertypeRef(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	* @generated
	*/
	protected ExtendibleElementReference getOldSource() {
		return (ExtendibleElementReference) referenceOwner;
	}

	/**
	* @generated
	*/
	protected ExtendibleElementReference getNewSource() {
		return (ExtendibleElementReference) newEnd;
	}

	/**
	* @generated
	*/
	protected ExtendibleElementReference getOldTarget() {
		return (ExtendibleElementReference) oldEnd;
	}

	/**
	* @generated
	*/
	protected ExtendibleElementReference getNewTarget() {
		return (ExtendibleElementReference) newEnd;
	}
}
