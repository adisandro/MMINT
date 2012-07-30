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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.trait.RelationshipDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeFactory;

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

	protected Link doExecuteInstancesLevel() throws Exception {

		ModelRel modelRel = (ModelRel) getElementToEdit();
		Link linkType = RelationshipDiagramTrait.selectLinkTypeToCreate(modelRel, null, null);
		Link newLink = MultiModelInstanceFactory.createLink(linkType, modelRel, RelationshipPackage.eINSTANCE.getLink());

		return newLink;
	}

	protected Link doExecuteTypesLevel() throws MMTFException {

		ModelRel modelRelType = (ModelRel) getElementToEdit();
		String newLinkTypeName = MidDiagramTrait.getStringInput("Create new light link type", "Insert new link type name");
		Link newLinkType = MultiModelTypeFactory.createLightLinkType(
			modelRelType,
			null,
			null,
			newLinkTypeName,
			RelationshipPackage.eINSTANCE.getLink()
		);
		MultiModelTypeFactory.syncRepository((MultiModel) modelRelType.eContainer());

		return newLinkType;
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
			Link newElement = (MultiModelConstraintChecker.isInstancesLevel((ModelRel) getElementToEdit())) ?
				doExecuteInstancesLevel() :
				doExecuteTypesLevel();
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
