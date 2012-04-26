/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingLink;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies.MIDBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class BinaryMappingLinkReorientCommand extends EditElementCommand {

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
	public BinaryMappingLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof BinaryMappingLink) {
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
		if (getLink().getElements().size() != 1) {
			return false;
		}
		ModelElementReference target = (ModelElementReference) getLink()
				.getElements().get(0);
		if (!(getLink().eContainer() instanceof MappingReference)) {
			return false;
		}
		MappingReference container = (MappingReference) getLink().eContainer();
		return MIDBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistBinaryMappingLink_4005(container, getLink(),
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ModelElementReference && newEnd instanceof ModelElementReference)) {
			return false;
		}
		if (getLink().getElements().size() != 1) {
			return false;
		}
		ModelElementReference source = (ModelElementReference) getLink()
				.getElements().get(0);
		if (!(getLink().eContainer() instanceof MappingReference)) {
			return false;
		}
		MappingReference container = (MappingReference) getLink().eContainer();
		return MIDBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistBinaryMappingLink_4005(container, getLink(), source,
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
		getLink().getElements().remove(getOldSource());
		getLink().getElements().add(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getElements().remove(getOldTarget());
		getLink().getElements().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected BinaryMappingLink getLink() {
		return (BinaryMappingLink) getElementToEdit();
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
