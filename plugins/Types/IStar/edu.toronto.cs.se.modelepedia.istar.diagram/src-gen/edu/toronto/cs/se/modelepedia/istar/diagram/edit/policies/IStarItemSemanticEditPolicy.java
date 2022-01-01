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
package edu.toronto.cs.se.modelepedia.istar.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.ActorCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.GoalCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.ResourceCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.SoftGoalCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.TaskCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.providers.IStarElementTypes;

/**
 * @generated
 */
public class IStarItemSemanticEditPolicy extends
		IStarBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public IStarItemSemanticEditPolicy() {
		super(IStarElementTypes.IStar_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (IStarElementTypes.SoftGoal_2001 == req.getElementType()) {
			return getGEFWrapper(new SoftGoalCreateCommand(req));
		}
		if (IStarElementTypes.Task_2002 == req.getElementType()) {
			return getGEFWrapper(new TaskCreateCommand(req));
		}
		if (IStarElementTypes.Resource_2003 == req.getElementType()) {
			return getGEFWrapper(new ResourceCreateCommand(req));
		}
		if (IStarElementTypes.Goal_2004 == req.getElementType()) {
			return getGEFWrapper(new GoalCreateCommand(req));
		}
		if (IStarElementTypes.Actor_2005 == req.getElementType()) {
			return getGEFWrapper(new ActorCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
