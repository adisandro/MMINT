/*
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.commands.FinalState2CreateCommand;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.commands.InitialState2CreateCommand;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.commands.State2CreateCommand;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes;

/**
 * @generated
 */
public class StateStateNestedStatesCompartmentItemSemanticEditPolicy extends
		StateMachineBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateStateNestedStatesCompartmentItemSemanticEditPolicy() {
		super(StateMachineElementTypes.State_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StateMachineElementTypes.InitialState_3001 == req.getElementType()) {
			return getGEFWrapper(new InitialState2CreateCommand(req));
		}
		if (StateMachineElementTypes.FinalState_3002 == req.getElementType()) {
			return getGEFWrapper(new FinalState2CreateCommand(req));
		}
		if (StateMachineElementTypes.State_3003 == req.getElementType()) {
			return getGEFWrapper(new State2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
