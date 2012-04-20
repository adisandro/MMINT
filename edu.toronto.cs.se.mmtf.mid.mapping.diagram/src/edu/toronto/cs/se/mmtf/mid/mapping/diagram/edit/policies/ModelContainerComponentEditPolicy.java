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
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.GroupRequestViaKeyboard;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelContainerEditPart;

/**
 * The component edit policy for model containers.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelContainerComponentEditPolicy extends ComponentEditPolicy {

	/**
	 * Gets the command to delete a model container when "Del" keyboard button
	 * is pressed.
	 * 
	 * @param request
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	public Command getCommand(Request request) {

		if (request instanceof GroupRequestViaKeyboard) {

			ModelContainerEditPart editPart = (ModelContainerEditPart) getHost();
			ModelContainer container = (ModelContainer) ((View) editPart.getModel()).getElement();
			if (container.getContainedModel() == null && container.eContainer() instanceof BinaryMappingReference) {
				// a binary mapping which is not standalone can be only modified through the MID
				return UnexecutableCommand.INSTANCE;
			}
		}

		return super.getCommand(request);
	}

}
