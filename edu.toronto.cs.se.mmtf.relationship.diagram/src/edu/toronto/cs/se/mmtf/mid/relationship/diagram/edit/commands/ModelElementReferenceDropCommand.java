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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

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

		//TODO MMTF: aggiungere canExecute per validare, aggiungerlo a tutti i comandi in realtà nel rel diagram
		//TODO MMTF: nel mid diagram dovrei chiedere ogni volta che creo/modifico una rel di che tipo statico la voglio, scelta in base ai dinamici available
		//TODO MMTF: in più nel mid diagram devo dare un hint quando è possibile una type conversion, con relativo action menu
		//TODO MMTF: tale conversione è semplicemente un assegnamento allo static type, che quindi ora non è più dynamic transient volatile blabla
		//TODO MMTF: distinguere TYPES e INSTANCES (per fare una copy in più direi, forse qualcos'altro?)
		ModelReference owner = (ModelReference) getElementToEdit();
		ModelElementReference newElement = MultiModelFactoryUtils.createModelElementReference(owner, droppedObject);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
