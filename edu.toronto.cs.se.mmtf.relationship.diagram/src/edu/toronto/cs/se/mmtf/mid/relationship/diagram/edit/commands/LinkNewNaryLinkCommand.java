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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.trait.RelationshipDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;

/**
 * The command to create a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkNewNaryLinkCommand extends LinkCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public LinkNewNaryLinkCommand(CreateElementRequest req) {

		super(req);
	}

	/**
	 * Checks if a link can be created.
	 * 
	 * @return True if a link can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	/**
	 * Creates a new link.
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
			ModelRel owner = (ModelRel) getElementToEdit();
			Link newElement;
			if (owner.getLevel() == MidLevel.TYPES) {
				String subLinkTypeName = MidDiagramTrait.getStringInput("Create new light link type", "Insert new link type name");
				Link newElementType = MMTFRegistry.createLightLinkType(
					owner.getUri(),
					null,
					null,
					subLinkTypeName,
					RelationshipPackage.eINSTANCE.getLink()
				);
				newElement = EcoreUtil.copy(newElementType);
				owner.getLinks().add(newElement);
			}
			else {
				Link linkType = RelationshipDiagramTrait.selectLinkTypeToCreate(owner, null, null);
				newElement = MultiModelFactoryUtils.createLink(linkType, owner, RelationshipPackage.eINSTANCE.getLink());
			}
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
	
			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No link created", e);
			return CommandResult.newErrorCommandResult("No link created");
		}
	}

}
