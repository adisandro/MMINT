/*
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
package edu.toronto.cs.se.mmint.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import edu.toronto.cs.se.mmint.mid.diagram.edit.policies.ExtendibleElementSupertypeItemSemanticEditPolicy;

/**
 * The semantic edit policy for supertypes.
 * 
 * @author Vivien Suen
 * 
 */
public class ExtendibleElementSupertypeSemanticEditPolicy extends ExtendibleElementSupertypeItemSemanticEditPolicy {

	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {

		return UnexecutableCommand.INSTANCE;
	}
}
