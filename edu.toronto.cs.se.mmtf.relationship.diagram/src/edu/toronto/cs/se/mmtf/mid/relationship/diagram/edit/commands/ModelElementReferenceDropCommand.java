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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;

/**
 * The command to create a model element reference from a dropped object.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceDropCommand extends ModelElementReferenceCreateCommand {

	/** The dropped element. */
	EObject droppedElement;
	ModelElement modelElemType;

	/**
	 * Constructor: initialises the superclass and the dropped element.
	 * 
	 * @param req
	 *            The request.
	 * @param droppedElement
	 *            The dropped element.
	 */
	public ModelElementReferenceDropCommand(CreateElementRequest req, EObject droppedElement) {

		super(req);
		this.droppedElement = droppedElement;
		this.modelElemType = null;
	}

	/**
	 * Checks if a model element reference can be created.
	 * 
	 * @return True if a model element reference can be created, false
	 *         otherwise.
	 */
	@Override
	public boolean canExecute() {

		if (!super.canExecute()) {
			return false;
		}
		if (MultiModelConstraintChecker.isInstanceLevel((ModelRel) getElementToEdit().eContainer())) {
			modelElemType = MultiModelConstraintChecker.getAllowedModelElementType((ModelReference) getElementToEdit(), droppedElement);
			if (modelElemType == null) {
				return false;
			}
		}

		return true;
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

		ModelReference owner = (ModelReference) getElementToEdit();
		ModelElementReference newElementRef = null;
		try {
			if (MultiModelConstraintChecker.isInstanceLevel((ModelRel) owner.eContainer())) {
				newElementRef = MultiModelFactoryUtils.createModelElementReference(modelElemType, owner, droppedElement);
			}
			else {
				String subElementTypeName = MidDiagramTrait.getStringInput("Create new light model element type", "Insert new model element type name");
				newElementRef = MMTFRegistry.createLightModelElementType(owner, subElementTypeName, droppedElement);
				MMTFRegistry.updateRepository((MultiModel) owner.eContainer().eContainer());
			}
			doConfigure(newElementRef, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElementRef);

			return CommandResult.newOKCommandResult(newElementRef);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model element reference created", e);
			return CommandResult.newErrorCommandResult("No model element reference created");
		}
	}

}
