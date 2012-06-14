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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MidDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;

/**
 * The command to create a model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelNewNaryRelCommand extends ModelRelCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public ModelRelNewNaryRelCommand(CreateElementRequest req) {

		super(req);
	}

	/**
	 * Checks if a model relationship can be created.
	 * 
	 * @return True if a model relationship can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	/**
	 * Creates a new model relationship.
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

		MultiModel owner = (MultiModel) getElementToEdit();
		ModelRel newElement;
		try {
			if (MultiModelConstraintChecker.isInstanceLevel(owner)) {
				ModelRel modelRelType = MidDiagramTrait.selectModelRelTypeToCreate(null, null);
				newElement = MultiModelFactoryUtils.createModelRel(
					modelRelType,
					ModelOrigin.CREATED,
					owner,
					null,
					RelationshipPackage.eINSTANCE.getModelRel()
				);
			}
			else {
				ModelRel superModelRelType = MidDiagramTrait.selectModelRelTypeToExtend(null, null);
				String subModelRelTypeName = MidDiagramTrait.getStringInput("Create new light model relationship type", "Insert new model relationship type name");
				String constraint = MidDiagramTrait.getStringInput("Create new light model relationship type", "Insert new model relationship type constraint");
				ModelRel newElementType = MMTFRegistry.createLightModelRelType(
					superModelRelType,
					subModelRelTypeName,
					constraint,
					RelationshipPackage.eINSTANCE.getModelRel()
				);
				// diagram copy
				newElement = EcoreUtil.copy(newElementType);
				owner.getModels().add(newElement);
				//TODO MMTF: how to automate this? little extendible table as return from createlighttype (for cycle->setsupertype,add2table)?
				newElement.setSupertype(
						owner.getExtendibleTable().get(newElementType.getSupertype().getUri())
					);
				owner.getExtendibleTable().put(newElement.getUri(), newElement);
			}
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
	
			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model relationship created", e);
			return CommandResult.newErrorCommandResult("No model relationship created");
		}
	}

}
