/*
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.Goal2CreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.Resource2CreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.SoftGoal2CreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.Task2CreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.providers.IStarElementTypes;

/**
 * @generated
 */
public class ActorActorIntentionsCompartmentItemSemanticEditPolicy extends
		IStarBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActorActorIntentionsCompartmentItemSemanticEditPolicy() {
		super(IStarElementTypes.Actor_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (IStarElementTypes.SoftGoal_3001 == req.getElementType()) {
			return getGEFWrapper(new SoftGoal2CreateCommand(req));
		}
		if (IStarElementTypes.Task_3002 == req.getElementType()) {
			return getGEFWrapper(new Task2CreateCommand(req));
		}
		if (IStarElementTypes.Resource_3003 == req.getElementType()) {
			return getGEFWrapper(new Resource2CreateCommand(req));
		}
		if (IStarElementTypes.Goal_3004 == req.getElementType()) {
			return getGEFWrapper(new Goal2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
