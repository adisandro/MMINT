/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;

/**
 * The command to remove a model element reference from a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MappingReferenceRemoveModelElementEndpointReferenceCommand extends DestroyElementCommand {

	public MappingReferenceRemoveModelElementEndpointReferenceCommand(DestroyElementRequest request) {

		super(request);
	}

	@Override
	public boolean canExecute() {

		MappingReference mappingRef = (MappingReference) getElementToEdit();
		return super.canExecute() && (
			mappingRef.isInstancesLevel() ||
			(mappingRef.isTypesLevel() && !MIDTypeHierarchy.isRootType(((ModelElementEndpointReference) getElementToDestroy()).getObject()))
		);
	}

	protected void doExecuteTypesLevel() throws MMINTException {

		((ModelElementEndpointReference) getElementToDestroy()).deleteTypeAndReference(true);
		// no need to init type hierarchy, no need for undo/redo
	}

	protected void doExecuteInstancesLevel() throws MMINTException {

		((ModelElementEndpointReference) getElementToDestroy()).deleteInstanceAndReference(true);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			switch (((MappingReference) getElementToEdit()).getObject().getLevel()) {
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
			MMINTException.print(IStatus.ERROR, "No model element endpoint deleted", e);
			return CommandResult.newErrorCommandResult("No model element endpoint deleted");
		}
	}

}
