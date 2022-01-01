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
package edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class StateStateInternalActionsCompartmentItemSemanticEditPolicy extends
		edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.policies.StateMachine_MAVOBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public StateStateInternalActionsCompartmentItemSemanticEditPolicy() {
		super(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.State_2001);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.StateAction_3001 == req
				.getElementType()) {
			return getGEFWrapper(
					new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.commands.StateActionCreateCommand(
							req));
		}
		return super.getCreateCommand(req);
	}

}
