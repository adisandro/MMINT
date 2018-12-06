/*
 * Copyright Text ->
 * 
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
package edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.commands.FinalStateCreateCommand;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.commands.InitialStateCreateCommand;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.commands.StateCreateCommand;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes;

/**
 * @generated
 */
public class StateMachineItemSemanticEditPolicy extends
		StateMachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateMachineItemSemanticEditPolicy() {
		super(StateMachineElementTypes.StateMachine_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StateMachineElementTypes.State_2001 == req.getElementType()) {
			return getGEFWrapper(new StateCreateCommand(req));
		}
		if (StateMachineElementTypes.InitialState_2002 == req.getElementType()) {
			return getGEFWrapper(new InitialStateCreateCommand(req));
		}
		if (StateMachineElementTypes.FinalState_2003 == req.getElementType()) {
			return getGEFWrapper(new FinalStateCreateCommand(req));
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
