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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ActorActorIntentionsCompartmentItemSemanticEditPolicy
		extends edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.policies.IStar_MAVOBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ActorActorIntentionsCompartmentItemSemanticEditPolicy() {
		super(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Actor_2005);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.SoftGoal_3001 == req
				.getElementType()) {
			return getGEFWrapper(
					new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.commands.SoftGoal2CreateCommand(req));
		}
		if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Task_3002 == req
				.getElementType()) {
			return getGEFWrapper(
					new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.commands.Task2CreateCommand(req));
		}
		if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Resource_3003 == req
				.getElementType()) {
			return getGEFWrapper(
					new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.commands.Resource2CreateCommand(req));
		}
		if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Goal_3004 == req
				.getElementType()) {
			return getGEFWrapper(
					new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.commands.Goal2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
