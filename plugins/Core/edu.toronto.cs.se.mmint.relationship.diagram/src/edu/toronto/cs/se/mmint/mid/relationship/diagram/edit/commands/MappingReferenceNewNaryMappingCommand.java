/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;

/**
 * The command to create a link.
 *
 * @author Alessio Di Sandro
 *
 */
public class MappingReferenceNewNaryMappingCommand extends MappingReferenceCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 *
	 * @param req
	 *            The request.
	 */
	public MappingReferenceNewNaryMappingCommand(CreateElementRequest req) {

		super(req);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MID mid = ((ModelRel) getElementToEdit()).getMIDContainer();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MID mid = ((ModelRel) getElementToEdit()).getMIDContainer();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

	/**
	 * Checks if a link can be created.
	 *
	 * @return True if a link can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		ModelRel modelRel = (ModelRel) getElementToEdit();
		return super.canExecute() && (
			modelRel.isInstancesLevel() ||
			(modelRel.isTypesLevel() && !MIDTypeHierarchy.isRootType((ModelRel) getElementToEdit()))
		);
	}

	protected MappingReference doExecuteTypesLevel() throws MMINTException, MIDDialogCancellation {

		ModelRel modelRelType = (ModelRel) getElementToEdit();
		MappingReference mappingTypeRef = MIDDialogs.selectMappingTypeReferenceToExtend(modelRelType, null, null);
		Mapping mappingType = mappingTypeRef.getObject();
		if (MIDTypeHierarchy.getRootTypeUri(mappingType).equals(mappingType.getUri())) {
			mappingTypeRef = null; // the link reference to the root is never shown
		}
		String newMappingTypeName = MIDDialogs.getStringInput("Create new light mapping type", "Insert new mapping type name", null);
		MappingReference newMappingTypeRef = mappingType.createSubtypeAndReference(mappingTypeRef, newMappingTypeName, false, modelRelType);
		MMINT.createTypeHierarchy(modelRelType.getMIDContainer());

		return newMappingTypeRef;
	}

	protected MappingReference doExecuteInstancesLevel() throws MMINTException, MIDDialogCancellation {

		ModelRel modelRel = (ModelRel) getElementToEdit();
		Mapping mappingType = MIDDialogs.selectMappingTypeToCreate(modelRel, null, null);
		MappingReference newMappingRef = mappingType.createInstanceAndReference(false, modelRel);

		return newMappingRef;
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
			MappingReference newElement;
			switch (((ModelRel) getElementToEdit()).getLevel()) {
				case TYPES:
					newElement = this.doExecuteTypesLevel();
					break;
				case INSTANCES:
					newElement = this.doExecuteInstancesLevel();
					break;
				case WORKFLOWS:
					throw new MMINTException("The WORKFLOWS level is not allowed");
				default:
					throw new MMINTException("The MID level is missing");
			}
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (MIDDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No link created", e);
			return CommandResult.newErrorCommandResult("No link created");
		}
	}

}
