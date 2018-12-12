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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class DependerLinkReorientCommand extends EditElementCommand {

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
	public DependerLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink) {
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
		if (!(oldEnd instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint
				&& newEnd instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint)) {
			return false;
		}
		edu.toronto.cs.se.modelepedia.istar_mavo.Intention target = getLink().getDependum();
		if (!(getLink().eContainer() instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention)) {
			return false;
		}
		edu.toronto.cs.se.modelepedia.istar_mavo.Intention container = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) getLink()
				.eContainer();
		return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.policies.IStar_MAVOBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistDependerLink_4004(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention
				&& newEnd instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention)) {
			return false;
		}
		edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint source = getLink().getDepender();
		if (!(getLink().eContainer() instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention)) {
			return false;
		}
		edu.toronto.cs.se.modelepedia.istar_mavo.Intention container = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) getLink()
				.eContainer();
		return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.policies.IStar_MAVOBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistDependerLink_4004(container, getLink(), source, getNewTarget());
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
		getLink().setDepender(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setDependum(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink getLink() {
		return (edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint getOldSource() {
		return (edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint) oldEnd;
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint getNewSource() {
		return (edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint) newEnd;
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.istar_mavo.Intention getOldTarget() {
		return (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) oldEnd;
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.istar_mavo.Intention getNewTarget() {
		return (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) newEnd;
	}
}
