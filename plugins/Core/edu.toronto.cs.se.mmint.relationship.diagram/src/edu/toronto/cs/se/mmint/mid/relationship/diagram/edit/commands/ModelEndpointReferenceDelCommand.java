/*
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDDiagramEditor;

/**
 * The command to delete a model reference.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelEndpointReferenceDelCommand extends DestroyElementCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ModelEndpointReferenceDelCommand(DestroyElementRequest request) {

		super(request);
	}

	/**
	 * Checks if a model reference can be deleted.
	 * 
	 * @return True if a model reference can be deleted, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		ModelEndpointReference modelEndpointRef = (ModelEndpointReference) getElementToDestroy();
		return super.canExecute() && (
			modelEndpointRef.isInstancesLevel() ||
			(modelEndpointRef.isTypesLevel() && MIDConstraintChecker.isAllowedModelType((ModelRel) getElementToDestroy().eContainer()))
		);
	}

	/**
	 * Deletes a model reference.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		// refresh outline
		MIDDiagramEditor editor = (MIDDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		editor.getOutlinePage().loadOutlineModels();

		return CommandResult.newOKCommandResult();
	}

}
