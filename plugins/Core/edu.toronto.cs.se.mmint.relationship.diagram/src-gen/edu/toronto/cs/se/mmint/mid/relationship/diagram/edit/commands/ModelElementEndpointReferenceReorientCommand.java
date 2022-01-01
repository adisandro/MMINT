/*
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.MIDBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ModelElementEndpointReferenceReorientCommand extends EditElementCommand {

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
	public ModelElementEndpointReferenceReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof ModelElementEndpointReference) {
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
		if (!(oldEnd instanceof MappingReference && newEnd instanceof MappingReference)) {
			return false;
		}
		ModelElementReference target = getLink().getModelElemRef();
		return MIDBaseItemSemanticEditPolicy.getLinkConstraints().canExistModelElementEndpointReference_4002(getLink(),
				getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ModelElementReference && newEnd instanceof ModelElementReference)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof MappingReference)) {
			return false;
		}
		MappingReference source = (MappingReference) getLink().eContainer();
		return MIDBaseItemSemanticEditPolicy.getLinkConstraints().canExistModelElementEndpointReference_4002(getLink(),
				source, getNewTarget());
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
		getOldSource().getModelElemEndpointRefs().remove(getLink());
		getNewSource().getModelElemEndpointRefs().add(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setModelElemRef(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected ModelElementEndpointReference getLink() {
		return (ModelElementEndpointReference) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected MappingReference getOldSource() {
		return (MappingReference) oldEnd;
	}

	/**
	* @generated
	*/
	protected MappingReference getNewSource() {
		return (MappingReference) newEnd;
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
