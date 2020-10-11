/*
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.modelepedia.istar.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar.Intention;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.policies.IStarBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class DependeeLinkReorientCommand extends EditElementCommand {

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
	public DependeeLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof DependeeLink) {
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
		if (!(oldEnd instanceof Intention && newEnd instanceof Intention)) {
			return false;
		}
		DependencyEndpoint target = getLink().getDependee();
		if (!(getLink().eContainer() instanceof Intention)) {
			return false;
		}
		Intention container = (Intention) getLink().eContainer();
		return IStarBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistDependeeLink_4005(container, getLink(),
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof DependencyEndpoint && newEnd instanceof DependencyEndpoint)) {
			return false;
		}
		Intention source = getLink().getDependum();
		if (!(getLink().eContainer() instanceof Intention)) {
			return false;
		}
		Intention container = (Intention) getLink().eContainer();
		return IStarBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistDependeeLink_4005(container, getLink(), source,
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
		getLink().setDependum(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setDependee(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected DependeeLink getLink() {
		return (DependeeLink) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Intention getOldSource() {
		return (Intention) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Intention getNewSource() {
		return (Intention) newEnd;
	}

	/**
	 * @generated
	 */
	protected DependencyEndpoint getOldTarget() {
		return (DependencyEndpoint) oldEnd;
	}

	/**
	 * @generated
	 */
	protected DependencyEndpoint getNewTarget() {
		return (DependencyEndpoint) newEnd;
	}
}
