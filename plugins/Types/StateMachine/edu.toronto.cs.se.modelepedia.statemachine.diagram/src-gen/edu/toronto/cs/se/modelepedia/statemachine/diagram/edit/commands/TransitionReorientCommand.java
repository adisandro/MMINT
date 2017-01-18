/*
 * Copyright Text ->
 * 
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.modelepedia.statemachine.AbstractState;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachine;
import edu.toronto.cs.se.modelepedia.statemachine.Transition;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.policies.StateMachineBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class TransitionReorientCommand extends EditElementCommand {

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
	public TransitionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Transition) {
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
		if (!(oldEnd instanceof AbstractState && newEnd instanceof AbstractState)) {
			return false;
		}
		AbstractState target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof StateMachine)) {
			return false;
		}
		StateMachine container = (StateMachine) getLink().eContainer();
		return StateMachineBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistTransition_4001(container, getLink(), getNewSource(),
						target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof AbstractState && newEnd instanceof AbstractState)) {
			return false;
		}
		AbstractState source = getLink().getSource();
		if (!(getLink().eContainer() instanceof StateMachine)) {
			return false;
		}
		StateMachine container = (StateMachine) getLink().eContainer();
		return StateMachineBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistTransition_4001(container, getLink(), source,
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
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Transition getLink() {
		return (Transition) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected AbstractState getOldSource() {
		return (AbstractState) oldEnd;
	}

	/**
	 * @generated
	 */
	protected AbstractState getNewSource() {
		return (AbstractState) newEnd;
	}

	/**
	 * @generated
	 */
	protected AbstractState getOldTarget() {
		return (AbstractState) oldEnd;
	}

	/**
	 * @generated
	 */
	protected AbstractState getNewTarget() {
		return (AbstractState) newEnd;
	}
}
