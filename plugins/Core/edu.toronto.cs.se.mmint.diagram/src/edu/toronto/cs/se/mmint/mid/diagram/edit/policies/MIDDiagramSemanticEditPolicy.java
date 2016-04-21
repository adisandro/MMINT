/*
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelImportModelCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelNewModelCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRelImportNaryRelCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRelNewNaryRelCommand;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;

/**
 * The semantic edit policy for the Mid diagram (i.e. a multimodel).
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MIDDiagramSemanticEditPolicy extends MIDItemSemanticEditPolicy {

	/**
	 * Gets the command to create a new element in the diagram.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		if (MIDElementTypes.Model_2001 == req.getElementType()) {
			return getGEFWrapper(new ModelNewModelCommand(req));
		}
		if (MIDElementTypes.Model_2002 == req.getElementType()) {
			return getGEFWrapper(new ModelImportModelCommand(req));
		}
		if (MIDElementTypes.ModelRel_2003 == req.getElementType()) {
			return getGEFWrapper(new ModelRelNewNaryRelCommand(req));
		}
		if (MIDElementTypes.ModelRel_2004 == req.getElementType()) {
			return getGEFWrapper(new ModelRelImportNaryRelCommand(req));
		}
		return null;
	}

}
