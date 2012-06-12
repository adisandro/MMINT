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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
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
	}

	/**
	 * Checks if a model element reference can be created.
	 * 
	 * @return True if a model element reference can be created, false
	 *         otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				!MultiModelConstraintChecker.isInstanceLevel((ModelRel) getElementToEdit().eContainer()) ||
				MultiModelConstraintChecker.isAllowedModelElement((ModelRel) getElementToEdit().eContainer(), droppedElement)
			);
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
		ModelElementReference newElement = null;
		try {
			if (owner.getObject().getLevel() == MidLevel.TYPES) {
				String subElementTypeName = MidDiagramTrait.getStringInput("Create new light model element type", "Insert new model element type name");
				ModelElementReference newElementType = MMTFRegistry.createLightModelElementType(owner, subElementTypeName, droppedElement);
				newElement = EcoreUtil.copy(newElementType);
				owner.getElementRefs().add(newElement);
			}
			else {
				Model model = (Model) owner.getObject();
				//TODO MMTF: go through supertypes?
				for (ModelElement elementType : MMTFRegistry.getModelElementTypes((Model) model.getMetatype())) {
					if (MultiModelConstraintChecker.isAllowedModelElementType(elementType, droppedElement)) {
						newElement = MultiModelFactoryUtils.createModelElementReference(elementType, owner, droppedElement);
						break;
					}
				}
				if (newElement == null) {
					throw new MMTFException("Dropped element type not found");
				}
			}
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
	
			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model element created", e);
			return CommandResult.newErrorCommandResult("No model element created");
		}
	}

}
