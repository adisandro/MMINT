/*
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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;

/**
 * The component edit policy for model references.
 * 
 * @author Vivien Suen
 * 
 */
public class MappingReferenceSuperComponentEditPolicy extends ComponentEditPolicy {

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

		return null;
	}

}
