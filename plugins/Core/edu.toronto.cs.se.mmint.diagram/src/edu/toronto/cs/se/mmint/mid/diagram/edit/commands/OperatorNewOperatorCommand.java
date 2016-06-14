/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.library.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.library.MIDUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogUtils;

public class OperatorNewOperatorCommand extends OperatorCreateCommand {

	public OperatorNewOperatorCommand(CreateElementRequest req) {

		super(req);
	}

	@Override
	public boolean canExecute() {

		MID mid = (MID) getElementToEdit();
		return super.canExecute() && mid.isTypesLevel();
	}

	protected Operator doExecuteTypesLevel() throws MMINTException, MIDDialogCancellation {

		MID typeMID = (MID) getElementToEdit();
		String workflowMIDUri = MIDDialogUtils.selectWorkflowMIDToCreateOperatorType(typeMID);
		String newOperatorTypeName = MIDDialogUtils.getStringInput(
			"Create new operator type from workflow",
			"Insert new operator type name",
			MIDUtils.getFileNameFromUri(workflowMIDUri));
		Operator newOperator = MIDRegistry.<Operator>getExtendibleElement(MMINT.ROOT_OPERATOR_URI, typeMID)
			.createSubtype(newOperatorTypeName, workflowMIDUri);

		return newOperator;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			Operator newElement;
			switch (((MID) getElementToEdit()).getLevel()) {
				case TYPES:
					newElement = this.doExecuteTypesLevel();
					break;
				case INSTANCES:
					throw new MMINTException("The INSTANCES level is not allowed");
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
			MMINTException.print(IStatus.ERROR, "No operator created", e);
			return CommandResult.newErrorCommandResult("No operator created");
		}
	}

}
