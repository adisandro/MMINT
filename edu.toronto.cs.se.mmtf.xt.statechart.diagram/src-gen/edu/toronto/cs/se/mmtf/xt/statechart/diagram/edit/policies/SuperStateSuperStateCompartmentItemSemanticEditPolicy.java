/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.commands.State2CreateCommand;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.commands.SuperState2CreateCommand;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.providers.StatechartElementTypes;

/**
 * @generated
 */
public class SuperStateSuperStateCompartmentItemSemanticEditPolicy extends
		StatechartBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SuperStateSuperStateCompartmentItemSemanticEditPolicy() {
		super(StatechartElementTypes.SuperState_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (StatechartElementTypes.State_3001 == req.getElementType()) {
			return getGEFWrapper(new State2CreateCommand(req));
		}
		if (StatechartElementTypes.SuperState_3002 == req.getElementType()) {
			return getGEFWrapper(new SuperState2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
