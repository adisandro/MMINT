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
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.commands;

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
public class EdgeReorientCommand extends EditElementCommand {

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
	public EdgeReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Edge) {
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
		if (!(oldEnd instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Node
				&& newEnd instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Node)) {
			return false;
		}
		edu.toronto.cs.se.modelepedia.graph_mavo.Node target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Graph)) {
			return false;
		}
		edu.toronto.cs.se.modelepedia.graph_mavo.Graph container = (edu.toronto.cs.se.modelepedia.graph_mavo.Graph) getLink()
				.eContainer();
		return edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.policies.Graph_MAVOBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistEdge_4001(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Node
				&& newEnd instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Node)) {
			return false;
		}
		edu.toronto.cs.se.modelepedia.graph_mavo.Node source = getLink().getSource();
		if (!(getLink().eContainer() instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Graph)) {
			return false;
		}
		edu.toronto.cs.se.modelepedia.graph_mavo.Graph container = (edu.toronto.cs.se.modelepedia.graph_mavo.Graph) getLink()
				.eContainer();
		return edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.policies.Graph_MAVOBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistEdge_4001(container, getLink(), source, getNewTarget());
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
	protected edu.toronto.cs.se.modelepedia.graph_mavo.Edge getLink() {
		return (edu.toronto.cs.se.modelepedia.graph_mavo.Edge) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.graph_mavo.Node getOldSource() {
		return (edu.toronto.cs.se.modelepedia.graph_mavo.Node) oldEnd;
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.graph_mavo.Node getNewSource() {
		return (edu.toronto.cs.se.modelepedia.graph_mavo.Node) newEnd;
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.graph_mavo.Node getOldTarget() {
		return (edu.toronto.cs.se.modelepedia.graph_mavo.Node) oldEnd;
	}

	/**
	* @generated
	*/
	protected edu.toronto.cs.se.modelepedia.graph_mavo.Node getNewTarget() {
		return (edu.toronto.cs.se.modelepedia.graph_mavo.Node) newEnd;
	}
}
