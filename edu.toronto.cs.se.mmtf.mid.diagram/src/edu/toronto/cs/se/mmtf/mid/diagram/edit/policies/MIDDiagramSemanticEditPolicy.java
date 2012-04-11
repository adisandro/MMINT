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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceCreateMappingCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceImportMappingCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReferenceCreateModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReferenceImportModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;

/**
 * The semantic edit policy for the MID diagram (i.e. a multimodel).
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MIDDiagramSemanticEditPolicy extends MultiModelItemSemanticEditPolicy {

	/**
	 * Gets the command to create a new element in the diagram.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		if (MIDElementTypes.MappingReference_2004 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceCreateMappingCommand(req));
		}
		if (MIDElementTypes.ModelReference_2002 == req.getElementType()) {
			return getGEFWrapper(new ModelReferenceImportModelCommand(req));
		}
		if (MIDElementTypes.ModelReference_2003 == req.getElementType()) {
			return getGEFWrapper(new ModelReferenceCreateModelCommand(req));
		}
		if (MIDElementTypes.MappingReference_2005 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceImportMappingCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
