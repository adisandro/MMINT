/*
 * Copyright Text ->
 * 
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.commands.StateActionCreateCommand;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes;

/**
 * @generated
 */
public class StateStateInternalActionsCompartmentItemSemanticEditPolicy extends
		StateMachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateStateInternalActionsCompartmentItemSemanticEditPolicy() {
		super(StateMachineElementTypes.State_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StateMachineElementTypes.StateAction_3001 == req.getElementType()) {
			return getGEFWrapper(new StateActionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
