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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;

/**
 * The command to create a model element reference from a dropped object.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceDropCommand extends ModelElementReferenceCreateCommand {

	/** The dropped object. */
	EObject droppedObject;

	/**
	 * Constructor: initialises the superclass and the dropped object.
	 * 
	 * @param req
	 *            The request.
	 * @param droppedObject
	 *            The dropped object.
	 */
	public ModelElementReferenceDropCommand(CreateElementRequest req, EObject droppedObject) {

		super(req);
		this.droppedObject = droppedObject;
	}

	/**
	 * Checks if a model element reference can be created.
	 * 
	 * @return True if a model element reference can be created, false
	 *         otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	/**
	 * Creates a new model element reference from a dropped object.
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

		//TODO MMTF: distinguere TYPES e INSTANCES qui e a tutti i comandi eseguibili nel rel diagram (per fare una copy in più direi, forse qualcos'altro?)
		ModelReference owner = (ModelReference) getElementToEdit();
		ModelElementReference newElement = MultiModelFactoryUtils.createModelElementReference(owner, droppedObject);
		if (owner.getObject().getLevel() == MidLevel.TYPES) {
			ModelElementReference newElementForDiagram = EcoreUtil.copy(newElement);
			//TODO add this element to the owner
			//TODO but createmodelelementreference should add it to the repository (do i need to create the alternative version in mmtfregistry?)
		}
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
