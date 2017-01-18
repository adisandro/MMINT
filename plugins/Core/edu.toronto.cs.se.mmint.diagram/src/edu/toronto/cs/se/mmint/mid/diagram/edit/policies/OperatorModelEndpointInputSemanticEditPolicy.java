/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * The semantic edit policy for input parameters.
 * 
 * @author Vivien Suen
 * 
 */
public class OperatorModelEndpointInputSemanticEditPolicy extends ModelEndpoint2ItemSemanticEditPolicy {

	/** Gets the command to destroy an input parameter.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

}
