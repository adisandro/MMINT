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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTrait;

/**
 * The command to create a binary mapping reference.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryMappingReferenceCreateMappingCommand extends BinaryMappingReferenceCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 * @param source
	 *            The source model reference.
	 * @param target
	 *            The target model reference.
	 */
	public BinaryMappingReferenceCreateMappingCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	/**
	 * Creates a new binary mapping reference.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If source or target are null or instances of disallowed
	 *             types, or if configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}

		try {
			BinaryMappingReference newElement = (BinaryMappingReference) MultiModelTrait.createMappingReference(
				ModelReferenceOrigin.CREATED,
				getContainer(),
				null,
				MappingPackage.eINSTANCE.getBinaryMappingReference()
			);
			newElement.getModels().add(getSource());
			newElement.getModels().add(getTarget());
			MultiModelTrait.createMappingReferenceModelContainer(newElement, getSource());
			MultiModelTrait.createMappingReferenceModelContainer(newElement, getTarget());
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
	
			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No binary mapping created", e);
			return CommandResult.newErrorCommandResult("No binary mapping created");
		}
	}

}
