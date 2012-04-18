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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTrait;

/**
 * The command to create a mapping reference by also creating the underlying
 * mapping structure.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MappingReferenceCreateMappingCommand extends MappingReferenceCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public MappingReferenceCreateMappingCommand(CreateElementRequest req) {

		super(req);
	}

	/**
	 * Creates a new mapping reference by also creating the underlying mapping
	 * structure.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			MultiModel owner = (MultiModel) getElementToEdit();
			MappingReference newElement = MultiModelTrait.createMappingReference(
				ModelReferenceOrigin.CREATED,
				owner,
				null,
				MappingPackage.eINSTANCE.getMappingReference()
			);
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
	
			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No mapping created", e);
			return CommandResult.newErrorCommandResult("No mapping created");
		}
	}

}
