/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.part.MIDDiagramEditor;

/**
 * The command to delete a model container.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelContainerDelCommand extends DestroyElementCommand {

	/** The Mapping diagram root. */
	private MappingReference diagramRoot;

	/**
	 * Constructor: initialises the superclass and the Mapping diagram root.
	 * 
	 * @param request
	 *            The request.
	 * @param root
	 *            The Mapping diagram root, which will no longer contain the
	 *            model container to destroy when this command is executed.
	 */
	public ModelContainerDelCommand(DestroyElementRequest request, MappingReference root) {

		super(request);
		diagramRoot = root;
	}

	/**
	 * Deletes a model container of a mapping reference.
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

		ModelContainer destructee = (ModelContainer) getElementToDestroy();
		ModelReference modelRef = (ModelReference) destructee.getModel();

		// handle standalone binary mapping reference
		if (diagramRoot instanceof BinaryMappingReference) {
			BinaryMappingReference binaryMappingRef = (BinaryMappingReference) diagramRoot;
			if (binaryMappingRef.getModel1() == modelRef) {
				binaryMappingRef.setModel1(null);
			}
			else {
				if (binaryMappingRef.getModel0() == modelRef) {
					binaryMappingRef.setModel0(binaryMappingRef.getModel1());
					binaryMappingRef.setModel1(null);
				}
				else {
					binaryMappingRef.setModel0(null);
				}
			}
		}

		// refresh outline
		MIDDiagramEditor editor = (MIDDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		editor.getOutlinePage().loadOutlineModels();

		return CommandResult.newOKCommandResult();
	}

}
