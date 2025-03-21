/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class BinaryMappingReferenceDelCommand extends DestroyElementCommand {

	public BinaryMappingReferenceDelCommand(DestroyElementRequest request) {

		super(request);
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

	@Override
	public boolean canExecute() {

		ModelRel modelRel = (ModelRel) getElementToEdit();
		return super.canExecute() && (
			modelRel.isInstancesLevel() ||
			(modelRel.isTypesLevel() && !MIDTypeHierarchy.isRootType(((BinaryMappingReference) getElementToDestroy()).getObject()))
		);
	}

	protected void doExecuteTypesLevel() throws MMINTException {

		((BinaryMappingReference) getElementToDestroy()).deleteTypeAndReference();
		MMINT.createTypeHierarchy(((ModelRel) getElementToEdit()).getMIDContainer());
	}

	protected void doExecuteInstancesLevel() throws MMINTException {

		((BinaryMappingReference) getElementToDestroy()).deleteInstanceAndReference();
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			switch (((ModelRel) getElementToEdit()).getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel();
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel();
					break;
				case WORKFLOWS:
					throw new MMINTException("The WORKFLOWS level is not allowed");
				default:
					throw new MMINTException("The MID level is missing");
			}

			return super.doExecuteWithResult(monitor, info);
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No binary link deleted", e);
			return CommandResult.newErrorCommandResult("No binary link deleted");
		}
	}

}
