/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.GroupRequestViaKeyboard;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceEditPart;

/**
 * The component edit policy for model references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelReferenceComponentEditPolicy extends ComponentEditPolicy {

	/**
	 * Gets the command to delete a model reference when "Del" keyboard button
	 * is pressed.
	 * 
	 * @param request
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	public Command getCommand(Request request) {

		if (request instanceof GroupRequestViaKeyboard) {

			ModelReferenceEditPart editPart = (ModelReferenceEditPart) getHost();
			ModelReference modelRef = (ModelReference) ((View) editPart.getModel()).getElement();
			if (modelRef.getContainedObject() == null && modelRef.eContainer() instanceof BinaryModelRel) {
				// a binary model relationship which is not standalone can be only modified through the Mid diagram
				return UnexecutableCommand.INSTANCE;
			}
		}

		return super.getCommand(request);
	}

}
