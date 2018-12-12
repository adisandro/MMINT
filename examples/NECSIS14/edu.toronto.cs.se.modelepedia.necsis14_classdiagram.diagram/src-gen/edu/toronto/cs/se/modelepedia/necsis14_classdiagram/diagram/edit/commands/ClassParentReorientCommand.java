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
package edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class ClassParentReorientCommand extends EditElementCommand {

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
	public ClassParentReorientCommand(
			ReorientReferenceRelationshipRequest request) {
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
		if (false == referenceOwner instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) {
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
		if (!(oldEnd instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class && newEnd instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class)) {
			return false;
		}
		return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.policies.NECSIS14_ClassDiagramBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistClassParent_4002(getNewSource(),
						getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class && newEnd instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class)) {
			return false;
		}
		return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.policies.NECSIS14_ClassDiagramBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistClassParent_4002(getOldSource(),
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
		getOldSource().setParent(null);
		getNewSource().setParent(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().setParent(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class getOldSource() {
		return (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class getNewSource() {
		return (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) newEnd;
	}

	/**
	 * @generated
	 */
	protected edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class getOldTarget() {
		return (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) oldEnd;
	}

	/**
	 * @generated
	 */
	protected edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class getNewTarget() {
		return (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) newEnd;
	}
}
